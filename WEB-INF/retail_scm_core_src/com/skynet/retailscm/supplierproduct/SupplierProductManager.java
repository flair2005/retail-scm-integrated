
package com.skynet.retailscm.supplierproduct;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplierProductManager{

	public SupplierProduct createSupplierProduct(RetailScmUserContext userContext, String productName, String productDescription, String productUnit, String supplierId
) throws Exception;	
	public SupplierProduct updateSupplierProduct(RetailScmUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SupplierProduct transferToAnotherSupplier(RetailScmUserContext userContext, String supplierProductId, String anotherSupplierId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String supplierProductId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplierProduct addProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, int quantity, String duration, double price ,String [] tokensExpr)  throws Exception;
	public  SupplierProduct removeProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr)  throws Exception;
	public  SupplierProduct updateProductSupplyDuration(RetailScmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


