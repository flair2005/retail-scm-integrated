
package com.skynet.retailscm.trainingcoursetype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TrainingCourseTypeDAO{

	
	public TrainingCourseType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TrainingCourseType present(TrainingCourseType trainingCourseType,Map<String,Object> options) throws Exception;
	public TrainingCourseType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TrainingCourseType save(TrainingCourseType trainingCourseType,Map<String,Object> options);
	public SmartList<TrainingCourseType> saveTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options);
	public SmartList<TrainingCourseType> removeTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options);
	
	public void delete(String trainingCourseTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTrainingCourseTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


