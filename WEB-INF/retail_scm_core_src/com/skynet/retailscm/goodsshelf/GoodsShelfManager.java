
package com.skynet.retailscm.goodsshelf;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface GoodsShelfManager{

	public GoodsShelf createGoodsShelf(RetailScmUserContext userContext, String location, String storageSpaceId, String supplierSpaceId, String damageSpaceId
) throws Exception;	
	public GoodsShelf updateGoodsShelf(RetailScmUserContext userContext,String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public GoodsShelf transferToAnotherStorageSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherStorageSpaceId)  throws Exception;
 	public GoodsShelf transferToAnotherSupplierSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherSupplierSpaceId)  throws Exception;
 	public GoodsShelf transferToAnotherDamageSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherDamageSpaceId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String goodsShelfId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  GoodsShelf addGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, String title, Date countTime, String summary ,String [] tokensExpr)  throws Exception;
	public  GoodsShelf removeGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelf updateGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  GoodsShelf addGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, String location, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  GoodsShelf removeGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion,String [] tokensExpr)  throws Exception;
	public  GoodsShelf updateGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


