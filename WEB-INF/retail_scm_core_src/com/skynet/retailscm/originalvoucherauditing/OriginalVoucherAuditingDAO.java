
package com.skynet.retailscm.originalvoucherauditing;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface OriginalVoucherAuditingDAO{

	
	public OriginalVoucherAuditing load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public OriginalVoucherAuditing present(OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object> options) throws Exception;
	public OriginalVoucherAuditing clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucherAuditing save(OriginalVoucherAuditing originalVoucherAuditing,Map<String,Object> options);
	public SmartList<OriginalVoucherAuditing> saveOriginalVoucherAuditingList(SmartList<OriginalVoucherAuditing> originalVoucherAuditingList,Map<String,Object> options);
	public SmartList<OriginalVoucherAuditing> removeOriginalVoucherAuditingList(SmartList<OriginalVoucherAuditing> originalVoucherAuditingList,Map<String,Object> options);
	
	public void delete(String originalVoucherAuditingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


