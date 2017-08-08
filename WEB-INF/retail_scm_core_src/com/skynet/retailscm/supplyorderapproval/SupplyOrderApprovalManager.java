
package com.skynet.retailscm.supplyorderapproval;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderApprovalManager{

	public SupplyOrderApproval createSupplyOrderApproval(RetailScmUserContext userContext, String who, Date approveTime
) throws Exception;	
	public SupplyOrderApproval updateSupplyOrderApproval(RetailScmUserContext userContext,String supplyOrderApprovalId, int supplyOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String supplyOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplyOrderApproval addConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String title, String consumerId, String storeId ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateConsumerOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  SupplyOrderApproval addSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderApproval updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderApprovalId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


