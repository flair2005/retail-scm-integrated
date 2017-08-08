
package com.skynet.retailscm.levelonecategory;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class LevelOneCategoryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="levelOneCategory";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected LevelOneCategoryTokens(){
		//ensure not initialized outside the class
	}
	
	public LevelOneCategoryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LevelOneCategoryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LevelOneCategoryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LevelOneCategoryTokens start(){
		return new LevelOneCategoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LevelOneCategoryTokens allTokens(){
		
		return start()
			.withCatalog()
			.withLevelTwoCategoryList();
	
	}
	protected static LevelOneCategoryTokens withoutListsTokens(){
		
		return start()
			.withCatalog();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String CATALOG = "catalog";
	public String getCatalog(){
		return CATALOG;
	}
	public LevelOneCategoryTokens withCatalog(){		
		addSimpleOptions(CATALOG);
		return this;
	}
	
	
	protected static final String LEVEL_TWO_CATEGORY_LIST = "levelTwoCategoryList";
	public String getLevelTwoCategoryList(){
		return LEVEL_TWO_CATEGORY_LIST;
	}
	public LevelOneCategoryTokens withLevelTwoCategoryList(){		
		addSimpleOptions(LEVEL_TWO_CATEGORY_LIST);
		return this;
	}	
		
}

