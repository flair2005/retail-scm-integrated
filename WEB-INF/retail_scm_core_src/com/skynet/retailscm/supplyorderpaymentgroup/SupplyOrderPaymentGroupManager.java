
package com.skynet.retailscm.supplyorderpaymentgroup;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderPaymentGroupManager{

	public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(RetailScmUserContext userContext, String name, String bizOrderId, String cardNumber
) throws Exception;	
	public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroup(RetailScmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SupplyOrderPaymentGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String supplyOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


