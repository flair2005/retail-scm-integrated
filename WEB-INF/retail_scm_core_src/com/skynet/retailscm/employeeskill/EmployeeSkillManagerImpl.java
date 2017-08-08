
package com.skynet.retailscm.employeeskill;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.skilltype.SkillTypeDAO;
import com.skynet.retailscm.employee.EmployeeDAO;



import com.skynet.retailscm.skilltype.SkillTypeTable;
import com.skynet.retailscm.employee.EmployeeTable;




public class EmployeeSkillManagerImpl extends RetailScmCheckerManager implements EmployeeSkillManager {
	
	private static final String SERVICE_TYPE = "EmployeeSkill";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  EmployeeSkillDAO  employeeSkillDAO;
 	public void setEmployeeSkillDAO(EmployeeSkillDAO  employeeSkillDAO){
 	
 		if(employeeSkillDAO == null){
 			throw new IllegalStateException("Do not try to set employeeSkillDAO to null.");
 		}
	 	this.employeeSkillDAO = employeeSkillDAO;
 	}
 	public EmployeeSkillDAO getEmployeeSkillDAO(){
 		if(this.employeeSkillDAO == null){
 			throw new IllegalStateException("The EmployeeSkillDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeSkillDAO;
 	}
 	
 	protected EmployeeSkill saveEmployeeSkill(RetailScmUserContext userContext, EmployeeSkill employeeSkill, String [] tokensExpr) throws Exception{	
 		//return getEmployeeSkillDAO().save(employeeSkill, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveEmployeeSkill(userContext, employeeSkill, tokens);
 	}
 	
 	protected EmployeeSkill saveEmployeeSkillDetail(RetailScmUserContext userContext, EmployeeSkill employeeSkill) throws Exception{	

 		
 		return saveEmployeeSkill(userContext, employeeSkill, allTokens());
 	}
 	
 	public EmployeeSkill loadEmployeeSkill(RetailScmUserContext userContext, String employeeSkillId, String [] tokensExpr) throws Exception{				
 
 		EmployeeSkillManagerException exception = new EmployeeSkillManagerException("Error Occured");
		
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,employeeSkill, tokens);
 	}
 	
 	protected EmployeeSkill present(RetailScmUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,employeeSkill,tokens);
		
		
		return this.getEmployeeSkillDAO().present(employeeSkill, tokens);
	}
 
 	
 	
 	public EmployeeSkill loadEmployeeSkillDetail(RetailScmUserContext userContext, String employeeSkillId) throws Exception{	
 		EmployeeSkillManagerException exception = new EmployeeSkillManagerException("Error Occured");
		
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, allTokens());

 		return present(userContext,employeeSkill, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String employeeSkillId) throws Exception{	
 		EmployeeSkillManagerException exception = new EmployeeSkillManagerException("Error Occured");
		
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		EmployeeSkill employeeSkill = loadEmployeeSkill( userContext, employeeSkillId, allTokens());

 		return present(userContext,employeeSkill, allTokens());
		
 	}
 	protected EmployeeSkill saveEmployeeSkill(RetailScmUserContext userContext, EmployeeSkill employeeSkill, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeSkillDAO().save(employeeSkill, tokens);
 	}
 	protected EmployeeSkill loadEmployeeSkill(RetailScmUserContext userContext, String employeeSkillId, Map<String,Object>tokens) throws Exception{	
 		return getEmployeeSkillDAO().load(employeeSkillId, tokens);
 	}

	



 	 
 	
