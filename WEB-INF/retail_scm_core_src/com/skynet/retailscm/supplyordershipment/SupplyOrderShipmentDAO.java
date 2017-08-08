
package com.skynet.retailscm.supplyordershipment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderShipmentDAO{

	
	public SupplyOrderShipment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderShipment present(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options) throws Exception;
	public SupplyOrderShipment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderShipment save(SupplyOrderShipment supplyOrderShipment,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> saveSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options);
	public SmartList<SupplyOrderShipment> removeSupplyOrderShipmentList(SmartList<SupplyOrderShipment> supplyOrderShipmentList,Map<String,Object> options);
	
	public void delete(String supplyOrderShipmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


