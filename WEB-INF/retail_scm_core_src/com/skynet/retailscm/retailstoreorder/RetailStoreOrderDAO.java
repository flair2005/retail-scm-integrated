
package com.skynet.retailscm.retailstoreorder;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderDAO{

	
	public RetailStoreOrder load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrder present(RetailStoreOrder retailStoreOrder,Map<String,Object> options) throws Exception;
	public RetailStoreOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrder save(RetailStoreOrder retailStoreOrder,Map<String,Object> options);
	public SmartList<RetailStoreOrder> saveRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options);
	public SmartList<RetailStoreOrder> removeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId, Map<String,Object> options);
 	public int countRetailStoreOrderByBuyer(String retailStoreId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreOrderBySeller(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, Map<String,Object> options);
 	public int countRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId, Map<String,Object> options);
 	public int countRetailStoreOrderByApproval(String retailStoreOrderApprovalId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, Map<String,Object> options);
 	public int countRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId, Map<String,Object> options);
 	public int countRetailStoreOrderByPicking(String retailStoreOrderPickingId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId, Map<String,Object> options);
 	public int countRetailStoreOrderByShipment(String retailStoreOrderShipmentId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, Map<String,Object> options);
 	public int countRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, Map<String,Object> options);
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, int start, int count, Map<String,Object> options);
 
 }


