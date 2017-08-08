
package com.skynet.retailscm.employeeleave;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.leavetype.LeaveType;

import com.skynet.retailscm.leavetype.LeaveTypeDAO;
import com.skynet.retailscm.employee.EmployeeDAO;



import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.leavetype.LeaveTypeTable;




public class EmployeeLeaveManagerImpl extends RetailScmCheckerManager implements EmployeeLeaveManager {
	
	private static final String SERVICE_TYPE = "EmployeeLeave";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeLeaveDAO  employeeLeaveDAO;
 	public void setEmployeeLeaveDAO(EmployeeLeaveDAO  employeeLeaveDAO){
 	
 		if(employeeLeaveDAO == null){
 			throw new IllegalStateException("Do not try to set employeeLeaveDAO to null.");
 		}
	 	this.employeeLeaveDAO = employeeLeaveDAO;
 	}
 	public EmployeeLeaveDAO getEmployeeLeaveDAO(){
 		if(this.employeeLeaveDAO == null){
 			throw new IllegalStateException("The EmployeeLeaveDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeLeaveDAO;
 	}
 	
 	protected EmployeeLeave saveEmployeeLeave(RetailScmUserContext userContext, EmployeeLeave employeeLeave, String [] tokensExpr) throws Exception{	
 		//return getEmployeeLeaveDAO().save(employeeLeave, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeLeave(userContext, employeeLeave, tokens);
 	}
 	
 	protected EmployeeLeave saveEmployeeLeaveDetail(RetailScmUserContext userContext, EmployeeLeave employeeLeave) throws Exception{	

 		
 		return saveEmployeeLeave(userContext, employeeLeave, allTokens());
 	}
 	
 	public EmployeeLeave loadEmployeeLeave(RetailScmUserContext userContext, String employeeLeaveId, String [] tokensExpr) throws Exception{				
 
 		EmployeeLeaveManagerException exception = new EmployeeLeaveManagerException("Error Occured");
		
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeLeave, tokens);
 	}
 	
 	protected EmployeeLeave present(RetailScmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeLeave,tokens);
		
		
		return this.getEmployeeLeaveDAO().present(employeeLeave, tokens);
	}
 
 	
 	
 	public EmployeeLeave loadEmployeeLeaveDetail(RetailScmUserContext userContext, String employeeLeaveId) throws Exception{	
 		EmployeeLeaveManagerException exception = new EmployeeLeaveManagerException("Error Occured");
		
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, allTokens());

 		return present(userContext,employeeLeave, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeLeaveId) throws Exception{	
 		EmployeeLeaveManagerException exception = new EmployeeLeaveManagerException("Error Occured");
		
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeLeave employeeLeave = loadEmployeeLeave( userContext, employeeLeaveId, allTokens());

 		return present(userContext,employeeLeave, allTokens());
		
 	}
 	protected EmployeeLeave saveEmployeeLeave(RetailScmUserContext userContext, EmployeeLeave employeeLeave, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeLeaveDAO().save(employeeLeave, tokens);
 	}
 	protected EmployeeLeave loadEmployeeLeave(RetailScmUserContext userContext, String employeeLeaveId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeLeaveDAO().load(employeeLeaveId, tokens);
 	}

	



 	 
 	
