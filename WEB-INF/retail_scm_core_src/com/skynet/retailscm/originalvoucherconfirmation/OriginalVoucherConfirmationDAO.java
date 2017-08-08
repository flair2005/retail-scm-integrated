
package com.skynet.retailscm.originalvoucherconfirmation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface OriginalVoucherConfirmationDAO{

	
	public OriginalVoucherConfirmation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public OriginalVoucherConfirmation present(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options) throws Exception;
	public OriginalVoucherConfirmation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucherConfirmation save(OriginalVoucherConfirmation originalVoucherConfirmation,Map<String,Object> options);
	public SmartList<OriginalVoucherConfirmation> saveOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options);
	public SmartList<OriginalVoucherConfirmation> removeOriginalVoucherConfirmationList(SmartList<OriginalVoucherConfirmation> originalVoucherConfirmationList,Map<String,Object> options);
	
	public void delete(String originalVoucherConfirmationId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


