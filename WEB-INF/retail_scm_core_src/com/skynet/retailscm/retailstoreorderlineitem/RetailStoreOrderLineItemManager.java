
package com.skynet.retailscm.retailstoreorderlineitem;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderLineItemManager{

	public RetailStoreOrderLineItem createRetailStoreOrderLineItem(RetailScmUserContext userContext, String bizOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement
) throws Exception;	
	public RetailStoreOrderLineItem updateRetailStoreOrderLineItem(RetailScmUserContext userContext,String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreOrderLineItem transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderLineItemId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreOrderLineItemId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


