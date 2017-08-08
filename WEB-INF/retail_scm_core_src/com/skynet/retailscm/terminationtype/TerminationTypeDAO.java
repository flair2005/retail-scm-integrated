
package com.skynet.retailscm.terminationtype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface TerminationTypeDAO{

	
	public TerminationType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public TerminationType present(TerminationType terminationType,Map<String,Object> options) throws Exception;
	public TerminationType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TerminationType save(TerminationType terminationType,Map<String,Object> options);
	public SmartList<TerminationType> saveTerminationTypeList(SmartList<TerminationType> terminationTypeList,Map<String,Object> options);
	public SmartList<TerminationType> removeTerminationTypeList(SmartList<TerminationType> terminationTypeList,Map<String,Object> options);
	
	public void delete(String terminationTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<TerminationType> findTerminationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTerminationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<TerminationType> findTerminationTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


