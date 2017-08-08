
package com.skynet.retailscm.accountset;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface AccountSetDAO{

	
	public AccountSet load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public AccountSet present(AccountSet accountSet,Map<String,Object> options) throws Exception;
	public AccountSet clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AccountSet save(AccountSet accountSet,Map<String,Object> options);
	public SmartList<AccountSet> saveAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options);
	public SmartList<AccountSet> removeAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options);
	
	public void delete(String accountSetId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<AccountSet> findAccountSetByCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countAccountSetByCountryCenter(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<AccountSet> findAccountSetByCountryCenter(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountSet> findAccountSetByRetailStore(String retailStoreId, Map<String,Object> options);
 	public int countAccountSetByRetailStore(String retailStoreId, Map<String,Object> options);
 	public SmartList<AccountSet> findAccountSetByRetailStore(String retailStoreId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<AccountSet> findAccountSetByGoodsSupplier(String goodsSupplierId, Map<String,Object> options);
 	public int countAccountSetByGoodsSupplier(String goodsSupplierId, Map<String,Object> options);
 	public SmartList<AccountSet> findAccountSetByGoodsSupplier(String goodsSupplierId, int start, int count, Map<String,Object> options);
 
 }


