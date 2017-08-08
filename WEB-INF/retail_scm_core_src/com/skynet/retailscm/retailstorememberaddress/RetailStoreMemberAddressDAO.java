
package com.skynet.retailscm.retailstorememberaddress;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreMemberAddressDAO{

	
	public RetailStoreMemberAddress load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreMemberAddress present(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options) throws Exception;
	public RetailStoreMemberAddress clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberAddress save(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options);
	public SmartList<RetailStoreMemberAddress> saveRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options);
	public SmartList<RetailStoreMemberAddress> removeRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options);
	
	public void delete(String retailStoreMemberAddressId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countRetailStoreMemberAddressByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 
 }


