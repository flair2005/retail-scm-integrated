
package com.skynet.retailscm.consumerorderpaymentgroup;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderPaymentGroupManager{

	public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(RetailScmUserContext userContext, String name, String bizOrderId, String cardNumber
) throws Exception;	
	public ConsumerOrderPaymentGroup updateConsumerOrderPaymentGroup(RetailScmUserContext userContext,String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ConsumerOrderPaymentGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderPaymentGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String consumerOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


