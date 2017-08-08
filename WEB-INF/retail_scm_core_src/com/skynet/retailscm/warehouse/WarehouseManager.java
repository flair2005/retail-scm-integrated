
package com.skynet.retailscm.warehouse;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface WarehouseManager{

	public Warehouse createWarehouse(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, String ownerId, double latitude, double longitude
) throws Exception;	
	public Warehouse updateWarehouse(RetailScmUserContext userContext,String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Warehouse transferToAnotherOwner(RetailScmUserContext userContext, String warehouseId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String warehouseId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Warehouse addStorageSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  Warehouse removeStorageSpace(RetailScmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateStorageSpace(RetailScmUserContext userContext, String warehouseId, String storageSpaceId, int storageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Warehouse addSmartPallet(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  Warehouse removeSmartPallet(RetailScmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateSmartPallet(RetailScmUserContext userContext, String warehouseId, String smartPalletId, int smartPalletVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Warehouse addSupplierSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  Warehouse removeSupplierSpace(RetailScmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateSupplierSpace(RetailScmUserContext userContext, String warehouseId, String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Warehouse addReceivingSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String description, String totalArea, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  Warehouse removeReceivingSpace(RetailScmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateReceivingSpace(RetailScmUserContext userContext, String warehouseId, String receivingSpaceId, int receivingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Warehouse addShippingSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  Warehouse removeShippingSpace(RetailScmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateShippingSpace(RetailScmUserContext userContext, String warehouseId, String shippingSpaceId, int shippingSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Warehouse addDamageSpace(RetailScmUserContext userContext, String warehouseId, String location, String contactNumber, String totalArea, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  Warehouse removeDamageSpace(RetailScmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateDamageSpace(RetailScmUserContext userContext, String warehouseId, String damageSpaceId, int damageSpaceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  Warehouse addWarehouseAsset(RetailScmUserContext userContext, String warehouseId, String name, String position ,String [] tokensExpr)  throws Exception;
	public  Warehouse removeWarehouseAsset(RetailScmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion,String [] tokensExpr)  throws Exception;
	public  Warehouse updateWarehouseAsset(RetailScmUserContext userContext, String warehouseId, String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


