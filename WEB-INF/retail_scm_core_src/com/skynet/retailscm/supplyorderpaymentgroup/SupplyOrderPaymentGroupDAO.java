
package com.skynet.retailscm.supplyorderpaymentgroup;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderPaymentGroupDAO{

	
	public SupplyOrderPaymentGroup load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderPaymentGroup present(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options) throws Exception;
	public SupplyOrderPaymentGroup clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderPaymentGroup save(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options);
	public SmartList<SupplyOrderPaymentGroup> saveSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options);
	public SmartList<SupplyOrderPaymentGroup> removeSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options);
	
	public void delete(String supplyOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 
 }


