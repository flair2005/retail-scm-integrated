
package com.skynet.retailscm.leveltwodepartment;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface LevelTwoDepartmentDAO{

	
	public LevelTwoDepartment load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public LevelTwoDepartment present(LevelTwoDepartment levelTwoDepartment,Map<String,Object> options) throws Exception;
	public LevelTwoDepartment clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelTwoDepartment save(LevelTwoDepartment levelTwoDepartment,Map<String,Object> options);
	public SmartList<LevelTwoDepartment> saveLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList,Map<String,Object> options);
	public SmartList<LevelTwoDepartment> removeLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList,Map<String,Object> options);
	
	public void delete(String levelTwoDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId, Map<String,Object> options);
 	public int countLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId, Map<String,Object> options);
 	public SmartList<LevelTwoDepartment> findLevelTwoDepartmentByBelongsTo(String levelOneDepartmentId, int start, int count, Map<String,Object> options);
 
 }


