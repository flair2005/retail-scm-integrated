
package com.skynet.retailscm.transportfleet;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class TransportFleetTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportFleet";
	
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
	protected TransportFleetTokens(){
		//ensure not initialized outside the class
	}
	
	public TransportFleetTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransportFleetTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransportFleetTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransportFleetTokens start(){
		return new TransportFleetTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransportFleetTokens allTokens(){
		
		return start()
			.withOwner()
			.withTransportTruckList()
			.withTruckDriverList()
			.withTransportTaskList();
	
	}
	protected static TransportFleetTokens withoutListsTokens(){
		
		return start()
			.withOwner();
	
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

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public TransportFleetTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	protected static final String TRANSPORT_TRUCK_LIST = "transportTruckList";
	public String getTransportTruckList(){
		return TRANSPORT_TRUCK_LIST;
	}
	public TransportFleetTokens withTransportTruckList(){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST);
		return this;
	}	
		
	protected static final String TRUCK_DRIVER_LIST = "truckDriverList";
	public String getTruckDriverList(){
		return TRUCK_DRIVER_LIST;
	}
	public TransportFleetTokens withTruckDriverList(){		
		addSimpleOptions(TRUCK_DRIVER_LIST);
		return this;
	}	
		
	protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	public String getTransportTaskList(){
		return TRANSPORT_TASK_LIST;
	}
	public TransportFleetTokens withTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST);
		return this;
	}	
		
}

