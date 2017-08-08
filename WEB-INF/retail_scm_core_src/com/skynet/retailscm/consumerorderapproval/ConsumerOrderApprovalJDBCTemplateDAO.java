
package com.skynet.retailscm.consumerorderapproval;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;




import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderApprovalJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderApprovalDAO{

		

	
	/*
	protected ConsumerOrderApproval load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderApproval(accessKey, options);
	}
	*/
	public ConsumerOrderApproval load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderApproval(ConsumerOrderApprovalTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderApproval save(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderApproval, methodName, "consumerOrderApproval");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderApproval(consumerOrderApproval,options);
	}
	public ConsumerOrderApproval clone(String consumerOrderApprovalId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderApprovalTable.withId(consumerOrderApprovalId),options);
	}
	
	protected ConsumerOrderApproval clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderApprovalId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderApproval newConsumerOrderApproval = loadInternalConsumerOrderApproval(accessKey, options);
		newConsumerOrderApproval.setVersion(0);
		
		

		
		saveInternalConsumerOrderApproval(newConsumerOrderApproval,options);
		
		return newConsumerOrderApproval;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderApprovalId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderApprovalId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderApprovalVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderApprovalNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderApprovalId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderApprovalId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderApprovalId, int version)";
		assertMethodArgumentNotNull(consumerOrderApprovalId, methodName, "consumerOrderApprovalId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderApprovalId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderApprovalId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","approve_time"};
		return ConsumerOrderApprovalTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_approval";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderApprovalTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ConsumerOrderApprovalMapper getConsumerOrderApprovalMapper(){
		return new ConsumerOrderApprovalMapper();
	}
	protected ConsumerOrderApproval extractConsumerOrderApproval(String consumerOrderApprovalId) throws Exception{
		String SQL = "select * from consumer_order_approval_data where id = ?";	
		try{
		
			ConsumerOrderApproval consumerOrderApproval = queryForObject(SQL, new Object[]{consumerOrderApprovalId}, getConsumerOrderApprovalMapper());
			return consumerOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderApprovalNotFoundException("ConsumerOrderApproval("+consumerOrderApprovalId+") is not found!");
		}
		
		
	}
	protected ConsumerOrderApproval extractConsumerOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_approval_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrderApproval consumerOrderApproval = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderApprovalMapper());
			return consumerOrderApproval;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderApprovalNotFoundException("ConsumerOrderApproval("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrderApproval loadInternalConsumerOrderApproval(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderApproval consumerOrderApproval = extractConsumerOrderApproval(accessKey, loadOptions);

		
		return consumerOrderApproval;
		
	}



	
	
	
		
		
 	
		
		
		

	

	protected ConsumerOrderApproval saveConsumerOrderApproval(ConsumerOrderApproval  consumerOrderApproval){
	
		String SQL=this.getSaveConsumerOrderApprovalSQL(consumerOrderApproval);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderApprovalParameters(consumerOrderApproval);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderApproval.incVersion();
		return consumerOrderApproval;
	
	}
	public SmartList<ConsumerOrderApproval> saveConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderApprovalList(consumerOrderApprovalList);
		
		batchConsumerOrderApprovalCreate((List<ConsumerOrderApproval>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderApprovalUpdate((List<ConsumerOrderApproval>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderApproval consumerOrderApproval:consumerOrderApprovalList){
			if(consumerOrderApproval.isChanged()){
				consumerOrderApproval.incVersion();
			}
			
		
		}
		
		
		return consumerOrderApprovalList;
	}

	public SmartList<ConsumerOrderApproval> removeConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderApprovalList, options);
		
		return consumerOrderApprovalList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderApprovalBatchCreateArgs(List<ConsumerOrderApproval> consumerOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderApproval consumerOrderApproval:consumerOrderApprovalList ){
			Object [] parameters = prepareConsumerOrderApprovalCreateParameters(consumerOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderApprovalBatchUpdateArgs(List<ConsumerOrderApproval> consumerOrderApprovalList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderApproval consumerOrderApproval:consumerOrderApprovalList ){
			if(!consumerOrderApproval.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderApprovalUpdateParameters(consumerOrderApproval);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderApprovalCreate(List<ConsumerOrderApproval> consumerOrderApprovalList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderApprovalBatchCreateArgs(consumerOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderApprovalUpdate(List<ConsumerOrderApproval> consumerOrderApprovalList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderApprovalBatchUpdateArgs(consumerOrderApprovalList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderApprovalList(List<ConsumerOrderApproval> consumerOrderApprovalList){
		
		List<ConsumerOrderApproval> consumerOrderApprovalCreateList=new ArrayList<ConsumerOrderApproval>();
		List<ConsumerOrderApproval> consumerOrderApprovalUpdateList=new ArrayList<ConsumerOrderApproval>();
		
		for(ConsumerOrderApproval consumerOrderApproval: consumerOrderApprovalList){
			if(isUpdateRequest(consumerOrderApproval)){
				consumerOrderApprovalUpdateList.add( consumerOrderApproval);
				continue;
			}
			consumerOrderApprovalCreateList.add(consumerOrderApproval);
		}
		
		return new Object[]{consumerOrderApprovalCreateList,consumerOrderApprovalUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderApproval consumerOrderApproval){
 		return consumerOrderApproval.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderApprovalSQL(ConsumerOrderApproval consumerOrderApproval){
 		if(isUpdateRequest(consumerOrderApproval)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderApprovalParameters(ConsumerOrderApproval consumerOrderApproval){
 		if(isUpdateRequest(consumerOrderApproval) ){
 			return prepareConsumerOrderApprovalUpdateParameters(consumerOrderApproval);
 		}
 		return prepareConsumerOrderApprovalCreateParameters(consumerOrderApproval);
 	}
 	protected Object[] prepareConsumerOrderApprovalUpdateParameters(ConsumerOrderApproval consumerOrderApproval){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = consumerOrderApproval.getWho();
 		parameters[1] = consumerOrderApproval.getApproveTime();		
 		parameters[2] = consumerOrderApproval.getId();
 		parameters[3] = consumerOrderApproval.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderApprovalCreateParameters(ConsumerOrderApproval consumerOrderApproval){
		Object[] parameters = new Object[3];
		String newConsumerOrderApprovalId=getNextId();
		consumerOrderApproval.setId(newConsumerOrderApprovalId);
		parameters[0] =  consumerOrderApproval.getId();
 
 		parameters[1] = consumerOrderApproval.getWho();
 		parameters[2] = consumerOrderApproval.getApproveTime();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderApproval saveInternalConsumerOrderApproval(ConsumerOrderApproval consumerOrderApproval, Map<String,Object> options){
		
		saveConsumerOrderApproval(consumerOrderApproval);

		
		return consumerOrderApproval;
		
	}
	
	
	
	//======================================================================================
	
		

	public ConsumerOrderApproval present(ConsumerOrderApproval consumerOrderApproval,Map<String, Object> options){
	

		return consumerOrderApproval;
	
	}
		


	protected String getTableName(){
		return ConsumerOrderApprovalTable.TABLE_NAME;
	}
}


