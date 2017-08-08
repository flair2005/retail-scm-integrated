
package com.skynet.retailscm.employeecompanytraining;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EmployeeCompanyTrainingManager{

	public EmployeeCompanyTraining createEmployeeCompanyTraining(RetailScmUserContext userContext, String employeeId, String trainingId
) throws Exception;	
	public EmployeeCompanyTraining updateEmployeeCompanyTraining(RetailScmUserContext userContext,String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EmployeeCompanyTraining transferToAnotherEmployee(RetailScmUserContext userContext, String employeeCompanyTrainingId, String anotherEmployeeId)  throws Exception;
 	public EmployeeCompanyTraining transferToAnotherTraining(RetailScmUserContext userContext, String employeeCompanyTrainingId, String anotherTrainingId)  throws Exception;
 	public EmployeeCompanyTraining score(RetailScmUserContext userContext, String employeeCompanyTrainingId, String scoredBy, int score, String comment
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String employeeCompanyTrainingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


