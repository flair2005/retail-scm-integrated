
package com.skynet.retailscm.consumerorderpriceadjustment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderPriceAdjustmentManager{

	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String name, String bizOrderId, double amount, String provider
) throws Exception;	
	public ConsumerOrderPriceAdjustment updateConsumerOrderPriceAdjustment(RetailScmUserContext userContext,String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ConsumerOrderPriceAdjustment transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String consumerOrderPriceAdjustmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


