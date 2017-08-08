
package com.skynet.retailscm.supplyorderlineitem;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderLineItemDAO{

	
	public SupplyOrderLineItem load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderLineItem present(SupplyOrderLineItem supplyOrderLineItem,Map<String,Object> options) throws Exception;
	public SupplyOrderLineItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderLineItem save(SupplyOrderLineItem supplyOrderLineItem,Map<String,Object> options);
	public SmartList<SupplyOrderLineItem> saveSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options);
	public SmartList<SupplyOrderLineItem> removeSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList,Map<String,Object> options);
	
	public void delete(String supplyOrderLineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countSupplyOrderLineItemByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public SmartList<SupplyOrderLineItem> findSupplyOrderLineItemByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 
 }


