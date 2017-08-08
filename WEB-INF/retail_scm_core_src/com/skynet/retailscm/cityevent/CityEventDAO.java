
package com.skynet.retailscm.cityevent;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface CityEventDAO{

	
	public CityEvent load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public CityEvent present(CityEvent cityEvent,Map<String,Object> options) throws Exception;
	public CityEvent clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CityEvent save(CityEvent cityEvent,Map<String,Object> options);
	public SmartList<CityEvent> saveCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options);
	public SmartList<CityEvent> removeCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options);
	
	public void delete(String cityEventId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 
 }


