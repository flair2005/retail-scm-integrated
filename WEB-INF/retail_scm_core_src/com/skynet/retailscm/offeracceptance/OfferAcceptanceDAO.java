
package com.skynet.retailscm.offeracceptance;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface OfferAcceptanceDAO{

	
	public OfferAcceptance load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public OfferAcceptance present(OfferAcceptance offerAcceptance,Map<String,Object> options) throws Exception;
	public OfferAcceptance clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OfferAcceptance save(OfferAcceptance offerAcceptance,Map<String,Object> options);
	public SmartList<OfferAcceptance> saveOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options);
	public SmartList<OfferAcceptance> removeOfferAcceptanceList(SmartList<OfferAcceptance> offerAcceptanceList,Map<String,Object> options);
	
	public void delete(String offerAcceptanceId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


