
package com.skynet.retailscm.jobapplication;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface JobApplicationManager{

	public JobApplication createJobApplication(RetailScmUserContext userContext, Date applicationTime, String who, String comments
) throws Exception;	
	public JobApplication updateJobApplication(RetailScmUserContext userContext,String jobApplicationId, int jobApplicationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String jobApplicationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  JobApplication addEmployee(RetailScmUserContext userContext, String jobApplicationId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  JobApplication removeEmployee(RetailScmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  JobApplication updateEmployee(RetailScmUserContext userContext, String jobApplicationId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


