
package com.skynet.retailscm.consumerordershippinggroup;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderShippingGroupManager{

	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailScmUserContext userContext, String name, String bizOrderId, double amount
) throws Exception;	
	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroup(RetailScmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ConsumerOrderShippingGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String consumerOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


