
package com.skynet.retailscm.employeeperformance;

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




public class EmployeePerformanceManagerImpl extends RetailScmCheckerManager implements EmployeePerformanceManager {
	
	private static final String SERVICE_TYPE = "EmployeePerformance";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeePerformanceDAO  employeePerformanceDAO;
 	public void setEmployeePerformanceDAO(EmployeePerformanceDAO  employeePerformanceDAO){
 	
 		if(employeePerformanceDAO == null){
 			throw new IllegalStateException("Do not try to set employeePerformanceDAO to null.");
 		}
	 	this.employeePerformanceDAO = employeePerformanceDAO;
 	}
 	public EmployeePerformanceDAO getEmployeePerformanceDAO(){
 		if(this.employeePerformanceDAO == null){
 			throw new IllegalStateException("The EmployeePerformanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeePerformanceDAO;
 	}
 	
 	protected EmployeePerformance saveEmployeePerformance(RetailScmUserContext userContext, EmployeePerformance employeePerformance, String [] tokensExpr) throws Exception{	
 		//return getEmployeePerformanceDAO().save(employeePerformance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeePerformance(userContext, employeePerformance, tokens);
 	}
 	
 	protected EmployeePerformance saveEmployeePerformanceDetail(RetailScmUserContext userContext, EmployeePerformance employeePerformance) throws Exception{	

 		
 		return saveEmployeePerformance(userContext, employeePerformance, allTokens());
 	}
 	
 	public EmployeePerformance loadEmployeePerformance(RetailScmUserContext userContext, String employeePerformanceId, String [] tokensExpr) throws Exception{				
 
 		EmployeePerformanceManagerException exception = new EmployeePerformanceManagerException("Error Occured");
		
		checkIdOfEmployeePerformance(userContext, employeePerformanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeePerformance, tokens);
 	}
 	
 	protected EmployeePerformance present(RetailScmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeePerformance,tokens);
		
		
		return this.getEmployeePerformanceDAO().present(employeePerformance, tokens);
	}
 
 	
 	
 	public EmployeePerformance loadEmployeePerformanceDetail(RetailScmUserContext userContext, String employeePerformanceId) throws Exception{	
 		EmployeePerformanceManagerException exception = new EmployeePerformanceManagerException("Error Occured");
		
		checkIdOfEmployeePerformance(userContext, employeePerformanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, allTokens());

 		return present(userContext,employeePerformance, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeePerformanceId) throws Exception{	
 		EmployeePerformanceManagerException exception = new EmployeePerformanceManagerException("Error Occured");
		
		checkIdOfEmployeePerformance(userContext, employeePerformanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeePerformance employeePerformance = loadEmployeePerformance( userContext, employeePerformanceId, allTokens());

 		return present(userContext,employeePerformance, allTokens());
		
 	}
 	protected EmployeePerformance saveEmployeePerformance(RetailScmUserContext userContext, EmployeePerformance employeePerformance, Map<String,Object>tokens) throws Exception{	
 		return getEmployeePerformanceDAO().save(employeePerformance, tokens);
 	}
 	protected EmployeePerformance loadEmployeePerformance(RetailScmUserContext userContext, String employeePerformanceId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeePerformanceDAO().load(employeePerformanceId, tokens);
 	}

	



 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens){
		super.addActions(userContext, employeePerformance, tokens);
		
		addAction(userContext, employeePerformance, tokens,"@create","createEmployeePerformance","createEmployeePerformance/","main","primary");
		addAction(userContext, employeePerformance, tokens,"@update","updateEmployeePerformance","updateEmployeePerformance/"+employeePerformance.getId()+"/","main","primary");
		addAction(userContext, employeePerformance, tokens,"@copy","cloneEmployeePerformance","cloneEmployeePerformance/"+employeePerformance.getId()+"/","main","primary");
		
		addAction(userContext, employeePerformance, tokens,"employee_performance.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeePerformance.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeePerformance employeePerformance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeePerformance createEmployeePerformance(RetailScmUserContext userContext,String employeeId, String performanceComment
) throws Exception
	{
		
		EmployeePerformanceManagerException exception = new EmployeePerformanceManagerException("Error Occured");

		

		checkPerformanceCommentOfEmployeePerformance(userContext,  performanceComment, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeePerformance employeePerformance=createNewEmployeePerformance();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeePerformance.setEmployee(employee);
		employeePerformance.setPerformanceComment(performanceComment);

		return saveEmployeePerformance(userContext, employeePerformance, emptyOptions());
		

		
	}
	protected EmployeePerformance createNewEmployeePerformance() 
	{
		
		return new EmployeePerformance();		
	}
	
	protected void checkParamsForUpdatingEmployeePerformance(RetailScmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeePerformanceManagerException exception = new EmployeePerformanceManagerException("Error Occured");
		
		checkIdOfEmployeePerformance(userContext, employeePerformanceId, exception);
		checkVersionOfEmployeePerformance(userContext, employeePerformanceVersion, exception);
		
		

		
		if(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			checkPerformanceCommentOfEmployeePerformance(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeePerformance clone(RetailScmUserContext userContext, String fromEmployeePerformanceId) throws Exception{
		
		return this.getEmployeePerformanceDAO().clone(fromEmployeePerformanceId, this.allTokens());
	}
	
	public EmployeePerformance updateEmployeePerformance(RetailScmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeePerformance(userContext, employeePerformanceId, employeePerformanceVersion, property, newValueExpr, tokensExpr);
		
		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());
		if(employeePerformance.getVersion() != employeePerformanceVersion){
			String message = "The target version("+employeePerformance.getVersion()+") is not equals to version("+employeePerformanceVersion+") provided";
			throw new EmployeePerformanceManagerException(message);
		}
		synchronized(employeePerformance){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeePerformance.
			
			employeePerformance.changePropery(property, newValueExpr);
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, tokens().done());
			return present(userContext,employeePerformance, mergedAllTokens(tokensExpr));
			//return saveEmployeePerformance(userContext, employeePerformance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeePerformanceTokens tokens(){
		return EmployeePerformanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeePerformanceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeePerformanceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeePerformanceId, String anotherEmployeeId) throws Exception
 	{
 		EmployeePerformanceManagerException exception = new EmployeePerformanceManagerException("Error Occured");
 		checkIdOfEmployeePerformance(userContext, employeePerformanceId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeePerformance transferToAnotherEmployee(RetailScmUserContext userContext, String employeePerformanceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeePerformanceId,anotherEmployeeId);
 
		EmployeePerformance employeePerformance = loadEmployeePerformance(userContext, employeePerformanceId, allTokens());	
		synchronized(employeePerformance){
			//will be good when the employeePerformance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeePerformance.setEmployee(employee);		
			employeePerformance = saveEmployeePerformance(userContext, employeePerformance, emptyOptions());
			
			return present(userContext,employeePerformance, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeePerformanceId, int employeePerformanceVersion) throws Exception {
		
		deleteInternal(userContext, employeePerformanceId, employeePerformanceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeePerformanceId, int employeePerformanceVersion) throws Exception{
		getEmployeePerformanceDAO().delete(employeePerformanceId, employeePerformanceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeePerformanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeePerformanceDAO().deleteAll();
	}


}


