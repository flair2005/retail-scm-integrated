
package com.skynet.retailscm.transporttask;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class TransportTaskTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportTask";
	
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
	protected TransportTaskTokens(){
		//ensure not initialized outside the class
	}
	
	public TransportTaskTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransportTaskTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransportTaskTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static TransportTaskTokens start(){
		return new TransportTaskTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static TransportTaskTokens allTokens(){
		
		return start()
			.withEnd()
			.withDriver()
			.withTruck()
			.withBelongsTo()
			.withGoodsList()
			.withTransportTaskTrackList();
	
	}
	protected static TransportTaskTokens withoutListsTokens(){
		
		return start()
			.withEnd()
			.withDriver()
			.withTruck()
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

	protected static final String END = "end";
	public String getEnd(){
		return END;
	}
	public TransportTaskTokens withEnd(){		
		addSimpleOptions(END);
		return this;
	}
	
	
	protected static final String DRIVER = "driver";
	public String getDriver(){
		return DRIVER;
	}
	public TransportTaskTokens withDriver(){		
		addSimpleOptions(DRIVER);
		return this;
	}
	
	
	protected static final String TRUCK = "truck";
	public String getTruck(){
		return TRUCK;
	}
	public TransportTaskTokens withTruck(){		
		addSimpleOptions(TRUCK);
		return this;
	}
	
	
	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	public TransportTaskTokens withBelongsTo(){		
		addSimpleOptions(BELONGSTO);
		return this;
	}
	
	
	protected static final String GOODS_LIST = "goodsList";
	public String getGoodsList(){
		return GOODS_LIST;
	}
	public TransportTaskTokens withGoodsList(){		
		addSimpleOptions(GOODS_LIST);
		return this;
	}	
		
	protected static final String TRANSPORT_TASK_TRACK_LIST = "transportTaskTrackList";
	public String getTransportTaskTrackList(){
		return TRANSPORT_TASK_TRACK_LIST;
	}
	public TransportTaskTokens withTransportTaskTrackList(){		
		addSimpleOptions(TRANSPORT_TASK_TRACK_LIST);
		return this;
	}	
		
}

