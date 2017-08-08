
package com.skynet.retailscm.consumerorderpriceadjustment;

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

public class ConsumerOrderPriceAdjustmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderPriceAdjustmentDAO{
 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}

		

	
	/*
	protected ConsumerOrderPriceAdjustment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderPriceAdjustment(accessKey, options);
	}
	*/
	public ConsumerOrderPriceAdjustment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustmentTable.withId(id), options);
	}
	
	
	
	public ConsumerOrderPriceAdjustment save(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options){
		
		String methodName="save(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrderPriceAdjustment, methodName, "consumerOrderPriceAdjustment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment,options);
	}
	public ConsumerOrderPriceAdjustment clone(String consumerOrderPriceAdjustmentId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderPriceAdjustmentTable.withId(consumerOrderPriceAdjustmentId),options);
	}
	
	protected ConsumerOrderPriceAdjustment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderPriceAdjustmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrderPriceAdjustment newConsumerOrderPriceAdjustment = loadInternalConsumerOrderPriceAdjustment(accessKey, options);
		newConsumerOrderPriceAdjustment.setVersion(0);
		
		

		
		saveInternalConsumerOrderPriceAdjustment(newConsumerOrderPriceAdjustment,options);
		
		return newConsumerOrderPriceAdjustment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderPriceAdjustmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderPriceAdjustmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderPriceAdjustmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderPriceAdjustmentNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderPriceAdjustmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderPriceAdjustmentId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderPriceAdjustmentId, int version)";
		assertMethodArgumentNotNull(consumerOrderPriceAdjustmentId, methodName, "consumerOrderPriceAdjustmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderPriceAdjustmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderPriceAdjustmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","biz_order","amount","provider"};
		return ConsumerOrderPriceAdjustmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order_price_adjustment";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderPriceAdjustmentTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderPriceAdjustmentTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderPriceAdjustmentTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected ConsumerOrderPriceAdjustmentMapper getConsumerOrderPriceAdjustmentMapper(){
		return new ConsumerOrderPriceAdjustmentMapper();
	}
	protected ConsumerOrderPriceAdjustment extractConsumerOrderPriceAdjustment(String consumerOrderPriceAdjustmentId) throws Exception{
		String SQL = "select * from consumer_order_price_adjustment_data where id = ?";	
		try{
		
			ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = queryForObject(SQL, new Object[]{consumerOrderPriceAdjustmentId}, getConsumerOrderPriceAdjustmentMapper());
			return consumerOrderPriceAdjustment;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderPriceAdjustmentNotFoundException("ConsumerOrderPriceAdjustment("+consumerOrderPriceAdjustmentId+") is not found!");
		}
		
		
	}
	protected ConsumerOrderPriceAdjustment extractConsumerOrderPriceAdjustment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_price_adjustment_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderPriceAdjustmentMapper());
			return consumerOrderPriceAdjustment;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderPriceAdjustmentNotFoundException("ConsumerOrderPriceAdjustment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrderPriceAdjustment loadInternalConsumerOrderPriceAdjustment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = extractConsumerOrderPriceAdjustment(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(consumerOrderPriceAdjustment, loadOptions);
 		}
 
		
		return consumerOrderPriceAdjustment;
		
	}



	
	
	 

 	protected ConsumerOrderPriceAdjustment extractBizOrder(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options) throws Exception{

		if(consumerOrderPriceAdjustment.getBizOrder() == null){
			return consumerOrderPriceAdjustment;
		}
		String bizOrderId = consumerOrderPriceAdjustment.getBizOrder().getId();
		if( bizOrderId == null){
			return consumerOrderPriceAdjustment;
		}
		ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			consumerOrderPriceAdjustment.setBizOrder(bizOrder);
		}
		
 		
 		return consumerOrderPriceAdjustment;
 	}
 		
 
		
		
  	
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = queryForList(SQL, new Object[]{consumerOrderId}, getConsumerOrderPriceAdjustmentMapper());	
 		return consumerOrderPriceAdjustmentList;
 	}
 	
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = queryForList(SQL, new Object[]{consumerOrderId,start, count}, getConsumerOrderPriceAdjustmentMapper());
		
 		return consumerOrderPriceAdjustmentList;
 	}
 	
 	public int countConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{consumerOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ConsumerOrderPriceAdjustment saveConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment  consumerOrderPriceAdjustment){
	
		String SQL=this.getSaveConsumerOrderPriceAdjustmentSQL(consumerOrderPriceAdjustment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderPriceAdjustmentParameters(consumerOrderPriceAdjustment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrderPriceAdjustment.incVersion();
		return consumerOrderPriceAdjustment;
	
	}
	public SmartList<ConsumerOrderPriceAdjustment> saveConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList);
		
		batchConsumerOrderPriceAdjustmentCreate((List<ConsumerOrderPriceAdjustment>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderPriceAdjustmentUpdate((List<ConsumerOrderPriceAdjustment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			if(consumerOrderPriceAdjustment.isChanged()){
				consumerOrderPriceAdjustment.incVersion();
			}
			
		
		}
		
		
		return consumerOrderPriceAdjustmentList;
	}

	public SmartList<ConsumerOrderPriceAdjustment> removeConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderPriceAdjustmentList, options);
		
		return consumerOrderPriceAdjustmentList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderPriceAdjustmentBatchCreateArgs(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList ){
			Object [] parameters = prepareConsumerOrderPriceAdjustmentCreateParameters(consumerOrderPriceAdjustment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderPriceAdjustmentBatchUpdateArgs(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList ){
			if(!consumerOrderPriceAdjustment.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderPriceAdjustmentUpdateParameters(consumerOrderPriceAdjustment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderPriceAdjustmentCreate(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderPriceAdjustmentBatchCreateArgs(consumerOrderPriceAdjustmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderPriceAdjustmentUpdate(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderPriceAdjustmentBatchUpdateArgs(consumerOrderPriceAdjustmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderPriceAdjustmentList(List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		
		List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentCreateList=new ArrayList<ConsumerOrderPriceAdjustment>();
		List<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentUpdateList=new ArrayList<ConsumerOrderPriceAdjustment>();
		
		for(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment: consumerOrderPriceAdjustmentList){
			if(isUpdateRequest(consumerOrderPriceAdjustment)){
				consumerOrderPriceAdjustmentUpdateList.add( consumerOrderPriceAdjustment);
				continue;
			}
			consumerOrderPriceAdjustmentCreateList.add(consumerOrderPriceAdjustment);
		}
		
		return new Object[]{consumerOrderPriceAdjustmentCreateList,consumerOrderPriceAdjustmentUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		return consumerOrderPriceAdjustment.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderPriceAdjustmentSQL(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		if(isUpdateRequest(consumerOrderPriceAdjustment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderPriceAdjustmentParameters(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		if(isUpdateRequest(consumerOrderPriceAdjustment) ){
 			return prepareConsumerOrderPriceAdjustmentUpdateParameters(consumerOrderPriceAdjustment);
 		}
 		return prepareConsumerOrderPriceAdjustmentCreateParameters(consumerOrderPriceAdjustment);
 	}
 	protected Object[] prepareConsumerOrderPriceAdjustmentUpdateParameters(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = consumerOrderPriceAdjustment.getName(); 	
 		if(consumerOrderPriceAdjustment.getBizOrder() != null){
 			parameters[1] = consumerOrderPriceAdjustment.getBizOrder().getId();
 		}
 
 		parameters[2] = consumerOrderPriceAdjustment.getAmount();
 		parameters[3] = consumerOrderPriceAdjustment.getProvider();		
 		parameters[4] = consumerOrderPriceAdjustment.getId();
 		parameters[5] = consumerOrderPriceAdjustment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderPriceAdjustmentCreateParameters(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
		Object[] parameters = new Object[5];
		String newConsumerOrderPriceAdjustmentId=getNextId();
		consumerOrderPriceAdjustment.setId(newConsumerOrderPriceAdjustmentId);
		parameters[0] =  consumerOrderPriceAdjustment.getId();
 
 		parameters[1] = consumerOrderPriceAdjustment.getName(); 	
 		if(consumerOrderPriceAdjustment.getBizOrder() != null){
 			parameters[2] = consumerOrderPriceAdjustment.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = consumerOrderPriceAdjustment.getAmount();
 		parameters[4] = consumerOrderPriceAdjustment.getProvider();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrderPriceAdjustment saveInternalConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options){
		
		saveConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(consumerOrderPriceAdjustment, options);
 		}
 
		
		return consumerOrderPriceAdjustment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ConsumerOrderPriceAdjustment saveBizOrder(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrderPriceAdjustment.getBizOrder() == null){
 			return consumerOrderPriceAdjustment;//do nothing when it is null
 		}
 		
 		getConsumerOrderDAO().save(consumerOrderPriceAdjustment.getBizOrder(),options);
 		return consumerOrderPriceAdjustment;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public ConsumerOrderPriceAdjustment present(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String, Object> options){
	

		return consumerOrderPriceAdjustment;
	
	}
		


	protected String getTableName(){
		return ConsumerOrderPriceAdjustmentTable.TABLE_NAME;
	}
}


