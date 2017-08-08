
package com.skynet.retailscm.consumerorderdelivery;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderDeliveryDAO{

	
	public ConsumerOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderDelivery present(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options) throws Exception;
	public ConsumerOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderDelivery save(ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> saveConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options);
	public SmartList<ConsumerOrderDelivery> removeConsumerOrderDeliveryList(SmartList<ConsumerOrderDelivery> consumerOrderDeliveryList,Map<String,Object> options);
	
	public void delete(String consumerOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


