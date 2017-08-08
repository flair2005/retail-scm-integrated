
package com.skynet.retailscm.offerapproval;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface OfferApprovalDAO{

	
	public OfferApproval load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public OfferApproval present(OfferApproval offerApproval,Map<String,Object> options) throws Exception;
	public OfferApproval clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OfferApproval save(OfferApproval offerApproval,Map<String,Object> options);
	public SmartList<OfferApproval> saveOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options);
	public SmartList<OfferApproval> removeOfferApprovalList(SmartList<OfferApproval> offerApprovalList,Map<String,Object> options);
	
	public void delete(String offerApprovalId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


