
package com.skynet.retailscm.employeeperformance;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeePerformanceDAO{

	
	public EmployeePerformance load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeePerformance present(EmployeePerformance employeePerformance,Map<String,Object> options) throws Exception;
	public EmployeePerformance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeePerformance save(EmployeePerformance employeePerformance,Map<String,Object> options);
	public SmartList<EmployeePerformance> saveEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList,Map<String,Object> options);
	public SmartList<EmployeePerformance> removeEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList,Map<String,Object> options);
	
	public void delete(String employeePerformanceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeePerformanceByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
 }


