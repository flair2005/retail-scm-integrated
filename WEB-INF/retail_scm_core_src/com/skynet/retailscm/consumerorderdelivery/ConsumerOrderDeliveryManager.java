
package com.skynet.retailscm.consumerorderdelivery;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderDeliveryManager{

	public ConsumerOrderDelivery createConsumerOrderDelivery(RetailScmUserContext userContext, String who, Date deliveryTime
) throws Exception;	
	public ConsumerOrderDelivery updateConsumerOrderDelivery(RetailScmUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String consumerOrderDeliveryId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


