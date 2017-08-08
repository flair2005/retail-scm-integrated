
package com.skynet.retailscm.userapp;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface UserAppDAO{

	
	public UserApp load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public UserApp present(UserApp userApp,Map<String,Object> options) throws Exception;
	public UserApp clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserApp save(UserApp userApp,Map<String,Object> options);
	public SmartList<UserApp> saveUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	public SmartList<UserApp> removeUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	
	public void delete(String userAppId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public int countUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 
 }


