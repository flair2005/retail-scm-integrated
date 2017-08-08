
package com.skynet.retailscm.employeeaward;

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




public class EmployeeAwardManagerImpl extends RetailScmCheckerManager implements EmployeeAwardManager {
	
	private static final String SERVICE_TYPE = "EmployeeAward";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeAwardDAO  employeeAwardDAO;
 	public void setEmployeeAwardDAO(EmployeeAwardDAO  employeeAwardDAO){
 	
 		if(employeeAwardDAO == null){
 			throw new IllegalStateException("Do not try to set employeeAwardDAO to null.");
 		}
	 	this.employeeAwardDAO = employeeAwardDAO;
 	}
 	public EmployeeAwardDAO getEmployeeAwardDAO(){
 		if(this.employeeAwardDAO == null){
 			throw new IllegalStateException("The EmployeeAwardDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeAwardDAO;
 	}
 	
 	protected EmployeeAward saveEmployeeAward(RetailScmUserContext userContext, EmployeeAward employeeAward, String [] tokensExpr) throws Exception{	
 		//return getEmployeeAwardDAO().save(employeeAward, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeAward(userContext, employeeAward, tokens);
 	}
 	
 	protected EmployeeAward saveEmployeeAwardDetail(RetailScmUserContext userContext, EmployeeAward employeeAward) throws Exception{	

 		
 		return saveEmployeeAward(userContext, employeeAward, allTokens());
 	}
 	
 	public EmployeeAward loadEmployeeAward(RetailScmUserContext userContext, String employeeAwardId, String [] tokensExpr) throws Exception{				
 
 		EmployeeAwardManagerException exception = new EmployeeAwardManagerException("Error Occured");
		
		checkIdOfEmployeeAward(userContext, employeeAwardId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAward, tokens);
 	}
 	
 	protected EmployeeAward present(RetailScmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeAward,tokens);
		
		
		return this.getEmployeeAwardDAO().present(employeeAward, tokens);
	}
 
 	
 	
 	public EmployeeAward loadEmployeeAwardDetail(RetailScmUserContext userContext, String employeeAwardId) throws Exception{	
 		EmployeeAwardManagerException exception = new EmployeeAwardManagerException("Error Occured");
		
		checkIdOfEmployeeAward(userContext, employeeAwardId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, allTokens());

 		return present(userContext,employeeAward, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeAwardId) throws Exception{	
 		EmployeeAwardManagerException exception = new EmployeeAwardManagerException("Error Occured");
		
		checkIdOfEmployeeAward(userContext, employeeAwardId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeAward employeeAward = loadEmployeeAward( userContext, employeeAwardId, allTokens());

 		return present(userContext,employeeAward, allTokens());
		
 	}
 	protected EmployeeAward saveEmployeeAward(RetailScmUserContext userContext, EmployeeAward employeeAward, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeAwardDAO().save(employeeAward, tokens);
 	}
 	protected EmployeeAward loadEmployeeAward(RetailScmUserContext userContext, String employeeAwardId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeAwardDAO().load(employeeAwardId, tokens);
 	}

	



 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens){
		super.addActions(userContext, employeeAward, tokens);
		
		addAction(userContext, employeeAward, tokens,"@create","createEmployeeAward","createEmployeeAward/","main","primary");
		addAction(userContext, employeeAward, tokens,"@update","updateEmployeeAward","updateEmployeeAward/"+employeeAward.getId()+"/","main","primary");
		addAction(userContext, employeeAward, tokens,"@copy","cloneEmployeeAward","cloneEmployeeAward/"+employeeAward.getId()+"/","main","primary");
		
		addAction(userContext, employeeAward, tokens,"employee_award.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeAward.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeAward employeeAward, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeAward createEmployeeAward(RetailScmUserContext userContext,String employeeId, Date completeTime, String type, String remark
) throws Exception
	{
		
		EmployeeAwardManagerException exception = new EmployeeAwardManagerException("Error Occured");

		

		checkCompleteTimeOfEmployeeAward(userContext,  completeTime, exception);
		checkTypeOfEmployeeAward(userContext,  type, exception);
		checkRemarkOfEmployeeAward(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeAward employeeAward=createNewEmployeeAward();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeAward.setEmployee(employee);
		employeeAward.setCompleteTime(completeTime);
		employeeAward.setType(type);
		employeeAward.setRemark(remark);

		return saveEmployeeAward(userContext, employeeAward, emptyOptions());
		

		
	}
	protected EmployeeAward createNewEmployeeAward() 
	{
		
		return new EmployeeAward();		
	}
	
	protected void checkParamsForUpdatingEmployeeAward(RetailScmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeAwardManagerException exception = new EmployeeAwardManagerException("Error Occured");
		
		checkIdOfEmployeeAward(userContext, employeeAwardId, exception);
		checkVersionOfEmployeeAward(userContext, employeeAwardVersion, exception);
		
		

		
		if(EmployeeAward.COMPLETE_TIME_PROPERTY.equals(property)){
			checkCompleteTimeOfEmployeeAward(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeAward.TYPE_PROPERTY.equals(property)){
			checkTypeOfEmployeeAward(userContext, parseString(newValueExpr), exception);
		}
		if(EmployeeAward.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeAward(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeAward clone(RetailScmUserContext userContext, String fromEmployeeAwardId) throws Exception{
		
		return this.getEmployeeAwardDAO().clone(fromEmployeeAwardId, this.allTokens());
	}
	
	public EmployeeAward updateEmployeeAward(RetailScmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeAward(userContext, employeeAwardId, employeeAwardVersion, property, newValueExpr, tokensExpr);
		
		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());
		if(employeeAward.getVersion() != employeeAwardVersion){
			String message = "The target version("+employeeAward.getVersion()+") is not equals to version("+employeeAwardVersion+") provided";
			throw new EmployeeAwardManagerException(message);
		}
		synchronized(employeeAward){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAward.
			
			employeeAward.changePropery(property, newValueExpr);
			employeeAward = saveEmployeeAward(userContext, employeeAward, tokens().done());
			return present(userContext,employeeAward, mergedAllTokens(tokensExpr));
			//return saveEmployeeAward(userContext, employeeAward, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeAwardTokens tokens(){
		return EmployeeAwardTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeAwardTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeAwardTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeAwardId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeAwardManagerException exception = new EmployeeAwardManagerException("Error Occured");
 		checkIdOfEmployeeAward(userContext, employeeAwardId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeAward transferToAnotherEmployee(RetailScmUserContext userContext, String employeeAwardId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeAwardId,anotherEmployeeId);
 
		EmployeeAward employeeAward = loadEmployeeAward(userContext, employeeAwardId, allTokens());	
		synchronized(employeeAward){
			//will be good when the employeeAward loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeAward.setEmployee(employee);		
			employeeAward = saveEmployeeAward(userContext, employeeAward, emptyOptions());
			
			return present(userContext,employeeAward, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeAwardId, int employeeAwardVersion) throws Exception {
		
		deleteInternal(userContext, employeeAwardId, employeeAwardVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeAwardId, int employeeAwardVersion) throws Exception{
		getEmployeeAwardDAO().delete(employeeAwardId, employeeAwardVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeAwardManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeAwardDAO().deleteAll();
	}


}


