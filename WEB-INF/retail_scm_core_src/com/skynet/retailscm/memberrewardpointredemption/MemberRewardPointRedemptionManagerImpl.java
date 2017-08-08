
package com.skynet.retailscm.memberrewardpointredemption;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;



import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;




public class MemberRewardPointRedemptionManagerImpl extends RetailScmCheckerManager implements MemberRewardPointRedemptionManager {
	
	private static final String SERVICE_TYPE = "MemberRewardPointRedemption";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  MemberRewardPointRedemptionDAO  memberRewardPointRedemptionDAO;
 	public void setMemberRewardPointRedemptionDAO(MemberRewardPointRedemptionDAO  memberRewardPointRedemptionDAO){
 	
 		if(memberRewardPointRedemptionDAO == null){
 			throw new IllegalStateException("Do not try to set memberRewardPointRedemptionDAO to null.");
 		}
	 	this.memberRewardPointRedemptionDAO = memberRewardPointRedemptionDAO;
 	}
 	public MemberRewardPointRedemptionDAO getMemberRewardPointRedemptionDAO(){
 		if(this.memberRewardPointRedemptionDAO == null){
 			throw new IllegalStateException("The MemberRewardPointRedemptionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberRewardPointRedemptionDAO;
 	}
 	
 	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(RetailScmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, String [] tokensExpr) throws Exception{	
 		//return getMemberRewardPointRedemptionDAO().save(memberRewardPointRedemption, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens);
 	}
 	
 	protected MemberRewardPointRedemption saveMemberRewardPointRedemptionDetail(RetailScmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption) throws Exception{	

 		
 		return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, allTokens());
 	}
 	
 	public MemberRewardPointRedemption loadMemberRewardPointRedemption(RetailScmUserContext userContext, String memberRewardPointRedemptionId, String [] tokensExpr) throws Exception{				
 
 		MemberRewardPointRedemptionManagerException exception = new MemberRewardPointRedemptionManagerException("Error Occured");
		
		checkIdOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberRewardPointRedemption, tokens);
 	}
 	
