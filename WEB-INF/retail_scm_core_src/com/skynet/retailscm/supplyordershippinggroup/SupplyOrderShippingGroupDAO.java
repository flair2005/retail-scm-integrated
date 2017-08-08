
package com.skynet.retailscm.supplyordershippinggroup;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderShippingGroupDAO{

	
	public SupplyOrderShippingGroup load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderShippingGroup present(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options) throws Exception;
	public SupplyOrderShippingGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderShippingGroup save(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options);
	public SmartList<SupplyOrderShippingGroup> saveSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options);
	public SmartList<SupplyOrderShippingGroup> removeSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options);
	
	public void delete(String supplyOrderShippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countSupplyOrderShippingGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 
 }