 	private  LeaveTypeDAO  leaveTypeDAO;
 	public void setLeaveTypeDAO(LeaveTypeDAO leaveTypeDAO){
	 	this.leaveTypeDAO = leaveTypeDAO;
 	}
 	//------------------------------------
 	public LeaveTypeDAO getLeaveTypeDAO(){
	 	return this.leaveTypeDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens){
		super.addActions(userContext, employeeLeave, tokens);
		
		addAction(userContext, employeeLeave, tokens,"@create","createEmployeeLeave","createEmployeeLeave/","main","primary");
		addAction(userContext, employeeLeave, tokens,"@update","updateEmployeeLeave","updateEmployeeLeave/"+employeeLeave.getId()+"/","main","primary");
		addAction(userContext, employeeLeave, tokens,"@copy","cloneEmployeeLeave","cloneEmployeeLeave/"+employeeLeave.getId()+"/","main","primary");
		
		addAction(userContext, employeeLeave, tokens,"employee_leave.transfer_to_who","transferToAnotherWho","transferToAnotherWho/"+employeeLeave.getId()+"/","main","primary");
		addAction(userContext, employeeLeave, tokens,"employee_leave.transfer_to_type","transferToAnotherType","transferToAnotherType/"+employeeLeave.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeLeave employeeLeave, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeLeave createEmployeeLeave(RetailScmUserContext userContext,String whoId, String typeId, int leaveDurationHour, String remark
) throws Exception
	{
		
		EmployeeLeaveManagerException exception = new EmployeeLeaveManagerException("Error Occured");

		

		checkLeaveDurationHourOfEmployeeLeave(userContext,  leaveDurationHour, exception);
		checkRemarkOfEmployeeLeave(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeLeave employeeLeave=createNewEmployeeLeave();	

		Employee who = loadEmployee(whoId,emptyOptions());
		employeeLeave.setWho(who);
		LeaveType type = loadLeaveType(typeId,emptyOptions());
		employeeLeave.setType(type);
		employeeLeave.setLeaveDurationHour(leaveDurationHour);
		employeeLeave.setRemark(remark);

		return saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
		

		
	}
	protected EmployeeLeave createNewEmployeeLeave() 
	{
		
		return new EmployeeLeave();		
	}
	
	protected void checkParamsForUpdatingEmployeeLeave(RetailScmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeLeaveManagerException exception = new EmployeeLeaveManagerException("Error Occured");
		
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		checkVersionOfEmployeeLeave(userContext, employeeLeaveVersion, exception);
		
		

				

		
		if(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			checkLeaveDurationHourOfEmployeeLeave(userContext, parseInt(newValueExpr), exception);
		}
		if(EmployeeLeave.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeLeave(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeLeave clone(RetailScmUserContext userContext, String fromEmployeeLeaveId) throws Exception{
		
		return this.getEmployeeLeaveDAO().clone(fromEmployeeLeaveId, this.allTokens());
	}
	
	public EmployeeLeave updateEmployeeLeave(RetailScmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeLeave(userContext, employeeLeaveId, employeeLeaveVersion, property, newValueExpr, tokensExpr);
		
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());
		if(employeeLeave.getVersion() != employeeLeaveVersion){
			String message = "The target version("+employeeLeave.getVersion()+") is not equals to version("+employeeLeaveVersion+") provided";
			throw new EmployeeLeaveManagerException(message);
		}
		synchronized(employeeLeave){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeLeave.
			
			employeeLeave.changePropery(property, newValueExpr);
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, tokens().done());
			return present(userContext,employeeLeave, mergedAllTokens(tokensExpr));
			//return saveEmployeeLeave(userContext, employeeLeave, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeLeaveTokens tokens(){
		return EmployeeLeaveTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeLeaveTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeLeaveTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherWho(RetailScmUserContext userContext, String employeeLeaveId, String anotherWhoId) throws Exception
 	{
 		EmployeeLeaveManagerException exception = new EmployeeLeaveManagerException("Error Occured");
 		checkIdOfEmployeeLeave(userContext, employeeLeaveId,exception);
 		checkIdOfEmployee(userContext, anotherWhoId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeLeave transferToAnotherWho(RetailScmUserContext userContext, String employeeLeaveId, String anotherWhoId) throws Exception
 	{
 		checkParamsForTransferingAnotherWho(userContext, employeeLeaveId,anotherWhoId);
 
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());	
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee who = loadEmployee(anotherWhoId, emptyOptions());		
			employeeLeave.setWho(who);		
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
			
			return present(userContext,employeeLeave, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherType(RetailScmUserContext userContext, String employeeLeaveId, String anotherTypeId) throws Exception
 	{
 		EmployeeLeaveManagerException exception = new EmployeeLeaveManagerException("Error Occured");
 		checkIdOfEmployeeLeave(userContext, employeeLeaveId,exception);
 		checkIdOfLeaveType(userContext, anotherTypeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeLeave transferToAnotherType(RetailScmUserContext userContext, String employeeLeaveId, String anotherTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherType(userContext, employeeLeaveId,anotherTypeId);
 
		EmployeeLeave employeeLeave = loadEmployeeLeave(userContext, employeeLeaveId, allTokens());	
		synchronized(employeeLeave){
			//will be good when the employeeLeave loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LeaveType type = loadLeaveType(anotherTypeId, emptyOptions());		
			employeeLeave.setType(type);		
			employeeLeave = saveEmployeeLeave(userContext, employeeLeave, emptyOptions());
			
			return present(userContext,employeeLeave, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected LeaveType loadLeaveType(String newTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return getLeaveTypeDAO().load(newTypeId, options);
 	}
	
	 	
 	protected Employee loadEmployee(String newWhoId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newWhoId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeLeaveId, int employeeLeaveVersion) throws Exception {
		
		deleteInternal(userContext, employeeLeaveId, employeeLeaveVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeLeaveId, int employeeLeaveVersion) throws Exception{
		getEmployeeLeaveDAO().delete(employeeLeaveId, employeeLeaveVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeLeaveManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeLeaveDAO().deleteAll();
	}


}


