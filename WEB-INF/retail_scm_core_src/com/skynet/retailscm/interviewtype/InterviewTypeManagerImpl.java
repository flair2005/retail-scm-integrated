
package com.skynet.retailscm.interviewtype;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeinterview.EmployeeInterview;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.employee.Employee;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employeeinterview.EmployeeInterviewTable;




public class InterviewTypeManagerImpl extends RetailScmCheckerManager implements InterviewTypeManager {
	
	private static final String SERVICE_TYPE = "InterviewType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  InterviewTypeDAO  interviewTypeDAO;
 	public void setInterviewTypeDAO(InterviewTypeDAO  interviewTypeDAO){
 	
 		if(interviewTypeDAO == null){
 			throw new IllegalStateException("Do not try to set interviewTypeDAO to null.");
 		}
	 	this.interviewTypeDAO = interviewTypeDAO;
 	}
 	public InterviewTypeDAO getInterviewTypeDAO(){
 		if(this.interviewTypeDAO == null){
 			throw new IllegalStateException("The InterviewTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.interviewTypeDAO;
 	}
 	
 	protected InterviewType saveInterviewType(RetailScmUserContext userContext, InterviewType interviewType, String [] tokensExpr) throws Exception{	
 		//return getInterviewTypeDAO().save(interviewType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveInterviewType(userContext, interviewType, tokens);
 	}
 	
 	protected InterviewType saveInterviewTypeDetail(RetailScmUserContext userContext, InterviewType interviewType) throws Exception{	

 		
 		return saveInterviewType(userContext, interviewType, allTokens());
 	}
 	
 	public InterviewType loadInterviewType(RetailScmUserContext userContext, String interviewTypeId, String [] tokensExpr) throws Exception{				
 
 		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		InterviewType interviewType = loadInterviewType( userContext, interviewTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,interviewType, tokens);
 	}
 	
 	protected InterviewType present(RetailScmUserContext userContext, InterviewType interviewType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,interviewType,tokens);
		
		
		return this.getInterviewTypeDAO().present(interviewType, tokens);
	}
 
 	
 	
 	public InterviewType loadInterviewTypeDetail(RetailScmUserContext userContext, String interviewTypeId) throws Exception{	
 		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		InterviewType interviewType = loadInterviewType( userContext, interviewTypeId, allTokens());

 		return present(userContext,interviewType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String interviewTypeId) throws Exception{	
 		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		InterviewType interviewType = loadInterviewType( userContext, interviewTypeId, allTokens());

 		return present(userContext,interviewType, allTokens());
		
 	}
 	protected InterviewType saveInterviewType(RetailScmUserContext userContext, InterviewType interviewType, Map<String,Object>tokens) throws Exception{	
 		return getInterviewTypeDAO().save(interviewType, tokens);
 	}
 	protected InterviewType loadInterviewType(RetailScmUserContext userContext, String interviewTypeId, Map<String,Object>tokens) throws Exception{	
 		return getInterviewTypeDAO().load(interviewTypeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, InterviewType interviewType, Map<String, Object> tokens){
		super.addActions(userContext, interviewType, tokens);
		
		addAction(userContext, interviewType, tokens,"@create","createInterviewType","createInterviewType/","main","primary");
		addAction(userContext, interviewType, tokens,"@update","updateInterviewType","updateInterviewType/"+interviewType.getId()+"/","main","primary");
		addAction(userContext, interviewType, tokens,"@copy","cloneInterviewType","cloneInterviewType/"+interviewType.getId()+"/","main","primary");
		
		addAction(userContext, interviewType, tokens,"interview_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+interviewType.getId()+"/","main","primary");
		addAction(userContext, interviewType, tokens,"interview_type.addEmployeeInterview","addEmployeeInterview","addEmployeeInterview/"+interviewType.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, interviewType, tokens,"interview_type.removeEmployeeInterview","removeEmployeeInterview","removeEmployeeInterview/"+interviewType.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, interviewType, tokens,"interview_type.updateEmployeeInterview","updateEmployeeInterview","updateEmployeeInterview/"+interviewType.getId()+"/","employeeInterviewList","primary");
		addAction(userContext, interviewType, tokens,"interview_type.copyEmployeeInterviewFrom","copyEmployeeInterviewFrom","copyEmployeeInterviewFrom/"+interviewType.getId()+"/","employeeInterviewList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, InterviewType interviewType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public InterviewType createInterviewType(RetailScmUserContext userContext,String code, String companyId, String description, String detailDescription
) throws Exception
	{
		
		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");

		

		checkCodeOfInterviewType(userContext,  code, exception);
		checkDescriptionOfInterviewType(userContext,  description, exception);
		checkDetailDescriptionOfInterviewType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		InterviewType interviewType=createNewInterviewType();	

		interviewType.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		interviewType.setCompany(company);
		interviewType.setDescription(description);
		interviewType.setDetailDescription(detailDescription);

		return saveInterviewType(userContext, interviewType, emptyOptions());
		

		
	}
	protected InterviewType createNewInterviewType() 
	{
		
		return new InterviewType();		
	}
	
	protected void checkParamsForUpdatingInterviewType(RetailScmUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		checkVersionOfInterviewType(userContext, interviewTypeVersion, exception);
		

		if(InterviewType.CODE_PROPERTY.equals(property)){
			checkCodeOfInterviewType(userContext, parseString(newValueExpr), exception);
		}		

		
		if(InterviewType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfInterviewType(userContext, parseString(newValueExpr), exception);
		}
		if(InterviewType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfInterviewType(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public InterviewType clone(RetailScmUserContext userContext, String fromInterviewTypeId) throws Exception{
		
		return this.getInterviewTypeDAO().clone(fromInterviewTypeId, this.allTokens());
	}
	
	public InterviewType updateInterviewType(RetailScmUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingInterviewType(userContext, interviewTypeId, interviewTypeVersion, property, newValueExpr, tokensExpr);
		
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		if(interviewType.getVersion() != interviewTypeVersion){
			String message = "The target version("+interviewType.getVersion()+") is not equals to version("+interviewTypeVersion+") provided";
			throw new InterviewTypeManagerException(message);
		}
		synchronized(interviewType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to InterviewType.
			
			interviewType.changePropery(property, newValueExpr);
			interviewType = saveInterviewType(userContext, interviewType, tokens().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
			//return saveInterviewType(userContext, interviewType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected InterviewTypeTokens tokens(){
		return InterviewTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return InterviewTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return InterviewTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String interviewTypeId, String anotherCompanyId) throws Exception
 	{
 		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
 		checkIdOfInterviewType(userContext, interviewTypeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public InterviewType transferToAnotherCompany(RetailScmUserContext userContext, String interviewTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, interviewTypeId,anotherCompanyId);
 
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());	
		synchronized(interviewType){
			//will be good when the interviewType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			interviewType.setCompany(company);		
			interviewType = saveInterviewType(userContext, interviewType, emptyOptions());
			
			return present(userContext,interviewType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String interviewTypeId, int interviewTypeVersion) throws Exception {
		
		deleteInternal(userContext, interviewTypeId, interviewTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String interviewTypeId, int interviewTypeVersion) throws Exception{
		getInterviewTypeDAO().delete(interviewTypeId, interviewTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new InterviewTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getInterviewTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String employeeId, String remark,String [] tokensExpr) throws Exception{
		
		

		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		
		
		checkIdOfEmployee(userContext,  employeeId, exception);
		checkRemarkOfEmployeeInterview(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  InterviewType addEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String employeeId, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeInterview(userContext,interviewTypeId,employeeId, remark,tokensExpr);
		
		EmployeeInterview employeeInterview = createEmployeeInterview(userContext,employeeId, remark);
		
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			interviewType.addEmployeeInterview( employeeInterview );		
			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeInterview createEmployeeInterview(RetailScmUserContext userContext, String employeeId, String remark) throws Exception{

		EmployeeInterview employeeInterview = new EmployeeInterview();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeInterview.setEmployee(employee);		
		employeeInterview.setRemark(remark);
	
		
		return employeeInterview;
	
		
	}
	
	protected EmployeeInterview createIndexedEmployeeInterview(String id, int version){

		EmployeeInterview employeeInterview = new EmployeeInterview();
		employeeInterview.setId(id);
		employeeInterview.setVersion(version);
		return employeeInterview;			
		
	}
	protected void checkParamsForRemovingEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		

		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		checkVersionOfEmployeeInterview(userContext, employeeInterviewVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  InterviewType removeEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeInterview(userContext,interviewTypeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			interviewType.removeEmployeeInterview( employeeInterview );		
			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		

		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		checkVersionOfEmployeeInterview(userContext, employeeInterviewVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  InterviewType copyEmployeeInterviewFrom(RetailScmUserContext userContext, String interviewTypeId, 
		String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeInterview(userContext,interviewTypeId, employeeInterviewId, employeeInterviewVersion,tokensExpr);
		
		EmployeeInterview employeeInterview = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			interviewType.copyEmployeeInterviewFrom( employeeInterview );		
			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		InterviewTypeManagerException exception = new InterviewTypeManagerException("Error Occured");
		
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		checkVersionOfEmployeeInterview(userContext, employeeInterviewVersion, exception);
		

		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeInterview(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  InterviewType updateEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeInterview(userContext, interviewTypeId, employeeInterviewId, employeeInterviewVersion, property, newValueExpr,  tokensExpr);
		
		
		InterviewType interviewType = loadInterviewType(userContext, interviewTypeId, allTokens());
		
		synchronized(interviewType){ 
			//Will be good when the interviewType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//interviewType.removeEmployeeInterview( employeeInterview );	
			//make changes to AcceleraterAccount.
			EmployeeInterview employeeInterviewIndex = createIndexedEmployeeInterview(employeeInterviewId, employeeInterviewVersion);
		
			EmployeeInterview employeeInterview = interviewType.findTheEmployeeInterview(employeeInterviewIndex);
			if(employeeInterview == null){
				throw new InterviewTypeManagerException(employeeInterview+"Not found" );
			}
			
			employeeInterview.changePropery(property, newValueExpr);

			interviewType = saveInterviewType(userContext, interviewType, tokens().withEmployeeInterviewList().done());
			return present(userContext,interviewType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


