
package com.skynet.retailscm.employeequalifier;

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




public class EmployeeQualifierManagerImpl extends RetailScmCheckerManager implements EmployeeQualifierManager {
	
	private static final String SERVICE_TYPE = "EmployeeQualifier";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeQualifierDAO  employeeQualifierDAO;
 	public void setEmployeeQualifierDAO(EmployeeQualifierDAO  employeeQualifierDAO){
 	
 		if(employeeQualifierDAO == null){
 			throw new IllegalStateException("Do not try to set employeeQualifierDAO to null.");
 		}
	 	this.employeeQualifierDAO = employeeQualifierDAO;
 	}
 	public EmployeeQualifierDAO getEmployeeQualifierDAO(){
 		if(this.employeeQualifierDAO == null){
 			throw new IllegalStateException("The EmployeeQualifierDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeQualifierDAO;
 	}
 	
 	protected EmployeeQualifier saveEmployeeQualifier(RetailScmUserContext userContext, EmployeeQualifier employeeQualifier, String [] tokensExpr) throws Exception{	
 		//return getEmployeeQualifierDAO().save(employeeQualifier, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeQualifier(userContext, employeeQualifier, tokens);
 	}
 	
 	protected EmployeeQualifier saveEmployeeQualifierDetail(RetailScmUserContext userContext, EmployeeQualifier employeeQualifier) throws Exception{	

 		
 		return saveEmployeeQualifier(userContext, employeeQualifier, allTokens());
 	}
 	
 	public EmployeeQualifier loadEmployeeQualifier(RetailScmUserContext userContext, String employeeQualifierId, String [] tokensExpr) throws Exception{				
 
 		EmployeeQualifierManagerException exception = new EmployeeQualifierManagerException("Error Occured");
		
		checkIdOfEmployeeQualifier(userContext, employeeQualifierId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeQualifier employeeQualifier = loadEmployeeQualifier( userContext, employeeQualifierId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeQualifier, tokens);
 	}
 	
 	protected EmployeeQualifier present(RetailScmUserContext userContext, EmployeeQualifier employeeQualifier, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeQualifier,tokens);
		
		
		return this.getEmployeeQualifierDAO().present(employeeQualifier, tokens);
	}
 
 	
 	
 	public EmployeeQualifier loadEmployeeQualifierDetail(RetailScmUserContext userContext, String employeeQualifierId) throws Exception{	
 		EmployeeQualifierManagerException exception = new EmployeeQualifierManagerException("Error Occured");
		
		checkIdOfEmployeeQualifier(userContext, employeeQualifierId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeQualifier employeeQualifier = loadEmployeeQualifier( userContext, employeeQualifierId, allTokens());

 		return present(userContext,employeeQualifier, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeQualifierId) throws Exception{	
 		EmployeeQualifierManagerException exception = new EmployeeQualifierManagerException("Error Occured");
		
		checkIdOfEmployeeQualifier(userContext, employeeQualifierId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeQualifier employeeQualifier = loadEmployeeQualifier( userContext, employeeQualifierId, allTokens());

 		return present(userContext,employeeQualifier, allTokens());
		
 	}
 	protected EmployeeQualifier saveEmployeeQualifier(RetailScmUserContext userContext, EmployeeQualifier employeeQualifier, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeQualifierDAO().save(employeeQualifier, tokens);
 	}
 	protected EmployeeQualifier loadEmployeeQualifier(RetailScmUserContext userContext, String employeeQualifierId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeQualifierDAO().load(employeeQualifierId, tokens);
 	}

	



 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeQualifier employeeQualifier, Map<String, Object> tokens){
		super.addActions(userContext, employeeQualifier, tokens);
		
		addAction(userContext, employeeQualifier, tokens,"@create","createEmployeeQualifier","createEmployeeQualifier/","main","primary");
		addAction(userContext, employeeQualifier, tokens,"@update","updateEmployeeQualifier","updateEmployeeQualifier/"+employeeQualifier.getId()+"/","main","primary");
		addAction(userContext, employeeQualifier, tokens,"@copy","cloneEmployeeQualifier","cloneEmployeeQualifier/"+employeeQualifier.getId()+"/","main","primary");
		
		addAction(userContext, employeeQualifier, tokens,"employee_qualifier.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeQualifier.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeQualifier employeeQualifier, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeQualifier createEmployeeQualifier(RetailScmUserContext userContext,String employeeId, Date qualifiedTime, String type, String level, String remark
) throws Exception
	{
		
		EmployeeQualifierManagerException exception = new EmployeeQualifierManagerException("Error Occured");

		

		checkQualifiedTimeOfEmployeeQualifier(userContext,  qualifiedTime, exception);
		checkTypeOfEmployeeQualifier(userContext,  type, exception);
		checkLevelOfEmployeeQualifier(userContext,  level, exception);
		checkRemarkOfEmployeeQualifier(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeQualifier employeeQualifier=createNewEmployeeQualifier();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeQualifier.setEmployee(employee);
		employeeQualifier.setQualifiedTime(qualifiedTime);
		employeeQualifier.setType(type);
		employeeQualifier.setLevel(level);
		employeeQualifier.setRemark(remark);

		return saveEmployeeQualifier(userContext, employeeQualifier, emptyOptions());
		

		
	}
	protected EmployeeQualifier createNewEmployeeQualifier() 
	{
		
		return new EmployeeQualifier();		
	}
	
	protected void checkParamsForUpdatingEmployeeQualifier(RetailScmUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeQualifierManagerException exception = new EmployeeQualifierManagerException("Error Occured");
		
		checkIdOfEmployeeQualifier(userContext, employeeQualifierId, exception);
		checkVersionOfEmployeeQualifier(userContext, employeeQualifierVersion, exception);
		
		

		
		if(EmployeeQualifier.QUALIFIED_TIME_PROPERTY.equals(property)){
			checkQualifiedTimeOfEmployeeQualifier(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeQualifier.TYPE_PROPERTY.equals(property)){
			checkTypeOfEmployeeQualifier(userContext, parseString(newValueExpr), exception);
		}
		if(EmployeeQualifier.LEVEL_PROPERTY.equals(property)){
			checkLevelOfEmployeeQualifier(userContext, parseString(newValueExpr), exception);
		}
		if(EmployeeQualifier.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeQualifier(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeQualifier clone(RetailScmUserContext userContext, String fromEmployeeQualifierId) throws Exception{
		
		return this.getEmployeeQualifierDAO().clone(fromEmployeeQualifierId, this.allTokens());
	}
	
	public EmployeeQualifier updateEmployeeQualifier(RetailScmUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeQualifier(userContext, employeeQualifierId, employeeQualifierVersion, property, newValueExpr, tokensExpr);
		
		EmployeeQualifier employeeQualifier = loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());
		if(employeeQualifier.getVersion() != employeeQualifierVersion){
			String message = "The target version("+employeeQualifier.getVersion()+") is not equals to version("+employeeQualifierVersion+") provided";
			throw new EmployeeQualifierManagerException(message);
		}
		synchronized(employeeQualifier){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeQualifier.
			
			employeeQualifier.changePropery(property, newValueExpr);
			employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
			return present(userContext,employeeQualifier, mergedAllTokens(tokensExpr));
			//return saveEmployeeQualifier(userContext, employeeQualifier, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeQualifierTokens tokens(){
		return EmployeeQualifierTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeQualifierTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeQualifierTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeQualifierId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeQualifierManagerException exception = new EmployeeQualifierManagerException("Error Occured");
 		checkIdOfEmployeeQualifier(userContext, employeeQualifierId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeQualifier transferToAnotherEmployee(RetailScmUserContext userContext, String employeeQualifierId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeQualifierId,anotherEmployeeId);
 
		EmployeeQualifier employeeQualifier = loadEmployeeQualifier(userContext, employeeQualifierId, allTokens());	
		synchronized(employeeQualifier){
			//will be good when the employeeQualifier loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeQualifier.setEmployee(employee);		
			employeeQualifier = saveEmployeeQualifier(userContext, employeeQualifier, emptyOptions());
			
			return present(userContext,employeeQualifier, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeQualifierId, int employeeQualifierVersion) throws Exception {
		
		deleteInternal(userContext, employeeQualifierId, employeeQualifierVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeQualifierId, int employeeQualifierVersion) throws Exception{
		getEmployeeQualifierDAO().delete(employeeQualifierId, employeeQualifierVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeQualifierManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeQualifierDAO().deleteAll();
	}


}


