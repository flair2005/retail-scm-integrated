
package com.skynet.retailscm.cityevent;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface CityEventManager{

	public CityEvent createCityEvent(RetailScmUserContext userContext, String name, String mobile, String cityServiceCenterId, String description
) throws Exception;	
	public CityEvent updateCityEvent(RetailScmUserContext userContext,String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public CityEvent transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String cityEventId, String anotherCityServiceCenterId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String cityEventId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  CityEvent addEventAttendance(RetailScmUserContext userContext, String cityEventId, String name, String potentialCustomerId, String description ,String [] tokensExpr)  throws Exception;
	public  CityEvent removeEventAttendance(RetailScmUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  CityEvent updateEventAttendance(RetailScmUserContext userContext, String cityEventId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


