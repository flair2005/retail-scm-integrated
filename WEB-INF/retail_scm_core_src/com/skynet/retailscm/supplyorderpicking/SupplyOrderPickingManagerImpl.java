
package com.skynet.retailscm.supplyorderpicking;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.supplyorder.SupplyOrder;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


import com.skynet.retailscm.supplyorder.SupplyOrderTable;




public class SupplyOrderPickingManagerImpl extends RetailScmCheckerManager implements SupplyOrderPickingManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderPicking";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  SupplyOrderPickingDAO  supplyOrderPickingDAO;
 	public void setSupplyOrderPickingDAO(SupplyOrderPickingDAO  supplyOrderPickingDAO){
 	
 		if(supplyOrderPickingDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderPickingDAO to null.");
 		}
	 	this.supplyOrderPickingDAO = supplyOrderPickingDAO;
 	}
 	public SupplyOrderPickingDAO getSupplyOrderPickingDAO(){
 		if(this.supplyOrderPickingDAO == null){
 			throw new IllegalStateException("The SupplyOrderPickingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderPickingDAO;
 	}
 	
 	protected SupplyOrderPicking saveSupplyOrderPicking(RetailScmUserContext userContext, SupplyOrderPicking supplyOrderPicking, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderPickingDAO().save(supplyOrderPicking, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderPicking(userContext, supplyOrderPicking, tokens);
 	}
 	
 	protected SupplyOrderPicking saveSupplyOrderPickingDetail(RetailScmUserContext userContext, SupplyOrderPicking supplyOrderPicking) throws Exception{	

 		
 		return saveSupplyOrderPicking(userContext, supplyOrderPicking, allTokens());
 	}
 	
 	public SupplyOrderPicking loadSupplyOrderPicking(RetailScmUserContext userContext, String supplyOrderPickingId, String [] tokensExpr) throws Exception{				
 
 		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking( userContext, supplyOrderPickingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderPicking, tokens);
 	}
 	
 	protected SupplyOrderPicking present(RetailScmUserContext userContext, SupplyOrderPicking supplyOrderPicking, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderPicking,tokens);
		
		
		return this.getSupplyOrderPickingDAO().present(supplyOrderPicking, tokens);
	}
 
 	
 	
 	public SupplyOrderPicking loadSupplyOrderPickingDetail(RetailScmUserContext userContext, String supplyOrderPickingId) throws Exception{	
 		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking( userContext, supplyOrderPickingId, allTokens());

 		return present(userContext,supplyOrderPicking, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String supplyOrderPickingId) throws Exception{	
 		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking( userContext, supplyOrderPickingId, allTokens());

 		return present(userContext,supplyOrderPicking, allTokens());
		
 	}
 	protected SupplyOrderPicking saveSupplyOrderPicking(RetailScmUserContext userContext, SupplyOrderPicking supplyOrderPicking, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderPickingDAO().save(supplyOrderPicking, tokens);
 	}
 	protected SupplyOrderPicking loadSupplyOrderPicking(RetailScmUserContext userContext, String supplyOrderPickingId, Map<String,Object>tokens) throws Exception{	
 		return getSupplyOrderPickingDAO().load(supplyOrderPickingId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderPicking supplyOrderPicking, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderPicking, tokens);
		
		addAction(userContext, supplyOrderPicking, tokens,"@create","createSupplyOrderPicking","createSupplyOrderPicking/","main","primary");
		addAction(userContext, supplyOrderPicking, tokens,"@update","updateSupplyOrderPicking","updateSupplyOrderPicking/"+supplyOrderPicking.getId()+"/","main","primary");
		addAction(userContext, supplyOrderPicking, tokens,"@copy","cloneSupplyOrderPicking","cloneSupplyOrderPicking/"+supplyOrderPicking.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderPicking, tokens,"supply_order_picking.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+supplyOrderPicking.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderPicking, tokens,"supply_order_picking.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+supplyOrderPicking.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderPicking, tokens,"supply_order_picking.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+supplyOrderPicking.getId()+"/","supplyOrderList","primary");
		addAction(userContext, supplyOrderPicking, tokens,"supply_order_picking.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+supplyOrderPicking.getId()+"/","supplyOrderList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, SupplyOrderPicking supplyOrderPicking, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderPicking createSupplyOrderPicking(RetailScmUserContext userContext,String who, Date processTime
) throws Exception
	{
		
		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");

		

		checkWhoOfSupplyOrderPicking(userContext,  who, exception);
		checkProcessTimeOfSupplyOrderPicking(userContext,  processTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		SupplyOrderPicking supplyOrderPicking=createNewSupplyOrderPicking();	

		supplyOrderPicking.setWho(who);
		supplyOrderPicking.setProcessTime(processTime);

		return saveSupplyOrderPicking(userContext, supplyOrderPicking, emptyOptions());
		

		
	}
	protected SupplyOrderPicking createNewSupplyOrderPicking() 
	{
		
		return new SupplyOrderPicking();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderPicking(RetailScmUserContext userContext,String supplyOrderPickingId, int supplyOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		checkVersionOfSupplyOrderPicking(userContext, supplyOrderPickingVersion, exception);
		

		if(SupplyOrderPicking.WHO_PROPERTY.equals(property)){
			checkWhoOfSupplyOrderPicking(userContext, parseString(newValueExpr), exception);
		}
		if(SupplyOrderPicking.PROCESS_TIME_PROPERTY.equals(property)){
			checkProcessTimeOfSupplyOrderPicking(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public SupplyOrderPicking clone(RetailScmUserContext userContext, String fromSupplyOrderPickingId) throws Exception{
		
		return this.getSupplyOrderPickingDAO().clone(fromSupplyOrderPickingId, this.allTokens());
	}
	
	public SupplyOrderPicking updateSupplyOrderPicking(RetailScmUserContext userContext,String supplyOrderPickingId, int supplyOrderPickingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderPicking(userContext, supplyOrderPickingId, supplyOrderPickingVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking(userContext, supplyOrderPickingId, allTokens());
		if(supplyOrderPicking.getVersion() != supplyOrderPickingVersion){
			String message = "The target version("+supplyOrderPicking.getVersion()+") is not equals to version("+supplyOrderPickingVersion+") provided";
			throw new SupplyOrderPickingManagerException(message);
		}
		synchronized(supplyOrderPicking){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPicking.
			
			supplyOrderPicking.changePropery(property, newValueExpr);
			supplyOrderPicking = saveSupplyOrderPicking(userContext, supplyOrderPicking, tokens().done());
			return present(userContext,supplyOrderPicking, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderPicking(userContext, supplyOrderPicking, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderPickingTokens tokens(){
		return SupplyOrderPickingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderPickingTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderPickingTokens.mergeAll(tokens).done();
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
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String supplyOrderPickingId, int supplyOrderPickingVersion) throws Exception {
		
		deleteInternal(userContext, supplyOrderPickingId, supplyOrderPickingVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String supplyOrderPickingId, int supplyOrderPickingVersion) throws Exception{
		getSupplyOrderPickingDAO().delete(supplyOrderPickingId, supplyOrderPickingVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderPickingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getSupplyOrderPickingDAO().deleteAll();
	}

	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		
		
		checkIdOfRetailStoreCountryCenter(userContext,  buyerId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  sellerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  SupplyOrderPicking addSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, String buyerId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,supplyOrderPickingId,buyerId, sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,buyerId, sellerId, title, totalAmount);
		
		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking(userContext, supplyOrderPickingId, allTokens());
		synchronized(supplyOrderPicking){ 
			//Will be good when the supplyOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderPicking.addSupplyOrder( supplyOrder );		
			supplyOrderPicking = saveSupplyOrderPicking(userContext, supplyOrderPicking, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderPicking, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplyOrder createSupplyOrder(RetailScmUserContext userContext, String buyerId, String sellerId, String title, double totalAmount) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		RetailStoreCountryCenter  buyer = new RetailStoreCountryCenter();
		buyer.setId(buyerId);		
		supplyOrder.setBuyer(buyer);		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);
	
		
		return supplyOrder;
	
		
	}
	
	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;			
		
	}
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderPicking removeSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,supplyOrderPickingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking(userContext, supplyOrderPickingId, allTokens());
		synchronized(supplyOrderPicking){ 
			//Will be good when the supplyOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderPicking.removeSupplyOrder( supplyOrder );		
			supplyOrderPicking = saveSupplyOrderPicking(userContext, supplyOrderPicking, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderPicking, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  SupplyOrderPicking copySupplyOrderFrom(RetailScmUserContext userContext, String supplyOrderPickingId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,supplyOrderPickingId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking(userContext, supplyOrderPickingId, allTokens());
		synchronized(supplyOrderPicking){ 
			//Will be good when the supplyOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			supplyOrderPicking.copySupplyOrderFrom( supplyOrder );		
			supplyOrderPicking = saveSupplyOrderPicking(userContext, supplyOrderPicking, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderPicking, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		SupplyOrderPickingManagerException exception = new SupplyOrderPickingManagerException("Error Occured");
		
		checkIdOfSupplyOrderPicking(userContext, supplyOrderPickingId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfSupplyOrder(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkTotalAmountOfSupplyOrder(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  SupplyOrderPicking updateSupplyOrder(RetailScmUserContext userContext, String supplyOrderPickingId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, supplyOrderPickingId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		SupplyOrderPicking supplyOrderPicking = loadSupplyOrderPicking(userContext, supplyOrderPickingId, allTokens());
		
		synchronized(supplyOrderPicking){ 
			//Will be good when the supplyOrderPicking loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//supplyOrderPicking.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = supplyOrderPicking.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new SupplyOrderPickingManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			supplyOrderPicking = saveSupplyOrderPicking(userContext, supplyOrderPicking, tokens().withSupplyOrderList().done());
			return present(userContext,supplyOrderPicking, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


