
package com.skynet.retailscm.goodsmovement;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.goods.Goods;

import com.skynet.retailscm.goods.GoodsDAO;



import com.skynet.retailscm.goods.GoodsTable;




public class GoodsMovementManagerImpl extends RetailScmCheckerManager implements GoodsMovementManager {
	
	private static final String SERVICE_TYPE = "GoodsMovement";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  GoodsMovementDAO  goodsMovementDAO;
 	public void setGoodsMovementDAO(GoodsMovementDAO  goodsMovementDAO){
 	
 		if(goodsMovementDAO == null){
 			throw new IllegalStateException("Do not try to set goodsMovementDAO to null.");
 		}
	 	this.goodsMovementDAO = goodsMovementDAO;
 	}
 	public GoodsMovementDAO getGoodsMovementDAO(){
 		if(this.goodsMovementDAO == null){
 			throw new IllegalStateException("The GoodsMovementDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsMovementDAO;
 	}
 	
 	protected GoodsMovement saveGoodsMovement(RetailScmUserContext userContext, GoodsMovement goodsMovement, String [] tokensExpr) throws Exception{	
 		//return getGoodsMovementDAO().save(goodsMovement, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveGoodsMovement(userContext, goodsMovement, tokens);
 	}
 	
 	protected GoodsMovement saveGoodsMovementDetail(RetailScmUserContext userContext, GoodsMovement goodsMovement) throws Exception{	

 		
 		return saveGoodsMovement(userContext, goodsMovement, allTokens());
 	}
 	
 	public GoodsMovement loadGoodsMovement(RetailScmUserContext userContext, String goodsMovementId, String [] tokensExpr) throws Exception{				
 
 		GoodsMovementManagerException exception = new GoodsMovementManagerException("Error Occured");
		
		checkIdOfGoodsMovement(userContext, goodsMovementId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		GoodsMovement goodsMovement = loadGoodsMovement( userContext, goodsMovementId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,goodsMovement, tokens);
 	}
 	
 	protected GoodsMovement present(RetailScmUserContext userContext, GoodsMovement goodsMovement, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,goodsMovement,tokens);
		
		
		return this.getGoodsMovementDAO().present(goodsMovement, tokens);
	}
 
 	
 	
 	public GoodsMovement loadGoodsMovementDetail(RetailScmUserContext userContext, String goodsMovementId) throws Exception{	
 		GoodsMovementManagerException exception = new GoodsMovementManagerException("Error Occured");
		
		checkIdOfGoodsMovement(userContext, goodsMovementId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsMovement goodsMovement = loadGoodsMovement( userContext, goodsMovementId, allTokens());

 		return present(userContext,goodsMovement, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String goodsMovementId) throws Exception{	
 		GoodsMovementManagerException exception = new GoodsMovementManagerException("Error Occured");
		
		checkIdOfGoodsMovement(userContext, goodsMovementId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		GoodsMovement goodsMovement = loadGoodsMovement( userContext, goodsMovementId, allTokens());

 		return present(userContext,goodsMovement, allTokens());
		
 	}
 	protected GoodsMovement saveGoodsMovement(RetailScmUserContext userContext, GoodsMovement goodsMovement, Map<String,Object>tokens) throws Exception{	
 		return getGoodsMovementDAO().save(goodsMovement, tokens);
 	}
 	protected GoodsMovement loadGoodsMovement(RetailScmUserContext userContext, String goodsMovementId, Map<String,Object>tokens) throws Exception{	
 		return getGoodsMovementDAO().load(goodsMovementId, tokens);
 	}

	



 	 
 	
 	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO goodsDAO){
	 	this.goodsDAO = goodsDAO;
 	}
 	//------------------------------------
 	public GoodsDAO getGoodsDAO(){
	 	return this.goodsDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsMovement goodsMovement, Map<String, Object> tokens){
		super.addActions(userContext, goodsMovement, tokens);
		
		addAction(userContext, goodsMovement, tokens,"@create","createGoodsMovement","createGoodsMovement/","main","primary");
		addAction(userContext, goodsMovement, tokens,"@update","updateGoodsMovement","updateGoodsMovement/"+goodsMovement.getId()+"/","main","primary");
		addAction(userContext, goodsMovement, tokens,"@copy","cloneGoodsMovement","cloneGoodsMovement/"+goodsMovement.getId()+"/","main","primary");
		
		addAction(userContext, goodsMovement, tokens,"goods_movement.transfer_to_goods","transferToAnotherGoods","transferToAnotherGoods/"+goodsMovement.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, GoodsMovement goodsMovement, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public GoodsMovement createGoodsMovement(RetailScmUserContext userContext,Date moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, double latitude, double longitude, String goodsId
) throws Exception
	{
		
		GoodsMovementManagerException exception = new GoodsMovementManagerException("Error Occured");

		

		checkMoveTimeOfGoodsMovement(userContext,  moveTime, exception);
		checkFacilityOfGoodsMovement(userContext,  facility, exception);
		checkFacilityIdOfGoodsMovement(userContext,  facilityId, exception);
		checkFromIpOfGoodsMovement(userContext,  fromIp, exception);
		checkUserAgentOfGoodsMovement(userContext,  userAgent, exception);
		checkSessionIdOfGoodsMovement(userContext,  sessionId, exception);
		checkLatitudeOfGoodsMovement(userContext,  latitude, exception);
		checkLongitudeOfGoodsMovement(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		GoodsMovement goodsMovement=createNewGoodsMovement();	

		goodsMovement.setMoveTime(moveTime);
		goodsMovement.setFacility(facility);
		goodsMovement.setFacilityId(facilityId);
		goodsMovement.setFromIp(fromIp);
		goodsMovement.setUserAgent(userAgent);
		goodsMovement.setSessionId(sessionId);
		goodsMovement.setLatitude(latitude);
		goodsMovement.setLongitude(longitude);
		Goods goods = loadGoods(goodsId,emptyOptions());
		goodsMovement.setGoods(goods);

		return saveGoodsMovement(userContext, goodsMovement, emptyOptions());
		

		
	}
	protected GoodsMovement createNewGoodsMovement() 
	{
		
		return new GoodsMovement();		
	}
	
	protected void checkParamsForUpdatingGoodsMovement(RetailScmUserContext userContext,String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		GoodsMovementManagerException exception = new GoodsMovementManagerException("Error Occured");
		
		checkIdOfGoodsMovement(userContext, goodsMovementId, exception);
		checkVersionOfGoodsMovement(userContext, goodsMovementVersion, exception);
		

		if(GoodsMovement.MOVE_TIME_PROPERTY.equals(property)){
			checkMoveTimeOfGoodsMovement(userContext, parseTimestamp(newValueExpr), exception);
		}
		if(GoodsMovement.FACILITY_PROPERTY.equals(property)){
			checkFacilityOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsMovement.FACILITY_ID_PROPERTY.equals(property)){
			checkFacilityIdOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsMovement.FROM_IP_PROPERTY.equals(property)){
			checkFromIpOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsMovement.USER_AGENT_PROPERTY.equals(property)){
			checkUserAgentOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsMovement.SESSION_ID_PROPERTY.equals(property)){
			checkSessionIdOfGoodsMovement(userContext, parseString(newValueExpr), exception);
		}
		if(GoodsMovement.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfGoodsMovement(userContext, parseDouble(newValueExpr), exception);
		}
		if(GoodsMovement.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfGoodsMovement(userContext, parseDouble(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public GoodsMovement clone(RetailScmUserContext userContext, String fromGoodsMovementId) throws Exception{
		
		return this.getGoodsMovementDAO().clone(fromGoodsMovementId, this.allTokens());
	}
	
	public GoodsMovement updateGoodsMovement(RetailScmUserContext userContext,String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingGoodsMovement(userContext, goodsMovementId, goodsMovementVersion, property, newValueExpr, tokensExpr);
		
		GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, allTokens());
		if(goodsMovement.getVersion() != goodsMovementVersion){
			String message = "The target version("+goodsMovement.getVersion()+") is not equals to version("+goodsMovementVersion+") provided";
			throw new GoodsMovementManagerException(message);
		}
		synchronized(goodsMovement){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to GoodsMovement.
			
			goodsMovement.changePropery(property, newValueExpr);
			goodsMovement = saveGoodsMovement(userContext, goodsMovement, tokens().done());
			return present(userContext,goodsMovement, mergedAllTokens(tokensExpr));
			//return saveGoodsMovement(userContext, goodsMovement, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected GoodsMovementTokens tokens(){
		return GoodsMovementTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return GoodsMovementTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return GoodsMovementTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherGoods(RetailScmUserContext userContext, String goodsMovementId, String anotherGoodsId) throws Exception
 	{
 		GoodsMovementManagerException exception = new GoodsMovementManagerException("Error Occured");
 		checkIdOfGoodsMovement(userContext, goodsMovementId,exception);
 		checkIdOfGoods(userContext, anotherGoodsId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public GoodsMovement transferToAnotherGoods(RetailScmUserContext userContext, String goodsMovementId, String anotherGoodsId) throws Exception
 	{
 		checkParamsForTransferingAnotherGoods(userContext, goodsMovementId,anotherGoodsId);
 
		GoodsMovement goodsMovement = loadGoodsMovement(userContext, goodsMovementId, allTokens());	
		synchronized(goodsMovement){
			//will be good when the goodsMovement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Goods goods = loadGoods(anotherGoodsId, emptyOptions());		
			goodsMovement.setGoods(goods);		
			goodsMovement = saveGoodsMovement(userContext, goodsMovement, emptyOptions());
			
			return present(userContext,goodsMovement, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Goods loadGoods(String newGoodsId, Map<String,Object> options) throws Exception
 	{
		
 		return getGoodsDAO().load(newGoodsId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String goodsMovementId, int goodsMovementVersion) throws Exception {
		
		deleteInternal(userContext, goodsMovementId, goodsMovementVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String goodsMovementId, int goodsMovementVersion) throws Exception{
		getGoodsMovementDAO().delete(goodsMovementId, goodsMovementVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new GoodsMovementManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getGoodsMovementDAO().deleteAll();
	}


}


