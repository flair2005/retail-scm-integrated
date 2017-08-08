
package com.skynet.retailscm.employeesalarysheet;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeSalarySheetDAO{

	
	public EmployeeSalarySheet load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeSalarySheet present(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options) throws Exception;
	public EmployeeSalarySheet clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeSalarySheet save(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> saveEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options);
	public SmartList<EmployeeSalarySheet> removeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options);
	
	public void delete(String employeeSalarySheetId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, Map<String,Object> options);
 	public int countEmployeeSalarySheetByPayingOff(String payingOffId, Map<String,Object> options);
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, int start, int count, Map<String,Object> options);
 
 }


