
package com.skynet.retailscm.retailstoreorderlineitem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrderDAO;

import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreOrderLineItemJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderLineItemDAO{
 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

		

	
	/*
	protected RetailStoreOrderLineItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderLineItem(accessKey, options);
	}
	*/
	public RetailStoreOrderLineItem load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderLineItem(RetailStoreOrderLineItemTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderLineItem save(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderLineItem, methodName, "retailStoreOrderLineItem");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderLineItem(retailStoreOrderLineItem,options);
	}
	public RetailStoreOrderLineItem clone(String retailStoreOrderLineItemId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderLineItemTable.withId(retailStoreOrderLineItemId),options);
	}
	
	protected RetailStoreOrderLineItem clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderLineItemId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderLineItem newRetailStoreOrderLineItem = loadInternalRetailStoreOrderLineItem(accessKey, options);
		newRetailStoreOrderLineItem.setVersion(0);
		
		

		
		saveInternalRetailStoreOrderLineItem(newRetailStoreOrderLineItem,options);
		
		return newRetailStoreOrderLineItem;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderLineItemId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderLineItemId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderLineItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderLineItemNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderLineItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderLineItemId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderLineItemId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderLineItemId, methodName, "retailStoreOrderLineItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderLineItemId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderLineItemId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"biz_order","sku_id","sku_name","amount","quantity","unit_of_measurement"};
		return RetailStoreOrderLineItemTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_line_item";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderLineItemTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderLineItemTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderLineItemTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected RetailStoreOrderLineItemMapper getRetailStoreOrderLineItemMapper(){
		return new RetailStoreOrderLineItemMapper();
	}
	protected RetailStoreOrderLineItem extractRetailStoreOrderLineItem(String retailStoreOrderLineItemId) throws Exception{
		String SQL = "select * from retail_store_order_line_item_data where id = ?";	
		try{
		
			RetailStoreOrderLineItem retailStoreOrderLineItem = queryForObject(SQL, new Object[]{retailStoreOrderLineItemId}, getRetailStoreOrderLineItemMapper());
			return retailStoreOrderLineItem;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderLineItemNotFoundException("RetailStoreOrderLineItem("+retailStoreOrderLineItemId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderLineItem extractRetailStoreOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_line_item_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderLineItem retailStoreOrderLineItem = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderLineItemMapper());
			return retailStoreOrderLineItem;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderLineItemNotFoundException("RetailStoreOrderLineItem("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderLineItem loadInternalRetailStoreOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderLineItem retailStoreOrderLineItem = extractRetailStoreOrderLineItem(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(retailStoreOrderLineItem, loadOptions);
 		}
 
		
		return retailStoreOrderLineItem;
		
	}



	
	
	 

 	protected RetailStoreOrderLineItem extractBizOrder(RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options) throws Exception{

		if(retailStoreOrderLineItem.getBizOrder() == null){
			return retailStoreOrderLineItem;
		}
		String bizOrderId = retailStoreOrderLineItem.getBizOrder().getId();
		if( bizOrderId == null){
			return retailStoreOrderLineItem;
		}
		RetailStoreOrder bizOrder = getRetailStoreOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			retailStoreOrderLineItem.setBizOrder(bizOrder);
		}
		
 		
 		return retailStoreOrderLineItem;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = queryForList(SQL, new Object[]{retailStoreOrderId}, getRetailStoreOrderLineItemMapper());	
 		return retailStoreOrderLineItemList;
 	}
 	
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = queryForList(SQL, new Object[]{retailStoreOrderId,start, count}, getRetailStoreOrderLineItemMapper());
		
 		return retailStoreOrderLineItemList;
 	}
 	
 	public int countRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreOrderLineItem saveRetailStoreOrderLineItem(RetailStoreOrderLineItem  retailStoreOrderLineItem){
	
		String SQL=this.getSaveRetailStoreOrderLineItemSQL(retailStoreOrderLineItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderLineItemParameters(retailStoreOrderLineItem);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderLineItem.incVersion();
		return retailStoreOrderLineItem;
	
	}
	public SmartList<RetailStoreOrderLineItem> saveRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderLineItemList(retailStoreOrderLineItemList);
		
		batchRetailStoreOrderLineItemCreate((List<RetailStoreOrderLineItem>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderLineItemUpdate((List<RetailStoreOrderLineItem>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			if(retailStoreOrderLineItem.isChanged()){
				retailStoreOrderLineItem.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderLineItemList;
	}

	public SmartList<RetailStoreOrderLineItem> removeRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderLineItemList, options);
		
		return retailStoreOrderLineItemList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderLineItemBatchCreateArgs(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList ){
			Object [] parameters = prepareRetailStoreOrderLineItemCreateParameters(retailStoreOrderLineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderLineItemBatchUpdateArgs(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList ){
			if(!retailStoreOrderLineItem.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderLineItemUpdateParameters(retailStoreOrderLineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderLineItemCreate(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderLineItemBatchCreateArgs(retailStoreOrderLineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderLineItemUpdate(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderLineItemBatchUpdateArgs(retailStoreOrderLineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderLineItemList(List<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		
		List<RetailStoreOrderLineItem> retailStoreOrderLineItemCreateList=new ArrayList<RetailStoreOrderLineItem>();
		List<RetailStoreOrderLineItem> retailStoreOrderLineItemUpdateList=new ArrayList<RetailStoreOrderLineItem>();
		
		for(RetailStoreOrderLineItem retailStoreOrderLineItem: retailStoreOrderLineItemList){
			if(isUpdateRequest(retailStoreOrderLineItem)){
				retailStoreOrderLineItemUpdateList.add( retailStoreOrderLineItem);
				continue;
			}
			retailStoreOrderLineItemCreateList.add(retailStoreOrderLineItem);
		}
		
		return new Object[]{retailStoreOrderLineItemCreateList,retailStoreOrderLineItemUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		return retailStoreOrderLineItem.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderLineItemSQL(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		if(isUpdateRequest(retailStoreOrderLineItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderLineItemParameters(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		if(isUpdateRequest(retailStoreOrderLineItem) ){
 			return prepareRetailStoreOrderLineItemUpdateParameters(retailStoreOrderLineItem);
 		}
 		return prepareRetailStoreOrderLineItemCreateParameters(retailStoreOrderLineItem);
 	}
 	protected Object[] prepareRetailStoreOrderLineItemUpdateParameters(RetailStoreOrderLineItem retailStoreOrderLineItem){
 		Object[] parameters = new Object[8];
  	
 		if(retailStoreOrderLineItem.getBizOrder() != null){
 			parameters[0] = retailStoreOrderLineItem.getBizOrder().getId();
 		}
 
 		parameters[1] = retailStoreOrderLineItem.getSkuId();
 		parameters[2] = retailStoreOrderLineItem.getSkuName();
 		parameters[3] = retailStoreOrderLineItem.getAmount();
 		parameters[4] = retailStoreOrderLineItem.getQuantity();
 		parameters[5] = retailStoreOrderLineItem.getUnitOfMeasurement();		
 		parameters[6] = retailStoreOrderLineItem.getId();
 		parameters[7] = retailStoreOrderLineItem.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderLineItemCreateParameters(RetailStoreOrderLineItem retailStoreOrderLineItem){
		Object[] parameters = new Object[7];
		String newRetailStoreOrderLineItemId=getNextId();
		retailStoreOrderLineItem.setId(newRetailStoreOrderLineItemId);
		parameters[0] =  retailStoreOrderLineItem.getId();
  	
 		if(retailStoreOrderLineItem.getBizOrder() != null){
 			parameters[1] = retailStoreOrderLineItem.getBizOrder().getId();
 		
 		}
 		
 		parameters[2] = retailStoreOrderLineItem.getSkuId();
 		parameters[3] = retailStoreOrderLineItem.getSkuName();
 		parameters[4] = retailStoreOrderLineItem.getAmount();
 		parameters[5] = retailStoreOrderLineItem.getQuantity();
 		parameters[6] = retailStoreOrderLineItem.getUnitOfMeasurement();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderLineItem saveInternalRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options){
		
		saveRetailStoreOrderLineItem(retailStoreOrderLineItem);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(retailStoreOrderLineItem, options);
 		}
 
		
		return retailStoreOrderLineItem;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreOrderLineItem saveBizOrder(RetailStoreOrderLineItem retailStoreOrderLineItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrderLineItem.getBizOrder() == null){
 			return retailStoreOrderLineItem;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDAO().save(retailStoreOrderLineItem.getBizOrder(),options);
 		return retailStoreOrderLineItem;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public RetailStoreOrderLineItem present(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String, Object> options){
	

		return retailStoreOrderLineItem;
	
	}
		


	protected String getTableName(){
		return RetailStoreOrderLineItemTable.TABLE_NAME;
	}
}


