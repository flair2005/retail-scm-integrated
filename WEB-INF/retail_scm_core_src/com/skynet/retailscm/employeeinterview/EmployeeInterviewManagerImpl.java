
package com.skynet.retailscm.employeeinterview;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.interviewtype.InterviewTypeDAO;
import com.skynet.retailscm.employee.EmployeeDAO;



import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.interviewtype.InterviewTypeTable;




public class EmployeeInterviewManagerImpl extends RetailScmCheckerManager implements EmployeeInterviewManager {
	
	private static final String SERVICE_TYPE = "EmployeeInterview";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeInterviewDAO  employeeInterviewDAO;
 	public void setEmployeeInterviewDAO(EmployeeInterviewDAO  employeeInterviewDAO){
 	
 		if(employeeInterviewDAO == null){
 			throw new IllegalStateException("Do not try to set employeeInterviewDAO to null.");
 		}
	 	this.employeeInterviewDAO = employeeInterviewDAO;
 	}
 	public EmployeeInterviewDAO getEmployeeInterviewDAO(){
 		if(this.employeeInterviewDAO == null){
 			throw new IllegalStateException("The EmployeeInterviewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeInterviewDAO;
 	}
 	
 	protected EmployeeInterview saveEmployeeInterview(RetailScmUserContext userContext, EmployeeInterview employeeInterview, String [] tokensExpr) throws Exception{	
 		//return getEmployeeInterviewDAO().save(employeeInterview, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeInterview(userContext, employeeInterview, tokens);
 	}
 	
 	protected EmployeeInterview saveEmployeeInterviewDetail(RetailScmUserContext userContext, EmployeeInterview employeeInterview) throws Exception{	

 		
 		return saveEmployeeInterview(userContext, employeeInterview, allTokens());
 	}
 	
 	public EmployeeInterview loadEmployeeInterview(RetailScmUserContext userContext, String employeeInterviewId, String [] tokensExpr) throws Exception{				
 
 		EmployeeInterviewManagerException exception = new EmployeeInterviewManagerException("Error Occured");
		
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeInterview, tokens);
 	}
 	
 	protected EmployeeInterview present(RetailScmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeInterview,tokens);
		
		
		return this.getEmployeeInterviewDAO().present(employeeInterview, tokens);
	}
 
 	
 	
 	public EmployeeInterview loadEmployeeInterviewDetail(RetailScmUserContext userContext, String employeeInterviewId) throws Exception{	
 		EmployeeInterviewManagerException exception = new EmployeeInterviewManagerException("Error Occured");
		
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, allTokens());

 		return present(userContext,employeeInterview, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeInterviewId) throws Exception{	
 		EmployeeInterviewManagerException exception = new EmployeeInterviewManagerException("Error Occured");
		
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeInterview employeeInterview = loadEmployeeInterview( userContext, employeeInterviewId, allTokens());

 		return present(userContext,employeeInterview, allTokens());
		
 	}
 	protected EmployeeInterview saveEmployeeInterview(RetailScmUserContext userContext, EmployeeInterview employeeInterview, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeInterviewDAO().save(employeeInterview, tokens);
 	}
 	protected EmployeeInterview loadEmployeeInterview(RetailScmUserContext userContext, String employeeInterviewId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeInterviewDAO().load(employeeInterviewId, tokens);
 	}

	



 	 
 	
