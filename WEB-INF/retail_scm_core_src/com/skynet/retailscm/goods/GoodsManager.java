
package com.skynet.retailscm.goods;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface GoodsManager{

	public Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String retailStoreId, String bizOrderId, String retailStoreOrderId
) throws Exception;	
	public Goods updateGoods(RetailScmUserContext userContext,String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Goods transferToAnotherSku(RetailScmUserContext userContext, String goodsId, String anotherSkuId)  throws Exception;
 	public Goods transferToAnotherReceivingSpace(RetailScmUserContext userContext, String goodsId, String anotherReceivingSpaceId)  throws Exception;
 	public Goods transferToAnotherGoodsAllocation(RetailScmUserContext userContext, String goodsId, String anotherGoodsAllocationId)  throws Exception;
 	public Goods transferToAnotherSmartPallet(RetailScmUserContext userContext, String goodsId, String anotherSmartPalletId)  throws Exception;
 	public Goods transferToAnotherShippingSpace(RetailScmUserContext userContext, String goodsId, String anotherShippingSpaceId)  throws Exception;
 	public Goods transferToAnotherTransportTask(RetailScmUserContext userContext, String goodsId, String anotherTransportTaskId)  throws Exception;
 	public Goods transferToAnotherRetailStore(RetailScmUserContext userContext, String goodsId, String anotherRetailStoreId)  throws Exception;
 	public Goods transferToAnotherBizOrder(RetailScmUserContext userContext, String goodsId, String anotherBizOrderId)  throws Exception;
 	public Goods transferToAnotherRetailStoreOrder(RetailScmUserContext userContext, String goodsId, String anotherRetailStoreOrderId)  throws Exception;
 	public Goods pack(RetailScmUserContext userContext, String goodsId, String packageName, String rfid, Date packageTime, String description
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String goodsId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Goods addGoodsMovement(RetailScmUserContext userContext, String goodsId, Date moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  Goods removeGoodsMovement(RetailScmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion,String [] tokensExpr)  throws Exception;
	public  Goods updateGoodsMovement(RetailScmUserContext userContext, String goodsId, String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


