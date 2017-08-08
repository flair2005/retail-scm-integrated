
package com.skynet.retailscm.retailstoreorderpaymentgroup;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderPaymentGroupDAO{

	
	public RetailStoreOrderPaymentGroup load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderPaymentGroup present(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options) throws Exception;
	public RetailStoreOrderPaymentGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderPaymentGroup save(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object> options);
	public SmartList<RetailStoreOrderPaymentGroup> saveRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<RetailStoreOrderPaymentGroup> removeRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, Map<String,Object> options);
 	public SmartList<RetailStoreOrderPaymentGroup> findRetailStoreOrderPaymentGroupByBizOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 
 }


