
package com.skynet.retailscm.skilltype;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeskill.EmployeeSkill;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.employee.Employee;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employeeskill.EmployeeSkillTable;




public class SkillTypeManagerImpl extends RetailScmCheckerManager implements SkillTypeManager {
	
	private static final String SERVICE_TYPE = "SkillType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SkillTypeDAO  skillTypeDAO;
 	public void setSkillTypeDAO(SkillTypeDAO  skillTypeDAO){
 	
 		if(skillTypeDAO == null){
 			throw new IllegalStateException("Do not try to set skillTypeDAO to null.");
 		}
	 	this.skillTypeDAO = skillTypeDAO;
 	}
 	public SkillTypeDAO getSkillTypeDAO(){
 		if(this.skillTypeDAO == null){
 			throw new IllegalStateException("The SkillTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.skillTypeDAO;
 	}
 	
 	protected SkillType saveSkillType(RetailScmUserContext userContext, SkillType skillType, String [] tokensExpr) throws Exception{	
 		//return getSkillTypeDAO().save(skillType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSkillType(userContext, skillType, tokens);
 	}
 	
 	protected SkillType saveSkillTypeDetail(RetailScmUserContext userContext, SkillType skillType) throws Exception{	

 		
 		return saveSkillType(userContext, skillType, allTokens());
 	}
 	
 	public SkillType loadSkillType(RetailScmUserContext userContext, String skillTypeId, String [] tokensExpr) throws Exception{				
 
 		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SkillType skillType = loadSkillType( userContext, skillTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,skillType, tokens);
 	}
 	
 	protected SkillType present(RetailScmUserContext userContext, SkillType skillType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,skillType,tokens);
		
		
		return this.getSkillTypeDAO().present(skillType, tokens);
	}
 
 	
 	
 	public SkillType loadSkillTypeDetail(RetailScmUserContext userContext, String skillTypeId) throws Exception{	
 		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SkillType skillType = loadSkillType( userContext, skillTypeId, allTokens());

 		return present(userContext,skillType, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String skillTypeId) throws Exception{	
 		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SkillType skillType = loadSkillType( userContext, skillTypeId, allTokens());

 		return present(userContext,skillType, allTokens());
		
 	}
 	protected SkillType saveSkillType(RetailScmUserContext userContext, SkillType skillType, Map<String,Object>tokens) throws Exception{	
 		return getSkillTypeDAO().save(skillType, tokens);
 	}
 	protected SkillType loadSkillType(RetailScmUserContext userContext, String skillTypeId, Map<String,Object>tokens) throws Exception{	
 		return getSkillTypeDAO().load(skillTypeId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SkillType skillType, Map<String, Object> tokens){
		super.addActions(userContext, skillType, tokens);
		
		addAction(userContext, skillType, tokens,"@create","createSkillType","createSkillType/","main","primary");
		addAction(userContext, skillType, tokens,"@update","updateSkillType","updateSkillType/"+skillType.getId()+"/","main","primary");
		addAction(userContext, skillType, tokens,"@copy","cloneSkillType","cloneSkillType/"+skillType.getId()+"/","main","primary");
		
		addAction(userContext, skillType, tokens,"skill_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+skillType.getId()+"/","main","primary");
		addAction(userContext, skillType, tokens,"skill_type.addEmployeeSkill","addEmployeeSkill","addEmployeeSkill/"+skillType.getId()+"/","employeeSkillList","primary");
		addAction(userContext, skillType, tokens,"skill_type.removeEmployeeSkill","removeEmployeeSkill","removeEmployeeSkill/"+skillType.getId()+"/","employeeSkillList","primary");
		addAction(userContext, skillType, tokens,"skill_type.updateEmployeeSkill","updateEmployeeSkill","updateEmployeeSkill/"+skillType.getId()+"/","employeeSkillList","primary");
		addAction(userContext, skillType, tokens,"skill_type.copyEmployeeSkillFrom","copyEmployeeSkillFrom","copyEmployeeSkillFrom/"+skillType.getId()+"/","employeeSkillList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SkillType skillType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SkillType createSkillType(RetailScmUserContext userContext,String code, String companyId, String description
) throws Exception
	{
		
		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");

		

		checkCodeOfSkillType(userContext,  code, exception);
		checkDescriptionOfSkillType(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SkillType skillType=createNewSkillType();	

		skillType.setCode(code);
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(companyId,emptyOptions());
		skillType.setCompany(company);
		skillType.setDescription(description);

		return saveSkillType(userContext, skillType, emptyOptions());
		

		
	}
	protected SkillType createNewSkillType() 
	{
		
		return new SkillType();		
	}
	
	protected void checkParamsForUpdatingSkillType(RetailScmUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		checkVersionOfSkillType(userContext, skillTypeVersion, exception);
		

		if(SkillType.CODE_PROPERTY.equals(property)){
			checkCodeOfSkillType(userContext, parseString(newValueExpr), exception);
		}		

		
		if(SkillType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfSkillType(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SkillType clone(RetailScmUserContext userContext, String fromSkillTypeId) throws Exception{
		
		return this.getSkillTypeDAO().clone(fromSkillTypeId, this.allTokens());
	}
	
	public SkillType updateSkillType(RetailScmUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSkillType(userContext, skillTypeId, skillTypeVersion, property, newValueExpr, tokensExpr);
		
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		if(skillType.getVersion() != skillTypeVersion){
			String message = "The target version("+skillType.getVersion()+") is not equals to version("+skillTypeVersion+") provided";
			throw new SkillTypeManagerException(message);
		}
		synchronized(skillType){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SkillType.
			
			skillType.changePropery(property, newValueExpr);
			skillType = saveSkillType(userContext, skillType, tokens().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
			//return saveSkillType(userContext, skillType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SkillTypeTokens tokens(){
		return SkillTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SkillTypeTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkillTypeTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherCompany(RetailScmUserContext userContext, String skillTypeId, String anotherCompanyId) throws Exception
 	{
 		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
 		checkIdOfSkillType(userContext, skillTypeId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherCompanyId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SkillType transferToAnotherCompany(RetailScmUserContext userContext, String skillTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, skillTypeId,anotherCompanyId);
 
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());	
		synchronized(skillType){
			//will be good when the skillType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(anotherCompanyId, emptyOptions());		
			skillType.setCompany(company);		
			skillType = saveSkillType(userContext, skillType, emptyOptions());
			
			return present(userContext,skillType, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String skillTypeId, int skillTypeVersion) throws Exception {
		
		deleteInternal(userContext, skillTypeId, skillTypeVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String skillTypeId, int skillTypeVersion) throws Exception{
		getSkillTypeDAO().delete(skillTypeId, skillTypeVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SkillTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSkillTypeDAO().deleteAll();
	}

	protected void checkParamsForAddingEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String employeeId, String description,String [] tokensExpr) throws Exception{
		
		

		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		
		
		checkIdOfEmployee(userContext,  employeeId, exception);
		checkDescriptionOfEmployeeSkill(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SkillType addEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String employeeId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSkill(userContext,skillTypeId,employeeId, description,tokensExpr);
		
		EmployeeSkill employeeSkill = createEmployeeSkill(userContext,employeeId, description);
		
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			skillType.addEmployeeSkill( employeeSkill );		
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
	}
	protected EmployeeSkill createEmployeeSkill(RetailScmUserContext userContext, String employeeId, String description) throws Exception{

		EmployeeSkill employeeSkill = new EmployeeSkill();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeSkill.setEmployee(employee);		
		employeeSkill.setDescription(description);
	
		
		return employeeSkill;
	
		
	}
	
	protected EmployeeSkill createIndexedEmployeeSkill(String id, int version){

		EmployeeSkill employeeSkill = new EmployeeSkill();
		employeeSkill.setId(id);
		employeeSkill.setVersion(version);
		return employeeSkill;			
		
	}
	protected void checkParamsForRemovingEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		

		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		checkVersionOfEmployeeSkill(userContext, employeeSkillVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SkillType removeEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSkill(userContext,skillTypeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			skillType.removeEmployeeSkill( employeeSkill );		
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		

		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		checkVersionOfEmployeeSkill(userContext, employeeSkillVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SkillType copyEmployeeSkillFrom(RetailScmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSkill(userContext,skillTypeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			skillType.copyEmployeeSkillFrom( employeeSkill );		
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SkillTypeManagerException exception = new SkillTypeManagerException("Error Occured");
		
		checkIdOfSkillType(userContext, skillTypeId, exception);
		checkIdOfEmployeeSkill(userContext, employeeSkillId, exception);
		checkVersionOfEmployeeSkill(userContext, employeeSkillVersion, exception);
		

		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfEmployeeSkill(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SkillType updateEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSkill(userContext, skillTypeId, employeeSkillId, employeeSkillVersion, property, newValueExpr,  tokensExpr);
		
		
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//skillType.removeEmployeeSkill( employeeSkill );	
			//make changes to AcceleraterAccount.
			EmployeeSkill employeeSkillIndex = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		
			EmployeeSkill employeeSkill = skillType.findTheEmployeeSkill(employeeSkillIndex);
			if(employeeSkill == null){
				throw new SkillTypeManagerException(employeeSkill+"Not found" );
			}
			
			employeeSkill.changePropery(property, newValueExpr);

			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


