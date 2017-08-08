
package com.skynet.retailscm.payingoff;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface PayingOffDAO{

	
	public PayingOff load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public PayingOff present(PayingOff payingOff,Map<String,Object> options) throws Exception;
	public PayingOff clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PayingOff save(PayingOff payingOff,Map<String,Object> options);
	public SmartList<PayingOff> savePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options);
	public SmartList<PayingOff> removePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options);
	
	public void delete(String payingOffId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public int countPayingOffByPaidFor(String employeeId, Map<String,Object> options);
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, int start, int count, Map<String,Object> options);
 
 }








