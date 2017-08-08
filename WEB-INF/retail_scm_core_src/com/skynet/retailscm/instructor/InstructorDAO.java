
package com.skynet.retailscm.instructor;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface InstructorDAO{

	
	public Instructor load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Instructor present(Instructor instructor,Map<String,Object> options) throws Exception;
	public Instructor clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Instructor save(Instructor instructor,Map<String,Object> options);
	public SmartList<Instructor> saveInstructorList(SmartList<Instructor> instructorList,Map<String,Object> options);
	public SmartList<Instructor> removeInstructorList(SmartList<Instructor> instructorList,Map<String,Object> options);
	
	public void delete(String instructorId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Instructor> findInstructorByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countInstructorByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<Instructor> findInstructorByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


