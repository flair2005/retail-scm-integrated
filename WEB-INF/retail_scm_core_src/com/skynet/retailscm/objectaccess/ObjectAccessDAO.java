
package com.skynet.retailscm.objectaccess;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ObjectAccessDAO{

	
	public ObjectAccess load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ObjectAccess present(ObjectAccess objectAccess,Map<String,Object> options) throws Exception;
	public ObjectAccess clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ObjectAccess save(ObjectAccess objectAccess,Map<String,Object> options);
	public SmartList<ObjectAccess> saveObjectAccessList(SmartList<ObjectAccess> objectAccessList,Map<String,Object> options);
	public SmartList<ObjectAccess> removeObjectAccessList(SmartList<ObjectAccess> objectAccessList,Map<String,Object> options);
	
	public void delete(String objectAccessId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ObjectAccess> findObjectAccessByApp(String userAppId, Map<String,Object> options);
 	public int countObjectAccessByApp(String userAppId, Map<String,Object> options);
 	public SmartList<ObjectAccess> findObjectAccessByApp(String userAppId, int start, int count, Map<String,Object> options);
 
 }


