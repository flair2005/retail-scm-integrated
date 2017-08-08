
package com.skynet.retailscm.secuser;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import com.skynet.infrastructure.CacheService;
import com.skynet.infrastructure.GraphService;
import com.skynet.infrastructure.SMTPService;

import com.skynet.retailscm.RetailScmUserContextImpl;
import com.skynet.retailscm.LoginForm;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.CommonError;

import com.skynet.retailscm.UserContextImpl;
import com.skynet.retailscm.userapp.UserApp;
import com.skynet.retailscm.RetailScmUserContext;
import com.skynet.retailscm.userapp.*;
import com.skynet.retailscm.objectaccess.*;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.terapico.uccaf.BaseUserContext;
import com.terapico.uccaf.UserContextProvider;
import com.terapico.caf.BeanFactory;
import java.util.Date;

import java.lang.reflect.InvocationTargetException;

public class CustomSecUserManagerImpl extends SecUserManagerImpl implements
		UserContextProvider {
	
	
	public CustomSecUserManagerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public SecUser clone(RetailScmUserContext userContext, String fromSecUserId) throws Exception{
		
		return this.getSecUserDAO().clone(fromSecUserId, this.allTokens());
	}
	
	public Object resetPassword(RetailScmUserContext userContext, String userId, String newPass) throws Exception{
		SecUser user = this.getSecUserDAO().load(userId, this.emptyOptions());
		
		user.setPwd(this.hashStringWithSHA256(newPass, userId));
		
		this.getSecUserDAO().save(user, this.allTokens());
		
		return this.login(userContext, userId, newPass);
		//return this.getSecUserDAO().clone(fromSecUserId, this.allTokens());
	}
	
	public Object selectApp(RetailScmUserContext userContext,
			String appId) throws Exception {
		SecUser user = cachedUser(userContext);
		if(user==null){
			return errorLogin("对不起，你的会话过期，请重新登录");
		}
		List<UserApp> userApps = user.getUserAppList();
		for (UserApp app : userApps) {
			if (app.getId().equals(appId)) {
				
				
				return gotoApp(userContext,app);
			}
		}
		return user;
	}
	public SecUser manage(RetailScmUserContext userContext) throws Exception{
		SecUser user = cachedUser(userContext);
		SecUser user2 = this.loadSecUser(userContext, user.getId(), this.allTokens());
		return this.present(userContext, user2, this.allTokens());
		
	}
	protected SecUser cachedUser(RetailScmUserContext userContext)
	{
		return (SecUser)userContext.getCachedObject(this.getUserKey(userContext), SecUser.class);
	}
	
	protected BaseEntity error(String message){
		BaseEntity entity = new CommonError();
		entity.addErrorMessage(message, null);
		return entity;
	}
	
	private UserAppDAO userAppDAO;
	
	public UserAppDAO getUserAppDAO() {
		return userAppDAO;
	}

	public void setUserAppDAO(UserAppDAO userAppDAO) {
		this.userAppDAO = userAppDAO;
	}

	protected Object gotoApp(RetailScmUserContext userContext, UserApp app) throws Exception {
		
		UserApp fullAppData = userAppDAO.load(app.getId(), UserAppTokens.all());
		userContext.putToCache(getCurrentAppKey(userContext), fullAppData, 1000000);
		// the app has all the accessable objects
		String targetBeanName = getBeanName( userContext,  app);
		if(targetBeanName == null){
			return error("targetBeanName is null");
		}
		Object targetObject = userContext.getBean(targetBeanName );
		if(targetObject == null){
			return error("targetObject is null");
		}

		String targetId = getTargetObjectId( userContext,  app);
		if(targetId == null){
			return error("targetId is null");
		}
		String serviceType = getServiceType( userContext,  app);
		if(serviceType == null){
			return error("serviceType is null");
		}
		String methodName = getMethodName( userContext,  app);
		if(methodName == null){
			return error("methodName is null");
		}
		
		ObjectAccess oa = findAppliedObjectAccess(fullAppData,serviceType);
		Map<String,Object > tokens =  packTokens(oa);
		

		userContext.addAccessTokens(tokens);
		//String 
		try {
			
			String className =ucClassNameOf(serviceType);
			return invokeWithOneString(userContext,targetBeanName,methodName,className,targetId);
		} catch (NoSuchMethodException e) {
			
			return error("NoSuchMethodException: "+ e.getMessage());
		} catch (SecurityException e) {
			
			return error("SecurityException: "+ e.getMessage());
		} catch (IllegalAccessException e) {
			
			return error("IllegalAccessException: "+ e.getMessage());
		} catch (IllegalArgumentException e) {
			
			return error("IllegalArgumentException: "+ e.getMessage());
		} catch (InvocationTargetException e) {
			
			return error("InvocationTargetException: "+ e.getTargetException().getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			return error("Exception1: "+ e.getMessage());
		}

	}
	
	@Override
	public void checkAccess(BaseUserContext baseUserContext, String methodName,
			Object[] parameters) throws IllegalAccessException {
		
		if(methodName.startsWith("login")){
			return;
		}
		if(methodName.startsWith("show")){
			return;
		}
		if(methodName.startsWith("selectApp")){
			return;
		}
		if(methodName.startsWith("home")){
			return;
		}
		
		
		super.checkAccess(baseUserContext, methodName, parameters);
	}
	public String showMessage(BaseUserContext baseUserContext){
		return "hello";
	}
	public String showMessage2(BaseUserContext baseUserContext){
		return "hello";
	}
	protected String ucClassNameOf(String type){
		//com.skynet.scm;
		String packageName = "com.skynet.scm";
		return packageName +"."+type.toLowerCase()+"."+type+"UserContext";
		
	}
	
	protected String getBeanName(RetailScmUserContext userContext, UserApp app){

		String target = app.getObjectType();
		String lowerCase = target.substring(0,1).toLowerCase()+target.substring(1);
		return lowerCase+"Manager";
		
	}
	protected String getTargetObjectId(RetailScmUserContext userContext, UserApp app){
		
		return  app.getObjectId();
		
	}
	protected String getServiceType(RetailScmUserContext userContext, UserApp app){
		
		return app.getObjectType();
	}
	protected String getMethodName(RetailScmUserContext userContext, UserApp app){
		//return "load"+app.getObjectType()+"Detail";
		return "view";
	}

	
	
	public Object home(RetailScmUserContext userContext) {
		SecUser user = (SecUser) userContext.getCachedObject(
				getUserKey(userContext), SecUser.class);
		if (user == null) {
			return showSessionExpired(userContext);
		}
		CustomSecUser customUser = new CustomSecUser();
		user.copyTo(customUser);
		return customUser;
	}

	public Object loginWithEmail(BbtUserContext userContext, String email,
			String password) {

		return loginInternal(userContext,"email",email, password);
	
	}
	public Object login(BbtUserContext userContext, String email,
			String password) {

		return loginInternal(userContext,"userId",email, password);
	
	}
	public Object loginWithLogin(BbtUserContext userContext, String email,
			String password) {

		return loginInternal(userContext,"login",email, password);
	
	}
	public Object loginWithMobile(BbtUserContext userContext, String email,
			String password) {
		return loginInternal(userContext,"mobile",email, password);
	
	}
	protected SecUser loadUserWith(BbtUserContext userContext, String type, String userId) throws Exception{
		if("email".equals(type)){
			return this.loadSecUserWithEmail(userContext, userId, this.allTokens());
		}
		if("mobile".equals(type)){
			return this.loadSecUserWithMobile(userContext, userId, this.allTokens());
		}
		if("login".equals(type)){
			return this.loadSecUserWithLogin(userContext, userId, this.allTokens());
		}
		return this.loadSecUser(userContext, userId , this.allTokens());
	}
	// return a form or a user
	protected Object loginInternal(BbtUserContext userContext, String type, String userId,
			String password) {

		try {
			// SecUser user = (SecUser)
			// userContext.getFromCache(userContext.tokenId(), SecUser.class);
			SecUser user = this.loadUserWith(userContext, type, userId);
			
			
			String hashedPassed = this.hashStringWithSHA256(password, user.getId());
			log("hashed pass: "+ hashedPassed);
			log("stored pass: "+user.getPwd());
			Map<String,Object> tokens = new HashMap<String,Object>();
			//Map<String,Object > tokens =  packTokens(oa);
			tokens.put("userAppList", "userAppList");
			tokens.put("secUserList", "secUserList");
			tokens.put("objectAccessList", "objectAccessList");
			userContext.addAccessTokens(tokens);
			
			if (!user.getPwd().equals(hashedPassed)) {
				this.addLoginHistory(userContext, user.getId(), new Date(), userContext.getRemoteIP(), "密码错误", "x".split("."));
				return errorLogin("密码错了!");
			}
			
			// save it to Redis, then use it later

			userContext.putToCache(getUserKey(userContext), user,100000);
			
			CustomSecUser customUser = new CustomSecUser();
			user.copyTo(customUser);
			//userContext.sendEmail("philip_chang@163.com", "有人登陆"+userContext.getRemoteIP() , "有人登陆"+userContext.getRemoteIP());
			this.addLoginHistory(userContext, user.getId(), new Date(), userContext.getRemoteIP(), "成功登陆", "x".split("."));
			
			return customUser;
		} catch (SecUserNotFoundException e) {
			return errorLogin("对不起，不认识你");
		} catch (Exception e) {
			return errorLogin("对不起, 系统出错，跟你没关系哈，你等会再试下" + e.getMessage());
		}

	}

	public Object showlogin(RetailScmUserContext userContext) {
		
		userContext.removeFromCache(getUserKey(userContext));
		
		LoginForm form = new LoginForm();

		return form;

	}

	protected LoginForm showSessionExpired(RetailScmUserContext userContext) {

		LoginForm form = new LoginForm();
		form.addErrorMessage("登录过期了", null);
		// form.addErrorMessage(errorMessage, null);
		return form;

	}

	private void log(String message) {
		System.out.println("Message: " + message);
	}

	protected LoginForm errorLogin(String errorMessage) {
		LoginForm form = new LoginForm();
		form.addErrorMessage(errorMessage, null);
		return form;
	}

	public BaseUserContext loadUserConext(HttpServletRequest request)
			throws Exception {
		String path = getRequestPath(request);
		RetailScmUserContextImpl uc = createNewConext(path);
		init(uc, request);
		return uc;
	}

	private CacheService cacheService;

	public CacheService getCacheService() {
		return cacheService;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	private SMTPService smtpService;

	public SMTPService getSmtpService() {
		return smtpService;
	}

	public void setSmtpService(SMTPService smtpService) {
		this.smtpService = smtpService;
	}
	
	private GraphService graphService;

	
	
	
	public GraphService getGraphService() {
		return graphService;
	}

	public void setGraphService(GraphService graphService) {
		this.graphService = graphService;
	}

	protected String publicMediaServicePrefix;
	public String getPublicMediaServicePrefix() {
		return publicMediaServicePrefix;
	}
	public void setPublicMediaServicePrefix(String publicMediaServicePrefix) {
		this.publicMediaServicePrefix = publicMediaServicePrefix;
	}
	
	protected RetailScmCheckerManager customCheckManager;
	public RetailScmCheckerManager getCustomCheckManager(){
		return customCheckManager;
	}
	public void setCustomCheckManager(RetailScmCheckerManager customCheckManager){
		this.customCheckManager = customCheckManager;
	}
	
	protected void init(UserContextImpl userContext, HttpServletRequest request) {
		
		BeanFactory beanFactory = (BeanFactory)request.getAttribute("beanFactory");
		userContext.setBeanFactory(beanFactory);
		userContext.setRemoteIP(getRemoteIP(request));
		userContext.setCacheService(cacheService);
		userContext.setSmtpService(smtpService);
		userContext.setGraphService(graphService);
		userContext.setTokenId(request.getSession().getId());
		userContext.setUserAgent(request.getHeader("User-Agent"));
		userContext.setPublicMediaServicePrefix(getPublicMediaServicePrefix());
		userContext.setCustomCheckManager(getCustomCheckManager());
	}
	
	protected String getRemoteIP(HttpServletRequest request){
		String remoteHost = request.getHeader("X-Forwarded-For");
		if(remoteHost != null){
			return remoteHost;	
		}
		return request.getRemoteAddr();
		
	}


	protected String getRequestPath(HttpServletRequest request) {

		String path = request.getRequestURI().substring(
				request.getContextPath().length());

		return path;

	}

	protected RetailScmUserContextImpl createNewConext(String path) {

		return new RetailScmUserContextImpl();

	}

	

}









