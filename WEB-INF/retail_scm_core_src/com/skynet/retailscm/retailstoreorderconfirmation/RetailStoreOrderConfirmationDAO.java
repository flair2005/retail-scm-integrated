
package com.skynet.retailscm.retailstoreorderconfirmation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOrderConfirmationDAO{

	
	public RetailStoreOrderConfirmation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOrderConfirmation present(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options) throws Exception;
	public RetailStoreOrderConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOrderConfirmation save(RetailStoreOrderConfirmation retailStoreOrderConfirmation,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> saveRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options);
	public SmartList<RetailStoreOrderConfirmation> removeRetailStoreOrderConfirmationList(SmartList<RetailStoreOrderConfirmation> retailStoreOrderConfirmationList,Map<String,Object> options);
	
	public void delete(String retailStoreOrderConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


