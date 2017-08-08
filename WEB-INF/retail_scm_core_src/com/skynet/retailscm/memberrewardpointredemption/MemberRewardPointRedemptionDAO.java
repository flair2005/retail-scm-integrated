
package com.skynet.retailscm.memberrewardpointredemption;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface MemberRewardPointRedemptionDAO{

	
	public MemberRewardPointRedemption load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public MemberRewardPointRedemption present(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options) throws Exception;
	public MemberRewardPointRedemption clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public MemberRewardPointRedemption save(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options);
	public SmartList<MemberRewardPointRedemption> saveMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options);
	public SmartList<MemberRewardPointRedemption> removeMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options);
	
	public void delete(String memberRewardPointRedemptionId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public int countMemberRewardPointRedemptionByOwner(String retailStoreMemberId, Map<String,Object> options);
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId, int start, int count, Map<String,Object> options);
 
 }


