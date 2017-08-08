
package com.skynet.retailscm.memberrewardpoint;

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




public class MemberRewardPointManagerImpl extends RetailScmCheckerManager implements MemberRewardPointManager {
	
	private static final String SERVICE_TYPE = "MemberRewardPoint";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  MemberRewardPointDAO  memberRewardPointDAO;
 	public void setMemberRewardPointDAO(MemberRewardPointDAO  memberRewardPointDAO){
 	
 		if(memberRewardPointDAO == null){
 			throw new IllegalStateException("Do not try to set memberRewardPointDAO to null.");
 		}
	 	this.memberRewardPointDAO = memberRewardPointDAO;
 	}
 	public MemberRewardPointDAO getMemberRewardPointDAO(){
 		if(this.memberRewardPointDAO == null){
 			throw new IllegalStateException("The MemberRewardPointDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberRewardPointDAO;
 	}
 	
 	protected MemberRewardPoint saveMemberRewardPoint(RetailScmUserContext userContext, MemberRewardPoint memberRewardPoint, String [] tokensExpr) throws Exception{	
 		//return getMemberRewardPointDAO().save(memberRewardPoint, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberRewardPoint(userContext, memberRewardPoint, tokens);
 	}
 	
 	protected MemberRewardPoint saveMemberRewardPointDetail(RetailScmUserContext userContext, MemberRewardPoint memberRewardPoint) throws Exception{	

 		
 		return saveMemberRewardPoint(userContext, memberRewardPoint, allTokens());
 	}
 	
 	public MemberRewardPoint loadMemberRewardPoint(RetailScmUserContext userContext, String memberRewardPointId, String [] tokensExpr) throws Exception{				
 
 		MemberRewardPointManagerException exception = new MemberRewardPointManagerException("Error Occured");
		
		checkIdOfMemberRewardPoint(userContext, memberRewardPointId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberRewardPoint memberRewardPoint = loadMemberRewardPoint( userContext, memberRewardPointId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberRewardPoint, tokens);
 	}
 	
 	protected MemberRewardPoint present(RetailScmUserContext userContext, MemberRewardPoint memberRewardPoint, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberRewardPoint,tokens);
		
		
		return this.getMemberRewardPointDAO().present(memberRewardPoint, tokens);
	}
 
 	
 	
 	public MemberRewardPoint loadMemberRewardPointDetail(RetailScmUserContext userContext, String memberRewardPointId) throws Exception{	
 		MemberRewardPointManagerException exception = new MemberRewardPointManagerException("Error Occured");
		
		checkIdOfMemberRewardPoint(userContext, memberRewardPointId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberRewardPoint memberRewardPoint = loadMemberRewardPoint( userContext, memberRewardPointId, allTokens());

 		return present(userContext,memberRewardPoint, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String memberRewardPointId) throws Exception{	
 		MemberRewardPointManagerException exception = new MemberRewardPointManagerException("Error Occured");
		
		checkIdOfMemberRewardPoint(userContext, memberRewardPointId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberRewardPoint memberRewardPoint = loadMemberRewardPoint( userContext, memberRewardPointId, allTokens());

 		return present(userContext,memberRewardPoint, allTokens());
		
 	}
 	protected MemberRewardPoint saveMemberRewardPoint(RetailScmUserContext userContext, MemberRewardPoint memberRewardPoint, Map<String,Object>tokens) throws Exception{	
 		return getMemberRewardPointDAO().save(memberRewardPoint, tokens);
 	}
 	protected MemberRewardPoint loadMemberRewardPoint(RetailScmUserContext userContext, String memberRewardPointId, Map<String,Object>tokens) throws Exception{	
 		return getMemberRewardPointDAO().load(memberRewardPointId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberRewardPoint memberRewardPoint, Map<String, Object> tokens){
		super.addActions(userContext, memberRewardPoint, tokens);
		
		addAction(userContext, memberRewardPoint, tokens,"@create","createMemberRewardPoint","createMemberRewardPoint/","main","primary");
		addAction(userContext, memberRewardPoint, tokens,"@update","updateMemberRewardPoint","updateMemberRewardPoint/"+memberRewardPoint.getId()+"/","main","primary");
		addAction(userContext, memberRewardPoint, tokens,"@copy","cloneMemberRewardPoint","cloneMemberRewardPoint/"+memberRewardPoint.getId()+"/","main","primary");
		
		addAction(userContext, memberRewardPoint, tokens,"member_reward_point.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberRewardPoint.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberRewardPoint memberRewardPoint, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MemberRewardPoint createMemberRewardPoint(RetailScmUserContext userContext,String name, int point, String ownerId
) throws Exception
	{
		
		MemberRewardPointManagerException exception = new MemberRewardPointManagerException("Error Occured");

		

		checkNameOfMemberRewardPoint(userContext,  name, exception);
		checkPointOfMemberRewardPoint(userContext,  point, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		MemberRewardPoint memberRewardPoint=createNewMemberRewardPoint();	

		memberRewardPoint.setName(name);
		memberRewardPoint.setPoint(point);
		RetailStoreMember owner = loadRetailStoreMember(ownerId,emptyOptions());
		memberRewardPoint.setOwner(owner);

		return saveMemberRewardPoint(userContext, memberRewardPoint, emptyOptions());
		

		
	}
	protected MemberRewardPoint createNewMemberRewardPoint() 
	{
		
		return new MemberRewardPoint();		
	}
	
	protected void checkParamsForUpdatingMemberRewardPoint(RetailScmUserContext userContext,String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		MemberRewardPointManagerException exception = new MemberRewardPointManagerException("Error Occured");
		
		checkIdOfMemberRewardPoint(userContext, memberRewardPointId, exception);
		checkVersionOfMemberRewardPoint(userContext, memberRewardPointVersion, exception);
		

		if(MemberRewardPoint.NAME_PROPERTY.equals(property)){
			checkNameOfMemberRewardPoint(userContext, parseString(newValueExpr), exception);
		}
		if(MemberRewardPoint.POINT_PROPERTY.equals(property)){
			checkPointOfMemberRewardPoint(userContext, parseInt(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public MemberRewardPoint clone(RetailScmUserContext userContext, String fromMemberRewardPointId) throws Exception{
		
		return this.getMemberRewardPointDAO().clone(fromMemberRewardPointId, this.allTokens());
	}
	
	public MemberRewardPoint updateMemberRewardPoint(RetailScmUserContext userContext,String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberRewardPoint(userContext, memberRewardPointId, memberRewardPointVersion, property, newValueExpr, tokensExpr);
		
		MemberRewardPoint memberRewardPoint = loadMemberRewardPoint(userContext, memberRewardPointId, allTokens());
		if(memberRewardPoint.getVersion() != memberRewardPointVersion){
			String message = "The target version("+memberRewardPoint.getVersion()+") is not equals to version("+memberRewardPointVersion+") provided";
			throw new MemberRewardPointManagerException(message);
		}
		synchronized(memberRewardPoint){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPoint.
			
			memberRewardPoint.changePropery(property, newValueExpr);
			memberRewardPoint = saveMemberRewardPoint(userContext, memberRewardPoint, tokens().done());
			return present(userContext,memberRewardPoint, mergedAllTokens(tokensExpr));
			//return saveMemberRewardPoint(userContext, memberRewardPoint, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MemberRewardPointTokens tokens(){
		return MemberRewardPointTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberRewardPointTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberRewardPointTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String memberRewardPointId, String anotherOwnerId) throws Exception
 	{
 		MemberRewardPointManagerException exception = new MemberRewardPointManagerException("Error Occured");
 		checkIdOfMemberRewardPoint(userContext, memberRewardPointId,exception);
 		checkIdOfRetailStoreMember(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public MemberRewardPoint transferToAnotherOwner(RetailScmUserContext userContext, String memberRewardPointId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberRewardPointId,anotherOwnerId);
 
		MemberRewardPoint memberRewardPoint = loadMemberRewardPoint(userContext, memberRewardPointId, allTokens());	
		synchronized(memberRewardPoint){
			//will be good when the memberRewardPoint loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(anotherOwnerId, emptyOptions());		
			memberRewardPoint.setOwner(owner);		
			memberRewardPoint = saveMemberRewardPoint(userContext, memberRewardPoint, emptyOptions());
			
			return present(userContext,memberRewardPoint, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String memberRewardPointId, int memberRewardPointVersion) throws Exception {
		
		deleteInternal(userContext, memberRewardPointId, memberRewardPointVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String memberRewardPointId, int memberRewardPointVersion) throws Exception{
		getMemberRewardPointDAO().delete(memberRewardPointId, memberRewardPointVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberRewardPointManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getMemberRewardPointDAO().deleteAll();
	}


}


