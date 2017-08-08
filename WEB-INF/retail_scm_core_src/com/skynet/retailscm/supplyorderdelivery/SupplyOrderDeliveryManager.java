
package com.skynet.retailscm.supplyorderdelivery;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderDeliveryManager{

	public SupplyOrderDelivery createSupplyOrderDelivery(RetailScmUserContext userContext, String who, Date deliveryTime
) throws Exception;	
	public SupplyOrderDelivery updateSupplyOrderDelivery(RetailScmUserContext userContext,String supplyOrderDeliveryId, int supplyOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String supplyOrderDeliveryId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplyOrderDelivery addConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrderDelivery addSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderDelivery updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderDeliveryId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


