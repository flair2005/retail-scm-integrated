
package com.skynet.retailscm.retailstoremembercoupon;

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




public class RetailStoreMemberCouponManagerImpl extends RetailScmCheckerManager implements RetailStoreMemberCouponManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMemberCoupon";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreMemberCouponDAO  retailStoreMemberCouponDAO;
 	public void setRetailStoreMemberCouponDAO(RetailStoreMemberCouponDAO  retailStoreMemberCouponDAO){
 	
 		if(retailStoreMemberCouponDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberCouponDAO to null.");
 		}
	 	this.retailStoreMemberCouponDAO = retailStoreMemberCouponDAO;
 	}
 	public RetailStoreMemberCouponDAO getRetailStoreMemberCouponDAO(){
 		if(this.retailStoreMemberCouponDAO == null){
 			throw new IllegalStateException("The RetailStoreMemberCouponDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberCouponDAO;
 	}
 	
 	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailScmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberCouponDAO().save(retailStoreMemberCoupon, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens);
 	}
 	
 	protected RetailStoreMemberCoupon saveRetailStoreMemberCouponDetail(RetailScmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon) throws Exception{	

 		
 		return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, allTokens());
 	}
 	
 	public RetailStoreMemberCoupon loadRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberCouponId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreMemberCouponManagerException exception = new RetailStoreMemberCouponManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberCoupon, tokens);
 	}
 	
 	protected RetailStoreMemberCoupon present(RetailScmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberCoupon,tokens);
		
		
		return this.getRetailStoreMemberCouponDAO().present(retailStoreMemberCoupon, tokens);
	}
 
 	
 	
 	public RetailStoreMemberCoupon loadRetailStoreMemberCouponDetail(RetailScmUserContext userContext, String retailStoreMemberCouponId) throws Exception{	
 		RetailStoreMemberCouponManagerException exception = new RetailStoreMemberCouponManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, allTokens());

 		return present(userContext,retailStoreMemberCoupon, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreMemberCouponId) throws Exception{	
 		RetailStoreMemberCouponManagerException exception = new RetailStoreMemberCouponManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon( userContext, retailStoreMemberCouponId, allTokens());

 		return present(userContext,retailStoreMemberCoupon, allTokens());
		
 	}
 	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailScmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberCouponDAO().save(retailStoreMemberCoupon, tokens);
 	}
 	protected RetailStoreMemberCoupon loadRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberCouponId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberCouponDAO().load(retailStoreMemberCouponId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberCoupon, tokens);
		
		addAction(userContext, retailStoreMemberCoupon, tokens,"@create","createRetailStoreMemberCoupon","createRetailStoreMemberCoupon/","main","primary");
		addAction(userContext, retailStoreMemberCoupon, tokens,"@update","updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon/"+retailStoreMemberCoupon.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberCoupon, tokens,"@copy","cloneRetailStoreMemberCoupon","cloneRetailStoreMemberCoupon/"+retailStoreMemberCoupon.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberCoupon, tokens,"retail_store_member_coupon.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberCoupon.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailScmUserContext userContext,String name, String ownerId, String number
) throws Exception
	{
		
		RetailStoreMemberCouponManagerException exception = new RetailStoreMemberCouponManagerException("Error Occured");

		

		checkNameOfRetailStoreMemberCoupon(userContext,  name, exception);
		checkNumberOfRetailStoreMemberCoupon(userContext,  number, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreMemberCoupon retailStoreMemberCoupon=createNewRetailStoreMemberCoupon();	

		retailStoreMemberCoupon.setName(name);
		RetailStoreMember owner = loadRetailStoreMember(ownerId,emptyOptions());
		retailStoreMemberCoupon.setOwner(owner);
		retailStoreMemberCoupon.setNumber(number);

		return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, emptyOptions());
		

		
	}
	protected RetailStoreMemberCoupon createNewRetailStoreMemberCoupon() 
	{
		
		return new RetailStoreMemberCoupon();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberCoupon(RetailScmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreMemberCouponManagerException exception = new RetailStoreMemberCouponManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, exception);
		checkVersionOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponVersion, exception);
		

		if(RetailStoreMemberCoupon.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreMemberCoupon(userContext, parseString(newValueExpr), exception);
		}		

		
		if(RetailStoreMemberCoupon.NUMBER_PROPERTY.equals(property)){
			checkNumberOfRetailStoreMemberCoupon(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreMemberCoupon clone(RetailScmUserContext userContext, String fromRetailStoreMemberCouponId) throws Exception{
		
		return this.getRetailStoreMemberCouponDAO().clone(fromRetailStoreMemberCouponId, this.allTokens());
	}
	
	public RetailStoreMemberCoupon updateRetailStoreMemberCoupon(RetailScmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());
		if(retailStoreMemberCoupon.getVersion() != retailStoreMemberCouponVersion){
			String message = "The target version("+retailStoreMemberCoupon.getVersion()+") is not equals to version("+retailStoreMemberCouponVersion+") provided";
			throw new RetailStoreMemberCouponManagerException(message);
		}
		synchronized(retailStoreMemberCoupon){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberCoupon.
			
			retailStoreMemberCoupon.changePropery(property, newValueExpr);
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
			return present(userContext,retailStoreMemberCoupon, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberCouponTokens tokens(){
		return RetailStoreMemberCouponTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberCouponTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberCouponTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId) throws Exception
 	{
 		RetailStoreMemberCouponManagerException exception = new RetailStoreMemberCouponManagerException("Error Occured");
 		checkIdOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId,exception);
 		checkIdOfRetailStoreMember(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreMemberCoupon transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberCouponId,anotherOwnerId);
 
		RetailStoreMemberCoupon retailStoreMemberCoupon = loadRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, allTokens());	
		synchronized(retailStoreMemberCoupon){
			//will be good when the retailStoreMemberCoupon loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(anotherOwnerId, emptyOptions());		
			retailStoreMemberCoupon.setOwner(owner);		
			retailStoreMemberCoupon = saveRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, emptyOptions());
			
			return present(userContext,retailStoreMemberCoupon, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreMemberCouponId, retailStoreMemberCouponVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreMemberCouponId, int retailStoreMemberCouponVersion) throws Exception{
		getRetailStoreMemberCouponDAO().delete(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberCouponManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreMemberCouponDAO().deleteAll();
	}


}


