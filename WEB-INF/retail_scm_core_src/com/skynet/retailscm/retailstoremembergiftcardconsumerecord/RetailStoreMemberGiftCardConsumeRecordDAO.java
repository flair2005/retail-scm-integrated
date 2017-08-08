
package com.skynet.retailscm.retailstoremembergiftcardconsumerecord;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreMemberGiftCardConsumeRecordDAO{

	
	public RetailStoreMemberGiftCardConsumeRecord load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreMemberGiftCardConsumeRecord present(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object> options) throws Exception;
	public RetailStoreMemberGiftCardConsumeRecord clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberGiftCardConsumeRecord save(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> saveRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,Map<String,Object> options);
	public SmartList<RetailStoreMemberGiftCardConsumeRecord> removeRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList,Map<String,Object> options);
	
	public void delete(String retailStoreMemberGiftCardConsumeRecordId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId, Map<String,Object> options);
 	public int countRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId, Map<String,Object> options);
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByOwner(String retailStoreMemberGiftCardId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public SmartList<RetailStoreMemberGiftCardConsumeRecord> findRetailStoreMemberGiftCardConsumeRecordByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 
 }


