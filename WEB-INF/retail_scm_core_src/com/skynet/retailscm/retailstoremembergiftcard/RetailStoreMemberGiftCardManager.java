
package com.skynet.retailscm.retailstoremembergiftcard;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreMemberGiftCardManager{

	public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailScmUserContext userContext, String name, String ownerId, String number, double remain
) throws Exception;	
	public RetailStoreMemberGiftCard updateRetailStoreMemberGiftCard(RetailScmUserContext userContext,String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreMemberGiftCard transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, Date occureTime, String bizOrderId, String number, double amount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreMemberGiftCard updateRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String retailStoreMemberGiftCardId, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


