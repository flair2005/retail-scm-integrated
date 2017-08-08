
package com.skynet.retailscm.smartpallet;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SmartPalletManager{

	public SmartPallet createSmartPallet(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude, String warehouseId
) throws Exception;	
	public SmartPallet updateSmartPallet(RetailScmUserContext userContext,String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SmartPallet transferToAnotherWarehouse(RetailScmUserContext userContext, String smartPalletId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String smartPalletId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SmartPallet addGoods(RetailScmUserContext userContext, String smartPalletId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  SmartPallet removeGoods(RetailScmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  SmartPallet updateGoods(RetailScmUserContext userContext, String smartPalletId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


