
package com.skynet.retailscm.levelonedepartment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface LevelOneDepartmentDAO{

	
	public LevelOneDepartment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public LevelOneDepartment present(LevelOneDepartment levelOneDepartment,Map<String,Object> options) throws Exception;
	public LevelOneDepartment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelOneDepartment save(LevelOneDepartment levelOneDepartment,Map<String,Object> options);
	public SmartList<LevelOneDepartment> saveLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options);
	public SmartList<LevelOneDepartment> removeLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options);
	
	public void delete(String levelOneDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


