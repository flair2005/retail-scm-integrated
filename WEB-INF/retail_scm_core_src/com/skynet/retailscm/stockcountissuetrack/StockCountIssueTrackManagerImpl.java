
package com.skynet.retailscm.stockcountissuetrack;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;



import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCountTable;




public class StockCountIssueTrackManagerImpl extends RetailScmCheckerManager implements StockCountIssueTrackManager {
	
	private static final String SERVICE_TYPE = "StockCountIssueTrack";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  StockCountIssueTrackDAO  stockCountIssueTrackDAO;
 	public void setStockCountIssueTrackDAO(StockCountIssueTrackDAO  stockCountIssueTrackDAO){
 	
 		if(stockCountIssueTrackDAO == null){
 			throw new IllegalStateException("Do not try to set stockCountIssueTrackDAO to null.");
 		}
	 	this.stockCountIssueTrackDAO = stockCountIssueTrackDAO;
 	}
 	public StockCountIssueTrackDAO getStockCountIssueTrackDAO(){
 		if(this.stockCountIssueTrackDAO == null){
 			throw new IllegalStateException("The StockCountIssueTrackDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.stockCountIssueTrackDAO;
 	}
 	
 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailScmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, String [] tokensExpr) throws Exception{	
 		//return getStockCountIssueTrackDAO().save(stockCountIssueTrack, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens);
 	}
 	
 	protected StockCountIssueTrack saveStockCountIssueTrackDetail(RetailScmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception{	

 		
 		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, allTokens());
 	}
 	
 	public StockCountIssueTrack loadStockCountIssueTrack(RetailScmUserContext userContext, String stockCountIssueTrackId, String [] tokensExpr) throws Exception{				
 
 		StockCountIssueTrackManagerException exception = new StockCountIssueTrackManagerException("Error Occured");
		
		checkIdOfStockCountIssueTrack(userContext, stockCountIssueTrackId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,stockCountIssueTrack, tokens);
 	}
 	
 	protected StockCountIssueTrack present(RetailScmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,stockCountIssueTrack,tokens);
		
		
		return this.getStockCountIssueTrackDAO().present(stockCountIssueTrack, tokens);
	}
 
 	
 	
