
package com.skynet.retailscm.transporttasktrack;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface TransportTaskTrackManager{

	public TransportTaskTrack createTransportTaskTrack(RetailScmUserContext userContext, Date trackTime, double latitude, double longitude, String movementId
) throws Exception;	
	public TransportTaskTrack updateTransportTaskTrack(RetailScmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public TransportTaskTrack transferToAnotherMovement(RetailScmUserContext userContext, String transportTaskTrackId, String anotherMovementId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String transportTaskTrackId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


