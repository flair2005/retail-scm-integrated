
package com.skynet.retailscm.employeeattendance;

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




public class EmployeeAttendanceManagerImpl extends RetailScmCheckerManager implements EmployeeAttendanceManager {
	
	private static final String SERVICE_TYPE = "EmployeeAttendance";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeAttendanceDAO  employeeAttendanceDAO;
 	public void setEmployeeAttendanceDAO(EmployeeAttendanceDAO  employeeAttendanceDAO){
 	
 		if(employeeAttendanceDAO == null){
 			throw new IllegalStateException("Do not try to set employeeAttendanceDAO to null.");
 		}
	 	this.employeeAttendanceDAO = employeeAttendanceDAO;
 	}
 	public EmployeeAttendanceDAO getEmployeeAttendanceDAO(){
 		if(this.employeeAttendanceDAO == null){
 			throw new IllegalStateException("The EmployeeAttendanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeAttendanceDAO;
 	}
 	
 	protected EmployeeAttendance saveEmployeeAttendance(RetailScmUserContext userContext, EmployeeAttendance employeeAttendance, String [] tokensExpr) throws Exception{	
 		//return getEmployeeAttendanceDAO().save(employeeAttendance, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeAttendance(userContext, employeeAttendance, tokens);
 	}
 	
 	protected EmployeeAttendance saveEmployeeAttendanceDetail(RetailScmUserContext userContext, EmployeeAttendance employeeAttendance) throws Exception{	

 		
 		return saveEmployeeAttendance(userContext, employeeAttendance, allTokens());
 	}
 	
 	public EmployeeAttendance loadEmployeeAttendance(RetailScmUserContext userContext, String employeeAttendanceId, String [] tokensExpr) throws Exception{				
 
 		EmployeeAttendanceManagerException exception = new EmployeeAttendanceManagerException("Error Occured");
		
		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeAttendance, tokens);
 	}
 	
 	protected EmployeeAttendance present(RetailScmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeAttendance,tokens);
		
		
		return this.getEmployeeAttendanceDAO().present(employeeAttendance, tokens);
	}
 
 	
 	
 	public EmployeeAttendance loadEmployeeAttendanceDetail(RetailScmUserContext userContext, String employeeAttendanceId) throws Exception{	
 		EmployeeAttendanceManagerException exception = new EmployeeAttendanceManagerException("Error Occured");
		
		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, allTokens());

