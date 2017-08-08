
package com.skynet.retailscm.truckdriver;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TruckDriverDAO{

	
	public TruckDriver load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TruckDriver present(TruckDriver truckDriver,Map<String,Object> options) throws Exception;
	public TruckDriver clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TruckDriver save(TruckDriver truckDriver,Map<String,Object> options);
	public SmartList<TruckDriver> saveTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options);
	public SmartList<TruckDriver> removeTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options);
	
	public void delete(String truckDriverId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public int countTruckDriverByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, int start, int count, Map<String,Object> options);
 
 }


