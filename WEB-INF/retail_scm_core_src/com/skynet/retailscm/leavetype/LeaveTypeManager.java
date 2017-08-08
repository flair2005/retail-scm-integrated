
package com.skynet.retailscm.leavetype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface LeaveTypeManager{

	public LeaveType createLeaveType(RetailScmUserContext userContext, String code, String companyId, String description, String detailDescription
) throws Exception;	
	public LeaveType updateLeaveType(RetailScmUserContext userContext,String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public LeaveType transferToAnotherCompany(RetailScmUserContext userContext, String leaveTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String leaveTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  LeaveType addEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, String whoId, int leaveDurationHour, String remark ,String [] tokensExpr)  throws Exception;
	public  LeaveType removeEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion,String [] tokensExpr)  throws Exception;
	public  LeaveType updateEmployeeLeave(RetailScmUserContext userContext, String leaveTypeId, String employeeLeaveId, int employeeLeaveVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


