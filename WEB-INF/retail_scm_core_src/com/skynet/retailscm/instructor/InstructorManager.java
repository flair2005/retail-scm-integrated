
package com.skynet.retailscm.instructor;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface InstructorManager{

	public Instructor createInstructor(RetailScmUserContext userContext, String title, String familyName, String givenName, String cellPhone, String email, String companyId, String introduction
) throws Exception;	
	public Instructor updateInstructor(RetailScmUserContext userContext,String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Instructor transferToAnotherCompany(RetailScmUserContext userContext, String instructorId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String instructorId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Instructor addCompanyTraining(RetailScmUserContext userContext, String instructorId, String title, String companyId, String trainingCourseTypeId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;
	public  Instructor removeCompanyTraining(RetailScmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Instructor updateCompanyTraining(RetailScmUserContext userContext, String instructorId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


