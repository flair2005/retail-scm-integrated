
package com.skynet.retailscm.eventattendance;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface EventAttendanceManager{

	public EventAttendance createEventAttendance(RetailScmUserContext userContext, String name, String potentialCustomerId, String cityEventId, String description
) throws Exception;	
	public EventAttendance updateEventAttendance(RetailScmUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public EventAttendance transferToAnotherPotentialCustomer(RetailScmUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId)  throws Exception;
 	public EventAttendance transferToAnotherCityEvent(RetailScmUserContext userContext, String eventAttendanceId, String anotherCityEventId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String eventAttendanceId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


