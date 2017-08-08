
package com.skynet.retailscm.memberwishlistproduct;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.memberwishlist.MemberWishlist;

import com.skynet.retailscm.memberwishlist.MemberWishlistDAO;



import com.skynet.retailscm.memberwishlist.MemberWishlistTable;




public class MemberWishlistProductManagerImpl extends RetailScmCheckerManager implements MemberWishlistProductManager {
	
	private static final String SERVICE_TYPE = "MemberWishlistProduct";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  MemberWishlistProductDAO  memberWishlistProductDAO;
 	public void setMemberWishlistProductDAO(MemberWishlistProductDAO  memberWishlistProductDAO){
 	
 		if(memberWishlistProductDAO == null){
 			throw new IllegalStateException("Do not try to set memberWishlistProductDAO to null.");
 		}
	 	this.memberWishlistProductDAO = memberWishlistProductDAO;
 	}
 	public MemberWishlistProductDAO getMemberWishlistProductDAO(){
 		if(this.memberWishlistProductDAO == null){
 			throw new IllegalStateException("The MemberWishlistProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberWishlistProductDAO;
 	}
 	
 	protected MemberWishlistProduct saveMemberWishlistProduct(RetailScmUserContext userContext, MemberWishlistProduct memberWishlistProduct, String [] tokensExpr) throws Exception{	
 		//return getMemberWishlistProductDAO().save(memberWishlistProduct, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens);
 	}
 	
 	protected MemberWishlistProduct saveMemberWishlistProductDetail(RetailScmUserContext userContext, MemberWishlistProduct memberWishlistProduct) throws Exception{	

 		
 		return saveMemberWishlistProduct(userContext, memberWishlistProduct, allTokens());
 	}
 	
 	public MemberWishlistProduct loadMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistProductId, String [] tokensExpr) throws Exception{				
 
 		MemberWishlistProductManagerException exception = new MemberWishlistProductManagerException("Error Occured");
		
		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct( userContext, memberWishlistProductId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberWishlistProduct, tokens);
 	}
 	
 	protected MemberWishlistProduct present(RetailScmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberWishlistProduct,tokens);
		
		
		return this.getMemberWishlistProductDAO().present(memberWishlistProduct, tokens);
	}
 
 	
 	
