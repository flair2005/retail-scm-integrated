
package com.skynet.retailscm.employeeboarding;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeBoardingManager{

	public EmployeeBoarding createEmployeeBoarding(RetailScmUserContext userContext, String who, Date employTime, String comments
) throws Exception;	
	public EmployeeBoarding updateEmployeeBoarding(RetailScmUserContext userContext,String employeeBoardingId, int employeeBoardingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String employeeBoardingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  EmployeeBoarding addEmployee(RetailScmUserContext userContext, String employeeBoardingId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding removeEmployee(RetailScmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  EmployeeBoarding updateEmployee(RetailScmUserContext userContext, String employeeBoardingId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


