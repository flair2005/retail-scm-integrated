
package com.skynet.retailscm.employeeworkexperience;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeWorkExperienceManager{

	public EmployeeWorkExperience createEmployeeWorkExperience(RetailScmUserContext userContext, String employeeId, Date start, Date end, String company, String description
) throws Exception;	
	public EmployeeWorkExperience updateEmployeeWorkExperience(RetailScmUserContext userContext,String employeeWorkExperienceId, int employeeWorkExperienceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeWorkExperience transferToAnotherEmployee(RetailScmUserContext userContext, String employeeWorkExperienceId, String anotherEmployeeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String employeeWorkExperienceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


