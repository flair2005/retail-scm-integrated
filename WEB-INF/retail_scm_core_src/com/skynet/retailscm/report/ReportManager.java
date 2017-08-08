
package com.skynet.retailscm.report;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ReportManager{

	public Report createReport(RetailScmUserContext userContext, String name, String createdBy, String ownerId
) throws Exception;	
	public Report updateReport(RetailScmUserContext userContext,String reportId, int reportVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Report transferToAnotherOwner(RetailScmUserContext userContext, String reportId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String reportId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Report addReportLine(RetailScmUserContext userContext, String reportId, String name, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december ,String [] tokensExpr)  throws Exception;
	public  Report removeReportLine(RetailScmUserContext userContext, String reportId, String reportLineId, int reportLineVersion,String [] tokensExpr)  throws Exception;
	public  Report updateReportLine(RetailScmUserContext userContext, String reportId, String reportLineId, int reportLineVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


