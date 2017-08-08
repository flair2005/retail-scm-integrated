
package com.skynet.retailscm.supplyorderconfirmation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderConfirmationManager{

	public SupplyOrderConfirmation createSupplyOrderConfirmation(RetailScmUserContext userContext, String who, Date confirmTime
) throws Exception;	
	public SupplyOrderConfirmation updateSupplyOrderConfirmation(RetailScmUserContext userContext,String supplyOrderConfirmationId, int supplyOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String supplyOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplyOrderConfirmation addConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrderConfirmation addSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderConfirmation updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderConfirmationId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


