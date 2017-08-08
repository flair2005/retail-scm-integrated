
package com.skynet.retailscm.goodssupplier;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface GoodsSupplierManager{

	public GoodsSupplier createGoodsSupplier(RetailScmUserContext userContext, String name, String supplyProduct, String belongToId, String contactNumber, String description
) throws Exception;	
	public GoodsSupplier updateGoodsSupplier(RetailScmUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public GoodsSupplier transferToAnotherBelongTo(RetailScmUserContext userContext, String goodsSupplierId, String anotherBelongToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String goodsSupplierId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  GoodsSupplier addSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit ,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplierProduct(RetailScmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, String buyerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplyOrder(RetailScmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addAccountSet(RetailScmUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId ,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeAccountSet(RetailScmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateAccountSet(RetailScmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


