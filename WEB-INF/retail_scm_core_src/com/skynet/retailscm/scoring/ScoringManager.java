
package com.skynet.retailscm.scoring;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ScoringManager{

	public Scoring createScoring(RetailScmUserContext userContext, String scoredBy, int score, String comment
) throws Exception;	
	public Scoring updateScoring(RetailScmUserContext userContext,String scoringId, int scoringVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String scoringId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Scoring addEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, String employeeId, String trainingId ,String [] tokensExpr)  throws Exception;
	public  Scoring removeEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  Scoring updateEmployeeCompanyTraining(RetailScmUserContext userContext, String scoringId, String employeeCompanyTrainingId, int employeeCompanyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


