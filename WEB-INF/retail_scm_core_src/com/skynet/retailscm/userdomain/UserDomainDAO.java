
package com.skynet.retailscm.userdomain;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface UserDomainDAO{

	
	public UserDomain load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public UserDomain present(UserDomain userDomain,Map<String,Object> options) throws Exception;
	public UserDomain clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserDomain save(UserDomain userDomain,Map<String,Object> options);
	public SmartList<UserDomain> saveUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options);
	public SmartList<UserDomain> removeUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options);
	
	public void delete(String userDomainId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


