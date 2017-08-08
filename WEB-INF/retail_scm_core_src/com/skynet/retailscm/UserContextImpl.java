package com.skynet.retailscm;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skynet.infrastructure.CacheService;
import com.skynet.infrastructure.GraphService;
import com.skynet.infrastructure.SMTPService;
import com.terapico.caf.BeanFactory;

//Default implementation
public class UserContextImpl implements UserContext{
	private CacheService cacheService;
	private SMTPService smtpService;
	private String remoteIP;
	private String tokenId;
	private String userAgent;
	private BeanFactory beanFactory;
	protected String publicMediaServicePrefix;
	protected RetailScmCheckerManager customCheckManager;
	
	public String getPublicMediaServicePrefix() {
		return publicMediaServicePrefix;
	}

	public void setPublicMediaServicePrefix(String publicMediaServicePrefix) {
		this.publicMediaServicePrefix = publicMediaServicePrefix;
	}
	public RetailScmCheckerManager getCustomCheckManager(){
		return customCheckManager;
	}
	public void setCustomCheckManager(RetailScmCheckerManager customCheckManager){
		this.customCheckManager = customCheckManager;
	}
	
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public String getRemoteIP() {
		return remoteIP;
	}

	public void setSmtpService(SMTPService smtpService) {
		this.smtpService = smtpService;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setCacheService(CacheService cacheService) {
		
		this.cacheService = cacheService;
	}
	
	public void putToCache(String key, Object value,int timeToLiveInSeconds){
		ensureCacheService();
		cacheService.put(key, value,timeToLiveInSeconds);
	}
	
	public void sendEmail(String to, String subject, String content){
		this.ensureSMTPService();
		smtpService.send(to, subject, content);
		
	}
	
	public Object getCachedObject(String key,Class<?> clazz){
		ensureCacheService();
		return cacheService.get(key,clazz);
	}
	protected void ensureCacheService(){
		if(cacheService ==  null){
			throw new IllegalStateException("cacheService is not configured for a instance of UserContextImpl");
		}
	}
	protected void ensureSMTPService(){
		if(smtpService ==  null){
			throw new IllegalStateException("smtpService is not configured for a instance of UserContextImpl");
		}
	}
	
	public void setRemoteIP(String remoteAddr) {
		
		this.remoteIP = remoteAddr;
	}
	
	public void setTokenId(String id) {
		
		this.tokenId = id;
	}
	public String tokenId() {
		
		return this.tokenId;
	}
	public void setUserAgent(String userAgent) {
		
		this.userAgent = userAgent;
	}

	public void log(String message) {
		Format formatter = new SimpleDateFormat("yy/MM/dd");
		String timeExpr = formatter.format(getCurrentTime());
		
		System.out.println(timeExpr+": "+this.tokenId+"@"+this.remoteIP+": "+ message);
	}
	protected Date getCurrentTime(){
		return new Date();//provide a way to shift the time for some use cases;
	}

	public void cacheUser(Object value) {
		
		this.putToCache(this.tokenId, value,1000);
	}

	public Object userOf(Class<?> clazz) {
		
		return this.getCachedObject(this.tokenId,clazz);
	}

	public void removeFromCache(String key) {
		
		ensureCacheService();
		cacheService.remove(key);
	}

	public Object getBean(String beanName) {
		if(getBeanFactory() == null){
			this.log("getBeanFactory() is not initialized");
			return null;
		}
		
		return getBeanFactory().getBean(beanName);
	}

	public UserContext castTo(Class<UserContext> targetClass) throws InstantiationException, IllegalAccessException {
		UserContextImpl newUserContext =(UserContextImpl) targetClass.newInstance();
		
		newUserContext.setBeanFactory(this.getBeanFactory());
		
		newUserContext.setCacheService(this.cacheService);
		newUserContext.setRemoteIP(this.getRemoteIP());
		newUserContext.setSmtpService(this.smtpService);
		newUserContext.setTokenId(this.tokenId());
		newUserContext.setUserAgent(this.userAgent);
		return newUserContext;
	}
	public void setGraphService(GraphService graphService) {
		this.graphService = graphService;
	}
	private GraphService graphService;
	public List<String[]> relationBetween(String sourceType,String sourceId, 
			String targetType, String targetId) {
		
		if(graphService == null){
			throw new IllegalStateException("graphService must be configured");
		}
		return graphService.relationsOf(sourceType, sourceId, targetType, targetId);
	}
	private Map<String,Object> accessTokens;
	public void addAccessTokens(Map<String, Object> tokens) {
		// TODO Auto-generated method stub
		ensureAccessTokens();
		accessTokens.putAll(tokens);
	}
	protected void ensureAccessTokens(){
		if(accessTokens == null){
			accessTokens = new HashMap<String,Object>();
		}
	}
	public Map<String,Object> getAccessTokens(){
		ensureAccessTokens();
		return accessTokens;
	}

}
