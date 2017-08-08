
package com.skynet.retailscm.supplyorder;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderManager{

	public SupplyOrder createSupplyOrder(RetailScmUserContext userContext, String buyerId, String sellerId, String title, double totalAmount
) throws Exception;	
	public SupplyOrder updateSupplyOrder(RetailScmUserContext userContext,String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SupplyOrder transferToAnotherBuyer(RetailScmUserContext userContext, String supplyOrderId, String anotherBuyerId)  throws Exception;
 	public SupplyOrder transferToAnotherSeller(RetailScmUserContext userContext, String supplyOrderId, String anotherSellerId)  throws Exception;
 	public SupplyOrder confirm(RetailScmUserContext userContext, String supplyOrderId, String who, Date confirmTime
)  throws Exception;
	public SupplyOrder approve(RetailScmUserContext userContext, String supplyOrderId, String who, Date approveTime
)  throws Exception;
	public SupplyOrder process(RetailScmUserContext userContext, String supplyOrderId, String who, Date processTime
)  throws Exception;
	public SupplyOrder pick(RetailScmUserContext userContext, String supplyOrderId, String who, Date processTime
)  throws Exception;
	public SupplyOrder ship(RetailScmUserContext userContext, String supplyOrderId, String who, Date shipTime
)  throws Exception;
	public SupplyOrder deliver(RetailScmUserContext userContext, String supplyOrderId, String who, Date deliveryTime
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String supplyOrderId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplyOrder addSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, String skuId, String skuName, double amount, int quantity, String unitOfMeasurement ,String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderLineItem(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, String name, double amount ,String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderId, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrder addGoods(RetailScmUserContext userContext, String supplyOrderId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  SupplyOrder removeGoods(RetailScmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrder updateGoods(RetailScmUserContext userContext, String supplyOrderId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


