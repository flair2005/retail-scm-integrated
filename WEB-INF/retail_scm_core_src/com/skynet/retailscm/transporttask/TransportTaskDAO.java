
package com.skynet.retailscm.transporttask;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TransportTaskDAO{

	
	public TransportTask load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TransportTask present(TransportTask transportTask,Map<String,Object> options) throws Exception;
	public TransportTask clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportTask save(TransportTask transportTask,Map<String,Object> options);
	public SmartList<TransportTask> saveTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options);
	public SmartList<TransportTask> removeTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options);
	
	public void delete(String transportTaskId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TransportTask> findTransportTaskByEnd(String retailStoreId, Map<String,Object> options);
 	public int countTransportTaskByEnd(String retailStoreId, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByEnd(String retailStoreId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<TransportTask> findTransportTaskByDriver(String truckDriverId, Map<String,Object> options);
 	public int countTransportTaskByDriver(String truckDriverId, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByDriver(String truckDriverId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<TransportTask> findTransportTaskByTruck(String transportTruckId, Map<String,Object> options);
 	public int countTransportTaskByTruck(String transportTruckId, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByTruck(String transportTruckId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<TransportTask> findTransportTaskByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public int countTransportTaskByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public SmartList<TransportTask> findTransportTaskByBelongsTo(String transportFleetId, int start, int count, Map<String,Object> options);
 
 }


