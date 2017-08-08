
package com.skynet.retailscm.retailstoreopening;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreOpeningDAO{

	
	public RetailStoreOpening load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreOpening present(RetailStoreOpening retailStoreOpening,Map<String,Object> options) throws Exception;
	public RetailStoreOpening clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreOpening save(RetailStoreOpening retailStoreOpening,Map<String,Object> options);
	public SmartList<RetailStoreOpening> saveRetailStoreOpeningList(SmartList<RetailStoreOpening> retailStoreOpeningList,Map<String,Object> options);
	public SmartList<RetailStoreOpening> removeRetailStoreOpeningList(SmartList<RetailStoreOpening> retailStoreOpeningList,Map<String,Object> options);
	
	public void delete(String retailStoreOpeningId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


