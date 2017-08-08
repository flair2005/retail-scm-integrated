
package com.skynet.retailscm.storagespace;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface StorageSpaceManager{

	public StorageSpace createStorageSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, String warehouseId, double latitude, double longitude
) throws Exception;	
	public StorageSpace updateStorageSpace(RetailScmUserContext userContext,String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public StorageSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String storageSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String storageSpaceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  StorageSpace addGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, String location, String supplierSpaceId, String damageSpaceId ,String [] tokensExpr)  throws Exception;
	public  StorageSpace removeGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  StorageSpace updateGoodsShelf(RetailScmUserContext userContext, String storageSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


