
package com.skynet.retailscm.retailstoreorderapproval;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderApprovalManager{

	public RetailStoreOrderApproval createRetailStoreOrderApproval(RetailScmUserContext userContext, String who, Date approveTime
) throws Exception;	
	public RetailStoreOrderApproval updateRetailStoreOrderApproval(RetailScmUserContext userContext,String retailStoreOrderApprovalId, int retailStoreOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreOrderApproval addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreOrderApproval updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreOrderApprovalId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


