
package com.skynet.retailscm.retailstoremembergiftcardconsumerecord;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.consumerorder.ConsumerOrder;

import com.skynet.retailscm.consumerorder.ConsumerOrderDAO;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;



import com.skynet.retailscm.consumerorder.ConsumerOrderTable;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTable;




public class RetailStoreMemberGiftCardConsumeRecordManagerImpl extends RetailScmCheckerManager implements RetailStoreMemberGiftCardConsumeRecordManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMemberGiftCardConsumeRecord";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreMemberGiftCardConsumeRecordDAO  retailStoreMemberGiftCardConsumeRecordDAO;
 	public void setRetailStoreMemberGiftCardConsumeRecordDAO(RetailStoreMemberGiftCardConsumeRecordDAO  retailStoreMemberGiftCardConsumeRecordDAO){
 	
 		if(retailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardConsumeRecordDAO to null.");
 		}
	 	this.retailStoreMemberGiftCardConsumeRecordDAO = retailStoreMemberGiftCardConsumeRecordDAO;
 	}
 	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO(){
 		if(this.retailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("The RetailStoreMemberGiftCardConsumeRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberGiftCardConsumeRecordDAO;
 	}
 	
 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberGiftCardConsumeRecordDAO().save(retailStoreMemberGiftCardConsumeRecord, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	
 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecordDetail(RetailScmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) throws Exception{	

 		
 		return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, allTokens());
 	}
 	
 	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreMemberGiftCardConsumeRecordManagerException exception = new RetailStoreMemberGiftCardConsumeRecordManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	
 	protected RetailStoreMemberGiftCardConsumeRecord present(RetailScmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberGiftCardConsumeRecord,tokens);
		
		
		return this.getRetailStoreMemberGiftCardConsumeRecordDAO().present(retailStoreMemberGiftCardConsumeRecord, tokens);
	}
 
 	
 	
 	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecordDetail(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{	
 		RetailStoreMemberGiftCardConsumeRecordManagerException exception = new RetailStoreMemberGiftCardConsumeRecordManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());

 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{	
 		RetailStoreMemberGiftCardConsumeRecordManagerException exception = new RetailStoreMemberGiftCardConsumeRecordManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());

 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
		
 	}
 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberGiftCardConsumeRecordDAO().save(retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	protected RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberGiftCardConsumeRecordDAO().load(retailStoreMemberGiftCardConsumeRecordId, tokens);
 	}

	



 	 
 	
 	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	//------------------------------------
 	public ConsumerOrderDAO getConsumerOrderDAO(){
	 	return this.consumerOrderDAO;
 	}
 
 	
 	private  RetailStoreMemberGiftCardDAO  retailStoreMemberGiftCardDAO;
 	public void setRetailStoreMemberGiftCardDAO(RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDAO){
	 	this.retailStoreMemberGiftCardDAO = retailStoreMemberGiftCardDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO(){
	 	return this.retailStoreMemberGiftCardDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberGiftCardConsumeRecord, tokens);
		
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@create","createRetailStoreMemberGiftCardConsumeRecord","createRetailStoreMemberGiftCardConsumeRecord/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@update","updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@copy","cloneRetailStoreMemberGiftCardConsumeRecord","cloneRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"retail_store_member_gift_card_consume_record.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"retail_store_member_gift_card_consume_record.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext,Date occureTime, String ownerId, String bizOrderId, String number, double amount
) throws Exception
	{
		
		RetailStoreMemberGiftCardConsumeRecordManagerException exception = new RetailStoreMemberGiftCardConsumeRecordManagerException("Error Occured");

		

		checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(userContext,  occureTime, exception);
		checkNumberOfRetailStoreMemberGiftCardConsumeRecord(userContext,  number, exception);
		checkAmountOfRetailStoreMemberGiftCardConsumeRecord(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord=createNewRetailStoreMemberGiftCardConsumeRecord();	

		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);
		RetailStoreMemberGiftCard owner = loadRetailStoreMemberGiftCard(ownerId,emptyOptions());
		retailStoreMemberGiftCardConsumeRecord.setOwner(owner);
		ConsumerOrder bizOrder = loadConsumerOrder(bizOrderId,emptyOptions());
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);

		return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());
		

		
	}
	protected RetailStoreMemberGiftCardConsumeRecord createNewRetailStoreMemberGiftCardConsumeRecord() 
	{
		
		return new RetailStoreMemberGiftCardConsumeRecord();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreMemberGiftCardConsumeRecordManagerException exception = new RetailStoreMemberGiftCardConsumeRecordManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		checkVersionOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordVersion, exception);
		

		if(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)){
			checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(userContext, parseDate(newValueExpr), exception);
		}		

				

		
		if(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)){
			checkNumberOfRetailStoreMemberGiftCardConsumeRecord(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfRetailStoreMemberGiftCardConsumeRecord(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreMemberGiftCardConsumeRecord clone(RetailScmUserContext userContext, String fromRetailStoreMemberGiftCardConsumeRecordId) throws Exception{
		
		return this.getRetailStoreMemberGiftCardConsumeRecordDAO().clone(fromRetailStoreMemberGiftCardConsumeRecordId, this.allTokens());
	}
	
	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
		if(retailStoreMemberGiftCardConsumeRecord.getVersion() != retailStoreMemberGiftCardConsumeRecordVersion){
			String message = "The target version("+retailStoreMemberGiftCardConsumeRecord.getVersion()+") is not equals to version("+retailStoreMemberGiftCardConsumeRecordVersion+") provided";
			throw new RetailStoreMemberGiftCardConsumeRecordManagerException(message);
		}
		synchronized(retailStoreMemberGiftCardConsumeRecord){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCardConsumeRecord.
			
			retailStoreMemberGiftCardConsumeRecord.changePropery(property, newValueExpr);
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberGiftCardConsumeRecordTokens tokens(){
		return RetailStoreMemberGiftCardConsumeRecordTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberGiftCardConsumeRecordTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberGiftCardConsumeRecordTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId) throws Exception
 	{
 		RetailStoreMemberGiftCardConsumeRecordManagerException exception = new RetailStoreMemberGiftCardConsumeRecordManagerException("Error Occured");
 		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId,exception);
 		checkIdOfRetailStoreMemberGiftCard(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberGiftCardConsumeRecordId,anotherOwnerId);
 
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());	
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMemberGiftCard owner = loadRetailStoreMemberGiftCard(anotherOwnerId, emptyOptions());		
			retailStoreMemberGiftCardConsumeRecord.setOwner(owner);		
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());
			
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId) throws Exception
 	{
 		RetailStoreMemberGiftCardConsumeRecordManagerException exception = new RetailStoreMemberGiftCardConsumeRecordManagerException("Error Occured");
 		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId,exception);
 		checkIdOfConsumerOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreMemberGiftCardConsumeRecordId,anotherBizOrderId);
 
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());	
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(anotherBizOrderId, emptyOptions());		
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);		
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());
			
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected ConsumerOrder loadConsumerOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getConsumerOrderDAO().load(newBizOrderId, options);
 	}
	
	 	
 	protected RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberGiftCardDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception{
		getRetailStoreMemberGiftCardConsumeRecordDAO().delete(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberGiftCardConsumeRecordManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreMemberGiftCardConsumeRecordDAO().deleteAll();
	}


}


