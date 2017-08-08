
package com.skynet.retailscm.retailstorecityservicecenter;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreCityServiceCenterManager{

	public RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(RetailScmUserContext userContext, String name, Date founded, String belongsToId
) throws Exception;	
	public RetailStoreCityServiceCenter updateRetailStoreCityServiceCenter(RetailScmUserContext userContext,String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreCityServiceCenter transferToAnotherBelongsTo(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreCityServiceCenter addCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removeCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityPartnerId, int cityPartnerVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updateCityPartner(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCityServiceCenter addPotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removePotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updatePotentialCustomer(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCityServiceCenter addCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removeCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityEventId, int cityEventVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updateCityEvent(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String cityEventId, int cityEventVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCityServiceCenter addRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String name, String telephone, String owner, String retailStoreCountryCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter removeRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCityServiceCenter updateRetailStore(RetailScmUserContext userContext, String retailStoreCityServiceCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


