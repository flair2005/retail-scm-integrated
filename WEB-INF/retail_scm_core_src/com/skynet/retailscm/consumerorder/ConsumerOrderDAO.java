
package com.skynet.retailscm.consumerorder;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ConsumerOrderDAO{

	
	public ConsumerOrder load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ConsumerOrder present(ConsumerOrder consumerOrder,Map<String,Object> options) throws Exception;
	public ConsumerOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ConsumerOrder save(ConsumerOrder consumerOrder,Map<String,Object> options);
	public SmartList<ConsumerOrder> saveConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options);
	public SmartList<ConsumerOrder> removeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options);
	
	public void delete(String consumerOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, Map<String,Object> options);
 	public int countConsumerOrderByConsumer(String retailStoreMemberId, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public int countConsumerOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public int countConsumerOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public int countConsumerOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public int countConsumerOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public int countConsumerOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, Map<String,Object> options);
 	public int countConsumerOrderByStore(String retailStoreId, Map<String,Object> options);
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, int start, int count, Map<String,Object> options);
 
 }


