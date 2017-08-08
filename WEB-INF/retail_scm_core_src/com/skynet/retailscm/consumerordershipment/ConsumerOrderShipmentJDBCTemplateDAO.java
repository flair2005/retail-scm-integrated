
package com.skynet.retailscm.consumerordershipment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;




import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderShipmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderShipmentDAO{

		

	
	/*
	protected ConsumerOrderShipment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShipment(accessKey, options);
	}
	*/
	public ConsumerOrderShipment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderShipment(ConsumerOrderShipmentTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderShipment save(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderShipment, methodName, "consumerOrderShipment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderShipment(consumerOrderShipment,options);
	}
	public ConsumerOrderShipment clone(String consumerOrderShipmentId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderShipmentTable.withId(consumerOrderShipmentId),options);
	}
	
	protected ConsumerOrderShipment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderShipmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderShipment newConsumerOrderShipment = loadInternalConsumerOrderShipment(accessKey, options);
		newConsumerOrderShipment.setVersion(0);
		
		

		
		saveInternalConsumerOrderShipment(newConsumerOrderShipment,options);
		
		return newConsumerOrderShipment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderShipmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderShipmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderShipmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderShipmentNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderShipmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderShipmentId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderShipmentId, int version)";
		assertMethodArgumentNotNull(consumerOrderShipmentId, methodName, "consumerOrderShipmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderShipmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderShipmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","ship_time"};
		return ConsumerOrderShipmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_shipment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderShipmentTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ConsumerOrderShipmentMapper getConsumerOrderShipmentMapper(){
		return new ConsumerOrderShipmentMapper();
	}
	protected ConsumerOrderShipment extractConsumerOrderShipment(String consumerOrderShipmentId) throws Exception{
		String SQL = "select * from consumer_order_shipment_data where id = ?";	
		try{
		
			ConsumerOrderShipment consumerOrderShipment = queryForObject(SQL, new Object[]{consumerOrderShipmentId}, getConsumerOrderShipmentMapper());
			return consumerOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderShipmentNotFoundException("ConsumerOrderShipment("+consumerOrderShipmentId+") is not found!");
		}
		
		
	}
	protected ConsumerOrderShipment extractConsumerOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_shipment_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrderShipment consumerOrderShipment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderShipmentMapper());
			return consumerOrderShipment;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderShipmentNotFoundException("ConsumerOrderShipment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrderShipment loadInternalConsumerOrderShipment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderShipment consumerOrderShipment = extractConsumerOrderShipment(accessKey, loadOptions);

		
		return consumerOrderShipment;
		
	}



	
	
	
		
		
 	
		
		
		

	

	protected ConsumerOrderShipment saveConsumerOrderShipment(ConsumerOrderShipment  consumerOrderShipment){
	
		String SQL=this.getSaveConsumerOrderShipmentSQL(consumerOrderShipment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderShipmentParameters(consumerOrderShipment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderShipment.incVersion();
		return consumerOrderShipment;
	
	}
	public SmartList<ConsumerOrderShipment> saveConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderShipmentList(consumerOrderShipmentList);
		
		batchConsumerOrderShipmentCreate((List<ConsumerOrderShipment>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderShipmentUpdate((List<ConsumerOrderShipment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderShipment consumerOrderShipment:consumerOrderShipmentList){
			if(consumerOrderShipment.isChanged()){
				consumerOrderShipment.incVersion();
			}
			
		
		}
		
		
		return consumerOrderShipmentList;
	}

	public SmartList<ConsumerOrderShipment> removeConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderShipmentList, options);
		
		return consumerOrderShipmentList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderShipmentBatchCreateArgs(List<ConsumerOrderShipment> consumerOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShipment consumerOrderShipment:consumerOrderShipmentList ){
			Object [] parameters = prepareConsumerOrderShipmentCreateParameters(consumerOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderShipmentBatchUpdateArgs(List<ConsumerOrderShipment> consumerOrderShipmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderShipment consumerOrderShipment:consumerOrderShipmentList ){
			if(!consumerOrderShipment.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderShipmentUpdateParameters(consumerOrderShipment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderShipmentCreate(List<ConsumerOrderShipment> consumerOrderShipmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderShipmentBatchCreateArgs(consumerOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderShipmentUpdate(List<ConsumerOrderShipment> consumerOrderShipmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderShipmentBatchUpdateArgs(consumerOrderShipmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderShipmentList(List<ConsumerOrderShipment> consumerOrderShipmentList){
		
		List<ConsumerOrderShipment> consumerOrderShipmentCreateList=new ArrayList<ConsumerOrderShipment>();
		List<ConsumerOrderShipment> consumerOrderShipmentUpdateList=new ArrayList<ConsumerOrderShipment>();
		
		for(ConsumerOrderShipment consumerOrderShipment: consumerOrderShipmentList){
			if(isUpdateRequest(consumerOrderShipment)){
				consumerOrderShipmentUpdateList.add( consumerOrderShipment);
				continue;
			}
			consumerOrderShipmentCreateList.add(consumerOrderShipment);
		}
		
		return new Object[]{consumerOrderShipmentCreateList,consumerOrderShipmentUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderShipment consumerOrderShipment){
 		return consumerOrderShipment.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderShipmentSQL(ConsumerOrderShipment consumerOrderShipment){
 		if(isUpdateRequest(consumerOrderShipment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderShipmentParameters(ConsumerOrderShipment consumerOrderShipment){
 		if(isUpdateRequest(consumerOrderShipment) ){
 			return prepareConsumerOrderShipmentUpdateParameters(consumerOrderShipment);
 		}
 		return prepareConsumerOrderShipmentCreateParameters(consumerOrderShipment);
 	}
 	protected Object[] prepareConsumerOrderShipmentUpdateParameters(ConsumerOrderShipment consumerOrderShipment){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = consumerOrderShipment.getWho();
 		parameters[1] = consumerOrderShipment.getShipTime();		
 		parameters[2] = consumerOrderShipment.getId();
 		parameters[3] = consumerOrderShipment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderShipmentCreateParameters(ConsumerOrderShipment consumerOrderShipment){
		Object[] parameters = new Object[3];
		String newConsumerOrderShipmentId=getNextId();
		consumerOrderShipment.setId(newConsumerOrderShipmentId);
		parameters[0] =  consumerOrderShipment.getId();
 
 		parameters[1] = consumerOrderShipment.getWho();
 		parameters[2] = consumerOrderShipment.getShipTime();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderShipment saveInternalConsumerOrderShipment(ConsumerOrderShipment consumerOrderShipment, Map<String,Object> options){
		
		saveConsumerOrderShipment(consumerOrderShipment);

		
		return consumerOrderShipment;
		
	}
	
	
	
	//======================================================================================
	
		

	public ConsumerOrderShipment present(ConsumerOrderShipment consumerOrderShipment,Map<String, Object> options){
	

		return consumerOrderShipment;
	
	}
		


	protected String getTableName(){
		return ConsumerOrderShipmentTable.TABLE_NAME;
	}
}


