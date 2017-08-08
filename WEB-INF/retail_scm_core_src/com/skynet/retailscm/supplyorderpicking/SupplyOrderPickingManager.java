
package com.skynet.retailscm.supplyorderpicking;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SupplyOrderPickingManager{

	public SupplyOrderPicking createSupplyOrderPicking(RetailScmUserContext userContext, String who, Date processTime
) throws Exception;	
	public SupplyOrderPicking updateSupplyOrderPicking(RetailScmUserContext userContext,String supplyOrderPickingId, int supplyOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String supplyOrderPickingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SupplyOrderPicking addSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  SupplyOrderPicking updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


