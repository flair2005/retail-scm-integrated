
package com.skynet.retailscm.supplyorderlineitem;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.supplyorder.SupplyOrder;

import com.skynet.retailscm.supplyorder.SupplyOrderDAO;

import com.skynet.retailscm.supplyorder.SupplyOrderTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderLineItemJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderLineItemDAO{
 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}

		

	
	/*
	protected SupplyOrderLineItem load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderLineItem(accessKey, options);
	}
	*/
	public SupplyOrderLineItem load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderLineItem(SupplyOrderLineItemTable.withId(id), options);
	}
	
	
	
	public SupplyOrderLineItem save(SupplyOrderLineItem supplyOrderLineItem,Map<String,Object> options){
		
		String methodName="save(SupplyOrderLineItem supplyOrderLineItem,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderLineItem, methodName, "supplyOrderLineItem");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderLineItem(supplyOrderLineItem,options);
	}
	public SupplyOrderLineItem clone(String supplyOrderLineItemId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderLineItemTable.withId(supplyOrderLineItemId),options);
	}
	
	protected SupplyOrderLineItem clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderLineItemId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderLineItem newSupplyOrderLineItem = loadInternalSupplyOrderLineItem(accessKey, options);
		newSupplyOrderLineItem.setVersion(0);
		
		

		
		saveInternalSupplyOrderLineItem(newSupplyOrderLineItem,options);
		
		return newSupplyOrderLineItem;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderLineItemId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderLineItemId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderLineItemVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderLineItemNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderLineItemId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderLineItemId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderLineItemId, int version)";
		assertMethodArgumentNotNull(supplyOrderLineItemId, methodName, "supplyOrderLineItemId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderLineItemId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderLineItemId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"biz_order","sku_id","sku_name","amount","quantity","unit_of_measurement"};
		return SupplyOrderLineItemTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_line_item";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderLineItemTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderLineItemTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderLineItemTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected SupplyOrderLineItemMapper getSupplyOrderLineItemMapper(){
		return new SupplyOrderLineItemMapper();
	}
	protected SupplyOrderLineItem extractSupplyOrderLineItem(String supplyOrderLineItemId) throws Exception{
		String SQL = "select * from supply_order_line_item_data where id = ?";	
		try{
		
			SupplyOrderLineItem supplyOrderLineItem = queryForObject(SQL, new Object[]{supplyOrderLineItemId}, getSupplyOrderLineItemMapper());
			return supplyOrderLineItem;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderLineItemNotFoundException("SupplyOrderLineItem("+supplyOrderLineItemId+") is not found!");
		}
		
		
	}
	protected SupplyOrderLineItem extractSupplyOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_line_item_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderLineItem supplyOrderLineItem = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderLineItemMapper());
			return supplyOrderLineItem;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderLineItemNotFoundException("SupplyOrderLineItem("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderLineItem loadInternalSupplyOrderLineItem(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderLineItem supplyOrderLineItem = extractSupplyOrderLineItem(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(supplyOrderLineItem, loadOptions);
 		}
 
		
		return supplyOrderLineItem;
		
	}



	
	
	 

 	protected SupplyOrderLineItem extractBizOrder(SupplyOrderLineItem supplyOrderLineItem, Map<String,Object> options) throws Exception{

		if(supplyOrderLineItem.getBizOrder() == null){
			return supplyOrderLineItem;
		}
		String bizOrderId = supplyOrderLineItem.getBizOrder().getId();
		if( bizOrderId == null){
			return supplyOrderLineItem;
		}
		SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			supplyOrderLineItem.setBizOrder(bizOrder);
		}
		
 		
 		return supplyOrderLineItem;
 	}
 		
 
		
		
  	
 	public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(String supplyOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = queryForList(SQL, new Object[]{supplyOrderId}, getSupplyOrderLineItemMapper());	
 		return supplyOrderLineItemList;
 	}
 	
 	public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(String supplyOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = queryForList(SQL, new Object[]{supplyOrderId,start, count}, getSupplyOrderLineItemMapper());
		
 		return supplyOrderLineItemList;
 	}
 	
 	public int countSupplyOrderLineItemByBizOrder(String supplyOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SupplyOrderLineItem saveSupplyOrderLineItem(SupplyOrderLineItem  supplyOrderLineItem){
	
		String SQL=this.getSaveSupplyOrderLineItemSQL(supplyOrderLineItem);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderLineItemParameters(supplyOrderLineItem);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderLineItem.incVersion();
		return supplyOrderLineItem;
	
	}
	public SmartList<SupplyOrderLineItem> saveSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderLineItemList(supplyOrderLineItemList);
		
		batchSupplyOrderLineItemCreate((List<SupplyOrderLineItem>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderLineItemUpdate((List<SupplyOrderLineItem>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList){
			if(supplyOrderLineItem.isChanged()){
				supplyOrderLineItem.incVersion();
			}
			
		
		}
		
		
		return supplyOrderLineItemList;
	}

	public SmartList<SupplyOrderLineItem> removeSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderLineItemList, options);
		
		return supplyOrderLineItemList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderLineItemBatchCreateArgs(List<SupplyOrderLineItem> supplyOrderLineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList ){
			Object [] parameters = prepareSupplyOrderLineItemCreateParameters(supplyOrderLineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderLineItemBatchUpdateArgs(List<SupplyOrderLineItem> supplyOrderLineItemList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList ){
			if(!supplyOrderLineItem.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderLineItemUpdateParameters(supplyOrderLineItem);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderLineItemCreate(List<SupplyOrderLineItem> supplyOrderLineItemList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderLineItemBatchCreateArgs(supplyOrderLineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderLineItemUpdate(List<SupplyOrderLineItem> supplyOrderLineItemList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderLineItemBatchUpdateArgs(supplyOrderLineItemList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderLineItemList(List<SupplyOrderLineItem> supplyOrderLineItemList){
		
		List<SupplyOrderLineItem> supplyOrderLineItemCreateList=new ArrayList<SupplyOrderLineItem>();
		List<SupplyOrderLineItem> supplyOrderLineItemUpdateList=new ArrayList<SupplyOrderLineItem>();
		
		for(SupplyOrderLineItem supplyOrderLineItem: supplyOrderLineItemList){
			if(isUpdateRequest(supplyOrderLineItem)){
				supplyOrderLineItemUpdateList.add( supplyOrderLineItem);
				continue;
			}
			supplyOrderLineItemCreateList.add(supplyOrderLineItem);
		}
		
		return new Object[]{supplyOrderLineItemCreateList,supplyOrderLineItemUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderLineItem supplyOrderLineItem){
 		return supplyOrderLineItem.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderLineItemSQL(SupplyOrderLineItem supplyOrderLineItem){
 		if(isUpdateRequest(supplyOrderLineItem)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderLineItemParameters(SupplyOrderLineItem supplyOrderLineItem){
 		if(isUpdateRequest(supplyOrderLineItem) ){
 			return prepareSupplyOrderLineItemUpdateParameters(supplyOrderLineItem);
 		}
 		return prepareSupplyOrderLineItemCreateParameters(supplyOrderLineItem);
 	}
 	protected Object[] prepareSupplyOrderLineItemUpdateParameters(SupplyOrderLineItem supplyOrderLineItem){
 		Object[] parameters = new Object[8];
  	
 		if(supplyOrderLineItem.getBizOrder() != null){
 			parameters[0] = supplyOrderLineItem.getBizOrder().getId();
 		}
 
 		parameters[1] = supplyOrderLineItem.getSkuId();
 		parameters[2] = supplyOrderLineItem.getSkuName();
 		parameters[3] = supplyOrderLineItem.getAmount();
 		parameters[4] = supplyOrderLineItem.getQuantity();
 		parameters[5] = supplyOrderLineItem.getUnitOfMeasurement();		
 		parameters[6] = supplyOrderLineItem.getId();
 		parameters[7] = supplyOrderLineItem.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderLineItemCreateParameters(SupplyOrderLineItem supplyOrderLineItem){
		Object[] parameters = new Object[7];
		String newSupplyOrderLineItemId=getNextId();
		supplyOrderLineItem.setId(newSupplyOrderLineItemId);
		parameters[0] =  supplyOrderLineItem.getId();
  	
 		if(supplyOrderLineItem.getBizOrder() != null){
 			parameters[1] = supplyOrderLineItem.getBizOrder().getId();
 		
 		}
 		
 		parameters[2] = supplyOrderLineItem.getSkuId();
 		parameters[3] = supplyOrderLineItem.getSkuName();
 		parameters[4] = supplyOrderLineItem.getAmount();
 		parameters[5] = supplyOrderLineItem.getQuantity();
 		parameters[6] = supplyOrderLineItem.getUnitOfMeasurement();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderLineItem saveInternalSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem, Map<String,Object> options){
		
		saveSupplyOrderLineItem(supplyOrderLineItem);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(supplyOrderLineItem, options);
 		}
 
		
		return supplyOrderLineItem;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplyOrderLineItem saveBizOrder(SupplyOrderLineItem supplyOrderLineItem, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrderLineItem.getBizOrder() == null){
 			return supplyOrderLineItem;//do nothing when it is null
 		}
 		
 		getSupplyOrderDAO().save(supplyOrderLineItem.getBizOrder(),options);
 		return supplyOrderLineItem;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public SupplyOrderLineItem present(SupplyOrderLineItem supplyOrderLineItem,Map<String, Object> options){
	

		return supplyOrderLineItem;
	
	}
		


	protected String getTableName(){
		return SupplyOrderLineItemTable.TABLE_NAME;
	}
}


