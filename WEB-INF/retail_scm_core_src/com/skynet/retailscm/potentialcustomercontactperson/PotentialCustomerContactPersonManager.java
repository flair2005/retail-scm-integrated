
package com.skynet.retailscm.potentialcustomercontactperson;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface PotentialCustomerContactPersonManager{

	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(RetailScmUserContext userContext, String name, String mobile, String potentialCustomerId, String description
) throws Exception;	
	public PotentialCustomerContactPerson updatePotentialCustomerContactPerson(RetailScmUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public PotentialCustomerContactPerson transferToAnotherPotentialCustomer(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String potentialCustomerContactPersonId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  PotentialCustomerContactPerson addPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson removePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson updatePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


