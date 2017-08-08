
package com.skynet.retailscm.retailstorecityservicecenter;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreCityServiceCenterDAO{

	
	public RetailStoreCityServiceCenter load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreCityServiceCenter present(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options) throws Exception;
	public RetailStoreCityServiceCenter clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreCityServiceCenter save(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options);
	public SmartList<RetailStoreCityServiceCenter> saveRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCityServiceCenter> removeRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options);
	
	public void delete(String retailStoreCityServiceCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public int countRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, int start, int count, Map<String,Object> options);
 
 }


