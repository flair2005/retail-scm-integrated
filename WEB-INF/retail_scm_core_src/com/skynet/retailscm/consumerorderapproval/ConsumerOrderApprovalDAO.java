
package com.skynet.retailscm.consumerorderapproval;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderApprovalDAO{

	
	public ConsumerOrderApproval load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderApproval present(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options) throws Exception;
	public ConsumerOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderApproval save(ConsumerOrderApproval consumerOrderApproval,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> saveConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options);
	public SmartList<ConsumerOrderApproval> removeConsumerOrderApprovalList(SmartList<ConsumerOrderApproval> consumerOrderApprovalList,Map<String,Object> options);
	
	public void delete(String consumerOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


