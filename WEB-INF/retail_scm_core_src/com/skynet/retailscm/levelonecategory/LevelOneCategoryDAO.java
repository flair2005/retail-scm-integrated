
package com.skynet.retailscm.levelonecategory;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface LevelOneCategoryDAO{

	
	public LevelOneCategory load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public LevelOneCategory present(LevelOneCategory levelOneCategory,Map<String,Object> options) throws Exception;
	public LevelOneCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelOneCategory save(LevelOneCategory levelOneCategory,Map<String,Object> options);
	public SmartList<LevelOneCategory> saveLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options);
	public SmartList<LevelOneCategory> removeLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList,Map<String,Object> options);
	
	public void delete(String levelOneCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, Map<String,Object> options);
 	public int countLevelOneCategoryByCatalog(String catalogId, Map<String,Object> options);
 	public SmartList<LevelOneCategory> findLevelOneCategoryByCatalog(String catalogId, int start, int count, Map<String,Object> options);
 
 }


