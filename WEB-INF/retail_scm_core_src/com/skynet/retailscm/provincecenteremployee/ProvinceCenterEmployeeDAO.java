
package com.skynet.retailscm.provincecenteremployee;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ProvinceCenterEmployeeDAO{

	
	public ProvinceCenterEmployee load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ProvinceCenterEmployee present(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options) throws Exception;
	public ProvinceCenterEmployee clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProvinceCenterEmployee save(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options);
	public SmartList<ProvinceCenterEmployee> saveProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options);
	public SmartList<ProvinceCenterEmployee> removeProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options);
	
	public void delete(String provinceCenterEmployeeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, Map<String,Object> options);
 	public int countProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, Map<String,Object> options);
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public int countProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, int start, int count, Map<String,Object> options);
 
 }


