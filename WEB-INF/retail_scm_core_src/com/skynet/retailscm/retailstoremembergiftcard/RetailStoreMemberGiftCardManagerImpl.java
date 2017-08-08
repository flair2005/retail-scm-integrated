
package com.skynet.retailscm.retailstoremembergiftcard;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;

import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.consumerorder.ConsumerOrder;


import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTable;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;




public class RetailStoreMemberGiftCardManagerImpl extends RetailScmCheckerManager implements RetailStoreMemberGiftCardManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMemberGiftCard";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreMemberGiftCardDAO  retailStoreMemberGiftCardDAO;
 	public void setRetailStoreMemberGiftCardDAO(RetailStoreMemberGiftCardDAO  retailStoreMemberGiftCardDAO){
 	
 		if(retailStoreMemberGiftCardDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardDAO to null.");
 		}
	 	this.retailStoreMemberGiftCardDAO = retailStoreMemberGiftCardDAO;
 	}
 	public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO(){
 		if(this.retailStoreMemberGiftCardDAO == null){
 			throw new IllegalStateException("The RetailStoreMemberGiftCardDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberGiftCardDAO;
 	}
 	
 	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(RetailScmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberGiftCardDAO().save(retailStoreMemberGiftCard, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens);
 	}
 	
 	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCardDetail(RetailScmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard) throws Exception{	

 		
 		return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, allTokens());
 	}
 	
 	public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCard, tokens);
 	}
 	
 	protected RetailStoreMemberGiftCard present(RetailScmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberGiftCard,tokens);
		
		
		return this.getRetailStoreMemberGiftCardDAO().present(retailStoreMemberGiftCard, tokens);
	}
 
 	
 	
 	public RetailStoreMemberGiftCard loadRetailStoreMemberGiftCardDetail(RetailScmUserContext userContext, String retailStoreMemberGiftCardId) throws Exception{	
 		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, allTokens());

 		return present(userContext,retailStoreMemberGiftCard, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreMemberGiftCardId) throws Exception{	
 		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard( userContext, retailStoreMemberGiftCardId, allTokens());

 		return present(userContext,retailStoreMemberGiftCard, allTokens());
		
 	}
 	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(RetailScmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberGiftCardDAO().save(retailStoreMemberGiftCard, tokens);
 	}
 	protected RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberGiftCardDAO().load(retailStoreMemberGiftCardId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberGiftCard, tokens);
		
		addAction(userContext, retailStoreMemberGiftCard, tokens,"@create","createRetailStoreMemberGiftCard","createRetailStoreMemberGiftCard/","main","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"@update","updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard/"+retailStoreMemberGiftCard.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"@copy","cloneRetailStoreMemberGiftCard","cloneRetailStoreMemberGiftCard/"+retailStoreMemberGiftCard.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberGiftCard.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord","addRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord","removeRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
		addAction(userContext, retailStoreMemberGiftCard, tokens,"retail_store_member_gift_card.copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom","copyRetailStoreMemberGiftCardConsumeRecordFrom/"+retailStoreMemberGiftCard.getId()+"/","retailStoreMemberGiftCardConsumeRecordList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailScmUserContext userContext,String name, String ownerId, String number, double remain
) throws Exception
	{
		
		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");

		

		checkNameOfRetailStoreMemberGiftCard(userContext,  name, exception);
		checkNumberOfRetailStoreMemberGiftCard(userContext,  number, exception);
		checkRemainOfRetailStoreMemberGiftCard(userContext,  remain, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreMemberGiftCard retailStoreMemberGiftCard=createNewRetailStoreMemberGiftCard();	

		retailStoreMemberGiftCard.setName(name);
		RetailStoreMember owner = loadRetailStoreMember(ownerId,emptyOptions());
		retailStoreMemberGiftCard.setOwner(owner);
		retailStoreMemberGiftCard.setNumber(number);
		retailStoreMemberGiftCard.setRemain(remain);

		return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, emptyOptions());
		

		
	}
	protected RetailStoreMemberGiftCard createNewRetailStoreMemberGiftCard() 
	{
		
		return new RetailStoreMemberGiftCard();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCard(RetailScmUserContext userContext,String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		checkVersionOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardVersion, exception);
		

		if(RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreMemberGiftCard(userContext, parseString(newValueExpr), exception);
		}		

		
		if(RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)){
			checkNumberOfRetailStoreMemberGiftCard(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)){
			checkRemainOfRetailStoreMemberGiftCard(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreMemberGiftCard clone(RetailScmUserContext userContext, String fromRetailStoreMemberGiftCardId) throws Exception{
		
		return this.getRetailStoreMemberGiftCardDAO().clone(fromRetailStoreMemberGiftCardId, this.allTokens());
	}
	
	public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCard(RetailScmUserContext userContext,String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		if(retailStoreMemberGiftCard.getVersion() != retailStoreMemberGiftCardVersion){
			String message = "The target version("+retailStoreMemberGiftCard.getVersion()+") is not equals to version("+retailStoreMemberGiftCardVersion+") provided";
			throw new RetailStoreMemberGiftCardManagerException(message);
		}
		synchronized(retailStoreMemberGiftCard){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCard.
			
			retailStoreMemberGiftCard.changePropery(property, newValueExpr);
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberGiftCardTokens tokens(){
		return RetailStoreMemberGiftCardTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberGiftCardTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberGiftCardTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId) throws Exception
 	{
 		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
 		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId,exception);
 		checkIdOfRetailStoreMember(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreMemberGiftCard transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberGiftCardId,anotherOwnerId);
 
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());	
		synchronized(retailStoreMemberGiftCard){
			//will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(anotherOwnerId, emptyOptions());		
			retailStoreMemberGiftCard.setOwner(owner);		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, emptyOptions());
			
			return present(userContext,retailStoreMemberGiftCard, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion) throws Exception{
		getRetailStoreMemberGiftCardDAO().delete(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberGiftCardManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreMemberGiftCardDAO().deleteAll();
	}

	protected void checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, double amount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);

		checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(userContext,  occureTime, exception);		
		
		checkIdOfConsumerOrder(userContext,  bizOrderId, exception);
		checkNumberOfRetailStoreMemberGiftCardConsumeRecord(userContext,  number, exception);
		checkAmountOfRetailStoreMemberGiftCardConsumeRecord(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, double amount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId,occureTime, bizOrderId, number, amount,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createRetailStoreMemberGiftCardConsumeRecord(userContext,occureTime, bizOrderId, number, amount);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMemberGiftCard.addRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, Date occureTime, String bizOrderId, String number, double amount) throws Exception{

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		
		
		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);		
		ConsumerOrder  bizOrder = new ConsumerOrder();
		bizOrder.setId(bizOrderId);		
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);		
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);		
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);
	
		
		return retailStoreMemberGiftCardConsumeRecord;
	
		
	}
	
	protected RetailStoreMemberGiftCardConsumeRecord createIndexedRetailStoreMemberGiftCardConsumeRecord(String id, int version){

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecord.setId(id);
		retailStoreMemberGiftCardConsumeRecord.setVersion(version);
		return retailStoreMemberGiftCardConsumeRecord;			
		
	}
	protected void checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		checkVersionOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMemberGiftCard.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, exception);
		checkVersionOfRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMemberGiftCard copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, 
		String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberGiftCardConsumeRecord(userContext,retailStoreMemberGiftCardId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion,tokensExpr);
		
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMemberGiftCard.copyRetailStoreMemberGiftCardConsumeRecordFrom( retailStoreMemberGiftCardConsumeRecord );		
			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberGiftCardManagerException exception = new RetailStoreMemberGiftCardManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
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
	
	public  RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardId, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = loadRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, allTokens());
		
		synchronized(retailStoreMemberGiftCard){ 
			//Will be good when the retailStoreMemberGiftCard loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMemberGiftCard.removeRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecord );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIndex = createIndexedRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
		
			RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = retailStoreMemberGiftCard.findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordIndex);
			if(retailStoreMemberGiftCardConsumeRecord == null){
				throw new RetailStoreMemberGiftCardManagerException(retailStoreMemberGiftCardConsumeRecord+"Not found" );
			}
			
			retailStoreMemberGiftCardConsumeRecord.changePropery(property, newValueExpr);

			retailStoreMemberGiftCard = saveRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, tokens().withRetailStoreMemberGiftCardConsumeRecordList().done());
			return present(userContext,retailStoreMemberGiftCard, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


