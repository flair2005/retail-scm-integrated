
package com.skynet.retailscm.product;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ProductManager{

	public Product createProduct(RetailScmUserContext userContext, String displayName, String parentCategoryId, String origin, String remark, String brand, String picture
) throws Exception;	
	public Product updateProduct(RetailScmUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Product transferToAnotherParentCategory(RetailScmUserContext userContext, String productId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Product addSku(RetailScmUserContext userContext, String productId, String displayName, String size, String barcode, String packageType, String netContent, double price, String picture ,String [] tokensExpr)  throws Exception;
	public  Product removeSku(RetailScmUserContext userContext, String productId, String skuId, int skuVersion,String [] tokensExpr)  throws Exception;
	public  Product updateSku(RetailScmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


