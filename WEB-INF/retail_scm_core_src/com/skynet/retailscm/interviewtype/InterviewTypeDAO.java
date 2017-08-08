
package com.skynet.retailscm.interviewtype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface InterviewTypeDAO{

	
	public InterviewType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public InterviewType present(InterviewType interviewType,Map<String,Object> options) throws Exception;
	public InterviewType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public InterviewType save(InterviewType interviewType,Map<String,Object> options);
	public SmartList<InterviewType> saveInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options);
	public SmartList<InterviewType> removeInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options);
	
	public void delete(String interviewTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countInterviewTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


