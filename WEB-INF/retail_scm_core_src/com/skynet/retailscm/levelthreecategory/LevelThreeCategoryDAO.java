
package com.skynet.retailscm.levelthreecategory;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface LevelThreeCategoryDAO{

	
	public LevelThreeCategory load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public LevelThreeCategory present(LevelThreeCategory levelThreeCategory,Map<String,Object> options) throws Exception;
	public LevelThreeCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelThreeCategory save(LevelThreeCategory levelThreeCategory,Map<String,Object> options);
	public SmartList<LevelThreeCategory> saveLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options);
	public SmartList<LevelThreeCategory> removeLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options);
	
	public void delete(String levelThreeCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public int countLevelThreeCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId, int start, int count, Map<String,Object> options);
 
 }