 	public StockCountIssueTrack loadStockCountIssueTrackDetail(RetailScmUserContext userContext, String stockCountIssueTrackId) throws Exception{	
 		StockCountIssueTrackManagerException exception = new StockCountIssueTrackManagerException("Error Occured");
		
		checkIdOfStockCountIssueTrack(userContext, stockCountIssueTrackId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, allTokens());

 		return present(userContext,stockCountIssueTrack, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String stockCountIssueTrackId) throws Exception{	
 		StockCountIssueTrackManagerException exception = new StockCountIssueTrackManagerException("Error Occured");
		
		checkIdOfStockCountIssueTrack(userContext, stockCountIssueTrackId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack( userContext, stockCountIssueTrackId, allTokens());

 		return present(userContext,stockCountIssueTrack, allTokens());
		
 	}
 	protected StockCountIssueTrack saveStockCountIssueTrack(RetailScmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String,Object>tokens) throws Exception{	
 		return getStockCountIssueTrackDAO().save(stockCountIssueTrack, tokens);
 	}
 	protected StockCountIssueTrack loadStockCountIssueTrack(RetailScmUserContext userContext, String stockCountIssueTrackId, Map<String,Object>tokens) throws Exception{	
 		return getStockCountIssueTrackDAO().load(stockCountIssueTrackId, tokens);
 	}

	



 	 
 	
 	private  GoodsShelfStockCountDAO  goodsShelfStockCountDAO;
 	public void setGoodsShelfStockCountDAO(GoodsShelfStockCountDAO goodsShelfStockCountDAO){
	 	this.goodsShelfStockCountDAO = goodsShelfStockCountDAO;
 	}
 	//------------------------------------
 	public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO(){
	 	return this.goodsShelfStockCountDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){
		super.addActions(userContext, stockCountIssueTrack, tokens);
		
		addAction(userContext, stockCountIssueTrack, tokens,"@create","createStockCountIssueTrack","createStockCountIssueTrack/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@update","updateStockCountIssueTrack","updateStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");
		addAction(userContext, stockCountIssueTrack, tokens,"@copy","cloneStockCountIssueTrack","cloneStockCountIssueTrack/"+stockCountIssueTrack.getId()+"/","main","primary");
		
		addAction(userContext, stockCountIssueTrack, tokens,"stock_count_issue_track.transfer_to_stock_count","transferToAnotherStockCount","transferToAnotherStockCount/"+stockCountIssueTrack.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, StockCountIssueTrack stockCountIssueTrack, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public StockCountIssueTrack createStockCountIssueTrack(RetailScmUserContext userContext,String title, Date countTime, String summary, String stockCountId
) throws Exception
	{
		
		StockCountIssueTrackManagerException exception = new StockCountIssueTrackManagerException("Error Occured");

		

		checkTitleOfStockCountIssueTrack(userContext,  title, exception);
		checkCountTimeOfStockCountIssueTrack(userContext,  countTime, exception);
		checkSummaryOfStockCountIssueTrack(userContext,  summary, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		StockCountIssueTrack stockCountIssueTrack=createNewStockCountIssueTrack();	

		stockCountIssueTrack.setTitle(title);
		stockCountIssueTrack.setCountTime(countTime);
		stockCountIssueTrack.setSummary(summary);
		GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(stockCountId,emptyOptions());
		stockCountIssueTrack.setStockCount(stockCount);

		return saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());
		

		
	}
	protected StockCountIssueTrack createNewStockCountIssueTrack() 
	{
		
		return new StockCountIssueTrack();		
	}
	
	protected void checkParamsForUpdatingStockCountIssueTrack(RetailScmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		StockCountIssueTrackManagerException exception = new StockCountIssueTrackManagerException("Error Occured");
		
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
	
	
	
	public StockCountIssueTrack clone(RetailScmUserContext userContext, String fromStockCountIssueTrackId) throws Exception{
		
		return this.getStockCountIssueTrackDAO().clone(fromStockCountIssueTrackId, this.allTokens());
	}
	
	public StockCountIssueTrack updateStockCountIssueTrack(RetailScmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStockCountIssueTrack(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion, property, newValueExpr, tokensExpr);
		
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());
		if(stockCountIssueTrack.getVersion() != stockCountIssueTrackVersion){
			String message = "The target version("+stockCountIssueTrack.getVersion()+") is not equals to version("+stockCountIssueTrackVersion+") provided";
			throw new StockCountIssueTrackManagerException(message);
		}
		synchronized(stockCountIssueTrack){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StockCountIssueTrack.
			
			stockCountIssueTrack.changePropery(property, newValueExpr);
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
			return present(userContext,stockCountIssueTrack, mergedAllTokens(tokensExpr));
			//return saveStockCountIssueTrack(userContext, stockCountIssueTrack, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected StockCountIssueTrackTokens tokens(){
		return StockCountIssueTrackTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StockCountIssueTrackTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return StockCountIssueTrackTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherStockCount(RetailScmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{
 		StockCountIssueTrackManagerException exception = new StockCountIssueTrackManagerException("Error Occured");
 		checkIdOfStockCountIssueTrack(userContext, stockCountIssueTrackId,exception);
 		checkIdOfGoodsShelfStockCount(userContext, anotherStockCountId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public StockCountIssueTrack transferToAnotherStockCount(RetailScmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId) throws Exception
 	{
 		checkParamsForTransferingAnotherStockCount(userContext, stockCountIssueTrackId,anotherStockCountId);
 
		StockCountIssueTrack stockCountIssueTrack = loadStockCountIssueTrack(userContext, stockCountIssueTrackId, allTokens());	
		synchronized(stockCountIssueTrack){
			//will be good when the stockCountIssueTrack loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GoodsShelfStockCount stockCount = loadGoodsShelfStockCount(anotherStockCountId, emptyOptions());		
			stockCountIssueTrack.setStockCount(stockCount);		
			stockCountIssueTrack = saveStockCountIssueTrack(userContext, stockCountIssueTrack, emptyOptions());
			
			return present(userContext,stockCountIssueTrack, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected GoodsShelfStockCount loadGoodsShelfStockCount(String newStockCountId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsShelfStockCountDAO().load(newStockCountId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception {
		
		deleteInternal(userContext, stockCountIssueTrackId, stockCountIssueTrackVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String stockCountIssueTrackId, int stockCountIssueTrackVersion) throws Exception{
		getStockCountIssueTrackDAO().delete(stockCountIssueTrackId, stockCountIssueTrackVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StockCountIssueTrackManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getStockCountIssueTrackDAO().deleteAll();
	}


}


