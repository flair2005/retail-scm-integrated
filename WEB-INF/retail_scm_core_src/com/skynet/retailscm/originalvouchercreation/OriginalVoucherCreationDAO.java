
package com.skynet.retailscm.originalvouchercreation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface OriginalVoucherCreationDAO{

	
	public OriginalVoucherCreation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public OriginalVoucherCreation present(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options) throws Exception;
	public OriginalVoucherCreation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucherCreation save(OriginalVoucherCreation originalVoucherCreation,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> saveOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options);
	public SmartList<OriginalVoucherCreation> removeOriginalVoucherCreationList(SmartList<OriginalVoucherCreation> originalVoucherCreationList,Map<String,Object> options);
	
	public void delete(String originalVoucherCreationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


