
package com.skynet.retailscm.employeeinterview;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeInterviewDAO{

	
	public EmployeeInterview load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeInterview present(EmployeeInterview employeeInterview,Map<String,Object> options) throws Exception;
	public EmployeeInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeInterview save(EmployeeInterview employeeInterview,Map<String,Object> options);
	public SmartList<EmployeeInterview> saveEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options);
	public SmartList<EmployeeInterview> removeEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options);
	
	public void delete(String employeeInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeInterviewByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId, Map<String,Object> options);
 	public int countEmployeeInterviewByInterviewType(String interviewTypeId, Map<String,Object> options);
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId, int start, int count, Map<String,Object> options);
 
 }


