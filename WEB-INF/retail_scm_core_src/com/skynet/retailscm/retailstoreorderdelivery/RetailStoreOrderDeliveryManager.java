
package com.skynet.retailscm.retailstoreorderdelivery;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderDeliveryManager{

	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(RetailScmUserContext userContext, String who, Date deliveryTime
) throws Exception;	
	public RetailStoreOrderDelivery updateRetailStoreOrderDelivery(RetailScmUserContext userContext,String retailStoreOrderDeliveryId, int retailStoreOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOrderDelivery addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderDelivery removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderDelivery updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderDeliveryId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


