
package com.skynet.retailscm.professioninterview;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ProfessionInterviewManager{

	public ProfessionInterview createProfessionInterview(RetailScmUserContext userContext, String who, Date interviewTime, String comments
) throws Exception;	
	public ProfessionInterview updateProfessionInterview(RetailScmUserContext userContext,String professionInterviewId, int professionInterviewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String professionInterviewId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  ProfessionInterview addEmployee(RetailScmUserContext userContext, String professionInterviewId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  ProfessionInterview removeEmployee(RetailScmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  ProfessionInterview updateEmployee(RetailScmUserContext userContext, String professionInterviewId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


