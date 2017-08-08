
package com.skynet.retailscm.originalvouchercreation;

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




public class OriginalVoucherCreationManagerImpl extends RetailScmCheckerManager implements OriginalVoucherCreationManager {
	
	private static final String SERVICE_TYPE = "OriginalVoucherCreation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  OriginalVoucherCreationDAO  originalVoucherCreationDAO;
 	public void setOriginalVoucherCreationDAO(OriginalVoucherCreationDAO  originalVoucherCreationDAO){
 	
 		if(originalVoucherCreationDAO == null){
 			throw new IllegalStateException("Do not try to set originalVoucherCreationDAO to null.");
 		}
	 	this.originalVoucherCreationDAO = originalVoucherCreationDAO;
 	}
 	public OriginalVoucherCreationDAO getOriginalVoucherCreationDAO(){
 		if(this.originalVoucherCreationDAO == null){
 			throw new IllegalStateException("The OriginalVoucherCreationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.originalVoucherCreationDAO;
 	}
 	
 	protected OriginalVoucherCreation saveOriginalVoucherCreation(RetailScmUserContext userContext, OriginalVoucherCreation originalVoucherCreation, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherCreationDAO().save(originalVoucherCreation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens);
 	}
 	
 	protected OriginalVoucherCreation saveOriginalVoucherCreationDetail(RetailScmUserContext userContext, OriginalVoucherCreation originalVoucherCreation) throws Exception{	

 		
 		return saveOriginalVoucherCreation(userContext, originalVoucherCreation, allTokens());
 	}
 	
 	public OriginalVoucherCreation loadOriginalVoucherCreation(RetailScmUserContext userContext, String originalVoucherCreationId, String [] tokensExpr) throws Exception{				
 
 		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation( userContext, originalVoucherCreationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherCreation, tokens);
 	}
 	
 	protected OriginalVoucherCreation present(RetailScmUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherCreation,tokens);
		
		
		return this.getOriginalVoucherCreationDAO().present(originalVoucherCreation, tokens);
	}
 
 	
 	
 	public OriginalVoucherCreation loadOriginalVoucherCreationDetail(RetailScmUserContext userContext, String originalVoucherCreationId) throws Exception{	
 		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation( userContext, originalVoucherCreationId, allTokens());

 		return present(userContext,originalVoucherCreation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String originalVoucherCreationId) throws Exception{	
 		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation( userContext, originalVoucherCreationId, allTokens());

 		return present(userContext,originalVoucherCreation, allTokens());
		
 	}
 	protected OriginalVoucherCreation saveOriginalVoucherCreation(RetailScmUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherCreationDAO().save(originalVoucherCreation, tokens);
 	}
 	protected OriginalVoucherCreation loadOriginalVoucherCreation(RetailScmUserContext userContext, String originalVoucherCreationId, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherCreationDAO().load(originalVoucherCreationId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherCreation, tokens);
		
		addAction(userContext, originalVoucherCreation, tokens,"@create","createOriginalVoucherCreation","createOriginalVoucherCreation/","main","primary");
		addAction(userContext, originalVoucherCreation, tokens,"@update","updateOriginalVoucherCreation","updateOriginalVoucherCreation/"+originalVoucherCreation.getId()+"/","main","primary");
		addAction(userContext, originalVoucherCreation, tokens,"@copy","cloneOriginalVoucherCreation","cloneOriginalVoucherCreation/"+originalVoucherCreation.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherCreation, tokens,"original_voucher_creation.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherCreation.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucherCreation originalVoucherCreation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OriginalVoucherCreation createOriginalVoucherCreation(RetailScmUserContext userContext,String who, String comments, Date makeDate
) throws Exception
	{
		
		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");

		

		checkWhoOfOriginalVoucherCreation(userContext,  who, exception);
		checkCommentsOfOriginalVoucherCreation(userContext,  comments, exception);
		checkMakeDateOfOriginalVoucherCreation(userContext,  makeDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		OriginalVoucherCreation originalVoucherCreation=createNewOriginalVoucherCreation();	

		originalVoucherCreation.setWho(who);
		originalVoucherCreation.setComments(comments);
		originalVoucherCreation.setMakeDate(makeDate);

		return saveOriginalVoucherCreation(userContext, originalVoucherCreation, emptyOptions());
		

		
	}
	protected OriginalVoucherCreation createNewOriginalVoucherCreation() 
	{
		
		return new OriginalVoucherCreation();		
	}
	
	protected void checkParamsForUpdatingOriginalVoucherCreation(RetailScmUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);
		checkVersionOfOriginalVoucherCreation(userContext, originalVoucherCreationVersion, exception);
		

		if(OriginalVoucherCreation.WHO_PROPERTY.equals(property)){
			checkWhoOfOriginalVoucherCreation(userContext, parseString(newValueExpr), exception);
		}
		if(OriginalVoucherCreation.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfOriginalVoucherCreation(userContext, parseString(newValueExpr), exception);
		}
		if(OriginalVoucherCreation.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfOriginalVoucherCreation(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public OriginalVoucherCreation clone(RetailScmUserContext userContext, String fromOriginalVoucherCreationId) throws Exception{
		
		return this.getOriginalVoucherCreationDAO().clone(fromOriginalVoucherCreationId, this.allTokens());
	}
	
	public OriginalVoucherCreation updateOriginalVoucherCreation(RetailScmUserContext userContext,String originalVoucherCreationId, int originalVoucherCreationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucherCreation(userContext, originalVoucherCreationId, originalVoucherCreationVersion, property, newValueExpr, tokensExpr);
		
		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		if(originalVoucherCreation.getVersion() != originalVoucherCreationVersion){
			String message = "The target version("+originalVoucherCreation.getVersion()+") is not equals to version("+originalVoucherCreationVersion+") provided";
			throw new OriginalVoucherCreationManagerException(message);
		}
		synchronized(originalVoucherCreation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherCreation.
			
			originalVoucherCreation.changePropery(property, newValueExpr);
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OriginalVoucherCreationTokens tokens(){
		return OriginalVoucherCreationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherCreationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherCreationTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String originalVoucherCreationId, int originalVoucherCreationVersion) throws Exception {
		
		deleteInternal(userContext, originalVoucherCreationId, originalVoucherCreationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String originalVoucherCreationId, int originalVoucherCreationVersion) throws Exception{
		getOriginalVoucherCreationDAO().delete(originalVoucherCreationId, originalVoucherCreationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherCreationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getOriginalVoucherCreationDAO().deleteAll();
	}

	protected void checkParamsForAddingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId,String [] tokensExpr) throws Exception{
		
		

		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);

		checkTitleOfOriginalVoucher(userContext,  title, exception);
		checkMadeByOfOriginalVoucher(userContext,  madeBy, exception);
		checkReceivedByOfOriginalVoucher(userContext,  receivedBy, exception);
		checkVoucherTypeOfOriginalVoucher(userContext,  voucherType, exception);
		checkVoucherImageOfOriginalVoucher(userContext,  voucherImage, exception);		
		
		checkIdOfAccountingDocument(userContext,  belongsToId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  OriginalVoucherCreation addOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOriginalVoucher(userContext,originalVoucherCreationId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId,tokensExpr);
		
		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId);
		
		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		synchronized(originalVoucherCreation){ 
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherCreation.addOriginalVoucher( originalVoucher );		
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OriginalVoucherCreation removeOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherCreationId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		synchronized(originalVoucherCreation){ 
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherCreation.removeOriginalVoucher( originalVoucher );		
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OriginalVoucherCreation copyOriginalVoucherFrom(RetailScmUserContext userContext, String originalVoucherCreationId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherCreationId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		synchronized(originalVoucherCreation){ 
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherCreation.copyOriginalVoucherFrom( originalVoucher );		
			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		OriginalVoucherCreationManagerException exception = new OriginalVoucherCreationManagerException("Error Occured");
		
		checkIdOfOriginalVoucherCreation(userContext, originalVoucherCreationId, exception);
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
	
	public  OriginalVoucherCreation updateOriginalVoucher(RetailScmUserContext userContext, String originalVoucherCreationId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherCreationId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);
		
		
		OriginalVoucherCreation originalVoucherCreation = loadOriginalVoucherCreation(userContext, originalVoucherCreationId, allTokens());
		
		synchronized(originalVoucherCreation){ 
			//Will be good when the originalVoucherCreation loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherCreation.removeOriginalVoucher( originalVoucher );	
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		
			OriginalVoucher originalVoucher = originalVoucherCreation.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherCreationManagerException(originalVoucher+"Not found" );
			}
			
			originalVoucher.changePropery(property, newValueExpr);

			originalVoucherCreation = saveOriginalVoucherCreation(userContext, originalVoucherCreation, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherCreation, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


