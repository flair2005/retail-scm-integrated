
package com.skynet.retailscm.transportfleet;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TransportFleetManager{

	public TransportFleet createTransportFleet(RetailScmUserContext userContext, String name, String contactNumber, String ownerId
) throws Exception;	
	public TransportFleet updateTransportFleet(RetailScmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TransportFleet transferToAnotherOwner(RetailScmUserContext userContext, String transportFleetId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String transportFleetId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  TransportFleet addTransportTruck(RetailScmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor ,String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTransportTruck(RetailScmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTransportTruck(RetailScmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTruckDriver(RetailScmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber ,String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTruckDriver(RetailScmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTruckDriver(RetailScmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTransportTask(RetailScmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTransportTask(RetailScmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTransportTask(RetailScmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


