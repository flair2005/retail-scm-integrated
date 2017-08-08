
package com.skynet.retailscm.retailstoremember;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreMemberDAO{

	
	public RetailStoreMember load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreMember present(RetailStoreMember retailStoreMember,Map<String,Object> options) throws Exception;
	public RetailStoreMember clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMember save(RetailStoreMember retailStoreMember,Map<String,Object> options);
	public SmartList<RetailStoreMember> saveRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options);
	public SmartList<RetailStoreMember> removeRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options);
	
	public void delete(String retailStoreMemberId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreMemberByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


