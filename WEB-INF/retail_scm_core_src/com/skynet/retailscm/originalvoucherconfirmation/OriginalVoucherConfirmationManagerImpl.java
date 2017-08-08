
package com.skynet.retailscm.originalvoucherconfirmation;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.originalvoucher.OriginalVoucher;


import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.accountingdocument.AccountingDocument;


import com.skynet.retailscm.originalvoucher.OriginalVoucherTable;




public class OriginalVoucherConfirmationManagerImpl extends RetailScmCheckerManager implements OriginalVoucherConfirmationManager {
	
	private static final String SERVICE_TYPE = "OriginalVoucherConfirmation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  OriginalVoucherConfirmationDAO  originalVoucherConfirmationDAO;
 	public void setOriginalVoucherConfirmationDAO(OriginalVoucherConfirmationDAO  originalVoucherConfirmationDAO){
 	
 		if(originalVoucherConfirmationDAO == null){
 			throw new IllegalStateException("Do not try to set originalVoucherConfirmationDAO to null.");
 		}
	 	this.originalVoucherConfirmationDAO = originalVoucherConfirmationDAO;
 	}
 	public OriginalVoucherConfirmationDAO getOriginalVoucherConfirmationDAO(){
 		if(this.originalVoucherConfirmationDAO == null){
 			throw new IllegalStateException("The OriginalVoucherConfirmationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.originalVoucherConfirmationDAO;
 	}
 	
 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(RetailScmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherConfirmationDAO().save(originalVoucherConfirmation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens);
 	}
 	
 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmationDetail(RetailScmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation) throws Exception{	

 		
 		return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, allTokens());
 	}
 	
 	public OriginalVoucherConfirmation loadOriginalVoucherConfirmation(RetailScmUserContext userContext, String originalVoucherConfirmationId, String [] tokensExpr) throws Exception{				
 
 		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherConfirmation, tokens);
 	}
 	
