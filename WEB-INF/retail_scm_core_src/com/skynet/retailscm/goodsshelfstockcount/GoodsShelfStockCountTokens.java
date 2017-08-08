
package com.skynet.retailscm.goodsshelfstockcount;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class GoodsShelfStockCountTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsShelfStockCount";
	
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
	protected GoodsShelfStockCountTokens(){
		//ensure not initialized outside the class
	}
	
	public GoodsShelfStockCountTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsShelfStockCountTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsShelfStockCountTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static GoodsShelfStockCountTokens start(){
		return new GoodsShelfStockCountTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static GoodsShelfStockCountTokens allTokens(){
		
		return start()
			.withShelf()
			.withStockCountIssueTrackList();
	
	}
	protected static GoodsShelfStockCountTokens withoutListsTokens(){
		
		return start()
			.withShelf();
	
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

	protected static final String SHELF = "shelf";
	public String getShelf(){
		return SHELF;
	}
	public GoodsShelfStockCountTokens withShelf(){		
		addSimpleOptions(SHELF);
		return this;
	}
	
	
	protected static final String STOCK_COUNT_ISSUE_TRACK_LIST = "stockCountIssueTrackList";
	public String getStockCountIssueTrackList(){
		return STOCK_COUNT_ISSUE_TRACK_LIST;
	}
	public GoodsShelfStockCountTokens withStockCountIssueTrackList(){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST);
		return this;
	}	
		
}

