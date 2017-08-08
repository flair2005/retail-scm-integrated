
package com.skynet.retailscm.hrinterview;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface HrInterviewManager{

	public HrInterview createHrInterview(RetailScmUserContext userContext, String who, Date interviewTime, String comments
) throws Exception;	
	public HrInterview updateHrInterview(RetailScmUserContext userContext,String hrInterviewId, int hrInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String hrInterviewId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  HrInterview addEmployee(RetailScmUserContext userContext, String hrInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  HrInterview removeEmployee(RetailScmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  HrInterview updateEmployee(RetailScmUserContext userContext, String hrInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


