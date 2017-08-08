
package com.skynet.retailscm.goodsallocation;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class GoodsAllocationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsAllocation";
	
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
	protected GoodsAllocationTokens(){
		//ensure not initialized outside the class
	}
	
	public GoodsAllocationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsAllocationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsAllocationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static GoodsAllocationTokens start(){
		return new GoodsAllocationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static GoodsAllocationTokens allTokens(){
		
		return start()
			.withGoodsShelf()
			.withGoodsList();
	
	}
	protected static GoodsAllocationTokens withoutListsTokens(){
		
		return start()
			.withGoodsShelf();
	
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

	protected static final String GOODSSHELF = "goodsShelf";
	public String getGoodsShelf(){
		return GOODSSHELF;
	}
	public GoodsAllocationTokens withGoodsShelf(){		
		addSimpleOptions(GOODSSHELF);
		return this;
	}
	
	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public GoodsAllocationTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
}

