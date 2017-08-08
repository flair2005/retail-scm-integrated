
package com.skynet.retailscm.hrinterview;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface HrInterviewDAO{

	
	public HrInterview load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public HrInterview present(HrInterview hrInterview,Map<String,Object> options) throws Exception;
	public HrInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public HrInterview save(HrInterview hrInterview,Map<String,Object> options);
	public SmartList<HrInterview> saveHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options);
	public SmartList<HrInterview> removeHrInterviewList(SmartList<HrInterview> hrInterviewList,Map<String,Object> options);
	
	public void delete(String hrInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


