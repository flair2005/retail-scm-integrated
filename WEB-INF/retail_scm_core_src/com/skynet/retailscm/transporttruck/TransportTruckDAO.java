
package com.skynet.retailscm.transporttruck;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TransportTruckDAO{

	
	public TransportTruck load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TransportTruck present(TransportTruck transportTruck,Map<String,Object> options) throws Exception;
	public TransportTruck clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportTruck save(TransportTruck transportTruck,Map<String,Object> options);
	public SmartList<TransportTruck> saveTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options);
	public SmartList<TransportTruck> removeTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options);
	
	public void delete(String transportTruckId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId, Map<String,Object> options);
 	public int countTransportTruckByOwner(String transportFleetId, Map<String,Object> options);
 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId, int start, int count, Map<String,Object> options);
 
 }


