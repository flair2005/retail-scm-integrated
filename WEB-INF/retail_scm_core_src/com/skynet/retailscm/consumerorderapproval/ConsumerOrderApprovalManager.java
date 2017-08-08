
package com.skynet.retailscm.consumerorderapproval;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderApprovalManager{

	public ConsumerOrderApproval createConsumerOrderApproval(RetailScmUserContext userContext, String who, Date approveTime
) throws Exception;	
	public ConsumerOrderApproval updateConsumerOrderApproval(RetailScmUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String consumerOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


