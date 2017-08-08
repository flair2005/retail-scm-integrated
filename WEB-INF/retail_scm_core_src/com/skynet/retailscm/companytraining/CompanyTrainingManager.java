
package com.skynet.retailscm.companytraining;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface CompanyTrainingManager{

	public CompanyTraining createCompanyTraining(RetailScmUserContext userContext, String title, String companyId, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours
) throws Exception;	
	public CompanyTraining updateCompanyTraining(RetailScmUserContext userContext,String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public CompanyTraining transferToAnotherCompany(RetailScmUserContext userContext, String companyTrainingId, String anotherCompanyId)  throws Exception;
 	public CompanyTraining transferToAnotherInstructor(RetailScmUserContext userContext, String companyTrainingId, String anotherInstructorId)  throws Exception;
 	public CompanyTraining transferToAnotherTrainingCourseType(RetailScmUserContext userContext, String companyTrainingId, String anotherTrainingCourseTypeId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String companyTrainingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  CompanyTraining addEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String employeeId ,String [] tokensExpr)  throws Exception;
	public  CompanyTraining removeEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  CompanyTraining updateEmployeeCompanyTraining(RetailScmUserContext userContext, String companyTrainingId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


