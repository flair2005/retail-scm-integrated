
package com.skynet.retailscm.employeeattendance;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeAttendanceManager{

	public EmployeeAttendance createEmployeeAttendance(RetailScmUserContext userContext, String employeeId, Date enterTime, Date leaveTime, int durationHours, String remark
) throws Exception;	
	public EmployeeAttendance updateEmployeeAttendance(RetailScmUserContext userContext,String employeeAttendanceId, int employeeAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeAttendance transferToAnotherEmployee(RetailScmUserContext userContext, String employeeAttendanceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeAttendanceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


