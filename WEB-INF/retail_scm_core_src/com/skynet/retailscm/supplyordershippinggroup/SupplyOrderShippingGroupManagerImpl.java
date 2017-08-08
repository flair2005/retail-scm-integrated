
package com.skynet.retailscm.supplyordershippinggroup;

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




public class SupplyOrderShippingGroupManagerImpl extends RetailScmCheckerManager implements SupplyOrderShippingGroupManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderShippingGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderShippingGroupDAO  supplyOrderShippingGroupDAO;
 	public void setSupplyOrderShippingGroupDAO(SupplyOrderShippingGroupDAO  supplyOrderShippingGroupDAO){
 	
 		if(supplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderShippingGroupDAO to null.");
 		}
	 	this.supplyOrderShippingGroupDAO = supplyOrderShippingGroupDAO;
 	}
 	public SupplyOrderShippingGroupDAO getSupplyOrderShippingGroupDAO(){
 		if(this.supplyOrderShippingGroupDAO == null){
 			throw new IllegalStateException("The SupplyOrderShippingGroupDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderShippingGroupDAO;
 	}
 	
 	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroup(RetailScmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderShippingGroupDAO().save(supplyOrderShippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens);
 	}
 	
 	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroupDetail(RetailScmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup) throws Exception{	

 		
 		return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, allTokens());
 	}
 	
 	public SupplyOrderShippingGroup loadSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderShippingGroupId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderShippingGroupManagerException exception = new SupplyOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup( userContext, supplyOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShippingGroup, tokens);
 	}
 	
 	protected SupplyOrderShippingGroup present(RetailScmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderShippingGroup,tokens);
		
		
		return this.getSupplyOrderShippingGroupDAO().present(supplyOrderShippingGroup, tokens);
	}
 
 	
 	
 	public SupplyOrderShippingGroup loadSupplyOrderShippingGroupDetail(RetailScmUserContext userContext, String supplyOrderShippingGroupId) throws Exception{	
 		SupplyOrderShippingGroupManagerException exception = new SupplyOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup( userContext, supplyOrderShippingGroupId, allTokens());

 		return present(userContext,supplyOrderShippingGroup, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderShippingGroupId) throws Exception{	
 		SupplyOrderShippingGroupManagerException exception = new SupplyOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup( userContext, supplyOrderShippingGroupId, allTokens());

 		return present(userContext,supplyOrderShippingGroup, allTokens());
		
 	}
 	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroup(RetailScmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderShippingGroupDAO().save(supplyOrderShippingGroup, tokens);
 	}
 	protected SupplyOrderShippingGroup loadSupplyOrderShippingGroup(RetailScmUserContext userContext, String supplyOrderShippingGroupId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderShippingGroupDAO().load(supplyOrderShippingGroupId, tokens);
 	}

	



 	 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	//------------------------------------
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderShippingGroup, tokens);
		
		addAction(userContext, supplyOrderShippingGroup, tokens,"@create","createSupplyOrderShippingGroup","createSupplyOrderShippingGroup/","main","primary");
		addAction(userContext, supplyOrderShippingGroup, tokens,"@update","updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup/"+supplyOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, supplyOrderShippingGroup, tokens,"@copy","cloneSupplyOrderShippingGroup","cloneSupplyOrderShippingGroup/"+supplyOrderShippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderShippingGroup, tokens,"supply_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderShippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderShippingGroup createSupplyOrderShippingGroup(RetailScmUserContext userContext,String name, String bizOrderId, double amount
) throws Exception
	{
		
		SupplyOrderShippingGroupManagerException exception = new SupplyOrderShippingGroupManagerException("Error Occured");

		

		checkNameOfSupplyOrderShippingGroup(userContext,  name, exception);
		checkAmountOfSupplyOrderShippingGroup(userContext,  amount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderShippingGroup supplyOrderShippingGroup=createNewSupplyOrderShippingGroup();	

		supplyOrderShippingGroup.setName(name);
		SupplyOrder bizOrder = loadSupplyOrder(bizOrderId,emptyOptions());
		supplyOrderShippingGroup.setBizOrder(bizOrder);
		supplyOrderShippingGroup.setAmount(amount);

		return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, emptyOptions());
		

		
	}
	protected SupplyOrderShippingGroup createNewSupplyOrderShippingGroup() 
	{
		
		return new SupplyOrderShippingGroup();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderShippingGroup(RetailScmUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderShippingGroupManagerException exception = new SupplyOrderShippingGroupManagerException("Error Occured");
		
		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, exception);
		checkVersionOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupVersion, exception);
		

		if(SupplyOrderShippingGroup.NAME_PROPERTY.equals(property)){
			checkNameOfSupplyOrderShippingGroup(userContext, parseString(newValueExpr), exception);
		}		

		
		if(SupplyOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			checkAmountOfSupplyOrderShippingGroup(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderShippingGroup clone(RetailScmUserContext userContext, String fromSupplyOrderShippingGroupId) throws Exception{
		
		return this.getSupplyOrderShippingGroupDAO().clone(fromSupplyOrderShippingGroupId, this.allTokens());
	}
	
	public SupplyOrderShippingGroup updateSupplyOrderShippingGroup(RetailScmUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, allTokens());
		if(supplyOrderShippingGroup.getVersion() != supplyOrderShippingGroupVersion){
			String message = "The target version("+supplyOrderShippingGroup.getVersion()+") is not equals to version("+supplyOrderShippingGroupVersion+") provided";
			throw new SupplyOrderShippingGroupManagerException(message);
		}
		synchronized(supplyOrderShippingGroup){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShippingGroup.
			
			supplyOrderShippingGroup.changePropery(property, newValueExpr);
			supplyOrderShippingGroup = saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens().done());
			return present(userContext,supplyOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderShippingGroupTokens tokens(){
		return SupplyOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderShippingGroupTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderShippingGroupTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		SupplyOrderShippingGroupManagerException exception = new SupplyOrderShippingGroupManagerException("Error Occured");
 		checkIdOfSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId,exception);
 		checkIdOfSupplyOrder(userContext, anotherBizOrderId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public SupplyOrderShippingGroup transferToAnotherBizOrder(RetailScmUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderShippingGroupId,anotherBizOrderId);
 
		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, allTokens());	
		synchronized(supplyOrderShippingGroup){
			//will be good when the supplyOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(anotherBizOrderId, emptyOptions());		
			supplyOrderShippingGroup.setBizOrder(bizOrder);		
			supplyOrderShippingGroup = saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, emptyOptions());
			
			return present(userContext,supplyOrderShippingGroup, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected SupplyOrder loadSupplyOrder(String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplyOrderDAO().load(newBizOrderId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion) throws Exception{
		getSupplyOrderShippingGroupDAO().delete(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderShippingGroupDAO().deleteAll();
	}


}


