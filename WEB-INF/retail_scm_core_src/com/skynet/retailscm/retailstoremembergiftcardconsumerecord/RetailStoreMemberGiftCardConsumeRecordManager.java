
package com.skynet.retailscm.retailstoremembergiftcardconsumerecord;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreMemberGiftCardConsumeRecordManager{

	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, Date occureTime, String ownerId, String bizOrderId, String number, double amount
) throws Exception;	
	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId)  throws Exception;
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherBizOrder(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


