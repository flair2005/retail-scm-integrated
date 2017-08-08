
package com.skynet.retailscm.retailstoremembergiftcard;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreMemberGiftCardDAO{

	
	public RetailStoreMemberGiftCard load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreMemberGiftCard present(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options) throws Exception;
	public RetailStoreMemberGiftCard clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberGiftCard save(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> saveRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCard> removeRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options);
	
	public void delete(String retailStoreMemberGiftCardId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 
 }


