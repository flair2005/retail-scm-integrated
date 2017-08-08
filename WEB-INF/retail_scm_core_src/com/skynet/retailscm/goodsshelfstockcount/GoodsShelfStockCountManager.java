
package com.skynet.retailscm.goodsshelfstockcount;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface GoodsShelfStockCountManager{

	public GoodsShelfStockCount createGoodsShelfStockCount(RetailScmUserContext userContext, String title, Date countTime, String summary, String shelfId
) throws Exception;	
	public GoodsShelfStockCount updateGoodsShelfStockCount(RetailScmUserContext userContext,String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public GoodsShelfStockCount transferToAnotherShelf(RetailScmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String goodsShelfStockCountId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  GoodsShelfStockCount addStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary ,String [] tokensExpr)  throws Exception;
	public  GoodsShelfStockCount removeStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelfStockCount updateStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


