
package com.skynet.retailscm.consumerorderprocessing;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderProcessingManager{

	public ConsumerOrderProcessing createConsumerOrderProcessing(RetailScmUserContext userContext, String who, Date processTime
) throws Exception;	
	public ConsumerOrderProcessing updateConsumerOrderProcessing(RetailScmUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String consumerOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


