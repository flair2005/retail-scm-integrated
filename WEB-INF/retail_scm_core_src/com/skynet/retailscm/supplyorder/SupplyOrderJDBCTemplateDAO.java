
package com.skynet.retailscm.supplyorder;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;

import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationDAO;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.goodssupplier.GoodsSupplierDAO;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryDAO;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPickingDAO;
import com.skynet.retailscm.goods.GoodsDAO;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalDAO;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItemDAO;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupDAO;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupDAO;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItemTable;
import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApprovalTable;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupTable;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDeliveryTable;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessingTable;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPickingTable;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipmentTable;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmationTable;
import com.skynet.retailscm.goodssupplier.GoodsSupplierTable;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderDAO{
 
 	
 	private  SupplyOrderApprovalDAO  supplyOrderApprovalDAO;
 	public void setSupplyOrderApprovalDAO(SupplyOrderApprovalDAO supplyOrderApprovalDAO){
	 	this.supplyOrderApprovalDAO = supplyOrderApprovalDAO;
 	}
 	public SupplyOrderApprovalDAO getSupplyOrderApprovalDAO(){
	 	return this.supplyOrderApprovalDAO;
 	}
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  SupplyOrderDeliveryDAO  supplyOrderDeliveryDAO;
 	public void setSupplyOrderDeliveryDAO(SupplyOrderDeliveryDAO supplyOrderDeliveryDAO){
	 	this.supplyOrderDeliveryDAO = supplyOrderDeliveryDAO;
 	}
 	public SupplyOrderDeliveryDAO getSupplyOrderDeliveryDAO(){
	 	return this.supplyOrderDeliveryDAO;
 	}
 
 	
 	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
	 	return this.goodsSupplierDAO;
 	}
 
 	
 	private  SupplyOrderPickingDAO  supplyOrderPickingDAO;
 	public void setSupplyOrderPickingDAO(SupplyOrderPickingDAO supplyOrderPickingDAO){
	 	this.supplyOrderPickingDAO = supplyOrderPickingDAO;
 	}
 	public SupplyOrderPickingDAO getSupplyOrderPickingDAO(){
	 	return this.supplyOrderPickingDAO;
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
 
 	
 	private  SupplyOrderProcessingDAO  supplyOrderProcessingDAO;
 	public void setSupplyOrderProcessingDAO(SupplyOrderProcessingDAO supplyOrderProcessingDAO){
	 	this.supplyOrderProcessingDAO = supplyOrderProcessingDAO;
 	}
 	public SupplyOrderProcessingDAO getSupplyOrderProcessingDAO(){
	 	return this.supplyOrderProcessingDAO;
 	}

		
	
  	private  SupplyOrderLineItemDAO  supplyOrderLineItemDAO;
 	public void setSupplyOrderLineItemDAO(SupplyOrderLineItemDAO pSupplyOrderLineItemDAO){
 	
 		if(pSupplyOrderLineItemDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderLineItemDAO to null.");
 		}
	 	this.supplyOrderLineItemDAO = pSupplyOrderLineItemDAO;
 	}
 	public SupplyOrderLineItemDAO getSupplyOrderLineItemDAO(){
 		if(this.supplyOrderLineItemDAO == null){
 			throw new IllegalStateException("The supplyOrderLineItemDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderLineItemDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderShippingGroupDAO  supplyOrderShippingGroupDAO;
 	public void setSupplyOrderShippingGroupDAO(SupplyOrderShippingGroupDAO pSupplyOrderShippingGroupDAO){
 	
 		if(pSupplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderShippingGroupDAO to null.");
 		}
	 	this.supplyOrderShippingGroupDAO = pSupplyOrderShippingGroupDAO;
 	}
 	public SupplyOrderShippingGroupDAO getSupplyOrderShippingGroupDAO(){
 		if(this.supplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The supplyOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderShippingGroupDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderPaymentGroupDAO  supplyOrderPaymentGroupDAO;
 	public void setSupplyOrderPaymentGroupDAO(SupplyOrderPaymentGroupDAO pSupplyOrderPaymentGroupDAO){
 	
 		if(pSupplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderPaymentGroupDAO to null.");
 		}
	 	this.supplyOrderPaymentGroupDAO = pSupplyOrderPaymentGroupDAO;
 	}
 	public SupplyOrderPaymentGroupDAO getSupplyOrderPaymentGroupDAO(){
 		if(this.supplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The supplyOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderPaymentGroupDAO;
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
	protected SupplyOrder load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrder(accessKey, options);
	}
	*/
	public SupplyOrder load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrder(SupplyOrderTable.withId(id), options);
	}
	
	
	
	public SupplyOrder save(SupplyOrder supplyOrder,Map<String,Object> options){
		
		String methodName="save(SupplyOrder supplyOrder,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrder, methodName, "supplyOrder");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrder(supplyOrder,options);
	}
	public SupplyOrder clone(String supplyOrderId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderTable.withId(supplyOrderId),options);
	}
	
	protected SupplyOrder clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrder newSupplyOrder = loadInternalSupplyOrder(accessKey, options);
		newSupplyOrder.setVersion(0);
		
		
 		
 		if(isSaveSupplyOrderLineItemListEnabled(options)){
 			for(SupplyOrderLineItem item: newSupplyOrder.getSupplyOrderLineItemList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderShippingGroupListEnabled(options)){
 			for(SupplyOrderShippingGroup item: newSupplyOrder.getSupplyOrderShippingGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderPaymentGroupListEnabled(options)){
 			for(SupplyOrderPaymentGroup item: newSupplyOrder.getSupplyOrderPaymentGroupList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newSupplyOrder.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSupplyOrder(newSupplyOrder,options);
		
		return newSupplyOrder;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderId, int version)";
		assertMethodArgumentNotNull(supplyOrderId, methodName, "supplyOrderId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"buyer","seller","title","total_amount","confirmation","approval","processing","picking","shipment","delivery","current_status"};
		return SupplyOrderTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBuyerEnabled = true;
 	//private static final String BUYER = "buyer";
 	protected boolean isExtractBuyerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.BUYER);
 	}
 	
 	
 	//private boolean saveBuyerEnabled = true;
 	protected boolean isSaveBuyerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.BUYER);
 	}
 	

 	
  
 	//private boolean extractSellerEnabled = true;
 	//private static final String SELLER = "seller";
 	protected boolean isExtractSellerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.SELLER);
 	}
 	
 	
 	//private boolean saveSellerEnabled = true;
 	protected boolean isSaveSellerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.SELLER);
 	}
 	

 	
  
 	//private boolean extractConfirmationEnabled = true;
 	//private static final String CONFIRMATION = "confirmation";
 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.CONFIRMATION);
 	}
 	
 	
 	//private boolean saveConfirmationEnabled = true;
 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.CONFIRMATION);
 	}
 	

 	
  
 	//private boolean extractApprovalEnabled = true;
 	//private static final String APPROVAL = "approval";
 	protected boolean isExtractApprovalEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.APPROVAL);
 	}
 	
 	
 	//private boolean saveApprovalEnabled = true;
 	protected boolean isSaveApprovalEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.APPROVAL);
 	}
 	

 	
  
 	//private boolean extractProcessingEnabled = true;
 	//private static final String PROCESSING = "processing";
 	protected boolean isExtractProcessingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.PROCESSING);
 	}
 	
 	
 	//private boolean saveProcessingEnabled = true;
 	protected boolean isSaveProcessingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.PROCESSING);
 	}
 	

 	
  
 	//private boolean extractPickingEnabled = true;
 	//private static final String PICKING = "picking";
 	protected boolean isExtractPickingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.PICKING);
 	}
 	
 	
 	//private boolean savePickingEnabled = true;
 	protected boolean isSavePickingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.PICKING);
 	}
 	

 	
  
 	//private boolean extractShipmentEnabled = true;
 	//private static final String SHIPMENT = "shipment";
 	protected boolean isExtractShipmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.SHIPMENT);
 	}
 	
 	
 	//private boolean saveShipmentEnabled = true;
 	protected boolean isSaveShipmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.SHIPMENT);
 	}
 	

 	
  
 	//private boolean extractDeliveryEnabled = true;
 	//private static final String DELIVERY = "delivery";
 	protected boolean isExtractDeliveryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderTokens.DELIVERY);
 	}
 	
 	
 	//private boolean saveDeliveryEnabled = true;
 	protected boolean isSaveDeliveryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderTokens.DELIVERY);
 	}
 	

 	
 
		
	//protected static final String SUPPLY_ORDER_LINE_ITEM_LIST = "supplyOrderLineItemList";
	
	protected boolean isExtractSupplyOrderLineItemListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_LINE_ITEM_LIST);
		
 	}

	protected boolean isSaveSupplyOrderLineItemListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_LINE_ITEM_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_SHIPPING_GROUP_LIST = "supplyOrderShippingGroupList";
	
	protected boolean isExtractSupplyOrderShippingGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_SHIPPING_GROUP_LIST);
		
 	}

	protected boolean isSaveSupplyOrderShippingGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_SHIPPING_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_PAYMENT_GROUP_LIST = "supplyOrderPaymentGroupList";
	
	protected boolean isExtractSupplyOrderPaymentGroupListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.SUPPLY_ORDER_PAYMENT_GROUP_LIST);
		
 	}

	protected boolean isSaveSupplyOrderPaymentGroupListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.SUPPLY_ORDER_PAYMENT_GROUP_LIST);
		
 	}
 	
 	
			
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SupplyOrderTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, SupplyOrderTokens.GOODS_LIST);
		
 	}
 	
 	
			
		

	

	protected SupplyOrderMapper getSupplyOrderMapper(){
		return new SupplyOrderMapper();
	}
	protected SupplyOrder extractSupplyOrder(String supplyOrderId) throws Exception{
		String SQL = "select * from supply_order_data where id = ?";	
		try{
		
			SupplyOrder supplyOrder = queryForObject(SQL, new Object[]{supplyOrderId}, getSupplyOrderMapper());
			return supplyOrder;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderNotFoundException("SupplyOrder("+supplyOrderId+") is not found!");
		}
		
		
	}
	protected SupplyOrder extractSupplyOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrder supplyOrder = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderMapper());
			return supplyOrder;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderNotFoundException("SupplyOrder("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrder loadInternalSupplyOrder(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrder supplyOrder = extractSupplyOrder(accessKey, loadOptions);
 	
 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractApprovalEnabled(loadOptions)){
	 		extractApproval(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractProcessingEnabled(loadOptions)){
	 		extractProcessing(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractPickingEnabled(loadOptions)){
	 		extractPicking(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractShipmentEnabled(loadOptions)){
	 		extractShipment(supplyOrder, loadOptions);
 		}
  	
 		if(isExtractDeliveryEnabled(loadOptions)){
	 		extractDelivery(supplyOrder, loadOptions);
 		}
 
		
		if(isExtractSupplyOrderLineItemListEnabled(loadOptions)){
	 		extractSupplyOrderLineItemList(supplyOrder, loadOptions);
 		}		
		
		if(isExtractSupplyOrderShippingGroupListEnabled(loadOptions)){
	 		extractSupplyOrderShippingGroupList(supplyOrder, loadOptions);
 		}		
		
		if(isExtractSupplyOrderPaymentGroupListEnabled(loadOptions)){
	 		extractSupplyOrderPaymentGroupList(supplyOrder, loadOptions);
 		}		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(supplyOrder, loadOptions);
 		}		
		
		return supplyOrder;
		
	}



	
	
	 

 	protected SupplyOrder extractBuyer(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getBuyer() == null){
			return supplyOrder;
		}
		String buyerId = supplyOrder.getBuyer().getId();
		if( buyerId == null){
			return supplyOrder;
		}
		RetailStoreCountryCenter buyer = getRetailStoreCountryCenterDAO().load(buyerId,options);
		if(buyer != null){
			supplyOrder.setBuyer(buyer);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractSeller(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getSeller() == null){
			return supplyOrder;
		}
		String sellerId = supplyOrder.getSeller().getId();
		if( sellerId == null){
			return supplyOrder;
		}
		GoodsSupplier seller = getGoodsSupplierDAO().load(sellerId,options);
		if(seller != null){
			supplyOrder.setSeller(seller);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractConfirmation(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getConfirmation() == null){
			return supplyOrder;
		}
		String confirmationId = supplyOrder.getConfirmation().getId();
		if( confirmationId == null){
			return supplyOrder;
		}
		SupplyOrderConfirmation confirmation = getSupplyOrderConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			supplyOrder.setConfirmation(confirmation);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractApproval(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getApproval() == null){
			return supplyOrder;
		}
		String approvalId = supplyOrder.getApproval().getId();
		if( approvalId == null){
			return supplyOrder;
		}
		SupplyOrderApproval approval = getSupplyOrderApprovalDAO().load(approvalId,options);
		if(approval != null){
			supplyOrder.setApproval(approval);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractProcessing(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getProcessing() == null){
			return supplyOrder;
		}
		String processingId = supplyOrder.getProcessing().getId();
		if( processingId == null){
			return supplyOrder;
		}
		SupplyOrderProcessing processing = getSupplyOrderProcessingDAO().load(processingId,options);
		if(processing != null){
			supplyOrder.setProcessing(processing);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractPicking(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getPicking() == null){
			return supplyOrder;
		}
		String pickingId = supplyOrder.getPicking().getId();
		if( pickingId == null){
			return supplyOrder;
		}
		SupplyOrderPicking picking = getSupplyOrderPickingDAO().load(pickingId,options);
		if(picking != null){
			supplyOrder.setPicking(picking);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractShipment(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getShipment() == null){
			return supplyOrder;
		}
		String shipmentId = supplyOrder.getShipment().getId();
		if( shipmentId == null){
			return supplyOrder;
		}
		SupplyOrderShipment shipment = getSupplyOrderShipmentDAO().load(shipmentId,options);
		if(shipment != null){
			supplyOrder.setShipment(shipment);
		}
		
 		
 		return supplyOrder;
 	}
 		
  

 	protected SupplyOrder extractDelivery(SupplyOrder supplyOrder, Map<String,Object> options) throws Exception{

		if(supplyOrder.getDelivery() == null){
			return supplyOrder;
		}
		String deliveryId = supplyOrder.getDelivery().getId();
		if( deliveryId == null){
			return supplyOrder;
		}
		SupplyOrderDelivery delivery = getSupplyOrderDeliveryDAO().load(deliveryId,options);
		if(delivery != null){
			supplyOrder.setDelivery(delivery);
		}
		
 		
 		return supplyOrder;
 	}
 		
 
		
	protected SupplyOrder extractSupplyOrderLineItemList(SupplyOrder supplyOrder, Map<String,Object> options){
		
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = getSupplyOrderLineItemDAO().findSupplyOrderLineItemByBizOrder(supplyOrder.getId(),options);
		if(supplyOrderLineItemList != null){
			supplyOrder.setSupplyOrderLineItemList(supplyOrderLineItemList);
		}
		
		return supplyOrder;
	
	}	
		
	protected SupplyOrder extractSupplyOrderShippingGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
		
		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = getSupplyOrderShippingGroupDAO().findSupplyOrderShippingGroupByBizOrder(supplyOrder.getId(),options);
		if(supplyOrderShippingGroupList != null){
			supplyOrder.setSupplyOrderShippingGroupList(supplyOrderShippingGroupList);
		}
		
		return supplyOrder;
	
	}	
		
	protected SupplyOrder extractSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
		
		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = getSupplyOrderPaymentGroupDAO().findSupplyOrderPaymentGroupByBizOrder(supplyOrder.getId(),options);
		if(supplyOrderPaymentGroupList != null){
			supplyOrder.setSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList);
		}
		
		return supplyOrder;
	
	}	
		
	protected SupplyOrder extractGoodsList(SupplyOrder supplyOrder, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByBizOrder(supplyOrder.getId(),options);
		if(goodsList != null){
			supplyOrder.setGoodsList(goodsList);
		}
		
		return supplyOrder;
	
	}	
		
		
  	
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where buyer = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderByBuyer(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where buyer = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderByBuyer(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where buyer = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where seller = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{goodsSupplierId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderBySeller(String goodsSupplierId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where seller = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{goodsSupplierId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderBySeller(String goodsSupplierId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where seller = ?";
		Integer count = queryInt(SQL, new Object[]{goodsSupplierId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderConfirmationId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderByConfirmation(String supplyOrderConfirmationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderConfirmationId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderByConfirmation(String supplyOrderConfirmationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where confirmation = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderConfirmationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where approval = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderApprovalId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderByApproval(String supplyOrderApprovalId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where approval = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderApprovalId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderByApproval(String supplyOrderApprovalId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where approval = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderApprovalId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where processing = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderProcessingId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderByProcessing(String supplyOrderProcessingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where processing = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderProcessingId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderByProcessing(String supplyOrderProcessingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where processing = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderProcessingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByPicking(String supplyOrderPickingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where picking = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderPickingId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderByPicking(String supplyOrderPickingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where picking = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderPickingId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderByPicking(String supplyOrderPickingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where picking = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderPickingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipment = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderShipmentId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderByShipment(String supplyOrderShipmentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipment = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderShipmentId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderByShipment(String supplyOrderShipmentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where shipment = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderShipmentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<SupplyOrder> findSupplyOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where delivery = ?";
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderDeliveryId}, getSupplyOrderMapper());	
 		return supplyOrderList;
 	}
 	
 	public SmartList<SupplyOrder> findSupplyOrderByDelivery(String supplyOrderDeliveryId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where delivery = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrder> supplyOrderList = queryForList(SQL, new Object[]{supplyOrderDeliveryId,start, count}, getSupplyOrderMapper());
		
 		return supplyOrderList;
 	}
 	
 	public int countSupplyOrderByDelivery(String supplyOrderDeliveryId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where delivery = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderDeliveryId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SupplyOrder saveSupplyOrder(SupplyOrder  supplyOrder){
	
		String SQL=this.getSaveSupplyOrderSQL(supplyOrder);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderParameters(supplyOrder);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrder.incVersion();
		return supplyOrder;
	
	}
	public SmartList<SupplyOrder> saveSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderList(supplyOrderList);
		
		batchSupplyOrderCreate((List<SupplyOrder>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderUpdate((List<SupplyOrder>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrder supplyOrder:supplyOrderList){
			if(supplyOrder.isChanged()){
				supplyOrder.incVersion();
			}
			
		
		}
		
		
		return supplyOrderList;
	}

	public SmartList<SupplyOrder> removeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderList, options);
		
		return supplyOrderList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderBatchCreateArgs(List<SupplyOrder> supplyOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrder supplyOrder:supplyOrderList ){
			Object [] parameters = prepareSupplyOrderCreateParameters(supplyOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderBatchUpdateArgs(List<SupplyOrder> supplyOrderList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrder supplyOrder:supplyOrderList ){
			if(!supplyOrder.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderUpdateParameters(supplyOrder);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderCreate(List<SupplyOrder> supplyOrderList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderBatchCreateArgs(supplyOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderUpdate(List<SupplyOrder> supplyOrderList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderBatchUpdateArgs(supplyOrderList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderList(List<SupplyOrder> supplyOrderList){
		
		List<SupplyOrder> supplyOrderCreateList=new ArrayList<SupplyOrder>();
		List<SupplyOrder> supplyOrderUpdateList=new ArrayList<SupplyOrder>();
		
		for(SupplyOrder supplyOrder: supplyOrderList){
			if(isUpdateRequest(supplyOrder)){
				supplyOrderUpdateList.add( supplyOrder);
				continue;
			}
			supplyOrderCreateList.add(supplyOrder);
		}
		
		return new Object[]{supplyOrderCreateList,supplyOrderUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrder supplyOrder){
 		return supplyOrder.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderSQL(SupplyOrder supplyOrder){
 		if(isUpdateRequest(supplyOrder)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderParameters(SupplyOrder supplyOrder){
 		if(isUpdateRequest(supplyOrder) ){
 			return prepareSupplyOrderUpdateParameters(supplyOrder);
 		}
 		return prepareSupplyOrderCreateParameters(supplyOrder);
 	}
 	protected Object[] prepareSupplyOrderUpdateParameters(SupplyOrder supplyOrder){
 		Object[] parameters = new Object[13];
  	
 		if(supplyOrder.getBuyer() != null){
 			parameters[0] = supplyOrder.getBuyer().getId();
 		}
  	
 		if(supplyOrder.getSeller() != null){
 			parameters[1] = supplyOrder.getSeller().getId();
 		}
 
 		parameters[2] = supplyOrder.getTitle();
 		parameters[3] = supplyOrder.getTotalAmount(); 	
 		if(supplyOrder.getConfirmation() != null){
 			parameters[4] = supplyOrder.getConfirmation().getId();
 		}
  	
 		if(supplyOrder.getApproval() != null){
 			parameters[5] = supplyOrder.getApproval().getId();
 		}
  	
 		if(supplyOrder.getProcessing() != null){
 			parameters[6] = supplyOrder.getProcessing().getId();
 		}
  	
 		if(supplyOrder.getPicking() != null){
 			parameters[7] = supplyOrder.getPicking().getId();
 		}
  	
 		if(supplyOrder.getShipment() != null){
 			parameters[8] = supplyOrder.getShipment().getId();
 		}
  	
 		if(supplyOrder.getDelivery() != null){
 			parameters[9] = supplyOrder.getDelivery().getId();
 		}
 
 		parameters[10] = supplyOrder.getCurrentStatus();		
 		parameters[11] = supplyOrder.getId();
 		parameters[12] = supplyOrder.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderCreateParameters(SupplyOrder supplyOrder){
		Object[] parameters = new Object[12];
		String newSupplyOrderId=getNextId();
		supplyOrder.setId(newSupplyOrderId);
		parameters[0] =  supplyOrder.getId();
  	
 		if(supplyOrder.getBuyer() != null){
 			parameters[1] = supplyOrder.getBuyer().getId();
 		
 		}
 		 	
 		if(supplyOrder.getSeller() != null){
 			parameters[2] = supplyOrder.getSeller().getId();
 		
 		}
 		
 		parameters[3] = supplyOrder.getTitle();
 		parameters[4] = supplyOrder.getTotalAmount(); 	
 		if(supplyOrder.getConfirmation() != null){
 			parameters[5] = supplyOrder.getConfirmation().getId();
 		
 		}
 		 	
 		if(supplyOrder.getApproval() != null){
 			parameters[6] = supplyOrder.getApproval().getId();
 		
 		}
 		 	
 		if(supplyOrder.getProcessing() != null){
 			parameters[7] = supplyOrder.getProcessing().getId();
 		
 		}
 		 	
 		if(supplyOrder.getPicking() != null){
 			parameters[8] = supplyOrder.getPicking().getId();
 		
 		}
 		 	
 		if(supplyOrder.getShipment() != null){
 			parameters[9] = supplyOrder.getShipment().getId();
 		
 		}
 		 	
 		if(supplyOrder.getDelivery() != null){
 			parameters[10] = supplyOrder.getDelivery().getId();
 		
 		}
 		
 		parameters[11] = supplyOrder.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrder saveInternalSupplyOrder(SupplyOrder supplyOrder, Map<String,Object> options){
		
		saveSupplyOrder(supplyOrder);
 	
 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(supplyOrder, options);
 		}
  	
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(supplyOrder, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(supplyOrder, options);
 		}
  	
 		if(isSaveApprovalEnabled(options)){
	 		saveApproval(supplyOrder, options);
 		}
  	
 		if(isSaveProcessingEnabled(options)){
	 		saveProcessing(supplyOrder, options);
 		}
  	
 		if(isSavePickingEnabled(options)){
	 		savePicking(supplyOrder, options);
 		}
  	
 		if(isSaveShipmentEnabled(options)){
	 		saveShipment(supplyOrder, options);
 		}
  	
 		if(isSaveDeliveryEnabled(options)){
	 		saveDelivery(supplyOrder, options);
 		}
 
		
		if(isSaveSupplyOrderLineItemListEnabled(options)){
	 		saveSupplyOrderLineItemList(supplyOrder, options);
	 		removeSupplyOrderLineItemList(supplyOrder, options);
	 		
 		}		
		
		if(isSaveSupplyOrderShippingGroupListEnabled(options)){
	 		saveSupplyOrderShippingGroupList(supplyOrder, options);
	 		removeSupplyOrderShippingGroupList(supplyOrder, options);
	 		
 		}		
		
		if(isSaveSupplyOrderPaymentGroupListEnabled(options)){
	 		saveSupplyOrderPaymentGroupList(supplyOrder, options);
	 		removeSupplyOrderPaymentGroupList(supplyOrder, options);
	 		
 		}		
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(supplyOrder, options);
	 		removeGoodsList(supplyOrder, options);
	 		
 		}		
		
		return supplyOrder;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplyOrder saveBuyer(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getBuyer() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(supplyOrder.getBuyer(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveSeller(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getSeller() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getGoodsSupplierDAO().save(supplyOrder.getSeller(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveConfirmation(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getConfirmation() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderConfirmationDAO().save(supplyOrder.getConfirmation(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveApproval(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getApproval() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderApprovalDAO().save(supplyOrder.getApproval(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveProcessing(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getProcessing() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderProcessingDAO().save(supplyOrder.getProcessing(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder savePicking(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getPicking() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderPickingDAO().save(supplyOrder.getPicking(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveShipment(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getShipment() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderShipmentDAO().save(supplyOrder.getShipment(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected SupplyOrder saveDelivery(SupplyOrder supplyOrder, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrder.getDelivery() == null){
 			return supplyOrder;//do nothing when it is null
 		}
 		
 		getSupplyOrderDeliveryDAO().save(supplyOrder.getDelivery(),options);
 		return supplyOrder;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected SupplyOrder saveSupplyOrderLineItemList(SupplyOrder supplyOrder, Map<String,Object> options){
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
		if(supplyOrderLineItemList == null){
			return supplyOrder;
		}
		if(supplyOrderLineItemList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderLineItemDAO().saveSupplyOrderLineItemList(supplyOrderLineItemList,options);
		
		return supplyOrder;
	
	}
	
	protected SupplyOrder removeSupplyOrderLineItemList(SupplyOrder supplyOrder, Map<String,Object> options){
	
	
		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();
		if(supplyOrderLineItemList == null){
			return supplyOrder;
		}	
	
		SmartList<SupplyOrderLineItem> toRemoveSupplyOrderLineItemList = supplyOrderLineItemList.getToRemoveList();
		
		if(toRemoveSupplyOrderLineItemList == null){
			return supplyOrder;
		}
		if(toRemoveSupplyOrderLineItemList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderLineItemDAO().removeSupplyOrderLineItemList(toRemoveSupplyOrderLineItemList,options);
		
		return supplyOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrder saveSupplyOrderShippingGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
		if(supplyOrderShippingGroupList == null){
			return supplyOrder;
		}
		if(supplyOrderShippingGroupList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderShippingGroupDAO().saveSupplyOrderShippingGroupList(supplyOrderShippingGroupList,options);
		
		return supplyOrder;
	
	}
	
	protected SupplyOrder removeSupplyOrderShippingGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
	
	
		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();
		if(supplyOrderShippingGroupList == null){
			return supplyOrder;
		}	
	
		SmartList<SupplyOrderShippingGroup> toRemoveSupplyOrderShippingGroupList = supplyOrderShippingGroupList.getToRemoveList();
		
		if(toRemoveSupplyOrderShippingGroupList == null){
			return supplyOrder;
		}
		if(toRemoveSupplyOrderShippingGroupList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderShippingGroupDAO().removeSupplyOrderShippingGroupList(toRemoveSupplyOrderShippingGroupList,options);
		
		return supplyOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrder saveSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
		if(supplyOrderPaymentGroupList == null){
			return supplyOrder;
		}
		if(supplyOrderPaymentGroupList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderPaymentGroupDAO().saveSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList,options);
		
		return supplyOrder;
	
	}
	
	protected SupplyOrder removeSupplyOrderPaymentGroupList(SupplyOrder supplyOrder, Map<String,Object> options){
	
	
		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();
		if(supplyOrderPaymentGroupList == null){
			return supplyOrder;
		}	
	
		SmartList<SupplyOrderPaymentGroup> toRemoveSupplyOrderPaymentGroupList = supplyOrderPaymentGroupList.getToRemoveList();
		
		if(toRemoveSupplyOrderPaymentGroupList == null){
			return supplyOrder;
		}
		if(toRemoveSupplyOrderPaymentGroupList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderPaymentGroupDAO().removeSupplyOrderPaymentGroupList(toRemoveSupplyOrderPaymentGroupList,options);
		
		return supplyOrder;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SupplyOrder saveGoodsList(SupplyOrder supplyOrder, Map<String,Object> options){
		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		if(goodsList == null){
			return supplyOrder;
		}
		if(goodsList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return supplyOrder;
	
	}
	
	protected SupplyOrder removeGoodsList(SupplyOrder supplyOrder, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = supplyOrder.getGoodsList();
		if(goodsList == null){
			return supplyOrder;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return supplyOrder;
		}
		if(toRemoveGoodsList.isEmpty()){
			return supplyOrder;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return supplyOrder;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SupplyOrder present(SupplyOrder supplyOrder,Map<String, Object> options){
	
		presentSupplyOrderLineItemList(supplyOrder,options);
		presentSupplyOrderShippingGroupList(supplyOrder,options);
		presentSupplyOrderPaymentGroupList(supplyOrder,options);
		presentGoodsList(supplyOrder,options);

		return supplyOrder;
	
	}
		
	
  	
 	protected SupplyOrder presentSupplyOrderLineItemList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {

		SmartList<SupplyOrderLineItem> supplyOrderLineItemList = supplyOrder.getSupplyOrderLineItemList();		
		if(supplyOrderLineItemList == null){
			return supplyOrder;			
		}
		
		String targetObjectName = "supplyOrderLineItem";
		int supplyOrderLineItemListSize = supplyOrderLineItemList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderLineItemListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderLineItemListSize;
		if(supplyOrderLineItemListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderLineItemDAO().countSupplyOrderLineItemByBizOrder(supplyOrder.getId(), options);			
		}
		//supplyOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderLineItemListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderLineItemListSize,currentPage,rowsPerPage) ;
			supplyOrderLineItemList = supplyOrderLineItemList.subListOf(fromIndex, toIndex);
			supplyOrderLineItemList.setTotalCount(count);
			supplyOrderLineItemList.setCurrentPageNumber(currentPage);			
			supplyOrder.setSupplyOrderLineItemList(supplyOrderLineItemList);
			return supplyOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderLineItemList 
			= getSupplyOrderLineItemDAO().findSupplyOrderLineItemByBizOrder(supplyOrder.getId(),start, rowsPerPage, options );
		supplyOrderLineItemList.setTotalCount(count);
		supplyOrderLineItemList.setCurrentPageNumber(currentPage);
		supplyOrder.setSupplyOrderLineItemList(supplyOrderLineItemList );	

		return supplyOrder;
	}			
		
	
  	
 	protected SupplyOrder presentSupplyOrderShippingGroupList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {

		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = supplyOrder.getSupplyOrderShippingGroupList();		
		if(supplyOrderShippingGroupList == null){
			return supplyOrder;			
		}
		
		String targetObjectName = "supplyOrderShippingGroup";
		int supplyOrderShippingGroupListSize = supplyOrderShippingGroupList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderShippingGroupListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderShippingGroupListSize;
		if(supplyOrderShippingGroupListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderShippingGroupDAO().countSupplyOrderShippingGroupByBizOrder(supplyOrder.getId(), options);			
		}
		//supplyOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderShippingGroupListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderShippingGroupListSize,currentPage,rowsPerPage) ;
			supplyOrderShippingGroupList = supplyOrderShippingGroupList.subListOf(fromIndex, toIndex);
			supplyOrderShippingGroupList.setTotalCount(count);
			supplyOrderShippingGroupList.setCurrentPageNumber(currentPage);			
			supplyOrder.setSupplyOrderShippingGroupList(supplyOrderShippingGroupList);
			return supplyOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderShippingGroupList 
			= getSupplyOrderShippingGroupDAO().findSupplyOrderShippingGroupByBizOrder(supplyOrder.getId(),start, rowsPerPage, options );
		supplyOrderShippingGroupList.setTotalCount(count);
		supplyOrderShippingGroupList.setCurrentPageNumber(currentPage);
		supplyOrder.setSupplyOrderShippingGroupList(supplyOrderShippingGroupList );	

		return supplyOrder;
	}			
		
	
  	
 	protected SupplyOrder presentSupplyOrderPaymentGroupList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {

		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = supplyOrder.getSupplyOrderPaymentGroupList();		
		if(supplyOrderPaymentGroupList == null){
			return supplyOrder;			
		}
		
		String targetObjectName = "supplyOrderPaymentGroup";
		int supplyOrderPaymentGroupListSize = supplyOrderPaymentGroupList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderPaymentGroupListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderPaymentGroupListSize;
		if(supplyOrderPaymentGroupListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderPaymentGroupDAO().countSupplyOrderPaymentGroupByBizOrder(supplyOrder.getId(), options);			
		}
		//supplyOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderPaymentGroupListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderPaymentGroupListSize,currentPage,rowsPerPage) ;
			supplyOrderPaymentGroupList = supplyOrderPaymentGroupList.subListOf(fromIndex, toIndex);
			supplyOrderPaymentGroupList.setTotalCount(count);
			supplyOrderPaymentGroupList.setCurrentPageNumber(currentPage);			
			supplyOrder.setSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList);
			return supplyOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderPaymentGroupList 
			= getSupplyOrderPaymentGroupDAO().findSupplyOrderPaymentGroupByBizOrder(supplyOrder.getId(),start, rowsPerPage, options );
		supplyOrderPaymentGroupList.setTotalCount(count);
		supplyOrderPaymentGroupList.setCurrentPageNumber(currentPage);
		supplyOrder.setSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList );	

		return supplyOrder;
	}			
		
	
  	
 	protected SupplyOrder presentGoodsList(
			SupplyOrder supplyOrder,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = supplyOrder.getGoodsList();		
		if(goodsList == null){
			return supplyOrder;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return supplyOrder;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByBizOrder(supplyOrder.getId(), options);			
		}
		//supplyOrder.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//supplyOrder.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			supplyOrder.setGoodsList(goodsList);
			return supplyOrder;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByBizOrder(supplyOrder.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		supplyOrder.setGoodsList(goodsList );	

		return supplyOrder;
	}			
		


	protected String getTableName(){
		return SupplyOrderTable.TABLE_NAME;
	}
}


