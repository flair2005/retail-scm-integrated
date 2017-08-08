
package com.skynet.retailscm.responsibilitytype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ResponsibilityTypeDAO{

	
	public ResponsibilityType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ResponsibilityType present(ResponsibilityType responsibilityType,Map<String,Object> options) throws Exception;
	public ResponsibilityType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ResponsibilityType save(ResponsibilityType responsibilityType,Map<String,Object> options);
	public SmartList<ResponsibilityType> saveResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options);
	public SmartList<ResponsibilityType> removeResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options);
	
	public void delete(String responsibilityTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countResponsibilityTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


