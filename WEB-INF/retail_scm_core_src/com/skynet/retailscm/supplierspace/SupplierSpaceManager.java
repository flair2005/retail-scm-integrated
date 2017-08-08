
package com.skynet.retailscm.supplierspace;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplierSpaceManager{

	public SupplierSpace createSupplierSpace(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, String warehouseId, double latitude, double longitude
) throws Exception;	
	public SupplierSpace updateSupplierSpace(RetailScmUserContext userContext,String supplierSpaceId, int supplierSpaceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SupplierSpace transferToAnotherWarehouse(RetailScmUserContext userContext, String supplierSpaceId, String anotherWarehouseId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String supplierSpaceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplierSpace addGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, String location, String storageSpaceId, String damageSpaceId ,String [] tokensExpr)  throws Exception;
	public  SupplierSpace removeGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion,String [] tokensExpr)  throws Exception;
	public  SupplierSpace updateGoodsShelf(RetailScmUserContext userContext, String supplierSpaceId, String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


