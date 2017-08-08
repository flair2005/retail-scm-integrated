
package com.skynet.retailscm.consumerorderlineitem;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderLineItemDAO{

	
	public ConsumerOrderLineItem load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderLineItem present(ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object> options) throws Exception;
	public ConsumerOrderLineItem clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderLineItem save(ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object> options);
	public SmartList<ConsumerOrderLineItem> saveConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList,Map<String,Object> options);
	public SmartList<ConsumerOrderLineItem> removeConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList,Map<String,Object> options);
	
	public void delete(String consumerOrderLineItemId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderLineItemByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public SmartList<ConsumerOrderLineItem> findConsumerOrderLineItemByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 
 }


