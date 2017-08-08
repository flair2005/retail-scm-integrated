
package com.skynet.retailscm.warehouseasset;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.warehouse.Warehouse;

import com.skynet.retailscm.warehouse.WarehouseDAO;

import com.skynet.retailscm.warehouse.WarehouseTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class WarehouseAssetJDBCTemplateDAO extends CommonJDBCTemplateDAO implements WarehouseAssetDAO{
 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

		

	
	/*
	protected WarehouseAsset load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWarehouseAsset(accessKey, options);
	}
	*/
	public WarehouseAsset load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWarehouseAsset(WarehouseAssetTable.withId(id), options);
	}
	
	
	
	public WarehouseAsset save(WarehouseAsset warehouseAsset,Map<String,Object> options){
		
		String methodName="save(WarehouseAsset warehouseAsset,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(warehouseAsset, methodName, "warehouseAsset");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalWarehouseAsset(warehouseAsset,options);
	}
	public WarehouseAsset clone(String warehouseAssetId, Map<String,Object> options) throws Exception{
	
		return clone(WarehouseAssetTable.withId(warehouseAssetId),options);
	}
	
	protected WarehouseAsset clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String warehouseAssetId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		WarehouseAsset newWarehouseAsset = loadInternalWarehouseAsset(accessKey, options);
		newWarehouseAsset.setVersion(0);
		
		

		
		saveInternalWarehouseAsset(newWarehouseAsset,options);
		
		return newWarehouseAsset;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String warehouseAssetId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{warehouseAssetId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new WarehouseAssetVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WarehouseAssetNotFoundException(
					"The " + this.getTableName() + "(" + warehouseAssetId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String warehouseAssetId, int version) throws Exception{
	
		String methodName="delete(String warehouseAssetId, int version)";
		assertMethodArgumentNotNull(warehouseAssetId, methodName, "warehouseAssetId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{warehouseAssetId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(warehouseAssetId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","position","owner"};
		return WarehouseAssetTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "warehouse_asset";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WarehouseAssetTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WarehouseAssetTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WarehouseAssetTokens.OWNER);
 	}
 	

 	
 
		

	

	protected WarehouseAssetMapper getWarehouseAssetMapper(){
		return new WarehouseAssetMapper();
	}
	protected WarehouseAsset extractWarehouseAsset(String warehouseAssetId) throws Exception{
		String SQL = "select * from warehouse_asset_data where id = ?";	
		try{
		
			WarehouseAsset warehouseAsset = queryForObject(SQL, new Object[]{warehouseAssetId}, getWarehouseAssetMapper());
			return warehouseAsset;
		}catch(EmptyResultDataAccessException e){
			throw new WarehouseAssetNotFoundException("WarehouseAsset("+warehouseAssetId+") is not found!");
		}
		
		
	}
	protected WarehouseAsset extractWarehouseAsset(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from warehouse_asset_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			WarehouseAsset warehouseAsset = queryForObject(SQL, new Object[]{accessKey.getValue()}, getWarehouseAssetMapper());
			return warehouseAsset;
		}catch(EmptyResultDataAccessException e){
			throw new WarehouseAssetNotFoundException("WarehouseAsset("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected WarehouseAsset loadInternalWarehouseAsset(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		WarehouseAsset warehouseAsset = extractWarehouseAsset(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(warehouseAsset, loadOptions);
 		}
 
		
		return warehouseAsset;
		
	}



	
	
	 

 	protected WarehouseAsset extractOwner(WarehouseAsset warehouseAsset, Map<String,Object> options) throws Exception{

		if(warehouseAsset.getOwner() == null){
			return warehouseAsset;
		}
		String ownerId = warehouseAsset.getOwner().getId();
		if( ownerId == null){
			return warehouseAsset;
		}
		Warehouse owner = getWarehouseDAO().load(ownerId,options);
		if(owner != null){
			warehouseAsset.setOwner(owner);
		}
		
 		
 		return warehouseAsset;
 	}
 		
 
		
		
  	
 	public SmartList<WarehouseAsset> findWarehouseAssetByOwner(String warehouseId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<WarehouseAsset> warehouseAssetList = queryForList(SQL, new Object[]{warehouseId}, getWarehouseAssetMapper());	
 		return warehouseAssetList;
 	}
 	
 	public SmartList<WarehouseAsset> findWarehouseAssetByOwner(String warehouseId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<WarehouseAsset> warehouseAssetList = queryForList(SQL, new Object[]{warehouseId,start, count}, getWarehouseAssetMapper());
		
 		return warehouseAssetList;
 	}
 	
 	public int countWarehouseAssetByOwner(String warehouseId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{warehouseId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected WarehouseAsset saveWarehouseAsset(WarehouseAsset  warehouseAsset){
	
		String SQL=this.getSaveWarehouseAssetSQL(warehouseAsset);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWarehouseAssetParameters(warehouseAsset);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		warehouseAsset.incVersion();
		return warehouseAsset;
	
	}
	public SmartList<WarehouseAsset> saveWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWarehouseAssetList(warehouseAssetList);
		
		batchWarehouseAssetCreate((List<WarehouseAsset>)lists[CREATE_LIST_INDEX]);
		
		batchWarehouseAssetUpdate((List<WarehouseAsset>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(WarehouseAsset warehouseAsset:warehouseAssetList){
			if(warehouseAsset.isChanged()){
				warehouseAsset.incVersion();
			}
			
		
		}
		
		
		return warehouseAssetList;
	}

	public SmartList<WarehouseAsset> removeWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList,Map<String,Object> options){
		
		
		super.removeList(warehouseAssetList, options);
		
		return warehouseAssetList;
		
		
	}
	
	protected List<Object[]> prepareWarehouseAssetBatchCreateArgs(List<WarehouseAsset> warehouseAssetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WarehouseAsset warehouseAsset:warehouseAssetList ){
			Object [] parameters = prepareWarehouseAssetCreateParameters(warehouseAsset);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareWarehouseAssetBatchUpdateArgs(List<WarehouseAsset> warehouseAssetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WarehouseAsset warehouseAsset:warehouseAssetList ){
			if(!warehouseAsset.isChanged()){
				continue;
			}
			Object [] parameters = prepareWarehouseAssetUpdateParameters(warehouseAsset);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchWarehouseAssetCreate(List<WarehouseAsset> warehouseAssetList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWarehouseAssetBatchCreateArgs(warehouseAssetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchWarehouseAssetUpdate(List<WarehouseAsset> warehouseAssetList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWarehouseAssetBatchUpdateArgs(warehouseAssetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitWarehouseAssetList(List<WarehouseAsset> warehouseAssetList){
		
		List<WarehouseAsset> warehouseAssetCreateList=new ArrayList<WarehouseAsset>();
		List<WarehouseAsset> warehouseAssetUpdateList=new ArrayList<WarehouseAsset>();
		
		for(WarehouseAsset warehouseAsset: warehouseAssetList){
			if(isUpdateRequest(warehouseAsset)){
				warehouseAssetUpdateList.add( warehouseAsset);
				continue;
			}
			warehouseAssetCreateList.add(warehouseAsset);
		}
		
		return new Object[]{warehouseAssetCreateList,warehouseAssetUpdateList};
	}
	
	protected boolean isUpdateRequest(WarehouseAsset warehouseAsset){
 		return warehouseAsset.getVersion() > 0;
 	}
 	protected String getSaveWarehouseAssetSQL(WarehouseAsset warehouseAsset){
 		if(isUpdateRequest(warehouseAsset)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveWarehouseAssetParameters(WarehouseAsset warehouseAsset){
 		if(isUpdateRequest(warehouseAsset) ){
 			return prepareWarehouseAssetUpdateParameters(warehouseAsset);
 		}
 		return prepareWarehouseAssetCreateParameters(warehouseAsset);
 	}
 	protected Object[] prepareWarehouseAssetUpdateParameters(WarehouseAsset warehouseAsset){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = warehouseAsset.getName();
 		parameters[1] = warehouseAsset.getPosition(); 	
 		if(warehouseAsset.getOwner() != null){
 			parameters[2] = warehouseAsset.getOwner().getId();
 		}
 		
 		parameters[3] = warehouseAsset.getId();
 		parameters[4] = warehouseAsset.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareWarehouseAssetCreateParameters(WarehouseAsset warehouseAsset){
		Object[] parameters = new Object[4];
		String newWarehouseAssetId=getNextId();
		warehouseAsset.setId(newWarehouseAssetId);
		parameters[0] =  warehouseAsset.getId();
 
 		parameters[1] = warehouseAsset.getName();
 		parameters[2] = warehouseAsset.getPosition(); 	
 		if(warehouseAsset.getOwner() != null){
 			parameters[3] = warehouseAsset.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected WarehouseAsset saveInternalWarehouseAsset(WarehouseAsset warehouseAsset, Map<String,Object> options){
		
		saveWarehouseAsset(warehouseAsset);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(warehouseAsset, options);
 		}
 
		
		return warehouseAsset;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected WarehouseAsset saveOwner(WarehouseAsset warehouseAsset, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(warehouseAsset.getOwner() == null){
 			return warehouseAsset;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(warehouseAsset.getOwner(),options);
 		return warehouseAsset;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public WarehouseAsset present(WarehouseAsset warehouseAsset,Map<String, Object> options){
	

		return warehouseAsset;
	
	}
		


	protected String getTableName(){
		return WarehouseAssetTable.TABLE_NAME;
	}
}


