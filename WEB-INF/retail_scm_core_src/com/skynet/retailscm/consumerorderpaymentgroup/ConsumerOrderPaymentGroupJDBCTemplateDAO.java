
package com.skynet.retailscm.consumerorderpaymentgroup;

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

public class ConsumerOrderPaymentGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderPaymentGroupDAO{
 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}

		

	
	/*
	protected ConsumerOrderPaymentGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderPaymentGroup(accessKey, options);
	}
	*/
	public ConsumerOrderPaymentGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderPaymentGroup(ConsumerOrderPaymentGroupTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderPaymentGroup save(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderPaymentGroup, methodName, "consumerOrderPaymentGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderPaymentGroup(consumerOrderPaymentGroup,options);
	}
	public ConsumerOrderPaymentGroup clone(String consumerOrderPaymentGroupId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderPaymentGroupTable.withId(consumerOrderPaymentGroupId),options);
	}
	
	protected ConsumerOrderPaymentGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderPaymentGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderPaymentGroup newConsumerOrderPaymentGroup = loadInternalConsumerOrderPaymentGroup(accessKey, options);
		newConsumerOrderPaymentGroup.setVersion(0);
		
		

		
		saveInternalConsumerOrderPaymentGroup(newConsumerOrderPaymentGroup,options);
		
		return newConsumerOrderPaymentGroup;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderPaymentGroupId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderPaymentGroupId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderPaymentGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderPaymentGroupNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderPaymentGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderPaymentGroupId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderPaymentGroupId, int version)";
		assertMethodArgumentNotNull(consumerOrderPaymentGroupId, methodName, "consumerOrderPaymentGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderPaymentGroupId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderPaymentGroupId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","biz_order","card_number"};
		return ConsumerOrderPaymentGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_payment_group";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderPaymentGroupTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderPaymentGroupTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderPaymentGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected ConsumerOrderPaymentGroupMapper getConsumerOrderPaymentGroupMapper(){
		return new ConsumerOrderPaymentGroupMapper();
	}
	protected ConsumerOrderPaymentGroup extractConsumerOrderPaymentGroup(String consumerOrderPaymentGroupId) throws Exception{
		String SQL = "select * from consumer_order_payment_group_data where id = ?";	
		try{
		
			ConsumerOrderPaymentGroup consumerOrderPaymentGroup = queryForObject(SQL, new Object[]{consumerOrderPaymentGroupId}, getConsumerOrderPaymentGroupMapper());
			return consumerOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderPaymentGroupNotFoundException("ConsumerOrderPaymentGroup("+consumerOrderPaymentGroupId+") is not found!");
		}
		
		
	}
	protected ConsumerOrderPaymentGroup extractConsumerOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_payment_group_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrderPaymentGroup consumerOrderPaymentGroup = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderPaymentGroupMapper());
			return consumerOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderPaymentGroupNotFoundException("ConsumerOrderPaymentGroup("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrderPaymentGroup loadInternalConsumerOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = extractConsumerOrderPaymentGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(consumerOrderPaymentGroup, loadOptions);
 		}
 
		
		return consumerOrderPaymentGroup;
		
	}



	
	
	 

 	protected ConsumerOrderPaymentGroup extractBizOrder(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String,Object> options) throws Exception{

		if(consumerOrderPaymentGroup.getBizOrder() == null){
			return consumerOrderPaymentGroup;
		}
		String bizOrderId = consumerOrderPaymentGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return consumerOrderPaymentGroup;
		}
		ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			consumerOrderPaymentGroup.setBizOrder(bizOrder);
		}
		
 		
 		return consumerOrderPaymentGroup;
 	}
 		
 
		
		
  	
 	public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(String consumerOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = queryForList(SQL, new Object[]{consumerOrderId}, getConsumerOrderPaymentGroupMapper());	
 		return consumerOrderPaymentGroupList;
 	}
 	
 	public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(String consumerOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = queryForList(SQL, new Object[]{consumerOrderId,start, count}, getConsumerOrderPaymentGroupMapper());
		
 		return consumerOrderPaymentGroupList;
 	}
 	
 	public int countConsumerOrderPaymentGroupByBizOrder(String consumerOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{consumerOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ConsumerOrderPaymentGroup saveConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup  consumerOrderPaymentGroup){
	
		String SQL=this.getSaveConsumerOrderPaymentGroupSQL(consumerOrderPaymentGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderPaymentGroupParameters(consumerOrderPaymentGroup);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderPaymentGroup.incVersion();
		return consumerOrderPaymentGroup;
	
	}
	public SmartList<ConsumerOrderPaymentGroup> saveConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList);
		
		batchConsumerOrderPaymentGroupCreate((List<ConsumerOrderPaymentGroup>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderPaymentGroupUpdate((List<ConsumerOrderPaymentGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList){
			if(consumerOrderPaymentGroup.isChanged()){
				consumerOrderPaymentGroup.incVersion();
			}
			
		
		}
		
		
		return consumerOrderPaymentGroupList;
	}

	public SmartList<ConsumerOrderPaymentGroup> removeConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderPaymentGroupList, options);
		
		return consumerOrderPaymentGroupList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderPaymentGroupBatchCreateArgs(List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList ){
			Object [] parameters = prepareConsumerOrderPaymentGroupCreateParameters(consumerOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderPaymentGroupBatchUpdateArgs(List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList ){
			if(!consumerOrderPaymentGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderPaymentGroupUpdateParameters(consumerOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderPaymentGroupCreate(List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderPaymentGroupBatchCreateArgs(consumerOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderPaymentGroupUpdate(List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderPaymentGroupBatchUpdateArgs(consumerOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderPaymentGroupList(List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		
		List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupCreateList=new ArrayList<ConsumerOrderPaymentGroup>();
		List<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupUpdateList=new ArrayList<ConsumerOrderPaymentGroup>();
		
		for(ConsumerOrderPaymentGroup consumerOrderPaymentGroup: consumerOrderPaymentGroupList){
			if(isUpdateRequest(consumerOrderPaymentGroup)){
				consumerOrderPaymentGroupUpdateList.add( consumerOrderPaymentGroup);
				continue;
			}
			consumerOrderPaymentGroupCreateList.add(consumerOrderPaymentGroup);
		}
		
		return new Object[]{consumerOrderPaymentGroupCreateList,consumerOrderPaymentGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
 		return consumerOrderPaymentGroup.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderPaymentGroupSQL(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
 		if(isUpdateRequest(consumerOrderPaymentGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderPaymentGroupParameters(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
 		if(isUpdateRequest(consumerOrderPaymentGroup) ){
 			return prepareConsumerOrderPaymentGroupUpdateParameters(consumerOrderPaymentGroup);
 		}
 		return prepareConsumerOrderPaymentGroupCreateParameters(consumerOrderPaymentGroup);
 	}
 	protected Object[] prepareConsumerOrderPaymentGroupUpdateParameters(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = consumerOrderPaymentGroup.getName(); 	
 		if(consumerOrderPaymentGroup.getBizOrder() != null){
 			parameters[1] = consumerOrderPaymentGroup.getBizOrder().getId();
 		}
 
 		parameters[2] = consumerOrderPaymentGroup.getCardNumber();		
 		parameters[3] = consumerOrderPaymentGroup.getId();
 		parameters[4] = consumerOrderPaymentGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderPaymentGroupCreateParameters(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
		Object[] parameters = new Object[4];
		String newConsumerOrderPaymentGroupId=getNextId();
		consumerOrderPaymentGroup.setId(newConsumerOrderPaymentGroupId);
		parameters[0] =  consumerOrderPaymentGroup.getId();
 
 		parameters[1] = consumerOrderPaymentGroup.getName(); 	
 		if(consumerOrderPaymentGroup.getBizOrder() != null){
 			parameters[2] = consumerOrderPaymentGroup.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = consumerOrderPaymentGroup.getCardNumber();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderPaymentGroup saveInternalConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String,Object> options){
		
		saveConsumerOrderPaymentGroup(consumerOrderPaymentGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(consumerOrderPaymentGroup, options);
 		}
 
		
		return consumerOrderPaymentGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ConsumerOrderPaymentGroup saveBizOrder(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrderPaymentGroup.getBizOrder() == null){
 			return consumerOrderPaymentGroup;//do nothing when it is null
 		}
 		
 		getConsumerOrderDAO().save(consumerOrderPaymentGroup.getBizOrder(),options);
 		return consumerOrderPaymentGroup;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public ConsumerOrderPaymentGroup present(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String, Object> options){
	

		return consumerOrderPaymentGroup;
	
	}
		


	protected String getTableName(){
		return ConsumerOrderPaymentGroupTable.TABLE_NAME;
	}
}


