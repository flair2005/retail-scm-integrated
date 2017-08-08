
package com.skynet.retailscm.sku;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SkuManager{

	public Sku createSku(RetailScmUserContext userContext, String displayName, String size, String productId, String barcode, String packageType, String netContent, double price, String picture
) throws Exception;	
	public Sku updateSku(RetailScmUserContext userContext,String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Sku transferToAnotherProduct(RetailScmUserContext userContext, String skuId, String anotherProductId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String skuId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Sku addGoods(RetailScmUserContext userContext, String skuId, String name, String rfid, String uom, int maxPackage, Date expireTime, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  Sku removeGoods(RetailScmUserContext userContext, String skuId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  Sku updateGoods(RetailScmUserContext userContext, String skuId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


