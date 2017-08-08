
package com.skynet.retailscm.originalvoucher;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface OriginalVoucherDAO{

	
	public OriginalVoucher load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public OriginalVoucher present(OriginalVoucher originalVoucher,Map<String,Object> options) throws Exception;
	public OriginalVoucher clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OriginalVoucher save(OriginalVoucher originalVoucher,Map<String,Object> options);
	public SmartList<OriginalVoucher> saveOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options);
	public SmartList<OriginalVoucher> removeOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options);
	
	public void delete(String originalVoucherId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public int countOriginalVoucherByBelongsTo(String accountingDocumentId, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, Map<String,Object> options);
 	public int countOriginalVoucherByCreation(String originalVoucherCreationId, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, Map<String,Object> options);
 	public int countOriginalVoucherByConfirmation(String originalVoucherConfirmationId, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, Map<String,Object> options);
 	public int countOriginalVoucherByAuditing(String originalVoucherAuditingId, Map<String,Object> options);
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, int start, int count, Map<String,Object> options);
 
 }


