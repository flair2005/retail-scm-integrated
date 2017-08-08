
package com.skynet.retailscm.consumerordershipment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderShipmentDAO{

	
	public ConsumerOrderShipment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrderShipment present(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options) throws Exception;
	public ConsumerOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrderShipment save(ConsumerOrderShipment consumerOrderShipment,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> saveConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options);
	public SmartList<ConsumerOrderShipment> removeConsumerOrderShipmentList(SmartList<ConsumerOrderShipment> consumerOrderShipmentList,Map<String,Object> options);
	
	public void delete(String consumerOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