 	protected MemberRewardPointRedemption present(RetailScmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberRewardPointRedemption,tokens);
		
		
		return this.getMemberRewardPointRedemptionDAO().present(memberRewardPointRedemption, tokens);
	}
 
 	
 	
 	public MemberRewardPointRedemption loadMemberRewardPointRedemptionDetail(RetailScmUserContext userContext, String memberRewardPointRedemptionId) throws Exception{	
 		MemberRewardPointRedemptionManagerException exception = new MemberRewardPointRedemptionManagerException("Error Occured");
		
		checkIdOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, allTokens());

 		return present(userContext,memberRewardPointRedemption, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String memberRewardPointRedemptionId) throws Exception{	
 		MemberRewardPointRedemptionManagerException exception = new MemberRewardPointRedemptionManagerException("Error Occured");
		
		checkIdOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, allTokens());

 		return present(userContext,memberRewardPointRedemption, allTokens());
		
 	}
 	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(RetailScmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object>tokens) throws Exception{	
 		return getMemberRewardPointRedemptionDAO().save(memberRewardPointRedemption, tokens);
 	}
 	protected MemberRewardPointRedemption loadMemberRewardPointRedemption(RetailScmUserContext userContext, String memberRewardPointRedemptionId, Map<String,Object>tokens) throws Exception{	
 		return getMemberRewardPointRedemptionDAO().load(memberRewardPointRedemptionId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens){
		super.addActions(userContext, memberRewardPointRedemption, tokens);
		
		addAction(userContext, memberRewardPointRedemption, tokens,"@create","createMemberRewardPointRedemption","createMemberRewardPointRedemption/","main","primary");
		addAction(userContext, memberRewardPointRedemption, tokens,"@update","updateMemberRewardPointRedemption","updateMemberRewardPointRedemption/"+memberRewardPointRedemption.getId()+"/","main","primary");
		addAction(userContext, memberRewardPointRedemption, tokens,"@copy","cloneMemberRewardPointRedemption","cloneMemberRewardPointRedemption/"+memberRewardPointRedemption.getId()+"/","main","primary");
		
		addAction(userContext, memberRewardPointRedemption, tokens,"member_reward_point_redemption.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberRewardPointRedemption.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MemberRewardPointRedemption createMemberRewardPointRedemption(RetailScmUserContext userContext,String name, int point, String ownerId
) throws Exception
	{
		
		MemberRewardPointRedemptionManagerException exception = new MemberRewardPointRedemptionManagerException("Error Occured");

		

		checkNameOfMemberRewardPointRedemption(userContext,  name, exception);
		checkPointOfMemberRewardPointRedemption(userContext,  point, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		MemberRewardPointRedemption memberRewardPointRedemption=createNewMemberRewardPointRedemption();	

		memberRewardPointRedemption.setName(name);
		memberRewardPointRedemption.setPoint(point);
		RetailStoreMember owner = loadRetailStoreMember(ownerId,emptyOptions());
		memberRewardPointRedemption.setOwner(owner);

		return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, emptyOptions());
		

		
	}
	protected MemberRewardPointRedemption createNewMemberRewardPointRedemption() 
	{
		
		return new MemberRewardPointRedemption();		
	}
	
	protected void checkParamsForUpdatingMemberRewardPointRedemption(RetailScmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		MemberRewardPointRedemptionManagerException exception = new MemberRewardPointRedemptionManagerException("Error Occured");
		
		checkIdOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, exception);
		checkVersionOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionVersion, exception);
		

		if(MemberRewardPointRedemption.NAME_PROPERTY.equals(property)){
			checkNameOfMemberRewardPointRedemption(userContext, parseString(newValueExpr), exception);
		}
		if(MemberRewardPointRedemption.POINT_PROPERTY.equals(property)){
			checkPointOfMemberRewardPointRedemption(userContext, parseInt(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public MemberRewardPointRedemption clone(RetailScmUserContext userContext, String fromMemberRewardPointRedemptionId) throws Exception{
		
		return this.getMemberRewardPointRedemptionDAO().clone(fromMemberRewardPointRedemptionId, this.allTokens());
	}
	
	public MemberRewardPointRedemption updateMemberRewardPointRedemption(RetailScmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr, tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());
		if(memberRewardPointRedemption.getVersion() != memberRewardPointRedemptionVersion){
			String message = "The target version("+memberRewardPointRedemption.getVersion()+") is not equals to version("+memberRewardPointRedemptionVersion+") provided";
			throw new MemberRewardPointRedemptionManagerException(message);
		}
		synchronized(memberRewardPointRedemption){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPointRedemption.
			
			memberRewardPointRedemption.changePropery(property, newValueExpr);
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
			return present(userContext,memberRewardPointRedemption, mergedAllTokens(tokensExpr));
			//return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MemberRewardPointRedemptionTokens tokens(){
		return MemberRewardPointRedemptionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberRewardPointRedemptionTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberRewardPointRedemptionTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId) throws Exception
 	{
 		MemberRewardPointRedemptionManagerException exception = new MemberRewardPointRedemptionManagerException("Error Occured");
 		checkIdOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId,exception);
 		checkIdOfRetailStoreMember(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public MemberRewardPointRedemption transferToAnotherOwner(RetailScmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberRewardPointRedemptionId,anotherOwnerId);
 
		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());	
		synchronized(memberRewardPointRedemption){
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(anotherOwnerId, emptyOptions());		
			memberRewardPointRedemption.setOwner(owner);		
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, emptyOptions());
			
			return present(userContext,memberRewardPointRedemption, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception {
		
		deleteInternal(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception{
		getMemberRewardPointRedemptionDAO().delete(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberRewardPointRedemptionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getMemberRewardPointRedemptionDAO().deleteAll();
	}


}


