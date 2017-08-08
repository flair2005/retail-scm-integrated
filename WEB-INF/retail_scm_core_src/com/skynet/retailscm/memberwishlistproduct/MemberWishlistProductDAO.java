
package com.skynet.retailscm.memberwishlistproduct;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface MemberWishlistProductDAO{

	
	public MemberWishlistProduct load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public MemberWishlistProduct present(MemberWishlistProduct memberWishlistProduct,Map<String,Object> options) throws Exception;
	public MemberWishlistProduct clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberWishlistProduct save(MemberWishlistProduct memberWishlistProduct,Map<String,Object> options);
	public SmartList<MemberWishlistProduct> saveMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList,Map<String,Object> options);
	public SmartList<MemberWishlistProduct> removeMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList,Map<String,Object> options);
	
	public void delete(String memberWishlistProductId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(String memberWishlistId, Map<String,Object> options);
 	public int countMemberWishlistProductByOwner(String memberWishlistId, Map<String,Object> options);
 	public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(String memberWishlistId, int start, int count, Map<String,Object> options);
 
 }


