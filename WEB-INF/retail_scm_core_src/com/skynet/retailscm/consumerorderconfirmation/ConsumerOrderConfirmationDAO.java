
package com.skynet.retailscm.consumerorderconfirmation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderConfirmationDAO{

	
	public ConsumerOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderConfirmation present(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options) throws Exception;
	public ConsumerOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderConfirmation save(ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> saveConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options);
	public SmartList<ConsumerOrderConfirmation> removeConsumerOrderConfirmationList(SmartList<ConsumerOrderConfirmation> consumerOrderConfirmationList,Map<String,Object> options);
	
	public void delete(String consumerOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


