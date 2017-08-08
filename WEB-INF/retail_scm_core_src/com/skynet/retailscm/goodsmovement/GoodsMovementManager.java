
package com.skynet.retailscm.goodsmovement;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface GoodsMovementManager{

	public GoodsMovement createGoodsMovement(RetailScmUserContext userContext, Date moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, double latitude, double longitude, String goodsId
) throws Exception;	
	public GoodsMovement updateGoodsMovement(RetailScmUserContext userContext,String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public GoodsMovement transferToAnotherGoods(RetailScmUserContext userContext, String goodsMovementId, String anotherGoodsId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String goodsMovementId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


