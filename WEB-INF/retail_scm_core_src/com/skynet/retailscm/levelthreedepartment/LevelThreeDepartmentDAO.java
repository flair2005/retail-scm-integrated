
package com.skynet.retailscm.levelthreedepartment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface LevelThreeDepartmentDAO{

	
	public LevelThreeDepartment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public LevelThreeDepartment present(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options) throws Exception;
	public LevelThreeDepartment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelThreeDepartment save(LevelThreeDepartment levelThreeDepartment,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> saveLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options);
	public SmartList<LevelThreeDepartment> removeLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList,Map<String,Object> options);
	
	public void delete(String levelThreeDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, Map<String,Object> options);
 	public int countLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, Map<String,Object> options);
 	public SmartList<LevelThreeDepartment> findLevelThreeDepartmentByBelongsTo(String levelTwoDepartmentId, int start, int count, Map<String,Object> options);
 
 }


