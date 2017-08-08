
package com.skynet.retailscm.retailstoreorderconfirmation;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderConfirmationManager{

	public RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(RetailScmUserContext userContext, String who, Date confirmTime
) throws Exception;	
	public RetailStoreOrderConfirmation updateRetailStoreOrderConfirmation(RetailScmUserContext userContext,String retailStoreOrderConfirmationId, int retailStoreOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOrderConfirmation addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderConfirmation updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderConfirmationId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