 	public MemberWishlistProduct loadMemberWishlistProductDetail(RetailScmUserContext userContext, String memberWishlistProductId) throws Exception{	
 		MemberWishlistProductManagerException exception = new MemberWishlistProductManagerException("Error Occured");
		
		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct( userContext, memberWishlistProductId, allTokens());

 		return present(userContext,memberWishlistProduct, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String memberWishlistProductId) throws Exception{	
 		MemberWishlistProductManagerException exception = new MemberWishlistProductManagerException("Error Occured");
		
		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct( userContext, memberWishlistProductId, allTokens());

 		return present(userContext,memberWishlistProduct, allTokens());
		
 	}
 	protected MemberWishlistProduct saveMemberWishlistProduct(RetailScmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String,Object>tokens) throws Exception{	
 		return getMemberWishlistProductDAO().save(memberWishlistProduct, tokens);
 	}
 	protected MemberWishlistProduct loadMemberWishlistProduct(RetailScmUserContext userContext, String memberWishlistProductId, Map<String,Object>tokens) throws Exception{	
 		return getMemberWishlistProductDAO().load(memberWishlistProductId, tokens);
 	}

	



 	 
 	
 	private  MemberWishlistDAO  memberWishlistDAO;
 	public void setMemberWishlistDAO(MemberWishlistDAO memberWishlistDAO){
	 	this.memberWishlistDAO = memberWishlistDAO;
 	}
 	//------------------------------------
 	public MemberWishlistDAO getMemberWishlistDAO(){
	 	return this.memberWishlistDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String, Object> tokens){
		super.addActions(userContext, memberWishlistProduct, tokens);
		
		addAction(userContext, memberWishlistProduct, tokens,"@create","createMemberWishlistProduct","createMemberWishlistProduct/","main","primary");
		addAction(userContext, memberWishlistProduct, tokens,"@update","updateMemberWishlistProduct","updateMemberWishlistProduct/"+memberWishlistProduct.getId()+"/","main","primary");
		addAction(userContext, memberWishlistProduct, tokens,"@copy","cloneMemberWishlistProduct","cloneMemberWishlistProduct/"+memberWishlistProduct.getId()+"/","main","primary");
		
		addAction(userContext, memberWishlistProduct, tokens,"member_wishlist_product.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberWishlistProduct.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, MemberWishlistProduct memberWishlistProduct, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MemberWishlistProduct createMemberWishlistProduct(RetailScmUserContext userContext,String name, String ownerId
) throws Exception
	{
		
		MemberWishlistProductManagerException exception = new MemberWishlistProductManagerException("Error Occured");

		

		checkNameOfMemberWishlistProduct(userContext,  name, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		MemberWishlistProduct memberWishlistProduct=createNewMemberWishlistProduct();	

		memberWishlistProduct.setName(name);
		MemberWishlist owner = loadMemberWishlist(ownerId,emptyOptions());
		memberWishlistProduct.setOwner(owner);

		return saveMemberWishlistProduct(userContext, memberWishlistProduct, emptyOptions());
		

		
	}
	protected MemberWishlistProduct createNewMemberWishlistProduct() 
	{
		
		return new MemberWishlistProduct();		
	}
	
	protected void checkParamsForUpdatingMemberWishlistProduct(RetailScmUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		MemberWishlistProductManagerException exception = new MemberWishlistProductManagerException("Error Occured");
		
		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId, exception);
		checkVersionOfMemberWishlistProduct(userContext, memberWishlistProductVersion, exception);
		

		if(MemberWishlistProduct.NAME_PROPERTY.equals(property)){
			checkNameOfMemberWishlistProduct(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public MemberWishlistProduct clone(RetailScmUserContext userContext, String fromMemberWishlistProductId) throws Exception{
		
		return this.getMemberWishlistProductDAO().clone(fromMemberWishlistProductId, this.allTokens());
	}
	
	public MemberWishlistProduct updateMemberWishlistProduct(RetailScmUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberWishlistProduct(userContext, memberWishlistProductId, memberWishlistProductVersion, property, newValueExpr, tokensExpr);
		
		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct(userContext, memberWishlistProductId, allTokens());
		if(memberWishlistProduct.getVersion() != memberWishlistProductVersion){
			String message = "The target version("+memberWishlistProduct.getVersion()+") is not equals to version("+memberWishlistProductVersion+") provided";
			throw new MemberWishlistProductManagerException(message);
		}
		synchronized(memberWishlistProduct){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberWishlistProduct.
			
			memberWishlistProduct.changePropery(property, newValueExpr);
			memberWishlistProduct = saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens().done());
			return present(userContext,memberWishlistProduct, mergedAllTokens(tokensExpr));
			//return saveMemberWishlistProduct(userContext, memberWishlistProduct, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MemberWishlistProductTokens tokens(){
		return MemberWishlistProductTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberWishlistProductTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberWishlistProductTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String memberWishlistProductId, String anotherOwnerId) throws Exception
 	{
 		MemberWishlistProductManagerException exception = new MemberWishlistProductManagerException("Error Occured");
 		checkIdOfMemberWishlistProduct(userContext, memberWishlistProductId,exception);
 		checkIdOfMemberWishlist(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public MemberWishlistProduct transferToAnotherOwner(RetailScmUserContext userContext, String memberWishlistProductId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberWishlistProductId,anotherOwnerId);
 
		MemberWishlistProduct memberWishlistProduct = loadMemberWishlistProduct(userContext, memberWishlistProductId, allTokens());	
		synchronized(memberWishlistProduct){
			//will be good when the memberWishlistProduct loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			MemberWishlist owner = loadMemberWishlist(anotherOwnerId, emptyOptions());		
			memberWishlistProduct.setOwner(owner);		
			memberWishlistProduct = saveMemberWishlistProduct(userContext, memberWishlistProduct, emptyOptions());
			
			return present(userContext,memberWishlistProduct, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected MemberWishlist loadMemberWishlist(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getMemberWishlistDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String memberWishlistProductId, int memberWishlistProductVersion) throws Exception {
		
		deleteInternal(userContext, memberWishlistProductId, memberWishlistProductVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String memberWishlistProductId, int memberWishlistProductVersion) throws Exception{
		getMemberWishlistProductDAO().delete(memberWishlistProductId, memberWishlistProductVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberWishlistProductManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getMemberWishlistProductDAO().deleteAll();
	}


}


