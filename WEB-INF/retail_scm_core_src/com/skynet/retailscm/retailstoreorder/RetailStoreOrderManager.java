
package com.skynet.retailscm.retailstoreorder;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderManager{

	public RetailStoreOrder createRetailStoreOrder(RetailScmUserContext userContext, String buyerId, String sellerId, String title, double totalAmount
) throws Exception;	
	public RetailStoreOrder updateRetailStoreOrder(RetailScmUserContext userContext,String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreOrder transferToAnotherBuyer(RetailScmUserContext userContext, String retailStoreOrderId, String anotherBuyerId)  throws Exception;
 	public RetailStoreOrder transferToAnotherSeller(RetailScmUserContext userContext, String retailStoreOrderId, String anotherSellerId)  throws Exception;
 	public RetailStoreOrder confirm(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date confirmTime
)  throws Exception;
	public RetailStoreOrder approve(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date approveTime
)  throws Exception;
	public RetailStoreOrder process(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date processTime
)  throws Exception;
	public RetailStoreOrder pick(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date processTime
)  throws Exception;
	public RetailStoreOrder ship(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date shipTime
)  throws Exception;
	public RetailStoreOrder deliver(RetailScmUserContext userContext, String retailStoreOrderId, String who, Date deliveryTime
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String retailStoreOrderId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOrder addRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderLineItem(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderLineItemId, int retailStoreOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrder addRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, String name, double amount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrder addRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String retailStoreOrderId, String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreOrder addGoods(RetailScmUserContext userContext, String retailStoreOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder removeGoods(RetailScmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrder updateGoods(RetailScmUserContext userContext, String retailStoreOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


