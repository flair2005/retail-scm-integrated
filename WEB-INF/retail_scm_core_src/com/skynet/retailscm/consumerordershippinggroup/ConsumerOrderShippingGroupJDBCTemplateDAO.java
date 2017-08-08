
package com.skynet.retailscm.consumerordershippinggroup;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

import com.skynet.retailscm.consumerorder.ConsumerOrderDAO;

import com.skynet.retailscm.consumerorder.ConsumerOrderTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderShippingGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderShippingGroupDAO{
 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}

		

	
	/*
	protected ConsumerOrderShippingGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShippingGroup(accessKey, options);
	}
	*/
	public ConsumerOrderShippingGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShippingGroup(ConsumerOrderShippingGroupTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderShippingGroup save(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderShippingGroup, methodName, "consumerOrderShippingGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderShippingGroup(consumerOrderShippingGroup,options);
	}
	public ConsumerOrderShippingGroup clone(String consumerOrderShippingGroupId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderShippingGroupTable.withId(consumerOrderShippingGroupId),options);
	}
	
	protected ConsumerOrderShippingGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderShippingGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderShippingGroup newConsumerOrderShippingGroup = loadInternalConsumerOrderShippingGroup(accessKey, options);
		newConsumerOrderShippingGroup.setVersion(0);
		
		

		
		saveInternalConsumerOrderShippingGroup(newConsumerOrderShippingGroup,options);
		
		return newConsumerOrderShippingGroup;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderShippingGroupId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderShippingGroupId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderShippingGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderShippingGroupNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderShippingGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderShippingGroupId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderShippingGroupId, int version)";
		assertMethodArgumentNotNull(consumerOrderShippingGroupId, methodName, "consumerOrderShippingGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderShippingGroupId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderShippingGroupId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","biz_order","amount"};
		return ConsumerOrderShippingGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_shipping_group";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderShippingGroupTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderShippingGroupTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderShippingGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected ConsumerOrderShippingGroupMapper getConsumerOrderShippingGroupMapper(){
		return new ConsumerOrderShippingGroupMapper();
	}
	protected ConsumerOrderShippingGroup extractConsumerOrderShippingGroup(String consumerOrderShippingGroupId) throws Exception{
		String SQL = "select * from consumer_order_shipping_group_data where id = ?";	
		try{
		
			ConsumerOrderShippingGroup consumerOrderShippingGroup = queryForObject(SQL, new Object[]{consumerOrderShippingGroupId}, getConsumerOrderShippingGroupMapper());
			return consumerOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderShippingGroupNotFoundException("ConsumerOrderShippingGroup("+consumerOrderShippingGroupId+") is not found!");
		}
		
		
	}
	protected ConsumerOrderShippingGroup extractConsumerOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_shipping_group_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrderShippingGroup consumerOrderShippingGroup = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderShippingGroupMapper());
			return consumerOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderShippingGroupNotFoundException("ConsumerOrderShippingGroup("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrderShippingGroup loadInternalConsumerOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderShippingGroup consumerOrderShippingGroup = extractConsumerOrderShippingGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(consumerOrderShippingGroup, loadOptions);
 		}
 
		
		return consumerOrderShippingGroup;
		
	}



	
	
	 

 	protected ConsumerOrderShippingGroup extractBizOrder(ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options) throws Exception{

		if(consumerOrderShippingGroup.getBizOrder() == null){
			return consumerOrderShippingGroup;
		}
		String bizOrderId = consumerOrderShippingGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return consumerOrderShippingGroup;
		}
		ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			consumerOrderShippingGroup.setBizOrder(bizOrder);
		}
		
 		
 		return consumerOrderShippingGroup;
 	}
 		
 
		
		
  	
 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = queryForList(SQL, new Object[]{consumerOrderId}, getConsumerOrderShippingGroupMapper());	
 		return consumerOrderShippingGroupList;
 	}
 	
 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = queryForList(SQL, new Object[]{consumerOrderId,start, count}, getConsumerOrderShippingGroupMapper());
		
 		return consumerOrderShippingGroupList;
 	}
 	
 	public int countConsumerOrderShippingGroupByBizOrder(String consumerOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{consumerOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ConsumerOrderShippingGroup saveConsumerOrderShippingGroup(ConsumerOrderShippingGroup  consumerOrderShippingGroup){
	
		String SQL=this.getSaveConsumerOrderShippingGroupSQL(consumerOrderShippingGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderShippingGroupParameters(consumerOrderShippingGroup);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderShippingGroup.incVersion();
		return consumerOrderShippingGroup;
	
	}
	public SmartList<ConsumerOrderShippingGroup> saveConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderShippingGroupList(consumerOrderShippingGroupList);
		
		batchConsumerOrderShippingGroupCreate((List<ConsumerOrderShippingGroup>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderShippingGroupUpdate((List<ConsumerOrderShippingGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			if(consumerOrderShippingGroup.isChanged()){
				consumerOrderShippingGroup.incVersion();
			}
			
		
		}
		
		
		return consumerOrderShippingGroupList;
	}

	public SmartList<ConsumerOrderShippingGroup> removeConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderShippingGroupList, options);
		
		return consumerOrderShippingGroupList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderShippingGroupBatchCreateArgs(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList ){
			Object [] parameters = prepareConsumerOrderShippingGroupCreateParameters(consumerOrderShippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderShippingGroupBatchUpdateArgs(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList ){
			if(!consumerOrderShippingGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderShippingGroupUpdateParameters(consumerOrderShippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderShippingGroupCreate(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderShippingGroupBatchCreateArgs(consumerOrderShippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderShippingGroupUpdate(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderShippingGroupBatchUpdateArgs(consumerOrderShippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderShippingGroupList(List<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		
		List<ConsumerOrderShippingGroup> consumerOrderShippingGroupCreateList=new ArrayList<ConsumerOrderShippingGroup>();
		List<ConsumerOrderShippingGroup> consumerOrderShippingGroupUpdateList=new ArrayList<ConsumerOrderShippingGroup>();
		
		for(ConsumerOrderShippingGroup consumerOrderShippingGroup: consumerOrderShippingGroupList){
			if(isUpdateRequest(consumerOrderShippingGroup)){
				consumerOrderShippingGroupUpdateList.add( consumerOrderShippingGroup);
				continue;
			}
			consumerOrderShippingGroupCreateList.add(consumerOrderShippingGroup);
		}
		
		return new Object[]{consumerOrderShippingGroupCreateList,consumerOrderShippingGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		return consumerOrderShippingGroup.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderShippingGroupSQL(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		if(isUpdateRequest(consumerOrderShippingGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderShippingGroupParameters(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		if(isUpdateRequest(consumerOrderShippingGroup) ){
 			return prepareConsumerOrderShippingGroupUpdateParameters(consumerOrderShippingGroup);
 		}
 		return prepareConsumerOrderShippingGroupCreateParameters(consumerOrderShippingGroup);
 	}
 	protected Object[] prepareConsumerOrderShippingGroupUpdateParameters(ConsumerOrderShippingGroup consumerOrderShippingGroup){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = consumerOrderShippingGroup.getName(); 	
 		if(consumerOrderShippingGroup.getBizOrder() != null){
 			parameters[1] = consumerOrderShippingGroup.getBizOrder().getId();
 		}
 
 		parameters[2] = consumerOrderShippingGroup.getAmount();		
 		parameters[3] = consumerOrderShippingGroup.getId();
 		parameters[4] = consumerOrderShippingGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderShippingGroupCreateParameters(ConsumerOrderShippingGroup consumerOrderShippingGroup){
		Object[] parameters = new Object[4];
		String newConsumerOrderShippingGroupId=getNextId();
		consumerOrderShippingGroup.setId(newConsumerOrderShippingGroupId);
		parameters[0] =  consumerOrderShippingGroup.getId();
 
 		parameters[1] = consumerOrderShippingGroup.getName(); 	
 		if(consumerOrderShippingGroup.getBizOrder() != null){
 			parameters[2] = consumerOrderShippingGroup.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = consumerOrderShippingGroup.getAmount();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderShippingGroup saveInternalConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options){
		
		saveConsumerOrderShippingGroup(consumerOrderShippingGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(consumerOrderShippingGroup, options);
 		}
 
		
		return consumerOrderShippingGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ConsumerOrderShippingGroup saveBizOrder(ConsumerOrderShippingGroup consumerOrderShippingGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrderShippingGroup.getBizOrder() == null){
 			return consumerOrderShippingGroup;//do nothing when it is null
 		}
 		
 		getConsumerOrderDAO().save(consumerOrderShippingGroup.getBizOrder(),options);
 		return consumerOrderShippingGroup;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public ConsumerOrderShippingGroup present(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String, Object> options){
	

		return consumerOrderShippingGroup;
	
	}
		


	protected String getTableName(){
		return ConsumerOrderShippingGroupTable.TABLE_NAME;
	}
}


