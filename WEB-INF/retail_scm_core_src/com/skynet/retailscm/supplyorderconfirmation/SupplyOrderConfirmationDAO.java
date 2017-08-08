
package com.skynet.retailscm.supplyorderconfirmation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplyOrderConfirmationDAO{

	
	public SupplyOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplyOrderConfirmation present(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options) throws Exception;
	public SupplyOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplyOrderConfirmation save(SupplyOrderConfirmation supplyOrderConfirmation,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> saveSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options);
	public SmartList<SupplyOrderConfirmation> removeSupplyOrderConfirmationList(SmartList<SupplyOrderConfirmation> supplyOrderConfirmationList,Map<String,Object> options);
	
	public void delete(String supplyOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


