
package com.skynet.retailscm.employeeeducation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeEducationDAO{

	
	public EmployeeEducation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeEducation present(EmployeeEducation employeeEducation,Map<String,Object> options) throws Exception;
	public EmployeeEducation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeEducation save(EmployeeEducation employeeEducation,Map<String,Object> options);
	public SmartList<EmployeeEducation> saveEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList,Map<String,Object> options);
	public SmartList<EmployeeEducation> removeEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList,Map<String,Object> options);
	
	public void delete(String employeeEducationId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeEducationByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
 }


