
package com.skynet.retailscm.supplyorderdelivery;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderDeliveryDAO{

	
	public SupplyOrderDelivery load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderDelivery present(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options) throws Exception;
	public SupplyOrderDelivery clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderDelivery save(SupplyOrderDelivery supplyOrderDelivery,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> saveSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options);
	public SmartList<SupplyOrderDelivery> removeSupplyOrderDeliveryList(SmartList<SupplyOrderDelivery> supplyOrderDeliveryList,Map<String,Object> options);
	
	public void delete(String supplyOrderDeliveryId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


