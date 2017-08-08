package com.skynet.retailscm;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.MissingResourceException;
public class RetailScmUserContextImpl extends UserContextImpl implements RetailScmUserContext{
    //implements the domain specific user model

	//默认支持中文和英文
	static Map<String,String> chineseMap;
	
	static Map<String,String> englishMap;
	
	
	
	static final String RESOURCE_PATH="com.skynet.retailscm.RetailScmResources";
	static final String CUSTOM_RESOURCE_PATH="com.skynet.retailscm.RetailScmCustomResources";
	
	public Map<String,String> ensureLocaleMaps(Locale locale ){
		
		String [] resources = {RESOURCE_PATH, CUSTOM_RESOURCE_PATH};
		return ensureResourceAddResourceMaps(resources, locale);
		
	}
	
	protected Map<String,String> ensureResourceAddResourceMaps(String[] paths, Locale locale){
		Map<String,String> localeMap= new HashMap<String,String>();
		for(String path: paths){
			try{
				ResourceBundle resourceBundle = ResourceBundle.getBundle(path,locale);
				addResourceToMap(localeMap, resourceBundle);
			}catch(MissingResourceException e){
				//the resource can be missed and it is fine
			}

		}
		return localeMap;
	}
	
	protected void addResourceToMap(Map<String,String> localeMap, ResourceBundle resourceBundle){
		Enumeration<String> bundleKeys = resourceBundle.getKeys();

		while (bundleKeys.hasMoreElements()) {
		    String key = (String)bundleKeys.nextElement();
		    String value = resourceBundle.getString(key);
		    //System.out.println("key = " + key + ", " + "value = " + value);
		    localeMap.put(key, value);
		}
		
		
	}
	public void init(){
		if(chineseMap==null){
			chineseMap = ensureLocaleMaps(Locale.SIMPLIFIED_CHINESE);
		}
		if(englishMap==null){
			englishMap = ensureLocaleMaps(Locale.US);
		}

		
	}
	public Map<String,String> getLocaleMap(){
		
		init();
		return chineseMap;
		
	}
	
	protected Locale getLocale(){
		return Locale.US;
	}
	public String getLocaleKey(String subject) {
		return getLocaleMap().get(subject);
	}
}












