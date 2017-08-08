
package com.skynet.retailscm.retailstoreclosing;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreClosingDAO{

	
	public RetailStoreClosing load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreClosing present(RetailStoreClosing retailStoreClosing,Map<String,Object> options) throws Exception;
	public RetailStoreClosing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreClosing save(RetailStoreClosing retailStoreClosing,Map<String,Object> options);
	public SmartList<RetailStoreClosing> saveRetailStoreClosingList(SmartList<RetailStoreClosing> retailStoreClosingList,Map<String,Object> options);
	public SmartList<RetailStoreClosing> removeRetailStoreClosingList(SmartList<RetailStoreClosing> retailStoreClosingList,Map<String,Object> options);
	
	public void delete(String retailStoreClosingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


