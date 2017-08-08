
package com.skynet.retailscm.termination;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TerminationDAO{

	
	public Termination load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Termination present(Termination termination,Map<String,Object> options) throws Exception;
	public Termination clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Termination save(Termination termination,Map<String,Object> options);
	public SmartList<Termination> saveTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	public SmartList<Termination> removeTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	
	public void delete(String terminationId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public int countTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public int countTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, int start, int count, Map<String,Object> options);
 
 }


