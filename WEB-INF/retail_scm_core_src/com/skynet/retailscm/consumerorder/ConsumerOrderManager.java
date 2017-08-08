
package com.skynet.retailscm.consumerorder;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderManager{

	public ConsumerOrder createConsumerOrder(RetailScmUserContext userContext, String title, String consumerId, String storeId
) throws Exception;	
	public ConsumerOrder updateConsumerOrder(RetailScmUserContext userContext,String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ConsumerOrder transferToAnotherConsumer(RetailScmUserContext userContext, String consumerOrderId, String anotherConsumerId)  throws Exception;
 	public ConsumerOrder confirm(RetailScmUserContext userContext, String consumerOrderId, String who, Date confirmTime
)  throws Exception;
	public ConsumerOrder approve(RetailScmUserContext userContext, String consumerOrderId, String who, Date approveTime
)  throws Exception;
	public ConsumerOrder process(RetailScmUserContext userContext, String consumerOrderId, String who, Date processTime
)  throws Exception;
	public ConsumerOrder ship(RetailScmUserContext userContext, String consumerOrderId, String who, Date shipTime
)  throws Exception;
	public ConsumerOrder deliver(RetailScmUserContext userContext, String consumerOrderId, String who, Date deliveryTime
)  throws Exception;
	public ConsumerOrder transferToAnotherStore(RetailScmUserContext userContext, String consumerOrderId, String anotherStoreId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String consumerOrderId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  ConsumerOrder addConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, String skuId, String skuName, double price, double quantity, double amount ,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderLineItem(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, String name, double amount ,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderShippingGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, String name, String cardNumber ,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderPaymentGroup(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPaymentGroupId, int consumerOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, String name, double amount, String provider ,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String consumerOrderId, String consumerOrderPriceAdjustmentId, int consumerOrderPriceAdjustmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  ConsumerOrder addRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, Date occureTime, String ownerId, String number, double amount ,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr)  throws Exception;
	public  ConsumerOrder updateRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String consumerOrderId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


