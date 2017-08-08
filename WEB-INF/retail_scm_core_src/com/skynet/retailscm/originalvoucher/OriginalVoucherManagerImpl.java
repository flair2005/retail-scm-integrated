
package com.skynet.retailscm.originalvoucher;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditingDAO;
import com.skynet.retailscm.accountingdocument.AccountingDocumentDAO;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmationDAO;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreationDAO;



import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmationTable;
import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreationTable;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditingTable;




public class OriginalVoucherManagerImpl extends RetailScmCheckerManager implements OriginalVoucherManager {
	
	private static final String SERVICE_TYPE = "OriginalVoucher";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  OriginalVoucherDAO  originalVoucherDAO;
 	public void setOriginalVoucherDAO(OriginalVoucherDAO  originalVoucherDAO){
 	
 		if(originalVoucherDAO == null){
 			throw new IllegalStateException("Do not try to set originalVoucherDAO to null.");
 		}
	 	this.originalVoucherDAO = originalVoucherDAO;
 	}
 	public OriginalVoucherDAO getOriginalVoucherDAO(){
 		if(this.originalVoucherDAO == null){
 			throw new IllegalStateException("The OriginalVoucherDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.originalVoucherDAO;
 	}
 	
 	protected OriginalVoucher saveOriginalVoucher(RetailScmUserContext userContext, OriginalVoucher originalVoucher, String [] tokensExpr) throws Exception{	
 		//return getOriginalVoucherDAO().save(originalVoucher, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveOriginalVoucher(userContext, originalVoucher, tokens);
 	}
 	
 	protected OriginalVoucher saveOriginalVoucherDetail(RetailScmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{	

 		
 		return saveOriginalVoucher(userContext, originalVoucher, allTokens());
 	}
 	
 	public OriginalVoucher loadOriginalVoucher(RetailScmUserContext userContext, String originalVoucherId, String [] tokensExpr) throws Exception{				
 
 		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
		
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,originalVoucher, tokens);
 	}
 	
 	protected OriginalVoucher present(RetailScmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,originalVoucher,tokens);
		
		
		return this.getOriginalVoucherDAO().present(originalVoucher, tokens);
	}
 
 	
 	
 	public OriginalVoucher loadOriginalVoucherDetail(RetailScmUserContext userContext, String originalVoucherId) throws Exception{	
 		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
		
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, allTokens());

 		return present(userContext,originalVoucher, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String originalVoucherId) throws Exception{	
 		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
		
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		OriginalVoucher originalVoucher = loadOriginalVoucher( userContext, originalVoucherId, allTokens());

 		return present(userContext,originalVoucher, allTokens());
		
 	}
 	protected OriginalVoucher saveOriginalVoucher(RetailScmUserContext userContext, OriginalVoucher originalVoucher, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherDAO().save(originalVoucher, tokens);
 	}
 	protected OriginalVoucher loadOriginalVoucher(RetailScmUserContext userContext, String originalVoucherId, Map<String,Object>tokens) throws Exception{	
 		return getOriginalVoucherDAO().load(originalVoucherId, tokens);
 	}

	



 	 
 	
 	private  OriginalVoucherCreationDAO  originalVoucherCreationDAO;
 	public void setOriginalVoucherCreationDAO(OriginalVoucherCreationDAO originalVoucherCreationDAO){
	 	this.originalVoucherCreationDAO = originalVoucherCreationDAO;
 	}
 	//------------------------------------
 	public OriginalVoucherCreationDAO getOriginalVoucherCreationDAO(){
	 	return this.originalVoucherCreationDAO;
 	}
 
 	
 	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO accountingDocumentDAO){
	 	this.accountingDocumentDAO = accountingDocumentDAO;
 	}
 	//------------------------------------
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
	 	return this.accountingDocumentDAO;
 	}
 
 	
 	private  OriginalVoucherConfirmationDAO  originalVoucherConfirmationDAO;
 	public void setOriginalVoucherConfirmationDAO(OriginalVoucherConfirmationDAO originalVoucherConfirmationDAO){
	 	this.originalVoucherConfirmationDAO = originalVoucherConfirmationDAO;
 	}
 	//------------------------------------
 	public OriginalVoucherConfirmationDAO getOriginalVoucherConfirmationDAO(){
	 	return this.originalVoucherConfirmationDAO;
 	}
 
 	
 	private  OriginalVoucherAuditingDAO  originalVoucherAuditingDAO;
 	public void setOriginalVoucherAuditingDAO(OriginalVoucherAuditingDAO originalVoucherAuditingDAO){
	 	this.originalVoucherAuditingDAO = originalVoucherAuditingDAO;
 	}
 	//------------------------------------
 	public OriginalVoucherAuditingDAO getOriginalVoucherAuditingDAO(){
	 	return this.originalVoucherAuditingDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){
		super.addActions(userContext, originalVoucher, tokens);
		
		addAction(userContext, originalVoucher, tokens,"@create","createOriginalVoucher","createOriginalVoucher/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@update","updateOriginalVoucher","updateOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"@copy","cloneOriginalVoucher","cloneOriginalVoucher/"+originalVoucher.getId()+"/","main","primary");
		
		addAction(userContext, originalVoucher, tokens,"original_voucher.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"original_voucher.create","create","create/"+originalVoucher.getId()+"/","main","primary");
		addAction(userContext, originalVoucher, tokens,"original_voucher.confirm","confirm","confirm/"+originalVoucher.getId()+"/","main","success");
		addAction(userContext, originalVoucher, tokens,"original_voucher.audit","audit","audit/"+originalVoucher.getId()+"/","main","success");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, OriginalVoucher originalVoucher, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public OriginalVoucher createOriginalVoucher(RetailScmUserContext userContext,String title, String madeBy, String receivedBy, String voucherType, String voucherImage, String belongsToId
) throws Exception
	{
		
		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");

		

		checkTitleOfOriginalVoucher(userContext,  title, exception);
		checkMadeByOfOriginalVoucher(userContext,  madeBy, exception);
		checkReceivedByOfOriginalVoucher(userContext,  receivedBy, exception);
		checkVoucherTypeOfOriginalVoucher(userContext,  voucherType, exception);
		checkVoucherImageOfOriginalVoucher(userContext,  voucherImage, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		OriginalVoucher originalVoucher=createNewOriginalVoucher();	

		originalVoucher.setTitle(title);
		originalVoucher.setMadeBy(madeBy);
		originalVoucher.setReceivedBy(receivedBy);
		originalVoucher.setVoucherType(voucherType);
		originalVoucher.setVoucherImage(voucherImage);
		AccountingDocument belongsTo = loadAccountingDocument(belongsToId,emptyOptions());
		originalVoucher.setBelongsTo(belongsTo);

		return saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
		

		
	}
	protected OriginalVoucher createNewOriginalVoucher() 
	{
		
		return new OriginalVoucher();		
	}
	
	protected void checkParamsForUpdatingOriginalVoucher(RetailScmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
		
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
	
	
	
	public OriginalVoucher clone(RetailScmUserContext userContext, String fromOriginalVoucherId) throws Exception{
		
		return this.getOriginalVoucherDAO().clone(fromOriginalVoucherId, this.allTokens());
	}
	
	public OriginalVoucher updateOriginalVoucher(RetailScmUserContext userContext,String originalVoucherId, int originalVoucherVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingOriginalVoucher(userContext, originalVoucherId, originalVoucherVersion, property, newValueExpr, tokensExpr);
		
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());
		if(originalVoucher.getVersion() != originalVoucherVersion){
			String message = "The target version("+originalVoucher.getVersion()+") is not equals to version("+originalVoucherVersion+") provided";
			throw new OriginalVoucherManagerException(message);
		}
		synchronized(originalVoucher){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to OriginalVoucher.
			
			originalVoucher.changePropery(property, newValueExpr);
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().done());
			return present(userContext,originalVoucher, mergedAllTokens(tokensExpr));
			//return saveOriginalVoucher(userContext, originalVoucher, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected OriginalVoucherTokens tokens(){
		return OriginalVoucherTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return OriginalVoucherTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return OriginalVoucherTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"CREATED","CONFIRMED","AUDITED"};
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
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{
 		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
 		checkIdOfOriginalVoucher(userContext, originalVoucherId,exception);
 		checkIdOfAccountingDocument(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public OriginalVoucher transferToAnotherBelongsTo(RetailScmUserContext userContext, String originalVoucherId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, originalVoucherId,anotherBelongsToId);
 
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			AccountingDocument belongsTo = loadAccountingDocument(anotherBelongsToId, emptyOptions());		
			originalVoucher.setBelongsTo(belongsTo);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, emptyOptions());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForCreation(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
 		

		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
		
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkWhoOfOriginalVoucherCreation(userContext,who,exception);
		checkCommentsOfOriginalVoucherCreation(userContext,comments,exception);
		checkMakeDateOfOriginalVoucherCreation(userContext,makeDate,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public OriginalVoucher create(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForCreation(userContext, originalVoucherId, who, comments, makeDate);
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOriginalVoucherCreation(userContext,originalVoucher);
 		

			originalVoucher.setCurrentStatus("CREATED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OriginalVoucherCreation creation = createOriginalVoucherCreation(who, comments, makeDate);		
			originalVoucher.setCreation(creation);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().withCreation().done());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	protected OriginalVoucherCreation createOriginalVoucherCreation(String who, String comments, Date makeDate){
 		OriginalVoucherCreation creation = new OriginalVoucherCreation(who, comments, makeDate);
 		return getOriginalVoucherCreationDAO().save(creation,emptyOptions());
 	}
 	protected void checkIfEligibleForOriginalVoucherCreation(RetailScmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{
 		
 		
 		String currentStatus = originalVoucher.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CREATED'";
 			throw new OriginalVoucherManagerException(message);
 		}
 		
 		if(!("CREATED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CREATED'";
 			throw new OriginalVoucherManagerException(message);
 		}
 		
 		
 		OriginalVoucherCreation creation = originalVoucher.getCreation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = creation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( creation != null){
				throw new OriginalVoucherManagerException("The OriginalVoucher("+originalVoucher.getId()+") has already been CREATED");
		}
 		
 		
 	}
	
 	protected void checkParamsForConfirmation(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
 		

		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
		
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkWhoOfOriginalVoucherConfirmation(userContext,who,exception);
		checkCommentsOfOriginalVoucherConfirmation(userContext,comments,exception);
		checkMakeDateOfOriginalVoucherConfirmation(userContext,makeDate,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public OriginalVoucher confirm(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForConfirmation(userContext, originalVoucherId, who, comments, makeDate);
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOriginalVoucherConfirmation(userContext,originalVoucher);
 		

			originalVoucher.setCurrentStatus("CONFIRMED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OriginalVoucherConfirmation confirmation = createOriginalVoucherConfirmation(who, comments, makeDate);		
			originalVoucher.setConfirmation(confirmation);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().withConfirmation().done());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	protected OriginalVoucherConfirmation createOriginalVoucherConfirmation(String who, String comments, Date makeDate){
 		OriginalVoucherConfirmation confirmation = new OriginalVoucherConfirmation(who, comments, makeDate);
 		return getOriginalVoucherConfirmationDAO().save(confirmation,emptyOptions());
 	}
 	protected void checkIfEligibleForOriginalVoucherConfirmation(RetailScmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{
 		
 		
 		String currentStatus = originalVoucher.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new OriginalVoucherManagerException(message);
 		}
 		
 		if(!("CONFIRMED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CONFIRMED'";
 			throw new OriginalVoucherManagerException(message);
 		}
 		
 		
 		OriginalVoucherConfirmation confirmation = originalVoucher.getConfirmation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = confirmation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( confirmation != null){
				throw new OriginalVoucherManagerException("The OriginalVoucher("+originalVoucher.getId()+") has already been CONFIRMED");
		}
 		
 		
 	}
	
 	protected void checkParamsForAuditing(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
 		

		OriginalVoucherManagerException exception = new OriginalVoucherManagerException("Error Occured");
		
		checkIdOfOriginalVoucher(userContext, originalVoucherId, exception);
		checkWhoOfOriginalVoucherAuditing(userContext,who,exception);
		checkCommentsOfOriginalVoucherAuditing(userContext,comments,exception);
		checkMakeDateOfOriginalVoucherAuditing(userContext,makeDate,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public OriginalVoucher audit(RetailScmUserContext userContext, String originalVoucherId, String who, String comments, Date makeDate
) throws Exception
 	{
		checkParamsForAuditing(userContext, originalVoucherId, who, comments, makeDate);
		OriginalVoucher originalVoucher = loadOriginalVoucher(userContext, originalVoucherId, allTokens());	
		synchronized(originalVoucher){
			//will be good when the originalVoucher loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForOriginalVoucherAuditing(userContext,originalVoucher);
 		

			originalVoucher.setCurrentStatus("AUDITED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			OriginalVoucherAuditing auditing = createOriginalVoucherAuditing(who, comments, makeDate);		
			originalVoucher.setAuditing(auditing);		
			originalVoucher = saveOriginalVoucher(userContext, originalVoucher, tokens().withAuditing().done());
			
			return present(userContext,originalVoucher, allTokens());
			
		}

 	}
 	protected OriginalVoucherAuditing createOriginalVoucherAuditing(String who, String comments, Date makeDate){
 		OriginalVoucherAuditing auditing = new OriginalVoucherAuditing(who, comments, makeDate);
 		return getOriginalVoucherAuditingDAO().save(auditing,emptyOptions());
 	}
 	protected void checkIfEligibleForOriginalVoucherAuditing(RetailScmUserContext userContext, OriginalVoucher originalVoucher) throws Exception{
 		
 		
 		String currentStatus = originalVoucher.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'AUDITED'";
 			throw new OriginalVoucherManagerException(message);
 		}
 		
 		if(!("AUDITED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'AUDITED'";
 			throw new OriginalVoucherManagerException(message);
 		}
 		
 		
 		OriginalVoucherAuditing auditing = originalVoucher.getAuditing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = auditing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( auditing != null){
				throw new OriginalVoucherManagerException("The OriginalVoucher("+originalVoucher.getId()+") has already been AUDITED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected OriginalVoucherCreation loadOriginalVoucherCreation(String newCreationId, Map<String,Object> options) throws Exception
 	{
		
 		return getOriginalVoucherCreationDAO().load(newCreationId, options);
 	}
	
	 	
 	protected AccountingDocument loadAccountingDocument(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getAccountingDocumentDAO().load(newBelongsToId, options);
 	}
	
	 	
 	protected OriginalVoucherConfirmation loadOriginalVoucherConfirmation(String newConfirmationId, Map<String,Object> options) throws Exception
 	{
		
 		return getOriginalVoucherConfirmationDAO().load(newConfirmationId, options);
 	}
	
	 	
 	protected OriginalVoucherAuditing loadOriginalVoucherAuditing(String newAuditingId, Map<String,Object> options) throws Exception
 	{
		
 		return getOriginalVoucherAuditingDAO().load(newAuditingId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String originalVoucherId, int originalVoucherVersion) throws Exception {
		
		deleteInternal(userContext, originalVoucherId, originalVoucherVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String originalVoucherId, int originalVoucherVersion) throws Exception{
		getOriginalVoucherDAO().delete(originalVoucherId, originalVoucherVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new OriginalVoucherManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getOriginalVoucherDAO().deleteAll();
	}


}


