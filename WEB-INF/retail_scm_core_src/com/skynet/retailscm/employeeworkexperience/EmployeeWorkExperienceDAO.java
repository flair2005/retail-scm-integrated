
package com.skynet.retailscm.employeeworkexperience;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeWorkExperienceDAO{

	
	public EmployeeWorkExperience load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeWorkExperience present(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options) throws Exception;
	public EmployeeWorkExperience clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeWorkExperience save(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options);
	public SmartList<EmployeeWorkExperience> saveEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options);
	public SmartList<EmployeeWorkExperience> removeEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options);
	
	public void delete(String employeeWorkExperienceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeWorkExperienceByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
 }


