
package com.skynet.retailscm.employeeaward;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeAwardManager{

	public EmployeeAward createEmployeeAward(RetailScmUserContext userContext, String employeeId, Date completeTime, String type, String remark
) throws Exception;	
	public EmployeeAward updateEmployeeAward(RetailScmUserContext userContext,String employeeAwardId, int employeeAwardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeAward transferToAnotherEmployee(RetailScmUserContext userContext, String employeeAwardId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeAwardId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


