
package com.skynet.retailscm.provincecenterdepartment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ProvinceCenterDepartmentDAO{

	
	public ProvinceCenterDepartment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ProvinceCenterDepartment present(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options) throws Exception;
	public ProvinceCenterDepartment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProvinceCenterDepartment save(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options);
	public SmartList<ProvinceCenterDepartment> saveProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options);
	public SmartList<ProvinceCenterDepartment> removeProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options);
	
	public void delete(String provinceCenterDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public int countProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, Map<String,Object> options);
 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, int start, int count, Map<String,Object> options);
 
 }


