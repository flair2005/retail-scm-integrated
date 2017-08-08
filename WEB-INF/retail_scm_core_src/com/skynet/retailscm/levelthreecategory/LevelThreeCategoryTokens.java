
package com.skynet.retailscm.levelthreecategory;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class LevelThreeCategoryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="levelThreeCategory";
	
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
	protected LevelThreeCategoryTokens(){
		//ensure not initialized outside the class
	}
	
	public LevelThreeCategoryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LevelThreeCategoryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LevelThreeCategoryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LevelThreeCategoryTokens start(){
		return new LevelThreeCategoryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LevelThreeCategoryTokens allTokens(){
		
		return start()
			.withParentCategory()
			.withProductList();
	
	}
	protected static LevelThreeCategoryTokens withoutListsTokens(){
		
		return start()
			.withParentCategory();
	
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

	protected static final String PARENTCATEGORY = "parentCategory";
	public String getParentCategory(){
		return PARENTCATEGORY;
	}
	public LevelThreeCategoryTokens withParentCategory(){		
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}
	
	
	protected static final String PRODUCT_LIST = "productList";
	public String getProductList(){
		return PRODUCT_LIST;
	}
	public LevelThreeCategoryTokens withProductList(){		
		addSimpleOptions(PRODUCT_LIST);
		return this;
	}	
		
}

