
package com.skynet.retailscm.retailstoreorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupDAO;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipmentDAO;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemDAO;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupDAO;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessingDAO;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPickingDAO;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDeliveryDAO;
import com.skynet.retailscm.goods.GoodsDAO;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmationDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApprovalDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipmentTable;
import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemTable;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmationTable;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPickingTable;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApprovalTable;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessingTable;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupTable;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDeliveryTable;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreOrderJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreOrderDAO{
 
 	
 	private  RetailStoreOrderApprovalDAO  retailStoreOrderApprovalDAO;
 	public void setRetailStoreOrderApprovalDAO(RetailStoreOrderApprovalDAO retailStoreOrderApprovalDAO){
	 	this.retailStoreOrderApprovalDAO = retailStoreOrderApprovalDAO;
 	}
 	public RetailStoreOrderApprovalDAO getRetailStoreOrderApprovalDAO(){
	 	return this.retailStoreOrderApprovalDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  RetailStoreOrderDeliveryDAO  retailStoreOrderDeliveryDAO;
 	public void setRetailStoreOrderDeliveryDAO(RetailStoreOrderDeliveryDAO retailStoreOrderDeliveryDAO){
	 	this.retailStoreOrderDeliveryDAO = retailStoreOrderDeliveryDAO;
 	}
 	public RetailStoreOrderDeliveryDAO getRetailStoreOrderDeliveryDAO(){
	 	return this.retailStoreOrderDeliveryDAO;
 	}
 
 	
 	private  RetailStoreOrderPickingDAO  retailStoreOrderPickingDAO;
 	public void setRetailStoreOrderPickingDAO(RetailStoreOrderPickingDAO retailStoreOrderPickingDAO){
	 	this.retailStoreOrderPickingDAO = retailStoreOrderPickingDAO;
 	}
 	public RetailStoreOrderPickingDAO getRetailStoreOrderPickingDAO(){
	 	return this.retailStoreOrderPickingDAO;
 	}
 
 	
 	private  RetailStoreOrderShipmentDAO  retailStoreOrderShipmentDAO;
 	public void setRetailStoreOrderShipmentDAO(RetailStoreOrderShipmentDAO retailStoreOrderShipmentDAO){
	 	this.retailStoreOrderShipmentDAO = retailStoreOrderShipmentDAO;
 	}
 	public RetailStoreOrderShipmentDAO getRetailStoreOrderShipmentDAO(){
	 	return this.retailStoreOrderShipmentDAO;
 	}
 
 	
 	private  RetailStoreOrderConfirmationDAO  retailStoreOrderConfirmationDAO;
 	public void setRetailStoreOrderConfirmationDAO(RetailStoreOrderConfirmationDAO retailStoreOrderConfirmationDAO){
	 	this.retailStoreOrderConfirmationDAO = retailStoreOrderConfirmationDAO;
 	}
 	public RetailStoreOrderConfirmationDAO getRetailStoreOrderConfirmationDAO(){
	 	return this.retailStoreOrderConfirmationDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  RetailStoreOrderProcessingDAO  retailStoreOrderProcessingDAO;
 	public void setRetailStoreOrderProcessingDAO(RetailStoreOrderProcessingDAO retailStoreOrderProcessingDAO){
	 	this.retailStoreOrderProcessingDAO = retailStoreOrderProcessingDAO;
 	}
 	public RetailStoreOrderProcessingDAO getRetailStoreOrderProcessingDAO(){
	 	return this.retailStoreOrderProcessingDAO;
 	}

		
	
  	private  RetailStoreOrderLineItemDAO  retailStoreOrderLineItemDAO;
 	public void setRetailStoreOrderLineItemDAO(RetailStoreOrderLineItemDAO pRetailStoreOrderLineItemDAO){
 	
 		if(pRetailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderLineItemDAO to null.");
 		}
	 	this.retailStoreOrderLineItemDAO = pRetailStoreOrderLineItemDAO;
 	}
 	public RetailStoreOrderLineItemDAO getRetailStoreOrderLineItemDAO(){
 		if(this.retailStoreOrderLineItemDAO == null){
 			throw new IllegalStateException("The retailStoreOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderLineItemDAO;
 	}	
 	
			
		
	
  	private  RetailStoreOrderShippingGroupDAO  retailStoreOrderShippingGroupDAO;
 	public void setRetailStoreOrderShippingGroupDAO(RetailStoreOrderShippingGroupDAO pRetailStoreOrderShippingGroupDAO){
 	
 		if(pRetailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderShippingGroupDAO to null.");
 		}
	 	this.retailStoreOrderShippingGroupDAO = pRetailStoreOrderShippingGroupDAO;
 	}
 	public RetailStoreOrderShippingGroupDAO getRetailStoreOrderShippingGroupDAO(){
 		if(this.retailStoreOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The retailStoreOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderShippingGroupDAO;
 	}	
 	
			
		
	
  	private  RetailStoreOrderPaymentGroupDAO  retailStoreOrderPaymentGroupDAO;
 	public void setRetailStoreOrderPaymentGroupDAO(RetailStoreOrderPaymentGroupDAO pRetailStoreOrderPaymentGroupDAO){
 	
 		if(pRetailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderPaymentGroupDAO to null.");
 		}
	 	this.retailStoreOrderPaymentGroupDAO = pRetailStoreOrderPaymentGroupDAO;
 	}
 	public RetailStoreOrderPaymentGroupDAO getRetailStoreOrderPaymentGroupDAO(){
 		if(this.retailStoreOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The retailStoreOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderPaymentGroupDAO;
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
 	
			
		

	
	/*
	protected RetailStoreOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrder(accessKey, options);
	}
	*/
	public RetailStoreOrder load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreOrder(RetailStoreOrderTable.withId(id), options);
	}
	
	
	
	public RetailStoreOrder save(RetailStoreOrder retailStoreOrder,Map<String,Object> options){
		
		String methodName="save(RetailStoreOrder retailStoreOrder,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreOrder, methodName, "retailStoreOrder");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreOrder(retailStoreOrder,options);
	}
	public RetailStoreOrder clone(String retailStoreOrderId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreOrderTable.withId(retailStoreOrderId),options);
	}
	
	protected RetailStoreOrder clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreOrderId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreOrder newRetailStoreOrder = loadInternalRetailStoreOrder(accessKey, options);
		newRetailStoreOrder.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreOrderLineItemListEnabled(options)){
 			for(RetailStoreOrderLineItem item: newRetailStoreOrder.getRetailStoreOrderLineItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreOrderShippingGroupListEnabled(options)){
 			for(RetailStoreOrderShippingGroup item: newRetailStoreOrder.getRetailStoreOrderShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreOrderPaymentGroupListEnabled(options)){
 			for(RetailStoreOrderPaymentGroup item: newRetailStoreOrder.getRetailStoreOrderPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newRetailStoreOrder.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreOrder(newRetailStoreOrder,options);
		
		return newRetailStoreOrder;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreOrderId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreOrderId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreOrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreOrderNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreOrderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreOrderId, int version) throws Exception{
	
		String methodName="delete(String retailStoreOrderId, int version)";
		assertMethodArgumentNotNull(retailStoreOrderId, methodName, "retailStoreOrderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreOrderId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreOrderId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"buyer","seller","title","total_amount","confirmation","approval","processing","picking","shipment","delivery","current_status"};
		return RetailStoreOrderTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_order";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreOrderTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBuyerEnabled = true;
 	//private static final String BUYER = "buyer";
 	protected boolean isExtractBuyerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.BUYER);
 	}
 	
 	
 	//private boolean saveBuyerEnabled = true;
 	protected boolean isSaveBuyerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.BUYER);
 	}
 	

 	
  
 	//private boolean extractSellerEnabled = true;
 	//private static final String SELLER = "seller";
 	protected boolean isExtractSellerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.SELLER);
 	}
 	
 	
 	//private boolean saveSellerEnabled = true;
 	protected boolean isSaveSellerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.SELLER);
 	}
 	

 	
  
 	//private boolean extractConfirmationEnabled = true;
 	//private static final String CONFIRMATION = "confirmation";
 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.CONFIRMATION);
 	}
 	
 	
 	//private boolean saveConfirmationEnabled = true;
 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.CONFIRMATION);
 	}
 	

 	
  
 	//private boolean extractApprovalEnabled = true;
 	//private static final String APPROVAL = "approval";
 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.APPROVAL);
 	}
 	
 	
 	//private boolean saveApprovalEnabled = true;
 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.APPROVAL);
 	}
 	

 	
  
 	//private boolean extractProcessingEnabled = true;
 	//private static final String PROCESSING = "processing";
 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.PROCESSING);
 	}
 	
 	
 	//private boolean saveProcessingEnabled = true;
 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.PROCESSING);
 	}
 	

 	
  
 	//private boolean extractPickingEnabled = true;
 	//private static final String PICKING = "picking";
 	protected boolean isExtractPickingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.PICKING);
 	}
 	
 	
 	//private boolean savePickingEnabled = true;
 	protected boolean isSavePickingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.PICKING);
 	}
 	

 	
  
 	//private boolean extractShipmentEnabled = true;
 	//private static final String SHIPMENT = "shipment";
 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.SHIPMENT);
 	}
 	
 	
 	//private boolean saveShipmentEnabled = true;
 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.SHIPMENT);
 	}
 	

 	
  
 	//private boolean extractDeliveryEnabled = true;
 	//private static final String DELIVERY = "delivery";
 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreOrderTokens.DELIVERY);
 	}
 	
 	
 	//private boolean saveDeliveryEnabled = true;
 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreOrderTokens.DELIVERY);
 	}
 	

 	
 
		
	//protected static final String RETAIL_STORE_ORDER_LINE_ITEM_LIST = "retailStoreOrderLineItemList";
	
	protected boolean isExtractRetailStoreOrderLineItemListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST = "retailStoreOrderShippingGroupList";
	
	protected boolean isExtractRetailStoreOrderShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST = "retailStoreOrderPaymentGroupList";
	
	protected boolean isExtractRetailStoreOrderPaymentGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreOrderTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreOrderTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreOrderMapper getRetailStoreOrderMapper(){
		return new RetailStoreOrderMapper();
	}
	protected RetailStoreOrder extractRetailStoreOrder(String retailStoreOrderId) throws Exception{
		String SQL = "select * from retail_store_order_data where id = ?";	
		try{
		
			RetailStoreOrder retailStoreOrder = queryForObject(SQL, new Object[]{retailStoreOrderId}, getRetailStoreOrderMapper());
			return retailStoreOrder;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderNotFoundException("RetailStoreOrder("+retailStoreOrderId+") is not found!");
		}
		
		
	}
	protected RetailStoreOrder extractRetailStoreOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_order_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreOrder retailStoreOrder = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreOrderMapper());
			return retailStoreOrder;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreOrderNotFoundException("RetailStoreOrder("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreOrder loadInternalRetailStoreOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreOrder retailStoreOrder = extractRetailStoreOrder(accessKey, loadOptions);
 	
 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractApprovalEnabled(loadOptions)){
	 		extractApproval(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractProcessingEnabled(loadOptions)){
	 		extractProcessing(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractPickingEnabled(loadOptions)){
	 		extractPicking(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractShipmentEnabled(loadOptions)){
	 		extractShipment(retailStoreOrder, loadOptions);
 		}
  	
 		if(isExtractDeliveryEnabled(loadOptions)){
	 		extractDelivery(retailStoreOrder, loadOptions);
 		}
 
		
		if(isExtractRetailStoreOrderLineItemListEnabled(loadOptions)){
	 		extractRetailStoreOrderLineItemList(retailStoreOrder, loadOptions);
 		}		
		
		if(isExtractRetailStoreOrderShippingGroupListEnabled(loadOptions)){
	 		extractRetailStoreOrderShippingGroupList(retailStoreOrder, loadOptions);
 		}		
		
		if(isExtractRetailStoreOrderPaymentGroupListEnabled(loadOptions)){
	 		extractRetailStoreOrderPaymentGroupList(retailStoreOrder, loadOptions);
 		}		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(retailStoreOrder, loadOptions);
 		}		
		
		return retailStoreOrder;
		
	}



	
	
	 

 	protected RetailStoreOrder extractBuyer(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getBuyer() == null){
			return retailStoreOrder;
		}
		String buyerId = retailStoreOrder.getBuyer().getId();
		if( buyerId == null){
			return retailStoreOrder;
		}
		RetailStore buyer = getRetailStoreDAO().load(buyerId,options);
		if(buyer != null){
			retailStoreOrder.setBuyer(buyer);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractSeller(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getSeller() == null){
			return retailStoreOrder;
		}
		String sellerId = retailStoreOrder.getSeller().getId();
		if( sellerId == null){
			return retailStoreOrder;
		}
		RetailStoreCountryCenter seller = getRetailStoreCountryCenterDAO().load(sellerId,options);
		if(seller != null){
			retailStoreOrder.setSeller(seller);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractConfirmation(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getConfirmation() == null){
			return retailStoreOrder;
		}
		String confirmationId = retailStoreOrder.getConfirmation().getId();
		if( confirmationId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderConfirmation confirmation = getRetailStoreOrderConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			retailStoreOrder.setConfirmation(confirmation);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractApproval(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getApproval() == null){
			return retailStoreOrder;
		}
		String approvalId = retailStoreOrder.getApproval().getId();
		if( approvalId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderApproval approval = getRetailStoreOrderApprovalDAO().load(approvalId,options);
		if(approval != null){
			retailStoreOrder.setApproval(approval);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractProcessing(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getProcessing() == null){
			return retailStoreOrder;
		}
		String processingId = retailStoreOrder.getProcessing().getId();
		if( processingId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderProcessing processing = getRetailStoreOrderProcessingDAO().load(processingId,options);
		if(processing != null){
			retailStoreOrder.setProcessing(processing);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractPicking(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getPicking() == null){
			return retailStoreOrder;
		}
		String pickingId = retailStoreOrder.getPicking().getId();
		if( pickingId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderPicking picking = getRetailStoreOrderPickingDAO().load(pickingId,options);
		if(picking != null){
			retailStoreOrder.setPicking(picking);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractShipment(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getShipment() == null){
			return retailStoreOrder;
		}
		String shipmentId = retailStoreOrder.getShipment().getId();
		if( shipmentId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderShipment shipment = getRetailStoreOrderShipmentDAO().load(shipmentId,options);
		if(shipment != null){
			retailStoreOrder.setShipment(shipment);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
  

 	protected RetailStoreOrder extractDelivery(RetailStoreOrder retailStoreOrder, Map<String,Object> options) throws Exception{

		if(retailStoreOrder.getDelivery() == null){
			return retailStoreOrder;
		}
		String deliveryId = retailStoreOrder.getDelivery().getId();
		if( deliveryId == null){
			return retailStoreOrder;
		}
		RetailStoreOrderDelivery delivery = getRetailStoreOrderDeliveryDAO().load(deliveryId,options);
		if(delivery != null){
			retailStoreOrder.setDelivery(delivery);
		}
		
 		
 		return retailStoreOrder;
 	}
 		
 
		
	protected RetailStoreOrder extractRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = getRetailStoreOrderLineItemDAO().findRetailStoreOrderLineItemByBizOrder(retailStoreOrder.getId(),options);
		if(retailStoreOrderLineItemList != null){
			retailStoreOrder.setRetailStoreOrderLineItemList(retailStoreOrderLineItemList);
		}
		
		return retailStoreOrder;
	
	}	
		
	protected RetailStoreOrder extractRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		
		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = getRetailStoreOrderShippingGroupDAO().findRetailStoreOrderShippingGroupByBizOrder(retailStoreOrder.getId(),options);
		if(retailStoreOrderShippingGroupList != null){
			retailStoreOrder.setRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList);
		}
		
		return retailStoreOrder;
	
	}	
		
	protected RetailStoreOrder extractRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		
		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = getRetailStoreOrderPaymentGroupDAO().findRetailStoreOrderPaymentGroupByBizOrder(retailStoreOrder.getId(),options);
		if(retailStoreOrderPaymentGroupList != null){
			retailStoreOrder.setRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList);
		}
		
		return retailStoreOrder;
	
	}	
		
	protected RetailStoreOrder extractGoodsList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByRetailStoreOrder(retailStoreOrder.getId(),options);
		if(goodsList != null){
			retailStoreOrder.setGoodsList(goodsList);
		}
		
		return retailStoreOrder;
	
	}	
		
		
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where buyer = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByBuyer(String retailStoreId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where buyer = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderByBuyer(String retailStoreId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where buyer = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where seller = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderBySeller(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where seller = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderBySeller(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where seller = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderConfirmationId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderConfirmationId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderByConfirmation(String retailStoreOrderConfirmationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where confirmation = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderConfirmationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where approval = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderApprovalId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByApproval(String retailStoreOrderApprovalId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where approval = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderApprovalId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderByApproval(String retailStoreOrderApprovalId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where approval = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderApprovalId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where processing = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderProcessingId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByProcessing(String retailStoreOrderProcessingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where processing = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderProcessingId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderByProcessing(String retailStoreOrderProcessingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where processing = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderProcessingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where picking = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderPickingId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByPicking(String retailStoreOrderPickingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where picking = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderPickingId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderByPicking(String retailStoreOrderPickingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where picking = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderPickingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipment = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderShipmentId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByShipment(String retailStoreOrderShipmentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipment = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderShipmentId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderByShipment(String retailStoreOrderShipmentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where shipment = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderShipmentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where delivery = ?";
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderDeliveryId}, getRetailStoreOrderMapper());	
 		return retailStoreOrderList;
 	}
 	
 	public SmartList<RetailStoreOrder> findRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where delivery = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreOrder> retailStoreOrderList = queryForList(SQL, new Object[]{retailStoreOrderDeliveryId,start, count}, getRetailStoreOrderMapper());
		
 		return retailStoreOrderList;
 	}
 	
 	public int countRetailStoreOrderByDelivery(String retailStoreOrderDeliveryId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where delivery = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderDeliveryId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreOrder saveRetailStoreOrder(RetailStoreOrder  retailStoreOrder){
	
		String SQL=this.getSaveRetailStoreOrderSQL(retailStoreOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreOrderParameters(retailStoreOrder);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreOrder.incVersion();
		return retailStoreOrder;
	
	}
	public SmartList<RetailStoreOrder> saveRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreOrderList(retailStoreOrderList);
		
		batchRetailStoreOrderCreate((List<RetailStoreOrder>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreOrderUpdate((List<RetailStoreOrder>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			if(retailStoreOrder.isChanged()){
				retailStoreOrder.incVersion();
			}
			
		
		}
		
		
		return retailStoreOrderList;
	}

	public SmartList<RetailStoreOrder> removeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		
		
		super.removeList(retailStoreOrderList, options);
		
		return retailStoreOrderList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreOrderBatchCreateArgs(List<RetailStoreOrder> retailStoreOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrder retailStoreOrder:retailStoreOrderList ){
			Object [] parameters = prepareRetailStoreOrderCreateParameters(retailStoreOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreOrderBatchUpdateArgs(List<RetailStoreOrder> retailStoreOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreOrder retailStoreOrder:retailStoreOrderList ){
			if(!retailStoreOrder.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreOrderUpdateParameters(retailStoreOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreOrderCreate(List<RetailStoreOrder> retailStoreOrderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreOrderBatchCreateArgs(retailStoreOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreOrderUpdate(List<RetailStoreOrder> retailStoreOrderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreOrderBatchUpdateArgs(retailStoreOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreOrderList(List<RetailStoreOrder> retailStoreOrderList){
		
		List<RetailStoreOrder> retailStoreOrderCreateList=new ArrayList<RetailStoreOrder>();
		List<RetailStoreOrder> retailStoreOrderUpdateList=new ArrayList<RetailStoreOrder>();
		
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderList){
			if(isUpdateRequest(retailStoreOrder)){
				retailStoreOrderUpdateList.add( retailStoreOrder);
				continue;
			}
			retailStoreOrderCreateList.add(retailStoreOrder);
		}
		
		return new Object[]{retailStoreOrderCreateList,retailStoreOrderUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreOrder retailStoreOrder){
 		return retailStoreOrder.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreOrderSQL(RetailStoreOrder retailStoreOrder){
 		if(isUpdateRequest(retailStoreOrder)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreOrderParameters(RetailStoreOrder retailStoreOrder){
 		if(isUpdateRequest(retailStoreOrder) ){
 			return prepareRetailStoreOrderUpdateParameters(retailStoreOrder);
 		}
 		return prepareRetailStoreOrderCreateParameters(retailStoreOrder);
 	}
 	protected Object[] prepareRetailStoreOrderUpdateParameters(RetailStoreOrder retailStoreOrder){
 		Object[] parameters = new Object[13];
  	
 		if(retailStoreOrder.getBuyer() != null){
 			parameters[0] = retailStoreOrder.getBuyer().getId();
 		}
  	
 		if(retailStoreOrder.getSeller() != null){
 			parameters[1] = retailStoreOrder.getSeller().getId();
 		}
 
 		parameters[2] = retailStoreOrder.getTitle();
 		parameters[3] = retailStoreOrder.getTotalAmount(); 	
 		if(retailStoreOrder.getConfirmation() != null){
 			parameters[4] = retailStoreOrder.getConfirmation().getId();
 		}
  	
 		if(retailStoreOrder.getApproval() != null){
 			parameters[5] = retailStoreOrder.getApproval().getId();
 		}
  	
 		if(retailStoreOrder.getProcessing() != null){
 			parameters[6] = retailStoreOrder.getProcessing().getId();
 		}
  	
 		if(retailStoreOrder.getPicking() != null){
 			parameters[7] = retailStoreOrder.getPicking().getId();
 		}
  	
 		if(retailStoreOrder.getShipment() != null){
 			parameters[8] = retailStoreOrder.getShipment().getId();
 		}
  	
 		if(retailStoreOrder.getDelivery() != null){
 			parameters[9] = retailStoreOrder.getDelivery().getId();
 		}
 
 		parameters[10] = retailStoreOrder.getCurrentStatus();		
 		parameters[11] = retailStoreOrder.getId();
 		parameters[12] = retailStoreOrder.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreOrderCreateParameters(RetailStoreOrder retailStoreOrder){
		Object[] parameters = new Object[12];
		String newRetailStoreOrderId=getNextId();
		retailStoreOrder.setId(newRetailStoreOrderId);
		parameters[0] =  retailStoreOrder.getId();
  	
 		if(retailStoreOrder.getBuyer() != null){
 			parameters[1] = retailStoreOrder.getBuyer().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getSeller() != null){
 			parameters[2] = retailStoreOrder.getSeller().getId();
 		
 		}
 		
 		parameters[3] = retailStoreOrder.getTitle();
 		parameters[4] = retailStoreOrder.getTotalAmount(); 	
 		if(retailStoreOrder.getConfirmation() != null){
 			parameters[5] = retailStoreOrder.getConfirmation().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getApproval() != null){
 			parameters[6] = retailStoreOrder.getApproval().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getProcessing() != null){
 			parameters[7] = retailStoreOrder.getProcessing().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getPicking() != null){
 			parameters[8] = retailStoreOrder.getPicking().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getShipment() != null){
 			parameters[9] = retailStoreOrder.getShipment().getId();
 		
 		}
 		 	
 		if(retailStoreOrder.getDelivery() != null){
 			parameters[10] = retailStoreOrder.getDelivery().getId();
 		
 		}
 		
 		parameters[11] = retailStoreOrder.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreOrder saveInternalRetailStoreOrder(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		
		saveRetailStoreOrder(retailStoreOrder);
 	
 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(retailStoreOrder, options);
 		}
  	
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(retailStoreOrder, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(retailStoreOrder, options);
 		}
  	
 		if(isSaveApprovalEnabled(options)){
	 		saveApproval(retailStoreOrder, options);
 		}
  	
 		if(isSaveProcessingEnabled(options)){
	 		saveProcessing(retailStoreOrder, options);
 		}
  	
 		if(isSavePickingEnabled(options)){
	 		savePicking(retailStoreOrder, options);
 		}
  	
 		if(isSaveShipmentEnabled(options)){
	 		saveShipment(retailStoreOrder, options);
 		}
  	
 		if(isSaveDeliveryEnabled(options)){
	 		saveDelivery(retailStoreOrder, options);
 		}
 
		
		if(isSaveRetailStoreOrderLineItemListEnabled(options)){
	 		saveRetailStoreOrderLineItemList(retailStoreOrder, options);
	 		removeRetailStoreOrderLineItemList(retailStoreOrder, options);
	 		
 		}		
		
		if(isSaveRetailStoreOrderShippingGroupListEnabled(options)){
	 		saveRetailStoreOrderShippingGroupList(retailStoreOrder, options);
	 		removeRetailStoreOrderShippingGroupList(retailStoreOrder, options);
	 		
 		}		
		
		if(isSaveRetailStoreOrderPaymentGroupListEnabled(options)){
	 		saveRetailStoreOrderPaymentGroupList(retailStoreOrder, options);
	 		removeRetailStoreOrderPaymentGroupList(retailStoreOrder, options);
	 		
 		}		
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(retailStoreOrder, options);
	 		removeGoodsList(retailStoreOrder, options);
	 		
 		}		
		
		return retailStoreOrder;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreOrder saveBuyer(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getBuyer() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreDAO().save(retailStoreOrder.getBuyer(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveSeller(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getSeller() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(retailStoreOrder.getSeller(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveConfirmation(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getConfirmation() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderConfirmationDAO().save(retailStoreOrder.getConfirmation(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveApproval(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getApproval() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderApprovalDAO().save(retailStoreOrder.getApproval(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveProcessing(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getProcessing() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderProcessingDAO().save(retailStoreOrder.getProcessing(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder savePicking(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getPicking() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderPickingDAO().save(retailStoreOrder.getPicking(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveShipment(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getShipment() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderShipmentDAO().save(retailStoreOrder.getShipment(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStoreOrder saveDelivery(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreOrder.getDelivery() == null){
 			return retailStoreOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDeliveryDAO().save(retailStoreOrder.getDelivery(),options);
 		return retailStoreOrder;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected RetailStoreOrder saveRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
		if(retailStoreOrderLineItemList == null){
			return retailStoreOrder;
		}
		if(retailStoreOrderLineItemList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderLineItemDAO().saveRetailStoreOrderLineItemList(retailStoreOrderLineItemList,options);
		
		return retailStoreOrder;
	
	}
	
	protected RetailStoreOrder removeRetailStoreOrderLineItemList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();
		if(retailStoreOrderLineItemList == null){
			return retailStoreOrder;
		}	
	
		SmartList<RetailStoreOrderLineItem> toRemoveRetailStoreOrderLineItemList = retailStoreOrderLineItemList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderLineItemList == null){
			return retailStoreOrder;
		}
		if(toRemoveRetailStoreOrderLineItemList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderLineItemDAO().removeRetailStoreOrderLineItemList(toRemoveRetailStoreOrderLineItemList,options);
		
		return retailStoreOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreOrder saveRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
		if(retailStoreOrderShippingGroupList == null){
			return retailStoreOrder;
		}
		if(retailStoreOrderShippingGroupList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderShippingGroupDAO().saveRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList,options);
		
		return retailStoreOrder;
	
	}
	
	protected RetailStoreOrder removeRetailStoreOrderShippingGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();
		if(retailStoreOrderShippingGroupList == null){
			return retailStoreOrder;
		}	
	
		SmartList<RetailStoreOrderShippingGroup> toRemoveRetailStoreOrderShippingGroupList = retailStoreOrderShippingGroupList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderShippingGroupList == null){
			return retailStoreOrder;
		}
		if(toRemoveRetailStoreOrderShippingGroupList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderShippingGroupDAO().removeRetailStoreOrderShippingGroupList(toRemoveRetailStoreOrderShippingGroupList,options);
		
		return retailStoreOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreOrder saveRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
		if(retailStoreOrderPaymentGroupList == null){
			return retailStoreOrder;
		}
		if(retailStoreOrderPaymentGroupList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderPaymentGroupDAO().saveRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList,options);
		
		return retailStoreOrder;
	
	}
	
	protected RetailStoreOrder removeRetailStoreOrderPaymentGroupList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();
		if(retailStoreOrderPaymentGroupList == null){
			return retailStoreOrder;
		}	
	
		SmartList<RetailStoreOrderPaymentGroup> toRemoveRetailStoreOrderPaymentGroupList = retailStoreOrderPaymentGroupList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderPaymentGroupList == null){
			return retailStoreOrder;
		}
		if(toRemoveRetailStoreOrderPaymentGroupList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderPaymentGroupDAO().removeRetailStoreOrderPaymentGroupList(toRemoveRetailStoreOrderPaymentGroupList,options);
		
		return retailStoreOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreOrder saveGoodsList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		if(goodsList == null){
			return retailStoreOrder;
		}
		if(goodsList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return retailStoreOrder;
	
	}
	
	protected RetailStoreOrder removeGoodsList(RetailStoreOrder retailStoreOrder, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();
		if(goodsList == null){
			return retailStoreOrder;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return retailStoreOrder;
		}
		if(toRemoveGoodsList.isEmpty()){
			return retailStoreOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return retailStoreOrder;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreOrder present(RetailStoreOrder retailStoreOrder,Map<String, Object> options){
	
		presentRetailStoreOrderLineItemList(retailStoreOrder,options);
		presentRetailStoreOrderShippingGroupList(retailStoreOrder,options);
		presentRetailStoreOrderPaymentGroupList(retailStoreOrder,options);
		presentGoodsList(retailStoreOrder,options);

		return retailStoreOrder;
	
	}
		
	
  	
 	protected RetailStoreOrder presentRetailStoreOrderLineItemList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {

		SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList = retailStoreOrder.getRetailStoreOrderLineItemList();		
		if(retailStoreOrderLineItemList == null){
			return retailStoreOrder;			
		}
		
		String targetObjectName = "retailStoreOrderLineItem";
		int retailStoreOrderLineItemListSize = retailStoreOrderLineItemList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderLineItemListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderLineItemListSize;
		if(retailStoreOrderLineItemListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderLineItemDAO().countRetailStoreOrderLineItemByBizOrder(retailStoreOrder.getId(), options);			
		}
		//retailStoreOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderLineItemListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderLineItemListSize,currentPage,rowsPerPage) ;
			retailStoreOrderLineItemList = retailStoreOrderLineItemList.subListOf(fromIndex, toIndex);
			retailStoreOrderLineItemList.setTotalCount(count);
			retailStoreOrderLineItemList.setCurrentPageNumber(currentPage);			
			retailStoreOrder.setRetailStoreOrderLineItemList(retailStoreOrderLineItemList);
			return retailStoreOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderLineItemList 
			= getRetailStoreOrderLineItemDAO().findRetailStoreOrderLineItemByBizOrder(retailStoreOrder.getId(),start, rowsPerPage, options );
		retailStoreOrderLineItemList.setTotalCount(count);
		retailStoreOrderLineItemList.setCurrentPageNumber(currentPage);
		retailStoreOrder.setRetailStoreOrderLineItemList(retailStoreOrderLineItemList );	

		return retailStoreOrder;
	}			
		
	
  	
 	protected RetailStoreOrder presentRetailStoreOrderShippingGroupList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {

		SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList = retailStoreOrder.getRetailStoreOrderShippingGroupList();		
		if(retailStoreOrderShippingGroupList == null){
			return retailStoreOrder;			
		}
		
		String targetObjectName = "retailStoreOrderShippingGroup";
		int retailStoreOrderShippingGroupListSize = retailStoreOrderShippingGroupList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderShippingGroupListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderShippingGroupListSize;
		if(retailStoreOrderShippingGroupListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderShippingGroupDAO().countRetailStoreOrderShippingGroupByBizOrder(retailStoreOrder.getId(), options);			
		}
		//retailStoreOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderShippingGroupListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderShippingGroupListSize,currentPage,rowsPerPage) ;
			retailStoreOrderShippingGroupList = retailStoreOrderShippingGroupList.subListOf(fromIndex, toIndex);
			retailStoreOrderShippingGroupList.setTotalCount(count);
			retailStoreOrderShippingGroupList.setCurrentPageNumber(currentPage);			
			retailStoreOrder.setRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList);
			return retailStoreOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderShippingGroupList 
			= getRetailStoreOrderShippingGroupDAO().findRetailStoreOrderShippingGroupByBizOrder(retailStoreOrder.getId(),start, rowsPerPage, options );
		retailStoreOrderShippingGroupList.setTotalCount(count);
		retailStoreOrderShippingGroupList.setCurrentPageNumber(currentPage);
		retailStoreOrder.setRetailStoreOrderShippingGroupList(retailStoreOrderShippingGroupList );	

		return retailStoreOrder;
	}			
		
	
  	
 	protected RetailStoreOrder presentRetailStoreOrderPaymentGroupList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {

		SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList = retailStoreOrder.getRetailStoreOrderPaymentGroupList();		
		if(retailStoreOrderPaymentGroupList == null){
			return retailStoreOrder;			
		}
		
		String targetObjectName = "retailStoreOrderPaymentGroup";
		int retailStoreOrderPaymentGroupListSize = retailStoreOrderPaymentGroupList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderPaymentGroupListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderPaymentGroupListSize;
		if(retailStoreOrderPaymentGroupListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderPaymentGroupDAO().countRetailStoreOrderPaymentGroupByBizOrder(retailStoreOrder.getId(), options);			
		}
		//retailStoreOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderPaymentGroupListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderPaymentGroupListSize,currentPage,rowsPerPage) ;
			retailStoreOrderPaymentGroupList = retailStoreOrderPaymentGroupList.subListOf(fromIndex, toIndex);
			retailStoreOrderPaymentGroupList.setTotalCount(count);
			retailStoreOrderPaymentGroupList.setCurrentPageNumber(currentPage);			
			retailStoreOrder.setRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList);
			return retailStoreOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderPaymentGroupList 
			= getRetailStoreOrderPaymentGroupDAO().findRetailStoreOrderPaymentGroupByBizOrder(retailStoreOrder.getId(),start, rowsPerPage, options );
		retailStoreOrderPaymentGroupList.setTotalCount(count);
		retailStoreOrderPaymentGroupList.setCurrentPageNumber(currentPage);
		retailStoreOrder.setRetailStoreOrderPaymentGroupList(retailStoreOrderPaymentGroupList );	

		return retailStoreOrder;
	}			
		
	
  	
 	protected RetailStoreOrder presentGoodsList(
			RetailStoreOrder retailStoreOrder,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = retailStoreOrder.getGoodsList();		
		if(goodsList == null){
			return retailStoreOrder;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByRetailStoreOrder(retailStoreOrder.getId(), options);			
		}
		//retailStoreOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			retailStoreOrder.setGoodsList(goodsList);
			return retailStoreOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByRetailStoreOrder(retailStoreOrder.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		retailStoreOrder.setGoodsList(goodsList );	

		return retailStoreOrder;
	}			
		


	protected String getTableName(){
		return RetailStoreOrderTable.TABLE_NAME;
	}
}


