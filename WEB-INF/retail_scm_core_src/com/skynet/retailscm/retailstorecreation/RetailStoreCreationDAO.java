
package com.skynet.retailscm.retailstorecreation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreCreationDAO{

	
	public RetailStoreCreation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreCreation present(RetailStoreCreation retailStoreCreation,Map<String,Object> options) throws Exception;
	public RetailStoreCreation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreCreation save(RetailStoreCreation retailStoreCreation,Map<String,Object> options);
	public SmartList<RetailStoreCreation> saveRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options);
	public SmartList<RetailStoreCreation> removeRetailStoreCreationList(SmartList<RetailStoreCreation> retailStoreCreationList,Map<String,Object> options);
	
	public void delete(String retailStoreCreationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


