
package com.skynet.retailscm.consumerorderpriceadjustment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderPriceAdjustmentDAO{

	
	public ConsumerOrderPriceAdjustment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderPriceAdjustment present(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options) throws Exception;
	public ConsumerOrderPriceAdjustment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderPriceAdjustment save(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment,Map<String,Object> options);
	public SmartList<ConsumerOrderPriceAdjustment> saveConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderPriceAdjustment> removeConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList,Map<String,Object> options);
	
	public void delete(String consumerOrderPriceAdjustmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public SmartList<ConsumerOrderPriceAdjustment> findConsumerOrderPriceAdjustmentByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 
 }


