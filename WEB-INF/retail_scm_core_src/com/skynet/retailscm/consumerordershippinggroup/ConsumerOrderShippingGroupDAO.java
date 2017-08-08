
package com.skynet.retailscm.consumerordershippinggroup;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderShippingGroupDAO{

	
	public ConsumerOrderShippingGroup load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderShippingGroup present(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options) throws Exception;
	public ConsumerOrderShippingGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderShippingGroup save(ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object> options);
	public SmartList<ConsumerOrderShippingGroup> saveConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options);
	public SmartList<ConsumerOrderShippingGroup> removeConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList,Map<String,Object> options);
	
	public void delete(String consumerOrderShippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderShippingGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public SmartList<ConsumerOrderShippingGroup> findConsumerOrderShippingGroupByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 
 }


