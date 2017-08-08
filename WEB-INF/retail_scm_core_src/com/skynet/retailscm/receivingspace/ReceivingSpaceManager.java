
package com.skynet.retailscm.receivingspace;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ReceivingSpaceManager{

	public ReceivingSpace createReceivingSpace(RetailScmUserContext userContext, String location, String contactNumber, String description, String totalArea, String warehouseId, double latitude, double longitude
) throws Exception;	
	public ReceivingSpace updateReceivingSpace(RetailScmUserContext userContext,String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ReceivingSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String receivingSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String receivingSpaceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  ReceivingSpace addGoods(RetailScmUserContext userContext, String receivingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  ReceivingSpace removeGoods(RetailScmUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  ReceivingSpace updateGoods(RetailScmUserContext userContext, String receivingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


