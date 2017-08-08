
package com.skynet.retailscm.truckdriver;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TruckDriverManager{

	public TruckDriver createTruckDriver(RetailScmUserContext userContext, String name, String driverLicenseNumber, String contactNumber, String belongsToId
) throws Exception;	
	public TruckDriver updateTruckDriver(RetailScmUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TruckDriver transferToAnotherBelongsTo(RetailScmUserContext userContext, String truckDriverId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String truckDriverId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  TruckDriver addTransportTask(RetailScmUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  TruckDriver removeTransportTask(RetailScmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TruckDriver updateTransportTask(RetailScmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


