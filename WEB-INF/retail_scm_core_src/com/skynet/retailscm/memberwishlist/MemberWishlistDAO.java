
package com.skynet.retailscm.memberwishlist;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface MemberWishlistDAO{

	
	public MemberWishlist load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public MemberWishlist present(MemberWishlist memberWishlist,Map<String,Object> options) throws Exception;
	public MemberWishlist clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberWishlist save(MemberWishlist memberWishlist,Map<String,Object> options);
	public SmartList<MemberWishlist> saveMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options);
	public SmartList<MemberWishlist> removeMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options);
	
	public void delete(String memberWishlistId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberWishlistByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 
 }


