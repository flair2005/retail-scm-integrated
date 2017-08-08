
package com.skynet.retailscm.offerapproval;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface OfferApprovalManager{

	public OfferApproval createOfferApproval(RetailScmUserContext userContext, String who, Date approveTime, String comments
) throws Exception;	
	public OfferApproval updateOfferApproval(RetailScmUserContext userContext,String offerApprovalId, int offerApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String offerApprovalId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  OfferApproval addEmployee(RetailScmUserContext userContext, String offerApprovalId, String companyId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  OfferApproval removeEmployee(RetailScmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  OfferApproval updateEmployee(RetailScmUserContext userContext, String offerApprovalId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


