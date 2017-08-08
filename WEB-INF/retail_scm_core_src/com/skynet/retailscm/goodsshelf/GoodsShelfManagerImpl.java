
package com.skynet.retailscm.goodsshelf;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.skynet.retailscm.supplierspace.SupplierSpace;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;

import com.skynet.retailscm.supplierspace.SupplierSpaceDAO;
import com.skynet.retailscm.storagespace.StorageSpaceDAO;
import com.skynet.retailscm.damagespace.DamageSpaceDAO;

import com.skynet.retailscm.goodsshelf.GoodsShelf;


import com.skynet.retailscm.damagespace.DamageSpaceTable;
import com.skynet.retailscm.goodsallocation.GoodsAllocationTable;
import com.skynet.retailscm.storagespace.StorageSpaceTable;
import com.skynet.retailscm.supplierspace.SupplierSpaceTable;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCountTable;




public class GoodsShelfManagerImpl extends RetailScmCheckerManager implements GoodsShelfManager {
	
	private static final String SERVICE_TYPE = "GoodsShelf";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO  goodsShelfDAO){
 	
 		if(goodsShelfDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfDAO to null.");
 		}
	 	this.goodsShelfDAO = goodsShelfDAO;
 	}
 	public GoodsShelfDAO getGoodsShelfDAO(){
 		if(this.goodsShelfDAO == null){
 			throw new IllegalStateException("The GoodsShelfDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsShelfDAO;
 	}
 	
 	protected GoodsShelf saveGoodsShelf(RetailScmUserContext userContext, GoodsShelf goodsShelf, String [] tokensExpr) throws Exception{	
 		//return getGoodsShelfDAO().save(goodsShelf, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsShelf(userContext, goodsShelf, tokens);
 	}
 	
 	protected GoodsShelf saveGoodsShelfDetail(RetailScmUserContext userContext, GoodsShelf goodsShelf) throws Exception{	

 		
 		return saveGoodsShelf(userContext, goodsShelf, allTokens());
 	}
 	
 	public GoodsShelf loadGoodsShelf(RetailScmUserContext userContext, String goodsShelfId, String [] tokensExpr) throws Exception{				
 
 		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsShelf goodsShelf = loadGoodsShelf( userContext, goodsShelfId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsShelf, tokens);
 	}
 	
 	protected GoodsShelf present(RetailScmUserContext userContext, GoodsShelf goodsShelf, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsShelf,tokens);
		
		
		return this.getGoodsShelfDAO().present(goodsShelf, tokens);
	}
 
 	
 	
 	public GoodsShelf loadGoodsShelfDetail(RetailScmUserContext userContext, String goodsShelfId) throws Exception{	
 		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsShelf goodsShelf = loadGoodsShelf( userContext, goodsShelfId, allTokens());

 		return present(userContext,goodsShelf, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String goodsShelfId) throws Exception{	
 		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsShelf goodsShelf = loadGoodsShelf( userContext, goodsShelfId, allTokens());

 		return present(userContext,goodsShelf, allTokens());
		
 	}
 	protected GoodsShelf saveGoodsShelf(RetailScmUserContext userContext, GoodsShelf goodsShelf, Map<String,Object>tokens) throws Exception{	
 		return getGoodsShelfDAO().save(goodsShelf, tokens);
 	}
 	protected GoodsShelf loadGoodsShelf(RetailScmUserContext userContext, String goodsShelfId, Map<String,Object>tokens) throws Exception{	
 		return getGoodsShelfDAO().load(goodsShelfId, tokens);
 	}

	



 	 
 	
 	private  DamageSpaceDAO  damageSpaceDAO;
 	public void setDamageSpaceDAO(DamageSpaceDAO damageSpaceDAO){
	 	this.damageSpaceDAO = damageSpaceDAO;
 	}
 	//------------------------------------
 	public DamageSpaceDAO getDamageSpaceDAO(){
	 	return this.damageSpaceDAO;
 	}
 
 	
 	private  StorageSpaceDAO  storageSpaceDAO;
 	public void setStorageSpaceDAO(StorageSpaceDAO storageSpaceDAO){
	 	this.storageSpaceDAO = storageSpaceDAO;
 	}
 	//------------------------------------
 	public StorageSpaceDAO getStorageSpaceDAO(){
	 	return this.storageSpaceDAO;
 	}
 
 	
 	private  SupplierSpaceDAO  supplierSpaceDAO;
 	public void setSupplierSpaceDAO(SupplierSpaceDAO supplierSpaceDAO){
	 	this.supplierSpaceDAO = supplierSpaceDAO;
 	}
 	//------------------------------------
 	public SupplierSpaceDAO getSupplierSpaceDAO(){
	 	return this.supplierSpaceDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsShelf goodsShelf, Map<String, Object> tokens){
		super.addActions(userContext, goodsShelf, tokens);
		
		addAction(userContext, goodsShelf, tokens,"@create","createGoodsShelf","createGoodsShelf/","main","primary");
		addAction(userContext, goodsShelf, tokens,"@update","updateGoodsShelf","updateGoodsShelf/"+goodsShelf.getId()+"/","main","primary");
		addAction(userContext, goodsShelf, tokens,"@copy","cloneGoodsShelf","cloneGoodsShelf/"+goodsShelf.getId()+"/","main","primary");
		
		addAction(userContext, goodsShelf, tokens,"goods_shelf.transfer_to_storage_space","transferToAnotherStorageSpace","transferToAnotherStorageSpace/"+goodsShelf.getId()+"/","main","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.transfer_to_supplier_space","transferToAnotherSupplierSpace","transferToAnotherSupplierSpace/"+goodsShelf.getId()+"/","main","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.transfer_to_damage_space","transferToAnotherDamageSpace","transferToAnotherDamageSpace/"+goodsShelf.getId()+"/","main","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.addGoodsShelfStockCount","addGoodsShelfStockCount","addGoodsShelfStockCount/"+goodsShelf.getId()+"/","goodsShelfStockCountList","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.removeGoodsShelfStockCount","removeGoodsShelfStockCount","removeGoodsShelfStockCount/"+goodsShelf.getId()+"/","goodsShelfStockCountList","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.updateGoodsShelfStockCount","updateGoodsShelfStockCount","updateGoodsShelfStockCount/"+goodsShelf.getId()+"/","goodsShelfStockCountList","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.copyGoodsShelfStockCountFrom","copyGoodsShelfStockCountFrom","copyGoodsShelfStockCountFrom/"+goodsShelf.getId()+"/","goodsShelfStockCountList","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.addGoodsAllocation","addGoodsAllocation","addGoodsAllocation/"+goodsShelf.getId()+"/","goodsAllocationList","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.removeGoodsAllocation","removeGoodsAllocation","removeGoodsAllocation/"+goodsShelf.getId()+"/","goodsAllocationList","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.updateGoodsAllocation","updateGoodsAllocation","updateGoodsAllocation/"+goodsShelf.getId()+"/","goodsAllocationList","primary");
		addAction(userContext, goodsShelf, tokens,"goods_shelf.copyGoodsAllocationFrom","copyGoodsAllocationFrom","copyGoodsAllocationFrom/"+goodsShelf.getId()+"/","goodsAllocationList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsShelf goodsShelf, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsShelf createGoodsShelf(RetailScmUserContext userContext,String location, String storageSpaceId, String supplierSpaceId, String damageSpaceId
) throws Exception
	{
		
		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");

		

		checkLocationOfGoodsShelf(userContext,  location, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		GoodsShelf goodsShelf=createNewGoodsShelf();	

		goodsShelf.setLocation(location);
		StorageSpace storageSpace = loadStorageSpace(storageSpaceId,emptyOptions());
		goodsShelf.setStorageSpace(storageSpace);
		SupplierSpace supplierSpace = loadSupplierSpace(supplierSpaceId,emptyOptions());
		goodsShelf.setSupplierSpace(supplierSpace);
		DamageSpace damageSpace = loadDamageSpace(damageSpaceId,emptyOptions());
		goodsShelf.setDamageSpace(damageSpace);

		return saveGoodsShelf(userContext, goodsShelf, emptyOptions());
		

		
	}
	protected GoodsShelf createNewGoodsShelf() 
	{
		
		return new GoodsShelf();		
	}
	
	protected void checkParamsForUpdatingGoodsShelf(RetailScmUserContext userContext,String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkVersionOfGoodsShelf(userContext, goodsShelfVersion, exception);
		

		if(GoodsShelf.LOCATION_PROPERTY.equals(property)){
			checkLocationOfGoodsShelf(userContext, parseString(newValueExpr), exception);
		}		

				

				

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public GoodsShelf clone(RetailScmUserContext userContext, String fromGoodsShelfId) throws Exception{
		
		return this.getGoodsShelfDAO().clone(fromGoodsShelfId, this.allTokens());
	}
	
	public GoodsShelf updateGoodsShelf(RetailScmUserContext userContext,String goodsShelfId, int goodsShelfVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsShelf(userContext, goodsShelfId, goodsShelfVersion, property, newValueExpr, tokensExpr);
		
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		if(goodsShelf.getVersion() != goodsShelfVersion){
			String message = "The target version("+goodsShelf.getVersion()+") is not equals to version("+goodsShelfVersion+") provided";
			throw new GoodsShelfManagerException(message);
		}
		synchronized(goodsShelf){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsShelf.
			
			goodsShelf.changePropery(property, newValueExpr);
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
			//return saveGoodsShelf(userContext, goodsShelf, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsShelfTokens tokens(){
		return GoodsShelfTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsShelfTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsShelfTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherStorageSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherStorageSpaceId) throws Exception
 	{
 		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
 		checkIdOfGoodsShelf(userContext, goodsShelfId,exception);
 		checkIdOfStorageSpace(userContext, anotherStorageSpaceId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public GoodsShelf transferToAnotherStorageSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherStorageSpaceId) throws Exception
 	{
 		checkParamsForTransferingAnotherStorageSpace(userContext, goodsShelfId,anotherStorageSpaceId);
 
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());	
		synchronized(goodsShelf){
			//will be good when the goodsShelf loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			StorageSpace storageSpace = loadStorageSpace(anotherStorageSpaceId, emptyOptions());		
			goodsShelf.setStorageSpace(storageSpace);		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, emptyOptions());
			
			return present(userContext,goodsShelf, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherSupplierSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherSupplierSpaceId) throws Exception
 	{
 		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
 		checkIdOfGoodsShelf(userContext, goodsShelfId,exception);
 		checkIdOfSupplierSpace(userContext, anotherSupplierSpaceId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public GoodsShelf transferToAnotherSupplierSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherSupplierSpaceId) throws Exception
 	{
 		checkParamsForTransferingAnotherSupplierSpace(userContext, goodsShelfId,anotherSupplierSpaceId);
 
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());	
		synchronized(goodsShelf){
			//will be good when the goodsShelf loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplierSpace supplierSpace = loadSupplierSpace(anotherSupplierSpaceId, emptyOptions());		
			goodsShelf.setSupplierSpace(supplierSpace);		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, emptyOptions());
			
			return present(userContext,goodsShelf, allTokens());
			
		}

 	}

 	
 	protected void checkParamsForTransferingAnotherDamageSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherDamageSpaceId) throws Exception
 	{
 		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
 		checkIdOfGoodsShelf(userContext, goodsShelfId,exception);
 		checkIdOfDamageSpace(userContext, anotherDamageSpaceId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public GoodsShelf transferToAnotherDamageSpace(RetailScmUserContext userContext, String goodsShelfId, String anotherDamageSpaceId) throws Exception
 	{
 		checkParamsForTransferingAnotherDamageSpace(userContext, goodsShelfId,anotherDamageSpaceId);
 
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());	
		synchronized(goodsShelf){
			//will be good when the goodsShelf loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			DamageSpace damageSpace = loadDamageSpace(anotherDamageSpaceId, emptyOptions());		
			goodsShelf.setDamageSpace(damageSpace);		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, emptyOptions());
			
			return present(userContext,goodsShelf, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected DamageSpace loadDamageSpace(String newDamageSpaceId, Map<String,Object> options) throws Exception
 	{
		
 		return getDamageSpaceDAO().load(newDamageSpaceId, options);
 	}
	
	 	
 	protected StorageSpace loadStorageSpace(String newStorageSpaceId, Map<String,Object> options) throws Exception
 	{
		
 		return getStorageSpaceDAO().load(newStorageSpaceId, options);
 	}
	
	 	
 	protected SupplierSpace loadSupplierSpace(String newSupplierSpaceId, Map<String,Object> options) throws Exception
 	{
		
 		return getSupplierSpaceDAO().load(newSupplierSpaceId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String goodsShelfId, int goodsShelfVersion) throws Exception {
		
		deleteInternal(userContext, goodsShelfId, goodsShelfVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String goodsShelfId, int goodsShelfVersion) throws Exception{
		getGoodsShelfDAO().delete(goodsShelfId, goodsShelfVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsShelfManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getGoodsShelfDAO().deleteAll();
	}

	protected void checkParamsForAddingGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, String title, Date countTime, String summary,String [] tokensExpr) throws Exception{
		
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);

		checkTitleOfGoodsShelfStockCount(userContext,  title, exception);
		checkCountTimeOfGoodsShelfStockCount(userContext,  countTime, exception);
		checkSummaryOfGoodsShelfStockCount(userContext,  summary, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsShelf addGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, String title, Date countTime, String summary, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsShelfStockCount(userContext,goodsShelfId,title, countTime, summary,tokensExpr);
		
		GoodsShelfStockCount goodsShelfStockCount = createGoodsShelfStockCount(userContext,title, countTime, summary);
		
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelf.addGoodsShelfStockCount( goodsShelfStockCount );		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}
	}
	protected GoodsShelfStockCount createGoodsShelfStockCount(RetailScmUserContext userContext, String title, Date countTime, String summary) throws Exception{

		GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();
		
		
		goodsShelfStockCount.setTitle(title);		
		goodsShelfStockCount.setCountTime(countTime);		
		goodsShelfStockCount.setSummary(summary);
	
		
		return goodsShelfStockCount;
	
		
	}
	
	protected GoodsShelfStockCount createIndexedGoodsShelfStockCount(String id, int version){

		GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();
		goodsShelfStockCount.setId(id);
		goodsShelfStockCount.setVersion(version);
		return goodsShelfStockCount;			
		
	}
	protected void checkParamsForRemovingGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsShelfStockCountId, int goodsShelfStockCountVersion,String [] tokensExpr) throws Exception{
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		checkVersionOfGoodsShelfStockCount(userContext, goodsShelfStockCountVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsShelf removeGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsShelfStockCountId, int goodsShelfStockCountVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsShelfStockCount(userContext,goodsShelfId, goodsShelfStockCountId, goodsShelfStockCountVersion,tokensExpr);
		
		GoodsShelfStockCount goodsShelfStockCount = createIndexedGoodsShelfStockCount(goodsShelfStockCountId, goodsShelfStockCountVersion);
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelf.removeGoodsShelfStockCount( goodsShelfStockCount );		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsShelfStockCountId, int goodsShelfStockCountVersion,String [] tokensExpr) throws Exception{
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		checkVersionOfGoodsShelfStockCount(userContext, goodsShelfStockCountVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsShelf copyGoodsShelfStockCountFrom(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsShelfStockCountId, int goodsShelfStockCountVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsShelfStockCount(userContext,goodsShelfId, goodsShelfStockCountId, goodsShelfStockCountVersion,tokensExpr);
		
		GoodsShelfStockCount goodsShelfStockCount = createIndexedGoodsShelfStockCount(goodsShelfStockCountId, goodsShelfStockCountVersion);
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelf.copyGoodsShelfStockCountFrom( goodsShelfStockCount );		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		checkVersionOfGoodsShelfStockCount(userContext, goodsShelfStockCountVersion, exception);
		

		if(GoodsShelfStockCount.TITLE_PROPERTY.equals(property)){
			checkTitleOfGoodsShelfStockCount(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsShelfStockCount.COUNT_TIME_PROPERTY.equals(property)){
			checkCountTimeOfGoodsShelfStockCount(userContext, parseDate(newValueExpr), exception);
		}
		
		if(GoodsShelfStockCount.SUMMARY_PROPERTY.equals(property)){
			checkSummaryOfGoodsShelfStockCount(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  GoodsShelf updateGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfId, String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsShelfStockCount(userContext, goodsShelfId, goodsShelfStockCountId, goodsShelfStockCountVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsShelf.removeGoodsShelfStockCount( goodsShelfStockCount );	
			//make changes to AcceleraterAccount.
			GoodsShelfStockCount goodsShelfStockCountIndex = createIndexedGoodsShelfStockCount(goodsShelfStockCountId, goodsShelfStockCountVersion);
		
			GoodsShelfStockCount goodsShelfStockCount = goodsShelf.findTheGoodsShelfStockCount(goodsShelfStockCountIndex);
			if(goodsShelfStockCount == null){
				throw new GoodsShelfManagerException(goodsShelfStockCount+"Not found" );
			}
			
			goodsShelfStockCount.changePropery(property, newValueExpr);

			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsShelfStockCountList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, String location, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);

		checkLocationOfGoodsAllocation(userContext,  location, exception);
		checkLatitudeOfGoodsAllocation(userContext,  latitude, exception);
		checkLongitudeOfGoodsAllocation(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsShelf addGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, String location, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsAllocation(userContext,goodsShelfId,location, latitude, longitude,tokensExpr);
		
		GoodsAllocation goodsAllocation = createGoodsAllocation(userContext,location, latitude, longitude);
		
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelf.addGoodsAllocation( goodsAllocation );		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}
	}
	protected GoodsAllocation createGoodsAllocation(RetailScmUserContext userContext, String location, double latitude, double longitude) throws Exception{

		GoodsAllocation goodsAllocation = new GoodsAllocation();
		
		
		goodsAllocation.setLocation(location);		
		goodsAllocation.setLatitude(latitude);		
		goodsAllocation.setLongitude(longitude);
	
		
		return goodsAllocation;
	
		
	}
	
	protected GoodsAllocation createIndexedGoodsAllocation(String id, int version){

		GoodsAllocation goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(id);
		goodsAllocation.setVersion(version);
		return goodsAllocation;			
		
	}
	protected void checkParamsForRemovingGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsAllocationId, int goodsAllocationVersion,String [] tokensExpr) throws Exception{
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		checkVersionOfGoodsAllocation(userContext, goodsAllocationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsShelf removeGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsAllocationId, int goodsAllocationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsAllocation(userContext,goodsShelfId, goodsAllocationId, goodsAllocationVersion,tokensExpr);
		
		GoodsAllocation goodsAllocation = createIndexedGoodsAllocation(goodsAllocationId, goodsAllocationVersion);
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelf.removeGoodsAllocation( goodsAllocation );		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsAllocationId, int goodsAllocationVersion,String [] tokensExpr) throws Exception{
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		checkVersionOfGoodsAllocation(userContext, goodsAllocationVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsShelf copyGoodsAllocationFrom(RetailScmUserContext userContext, String goodsShelfId, 
		String goodsAllocationId, int goodsAllocationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsAllocation(userContext,goodsShelfId, goodsAllocationId, goodsAllocationVersion,tokensExpr);
		
		GoodsAllocation goodsAllocation = createIndexedGoodsAllocation(goodsAllocationId, goodsAllocationVersion);
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelf.copyGoodsAllocationFrom( goodsAllocation );		
			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsShelfManagerException exception = new GoodsShelfManagerException("Error Occured");
		
		checkIdOfGoodsShelf(userContext, goodsShelfId, exception);
		checkIdOfGoodsAllocation(userContext, goodsAllocationId, exception);
		checkVersionOfGoodsAllocation(userContext, goodsAllocationVersion, exception);
		

		if(GoodsAllocation.LOCATION_PROPERTY.equals(property)){
			checkLocationOfGoodsAllocation(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsAllocation.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfGoodsAllocation(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(GoodsAllocation.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfGoodsAllocation(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  GoodsShelf updateGoodsAllocation(RetailScmUserContext userContext, String goodsShelfId, String goodsAllocationId, int goodsAllocationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsAllocation(userContext, goodsShelfId, goodsAllocationId, goodsAllocationVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsShelf goodsShelf = loadGoodsShelf(userContext, goodsShelfId, allTokens());
		
		synchronized(goodsShelf){ 
			//Will be good when the goodsShelf loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsShelf.removeGoodsAllocation( goodsAllocation );	
			//make changes to AcceleraterAccount.
			GoodsAllocation goodsAllocationIndex = createIndexedGoodsAllocation(goodsAllocationId, goodsAllocationVersion);
		
			GoodsAllocation goodsAllocation = goodsShelf.findTheGoodsAllocation(goodsAllocationIndex);
			if(goodsAllocation == null){
				throw new GoodsShelfManagerException(goodsAllocation+"Not found" );
			}
			
			goodsAllocation.changePropery(property, newValueExpr);

			goodsShelf = saveGoodsShelf(userContext, goodsShelf, tokens().withGoodsAllocationList().done());
			return present(userContext,goodsShelf, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


