
package com.skynet.retailscm.retailstoreorderdelivery;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderDeliveryDAO{

	
	public RetailStoreOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderDelivery present(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options) throws Exception;
	public RetailStoreOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderDelivery save(RetailStoreOrderDelivery retailStoreOrderDelivery,Map<String,Object> options);
	public SmartList<RetailStoreOrderDelivery> saveRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options);
	public SmartList<RetailStoreOrderDelivery> removeRetailStoreOrderDeliveryList(SmartList<RetailStoreOrderDelivery> retailStoreOrderDeliveryList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


