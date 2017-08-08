
package com.skynet.retailscm.eventattendance;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EventAttendanceDAO{

	
	public EventAttendance load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EventAttendance present(EventAttendance eventAttendance,Map<String,Object> options) throws Exception;
	public EventAttendance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EventAttendance save(EventAttendance eventAttendance,Map<String,Object> options);
	public SmartList<EventAttendance> saveEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options);
	public SmartList<EventAttendance> removeEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options);
	
	public void delete(String eventAttendanceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public int countEventAttendanceByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId, Map<String,Object> options);
 	public int countEventAttendanceByCityEvent(String cityEventId, Map<String,Object> options);
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId, int start, int count, Map<String,Object> options);
 
 }


