
package com.skynet.retailscm.goodspackaging;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface GoodsPackagingManager{

	public GoodsPackaging createGoodsPackaging(RetailScmUserContext userContext, String packageName, String rfid, Date packageTime, String description
) throws Exception;	
	public GoodsPackaging updateGoodsPackaging(RetailScmUserContext userContext,String goodsPackagingId, int goodsPackagingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String goodsPackagingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  GoodsPackaging addGoods(RetailScmUserContext userContext, String goodsPackagingId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  GoodsPackaging removeGoods(RetailScmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  GoodsPackaging updateGoods(RetailScmUserContext userContext, String goodsPackagingId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


