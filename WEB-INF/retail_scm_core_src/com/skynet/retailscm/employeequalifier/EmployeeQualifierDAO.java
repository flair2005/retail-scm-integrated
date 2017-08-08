
package com.skynet.retailscm.employeequalifier;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeQualifierDAO{

	
	public EmployeeQualifier load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeQualifier present(EmployeeQualifier employeeQualifier,Map<String,Object> options) throws Exception;
	public EmployeeQualifier clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeQualifier save(EmployeeQualifier employeeQualifier,Map<String,Object> options);
	public SmartList<EmployeeQualifier> saveEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options);
	public SmartList<EmployeeQualifier> removeEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options);
	
	public void delete(String employeeQualifierId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeQualifierByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
 }


