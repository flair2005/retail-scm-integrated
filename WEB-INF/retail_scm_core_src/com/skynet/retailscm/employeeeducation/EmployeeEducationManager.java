
package com.skynet.retailscm.employeeeducation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeEducationManager{

	public EmployeeEducation createEmployeeEducation(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark
) throws Exception;	
	public EmployeeEducation updateEmployeeEducation(RetailScmUserContext userContext,String employeeEducationId, int employeeEducationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeEducation transferToAnotherEmployee(RetailScmUserContext userContext, String employeeEducationId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeEducationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


