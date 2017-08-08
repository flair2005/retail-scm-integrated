
package com.skynet.retailscm.retailstoremember;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.skynet.retailscm.memberwishlist.MemberWishlist;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPoint;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;

import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCouponDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.consumerorder.ConsumerOrderDAO;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionDAO;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPointDAO;
import com.skynet.retailscm.memberwishlist.MemberWishlistDAO;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddressDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.consumerorder.ConsumerOrderTable;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPointTable;
import com.skynet.retailscm.memberwishlist.MemberWishlistTable;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddressTable;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTable;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCouponTable;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreMemberJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreMemberDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  ConsumerOrderDAO  consumerOrderDAO;
 	public void setConsumerOrderDAO(ConsumerOrderDAO pConsumerOrderDAO){
 	
 		if(pConsumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = pConsumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The consumerOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderDAO;
 	}	
 	
			
		
	
  	private  RetailStoreMemberCouponDAO  retailStoreMemberCouponDAO;
 	public void setRetailStoreMemberCouponDAO(RetailStoreMemberCouponDAO pRetailStoreMemberCouponDAO){
 	
 		if(pRetailStoreMemberCouponDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberCouponDAO to null.");
 		}
	 	this.retailStoreMemberCouponDAO = pRetailStoreMemberCouponDAO;
 	}
 	public RetailStoreMemberCouponDAO getRetailStoreMemberCouponDAO(){
 		if(this.retailStoreMemberCouponDAO == null){
 			throw new IllegalStateException("The retailStoreMemberCouponDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberCouponDAO;
 	}	
 	
			
		
	
  	private  MemberWishlistDAO  memberWishlistDAO;
 	public void setMemberWishlistDAO(MemberWishlistDAO pMemberWishlistDAO){
 	
 		if(pMemberWishlistDAO == null){
 			throw new IllegalStateException("Do not try to set memberWishlistDAO to null.");
 		}
	 	this.memberWishlistDAO = pMemberWishlistDAO;
 	}
 	public MemberWishlistDAO getMemberWishlistDAO(){
 		if(this.memberWishlistDAO == null){
 			throw new IllegalStateException("The memberWishlistDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberWishlistDAO;
 	}	
 	
			
		
	
  	private  MemberRewardPointDAO  memberRewardPointDAO;
 	public void setMemberRewardPointDAO(MemberRewardPointDAO pMemberRewardPointDAO){
 	
 		if(pMemberRewardPointDAO == null){
 			throw new IllegalStateException("Do not try to set memberRewardPointDAO to null.");
 		}
	 	this.memberRewardPointDAO = pMemberRewardPointDAO;
 	}
 	public MemberRewardPointDAO getMemberRewardPointDAO(){
 		if(this.memberRewardPointDAO == null){
 			throw new IllegalStateException("The memberRewardPointDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberRewardPointDAO;
 	}	
 	
			
		
	
  	private  MemberRewardPointRedemptionDAO  memberRewardPointRedemptionDAO;
 	public void setMemberRewardPointRedemptionDAO(MemberRewardPointRedemptionDAO pMemberRewardPointRedemptionDAO){
 	
 		if(pMemberRewardPointRedemptionDAO == null){
 			throw new IllegalStateException("Do not try to set memberRewardPointRedemptionDAO to null.");
 		}
	 	this.memberRewardPointRedemptionDAO = pMemberRewardPointRedemptionDAO;
 	}
 	public MemberRewardPointRedemptionDAO getMemberRewardPointRedemptionDAO(){
 		if(this.memberRewardPointRedemptionDAO == null){
 			throw new IllegalStateException("The memberRewardPointRedemptionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberRewardPointRedemptionDAO;
 	}	
 	
			
		
	
  	private  RetailStoreMemberAddressDAO  retailStoreMemberAddressDAO;
 	public void setRetailStoreMemberAddressDAO(RetailStoreMemberAddressDAO pRetailStoreMemberAddressDAO){
 	
 		if(pRetailStoreMemberAddressDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberAddressDAO to null.");
 		}
	 	this.retailStoreMemberAddressDAO = pRetailStoreMemberAddressDAO;
 	}
 	public RetailStoreMemberAddressDAO getRetailStoreMemberAddressDAO(){
 		if(this.retailStoreMemberAddressDAO == null){
 			throw new IllegalStateException("The retailStoreMemberAddressDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberAddressDAO;
 	}	
 	
			
		
	
  	private  RetailStoreMemberGiftCardDAO  retailStoreMemberGiftCardDAO;
 	public void setRetailStoreMemberGiftCardDAO(RetailStoreMemberGiftCardDAO pRetailStoreMemberGiftCardDAO){
 	
 		if(pRetailStoreMemberGiftCardDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardDAO to null.");
 		}
	 	this.retailStoreMemberGiftCardDAO = pRetailStoreMemberGiftCardDAO;
 	}
 	public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO(){
 		if(this.retailStoreMemberGiftCardDAO == null){
 			throw new IllegalStateException("The retailStoreMemberGiftCardDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberGiftCardDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreMember load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMember(accessKey, options);
	}
	*/
	public RetailStoreMember load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMember(RetailStoreMemberTable.withId(id), options);
	}
	
	
	
	public RetailStoreMember save(RetailStoreMember retailStoreMember,Map<String,Object> options){
		
		String methodName="save(RetailStoreMember retailStoreMember,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreMember, methodName, "retailStoreMember");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreMember(retailStoreMember,options);
	}
	public RetailStoreMember clone(String retailStoreMemberId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreMemberTable.withId(retailStoreMemberId),options);
	}
	
	protected RetailStoreMember clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreMemberId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreMember newRetailStoreMember = loadInternalRetailStoreMember(accessKey, options);
		newRetailStoreMember.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newRetailStoreMember.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreMemberCouponListEnabled(options)){
 			for(RetailStoreMemberCoupon item: newRetailStoreMember.getRetailStoreMemberCouponList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveMemberWishlistListEnabled(options)){
 			for(MemberWishlist item: newRetailStoreMember.getMemberWishlistList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveMemberRewardPointListEnabled(options)){
 			for(MemberRewardPoint item: newRetailStoreMember.getMemberRewardPointList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveMemberRewardPointRedemptionListEnabled(options)){
 			for(MemberRewardPointRedemption item: newRetailStoreMember.getMemberRewardPointRedemptionList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreMemberAddressListEnabled(options)){
 			for(RetailStoreMemberAddress item: newRetailStoreMember.getRetailStoreMemberAddressList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreMemberGiftCardListEnabled(options)){
 			for(RetailStoreMemberGiftCard item: newRetailStoreMember.getRetailStoreMemberGiftCardList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreMember(newRetailStoreMember,options);
		
		return newRetailStoreMember;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreMemberId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreMemberId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreMemberVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreMemberId, int version) throws Exception{
	
		String methodName="delete(String retailStoreMemberId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberId, methodName, "retailStoreMemberId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","mobile_phone","owner"};
		return RetailStoreMemberTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_member";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreMemberTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_MEMBER_COUPON_LIST = "retailStoreMemberCouponList";
	
	protected boolean isExtractRetailStoreMemberCouponListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberTokens.RETAIL_STORE_MEMBER_COUPON_LIST);
		
 	}

	protected boolean isSaveRetailStoreMemberCouponListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.RETAIL_STORE_MEMBER_COUPON_LIST);
		
 	}
 	
 	
			
		
	//protected static final String MEMBER_WISHLIST_LIST = "memberWishlistList";
	
	protected boolean isExtractMemberWishlistListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberTokens.MEMBER_WISHLIST_LIST);
		
 	}

	protected boolean isSaveMemberWishlistListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.MEMBER_WISHLIST_LIST);
		
 	}
 	
 	
			
		
	//protected static final String MEMBER_REWARD_POINT_LIST = "memberRewardPointList";
	
	protected boolean isExtractMemberRewardPointListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberTokens.MEMBER_REWARD_POINT_LIST);
		
 	}

	protected boolean isSaveMemberRewardPointListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.MEMBER_REWARD_POINT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String MEMBER_REWARD_POINT_REDEMPTION_LIST = "memberRewardPointRedemptionList";
	
	protected boolean isExtractMemberRewardPointRedemptionListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberTokens.MEMBER_REWARD_POINT_REDEMPTION_LIST);
		
 	}

	protected boolean isSaveMemberRewardPointRedemptionListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.MEMBER_REWARD_POINT_REDEMPTION_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_MEMBER_ADDRESS_LIST = "retailStoreMemberAddressList";
	
	protected boolean isExtractRetailStoreMemberAddressListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberTokens.RETAIL_STORE_MEMBER_ADDRESS_LIST);
		
 	}

	protected boolean isSaveRetailStoreMemberAddressListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.RETAIL_STORE_MEMBER_ADDRESS_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_LIST = "retailStoreMemberGiftCardList";
	
	protected boolean isExtractRetailStoreMemberGiftCardListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberTokens.RETAIL_STORE_MEMBER_GIFT_CARD_LIST);
		
 	}

	protected boolean isSaveRetailStoreMemberGiftCardListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.RETAIL_STORE_MEMBER_GIFT_CARD_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreMemberMapper getRetailStoreMemberMapper(){
		return new RetailStoreMemberMapper();
	}
	protected RetailStoreMember extractRetailStoreMember(String retailStoreMemberId) throws Exception{
		String SQL = "select * from retail_store_member_data where id = ?";	
		try{
		
			RetailStoreMember retailStoreMember = queryForObject(SQL, new Object[]{retailStoreMemberId}, getRetailStoreMemberMapper());
			return retailStoreMember;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberNotFoundException("RetailStoreMember("+retailStoreMemberId+") is not found!");
		}
		
		
	}
	protected RetailStoreMember extractRetailStoreMember(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_member_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreMember retailStoreMember = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreMemberMapper());
			return retailStoreMember;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberNotFoundException("RetailStoreMember("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreMember loadInternalRetailStoreMember(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreMember retailStoreMember = extractRetailStoreMember(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMember, loadOptions);
 		}
 
		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(retailStoreMember, loadOptions);
 		}		
		
		if(isExtractRetailStoreMemberCouponListEnabled(loadOptions)){
	 		extractRetailStoreMemberCouponList(retailStoreMember, loadOptions);
 		}		
		
		if(isExtractMemberWishlistListEnabled(loadOptions)){
	 		extractMemberWishlistList(retailStoreMember, loadOptions);
 		}		
		
		if(isExtractMemberRewardPointListEnabled(loadOptions)){
	 		extractMemberRewardPointList(retailStoreMember, loadOptions);
 		}		
		
		if(isExtractMemberRewardPointRedemptionListEnabled(loadOptions)){
	 		extractMemberRewardPointRedemptionList(retailStoreMember, loadOptions);
 		}		
		
		if(isExtractRetailStoreMemberAddressListEnabled(loadOptions)){
	 		extractRetailStoreMemberAddressList(retailStoreMember, loadOptions);
 		}		
		
		if(isExtractRetailStoreMemberGiftCardListEnabled(loadOptions)){
	 		extractRetailStoreMemberGiftCardList(retailStoreMember, loadOptions);
 		}		
		
		return retailStoreMember;
		
	}



	
	
	 

 	protected RetailStoreMember extractOwner(RetailStoreMember retailStoreMember, Map<String,Object> options) throws Exception{

		if(retailStoreMember.getOwner() == null){
			return retailStoreMember;
		}
		String ownerId = retailStoreMember.getOwner().getId();
		if( ownerId == null){
			return retailStoreMember;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMember.setOwner(owner);
		}
		
 		
 		return retailStoreMember;
 	}
 		
 
		
	protected RetailStoreMember extractConsumerOrderList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByConsumer(retailStoreMember.getId(),options);
		if(consumerOrderList != null){
			retailStoreMember.setConsumerOrderList(consumerOrderList);
		}
		
		return retailStoreMember;
	
	}	
		
	protected RetailStoreMember extractRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = getRetailStoreMemberCouponDAO().findRetailStoreMemberCouponByOwner(retailStoreMember.getId(),options);
		if(retailStoreMemberCouponList != null){
			retailStoreMember.setRetailStoreMemberCouponList(retailStoreMemberCouponList);
		}
		
		return retailStoreMember;
	
	}	
		
	protected RetailStoreMember extractMemberWishlistList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		SmartList<MemberWishlist> memberWishlistList = getMemberWishlistDAO().findMemberWishlistByOwner(retailStoreMember.getId(),options);
		if(memberWishlistList != null){
			retailStoreMember.setMemberWishlistList(memberWishlistList);
		}
		
		return retailStoreMember;
	
	}	
		
	protected RetailStoreMember extractMemberRewardPointList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		SmartList<MemberRewardPoint> memberRewardPointList = getMemberRewardPointDAO().findMemberRewardPointByOwner(retailStoreMember.getId(),options);
		if(memberRewardPointList != null){
			retailStoreMember.setMemberRewardPointList(memberRewardPointList);
		}
		
		return retailStoreMember;
	
	}	
		
	protected RetailStoreMember extractMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = getMemberRewardPointRedemptionDAO().findMemberRewardPointRedemptionByOwner(retailStoreMember.getId(),options);
		if(memberRewardPointRedemptionList != null){
			retailStoreMember.setMemberRewardPointRedemptionList(memberRewardPointRedemptionList);
		}
		
		return retailStoreMember;
	
	}	
		
	protected RetailStoreMember extractRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = getRetailStoreMemberAddressDAO().findRetailStoreMemberAddressByOwner(retailStoreMember.getId(),options);
		if(retailStoreMemberAddressList != null){
			retailStoreMember.setRetailStoreMemberAddressList(retailStoreMemberAddressList);
		}
		
		return retailStoreMember;
	
	}	
		
	protected RetailStoreMember extractRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = getRetailStoreMemberGiftCardDAO().findRetailStoreMemberGiftCardByOwner(retailStoreMember.getId(),options);
		if(retailStoreMemberGiftCardList != null){
			retailStoreMember.setRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList);
		}
		
		return retailStoreMember;
	
	}	
		
		
  	
 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<RetailStoreMember> retailStoreMemberList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getRetailStoreMemberMapper());	
 		return retailStoreMemberList;
 	}
 	
 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreMember> retailStoreMemberList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getRetailStoreMemberMapper());
		
 		return retailStoreMemberList;
 	}
 	
 	public int countRetailStoreMemberByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreMember saveRetailStoreMember(RetailStoreMember  retailStoreMember){
	
		String SQL=this.getSaveRetailStoreMemberSQL(retailStoreMember);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberParameters(retailStoreMember);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreMember.incVersion();
		return retailStoreMember;
	
	}
	public SmartList<RetailStoreMember> saveRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberList(retailStoreMemberList);
		
		batchRetailStoreMemberCreate((List<RetailStoreMember>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreMemberUpdate((List<RetailStoreMember>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreMember retailStoreMember:retailStoreMemberList){
			if(retailStoreMember.isChanged()){
				retailStoreMember.incVersion();
			}
			
		
		}
		
		
		return retailStoreMemberList;
	}

	public SmartList<RetailStoreMember> removeRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options){
		
		
		super.removeList(retailStoreMemberList, options);
		
		return retailStoreMemberList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreMemberBatchCreateArgs(List<RetailStoreMember> retailStoreMemberList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMember retailStoreMember:retailStoreMemberList ){
			Object [] parameters = prepareRetailStoreMemberCreateParameters(retailStoreMember);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreMemberBatchUpdateArgs(List<RetailStoreMember> retailStoreMemberList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMember retailStoreMember:retailStoreMemberList ){
			if(!retailStoreMember.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberUpdateParameters(retailStoreMember);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreMemberCreate(List<RetailStoreMember> retailStoreMemberList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberBatchCreateArgs(retailStoreMemberList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreMemberUpdate(List<RetailStoreMember> retailStoreMemberList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberBatchUpdateArgs(retailStoreMemberList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreMemberList(List<RetailStoreMember> retailStoreMemberList){
		
		List<RetailStoreMember> retailStoreMemberCreateList=new ArrayList<RetailStoreMember>();
		List<RetailStoreMember> retailStoreMemberUpdateList=new ArrayList<RetailStoreMember>();
		
		for(RetailStoreMember retailStoreMember: retailStoreMemberList){
			if(isUpdateRequest(retailStoreMember)){
				retailStoreMemberUpdateList.add( retailStoreMember);
				continue;
			}
			retailStoreMemberCreateList.add(retailStoreMember);
		}
		
		return new Object[]{retailStoreMemberCreateList,retailStoreMemberUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreMember retailStoreMember){
 		return retailStoreMember.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberSQL(RetailStoreMember retailStoreMember){
 		if(isUpdateRequest(retailStoreMember)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreMemberParameters(RetailStoreMember retailStoreMember){
 		if(isUpdateRequest(retailStoreMember) ){
 			return prepareRetailStoreMemberUpdateParameters(retailStoreMember);
 		}
 		return prepareRetailStoreMemberCreateParameters(retailStoreMember);
 	}
 	protected Object[] prepareRetailStoreMemberUpdateParameters(RetailStoreMember retailStoreMember){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreMember.getName();
 		parameters[1] = retailStoreMember.getMobilePhone(); 	
 		if(retailStoreMember.getOwner() != null){
 			parameters[2] = retailStoreMember.getOwner().getId();
 		}
 		
 		parameters[3] = retailStoreMember.getId();
 		parameters[4] = retailStoreMember.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberCreateParameters(RetailStoreMember retailStoreMember){
		Object[] parameters = new Object[4];
		String newRetailStoreMemberId=getNextId();
		retailStoreMember.setId(newRetailStoreMemberId);
		parameters[0] =  retailStoreMember.getId();
 
 		parameters[1] = retailStoreMember.getName();
 		parameters[2] = retailStoreMember.getMobilePhone(); 	
 		if(retailStoreMember.getOwner() != null){
 			parameters[3] = retailStoreMember.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreMember saveInternalRetailStoreMember(RetailStoreMember retailStoreMember, Map<String,Object> options){
		
		saveRetailStoreMember(retailStoreMember);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMember, options);
 		}
 
		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(retailStoreMember, options);
	 		removeConsumerOrderList(retailStoreMember, options);
	 		
 		}		
		
		if(isSaveRetailStoreMemberCouponListEnabled(options)){
	 		saveRetailStoreMemberCouponList(retailStoreMember, options);
	 		removeRetailStoreMemberCouponList(retailStoreMember, options);
	 		
 		}		
		
		if(isSaveMemberWishlistListEnabled(options)){
	 		saveMemberWishlistList(retailStoreMember, options);
	 		removeMemberWishlistList(retailStoreMember, options);
	 		
 		}		
		
		if(isSaveMemberRewardPointListEnabled(options)){
	 		saveMemberRewardPointList(retailStoreMember, options);
	 		removeMemberRewardPointList(retailStoreMember, options);
	 		
 		}		
		
		if(isSaveMemberRewardPointRedemptionListEnabled(options)){
	 		saveMemberRewardPointRedemptionList(retailStoreMember, options);
	 		removeMemberRewardPointRedemptionList(retailStoreMember, options);
	 		
 		}		
		
		if(isSaveRetailStoreMemberAddressListEnabled(options)){
	 		saveRetailStoreMemberAddressList(retailStoreMember, options);
	 		removeRetailStoreMemberAddressList(retailStoreMember, options);
	 		
 		}		
		
		if(isSaveRetailStoreMemberGiftCardListEnabled(options)){
	 		saveRetailStoreMemberGiftCardList(retailStoreMember, options);
	 		removeRetailStoreMemberGiftCardList(retailStoreMember, options);
	 		
 		}		
		
		return retailStoreMember;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreMember saveOwner(RetailStoreMember retailStoreMember, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMember.getOwner() == null){
 			return retailStoreMember;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(retailStoreMember.getOwner(),options);
 		return retailStoreMember;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected RetailStoreMember saveConsumerOrderList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		if(consumerOrderList == null){
			return retailStoreMember;
		}
		if(consumerOrderList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderDAO().saveConsumerOrderList(consumerOrderList,options);
		
		return retailStoreMember;
	
	}
	
	protected RetailStoreMember removeConsumerOrderList(RetailStoreMember retailStoreMember, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		if(consumerOrderList == null){
			return retailStoreMember;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return retailStoreMember;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return retailStoreMember;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreMember saveRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
		if(retailStoreMemberCouponList == null){
			return retailStoreMember;
		}
		if(retailStoreMemberCouponList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreMemberCouponDAO().saveRetailStoreMemberCouponList(retailStoreMemberCouponList,options);
		
		return retailStoreMember;
	
	}
	
	protected RetailStoreMember removeRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, Map<String,Object> options){
	
	
		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
		if(retailStoreMemberCouponList == null){
			return retailStoreMember;
		}	
	
		SmartList<RetailStoreMemberCoupon> toRemoveRetailStoreMemberCouponList = retailStoreMemberCouponList.getToRemoveList();
		
		if(toRemoveRetailStoreMemberCouponList == null){
			return retailStoreMember;
		}
		if(toRemoveRetailStoreMemberCouponList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreMemberCouponDAO().removeRetailStoreMemberCouponList(toRemoveRetailStoreMemberCouponList,options);
		
		return retailStoreMember;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreMember saveMemberWishlistList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
		if(memberWishlistList == null){
			return retailStoreMember;
		}
		if(memberWishlistList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getMemberWishlistDAO().saveMemberWishlistList(memberWishlistList,options);
		
		return retailStoreMember;
	
	}
	
	protected RetailStoreMember removeMemberWishlistList(RetailStoreMember retailStoreMember, Map<String,Object> options){
	
	
		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
		if(memberWishlistList == null){
			return retailStoreMember;
		}	
	
		SmartList<MemberWishlist> toRemoveMemberWishlistList = memberWishlistList.getToRemoveList();
		
		if(toRemoveMemberWishlistList == null){
			return retailStoreMember;
		}
		if(toRemoveMemberWishlistList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMemberWishlistDAO().removeMemberWishlistList(toRemoveMemberWishlistList,options);
		
		return retailStoreMember;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreMember saveMemberRewardPointList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
		if(memberRewardPointList == null){
			return retailStoreMember;
		}
		if(memberRewardPointList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getMemberRewardPointDAO().saveMemberRewardPointList(memberRewardPointList,options);
		
		return retailStoreMember;
	
	}
	
	protected RetailStoreMember removeMemberRewardPointList(RetailStoreMember retailStoreMember, Map<String,Object> options){
	
	
		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
		if(memberRewardPointList == null){
			return retailStoreMember;
		}	
	
		SmartList<MemberRewardPoint> toRemoveMemberRewardPointList = memberRewardPointList.getToRemoveList();
		
		if(toRemoveMemberRewardPointList == null){
			return retailStoreMember;
		}
		if(toRemoveMemberRewardPointList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMemberRewardPointDAO().removeMemberRewardPointList(toRemoveMemberRewardPointList,options);
		
		return retailStoreMember;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreMember saveMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
		if(memberRewardPointRedemptionList == null){
			return retailStoreMember;
		}
		if(memberRewardPointRedemptionList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getMemberRewardPointRedemptionDAO().saveMemberRewardPointRedemptionList(memberRewardPointRedemptionList,options);
		
		return retailStoreMember;
	
	}
	
	protected RetailStoreMember removeMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, Map<String,Object> options){
	
	
		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
		if(memberRewardPointRedemptionList == null){
			return retailStoreMember;
		}	
	
		SmartList<MemberRewardPointRedemption> toRemoveMemberRewardPointRedemptionList = memberRewardPointRedemptionList.getToRemoveList();
		
		if(toRemoveMemberRewardPointRedemptionList == null){
			return retailStoreMember;
		}
		if(toRemoveMemberRewardPointRedemptionList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMemberRewardPointRedemptionDAO().removeMemberRewardPointRedemptionList(toRemoveMemberRewardPointRedemptionList,options);
		
		return retailStoreMember;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreMember saveRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
		if(retailStoreMemberAddressList == null){
			return retailStoreMember;
		}
		if(retailStoreMemberAddressList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreMemberAddressDAO().saveRetailStoreMemberAddressList(retailStoreMemberAddressList,options);
		
		return retailStoreMember;
	
	}
	
	protected RetailStoreMember removeRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, Map<String,Object> options){
	
	
		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
		if(retailStoreMemberAddressList == null){
			return retailStoreMember;
		}	
	
		SmartList<RetailStoreMemberAddress> toRemoveRetailStoreMemberAddressList = retailStoreMemberAddressList.getToRemoveList();
		
		if(toRemoveRetailStoreMemberAddressList == null){
			return retailStoreMember;
		}
		if(toRemoveRetailStoreMemberAddressList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreMemberAddressDAO().removeRetailStoreMemberAddressList(toRemoveRetailStoreMemberAddressList,options);
		
		return retailStoreMember;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreMember saveRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, Map<String,Object> options){
		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
		if(retailStoreMemberGiftCardList == null){
			return retailStoreMember;
		}
		if(retailStoreMemberGiftCardList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreMemberGiftCardDAO().saveRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList,options);
		
		return retailStoreMember;
	
	}
	
	protected RetailStoreMember removeRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, Map<String,Object> options){
	
	
		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
		if(retailStoreMemberGiftCardList == null){
			return retailStoreMember;
		}	
	
		SmartList<RetailStoreMemberGiftCard> toRemoveRetailStoreMemberGiftCardList = retailStoreMemberGiftCardList.getToRemoveList();
		
		if(toRemoveRetailStoreMemberGiftCardList == null){
			return retailStoreMember;
		}
		if(toRemoveRetailStoreMemberGiftCardList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreMemberGiftCardDAO().removeRetailStoreMemberGiftCardList(toRemoveRetailStoreMemberGiftCardList,options);
		
		return retailStoreMember;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreMember present(RetailStoreMember retailStoreMember,Map<String, Object> options){
	
		presentConsumerOrderList(retailStoreMember,options);
		presentRetailStoreMemberCouponList(retailStoreMember,options);
		presentMemberWishlistList(retailStoreMember,options);
		presentMemberRewardPointList(retailStoreMember,options);
		presentMemberRewardPointRedemptionList(retailStoreMember,options);
		presentRetailStoreMemberAddressList(retailStoreMember,options);
		presentRetailStoreMemberGiftCardList(retailStoreMember,options);

		return retailStoreMember;
	
	}
		
	
  	
 	protected RetailStoreMember presentConsumerOrderList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();		
		if(consumerOrderList == null){
			return retailStoreMember;			
		}
		
		String targetObjectName = "consumerOrder";
		int consumerOrderListSize = consumerOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMember;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderListSize;
		if(consumerOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderDAO().countConsumerOrderByConsumer(retailStoreMember.getId(), options);			
		}
		//retailStoreMember.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMember.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderListSize,currentPage,rowsPerPage) ;
			consumerOrderList = consumerOrderList.subListOf(fromIndex, toIndex);
			consumerOrderList.setTotalCount(count);
			consumerOrderList.setCurrentPageNumber(currentPage);			
			retailStoreMember.setConsumerOrderList(consumerOrderList);
			return retailStoreMember;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderList 
			= getConsumerOrderDAO().findConsumerOrderByConsumer(retailStoreMember.getId(),start, rowsPerPage, options );
		consumerOrderList.setTotalCount(count);
		consumerOrderList.setCurrentPageNumber(currentPage);
		retailStoreMember.setConsumerOrderList(consumerOrderList );	

		return retailStoreMember;
	}			
		
	
  	
 	protected RetailStoreMember presentRetailStoreMemberCouponList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {

		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();		
		if(retailStoreMemberCouponList == null){
			return retailStoreMember;			
		}
		
		String targetObjectName = "retailStoreMemberCoupon";
		int retailStoreMemberCouponListSize = retailStoreMemberCouponList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreMemberCouponListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMember;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreMemberCouponListSize;
		if(retailStoreMemberCouponListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreMemberCouponDAO().countRetailStoreMemberCouponByOwner(retailStoreMember.getId(), options);			
		}
		//retailStoreMember.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMember.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreMemberCouponListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreMemberCouponListSize,currentPage,rowsPerPage) ;
			retailStoreMemberCouponList = retailStoreMemberCouponList.subListOf(fromIndex, toIndex);
			retailStoreMemberCouponList.setTotalCount(count);
			retailStoreMemberCouponList.setCurrentPageNumber(currentPage);			
			retailStoreMember.setRetailStoreMemberCouponList(retailStoreMemberCouponList);
			return retailStoreMember;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreMemberCouponList 
			= getRetailStoreMemberCouponDAO().findRetailStoreMemberCouponByOwner(retailStoreMember.getId(),start, rowsPerPage, options );
		retailStoreMemberCouponList.setTotalCount(count);
		retailStoreMemberCouponList.setCurrentPageNumber(currentPage);
		retailStoreMember.setRetailStoreMemberCouponList(retailStoreMemberCouponList );	

		return retailStoreMember;
	}			
		
	
  	
 	protected RetailStoreMember presentMemberWishlistList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {

		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();		
		if(memberWishlistList == null){
			return retailStoreMember;			
		}
		
		String targetObjectName = "memberWishlist";
		int memberWishlistListSize = memberWishlistList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(memberWishlistListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMember;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = memberWishlistListSize;
		if(memberWishlistListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getMemberWishlistDAO().countMemberWishlistByOwner(retailStoreMember.getId(), options);			
		}
		//retailStoreMember.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMember.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(memberWishlistListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(memberWishlistListSize,currentPage,rowsPerPage) ;
			memberWishlistList = memberWishlistList.subListOf(fromIndex, toIndex);
			memberWishlistList.setTotalCount(count);
			memberWishlistList.setCurrentPageNumber(currentPage);			
			retailStoreMember.setMemberWishlistList(memberWishlistList);
			return retailStoreMember;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		memberWishlistList 
			= getMemberWishlistDAO().findMemberWishlistByOwner(retailStoreMember.getId(),start, rowsPerPage, options );
		memberWishlistList.setTotalCount(count);
		memberWishlistList.setCurrentPageNumber(currentPage);
		retailStoreMember.setMemberWishlistList(memberWishlistList );	

		return retailStoreMember;
	}			
		
	
  	
 	protected RetailStoreMember presentMemberRewardPointList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {

		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();		
		if(memberRewardPointList == null){
			return retailStoreMember;			
		}
		
		String targetObjectName = "memberRewardPoint";
		int memberRewardPointListSize = memberRewardPointList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(memberRewardPointListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMember;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = memberRewardPointListSize;
		if(memberRewardPointListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getMemberRewardPointDAO().countMemberRewardPointByOwner(retailStoreMember.getId(), options);			
		}
		//retailStoreMember.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMember.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(memberRewardPointListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(memberRewardPointListSize,currentPage,rowsPerPage) ;
			memberRewardPointList = memberRewardPointList.subListOf(fromIndex, toIndex);
			memberRewardPointList.setTotalCount(count);
			memberRewardPointList.setCurrentPageNumber(currentPage);			
			retailStoreMember.setMemberRewardPointList(memberRewardPointList);
			return retailStoreMember;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		memberRewardPointList 
			= getMemberRewardPointDAO().findMemberRewardPointByOwner(retailStoreMember.getId(),start, rowsPerPage, options );
		memberRewardPointList.setTotalCount(count);
		memberRewardPointList.setCurrentPageNumber(currentPage);
		retailStoreMember.setMemberRewardPointList(memberRewardPointList );	

		return retailStoreMember;
	}			
		
	
  	
 	protected RetailStoreMember presentMemberRewardPointRedemptionList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {

		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();		
		if(memberRewardPointRedemptionList == null){
			return retailStoreMember;			
		}
		
		String targetObjectName = "memberRewardPointRedemption";
		int memberRewardPointRedemptionListSize = memberRewardPointRedemptionList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(memberRewardPointRedemptionListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMember;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = memberRewardPointRedemptionListSize;
		if(memberRewardPointRedemptionListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getMemberRewardPointRedemptionDAO().countMemberRewardPointRedemptionByOwner(retailStoreMember.getId(), options);			
		}
		//retailStoreMember.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMember.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(memberRewardPointRedemptionListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(memberRewardPointRedemptionListSize,currentPage,rowsPerPage) ;
			memberRewardPointRedemptionList = memberRewardPointRedemptionList.subListOf(fromIndex, toIndex);
			memberRewardPointRedemptionList.setTotalCount(count);
			memberRewardPointRedemptionList.setCurrentPageNumber(currentPage);			
			retailStoreMember.setMemberRewardPointRedemptionList(memberRewardPointRedemptionList);
			return retailStoreMember;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		memberRewardPointRedemptionList 
			= getMemberRewardPointRedemptionDAO().findMemberRewardPointRedemptionByOwner(retailStoreMember.getId(),start, rowsPerPage, options );
		memberRewardPointRedemptionList.setTotalCount(count);
		memberRewardPointRedemptionList.setCurrentPageNumber(currentPage);
		retailStoreMember.setMemberRewardPointRedemptionList(memberRewardPointRedemptionList );	

		return retailStoreMember;
	}			
		
	
  	
 	protected RetailStoreMember presentRetailStoreMemberAddressList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {

		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();		
		if(retailStoreMemberAddressList == null){
			return retailStoreMember;			
		}
		
		String targetObjectName = "retailStoreMemberAddress";
		int retailStoreMemberAddressListSize = retailStoreMemberAddressList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreMemberAddressListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMember;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreMemberAddressListSize;
		if(retailStoreMemberAddressListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreMemberAddressDAO().countRetailStoreMemberAddressByOwner(retailStoreMember.getId(), options);			
		}
		//retailStoreMember.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMember.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreMemberAddressListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreMemberAddressListSize,currentPage,rowsPerPage) ;
			retailStoreMemberAddressList = retailStoreMemberAddressList.subListOf(fromIndex, toIndex);
			retailStoreMemberAddressList.setTotalCount(count);
			retailStoreMemberAddressList.setCurrentPageNumber(currentPage);			
			retailStoreMember.setRetailStoreMemberAddressList(retailStoreMemberAddressList);
			return retailStoreMember;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreMemberAddressList 
			= getRetailStoreMemberAddressDAO().findRetailStoreMemberAddressByOwner(retailStoreMember.getId(),start, rowsPerPage, options );
		retailStoreMemberAddressList.setTotalCount(count);
		retailStoreMemberAddressList.setCurrentPageNumber(currentPage);
		retailStoreMember.setRetailStoreMemberAddressList(retailStoreMemberAddressList );	

		return retailStoreMember;
	}			
		
	
  	
 	protected RetailStoreMember presentRetailStoreMemberGiftCardList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {

		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();		
		if(retailStoreMemberGiftCardList == null){
			return retailStoreMember;			
		}
		
		String targetObjectName = "retailStoreMemberGiftCard";
		int retailStoreMemberGiftCardListSize = retailStoreMemberGiftCardList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreMemberGiftCardListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMember;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreMemberGiftCardListSize;
		if(retailStoreMemberGiftCardListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreMemberGiftCardDAO().countRetailStoreMemberGiftCardByOwner(retailStoreMember.getId(), options);			
		}
		//retailStoreMember.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMember.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreMemberGiftCardListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreMemberGiftCardListSize,currentPage,rowsPerPage) ;
			retailStoreMemberGiftCardList = retailStoreMemberGiftCardList.subListOf(fromIndex, toIndex);
			retailStoreMemberGiftCardList.setTotalCount(count);
			retailStoreMemberGiftCardList.setCurrentPageNumber(currentPage);			
			retailStoreMember.setRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList);
			return retailStoreMember;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreMemberGiftCardList 
			= getRetailStoreMemberGiftCardDAO().findRetailStoreMemberGiftCardByOwner(retailStoreMember.getId(),start, rowsPerPage, options );
		retailStoreMemberGiftCardList.setTotalCount(count);
		retailStoreMemberGiftCardList.setCurrentPageNumber(currentPage);
		retailStoreMember.setRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList );	

		return retailStoreMember;
	}			
		


	protected String getTableName(){
		return RetailStoreMemberTable.TABLE_NAME;
	}
}


