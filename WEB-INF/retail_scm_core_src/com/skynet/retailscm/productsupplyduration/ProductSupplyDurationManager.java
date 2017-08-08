
package com.skynet.retailscm.productsupplyduration;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ProductSupplyDurationManager{

	public ProductSupplyDuration createProductSupplyDuration(RetailScmUserContext userContext, int quantity, String duration, double price, String productId
) throws Exception;	
	public ProductSupplyDuration updateProductSupplyDuration(RetailScmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ProductSupplyDuration transferToAnotherProduct(RetailScmUserContext userContext, String productSupplyDurationId, String anotherProductId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String productSupplyDurationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


