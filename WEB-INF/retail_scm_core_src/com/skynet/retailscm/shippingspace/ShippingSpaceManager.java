
package com.skynet.retailscm.shippingspace;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ShippingSpaceManager{

	public ShippingSpace createShippingSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, String warehouseId, double latitude, double longitude, String description
) throws Exception;	
	public ShippingSpace updateShippingSpace(RetailScmUserContext userContext,String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ShippingSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String shippingSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String shippingSpaceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  ShippingSpace addGoods(RetailScmUserContext userContext, String shippingSpaceId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  ShippingSpace removeGoods(RetailScmUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  ShippingSpace updateGoods(RetailScmUserContext userContext, String shippingSpaceId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


