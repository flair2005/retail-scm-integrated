
package com.skynet.retailscm.memberwishlist;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProduct;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;

import com.skynet.retailscm.memberwishlist.MemberWishlist;


import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProductTable;




public class MemberWishlistManagerImpl extends RetailScmCheckerManager implements MemberWishlistManager {
	
	private static final String SERVICE_TYPE = "MemberWishlist";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  MemberWishlistDAO  memberWishlistDAO;
 	public void setMemberWishlistDAO(MemberWishlistDAO  memberWishlistDAO){
 	
 		if(memberWishlistDAO == null){
 			throw new IllegalStateException("Do not try to set memberWishlistDAO to null.");
 		}
	 	this.memberWishlistDAO = memberWishlistDAO;
 	}
 	public MemberWishlistDAO getMemberWishlistDAO(){
 		if(this.memberWishlistDAO == null){
 			throw new IllegalStateException("The MemberWishlistDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberWishlistDAO;
 	}
 	
 	protected MemberWishlist saveMemberWishlist(RetailScmUserContext userContext, MemberWishlist memberWishlist, String [] tokensExpr) throws Exception{	
 		//return getMemberWishlistDAO().save(memberWishlist, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberWishlist(userContext, memberWishlist, tokens);
 	}
 	
 	protected MemberWishlist saveMemberWishlistDetail(RetailScmUserContext userContext, MemberWishlist memberWishlist) throws Exception{	

 		
 		return saveMemberWishlist(userContext, memberWishlist, allTokens());
 	}
 	
 	public MemberWishlist loadMemberWishlist(RetailScmUserContext userContext, String memberWishlistId, String [] tokensExpr) throws Exception{				
 
 		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberWishlist memberWishlist = loadMemberWishlist( userContext, memberWishlistId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberWishlist, tokens);
 	}
 	
 	protected MemberWishlist present(RetailScmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberWishlist,tokens);
		
		
		return this.getMemberWishlistDAO().present(memberWishlist, tokens);
	}
 
 	
 	
 	public MemberWishlist loadMemberWishlistDetail(RetailScmUserContext userContext, String memberWishlistId) throws Exception{	
 		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberWishlist memberWishlist = loadMemberWishlist( userContext, memberWishlistId, allTokens());

 		return present(userContext,memberWishlist, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String memberWishlistId) throws Exception{	
 		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberWishlist memberWishlist = loadMemberWishlist( userContext, memberWishlistId, allTokens());

 		return present(userContext,memberWishlist, allTokens());
		
 	}
 	protected MemberWishlist saveMemberWishlist(RetailScmUserContext userContext, MemberWishlist memberWishlist, Map<String,Object>tokens) throws Exception{	
 		return getMemberWishlistDAO().save(memberWishlist, tokens);
 	}
 	protected MemberWishlist loadMemberWishlist(RetailScmUserContext userContext, String memberWishlistId, Map<String,Object>tokens) throws Exception{	
 		return getMemberWishlistDAO().load(memberWishlistId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens){
		super.addActions(userContext, memberWishlist, tokens);
		
		addAction(userContext, memberWishlist, tokens,"@create","createMemberWishlist","createMemberWishlist/","main","primary");
		addAction(userContext, memberWishlist, tokens,"@update","updateMemberWishlist","updateMemberWishlist/"+memberWishlist.getId()+"/","main","primary");
		addAction(userContext, memberWishlist, tokens,"@copy","cloneMemberWishlist","cloneMemberWishlist/"+memberWishlist.getId()+"/","main","primary");
		
		addAction(userContext, memberWishlist, tokens,"member_wishlist.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberWishlist.getId()+"/","main","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.addMemberWishlistProduct","addMemberWishlistProduct","addMemberWishlistProduct/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.removeMemberWishlistProduct","removeMemberWishlistProduct","removeMemberWishlistProduct/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.updateMemberWishlistProduct","updateMemberWishlistProduct","updateMemberWishlistProduct/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
		addAction(userContext, memberWishlist, tokens,"member_wishlist.copyMemberWishlistProductFrom","copyMemberWishlistProductFrom","copyMemberWishlistProductFrom/"+memberWishlist.getId()+"/","memberWishlistProductList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MemberWishlist createMemberWishlist(RetailScmUserContext userContext,String name, String ownerId
) throws Exception
	{
		
		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");

		

		checkNameOfMemberWishlist(userContext,  name, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		MemberWishlist memberWishlist=createNewMemberWishlist();	

		memberWishlist.setName(name);
		RetailStoreMember owner = loadRetailStoreMember(ownerId,emptyOptions());
		memberWishlist.setOwner(owner);

		return saveMemberWishlist(userContext, memberWishlist, emptyOptions());
		

		
	}
	protected MemberWishlist createNewMemberWishlist() 
	{
		
		return new MemberWishlist();		
	}
	
	protected void checkParamsForUpdatingMemberWishlist(RetailScmUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		checkVersionOfMemberWishlist(userContext, memberWishlistVersion, exception);
		

		if(MemberWishlist.NAME_PROPERTY.equals(property)){
			checkNameOfMemberWishlist(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public MemberWishlist clone(RetailScmUserContext userContext, String fromMemberWishlistId) throws Exception{
		
		return this.getMemberWishlistDAO().clone(fromMemberWishlistId, this.allTokens());
	}
	
	public MemberWishlist updateMemberWishlist(RetailScmUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberWishlist(userContext, memberWishlistId, memberWishlistVersion, property, newValueExpr, tokensExpr);
		
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		if(memberWishlist.getVersion() != memberWishlistVersion){
			String message = "The target version("+memberWishlist.getVersion()+") is not equals to version("+memberWishlistVersion+") provided";
			throw new MemberWishlistManagerException(message);
		}
		synchronized(memberWishlist){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlist.
			
			memberWishlist.changePropery(property, newValueExpr);
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
			//return saveMemberWishlist(userContext, memberWishlist, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MemberWishlistTokens tokens(){
		return MemberWishlistTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberWishlistTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberWishlistTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String memberWishlistId, String anotherOwnerId) throws Exception
 	{
 		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
 		checkIdOfMemberWishlist(userContext, memberWishlistId,exception);
 		checkIdOfRetailStoreMember(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public MemberWishlist transferToAnotherOwner(RetailScmUserContext userContext, String memberWishlistId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberWishlistId,anotherOwnerId);
 
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());	
		synchronized(memberWishlist){
			//will be good when the memberWishlist loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(anotherOwnerId, emptyOptions());		
			memberWishlist.setOwner(owner);		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, emptyOptions());
			
			return present(userContext,memberWishlist, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String memberWishlistId, int memberWishlistVersion) throws Exception {
		
		deleteInternal(userContext, memberWishlistId, memberWishlistVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String memberWishlistId, int memberWishlistVersion) throws Exception{
		getMemberWishlistDAO().delete(memberWishlistId, memberWishlistVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberWishlistManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getMemberWishlistDAO().deleteAll();
	}

	protected void checkParamsForAddingMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, String name,String [] tokensExpr) throws Exception{
		
		

		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);

		checkNameOfMemberWishlistProduct(userContext,  name, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  MemberWishlist addMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberWishlistProduct(userContext,memberWishlistId,name,tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = createMemberWishlistProduct(userContext,name);
		
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			memberWishlist.addMemberWishlistProduct( memberWishlistProduct );		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}
	}
	protected MemberWishlistProduct createMemberWishlistProduct(RetailScmUserContext userContext, String name) throws Exception{

		MemberWishlistProduct memberWishlistProduct = new MemberWishlistProduct();
		
		
		memberWishlistProduct.setName(name);
	
		
		return memberWishlistProduct;
	
		
	}
	
	protected MemberWishlistProduct createIndexedMemberWishlistProduct(String id, int version){

		MemberWishlistProduct memberWishlistProduct = new MemberWishlistProduct();
		memberWishlistProduct.setId(id);
		memberWishlistProduct.setVersion(version);
		return memberWishlistProduct;			
		
	}
	protected void checkParamsForRemovingMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		

		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId, exception);
		checkVersionOfMemberWishlistProduct(userContext, memberWishlistProductVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  MemberWishlist removeMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberWishlistProduct(userContext,memberWishlistId, memberWishlistProductId, memberWishlistProductVersion,tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			memberWishlist.removeMemberWishlistProduct( memberWishlistProduct );		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		

		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId, exception);
		checkVersionOfMemberWishlistProduct(userContext, memberWishlistProductVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  MemberWishlist copyMemberWishlistProductFrom(RetailScmUserContext userContext, String memberWishlistId, 
		String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberWishlistProduct(userContext,memberWishlistId, memberWishlistProductId, memberWishlistProductVersion,tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			memberWishlist.copyMemberWishlistProductFrom( memberWishlistProduct );		
			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		MemberWishlistManagerException exception = new MemberWishlistManagerException("Error Occured");
		
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId, exception);
		checkVersionOfMemberWishlistProduct(userContext, memberWishlistProductVersion, exception);
		

		if(MemberWishlistProduct.NAME_PROPERTY.equals(property)){
			checkNameOfMemberWishlistProduct(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  MemberWishlist updateMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberWishlistProduct(userContext, memberWishlistId, memberWishlistProductId, memberWishlistProductVersion, property, newValueExpr,  tokensExpr);
		
		
		MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
		
		synchronized(memberWishlist){ 
			//Will be good when the memberWishlist loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//memberWishlist.removeMemberWishlistProduct( memberWishlistProduct );	
			//make changes to AcceleraterAccount.
			MemberWishlistProduct memberWishlistProductIndex = createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
		
			MemberWishlistProduct memberWishlistProduct = memberWishlist.findTheMemberWishlistProduct(memberWishlistProductIndex);
			if(memberWishlistProduct == null){
				throw new MemberWishlistManagerException(memberWishlistProduct+"Not found" );
			}
			
			memberWishlistProduct.changePropery(property, newValueExpr);

			memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
			return present(userContext,memberWishlist, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


