
package com.skynet.retailscm.termination;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TerminationManager{

	public Termination createTermination(RetailScmUserContext userContext, String reasonId, String typeId, String comment
) throws Exception;	
	public Termination updateTermination(RetailScmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Termination transferToAnotherReason(RetailScmUserContext userContext, String terminationId, String anotherReasonId)  throws Exception;
 	public Termination transferToAnotherType(RetailScmUserContext userContext, String terminationId, String anotherTypeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String terminationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Termination addEmployee(RetailScmUserContext userContext, String terminationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  Termination removeEmployee(RetailScmUserContext userContext, String terminationId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  Termination updateEmployee(RetailScmUserContext userContext, String terminationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


