
package com.skynet.retailscm.retailstorefranchising;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreFranchisingDAO{

	
	public RetailStoreFranchising load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreFranchising present(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options) throws Exception;
	public RetailStoreFranchising clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreFranchising save(RetailStoreFranchising retailStoreFranchising,Map<String,Object> options);
	public SmartList<RetailStoreFranchising> saveRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options);
	public SmartList<RetailStoreFranchising> removeRetailStoreFranchisingList(SmartList<RetailStoreFranchising> retailStoreFranchisingList,Map<String,Object> options);
	
	public void delete(String retailStoreFranchisingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


