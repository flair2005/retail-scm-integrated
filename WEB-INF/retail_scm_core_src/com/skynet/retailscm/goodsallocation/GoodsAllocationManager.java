
package com.skynet.retailscm.goodsallocation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface GoodsAllocationManager{

	public GoodsAllocation createGoodsAllocation(RetailScmUserContext userContext, String location, double latitude, double longitude, String goodsShelfId
) throws Exception;	
	public GoodsAllocation updateGoodsAllocation(RetailScmUserContext userContext,String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public GoodsAllocation transferToAnotherGoodsShelf(RetailScmUserContext userContext, String goodsAllocationId, String anotherGoodsShelfId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String goodsAllocationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  GoodsAllocation addGoods(RetailScmUserContext userContext, String goodsAllocationId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  GoodsAllocation removeGoods(RetailScmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  GoodsAllocation updateGoods(RetailScmUserContext userContext, String goodsAllocationId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


