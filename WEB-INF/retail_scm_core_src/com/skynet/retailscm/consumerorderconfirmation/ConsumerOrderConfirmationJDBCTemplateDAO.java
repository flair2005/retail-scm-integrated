
package com.skynet.retailscm.consumerorderconfirmation;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;




import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderConfirmationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderConfirmationDAO{

		

	
	/*
	protected ConsumerOrderConfirmation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderConfirmation(accessKey, options);
	}
	*/
	public ConsumerOrderConfirmation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderConfirmation(ConsumerOrderConfirmationTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderConfirmation save(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderConfirmation, methodName, "consumerOrderConfirmation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderConfirmation(consumerOrderConfirmation,options);
	}
	public ConsumerOrderConfirmation clone(String consumerOrderConfirmationId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderConfirmationTable.withId(consumerOrderConfirmationId),options);
	}
	
	protected ConsumerOrderConfirmation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderConfirmationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderConfirmation newConsumerOrderConfirmation = loadInternalConsumerOrderConfirmation(accessKey, options);
		newConsumerOrderConfirmation.setVersion(0);
		
		

		
		saveInternalConsumerOrderConfirmation(newConsumerOrderConfirmation,options);
		
		return newConsumerOrderConfirmation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderConfirmationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderConfirmationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderConfirmationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderConfirmationNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderConfirmationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderConfirmationId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderConfirmationId, int version)";
		assertMethodArgumentNotNull(consumerOrderConfirmationId, methodName, "consumerOrderConfirmationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderConfirmationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderConfirmationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","confirm_time"};
		return ConsumerOrderConfirmationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_confirmation";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderConfirmationTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ConsumerOrderConfirmationMapper getConsumerOrderConfirmationMapper(){
		return new ConsumerOrderConfirmationMapper();
	}
	protected ConsumerOrderConfirmation extractConsumerOrderConfirmation(String consumerOrderConfirmationId) throws Exception{
		String SQL = "select * from consumer_order_confirmation_data where id = ?";	
		try{
		
			ConsumerOrderConfirmation consumerOrderConfirmation = queryForObject(SQL, new Object[]{consumerOrderConfirmationId}, getConsumerOrderConfirmationMapper());
			return consumerOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderConfirmationNotFoundException("ConsumerOrderConfirmation("+consumerOrderConfirmationId+") is not found!");
		}
		
		
	}
	protected ConsumerOrderConfirmation extractConsumerOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_confirmation_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrderConfirmation consumerOrderConfirmation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderConfirmationMapper());
			return consumerOrderConfirmation;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderConfirmationNotFoundException("ConsumerOrderConfirmation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrderConfirmation loadInternalConsumerOrderConfirmation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderConfirmation consumerOrderConfirmation = extractConsumerOrderConfirmation(accessKey, loadOptions);

		
		return consumerOrderConfirmation;
		
	}



	
	
	
		
		
 	
		
		
		

	

	protected ConsumerOrderConfirmation saveConsumerOrderConfirmation(ConsumerOrderConfirmation  consumerOrderConfirmation){
	
		String SQL=this.getSaveConsumerOrderConfirmationSQL(consumerOrderConfirmation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderConfirmationParameters(consumerOrderConfirmation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderConfirmation.incVersion();
		return consumerOrderConfirmation;
	
	}
	public SmartList<ConsumerOrderConfirmation> saveConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderConfirmationList(consumerOrderConfirmationList);
		
		batchConsumerOrderConfirmationCreate((List<ConsumerOrderConfirmation>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderConfirmationUpdate((List<ConsumerOrderConfirmation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderConfirmation consumerOrderConfirmation:consumerOrderConfirmationList){
			if(consumerOrderConfirmation.isChanged()){
				consumerOrderConfirmation.incVersion();
			}
			
		
		}
		
		
		return consumerOrderConfirmationList;
	}

	public SmartList<ConsumerOrderConfirmation> removeConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderConfirmationList, options);
		
		return consumerOrderConfirmationList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderConfirmationBatchCreateArgs(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderConfirmation consumerOrderConfirmation:consumerOrderConfirmationList ){
			Object [] parameters = prepareConsumerOrderConfirmationCreateParameters(consumerOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderConfirmationBatchUpdateArgs(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderConfirmation consumerOrderConfirmation:consumerOrderConfirmationList ){
			if(!consumerOrderConfirmation.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderConfirmationUpdateParameters(consumerOrderConfirmation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderConfirmationCreate(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderConfirmationBatchCreateArgs(consumerOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderConfirmationUpdate(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderConfirmationBatchUpdateArgs(consumerOrderConfirmationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderConfirmationList(List<ConsumerOrderConfirmation> consumerOrderConfirmationList){
		
		List<ConsumerOrderConfirmation> consumerOrderConfirmationCreateList=new ArrayList<ConsumerOrderConfirmation>();
		List<ConsumerOrderConfirmation> consumerOrderConfirmationUpdateList=new ArrayList<ConsumerOrderConfirmation>();
		
		for(ConsumerOrderConfirmation consumerOrderConfirmation: consumerOrderConfirmationList){
			if(isUpdateRequest(consumerOrderConfirmation)){
				consumerOrderConfirmationUpdateList.add( consumerOrderConfirmation);
				continue;
			}
			consumerOrderConfirmationCreateList.add(consumerOrderConfirmation);
		}
		
		return new Object[]{consumerOrderConfirmationCreateList,consumerOrderConfirmationUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderConfirmation consumerOrderConfirmation){
 		return consumerOrderConfirmation.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderConfirmationSQL(ConsumerOrderConfirmation consumerOrderConfirmation){
 		if(isUpdateRequest(consumerOrderConfirmation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderConfirmationParameters(ConsumerOrderConfirmation consumerOrderConfirmation){
 		if(isUpdateRequest(consumerOrderConfirmation) ){
 			return prepareConsumerOrderConfirmationUpdateParameters(consumerOrderConfirmation);
 		}
 		return prepareConsumerOrderConfirmationCreateParameters(consumerOrderConfirmation);
 	}
 	protected Object[] prepareConsumerOrderConfirmationUpdateParameters(ConsumerOrderConfirmation consumerOrderConfirmation){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = consumerOrderConfirmation.getWho();
 		parameters[1] = consumerOrderConfirmation.getConfirmTime();		
 		parameters[2] = consumerOrderConfirmation.getId();
 		parameters[3] = consumerOrderConfirmation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderConfirmationCreateParameters(ConsumerOrderConfirmation consumerOrderConfirmation){
		Object[] parameters = new Object[3];
		String newConsumerOrderConfirmationId=getNextId();
		consumerOrderConfirmation.setId(newConsumerOrderConfirmationId);
		parameters[0] =  consumerOrderConfirmation.getId();
 
 		parameters[1] = consumerOrderConfirmation.getWho();
 		parameters[2] = consumerOrderConfirmation.getConfirmTime();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderConfirmation saveInternalConsumerOrderConfirmation(ConsumerOrderConfirmation consumerOrderConfirmation, Map<String,Object> options){
		
		saveConsumerOrderConfirmation(consumerOrderConfirmation);

		
		return consumerOrderConfirmation;
		
	}
	
	
	
	//======================================================================================
	
		

	public ConsumerOrderConfirmation present(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String, Object> options){
	

		return consumerOrderConfirmation;
	
	}
		


	protected String getTableName(){
		return ConsumerOrderConfirmationTable.TABLE_NAME;
	}
}


