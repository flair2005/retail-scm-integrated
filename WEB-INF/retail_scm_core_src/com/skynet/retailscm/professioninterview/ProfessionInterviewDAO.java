
package com.skynet.retailscm.professioninterview;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ProfessionInterviewDAO{

	
	public ProfessionInterview load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ProfessionInterview present(ProfessionInterview professionInterview,Map<String,Object> options) throws Exception;
	public ProfessionInterview clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProfessionInterview save(ProfessionInterview professionInterview,Map<String,Object> options);
	public SmartList<ProfessionInterview> saveProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options);
	public SmartList<ProfessionInterview> removeProfessionInterviewList(SmartList<ProfessionInterview> professionInterviewList,Map<String,Object> options);
	
	public void delete(String professionInterviewId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


