
package com.skynet.retailscm.goodsshelfstockcount;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goodsshelf.GoodsShelf;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrack;

import com.skynet.retailscm.goodsshelf.GoodsShelfDAO;

import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;


import com.skynet.retailscm.goodsshelf.GoodsShelfTable;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrackTable;




public class GoodsShelfStockCountManagerImpl extends RetailScmCheckerManager implements GoodsShelfStockCountManager {
	
	private static final String SERVICE_TYPE = "GoodsShelfStockCount";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  GoodsShelfStockCountDAO  goodsShelfStockCountDAO;
 	public void setGoodsShelfStockCountDAO(GoodsShelfStockCountDAO  goodsShelfStockCountDAO){
 	
 		if(goodsShelfStockCountDAO == null){
 			throw new IllegalStateException("Do not try to set goodsShelfStockCountDAO to null.");
 		}
	 	this.goodsShelfStockCountDAO = goodsShelfStockCountDAO;
 	}
 	public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO(){
 		if(this.goodsShelfStockCountDAO == null){
 			throw new IllegalStateException("The GoodsShelfStockCountDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsShelfStockCountDAO;
 	}
 	
 	protected GoodsShelfStockCount saveGoodsShelfStockCount(RetailScmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, String [] tokensExpr) throws Exception{	
 		//return getGoodsShelfStockCountDAO().save(goodsShelfStockCount, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens);
 	}
 	
 	protected GoodsShelfStockCount saveGoodsShelfStockCountDetail(RetailScmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount) throws Exception{	

 		
 		return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, allTokens());
 	}
 	
 	public GoodsShelfStockCount loadGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfStockCountId, String [] tokensExpr) throws Exception{				
 
 		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsShelfStockCount, tokens);
 	}
 	
 	protected GoodsShelfStockCount present(RetailScmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsShelfStockCount,tokens);
		
		
		return this.getGoodsShelfStockCountDAO().present(goodsShelfStockCount, tokens);
	}
 
 	
 	
 	public GoodsShelfStockCount loadGoodsShelfStockCountDetail(RetailScmUserContext userContext, String goodsShelfStockCountId) throws Exception{	
 		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, allTokens());

 		return present(userContext,goodsShelfStockCount, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String goodsShelfStockCountId) throws Exception{	
 		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount( userContext, goodsShelfStockCountId, allTokens());

 		return present(userContext,goodsShelfStockCount, allTokens());
		
 	}
 	protected GoodsShelfStockCount saveGoodsShelfStockCount(RetailScmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String,Object>tokens) throws Exception{	
 		return getGoodsShelfStockCountDAO().save(goodsShelfStockCount, tokens);
 	}
 	protected GoodsShelfStockCount loadGoodsShelfStockCount(RetailScmUserContext userContext, String goodsShelfStockCountId, Map<String,Object>tokens) throws Exception{	
 		return getGoodsShelfStockCountDAO().load(goodsShelfStockCountId, tokens);
 	}

	



 	 
 	
 	private  GoodsShelfDAO  goodsShelfDAO;
 	public void setGoodsShelfDAO(GoodsShelfDAO goodsShelfDAO){
	 	this.goodsShelfDAO = goodsShelfDAO;
 	}
 	//------------------------------------
 	public GoodsShelfDAO getGoodsShelfDAO(){
	 	return this.goodsShelfDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens){
		super.addActions(userContext, goodsShelfStockCount, tokens);
		
		addAction(userContext, goodsShelfStockCount, tokens,"@create","createGoodsShelfStockCount","createGoodsShelfStockCount/","main","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"@update","updateGoodsShelfStockCount","updateGoodsShelfStockCount/"+goodsShelfStockCount.getId()+"/","main","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"@copy","cloneGoodsShelfStockCount","cloneGoodsShelfStockCount/"+goodsShelfStockCount.getId()+"/","main","primary");
		
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.transfer_to_shelf","transferToAnotherShelf","transferToAnotherShelf/"+goodsShelfStockCount.getId()+"/","main","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.addStockCountIssueTrack","addStockCountIssueTrack","addStockCountIssueTrack/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.removeStockCountIssueTrack","removeStockCountIssueTrack","removeStockCountIssueTrack/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.updateStockCountIssueTrack","updateStockCountIssueTrack","updateStockCountIssueTrack/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
		addAction(userContext, goodsShelfStockCount, tokens,"goods_shelf_stock_count.copyStockCountIssueTrackFrom","copyStockCountIssueTrackFrom","copyStockCountIssueTrackFrom/"+goodsShelfStockCount.getId()+"/","stockCountIssueTrackList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsShelfStockCount createGoodsShelfStockCount(RetailScmUserContext userContext,String title, Date countTime, String summary, String shelfId
) throws Exception
	{
		
		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");

		

		checkTitleOfGoodsShelfStockCount(userContext,  title, exception);
		checkCountTimeOfGoodsShelfStockCount(userContext,  countTime, exception);
		checkSummaryOfGoodsShelfStockCount(userContext,  summary, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		GoodsShelfStockCount goodsShelfStockCount=createNewGoodsShelfStockCount();	

		goodsShelfStockCount.setTitle(title);
		goodsShelfStockCount.setCountTime(countTime);
		goodsShelfStockCount.setSummary(summary);
		GoodsShelf shelf = loadGoodsShelf(shelfId,emptyOptions());
		goodsShelfStockCount.setShelf(shelf);

		return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, emptyOptions());
		

		
	}
	protected GoodsShelfStockCount createNewGoodsShelfStockCount() 
	{
		
		return new GoodsShelfStockCount();		
	}
	
	protected void checkParamsForUpdatingGoodsShelfStockCount(RetailScmUserContext userContext,String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
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
	
	
	
	public GoodsShelfStockCount clone(RetailScmUserContext userContext, String fromGoodsShelfStockCountId) throws Exception{
		
		return this.getGoodsShelfStockCountDAO().clone(fromGoodsShelfStockCountId, this.allTokens());
	}
	
	public GoodsShelfStockCount updateGoodsShelfStockCount(RetailScmUserContext userContext,String goodsShelfStockCountId, int goodsShelfStockCountVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsShelfStockCount(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion, property, newValueExpr, tokensExpr);
		
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		if(goodsShelfStockCount.getVersion() != goodsShelfStockCountVersion){
			String message = "The target version("+goodsShelfStockCount.getVersion()+") is not equals to version("+goodsShelfStockCountVersion+") provided";
			throw new GoodsShelfStockCountManagerException(message);
		}
		synchronized(goodsShelfStockCount){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsShelfStockCount.
			
			goodsShelfStockCount.changePropery(property, newValueExpr);
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
			//return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsShelfStockCountTokens tokens(){
		return GoodsShelfStockCountTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsShelfStockCountTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsShelfStockCountTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherShelf(RetailScmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId) throws Exception
 	{
 		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
 		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId,exception);
 		checkIdOfGoodsShelf(userContext, anotherShelfId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public GoodsShelfStockCount transferToAnotherShelf(RetailScmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId) throws Exception
 	{
 		checkParamsForTransferingAnotherShelf(userContext, goodsShelfStockCountId,anotherShelfId);
 
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());	
		synchronized(goodsShelfStockCount){
			//will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelf shelf = loadGoodsShelf(anotherShelfId, emptyOptions());		
			goodsShelfStockCount.setShelf(shelf);		
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, emptyOptions());
			
			return present(userContext,goodsShelfStockCount, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsShelf loadGoodsShelf(String newShelfId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsShelfDAO().load(newShelfId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception {
		
		deleteInternal(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String goodsShelfStockCountId, int goodsShelfStockCountVersion) throws Exception{
		getGoodsShelfStockCountDAO().delete(goodsShelfStockCountId, goodsShelfStockCountVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsShelfStockCountManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getGoodsShelfStockCountDAO().deleteAll();
	}

	protected void checkParamsForAddingStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary,String [] tokensExpr) throws Exception{
		
		

		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);

		checkTitleOfStockCountIssueTrack(userContext,  title, exception);
		checkCountTimeOfStockCountIssueTrack(userContext,  countTime, exception);
		checkSummaryOfStockCountIssueTrack(userContext,  summary, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  GoodsShelfStockCount addStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, String title, Date countTime, String summary, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingStockCountIssueTrack(userContext,goodsShelfStockCountId,title, countTime, summary,tokensExpr);
		
		StockCountIssueTrack stockCountIssueTrack = createStockCountIssueTrack(userContext,title, countTime, summary);
		
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		synchronized(goodsShelfStockCount){ 
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelfStockCount.addStockCountIssueTrack( stockCountIssueTrack );		
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}
	}
	protected StockCountIssueTrack createStockCountIssueTrack(RetailScmUserContext userContext, String title, Date countTime, String summary) throws Exception{

		StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
		
		
		stockCountIssueTrack.setTitle(title);		
		stockCountIssueTrack.setCountTime(countTime);		
		stockCountIssueTrack.setSummary(summary);
	
		
		return stockCountIssueTrack;
	
		
	}
	
	protected StockCountIssueTrack createIndexedStockCountIssueTrack(String id, int version){

		StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
		stockCountIssueTrack.setId(id);
		stockCountIssueTrack.setVersion(version);
		return stockCountIssueTrack;			
		
	}
	protected void checkParamsForRemovingStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, 
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{
		

		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		checkIdOfStockCountIssueTrack(userContext, stockCountIssueTrackId, exception);
		checkVersionOfStockCountIssueTrack(userContext, stockCountIssueTrackVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsShelfStockCount removeStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, 
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingStockCountIssueTrack(userContext,goodsShelfStockCountId, stockCountIssueTrackId, stockCountIssueTrackVersion,tokensExpr);
		
		StockCountIssueTrack stockCountIssueTrack = createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		synchronized(goodsShelfStockCount){ 
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelfStockCount.removeStockCountIssueTrack( stockCountIssueTrack );		
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, 
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{
		

		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		checkIdOfStockCountIssueTrack(userContext, stockCountIssueTrackId, exception);
		checkVersionOfStockCountIssueTrack(userContext, stockCountIssueTrackVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  GoodsShelfStockCount copyStockCountIssueTrackFrom(RetailScmUserContext userContext, String goodsShelfStockCountId, 
		String stockCountIssueTrackId, int stockCountIssueTrackVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingStockCountIssueTrack(userContext,goodsShelfStockCountId, stockCountIssueTrackId, stockCountIssueTrackVersion,tokensExpr);
		
		StockCountIssueTrack stockCountIssueTrack = createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		synchronized(goodsShelfStockCount){ 
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			goodsShelfStockCount.copyStockCountIssueTrackFrom( stockCountIssueTrack );		
			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		GoodsShelfStockCountManagerException exception = new GoodsShelfStockCountManagerException("Error Occured");
		
		checkIdOfGoodsShelfStockCount(userContext, goodsShelfStockCountId, exception);
		checkIdOfStockCountIssueTrack(userContext, stockCountIssueTrackId, exception);
		checkVersionOfStockCountIssueTrack(userContext, stockCountIssueTrackVersion, exception);
		

		if(StockCountIssueTrack.TITLE_PROPERTY.equals(property)){
			checkTitleOfStockCountIssueTrack(userContext, parseString(newValueExpr), exception);
		}
		
		if(StockCountIssueTrack.COUNT_TIME_PROPERTY.equals(property)){
			checkCountTimeOfStockCountIssueTrack(userContext, parseDate(newValueExpr), exception);
		}
		
		if(StockCountIssueTrack.SUMMARY_PROPERTY.equals(property)){
			checkSummaryOfStockCountIssueTrack(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  GoodsShelfStockCount updateStockCountIssueTrack(RetailScmUserContext userContext, String goodsShelfStockCountId, String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingStockCountIssueTrack(userContext, goodsShelfStockCountId, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr,  tokensExpr);
		
		
		GoodsShelfStockCount goodsShelfStockCount = loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
		
		synchronized(goodsShelfStockCount){ 
			//Will be good when the goodsShelfStockCount loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//goodsShelfStockCount.removeStockCountIssueTrack( stockCountIssueTrack );	
			//make changes to AcceleraterAccount.
			StockCountIssueTrack stockCountIssueTrackIndex = createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);
		
			StockCountIssueTrack stockCountIssueTrack = goodsShelfStockCount.findTheStockCountIssueTrack(stockCountIssueTrackIndex);
			if(stockCountIssueTrack == null){
				throw new GoodsShelfStockCountManagerException(stockCountIssueTrack+"Not found" );
			}
			
			stockCountIssueTrack.changePropery(property, newValueExpr);

			goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
			return present(userContext,goodsShelfStockCount, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


