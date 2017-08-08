
package com.skynet.retailscm.warehouseasset;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.warehouse.Warehouse;

import com.skynet.retailscm.warehouse.WarehouseDAO;



import com.skynet.retailscm.warehouse.WarehouseTable;




public class WarehouseAssetManagerImpl extends RetailScmCheckerManager implements WarehouseAssetManager {
	
	private static final String SERVICE_TYPE = "WarehouseAsset";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  WarehouseAssetDAO  warehouseAssetDAO;
 	public void setWarehouseAssetDAO(WarehouseAssetDAO  warehouseAssetDAO){
 	
 		if(warehouseAssetDAO == null){
 			throw new IllegalStateException("Do not try to set warehouseAssetDAO to null.");
 		}
	 	this.warehouseAssetDAO = warehouseAssetDAO;
 	}
 	public WarehouseAssetDAO getWarehouseAssetDAO(){
 		if(this.warehouseAssetDAO == null){
 			throw new IllegalStateException("The WarehouseAssetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.warehouseAssetDAO;
 	}
 	
 	protected WarehouseAsset saveWarehouseAsset(RetailScmUserContext userContext, WarehouseAsset warehouseAsset, String [] tokensExpr) throws Exception{	
 		//return getWarehouseAssetDAO().save(warehouseAsset, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWarehouseAsset(userContext, warehouseAsset, tokens);
 	}
 	
 	protected WarehouseAsset saveWarehouseAssetDetail(RetailScmUserContext userContext, WarehouseAsset warehouseAsset) throws Exception{	

 		
 		return saveWarehouseAsset(userContext, warehouseAsset, allTokens());
 	}
 	
 	public WarehouseAsset loadWarehouseAsset(RetailScmUserContext userContext, String warehouseAssetId, String [] tokensExpr) throws Exception{				
 
 		WarehouseAssetManagerException exception = new WarehouseAssetManagerException("Error Occured");
		
		checkIdOfWarehouseAsset(userContext, warehouseAssetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,warehouseAsset, tokens);
 	}
 	
 	protected WarehouseAsset present(RetailScmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,warehouseAsset,tokens);
		
		
		return this.getWarehouseAssetDAO().present(warehouseAsset, tokens);
	}
 
 	
 	
 	public WarehouseAsset loadWarehouseAssetDetail(RetailScmUserContext userContext, String warehouseAssetId) throws Exception{	
 		WarehouseAssetManagerException exception = new WarehouseAssetManagerException("Error Occured");
		
		checkIdOfWarehouseAsset(userContext, warehouseAssetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, allTokens());

 		return present(userContext,warehouseAsset, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String warehouseAssetId) throws Exception{	
 		WarehouseAssetManagerException exception = new WarehouseAssetManagerException("Error Occured");
		
		checkIdOfWarehouseAsset(userContext, warehouseAssetId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		WarehouseAsset warehouseAsset = loadWarehouseAsset( userContext, warehouseAssetId, allTokens());

 		return present(userContext,warehouseAsset, allTokens());
		
 	}
 	protected WarehouseAsset saveWarehouseAsset(RetailScmUserContext userContext, WarehouseAsset warehouseAsset, Map<String,Object>tokens) throws Exception{	
 		return getWarehouseAssetDAO().save(warehouseAsset, tokens);
 	}
 	protected WarehouseAsset loadWarehouseAsset(RetailScmUserContext userContext, String warehouseAssetId, Map<String,Object>tokens) throws Exception{	
 		return getWarehouseAssetDAO().load(warehouseAssetId, tokens);
 	}

	



 	 
 	
 	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO warehouseDAO){
	 	this.warehouseDAO = warehouseDAO;
 	}
 	//------------------------------------
 	public WarehouseDAO getWarehouseDAO(){
	 	return this.warehouseDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens){
		super.addActions(userContext, warehouseAsset, tokens);
		
		addAction(userContext, warehouseAsset, tokens,"@create","createWarehouseAsset","createWarehouseAsset/","main","primary");
		addAction(userContext, warehouseAsset, tokens,"@update","updateWarehouseAsset","updateWarehouseAsset/"+warehouseAsset.getId()+"/","main","primary");
		addAction(userContext, warehouseAsset, tokens,"@copy","cloneWarehouseAsset","cloneWarehouseAsset/"+warehouseAsset.getId()+"/","main","primary");
		
		addAction(userContext, warehouseAsset, tokens,"warehouse_asset.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+warehouseAsset.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, WarehouseAsset warehouseAsset, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public WarehouseAsset createWarehouseAsset(RetailScmUserContext userContext,String name, String position, String ownerId
) throws Exception
	{
		
		WarehouseAssetManagerException exception = new WarehouseAssetManagerException("Error Occured");

		

		checkNameOfWarehouseAsset(userContext,  name, exception);
		checkPositionOfWarehouseAsset(userContext,  position, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		WarehouseAsset warehouseAsset=createNewWarehouseAsset();	

		warehouseAsset.setName(name);
		warehouseAsset.setPosition(position);
		Warehouse owner = loadWarehouse(ownerId,emptyOptions());
		warehouseAsset.setOwner(owner);

		return saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());
		

		
	}
	protected WarehouseAsset createNewWarehouseAsset() 
	{
		
		return new WarehouseAsset();		
	}
	
	protected void checkParamsForUpdatingWarehouseAsset(RetailScmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		WarehouseAssetManagerException exception = new WarehouseAssetManagerException("Error Occured");
		
		checkIdOfWarehouseAsset(userContext, warehouseAssetId, exception);
		checkVersionOfWarehouseAsset(userContext, warehouseAssetVersion, exception);
		

		if(WarehouseAsset.NAME_PROPERTY.equals(property)){
			checkNameOfWarehouseAsset(userContext, parseString(newValueExpr), exception);
		}
		if(WarehouseAsset.POSITION_PROPERTY.equals(property)){
			checkPositionOfWarehouseAsset(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public WarehouseAsset clone(RetailScmUserContext userContext, String fromWarehouseAssetId) throws Exception{
		
		return this.getWarehouseAssetDAO().clone(fromWarehouseAssetId, this.allTokens());
	}
	
	public WarehouseAsset updateWarehouseAsset(RetailScmUserContext userContext,String warehouseAssetId, int warehouseAssetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWarehouseAsset(userContext, warehouseAssetId, warehouseAssetVersion, property, newValueExpr, tokensExpr);
		
		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());
		if(warehouseAsset.getVersion() != warehouseAssetVersion){
			String message = "The target version("+warehouseAsset.getVersion()+") is not equals to version("+warehouseAssetVersion+") provided";
			throw new WarehouseAssetManagerException(message);
		}
		synchronized(warehouseAsset){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WarehouseAsset.
			
			warehouseAsset.changePropery(property, newValueExpr);
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
			return present(userContext,warehouseAsset, mergedAllTokens(tokensExpr));
			//return saveWarehouseAsset(userContext, warehouseAsset, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected WarehouseAssetTokens tokens(){
		return WarehouseAssetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WarehouseAssetTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WarehouseAssetTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String warehouseAssetId, String anotherOwnerId) throws Exception
 	{
 		WarehouseAssetManagerException exception = new WarehouseAssetManagerException("Error Occured");
 		checkIdOfWarehouseAsset(userContext, warehouseAssetId,exception);
 		checkIdOfWarehouse(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public WarehouseAsset transferToAnotherOwner(RetailScmUserContext userContext, String warehouseAssetId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, warehouseAssetId,anotherOwnerId);
 
		WarehouseAsset warehouseAsset = loadWarehouseAsset(userContext, warehouseAssetId, allTokens());	
		synchronized(warehouseAsset){
			//will be good when the warehouseAsset loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Warehouse owner = loadWarehouse(anotherOwnerId, emptyOptions());		
			warehouseAsset.setOwner(owner);		
			warehouseAsset = saveWarehouseAsset(userContext, warehouseAsset, emptyOptions());
			
			return present(userContext,warehouseAsset, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Warehouse loadWarehouse(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getWarehouseDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String warehouseAssetId, int warehouseAssetVersion) throws Exception {
		
		deleteInternal(userContext, warehouseAssetId, warehouseAssetVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String warehouseAssetId, int warehouseAssetVersion) throws Exception{
		getWarehouseAssetDAO().delete(warehouseAssetId, warehouseAssetVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WarehouseAssetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getWarehouseAssetDAO().deleteAll();
	}


}


