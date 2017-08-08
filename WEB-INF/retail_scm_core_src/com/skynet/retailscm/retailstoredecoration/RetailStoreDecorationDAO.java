
package com.skynet.retailscm.retailstoredecoration;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreDecorationDAO{

	
	public RetailStoreDecoration load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreDecoration present(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options) throws Exception;
	public RetailStoreDecoration clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreDecoration save(RetailStoreDecoration retailStoreDecoration,Map<String,Object> options);
	public SmartList<RetailStoreDecoration> saveRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options);
	public SmartList<RetailStoreDecoration> removeRetailStoreDecorationList(SmartList<RetailStoreDecoration> retailStoreDecorationList,Map<String,Object> options);
	
	public void delete(String retailStoreDecorationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


