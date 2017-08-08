
package com.skynet.retailscm.retailstoreordershippinggroup;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderShippingGroupDAO{

	
	public RetailStoreOrderShippingGroup load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderShippingGroup present(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options) throws Exception;
	public RetailStoreOrderShippingGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderShippingGroup save(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> saveRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderShippingGroup> removeRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderShippingGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public SmartList<RetailStoreOrderShippingGroup> findRetailStoreOrderShippingGroupByBizOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 
 }


