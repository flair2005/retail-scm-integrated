
package com.skynet.retailscm.supplierproduct;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class SupplierProductTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplierProduct";
	
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
	protected SupplierProductTokens(){
		//ensure not initialized outside the class
	}
	
	public SupplierProductTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplierProductTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplierProductTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static SupplierProductTokens start(){
		return new SupplierProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static SupplierProductTokens allTokens(){
		
		return start()
			.withSupplier()
			.withProductSupplyDurationList();
	
	}
	protected static SupplierProductTokens withoutListsTokens(){
		
		return start()
			.withSupplier();
	
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

	protected static final String SUPPLIER = "supplier";
	public String getSupplier(){
		return SUPPLIER;
	}
	public SupplierProductTokens withSupplier(){		
		addSimpleOptions(SUPPLIER);
		return this;
	}
	
	
	protected static final String PRODUCT_SUPPLY_DURATION_LIST = "productSupplyDurationList";
	public String getProductSupplyDurationList(){
		return PRODUCT_SUPPLY_DURATION_LIST;
	}
	public SupplierProductTokens withProductSupplyDurationList(){		
		addSimpleOptions(PRODUCT_SUPPLY_DURATION_LIST);
		return this;
	}	
		
}

