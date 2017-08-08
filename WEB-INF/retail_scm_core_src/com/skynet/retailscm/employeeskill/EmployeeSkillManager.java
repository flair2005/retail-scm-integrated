
package com.skynet.retailscm.employeeskill;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeSkillManager{

	public EmployeeSkill createEmployeeSkill(RetailScmUserContext userContext, String employeeId, String skillTypeId, String description
) throws Exception;	
	public EmployeeSkill updateEmployeeSkill(RetailScmUserContext userContext,String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeSkill transferToAnotherEmployee(RetailScmUserContext userContext, String employeeSkillId, String anotherEmployeeId)  throws Exception;
 	public EmployeeSkill transferToAnotherSkillType(RetailScmUserContext userContext, String employeeSkillId, String anotherSkillTypeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeSkillId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


