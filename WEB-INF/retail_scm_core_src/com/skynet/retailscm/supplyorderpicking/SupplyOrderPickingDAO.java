
package com.skynet.retailscm.supplyorderpicking;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderPickingDAO{

	
	public SupplyOrderPicking load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderPicking present(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options) throws Exception;
	public SupplyOrderPicking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderPicking save(SupplyOrderPicking supplyOrderPicking,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> saveSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options);
	public SmartList<SupplyOrderPicking> removeSupplyOrderPickingList(SmartList<SupplyOrderPicking> supplyOrderPickingList,Map<String,Object> options);
	
	public void delete(String supplyOrderPickingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


