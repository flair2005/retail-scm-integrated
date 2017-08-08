
package com.skynet.retailscm.salarygrade;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SalaryGradeDAO{

	
	public SalaryGrade load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SalaryGrade present(SalaryGrade salaryGrade,Map<String,Object> options) throws Exception;
	public SalaryGrade clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SalaryGrade save(SalaryGrade salaryGrade,Map<String,Object> options);
	public SmartList<SalaryGrade> saveSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options);
	public SmartList<SalaryGrade> removeSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options);
	
	public void delete(String salaryGradeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countSalaryGradeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


