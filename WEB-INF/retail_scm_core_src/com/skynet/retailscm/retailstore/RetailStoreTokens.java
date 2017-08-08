
package com.skynet.retailscm.retailstore;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStore";
	
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
	protected RetailStoreTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreTokens start(){
		return new RetailStoreTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreTokens allTokens(){
		
		return start()
			.withRetailStoreCountryCenter()
			.withCityServiceCenter()
			.withCreation()
			.withInvestmentInvitation()
			.withFranchising()
			.withDecoration()
			.withOpening()
			.withClosing()
			.withConsumerOrderList()
			.withRetailStoreOrderList()
			.withGoodsList()
			.withTransportTaskList()
			.withAccountSetList();
	
	}
	protected static RetailStoreTokens withoutListsTokens(){
		
		return start()
			.withRetailStoreCountryCenter()
			.withCityServiceCenter()
			.withCreation()
			.withInvestmentInvitation()
			.withFranchising()
			.withDecoration()
			.withOpening()
			.withClosing();
	
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

	protected static final String RETAILSTORECOUNTRYCENTER = "retailStoreCountryCenter";
	public String getRetailStoreCountryCenter(){
		return RETAILSTORECOUNTRYCENTER;
	}
	public RetailStoreTokens withRetailStoreCountryCenter(){		
		addSimpleOptions(RETAILSTORECOUNTRYCENTER);
		return this;
	}
	
	
	protected static final String CITYSERVICECENTER = "cityServiceCenter";
	public String getCityServiceCenter(){
		return CITYSERVICECENTER;
	}
	public RetailStoreTokens withCityServiceCenter(){		
		addSimpleOptions(CITYSERVICECENTER);
		return this;
	}
	
	
	protected static final String CREATION = "creation";
	public String getCreation(){
		return CREATION;
	}
	public RetailStoreTokens withCreation(){		
		addSimpleOptions(CREATION);
		return this;
	}
	
	
	protected static final String INVESTMENTINVITATION = "investmentInvitation";
	public String getInvestmentInvitation(){
		return INVESTMENTINVITATION;
	}
	public RetailStoreTokens withInvestmentInvitation(){		
		addSimpleOptions(INVESTMENTINVITATION);
		return this;
	}
	
	
	protected static final String FRANCHISING = "franchising";
	public String getFranchising(){
		return FRANCHISING;
	}
	public RetailStoreTokens withFranchising(){		
		addSimpleOptions(FRANCHISING);
		return this;
	}
	
	
	protected static final String DECORATION = "decoration";
	public String getDecoration(){
		return DECORATION;
	}
	public RetailStoreTokens withDecoration(){		
		addSimpleOptions(DECORATION);
		return this;
	}
	
	
	protected static final String OPENING = "opening";
	public String getOpening(){
		return OPENING;
	}
	public RetailStoreTokens withOpening(){		
		addSimpleOptions(OPENING);
		return this;
	}
	
	
	protected static final String CLOSING = "closing";
	public String getClosing(){
		return CLOSING;
	}
	public RetailStoreTokens withClosing(){		
		addSimpleOptions(CLOSING);
		return this;
	}
	
	
	protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	public String getConsumerOrderList(){
		return CONSUMER_ORDER_LIST;
	}
	public RetailStoreTokens withConsumerOrderList(){		
		addSimpleOptions(CONSUMER_ORDER_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	public String getRetailStoreOrderList(){
		return RETAIL_STORE_ORDER_LIST;
	}
	public RetailStoreTokens withRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return this;
	}	
		
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public RetailStoreTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
	protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	public String getTransportTaskList(){
		return TRANSPORT_TASK_LIST;
	}
	public RetailStoreTokens withTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST);
		return this;
	}	
		
	protected static final String ACCOUNT_SET_LIST = "accountSetList";
	public String getAccountSetList(){
		return ACCOUNT_SET_LIST;
	}
	public RetailStoreTokens withAccountSetList(){		
		addSimpleOptions(ACCOUNT_SET_LIST);
		return this;
	}	
		
}