 	protected OriginalVoucherConfirmation present(RetailScmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherConfirmation,tokens);
		
		
		return this.getOriginalVoucherConfirmationDAO().present(originalVoucherConfirmation, tokens);
	}
 
 	
 	
 	public OriginalVoucherConfirmation loadOriginalVoucherConfirmationDetail(RetailScmUserContext userContext, String originalVoucherConfirmationId) throws Exception{	
 		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, allTokens());

 		return present(userContext,originalVoucherConfirmation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String originalVoucherConfirmationId) throws Exception{	
 		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation( userContext, originalVoucherConfirmationId, allTokens());

 		return present(userContext,originalVoucherConfirmation, allTokens());
		
 	}
 	protected OriginalVoucherConfirmation saveOriginalVoucherConfirmation(RetailScmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherConfirmationDAO().save(originalVoucherConfirmation, tokens);
 	}
 	protected OriginalVoucherConfirmation loadOriginalVoucherConfirmation(RetailScmUserContext userContext, String originalVoucherConfirmationId, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherConfirmationDAO().load(originalVoucherConfirmationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherConfirmation, tokens);
		
		addAction(userContext, originalVoucherConfirmation, tokens,"@create","createOriginalVoucherConfirmation","createOriginalVoucherConfirmation/","main","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"@update","updateOriginalVoucherConfirmation","updateOriginalVoucherConfirmation/"+originalVoucherConfirmation.getId()+"/","main","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"@copy","cloneOriginalVoucherConfirmation","cloneOriginalVoucherConfirmation/"+originalVoucherConfirmation.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherConfirmation, tokens,"original_voucher_confirmation.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherConfirmation.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucherConfirmation originalVoucherConfirmation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(RetailScmUserContext userContext,String who, String comments, Date makeDate
) throws Exception
	{
		
		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");

		

		checkWhoOfOriginalVoucherConfirmation(userContext,  who, exception);
		checkCommentsOfOriginalVoucherConfirmation(userContext,  comments, exception);
		checkMakeDateOfOriginalVoucherConfirmation(userContext,  makeDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		OriginalVoucherConfirmation originalVoucherConfirmation=createNewOriginalVoucherConfirmation();	

		originalVoucherConfirmation.setWho(who);
		originalVoucherConfirmation.setComments(comments);
		originalVoucherConfirmation.setMakeDate(makeDate);

		return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, emptyOptions());
		

		
	}
	protected OriginalVoucherConfirmation createNewOriginalVoucherConfirmation() 
	{
		
		return new OriginalVoucherConfirmation();		
	}
	
	protected void checkParamsForUpdatingOriginalVoucherConfirmation(RetailScmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);
		checkVersionOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationVersion, exception);
		

		if(OriginalVoucherConfirmation.WHO_PROPERTY.equals(property)){
			checkWhoOfOriginalVoucherConfirmation(userContext, parseString(newValueExpr), exception);
		}
		if(OriginalVoucherConfirmation.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfOriginalVoucherConfirmation(userContext, parseString(newValueExpr), exception);
		}
		if(OriginalVoucherConfirmation.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfOriginalVoucherConfirmation(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public OriginalVoucherConfirmation clone(RetailScmUserContext userContext, String fromOriginalVoucherConfirmationId) throws Exception{
		
		return this.getOriginalVoucherConfirmationDAO().clone(fromOriginalVoucherConfirmationId, this.allTokens());
	}
	
	public OriginalVoucherConfirmation updateOriginalVoucherConfirmation(RetailScmUserContext userContext,String originalVoucherConfirmationId, int originalVoucherConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion, property, newValueExpr, tokensExpr);
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		if(originalVoucherConfirmation.getVersion() != originalVoucherConfirmationVersion){
			String message = "The target version("+originalVoucherConfirmation.getVersion()+") is not equals to version("+originalVoucherConfirmationVersion+") provided";
			throw new OriginalVoucherConfirmationManagerException(message);
		}
		synchronized(originalVoucherConfirmation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherConfirmation.
			
			originalVoucherConfirmation.changePropery(property, newValueExpr);
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OriginalVoucherConfirmationTokens tokens(){
		return OriginalVoucherConfirmationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherConfirmationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherConfirmationTokens.mergeAll(tokens).done();
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
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception {
		
		deleteInternal(userContext, originalVoucherConfirmationId, originalVoucherConfirmationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String originalVoucherConfirmationId, int originalVoucherConfirmationVersion) throws Exception{
		getOriginalVoucherConfirmationDAO().delete(originalVoucherConfirmationId, originalVoucherConfirmationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherConfirmationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getOriginalVoucherConfirmationDAO().deleteAll();
	}

	protected void checkParamsForAddingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId,String [] tokensExpr) throws Exception{
		
		

		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);

		checkTitleOfOriginalVoucher(userContext,  title, exception);
		checkMadeByOfOriginalVoucher(userContext,  madeBy, exception);
		checkReceivedByOfOriginalVoucher(userContext,  receivedBy, exception);
		checkVoucherTypeOfOriginalVoucher(userContext,  voucherType, exception);
		checkVoucherImageOfOriginalVoucher(userContext,  voucherImage, exception);		
		
		checkIdOfAccountingDocument(userContext,  belongsToId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  OriginalVoucherConfirmation addOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOriginalVoucher(userContext,originalVoucherConfirmationId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId,tokensExpr);
		
		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId);
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherConfirmation.addOriginalVoucher( originalVoucher );		
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
	}
	protected OriginalVoucher createOriginalVoucher(RetailScmUserContext userContext, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId) throws Exception{

		OriginalVoucher originalVoucher = new OriginalVoucher();
		
		
		originalVoucher.setTitle(title);		
		originalVoucher.setMadeBy(madeBy);		
		originalVoucher.setReceivedBy(receivedBy);		
		originalVoucher.setVoucherType(voucherType);		
		originalVoucher.setVoucherImage(voucherImage);		
		AccountingDocument  belongsTo = new AccountingDocument();
		belongsTo.setId(belongsToId);		
		originalVoucher.setBelongsTo(belongsTo);
	
		
		return originalVoucher;
	
		
	}
	
	protected OriginalVoucher createIndexedOriginalVoucher(String id, int version){

		OriginalVoucher originalVoucher = new OriginalVoucher();
		originalVoucher.setId(id);
		originalVoucher.setVersion(version);
		return originalVoucher;			
		
	}
	protected void checkParamsForRemovingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OriginalVoucherConfirmation removeOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherConfirmation.removeOriginalVoucher( originalVoucher );		
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OriginalVoucherConfirmation copyOriginalVoucherFrom(RetailScmUserContext userContext, String originalVoucherConfirmationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherConfirmation.copyOriginalVoucherFrom( originalVoucher );		
			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		OriginalVoucherConfirmationManagerException exception = new OriginalVoucherConfirmationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);
		

		if(OriginalVoucher.TITLE_PROPERTY.equals(property)){
			checkTitleOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.MADE_BY_PROPERTY.equals(property)){
			checkMadeByOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.RECEIVED_BY_PROPERTY.equals(property)){
			checkReceivedByOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.VOUCHER_TYPE_PROPERTY.equals(property)){
			checkVoucherTypeOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
		if(OriginalVoucher.VOUCHER_IMAGE_PROPERTY.equals(property)){
			checkVoucherImageOfOriginalVoucher(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  OriginalVoucherConfirmation updateOriginalVoucher(RetailScmUserContext userContext, String originalVoucherConfirmationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherConfirmationId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);
		
		
		OriginalVoucherConfirmation originalVoucherConfirmation = loadOriginalVoucherConfirmation(userContext, originalVoucherConfirmationId, allTokens());
		
		synchronized(originalVoucherConfirmation){ 
			//Will be good when the originalVoucherConfirmation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherConfirmation.removeOriginalVoucher( originalVoucher );	
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		
			OriginalVoucher originalVoucher = originalVoucherConfirmation.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherConfirmationManagerException(originalVoucher+"Not found" );
			}
			
			originalVoucher.changePropery(property, newValueExpr);

			originalVoucherConfirmation = saveOriginalVoucherConfirmation(userContext, originalVoucherConfirmation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherConfirmation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


