
package com.skynet.retailscm.employeeworkexperience;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.employee.EmployeeDAO;



import com.skynet.retailscm.employee.EmployeeTable;




public class EmployeeWorkExperienceManagerImpl extends RetailScmCheckerManager implements EmployeeWorkExperienceManager {
	
	private static final String SERVICE_TYPE = "EmployeeWorkExperience";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeWorkExperienceDAO  employeeWorkExperienceDAO;
 	public void setEmployeeWorkExperienceDAO(EmployeeWorkExperienceDAO  employeeWorkExperienceDAO){
 	
 		if(employeeWorkExperienceDAO == null){
 			throw new IllegalStateException("Do not try to set employeeWorkExperienceDAO to null.");
 		}
	 	this.employeeWorkExperienceDAO = employeeWorkExperienceDAO;
 	}
 	public EmployeeWorkExperienceDAO getEmployeeWorkExperienceDAO(){
 		if(this.employeeWorkExperienceDAO == null){
 			throw new IllegalStateException("The EmployeeWorkExperienceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeWorkExperienceDAO;
 	}
 	
 	protected EmployeeWorkExperience saveEmployeeWorkExperience(RetailScmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, String [] tokensExpr) throws Exception{	
 		//return getEmployeeWorkExperienceDAO().save(employeeWorkExperience, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens);
 	}
 	
 	protected EmployeeWorkExperience saveEmployeeWorkExperienceDetail(RetailScmUserContext userContext, EmployeeWorkExperience employeeWorkExperience) throws Exception{	

 		
 		return saveEmployeeWorkExperience(userContext, employeeWorkExperience, allTokens());
 	}
 	
 	public EmployeeWorkExperience loadEmployeeWorkExperience(RetailScmUserContext userContext, String employeeWorkExperienceId, String [] tokensExpr) throws Exception{				
 
 		EmployeeWorkExperienceManagerException exception = new EmployeeWorkExperienceManagerException("Error Occured");
		
		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeWorkExperience, tokens);
 	}
 	
 	protected EmployeeWorkExperience present(RetailScmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeWorkExperience,tokens);
		
		
		return this.getEmployeeWorkExperienceDAO().present(employeeWorkExperience, tokens);
	}
 
 	
 	
 	public EmployeeWorkExperience loadEmployeeWorkExperienceDetail(RetailScmUserContext userContext, String employeeWorkExperienceId) throws Exception{	
 		EmployeeWorkExperienceManagerException exception = new EmployeeWorkExperienceManagerException("Error Occured");
		
		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, allTokens());

