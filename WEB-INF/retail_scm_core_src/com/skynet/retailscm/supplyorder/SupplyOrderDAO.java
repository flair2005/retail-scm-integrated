
package com.skynet.retailscm.supplyorder;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderDAO{

	
	public SupplyOrder load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrder present(SupplyOrder supplyOrder,Map<String,Object> options) throws Exception;
	public SupplyOrder clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrder save(SupplyOrder supplyOrder,Map<String,Object> options);
	public SmartList<SupplyOrder> saveSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options);
	public SmartList<SupplyOrder> removeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options);
	
	public void delete(String supplyOrderId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countSupplyOrderByBuyer(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId, Map<String,Object> options);
 	public int countSupplyOrderBySeller(String goodsSupplierId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<SupplyOrder> findSupplyOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public int countSupplyOrderByConfirmation(String supplyOrderConfirmationId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByConfirmation(String supplyOrderConfirmationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<SupplyOrder> findSupplyOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public int countSupplyOrderByApproval(String supplyOrderApprovalId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByApproval(String supplyOrderApprovalId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<SupplyOrder> findSupplyOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public int countSupplyOrderByProcessing(String supplyOrderProcessingId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByProcessing(String supplyOrderProcessingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<SupplyOrder> findSupplyOrderByPicking(String supplyOrderPickingId, Map<String,Object> options);
 	public int countSupplyOrderByPicking(String supplyOrderPickingId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByPicking(String supplyOrderPickingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<SupplyOrder> findSupplyOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public int countSupplyOrderByShipment(String supplyOrderShipmentId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByShipment(String supplyOrderShipmentId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<SupplyOrder> findSupplyOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public int countSupplyOrderByDelivery(String supplyOrderDeliveryId, Map<String,Object> options);
 	public SmartList<SupplyOrder> findSupplyOrderByDelivery(String supplyOrderDeliveryId, int start, int count, Map<String,Object> options);
 
 }


