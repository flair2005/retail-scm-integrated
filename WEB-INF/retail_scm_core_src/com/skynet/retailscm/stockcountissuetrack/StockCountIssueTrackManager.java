
package com.skynet.retailscm.stockcountissuetrack;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface StockCountIssueTrackManager{

	public StockCountIssueTrack createStockCountIssueTrack(RetailScmUserContext userContext, String title, Date countTime, String summary, String stockCountId
) throws Exception;	
	public StockCountIssueTrack updateStockCountIssueTrack(RetailScmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public StockCountIssueTrack transferToAnotherStockCount(RetailScmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String stockCountIssueTrackId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


