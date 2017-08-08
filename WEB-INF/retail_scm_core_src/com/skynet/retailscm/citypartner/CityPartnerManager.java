
package com.skynet.retailscm.citypartner;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface CityPartnerManager{

	public CityPartner createCityPartner(RetailScmUserContext userContext, String name, String mobile, String cityServiceCenterId, String description
) throws Exception;	
	public CityPartner updateCityPartner(RetailScmUserContext userContext,String cityPartnerId, int cityPartnerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public CityPartner transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String cityPartnerId, String anotherCityServiceCenterId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String cityPartnerId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  CityPartner addPotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, String name, String mobile, String cityServiceCenterId, String description ,String [] tokensExpr)  throws Exception;
	public  CityPartner removePotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion,String [] tokensExpr)  throws Exception;
	public  CityPartner updatePotentialCustomer(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  CityPartner addPotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String contactToId, String description ,String [] tokensExpr)  throws Exception;
	public  CityPartner removePotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  CityPartner updatePotentialCustomerContact(RetailScmUserContext userContext, String cityPartnerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


