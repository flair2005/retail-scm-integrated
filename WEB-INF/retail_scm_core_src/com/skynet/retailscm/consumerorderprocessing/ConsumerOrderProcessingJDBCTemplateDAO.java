
package com.skynet.retailscm.consumerorderprocessing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;




import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderProcessingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderProcessingDAO{

		

	
	/*
	protected ConsumerOrderProcessing load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderProcessing(accessKey, options);
	}
	*/
	public ConsumerOrderProcessing load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderProcessing(ConsumerOrderProcessingTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderProcessing save(ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderProcessing, methodName, "consumerOrderProcessing");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderProcessing(consumerOrderProcessing,options);
	}
	public ConsumerOrderProcessing clone(String consumerOrderProcessingId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderProcessingTable.withId(consumerOrderProcessingId),options);
	}
	
	protected ConsumerOrderProcessing clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderProcessingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderProcessing newConsumerOrderProcessing = loadInternalConsumerOrderProcessing(accessKey, options);
		newConsumerOrderProcessing.setVersion(0);
		
		

		
		saveInternalConsumerOrderProcessing(newConsumerOrderProcessing,options);
		
		return newConsumerOrderProcessing;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderProcessingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderProcessingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderProcessingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderProcessingNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderProcessingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderProcessingId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderProcessingId, int version)";
		assertMethodArgumentNotNull(consumerOrderProcessingId, methodName, "consumerOrderProcessingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderProcessingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderProcessingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","process_time"};
		return ConsumerOrderProcessingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_processing";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderProcessingTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ConsumerOrderProcessingMapper getConsumerOrderProcessingMapper(){
		return new ConsumerOrderProcessingMapper();
	}
	protected ConsumerOrderProcessing extractConsumerOrderProcessing(String consumerOrderProcessingId) throws Exception{
		String SQL = "select * from consumer_order_processing_data where id = ?";	
		try{
		
			ConsumerOrderProcessing consumerOrderProcessing = queryForObject(SQL, new Object[]{consumerOrderProcessingId}, getConsumerOrderProcessingMapper());
			return consumerOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderProcessingNotFoundException("ConsumerOrderProcessing("+consumerOrderProcessingId+") is not found!");
		}
		
		
	}
	protected ConsumerOrderProcessing extractConsumerOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_processing_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrderProcessing consumerOrderProcessing = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderProcessingMapper());
			return consumerOrderProcessing;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderProcessingNotFoundException("ConsumerOrderProcessing("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrderProcessing loadInternalConsumerOrderProcessing(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderProcessing consumerOrderProcessing = extractConsumerOrderProcessing(accessKey, loadOptions);

		
		return consumerOrderProcessing;
		
	}



	
	
	
		
		
 	
		
		
		

	

	protected ConsumerOrderProcessing saveConsumerOrderProcessing(ConsumerOrderProcessing  consumerOrderProcessing){
	
		String SQL=this.getSaveConsumerOrderProcessingSQL(consumerOrderProcessing);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderProcessingParameters(consumerOrderProcessing);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderProcessing.incVersion();
		return consumerOrderProcessing;
	
	}
	public SmartList<ConsumerOrderProcessing> saveConsumerOrderProcessingList(SmartList<ConsumerOrderProcessing> consumerOrderProcessingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderProcessingList(consumerOrderProcessingList);
		
		batchConsumerOrderProcessingCreate((List<ConsumerOrderProcessing>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderProcessingUpdate((List<ConsumerOrderProcessing>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderProcessing consumerOrderProcessing:consumerOrderProcessingList){
			if(consumerOrderProcessing.isChanged()){
				consumerOrderProcessing.incVersion();
			}
			
		
		}
		
		
		return consumerOrderProcessingList;
	}

	public SmartList<ConsumerOrderProcessing> removeConsumerOrderProcessingList(SmartList<ConsumerOrderProcessing> consumerOrderProcessingList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderProcessingList, options);
		
		return consumerOrderProcessingList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderProcessingBatchCreateArgs(List<ConsumerOrderProcessing> consumerOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderProcessing consumerOrderProcessing:consumerOrderProcessingList ){
			Object [] parameters = prepareConsumerOrderProcessingCreateParameters(consumerOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderProcessingBatchUpdateArgs(List<ConsumerOrderProcessing> consumerOrderProcessingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderProcessing consumerOrderProcessing:consumerOrderProcessingList ){
			if(!consumerOrderProcessing.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderProcessingUpdateParameters(consumerOrderProcessing);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderProcessingCreate(List<ConsumerOrderProcessing> consumerOrderProcessingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderProcessingBatchCreateArgs(consumerOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderProcessingUpdate(List<ConsumerOrderProcessing> consumerOrderProcessingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderProcessingBatchUpdateArgs(consumerOrderProcessingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderProcessingList(List<ConsumerOrderProcessing> consumerOrderProcessingList){
		
		List<ConsumerOrderProcessing> consumerOrderProcessingCreateList=new ArrayList<ConsumerOrderProcessing>();
		List<ConsumerOrderProcessing> consumerOrderProcessingUpdateList=new ArrayList<ConsumerOrderProcessing>();
		
		for(ConsumerOrderProcessing consumerOrderProcessing: consumerOrderProcessingList){
			if(isUpdateRequest(consumerOrderProcessing)){
				consumerOrderProcessingUpdateList.add( consumerOrderProcessing);
				continue;
			}
			consumerOrderProcessingCreateList.add(consumerOrderProcessing);
		}
		
		return new Object[]{consumerOrderProcessingCreateList,consumerOrderProcessingUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderProcessing consumerOrderProcessing){
 		return consumerOrderProcessing.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderProcessingSQL(ConsumerOrderProcessing consumerOrderProcessing){
 		if(isUpdateRequest(consumerOrderProcessing)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderProcessingParameters(ConsumerOrderProcessing consumerOrderProcessing){
 		if(isUpdateRequest(consumerOrderProcessing) ){
 			return prepareConsumerOrderProcessingUpdateParameters(consumerOrderProcessing);
 		}
 		return prepareConsumerOrderProcessingCreateParameters(consumerOrderProcessing);
 	}
 	protected Object[] prepareConsumerOrderProcessingUpdateParameters(ConsumerOrderProcessing consumerOrderProcessing){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = consumerOrderProcessing.getWho();
 		parameters[1] = consumerOrderProcessing.getProcessTime();		
 		parameters[2] = consumerOrderProcessing.getId();
 		parameters[3] = consumerOrderProcessing.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderProcessingCreateParameters(ConsumerOrderProcessing consumerOrderProcessing){
		Object[] parameters = new Object[3];
		String newConsumerOrderProcessingId=getNextId();
		consumerOrderProcessing.setId(newConsumerOrderProcessingId);
		parameters[0] =  consumerOrderProcessing.getId();
 
 		parameters[1] = consumerOrderProcessing.getWho();
 		parameters[2] = consumerOrderProcessing.getProcessTime();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderProcessing saveInternalConsumerOrderProcessing(ConsumerOrderProcessing consumerOrderProcessing, Map<String,Object> options){
		
		saveConsumerOrderProcessing(consumerOrderProcessing);

		
		return consumerOrderProcessing;
		
	}
	
	
	
	//======================================================================================
	
		

	public ConsumerOrderProcessing present(ConsumerOrderProcessing consumerOrderProcessing,Map<String, Object> options){
	

		return consumerOrderProcessing;
	
	}
		


	protected String getTableName(){
		return ConsumerOrderProcessingTable.TABLE_NAME;
	}
}


