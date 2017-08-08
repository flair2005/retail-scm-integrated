
package com.skynet.retailscm.transporttasktrack;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TransportTaskTrackDAO{

	
	public TransportTaskTrack load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TransportTaskTrack present(TransportTaskTrack transportTaskTrack,Map<String,Object> options) throws Exception;
	public TransportTaskTrack clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TransportTaskTrack save(TransportTaskTrack transportTaskTrack,Map<String,Object> options);
	public SmartList<TransportTaskTrack> saveTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options);
	public SmartList<TransportTaskTrack> removeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options);
	
	public void delete(String transportTaskTrackId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId, Map<String,Object> options);
 	public int countTransportTaskTrackByMovement(String transportTaskId, Map<String,Object> options);
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId, int start, int count, Map<String,Object> options);
 
 }


