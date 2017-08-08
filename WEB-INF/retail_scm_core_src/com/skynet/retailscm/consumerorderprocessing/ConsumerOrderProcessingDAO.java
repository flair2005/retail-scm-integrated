
package com.skynet.retailscm.consumerorderprocessing;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderProcessingDAO{

	
	public ConsumerOrderProcessing load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderProcessing present(ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object> options) throws Exception;
	public ConsumerOrderProcessing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderProcessing save(ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object> options);
	public SmartList<ConsumerOrderProcessing> saveConsumerOrderProcessingList(SmartList<ConsumerOrderProcessing> consumerOrderProcessingList,Map<String,Object> options);
	public SmartList<ConsumerOrderProcessing> removeConsumerOrderProcessingList(SmartList<ConsumerOrderProcessing> consumerOrderProcessingList,Map<String,Object> options);
	
	public void delete(String consumerOrderProcessingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


