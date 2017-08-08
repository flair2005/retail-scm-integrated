
package com.skynet.retailscm.publicholiday;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;




public class PublicHolidayManagerImpl extends RetailScmCheckerManager implements PublicHolidayManager {
	
	private static final String SERVICE_TYPE = "PublicHoliday";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  PublicHolidayDAO  publicHolidayDAO;
 	public void setPublicHolidayDAO(PublicHolidayDAO  publicHolidayDAO){
 	
 		if(publicHolidayDAO == null){
 			throw new IllegalStateException("Do not try to set publicHolidayDAO to null.");
 		}
	 	this.publicHolidayDAO = publicHolidayDAO;
 	}
 	public PublicHolidayDAO getPublicHolidayDAO(){
 		if(this.publicHolidayDAO == null){
 			throw new IllegalStateException("The PublicHolidayDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.publicHolidayDAO;
 	}
 	
 	protected PublicHoliday savePublicHoliday(RetailScmUserContext userContext, PublicHoliday publicHoliday, String [] tokensExpr) throws Exception{	
 		//return getPublicHolidayDAO().save(publicHoliday, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePublicHoliday(userContext, publicHoliday, tokens);
 	}
 	
 	protected PublicHoliday savePublicHolidayDetail(RetailScmUserContext userContext, PublicHoliday publicHoliday) throws Exception{	

 		
 		return savePublicHoliday(userContext, publicHoliday, allTokens());
 	}
 	
 	public PublicHoliday loadPublicHoliday(RetailScmUserContext userContext, String publicHolidayId, String [] tokensExpr) throws Exception{				
 
 		PublicHolidayManagerException exception = new PublicHolidayManagerException("Error Occured");
		
		checkIdOfPublicHoliday(userContext, publicHolidayId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,publicHoliday, tokens);
 	}
 	
 	protected PublicHoliday present(RetailScmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,publicHoliday,tokens);
		
		
		return this.getPublicHolidayDAO().present(publicHoliday, tokens);
	}
 
 	
 	
 	public PublicHoliday loadPublicHolidayDetail(RetailScmUserContext userContext, String publicHolidayId) throws Exception{	
 		PublicHolidayManagerException exception = new PublicHolidayManagerException("Error Occured");
		
		checkIdOfPublicHoliday(userContext, publicHolidayId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, allTokens());

 		return present(userContext,publicHoliday, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String publicHolidayId) throws Exception{	
 		PublicHolidayManagerException exception = new PublicHolidayManagerException("Error Occured");
		
		checkIdOfPublicHoliday(userContext, publicHolidayId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		PublicHoliday publicHoliday = loadPublicHoliday( userContext, publicHolidayId, allTokens());

 		return present(userContext,publicHoliday, allTokens());
		
 	}
 	protected PublicHoliday savePublicHoliday(RetailScmUserContext userContext, PublicHoliday publicHoliday, Map<String,Object>tokens) throws Exception{	
 		return getPublicHolidayDAO().save(publicHoliday, tokens);
 	}
 	protected PublicHoliday loadPublicHoliday(RetailScmUserContext userContext, String publicHolidayId, Map<String,Object>tokens) throws Exception{	
 		return getPublicHolidayDAO().load(publicHolidayId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens){
		super.addActions(userContext, publicHoliday, tokens);
		
		addAction(userContext, publicHoliday, tokens,"@create","createPublicHoliday","createPublicHoliday/","main","primary");
		addAction(userContext, publicHoliday, tokens,"@update","updatePublicHoliday","updatePublicHoliday/"+publicHoliday.getId()+"/","main","primary");
		addAction(userContext, publicHoliday, tokens,"@copy","clonePublicHoliday","clonePublicHoliday/"+publicHoliday.getId()+"/","main","primary");
		
		addAction(userContext, publicHoliday, tokens,"public_holiday.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+publicHoliday.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, PublicHoliday publicHoliday, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public PublicHoliday createPublicHoliday(RetailScmUserContext userContext,String code, String companyId, String name, String description
) throws Exception
	{
		
		PublicHolidayManagerException exception = new PublicHolidayManagerException("Error Occured");

		

		checkCodeOfPublicHoliday(userContext,  code, exception);
		checkNameOfPublicHoliday(userContext,  name, exception);
		checkDescriptionOfPublicHoliday(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		PublicHoliday publicHoliday=createNewPublicHoliday();	

		publicHoliday.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		publicHoliday.setCompany(company);
		publicHoliday.setName(name);
		publicHoliday.setDescription(description);

		return savePublicHoliday(userContext, publicHoliday, emptyOptions());
		

		
	}
	protected PublicHoliday createNewPublicHoliday() 
	{
		
		return new PublicHoliday();		
	}
	
	protected void checkParamsForUpdatingPublicHoliday(RetailScmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		PublicHolidayManagerException exception = new PublicHolidayManagerException("Error Occured");
		
		checkIdOfPublicHoliday(userContext, publicHolidayId, exception);
		checkVersionOfPublicHoliday(userContext, publicHolidayVersion, exception);
		

		if(PublicHoliday.CODE_PROPERTY.equals(property)){
			checkCodeOfPublicHoliday(userContext, parseString(newValueExpr), exception);
		}		

		
		if(PublicHoliday.NAME_PROPERTY.equals(property)){
			checkNameOfPublicHoliday(userContext, parseString(newValueExpr), exception);
		}
		if(PublicHoliday.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfPublicHoliday(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public PublicHoliday clone(RetailScmUserContext userContext, String fromPublicHolidayId) throws Exception{
		
		return this.getPublicHolidayDAO().clone(fromPublicHolidayId, this.allTokens());
	}
	
	public PublicHoliday updatePublicHoliday(RetailScmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPublicHoliday(userContext, publicHolidayId, publicHolidayVersion, property, newValueExpr, tokensExpr);
		
		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());
		if(publicHoliday.getVersion() != publicHolidayVersion){
			String message = "The target version("+publicHoliday.getVersion()+") is not equals to version("+publicHolidayVersion+") provided";
			throw new PublicHolidayManagerException(message);
		}
		synchronized(publicHoliday){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to PublicHoliday.
			
			publicHoliday.changePropery(property, newValueExpr);
			publicHoliday = savePublicHoliday(userContext, publicHoliday, tokens().done());
			return present(userContext,publicHoliday, mergedAllTokens(tokensExpr));
			//return savePublicHoliday(userContext, publicHoliday, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PublicHolidayTokens tokens(){
		return PublicHolidayTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PublicHolidayTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PublicHolidayTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String publicHolidayId, String anotherCompanyId) throws Exception
 	{
 		PublicHolidayManagerException exception = new PublicHolidayManagerException("Error Occured");
 		checkIdOfPublicHoliday(userContext, publicHolidayId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public PublicHoliday transferToAnotherCompany(RetailScmUserContext userContext, String publicHolidayId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, publicHolidayId,anotherCompanyId);
 
		PublicHoliday publicHoliday = loadPublicHoliday(userContext, publicHolidayId, allTokens());	
		synchronized(publicHoliday){
			//will be good when the publicHoliday loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			publicHoliday.setCompany(company);		
			publicHoliday = savePublicHoliday(userContext, publicHoliday, emptyOptions());
			
			return present(userContext,publicHoliday, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String publicHolidayId, int publicHolidayVersion) throws Exception {
		
		deleteInternal(userContext, publicHolidayId, publicHolidayVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String publicHolidayId, int publicHolidayVersion) throws Exception{
		getPublicHolidayDAO().delete(publicHolidayId, publicHolidayVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PublicHolidayManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getPublicHolidayDAO().deleteAll();
	}


}


