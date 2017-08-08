
package com.skynet.retailscm.retailstore;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
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

import com.skynet.retailscm.consumerorder.ConsumerOrderDAO;
import com.skynet.retailscm.goods.GoodsDAO;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchisingDAO;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecorationDAO;
import com.skynet.retailscm.transporttask.TransportTaskDAO;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationDAO;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.accountset.AccountSetDAO;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpeningDAO;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosingDAO;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreationDAO;

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


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  RetailStoreFranchisingDAO  retailStoreFranchisingDAO;
 	public void setRetailStoreFranchisingDAO(RetailStoreFranchisingDAO retailStoreFranchisingDAO){
	 	this.retailStoreFranchisingDAO = retailStoreFranchisingDAO;
 	}
 	public RetailStoreFranchisingDAO getRetailStoreFranchisingDAO(){
	 	return this.retailStoreFranchisingDAO;
 	}
 
 	
 	private  RetailStoreDecorationDAO  retailStoreDecorationDAO;
 	public void setRetailStoreDecorationDAO(RetailStoreDecorationDAO retailStoreDecorationDAO){
	 	this.retailStoreDecorationDAO = retailStoreDecorationDAO;
 	}
 	public RetailStoreDecorationDAO getRetailStoreDecorationDAO(){
	 	return this.retailStoreDecorationDAO;
 	}
 
 	
 	private  RetailStoreClosingDAO  retailStoreClosingDAO;
 	public void setRetailStoreClosingDAO(RetailStoreClosingDAO retailStoreClosingDAO){
	 	this.retailStoreClosingDAO = retailStoreClosingDAO;
 	}
 	public RetailStoreClosingDAO getRetailStoreClosingDAO(){
	 	return this.retailStoreClosingDAO;
 	}
 
 	
 	private  RetailStoreCreationDAO  retailStoreCreationDAO;
 	public void setRetailStoreCreationDAO(RetailStoreCreationDAO retailStoreCreationDAO){
	 	this.retailStoreCreationDAO = retailStoreCreationDAO;
 	}
 	public RetailStoreCreationDAO getRetailStoreCreationDAO(){
	 	return this.retailStoreCreationDAO;
 	}
 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}
 
 	
 	private  RetailStoreInvestmentInvitationDAO  retailStoreInvestmentInvitationDAO;
 	public void setRetailStoreInvestmentInvitationDAO(RetailStoreInvestmentInvitationDAO retailStoreInvestmentInvitationDAO){
	 	this.retailStoreInvestmentInvitationDAO = retailStoreInvestmentInvitationDAO;
 	}
 	public RetailStoreInvestmentInvitationDAO getRetailStoreInvestmentInvitationDAO(){
	 	return this.retailStoreInvestmentInvitationDAO;
 	}
 
 	
 	private  RetailStoreOpeningDAO  retailStoreOpeningDAO;
 	public void setRetailStoreOpeningDAO(RetailStoreOpeningDAO retailStoreOpeningDAO){
	 	this.retailStoreOpeningDAO = retailStoreOpeningDAO;
 	}
 	public RetailStoreOpeningDAO getRetailStoreOpeningDAO(){
	 	return this.retailStoreOpeningDAO;
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
 	
			
		
	
  	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO pRetailStoreOrderDAO){
 	
 		if(pRetailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = pRetailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}	
 	
			
		
	
  	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO pGoodsDAO){
 	
 		if(pGoodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = pGoodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsDAO;
 	}	
 	
			
		
	
  	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO pTransportTaskDAO){
 	
 		if(pTransportTaskDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskDAO to null.");
 		}
	 	this.transportTaskDAO = pTransportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
 		if(this.transportTaskDAO == null){
 			throw new IllegalStateException("The transportTaskDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskDAO;
 	}	
 	
			
		
	
  	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO pAccountSetDAO){
 	
 		if(pAccountSetDAO == null){
 			throw new IllegalStateException("Do not try to set accountSetDAO to null.");
 		}
	 	this.accountSetDAO = pAccountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
 		if(this.accountSetDAO == null){
 			throw new IllegalStateException("The accountSetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountSetDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStore load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStore(accessKey, options);
	}
	*/
	public RetailStore load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStore(RetailStoreTable.withId(id), options);
	}
	
	
	
	public RetailStore save(RetailStore retailStore,Map<String,Object> options){
		
		String methodName="save(RetailStore retailStore,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStore, methodName, "retailStore");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStore(retailStore,options);
	}
	public RetailStore clone(String retailStoreId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreTable.withId(retailStoreId),options);
	}
	
	protected RetailStore clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStore newRetailStore = loadInternalRetailStore(accessKey, options);
		newRetailStore.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newRetailStore.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStore.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newRetailStore.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newRetailStore.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountSetListEnabled(options)){
 			for(AccountSet item: newRetailStore.getAccountSetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStore(newRetailStore,options);
		
		return newRetailStore;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreId, int version) throws Exception{
	
		String methodName="delete(String retailStoreId, int version)";
		assertMethodArgumentNotNull(retailStoreId, methodName, "retailStoreId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","telephone","owner","retail_store_country_center","city_service_center","creation","investment_invitation","franchising","decoration","opening","closing","founded","latitude","longitude","description","current_status"};
		return RetailStoreTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractRetailStoreCountryCenterEnabled = true;
 	//private static final String RETAILSTORECOUNTRYCENTER = "retailStoreCountryCenter";
 	protected boolean isExtractRetailStoreCountryCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.RETAILSTORECOUNTRYCENTER);
 	}
 	
 	
 	//private boolean saveRetailStoreCountryCenterEnabled = true;
 	protected boolean isSaveRetailStoreCountryCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.RETAILSTORECOUNTRYCENTER);
 	}
 	

 	
  
 	//private boolean extractCityServiceCenterEnabled = true;
 	//private static final String CITYSERVICECENTER = "cityServiceCenter";
 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.CITYSERVICECENTER);
 	}
 	
 	
 	//private boolean saveCityServiceCenterEnabled = true;
 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.CITYSERVICECENTER);
 	}
 	

 	
  
 	//private boolean extractCreationEnabled = true;
 	//private static final String CREATION = "creation";
 	protected boolean isExtractCreationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.CREATION);
 	}
 	
 	
 	//private boolean saveCreationEnabled = true;
 	protected boolean isSaveCreationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.CREATION);
 	}
 	

 	
  
 	//private boolean extractInvestmentInvitationEnabled = true;
 	//private static final String INVESTMENTINVITATION = "investmentInvitation";
 	protected boolean isExtractInvestmentInvitationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.INVESTMENTINVITATION);
 	}
 	
 	
 	//private boolean saveInvestmentInvitationEnabled = true;
 	protected boolean isSaveInvestmentInvitationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.INVESTMENTINVITATION);
 	}
 	

 	
  
 	//private boolean extractFranchisingEnabled = true;
 	//private static final String FRANCHISING = "franchising";
 	protected boolean isExtractFranchisingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.FRANCHISING);
 	}
 	
 	
 	//private boolean saveFranchisingEnabled = true;
 	protected boolean isSaveFranchisingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.FRANCHISING);
 	}
 	

 	
  
 	//private boolean extractDecorationEnabled = true;
 	//private static final String DECORATION = "decoration";
 	protected boolean isExtractDecorationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.DECORATION);
 	}
 	
 	
 	//private boolean saveDecorationEnabled = true;
 	protected boolean isSaveDecorationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.DECORATION);
 	}
 	

 	
  
 	//private boolean extractOpeningEnabled = true;
 	//private static final String OPENING = "opening";
 	protected boolean isExtractOpeningEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.OPENING);
 	}
 	
 	
 	//private boolean saveOpeningEnabled = true;
 	protected boolean isSaveOpeningEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.OPENING);
 	}
 	

 	
  
 	//private boolean extractClosingEnabled = true;
 	//private static final String CLOSING = "closing";
 	protected boolean isExtractClosingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.CLOSING);
 	}
 	
 	
 	//private boolean saveClosingEnabled = true;
 	protected boolean isSaveClosingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.CLOSING);
 	}
 	

 	
 
		
	//protected static final String CONSUMER_ORDER_LIST = "consumerOrderList";
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreTokens.CONSUMER_ORDER_LIST);
		
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.GOODS_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreTokens.TRANSPORT_TASK_LIST);
		
 	}

	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ACCOUNT_SET_LIST = "accountSetList";
	
	protected boolean isExtractAccountSetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreTokens.ACCOUNT_SET_LIST);
		
 	}

	protected boolean isSaveAccountSetListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.ACCOUNT_SET_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreMapper getRetailStoreMapper(){
		return new RetailStoreMapper();
	}
	protected RetailStore extractRetailStore(String retailStoreId) throws Exception{
		String SQL = "select * from retail_store_data where id = ?";	
		try{
		
			RetailStore retailStore = queryForObject(SQL, new Object[]{retailStoreId}, getRetailStoreMapper());
			return retailStore;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreNotFoundException("RetailStore("+retailStoreId+") is not found!");
		}
		
		
	}
	protected RetailStore extractRetailStore(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStore retailStore = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreMapper());
			return retailStore;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreNotFoundException("RetailStore("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStore loadInternalRetailStore(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStore retailStore = extractRetailStore(accessKey, loadOptions);
 	
 		if(isExtractRetailStoreCountryCenterEnabled(loadOptions)){
	 		extractRetailStoreCountryCenter(retailStore, loadOptions);
 		}
  	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(retailStore, loadOptions);
 		}
  	
 		if(isExtractCreationEnabled(loadOptions)){
	 		extractCreation(retailStore, loadOptions);
 		}
  	
 		if(isExtractInvestmentInvitationEnabled(loadOptions)){
	 		extractInvestmentInvitation(retailStore, loadOptions);
 		}
  	
 		if(isExtractFranchisingEnabled(loadOptions)){
	 		extractFranchising(retailStore, loadOptions);
 		}
  	
 		if(isExtractDecorationEnabled(loadOptions)){
	 		extractDecoration(retailStore, loadOptions);
 		}
  	
 		if(isExtractOpeningEnabled(loadOptions)){
	 		extractOpening(retailStore, loadOptions);
 		}
  	
 		if(isExtractClosingEnabled(loadOptions)){
	 		extractClosing(retailStore, loadOptions);
 		}
 
		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(retailStore, loadOptions);
 		}		
		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStore, loadOptions);
 		}		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(retailStore, loadOptions);
 		}		
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(retailStore, loadOptions);
 		}		
		
		if(isExtractAccountSetListEnabled(loadOptions)){
	 		extractAccountSetList(retailStore, loadOptions);
 		}		
		
		return retailStore;
		
	}



	
	
	 

 	protected RetailStore extractRetailStoreCountryCenter(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getRetailStoreCountryCenter() == null){
			return retailStore;
		}
		String retailStoreCountryCenterId = retailStore.getRetailStoreCountryCenter().getId();
		if( retailStoreCountryCenterId == null){
			return retailStore;
		}
		RetailStoreCountryCenter retailStoreCountryCenter = getRetailStoreCountryCenterDAO().load(retailStoreCountryCenterId,options);
		if(retailStoreCountryCenter != null){
			retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractCityServiceCenter(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getCityServiceCenter() == null){
			return retailStore;
		}
		String cityServiceCenterId = retailStore.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return retailStore;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			retailStore.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractCreation(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getCreation() == null){
			return retailStore;
		}
		String creationId = retailStore.getCreation().getId();
		if( creationId == null){
			return retailStore;
		}
		RetailStoreCreation creation = getRetailStoreCreationDAO().load(creationId,options);
		if(creation != null){
			retailStore.setCreation(creation);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractInvestmentInvitation(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getInvestmentInvitation() == null){
			return retailStore;
		}
		String investmentInvitationId = retailStore.getInvestmentInvitation().getId();
		if( investmentInvitationId == null){
			return retailStore;
		}
		RetailStoreInvestmentInvitation investmentInvitation = getRetailStoreInvestmentInvitationDAO().load(investmentInvitationId,options);
		if(investmentInvitation != null){
			retailStore.setInvestmentInvitation(investmentInvitation);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractFranchising(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getFranchising() == null){
			return retailStore;
		}
		String franchisingId = retailStore.getFranchising().getId();
		if( franchisingId == null){
			return retailStore;
		}
		RetailStoreFranchising franchising = getRetailStoreFranchisingDAO().load(franchisingId,options);
		if(franchising != null){
			retailStore.setFranchising(franchising);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractDecoration(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getDecoration() == null){
			return retailStore;
		}
		String decorationId = retailStore.getDecoration().getId();
		if( decorationId == null){
			return retailStore;
		}
		RetailStoreDecoration decoration = getRetailStoreDecorationDAO().load(decorationId,options);
		if(decoration != null){
			retailStore.setDecoration(decoration);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractOpening(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getOpening() == null){
			return retailStore;
		}
		String openingId = retailStore.getOpening().getId();
		if( openingId == null){
			return retailStore;
		}
		RetailStoreOpening opening = getRetailStoreOpeningDAO().load(openingId,options);
		if(opening != null){
			retailStore.setOpening(opening);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractClosing(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getClosing() == null){
			return retailStore;
		}
		String closingId = retailStore.getClosing().getId();
		if( closingId == null){
			return retailStore;
		}
		RetailStoreClosing closing = getRetailStoreClosingDAO().load(closingId,options);
		if(closing != null){
			retailStore.setClosing(closing);
		}
		
 		
 		return retailStore;
 	}
 		
 
		
	protected RetailStore extractConsumerOrderList(RetailStore retailStore, Map<String,Object> options){
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByStore(retailStore.getId(),options);
		if(consumerOrderList != null){
			retailStore.setConsumerOrderList(consumerOrderList);
		}
		
		return retailStore;
	
	}	
		
	protected RetailStore extractRetailStoreOrderList(RetailStore retailStore, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByBuyer(retailStore.getId(),options);
		if(retailStoreOrderList != null){
			retailStore.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStore;
	
	}	
		
	protected RetailStore extractGoodsList(RetailStore retailStore, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByRetailStore(retailStore.getId(),options);
		if(goodsList != null){
			retailStore.setGoodsList(goodsList);
		}
		
		return retailStore;
	
	}	
		
	protected RetailStore extractTransportTaskList(RetailStore retailStore, Map<String,Object> options){
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByEnd(retailStore.getId(),options);
		if(transportTaskList != null){
			retailStore.setTransportTaskList(transportTaskList);
		}
		
		return retailStore;
	
	}	
		
	protected RetailStore extractAccountSetList(RetailStore retailStore, Map<String,Object> options){
		
		SmartList<AccountSet> accountSetList = getAccountSetDAO().findAccountSetByRetailStore(retailStore.getId(),options);
		if(accountSetList != null){
			retailStore.setAccountSetList(accountSetList);
		}
		
		return retailStore;
	
	}	
		
		
  	
 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store_country_center = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store_country_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where retail_store_country_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where city_service_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCityServiceCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where creation = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreCreationId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where creation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreCreationId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByCreation(String retailStoreCreationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where creation = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCreationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where investment_invitation = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreInvestmentInvitationId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where investment_invitation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreInvestmentInvitationId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where investment_invitation = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreInvestmentInvitationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where franchising = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreFranchisingId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where franchising = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreFranchisingId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByFranchising(String retailStoreFranchisingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where franchising = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreFranchisingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where decoration = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreDecorationId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where decoration = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreDecorationId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByDecoration(String retailStoreDecorationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where decoration = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreDecorationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where opening = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreOpeningId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where opening = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreOpeningId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByOpening(String retailStoreOpeningId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where opening = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOpeningId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where closing = ?";
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreClosingId}, getRetailStoreMapper());	
 		return retailStoreList;
 	}
 	
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where closing = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStore> retailStoreList = queryForList(SQL, new Object[]{retailStoreClosingId,start, count}, getRetailStoreMapper());
		
 		return retailStoreList;
 	}
 	
 	public int countRetailStoreByClosing(String retailStoreClosingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where closing = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreClosingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStore saveRetailStore(RetailStore  retailStore){
	
		String SQL=this.getSaveRetailStoreSQL(retailStore);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreParameters(retailStore);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStore.incVersion();
		return retailStore;
	
	}
	public SmartList<RetailStore> saveRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreList(retailStoreList);
		
		batchRetailStoreCreate((List<RetailStore>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreUpdate((List<RetailStore>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStore retailStore:retailStoreList){
			if(retailStore.isChanged()){
				retailStore.incVersion();
			}
			
		
		}
		
		
		return retailStoreList;
	}

	public SmartList<RetailStore> removeRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		
		
		super.removeList(retailStoreList, options);
		
		return retailStoreList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreBatchCreateArgs(List<RetailStore> retailStoreList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStore retailStore:retailStoreList ){
			Object [] parameters = prepareRetailStoreCreateParameters(retailStore);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreBatchUpdateArgs(List<RetailStore> retailStoreList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStore retailStore:retailStoreList ){
			if(!retailStore.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreUpdateParameters(retailStore);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreCreate(List<RetailStore> retailStoreList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreBatchCreateArgs(retailStoreList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreUpdate(List<RetailStore> retailStoreList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreBatchUpdateArgs(retailStoreList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreList(List<RetailStore> retailStoreList){
		
		List<RetailStore> retailStoreCreateList=new ArrayList<RetailStore>();
		List<RetailStore> retailStoreUpdateList=new ArrayList<RetailStore>();
		
		for(RetailStore retailStore: retailStoreList){
			if(isUpdateRequest(retailStore)){
				retailStoreUpdateList.add( retailStore);
				continue;
			}
			retailStoreCreateList.add(retailStore);
		}
		
		return new Object[]{retailStoreCreateList,retailStoreUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStore retailStore){
 		return retailStore.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreSQL(RetailStore retailStore){
 		if(isUpdateRequest(retailStore)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreParameters(RetailStore retailStore){
 		if(isUpdateRequest(retailStore) ){
 			return prepareRetailStoreUpdateParameters(retailStore);
 		}
 		return prepareRetailStoreCreateParameters(retailStore);
 	}
 	protected Object[] prepareRetailStoreUpdateParameters(RetailStore retailStore){
 		Object[] parameters = new Object[18];
 
 		parameters[0] = retailStore.getName();
 		parameters[1] = retailStore.getTelephone();
 		parameters[2] = retailStore.getOwner(); 	
 		if(retailStore.getRetailStoreCountryCenter() != null){
 			parameters[3] = retailStore.getRetailStoreCountryCenter().getId();
 		}
  	
 		if(retailStore.getCityServiceCenter() != null){
 			parameters[4] = retailStore.getCityServiceCenter().getId();
 		}
  	
 		if(retailStore.getCreation() != null){
 			parameters[5] = retailStore.getCreation().getId();
 		}
  	
 		if(retailStore.getInvestmentInvitation() != null){
 			parameters[6] = retailStore.getInvestmentInvitation().getId();
 		}
  	
 		if(retailStore.getFranchising() != null){
 			parameters[7] = retailStore.getFranchising().getId();
 		}
  	
 		if(retailStore.getDecoration() != null){
 			parameters[8] = retailStore.getDecoration().getId();
 		}
  	
 		if(retailStore.getOpening() != null){
 			parameters[9] = retailStore.getOpening().getId();
 		}
  	
 		if(retailStore.getClosing() != null){
 			parameters[10] = retailStore.getClosing().getId();
 		}
 
 		parameters[11] = retailStore.getFounded();
 		parameters[12] = retailStore.getLatitude();
 		parameters[13] = retailStore.getLongitude();
 		parameters[14] = retailStore.getDescription();
 		parameters[15] = retailStore.getCurrentStatus();		
 		parameters[16] = retailStore.getId();
 		parameters[17] = retailStore.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCreateParameters(RetailStore retailStore){
		Object[] parameters = new Object[17];
		String newRetailStoreId=getNextId();
		retailStore.setId(newRetailStoreId);
		parameters[0] =  retailStore.getId();
 
 		parameters[1] = retailStore.getName();
 		parameters[2] = retailStore.getTelephone();
 		parameters[3] = retailStore.getOwner(); 	
 		if(retailStore.getRetailStoreCountryCenter() != null){
 			parameters[4] = retailStore.getRetailStoreCountryCenter().getId();
 		
 		}
 		 	
 		if(retailStore.getCityServiceCenter() != null){
 			parameters[5] = retailStore.getCityServiceCenter().getId();
 		
 		}
 		 	
 		if(retailStore.getCreation() != null){
 			parameters[6] = retailStore.getCreation().getId();
 		
 		}
 		 	
 		if(retailStore.getInvestmentInvitation() != null){
 			parameters[7] = retailStore.getInvestmentInvitation().getId();
 		
 		}
 		 	
 		if(retailStore.getFranchising() != null){
 			parameters[8] = retailStore.getFranchising().getId();
 		
 		}
 		 	
 		if(retailStore.getDecoration() != null){
 			parameters[9] = retailStore.getDecoration().getId();
 		
 		}
 		 	
 		if(retailStore.getOpening() != null){
 			parameters[10] = retailStore.getOpening().getId();
 		
 		}
 		 	
 		if(retailStore.getClosing() != null){
 			parameters[11] = retailStore.getClosing().getId();
 		
 		}
 		
 		parameters[12] = retailStore.getFounded();
 		parameters[13] = retailStore.getLatitude();
 		parameters[14] = retailStore.getLongitude();
 		parameters[15] = retailStore.getDescription();
 		parameters[16] = retailStore.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected RetailStore saveInternalRetailStore(RetailStore retailStore, Map<String,Object> options){
		
		saveRetailStore(retailStore);
 	
 		if(isSaveRetailStoreCountryCenterEnabled(options)){
	 		saveRetailStoreCountryCenter(retailStore, options);
 		}
  	
 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(retailStore, options);
 		}
  	
 		if(isSaveCreationEnabled(options)){
	 		saveCreation(retailStore, options);
 		}
  	
 		if(isSaveInvestmentInvitationEnabled(options)){
	 		saveInvestmentInvitation(retailStore, options);
 		}
  	
 		if(isSaveFranchisingEnabled(options)){
	 		saveFranchising(retailStore, options);
 		}
  	
 		if(isSaveDecorationEnabled(options)){
	 		saveDecoration(retailStore, options);
 		}
  	
 		if(isSaveOpeningEnabled(options)){
	 		saveOpening(retailStore, options);
 		}
  	
 		if(isSaveClosingEnabled(options)){
	 		saveClosing(retailStore, options);
 		}
 
		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(retailStore, options);
	 		removeConsumerOrderList(retailStore, options);
	 		
 		}		
		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStore, options);
	 		removeRetailStoreOrderList(retailStore, options);
	 		
 		}		
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(retailStore, options);
	 		removeGoodsList(retailStore, options);
	 		
 		}		
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(retailStore, options);
	 		removeTransportTaskList(retailStore, options);
	 		
 		}		
		
		if(isSaveAccountSetListEnabled(options)){
	 		saveAccountSetList(retailStore, options);
	 		removeAccountSetList(retailStore, options);
	 		
 		}		
		
		return retailStore;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStore saveRetailStoreCountryCenter(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getRetailStoreCountryCenter() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(retailStore.getRetailStoreCountryCenter(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveCityServiceCenter(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getCityServiceCenter() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreCityServiceCenterDAO().save(retailStore.getCityServiceCenter(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveCreation(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getCreation() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreCreationDAO().save(retailStore.getCreation(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveInvestmentInvitation(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getInvestmentInvitation() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreInvestmentInvitationDAO().save(retailStore.getInvestmentInvitation(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveFranchising(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getFranchising() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreFranchisingDAO().save(retailStore.getFranchising(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveDecoration(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getDecoration() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreDecorationDAO().save(retailStore.getDecoration(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveOpening(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getOpening() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreOpeningDAO().save(retailStore.getOpening(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveClosing(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getClosing() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreClosingDAO().save(retailStore.getClosing(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected RetailStore saveConsumerOrderList(RetailStore retailStore, Map<String,Object> options){
		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();
		if(consumerOrderList == null){
			return retailStore;
		}
		if(consumerOrderList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderDAO().saveConsumerOrderList(consumerOrderList,options);
		
		return retailStore;
	
	}
	
	protected RetailStore removeConsumerOrderList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();
		if(consumerOrderList == null){
			return retailStore;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return retailStore;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return retailStore;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStore saveRetailStoreOrderList(RetailStore retailStore, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStore;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStore;
	
	}
	
	protected RetailStore removeRetailStoreOrderList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStore;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStore;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStore;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStore saveGoodsList(RetailStore retailStore, Map<String,Object> options){
		SmartList<Goods> goodsList = retailStore.getGoodsList();
		if(goodsList == null){
			return retailStore;
		}
		if(goodsList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return retailStore;
	
	}
	
	protected RetailStore removeGoodsList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = retailStore.getGoodsList();
		if(goodsList == null){
			return retailStore;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return retailStore;
		}
		if(toRemoveGoodsList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return retailStore;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStore saveTransportTaskList(RetailStore retailStore, Map<String,Object> options){
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();
		if(transportTaskList == null){
			return retailStore;
		}
		if(transportTaskList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTransportTaskDAO().saveTransportTaskList(transportTaskList,options);
		
		return retailStore;
	
	}
	
	protected RetailStore removeTransportTaskList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();
		if(transportTaskList == null){
			return retailStore;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return retailStore;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return retailStore;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStore saveAccountSetList(RetailStore retailStore, Map<String,Object> options){
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();
		if(accountSetList == null){
			return retailStore;
		}
		if(accountSetList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountSetDAO().saveAccountSetList(accountSetList,options);
		
		return retailStore;
	
	}
	
	protected RetailStore removeAccountSetList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();
		if(accountSetList == null){
			return retailStore;
		}	
	
		SmartList<AccountSet> toRemoveAccountSetList = accountSetList.getToRemoveList();
		
		if(toRemoveAccountSetList == null){
			return retailStore;
		}
		if(toRemoveAccountSetList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountSetDAO().removeAccountSetList(toRemoveAccountSetList,options);
		
		return retailStore;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStore present(RetailStore retailStore,Map<String, Object> options){
	
		presentConsumerOrderList(retailStore,options);
		presentRetailStoreOrderList(retailStore,options);
		presentGoodsList(retailStore,options);
		presentTransportTaskList(retailStore,options);
		presentAccountSetList(retailStore,options);

		return retailStore;
	
	}
		
	
  	
 	protected RetailStore presentConsumerOrderList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();		
		if(consumerOrderList == null){
			return retailStore;			
		}
		
		String targetObjectName = "consumerOrder";
		int consumerOrderListSize = consumerOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStore;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderListSize;
		if(consumerOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderDAO().countConsumerOrderByStore(retailStore.getId(), options);			
		}
		//retailStore.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStore.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderListSize,currentPage,rowsPerPage) ;
			consumerOrderList = consumerOrderList.subListOf(fromIndex, toIndex);
			consumerOrderList.setTotalCount(count);
			consumerOrderList.setCurrentPageNumber(currentPage);			
			retailStore.setConsumerOrderList(consumerOrderList);
			return retailStore;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderList 
			= getConsumerOrderDAO().findConsumerOrderByStore(retailStore.getId(),start, rowsPerPage, options );
		consumerOrderList.setTotalCount(count);
		consumerOrderList.setCurrentPageNumber(currentPage);
		retailStore.setConsumerOrderList(consumerOrderList );	

		return retailStore;
	}			
		
	
  	
 	protected RetailStore presentRetailStoreOrderList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStore;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStore;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderByBuyer(retailStore.getId(), options);			
		}
		//retailStore.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStore.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStore.setRetailStoreOrderList(retailStoreOrderList);
			return retailStore;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderByBuyer(retailStore.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStore.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStore;
	}			
		
	
  	
 	protected RetailStore presentGoodsList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		if(goodsList == null){
			return retailStore;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStore;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByRetailStore(retailStore.getId(), options);			
		}
		//retailStore.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStore.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			retailStore.setGoodsList(goodsList);
			return retailStore;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByRetailStore(retailStore.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		retailStore.setGoodsList(goodsList );	

		return retailStore;
	}			
		
	
  	
 	protected RetailStore presentTransportTaskList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();		
		if(transportTaskList == null){
			return retailStore;			
		}
		
		String targetObjectName = "transportTask";
		int transportTaskListSize = transportTaskList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(transportTaskListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStore;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = transportTaskListSize;
		if(transportTaskListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTransportTaskDAO().countTransportTaskByEnd(retailStore.getId(), options);			
		}
		//retailStore.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStore.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(transportTaskListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(transportTaskListSize,currentPage,rowsPerPage) ;
			transportTaskList = transportTaskList.subListOf(fromIndex, toIndex);
			transportTaskList.setTotalCount(count);
			transportTaskList.setCurrentPageNumber(currentPage);			
			retailStore.setTransportTaskList(transportTaskList);
			return retailStore;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		transportTaskList 
			= getTransportTaskDAO().findTransportTaskByEnd(retailStore.getId(),start, rowsPerPage, options );
		transportTaskList.setTotalCount(count);
		transportTaskList.setCurrentPageNumber(currentPage);
		retailStore.setTransportTaskList(transportTaskList );	

		return retailStore;
	}			
		
	
  	
 	protected RetailStore presentAccountSetList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();		
		if(accountSetList == null){
			return retailStore;			
		}
		
		String targetObjectName = "accountSet";
		int accountSetListSize = accountSetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountSetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStore;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountSetListSize;
		if(accountSetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountSetDAO().countAccountSetByRetailStore(retailStore.getId(), options);			
		}
		//retailStore.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStore.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountSetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountSetListSize,currentPage,rowsPerPage) ;
			accountSetList = accountSetList.subListOf(fromIndex, toIndex);
			accountSetList.setTotalCount(count);
			accountSetList.setCurrentPageNumber(currentPage);			
			retailStore.setAccountSetList(accountSetList);
			return retailStore;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountSetList 
			= getAccountSetDAO().findAccountSetByRetailStore(retailStore.getId(),start, rowsPerPage, options );
		accountSetList.setTotalCount(count);
		accountSetList.setCurrentPageNumber(currentPage);
		retailStore.setAccountSetList(accountSetList );	

		return retailStore;
	}			
		


	protected String getTableName(){
		return RetailStoreTable.TABLE_NAME;
	}
}


