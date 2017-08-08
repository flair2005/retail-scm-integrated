
package com.skynet.retailscm.goodsshelf;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.skynet.retailscm.supplierspace.SupplierSpace;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;

import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;
import com.skynet.retailscm.goodsallocation.GoodsAllocationDAO;
import com.skynet.retailscm.supplierspace.SupplierSpaceDAO;
import com.skynet.retailscm.storagespace.StorageSpaceDAO;
import com.skynet.retailscm.damagespace.DamageSpaceDAO;

import com.skynet.retailscm.damagespace.DamageSpaceTable;
import com.skynet.retailscm.goodsallocation.GoodsAllocationTable;
import com.skynet.retailscm.storagespace.StorageSpaceTable;
import com.skynet.retailscm.supplierspace.SupplierSpaceTable;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCountTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsShelfJDBCTemplateDAO extends CommonJDBCTemplateDAO implements GoodsShelfDAO{
 
 	
 	private  DamageSpaceDAO  damageSpaceDAO;
 	public void setDamageSpaceDAO(DamageSpaceDAO damageSpaceDAO){
	 	this.damageSpaceDAO = damageSpaceDAO;
 	}
 	public DamageSpaceDAO getDamageSpaceDAO(){
	 	return this.damageSpaceDAO;
 	}
 
 	
 	private  StorageSpaceDAO  storageSpaceDAO;
 	public void setStorageSpaceDAO(StorageSpaceDAO storageSpaceDAO){
	 	this.storageSpaceDAO = storageSpaceDAO;
 	}
 	public StorageSpaceDAO getStorageSpaceDAO(){
	 	return this.storageSpaceDAO;
 	}
 
 	
 	private  SupplierSpaceDAO  supplierSpaceDAO;
 	public void setSupplierSpaceDAO(SupplierSpaceDAO supplierSpaceDAO){
	 	this.supplierSpaceDAO = supplierSpaceDAO;
 	}
 	public SupplierSpaceDAO getSupplierSpaceDAO(){
	 	return this.supplierSpaceDAO;
 	}

		
	
  	private  GoodsShelfStockCountDAO  goodsShelfStockCountDAO;
 	public void setGoodsShelfStockCountDAO(GoodsShelfStockCountDAO pGoodsShelfStockCountDAO){
 	
 		if(pGoodsShelfStockCountDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfStockCountDAO to null.");
 		}
	 	this.goodsShelfStockCountDAO = pGoodsShelfStockCountDAO;
 	}
 	public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO(){
 		if(this.goodsShelfStockCountDAO == null){
 			throw new IllegalStateException("The goodsShelfStockCountDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsShelfStockCountDAO;
 	}	
 	
			
		
	
  	private  GoodsAllocationDAO  goodsAllocationDAO;
 	public void setGoodsAllocationDAO(GoodsAllocationDAO pGoodsAllocationDAO){
 	
 		if(pGoodsAllocationDAO == null){
 			throw new IllegalStateException("Do not try to set goodsAllocationDAO to null.");
 		}
	 	this.goodsAllocationDAO = pGoodsAllocationDAO;
 	}
 	public GoodsAllocationDAO getGoodsAllocationDAO(){
 		if(this.goodsAllocationDAO == null){
 			throw new IllegalStateException("The goodsAllocationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsAllocationDAO;
 	}	
 	
			
		

	
	/*
	protected GoodsShelf load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsShelf(accessKey, options);
	}
	*/
	public GoodsShelf load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsShelf(GoodsShelfTable.withId(id), options);
	}
	
	
	
	public GoodsShelf save(GoodsShelf goodsShelf,Map<String,Object> options){
		
		String methodName="save(GoodsShelf goodsShelf,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goodsShelf, methodName, "goodsShelf");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoodsShelf(goodsShelf,options);
	}
	public GoodsShelf clone(String goodsShelfId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsShelfTable.withId(goodsShelfId),options);
	}
	
	protected GoodsShelf clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsShelfId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GoodsShelf newGoodsShelf = loadInternalGoodsShelf(accessKey, options);
		newGoodsShelf.setVersion(0);
		
		
 		
 		if(isSaveGoodsShelfStockCountListEnabled(options)){
 			for(GoodsShelfStockCount item: newGoodsShelf.getGoodsShelfStockCountList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveGoodsAllocationListEnabled(options)){
 			for(GoodsAllocation item: newGoodsShelf.getGoodsAllocationList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGoodsShelf(newGoodsShelf,options);
		
		return newGoodsShelf;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String goodsShelfId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{goodsShelfId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new GoodsShelfVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsShelfNotFoundException(
					"The " + this.getTableName() + "(" + goodsShelfId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String goodsShelfId, int version) throws Exception{
	
		String methodName="delete(String goodsShelfId, int version)";
		assertMethodArgumentNotNull(goodsShelfId, methodName, "goodsShelfId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsShelfId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsShelfId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","storage_space","supplier_space","damage_space"};
		return GoodsShelfTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods_shelf";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsShelfTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractStorageSpaceEnabled = true;
 	//private static final String STORAGESPACE = "storageSpace";
 	protected boolean isExtractStorageSpaceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsShelfTokens.STORAGESPACE);
 	}
 	
 	
 	//private boolean saveStorageSpaceEnabled = true;
 	protected boolean isSaveStorageSpaceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsShelfTokens.STORAGESPACE);
 	}
 	

 	
  
 	//private boolean extractSupplierSpaceEnabled = true;
 	//private static final String SUPPLIERSPACE = "supplierSpace";
 	protected boolean isExtractSupplierSpaceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsShelfTokens.SUPPLIERSPACE);
 	}
 	
 	
 	//private boolean saveSupplierSpaceEnabled = true;
 	protected boolean isSaveSupplierSpaceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsShelfTokens.SUPPLIERSPACE);
 	}
 	

 	
  
 	//private boolean extractDamageSpaceEnabled = true;
 	//private static final String DAMAGESPACE = "damageSpace";
 	protected boolean isExtractDamageSpaceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsShelfTokens.DAMAGESPACE);
 	}
 	
 	
 	//private boolean saveDamageSpaceEnabled = true;
 	protected boolean isSaveDamageSpaceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsShelfTokens.DAMAGESPACE);
 	}
 	

 	
 
		
	//protected static final String GOODS_SHELF_STOCK_COUNT_LIST = "goodsShelfStockCountList";
	
	protected boolean isExtractGoodsShelfStockCountListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsShelfTokens.GOODS_SHELF_STOCK_COUNT_LIST);
		
 	}

	protected boolean isSaveGoodsShelfStockCountListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsShelfTokens.GOODS_SHELF_STOCK_COUNT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String GOODS_ALLOCATION_LIST = "goodsAllocationList";
	
	protected boolean isExtractGoodsAllocationListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsShelfTokens.GOODS_ALLOCATION_LIST);
		
 	}

	protected boolean isSaveGoodsAllocationListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsShelfTokens.GOODS_ALLOCATION_LIST);
		
 	}
 	
 	
			
		

	

	protected GoodsShelfMapper getGoodsShelfMapper(){
		return new GoodsShelfMapper();
	}
	protected GoodsShelf extractGoodsShelf(String goodsShelfId) throws Exception{
		String SQL = "select * from goods_shelf_data where id = ?";	
		try{
		
			GoodsShelf goodsShelf = queryForObject(SQL, new Object[]{goodsShelfId}, getGoodsShelfMapper());
			return goodsShelf;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsShelfNotFoundException("GoodsShelf("+goodsShelfId+") is not found!");
		}
		
		
	}
	protected GoodsShelf extractGoodsShelf(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from goods_shelf_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			GoodsShelf goodsShelf = queryForObject(SQL, new Object[]{accessKey.getValue()}, getGoodsShelfMapper());
			return goodsShelf;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsShelfNotFoundException("GoodsShelf("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected GoodsShelf loadInternalGoodsShelf(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsShelf goodsShelf = extractGoodsShelf(accessKey, loadOptions);
 	
 		if(isExtractStorageSpaceEnabled(loadOptions)){
	 		extractStorageSpace(goodsShelf, loadOptions);
 		}
  	
 		if(isExtractSupplierSpaceEnabled(loadOptions)){
	 		extractSupplierSpace(goodsShelf, loadOptions);
 		}
  	
 		if(isExtractDamageSpaceEnabled(loadOptions)){
	 		extractDamageSpace(goodsShelf, loadOptions);
 		}
 
		
		if(isExtractGoodsShelfStockCountListEnabled(loadOptions)){
	 		extractGoodsShelfStockCountList(goodsShelf, loadOptions);
 		}		
		
		if(isExtractGoodsAllocationListEnabled(loadOptions)){
	 		extractGoodsAllocationList(goodsShelf, loadOptions);
 		}		
		
		return goodsShelf;
		
	}



	
	
	 

 	protected GoodsShelf extractStorageSpace(GoodsShelf goodsShelf, Map<String,Object> options) throws Exception{

		if(goodsShelf.getStorageSpace() == null){
			return goodsShelf;
		}
		String storageSpaceId = goodsShelf.getStorageSpace().getId();
		if( storageSpaceId == null){
			return goodsShelf;
		}
		StorageSpace storageSpace = getStorageSpaceDAO().load(storageSpaceId,options);
		if(storageSpace != null){
			goodsShelf.setStorageSpace(storageSpace);
		}
		
 		
 		return goodsShelf;
 	}
 		
  

 	protected GoodsShelf extractSupplierSpace(GoodsShelf goodsShelf, Map<String,Object> options) throws Exception{

		if(goodsShelf.getSupplierSpace() == null){
			return goodsShelf;
		}
		String supplierSpaceId = goodsShelf.getSupplierSpace().getId();
		if( supplierSpaceId == null){
			return goodsShelf;
		}
		SupplierSpace supplierSpace = getSupplierSpaceDAO().load(supplierSpaceId,options);
		if(supplierSpace != null){
			goodsShelf.setSupplierSpace(supplierSpace);
		}
		
 		
 		return goodsShelf;
 	}
 		
  

 	protected GoodsShelf extractDamageSpace(GoodsShelf goodsShelf, Map<String,Object> options) throws Exception{

		if(goodsShelf.getDamageSpace() == null){
			return goodsShelf;
		}
		String damageSpaceId = goodsShelf.getDamageSpace().getId();
		if( damageSpaceId == null){
			return goodsShelf;
		}
		DamageSpace damageSpace = getDamageSpaceDAO().load(damageSpaceId,options);
		if(damageSpace != null){
			goodsShelf.setDamageSpace(damageSpace);
		}
		
 		
 		return goodsShelf;
 	}
 		
 
		
	protected GoodsShelf extractGoodsShelfStockCountList(GoodsShelf goodsShelf, Map<String,Object> options){
		
		SmartList<GoodsShelfStockCount> goodsShelfStockCountList = getGoodsShelfStockCountDAO().findGoodsShelfStockCountByShelf(goodsShelf.getId(),options);
		if(goodsShelfStockCountList != null){
			goodsShelf.setGoodsShelfStockCountList(goodsShelfStockCountList);
		}
		
		return goodsShelf;
	
	}	
		
	protected GoodsShelf extractGoodsAllocationList(GoodsShelf goodsShelf, Map<String,Object> options){
		
		SmartList<GoodsAllocation> goodsAllocationList = getGoodsAllocationDAO().findGoodsAllocationByGoodsShelf(goodsShelf.getId(),options);
		if(goodsAllocationList != null){
			goodsShelf.setGoodsAllocationList(goodsAllocationList);
		}
		
		return goodsShelf;
	
	}	
		
		
  	
 	public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(String storageSpaceId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where storage_space = ?";
		SmartList<GoodsShelf> goodsShelfList = queryForList(SQL, new Object[]{storageSpaceId}, getGoodsShelfMapper());	
 		return goodsShelfList;
 	}
 	
 	public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(String storageSpaceId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where storage_space = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<GoodsShelf> goodsShelfList = queryForList(SQL, new Object[]{storageSpaceId,start, count}, getGoodsShelfMapper());
		
 		return goodsShelfList;
 	}
 	
 	public int countGoodsShelfByStorageSpace(String storageSpaceId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where storage_space = ?";
		Integer count = queryInt(SQL, new Object[]{storageSpaceId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(String supplierSpaceId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where supplier_space = ?";
		SmartList<GoodsShelf> goodsShelfList = queryForList(SQL, new Object[]{supplierSpaceId}, getGoodsShelfMapper());	
 		return goodsShelfList;
 	}
 	
 	public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(String supplierSpaceId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where supplier_space = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<GoodsShelf> goodsShelfList = queryForList(SQL, new Object[]{supplierSpaceId,start, count}, getGoodsShelfMapper());
		
 		return goodsShelfList;
 	}
 	
 	public int countGoodsShelfBySupplierSpace(String supplierSpaceId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where supplier_space = ?";
		Integer count = queryInt(SQL, new Object[]{supplierSpaceId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(String damageSpaceId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where damage_space = ?";
		SmartList<GoodsShelf> goodsShelfList = queryForList(SQL, new Object[]{damageSpaceId}, getGoodsShelfMapper());	
 		return goodsShelfList;
 	}
 	
 	public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(String damageSpaceId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where damage_space = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<GoodsShelf> goodsShelfList = queryForList(SQL, new Object[]{damageSpaceId,start, count}, getGoodsShelfMapper());
		
 		return goodsShelfList;
 	}
 	
 	public int countGoodsShelfByDamageSpace(String damageSpaceId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where damage_space = ?";
		Integer count = queryInt(SQL, new Object[]{damageSpaceId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected GoodsShelf saveGoodsShelf(GoodsShelf  goodsShelf){
	
		String SQL=this.getSaveGoodsShelfSQL(goodsShelf);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsShelfParameters(goodsShelf);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goodsShelf.incVersion();
		return goodsShelf;
	
	}
	public SmartList<GoodsShelf> saveGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsShelfList(goodsShelfList);
		
		batchGoodsShelfCreate((List<GoodsShelf>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsShelfUpdate((List<GoodsShelf>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GoodsShelf goodsShelf:goodsShelfList){
			if(goodsShelf.isChanged()){
				goodsShelf.incVersion();
			}
			
		
		}
		
		
		return goodsShelfList;
	}

	public SmartList<GoodsShelf> removeGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options){
		
		
		super.removeList(goodsShelfList, options);
		
		return goodsShelfList;
		
		
	}
	
	protected List<Object[]> prepareGoodsShelfBatchCreateArgs(List<GoodsShelf> goodsShelfList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsShelf goodsShelf:goodsShelfList ){
			Object [] parameters = prepareGoodsShelfCreateParameters(goodsShelf);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsShelfBatchUpdateArgs(List<GoodsShelf> goodsShelfList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsShelf goodsShelf:goodsShelfList ){
			if(!goodsShelf.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsShelfUpdateParameters(goodsShelf);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsShelfCreate(List<GoodsShelf> goodsShelfList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsShelfBatchCreateArgs(goodsShelfList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsShelfUpdate(List<GoodsShelf> goodsShelfList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsShelfBatchUpdateArgs(goodsShelfList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsShelfList(List<GoodsShelf> goodsShelfList){
		
		List<GoodsShelf> goodsShelfCreateList=new ArrayList<GoodsShelf>();
		List<GoodsShelf> goodsShelfUpdateList=new ArrayList<GoodsShelf>();
		
		for(GoodsShelf goodsShelf: goodsShelfList){
			if(isUpdateRequest(goodsShelf)){
				goodsShelfUpdateList.add( goodsShelf);
				continue;
			}
			goodsShelfCreateList.add(goodsShelf);
		}
		
		return new Object[]{goodsShelfCreateList,goodsShelfUpdateList};
	}
	
	protected boolean isUpdateRequest(GoodsShelf goodsShelf){
 		return goodsShelf.getVersion() > 0;
 	}
 	protected String getSaveGoodsShelfSQL(GoodsShelf goodsShelf){
 		if(isUpdateRequest(goodsShelf)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsShelfParameters(GoodsShelf goodsShelf){
 		if(isUpdateRequest(goodsShelf) ){
 			return prepareGoodsShelfUpdateParameters(goodsShelf);
 		}
 		return prepareGoodsShelfCreateParameters(goodsShelf);
 	}
 	protected Object[] prepareGoodsShelfUpdateParameters(GoodsShelf goodsShelf){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = goodsShelf.getLocation(); 	
 		if(goodsShelf.getStorageSpace() != null){
 			parameters[1] = goodsShelf.getStorageSpace().getId();
 		}
  	
 		if(goodsShelf.getSupplierSpace() != null){
 			parameters[2] = goodsShelf.getSupplierSpace().getId();
 		}
  	
 		if(goodsShelf.getDamageSpace() != null){
 			parameters[3] = goodsShelf.getDamageSpace().getId();
 		}
 		
 		parameters[4] = goodsShelf.getId();
 		parameters[5] = goodsShelf.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsShelfCreateParameters(GoodsShelf goodsShelf){
		Object[] parameters = new Object[5];
		String newGoodsShelfId=getNextId();
		goodsShelf.setId(newGoodsShelfId);
		parameters[0] =  goodsShelf.getId();
 
 		parameters[1] = goodsShelf.getLocation(); 	
 		if(goodsShelf.getStorageSpace() != null){
 			parameters[2] = goodsShelf.getStorageSpace().getId();
 		
 		}
 		 	
 		if(goodsShelf.getSupplierSpace() != null){
 			parameters[3] = goodsShelf.getSupplierSpace().getId();
 		
 		}
 		 	
 		if(goodsShelf.getDamageSpace() != null){
 			parameters[4] = goodsShelf.getDamageSpace().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected GoodsShelf saveInternalGoodsShelf(GoodsShelf goodsShelf, Map<String,Object> options){
		
		saveGoodsShelf(goodsShelf);
 	
 		if(isSaveStorageSpaceEnabled(options)){
	 		saveStorageSpace(goodsShelf, options);
 		}
  	
 		if(isSaveSupplierSpaceEnabled(options)){
	 		saveSupplierSpace(goodsShelf, options);
 		}
  	
 		if(isSaveDamageSpaceEnabled(options)){
	 		saveDamageSpace(goodsShelf, options);
 		}
 
		
		if(isSaveGoodsShelfStockCountListEnabled(options)){
	 		saveGoodsShelfStockCountList(goodsShelf, options);
	 		removeGoodsShelfStockCountList(goodsShelf, options);
	 		
 		}		
		
		if(isSaveGoodsAllocationListEnabled(options)){
	 		saveGoodsAllocationList(goodsShelf, options);
	 		removeGoodsAllocationList(goodsShelf, options);
	 		
 		}		
		
		return goodsShelf;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected GoodsShelf saveStorageSpace(GoodsShelf goodsShelf, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsShelf.getStorageSpace() == null){
 			return goodsShelf;//do nothing when it is null
 		}
 		
 		getStorageSpaceDAO().save(goodsShelf.getStorageSpace(),options);
 		return goodsShelf;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected GoodsShelf saveSupplierSpace(GoodsShelf goodsShelf, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsShelf.getSupplierSpace() == null){
 			return goodsShelf;//do nothing when it is null
 		}
 		
 		getSupplierSpaceDAO().save(goodsShelf.getSupplierSpace(),options);
 		return goodsShelf;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected GoodsShelf saveDamageSpace(GoodsShelf goodsShelf, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsShelf.getDamageSpace() == null){
 			return goodsShelf;//do nothing when it is null
 		}
 		
 		getDamageSpaceDAO().save(goodsShelf.getDamageSpace(),options);
 		return goodsShelf;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected GoodsShelf saveGoodsShelfStockCountList(GoodsShelf goodsShelf, Map<String,Object> options){
		SmartList<GoodsShelfStockCount> goodsShelfStockCountList = goodsShelf.getGoodsShelfStockCountList();
		if(goodsShelfStockCountList == null){
			return goodsShelf;
		}
		if(goodsShelfStockCountList.isEmpty()){
			return goodsShelf;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsShelfStockCountDAO().saveGoodsShelfStockCountList(goodsShelfStockCountList,options);
		
		return goodsShelf;
	
	}
	
	protected GoodsShelf removeGoodsShelfStockCountList(GoodsShelf goodsShelf, Map<String,Object> options){
	
	
		SmartList<GoodsShelfStockCount> goodsShelfStockCountList = goodsShelf.getGoodsShelfStockCountList();
		if(goodsShelfStockCountList == null){
			return goodsShelf;
		}	
	
		SmartList<GoodsShelfStockCount> toRemoveGoodsShelfStockCountList = goodsShelfStockCountList.getToRemoveList();
		
		if(toRemoveGoodsShelfStockCountList == null){
			return goodsShelf;
		}
		if(toRemoveGoodsShelfStockCountList.isEmpty()){
			return goodsShelf;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsShelfStockCountDAO().removeGoodsShelfStockCountList(toRemoveGoodsShelfStockCountList,options);
		
		return goodsShelf;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected GoodsShelf saveGoodsAllocationList(GoodsShelf goodsShelf, Map<String,Object> options){
		SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
		if(goodsAllocationList == null){
			return goodsShelf;
		}
		if(goodsAllocationList.isEmpty()){
			return goodsShelf;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsAllocationDAO().saveGoodsAllocationList(goodsAllocationList,options);
		
		return goodsShelf;
	
	}
	
	protected GoodsShelf removeGoodsAllocationList(GoodsShelf goodsShelf, Map<String,Object> options){
	
	
		SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
		if(goodsAllocationList == null){
			return goodsShelf;
		}	
	
		SmartList<GoodsAllocation> toRemoveGoodsAllocationList = goodsAllocationList.getToRemoveList();
		
		if(toRemoveGoodsAllocationList == null){
			return goodsShelf;
		}
		if(toRemoveGoodsAllocationList.isEmpty()){
			return goodsShelf;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsAllocationDAO().removeGoodsAllocationList(toRemoveGoodsAllocationList,options);
		
		return goodsShelf;
	
	}
	
	
	
 	
 	
	
	
	
		

	public GoodsShelf present(GoodsShelf goodsShelf,Map<String, Object> options){
	
		presentGoodsShelfStockCountList(goodsShelf,options);
		presentGoodsAllocationList(goodsShelf,options);

		return goodsShelf;
	
	}
		
	
  	
 	protected GoodsShelf presentGoodsShelfStockCountList(
			GoodsShelf goodsShelf,
			Map<String, Object> options) {

		SmartList<GoodsShelfStockCount> goodsShelfStockCountList = goodsShelf.getGoodsShelfStockCountList();		
		if(goodsShelfStockCountList == null){
			return goodsShelf;			
		}
		
		String targetObjectName = "goodsShelfStockCount";
		int goodsShelfStockCountListSize = goodsShelfStockCountList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsShelfStockCountListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsShelf;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsShelfStockCountListSize;
		if(goodsShelfStockCountListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsShelfStockCountDAO().countGoodsShelfStockCountByShelf(goodsShelf.getId(), options);			
		}
		//goodsShelf.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsShelf.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsShelfStockCountListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsShelfStockCountListSize,currentPage,rowsPerPage) ;
			goodsShelfStockCountList = goodsShelfStockCountList.subListOf(fromIndex, toIndex);
			goodsShelfStockCountList.setTotalCount(count);
			goodsShelfStockCountList.setCurrentPageNumber(currentPage);			
			goodsShelf.setGoodsShelfStockCountList(goodsShelfStockCountList);
			return goodsShelf;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsShelfStockCountList 
			= getGoodsShelfStockCountDAO().findGoodsShelfStockCountByShelf(goodsShelf.getId(),start, rowsPerPage, options );
		goodsShelfStockCountList.setTotalCount(count);
		goodsShelfStockCountList.setCurrentPageNumber(currentPage);
		goodsShelf.setGoodsShelfStockCountList(goodsShelfStockCountList );	

		return goodsShelf;
	}			
		
	
  	
 	protected GoodsShelf presentGoodsAllocationList(
			GoodsShelf goodsShelf,
			Map<String, Object> options) {

		SmartList<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();		
		if(goodsAllocationList == null){
			return goodsShelf;			
		}
		
		String targetObjectName = "goodsAllocation";
		int goodsAllocationListSize = goodsAllocationList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsAllocationListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsShelf;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsAllocationListSize;
		if(goodsAllocationListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsAllocationDAO().countGoodsAllocationByGoodsShelf(goodsShelf.getId(), options);			
		}
		//goodsShelf.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsShelf.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsAllocationListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsAllocationListSize,currentPage,rowsPerPage) ;
			goodsAllocationList = goodsAllocationList.subListOf(fromIndex, toIndex);
			goodsAllocationList.setTotalCount(count);
			goodsAllocationList.setCurrentPageNumber(currentPage);			
			goodsShelf.setGoodsAllocationList(goodsAllocationList);
			return goodsShelf;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsAllocationList 
			= getGoodsAllocationDAO().findGoodsAllocationByGoodsShelf(goodsShelf.getId(),start, rowsPerPage, options );
		goodsAllocationList.setTotalCount(count);
		goodsAllocationList.setCurrentPageNumber(currentPage);
		goodsShelf.setGoodsAllocationList(goodsAllocationList );	

		return goodsShelf;
	}			
		


	protected String getTableName(){
		return GoodsShelfTable.TABLE_NAME;
	}
}


