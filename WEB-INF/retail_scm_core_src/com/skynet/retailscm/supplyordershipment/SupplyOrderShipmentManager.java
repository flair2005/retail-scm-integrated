
package com.skynet.retailscm.supplyordershipment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderShipmentManager{

	public SupplyOrderShipment createSupplyOrderShipment(RetailScmUserContext userContext, String who, Date shipTime
) throws Exception;	
	public SupplyOrderShipment updateSupplyOrderShipment(RetailScmUserContext userContext,String supplyOrderShipmentId, int supplyOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String supplyOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplyOrderShipment addConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrderShipment addSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderShipment updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderShipmentId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


