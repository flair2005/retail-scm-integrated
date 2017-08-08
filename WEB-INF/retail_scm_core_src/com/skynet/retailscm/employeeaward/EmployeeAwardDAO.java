
package com.skynet.retailscm.employeeaward;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeAwardDAO{

	
	public EmployeeAward load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeAward present(EmployeeAward employeeAward,Map<String,Object> options) throws Exception;
	public EmployeeAward clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeAward save(EmployeeAward employeeAward,Map<String,Object> options);
	public SmartList<EmployeeAward> saveEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options);
	public SmartList<EmployeeAward> removeEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options);
	
	public void delete(String employeeAwardId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeAwardByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
 }


