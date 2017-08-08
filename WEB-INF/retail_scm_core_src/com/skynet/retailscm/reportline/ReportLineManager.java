
package com.skynet.retailscm.reportline;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ReportLineManager{

	public ReportLine createReportLine(RetailScmUserContext userContext, String name, String ownerId, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december
) throws Exception;	
	public ReportLine updateReportLine(RetailScmUserContext userContext,String reportLineId, int reportLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ReportLine transferToAnotherOwner(RetailScmUserContext userContext, String reportLineId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String reportLineId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


