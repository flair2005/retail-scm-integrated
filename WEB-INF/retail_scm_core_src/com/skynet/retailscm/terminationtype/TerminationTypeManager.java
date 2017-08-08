
package com.skynet.retailscm.terminationtype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TerminationTypeManager{

	public TerminationType createTerminationType(RetailScmUserContext userContext, String code, String companyId, String baseDescription, String detailDescription
) throws Exception;	
	public TerminationType updateTerminationType(RetailScmUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TerminationType transferToAnotherCompany(RetailScmUserContext userContext, String terminationTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String terminationTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  TerminationType addTermination(RetailScmUserContext userContext, String terminationTypeId, String reasonId, String comment ,String [] tokensExpr)  throws Exception;
	public  TerminationType removeTermination(RetailScmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion,String [] tokensExpr)  throws Exception;
	public  TerminationType updateTermination(RetailScmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