 	private  InterviewTypeDAO  interviewTypeDAO;
 	public void setInterviewTypeDAO(InterviewTypeDAO interviewTypeDAO){
	 	this.interviewTypeDAO = interviewTypeDAO;
 	}
 	//------------------------------------
 	public InterviewTypeDAO getInterviewTypeDAO(){
	 	return this.interviewTypeDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){
		super.addActions(userContext, employeeInterview, tokens);
		
		addAction(userContext, employeeInterview, tokens,"@create","createEmployeeInterview","createEmployeeInterview/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@update","updateEmployeeInterview","updateEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"@copy","cloneEmployeeInterview","cloneEmployeeInterview/"+employeeInterview.getId()+"/","main","primary");
		
		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeInterview.getId()+"/","main","primary");
		addAction(userContext, employeeInterview, tokens,"employee_interview.transfer_to_interview_type","transferToAnotherInterviewType","transferToAnotherInterviewType/"+employeeInterview.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeInterview employeeInterview, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeInterview createEmployeeInterview(RetailScmUserContext userContext,String employeeId, String interviewTypeId, String remark
) throws Exception
	{
		
		EmployeeInterviewManagerException exception = new EmployeeInterviewManagerException("Error Occured");

		

		checkRemarkOfEmployeeInterview(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeInterview employeeInterview=createNewEmployeeInterview();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeInterview.setEmployee(employee);
		InterviewType interviewType = loadInterviewType(interviewTypeId,emptyOptions());
		employeeInterview.setInterviewType(interviewType);
		employeeInterview.setRemark(remark);

		return saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
		

		
	}
	protected EmployeeInterview createNewEmployeeInterview() 
	{
		
		return new EmployeeInterview();		
	}
	
	protected void checkParamsForUpdatingEmployeeInterview(RetailScmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeInterviewManagerException exception = new EmployeeInterviewManagerException("Error Occured");
		
		checkIdOfEmployeeInterview(userContext, employeeInterviewId, exception);
		checkVersionOfEmployeeInterview(userContext, employeeInterviewVersion, exception);
		
		

				

		
		if(EmployeeInterview.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeInterview(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeInterview clone(RetailScmUserContext userContext, String fromEmployeeInterviewId) throws Exception{
		
		return this.getEmployeeInterviewDAO().clone(fromEmployeeInterviewId, this.allTokens());
	}
	
	public EmployeeInterview updateEmployeeInterview(RetailScmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeInterview(userContext, employeeInterviewId, employeeInterviewVersion, property, newValueExpr, tokensExpr);
		
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());
		if(employeeInterview.getVersion() != employeeInterviewVersion){
			String message = "The target version("+employeeInterview.getVersion()+") is not equals to version("+employeeInterviewVersion+") provided";
			throw new EmployeeInterviewManagerException(message);
		}
		synchronized(employeeInterview){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeInterview.
			
			employeeInterview.changePropery(property, newValueExpr);
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, tokens().done());
			return present(userContext,employeeInterview, mergedAllTokens(tokensExpr));
			//return saveEmployeeInterview(userContext, employeeInterview, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeInterviewTokens tokens(){
		return EmployeeInterviewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeInterviewTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeInterviewTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeInterviewManagerException exception = new EmployeeInterviewManagerException("Error Occured");
 		checkIdOfEmployeeInterview(userContext, employeeInterviewId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeInterview transferToAnotherEmployee(RetailScmUserContext userContext, String employeeInterviewId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeInterviewId,anotherEmployeeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());	
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeInterview.setEmployee(employee);		
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
			
			return present(userContext,employeeInterview, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherInterviewType(RetailScmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{
 		EmployeeInterviewManagerException exception = new EmployeeInterviewManagerException("Error Occured");
 		checkIdOfEmployeeInterview(userContext, employeeInterviewId,exception);
 		checkIdOfInterviewType(userContext, anotherInterviewTypeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeInterview transferToAnotherInterviewType(RetailScmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherInterviewType(userContext, employeeInterviewId,anotherInterviewTypeId);
 
		EmployeeInterview employeeInterview = loadEmployeeInterview(userContext, employeeInterviewId, allTokens());	
		synchronized(employeeInterview){
			//will be good when the employeeInterview loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			InterviewType interviewType = loadInterviewType(anotherInterviewTypeId, emptyOptions());		
			employeeInterview.setInterviewType(interviewType);		
			employeeInterview = saveEmployeeInterview(userContext, employeeInterview, emptyOptions());
			
			return present(userContext,employeeInterview, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected InterviewType loadInterviewType(String newInterviewTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return getInterviewTypeDAO().load(newInterviewTypeId, options);
 	}
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeInterviewId, int employeeInterviewVersion) throws Exception {
		
		deleteInternal(userContext, employeeInterviewId, employeeInterviewVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeInterviewId, int employeeInterviewVersion) throws Exception{
		getEmployeeInterviewDAO().delete(employeeInterviewId, employeeInterviewVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeInterviewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeInterviewDAO().deleteAll();
	}


}


