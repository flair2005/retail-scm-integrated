
package com.skynet.retailscm.terminationreason;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TerminationReasonDAO{

	
	public TerminationReason load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TerminationReason present(TerminationReason terminationReason,Map<String,Object> options) throws Exception;
	public TerminationReason clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TerminationReason save(TerminationReason terminationReason,Map<String,Object> options);
	public SmartList<TerminationReason> saveTerminationReasonList(SmartList<TerminationReason> terminationReasonList,Map<String,Object> options);
	public SmartList<TerminationReason> removeTerminationReasonList(SmartList<TerminationReason> terminationReasonList,Map<String,Object> options);
	
	public void delete(String terminationReasonId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TerminationReason> findTerminationReasonByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTerminationReasonByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<TerminationReason> findTerminationReasonByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


