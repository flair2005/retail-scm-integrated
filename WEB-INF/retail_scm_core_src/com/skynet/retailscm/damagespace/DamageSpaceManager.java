
package com.skynet.retailscm.damagespace;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface DamageSpaceManager{

	public DamageSpace createDamageSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude, String warehouseId
) throws Exception;	
	public DamageSpace updateDamageSpace(RetailScmUserContext userContext,String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public DamageSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String damageSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String damageSpaceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  DamageSpace addGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, String location, String storageSpaceId, String supplierSpaceId ,String [] tokensExpr)  throws Exception;
	public  DamageSpace removeGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  DamageSpace updateGoodsShelf(RetailScmUserContext userContext, String damageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


