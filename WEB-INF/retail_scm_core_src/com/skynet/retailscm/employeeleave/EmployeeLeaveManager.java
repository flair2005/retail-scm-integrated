
package com.skynet.retailscm.employeeleave;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeLeaveManager{

	public EmployeeLeave createEmployeeLeave(RetailScmUserContext userContext, String whoId, String typeId, int leaveDurationHour, String remark
) throws Exception;	
	public EmployeeLeave updateEmployeeLeave(RetailScmUserContext userContext,String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeLeave transferToAnotherWho(RetailScmUserContext userContext, String employeeLeaveId, String anotherWhoId)  throws Exception;
 	public EmployeeLeave transferToAnotherType(RetailScmUserContext userContext, String employeeLeaveId, String anotherTypeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeLeaveId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


