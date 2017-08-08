
package com.skynet.retailscm.transporttask;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrack;
import com.skynet.retailscm.truckdriver.TruckDriver;

import com.skynet.retailscm.transportfleet.TransportFleetDAO;
import com.skynet.retailscm.truckdriver.TruckDriverDAO;
import com.skynet.retailscm.transporttruck.TransportTruckDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;

import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;


import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.transportfleet.TransportFleetTable;
import com.skynet.retailscm.truckdriver.TruckDriverTable;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrackTable;
import com.skynet.retailscm.transporttruck.TransportTruckTable;




public class TransportTaskManagerImpl extends RetailScmCheckerManager implements TransportTaskManager {
	
	private static final String SERVICE_TYPE = "TransportTask";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO  transportTaskDAO){
 	
 		if(transportTaskDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskDAO to null.");
 		}
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
 		if(this.transportTaskDAO == null){
 			throw new IllegalStateException("The TransportTaskDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskDAO;
 	}
 	
 	protected TransportTask saveTransportTask(RetailScmUserContext userContext, TransportTask transportTask, String [] tokensExpr) throws Exception{	
 		//return getTransportTaskDAO().save(transportTask, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveTransportTask(userContext, transportTask, tokens);
 	}
 	
 	protected TransportTask saveTransportTaskDetail(RetailScmUserContext userContext, TransportTask transportTask) throws Exception{	

 		
 		return saveTransportTask(userContext, transportTask, allTokens());
 	}
 	
 	public TransportTask loadTransportTask(RetailScmUserContext userContext, String transportTaskId, String [] tokensExpr) throws Exception{				
 
 		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportTask, tokens);
 	}
 	
 	protected TransportTask present(RetailScmUserContext userContext, TransportTask transportTask, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,transportTask,tokens);
		
		
		return this.getTransportTaskDAO().present(transportTask, tokens);
	}
 
 	
 	
 	public TransportTask loadTransportTaskDetail(RetailScmUserContext userContext, String transportTaskId) throws Exception{	
 		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, allTokens());

 		return present(userContext,transportTask, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String transportTaskId) throws Exception{	
 		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		TransportTask transportTask = loadTransportTask( userContext, transportTaskId, allTokens());

 		return present(userContext,transportTask, allTokens());
		
 	}
 	protected TransportTask saveTransportTask(RetailScmUserContext userContext, TransportTask transportTask, Map<String,Object>tokens) throws Exception{	
 		return getTransportTaskDAO().save(transportTask, tokens);
 	}
 	protected TransportTask loadTransportTask(RetailScmUserContext userContext, String transportTaskId, Map<String,Object>tokens) throws Exception{	
 		return getTransportTaskDAO().load(transportTaskId, tokens);
 	}

	



 	 
 	
 	private  TruckDriverDAO  truckDriverDAO;
 	public void setTruckDriverDAO(TruckDriverDAO truckDriverDAO){
	 	this.truckDriverDAO = truckDriverDAO;
 	}
 	//------------------------------------
 	public TruckDriverDAO getTruckDriverDAO(){
	 	return this.truckDriverDAO;
 	}
 
 	
 	private  TransportFleetDAO  transportFleetDAO;
 	public void setTransportFleetDAO(TransportFleetDAO transportFleetDAO){
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	//------------------------------------
 	public TransportFleetDAO getTransportFleetDAO(){
	 	return this.transportFleetDAO;
 	}
 
 	
 	private  TransportTruckDAO  transportTruckDAO;
 	public void setTransportTruckDAO(TransportTruckDAO transportTruckDAO){
	 	this.transportTruckDAO = transportTruckDAO;
 	}
 	//------------------------------------
 	public TransportTruckDAO getTransportTruckDAO(){
	 	return this.transportTruckDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	//------------------------------------
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportTask transportTask, Map<String, Object> tokens){
		super.addActions(userContext, transportTask, tokens);
		
		addAction(userContext, transportTask, tokens,"@create","createTransportTask","createTransportTask/","main","primary");
		addAction(userContext, transportTask, tokens,"@update","updateTransportTask","updateTransportTask/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"@copy","cloneTransportTask","cloneTransportTask/"+transportTask.getId()+"/","main","primary");
		
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_end","transferToAnotherEnd","transferToAnotherEnd/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_driver","transferToAnotherDriver","transferToAnotherDriver/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_truck","transferToAnotherTruck","transferToAnotherTruck/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+transportTask.getId()+"/","main","primary");
		addAction(userContext, transportTask, tokens,"transport_task.addGoods","addGoods","addGoods/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.removeGoods","removeGoods","removeGoods/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.updateGoods","updateGoods","updateGoods/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+transportTask.getId()+"/","goodsList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.addTransportTaskTrack","addTransportTaskTrack","addTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.removeTransportTaskTrack","removeTransportTaskTrack","removeTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.updateTransportTaskTrack","updateTransportTaskTrack","updateTransportTaskTrack/"+transportTask.getId()+"/","transportTaskTrackList","primary");
		addAction(userContext, transportTask, tokens,"transport_task.copyTransportTaskTrackFrom","copyTransportTaskTrackFrom","copyTransportTaskTrackFrom/"+transportTask.getId()+"/","transportTaskTrackList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, TransportTask transportTask, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public TransportTask createTransportTask(RetailScmUserContext userContext,String name, String start, Date beginTime, String endId, String driverId, String truckId, String belongsToId, double latitude, double longitude
) throws Exception
	{
		
		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");

		

		checkNameOfTransportTask(userContext,  name, exception);
		checkStartOfTransportTask(userContext,  start, exception);
		checkBeginTimeOfTransportTask(userContext,  beginTime, exception);
		checkLatitudeOfTransportTask(userContext,  latitude, exception);
		checkLongitudeOfTransportTask(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		TransportTask transportTask=createNewTransportTask();	

		transportTask.setName(name);
		transportTask.setStart(start);
		transportTask.setBeginTime(beginTime);
		RetailStore end = loadRetailStore(endId,emptyOptions());
		transportTask.setEnd(end);
		TruckDriver driver = loadTruckDriver(driverId,emptyOptions());
		transportTask.setDriver(driver);
		TransportTruck truck = loadTransportTruck(truckId,emptyOptions());
		transportTask.setTruck(truck);
		TransportFleet belongsTo = loadTransportFleet(belongsToId,emptyOptions());
		transportTask.setBelongsTo(belongsTo);
		transportTask.setLatitude(latitude);
		transportTask.setLongitude(longitude);

		return saveTransportTask(userContext, transportTask, emptyOptions());
		

		
	}
	protected TransportTask createNewTransportTask() 
	{
		
		return new TransportTask();		
	}
	
	protected void checkParamsForUpdatingTransportTask(RetailScmUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
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
	
	
	
	public TransportTask clone(RetailScmUserContext userContext, String fromTransportTaskId) throws Exception{
		
		return this.getTransportTaskDAO().clone(fromTransportTaskId, this.allTokens());
	}
	
	public TransportTask updateTransportTask(RetailScmUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingTransportTask(userContext, transportTaskId, transportTaskVersion, property, newValueExpr, tokensExpr);
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		if(transportTask.getVersion() != transportTaskVersion){
			String message = "The target version("+transportTask.getVersion()+") is not equals to version("+transportTaskVersion+") provided";
			throw new TransportTaskManagerException(message);
		}
		synchronized(transportTask){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportTask.
			
			transportTask.changePropery(property, newValueExpr);
			transportTask = saveTransportTask(userContext, transportTask, tokens().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
			//return saveTransportTask(userContext, transportTask, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected TransportTaskTokens tokens(){
		return TransportTaskTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportTaskTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportTaskTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherEnd(RetailScmUserContext userContext, String transportTaskId, String anotherEndId) throws Exception
 	{
 		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
 		checkIdOfTransportTask(userContext, transportTaskId,exception);
 		checkIdOfRetailStore(userContext, anotherEndId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TransportTask transferToAnotherEnd(RetailScmUserContext userContext, String transportTaskId, String anotherEndId) throws Exception
 	{
 		checkParamsForTransferingAnotherEnd(userContext, transportTaskId,anotherEndId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStore end = loadRetailStore(anotherEndId, emptyOptions());		
			transportTask.setEnd(end);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherDriver(RetailScmUserContext userContext, String transportTaskId, String anotherDriverId) throws Exception
 	{
 		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
 		checkIdOfTransportTask(userContext, transportTaskId,exception);
 		checkIdOfTruckDriver(userContext, anotherDriverId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TransportTask transferToAnotherDriver(RetailScmUserContext userContext, String transportTaskId, String anotherDriverId) throws Exception
 	{
 		checkParamsForTransferingAnotherDriver(userContext, transportTaskId,anotherDriverId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TruckDriver driver = loadTruckDriver(anotherDriverId, emptyOptions());		
			transportTask.setDriver(driver);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherTruck(RetailScmUserContext userContext, String transportTaskId, String anotherTruckId) throws Exception
 	{
 		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
 		checkIdOfTransportTask(userContext, transportTaskId,exception);
 		checkIdOfTransportTruck(userContext, anotherTruckId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TransportTask transferToAnotherTruck(RetailScmUserContext userContext, String transportTaskId, String anotherTruckId) throws Exception
 	{
 		checkParamsForTransferingAnotherTruck(userContext, transportTaskId,anotherTruckId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportTruck truck = loadTransportTruck(anotherTruckId, emptyOptions());		
			transportTask.setTruck(truck);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherBelongsTo(RetailScmUserContext userContext, String transportTaskId, String anotherBelongsToId) throws Exception
 	{
 		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
 		checkIdOfTransportTask(userContext, transportTaskId,exception);
 		checkIdOfTransportFleet(userContext, anotherBelongsToId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public TransportTask transferToAnotherBelongsTo(RetailScmUserContext userContext, String transportTaskId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, transportTaskId,anotherBelongsToId);
 
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());	
		synchronized(transportTask){
			//will be good when the transportTask loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			TransportFleet belongsTo = loadTransportFleet(anotherBelongsToId, emptyOptions());		
			transportTask.setBelongsTo(belongsTo);		
			transportTask = saveTransportTask(userContext, transportTask, emptyOptions());
			
			return present(userContext,transportTask, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected TruckDriver loadTruckDriver(String newDriverId, Map<String,Object> options) throws Exception
 	{
		
 		return getTruckDriverDAO().load(newDriverId, options);
 	}
	
	 	
 	protected TransportFleet loadTransportFleet(String newBelongsToId, Map<String,Object> options) throws Exception
 	{
		
 		return getTransportFleetDAO().load(newBelongsToId, options);
 	}
	
	 	
 	protected TransportTruck loadTransportTruck(String newTruckId, Map<String,Object> options) throws Exception
 	{
		
 		return getTransportTruckDAO().load(newTruckId, options);
 	}
	
	 	
 	protected RetailStore loadRetailStore(String newEndId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreDAO().load(newEndId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String transportTaskId, int transportTaskVersion) throws Exception {
		
		deleteInternal(userContext, transportTaskId, transportTaskVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String transportTaskId, int transportTaskVersion) throws Exception{
		getTransportTaskDAO().delete(transportTaskId, transportTaskVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportTaskManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getTransportTaskDAO().deleteAll();
	}

	protected void checkParamsForAddingGoods(RetailScmUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{
		
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);

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
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfSupplyOrder(userContext,  bizOrderId, exception);		
		
		checkIdOfRetailStoreOrder(userContext,  retailStoreOrderId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TransportTask addGoods(RetailScmUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoods(userContext,transportTaskId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, retailStoreId, bizOrderId, retailStoreOrderId,tokensExpr);
		
		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, retailStoreId, bizOrderId, retailStoreOrderId);
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.addGoods( goods );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}
	protected Goods createGoods(RetailScmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId) throws Exception{

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
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		goods.setRetailStore(retailStore);		
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
	protected void checkParamsForRemovingGoods(RetailScmUserContext userContext, String transportTaskId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportTask removeGoods(RetailScmUserContext userContext, String transportTaskId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoods(userContext,transportTaskId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.removeGoods( goods );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoods(RetailScmUserContext userContext, String transportTaskId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkIdOfGoods(userContext, goodsId, exception);
		checkVersionOfGoods(userContext, goodsVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportTask copyGoodsFrom(RetailScmUserContext userContext, String transportTaskId, 
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoods(userContext,transportTaskId, goodsId, goodsVersion,tokensExpr);
		
		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.copyGoodsFrom( goods );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoods(RetailScmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
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
	
	public  TransportTask updateGoods(RetailScmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoods(userContext, transportTaskId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
		
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTask.removeGoods( goods );	
			//make changes to AcceleraterAccount.
			Goods goodsIndex = createIndexedGoods(goodsId, goodsVersion);
		
			Goods goods = transportTask.findTheGoods(goodsIndex);
			if(goods == null){
				throw new TransportTaskManagerException(goods+"Not found" );
			}
			
			goods.changePropery(property, newValueExpr);

			transportTask = saveTransportTask(userContext, transportTask, tokens().withGoodsList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, Date trackTime, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);

		checkTrackTimeOfTransportTaskTrack(userContext,  trackTime, exception);
		checkLatitudeOfTransportTaskTrack(userContext,  latitude, exception);
		checkLongitudeOfTransportTaskTrack(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  TransportTask addTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, Date trackTime, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportTaskTrack(userContext,transportTaskId,trackTime, latitude, longitude,tokensExpr);
		
		TransportTaskTrack transportTaskTrack = createTransportTaskTrack(userContext,trackTime, latitude, longitude);
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.addTransportTaskTrack( transportTaskTrack );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
	}
	protected TransportTaskTrack createTransportTaskTrack(RetailScmUserContext userContext, Date trackTime, double latitude, double longitude) throws Exception{

		TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
		
		
		transportTaskTrack.setTrackTime(trackTime);		
		transportTaskTrack.setLatitude(latitude);		
		transportTaskTrack.setLongitude(longitude);
	
		
		return transportTaskTrack;
	
		
	}
	
	protected TransportTaskTrack createIndexedTransportTaskTrack(String id, int version){

		TransportTaskTrack transportTaskTrack = new TransportTaskTrack();
		transportTaskTrack.setId(id);
		transportTaskTrack.setVersion(version);
		return transportTaskTrack;			
		
	}
	protected void checkParamsForRemovingTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId, exception);
		checkVersionOfTransportTaskTrack(userContext, transportTaskTrackVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportTask removeTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportTaskTrack(userContext,transportTaskId, transportTaskTrackId, transportTaskTrackVersion,tokensExpr);
		
		TransportTaskTrack transportTaskTrack = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.removeTransportTaskTrack( transportTaskTrack );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId, exception);
		checkVersionOfTransportTaskTrack(userContext, transportTaskTrackVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  TransportTask copyTransportTaskTrackFrom(RetailScmUserContext userContext, String transportTaskId, 
		String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportTaskTrack(userContext,transportTaskId, transportTaskTrackId, transportTaskTrackVersion,tokensExpr);
		
		TransportTaskTrack transportTaskTrack = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportTask.copyTransportTaskTrackFrom( transportTaskTrack );		
			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		TransportTaskManagerException exception = new TransportTaskManagerException("Error Occured");
		
		checkIdOfTransportTask(userContext, transportTaskId, exception);
		checkIdOfTransportTaskTrack(userContext, transportTaskTrackId, exception);
		checkVersionOfTransportTaskTrack(userContext, transportTaskTrackVersion, exception);
		

		if(TransportTaskTrack.TRACK_TIME_PROPERTY.equals(property)){
			checkTrackTimeOfTransportTaskTrack(userContext, parseDate(newValueExpr), exception);
		}
		
		if(TransportTaskTrack.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfTransportTaskTrack(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(TransportTaskTrack.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfTransportTaskTrack(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  TransportTask updateTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportTaskTrack(userContext, transportTaskId, transportTaskTrackId, transportTaskTrackVersion, property, newValueExpr,  tokensExpr);
		
		
		TransportTask transportTask = loadTransportTask(userContext, transportTaskId, allTokens());
		
		synchronized(transportTask){ 
			//Will be good when the transportTask loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportTask.removeTransportTaskTrack( transportTaskTrack );	
			//make changes to AcceleraterAccount.
			TransportTaskTrack transportTaskTrackIndex = createIndexedTransportTaskTrack(transportTaskTrackId, transportTaskTrackVersion);
		
			TransportTaskTrack transportTaskTrack = transportTask.findTheTransportTaskTrack(transportTaskTrackIndex);
			if(transportTaskTrack == null){
				throw new TransportTaskManagerException(transportTaskTrack+"Not found" );
			}
			
			transportTaskTrack.changePropery(property, newValueExpr);

			transportTask = saveTransportTask(userContext, transportTask, tokens().withTransportTaskTrackList().done());
			return present(userContext,transportTask, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


