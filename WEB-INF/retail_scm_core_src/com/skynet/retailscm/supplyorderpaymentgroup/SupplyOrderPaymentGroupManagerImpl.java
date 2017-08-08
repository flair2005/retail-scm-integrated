
package com.skynet.retailscm.supplyorderpaymentgroup;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.supplyorder.SupplyOrder;

import com.skynet.retailscm.supplyorder.SupplyOrderDAO;



import com.skynet.retailscm.supplyorder.SupplyOrderTable;




public class SupplyOrderPaymentGroupManagerImpl extends RetailScmCheckerManager implements SupplyOrderPaymentGroupManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderPaymentGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderPaymentGroupDAO  supplyOrderPaymentGroupDAO;
 	public void setSupplyOrderPaymentGroupDAO(SupplyOrderPaymentGroupDAO  supplyOrderPaymentGroupDAO){
 	
 		if(supplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderPaymentGroupDAO to null.");
 		}
	 	this.supplyOrderPaymentGroupDAO = supplyOrderPaymentGroupDAO;
 	}
 	public SupplyOrderPaymentGroupDAO getSupplyOrderPaymentGroupDAO(){
 		if(this.supplyOrderPaymentGroupDAO == null){
 			throw new IllegalStateException("The SupplyOrderPaymentGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderPaymentGroupDAO;
 	}
 	
 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(RetailScmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderPaymentGroupDAO().save(supplyOrderPaymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens);
 	}
 	
 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroupDetail(RetailScmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup) throws Exception{	

 		
 		return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, allTokens());
 	}
 	
 	public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderPaymentGroupId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderPaymentGroupManagerException exception = new SupplyOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderPaymentGroup, tokens);
 	}
 	
 	protected SupplyOrderPaymentGroup present(RetailScmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderPaymentGroup,tokens);
		
		
		return this.getSupplyOrderPaymentGroupDAO().present(supplyOrderPaymentGroup, tokens);
	}
 
 	
 	
 	public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroupDetail(RetailScmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{	
 		SupplyOrderPaymentGroupManagerException exception = new SupplyOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, allTokens());

 		return present(userContext,supplyOrderPaymentGroup, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{	
 		SupplyOrderPaymentGroupManagerException exception = new SupplyOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, allTokens());

 		return present(userContext,supplyOrderPaymentGroup, allTokens());
		
 	}
 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(RetailScmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderPaymentGroupDAO().save(supplyOrderPaymentGroup, tokens);
 	}
 	protected SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(RetailScmUserContext userContext, String supplyOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderPaymentGroupDAO().load(supplyOrderPaymentGroupId, tokens);
 	}

	



 	 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	//------------------------------------
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderPaymentGroup, tokens);
		
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@create","createSupplyOrderPaymentGroup","createSupplyOrderPaymentGroup/","main","primary");
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@update","updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup/"+supplyOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@copy","cloneSupplyOrderPaymentGroup","cloneSupplyOrderPaymentGroup/"+supplyOrderPaymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderPaymentGroup, tokens,"supply_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderPaymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(RetailScmUserContext userContext,String name, String bizOrderId, String cardNumber
) throws Exception
	{
		
		SupplyOrderPaymentGroupManagerException exception = new SupplyOrderPaymentGroupManagerException("Error Occured");

		

		checkNameOfSupplyOrderPaymentGroup(userContext,  name, exception);
		checkCardNumberOfSupplyOrderPaymentGroup(userContext,  cardNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderPaymentGroup supplyOrderPaymentGroup=createNewSupplyOrderPaymentGroup();	

		supplyOrderPaymentGroup.setName(name);
		SupplyOrder bizOrder = loadSupplyOrder(bizOrderId,emptyOptions());
		supplyOrderPaymentGroup.setBizOrder(bizOrder);
		supplyOrderPaymentGroup.setCardNumber(cardNumber);

		return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, emptyOptions());
		

		
	}
	protected SupplyOrderPaymentGroup createNewSupplyOrderPaymentGroup() 
	{
		
		return new SupplyOrderPaymentGroup();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderPaymentGroup(RetailScmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderPaymentGroupManagerException exception = new SupplyOrderPaymentGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, exception);
		checkVersionOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupVersion, exception);
		

		if(SupplyOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			checkNameOfSupplyOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}		

		
		if(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			checkCardNumberOfSupplyOrderPaymentGroup(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderPaymentGroup clone(RetailScmUserContext userContext, String fromSupplyOrderPaymentGroupId) throws Exception{
		
		return this.getSupplyOrderPaymentGroupDAO().clone(fromSupplyOrderPaymentGroupId, this.allTokens());
	}
	
	public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroup(RetailScmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());
		if(supplyOrderPaymentGroup.getVersion() != supplyOrderPaymentGroupVersion){
			String message = "The target version("+supplyOrderPaymentGroup.getVersion()+") is not equals to version("+supplyOrderPaymentGroupVersion+") provided";
			throw new SupplyOrderPaymentGroupManagerException(message);
		}
		synchronized(supplyOrderPaymentGroup){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPaymentGroup.
			
			supplyOrderPaymentGroup.changePropery(property, newValueExpr);
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
			return present(userContext,supplyOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderPaymentGroupTokens tokens(){
		return SupplyOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderPaymentGroupTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderPaymentGroupTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		SupplyOrderPaymentGroupManagerException exception = new SupplyOrderPaymentGroupManagerException("Error Occured");
 		checkIdOfSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId,exception);
 		checkIdOfSupplyOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SupplyOrderPaymentGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderPaymentGroupId,anotherBizOrderId);
 
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());	
		synchronized(supplyOrderPaymentGroup){
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(anotherBizOrderId, emptyOptions());		
			supplyOrderPaymentGroup.setBizOrder(bizOrder);		
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, emptyOptions());
			
			return present(userContext,supplyOrderPaymentGroup, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected SupplyOrder loadSupplyOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception{
		getSupplyOrderPaymentGroupDAO().delete(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderPaymentGroupDAO().deleteAll();
	}


}


