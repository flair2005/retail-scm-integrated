
package com.skynet.retailscm.retailstoreprovincecenter;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreProvinceCenterDAO{

	
	public RetailStoreProvinceCenter load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreProvinceCenter present(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options) throws Exception;
	public RetailStoreProvinceCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreProvinceCenter save(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> saveRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreProvinceCenter> removeRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options);
	
	public void delete(String retailStoreProvinceCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


