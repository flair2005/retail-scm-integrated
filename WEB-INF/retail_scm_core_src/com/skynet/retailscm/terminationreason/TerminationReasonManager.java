
package com.skynet.retailscm.terminationreason;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TerminationReasonManager{

	public TerminationReason createTerminationReason(RetailScmUserContext userContext, String code, String companyId, String description
) throws Exception;	
	public TerminationReason updateTerminationReason(RetailScmUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TerminationReason transferToAnotherCompany(RetailScmUserContext userContext, String terminationReasonId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String terminationReasonId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  TerminationReason addTermination(RetailScmUserContext userContext, String terminationReasonId, String typeId, String comment ,String [] tokensExpr)  throws Exception;
	public  TerminationReason removeTermination(RetailScmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion,String [] tokensExpr)  throws Exception;
	public  TerminationReason updateTermination(RetailScmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


