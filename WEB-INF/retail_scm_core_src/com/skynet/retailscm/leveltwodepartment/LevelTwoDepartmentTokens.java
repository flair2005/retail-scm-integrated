
package com.skynet.retailscm.leveltwodepartment;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class LevelTwoDepartmentTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="levelTwoDepartment";
	
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
	protected LevelTwoDepartmentTokens(){
		//ensure not initialized outside the class
	}
	
	public LevelTwoDepartmentTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LevelTwoDepartmentTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LevelTwoDepartmentTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LevelTwoDepartmentTokens start(){
		return new LevelTwoDepartmentTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LevelTwoDepartmentTokens allTokens(){
		
		return start()
			.withBelongsTo()
			.withLevelThreeDepartmentList();
	
	}
	protected static LevelTwoDepartmentTokens withoutListsTokens(){
		
		return start()
			.withBelongsTo();
	
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

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	public LevelTwoDepartmentTokens withBelongsTo(){		
		addSimpleOptions(BELONGSTO);
		return this;
	}
	
	
	protected static final String LEVEL_THREE_DEPARTMENT_LIST = "levelThreeDepartmentList";
	public String getLevelThreeDepartmentList(){
		return LEVEL_THREE_DEPARTMENT_LIST;
	}
	public LevelTwoDepartmentTokens withLevelThreeDepartmentList(){		
		addSimpleOptions(LEVEL_THREE_DEPARTMENT_LIST);
		return this;
	}	
		
}

