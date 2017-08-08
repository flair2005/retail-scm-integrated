
package com.skynet.retailscm.employeeattendance;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeAttendanceDAO{

	
	public EmployeeAttendance load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeAttendance present(EmployeeAttendance employeeAttendance,Map<String,Object> options) throws Exception;
	public EmployeeAttendance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeAttendance save(EmployeeAttendance employeeAttendance,Map<String,Object> options);
	public SmartList<EmployeeAttendance> saveEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options);
	public SmartList<EmployeeAttendance> removeEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options);
	
	public void delete(String employeeAttendanceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeAttendanceByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
 }


