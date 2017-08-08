
package com.skynet.retailscm.levelthreecategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.skynet.retailscm.BaseRowMapper;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;

public class LevelThreeCategoryMapper extends BaseRowMapper<LevelThreeCategory>{
	
	protected LevelThreeCategory internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LevelThreeCategory levelThreeCategory = getLevelThreeCategory();		
		 		
 		setId(levelThreeCategory, rs, rowNumber); 		
 		setParentCategory(levelThreeCategory, rs, rowNumber); 		
 		setDisplayName(levelThreeCategory, rs, rowNumber); 		
 		setVersion(levelThreeCategory, rs, rowNumber);

		return levelThreeCategory;
	}
	
	protected LevelThreeCategory getLevelThreeCategory(){
		return new LevelThreeCategory();
	}		
		
	protected void setId(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(LevelThreeCategoryTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
	
		levelThreeCategory.setId(id);
	}
		 		
 	protected void setParentCategory(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
 		String levelTwoCategoryId = rs.getString(LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY);
 		if( levelTwoCategoryId == null){
 			return;
 		}
 		if( levelTwoCategoryId.isEmpty()){
 			return;
 		}
 		LevelTwoCategory levelTwoCategory = levelThreeCategory.getParentCategory();
 		if( levelTwoCategory != null ){
 			//if the root object 'levelThreeCategory' already have the property, just set the id for it;
 			levelTwoCategory.setId(levelTwoCategoryId);
 			return;
 		}
 		levelThreeCategory.setParentCategory(createEmptyParentCategory(levelTwoCategoryId));
 	}
 	
	protected void setDisplayName(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String displayName = rs.getString(LevelThreeCategoryTable.COLUMN_DISPLAY_NAME);
		if(displayName == null){
			//do nothing when nothing found in database
			return;
		}
	
		levelThreeCategory.setDisplayName(displayName);
	}
		
	protected void setVersion(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(LevelThreeCategoryTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
	
		levelThreeCategory.setVersion(version);
	}
		
		

 	protected LevelTwoCategory  createEmptyParentCategory(String levelTwoCategoryId){
 		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
 		levelTwoCategory.setId(levelTwoCategoryId);
 		return levelTwoCategory;
 	}
 	
}


