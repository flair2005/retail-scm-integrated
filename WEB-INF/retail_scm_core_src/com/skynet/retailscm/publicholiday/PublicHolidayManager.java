
package com.skynet.retailscm.publicholiday;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface PublicHolidayManager{

	public PublicHoliday createPublicHoliday(RetailScmUserContext userContext, String code, String companyId, String name, String description
) throws Exception;	
	public PublicHoliday updatePublicHoliday(RetailScmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public PublicHoliday transferToAnotherCompany(RetailScmUserContext userContext, String publicHolidayId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String publicHolidayId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


