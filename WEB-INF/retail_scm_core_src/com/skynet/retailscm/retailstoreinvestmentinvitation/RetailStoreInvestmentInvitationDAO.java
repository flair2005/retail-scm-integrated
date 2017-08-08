
package com.skynet.retailscm.retailstoreinvestmentinvitation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreInvestmentInvitationDAO{

	
	public RetailStoreInvestmentInvitation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreInvestmentInvitation present(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options) throws Exception;
	public RetailStoreInvestmentInvitation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreInvestmentInvitation save(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation,Map<String,Object> options);
	public SmartList<RetailStoreInvestmentInvitation> saveRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options);
	public SmartList<RetailStoreInvestmentInvitation> removeRetailStoreInvestmentInvitationList(SmartList<RetailStoreInvestmentInvitation> retailStoreInvestmentInvitationList,Map<String,Object> options);
	
	public void delete(String retailStoreInvestmentInvitationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


