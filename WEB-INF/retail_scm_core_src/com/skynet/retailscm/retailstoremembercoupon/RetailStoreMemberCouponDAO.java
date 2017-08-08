
package com.skynet.retailscm.retailstoremembercoupon;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface RetailStoreMemberCouponDAO{

	
	public RetailStoreMemberCoupon load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public RetailStoreMemberCoupon present(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options) throws Exception;
	public RetailStoreMemberCoupon clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public RetailStoreMemberCoupon save(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options);
	public SmartList<RetailStoreMemberCoupon> saveRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options);
	public SmartList<RetailStoreMemberCoupon> removeRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options);
	
	public void delete(String retailStoreMemberCouponId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countRetailStoreMemberCouponByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 
 }


