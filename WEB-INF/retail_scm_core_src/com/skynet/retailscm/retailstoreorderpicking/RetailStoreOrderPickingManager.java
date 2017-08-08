
package com.skynet.retailscm.retailstoreorderpicking;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderPickingManager{

	public RetailStoreOrderPicking createRetailStoreOrderPicking(RetailScmUserContext userContext, String who, Date processTime
) throws Exception;	
	public RetailStoreOrderPicking updateRetailStoreOrderPicking(RetailScmUserContext userContext,String retailStoreOrderPickingId, int retailStoreOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreOrderPickingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOrderPicking addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderPicking removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderPicking updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderPickingId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


