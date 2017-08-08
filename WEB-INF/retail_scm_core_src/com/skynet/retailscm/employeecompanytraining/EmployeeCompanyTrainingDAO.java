
package com.skynet.retailscm.employeecompanytraining;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeCompanyTrainingDAO{

	
	public EmployeeCompanyTraining load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeCompanyTraining present(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options) throws Exception;
	public EmployeeCompanyTraining clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeCompanyTraining save(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options);
	public SmartList<EmployeeCompanyTraining> saveEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options);
	public SmartList<EmployeeCompanyTraining> removeEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options);
	
	public void delete(String employeeCompanyTrainingId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId, Map<String,Object> options);
 	public int countEmployeeCompanyTrainingByEmployee(String employeeId, Map<String,Object> options);
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId, Map<String,Object> options);
 	public int countEmployeeCompanyTrainingByTraining(String companyTrainingId, Map<String,Object> options);
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId, Map<String,Object> options);
 	public int countEmployeeCompanyTrainingByScoring(String scoringId, Map<String,Object> options);
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId, int start, int count, Map<String,Object> options);
 
 }


