
package com.skynet.retailscm.memberrewardpointredemption;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface MemberRewardPointRedemptionManager{

	public MemberRewardPointRedemption createMemberRewardPointRedemption(RetailScmUserContext userContext, String name, int point, String ownerId
) throws Exception;	
	public MemberRewardPointRedemption updateMemberRewardPointRedemption(RetailScmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public MemberRewardPointRedemption transferToAnotherOwner(RetailScmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String memberRewardPointRedemptionId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


