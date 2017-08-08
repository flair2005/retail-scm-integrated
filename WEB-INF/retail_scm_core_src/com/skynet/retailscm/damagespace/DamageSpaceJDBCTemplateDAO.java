
package com.skynet.retailscm.damagespace;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.goodsshelf.GoodsShelf;

import com.skynet.retailscm.warehouse.WarehouseDAO;
import com.skynet.retailscm.goodsshelf.GoodsShelfDAO;

import com.skynet.retailscm.goodsshelf.GoodsShelfTable;
import com.skynet.retailscm.warehouse.WarehouseTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class DamageSpaceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements DamageSpaceDAO{
 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

		
	
  	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO pGoodsShelfDAO){
 	
 		if(pGoodsShelfDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfDAO to null.");
 		}
	 	this.goodsShelfDAO = pGoodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
 		if(this.goodsShelfDAO == null){
 			throw new IllegalStateException("The goodsShelfDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsShelfDAO;
 	}	
 	
			
		

	
	/*
	protected DamageSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalDamageSpace(accessKey, options);
	}
	*/
	public DamageSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalDamageSpace(DamageSpaceTable.withId(id), options);
	}
	
	
	
	public DamageSpace save(DamageSpace damageSpace,Map<String,Object> options){
		
		String methodName="save(DamageSpace damageSpace,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(damageSpace, methodName, "damageSpace");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalDamageSpace(damageSpace,options);
	}
	public DamageSpace clone(String damageSpaceId, Map<String,Object> options) throws Exception{
	
		return clone(DamageSpaceTable.withId(damageSpaceId),options);
	}
	
	protected DamageSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String damageSpaceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		DamageSpace newDamageSpace = loadInternalDamageSpace(accessKey, options);
		newDamageSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsShelfListEnabled(options)){
 			for(GoodsShelf item: newDamageSpace.getGoodsShelfList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalDamageSpace(newDamageSpace,options);
		
		return newDamageSpace;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String damageSpaceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{damageSpaceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new DamageSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new DamageSpaceNotFoundException(
					"The " + this.getTableName() + "(" + damageSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String damageSpaceId, int version) throws Exception{
	
		String methodName="delete(String damageSpaceId, int version)";
		assertMethodArgumentNotNull(damageSpaceId, methodName, "damageSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{damageSpaceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(damageSpaceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","contact_number","total_area","latitude","longitude","warehouse"};
		return DamageSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "damage_space";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return DamageSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractWarehouseEnabled = true;
 	//private static final String WAREHOUSE = "warehouse";
 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, DamageSpaceTokens.WAREHOUSE);
 	}
 	
 	
 	//private boolean saveWarehouseEnabled = true;
 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, DamageSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	//protected static final String GOODS_SHELF_LIST = "goodsShelfList";
	
	protected boolean isExtractGoodsShelfListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,DamageSpaceTokens.GOODS_SHELF_LIST);
		
 	}

	protected boolean isSaveGoodsShelfListEnabled(Map<String,Object> options){
		return checkOptions(options, DamageSpaceTokens.GOODS_SHELF_LIST);
		
 	}
 	
 	
			
		

	

	protected DamageSpaceMapper getDamageSpaceMapper(){
		return new DamageSpaceMapper();
	}
	protected DamageSpace extractDamageSpace(String damageSpaceId) throws Exception{
		String SQL = "select * from damage_space_data where id = ?";	
		try{
		
			DamageSpace damageSpace = queryForObject(SQL, new Object[]{damageSpaceId}, getDamageSpaceMapper());
			return damageSpace;
		}catch(EmptyResultDataAccessException e){
			throw new DamageSpaceNotFoundException("DamageSpace("+damageSpaceId+") is not found!");
		}
		
		
	}
	protected DamageSpace extractDamageSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from damage_space_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			DamageSpace damageSpace = queryForObject(SQL, new Object[]{accessKey.getValue()}, getDamageSpaceMapper());
			return damageSpace;
		}catch(EmptyResultDataAccessException e){
			throw new DamageSpaceNotFoundException("DamageSpace("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected DamageSpace loadInternalDamageSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		DamageSpace damageSpace = extractDamageSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(damageSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsShelfListEnabled(loadOptions)){
	 		extractGoodsShelfList(damageSpace, loadOptions);
 		}		
		
		return damageSpace;
		
	}



	
	
	 

 	protected DamageSpace extractWarehouse(DamageSpace damageSpace, Map<String,Object> options) throws Exception{

		if(damageSpace.getWarehouse() == null){
			return damageSpace;
		}
		String warehouseId = damageSpace.getWarehouse().getId();
		if( warehouseId == null){
			return damageSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			damageSpace.setWarehouse(warehouse);
		}
		
 		
 		return damageSpace;
 	}
 		
 
		
	protected DamageSpace extractGoodsShelfList(DamageSpace damageSpace, Map<String,Object> options){
		
		SmartList<GoodsShelf> goodsShelfList = getGoodsShelfDAO().findGoodsShelfByDamageSpace(damageSpace.getId(),options);
		if(goodsShelfList != null){
			damageSpace.setGoodsShelfList(goodsShelfList);
		}
		
		return damageSpace;
	
	}	
		
		
  	
 	public SmartList<DamageSpace> findDamageSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ?";
		SmartList<DamageSpace> damageSpaceList = queryForList(SQL, new Object[]{warehouseId}, getDamageSpaceMapper());	
 		return damageSpaceList;
 	}
 	
 	public SmartList<DamageSpace> findDamageSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<DamageSpace> damageSpaceList = queryForList(SQL, new Object[]{warehouseId,start, count}, getDamageSpaceMapper());
		
 		return damageSpaceList;
 	}
 	
 	public int countDamageSpaceByWarehouse(String warehouseId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where warehouse = ?";
		Integer count = queryInt(SQL, new Object[]{warehouseId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected DamageSpace saveDamageSpace(DamageSpace  damageSpace){
	
		String SQL=this.getSaveDamageSpaceSQL(damageSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveDamageSpaceParameters(damageSpace);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		damageSpace.incVersion();
		return damageSpace;
	
	}
	public SmartList<DamageSpace> saveDamageSpaceList(SmartList<DamageSpace> damageSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitDamageSpaceList(damageSpaceList);
		
		batchDamageSpaceCreate((List<DamageSpace>)lists[CREATE_LIST_INDEX]);
		
		batchDamageSpaceUpdate((List<DamageSpace>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(DamageSpace damageSpace:damageSpaceList){
			if(damageSpace.isChanged()){
				damageSpace.incVersion();
			}
			
		
		}
		
		
		return damageSpaceList;
	}

	public SmartList<DamageSpace> removeDamageSpaceList(SmartList<DamageSpace> damageSpaceList,Map<String,Object> options){
		
		
		super.removeList(damageSpaceList, options);
		
		return damageSpaceList;
		
		
	}
	
	protected List<Object[]> prepareDamageSpaceBatchCreateArgs(List<DamageSpace> damageSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(DamageSpace damageSpace:damageSpaceList ){
			Object [] parameters = prepareDamageSpaceCreateParameters(damageSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareDamageSpaceBatchUpdateArgs(List<DamageSpace> damageSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(DamageSpace damageSpace:damageSpaceList ){
			if(!damageSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareDamageSpaceUpdateParameters(damageSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchDamageSpaceCreate(List<DamageSpace> damageSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareDamageSpaceBatchCreateArgs(damageSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchDamageSpaceUpdate(List<DamageSpace> damageSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareDamageSpaceBatchUpdateArgs(damageSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitDamageSpaceList(List<DamageSpace> damageSpaceList){
		
		List<DamageSpace> damageSpaceCreateList=new ArrayList<DamageSpace>();
		List<DamageSpace> damageSpaceUpdateList=new ArrayList<DamageSpace>();
		
		for(DamageSpace damageSpace: damageSpaceList){
			if(isUpdateRequest(damageSpace)){
				damageSpaceUpdateList.add( damageSpace);
				continue;
			}
			damageSpaceCreateList.add(damageSpace);
		}
		
		return new Object[]{damageSpaceCreateList,damageSpaceUpdateList};
	}
	
	protected boolean isUpdateRequest(DamageSpace damageSpace){
 		return damageSpace.getVersion() > 0;
 	}
 	protected String getSaveDamageSpaceSQL(DamageSpace damageSpace){
 		if(isUpdateRequest(damageSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveDamageSpaceParameters(DamageSpace damageSpace){
 		if(isUpdateRequest(damageSpace) ){
 			return prepareDamageSpaceUpdateParameters(damageSpace);
 		}
 		return prepareDamageSpaceCreateParameters(damageSpace);
 	}
 	protected Object[] prepareDamageSpaceUpdateParameters(DamageSpace damageSpace){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = damageSpace.getLocation();
 		parameters[1] = damageSpace.getContactNumber();
 		parameters[2] = damageSpace.getTotalArea();
 		parameters[3] = damageSpace.getLatitude();
 		parameters[4] = damageSpace.getLongitude(); 	
 		if(damageSpace.getWarehouse() != null){
 			parameters[5] = damageSpace.getWarehouse().getId();
 		}
 		
 		parameters[6] = damageSpace.getId();
 		parameters[7] = damageSpace.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareDamageSpaceCreateParameters(DamageSpace damageSpace){
		Object[] parameters = new Object[7];
		String newDamageSpaceId=getNextId();
		damageSpace.setId(newDamageSpaceId);
		parameters[0] =  damageSpace.getId();
 
 		parameters[1] = damageSpace.getLocation();
 		parameters[2] = damageSpace.getContactNumber();
 		parameters[3] = damageSpace.getTotalArea();
 		parameters[4] = damageSpace.getLatitude();
 		parameters[5] = damageSpace.getLongitude(); 	
 		if(damageSpace.getWarehouse() != null){
 			parameters[6] = damageSpace.getWarehouse().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected DamageSpace saveInternalDamageSpace(DamageSpace damageSpace, Map<String,Object> options){
		
		saveDamageSpace(damageSpace);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(damageSpace, options);
 		}
 
		
		if(isSaveGoodsShelfListEnabled(options)){
	 		saveGoodsShelfList(damageSpace, options);
	 		removeGoodsShelfList(damageSpace, options);
	 		
 		}		
		
		return damageSpace;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected DamageSpace saveWarehouse(DamageSpace damageSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(damageSpace.getWarehouse() == null){
 			return damageSpace;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(damageSpace.getWarehouse(),options);
 		return damageSpace;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected DamageSpace saveGoodsShelfList(DamageSpace damageSpace, Map<String,Object> options){
		SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return damageSpace;
		}
		if(goodsShelfList.isEmpty()){
			return damageSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsShelfDAO().saveGoodsShelfList(goodsShelfList,options);
		
		return damageSpace;
	
	}
	
	protected DamageSpace removeGoodsShelfList(DamageSpace damageSpace, Map<String,Object> options){
	
	
		SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return damageSpace;
		}	
	
		SmartList<GoodsShelf> toRemoveGoodsShelfList = goodsShelfList.getToRemoveList();
		
		if(toRemoveGoodsShelfList == null){
			return damageSpace;
		}
		if(toRemoveGoodsShelfList.isEmpty()){
			return damageSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsShelfDAO().removeGoodsShelfList(toRemoveGoodsShelfList,options);
		
		return damageSpace;
	
	}
	
	
	
 	
 	
	
	
	
		

	public DamageSpace present(DamageSpace damageSpace,Map<String, Object> options){
	
		presentGoodsShelfList(damageSpace,options);

		return damageSpace;
	
	}
		
	
  	
 	protected DamageSpace presentGoodsShelfList(
			DamageSpace damageSpace,
			Map<String, Object> options) {

		SmartList<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();		
		if(goodsShelfList == null){
			return damageSpace;			
		}
		
		String targetObjectName = "goodsShelf";
		int goodsShelfListSize = goodsShelfList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsShelfListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return damageSpace;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsShelfListSize;
		if(goodsShelfListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsShelfDAO().countGoodsShelfByDamageSpace(damageSpace.getId(), options);			
		}
		//damageSpace.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//damageSpace.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsShelfListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsShelfListSize,currentPage,rowsPerPage) ;
			goodsShelfList = goodsShelfList.subListOf(fromIndex, toIndex);
			goodsShelfList.setTotalCount(count);
			goodsShelfList.setCurrentPageNumber(currentPage);			
			damageSpace.setGoodsShelfList(goodsShelfList);
			return damageSpace;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsShelfList 
			= getGoodsShelfDAO().findGoodsShelfByDamageSpace(damageSpace.getId(),start, rowsPerPage, options );
		goodsShelfList.setTotalCount(count);
		goodsShelfList.setCurrentPageNumber(currentPage);
		damageSpace.setGoodsShelfList(goodsShelfList );	

		return damageSpace;
	}			
		


	protected String getTableName(){
		return DamageSpaceTable.TABLE_NAME;
	}
}


