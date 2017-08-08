
package com.skynet.retailscm.consumerordershipment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ConsumerOrderShipmentManager{

	public ConsumerOrderShipment createConsumerOrderShipment(RetailScmUserContext userContext, String who, Date shipTime
) throws Exception;	
	public ConsumerOrderShipment updateConsumerOrderShipment(RetailScmUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String consumerOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


