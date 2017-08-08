
package com.skynet.retailscm.leveltwocategory;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface LevelTwoCategoryDAO{

	
	public LevelTwoCategory load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public LevelTwoCategory present(LevelTwoCategory levelTwoCategory,Map<String,Object> options) throws Exception;
	public LevelTwoCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelTwoCategory save(LevelTwoCategory levelTwoCategory,Map<String,Object> options);
	public SmartList<LevelTwoCategory> saveLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options);
	public SmartList<LevelTwoCategory> removeLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options);
	
	public void delete(String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public int countLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, int start, int count, Map<String,Object> options);
 
 }


