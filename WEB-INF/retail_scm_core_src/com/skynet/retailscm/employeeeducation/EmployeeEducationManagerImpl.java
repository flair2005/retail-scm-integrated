
package com.skynet.retailscm.employeeeducation;

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




public class EmployeeEducationManagerImpl extends RetailScmCheckerManager implements EmployeeEducationManager {
	
	private static final String SERVICE_TYPE = "EmployeeEducation";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeEducationDAO  employeeEducationDAO;
 	public void setEmployeeEducationDAO(EmployeeEducationDAO  employeeEducationDAO){
 	
 		if(employeeEducationDAO == null){
 			throw new IllegalStateException("Do not try to set employeeEducationDAO to null.");
 		}
	 	this.employeeEducationDAO = employeeEducationDAO;
 	}
 	public EmployeeEducationDAO getEmployeeEducationDAO(){
 		if(this.employeeEducationDAO == null){
 			throw new IllegalStateException("The EmployeeEducationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeEducationDAO;
 	}
 	
 	protected EmployeeEducation saveEmployeeEducation(RetailScmUserContext userContext, EmployeeEducation employeeEducation, String [] tokensExpr) throws Exception{	
 		//return getEmployeeEducationDAO().save(employeeEducation, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeEducation(userContext, employeeEducation, tokens);
 	}
 	
 	protected EmployeeEducation saveEmployeeEducationDetail(RetailScmUserContext userContext, EmployeeEducation employeeEducation) throws Exception{	

 		
 		return saveEmployeeEducation(userContext, employeeEducation, allTokens());
 	}
 	
 	public EmployeeEducation loadEmployeeEducation(RetailScmUserContext userContext, String employeeEducationId, String [] tokensExpr) throws Exception{				
 
 		EmployeeEducationManagerException exception = new EmployeeEducationManagerException("Error Occured");
		
		checkIdOfEmployeeEducation(userContext, employeeEducationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeEducation, tokens);
 	}
 	
 	protected EmployeeEducation present(RetailScmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeEducation,tokens);
		
		
		return this.getEmployeeEducationDAO().present(employeeEducation, tokens);
	}
 
 	
 	
 	public EmployeeEducation loadEmployeeEducationDetail(RetailScmUserContext userContext, String employeeEducationId) throws Exception{	
 		EmployeeEducationManagerException exception = new EmployeeEducationManagerException("Error Occured");
		
		checkIdOfEmployeeEducation(userContext, employeeEducationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, allTokens());

 		return present(userContext,employeeEducation, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeEducationId) throws Exception{	
 		EmployeeEducationManagerException exception = new EmployeeEducationManagerException("Error Occured");
		
		checkIdOfEmployeeEducation(userContext, employeeEducationId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeEducation employeeEducation = loadEmployeeEducation( userContext, employeeEducationId, allTokens());

 		return present(userContext,employeeEducation, allTokens());
		
 	}
 	protected EmployeeEducation saveEmployeeEducation(RetailScmUserContext userContext, EmployeeEducation employeeEducation, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeEducationDAO().save(employeeEducation, tokens);
 	}
 	protected EmployeeEducation loadEmployeeEducation(RetailScmUserContext userContext, String employeeEducationId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeEducationDAO().load(employeeEducationId, tokens);
 	}

	



 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens){
		super.addActions(userContext, employeeEducation, tokens);
		
		addAction(userContext, employeeEducation, tokens,"@create","createEmployeeEducation","createEmployeeEducation/","main","primary");
		addAction(userContext, employeeEducation, tokens,"@update","updateEmployeeEducation","updateEmployeeEducation/"+employeeEducation.getId()+"/","main","primary");
		addAction(userContext, employeeEducation, tokens,"@copy","cloneEmployeeEducation","cloneEmployeeEducation/"+employeeEducation.getId()+"/","main","primary");
		
		addAction(userContext, employeeEducation, tokens,"employee_education.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeEducation.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeEducation employeeEducation, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeEducation createEmployeeEducation(RetailScmUserContext userContext,String employeeId, Date completeTime, String type, String remark
) throws Exception
	{
		
		EmployeeEducationManagerException exception = new EmployeeEducationManagerException("Error Occured");

		

		checkCompleteTimeOfEmployeeEducation(userContext,  completeTime, exception);
		checkTypeOfEmployeeEducation(userContext,  type, exception);
		checkRemarkOfEmployeeEducation(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeEducation employeeEducation=createNewEmployeeEducation();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeEducation.setEmployee(employee);
		employeeEducation.setCompleteTime(completeTime);
		employeeEducation.setType(type);
		employeeEducation.setRemark(remark);

		return saveEmployeeEducation(userContext, employeeEducation, emptyOptions());
		

		
	}
	protected EmployeeEducation createNewEmployeeEducation() 
	{
		
		return new EmployeeEducation();		
	}
	
	protected void checkParamsForUpdatingEmployeeEducation(RetailScmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeEducationManagerException exception = new EmployeeEducationManagerException("Error Occured");
		
		checkIdOfEmployeeEducation(userContext, employeeEducationId, exception);
		checkVersionOfEmployeeEducation(userContext, employeeEducationVersion, exception);
		
		

		
		if(EmployeeEducation.COMPLETE_TIME_PROPERTY.equals(property)){
			checkCompleteTimeOfEmployeeEducation(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeEducation.TYPE_PROPERTY.equals(property)){
			checkTypeOfEmployeeEducation(userContext, parseString(newValueExpr), exception);
		}
		if(EmployeeEducation.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeEducation(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeEducation clone(RetailScmUserContext userContext, String fromEmployeeEducationId) throws Exception{
		
		return this.getEmployeeEducationDAO().clone(fromEmployeeEducationId, this.allTokens());
	}
	
	public EmployeeEducation updateEmployeeEducation(RetailScmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeEducation(userContext, employeeEducationId, employeeEducationVersion, property, newValueExpr, tokensExpr);
		
		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());
		if(employeeEducation.getVersion() != employeeEducationVersion){
			String message = "The target version("+employeeEducation.getVersion()+") is not equals to version("+employeeEducationVersion+") provided";
			throw new EmployeeEducationManagerException(message);
		}
		synchronized(employeeEducation){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeEducation.
			
			employeeEducation.changePropery(property, newValueExpr);
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, tokens().done());
			return present(userContext,employeeEducation, mergedAllTokens(tokensExpr));
			//return saveEmployeeEducation(userContext, employeeEducation, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeEducationTokens tokens(){
		return EmployeeEducationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeEducationTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeEducationTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeEducationId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeEducationManagerException exception = new EmployeeEducationManagerException("Error Occured");
 		checkIdOfEmployeeEducation(userContext, employeeEducationId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeEducation transferToAnotherEmployee(RetailScmUserContext userContext, String employeeEducationId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeEducationId,anotherEmployeeId);
 
		EmployeeEducation employeeEducation = loadEmployeeEducation(userContext, employeeEducationId, allTokens());	
		synchronized(employeeEducation){
			//will be good when the employeeEducation loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeEducation.setEmployee(employee);		
			employeeEducation = saveEmployeeEducation(userContext, employeeEducation, emptyOptions());
			
			return present(userContext,employeeEducation, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeEducationId, int employeeEducationVersion) throws Exception {
		
		deleteInternal(userContext, employeeEducationId, employeeEducationVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeEducationId, int employeeEducationVersion) throws Exception{
		getEmployeeEducationDAO().delete(employeeEducationId, employeeEducationVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeEducationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeEducationDAO().deleteAll();
	}


}


