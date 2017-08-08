
package com.skynet.retailscm.consumerorderconfirmation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderConfirmationManager{

	public ConsumerOrderConfirmation createConsumerOrderConfirmation(RetailScmUserContext userContext, String who, Date confirmTime
) throws Exception;	
	public ConsumerOrderConfirmation updateConsumerOrderConfirmation(RetailScmUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String consumerOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


