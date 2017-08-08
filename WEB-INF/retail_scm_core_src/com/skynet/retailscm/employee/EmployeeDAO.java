
package com.skynet.retailscm.employee;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeDAO{

	
	public Employee load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Employee present(Employee employee,Map<String,Object> options) throws Exception;
	public Employee clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Employee save(Employee employee,Map<String,Object> options);
	public SmartList<Employee> saveEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options);
	public SmartList<Employee> removeEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options);
	
	public void delete(String employeeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countEmployeeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId, Map<String,Object> options);
 	public int countEmployeeByDepartment(String levelThreeDepartmentId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByDepartment(String levelThreeDepartmentId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId, Map<String,Object> options);
 	public int countEmployeeByOccupation(String occupationTypeId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByOccupation(String occupationTypeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId, Map<String,Object> options);
 	public int countEmployeeByResponsibleFor(String responsibilityTypeId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByResponsibleFor(String responsibilityTypeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public int countEmployeeByCurrentSalaryGrade(String salaryGradeId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByCurrentSalaryGrade(String salaryGradeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByJobApplication(String jobApplicationId, Map<String,Object> options);
 	public int countEmployeeByJobApplication(String jobApplicationId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByJobApplication(String jobApplicationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByProfessionInterview(String professionInterviewId, Map<String,Object> options);
 	public int countEmployeeByProfessionInterview(String professionInterviewId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByProfessionInterview(String professionInterviewId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByHrInterview(String hrInterviewId, Map<String,Object> options);
 	public int countEmployeeByHrInterview(String hrInterviewId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByHrInterview(String hrInterviewId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByOfferApproval(String offerApprovalId, Map<String,Object> options);
 	public int countEmployeeByOfferApproval(String offerApprovalId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByOfferApproval(String offerApprovalId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByOfferAcceptance(String offerAcceptanceId, Map<String,Object> options);
 	public int countEmployeeByOfferAcceptance(String offerAcceptanceId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByOfferAcceptance(String offerAcceptanceId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByEmployeeBoarding(String employeeBoardingId, Map<String,Object> options);
 	public int countEmployeeByEmployeeBoarding(String employeeBoardingId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByEmployeeBoarding(String employeeBoardingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Employee> findEmployeeByTermination(String terminationId, Map<String,Object> options);
 	public int countEmployeeByTermination(String terminationId, Map<String,Object> options);
 	public SmartList<Employee> findEmployeeByTermination(String terminationId, int start, int count, Map<String,Object> options);
 
 }


