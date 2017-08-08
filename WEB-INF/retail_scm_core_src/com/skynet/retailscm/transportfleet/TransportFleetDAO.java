
package com.skynet.retailscm.transportfleet;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TransportFleetDAO{

	
	public TransportFleet load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TransportFleet present(TransportFleet transportFleet,Map<String,Object> options) throws Exception;
	public TransportFleet clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportFleet save(TransportFleet transportFleet,Map<String,Object> options);
	public SmartList<TransportFleet> saveTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options);
	public SmartList<TransportFleet> removeTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options);
	
	public void delete(String transportFleetId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTransportFleetByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


