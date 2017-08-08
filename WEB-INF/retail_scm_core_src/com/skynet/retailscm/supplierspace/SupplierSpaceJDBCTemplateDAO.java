
package com.skynet.retailscm.supplierspace;

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

public class SupplierSpaceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplierSpaceDAO{
 
 	
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
	protected SupplierSpace load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplierSpace(accessKey, options);
	}
	*/
	public SupplierSpace load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplierSpace(SupplierSpaceTable.withId(id), options);
	}
	
	
	
	public SupplierSpace save(SupplierSpace supplierSpace,Map<String,Object> options){
		
		String methodName="save(SupplierSpace supplierSpace,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplierSpace, methodName, "supplierSpace");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplierSpace(supplierSpace,options);
	}
	public SupplierSpace clone(String supplierSpaceId, Map<String,Object> options) throws Exception{
	
		return clone(SupplierSpaceTable.withId(supplierSpaceId),options);
	}
	
	protected SupplierSpace clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplierSpaceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplierSpace newSupplierSpace = loadInternalSupplierSpace(accessKey, options);
		newSupplierSpace.setVersion(0);
		
		
 		
 		if(isSaveGoodsShelfListEnabled(options)){
 			for(GoodsShelf item: newSupplierSpace.getGoodsShelfList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplierSpace(newSupplierSpace,options);
		
		return newSupplierSpace;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplierSpaceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplierSpaceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplierSpaceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplierSpaceNotFoundException(
					"The " + this.getTableName() + "(" + supplierSpaceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplierSpaceId, int version) throws Exception{
	
		String methodName="delete(String supplierSpaceId, int version)";
		assertMethodArgumentNotNull(supplierSpaceId, methodName, "supplierSpaceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplierSpaceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplierSpaceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","contact_number","total_area","warehouse","latitude","longitude"};
		return SupplierSpaceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supplier_space";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplierSpaceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractWarehouseEnabled = true;
 	//private static final String WAREHOUSE = "warehouse";
 	protected boolean isExtractWarehouseEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplierSpaceTokens.WAREHOUSE);
 	}
 	
 	
 	//private boolean saveWarehouseEnabled = true;
 	protected boolean isSaveWarehouseEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplierSpaceTokens.WAREHOUSE);
 	}
 	

 	
 
		
	//protected static final String GOODS_SHELF_LIST = "goodsShelfList";
	
	protected boolean isExtractGoodsShelfListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplierSpaceTokens.GOODS_SHELF_LIST);
		
 	}

	protected boolean isSaveGoodsShelfListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplierSpaceTokens.GOODS_SHELF_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplierSpaceMapper getSupplierSpaceMapper(){
		return new SupplierSpaceMapper();
	}
	protected SupplierSpace extractSupplierSpace(String supplierSpaceId) throws Exception{
		String SQL = "select * from supplier_space_data where id = ?";	
		try{
		
			SupplierSpace supplierSpace = queryForObject(SQL, new Object[]{supplierSpaceId}, getSupplierSpaceMapper());
			return supplierSpace;
		}catch(EmptyResultDataAccessException e){
			throw new SupplierSpaceNotFoundException("SupplierSpace("+supplierSpaceId+") is not found!");
		}
		
		
	}
	protected SupplierSpace extractSupplierSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supplier_space_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplierSpace supplierSpace = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplierSpaceMapper());
			return supplierSpace;
		}catch(EmptyResultDataAccessException e){
			throw new SupplierSpaceNotFoundException("SupplierSpace("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplierSpace loadInternalSupplierSpace(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplierSpace supplierSpace = extractSupplierSpace(accessKey, loadOptions);
 	
 		if(isExtractWarehouseEnabled(loadOptions)){
	 		extractWarehouse(supplierSpace, loadOptions);
 		}
 
		
		if(isExtractGoodsShelfListEnabled(loadOptions)){
	 		extractGoodsShelfList(supplierSpace, loadOptions);
 		}		
		
		return supplierSpace;
		
	}



	
	
	 

 	protected SupplierSpace extractWarehouse(SupplierSpace supplierSpace, Map<String,Object> options) throws Exception{

		if(supplierSpace.getWarehouse() == null){
			return supplierSpace;
		}
		String warehouseId = supplierSpace.getWarehouse().getId();
		if( warehouseId == null){
			return supplierSpace;
		}
		Warehouse warehouse = getWarehouseDAO().load(warehouseId,options);
		if(warehouse != null){
			supplierSpace.setWarehouse(warehouse);
		}
		
 		
 		return supplierSpace;
 	}
 		
 
		
	protected SupplierSpace extractGoodsShelfList(SupplierSpace supplierSpace, Map<String,Object> options){
		
		SmartList<GoodsShelf> goodsShelfList = getGoodsShelfDAO().findGoodsShelfBySupplierSpace(supplierSpace.getId(),options);
		if(goodsShelfList != null){
			supplierSpace.setGoodsShelfList(goodsShelfList);
		}
		
		return supplierSpace;
	
	}	
		
		
  	
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ?";
		SmartList<SupplierSpace> supplierSpaceList = queryForList(SQL, new Object[]{warehouseId}, getSupplierSpaceMapper());	
 		return supplierSpaceList;
 	}
 	
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where warehouse = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplierSpace> supplierSpaceList = queryForList(SQL, new Object[]{warehouseId,start, count}, getSupplierSpaceMapper());
		
 		return supplierSpaceList;
 	}
 	
 	public int countSupplierSpaceByWarehouse(String warehouseId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where warehouse = ?";
		Integer count = queryInt(SQL, new Object[]{warehouseId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SupplierSpace saveSupplierSpace(SupplierSpace  supplierSpace){
	
		String SQL=this.getSaveSupplierSpaceSQL(supplierSpace);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplierSpaceParameters(supplierSpace);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplierSpace.incVersion();
		return supplierSpace;
	
	}
	public SmartList<SupplierSpace> saveSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplierSpaceList(supplierSpaceList);
		
		batchSupplierSpaceCreate((List<SupplierSpace>)lists[CREATE_LIST_INDEX]);
		
		batchSupplierSpaceUpdate((List<SupplierSpace>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplierSpace supplierSpace:supplierSpaceList){
			if(supplierSpace.isChanged()){
				supplierSpace.incVersion();
			}
			
		
		}
		
		
		return supplierSpaceList;
	}

	public SmartList<SupplierSpace> removeSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options){
		
		
		super.removeList(supplierSpaceList, options);
		
		return supplierSpaceList;
		
		
	}
	
	protected List<Object[]> prepareSupplierSpaceBatchCreateArgs(List<SupplierSpace> supplierSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierSpace supplierSpace:supplierSpaceList ){
			Object [] parameters = prepareSupplierSpaceCreateParameters(supplierSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplierSpaceBatchUpdateArgs(List<SupplierSpace> supplierSpaceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplierSpace supplierSpace:supplierSpaceList ){
			if(!supplierSpace.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplierSpaceUpdateParameters(supplierSpace);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplierSpaceCreate(List<SupplierSpace> supplierSpaceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplierSpaceBatchCreateArgs(supplierSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplierSpaceUpdate(List<SupplierSpace> supplierSpaceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplierSpaceBatchUpdateArgs(supplierSpaceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplierSpaceList(List<SupplierSpace> supplierSpaceList){
		
		List<SupplierSpace> supplierSpaceCreateList=new ArrayList<SupplierSpace>();
		List<SupplierSpace> supplierSpaceUpdateList=new ArrayList<SupplierSpace>();
		
		for(SupplierSpace supplierSpace: supplierSpaceList){
			if(isUpdateRequest(supplierSpace)){
				supplierSpaceUpdateList.add( supplierSpace);
				continue;
			}
			supplierSpaceCreateList.add(supplierSpace);
		}
		
		return new Object[]{supplierSpaceCreateList,supplierSpaceUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplierSpace supplierSpace){
 		return supplierSpace.getVersion() > 0;
 	}
 	protected String getSaveSupplierSpaceSQL(SupplierSpace supplierSpace){
 		if(isUpdateRequest(supplierSpace)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplierSpaceParameters(SupplierSpace supplierSpace){
 		if(isUpdateRequest(supplierSpace) ){
 			return prepareSupplierSpaceUpdateParameters(supplierSpace);
 		}
 		return prepareSupplierSpaceCreateParameters(supplierSpace);
 	}
 	protected Object[] prepareSupplierSpaceUpdateParameters(SupplierSpace supplierSpace){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = supplierSpace.getLocation();
 		parameters[1] = supplierSpace.getContactNumber();
 		parameters[2] = supplierSpace.getTotalArea(); 	
 		if(supplierSpace.getWarehouse() != null){
 			parameters[3] = supplierSpace.getWarehouse().getId();
 		}
 
 		parameters[4] = supplierSpace.getLatitude();
 		parameters[5] = supplierSpace.getLongitude();		
 		parameters[6] = supplierSpace.getId();
 		parameters[7] = supplierSpace.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplierSpaceCreateParameters(SupplierSpace supplierSpace){
		Object[] parameters = new Object[7];
		String newSupplierSpaceId=getNextId();
		supplierSpace.setId(newSupplierSpaceId);
		parameters[0] =  supplierSpace.getId();
 
 		parameters[1] = supplierSpace.getLocation();
 		parameters[2] = supplierSpace.getContactNumber();
 		parameters[3] = supplierSpace.getTotalArea(); 	
 		if(supplierSpace.getWarehouse() != null){
 			parameters[4] = supplierSpace.getWarehouse().getId();
 		
 		}
 		
 		parameters[5] = supplierSpace.getLatitude();
 		parameters[6] = supplierSpace.getLongitude();		
 				
 		return parameters;
 	}
 	
	protected SupplierSpace saveInternalSupplierSpace(SupplierSpace supplierSpace, Map<String,Object> options){
		
		saveSupplierSpace(supplierSpace);
 	
 		if(isSaveWarehouseEnabled(options)){
	 		saveWarehouse(supplierSpace, options);
 		}
 
		
		if(isSaveGoodsShelfListEnabled(options)){
	 		saveGoodsShelfList(supplierSpace, options);
	 		removeGoodsShelfList(supplierSpace, options);
	 		
 		}		
		
		return supplierSpace;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplierSpace saveWarehouse(SupplierSpace supplierSpace, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplierSpace.getWarehouse() == null){
 			return supplierSpace;//do nothing when it is null
 		}
 		
 		getWarehouseDAO().save(supplierSpace.getWarehouse(),options);
 		return supplierSpace;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected SupplierSpace saveGoodsShelfList(SupplierSpace supplierSpace, Map<String,Object> options){
		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return supplierSpace;
		}
		if(goodsShelfList.isEmpty()){
			return supplierSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsShelfDAO().saveGoodsShelfList(goodsShelfList,options);
		
		return supplierSpace;
	
	}
	
	protected SupplierSpace removeGoodsShelfList(SupplierSpace supplierSpace, Map<String,Object> options){
	
	
		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();
		if(goodsShelfList == null){
			return supplierSpace;
		}	
	
		SmartList<GoodsShelf> toRemoveGoodsShelfList = goodsShelfList.getToRemoveList();
		
		if(toRemoveGoodsShelfList == null){
			return supplierSpace;
		}
		if(toRemoveGoodsShelfList.isEmpty()){
			return supplierSpace;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsShelfDAO().removeGoodsShelfList(toRemoveGoodsShelfList,options);
		
		return supplierSpace;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplierSpace present(SupplierSpace supplierSpace,Map<String, Object> options){
	
		presentGoodsShelfList(supplierSpace,options);

		return supplierSpace;
	
	}
		
	
  	
 	protected SupplierSpace presentGoodsShelfList(
			SupplierSpace supplierSpace,
			Map<String, Object> options) {

		SmartList<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();		
		if(goodsShelfList == null){
			return supplierSpace;			
		}
		
		String targetObjectName = "goodsShelf";
		int goodsShelfListSize = goodsShelfList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsShelfListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplierSpace;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsShelfListSize;
		if(goodsShelfListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsShelfDAO().countGoodsShelfBySupplierSpace(supplierSpace.getId(), options);			
		}
		//supplierSpace.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplierSpace.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsShelfListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsShelfListSize,currentPage,rowsPerPage) ;
			goodsShelfList = goodsShelfList.subListOf(fromIndex, toIndex);
			goodsShelfList.setTotalCount(count);
			goodsShelfList.setCurrentPageNumber(currentPage);			
			supplierSpace.setGoodsShelfList(goodsShelfList);
			return supplierSpace;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsShelfList 
			= getGoodsShelfDAO().findGoodsShelfBySupplierSpace(supplierSpace.getId(),start, rowsPerPage, options );
		goodsShelfList.setTotalCount(count);
		goodsShelfList.setCurrentPageNumber(currentPage);
		supplierSpace.setGoodsShelfList(goodsShelfList );	

		return supplierSpace;
	}			
		


	protected String getTableName(){
		return SupplierSpaceTable.TABLE_NAME;
	}
}


