
package com.skynet.retailscm.retailstorememberaddress;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;



import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;




public class RetailStoreMemberAddressManagerImpl extends RetailScmCheckerManager implements RetailStoreMemberAddressManager {
	
	private static final String SERVICE_TYPE = "RetailStoreMemberAddress";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreMemberAddressDAO  retailStoreMemberAddressDAO;
 	public void setRetailStoreMemberAddressDAO(RetailStoreMemberAddressDAO  retailStoreMemberAddressDAO){
 	
 		if(retailStoreMemberAddressDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberAddressDAO to null.");
 		}
	 	this.retailStoreMemberAddressDAO = retailStoreMemberAddressDAO;
 	}
 	public RetailStoreMemberAddressDAO getRetailStoreMemberAddressDAO(){
 		if(this.retailStoreMemberAddressDAO == null){
 			throw new IllegalStateException("The RetailStoreMemberAddressDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberAddressDAO;
 	}
 	
 	protected RetailStoreMemberAddress saveRetailStoreMemberAddress(RetailScmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreMemberAddressDAO().save(retailStoreMemberAddress, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, tokens);
 	}
 	
 	protected RetailStoreMemberAddress saveRetailStoreMemberAddressDetail(RetailScmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress) throws Exception{	

 		
 		return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, allTokens());
 	}
 	
 	public RetailStoreMemberAddress loadRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberAddressId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreMemberAddressManagerException exception = new RetailStoreMemberAddressManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreMemberAddress retailStoreMemberAddress = loadRetailStoreMemberAddress( userContext, retailStoreMemberAddressId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberAddress, tokens);
 	}
 	
