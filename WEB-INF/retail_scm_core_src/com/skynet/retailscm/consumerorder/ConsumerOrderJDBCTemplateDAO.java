
package com.skynet.retailscm.consumerorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;

import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationDAO;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupDAO;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingDAO;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentDAO;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryDAO;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalDAO;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentDAO;
import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItemDAO;

import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalTable;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTable;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryTable;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingTable;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentTable;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupTable;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentTable;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationTable;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupTable;
import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItemTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ConsumerOrderJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ConsumerOrderDAO{
 
 	
 	private  SupplyOrderApprovalDAO  supplyOrderApprovalDAO;
 	public void setSupplyOrderApprovalDAO(SupplyOrderApprovalDAO supplyOrderApprovalDAO){
	 	this.supplyOrderApprovalDAO = supplyOrderApprovalDAO;
 	}
 	public SupplyOrderApprovalDAO getSupplyOrderApprovalDAO(){
	 	return this.supplyOrderApprovalDAO;
 	}
 
 	
 	private  SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO;
 	public void setSupplyOrderDeliveryDAO(SupplyOrderDeliveryDAO supplyOrderDeliveryDAO){
	 	this.supplyOrderDeliveryDAO = supplyOrderDeliveryDAO;
 	}
 	public SupplyOrderDeliveryDAO getSupplyOrderDeliveryDAO(){
	 	return this.supplyOrderDeliveryDAO;
 	}
 
 	
 	private  SupplyOrderShipmentDAO  supplyOrderShipmentDAO;
 	public void setSupplyOrderShipmentDAO(SupplyOrderShipmentDAO supplyOrderShipmentDAO){
	 	this.supplyOrderShipmentDAO = supplyOrderShipmentDAO;
 	}
 	public SupplyOrderShipmentDAO getSupplyOrderShipmentDAO(){
	 	return this.supplyOrderShipmentDAO;
 	}
 
 	
 	private  SupplyOrderConfirmationDAO  supplyOrderConfirmationDAO;
 	public void setSupplyOrderConfirmationDAO(SupplyOrderConfirmationDAO supplyOrderConfirmationDAO){
	 	this.supplyOrderConfirmationDAO = supplyOrderConfirmationDAO;
 	}
 	public SupplyOrderConfirmationDAO getSupplyOrderConfirmationDAO(){
	 	return this.supplyOrderConfirmationDAO;
 	}
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  SupplyOrderProcessingDAO  supplyOrderProcessingDAO;
 	public void setSupplyOrderProcessingDAO(SupplyOrderProcessingDAO supplyOrderProcessingDAO){
	 	this.supplyOrderProcessingDAO = supplyOrderProcessingDAO;
 	}
 	public SupplyOrderProcessingDAO getSupplyOrderProcessingDAO(){
	 	return this.supplyOrderProcessingDAO;
 	}

		
	
  	private  ConsumerOrderLineItemDAO  consumerOrderLineItemDAO;
 	public void setConsumerOrderLineItemDAO(ConsumerOrderLineItemDAO pConsumerOrderLineItemDAO){
 	
 		if(pConsumerOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderLineItemDAO to null.");
 		}
	 	this.consumerOrderLineItemDAO = pConsumerOrderLineItemDAO;
 	}
 	public ConsumerOrderLineItemDAO getConsumerOrderLineItemDAO(){
 		if(this.consumerOrderLineItemDAO == null){
 			throw new IllegalStateException("The consumerOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderLineItemDAO;
 	}	
 	
			
		
	
  	private  ConsumerOrderShippingGroupDAO  consumerOrderShippingGroupDAO;
 	public void setConsumerOrderShippingGroupDAO(ConsumerOrderShippingGroupDAO pConsumerOrderShippingGroupDAO){
 	
 		if(pConsumerOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderShippingGroupDAO to null.");
 		}
	 	this.consumerOrderShippingGroupDAO = pConsumerOrderShippingGroupDAO;
 	}
 	public ConsumerOrderShippingGroupDAO getConsumerOrderShippingGroupDAO(){
 		if(this.consumerOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The consumerOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderShippingGroupDAO;
 	}	
 	
			
		
	
  	private  ConsumerOrderPaymentGroupDAO  consumerOrderPaymentGroupDAO;
 	public void setConsumerOrderPaymentGroupDAO(ConsumerOrderPaymentGroupDAO pConsumerOrderPaymentGroupDAO){
 	
 		if(pConsumerOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderPaymentGroupDAO to null.");
 		}
	 	this.consumerOrderPaymentGroupDAO = pConsumerOrderPaymentGroupDAO;
 	}
 	public ConsumerOrderPaymentGroupDAO getConsumerOrderPaymentGroupDAO(){
 		if(this.consumerOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The consumerOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderPaymentGroupDAO;
 	}	
 	
			
		
	
  	private  ConsumerOrderPriceAdjustmentDAO  consumerOrderPriceAdjustmentDAO;
 	public void setConsumerOrderPriceAdjustmentDAO(ConsumerOrderPriceAdjustmentDAO pConsumerOrderPriceAdjustmentDAO){
 	
 		if(pConsumerOrderPriceAdjustmentDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderPriceAdjustmentDAO to null.");
 		}
	 	this.consumerOrderPriceAdjustmentDAO = pConsumerOrderPriceAdjustmentDAO;
 	}
 	public ConsumerOrderPriceAdjustmentDAO getConsumerOrderPriceAdjustmentDAO(){
 		if(this.consumerOrderPriceAdjustmentDAO == null){
 			throw new IllegalStateException("The consumerOrderPriceAdjustmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.consumerOrderPriceAdjustmentDAO;
 	}	
 	
			
		
	
  	private  RetailStoreMemberGiftCardConsumeRecordDAO  retailStoreMemberGiftCardConsumeRecordDAO;
 	public void setRetailStoreMemberGiftCardConsumeRecordDAO(RetailStoreMemberGiftCardConsumeRecordDAO pRetailStoreMemberGiftCardConsumeRecordDAO){
 	
 		if(pRetailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardConsumeRecordDAO to null.");
 		}
	 	this.retailStoreMemberGiftCardConsumeRecordDAO = pRetailStoreMemberGiftCardConsumeRecordDAO;
 	}
 	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO(){
 		if(this.retailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("The retailStoreMemberGiftCardConsumeRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberGiftCardConsumeRecordDAO;
 	}	
 	
			
		

	
	/*
	protected ConsumerOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrder(accessKey, options);
	}
	*/
	public ConsumerOrder load(String id,Map<String,Object> options) throws Exception{
		return loadInternalConsumerOrder(ConsumerOrderTable.withId(id), options);
	}
	
	
	
	public ConsumerOrder save(ConsumerOrder consumerOrder,Map<String,Object> options){
		
		String methodName="save(ConsumerOrder consumerOrder,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(consumerOrder, methodName, "consumerOrder");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalConsumerOrder(consumerOrder,options);
	}
	public ConsumerOrder clone(String consumerOrderId, Map<String,Object> options) throws Exception{
	
		return clone(ConsumerOrderTable.withId(consumerOrderId),options);
	}
	
	protected ConsumerOrder clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String consumerOrderId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ConsumerOrder newConsumerOrder = loadInternalConsumerOrder(accessKey, options);
		newConsumerOrder.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderLineItemListEnabled(options)){
 			for(ConsumerOrderLineItem item: newConsumerOrder.getConsumerOrderLineItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveConsumerOrderShippingGroupListEnabled(options)){
 			for(ConsumerOrderShippingGroup item: newConsumerOrder.getConsumerOrderShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveConsumerOrderPaymentGroupListEnabled(options)){
 			for(ConsumerOrderPaymentGroup item: newConsumerOrder.getConsumerOrderPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveConsumerOrderPriceAdjustmentListEnabled(options)){
 			for(ConsumerOrderPriceAdjustment item: newConsumerOrder.getConsumerOrderPriceAdjustmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)){
 			for(RetailStoreMemberGiftCardConsumeRecord item: newConsumerOrder.getRetailStoreMemberGiftCardConsumeRecordList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalConsumerOrder(newConsumerOrder,options);
		
		return newConsumerOrder;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String consumerOrderId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{consumerOrderId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ConsumerOrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ConsumerOrderNotFoundException(
					"The " + this.getTableName() + "(" + consumerOrderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String consumerOrderId, int version) throws Exception{
	
		String methodName="delete(String consumerOrderId, int version)";
		assertMethodArgumentNotNull(consumerOrderId, methodName, "consumerOrderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{consumerOrderId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(consumerOrderId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"title","consumer","confirmation","approval","processing","shipment","delivery","store","current_status"};
		return ConsumerOrderTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "consumer_order";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ConsumerOrderTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractConsumerEnabled = true;
 	//private static final String CONSUMER = "consumer";
 	protected boolean isExtractConsumerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.CONSUMER);
 	}
 	
 	
 	//private boolean saveConsumerEnabled = true;
 	protected boolean isSaveConsumerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.CONSUMER);
 	}
 	

 	
  
 	//private boolean extractConfirmationEnabled = true;
 	//private static final String CONFIRMATION = "confirmation";
 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.CONFIRMATION);
 	}
 	
 	
 	//private boolean saveConfirmationEnabled = true;
 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.CONFIRMATION);
 	}
 	

 	
  
 	//private boolean extractApprovalEnabled = true;
 	//private static final String APPROVAL = "approval";
 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.APPROVAL);
 	}
 	
 	
 	//private boolean saveApprovalEnabled = true;
 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.APPROVAL);
 	}
 	

 	
  
 	//private boolean extractProcessingEnabled = true;
 	//private static final String PROCESSING = "processing";
 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.PROCESSING);
 	}
 	
 	
 	//private boolean saveProcessingEnabled = true;
 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.PROCESSING);
 	}
 	

 	
  
 	//private boolean extractShipmentEnabled = true;
 	//private static final String SHIPMENT = "shipment";
 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.SHIPMENT);
 	}
 	
 	
 	//private boolean saveShipmentEnabled = true;
 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.SHIPMENT);
 	}
 	

 	
  
 	//private boolean extractDeliveryEnabled = true;
 	//private static final String DELIVERY = "delivery";
 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.DELIVERY);
 	}
 	
 	
 	//private boolean saveDeliveryEnabled = true;
 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.DELIVERY);
 	}
 	

 	
  
 	//private boolean extractStoreEnabled = true;
 	//private static final String STORE = "store";
 	protected boolean isExtractStoreEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ConsumerOrderTokens.STORE);
 	}
 	
 	
 	//private boolean saveStoreEnabled = true;
 	protected boolean isSaveStoreEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ConsumerOrderTokens.STORE);
 	}
 	

 	
 
		
	//protected static final String CONSUMER_ORDER_LINE_ITEM_LIST = "consumerOrderLineItemList";
	
	protected boolean isExtractConsumerOrderLineItemListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveConsumerOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CONSUMER_ORDER_SHIPPING_GROUP_LIST = "consumerOrderShippingGroupList";
	
	protected boolean isExtractConsumerOrderShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveConsumerOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CONSUMER_ORDER_PAYMENT_GROUP_LIST = "consumerOrderPaymentGroupList";
	
	protected boolean isExtractConsumerOrderPaymentGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSaveConsumerOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST = "consumerOrderPriceAdjustmentList";
	
	protected boolean isExtractConsumerOrderPriceAdjustmentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ConsumerOrderTokens.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
		
 	}

	protected boolean isSaveConsumerOrderPriceAdjustmentListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";
	
	protected boolean isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ConsumerOrderTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		
 	}

	protected boolean isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, ConsumerOrderTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		
 	}
 	
 	
			
		

	

	protected ConsumerOrderMapper getConsumerOrderMapper(){
		return new ConsumerOrderMapper();
	}
	protected ConsumerOrder extractConsumerOrder(String consumerOrderId) throws Exception{
		String SQL = "select * from consumer_order_data where id = ?";	
		try{
		
			ConsumerOrder consumerOrder = queryForObject(SQL, new Object[]{consumerOrderId}, getConsumerOrderMapper());
			return consumerOrder;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderNotFoundException("ConsumerOrder("+consumerOrderId+") is not found!");
		}
		
		
	}
	protected ConsumerOrder extractConsumerOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from consumer_order_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ConsumerOrder consumerOrder = queryForObject(SQL, new Object[]{accessKey.getValue()}, getConsumerOrderMapper());
			return consumerOrder;
		}catch(EmptyResultDataAccessException e){
			throw new ConsumerOrderNotFoundException("ConsumerOrder("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ConsumerOrder loadInternalConsumerOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ConsumerOrder consumerOrder = extractConsumerOrder(accessKey, loadOptions);
 	
 		if(isExtractConsumerEnabled(loadOptions)){
	 		extractConsumer(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractApprovalEnabled(loadOptions)){
	 		extractApproval(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractProcessingEnabled(loadOptions)){
	 		extractProcessing(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractShipmentEnabled(loadOptions)){
	 		extractShipment(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractDeliveryEnabled(loadOptions)){
	 		extractDelivery(consumerOrder, loadOptions);
 		}
  	
 		if(isExtractStoreEnabled(loadOptions)){
	 		extractStore(consumerOrder, loadOptions);
 		}
 
		
		if(isExtractConsumerOrderLineItemListEnabled(loadOptions)){
	 		extractConsumerOrderLineItemList(consumerOrder, loadOptions);
 		}		
		
		if(isExtractConsumerOrderShippingGroupListEnabled(loadOptions)){
	 		extractConsumerOrderShippingGroupList(consumerOrder, loadOptions);
 		}		
		
		if(isExtractConsumerOrderPaymentGroupListEnabled(loadOptions)){
	 		extractConsumerOrderPaymentGroupList(consumerOrder, loadOptions);
 		}		
		
		if(isExtractConsumerOrderPriceAdjustmentListEnabled(loadOptions)){
	 		extractConsumerOrderPriceAdjustmentList(consumerOrder, loadOptions);
 		}		
		
		if(isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(loadOptions)){
	 		extractRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, loadOptions);
 		}		
		
		return consumerOrder;
		
	}



	
	
	 

 	protected ConsumerOrder extractConsumer(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getConsumer() == null){
			return consumerOrder;
		}
		String consumerId = consumerOrder.getConsumer().getId();
		if( consumerId == null){
			return consumerOrder;
		}
		RetailStoreMember consumer = getRetailStoreMemberDAO().load(consumerId,options);
		if(consumer != null){
			consumerOrder.setConsumer(consumer);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractConfirmation(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getConfirmation() == null){
			return consumerOrder;
		}
		String confirmationId = consumerOrder.getConfirmation().getId();
		if( confirmationId == null){
			return consumerOrder;
		}
		SupplyOrderConfirmation confirmation = getSupplyOrderConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			consumerOrder.setConfirmation(confirmation);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractApproval(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getApproval() == null){
			return consumerOrder;
		}
		String approvalId = consumerOrder.getApproval().getId();
		if( approvalId == null){
			return consumerOrder;
		}
		SupplyOrderApproval approval = getSupplyOrderApprovalDAO().load(approvalId,options);
		if(approval != null){
			consumerOrder.setApproval(approval);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractProcessing(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getProcessing() == null){
			return consumerOrder;
		}
		String processingId = consumerOrder.getProcessing().getId();
		if( processingId == null){
			return consumerOrder;
		}
		SupplyOrderProcessing processing = getSupplyOrderProcessingDAO().load(processingId,options);
		if(processing != null){
			consumerOrder.setProcessing(processing);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractShipment(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getShipment() == null){
			return consumerOrder;
		}
		String shipmentId = consumerOrder.getShipment().getId();
		if( shipmentId == null){
			return consumerOrder;
		}
		SupplyOrderShipment shipment = getSupplyOrderShipmentDAO().load(shipmentId,options);
		if(shipment != null){
			consumerOrder.setShipment(shipment);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractDelivery(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getDelivery() == null){
			return consumerOrder;
		}
		String deliveryId = consumerOrder.getDelivery().getId();
		if( deliveryId == null){
			return consumerOrder;
		}
		SupplyOrderDelivery delivery = getSupplyOrderDeliveryDAO().load(deliveryId,options);
		if(delivery != null){
			consumerOrder.setDelivery(delivery);
		}
		
 		
 		return consumerOrder;
 	}
 		
  

 	protected ConsumerOrder extractStore(ConsumerOrder consumerOrder, Map<String,Object> options) throws Exception{

		if(consumerOrder.getStore() == null){
			return consumerOrder;
		}
		String storeId = consumerOrder.getStore().getId();
		if( storeId == null){
			return consumerOrder;
		}
		RetailStore store = getRetailStoreDAO().load(storeId,options);
		if(store != null){
			consumerOrder.setStore(store);
		}
		
 		
 		return consumerOrder;
 	}
 		
 
		
	protected ConsumerOrder extractConsumerOrderLineItemList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = getConsumerOrderLineItemDAO().findConsumerOrderLineItemByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderLineItemList != null){
			consumerOrder.setConsumerOrderLineItemList(consumerOrderLineItemList);
		}
		
		return consumerOrder;
	
	}	
		
	protected ConsumerOrder extractConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = getConsumerOrderShippingGroupDAO().findConsumerOrderShippingGroupByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderShippingGroupList != null){
			consumerOrder.setConsumerOrderShippingGroupList(consumerOrderShippingGroupList);
		}
		
		return consumerOrder;
	
	}	
		
	protected ConsumerOrder extractConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = getConsumerOrderPaymentGroupDAO().findConsumerOrderPaymentGroupByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderPaymentGroupList != null){
			consumerOrder.setConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList);
		}
		
		return consumerOrder;
	
	}	
		
	protected ConsumerOrder extractConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = getConsumerOrderPriceAdjustmentDAO().findConsumerOrderPriceAdjustmentByBizOrder(consumerOrder.getId(),options);
		if(consumerOrderPriceAdjustmentList != null){
			consumerOrder.setConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList);
		}
		
		return consumerOrder;
	
	}	
		
	protected ConsumerOrder extractRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = getRetailStoreMemberGiftCardConsumeRecordDAO().findRetailStoreMemberGiftCardConsumeRecordByBizOrder(consumerOrder.getId(),options);
		if(retailStoreMemberGiftCardConsumeRecordList != null){
			consumerOrder.setRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList);
		}
		
		return consumerOrder;
	
	}	
		
		
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where consumer = ?";
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{retailStoreMemberId}, getConsumerOrderMapper());	
 		return consumerOrderList;
 	}
 	
 	public SmartList<ConsumerOrder> findConsumerOrderByConsumer(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where consumer = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{retailStoreMemberId,start, count}, getConsumerOrderMapper());
		
 		return consumerOrderList;
 	}
 	
 	public int countConsumerOrderByConsumer(String retailStoreMemberId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where consumer = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ?";
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderConfirmationId}, getConsumerOrderMapper());	
 		return consumerOrderList;
 	}
 	
 	public SmartList<ConsumerOrder> findConsumerOrderByConfirmation(String supplyOrderConfirmationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderConfirmationId,start, count}, getConsumerOrderMapper());
		
 		return consumerOrderList;
 	}
 	
 	public int countConsumerOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where confirmation = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderConfirmationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where approval = ?";
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderApprovalId}, getConsumerOrderMapper());	
 		return consumerOrderList;
 	}
 	
 	public SmartList<ConsumerOrder> findConsumerOrderByApproval(String supplyOrderApprovalId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where approval = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderApprovalId,start, count}, getConsumerOrderMapper());
		
 		return consumerOrderList;
 	}
 	
 	public int countConsumerOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where approval = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderApprovalId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where processing = ?";
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderProcessingId}, getConsumerOrderMapper());	
 		return consumerOrderList;
 	}
 	
 	public SmartList<ConsumerOrder> findConsumerOrderByProcessing(String supplyOrderProcessingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where processing = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderProcessingId,start, count}, getConsumerOrderMapper());
		
 		return consumerOrderList;
 	}
 	
 	public int countConsumerOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where processing = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderProcessingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipment = ?";
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderShipmentId}, getConsumerOrderMapper());	
 		return consumerOrderList;
 	}
 	
 	public SmartList<ConsumerOrder> findConsumerOrderByShipment(String supplyOrderShipmentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipment = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderShipmentId,start, count}, getConsumerOrderMapper());
		
 		return consumerOrderList;
 	}
 	
 	public int countConsumerOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where shipment = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderShipmentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where delivery = ?";
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderDeliveryId}, getConsumerOrderMapper());	
 		return consumerOrderList;
 	}
 	
 	public SmartList<ConsumerOrder> findConsumerOrderByDelivery(String supplyOrderDeliveryId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where delivery = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{supplyOrderDeliveryId,start, count}, getConsumerOrderMapper());
		
 		return consumerOrderList;
 	}
 	
 	public int countConsumerOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where delivery = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderDeliveryId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where store = ?";
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{retailStoreId}, getConsumerOrderMapper());	
 		return consumerOrderList;
 	}
 	
 	public SmartList<ConsumerOrder> findConsumerOrderByStore(String retailStoreId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where store = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ConsumerOrder> consumerOrderList = queryForList(SQL, new Object[]{retailStoreId,start, count}, getConsumerOrderMapper());
		
 		return consumerOrderList;
 	}
 	
 	public int countConsumerOrderByStore(String retailStoreId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where store = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ConsumerOrder saveConsumerOrder(ConsumerOrder  consumerOrder){
	
		String SQL=this.getSaveConsumerOrderSQL(consumerOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveConsumerOrderParameters(consumerOrder);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		consumerOrder.incVersion();
		return consumerOrder;
	
	}
	public SmartList<ConsumerOrder> saveConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitConsumerOrderList(consumerOrderList);
		
		batchConsumerOrderCreate((List<ConsumerOrder>)lists[CREATE_LIST_INDEX]);
		
		batchConsumerOrderUpdate((List<ConsumerOrder>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ConsumerOrder consumerOrder:consumerOrderList){
			if(consumerOrder.isChanged()){
				consumerOrder.incVersion();
			}
			
		
		}
		
		
		return consumerOrderList;
	}

	public SmartList<ConsumerOrder> removeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		
		
		super.removeList(consumerOrderList, options);
		
		return consumerOrderList;
		
		
	}
	
	protected List<Object[]> prepareConsumerOrderBatchCreateArgs(List<ConsumerOrder> consumerOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrder consumerOrder:consumerOrderList ){
			Object [] parameters = prepareConsumerOrderCreateParameters(consumerOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareConsumerOrderBatchUpdateArgs(List<ConsumerOrder> consumerOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ConsumerOrder consumerOrder:consumerOrderList ){
			if(!consumerOrder.isChanged()){
				continue;
			}
			Object [] parameters = prepareConsumerOrderUpdateParameters(consumerOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchConsumerOrderCreate(List<ConsumerOrder> consumerOrderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareConsumerOrderBatchCreateArgs(consumerOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchConsumerOrderUpdate(List<ConsumerOrder> consumerOrderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareConsumerOrderBatchUpdateArgs(consumerOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitConsumerOrderList(List<ConsumerOrder> consumerOrderList){
		
		List<ConsumerOrder> consumerOrderCreateList=new ArrayList<ConsumerOrder>();
		List<ConsumerOrder> consumerOrderUpdateList=new ArrayList<ConsumerOrder>();
		
		for(ConsumerOrder consumerOrder: consumerOrderList){
			if(isUpdateRequest(consumerOrder)){
				consumerOrderUpdateList.add( consumerOrder);
				continue;
			}
			consumerOrderCreateList.add(consumerOrder);
		}
		
		return new Object[]{consumerOrderCreateList,consumerOrderUpdateList};
	}
	
	protected boolean isUpdateRequest(ConsumerOrder consumerOrder){
 		return consumerOrder.getVersion() > 0;
 	}
 	protected String getSaveConsumerOrderSQL(ConsumerOrder consumerOrder){
 		if(isUpdateRequest(consumerOrder)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveConsumerOrderParameters(ConsumerOrder consumerOrder){
 		if(isUpdateRequest(consumerOrder) ){
 			return prepareConsumerOrderUpdateParameters(consumerOrder);
 		}
 		return prepareConsumerOrderCreateParameters(consumerOrder);
 	}
 	protected Object[] prepareConsumerOrderUpdateParameters(ConsumerOrder consumerOrder){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = consumerOrder.getTitle(); 	
 		if(consumerOrder.getConsumer() != null){
 			parameters[1] = consumerOrder.getConsumer().getId();
 		}
  	
 		if(consumerOrder.getConfirmation() != null){
 			parameters[2] = consumerOrder.getConfirmation().getId();
 		}
  	
 		if(consumerOrder.getApproval() != null){
 			parameters[3] = consumerOrder.getApproval().getId();
 		}
  	
 		if(consumerOrder.getProcessing() != null){
 			parameters[4] = consumerOrder.getProcessing().getId();
 		}
  	
 		if(consumerOrder.getShipment() != null){
 			parameters[5] = consumerOrder.getShipment().getId();
 		}
  	
 		if(consumerOrder.getDelivery() != null){
 			parameters[6] = consumerOrder.getDelivery().getId();
 		}
  	
 		if(consumerOrder.getStore() != null){
 			parameters[7] = consumerOrder.getStore().getId();
 		}
 
 		parameters[8] = consumerOrder.getCurrentStatus();		
 		parameters[9] = consumerOrder.getId();
 		parameters[10] = consumerOrder.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareConsumerOrderCreateParameters(ConsumerOrder consumerOrder){
		Object[] parameters = new Object[10];
		String newConsumerOrderId=getNextId();
		consumerOrder.setId(newConsumerOrderId);
		parameters[0] =  consumerOrder.getId();
 
 		parameters[1] = consumerOrder.getTitle(); 	
 		if(consumerOrder.getConsumer() != null){
 			parameters[2] = consumerOrder.getConsumer().getId();
 		
 		}
 		 	
 		if(consumerOrder.getConfirmation() != null){
 			parameters[3] = consumerOrder.getConfirmation().getId();
 		
 		}
 		 	
 		if(consumerOrder.getApproval() != null){
 			parameters[4] = consumerOrder.getApproval().getId();
 		
 		}
 		 	
 		if(consumerOrder.getProcessing() != null){
 			parameters[5] = consumerOrder.getProcessing().getId();
 		
 		}
 		 	
 		if(consumerOrder.getShipment() != null){
 			parameters[6] = consumerOrder.getShipment().getId();
 		
 		}
 		 	
 		if(consumerOrder.getDelivery() != null){
 			parameters[7] = consumerOrder.getDelivery().getId();
 		
 		}
 		 	
 		if(consumerOrder.getStore() != null){
 			parameters[8] = consumerOrder.getStore().getId();
 		
 		}
 		
 		parameters[9] = consumerOrder.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected ConsumerOrder saveInternalConsumerOrder(ConsumerOrder consumerOrder, Map<String,Object> options){
		
		saveConsumerOrder(consumerOrder);
 	
 		if(isSaveConsumerEnabled(options)){
	 		saveConsumer(consumerOrder, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(consumerOrder, options);
 		}
  	
 		if(isSaveApprovalEnabled(options)){
	 		saveApproval(consumerOrder, options);
 		}
  	
 		if(isSaveProcessingEnabled(options)){
	 		saveProcessing(consumerOrder, options);
 		}
  	
 		if(isSaveShipmentEnabled(options)){
	 		saveShipment(consumerOrder, options);
 		}
  	
 		if(isSaveDeliveryEnabled(options)){
	 		saveDelivery(consumerOrder, options);
 		}
  	
 		if(isSaveStoreEnabled(options)){
	 		saveStore(consumerOrder, options);
 		}
 
		
		if(isSaveConsumerOrderLineItemListEnabled(options)){
	 		saveConsumerOrderLineItemList(consumerOrder, options);
	 		removeConsumerOrderLineItemList(consumerOrder, options);
	 		
 		}		
		
		if(isSaveConsumerOrderShippingGroupListEnabled(options)){
	 		saveConsumerOrderShippingGroupList(consumerOrder, options);
	 		removeConsumerOrderShippingGroupList(consumerOrder, options);
	 		
 		}		
		
		if(isSaveConsumerOrderPaymentGroupListEnabled(options)){
	 		saveConsumerOrderPaymentGroupList(consumerOrder, options);
	 		removeConsumerOrderPaymentGroupList(consumerOrder, options);
	 		
 		}		
		
		if(isSaveConsumerOrderPriceAdjustmentListEnabled(options)){
	 		saveConsumerOrderPriceAdjustmentList(consumerOrder, options);
	 		removeConsumerOrderPriceAdjustmentList(consumerOrder, options);
	 		
 		}		
		
		if(isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)){
	 		saveRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, options);
	 		removeRetailStoreMemberGiftCardConsumeRecordList(consumerOrder, options);
	 		
 		}		
		
		return consumerOrder;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ConsumerOrder saveConsumer(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getConsumer() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(consumerOrder.getConsumer(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveConfirmation(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getConfirmation() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderConfirmationDAO().save(consumerOrder.getConfirmation(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveApproval(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getApproval() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderApprovalDAO().save(consumerOrder.getApproval(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveProcessing(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getProcessing() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderProcessingDAO().save(consumerOrder.getProcessing(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveShipment(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getShipment() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderShipmentDAO().save(consumerOrder.getShipment(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveDelivery(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getDelivery() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderDeliveryDAO().save(consumerOrder.getDelivery(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ConsumerOrder saveStore(ConsumerOrder consumerOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(consumerOrder.getStore() == null){
 			return consumerOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreDAO().save(consumerOrder.getStore(),options);
 		return consumerOrder;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected ConsumerOrder saveConsumerOrderLineItemList(ConsumerOrder consumerOrder, Map<String,Object> options){
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();
		if(consumerOrderLineItemList == null){
			return consumerOrder;
		}
		if(consumerOrderLineItemList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderLineItemDAO().saveConsumerOrderLineItemList(consumerOrderLineItemList,options);
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderLineItemList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();
		if(consumerOrderLineItemList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderLineItem> toRemoveConsumerOrderLineItemList = consumerOrderLineItemList.getToRemoveList();
		
		if(toRemoveConsumerOrderLineItemList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderLineItemList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderLineItemDAO().removeConsumerOrderLineItemList(toRemoveConsumerOrderLineItemList,options);
		
		return consumerOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected ConsumerOrder saveConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();
		if(consumerOrderShippingGroupList == null){
			return consumerOrder;
		}
		if(consumerOrderShippingGroupList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderShippingGroupDAO().saveConsumerOrderShippingGroupList(consumerOrderShippingGroupList,options);
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderShippingGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();
		if(consumerOrderShippingGroupList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderShippingGroup> toRemoveConsumerOrderShippingGroupList = consumerOrderShippingGroupList.getToRemoveList();
		
		if(toRemoveConsumerOrderShippingGroupList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderShippingGroupList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderShippingGroupDAO().removeConsumerOrderShippingGroupList(toRemoveConsumerOrderShippingGroupList,options);
		
		return consumerOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected ConsumerOrder saveConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();
		if(consumerOrderPaymentGroupList == null){
			return consumerOrder;
		}
		if(consumerOrderPaymentGroupList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderPaymentGroupDAO().saveConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList,options);
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderPaymentGroupList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();
		if(consumerOrderPaymentGroupList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderPaymentGroup> toRemoveConsumerOrderPaymentGroupList = consumerOrderPaymentGroupList.getToRemoveList();
		
		if(toRemoveConsumerOrderPaymentGroupList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderPaymentGroupList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderPaymentGroupDAO().removeConsumerOrderPaymentGroupList(toRemoveConsumerOrderPaymentGroupList,options);
		
		return consumerOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected ConsumerOrder saveConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, Map<String,Object> options){
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();
		if(consumerOrderPriceAdjustmentList == null){
			return consumerOrder;
		}
		if(consumerOrderPriceAdjustmentList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getConsumerOrderPriceAdjustmentDAO().saveConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList,options);
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeConsumerOrderPriceAdjustmentList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();
		if(consumerOrderPriceAdjustmentList == null){
			return consumerOrder;
		}	
	
		SmartList<ConsumerOrderPriceAdjustment> toRemoveConsumerOrderPriceAdjustmentList = consumerOrderPriceAdjustmentList.getToRemoveList();
		
		if(toRemoveConsumerOrderPriceAdjustmentList == null){
			return consumerOrder;
		}
		if(toRemoveConsumerOrderPriceAdjustmentList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderPriceAdjustmentDAO().removeConsumerOrderPriceAdjustmentList(toRemoveConsumerOrderPriceAdjustmentList,options);
		
		return consumerOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected ConsumerOrder saveRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, Map<String,Object> options){
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;
		}
		if(retailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreMemberGiftCardConsumeRecordDAO().saveRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList,options);
		
		return consumerOrder;
	
	}
	
	protected ConsumerOrder removeRetailStoreMemberGiftCardConsumeRecordList(ConsumerOrder consumerOrder, Map<String,Object> options){
	
	
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;
		}	
	
		SmartList<RetailStoreMemberGiftCardConsumeRecord> toRemoveRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList.getToRemoveList();
		
		if(toRemoveRetailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;
		}
		if(toRemoveRetailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return consumerOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreMemberGiftCardConsumeRecordDAO().removeRetailStoreMemberGiftCardConsumeRecordList(toRemoveRetailStoreMemberGiftCardConsumeRecordList,options);
		
		return consumerOrder;
	
	}
	
	
	
 	
 	
	
	
	
		

	public ConsumerOrder present(ConsumerOrder consumerOrder,Map<String, Object> options){
	
		presentConsumerOrderLineItemList(consumerOrder,options);
		presentConsumerOrderShippingGroupList(consumerOrder,options);
		presentConsumerOrderPaymentGroupList(consumerOrder,options);
		presentConsumerOrderPriceAdjustmentList(consumerOrder,options);
		presentRetailStoreMemberGiftCardConsumeRecordList(consumerOrder,options);

		return consumerOrder;
	
	}
		
	
  	
 	protected ConsumerOrder presentConsumerOrderLineItemList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderLineItem> consumerOrderLineItemList = consumerOrder.getConsumerOrderLineItemList();		
		if(consumerOrderLineItemList == null){
			return consumerOrder;			
		}
		
		String targetObjectName = "consumerOrderLineItem";
		int consumerOrderLineItemListSize = consumerOrderLineItemList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderLineItemListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return consumerOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderLineItemListSize;
		if(consumerOrderLineItemListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderLineItemDAO().countConsumerOrderLineItemByBizOrder(consumerOrder.getId(), options);			
		}
		//consumerOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//consumerOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderLineItemListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderLineItemListSize,currentPage,rowsPerPage) ;
			consumerOrderLineItemList = consumerOrderLineItemList.subListOf(fromIndex, toIndex);
			consumerOrderLineItemList.setTotalCount(count);
			consumerOrderLineItemList.setCurrentPageNumber(currentPage);			
			consumerOrder.setConsumerOrderLineItemList(consumerOrderLineItemList);
			return consumerOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderLineItemList 
			= getConsumerOrderLineItemDAO().findConsumerOrderLineItemByBizOrder(consumerOrder.getId(),start, rowsPerPage, options );
		consumerOrderLineItemList.setTotalCount(count);
		consumerOrderLineItemList.setCurrentPageNumber(currentPage);
		consumerOrder.setConsumerOrderLineItemList(consumerOrderLineItemList );	

		return consumerOrder;
	}			
		
	
  	
 	protected ConsumerOrder presentConsumerOrderShippingGroupList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList = consumerOrder.getConsumerOrderShippingGroupList();		
		if(consumerOrderShippingGroupList == null){
			return consumerOrder;			
		}
		
		String targetObjectName = "consumerOrderShippingGroup";
		int consumerOrderShippingGroupListSize = consumerOrderShippingGroupList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderShippingGroupListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return consumerOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderShippingGroupListSize;
		if(consumerOrderShippingGroupListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderShippingGroupDAO().countConsumerOrderShippingGroupByBizOrder(consumerOrder.getId(), options);			
		}
		//consumerOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//consumerOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderShippingGroupListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderShippingGroupListSize,currentPage,rowsPerPage) ;
			consumerOrderShippingGroupList = consumerOrderShippingGroupList.subListOf(fromIndex, toIndex);
			consumerOrderShippingGroupList.setTotalCount(count);
			consumerOrderShippingGroupList.setCurrentPageNumber(currentPage);			
			consumerOrder.setConsumerOrderShippingGroupList(consumerOrderShippingGroupList);
			return consumerOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderShippingGroupList 
			= getConsumerOrderShippingGroupDAO().findConsumerOrderShippingGroupByBizOrder(consumerOrder.getId(),start, rowsPerPage, options );
		consumerOrderShippingGroupList.setTotalCount(count);
		consumerOrderShippingGroupList.setCurrentPageNumber(currentPage);
		consumerOrder.setConsumerOrderShippingGroupList(consumerOrderShippingGroupList );	

		return consumerOrder;
	}			
		
	
  	
 	protected ConsumerOrder presentConsumerOrderPaymentGroupList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList = consumerOrder.getConsumerOrderPaymentGroupList();		
		if(consumerOrderPaymentGroupList == null){
			return consumerOrder;			
		}
		
		String targetObjectName = "consumerOrderPaymentGroup";
		int consumerOrderPaymentGroupListSize = consumerOrderPaymentGroupList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderPaymentGroupListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return consumerOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderPaymentGroupListSize;
		if(consumerOrderPaymentGroupListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderPaymentGroupDAO().countConsumerOrderPaymentGroupByBizOrder(consumerOrder.getId(), options);			
		}
		//consumerOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//consumerOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderPaymentGroupListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderPaymentGroupListSize,currentPage,rowsPerPage) ;
			consumerOrderPaymentGroupList = consumerOrderPaymentGroupList.subListOf(fromIndex, toIndex);
			consumerOrderPaymentGroupList.setTotalCount(count);
			consumerOrderPaymentGroupList.setCurrentPageNumber(currentPage);			
			consumerOrder.setConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList);
			return consumerOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderPaymentGroupList 
			= getConsumerOrderPaymentGroupDAO().findConsumerOrderPaymentGroupByBizOrder(consumerOrder.getId(),start, rowsPerPage, options );
		consumerOrderPaymentGroupList.setTotalCount(count);
		consumerOrderPaymentGroupList.setCurrentPageNumber(currentPage);
		consumerOrder.setConsumerOrderPaymentGroupList(consumerOrderPaymentGroupList );	

		return consumerOrder;
	}			
		
	
  	
 	protected ConsumerOrder presentConsumerOrderPriceAdjustmentList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList = consumerOrder.getConsumerOrderPriceAdjustmentList();		
		if(consumerOrderPriceAdjustmentList == null){
			return consumerOrder;			
		}
		
		String targetObjectName = "consumerOrderPriceAdjustment";
		int consumerOrderPriceAdjustmentListSize = consumerOrderPriceAdjustmentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(consumerOrderPriceAdjustmentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return consumerOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = consumerOrderPriceAdjustmentListSize;
		if(consumerOrderPriceAdjustmentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getConsumerOrderPriceAdjustmentDAO().countConsumerOrderPriceAdjustmentByBizOrder(consumerOrder.getId(), options);			
		}
		//consumerOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//consumerOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(consumerOrderPriceAdjustmentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(consumerOrderPriceAdjustmentListSize,currentPage,rowsPerPage) ;
			consumerOrderPriceAdjustmentList = consumerOrderPriceAdjustmentList.subListOf(fromIndex, toIndex);
			consumerOrderPriceAdjustmentList.setTotalCount(count);
			consumerOrderPriceAdjustmentList.setCurrentPageNumber(currentPage);			
			consumerOrder.setConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList);
			return consumerOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		consumerOrderPriceAdjustmentList 
			= getConsumerOrderPriceAdjustmentDAO().findConsumerOrderPriceAdjustmentByBizOrder(consumerOrder.getId(),start, rowsPerPage, options );
		consumerOrderPriceAdjustmentList.setTotalCount(count);
		consumerOrderPriceAdjustmentList.setCurrentPageNumber(currentPage);
		consumerOrder.setConsumerOrderPriceAdjustmentList(consumerOrderPriceAdjustmentList );	

		return consumerOrder;
	}			
		
	
  	
 	protected ConsumerOrder presentRetailStoreMemberGiftCardConsumeRecordList(
			ConsumerOrder consumerOrder,
			Map<String, Object> options) {

		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = consumerOrder.getRetailStoreMemberGiftCardConsumeRecordList();		
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return consumerOrder;			
		}
		
		String targetObjectName = "retailStoreMemberGiftCardConsumeRecord";
		int retailStoreMemberGiftCardConsumeRecordListSize = retailStoreMemberGiftCardConsumeRecordList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreMemberGiftCardConsumeRecordListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return consumerOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreMemberGiftCardConsumeRecordListSize;
		if(retailStoreMemberGiftCardConsumeRecordListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreMemberGiftCardConsumeRecordDAO().countRetailStoreMemberGiftCardConsumeRecordByBizOrder(consumerOrder.getId(), options);			
		}
		//consumerOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//consumerOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreMemberGiftCardConsumeRecordListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreMemberGiftCardConsumeRecordListSize,currentPage,rowsPerPage) ;
			retailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList.subListOf(fromIndex, toIndex);
			retailStoreMemberGiftCardConsumeRecordList.setTotalCount(count);
			retailStoreMemberGiftCardConsumeRecordList.setCurrentPageNumber(currentPage);			
			consumerOrder.setRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList);
			return consumerOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreMemberGiftCardConsumeRecordList 
			= getRetailStoreMemberGiftCardConsumeRecordDAO().findRetailStoreMemberGiftCardConsumeRecordByBizOrder(consumerOrder.getId(),start, rowsPerPage, options );
		retailStoreMemberGiftCardConsumeRecordList.setTotalCount(count);
		retailStoreMemberGiftCardConsumeRecordList.setCurrentPageNumber(currentPage);
		consumerOrder.setRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList );	

		return consumerOrder;
	}			
		


	protected String getTableName(){
		return ConsumerOrderTable.TABLE_NAME;
	}
}