 		return present(userContext,employeeAttendance, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeAttendanceId) throws Exception{	
 		EmployeeAttendanceManagerException exception = new EmployeeAttendanceManagerException("Error Occured");
		
		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeAttendance employeeAttendance = loadEmployeeAttendance( userContext, employeeAttendanceId, allTokens());

 		return present(userContext,employeeAttendance, allTokens());
		
 	}
 	protected EmployeeAttendance saveEmployeeAttendance(RetailScmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeAttendanceDAO().save(employeeAttendance, tokens);
 	}
 	protected EmployeeAttendance loadEmployeeAttendance(RetailScmUserContext userContext, String employeeAttendanceId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeAttendanceDAO().load(employeeAttendanceId, tokens);
 	}

	



 	 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens){
		super.addActions(userContext, employeeAttendance, tokens);
		
		addAction(userContext, employeeAttendance, tokens,"@create","createEmployeeAttendance","createEmployeeAttendance/","main","primary");
		addAction(userContext, employeeAttendance, tokens,"@update","updateEmployeeAttendance","updateEmployeeAttendance/"+employeeAttendance.getId()+"/","main","primary");
		addAction(userContext, employeeAttendance, tokens,"@copy","cloneEmployeeAttendance","cloneEmployeeAttendance/"+employeeAttendance.getId()+"/","main","primary");
		
		addAction(userContext, employeeAttendance, tokens,"employee_attendance.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeAttendance.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeAttendance employeeAttendance, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeAttendance createEmployeeAttendance(RetailScmUserContext userContext,String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark
) throws Exception
	{
		
		EmployeeAttendanceManagerException exception = new EmployeeAttendanceManagerException("Error Occured");

		

		checkEnterTimeOfEmployeeAttendance(userContext,  enterTime, exception);
		checkLeaveTimeOfEmployeeAttendance(userContext,  leaveTime, exception);
		checkDurationHoursOfEmployeeAttendance(userContext,  durationHours, exception);
		checkRemarkOfEmployeeAttendance(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeAttendance employeeAttendance=createNewEmployeeAttendance();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeAttendance.setEmployee(employee);
		employeeAttendance.setEnterTime(enterTime);
		employeeAttendance.setLeaveTime(leaveTime);
		employeeAttendance.setDurationHours(durationHours);
		employeeAttendance.setRemark(remark);

		return saveEmployeeAttendance(userContext, employeeAttendance, emptyOptions());
		

		
	}
	protected EmployeeAttendance createNewEmployeeAttendance() 
	{
		
		return new EmployeeAttendance();		
	}
	
	protected void checkParamsForUpdatingEmployeeAttendance(RetailScmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeAttendanceManagerException exception = new EmployeeAttendanceManagerException("Error Occured");
		
		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId, exception);
		checkVersionOfEmployeeAttendance(userContext, employeeAttendanceVersion, exception);
		
		

		
		if(EmployeeAttendance.ENTER_TIME_PROPERTY.equals(property)){
			checkEnterTimeOfEmployeeAttendance(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeAttendance.LEAVE_TIME_PROPERTY.equals(property)){
			checkLeaveTimeOfEmployeeAttendance(userContext, parseDate(newValueExpr), exception);
		}
		if(EmployeeAttendance.DURATION_HOURS_PROPERTY.equals(property)){
			checkDurationHoursOfEmployeeAttendance(userContext, parseInt(newValueExpr), exception);
		}
		if(EmployeeAttendance.REMARK_PROPERTY.equals(property)){
			checkRemarkOfEmployeeAttendance(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeAttendance clone(RetailScmUserContext userContext, String fromEmployeeAttendanceId) throws Exception{
		
		return this.getEmployeeAttendanceDAO().clone(fromEmployeeAttendanceId, this.allTokens());
	}
	
	public EmployeeAttendance updateEmployeeAttendance(RetailScmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeAttendance(userContext, employeeAttendanceId, employeeAttendanceVersion, property, newValueExpr, tokensExpr);
		
		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());
		if(employeeAttendance.getVersion() != employeeAttendanceVersion){
			String message = "The target version("+employeeAttendance.getVersion()+") is not equals to version("+employeeAttendanceVersion+") provided";
			throw new EmployeeAttendanceManagerException(message);
		}
		synchronized(employeeAttendance){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeAttendance.
			
			employeeAttendance.changePropery(property, newValueExpr);
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
			return present(userContext,employeeAttendance, mergedAllTokens(tokensExpr));
			//return saveEmployeeAttendance(userContext, employeeAttendance, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeAttendanceTokens tokens(){
		return EmployeeAttendanceTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeAttendanceTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeAttendanceTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeAttendanceId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeAttendanceManagerException exception = new EmployeeAttendanceManagerException("Error Occured");
 		checkIdOfEmployeeAttendance(userContext, employeeAttendanceId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeAttendance transferToAnotherEmployee(RetailScmUserContext userContext, String employeeAttendanceId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeAttendanceId,anotherEmployeeId);
 
		EmployeeAttendance employeeAttendance = loadEmployeeAttendance(userContext, employeeAttendanceId, allTokens());	
		synchronized(employeeAttendance){
			//will be good when the employeeAttendance loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeAttendance.setEmployee(employee);		
			employeeAttendance = saveEmployeeAttendance(userContext, employeeAttendance, emptyOptions());
			
			return present(userContext,employeeAttendance, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeAttendanceId, int employeeAttendanceVersion) throws Exception {
		
		deleteInternal(userContext, employeeAttendanceId, employeeAttendanceVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeAttendanceId, int employeeAttendanceVersion) throws Exception{
		getEmployeeAttendanceDAO().delete(employeeAttendanceId, employeeAttendanceVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeAttendanceManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeAttendanceDAO().deleteAll();
	}


}


