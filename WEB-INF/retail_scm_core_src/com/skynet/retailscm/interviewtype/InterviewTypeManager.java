
package com.skynet.retailscm.interviewtype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface InterviewTypeManager{

	public InterviewType createInterviewType(RetailScmUserContext userContext, String code, String companyId, String description, String detailDescription
) throws Exception;	
	public InterviewType updateInterviewType(RetailScmUserContext userContext,String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public InterviewType transferToAnotherCompany(RetailScmUserContext userContext, String interviewTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String interviewTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  InterviewType addEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String employeeId, String remark ,String [] tokensExpr)  throws Exception;
	public  InterviewType removeEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion,String [] tokensExpr)  throws Exception;
	public  InterviewType updateEmployeeInterview(RetailScmUserContext userContext, String interviewTypeId, String employeeInterviewId, int employeeInterviewVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