 	private  SkillTypeDAO  skillTypeDAO;
 	public void setSkillTypeDAO(SkillTypeDAO skillTypeDAO){
	 	this.skillTypeDAO = skillTypeDAO;
 	}
 	//------------------------------------
 	public SkillTypeDAO getSkillTypeDAO(){
	 	return this.skillTypeDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	//------------------------------------
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens){
		super.addActions(userContext, employeeSkill, tokens);
		
		addAction(userContext, employeeSkill, tokens,"@create","createEmployeeSkill","createEmployeeSkill/","main","primary");
		addAction(userContext, employeeSkill, tokens,"@update","updateEmployeeSkill","updateEmployeeSkill/"+employeeSkill.getId()+"/","main","primary");
		addAction(userContext, employeeSkill, tokens,"@copy","cloneEmployeeSkill","cloneEmployeeSkill/"+employeeSkill.getId()+"/","main","primary");
		
		addAction(userContext, employeeSkill, tokens,"employee_skill.transfer_to_employee","transferToAnotherEmployee","transferToAnotherEmployee/"+employeeSkill.getId()+"/","main","primary");
		addAction(userContext, employeeSkill, tokens,"employee_skill.transfer_to_skill_type","transferToAnotherSkillType","transferToAnotherSkillType/"+employeeSkill.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, EmployeeSkill employeeSkill, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public EmployeeSkill createEmployeeSkill(RetailScmUserContext userContext,String employeeId, String skillTypeId, String description
) throws Exception
	{
		
		EmployeeSkillManagerException exception = new EmployeeSkillManagerException("Error Occured");

		

		checkDescriptionOfEmployeeSkill(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		EmployeeSkill employeeSkill=createNewEmployeeSkill();	

		Employee employee = loadEmployee(employeeId,emptyOptions());
		employeeSkill.setEmployee(employee);
		SkillType skillType = loadSkillType(skillTypeId,emptyOptions());
		employeeSkill.setSkillType(skillType);
		employeeSkill.setDescription(description);

		return saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
		

		
	}
	protected EmployeeSkill createNewEmployeeSkill() 
	{
		
		return new EmployeeSkill();		
	}
	
	protected void checkParamsForUpdatingEmployeeSkill(RetailScmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		EmployeeSkillManagerException exception = new EmployeeSkillManagerException("Error Occured");
		
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		checkVersionOfEmployeeSkill(userContext, employeeSkillVersion, exception);
		
		

				

		
		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfEmployeeSkill(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public EmployeeSkill clone(RetailScmUserContext userContext, String fromEmployeeSkillId) throws Exception{
		
		return this.getEmployeeSkillDAO().clone(fromEmployeeSkillId, this.allTokens());
	}
	
	public EmployeeSkill updateEmployeeSkill(RetailScmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingEmployeeSkill(userContext, employeeSkillId, employeeSkillVersion, property, newValueExpr, tokensExpr);
		
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());
		if(employeeSkill.getVersion() != employeeSkillVersion){
			String message = "The target version("+employeeSkill.getVersion()+") is not equals to version("+employeeSkillVersion+") provided";
			throw new EmployeeSkillManagerException(message);
		}
		synchronized(employeeSkill){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to EmployeeSkill.
			
			employeeSkill.changePropery(property, newValueExpr);
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, tokens().done());
			return present(userContext,employeeSkill, mergedAllTokens(tokensExpr));
			//return saveEmployeeSkill(userContext, employeeSkill, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected EmployeeSkillTokens tokens(){
		return EmployeeSkillTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return EmployeeSkillTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return EmployeeSkillTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEmployee(RetailScmUserContext userContext, String employeeSkillId, String anotherEmployeeId) throws Exception
 	{
 		EmployeeSkillManagerException exception = new EmployeeSkillManagerException("Error Occured");
 		checkIdOfEmployeeSkill(userContext, employeeSkillId,exception);
 		checkIdOfEmployee(userContext, anotherEmployeeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeSkill transferToAnotherEmployee(RetailScmUserContext userContext, String employeeSkillId, String anotherEmployeeId) throws Exception
 	{
 		checkParamsForTransferingAnotherEmployee(userContext, employeeSkillId,anotherEmployeeId);
 
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());	
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Employee employee = loadEmployee(anotherEmployeeId, emptyOptions());		
			employeeSkill.setEmployee(employee);		
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
			
			return present(userContext,employeeSkill, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherSkillType(RetailScmUserContext userContext, String employeeSkillId, String anotherSkillTypeId) throws Exception
 	{
 		EmployeeSkillManagerException exception = new EmployeeSkillManagerException("Error Occured");
 		checkIdOfEmployeeSkill(userContext, employeeSkillId,exception);
 		checkIdOfSkillType(userContext, anotherSkillTypeId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public EmployeeSkill transferToAnotherSkillType(RetailScmUserContext userContext, String employeeSkillId, String anotherSkillTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherSkillType(userContext, employeeSkillId,anotherSkillTypeId);
 
		EmployeeSkill employeeSkill = loadEmployeeSkill(userContext, employeeSkillId, allTokens());	
		synchronized(employeeSkill){
			//will be good when the employeeSkill loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SkillType skillType = loadSkillType(anotherSkillTypeId, emptyOptions());		
			employeeSkill.setSkillType(skillType);		
			employeeSkill = saveEmployeeSkill(userContext, employeeSkill, emptyOptions());
			
			return present(userContext,employeeSkill, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected SkillType loadSkillType(String newSkillTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return getSkillTypeDAO().load(newSkillTypeId, options);
 	}
	
	 	
 	protected Employee loadEmployee(String newEmployeeId, Map<String,Object> options) throws Exception
 	{
		
 		return getEmployeeDAO().load(newEmployeeId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String employeeSkillId, int employeeSkillVersion) throws Exception {
		
		deleteInternal(userContext, employeeSkillId, employeeSkillVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String employeeSkillId, int employeeSkillVersion) throws Exception{
		getEmployeeSkillDAO().delete(employeeSkillId, employeeSkillVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new EmployeeSkillManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getEmployeeSkillDAO().deleteAll();
	}


}


