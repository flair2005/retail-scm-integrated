
package com.skynet.retailscm.offeracceptance;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface OfferAcceptanceManager{

	public OfferAcceptance createOfferAcceptance(RetailScmUserContext userContext, String who, Date acceptTime, String comments
) throws Exception;	
	public OfferAcceptance updateOfferAcceptance(RetailScmUserContext userContext,String offerAcceptanceId, int offerAcceptanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String offerAcceptanceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  OfferAcceptance addEmployee(RetailScmUserContext userContext, String offerAcceptanceId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  OfferAcceptance removeEmployee(RetailScmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OfferAcceptance updateEmployee(RetailScmUserContext userContext, String offerAcceptanceId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


