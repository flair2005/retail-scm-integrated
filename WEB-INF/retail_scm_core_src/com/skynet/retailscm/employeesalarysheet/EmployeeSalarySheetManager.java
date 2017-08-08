
package com.skynet.retailscm.employeesalarysheet;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeSalarySheetManager{

	public EmployeeSalarySheet createEmployeeSalarySheet(RetailScmUserContext userContext, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance
) throws Exception;	
	public EmployeeSalarySheet updateEmployeeSalarySheet(RetailScmUserContext userContext,String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeSalarySheet transferToAnotherEmployee(RetailScmUserContext userContext, String employeeSalarySheetId, String anotherEmployeeId)  throws Exception;
 	public EmployeeSalarySheet transferToAnotherCurrentSalaryGrade(RetailScmUserContext userContext, String employeeSalarySheetId, String anotherCurrentSalaryGradeId)  throws Exception;
 	public EmployeeSalarySheet payOff(RetailScmUserContext userContext, String employeeSalarySheetId, String who, String paidForId, Date paidTime, double amount
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String employeeSalarySheetId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


