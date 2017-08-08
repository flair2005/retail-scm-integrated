
package com.skynet.retailscm.retailstoremember;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.skynet.retailscm.memberwishlist.MemberWishlist;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPoint;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.consumerorder.ConsumerOrderTable;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPointTable;
import com.skynet.retailscm.memberwishlist.MemberWishlistTable;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddressTable;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTable;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCouponTable;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionTable;




public class RetailStoreMemberManagerImpl extends RetailScmCheckerManager implements RetailStoreMemberManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMember";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO  retailStoreMemberDAO){
 	
 		if(retailStoreMemberDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberDAO to null.");
 		}
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
 		if(this.retailStoreMemberDAO == null){
 			throw new IllegalStateException("The RetailStoreMemberDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberDAO;
 	}
 	
 	protected RetailStoreMember saveRetailStoreMember(RetailScmUserContext userContext, RetailStoreMember retailStoreMember, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberDAO().save(retailStoreMember, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMember(userContext, retailStoreMember, tokens);
 	}
 	
 	protected RetailStoreMember saveRetailStoreMemberDetail(RetailScmUserContext userContext, RetailStoreMember retailStoreMember) throws Exception{	

 		
 		return saveRetailStoreMember(userContext, retailStoreMember, allTokens());
 	}
 	
 	public RetailStoreMember loadRetailStoreMember(RetailScmUserContext userContext, String retailStoreMemberId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMember, tokens);
 	}
 	
 	protected RetailStoreMember present(RetailScmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMember,tokens);
		
		
		return this.getRetailStoreMemberDAO().present(retailStoreMember, tokens);
	}
 
 	
 	
 	public RetailStoreMember loadRetailStoreMemberDetail(RetailScmUserContext userContext, String retailStoreMemberId) throws Exception{	
 		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, allTokens());

 		return present(userContext,retailStoreMember, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreMemberId) throws Exception{	
 		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, allTokens());

 		return present(userContext,retailStoreMember, allTokens());
		
 	}
 	protected RetailStoreMember saveRetailStoreMember(RetailScmUserContext userContext, RetailStoreMember retailStoreMember, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberDAO().save(retailStoreMember, tokens);
 	}
 	protected RetailStoreMember loadRetailStoreMember(RetailScmUserContext userContext, String retailStoreMemberId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberDAO().load(retailStoreMemberId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMember, tokens);
		
		addAction(userContext, retailStoreMember, tokens,"@create","createRetailStoreMember","createRetailStoreMember/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@update","updateRetailStoreMember","updateRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@copy","cloneRetailStoreMember","cloneRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberCoupon","addRetailStoreMemberCoupon","addRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberWishlist","addMemberWishlist","addMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberWishlist","removeMemberWishlist","removeMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberWishlist","updateMemberWishlist","updateMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberWishlistFrom","copyMemberWishlistFrom","copyMemberWishlistFrom/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPoint","addMemberRewardPoint","addMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPoint","removeMemberRewardPoint","removeMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPoint","updateMemberRewardPoint","updateMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointFrom","copyMemberRewardPointFrom","copyMemberRewardPointFrom/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPointRedemption","addMemberRewardPointRedemption","addMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPointRedemption","removeMemberRewardPointRedemption","removeMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPointRedemption","updateMemberRewardPointRedemption","updateMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberAddress","addRetailStoreMemberAddress","addRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberAddress","removeRetailStoreMemberAddress","removeRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberAddress","updateRetailStoreMemberAddress","updateRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMember createRetailStoreMember(RetailScmUserContext userContext,String name, String mobilePhone, String ownerId
) throws Exception
	{
		
		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");

		

		checkNameOfRetailStoreMember(userContext,  name, exception);
		checkMobilePhoneOfRetailStoreMember(userContext,  mobilePhone, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreMember retailStoreMember=createNewRetailStoreMember();	

		retailStoreMember.setName(name);
		retailStoreMember.setMobilePhone(mobilePhone);
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(ownerId,emptyOptions());
		retailStoreMember.setOwner(owner);

		return saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());
		

		
	}
	protected RetailStoreMember createNewRetailStoreMember() 
	{
		
		return new RetailStoreMember();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMember(RetailScmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkVersionOfRetailStoreMember(userContext, retailStoreMemberVersion, exception);
		

		if(RetailStoreMember.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreMember(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreMember.MOBILE_PHONE_PROPERTY.equals(property)){
			checkMobilePhoneOfRetailStoreMember(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreMember clone(RetailScmUserContext userContext, String fromRetailStoreMemberId) throws Exception{
		
		return this.getRetailStoreMemberDAO().clone(fromRetailStoreMemberId, this.allTokens());
	}
	
	public RetailStoreMember updateRetailStoreMember(RetailScmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		if(retailStoreMember.getVersion() != retailStoreMemberVersion){
			String message = "The target version("+retailStoreMember.getVersion()+") is not equals to version("+retailStoreMemberVersion+") provided";
			throw new RetailStoreMemberManagerException(message);
		}
		synchronized(retailStoreMember){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			
			retailStoreMember.changePropery(property, newValueExpr);
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberTokens tokens(){
		return RetailStoreMemberTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{
 		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
 		checkIdOfRetailStoreMember(userContext, retailStoreMemberId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreMember transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberId,anotherOwnerId);
 
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());	
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(anotherOwnerId, emptyOptions());		
			retailStoreMember.setOwner(owner);		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());
			
			return present(userContext,retailStoreMember, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreMemberId, int retailStoreMemberVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreMemberId, retailStoreMemberVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreMemberId, int retailStoreMemberVersion) throws Exception{
		getRetailStoreMemberDAO().delete(retailStoreMemberId, retailStoreMemberVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreMemberDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, String title, String storeId,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);

		checkTitleOfConsumerOrder(userContext,  title, exception);		
		
		checkIdOfRetailStore(userContext,  storeId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMember addConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, String title, String storeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,retailStoreMemberId,title, storeId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, storeId);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addConsumerOrder( consumerOrder );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected ConsumerOrder createConsumerOrder(RetailScmUserContext userContext, String title, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);
	
		
		return consumerOrder;
	
		
	}
	
	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;			
		
	}
	protected void checkParamsForRemovingConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember removeConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeConsumerOrder( consumerOrder );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember copyConsumerOrderFrom(RetailScmUserContext userContext, String retailStoreMemberId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.copyConsumerOrderFrom( consumerOrder );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreMember updateConsumerOrder(RetailScmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, retailStoreMemberId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = retailStoreMember.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new RetailStoreMemberManagerException(consumerOrder+"Not found" );
			}
			
			consumerOrder.changePropery(property, newValueExpr);

			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, String name, String number,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);

		checkNameOfRetailStoreMemberCoupon(userContext,  name, exception);
		checkNumberOfRetailStoreMemberCoupon(userContext,  number, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMember addRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, String name, String number, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberCoupon(userContext,retailStoreMemberId,name, number,tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = createRetailStoreMemberCoupon(userContext,name, number);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberCoupon( retailStoreMemberCoupon );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailScmUserContext userContext, String name, String number) throws Exception{

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		
		
		retailStoreMemberCoupon.setName(name);		
		retailStoreMemberCoupon.setNumber(number);
	
		
		return retailStoreMemberCoupon;
	
		
	}
	
	protected RetailStoreMemberCoupon createIndexedRetailStoreMemberCoupon(String id, int version){

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		retailStoreMemberCoupon.setId(id);
		retailStoreMemberCoupon.setVersion(version);
		return retailStoreMemberCoupon;			
		
	}
	protected void checkParamsForRemovingRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, exception);
		checkVersionOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember removeRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponId, exception);
		checkVersionOfRetailStoreMemberCoupon(userContext, retailStoreMemberCouponVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember copyRetailStoreMemberCouponFrom(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.copyRetailStoreMemberCouponFrom( retailStoreMemberCoupon );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
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
	
	public  RetailStoreMember updateRetailStoreMemberCoupon(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberCoupon retailStoreMemberCouponIndex = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		
			RetailStoreMemberCoupon retailStoreMemberCoupon = retailStoreMember.findTheRetailStoreMemberCoupon(retailStoreMemberCouponIndex);
			if(retailStoreMemberCoupon == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberCoupon+"Not found" );
			}
			
			retailStoreMemberCoupon.changePropery(property, newValueExpr);

			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, String name,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);

		checkNameOfMemberWishlist(userContext,  name, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMember addMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, String name, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberWishlist(userContext,retailStoreMemberId,name,tokensExpr);
		
		MemberWishlist memberWishlist = createMemberWishlist(userContext,name);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberWishlist( memberWishlist );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected MemberWishlist createMemberWishlist(RetailScmUserContext userContext, String name) throws Exception{

		MemberWishlist memberWishlist = new MemberWishlist();
		
		
		memberWishlist.setName(name);
	
		
		return memberWishlist;
	
		
	}
	
	protected MemberWishlist createIndexedMemberWishlist(String id, int version){

		MemberWishlist memberWishlist = new MemberWishlist();
		memberWishlist.setId(id);
		memberWishlist.setVersion(version);
		return memberWishlist;			
		
	}
	protected void checkParamsForRemovingMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		checkVersionOfMemberWishlist(userContext, memberWishlistVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember removeMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);
		
		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberWishlist( memberWishlist );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		checkVersionOfMemberWishlist(userContext, memberWishlistVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember copyMemberWishlistFrom(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);
		
		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.copyMemberWishlistFrom( memberWishlist );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfMemberWishlist(userContext, memberWishlistId, exception);
		checkVersionOfMemberWishlist(userContext, memberWishlistVersion, exception);
		

		if(MemberWishlist.NAME_PROPERTY.equals(property)){
			checkNameOfMemberWishlist(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreMember updateMemberWishlist(RetailScmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberWishlist(userContext, retailStoreMemberId, memberWishlistId, memberWishlistVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberWishlist( memberWishlist );	
			//make changes to AcceleraterAccount.
			MemberWishlist memberWishlistIndex = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		
			MemberWishlist memberWishlist = retailStoreMember.findTheMemberWishlist(memberWishlistIndex);
			if(memberWishlist == null){
				throw new RetailStoreMemberManagerException(memberWishlist+"Not found" );
			}
			
			memberWishlist.changePropery(property, newValueExpr);

			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);

		checkNameOfMemberRewardPoint(userContext,  name, exception);
		checkPointOfMemberRewardPoint(userContext,  point, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMember addMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberRewardPoint(userContext,retailStoreMemberId,name, point,tokensExpr);
		
		MemberRewardPoint memberRewardPoint = createMemberRewardPoint(userContext,name, point);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPoint( memberRewardPoint );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected MemberRewardPoint createMemberRewardPoint(RetailScmUserContext userContext, String name, int point) throws Exception{

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		
		
		memberRewardPoint.setName(name);		
		memberRewardPoint.setPoint(point);
	
		
		return memberRewardPoint;
	
		
	}
	
	protected MemberRewardPoint createIndexedMemberRewardPoint(String id, int version){

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		memberRewardPoint.setId(id);
		memberRewardPoint.setVersion(version);
		return memberRewardPoint;			
		
	}
	protected void checkParamsForRemovingMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfMemberRewardPoint(userContext, memberRewardPointId, exception);
		checkVersionOfMemberRewardPoint(userContext, memberRewardPointVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember removeMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);
		
		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPoint( memberRewardPoint );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfMemberRewardPoint(userContext, memberRewardPointId, exception);
		checkVersionOfMemberRewardPoint(userContext, memberRewardPointVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember copyMemberRewardPointFrom(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);
		
		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.copyMemberRewardPointFrom( memberRewardPoint );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
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
	
	public  RetailStoreMember updateMemberRewardPoint(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberRewardPoint(userContext, retailStoreMemberId, memberRewardPointId, memberRewardPointVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPoint( memberRewardPoint );	
			//make changes to AcceleraterAccount.
			MemberRewardPoint memberRewardPointIndex = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		
			MemberRewardPoint memberRewardPoint = retailStoreMember.findTheMemberRewardPoint(memberRewardPointIndex);
			if(memberRewardPoint == null){
				throw new RetailStoreMemberManagerException(memberRewardPoint+"Not found" );
			}
			
			memberRewardPoint.changePropery(property, newValueExpr);

			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);

		checkNameOfMemberRewardPointRedemption(userContext,  name, exception);
		checkPointOfMemberRewardPointRedemption(userContext,  point, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMember addMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingMemberRewardPointRedemption(userContext,retailStoreMemberId,name, point,tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = createMemberRewardPointRedemption(userContext,name, point);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPointRedemption( memberRewardPointRedemption );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected MemberRewardPointRedemption createMemberRewardPointRedemption(RetailScmUserContext userContext, String name, int point) throws Exception{

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		
		
		memberRewardPointRedemption.setName(name);		
		memberRewardPointRedemption.setPoint(point);
	
		
		return memberRewardPointRedemption;
	
		
	}
	
	protected MemberRewardPointRedemption createIndexedMemberRewardPointRedemption(String id, int version){

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		memberRewardPointRedemption.setId(id);
		memberRewardPointRedemption.setVersion(version);
		return memberRewardPointRedemption;			
		
	}
	protected void checkParamsForRemovingMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, exception);
		checkVersionOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember removeMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, exception);
		checkVersionOfMemberRewardPointRedemption(userContext, memberRewardPointRedemptionVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember copyMemberRewardPointRedemptionFrom(RetailScmUserContext userContext, String retailStoreMemberId, 
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.copyMemberRewardPointRedemptionFrom( memberRewardPointRedemption );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
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
	
	public  RetailStoreMember updateMemberRewardPointRedemption(RetailScmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingMemberRewardPointRedemption(userContext, retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );	
			//make changes to AcceleraterAccount.
			MemberRewardPointRedemption memberRewardPointRedemptionIndex = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		
			MemberRewardPointRedemption memberRewardPointRedemption = retailStoreMember.findTheMemberRewardPointRedemption(memberRewardPointRedemptionIndex);
			if(memberRewardPointRedemption == null){
				throw new RetailStoreMemberManagerException(memberRewardPointRedemption+"Not found" );
			}
			
			memberRewardPointRedemption.changePropery(property, newValueExpr);

			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);

		checkNameOfRetailStoreMemberAddress(userContext,  name, exception);
		checkMobilePhoneOfRetailStoreMemberAddress(userContext,  mobilePhone, exception);
		checkAddressOfRetailStoreMemberAddress(userContext,  address, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMember addRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberAddress(userContext,retailStoreMemberId,name, mobilePhone, address,tokensExpr);
		
		RetailStoreMemberAddress retailStoreMemberAddress = createRetailStoreMemberAddress(userContext,name, mobilePhone, address);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberAddress( retailStoreMemberAddress );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreMemberAddress createRetailStoreMemberAddress(RetailScmUserContext userContext, String name, String mobilePhone, String address) throws Exception{

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		
		
		retailStoreMemberAddress.setName(name);		
		retailStoreMemberAddress.setMobilePhone(mobilePhone);		
		retailStoreMemberAddress.setAddress(address);
	
		
		return retailStoreMemberAddress;
	
		
	}
	
	protected RetailStoreMemberAddress createIndexedRetailStoreMemberAddress(String id, int version){

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		retailStoreMemberAddress.setId(id);
		retailStoreMemberAddress.setVersion(version);
		return retailStoreMemberAddress;			
		
	}
	protected void checkParamsForRemovingRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, exception);
		checkVersionOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember removeRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);
		
		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, exception);
		checkVersionOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember copyRetailStoreMemberAddressFrom(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);
		
		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.copyRetailStoreMemberAddressFrom( retailStoreMemberAddress );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, exception);
		checkVersionOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressVersion, exception);
		

		if(RetailStoreMemberAddress.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreMemberAddress(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY.equals(property)){
			checkMobilePhoneOfRetailStoreMemberAddress(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreMemberAddress.ADDRESS_PROPERTY.equals(property)){
			checkAddressOfRetailStoreMemberAddress(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreMember updateRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberAddress(userContext, retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberAddress retailStoreMemberAddressIndex = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		
			RetailStoreMemberAddress retailStoreMemberAddress = retailStoreMember.findTheRetailStoreMemberAddress(retailStoreMemberAddressIndex);
			if(retailStoreMemberAddress == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberAddress+"Not found" );
			}
			
			retailStoreMemberAddress.changePropery(property, newValueExpr);

			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, String name, String number, double remain,String [] tokensExpr) throws Exception{
		
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);

		checkNameOfRetailStoreMemberGiftCard(userContext,  name, exception);
		checkNumberOfRetailStoreMemberGiftCard(userContext,  number, exception);
		checkRemainOfRetailStoreMemberGiftCard(userContext,  remain, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreMember addRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, String name, String number, double remain, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMemberGiftCard(userContext,retailStoreMemberId,name, number, remain,tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createRetailStoreMemberGiftCard(userContext,name, number, remain);
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberGiftCard( retailStoreMemberGiftCard );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailScmUserContext userContext, String name, String number, double remain) throws Exception{

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		
		
		retailStoreMemberGiftCard.setName(name);		
		retailStoreMemberGiftCard.setNumber(number);		
		retailStoreMemberGiftCard.setRemain(remain);
	
		
		return retailStoreMemberGiftCard;
	
		
	}
	
	protected RetailStoreMemberGiftCard createIndexedRetailStoreMemberGiftCard(String id, int version){

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		retailStoreMemberGiftCard.setId(id);
		retailStoreMemberGiftCard.setVersion(version);
		return retailStoreMemberGiftCard;			
		
	}
	protected void checkParamsForRemovingRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		checkVersionOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember removeRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		checkVersionOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreMember copyRetailStoreMemberGiftCardFrom(RetailScmUserContext userContext, String retailStoreMemberId, 
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.copyRetailStoreMemberGiftCardFrom( retailStoreMemberGiftCard );		
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreMemberManagerException exception = new RetailStoreMemberManagerException("Error Occured");
		
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkIdOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardId, exception);
		checkVersionOfRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCardVersion, exception);
		

		if(RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreMemberGiftCard(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)){
			checkNumberOfRetailStoreMemberGiftCard(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)){
			checkRemainOfRetailStoreMemberGiftCard(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreMember updateRetailStoreMemberGiftCard(RetailScmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		
		synchronized(retailStoreMember){ 
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );	
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCard retailStoreMemberGiftCardIndex = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		
			RetailStoreMemberGiftCard retailStoreMemberGiftCard = retailStoreMember.findTheRetailStoreMemberGiftCard(retailStoreMemberGiftCardIndex);
			if(retailStoreMemberGiftCard == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberGiftCard+"Not found" );
			}
			
			retailStoreMemberGiftCard.changePropery(property, newValueExpr);

			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


