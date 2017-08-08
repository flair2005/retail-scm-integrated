
package com.skynet.retailscm.employeeskill;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeSkillDAO{

	
	public EmployeeSkill load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeSkill present(EmployeeSkill employeeSkill,Map<String,Object> options) throws Exception;
	public EmployeeSkill clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeSkill save(EmployeeSkill employeeSkill,Map<String,Object> options);
	public SmartList<EmployeeSkill> saveEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options);
	public SmartList<EmployeeSkill> removeEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options);
	
	public void delete(String employeeSkillId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeSkillByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId, Map<String,Object> options);
 	public int countEmployeeSkillBySkillType(String skillTypeId, Map<String,Object> options);
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId, int start, int count, Map<String,Object> options);
 
 }


