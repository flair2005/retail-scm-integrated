
package com.skynet.retailscm.leavetype;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeleave.EmployeeLeave;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.leavetype.LeaveType;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employeeleave.EmployeeLeaveTable;




public class LeaveTypeManagerImpl extends RetailScmCheckerManager implements LeaveTypeManager {
	
	private static final String SERVICE_TYPE = "LeaveType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  LeaveTypeDAO  leaveTypeDAO;
 	public void setLeaveTypeDAO(LeaveTypeDAO  leaveTypeDAO){
 	
 		if(leaveTypeDAO == null){
 			throw new IllegalStateException("Do not try to set leaveTypeDAO to null.");
 		}
	 	this.leaveTypeDAO = leaveTypeDAO;
 	}
 	public LeaveTypeDAO getLeaveTypeDAO(){
 		if(this.leaveTypeDAO == null){
 			throw new IllegalStateException("The LeaveTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.leaveTypeDAO;
 	}
 	
 	protected LeaveType saveLeaveType(RetailScmUserContext userContext, LeaveType leaveType, String [] tokensExpr) throws Exception{	
 		//return getLeaveTypeDAO().save(leaveType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLeaveType(userContext, leaveType, tokens);
 	}
 	
 	protected LeaveType saveLeaveTypeDetail(RetailScmUserContext userContext, LeaveType leaveType) throws Exception{	

 		
 		return saveLeaveType(userContext, leaveType, allTokens());
 	}
 	
 	public LeaveType loadLeaveType(RetailScmUserContext userContext, String leaveTypeId, String [] tokensExpr) throws Exception{				
 
 		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LeaveType leaveType = loadLeaveType( userContext, leaveTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,leaveType, tokens);
 	}
 	
 	protected LeaveType present(RetailScmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,leaveType,tokens);
		
		
		return this.getLeaveTypeDAO().present(leaveType, tokens);
	}
 
 	
 	
 	public LeaveType loadLeaveTypeDetail(RetailScmUserContext userContext, String leaveTypeId) throws Exception{	
 		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LeaveType leaveType = loadLeaveType( userContext, leaveTypeId, allTokens());

 		return present(userContext,leaveType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String leaveTypeId) throws Exception{	
 		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		LeaveType leaveType = loadLeaveType( userContext, leaveTypeId, allTokens());

 		return present(userContext,leaveType, allTokens());
		
 	}
 	protected LeaveType saveLeaveType(RetailScmUserContext userContext, LeaveType leaveType, Map<String,Object>tokens) throws Exception{	
 		return getLeaveTypeDAO().save(leaveType, tokens);
 	}
 	protected LeaveType loadLeaveType(RetailScmUserContext userContext, String leaveTypeId, Map<String,Object>tokens) throws Exception{	
 		return getLeaveTypeDAO().load(leaveTypeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens){
		super.addActions(userContext, leaveType, tokens);
		
		addAction(userContext, leaveType, tokens,"@create","createLeaveType","createLeaveType/","main","primary");
		addAction(userContext, leaveType, tokens,"@update","updateLeaveType","updateLeaveType/"+leaveType.getId()+"/","main","primary");
		addAction(userContext, leaveType, tokens,"@copy","cloneLeaveType","cloneLeaveType/"+leaveType.getId()+"/","main","primary");
		
		addAction(userContext, leaveType, tokens,"leave_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+leaveType.getId()+"/","main","primary");
		addAction(userContext, leaveType, tokens,"leave_type.addEmployeeLeave","addEmployeeLeave","addEmployeeLeave/"+leaveType.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, leaveType, tokens,"leave_type.removeEmployeeLeave","removeEmployeeLeave","removeEmployeeLeave/"+leaveType.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, leaveType, tokens,"leave_type.updateEmployeeLeave","updateEmployeeLeave","updateEmployeeLeave/"+leaveType.getId()+"/","employeeLeaveList","primary");
		addAction(userContext, leaveType, tokens,"leave_type.copyEmployeeLeaveFrom","copyEmployeeLeaveFrom","copyEmployeeLeaveFrom/"+leaveType.getId()+"/","employeeLeaveList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, LeaveType leaveType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LeaveType createLeaveType(RetailScmUserContext userContext,String code, String companyId, String description, String detailDescription
) throws Exception
	{
		
		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");

		

		checkCodeOfLeaveType(userContext,  code, exception);
		checkDescriptionOfLeaveType(userContext,  description, exception);
		checkDetailDescriptionOfLeaveType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		LeaveType leaveType=createNewLeaveType();	

		leaveType.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		leaveType.setCompany(company);
		leaveType.setDescription(description);
		leaveType.setDetailDescription(detailDescription);

		return saveLeaveType(userContext, leaveType, emptyOptions());
		

		
	}
	protected LeaveType createNewLeaveType() 
	{
		
		return new LeaveType();		
	}
	
	protected void checkParamsForUpdatingLeaveType(RetailScmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		checkVersionOfLeaveType(userContext, leaveTypeVersion, exception);
		

		if(LeaveType.CODE_PROPERTY.equals(property)){
			checkCodeOfLeaveType(userContext, parseString(newValueExpr), exception);
		}		

		
		if(LeaveType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfLeaveType(userContext, parseString(newValueExpr), exception);
		}
		if(LeaveType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfLeaveType(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public LeaveType clone(RetailScmUserContext userContext, String fromLeaveTypeId) throws Exception{
		
		return this.getLeaveTypeDAO().clone(fromLeaveTypeId, this.allTokens());
	}
	
	public LeaveType updateLeaveType(RetailScmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLeaveType(userContext, leaveTypeId, leaveTypeVersion, property, newValueExpr, tokensExpr);
		
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		if(leaveType.getVersion() != leaveTypeVersion){
			String message = "The target version("+leaveType.getVersion()+") is not equals to version("+leaveTypeVersion+") provided";
			throw new LeaveTypeManagerException(message);
		}
		synchronized(leaveType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LeaveType.
			
			leaveType.changePropery(property, newValueExpr);
			leaveType = saveLeaveType(userContext, leaveType, tokens().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
			//return saveLeaveType(userContext, leaveType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LeaveTypeTokens tokens(){
		return LeaveTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LeaveTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LeaveTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String leaveTypeId, String anotherCompanyId) throws Exception
 	{
 		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
 		checkIdOfLeaveType(userContext, leaveTypeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public LeaveType transferToAnotherCompany(RetailScmUserContext userContext, String leaveTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, leaveTypeId,anotherCompanyId);
 
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());	
		synchronized(leaveType){
			//will be good when the leaveType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			leaveType.setCompany(company);		
			leaveType = saveLeaveType(userContext, leaveType, emptyOptions());
			
			return present(userContext,leaveType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String leaveTypeId, int leaveTypeVersion) throws Exception {
		
		deleteInternal(userContext, leaveTypeId, leaveTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String leaveTypeId, int leaveTypeVersion) throws Exception{
		getLeaveTypeDAO().delete(leaveTypeId, leaveTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LeaveTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getLeaveTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark,String [] tokensExpr) throws Exception{
		
		

		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		
		
		checkIdOfEmployee(userContext,  whoId, exception);
		checkLeaveDurationHourOfEmployeeLeave(userContext,  leaveDurationHour, exception);
		checkRemarkOfEmployeeLeave(userContext,  remark, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  LeaveType addEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeLeave(userContext,leaveTypeId,whoId, leaveDurationHour, remark,tokensExpr);
		
		EmployeeLeave employeeLeave = createEmployeeLeave(userContext,whoId, leaveDurationHour, remark);
		
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveType.addEmployeeLeave( employeeLeave );		
			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeLeave createEmployeeLeave(RetailScmUserContext userContext, String whoId, int leaveDurationHour, String remark) throws Exception{

		EmployeeLeave employeeLeave = new EmployeeLeave();
		
		
		Employee  who = new Employee();
		who.setId(whoId);		
		employeeLeave.setWho(who);		
		employeeLeave.setLeaveDurationHour(leaveDurationHour);		
		employeeLeave.setRemark(remark);
	
		
		return employeeLeave;
	
		
	}
	
	protected EmployeeLeave createIndexedEmployeeLeave(String id, int version){

		EmployeeLeave employeeLeave = new EmployeeLeave();
		employeeLeave.setId(id);
		employeeLeave.setVersion(version);
		return employeeLeave;			
		
	}
	protected void checkParamsForRemovingEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		

		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		checkVersionOfEmployeeLeave(userContext, employeeLeaveVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LeaveType removeEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeLeave(userContext,leaveTypeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveType.removeEmployeeLeave( employeeLeave );		
			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		

		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		checkIdOfEmployeeLeave(userContext, employeeLeaveId, exception);
		checkVersionOfEmployeeLeave(userContext, employeeLeaveVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  LeaveType copyEmployeeLeaveFrom(RetailScmUserContext userContext, String leaveTypeId, 
		String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeLeave(userContext,leaveTypeId, employeeLeaveId, employeeLeaveVersion,tokensExpr);
		
		EmployeeLeave employeeLeave = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			leaveType.copyEmployeeLeaveFrom( employeeLeave );		
			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		LeaveTypeManagerException exception = new LeaveTypeManagerException("Error Occured");
		
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
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
	
	public  LeaveType updateEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeLeave(userContext, leaveTypeId, employeeLeaveId, employeeLeaveVersion, property, newValueExpr,  tokensExpr);
		
		
		LeaveType leaveType = loadLeaveType(userContext, leaveTypeId, allTokens());
		
		synchronized(leaveType){ 
			//Will be good when the leaveType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//leaveType.removeEmployeeLeave( employeeLeave );	
			//make changes to AcceleraterAccount.
			EmployeeLeave employeeLeaveIndex = createIndexedEmployeeLeave(employeeLeaveId, employeeLeaveVersion);
		
			EmployeeLeave employeeLeave = leaveType.findTheEmployeeLeave(employeeLeaveIndex);
			if(employeeLeave == null){
				throw new LeaveTypeManagerException(employeeLeave+"Not found" );
			}
			
			employeeLeave.changePropery(property, newValueExpr);

			leaveType = saveLeaveType(userContext, leaveType, tokens().withEmployeeLeaveList().done());
			return present(userContext,leaveType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


