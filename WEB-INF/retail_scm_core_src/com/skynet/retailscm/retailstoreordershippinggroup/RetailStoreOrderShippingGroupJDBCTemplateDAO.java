
package com.skynet.retailscm.retailstoreordershippinggroup;

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

public class RetailStoreOrderShippingGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderShippingGroupDAO{
 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

		

	
	/*
	protected RetailStoreOrderShippingGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderShippingGroup(accessKey, options);
	}
	*/
	public RetailStoreOrderShippingGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroupTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderShippingGroup save(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderShippingGroup, methodName, "retailStoreOrderShippingGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup,options);
	}
	public RetailStoreOrderShippingGroup clone(String retailStoreOrderShippingGroupId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderShippingGroupTable.withId(retailStoreOrderShippingGroupId),options);
	}
	
	protected RetailStoreOrderShippingGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderShippingGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderShippingGroup newRetailStoreOrderShippingGroup = loadInternalRetailStoreOrderShippingGroup(accessKey, options);
		newRetailStoreOrderShippingGroup.setVersion(0);
		
		

		
		saveInternalRetailStoreOrderShippingGroup(newRetailStoreOrderShippingGroup,options);
		
		return newRetailStoreOrderShippingGroup;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderShippingGroupId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderShippingGroupId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderShippingGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderShippingGroupNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderShippingGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderShippingGroupId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderShippingGroupId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderShippingGroupId, methodName, "retailStoreOrderShippingGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderShippingGroupId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderShippingGroupId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","biz_order","amount"};
		return RetailStoreOrderShippingGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_shipping_group";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderShippingGroupTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderShippingGroupTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderShippingGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected RetailStoreOrderShippingGroupMapper getRetailStoreOrderShippingGroupMapper(){
		return new RetailStoreOrderShippingGroupMapper();
	}
	protected RetailStoreOrderShippingGroup extractRetailStoreOrderShippingGroup(String retailStoreOrderShippingGroupId) throws Exception{
		String SQL = "select * from retail_store_order_shipping_group_data where id = ?";	
		try{
		
			RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = queryForObject(SQL, new Object[]{retailStoreOrderShippingGroupId}, getRetailStoreOrderShippingGroupMapper());
			return retailStoreOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderShippingGroupNotFoundException("RetailStoreOrderShippingGroup("+retailStoreOrderShippingGroupId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderShippingGroup extractRetailStoreOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_shipping_group_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderShippingGroupMapper());
			return retailStoreOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderShippingGroupNotFoundException("RetailStoreOrderShippingGroup("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderShippingGroup loadInternalRetailStoreOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = extractRetailStoreOrderShippingGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(retailStoreOrderShippingGroup, loadOptions);
 		}
 
		
		return retailStoreOrderShippingGroup;
		
	}



	
	
	 

 	protected RetailStoreOrderShippingGroup extractBizOrder(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object> options) throws Exception{

		if(retailStoreOrderShippingGroup.getBizOrder() == null){
			return retailStoreOrderShippingGroup;
		}
		String bizOrderId = retailStoreOrderShippingGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return retailStoreOrderShippingGroup;
		}
		RetailStoreOrder bizOrder = getRetailStoreOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			retailStoreOrderShippingGroup.setBizOrder(bizOrder);
		}
		
 		
 		return retailStoreOrderShippingGroup;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = queryForList(SQL, new Object[]{retailStoreOrderId}, getRetailStoreOrderShippingGroupMapper());	
 		return retailStoreOrderShippingGroupList;
 	}
 	
 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = queryForList(SQL, new Object[]{retailStoreOrderId,start, count}, getRetailStoreOrderShippingGroupMapper());
		
 		return retailStoreOrderShippingGroupList;
 	}
 	
 	public int countRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreOrderShippingGroup saveRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup  retailStoreOrderShippingGroup){
	
		String SQL=this.getSaveRetailStoreOrderShippingGroupSQL(retailStoreOrderShippingGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderShippingGroupParameters(retailStoreOrderShippingGroup);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderShippingGroup.incVersion();
		return retailStoreOrderShippingGroup;
	
	}
	public SmartList<RetailStoreOrderShippingGroup> saveRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList);
		
		batchRetailStoreOrderShippingGroupCreate((List<RetailStoreOrderShippingGroup>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderShippingGroupUpdate((List<RetailStoreOrderShippingGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList){
			if(retailStoreOrderShippingGroup.isChanged()){
				retailStoreOrderShippingGroup.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderShippingGroupList;
	}

	public SmartList<RetailStoreOrderShippingGroup> removeRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderShippingGroupList, options);
		
		return retailStoreOrderShippingGroupList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderShippingGroupBatchCreateArgs(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList ){
			Object [] parameters = prepareRetailStoreOrderShippingGroupCreateParameters(retailStoreOrderShippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderShippingGroupBatchUpdateArgs(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList ){
			if(!retailStoreOrderShippingGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderShippingGroupUpdateParameters(retailStoreOrderShippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderShippingGroupCreate(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderShippingGroupBatchCreateArgs(retailStoreOrderShippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderShippingGroupUpdate(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderShippingGroupBatchUpdateArgs(retailStoreOrderShippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderShippingGroupList(List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		
		List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupCreateList=new ArrayList<RetailStoreOrderShippingGroup>();
		List<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupUpdateList=new ArrayList<RetailStoreOrderShippingGroup>();
		
		for(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup: retailStoreOrderShippingGroupList){
			if(isUpdateRequest(retailStoreOrderShippingGroup)){
				retailStoreOrderShippingGroupUpdateList.add( retailStoreOrderShippingGroup);
				continue;
			}
			retailStoreOrderShippingGroupCreateList.add(retailStoreOrderShippingGroup);
		}
		
		return new Object[]{retailStoreOrderShippingGroupCreateList,retailStoreOrderShippingGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
 		return retailStoreOrderShippingGroup.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderShippingGroupSQL(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
 		if(isUpdateRequest(retailStoreOrderShippingGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderShippingGroupParameters(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
 		if(isUpdateRequest(retailStoreOrderShippingGroup) ){
 			return prepareRetailStoreOrderShippingGroupUpdateParameters(retailStoreOrderShippingGroup);
 		}
 		return prepareRetailStoreOrderShippingGroupCreateParameters(retailStoreOrderShippingGroup);
 	}
 	protected Object[] prepareRetailStoreOrderShippingGroupUpdateParameters(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderShippingGroup.getName(); 	
 		if(retailStoreOrderShippingGroup.getBizOrder() != null){
 			parameters[1] = retailStoreOrderShippingGroup.getBizOrder().getId();
 		}
 
 		parameters[2] = retailStoreOrderShippingGroup.getAmount();		
 		parameters[3] = retailStoreOrderShippingGroup.getId();
 		parameters[4] = retailStoreOrderShippingGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderShippingGroupCreateParameters(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
		Object[] parameters = new Object[4];
		String newRetailStoreOrderShippingGroupId=getNextId();
		retailStoreOrderShippingGroup.setId(newRetailStoreOrderShippingGroupId);
		parameters[0] =  retailStoreOrderShippingGroup.getId();
 
 		parameters[1] = retailStoreOrderShippingGroup.getName(); 	
 		if(retailStoreOrderShippingGroup.getBizOrder() != null){
 			parameters[2] = retailStoreOrderShippingGroup.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = retailStoreOrderShippingGroup.getAmount();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderShippingGroup saveInternalRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object> options){
		
		saveRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(retailStoreOrderShippingGroup, options);
 		}
 
		
		return retailStoreOrderShippingGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreOrderShippingGroup saveBizOrder(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrderShippingGroup.getBizOrder() == null){
 			return retailStoreOrderShippingGroup;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDAO().save(retailStoreOrderShippingGroup.getBizOrder(),options);
 		return retailStoreOrderShippingGroup;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public RetailStoreOrderShippingGroup present(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String, Object> options){
	

		return retailStoreOrderShippingGroup;
	
	}
		


	protected String getTableName(){
		return RetailStoreOrderShippingGroupTable.TABLE_NAME;
	}
}


