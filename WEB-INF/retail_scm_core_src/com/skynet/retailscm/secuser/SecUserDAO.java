
package com.skynet.retailscm.secuser;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SecUserDAO{

	
	public SecUser load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SecUser present(SecUser secUser,Map<String,Object> options) throws Exception;
	public SecUser clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SecUser save(SecUser secUser,Map<String,Object> options);
	public SmartList<SecUser> saveSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	public SmartList<SecUser> removeSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	
	public void delete(String secUserId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public int countSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, int start, int count, Map<String,Object> options);
 
 }


