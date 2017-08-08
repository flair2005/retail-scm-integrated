
package com.skynet.retailscm.employeeinterview;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeInterviewManager{

	public EmployeeInterview createEmployeeInterview(RetailScmUserContext userContext, String employeeId, String interviewTypeId, String remark
) throws Exception;	
	public EmployeeInterview updateEmployeeInterview(RetailScmUserContext userContext,String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeInterview transferToAnotherEmployee(RetailScmUserContext userContext, String employeeInterviewId, String anotherEmployeeId)  throws Exception;
 	public EmployeeInterview transferToAnotherInterviewType(RetailScmUserContext userContext, String employeeInterviewId, String anotherInterviewTypeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeInterviewId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


