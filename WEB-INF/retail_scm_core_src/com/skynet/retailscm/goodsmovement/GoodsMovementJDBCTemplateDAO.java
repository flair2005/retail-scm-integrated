
package com.skynet.retailscm.goodsmovement;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goods.Goods;

import com.skynet.retailscm.goods.GoodsDAO;

import com.skynet.retailscm.goods.GoodsTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsMovementJDBCTemplateDAO extends CommonJDBCTemplateDAO implements GoodsMovementDAO{
 
 	
 	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO goodsDAO){
	 	this.goodsDAO = goodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
	 	return this.goodsDAO;
 	}

		

	
	/*
	protected GoodsMovement load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsMovement(accessKey, options);
	}
	*/
	public GoodsMovement load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsMovement(GoodsMovementTable.withId(id), options);
	}
	
	
	
	public GoodsMovement save(GoodsMovement goodsMovement,Map<String,Object> options){
		
		String methodName="save(GoodsMovement goodsMovement,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goodsMovement, methodName, "goodsMovement");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoodsMovement(goodsMovement,options);
	}
	public GoodsMovement clone(String goodsMovementId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsMovementTable.withId(goodsMovementId),options);
	}
	
	protected GoodsMovement clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsMovementId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GoodsMovement newGoodsMovement = loadInternalGoodsMovement(accessKey, options);
		newGoodsMovement.setVersion(0);
		
		

		
		saveInternalGoodsMovement(newGoodsMovement,options);
		
		return newGoodsMovement;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String goodsMovementId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{goodsMovementId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new GoodsMovementVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsMovementNotFoundException(
					"The " + this.getTableName() + "(" + goodsMovementId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String goodsMovementId, int version) throws Exception{
	
		String methodName="delete(String goodsMovementId, int version)";
		assertMethodArgumentNotNull(goodsMovementId, methodName, "goodsMovementId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsMovementId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsMovementId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"move_time","facility","facility_id","from_ip","user_agent","session_id","latitude","longitude","goods"};
		return GoodsMovementTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods_movement";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsMovementTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractGoodsEnabled = true;
 	//private static final String GOODS = "goods";
 	protected boolean isExtractGoodsEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsMovementTokens.GOODS);
 	}
 	
 	
 	//private boolean saveGoodsEnabled = true;
 	protected boolean isSaveGoodsEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsMovementTokens.GOODS);
 	}
 	

 	
 
		

	

	protected GoodsMovementMapper getGoodsMovementMapper(){
		return new GoodsMovementMapper();
	}
	protected GoodsMovement extractGoodsMovement(String goodsMovementId) throws Exception{
		String SQL = "select * from goods_movement_data where id = ?";	
		try{
		
			GoodsMovement goodsMovement = queryForObject(SQL, new Object[]{goodsMovementId}, getGoodsMovementMapper());
			return goodsMovement;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsMovementNotFoundException("GoodsMovement("+goodsMovementId+") is not found!");
		}
		
		
	}
	protected GoodsMovement extractGoodsMovement(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from goods_movement_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			GoodsMovement goodsMovement = queryForObject(SQL, new Object[]{accessKey.getValue()}, getGoodsMovementMapper());
			return goodsMovement;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsMovementNotFoundException("GoodsMovement("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected GoodsMovement loadInternalGoodsMovement(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsMovement goodsMovement = extractGoodsMovement(accessKey, loadOptions);
 	
 		if(isExtractGoodsEnabled(loadOptions)){
	 		extractGoods(goodsMovement, loadOptions);
 		}
 
		
		return goodsMovement;
		
	}



	
	
	 

 	protected GoodsMovement extractGoods(GoodsMovement goodsMovement, Map<String,Object> options) throws Exception{

		if(goodsMovement.getGoods() == null){
			return goodsMovement;
		}
		String goodsId = goodsMovement.getGoods().getId();
		if( goodsId == null){
			return goodsMovement;
		}
		Goods goods = getGoodsDAO().load(goodsId,options);
		if(goods != null){
			goodsMovement.setGoods(goods);
		}
		
 		
 		return goodsMovement;
 	}
 		
 
		
		
  	
 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods = ?";
		SmartList<GoodsMovement> goodsMovementList = queryForList(SQL, new Object[]{goodsId}, getGoodsMovementMapper());	
 		return goodsMovementList;
 	}
 	
 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where goods = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<GoodsMovement> goodsMovementList = queryForList(SQL, new Object[]{goodsId,start, count}, getGoodsMovementMapper());
		
 		return goodsMovementList;
 	}
 	
 	public int countGoodsMovementByGoods(String goodsId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where goods = ?";
		Integer count = queryInt(SQL, new Object[]{goodsId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected GoodsMovement saveGoodsMovement(GoodsMovement  goodsMovement){
	
		String SQL=this.getSaveGoodsMovementSQL(goodsMovement);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsMovementParameters(goodsMovement);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goodsMovement.incVersion();
		return goodsMovement;
	
	}
	public SmartList<GoodsMovement> saveGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsMovementList(goodsMovementList);
		
		batchGoodsMovementCreate((List<GoodsMovement>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsMovementUpdate((List<GoodsMovement>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GoodsMovement goodsMovement:goodsMovementList){
			if(goodsMovement.isChanged()){
				goodsMovement.incVersion();
			}
			
		
		}
		
		
		return goodsMovementList;
	}

	public SmartList<GoodsMovement> removeGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options){
		
		
		super.removeList(goodsMovementList, options);
		
		return goodsMovementList;
		
		
	}
	
	protected List<Object[]> prepareGoodsMovementBatchCreateArgs(List<GoodsMovement> goodsMovementList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsMovement goodsMovement:goodsMovementList ){
			Object [] parameters = prepareGoodsMovementCreateParameters(goodsMovement);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsMovementBatchUpdateArgs(List<GoodsMovement> goodsMovementList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsMovement goodsMovement:goodsMovementList ){
			if(!goodsMovement.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsMovementUpdateParameters(goodsMovement);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsMovementCreate(List<GoodsMovement> goodsMovementList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsMovementBatchCreateArgs(goodsMovementList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsMovementUpdate(List<GoodsMovement> goodsMovementList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsMovementBatchUpdateArgs(goodsMovementList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsMovementList(List<GoodsMovement> goodsMovementList){
		
		List<GoodsMovement> goodsMovementCreateList=new ArrayList<GoodsMovement>();
		List<GoodsMovement> goodsMovementUpdateList=new ArrayList<GoodsMovement>();
		
		for(GoodsMovement goodsMovement: goodsMovementList){
			if(isUpdateRequest(goodsMovement)){
				goodsMovementUpdateList.add( goodsMovement);
				continue;
			}
			goodsMovementCreateList.add(goodsMovement);
		}
		
		return new Object[]{goodsMovementCreateList,goodsMovementUpdateList};
	}
	
	protected boolean isUpdateRequest(GoodsMovement goodsMovement){
 		return goodsMovement.getVersion() > 0;
 	}
 	protected String getSaveGoodsMovementSQL(GoodsMovement goodsMovement){
 		if(isUpdateRequest(goodsMovement)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsMovementParameters(GoodsMovement goodsMovement){
 		if(isUpdateRequest(goodsMovement) ){
 			return prepareGoodsMovementUpdateParameters(goodsMovement);
 		}
 		return prepareGoodsMovementCreateParameters(goodsMovement);
 	}
 	protected Object[] prepareGoodsMovementUpdateParameters(GoodsMovement goodsMovement){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = goodsMovement.getMoveTime();
 		parameters[1] = goodsMovement.getFacility();
 		parameters[2] = goodsMovement.getFacilityId();
 		parameters[3] = goodsMovement.getFromIp();
 		parameters[4] = goodsMovement.getUserAgent();
 		parameters[5] = goodsMovement.getSessionId();
 		parameters[6] = goodsMovement.getLatitude();
 		parameters[7] = goodsMovement.getLongitude(); 	
 		if(goodsMovement.getGoods() != null){
 			parameters[8] = goodsMovement.getGoods().getId();
 		}
 		
 		parameters[9] = goodsMovement.getId();
 		parameters[10] = goodsMovement.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsMovementCreateParameters(GoodsMovement goodsMovement){
		Object[] parameters = new Object[10];
		String newGoodsMovementId=getNextId();
		goodsMovement.setId(newGoodsMovementId);
		parameters[0] =  goodsMovement.getId();
 
 		parameters[1] = goodsMovement.getMoveTime();
 		parameters[2] = goodsMovement.getFacility();
 		parameters[3] = goodsMovement.getFacilityId();
 		parameters[4] = goodsMovement.getFromIp();
 		parameters[5] = goodsMovement.getUserAgent();
 		parameters[6] = goodsMovement.getSessionId();
 		parameters[7] = goodsMovement.getLatitude();
 		parameters[8] = goodsMovement.getLongitude(); 	
 		if(goodsMovement.getGoods() != null){
 			parameters[9] = goodsMovement.getGoods().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected GoodsMovement saveInternalGoodsMovement(GoodsMovement goodsMovement, Map<String,Object> options){
		
		saveGoodsMovement(goodsMovement);
 	
 		if(isSaveGoodsEnabled(options)){
	 		saveGoods(goodsMovement, options);
 		}
 
		
		return goodsMovement;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected GoodsMovement saveGoods(GoodsMovement goodsMovement, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsMovement.getGoods() == null){
 			return goodsMovement;//do nothing when it is null
 		}
 		
 		getGoodsDAO().save(goodsMovement.getGoods(),options);
 		return goodsMovement;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public GoodsMovement present(GoodsMovement goodsMovement,Map<String, Object> options){
	

		return goodsMovement;
	
	}
		


	protected String getTableName(){
		return GoodsMovementTable.TABLE_NAME;
	}
}


