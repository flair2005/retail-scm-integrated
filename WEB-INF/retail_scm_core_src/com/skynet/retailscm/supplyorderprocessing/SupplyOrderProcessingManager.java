
package com.skynet.retailscm.supplyorderprocessing;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderProcessingManager{

	public SupplyOrderProcessing createSupplyOrderProcessing(RetailScmUserContext userContext, String who, Date processTime
) throws Exception;	
	public SupplyOrderProcessing updateSupplyOrderProcessing(RetailScmUserContext userContext,String supplyOrderProcessingId, int supplyOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String supplyOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplyOrderProcessing addConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrderProcessing addSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderProcessing updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderProcessingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


