
package com.skynet.retailscm.retailstoreordershipment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderShipmentManager{

	public RetailStoreOrderShipment createRetailStoreOrderShipment(RetailScmUserContext userContext, String who, Date shipTime
) throws Exception;	
	public RetailStoreOrderShipment updateRetailStoreOrderShipment(RetailScmUserContext userContext,String retailStoreOrderShipmentId, int retailStoreOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOrderShipment addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderShipment updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderShipmentId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


