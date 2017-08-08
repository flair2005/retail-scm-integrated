
package com.skynet.retailscm.trainingcoursetype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TrainingCourseTypeManager{

	public TrainingCourseType createTrainingCourseType(RetailScmUserContext userContext, String code, String companyId, String name, String description
) throws Exception;	
	public TrainingCourseType updateTrainingCourseType(RetailScmUserContext userContext,String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TrainingCourseType transferToAnotherCompany(RetailScmUserContext userContext, String trainingCourseTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String trainingCourseTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  TrainingCourseType addCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, String title, String companyId, String instructorId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;
	public  TrainingCourseType removeCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  TrainingCourseType updateCompanyTraining(RetailScmUserContext userContext, String trainingCourseTypeId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


