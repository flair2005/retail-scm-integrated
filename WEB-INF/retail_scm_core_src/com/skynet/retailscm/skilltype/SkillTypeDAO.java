
package com.skynet.retailscm.skilltype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SkillTypeDAO{

	
	public SkillType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SkillType present(SkillType skillType,Map<String,Object> options) throws Exception;
	public SkillType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SkillType save(SkillType skillType,Map<String,Object> options);
	public SmartList<SkillType> saveSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options);
	public SmartList<SkillType> removeSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options);
	
	public void delete(String skillTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countSkillTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


