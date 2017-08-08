
package com.skynet.retailscm.retailstoreorderpaymentgroup;

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

public class RetailStoreOrderPaymentGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderPaymentGroupDAO{
 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

		

	
	/*
	protected RetailStoreOrderPaymentGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPaymentGroup(accessKey, options);
	}
	*/
	public RetailStoreOrderPaymentGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroupTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrderPaymentGroup save(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrderPaymentGroup, methodName, "retailStoreOrderPaymentGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup,options);
	}
	public RetailStoreOrderPaymentGroup clone(String retailStoreOrderPaymentGroupId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderPaymentGroupTable.withId(retailStoreOrderPaymentGroupId),options);
	}
	
	protected RetailStoreOrderPaymentGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderPaymentGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrderPaymentGroup newRetailStoreOrderPaymentGroup = loadInternalRetailStoreOrderPaymentGroup(accessKey, options);
		newRetailStoreOrderPaymentGroup.setVersion(0);
		
		

		
		saveInternalRetailStoreOrderPaymentGroup(newRetailStoreOrderPaymentGroup,options);
		
		return newRetailStoreOrderPaymentGroup;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderPaymentGroupId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderPaymentGroupId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderPaymentGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderPaymentGroupNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderPaymentGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderPaymentGroupId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderPaymentGroupId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderPaymentGroupId, methodName, "retailStoreOrderPaymentGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderPaymentGroupId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderPaymentGroupId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","biz_order","card_number"};
		return RetailStoreOrderPaymentGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order_payment_group";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderPaymentGroupTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderPaymentGroupTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderPaymentGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected RetailStoreOrderPaymentGroupMapper getRetailStoreOrderPaymentGroupMapper(){
		return new RetailStoreOrderPaymentGroupMapper();
	}
	protected RetailStoreOrderPaymentGroup extractRetailStoreOrderPaymentGroup(String retailStoreOrderPaymentGroupId) throws Exception{
		String SQL = "select * from retail_store_order_payment_group_data where id = ?";	
		try{
		
			RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = queryForObject(SQL, new Object[]{retailStoreOrderPaymentGroupId}, getRetailStoreOrderPaymentGroupMapper());
			return retailStoreOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderPaymentGroupNotFoundException("RetailStoreOrderPaymentGroup("+retailStoreOrderPaymentGroupId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrderPaymentGroup extractRetailStoreOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_payment_group_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderPaymentGroupMapper());
			return retailStoreOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderPaymentGroupNotFoundException("RetailStoreOrderPaymentGroup("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrderPaymentGroup loadInternalRetailStoreOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = extractRetailStoreOrderPaymentGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(retailStoreOrderPaymentGroup, loadOptions);
 		}
 
		
		return retailStoreOrderPaymentGroup;
		
	}



	
	
	 

 	protected RetailStoreOrderPaymentGroup extractBizOrder(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options) throws Exception{

		if(retailStoreOrderPaymentGroup.getBizOrder() == null){
			return retailStoreOrderPaymentGroup;
		}
		String bizOrderId = retailStoreOrderPaymentGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return retailStoreOrderPaymentGroup;
		}
		RetailStoreOrder bizOrder = getRetailStoreOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			retailStoreOrderPaymentGroup.setBizOrder(bizOrder);
		}
		
 		
 		return retailStoreOrderPaymentGroup;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = queryForList(SQL, new Object[]{retailStoreOrderId}, getRetailStoreOrderPaymentGroupMapper());	
 		return retailStoreOrderPaymentGroupList;
 	}
 	
 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = queryForList(SQL, new Object[]{retailStoreOrderId,start, count}, getRetailStoreOrderPaymentGroupMapper());
		
 		return retailStoreOrderPaymentGroupList;
 	}
 	
 	public int countRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreOrderPaymentGroup saveRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup  retailStoreOrderPaymentGroup){
	
		String SQL=this.getSaveRetailStoreOrderPaymentGroupSQL(retailStoreOrderPaymentGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderPaymentGroupParameters(retailStoreOrderPaymentGroup);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrderPaymentGroup.incVersion();
		return retailStoreOrderPaymentGroup;
	
	}
	public SmartList<RetailStoreOrderPaymentGroup> saveRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList);
		
		batchRetailStoreOrderPaymentGroupCreate((List<RetailStoreOrderPaymentGroup>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderPaymentGroupUpdate((List<RetailStoreOrderPaymentGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			if(retailStoreOrderPaymentGroup.isChanged()){
				retailStoreOrderPaymentGroup.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderPaymentGroupList;
	}

	public SmartList<RetailStoreOrderPaymentGroup> removeRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderPaymentGroupList, options);
		
		return retailStoreOrderPaymentGroupList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderPaymentGroupBatchCreateArgs(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList ){
			Object [] parameters = prepareRetailStoreOrderPaymentGroupCreateParameters(retailStoreOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderPaymentGroupBatchUpdateArgs(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList ){
			if(!retailStoreOrderPaymentGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderPaymentGroupUpdateParameters(retailStoreOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderPaymentGroupCreate(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderPaymentGroupBatchCreateArgs(retailStoreOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderPaymentGroupUpdate(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderPaymentGroupBatchUpdateArgs(retailStoreOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderPaymentGroupList(List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		
		List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupCreateList=new ArrayList<RetailStoreOrderPaymentGroup>();
		List<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupUpdateList=new ArrayList<RetailStoreOrderPaymentGroup>();
		
		for(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup: retailStoreOrderPaymentGroupList){
			if(isUpdateRequest(retailStoreOrderPaymentGroup)){
				retailStoreOrderPaymentGroupUpdateList.add( retailStoreOrderPaymentGroup);
				continue;
			}
			retailStoreOrderPaymentGroupCreateList.add(retailStoreOrderPaymentGroup);
		}
		
		return new Object[]{retailStoreOrderPaymentGroupCreateList,retailStoreOrderPaymentGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		return retailStoreOrderPaymentGroup.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderPaymentGroupSQL(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		if(isUpdateRequest(retailStoreOrderPaymentGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderPaymentGroupParameters(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		if(isUpdateRequest(retailStoreOrderPaymentGroup) ){
 			return prepareRetailStoreOrderPaymentGroupUpdateParameters(retailStoreOrderPaymentGroup);
 		}
 		return prepareRetailStoreOrderPaymentGroupCreateParameters(retailStoreOrderPaymentGroup);
 	}
 	protected Object[] prepareRetailStoreOrderPaymentGroupUpdateParameters(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreOrderPaymentGroup.getName(); 	
 		if(retailStoreOrderPaymentGroup.getBizOrder() != null){
 			parameters[1] = retailStoreOrderPaymentGroup.getBizOrder().getId();
 		}
 
 		parameters[2] = retailStoreOrderPaymentGroup.getCardNumber();		
 		parameters[3] = retailStoreOrderPaymentGroup.getId();
 		parameters[4] = retailStoreOrderPaymentGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderPaymentGroupCreateParameters(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		Object[] parameters = new Object[4];
		String newRetailStoreOrderPaymentGroupId=getNextId();
		retailStoreOrderPaymentGroup.setId(newRetailStoreOrderPaymentGroupId);
		parameters[0] =  retailStoreOrderPaymentGroup.getId();
 
 		parameters[1] = retailStoreOrderPaymentGroup.getName(); 	
 		if(retailStoreOrderPaymentGroup.getBizOrder() != null){
 			parameters[2] = retailStoreOrderPaymentGroup.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = retailStoreOrderPaymentGroup.getCardNumber();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrderPaymentGroup saveInternalRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options){
		
		saveRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(retailStoreOrderPaymentGroup, options);
 		}
 
		
		return retailStoreOrderPaymentGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreOrderPaymentGroup saveBizOrder(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrderPaymentGroup.getBizOrder() == null){
 			return retailStoreOrderPaymentGroup;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDAO().save(retailStoreOrderPaymentGroup.getBizOrder(),options);
 		return retailStoreOrderPaymentGroup;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public RetailStoreOrderPaymentGroup present(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String, Object> options){
	

		return retailStoreOrderPaymentGroup;
	
	}
		


	protected String getTableName(){
		return RetailStoreOrderPaymentGroupTable.TABLE_NAME;
	}
}


