
package com.skynet.retailscm.transporttask;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TransportTaskManager{

	public TransportTask createTransportTask(RetailScmUserContext userContext, String name, String start, Date beginTime, String endId, String driverId, String truckId, String belongsToId, double latitude, double longitude
) throws Exception;	
	public TransportTask updateTransportTask(RetailScmUserContext userContext,String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TransportTask transferToAnotherEnd(RetailScmUserContext userContext, String transportTaskId, String anotherEndId)  throws Exception;
 	public TransportTask transferToAnotherDriver(RetailScmUserContext userContext, String transportTaskId, String anotherDriverId)  throws Exception;
 	public TransportTask transferToAnotherTruck(RetailScmUserContext userContext, String transportTaskId, String anotherTruckId)  throws Exception;
 	public TransportTask transferToAnotherBelongsTo(RetailScmUserContext userContext, String transportTaskId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String transportTaskId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  TransportTask addGoods(RetailScmUserContext userContext, String transportTaskId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String retailStoreId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  TransportTask removeGoods(RetailScmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  TransportTask updateGoods(RetailScmUserContext userContext, String transportTaskId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  TransportTask addTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, Date trackTime, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  TransportTask removeTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion,String [] tokensExpr)  throws Exception;
	public  TransportTask updateTransportTaskTrack(RetailScmUserContext userContext, String transportTaskId, String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


