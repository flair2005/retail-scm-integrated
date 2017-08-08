
package com.skynet.retailscm.salarygrade;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SalaryGradeManager{

	public SalaryGrade createSalaryGrade(RetailScmUserContext userContext, String code, String companyId, String name, String detailDescription
) throws Exception;	
	public SalaryGrade updateSalaryGrade(RetailScmUserContext userContext,String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SalaryGrade transferToAnotherCompany(RetailScmUserContext userContext, String salaryGradeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String salaryGradeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SalaryGrade addEmployee(RetailScmUserContext userContext, String salaryGradeId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  SalaryGrade removeEmployee(RetailScmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  SalaryGrade updateEmployee(RetailScmUserContext userContext, String salaryGradeId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SalaryGrade addEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, String employeeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance ,String [] tokensExpr)  throws Exception;
	public  SalaryGrade removeEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  SalaryGrade updateEmployeeSalarySheet(RetailScmUserContext userContext, String salaryGradeId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


