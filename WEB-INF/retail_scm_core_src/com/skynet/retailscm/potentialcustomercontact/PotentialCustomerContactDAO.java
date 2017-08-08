
package com.skynet.retailscm.potentialcustomercontact;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface PotentialCustomerContactDAO{

	
	public PotentialCustomerContact load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public PotentialCustomerContact present(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options) throws Exception;
	public PotentialCustomerContact clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PotentialCustomerContact save(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options);
	public SmartList<PotentialCustomerContact> savePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options);
	public SmartList<PotentialCustomerContact> removePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options);
	
	public void delete(String potentialCustomerContactId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public int countPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public int countPotentialCustomerContactByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, Map<String,Object> options);
 	public int countPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, Map<String,Object> options);
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, int start, int count, Map<String,Object> options);
 
 }


