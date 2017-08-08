
package com.skynet.retailscm.jobapplication;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface JobApplicationDAO{

	
	public JobApplication load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public JobApplication present(JobApplication jobApplication,Map<String,Object> options) throws Exception;
	public JobApplication clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public JobApplication save(JobApplication jobApplication,Map<String,Object> options);
	public SmartList<JobApplication> saveJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options);
	public SmartList<JobApplication> removeJobApplicationList(SmartList<JobApplication> jobApplicationList,Map<String,Object> options);
	
	public void delete(String jobApplicationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


