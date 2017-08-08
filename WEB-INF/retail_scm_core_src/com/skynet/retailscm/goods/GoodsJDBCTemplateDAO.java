
package com.skynet.retailscm.goods;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.goodsmovement.GoodsMovement;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;

import com.skynet.retailscm.goodsallocation.GoodsAllocationDAO;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.skynet.retailscm.receivingspace.ReceivingSpaceDAO;
import com.skynet.retailscm.supplyorder.SupplyOrderDAO;
import com.skynet.retailscm.goodsmovement.GoodsMovementDAO;
import com.skynet.retailscm.smartpallet.SmartPalletDAO;
import com.skynet.retailscm.shippingspace.ShippingSpaceDAO;
import com.skynet.retailscm.transporttask.TransportTaskDAO;
import com.skynet.retailscm.goodspackaging.GoodsPackagingDAO;
import com.skynet.retailscm.sku.SkuDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;

import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.goodsallocation.GoodsAllocationTable;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;
import com.skynet.retailscm.shippingspace.ShippingSpaceTable;
import com.skynet.retailscm.supplyorder.SupplyOrderTable;
import com.skynet.retailscm.smartpallet.SmartPalletTable;
import com.skynet.retailscm.goodsmovement.GoodsMovementTable;
import com.skynet.retailscm.transporttask.TransportTaskTable;
import com.skynet.retailscm.receivingspace.ReceivingSpaceTable;
import com.skynet.retailscm.sku.SkuTable;
import com.skynet.retailscm.goodspackaging.GoodsPackagingTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsJDBCTemplateDAO extends CommonJDBCTemplateDAO implements GoodsDAO{
 
 	
 	private  GoodsAllocationDAO  goodsAllocationDAO;
 	public void setGoodsAllocationDAO(GoodsAllocationDAO goodsAllocationDAO){
	 	this.goodsAllocationDAO = goodsAllocationDAO;
 	}
 	public GoodsAllocationDAO getGoodsAllocationDAO(){
	 	return this.goodsAllocationDAO;
 	}
 
 	
 	private  ShippingSpaceDAO  shippingSpaceDAO;
 	public void setShippingSpaceDAO(ShippingSpaceDAO shippingSpaceDAO){
	 	this.shippingSpaceDAO = shippingSpaceDAO;
 	}
 	public ShippingSpaceDAO getShippingSpaceDAO(){
	 	return this.shippingSpaceDAO;
 	}
 
 	
 	private  GoodsPackagingDAO  goodsPackagingDAO;
 	public void setGoodsPackagingDAO(GoodsPackagingDAO goodsPackagingDAO){
	 	this.goodsPackagingDAO = goodsPackagingDAO;
 	}
 	public GoodsPackagingDAO getGoodsPackagingDAO(){
	 	return this.goodsPackagingDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}
 
 	
 	private  SkuDAO  skuDAO;
 	public void setSkuDAO(SkuDAO skuDAO){
	 	this.skuDAO = skuDAO;
 	}
 	public SkuDAO getSkuDAO(){
	 	return this.skuDAO;
 	}
 
 	
 	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
	 	return this.transportTaskDAO;
 	}
 
 	
 	private  SmartPalletDAO  smartPalletDAO;
 	public void setSmartPalletDAO(SmartPalletDAO smartPalletDAO){
	 	this.smartPalletDAO = smartPalletDAO;
 	}
 	public SmartPalletDAO getSmartPalletDAO(){
	 	return this.smartPalletDAO;
 	}
 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}
 
 	
 	private  ReceivingSpaceDAO  receivingSpaceDAO;
 	public void setReceivingSpaceDAO(ReceivingSpaceDAO receivingSpaceDAO){
	 	this.receivingSpaceDAO = receivingSpaceDAO;
 	}
 	public ReceivingSpaceDAO getReceivingSpaceDAO(){
	 	return this.receivingSpaceDAO;
 	}
 
 	
 	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
	 	return this.retailStoreOrderDAO;
 	}

		
	
  	private  GoodsMovementDAO  goodsMovementDAO;
 	public void setGoodsMovementDAO(GoodsMovementDAO pGoodsMovementDAO){
 	
 		if(pGoodsMovementDAO == null){
 			throw new IllegalStateException("Do not try to set goodsMovementDAO to null.");
 		}
	 	this.goodsMovementDAO = pGoodsMovementDAO;
 	}
 	public GoodsMovementDAO getGoodsMovementDAO(){
 		if(this.goodsMovementDAO == null){
 			throw new IllegalStateException("The goodsMovementDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsMovementDAO;
 	}	
 	
			
		

	
	/*
	protected Goods load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoods(accessKey, options);
	}
	*/
	public Goods load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoods(GoodsTable.withId(id), options);
	}
	
	
	
	public Goods save(Goods goods,Map<String,Object> options){
		
		String methodName="save(Goods goods,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goods, methodName, "goods");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoods(goods,options);
	}
	public Goods clone(String goodsId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsTable.withId(goodsId),options);
	}
	
	protected Goods clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Goods newGoods = loadInternalGoods(accessKey, options);
		newGoods.setVersion(0);
		
		
 		
 		if(isSaveGoodsMovementListEnabled(options)){
 			for(GoodsMovement item: newGoods.getGoodsMovementList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGoods(newGoods,options);
		
		return newGoods;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String goodsId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{goodsId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new GoodsVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsNotFoundException(
					"The " + this.getTableName() + "(" + goodsId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String goodsId, int version) throws Exception{
	
		String methodName="delete(String goodsId, int version)";
		assertMethodArgumentNotNull(goodsId, methodName, "goodsId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","rfid","uom","max_package","expire_time","sku","receiving_space","goods_allocation","smart_pallet","shipping_space","transport_task","retail_store","biz_order","retail_store_order","packaging","current_status"};
		return GoodsTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractSkuEnabled = true;
 	//private static final String SKU = "sku";
 	protected boolean isExtractSkuEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.SKU);
 	}
 	
 	
 	//private boolean saveSkuEnabled = true;
 	protected boolean isSaveSkuEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.SKU);
 	}
 	

 	
  
 	//private boolean extractReceivingSpaceEnabled = true;
 	//private static final String RECEIVINGSPACE = "receivingSpace";
 	protected boolean isExtractReceivingSpaceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.RECEIVINGSPACE);
 	}
 	
 	
 	//private boolean saveReceivingSpaceEnabled = true;
 	protected boolean isSaveReceivingSpaceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.RECEIVINGSPACE);
 	}
 	

 	
  
 	//private boolean extractGoodsAllocationEnabled = true;
 	//private static final String GOODSALLOCATION = "goodsAllocation";
 	protected boolean isExtractGoodsAllocationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.GOODSALLOCATION);
 	}
 	
 	
 	//private boolean saveGoodsAllocationEnabled = true;
 	protected boolean isSaveGoodsAllocationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.GOODSALLOCATION);
 	}
 	

 	
  
 	//private boolean extractSmartPalletEnabled = true;
 	//private static final String SMARTPALLET = "smartPallet";
 	protected boolean isExtractSmartPalletEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.SMARTPALLET);
 	}
 	
 	
 	//private boolean saveSmartPalletEnabled = true;
 	protected boolean isSaveSmartPalletEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.SMARTPALLET);
 	}
 	

 	
  
 	//private boolean extractShippingSpaceEnabled = true;
 	//private static final String SHIPPINGSPACE = "shippingSpace";
 	protected boolean isExtractShippingSpaceEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.SHIPPINGSPACE);
 	}
 	
 	
 	//private boolean saveShippingSpaceEnabled = true;
 	protected boolean isSaveShippingSpaceEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.SHIPPINGSPACE);
 	}
 	

 	
  
 	//private boolean extractTransportTaskEnabled = true;
 	//private static final String TRANSPORTTASK = "transportTask";
 	protected boolean isExtractTransportTaskEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.TRANSPORTTASK);
 	}
 	
 	
 	//private boolean saveTransportTaskEnabled = true;
 	protected boolean isSaveTransportTaskEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.TRANSPORTTASK);
 	}
 	

 	
  
 	//private boolean extractRetailStoreEnabled = true;
 	//private static final String RETAILSTORE = "retailStore";
 	protected boolean isExtractRetailStoreEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.RETAILSTORE);
 	}
 	
 	
 	//private boolean saveRetailStoreEnabled = true;
 	protected boolean isSaveRetailStoreEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.RETAILSTORE);
 	}
 	

 	
  
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.BIZORDER);
 	}
 	

 	
  
 	//private boolean extractRetailStoreOrderEnabled = true;
 	//private static final String RETAILSTOREORDER = "retailStoreOrder";
 	protected boolean isExtractRetailStoreOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.RETAILSTOREORDER);
 	}
 	
 	
 	//private boolean saveRetailStoreOrderEnabled = true;
 	protected boolean isSaveRetailStoreOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.RETAILSTOREORDER);
 	}
 	

 	
  
 	//private boolean extractPackagingEnabled = true;
 	//private static final String PACKAGING = "packaging";
 	protected boolean isExtractPackagingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsTokens.PACKAGING);
 	}
 	
 	
 	//private boolean savePackagingEnabled = true;
 	protected boolean isSavePackagingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsTokens.PACKAGING);
 	}
 	

 	
 
		
	//protected static final String GOODS_MOVEMENT_LIST = "goodsMovementList";
	
	protected boolean isExtractGoodsMovementListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsTokens.GOODS_MOVEMENT_LIST);
		
 	}

	protected boolean isSaveGoodsMovementListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsTokens.GOODS_MOVEMENT_LIST);
		
 	}
 	
 	
			
		

	

	protected GoodsMapper getGoodsMapper(){
		return new GoodsMapper();
	}
	protected Goods extractGoods(String goodsId) throws Exception{
		String SQL = "select * from goods_data where id = ?";	
		try{
		
			Goods goods = queryForObject(SQL, new Object[]{goodsId}, getGoodsMapper());
			return goods;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsNotFoundException("Goods("+goodsId+") is not found!");
		}
		
		
	}
	protected Goods extractGoods(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from goods_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Goods goods = queryForObject(SQL, new Object[]{accessKey.getValue()}, getGoodsMapper());
			return goods;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsNotFoundException("Goods("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Goods loadInternalGoods(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Goods goods = extractGoods(accessKey, loadOptions);
 	
 		if(isExtractSkuEnabled(loadOptions)){
	 		extractSku(goods, loadOptions);
 		}
  	
 		if(isExtractReceivingSpaceEnabled(loadOptions)){
	 		extractReceivingSpace(goods, loadOptions);
 		}
  	
 		if(isExtractGoodsAllocationEnabled(loadOptions)){
	 		extractGoodsAllocation(goods, loadOptions);
 		}
  	
 		if(isExtractSmartPalletEnabled(loadOptions)){
	 		extractSmartPallet(goods, loadOptions);
 		}
  	
 		if(isExtractShippingSpaceEnabled(loadOptions)){
	 		extractShippingSpace(goods, loadOptions);
 		}
  	
 		if(isExtractTransportTaskEnabled(loadOptions)){
	 		extractTransportTask(goods, loadOptions);
 		}
  	
 		if(isExtractRetailStoreEnabled(loadOptions)){
	 		extractRetailStore(goods, loadOptions);
 		}
  	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(goods, loadOptions);
 		}
  	
 		if(isExtractRetailStoreOrderEnabled(loadOptions)){
	 		extractRetailStoreOrder(goods, loadOptions);
 		}
  	
 		if(isExtractPackagingEnabled(loadOptions)){
	 		extractPackaging(goods, loadOptions);
 		}
 
		
		if(isExtractGoodsMovementListEnabled(loadOptions)){
	 		extractGoodsMovementList(goods, loadOptions);
 		}		
		
		return goods;
		
	}



	
	
	 

 	protected Goods extractSku(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getSku() == null){
			return goods;
		}
		String skuId = goods.getSku().getId();
		if( skuId == null){
			return goods;
		}
		Sku sku = getSkuDAO().load(skuId,options);
		if(sku != null){
			goods.setSku(sku);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractReceivingSpace(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getReceivingSpace() == null){
			return goods;
		}
		String receivingSpaceId = goods.getReceivingSpace().getId();
		if( receivingSpaceId == null){
			return goods;
		}
		ReceivingSpace receivingSpace = getReceivingSpaceDAO().load(receivingSpaceId,options);
		if(receivingSpace != null){
			goods.setReceivingSpace(receivingSpace);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractGoodsAllocation(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getGoodsAllocation() == null){
			return goods;
		}
		String goodsAllocationId = goods.getGoodsAllocation().getId();
		if( goodsAllocationId == null){
			return goods;
		}
		GoodsAllocation goodsAllocation = getGoodsAllocationDAO().load(goodsAllocationId,options);
		if(goodsAllocation != null){
			goods.setGoodsAllocation(goodsAllocation);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractSmartPallet(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getSmartPallet() == null){
			return goods;
		}
		String smartPalletId = goods.getSmartPallet().getId();
		if( smartPalletId == null){
			return goods;
		}
		SmartPallet smartPallet = getSmartPalletDAO().load(smartPalletId,options);
		if(smartPallet != null){
			goods.setSmartPallet(smartPallet);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractShippingSpace(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getShippingSpace() == null){
			return goods;
		}
		String shippingSpaceId = goods.getShippingSpace().getId();
		if( shippingSpaceId == null){
			return goods;
		}
		ShippingSpace shippingSpace = getShippingSpaceDAO().load(shippingSpaceId,options);
		if(shippingSpace != null){
			goods.setShippingSpace(shippingSpace);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractTransportTask(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getTransportTask() == null){
			return goods;
		}
		String transportTaskId = goods.getTransportTask().getId();
		if( transportTaskId == null){
			return goods;
		}
		TransportTask transportTask = getTransportTaskDAO().load(transportTaskId,options);
		if(transportTask != null){
			goods.setTransportTask(transportTask);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractRetailStore(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getRetailStore() == null){
			return goods;
		}
		String retailStoreId = goods.getRetailStore().getId();
		if( retailStoreId == null){
			return goods;
		}
		RetailStore retailStore = getRetailStoreDAO().load(retailStoreId,options);
		if(retailStore != null){
			goods.setRetailStore(retailStore);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractBizOrder(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getBizOrder() == null){
			return goods;
		}
		String bizOrderId = goods.getBizOrder().getId();
		if( bizOrderId == null){
			return goods;
		}
		SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			goods.setBizOrder(bizOrder);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractRetailStoreOrder(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getRetailStoreOrder() == null){
			return goods;
		}
		String retailStoreOrderId = goods.getRetailStoreOrder().getId();
		if( retailStoreOrderId == null){
			return goods;
		}
		RetailStoreOrder retailStoreOrder = getRetailStoreOrderDAO().load(retailStoreOrderId,options);
		if(retailStoreOrder != null){
			goods.setRetailStoreOrder(retailStoreOrder);
		}
		
 		
 		return goods;
 	}
 		
  

 	protected Goods extractPackaging(Goods goods, Map<String,Object> options) throws Exception{

		if(goods.getPackaging() == null){
			return goods;
		}
		String packagingId = goods.getPackaging().getId();
		if( packagingId == null){
			return goods;
		}
		GoodsPackaging packaging = getGoodsPackagingDAO().load(packagingId,options);
		if(packaging != null){
			goods.setPackaging(packaging);
		}
		
 		
 		return goods;
 	}
 		
 
		
	protected Goods extractGoodsMovementList(Goods goods, Map<String,Object> options){
		
		SmartList<GoodsMovement> goodsMovementList = getGoodsMovementDAO().findGoodsMovementByGoods(goods.getId(),options);
		if(goodsMovementList != null){
			goods.setGoodsMovementList(goodsMovementList);
		}
		
		return goods;
	
	}	
		
		
  	
 	public SmartList<Goods> findGoodsBySku(String skuId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where sku = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{skuId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsBySku(String skuId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where sku = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{skuId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsBySku(String skuId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where sku = ?";
		Integer count = queryInt(SQL, new Object[]{skuId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where receiving_space = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{receivingSpaceId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where receiving_space = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{receivingSpaceId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByReceivingSpace(String receivingSpaceId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where receiving_space = ?";
		Integer count = queryInt(SQL, new Object[]{receivingSpaceId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods_allocation = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{goodsAllocationId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods_allocation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{goodsAllocationId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByGoodsAllocation(String goodsAllocationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where goods_allocation = ?";
		Integer count = queryInt(SQL, new Object[]{goodsAllocationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where smart_pallet = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{smartPalletId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where smart_pallet = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{smartPalletId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsBySmartPallet(String smartPalletId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where smart_pallet = ?";
		Integer count = queryInt(SQL, new Object[]{smartPalletId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipping_space = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{shippingSpaceId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where shipping_space = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{shippingSpaceId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByShippingSpace(String shippingSpaceId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where shipping_space = ?";
		Integer count = queryInt(SQL, new Object[]{shippingSpaceId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where transport_task = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{transportTaskId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where transport_task = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{transportTaskId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByTransportTask(String transportTaskId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where transport_task = ?";
		Integer count = queryInt(SQL, new Object[]{transportTaskId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{retailStoreId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{retailStoreId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByRetailStore(String retailStoreId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where retail_store = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{supplyOrderId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{supplyOrderId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByBizOrder(String supplyOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store_order = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{retailStoreOrderId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where retail_store_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{retailStoreOrderId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByRetailStoreOrder(String retailStoreOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where retail_store_order = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<Goods> findGoodsByPackaging(String goodsPackagingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where packaging = ?";
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{goodsPackagingId}, getGoodsMapper());	
 		return goodsList;
 	}
 	
 	public SmartList<Goods> findGoodsByPackaging(String goodsPackagingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where packaging = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Goods> goodsList = queryForList(SQL, new Object[]{goodsPackagingId,start, count}, getGoodsMapper());
		
 		return goodsList;
 	}
 	
 	public int countGoodsByPackaging(String goodsPackagingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where packaging = ?";
		Integer count = queryInt(SQL, new Object[]{goodsPackagingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Goods saveGoods(Goods  goods){
	
		String SQL=this.getSaveGoodsSQL(goods);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsParameters(goods);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goods.incVersion();
		return goods;
	
	}
	public SmartList<Goods> saveGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsList(goodsList);
		
		batchGoodsCreate((List<Goods>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsUpdate((List<Goods>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Goods goods:goodsList){
			if(goods.isChanged()){
				goods.incVersion();
			}
			
		
		}
		
		
		return goodsList;
	}

	public SmartList<Goods> removeGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		
		
		super.removeList(goodsList, options);
		
		return goodsList;
		
		
	}
	
	protected List<Object[]> prepareGoodsBatchCreateArgs(List<Goods> goodsList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Goods goods:goodsList ){
			Object [] parameters = prepareGoodsCreateParameters(goods);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsBatchUpdateArgs(List<Goods> goodsList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Goods goods:goodsList ){
			if(!goods.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsUpdateParameters(goods);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsCreate(List<Goods> goodsList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsBatchCreateArgs(goodsList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsUpdate(List<Goods> goodsList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsBatchUpdateArgs(goodsList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsList(List<Goods> goodsList){
		
		List<Goods> goodsCreateList=new ArrayList<Goods>();
		List<Goods> goodsUpdateList=new ArrayList<Goods>();
		
		for(Goods goods: goodsList){
			if(isUpdateRequest(goods)){
				goodsUpdateList.add( goods);
				continue;
			}
			goodsCreateList.add(goods);
		}
		
		return new Object[]{goodsCreateList,goodsUpdateList};
	}
	
	protected boolean isUpdateRequest(Goods goods){
 		return goods.getVersion() > 0;
 	}
 	protected String getSaveGoodsSQL(Goods goods){
 		if(isUpdateRequest(goods)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsParameters(Goods goods){
 		if(isUpdateRequest(goods) ){
 			return prepareGoodsUpdateParameters(goods);
 		}
 		return prepareGoodsCreateParameters(goods);
 	}
 	protected Object[] prepareGoodsUpdateParameters(Goods goods){
 		Object[] parameters = new Object[18];
 
 		parameters[0] = goods.getName();
 		parameters[1] = goods.getRfid();
 		parameters[2] = goods.getUom();
 		parameters[3] = goods.getMaxPackage();
 		parameters[4] = goods.getExpireTime(); 	
 		if(goods.getSku() != null){
 			parameters[5] = goods.getSku().getId();
 		}
  	
 		if(goods.getReceivingSpace() != null){
 			parameters[6] = goods.getReceivingSpace().getId();
 		}
  	
 		if(goods.getGoodsAllocation() != null){
 			parameters[7] = goods.getGoodsAllocation().getId();
 		}
  	
 		if(goods.getSmartPallet() != null){
 			parameters[8] = goods.getSmartPallet().getId();
 		}
  	
 		if(goods.getShippingSpace() != null){
 			parameters[9] = goods.getShippingSpace().getId();
 		}
  	
 		if(goods.getTransportTask() != null){
 			parameters[10] = goods.getTransportTask().getId();
 		}
  	
 		if(goods.getRetailStore() != null){
 			parameters[11] = goods.getRetailStore().getId();
 		}
  	
 		if(goods.getBizOrder() != null){
 			parameters[12] = goods.getBizOrder().getId();
 		}
  	
 		if(goods.getRetailStoreOrder() != null){
 			parameters[13] = goods.getRetailStoreOrder().getId();
 		}
  	
 		if(goods.getPackaging() != null){
 			parameters[14] = goods.getPackaging().getId();
 		}
 
 		parameters[15] = goods.getCurrentStatus();		
 		parameters[16] = goods.getId();
 		parameters[17] = goods.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsCreateParameters(Goods goods){
		Object[] parameters = new Object[17];
		String newGoodsId=getNextId();
		goods.setId(newGoodsId);
		parameters[0] =  goods.getId();
 
 		parameters[1] = goods.getName();
 		parameters[2] = goods.getRfid();
 		parameters[3] = goods.getUom();
 		parameters[4] = goods.getMaxPackage();
 		parameters[5] = goods.getExpireTime(); 	
 		if(goods.getSku() != null){
 			parameters[6] = goods.getSku().getId();
 		
 		}
 		 	
 		if(goods.getReceivingSpace() != null){
 			parameters[7] = goods.getReceivingSpace().getId();
 		
 		}
 		 	
 		if(goods.getGoodsAllocation() != null){
 			parameters[8] = goods.getGoodsAllocation().getId();
 		
 		}
 		 	
 		if(goods.getSmartPallet() != null){
 			parameters[9] = goods.getSmartPallet().getId();
 		
 		}
 		 	
 		if(goods.getShippingSpace() != null){
 			parameters[10] = goods.getShippingSpace().getId();
 		
 		}
 		 	
 		if(goods.getTransportTask() != null){
 			parameters[11] = goods.getTransportTask().getId();
 		
 		}
 		 	
 		if(goods.getRetailStore() != null){
 			parameters[12] = goods.getRetailStore().getId();
 		
 		}
 		 	
 		if(goods.getBizOrder() != null){
 			parameters[13] = goods.getBizOrder().getId();
 		
 		}
 		 	
 		if(goods.getRetailStoreOrder() != null){
 			parameters[14] = goods.getRetailStoreOrder().getId();
 		
 		}
 		 	
 		if(goods.getPackaging() != null){
 			parameters[15] = goods.getPackaging().getId();
 		
 		}
 		
 		parameters[16] = goods.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected Goods saveInternalGoods(Goods goods, Map<String,Object> options){
		
		saveGoods(goods);
 	
 		if(isSaveSkuEnabled(options)){
	 		saveSku(goods, options);
 		}
  	
 		if(isSaveReceivingSpaceEnabled(options)){
	 		saveReceivingSpace(goods, options);
 		}
  	
 		if(isSaveGoodsAllocationEnabled(options)){
	 		saveGoodsAllocation(goods, options);
 		}
  	
 		if(isSaveSmartPalletEnabled(options)){
	 		saveSmartPallet(goods, options);
 		}
  	
 		if(isSaveShippingSpaceEnabled(options)){
	 		saveShippingSpace(goods, options);
 		}
  	
 		if(isSaveTransportTaskEnabled(options)){
	 		saveTransportTask(goods, options);
 		}
  	
 		if(isSaveRetailStoreEnabled(options)){
	 		saveRetailStore(goods, options);
 		}
  	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(goods, options);
 		}
  	
 		if(isSaveRetailStoreOrderEnabled(options)){
	 		saveRetailStoreOrder(goods, options);
 		}
  	
 		if(isSavePackagingEnabled(options)){
	 		savePackaging(goods, options);
 		}
 
		
		if(isSaveGoodsMovementListEnabled(options)){
	 		saveGoodsMovementList(goods, options);
	 		removeGoodsMovementList(goods, options);
	 		
 		}		
		
		return goods;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Goods saveSku(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getSku() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getSkuDAO().save(goods.getSku(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveReceivingSpace(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getReceivingSpace() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getReceivingSpaceDAO().save(goods.getReceivingSpace(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveGoodsAllocation(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getGoodsAllocation() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getGoodsAllocationDAO().save(goods.getGoodsAllocation(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveSmartPallet(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getSmartPallet() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getSmartPalletDAO().save(goods.getSmartPallet(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveShippingSpace(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getShippingSpace() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getShippingSpaceDAO().save(goods.getShippingSpace(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveTransportTask(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getTransportTask() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getTransportTaskDAO().save(goods.getTransportTask(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveRetailStore(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getRetailStore() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getRetailStoreDAO().save(goods.getRetailStore(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveBizOrder(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getBizOrder() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getSupplyOrderDAO().save(goods.getBizOrder(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods saveRetailStoreOrder(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getRetailStoreOrder() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getRetailStoreOrderDAO().save(goods.getRetailStoreOrder(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Goods savePackaging(Goods goods, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goods.getPackaging() == null){
 			return goods;//do nothing when it is null
 		}
 		
 		getGoodsPackagingDAO().save(goods.getPackaging(),options);
 		return goods;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Goods saveGoodsMovementList(Goods goods, Map<String,Object> options){
		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();
		if(goodsMovementList == null){
			return goods;
		}
		if(goodsMovementList.isEmpty()){
			return goods;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsMovementDAO().saveGoodsMovementList(goodsMovementList,options);
		
		return goods;
	
	}
	
	protected Goods removeGoodsMovementList(Goods goods, Map<String,Object> options){
	
	
		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();
		if(goodsMovementList == null){
			return goods;
		}	
	
		SmartList<GoodsMovement> toRemoveGoodsMovementList = goodsMovementList.getToRemoveList();
		
		if(toRemoveGoodsMovementList == null){
			return goods;
		}
		if(toRemoveGoodsMovementList.isEmpty()){
			return goods;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsMovementDAO().removeGoodsMovementList(toRemoveGoodsMovementList,options);
		
		return goods;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Goods present(Goods goods,Map<String, Object> options){
	
		presentGoodsMovementList(goods,options);

		return goods;
	
	}
		
	
  	
 	protected Goods presentGoodsMovementList(
			Goods goods,
			Map<String, Object> options) {

		SmartList<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();		
		if(goodsMovementList == null){
			return goods;			
		}
		
		String targetObjectName = "goodsMovement";
		int goodsMovementListSize = goodsMovementList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsMovementListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goods;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsMovementListSize;
		if(goodsMovementListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsMovementDAO().countGoodsMovementByGoods(goods.getId(), options);			
		}
		//goods.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goods.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsMovementListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsMovementListSize,currentPage,rowsPerPage) ;
			goodsMovementList = goodsMovementList.subListOf(fromIndex, toIndex);
			goodsMovementList.setTotalCount(count);
			goodsMovementList.setCurrentPageNumber(currentPage);			
			goods.setGoodsMovementList(goodsMovementList);
			return goods;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsMovementList 
			= getGoodsMovementDAO().findGoodsMovementByGoods(goods.getId(),start, rowsPerPage, options );
		goodsMovementList.setTotalCount(count);
		goodsMovementList.setCurrentPageNumber(currentPage);
		goods.setGoodsMovementList(goodsMovementList );	

		return goods;
	}			
		


	protected String getTableName(){
		return GoodsTable.TABLE_NAME;
	}
}


