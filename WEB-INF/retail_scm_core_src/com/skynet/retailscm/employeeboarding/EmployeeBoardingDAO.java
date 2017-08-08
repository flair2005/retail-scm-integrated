
package com.skynet.retailscm.employeeboarding;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface EmployeeBoardingDAO{

	
	public EmployeeBoarding load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public EmployeeBoarding present(EmployeeBoarding employeeBoarding,Map<String,Object> options) throws Exception;
	public EmployeeBoarding clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public EmployeeBoarding save(EmployeeBoarding employeeBoarding,Map<String,Object> options);
	public SmartList<EmployeeBoarding> saveEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options);
	public SmartList<EmployeeBoarding> removeEmployeeBoardingList(SmartList<EmployeeBoarding> employeeBoardingList,Map<String,Object> options);
	
	public void delete(String employeeBoardingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


