
package com.skynet.retailscm.consumerorderpaymentgroup;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderPaymentGroupDAO{

	
	public ConsumerOrderPaymentGroup load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderPaymentGroup present(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object> options) throws Exception;
	public ConsumerOrderPaymentGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderPaymentGroup save(ConsumerOrderPaymentGroup consumerOrderPaymentGroup,Map<String,Object> options);
	public SmartList<ConsumerOrderPaymentGroup> saveConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<ConsumerOrderPaymentGroup> removeConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList,Map<String,Object> options);
	
	public void delete(String consumerOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public int countConsumerOrderPaymentGroupByBizOrder(String consumerOrderId, Map<String,Object> options);
 	public SmartList<ConsumerOrderPaymentGroup> findConsumerOrderPaymentGroupByBizOrder(String consumerOrderId, int start, int count, Map<String,Object> options);
 
 }


