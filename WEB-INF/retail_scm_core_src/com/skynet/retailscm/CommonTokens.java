package com.skynet.retailscm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CommonTokens {
	Map <String,Object> options;
	public Map <String,Object> done()
	{
		ensureOptions();
		return options;
	}
	public Map <String,Object> initWithArray(String [] tokensExpr)
	{
		return this.parseTokens(tokensExpr);
	}
	protected void addSimpleOptions(String key){
		ensureOptions();
		options.put(key, key);
	}
	protected void addSimpleOptions(String key,String value){
		ensureOptions();
		options.put(key, value);
	}
	static final String OWNER="$owner";
	protected static String getOwnerObjectKey(){
		
		return OWNER;
		
	}
	protected void addMapOptions(String key, Object value){
		ensureOptions();
		options.put(key, value);
		
	}
	
	protected int getIntValue(String key, int maxValue, int defaultValue){
		ensureOptions();
		try{
			String valueExpr =(String) options.get(key);
			int value = Integer.parseInt(valueExpr);
			
			if(value > maxValue){
				return maxValue;
			}
			return value;
			
		}catch(Exception e){
			return defaultValue;
		}
		
		
	}
	protected void ensureOptions()
	{
		if(options == null){
			options = new HashMap<String,Object>();
		}
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		ensureOptions();
		//Map<String,Object> options = options;
		if(tokensExpr ==  null){
			return options;
		}
		if(tokensExpr.length ==  0){
			return options;
		}
		
		for(String element: tokensExpr){
			if(element.indexOf('=')<=0){
				//options.put(element, element);
				addMapOptions(element, element);
				continue;
			}
			String pair[] = element.split("=");
			//options.put(pair[0], );
			addMapOptions(pair[0], pair[1]);
		}

		return options;
	}
	
	public String toString(){
		
		ensureOptions();
		Set<Entry<String, Object>> entrySet = options.entrySet();
		
		Iterator<Entry<String, Object>> it = entrySet.iterator();
		
		StringBuilder sb=new StringBuilder();
		while(it.hasNext()){
			Entry<String, Object> entry = it.next();
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
		}
		return sb.toString();
	}
	//the way to implement this is with withLineItemList().withShippingGroupList().
}


















