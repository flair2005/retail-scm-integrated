
package com.skynet.retailscm.employeeperformance;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeePerformanceManager{

	public EmployeePerformance createEmployeePerformance(RetailScmUserContext userContext, String employeeId, String performanceComment
) throws Exception;	
	public EmployeePerformance updateEmployeePerformance(RetailScmUserContext userContext,String employeePerformanceId, int employeePerformanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeePerformance transferToAnotherEmployee(RetailScmUserContext userContext, String employeePerformanceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeePerformanceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


