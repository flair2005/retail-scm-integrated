
package com.skynet.retailscm.memberrewardpoint;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface MemberRewardPointDAO{

	
	public MemberRewardPoint load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public MemberRewardPoint present(MemberRewardPoint memberRewardPoint,Map<String,Object> options) throws Exception;
	public MemberRewardPoint clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberRewardPoint save(MemberRewardPoint memberRewardPoint,Map<String,Object> options);
	public SmartList<MemberRewardPoint> saveMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options);
	public SmartList<MemberRewardPoint> removeMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options);
	
	public void delete(String memberRewardPointId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberRewardPointByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 
 }


