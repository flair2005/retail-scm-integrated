
package com.skynet.retailscm.supplyorderapproval;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderApprovalDAO{

	
	public SupplyOrderApproval load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderApproval present(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options) throws Exception;
	public SupplyOrderApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderApproval save(SupplyOrderApproval supplyOrderApproval,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> saveSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options);
	public SmartList<SupplyOrderApproval> removeSupplyOrderApprovalList(SmartList<SupplyOrderApproval> supplyOrderApprovalList,Map<String,Object> options);
	
	public void delete(String supplyOrderApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


