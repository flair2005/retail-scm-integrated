
package com.skynet.retailscm.retailstoreordershipment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderShipmentDAO{

	
	public RetailStoreOrderShipment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderShipment present(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options) throws Exception;
	public RetailStoreOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderShipment save(RetailStoreOrderShipment retailStoreOrderShipment,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> saveRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShipment> removeRetailStoreOrderShipmentList(SmartList<RetailStoreOrderShipment> retailStoreOrderShipmentList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


