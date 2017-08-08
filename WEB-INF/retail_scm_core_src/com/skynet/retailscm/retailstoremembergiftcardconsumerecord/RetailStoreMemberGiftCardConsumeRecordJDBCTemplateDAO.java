
package com.skynet.retailscm.retailstoremembergiftcardconsumerecord;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

import com.skynet.retailscm.consumerorder.ConsumerOrderDAO;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;

import com.skynet.retailscm.consumerorder.ConsumerOrderTable;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreMemberGiftCardConsumeRecordJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreMemberGiftCardConsumeRecordDAO{
 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}
 
 	
 	private  RetailStoreMemberGiftCardDAO  retailStoreMemberGiftCardDAO;
 	public void setRetailStoreMemberGiftCardDAO(RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDAO){
	 	this.retailStoreMemberGiftCardDAO = retailStoreMemberGiftCardDAO;
 	}
 	public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO(){
	 	return this.retailStoreMemberGiftCardDAO;
 	}

		

	
	/*
	protected RetailStoreMemberGiftCardConsumeRecord load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberGiftCardConsumeRecord(accessKey, options);
	}
	*/
	public RetailStoreMemberGiftCardConsumeRecord load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecordTable.withId(id), options);
	}
	
	
	
	public RetailStoreMemberGiftCardConsumeRecord save(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object> options){
		
		String methodName="save(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreMemberGiftCardConsumeRecord, methodName, "retailStoreMemberGiftCardConsumeRecord");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord,options);
	}
	public RetailStoreMemberGiftCardConsumeRecord clone(String retailStoreMemberGiftCardConsumeRecordId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreMemberGiftCardConsumeRecordTable.withId(retailStoreMemberGiftCardConsumeRecordId),options);
	}
	
	protected RetailStoreMemberGiftCardConsumeRecord clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreMemberGiftCardConsumeRecordId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord = loadInternalRetailStoreMemberGiftCardConsumeRecord(accessKey, options);
		newRetailStoreMemberGiftCardConsumeRecord.setVersion(0);
		
		

		
		saveInternalRetailStoreMemberGiftCardConsumeRecord(newRetailStoreMemberGiftCardConsumeRecord,options);
		
		return newRetailStoreMemberGiftCardConsumeRecord;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreMemberGiftCardConsumeRecordId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreMemberGiftCardConsumeRecordVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberGiftCardConsumeRecordNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberGiftCardConsumeRecordId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception{
	
		String methodName="delete(String retailStoreMemberGiftCardConsumeRecordId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberGiftCardConsumeRecordId, methodName, "retailStoreMemberGiftCardConsumeRecordId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberGiftCardConsumeRecordId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberGiftCardConsumeRecordId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"occure_time","owner","biz_order","number","amount"};
		return RetailStoreMemberGiftCardConsumeRecordTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_member_gift_card_consume_record";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreMemberGiftCardConsumeRecordTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.OWNER);
 	}
 	

 	
  
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberGiftCardConsumeRecordTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected RetailStoreMemberGiftCardConsumeRecordMapper getRetailStoreMemberGiftCardConsumeRecordMapper(){
		return new RetailStoreMemberGiftCardConsumeRecordMapper();
	}
	protected RetailStoreMemberGiftCardConsumeRecord extractRetailStoreMemberGiftCardConsumeRecord(String retailStoreMemberGiftCardConsumeRecordId) throws Exception{
		String SQL = "select * from retail_store_member_gift_card_consume_record_data where id = ?";	
		try{
		
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = queryForObject(SQL, new Object[]{retailStoreMemberGiftCardConsumeRecordId}, getRetailStoreMemberGiftCardConsumeRecordMapper());
			return retailStoreMemberGiftCardConsumeRecord;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberGiftCardConsumeRecordNotFoundException("RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecordId+") is not found!");
		}
		
		
	}
	protected RetailStoreMemberGiftCardConsumeRecord extractRetailStoreMemberGiftCardConsumeRecord(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_member_gift_card_consume_record_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreMemberGiftCardConsumeRecordMapper());
			return retailStoreMemberGiftCardConsumeRecord;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberGiftCardConsumeRecordNotFoundException("RetailStoreMemberGiftCardConsumeRecord("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreMemberGiftCardConsumeRecord loadInternalRetailStoreMemberGiftCardConsumeRecord(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = extractRetailStoreMemberGiftCardConsumeRecord(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMemberGiftCardConsumeRecord, loadOptions);
 		}
  	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(retailStoreMemberGiftCardConsumeRecord, loadOptions);
 		}
 
		
		return retailStoreMemberGiftCardConsumeRecord;
		
	}



	
	
	 

 	protected RetailStoreMemberGiftCardConsumeRecord extractOwner(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object> options) throws Exception{

		if(retailStoreMemberGiftCardConsumeRecord.getOwner() == null){
			return retailStoreMemberGiftCardConsumeRecord;
		}
		String ownerId = retailStoreMemberGiftCardConsumeRecord.getOwner().getId();
		if( ownerId == null){
			return retailStoreMemberGiftCardConsumeRecord;
		}
		RetailStoreMemberGiftCard owner = getRetailStoreMemberGiftCardDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMemberGiftCardConsumeRecord.setOwner(owner);
		}
		
 		
 		return retailStoreMemberGiftCardConsumeRecord;
 	}
 		
  

 	protected RetailStoreMemberGiftCardConsumeRecord extractBizOrder(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object> options) throws Exception{

		if(retailStoreMemberGiftCardConsumeRecord.getBizOrder() == null){
			return retailStoreMemberGiftCardConsumeRecord;
		}
		String bizOrderId = retailStoreMemberGiftCardConsumeRecord.getBizOrder().getId();
		if( bizOrderId == null){
			return retailStoreMemberGiftCardConsumeRecord;
		}
		ConsumerOrder bizOrder = getConsumerOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);
		}
		
 		
 		return retailStoreMemberGiftCardConsumeRecord;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = queryForList(SQL, new Object[]{retailStoreMemberGiftCardId}, getRetailStoreMemberGiftCardConsumeRecordMapper());	
 		return retailStoreMemberGiftCardConsumeRecordList;
 	}
 	
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = queryForList(SQL, new Object[]{retailStoreMemberGiftCardId,start, count}, getRetailStoreMemberGiftCardConsumeRecordMapper());
		
 		return retailStoreMemberGiftCardConsumeRecordList;
 	}
 	
 	public int countRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberGiftCardId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = queryForList(SQL, new Object[]{consumerOrderId}, getRetailStoreMemberGiftCardConsumeRecordMapper());	
 		return retailStoreMemberGiftCardConsumeRecordList;
 	}
 	
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = queryForList(SQL, new Object[]{consumerOrderId,start, count}, getRetailStoreMemberGiftCardConsumeRecordMapper());
		
 		return retailStoreMemberGiftCardConsumeRecordList;
 	}
 	
 	public int countRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{consumerOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord  retailStoreMemberGiftCardConsumeRecord){
	
		String SQL=this.getSaveRetailStoreMemberGiftCardConsumeRecordSQL(retailStoreMemberGiftCardConsumeRecord);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberGiftCardConsumeRecordParameters(retailStoreMemberGiftCardConsumeRecord);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreMemberGiftCardConsumeRecord.incVersion();
		return retailStoreMemberGiftCardConsumeRecord;
	
	}
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> saveRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList);
		
		batchRetailStoreMemberGiftCardConsumeRecordCreate((List<RetailStoreMemberGiftCardConsumeRecord>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreMemberGiftCardConsumeRecordUpdate((List<RetailStoreMemberGiftCardConsumeRecord>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			if(retailStoreMemberGiftCardConsumeRecord.isChanged()){
				retailStoreMemberGiftCardConsumeRecord.incVersion();
			}
			
		
		}
		
		
		return retailStoreMemberGiftCardConsumeRecordList;
	}

	public SmartList<RetailStoreMemberGiftCardConsumeRecord> removeRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,Map<String,Object> options){
		
		
		super.removeList(retailStoreMemberGiftCardConsumeRecordList, options);
		
		return retailStoreMemberGiftCardConsumeRecordList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreMemberGiftCardConsumeRecordBatchCreateArgs(List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList ){
			Object [] parameters = prepareRetailStoreMemberGiftCardConsumeRecordCreateParameters(retailStoreMemberGiftCardConsumeRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreMemberGiftCardConsumeRecordBatchUpdateArgs(List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList ){
			if(!retailStoreMemberGiftCardConsumeRecord.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberGiftCardConsumeRecordUpdateParameters(retailStoreMemberGiftCardConsumeRecord);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreMemberGiftCardConsumeRecordCreate(List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberGiftCardConsumeRecordBatchCreateArgs(retailStoreMemberGiftCardConsumeRecordList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreMemberGiftCardConsumeRecordUpdate(List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberGiftCardConsumeRecordBatchUpdateArgs(retailStoreMemberGiftCardConsumeRecordList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreMemberGiftCardConsumeRecordList(List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		
		List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordCreateList=new ArrayList<RetailStoreMemberGiftCardConsumeRecord>();
		List<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordUpdateList=new ArrayList<RetailStoreMemberGiftCardConsumeRecord>();
		
		for(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord: retailStoreMemberGiftCardConsumeRecordList){
			if(isUpdateRequest(retailStoreMemberGiftCardConsumeRecord)){
				retailStoreMemberGiftCardConsumeRecordUpdateList.add( retailStoreMemberGiftCardConsumeRecord);
				continue;
			}
			retailStoreMemberGiftCardConsumeRecordCreateList.add(retailStoreMemberGiftCardConsumeRecord);
		}
		
		return new Object[]{retailStoreMemberGiftCardConsumeRecordCreateList,retailStoreMemberGiftCardConsumeRecordUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
 		return retailStoreMemberGiftCardConsumeRecord.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberGiftCardConsumeRecordSQL(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
 		if(isUpdateRequest(retailStoreMemberGiftCardConsumeRecord)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreMemberGiftCardConsumeRecordParameters(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
 		if(isUpdateRequest(retailStoreMemberGiftCardConsumeRecord) ){
 			return prepareRetailStoreMemberGiftCardConsumeRecordUpdateParameters(retailStoreMemberGiftCardConsumeRecord);
 		}
 		return prepareRetailStoreMemberGiftCardConsumeRecordCreateParameters(retailStoreMemberGiftCardConsumeRecord);
 	}
 	protected Object[] prepareRetailStoreMemberGiftCardConsumeRecordUpdateParameters(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = retailStoreMemberGiftCardConsumeRecord.getOccureTime(); 	
 		if(retailStoreMemberGiftCardConsumeRecord.getOwner() != null){
 			parameters[1] = retailStoreMemberGiftCardConsumeRecord.getOwner().getId();
 		}
  	
 		if(retailStoreMemberGiftCardConsumeRecord.getBizOrder() != null){
 			parameters[2] = retailStoreMemberGiftCardConsumeRecord.getBizOrder().getId();
 		}
 
 		parameters[3] = retailStoreMemberGiftCardConsumeRecord.getNumber();
 		parameters[4] = retailStoreMemberGiftCardConsumeRecord.getAmount();		
 		parameters[5] = retailStoreMemberGiftCardConsumeRecord.getId();
 		parameters[6] = retailStoreMemberGiftCardConsumeRecord.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberGiftCardConsumeRecordCreateParameters(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		Object[] parameters = new Object[6];
		String newRetailStoreMemberGiftCardConsumeRecordId=getNextId();
		retailStoreMemberGiftCardConsumeRecord.setId(newRetailStoreMemberGiftCardConsumeRecordId);
		parameters[0] =  retailStoreMemberGiftCardConsumeRecord.getId();
 
 		parameters[1] = retailStoreMemberGiftCardConsumeRecord.getOccureTime(); 	
 		if(retailStoreMemberGiftCardConsumeRecord.getOwner() != null){
 			parameters[2] = retailStoreMemberGiftCardConsumeRecord.getOwner().getId();
 		
 		}
 		 	
 		if(retailStoreMemberGiftCardConsumeRecord.getBizOrder() != null){
 			parameters[3] = retailStoreMemberGiftCardConsumeRecord.getBizOrder().getId();
 		
 		}
 		
 		parameters[4] = retailStoreMemberGiftCardConsumeRecord.getNumber();
 		parameters[5] = retailStoreMemberGiftCardConsumeRecord.getAmount();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreMemberGiftCardConsumeRecord saveInternalRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object> options){
		
		saveRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMemberGiftCardConsumeRecord, options);
 		}
  	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(retailStoreMemberGiftCardConsumeRecord, options);
 		}
 
		
		return retailStoreMemberGiftCardConsumeRecord;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreMemberGiftCardConsumeRecord saveOwner(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMemberGiftCardConsumeRecord.getOwner() == null){
 			return retailStoreMemberGiftCardConsumeRecord;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberGiftCardDAO().save(retailStoreMemberGiftCardConsumeRecord.getOwner(),options);
 		return retailStoreMemberGiftCardConsumeRecord;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreMemberGiftCardConsumeRecord saveBizOrder(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMemberGiftCardConsumeRecord.getBizOrder() == null){
 			return retailStoreMemberGiftCardConsumeRecord;//do nothing when it is null
 		}
 		
 		getConsumerOrderDAO().save(retailStoreMemberGiftCardConsumeRecord.getBizOrder(),options);
 		return retailStoreMemberGiftCardConsumeRecord;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public RetailStoreMemberGiftCardConsumeRecord present(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String, Object> options){
	

		return retailStoreMemberGiftCardConsumeRecord;
	
	}
		


	protected String getTableName(){
		return RetailStoreMemberGiftCardConsumeRecordTable.TABLE_NAME;
	}
}


