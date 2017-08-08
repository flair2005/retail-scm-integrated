
package com.skynet.retailscm.retailstore;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreation;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosing;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.accountset.AccountSet;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpeningDAO;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosingDAO;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchisingDAO;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecorationDAO;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationDAO;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreationDAO;

import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.skynet.retailscm.truckdriver.TruckDriver;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreationTable;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosingTable;
import com.skynet.retailscm.transporttask.TransportTaskTable;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpeningTable;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecorationTable;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchisingTable;
import com.skynet.retailscm.consumerorder.ConsumerOrderTable;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationTable;
import com.skynet.retailscm.accountset.AccountSetTable;




public class RetailStoreManagerImpl extends RetailScmCheckerManager implements RetailStoreManager {
	
	private static final String SERVICE_TYPE = "RetailStore";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO  retailStoreDAO){
 	
 		if(retailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The RetailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}
 	
 	protected RetailStore saveRetailStore(RetailScmUserContext userContext, RetailStore retailStore, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreDAO().save(retailStore, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStore(userContext, retailStore, tokens);
 	}
 	
 	protected RetailStore saveRetailStoreDetail(RetailScmUserContext userContext, RetailStore retailStore) throws Exception{	

 		
 		return saveRetailStore(userContext, retailStore, allTokens());
 	}
 	
 	public RetailStore loadRetailStore(RetailScmUserContext userContext, String retailStoreId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStore, tokens);
 	}
 	
 	protected RetailStore present(RetailScmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStore,tokens);
		
		
		return this.getRetailStoreDAO().present(retailStore, tokens);
	}
 
 	
 	
 	public RetailStore loadRetailStoreDetail(RetailScmUserContext userContext, String retailStoreId) throws Exception{	
 		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, allTokens());

 		return present(userContext,retailStore, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreId) throws Exception{	
 		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, allTokens());

 		return present(userContext,retailStore, allTokens());
		
 	}
 	protected RetailStore saveRetailStore(RetailScmUserContext userContext, RetailStore retailStore, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreDAO().save(retailStore, tokens);
 	}
 	protected RetailStore loadRetailStore(RetailScmUserContext userContext, String retailStoreId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreDAO().load(retailStoreId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  RetailStoreFranchisingDAO  retailStoreFranchisingDAO;
 	public void setRetailStoreFranchisingDAO(RetailStoreFranchisingDAO retailStoreFranchisingDAO){
	 	this.retailStoreFranchisingDAO = retailStoreFranchisingDAO;
 	}
 	//------------------------------------
 	public RetailStoreFranchisingDAO getRetailStoreFranchisingDAO(){
	 	return this.retailStoreFranchisingDAO;
 	}
 
 	
 	private  RetailStoreDecorationDAO  retailStoreDecorationDAO;
 	public void setRetailStoreDecorationDAO(RetailStoreDecorationDAO retailStoreDecorationDAO){
	 	this.retailStoreDecorationDAO = retailStoreDecorationDAO;
 	}
 	//------------------------------------
 	public RetailStoreDecorationDAO getRetailStoreDecorationDAO(){
	 	return this.retailStoreDecorationDAO;
 	}
 
 	
 	private  RetailStoreClosingDAO  retailStoreClosingDAO;
 	public void setRetailStoreClosingDAO(RetailStoreClosingDAO retailStoreClosingDAO){
	 	this.retailStoreClosingDAO = retailStoreClosingDAO;
 	}
 	//------------------------------------
 	public RetailStoreClosingDAO getRetailStoreClosingDAO(){
	 	return this.retailStoreClosingDAO;
 	}
 
 	
 	private  RetailStoreCreationDAO  retailStoreCreationDAO;
 	public void setRetailStoreCreationDAO(RetailStoreCreationDAO retailStoreCreationDAO){
	 	this.retailStoreCreationDAO = retailStoreCreationDAO;
 	}
 	//------------------------------------
 	public RetailStoreCreationDAO getRetailStoreCreationDAO(){
	 	return this.retailStoreCreationDAO;
 	}
 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}
 
 	
 	private  RetailStoreInvestmentInvitationDAO  retailStoreInvestmentInvitationDAO;
 	public void setRetailStoreInvestmentInvitationDAO(RetailStoreInvestmentInvitationDAO retailStoreInvestmentInvitationDAO){
	 	this.retailStoreInvestmentInvitationDAO = retailStoreInvestmentInvitationDAO;
 	}
 	//------------------------------------
 	public RetailStoreInvestmentInvitationDAO getRetailStoreInvestmentInvitationDAO(){
	 	return this.retailStoreInvestmentInvitationDAO;
 	}
 
 	
 	private  RetailStoreOpeningDAO  retailStoreOpeningDAO;
 	public void setRetailStoreOpeningDAO(RetailStoreOpeningDAO retailStoreOpeningDAO){
	 	this.retailStoreOpeningDAO = retailStoreOpeningDAO;
 	}
 	//------------------------------------
 	public RetailStoreOpeningDAO getRetailStoreOpeningDAO(){
	 	return this.retailStoreOpeningDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){
		super.addActions(userContext, retailStore, tokens);
		
		addAction(userContext, retailStore, tokens,"@create","createRetailStore","createRetailStore/","main","primary");
		addAction(userContext, retailStore, tokens,"@update","updateRetailStore","updateRetailStore/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"@copy","cloneRetailStore","cloneRetailStore/"+retailStore.getId()+"/","main","primary");
		
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_retail_store_country_center","transferToAnotherRetailStoreCountryCenter","transferToAnotherRetailStoreCountryCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.create","create","create/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.inviteInvestment","inviteInvestment","inviteInvestment/"+retailStore.getId()+"/","main","success");
		addAction(userContext, retailStore, tokens,"retail_store.franchise","franchise","franchise/"+retailStore.getId()+"/","main","success");
		addAction(userContext, retailStore, tokens,"retail_store.decorate","decorate","decorate/"+retailStore.getId()+"/","main","info");
		addAction(userContext, retailStore, tokens,"retail_store.open","open","open/"+retailStore.getId()+"/","main","success");
		addAction(userContext, retailStore, tokens,"retail_store.close","close","close/"+retailStore.getId()+"/","main","danger");
		addAction(userContext, retailStore, tokens,"retail_store.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addGoods","addGoods","addGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeGoods","removeGoods","removeGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateGoods","updateGoods","updateGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addTransportTask","addTransportTask","addTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeTransportTask","removeTransportTask","removeTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateTransportTask","updateTransportTask","updateTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addAccountSet","addAccountSet","addAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeAccountSet","removeAccountSet","removeAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateAccountSet","updateAccountSet","updateAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+retailStore.getId()+"/","accountSetList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStore createRetailStore(RetailScmUserContext userContext,String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description
) throws Exception
	{
		
		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");

		

		checkNameOfRetailStore(userContext,  name, exception);
		checkTelephoneOfRetailStore(userContext,  telephone, exception);
		checkOwnerOfRetailStore(userContext,  owner, exception);
		checkFoundedOfRetailStore(userContext,  founded, exception);
		checkLatitudeOfRetailStore(userContext,  latitude, exception);
		checkLongitudeOfRetailStore(userContext,  longitude, exception);
		checkDescriptionOfRetailStore(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStore retailStore=createNewRetailStore();	

		retailStore.setName(name);
		retailStore.setTelephone(telephone);
		retailStore.setOwner(owner);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(retailStoreCountryCenterId,emptyOptions());
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(cityServiceCenterId,emptyOptions());
		retailStore.setCityServiceCenter(cityServiceCenter);
		retailStore.setFounded(founded);
		retailStore.setLatitude(latitude);
		retailStore.setLongitude(longitude);
		retailStore.setDescription(description);

		return saveRetailStore(userContext, retailStore, emptyOptions());
		

		
	}
	protected RetailStore createNewRetailStore() 
	{
		
		return new RetailStore();		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
			checkTelephoneOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStore.OWNER_PROPERTY.equals(property)){
			checkOwnerOfRetailStore(userContext, parseString(newValueExpr), exception);
		}		

				

		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStore(userContext, parseDate(newValueExpr), exception);
		}
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStore clone(RetailScmUserContext userContext, String fromRetailStoreId) throws Exception{
		
		return this.getRetailStoreDAO().clone(fromRetailStoreId, this.allTokens());
	}
	
	public RetailStore updateRetailStore(RetailScmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		if(retailStore.getVersion() != retailStoreVersion){
			String message = "The target version("+retailStore.getVersion()+") is not equals to version("+retailStoreVersion+") provided";
			throw new RetailStoreManagerException(message);
		}
		synchronized(retailStore){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			
			retailStore.changePropery(property, newValueExpr);
			retailStore = saveRetailStore(userContext, retailStore, tokens().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			//return saveRetailStore(userContext, retailStore, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreTokens tokens(){
		return RetailStoreTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={"CREATED","INVESTMENT_INVITED","FRANCHISED","DECORATED","OPENNED","CLOSED"};
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
	
	protected void checkParamsForTransferingAnotherRetailStoreCountryCenter(RetailScmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{
 		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
 		checkIdOfRetailStore(userContext, retailStoreId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherRetailStoreCountryCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStore transferToAnotherRetailStoreCountryCenter(RetailScmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStoreCountryCenter(userContext, retailStoreId,anotherRetailStoreCountryCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(anotherRetailStoreCountryCenterId, emptyOptions());		
			retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailScmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{
 		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
 		checkIdOfRetailStore(userContext, retailStoreId,exception);
 		checkIdOfRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStore transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, retailStoreId,anotherCityServiceCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(anotherCityServiceCenterId, emptyOptions());		
			retailStore.setCityServiceCenter(cityServiceCenter);		
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}

 	
 	
 	protected void checkParamsForCreation(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkCommentOfRetailStoreCreation(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStore create(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForCreation(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreCreation(userContext,retailStore);
 		

			retailStore.setCurrentStatus("CREATED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreCreation creation = createRetailStoreCreation(comment);		
			retailStore.setCreation(creation);		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withCreation().done());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	protected RetailStoreCreation createRetailStoreCreation(String comment){
 		RetailStoreCreation creation = new RetailStoreCreation(comment);
 		return getRetailStoreCreationDAO().save(creation,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreCreation(RetailScmUserContext userContext, RetailStore retailStore) throws Exception{
 		
 		
 		String currentStatus = retailStore.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CREATED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		if(!("CREATED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CREATED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		
 		RetailStoreCreation creation = retailStore.getCreation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = creation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( creation != null){
				throw new RetailStoreManagerException("The RetailStore("+retailStore.getId()+") has already been CREATED");
		}
 		
 		
 	}
	
 	protected void checkParamsForInvestmentInvitation(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkCommentOfRetailStoreInvestmentInvitation(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStore inviteInvestment(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForInvestmentInvitation(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreInvestmentInvitation(userContext,retailStore);
 		

			retailStore.setCurrentStatus("INVESTMENT_INVITED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreInvestmentInvitation investmentInvitation = createRetailStoreInvestmentInvitation(comment);		
			retailStore.setInvestmentInvitation(investmentInvitation);		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withInvestmentInvitation().done());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	protected RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(String comment){
 		RetailStoreInvestmentInvitation investmentInvitation = new RetailStoreInvestmentInvitation(comment);
 		return getRetailStoreInvestmentInvitationDAO().save(investmentInvitation,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreInvestmentInvitation(RetailScmUserContext userContext, RetailStore retailStore) throws Exception{
 		
 		
 		String currentStatus = retailStore.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'INVESTMENT_INVITED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		if(!("INVESTMENT_INVITED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'INVESTMENT_INVITED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		
 		RetailStoreInvestmentInvitation investmentInvitation = retailStore.getInvestmentInvitation();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = investmentInvitation 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( investmentInvitation != null){
				throw new RetailStoreManagerException("The RetailStore("+retailStore.getId()+") has already been INVESTMENT_INVITED");
		}
 		
 		
 	}
	
 	protected void checkParamsForFranchising(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkCommentOfRetailStoreFranchising(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStore franchise(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForFranchising(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreFranchising(userContext,retailStore);
 		

			retailStore.setCurrentStatus("FRANCHISED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreFranchising franchising = createRetailStoreFranchising(comment);		
			retailStore.setFranchising(franchising);		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withFranchising().done());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	protected RetailStoreFranchising createRetailStoreFranchising(String comment){
 		RetailStoreFranchising franchising = new RetailStoreFranchising(comment);
 		return getRetailStoreFranchisingDAO().save(franchising,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreFranchising(RetailScmUserContext userContext, RetailStore retailStore) throws Exception{
 		
 		
 		String currentStatus = retailStore.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'FRANCHISED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		if(!("FRANCHISED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'FRANCHISED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		
 		RetailStoreFranchising franchising = retailStore.getFranchising();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = franchising 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( franchising != null){
				throw new RetailStoreManagerException("The RetailStore("+retailStore.getId()+") has already been FRANCHISED");
		}
 		
 		
 	}
	
 	protected void checkParamsForDecoration(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkCommentOfRetailStoreDecoration(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStore decorate(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForDecoration(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreDecoration(userContext,retailStore);
 		

			retailStore.setCurrentStatus("DECORATED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreDecoration decoration = createRetailStoreDecoration(comment);		
			retailStore.setDecoration(decoration);		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withDecoration().done());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	protected RetailStoreDecoration createRetailStoreDecoration(String comment){
 		RetailStoreDecoration decoration = new RetailStoreDecoration(comment);
 		return getRetailStoreDecorationDAO().save(decoration,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreDecoration(RetailScmUserContext userContext, RetailStore retailStore) throws Exception{
 		
 		
 		String currentStatus = retailStore.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'DECORATED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		if(!("DECORATED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'DECORATED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		
 		RetailStoreDecoration decoration = retailStore.getDecoration();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = decoration 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( decoration != null){
				throw new RetailStoreManagerException("The RetailStore("+retailStore.getId()+") has already been DECORATED");
		}
 		
 		
 	}
	
 	protected void checkParamsForOpening(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkCommentOfRetailStoreOpening(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStore open(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForOpening(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreOpening(userContext,retailStore);
 		

			retailStore.setCurrentStatus("OPENNED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreOpening opening = createRetailStoreOpening(comment);		
			retailStore.setOpening(opening);		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withOpening().done());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	protected RetailStoreOpening createRetailStoreOpening(String comment){
 		RetailStoreOpening opening = new RetailStoreOpening(comment);
 		return getRetailStoreOpeningDAO().save(opening,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreOpening(RetailScmUserContext userContext, RetailStore retailStore) throws Exception{
 		
 		
 		String currentStatus = retailStore.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'OPENNED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		if(!("OPENNED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'OPENNED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		
 		RetailStoreOpening opening = retailStore.getOpening();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = opening 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( opening != null){
				throw new RetailStoreManagerException("The RetailStore("+retailStore.getId()+") has already been OPENNED");
		}
 		
 		
 	}
	
 	protected void checkParamsForClosing(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
 		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkCommentOfRetailStoreClosing(userContext,comment,exception);

	
		throwExceptionIfHasErrors(userContext, exception);

 	}
 	public RetailStore close(RetailScmUserContext userContext, String retailStoreId, String comment
) throws Exception
 	{
		checkParamsForClosing(userContext, retailStoreId, comment);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());	
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForRetailStoreClosing(userContext,retailStore);
 		

			retailStore.setCurrentStatus("CLOSED");
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			RetailStoreClosing closing = createRetailStoreClosing(comment);		
			retailStore.setClosing(closing);		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withClosing().done());
			
			return present(userContext,retailStore, allTokens());
			
		}

 	}
 	protected RetailStoreClosing createRetailStoreClosing(String comment){
 		RetailStoreClosing closing = new RetailStoreClosing(comment);
 		return getRetailStoreClosingDAO().save(closing,emptyOptions());
 	}
 	protected void checkIfEligibleForRetailStoreClosing(RetailScmUserContext userContext, RetailStore retailStore) throws Exception{
 		
 		
 		String currentStatus = retailStore.getCurrentStatus();
 		//'null' is fine for function getNextStatus
 		String expectedNextStatus = getNextStatus(userContext, currentStatus);
 		
 		if(expectedNextStatus == null){
 			//no more next status
 			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'CLOSED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		if(!("CLOSED".equalsIgnoreCase(expectedNextStatus))){
 			String message = "The current status '"+currentStatus+"' next status should be '"+expectedNextStatus+"', but you want to put the status to 'CLOSED'";
 			throw new RetailStoreManagerException(message);
 		}
 		
 		
 		RetailStoreClosing closing = retailStore.getClosing();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = closing 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( closing != null){
				throw new RetailStoreManagerException("The RetailStore("+retailStore.getId()+") has already been CLOSED");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newRetailStoreCountryCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newRetailStoreCountryCenterId, options);
 	}
	
	 	
 	protected RetailStoreFranchising loadRetailStoreFranchising(String newFranchisingId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreFranchisingDAO().load(newFranchisingId, options);
 	}
	
	 	
 	protected RetailStoreDecoration loadRetailStoreDecoration(String newDecorationId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreDecorationDAO().load(newDecorationId, options);
 	}
	
	 	
 	protected RetailStoreClosing loadRetailStoreClosing(String newClosingId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreClosingDAO().load(newClosingId, options);
 	}
	
	 	
 	protected RetailStoreCreation loadRetailStoreCreation(String newCreationId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCreationDAO().load(newCreationId, options);
 	}
	
	 	
 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCityServiceCenterDAO().load(newCityServiceCenterId, options);
 	}
	
	 	
 	protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(String newInvestmentInvitationId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreInvestmentInvitationDAO().load(newInvestmentInvitationId, options);
 	}
	
	 	
 	protected RetailStoreOpening loadRetailStoreOpening(String newOpeningId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreOpeningDAO().load(newOpeningId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreId, int retailStoreVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreId, retailStoreVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreId, int retailStoreVersion) throws Exception{
		getRetailStoreDAO().delete(retailStoreId, retailStoreVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreDAO().deleteAll();
	}

	protected void checkParamsForAddingConsumerOrder(RetailScmUserContext userContext, String retailStoreId, String title, String consumerId,String [] tokensExpr) throws Exception{
		
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);

		checkTitleOfConsumerOrder(userContext,  title, exception);		
		
		checkIdOfRetailStoreMember(userContext,  consumerId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStore addConsumerOrder(RetailScmUserContext userContext, String retailStoreId, String title, String consumerId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingConsumerOrder(userContext,retailStoreId,title, consumerId,tokensExpr);
		
		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addConsumerOrder( consumerOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected ConsumerOrder createConsumerOrder(RetailScmUserContext userContext, String title, String consumerId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);
	
		
		return consumerOrder;
	
		
	}
	
	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;			
		
	}
	protected void checkParamsForRemovingConsumerOrder(RetailScmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore removeConsumerOrder(RetailScmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeConsumerOrder( consumerOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingConsumerOrder(RetailScmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore copyConsumerOrderFrom(RetailScmUserContext userContext, String retailStoreId, 
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);
		
		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.copyConsumerOrderFrom( consumerOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingConsumerOrder(RetailScmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfConsumerOrder(userContext, consumerOrderId, exception);
		checkVersionOfConsumerOrder(userContext, consumerOrderVersion, exception);
		

		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfConsumerOrder(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStore updateConsumerOrder(RetailScmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingConsumerOrder(userContext, retailStoreId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeConsumerOrder( consumerOrder );	
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIndex = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		
			ConsumerOrder consumerOrder = retailStore.findTheConsumerOrder(consumerOrderIndex);
			if(consumerOrder == null){
				throw new RetailStoreManagerException(consumerOrder+"Not found" );
			}
			
			consumerOrder.changePropery(property, newValueExpr);

			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  sellerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStore addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreId,sellerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,sellerId, title, totalAmount);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addRetailStoreOrder( retailStoreOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreOrder createRetailStoreOrder(RetailScmUserContext userContext, String sellerId, String title, double totalAmount) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
		RetailStoreCountryCenter  seller = new RetailStoreCountryCenter();
		seller.setId(sellerId);		
		retailStoreOrder.setSeller(seller);		
		retailStoreOrder.setTitle(title);		
		retailStoreOrder.setTotalAmount(totalAmount);
	
		
		return retailStoreOrder;
	
		
	}
	
	protected RetailStoreOrder createIndexedRetailStoreOrder(String id, int version){

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(version);
		return retailStoreOrder;			
		
	}
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeRetailStoreOrder( retailStoreOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfRetailStoreOrder(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkTotalAmountOfRetailStoreOrder(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStore updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStore.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);

		checkNameOfGoods(userContext,  name, exception);
		checkRfidOfGoods(userContext,  rfid, exception);
		checkUomOfGoods(userContext,  uom, exception);
		checkMaxPackageOfGoods(userContext,  maxPackage, exception);
		checkExpireTimeOfGoods(userContext,  expireTime, exception);		
		
		checkIdOfSku(userContext,  skuId, exception);		
		
		checkIdOfReceivingSpace(userContext,  receivingSpaceId, exception);		
		
		checkIdOfGoodsAllocation(userContext,  goodsAllocationId, exception);		
		
		checkIdOfSmartPallet(userContext,  smartPalletId, exception);		
		
		checkIdOfShippingSpace(userContext,  shippingSpaceId, exception);		
		
		checkIdOfTransportTask(userContext,  transportTaskId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);		
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStore addGoods(RetailScmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,retailStoreId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addGoods( goods );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);
	
		
		return goods;
	
		
	}
	
	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;			
		
	}
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore removeGoods(RetailScmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeGoods( goods );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore copyGoodsFrom(RetailScmUserContext userContext, String retailStoreId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.copyGoodsFrom( goods );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);
		

		if(Goods.NAME_PROPERTY.equals(property)){
			checkNameOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			checkRfidOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			checkUomOfGoods(userContext, parseString(newValueExpr), exception);
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			checkMaxPackageOfGoods(userContext, parseInt(newValueExpr), exception);
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			checkExpireTimeOfGoods(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStore updateGoods(RetailScmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, retailStoreId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = retailStore.findTheGoods(goodsIndex);
			if(goods == null){
				throw new RetailStoreManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTransportTask(RetailScmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);

		checkNameOfTransportTask(userContext,  name, exception);
		checkStartOfTransportTask(userContext,  start, exception);
		checkBeginTimeOfTransportTask(userContext,  beginTime, exception);		
		
		checkIdOfTruckDriver(userContext,  driverId, exception);		
		
		checkIdOfTransportTruck(userContext,  truckId, exception);		
		
		checkIdOfTransportFleet(userContext,  belongsToId, exception);
		checkLatitudeOfTransportTask(userContext,  latitude, exception);
		checkLongitudeOfTransportTask(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStore addTransportTask(RetailScmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTask(userContext,retailStoreId,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude,tokensExpr);
		
		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addTransportTask( transportTask );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected TransportTask createTransportTask(RetailScmUserContext userContext, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, double latitude, double longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		TruckDriver  driver = new TruckDriver();
		driver.setId(driverId);		
		transportTask.setDriver(driver);		
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
		TransportFleet  belongsTo = new TransportFleet();
		belongsTo.setId(belongsToId);		
		transportTask.setBelongsTo(belongsTo);		
		transportTask.setLatitude(latitude);		
		transportTask.setLongitude(longitude);
	
		
		return transportTask;
	
		
	}
	
	protected TransportTask createIndexedTransportTask(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;			
		
	}
	protected void checkParamsForRemovingTransportTask(RetailScmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore removeTransportTask(RetailScmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeTransportTask( transportTask );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTransportTask(RetailScmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore copyTransportTaskFrom(RetailScmUserContext userContext, String retailStoreId, 
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);
		
		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.copyTransportTaskFrom( transportTask );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailScmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkVersionOfTransportTask(userContext, transportTaskVersion, exception);
		

		if(TransportTask.NAME_PROPERTY.equals(property)){
			checkNameOfTransportTask(userContext, parseString(newValueExpr), exception);
		}
		
		if(TransportTask.START_PROPERTY.equals(property)){
			checkStartOfTransportTask(userContext, parseString(newValueExpr), exception);
		}
		
		if(TransportTask.BEGIN_TIME_PROPERTY.equals(property)){
			checkBeginTimeOfTransportTask(userContext, parseDate(newValueExpr), exception);
		}
		
		if(TransportTask.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfTransportTask(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(TransportTask.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfTransportTask(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStore updateTransportTask(RetailScmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTask(userContext, retailStoreId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeTransportTask( transportTask );	
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIndex = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		
			TransportTask transportTask = retailStore.findTheTransportTask(transportTaskIndex);
			if(transportTask == null){
				throw new RetailStoreManagerException(transportTask+"Not found" );
			}
			
			transportTask.changePropery(property, newValueExpr);

			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingAccountSet(RetailScmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId,String [] tokensExpr) throws Exception{
		
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);

		checkNameOfAccountSet(userContext,  name, exception);
		checkYearSetOfAccountSet(userContext,  yearSet, exception);
		checkEffectiveDateOfAccountSet(userContext,  effectiveDate, exception);
		checkAccountingSystemOfAccountSet(userContext,  accountingSystem, exception);
		checkDomesticCurrencyCodeOfAccountSet(userContext,  domesticCurrencyCode, exception);
		checkDomesticCurrencyNameOfAccountSet(userContext,  domesticCurrencyName, exception);
		checkOpeningBankOfAccountSet(userContext,  openingBank, exception);
		checkAccountNumberOfAccountSet(userContext,  accountNumber, exception);		
		
		checkIdOfRetailStoreCountryCenter(userContext,  countryCenterId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  goodsSupplierId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStore addAccountSet(RetailScmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountSet(userContext,retailStoreId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId,tokensExpr);
		
		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId);
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addAccountSet( accountSet );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountSet createAccountSet(RetailScmUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId) throws Exception{

		AccountSet accountSet = new AccountSet();
		
		
		accountSet.setName(name);		
		accountSet.setYearSet(yearSet);		
		accountSet.setEffectiveDate(effectiveDate);		
		accountSet.setAccountingSystem(accountingSystem);		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);		
		accountSet.setOpeningBank(openingBank);		
		accountSet.setAccountNumber(accountNumber);		
		RetailStoreCountryCenter  countryCenter = new RetailStoreCountryCenter();
		countryCenter.setId(countryCenterId);		
		accountSet.setCountryCenter(countryCenter);		
		GoodsSupplier  goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(goodsSupplierId);		
		accountSet.setGoodsSupplier(goodsSupplier);
	
		
		return accountSet;
	
		
	}
	
	protected AccountSet createIndexedAccountSet(String id, int version){

		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(version);
		return accountSet;			
		
	}
	protected void checkParamsForRemovingAccountSet(RetailScmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore removeAccountSet(RetailScmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeAccountSet( accountSet );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountSet(RetailScmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStore copyAccountSetFrom(RetailScmUserContext userContext, String retailStoreId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.copyAccountSetFrom( accountSet );		
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountSet(RetailScmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreManagerException exception = new RetailStoreManagerException("Error Occured");
		
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
			checkNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
			checkYearSetOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
			checkEffectiveDateOfAccountSet(userContext, parseDate(newValueExpr), exception);
		}
		
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			checkAccountingSystemOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			checkDomesticCurrencyCodeOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			checkDomesticCurrencyNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
			checkOpeningBankOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
			checkAccountNumberOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStore updateAccountSet(RetailScmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountSet(userContext, retailStoreId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		
		synchronized(retailStore){ 
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeAccountSet( accountSet );	
			//make changes to AcceleraterAccount.
			AccountSet accountSetIndex = createIndexedAccountSet(accountSetId, accountSetVersion);
		
			AccountSet accountSet = retailStore.findTheAccountSet(accountSetIndex);
			if(accountSet == null){
				throw new RetailStoreManagerException(accountSet+"Not found" );
			}
			
			accountSet.changePropery(property, newValueExpr);

			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


