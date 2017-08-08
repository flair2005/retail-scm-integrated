
package com.skynet.retailscm.retailstoreorderprocessing;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderProcessingDAO{

	
	public RetailStoreOrderProcessing load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderProcessing present(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options) throws Exception;
	public RetailStoreOrderProcessing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderProcessing save(RetailStoreOrderProcessing retailStoreOrderProcessing,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> saveRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options);
	public SmartList<RetailStoreOrderProcessing> removeRetailStoreOrderProcessingList(SmartList<RetailStoreOrderProcessing> retailStoreOrderProcessingList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderProcessingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


