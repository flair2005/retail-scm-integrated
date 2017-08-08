
package com.skynet.retailscm.employeeleave;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeLeaveDAO{

	
	public EmployeeLeave load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeLeave present(EmployeeLeave employeeLeave,Map<String,Object> options) throws Exception;
	public EmployeeLeave clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeLeave save(EmployeeLeave employeeLeave,Map<String,Object> options);
	public SmartList<EmployeeLeave> saveEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options);
	public SmartList<EmployeeLeave> removeEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options);
	
	public void delete(String employeeLeaveId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId, Map<String,Object> options);
 	public int countEmployeeLeaveByWho(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId, Map<String,Object> options);
 	public int countEmployeeLeaveByType(String leaveTypeId, Map<String,Object> options);
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId, int start, int count, Map<String,Object> options);
 
 }