 		return present(userContext,employeeWorkExperience, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeWorkExperienceId) throws Exception{	
 		EmployeeWorkExperienceManagerException exception = new EmployeeWorkExperienceManagerException("Error Occured");
		
		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience( userContext, employeeWorkExperienceId, allTokens());

 		return present(userContext,employeeWorkExperience, allTokens());
		
 	}
 	protected EmployeeWorkExperience saveEmployeeWorkExperience(RetailScmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeWorkExperienceDAO().save(employeeWorkExperience, tokens);
 	}
 	protected EmployeeWorkExperience loadEmployeeWorkExperience(RetailScmUserContext userContext, String employeeWorkExperienceId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeWorkExperienceDAO().load(employeeWorkExperienceId, tokens);
 	}

	



 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String, Object> tokens){
		super.addActions(userContext, employeeWorkExperience, tokens);
		
		addAction(userContext, employeeWorkExperience, tokens,"@create","createEmployeeWorkExperience","createEmployeeWorkExperience/","main","primary");
		addAction(userContext, employeeWorkExperience, tokens,"@update","updateEmployeeWorkExperience","updateEmployeeWorkExperience/"+employeeWorkExperience.getId()+"/","main","primary");
		addAction(userContext, employeeWorkExperience, tokens,"@copy","cloneEmployeeWorkExperience","cloneEmployeeWorkExperience/"+employeeWorkExperience.getId()+"/","main","primary");
		
		addAction(userContext, employeeWorkExperience, tokens,"employee_work_experience.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeWorkExperience.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeWorkExperience employeeWorkExperience, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeWorkExperience createEmployeeWorkExperience(RetailScmUserContext userContext,String employeeId, Date start, Date end, String company, String description
) throws Exception
	{
		
		EmployeeWorkExperienceManagerException exception = new EmployeeWorkExperienceManagerException("Error Occured");

		

		checkStartOfEmployeeWorkExperience(userContext,  start, exception);
		checkEndOfEmployeeWorkExperience(userContext,  end, exception);
		checkCompanyOfEmployeeWorkExperience(userContext,  company, exception);
		checkDescriptionOfEmployeeWorkExperience(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeWorkExperience employeeWorkExperience=createNewEmployeeWorkExperience();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeWorkExperience.setEmployee(employee);
		employeeWorkExperience.setStart(start);
		employeeWorkExperience.setEnd(end);
		employeeWorkExperience.setCompany(company);
		employeeWorkExperience.setDescription(description);

		return saveEmployeeWorkExperience(userContext, employeeWorkExperience, emptyOptions());
		

		
	}
	protected EmployeeWorkExperience createNewEmployeeWorkExperience() 
	{
		
		return new EmployeeWorkExperience();		
	}
	
	protected void checkParamsForUpdatingEmployeeWorkExperience(RetailScmUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeWorkExperienceManagerException exception = new EmployeeWorkExperienceManagerException("Error Occured");
		
		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId, exception);
		checkVersionOfEmployeeWorkExperience(userContext, employeeWorkExperienceVersion, exception);
		
		

		
		if(EmployeeWorkExperience.START_PROPERTY.equals(property)){
			checkStartOfEmployeeWorkExperience(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeWorkExperience.END_PROPERTY.equals(property)){
			checkEndOfEmployeeWorkExperience(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeWorkExperience.COMPANY_PROPERTY.equals(property)){
			checkCompanyOfEmployeeWorkExperience(userContext, parseString(newValueExpr), exception);
		}
		if(EmployeeWorkExperience.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfEmployeeWorkExperience(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeWorkExperience clone(RetailScmUserContext userContext, String fromEmployeeWorkExperienceId) throws Exception{
		
		return this.getEmployeeWorkExperienceDAO().clone(fromEmployeeWorkExperienceId, this.allTokens());
	}
	
	public EmployeeWorkExperience updateEmployeeWorkExperience(RetailScmUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeWorkExperience(userContext, employeeWorkExperienceId, employeeWorkExperienceVersion, property, newValueExpr, tokensExpr);
		
		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience(userContext, employeeWorkExperienceId, allTokens());
		if(employeeWorkExperience.getVersion() != employeeWorkExperienceVersion){
			String message = "The target version("+employeeWorkExperience.getVersion()+") is not equals to version("+employeeWorkExperienceVersion+") provided";
			throw new EmployeeWorkExperienceManagerException(message);
		}
		synchronized(employeeWorkExperience){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeWorkExperience.
			
			employeeWorkExperience.changePropery(property, newValueExpr);
			employeeWorkExperience = saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens().done());
			return present(userContext,employeeWorkExperience, mergedAllTokens(tokensExpr));
			//return saveEmployeeWorkExperience(userContext, employeeWorkExperience, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeWorkExperienceTokens tokens(){
		return EmployeeWorkExperienceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeWorkExperienceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeWorkExperienceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeWorkExperienceId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeWorkExperienceManagerException exception = new EmployeeWorkExperienceManagerException("Error Occured");
 		checkIdOfEmployeeWorkExperience(userContext, employeeWorkExperienceId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeWorkExperience transferToAnotherEmployee(RetailScmUserContext userContext, String employeeWorkExperienceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeWorkExperienceId,anotherEmployeeId);
 
		EmployeeWorkExperience employeeWorkExperience = loadEmployeeWorkExperience(userContext, employeeWorkExperienceId, allTokens());	
		synchronized(employeeWorkExperience){
			//will be good when the employeeWorkExperience loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeWorkExperience.setEmployee(employee);		
			employeeWorkExperience = saveEmployeeWorkExperience(userContext, employeeWorkExperience, emptyOptions());
			
			return present(userContext,employeeWorkExperience, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeWorkExperienceId, int employeeWorkExperienceVersion) throws Exception {
		
		deleteInternal(userContext, employeeWorkExperienceId, employeeWorkExperienceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeWorkExperienceId, int employeeWorkExperienceVersion) throws Exception{
		getEmployeeWorkExperienceDAO().delete(employeeWorkExperienceId, employeeWorkExperienceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeWorkExperienceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeWorkExperienceDAO().deleteAll();
	}


}


