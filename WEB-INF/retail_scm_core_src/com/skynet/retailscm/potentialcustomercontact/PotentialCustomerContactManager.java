
package com.skynet.retailscm.potentialcustomercontact;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface PotentialCustomerContactManager{

	public PotentialCustomerContact createPotentialCustomerContact(RetailScmUserContext userContext, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String contactToId, String description
) throws Exception;	
	public PotentialCustomerContact updatePotentialCustomerContact(RetailScmUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public PotentialCustomerContact transferToAnotherPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherCityPartner(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherContactTo(RetailScmUserContext userContext, String potentialCustomerContactId, String anotherContactToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String potentialCustomerContactId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


