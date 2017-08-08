
package com.skynet.retailscm.memberrewardpoint;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface MemberRewardPointManager{

	public MemberRewardPoint createMemberRewardPoint(RetailScmUserContext userContext, String name, int point, String ownerId
) throws Exception;	
	public MemberRewardPoint updateMemberRewardPoint(RetailScmUserContext userContext,String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public MemberRewardPoint transferToAnotherOwner(RetailScmUserContext userContext, String memberRewardPointId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String memberRewardPointId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


