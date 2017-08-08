
package com.skynet.retailscm.retailstore;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreDAO{

	
	public RetailStore load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStore present(RetailStore retailStore,Map<String,Object> options) throws Exception;
	public RetailStore clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStore save(RetailStore retailStore,Map<String,Object> options);
	public SmartList<RetailStore> saveRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options);
	public SmartList<RetailStore> removeRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options);
	
	public void delete(String retailStoreId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId, Map<String,Object> options);
 	public int countRetailStoreByCreation(String retailStoreCreationId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, Map<String,Object> options);
 	public int countRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId, Map<String,Object> options);
 	public int countRetailStoreByFranchising(String retailStoreFranchisingId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId, Map<String,Object> options);
 	public int countRetailStoreByDecoration(String retailStoreDecorationId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId, Map<String,Object> options);
 	public int countRetailStoreByOpening(String retailStoreOpeningId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId, Map<String,Object> options);
 	public int countRetailStoreByClosing(String retailStoreClosingId, Map<String,Object> options);
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId, int start, int count, Map<String,Object> options);
 
 }


