
package com.skynet.retailscm.responsibilitytype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ResponsibilityTypeManager{

	public ResponsibilityType createResponsibilityType(RetailScmUserContext userContext, String code, String companyId, String baseDescription, String detailDescription
) throws Exception;	
	public ResponsibilityType updateResponsibilityType(RetailScmUserContext userContext,String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ResponsibilityType transferToAnotherCompany(RetailScmUserContext userContext, String responsibilityTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String responsibilityTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  ResponsibilityType addEmployee(RetailScmUserContext userContext, String responsibilityTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  ResponsibilityType removeEmployee(RetailScmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ResponsibilityType updateEmployee(RetailScmUserContext userContext, String responsibilityTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


