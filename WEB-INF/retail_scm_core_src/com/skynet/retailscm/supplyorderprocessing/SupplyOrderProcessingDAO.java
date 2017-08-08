
package com.skynet.retailscm.supplyorderprocessing;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderProcessingDAO{

	
	public SupplyOrderProcessing load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderProcessing present(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options) throws Exception;
	public SupplyOrderProcessing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderProcessing save(SupplyOrderProcessing supplyOrderProcessing,Map<String,Object> options);
	public SmartList<SupplyOrderProcessing> saveSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options);
	public SmartList<SupplyOrderProcessing> removeSupplyOrderProcessingList(SmartList<SupplyOrderProcessing> supplyOrderProcessingList,Map<String,Object> options);
	
	public void delete(String supplyOrderProcessingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


