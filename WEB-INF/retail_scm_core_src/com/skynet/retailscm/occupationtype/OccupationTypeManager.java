
package com.skynet.retailscm.occupationtype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface OccupationTypeManager{

	public OccupationType createOccupationType(RetailScmUserContext userContext, String code, String companyId, String description, String detailDescription
) throws Exception;	
	public OccupationType updateOccupationType(RetailScmUserContext userContext,String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public OccupationType transferToAnotherCompany(RetailScmUserContext userContext, String occupationTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String occupationTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  OccupationType addEmployee(RetailScmUserContext userContext, String occupationTypeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  OccupationType removeEmployee(RetailScmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OccupationType updateEmployee(RetailScmUserContext userContext, String occupationTypeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


