
package com.skynet.retailscm.employeequalifier;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeQualifierManager{

	public EmployeeQualifier createEmployeeQualifier(RetailScmUserContext userContext, String employeeId, Date qualifiedTime, String type, String level, String remark
) throws Exception;	
	public EmployeeQualifier updateEmployeeQualifier(RetailScmUserContext userContext,String employeeQualifierId, int employeeQualifierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeQualifier transferToAnotherEmployee(RetailScmUserContext userContext, String employeeQualifierId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeQualifierId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


