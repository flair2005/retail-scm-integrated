
package com.skynet.retailscm.consumerorderlineitem;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderLineItemManager{

	public ConsumerOrderLineItem createConsumerOrderLineItem(RetailScmUserContext userContext, String bizOrderId, String skuId, String skuName, double price, double quantity, double amount
) throws Exception;	
	public ConsumerOrderLineItem updateConsumerOrderLineItem(RetailScmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ConsumerOrderLineItem transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String consumerOrderLineItemId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


