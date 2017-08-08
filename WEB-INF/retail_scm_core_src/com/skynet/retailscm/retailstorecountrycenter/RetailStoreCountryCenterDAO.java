
package com.skynet.retailscm.retailstorecountrycenter;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreCountryCenterDAO{

	
	public RetailStoreCountryCenter load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreCountryCenter present(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options) throws Exception;
	public RetailStoreCountryCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreCountryCenter save(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> saveRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> removeRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options);
	
	public void delete(String retailStoreCountryCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