 	protected RetailStoreMemberAddress present(RetailScmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreMemberAddress,tokens);
		
		
		return this.getRetailStoreMemberAddressDAO().present(retailStoreMemberAddress, tokens);
	}
 
 	
 	
 	public RetailStoreMemberAddress loadRetailStoreMemberAddressDetail(RetailScmUserContext userContext, String retailStoreMemberAddressId) throws Exception{	
 		RetailStoreMemberAddressManagerException exception = new RetailStoreMemberAddressManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberAddress retailStoreMemberAddress = loadRetailStoreMemberAddress( userContext, retailStoreMemberAddressId, allTokens());

 		return present(userContext,retailStoreMemberAddress, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreMemberAddressId) throws Exception{	
 		RetailStoreMemberAddressManagerException exception = new RetailStoreMemberAddressManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreMemberAddress retailStoreMemberAddress = loadRetailStoreMemberAddress( userContext, retailStoreMemberAddressId, allTokens());

 		return present(userContext,retailStoreMemberAddress, allTokens());
		
 	}
 	protected RetailStoreMemberAddress saveRetailStoreMemberAddress(RetailScmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberAddressDAO().save(retailStoreMemberAddress, tokens);
 	}
 	protected RetailStoreMemberAddress loadRetailStoreMemberAddress(RetailScmUserContext userContext, String retailStoreMemberAddressId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreMemberAddressDAO().load(retailStoreMemberAddressId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	//------------------------------------
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberAddress, tokens);
		
		addAction(userContext, retailStoreMemberAddress, tokens,"@create","createRetailStoreMemberAddress","createRetailStoreMemberAddress/","main","primary");
		addAction(userContext, retailStoreMemberAddress, tokens,"@update","updateRetailStoreMemberAddress","updateRetailStoreMemberAddress/"+retailStoreMemberAddress.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberAddress, tokens,"@copy","cloneRetailStoreMemberAddress","cloneRetailStoreMemberAddress/"+retailStoreMemberAddress.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreMemberAddress, tokens,"retail_store_member_address.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberAddress.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreMemberAddress createRetailStoreMemberAddress(RetailScmUserContext userContext,String name, String ownerId, String mobilePhone, String address
) throws Exception
	{
		
		RetailStoreMemberAddressManagerException exception = new RetailStoreMemberAddressManagerException("Error Occured");

		

		checkNameOfRetailStoreMemberAddress(userContext,  name, exception);
		checkMobilePhoneOfRetailStoreMemberAddress(userContext,  mobilePhone, exception);
		checkAddressOfRetailStoreMemberAddress(userContext,  address, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreMemberAddress retailStoreMemberAddress=createNewRetailStoreMemberAddress();	

		retailStoreMemberAddress.setName(name);
		RetailStoreMember owner = loadRetailStoreMember(ownerId,emptyOptions());
		retailStoreMemberAddress.setOwner(owner);
		retailStoreMemberAddress.setMobilePhone(mobilePhone);
		retailStoreMemberAddress.setAddress(address);

		return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, emptyOptions());
		

		
	}
	protected RetailStoreMemberAddress createNewRetailStoreMemberAddress() 
	{
		
		return new RetailStoreMemberAddress();		
	}
	
	protected void checkParamsForUpdatingRetailStoreMemberAddress(RetailScmUserContext userContext,String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreMemberAddressManagerException exception = new RetailStoreMemberAddressManagerException("Error Occured");
		
		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, exception);
		checkVersionOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressVersion, exception);
		

		if(RetailStoreMemberAddress.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreMemberAddress(userContext, parseString(newValueExpr), exception);
		}		

		
		if(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY.equals(property)){
			checkMobilePhoneOfRetailStoreMemberAddress(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreMemberAddress.ADDRESS_PROPERTY.equals(property)){
			checkAddressOfRetailStoreMemberAddress(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreMemberAddress clone(RetailScmUserContext userContext, String fromRetailStoreMemberAddressId) throws Exception{
		
		return this.getRetailStoreMemberAddressDAO().clone(fromRetailStoreMemberAddressId, this.allTokens());
	}
	
	public RetailStoreMemberAddress updateRetailStoreMemberAddress(RetailScmUserContext userContext,String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, retailStoreMemberAddressVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreMemberAddress retailStoreMemberAddress = loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, allTokens());
		if(retailStoreMemberAddress.getVersion() != retailStoreMemberAddressVersion){
			String message = "The target version("+retailStoreMemberAddress.getVersion()+") is not equals to version("+retailStoreMemberAddressVersion+") provided";
			throw new RetailStoreMemberAddressManagerException(message);
		}
		synchronized(retailStoreMemberAddress){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberAddress.
			
			retailStoreMemberAddress.changePropery(property, newValueExpr);
			retailStoreMemberAddress = saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, tokens().done());
			return present(userContext,retailStoreMemberAddress, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreMemberAddressTokens tokens(){
		return RetailStoreMemberAddressTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberAddressTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberAddressTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberAddressId, String anotherOwnerId) throws Exception
 	{
 		RetailStoreMemberAddressManagerException exception = new RetailStoreMemberAddressManagerException("Error Occured");
 		checkIdOfRetailStoreMemberAddress(userContext, retailStoreMemberAddressId,exception);
 		checkIdOfRetailStoreMember(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public RetailStoreMemberAddress transferToAnotherOwner(RetailScmUserContext userContext, String retailStoreMemberAddressId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberAddressId,anotherOwnerId);
 
		RetailStoreMemberAddress retailStoreMemberAddress = loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, allTokens());	
		synchronized(retailStoreMemberAddress){
			//will be good when the retailStoreMemberAddress loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(anotherOwnerId, emptyOptions());		
			retailStoreMemberAddress.setOwner(owner);		
			retailStoreMemberAddress = saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, emptyOptions());
			
			return present(userContext,retailStoreMemberAddress, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreMemberAddressId, retailStoreMemberAddressVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreMemberAddressId, int retailStoreMemberAddressVersion) throws Exception{
		getRetailStoreMemberAddressDAO().delete(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberAddressManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreMemberAddressDAO().deleteAll();
	}


}


