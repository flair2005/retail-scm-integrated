
package com.skynet.retailscm.potentialcustomer;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface PotentialCustomerDAO{

	
	public PotentialCustomer load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public PotentialCustomer present(PotentialCustomer potentialCustomer,Map<String,Object> options) throws Exception;
	public PotentialCustomer clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PotentialCustomer save(PotentialCustomer potentialCustomer,Map<String,Object> options);
	public SmartList<PotentialCustomer> savePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options);
	public SmartList<PotentialCustomer> removePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options);
	
	public void delete(String potentialCustomerId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public int countPotentialCustomerByCityPartner(String cityPartnerId, Map<String,Object> options);
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId, int start, int count, Map<String,Object> options);
 
 }


