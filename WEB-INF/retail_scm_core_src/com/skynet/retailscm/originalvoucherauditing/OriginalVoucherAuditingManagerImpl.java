
package com.skynet.retailscm.originalvoucherauditing;

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




public class OriginalVoucherAuditingManagerImpl extends RetailScmCheckerManager implements OriginalVoucherAuditingManager {
	
	private static final String SERVICE_TYPE = "OriginalVoucherAuditing";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  OriginalVoucherAuditingDAO  originalVoucherAuditingDAO;
 	public void setOriginalVoucherAuditingDAO(OriginalVoucherAuditingDAO  originalVoucherAuditingDAO){
 	
 		if(originalVoucherAuditingDAO == null){
 			throw new IllegalStateException("Do not try to set originalVoucherAuditingDAO to null.");
 		}
	 	this.originalVoucherAuditingDAO = originalVoucherAuditingDAO;
 	}
 	public OriginalVoucherAuditingDAO getOriginalVoucherAuditingDAO(){
 		if(this.originalVoucherAuditingDAO == null){
 			throw new IllegalStateException("The OriginalVoucherAuditingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.originalVoucherAuditingDAO;
 	}
 	
 	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(RetailScmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherAuditingDAO().save(originalVoucherAuditing, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens);
 	}
 	
 	protected OriginalVoucherAuditing saveOriginalVoucherAuditingDetail(RetailScmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing) throws Exception{	

 		
 		return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, allTokens());
 	}
 	
 	public OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailScmUserContext userContext, String originalVoucherAuditingId, String [] tokensExpr) throws Exception{				
 
 		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucherAuditing, tokens);
 	}
 	
 	protected OriginalVoucherAuditing present(RetailScmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucherAuditing,tokens);
		
		
		return this.getOriginalVoucherAuditingDAO().present(originalVoucherAuditing, tokens);
	}
 
 	
 	
 	public OriginalVoucherAuditing loadOriginalVoucherAuditingDetail(RetailScmUserContext userContext, String originalVoucherAuditingId) throws Exception{	
 		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, allTokens());

 		return present(userContext,originalVoucherAuditing, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String originalVoucherAuditingId) throws Exception{	
 		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing( userContext, originalVoucherAuditingId, allTokens());

 		return present(userContext,originalVoucherAuditing, allTokens());
		
 	}
 	protected OriginalVoucherAuditing saveOriginalVoucherAuditing(RetailScmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherAuditingDAO().save(originalVoucherAuditing, tokens);
 	}
 	protected OriginalVoucherAuditing loadOriginalVoucherAuditing(RetailScmUserContext userContext, String originalVoucherAuditingId, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherAuditingDAO().load(originalVoucherAuditingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucherAuditing, tokens);
		
		addAction(userContext, originalVoucherAuditing, tokens,"@create","createOriginalVoucherAuditing","createOriginalVoucherAuditing/","main","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"@update","updateOriginalVoucherAuditing","updateOriginalVoucherAuditing/"+originalVoucherAuditing.getId()+"/","main","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"@copy","cloneOriginalVoucherAuditing","cloneOriginalVoucherAuditing/"+originalVoucherAuditing.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.addOriginalVoucher","addOriginalVoucher","addOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.removeOriginalVoucher","removeOriginalVoucher","removeOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.updateOriginalVoucher","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
		addAction(userContext, originalVoucherAuditing, tokens,"original_voucher_auditing.copyOriginalVoucherFrom","copyOriginalVoucherFrom","copyOriginalVoucherFrom/"+originalVoucherAuditing.getId()+"/","originalVoucherList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucherAuditing originalVoucherAuditing, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OriginalVoucherAuditing createOriginalVoucherAuditing(RetailScmUserContext userContext,String who, String comments, Date makeDate
) throws Exception
	{
		
		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");

		

		checkWhoOfOriginalVoucherAuditing(userContext,  who, exception);
		checkCommentsOfOriginalVoucherAuditing(userContext,  comments, exception);
		checkMakeDateOfOriginalVoucherAuditing(userContext,  makeDate, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		OriginalVoucherAuditing originalVoucherAuditing=createNewOriginalVoucherAuditing();	

		originalVoucherAuditing.setWho(who);
		originalVoucherAuditing.setComments(comments);
		originalVoucherAuditing.setMakeDate(makeDate);

		return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, emptyOptions());
		

		
	}
	protected OriginalVoucherAuditing createNewOriginalVoucherAuditing() 
	{
		
		return new OriginalVoucherAuditing();		
	}
	
	protected void checkParamsForUpdatingOriginalVoucherAuditing(RetailScmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);
		checkVersionOfOriginalVoucherAuditing(userContext, originalVoucherAuditingVersion, exception);
		

		if(OriginalVoucherAuditing.WHO_PROPERTY.equals(property)){
			checkWhoOfOriginalVoucherAuditing(userContext, parseString(newValueExpr), exception);
		}
		if(OriginalVoucherAuditing.COMMENTS_PROPERTY.equals(property)){
			checkCommentsOfOriginalVoucherAuditing(userContext, parseString(newValueExpr), exception);
		}
		if(OriginalVoucherAuditing.MAKE_DATE_PROPERTY.equals(property)){
			checkMakeDateOfOriginalVoucherAuditing(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public OriginalVoucherAuditing clone(RetailScmUserContext userContext, String fromOriginalVoucherAuditingId) throws Exception{
		
		return this.getOriginalVoucherAuditingDAO().clone(fromOriginalVoucherAuditingId, this.allTokens());
	}
	
	public OriginalVoucherAuditing updateOriginalVoucherAuditing(RetailScmUserContext userContext,String originalVoucherAuditingId, int originalVoucherAuditingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucherAuditing(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion, property, newValueExpr, tokensExpr);
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		if(originalVoucherAuditing.getVersion() != originalVoucherAuditingVersion){
			String message = "The target version("+originalVoucherAuditing.getVersion()+") is not equals to version("+originalVoucherAuditingVersion+") provided";
			throw new OriginalVoucherAuditingManagerException(message);
		}
		synchronized(originalVoucherAuditing){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucherAuditing.
			
			originalVoucherAuditing.changePropery(property, newValueExpr);
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OriginalVoucherAuditingTokens tokens(){
		return OriginalVoucherAuditingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherAuditingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherAuditingTokens.mergeAll(tokens).done();
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

	public void delete(RetailScmUserContext userContext, String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception {
		
		deleteInternal(userContext, originalVoucherAuditingId, originalVoucherAuditingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String originalVoucherAuditingId, int originalVoucherAuditingVersion) throws Exception{
		getOriginalVoucherAuditingDAO().delete(originalVoucherAuditingId, originalVoucherAuditingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherAuditingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getOriginalVoucherAuditingDAO().deleteAll();
	}

	protected void checkParamsForAddingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId,String [] tokensExpr) throws Exception{
		
		

		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);

		checkTitleOfOriginalVoucher(userContext,  title, exception);
		checkMadeByOfOriginalVoucher(userContext,  madeBy, exception);
		checkReceivedByOfOriginalVoucher(userContext,  receivedBy, exception);
		checkVoucherTypeOfOriginalVoucher(userContext,  voucherType, exception);
		checkVoucherImageOfOriginalVoucher(userContext,  voucherImage, exception);		
		
		checkIdOfAccountingDocument(userContext,  belongsToId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  OriginalVoucherAuditing addOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOriginalVoucher(userContext,originalVoucherAuditingId,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId,tokensExpr);
		
		OriginalVoucher originalVoucher = createOriginalVoucher(userContext,title, madeBy, receivedBy, voucherType, voucherImage, belongsToId);
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherAuditing.addOriginalVoucher( originalVoucher );		
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
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
	protected void checkParamsForRemovingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OriginalVoucherAuditing removeOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOriginalVoucher(userContext,originalVoucherAuditingId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherAuditing.removeOriginalVoucher( originalVoucher );		
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		

		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkVersionOfOriginalVoucher(userContext, originalVoucherVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  OriginalVoucherAuditing copyOriginalVoucherFrom(RetailScmUserContext userContext, String originalVoucherAuditingId, 
		String originalVoucherId, int originalVoucherVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOriginalVoucher(userContext,originalVoucherAuditingId, originalVoucherId, originalVoucherVersion,tokensExpr);
		
		OriginalVoucher originalVoucher = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			originalVoucherAuditing.copyOriginalVoucherFrom( originalVoucher );		
			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		OriginalVoucherAuditingManagerException exception = new OriginalVoucherAuditingManagerException("Error Occured");
		
		checkIdOfOriginalVoucherAuditing(userContext, originalVoucherAuditingId, exception);
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
	
	public  OriginalVoucherAuditing updateOriginalVoucher(RetailScmUserContext userContext, String originalVoucherAuditingId, String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherAuditingId, originalVoucherId, originalVoucherVersion, property, newValueExpr,  tokensExpr);
		
		
		OriginalVoucherAuditing originalVoucherAuditing = loadOriginalVoucherAuditing(userContext, originalVoucherAuditingId, allTokens());
		
		synchronized(originalVoucherAuditing){ 
			//Will be good when the originalVoucherAuditing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//originalVoucherAuditing.removeOriginalVoucher( originalVoucher );	
			//make changes to AcceleraterAccount.
			OriginalVoucher originalVoucherIndex = createIndexedOriginalVoucher(originalVoucherId, originalVoucherVersion);
		
			OriginalVoucher originalVoucher = originalVoucherAuditing.findTheOriginalVoucher(originalVoucherIndex);
			if(originalVoucher == null){
				throw new OriginalVoucherAuditingManagerException(originalVoucher+"Not found" );
			}
			
			originalVoucher.changePropery(property, newValueExpr);

			originalVoucherAuditing = saveOriginalVoucherAuditing(userContext, originalVoucherAuditing, tokens().withOriginalVoucherList().done());
			return present(userContext,originalVoucherAuditing, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


