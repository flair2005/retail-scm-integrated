
package com.skynet.retailscm.retailstoreorderprocessing;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderProcessingManager{

	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(RetailScmUserContext userContext, String who, Date processTime
) throws Exception;	
	public RetailStoreOrderProcessing updateRetailStoreOrderProcessing(RetailScmUserContext userContext,String retailStoreOrderProcessingId, int retailStoreOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOrderProcessing addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderProcessing updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderProcessingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


