
package com.skynet.retailscm.terminationreason;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.termination.Termination;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.terminationtype.TerminationType;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.termination.TerminationTable;




public class TerminationReasonManagerImpl extends RetailScmCheckerManager implements TerminationReasonManager {
	
	private static final String SERVICE_TYPE = "TerminationReason";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TerminationReasonDAO  terminationReasonDAO;
 	public void setTerminationReasonDAO(TerminationReasonDAO  terminationReasonDAO){
 	
 		if(terminationReasonDAO == null){
 			throw new IllegalStateException("Do not try to set terminationReasonDAO to null.");
 		}
	 	this.terminationReasonDAO = terminationReasonDAO;
 	}
 	public TerminationReasonDAO getTerminationReasonDAO(){
 		if(this.terminationReasonDAO == null){
 			throw new IllegalStateException("The TerminationReasonDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.terminationReasonDAO;
 	}
 	
 	protected TerminationReason saveTerminationReason(RetailScmUserContext userContext, TerminationReason terminationReason, String [] tokensExpr) throws Exception{	
 		//return getTerminationReasonDAO().save(terminationReason, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTerminationReason(userContext, terminationReason, tokens);
 	}
 	
 	protected TerminationReason saveTerminationReasonDetail(RetailScmUserContext userContext, TerminationReason terminationReason) throws Exception{	

 		
 		return saveTerminationReason(userContext, terminationReason, allTokens());
 	}
 	
 	public TerminationReason loadTerminationReason(RetailScmUserContext userContext, String terminationReasonId, String [] tokensExpr) throws Exception{				
 
 		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationReason, tokens);
 	}
 	
 	protected TerminationReason present(RetailScmUserContext userContext, TerminationReason terminationReason, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,terminationReason,tokens);
		
		
		return this.getTerminationReasonDAO().present(terminationReason, tokens);
	}
 
 	
 	
 	public TerminationReason loadTerminationReasonDetail(RetailScmUserContext userContext, String terminationReasonId) throws Exception{	
 		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, allTokens());

