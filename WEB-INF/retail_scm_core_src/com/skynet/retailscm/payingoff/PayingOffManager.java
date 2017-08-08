
package com.skynet.retailscm.payingoff;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface PayingOffManager{

	public PayingOff createPayingOff(RetailScmUserContext userContext, String who, String paidForId, Date paidTime, double amount
) throws Exception;	
	public PayingOff updatePayingOff(RetailScmUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public PayingOff transferToAnotherPaidFor(RetailScmUserContext userContext, String payingOffId, String anotherPaidForId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String payingOffId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  PayingOff addEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, double baseSalary, double bonus, double reward, double personalTax, double socialSecurity, double housingFound, double jobInsurance ,String [] tokensExpr)  throws Exception;
	public  PayingOff removeEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  PayingOff updateEmployeeSalarySheet(RetailScmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}









