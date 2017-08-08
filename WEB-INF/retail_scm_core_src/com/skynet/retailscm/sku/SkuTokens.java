
package com.skynet.retailscm.sku;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SkuTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="sku";
	
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
	protected SkuTokens(){
		//ensure not initialized outside the class
	}
	
	public SkuTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SkuTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SkuTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SkuTokens start(){
		return new SkuTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SkuTokens allTokens(){
		
		return start()
			.withProduct()
			.withGoodsList();
	
	}
	protected static SkuTokens withoutListsTokens(){
		
		return start()
			.withProduct();
	
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

	protected static final String PRODUCT = "product";
	public String getProduct(){
		return PRODUCT;
	}
	public SkuTokens withProduct(){		
		addSimpleOptions(PRODUCT);
		return this;
	}
	
	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public SkuTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
}

