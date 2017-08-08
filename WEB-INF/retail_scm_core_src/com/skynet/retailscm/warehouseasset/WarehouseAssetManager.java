
package com.skynet.retailscm.warehouseasset;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface WarehouseAssetManager{

	public WarehouseAsset createWarehouseAsset(RetailScmUserContext userContext, String name, String position, String ownerId
) throws Exception;	
	public WarehouseAsset updateWarehouseAsset(RetailScmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public WarehouseAsset transferToAnotherOwner(RetailScmUserContext userContext, String warehouseAssetId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String warehouseAssetId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


