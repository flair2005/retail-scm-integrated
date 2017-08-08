
package com.skynet.retailscm.potentialcustomer;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface PotentialCustomerManager{

	public PotentialCustomer createPotentialCustomer(RetailScmUserContext userContext, String name, String mobile, String cityServiceCenterId, String cityPartnerId, String description
) throws Exception;	
	public PotentialCustomer updatePotentialCustomer(RetailScmUserContext userContext,String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public PotentialCustomer transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String potentialCustomerId, String anotherCityServiceCenterId)  throws Exception;
 	public PotentialCustomer transferToAnotherCityPartner(RetailScmUserContext userContext, String potentialCustomerId, String anotherCityPartnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String potentialCustomerId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  PotentialCustomer addPotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContactPerson(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addPotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description ,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContact(RetailScmUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description ,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removeEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updateEventAttendance(RetailScmUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


