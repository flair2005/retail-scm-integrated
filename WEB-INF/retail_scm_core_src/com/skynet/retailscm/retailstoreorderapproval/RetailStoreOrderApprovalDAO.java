
package com.skynet.retailscm.retailstoreorderapproval;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderApprovalDAO{

	
	public RetailStoreOrderApproval load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderApproval present(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options) throws Exception;
	public RetailStoreOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderApproval save(RetailStoreOrderApproval retailStoreOrderApproval,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> saveRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options);
	public SmartList<RetailStoreOrderApproval> removeRetailStoreOrderApprovalList(SmartList<RetailStoreOrderApproval> retailStoreOrderApprovalList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


