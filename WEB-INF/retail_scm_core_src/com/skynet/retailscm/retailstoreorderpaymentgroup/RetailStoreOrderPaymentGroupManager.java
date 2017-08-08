
package com.skynet.retailscm.retailstoreorderpaymentgroup;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreOrderPaymentGroupManager{

	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String name, String bizOrderId, String cardNumber
) throws Exception;	
	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroup(RetailScmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreOrderPaymentGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


