
package com.skynet.retailscm.retailstoreorderlineitem;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderLineItemDAO{

	
	public RetailStoreOrderLineItem load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderLineItem present(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options) throws Exception;
	public RetailStoreOrderLineItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderLineItem save(RetailStoreOrderLineItem retailStoreOrderLineItem,Map<String,Object> options);
	public SmartList<RetailStoreOrderLineItem> saveRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options);
	public SmartList<RetailStoreOrderLineItem> removeRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderLineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public SmartList<RetailStoreOrderLineItem> findRetailStoreOrderLineItemByBizOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 
 }


