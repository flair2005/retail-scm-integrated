
package com.skynet.retailscm.transporttruck;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TransportTruckManager{

	public TransportTruck createTransportTruck(RetailScmUserContext userContext, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, String ownerId
) throws Exception;	
	public TransportTruck updateTransportTruck(RetailScmUserContext userContext,String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TransportTruck transferToAnotherOwner(RetailScmUserContext userContext, String transportTruckId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String transportTruckId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  TransportTruck addTransportTask(RetailScmUserContext userContext, String transportTruckId, String name, String start, Date beginTime, String endId, String driverId, String belongsToId, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  TransportTruck removeTransportTask(RetailScmUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TransportTruck updateTransportTask(RetailScmUserContext userContext, String transportTruckId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


