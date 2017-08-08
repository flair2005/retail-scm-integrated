package com.skynet.retailscm;

import java.util.List;
import java.util.Map;

import com.terapico.uccaf.BaseUserContext;

public interface UserContext extends BaseUserContext{
	
	public void log(String message);
	public void putToCache(String key, Object value, int timeToLiveInSeconds);	
	public void cacheUser(Object value);
	public Object userOf(Class<?> clazz);
	public Object getCachedObject(String key,Class<?> clazz);
	public void removeFromCache(String key);
	public void sendEmail(String to, String subject, String content);
	public String tokenId();
	public Object getBean(String beanName);
	public UserContext castTo(Class<UserContext> targetClass) throws Exception;
	public List<String[]> relationBetween(String sourceType,String sourceId,  String targetType, String targetId);
	public void addAccessTokens(Map<String, Object> tokens);
	public Map<String, Object> getAccessTokens();
	public String getRemoteIP();
	public String getUserAgent();
	public String getPublicMediaServicePrefix();
	public void setPublicMediaServicePrefix(String publicMediaServicePrefix);
	public RetailScmCheckerManager getCustomCheckManager();
	public void setCustomCheckManager(RetailScmCheckerManager customCheckManager);
}




