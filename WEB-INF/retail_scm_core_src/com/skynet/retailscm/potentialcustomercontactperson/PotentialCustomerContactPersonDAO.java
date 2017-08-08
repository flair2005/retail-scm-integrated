
package com.skynet.retailscm.potentialcustomercontactperson;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface PotentialCustomerContactPersonDAO{

	
	public PotentialCustomerContactPerson load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public PotentialCustomerContactPerson present(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options) throws Exception;
	public PotentialCustomerContactPerson clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PotentialCustomerContactPerson save(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options);
	public SmartList<PotentialCustomerContactPerson> savePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options);
	public SmartList<PotentialCustomerContactPerson> removePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options);
	
	public void delete(String potentialCustomerContactPersonId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public int countPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, Map<String,Object> options);
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, int start, int count, Map<String,Object> options);
 
 }


