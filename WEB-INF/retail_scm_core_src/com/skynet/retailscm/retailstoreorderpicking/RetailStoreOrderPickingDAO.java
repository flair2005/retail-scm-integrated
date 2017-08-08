
package com.skynet.retailscm.retailstoreorderpicking;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderPickingDAO{

	
	public RetailStoreOrderPicking load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderPicking present(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options) throws Exception;
	public RetailStoreOrderPicking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderPicking save(RetailStoreOrderPicking retailStoreOrderPicking,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> saveRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPicking> removeRetailStoreOrderPickingList(SmartList<RetailStoreOrderPicking> retailStoreOrderPickingList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderPickingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


