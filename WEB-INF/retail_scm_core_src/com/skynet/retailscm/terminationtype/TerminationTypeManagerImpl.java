
package com.skynet.retailscm.terminationtype;

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




public class TerminationTypeManagerImpl extends RetailScmCheckerManager implements TerminationTypeManager {
	
	private static final String SERVICE_TYPE = "TerminationType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TerminationTypeDAO  terminationTypeDAO;
 	public void setTerminationTypeDAO(TerminationTypeDAO  terminationTypeDAO){
 	
 		if(terminationTypeDAO == null){
 			throw new IllegalStateException("Do not try to set terminationTypeDAO to null.");
 		}
	 	this.terminationTypeDAO = terminationTypeDAO;
 	}
 	public TerminationTypeDAO getTerminationTypeDAO(){
 		if(this.terminationTypeDAO == null){
 			throw new IllegalStateException("The TerminationTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.terminationTypeDAO;
 	}
 	
 	protected TerminationType saveTerminationType(RetailScmUserContext userContext, TerminationType terminationType, String [] tokensExpr) throws Exception{	
 		//return getTerminationTypeDAO().save(terminationType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTerminationType(userContext, terminationType, tokens);
 	}
 	
 	protected TerminationType saveTerminationTypeDetail(RetailScmUserContext userContext, TerminationType terminationType) throws Exception{	

 		
 		return saveTerminationType(userContext, terminationType, allTokens());
 	}
 	
 	public TerminationType loadTerminationType(RetailScmUserContext userContext, String terminationTypeId, String [] tokensExpr) throws Exception{				
 
 		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,terminationType, tokens);
 	}
 	
 	protected TerminationType present(RetailScmUserContext userContext, TerminationType terminationType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,terminationType,tokens);
		
		
		return this.getTerminationTypeDAO().present(terminationType, tokens);
	}
 
 	
 	
 	public TerminationType loadTerminationTypeDetail(RetailScmUserContext userContext, String terminationTypeId) throws Exception{	
 		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, allTokens());

