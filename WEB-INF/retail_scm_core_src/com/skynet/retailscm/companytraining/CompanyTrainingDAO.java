
package com.skynet.retailscm.companytraining;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface CompanyTrainingDAO{

	
	public CompanyTraining load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public CompanyTraining present(CompanyTraining companyTraining,Map<String,Object> options) throws Exception;
	public CompanyTraining clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CompanyTraining save(CompanyTraining companyTraining,Map<String,Object> options);
	public SmartList<CompanyTraining> saveCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options);
	public SmartList<CompanyTraining> removeCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options);
	
	public void delete(String companyTrainingId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countCompanyTrainingByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId, Map<String,Object> options);
 	public int countCompanyTrainingByInstructor(String instructorId, Map<String,Object> options);
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, Map<String,Object> options);
 	public int countCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, Map<String,Object> options);
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, int start, int count, Map<String,Object> options);
 
 }


