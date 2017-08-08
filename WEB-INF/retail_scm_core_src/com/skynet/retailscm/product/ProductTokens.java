
package com.skynet.retailscm.product;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class ProductTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="product";
	
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
	protected ProductTokens(){
		//ensure not initialized outside the class
	}
	
	public ProductTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ProductTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ProductTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ProductTokens start(){
		return new ProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ProductTokens allTokens(){
		
		return start()
			.withParentCategory()
			.withSkuList();
	
	}
	protected static ProductTokens withoutListsTokens(){
		
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
	public ProductTokens withParentCategory(){		
		addSimpleOptions(PARENTCATEGORY);
		return this;
	}
	
	
	protected static final String SKU_LIST = "skuList";
	public String getSkuList(){
		return SKU_LIST;
	}
	public ProductTokens withSkuList(){		
		addSimpleOptions(SKU_LIST);
		return this;
	}	
		
}