 		return present(userContext,terminationType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String terminationTypeId) throws Exception{	
 		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TerminationType terminationType = loadTerminationType( userContext, terminationTypeId, allTokens());

 		return present(userContext,terminationType, allTokens());
		
 	}
 	protected TerminationType saveTerminationType(RetailScmUserContext userContext, TerminationType terminationType, Map<String,Object>tokens) throws Exception{	
 		return getTerminationTypeDAO().save(terminationType, tokens);
 	}
 	protected TerminationType loadTerminationType(RetailScmUserContext userContext, String terminationTypeId, Map<String,Object>tokens) throws Exception{	
 		return getTerminationTypeDAO().load(terminationTypeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TerminationType terminationType, Map<String, Object> tokens){
		super.addActions(userContext, terminationType, tokens);
		
		addAction(userContext, terminationType, tokens,"@create","createTerminationType","createTerminationType/","main","primary");
		addAction(userContext, terminationType, tokens,"@update","updateTerminationType","updateTerminationType/"+terminationType.getId()+"/","main","primary");
		addAction(userContext, terminationType, tokens,"@copy","cloneTerminationType","cloneTerminationType/"+terminationType.getId()+"/","main","primary");
		
		addAction(userContext, terminationType, tokens,"termination_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+terminationType.getId()+"/","main","primary");
		addAction(userContext, terminationType, tokens,"termination_type.addTermination","addTermination","addTermination/"+terminationType.getId()+"/","terminationList","primary");
		addAction(userContext, terminationType, tokens,"termination_type.removeTermination","removeTermination","removeTermination/"+terminationType.getId()+"/","terminationList","primary");
		addAction(userContext, terminationType, tokens,"termination_type.updateTermination","updateTermination","updateTermination/"+terminationType.getId()+"/","terminationList","primary");
		addAction(userContext, terminationType, tokens,"termination_type.copyTerminationFrom","copyTerminationFrom","copyTerminationFrom/"+terminationType.getId()+"/","terminationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TerminationType terminationType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TerminationType createTerminationType(RetailScmUserContext userContext,String code, String companyId, String baseDescription, String detailDescription
) throws Exception
	{
		
		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");

		

		checkCodeOfTerminationType(userContext,  code, exception);
		checkBaseDescriptionOfTerminationType(userContext,  baseDescription, exception);
		checkDetailDescriptionOfTerminationType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TerminationType terminationType=createNewTerminationType();	

		terminationType.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		terminationType.setCompany(company);
		terminationType.setBaseDescription(baseDescription);
		terminationType.setDetailDescription(detailDescription);

		return saveTerminationType(userContext, terminationType, emptyOptions());
		

		
	}
	protected TerminationType createNewTerminationType() 
	{
		
		return new TerminationType();		
	}
	
	protected void checkParamsForUpdatingTerminationType(RetailScmUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		checkVersionOfTerminationType(userContext, terminationTypeVersion, exception);
		

		if(TerminationType.CODE_PROPERTY.equals(property)){
			checkCodeOfTerminationType(userContext, parseString(newValueExpr), exception);
		}		

		
		if(TerminationType.BASE_DESCRIPTION_PROPERTY.equals(property)){
			checkBaseDescriptionOfTerminationType(userContext, parseString(newValueExpr), exception);
		}
		if(TerminationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfTerminationType(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public TerminationType clone(RetailScmUserContext userContext, String fromTerminationTypeId) throws Exception{
		
		return this.getTerminationTypeDAO().clone(fromTerminationTypeId, this.allTokens());
	}
	
	public TerminationType updateTerminationType(RetailScmUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTerminationType(userContext, terminationTypeId, terminationTypeVersion, property, newValueExpr, tokensExpr);
		
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		if(terminationType.getVersion() != terminationTypeVersion){
			String message = "The target version("+terminationType.getVersion()+") is not equals to version("+terminationTypeVersion+") provided";
			throw new TerminationTypeManagerException(message);
		}
		synchronized(terminationType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TerminationType.
			
			terminationType.changePropery(property, newValueExpr);
			terminationType = saveTerminationType(userContext, terminationType, tokens().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
			//return saveTerminationType(userContext, terminationType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TerminationTypeTokens tokens(){
		return TerminationTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TerminationTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TerminationTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String terminationTypeId, String anotherCompanyId) throws Exception
 	{
 		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
 		checkIdOfTerminationType(userContext, terminationTypeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TerminationType transferToAnotherCompany(RetailScmUserContext userContext, String terminationTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, terminationTypeId,anotherCompanyId);
 
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());	
		synchronized(terminationType){
			//will be good when the terminationType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			terminationType.setCompany(company);		
			terminationType = saveTerminationType(userContext, terminationType, emptyOptions());
			
			return present(userContext,terminationType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String terminationTypeId, int terminationTypeVersion) throws Exception {
		
		deleteInternal(userContext, terminationTypeId, terminationTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String terminationTypeId, int terminationTypeVersion) throws Exception{
		getTerminationTypeDAO().delete(terminationTypeId, terminationTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TerminationTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTerminationTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingTermination(RetailScmUserContext userContext, String terminationTypeId, String reasonId, String comment,String [] tokensExpr) throws Exception{
		
		

		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		
		
		checkIdOfTerminationReason(userContext,  reasonId, exception);
		checkCommentOfTermination(userContext,  comment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TerminationType addTermination(RetailScmUserContext userContext, String terminationTypeId, String reasonId, String comment, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTermination(userContext,terminationTypeId,reasonId, comment,tokensExpr);
		
		Termination termination = createTermination(userContext,reasonId, comment);
		
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationType.addTermination( termination );		
			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}
	}
	protected Termination createTermination(RetailScmUserContext userContext, String reasonId, String comment) throws Exception{

		Termination termination = new Termination();
		
		
		TerminationReason  reason = new TerminationReason();
		reason.setId(reasonId);		
		termination.setReason(reason);		
		termination.setComment(comment);
	
		
		return termination;
	
		
	}
	
	protected Termination createIndexedTermination(String id, int version){

		Termination termination = new Termination();
		termination.setId(id);
		termination.setVersion(version);
		return termination;			
		
	}
	protected void checkParamsForRemovingTermination(RetailScmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		

		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		checkIdOfTermination(userContext, terminationId, exception);
		checkVersionOfTermination(userContext, terminationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TerminationType removeTermination(RetailScmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTermination(userContext,terminationTypeId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationType.removeTermination( termination );		
			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTermination(RetailScmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		

		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		checkIdOfTermination(userContext, terminationId, exception);
		checkVersionOfTermination(userContext, terminationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TerminationType copyTerminationFrom(RetailScmUserContext userContext, String terminationTypeId, 
		String terminationId, int terminationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTermination(userContext,terminationTypeId, terminationId, terminationVersion,tokensExpr);
		
		Termination termination = createIndexedTermination(terminationId, terminationVersion);
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			terminationType.copyTerminationFrom( termination );		
			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTermination(RetailScmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TerminationTypeManagerException exception = new TerminationTypeManagerException("Error Occured");
		
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		checkIdOfTermination(userContext, terminationId, exception);
		checkVersionOfTermination(userContext, terminationVersion, exception);
		

		if(Termination.COMMENT_PROPERTY.equals(property)){
			checkCommentOfTermination(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  TerminationType updateTermination(RetailScmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTermination(userContext, terminationTypeId, terminationId, terminationVersion, property, newValueExpr,  tokensExpr);
		
		
		TerminationType terminationType = loadTerminationType(userContext, terminationTypeId, allTokens());
		
		synchronized(terminationType){ 
			//Will be good when the terminationType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//terminationType.removeTermination( termination );	
			//make changes to AcceleraterAccount.
			Termination terminationIndex = createIndexedTermination(terminationId, terminationVersion);
		
			Termination termination = terminationType.findTheTermination(terminationIndex);
			if(termination == null){
				throw new TerminationTypeManagerException(termination+"Not found" );
			}
			
			termination.changePropery(property, newValueExpr);

			terminationType = saveTerminationType(userContext, terminationType, tokens().withTerminationList().done());
			return present(userContext,terminationType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