 		return present(userContext,terminationReason, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String terminationReasonId) throws Exception{	
 		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TerminationReason terminationReason = loadTerminationReason( userContext, terminationReasonId, allTokens());

 		return present(userContext,terminationReason, allTokens());
		
 	}
 	protected TerminationReason saveTerminationReason(RetailScmUserContext userContext, TerminationReason terminationReason, Map<String,Object>tokens) throws Exception{	
 		return getTerminationReasonDAO().save(terminationReason, tokens);
 	}
 	protected TerminationReason loadTerminationReason(RetailScmUserContext userContext, String terminationReasonId, Map<String,Object>tokens) throws Exception{	
 		return getTerminationReasonDAO().load(terminationReasonId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TerminationReason terminationReason, Map<String, Object> tokens){
		super.addActions(userContext, terminationReason, tokens);
		
		addAction(userContext, terminationReason, tokens,"@create","createTerminationReason","createTerminationReason/","main","primary");
		addAction(userContext, terminationReason, tokens,"@update","updateTerminationReason","updateTerminationReason/"+terminationReason.getId()+"/","main","primary");
		addAction(userContext, terminationReason, tokens,"@copy","cloneTerminationReason","cloneTerminationReason/"+terminationReason.getId()+"/","main","primary");
		
		addAction(userContext, terminationReason, tokens,"termination_reason.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+terminationReason.getId()+"/","main","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.addTermination","addTermination","addTermination/"+terminationReason.getId()+"/","terminationList","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.removeTermination","removeTermination","removeTermination/"+terminationReason.getId()+"/","terminationList","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.updateTermination","updateTermination","updateTermination/"+terminationReason.getId()+"/","terminationList","primary");
		addAction(userContext, terminationReason, tokens,"termination_reason.copyTerminationFrom","copyTerminationFrom","copyTerminationFrom/"+terminationReason.getId()+"/","terminationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TerminationReason terminationReason, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TerminationReason createTerminationReason(RetailScmUserContext userContext,String code, String companyId, String description
) throws Exception
	{
		
		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");

		

		checkCodeOfTerminationReason(userContext,  code, exception);
		checkDescriptionOfTerminationReason(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TerminationReason terminationReason=createNewTerminationReason();	

		terminationReason.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		terminationReason.setCompany(company);
		terminationReason.setDescription(description);

		return saveTerminationReason(userContext, terminationReason, emptyOptions());
		

		
	}
	protected TerminationReason createNewTerminationReason() 
	{
		
		return new TerminationReason();		
	}
	
	protected void checkParamsForUpdatingTerminationReason(RetailScmUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		checkVersionOfTerminationReason(userContext, terminationReasonVersion, exception);
		

		if(TerminationReason.CODE_PROPERTY.equals(property)){
			checkCodeOfTerminationReason(userContext, parseString(newValueExpr), exception);
		}		

		
		if(TerminationReason.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfTerminationReason(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public TerminationReason clone(RetailScmUserContext userContext, String fromTerminationReasonId) throws Exception{
		
		return this.getTerminationReasonDAO().clone(fromTerminationReasonId, this.allTokens());
	}
	
	public TerminationReason updateTerminationReason(RetailScmUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTerminationReason(userContext, terminationReasonId, terminationReasonVersion, property, newValueExpr, tokensExpr);
		
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		if(terminationReason.getVersion() != terminationReasonVersion){
			String message = "The target version("+terminationReason.getVersion()+") is not equals to version("+terminationReasonVersion+") provided";
			throw new TerminationReasonManagerException(message);
		}
		synchronized(terminationReason){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationReason.
			
			terminationReason.changePropery(property, newValueExpr);
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
			//return saveTerminationReason(userContext, terminationReason, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TerminationReasonTokens tokens(){
		return TerminationReasonTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationReasonTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationReasonTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String terminationReasonId, String anotherCompanyId) throws Exception
 	{
 		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
 		checkIdOfTerminationReason(userContext, terminationReasonId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TerminationReason transferToAnotherCompany(RetailScmUserContext userContext, String terminationReasonId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, terminationReasonId,anotherCompanyId);
 
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());	
		synchronized(terminationReason){
			//will be good when the terminationReason loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			terminationReason.setCompany(company);		
			terminationReason = saveTerminationReason(userContext, terminationReason, emptyOptions());
			
			return present(userContext,terminationReason, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String terminationReasonId, int terminationReasonVersion) throws Exception {
		
		deleteInternal(userContext, terminationReasonId, terminationReasonVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String terminationReasonId, int terminationReasonVersion) throws Exception{
		getTerminationReasonDAO().delete(terminationReasonId, terminationReasonVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationReasonManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTerminationReasonDAO().deleteAll();
	}

	protected void checkParamsForAddingTermination(RetailScmUserContext userContext, String terminationReasonId, String typeId, String comment,String [] tokensExpr) throws Exception{
		
		

		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		
		
		checkIdOfTerminationType(userContext,  typeId, exception);
		checkCommentOfTermination(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TerminationReason addTermination(RetailScmUserContext userContext, String terminationReasonId, String typeId, String comment, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTermination(userContext,terminationReasonId,typeId, comment,tokensExpr);
		
		Termination termination = createTermination(userContext,typeId, comment);
		
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationReason.addTermination( termination );		
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
	}
	protected Termination createTermination(RetailScmUserContext userContext, String typeId, String comment) throws Exception{

		Termination termination = new Termination();
		
		
		TerminationType  type = new TerminationType();
		type.setId(typeId);		
		termination.setType(type);		
		termination.setComment(comment);
	
		
		return termination;
	
		
	}
	
	protected Termination createIndexedTermination(String id, int version){

		Termination termination = new Termination();
		termination.setId(id);
		termination.setVersion(version);
		return termination;			
		
	}
	protected void checkParamsForRemovingTermination(RetailScmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		

		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		checkIdOfTermination(userContext, terminationId, exception);
		checkVersionOfTermination(userContext, terminationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TerminationReason removeTermination(RetailScmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTermination(userContext,terminationReasonId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationReason.removeTermination( termination );		
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTermination(RetailScmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		

		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		checkIdOfTermination(userContext, terminationId, exception);
		checkVersionOfTermination(userContext, terminationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TerminationReason copyTerminationFrom(RetailScmUserContext userContext, String terminationReasonId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTermination(userContext,terminationReasonId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationReason.copyTerminationFrom( termination );		
			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTermination(RetailScmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TerminationReasonManagerException exception = new TerminationReasonManagerException("Error Occured");
		
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		checkIdOfTermination(userContext, terminationId, exception);
		checkVersionOfTermination(userContext, terminationVersion, exception);
		

		if(Termination.COMMENT_PROPERTY.equals(property)){
			checkCommentOfTermination(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  TerminationReason updateTermination(RetailScmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTermination(userContext, terminationReasonId, terminationId, terminationVersion, property, newValueExpr,  tokensExpr);
		
		
		TerminationReason terminationReason = loadTerminationReason(userContext, terminationReasonId, allTokens());
		
		synchronized(terminationReason){ 
			//Will be good when the terminationReason loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//terminationReason.removeTermination( termination );	
			//make changes to AcceleraterAccount.
			Termination terminationIndex = createIndexedTermination(terminationId, terminationVersion);
		
			Termination termination = terminationReason.findTheTermination(terminationIndex);
			if(termination == null){
				throw new TerminationReasonManagerException(termination+"Not found" );
			}
			
			termination.changePropery(property, newValueExpr);

			terminationReason = saveTerminationReason(userContext, terminationReason, tokens().withTerminationList().done());
			return present(userContext,terminationReason, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


