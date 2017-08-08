
package com.skynet.retailscm.transporttask;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrack;
import com.skynet.retailscm.truckdriver.TruckDriver;

import com.skynet.retailscm.transportfleet.TransportFleetDAO;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrackDAO;
import com.skynet.retailscm.truckdriver.TruckDriverDAO;
import com.skynet.retailscm.transporttruck.TransportTruckDAO;
import com.skynet.retailscm.goods.GoodsDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;

import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.goods.GoodsTable;
import com.skynet.retailscm.transportfleet.TransportFleetTable;
import com.skynet.retailscm.truckdriver.TruckDriverTable;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrackTable;
import com.skynet.retailscm.transporttruck.TransportTruckTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class TransportTaskJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TransportTaskDAO{
 
 	
 	private  TruckDriverDAO  truckDriverDAO;
 	public void setTruckDriverDAO(TruckDriverDAO truckDriverDAO){
	 	this.truckDriverDAO = truckDriverDAO;
 	}
 	public TruckDriverDAO getTruckDriverDAO(){
	 	return this.truckDriverDAO;
 	}
 
 	
 	private  TransportFleetDAO  transportFleetDAO;
 	public void setTransportFleetDAO(TransportFleetDAO transportFleetDAO){
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	public TransportFleetDAO getTransportFleetDAO(){
	 	return this.transportFleetDAO;
 	}
 
 	
 	private  TransportTruckDAO  transportTruckDAO;
 	public void setTransportTruckDAO(TransportTruckDAO transportTruckDAO){
	 	this.transportTruckDAO = transportTruckDAO;
 	}
 	public TransportTruckDAO getTransportTruckDAO(){
	 	return this.transportTruckDAO;
 	}
 
 	
 	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
	 	return this.retailStoreDAO;
 	}

		
	
  	private  GoodsDAO  goodsDAO;
 	public void setGoodsDAO(GoodsDAO pGoodsDAO){
 	
 		if(pGoodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = pGoodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsDAO;
 	}	
 	
			
		
	
  	private  TransportTaskTrackDAO  transportTaskTrackDAO;
 	public void setTransportTaskTrackDAO(TransportTaskTrackDAO pTransportTaskTrackDAO){
 	
 		if(pTransportTaskTrackDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskTrackDAO to null.");
 		}
	 	this.transportTaskTrackDAO = pTransportTaskTrackDAO;
 	}
 	public TransportTaskTrackDAO getTransportTaskTrackDAO(){
 		if(this.transportTaskTrackDAO == null){
 			throw new IllegalStateException("The transportTaskTrackDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskTrackDAO;
 	}	
 	
			
		

	
	/*
	protected TransportTask load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTask(accessKey, options);
	}
	*/
	public TransportTask load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTask(TransportTaskTable.withId(id), options);
	}
	
	
	
	public TransportTask save(TransportTask transportTask,Map<String,Object> options){
		
		String methodName="save(TransportTask transportTask,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportTask, methodName, "transportTask");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportTask(transportTask,options);
	}
	public TransportTask clone(String transportTaskId, Map<String,Object> options) throws Exception{
	
		return clone(TransportTaskTable.withId(transportTaskId),options);
	}
	
	protected TransportTask clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportTaskId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportTask newTransportTask = loadInternalTransportTask(accessKey, options);
		newTransportTask.setVersion(0);
		
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newTransportTask.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskTrackListEnabled(options)){
 			for(TransportTaskTrack item: newTransportTask.getTransportTaskTrackList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransportTask(newTransportTask,options);
		
		return newTransportTask;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String transportTaskId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{transportTaskId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TransportTaskVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTaskNotFoundException(
					"The " + this.getTableName() + "(" + transportTaskId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String transportTaskId, int version) throws Exception{
	
		String methodName="delete(String transportTaskId, int version)";
		assertMethodArgumentNotNull(transportTaskId, methodName, "transportTaskId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTaskId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTaskId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","start","begin_time","end","driver","truck","belongs_to","latitude","longitude"};
		return TransportTaskTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_task";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTaskTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEndEnabled = true;
 	//private static final String END = "end";
 	protected boolean isExtractEndEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.END);
 	}
 	
 	
 	//private boolean saveEndEnabled = true;
 	protected boolean isSaveEndEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.END);
 	}
 	

 	
  
 	//private boolean extractDriverEnabled = true;
 	//private static final String DRIVER = "driver";
 	protected boolean isExtractDriverEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.DRIVER);
 	}
 	
 	
 	//private boolean saveDriverEnabled = true;
 	protected boolean isSaveDriverEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.DRIVER);
 	}
 	

 	
  
 	//private boolean extractTruckEnabled = true;
 	//private static final String TRUCK = "truck";
 	protected boolean isExtractTruckEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.TRUCK);
 	}
 	
 	
 	//private boolean saveTruckEnabled = true;
 	protected boolean isSaveTruckEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.TRUCK);
 	}
 	

 	
  
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String GOODS_LIST = "goodsList";
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TransportTaskTokens.GOODS_LIST);
		
 	}

	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTaskTokens.GOODS_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TRANSPORT_TASK_TRACK_LIST = "transportTaskTrackList";
	
	protected boolean isExtractTransportTaskTrackListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TransportTaskTokens.TRANSPORT_TASK_TRACK_LIST);
		
 	}

	protected boolean isSaveTransportTaskTrackListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTaskTokens.TRANSPORT_TASK_TRACK_LIST);
		
 	}
 	
 	
			
		

	

	protected TransportTaskMapper getTransportTaskMapper(){
		return new TransportTaskMapper();
	}
	protected TransportTask extractTransportTask(String transportTaskId) throws Exception{
		String SQL = "select * from transport_task_data where id = ?";	
		try{
		
			TransportTask transportTask = queryForObject(SQL, new Object[]{transportTaskId}, getTransportTaskMapper());
			return transportTask;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskNotFoundException("TransportTask("+transportTaskId+") is not found!");
		}
		
		
	}
	protected TransportTask extractTransportTask(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from transport_task_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TransportTask transportTask = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTransportTaskMapper());
			return transportTask;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskNotFoundException("TransportTask("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TransportTask loadInternalTransportTask(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTask transportTask = extractTransportTask(accessKey, loadOptions);
 	
 		if(isExtractEndEnabled(loadOptions)){
	 		extractEnd(transportTask, loadOptions);
 		}
  	
 		if(isExtractDriverEnabled(loadOptions)){
	 		extractDriver(transportTask, loadOptions);
 		}
  	
 		if(isExtractTruckEnabled(loadOptions)){
	 		extractTruck(transportTask, loadOptions);
 		}
  	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(transportTask, loadOptions);
 		}
 
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(transportTask, loadOptions);
 		}		
		
		if(isExtractTransportTaskTrackListEnabled(loadOptions)){
	 		extractTransportTaskTrackList(transportTask, loadOptions);
 		}		
		
		return transportTask;
		
	}



	
	
	 

 	protected TransportTask extractEnd(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getEnd() == null){
			return transportTask;
		}
		String endId = transportTask.getEnd().getId();
		if( endId == null){
			return transportTask;
		}
		RetailStore end = getRetailStoreDAO().load(endId,options);
		if(end != null){
			transportTask.setEnd(end);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractDriver(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getDriver() == null){
			return transportTask;
		}
		String driverId = transportTask.getDriver().getId();
		if( driverId == null){
			return transportTask;
		}
		TruckDriver driver = getTruckDriverDAO().load(driverId,options);
		if(driver != null){
			transportTask.setDriver(driver);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractTruck(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getTruck() == null){
			return transportTask;
		}
		String truckId = transportTask.getTruck().getId();
		if( truckId == null){
			return transportTask;
		}
		TransportTruck truck = getTransportTruckDAO().load(truckId,options);
		if(truck != null){
			transportTask.setTruck(truck);
		}
		
 		
 		return transportTask;
 	}
 		
  

 	protected TransportTask extractBelongsTo(TransportTask transportTask, Map<String,Object> options) throws Exception{

		if(transportTask.getBelongsTo() == null){
			return transportTask;
		}
		String belongsToId = transportTask.getBelongsTo().getId();
		if( belongsToId == null){
			return transportTask;
		}
		TransportFleet belongsTo = getTransportFleetDAO().load(belongsToId,options);
		if(belongsTo != null){
			transportTask.setBelongsTo(belongsTo);
		}
		
 		
 		return transportTask;
 	}
 		
 
		
	protected TransportTask extractGoodsList(TransportTask transportTask, Map<String,Object> options){
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByTransportTask(transportTask.getId(),options);
		if(goodsList != null){
			transportTask.setGoodsList(goodsList);
		}
		
		return transportTask;
	
	}	
		
	protected TransportTask extractTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
		
		SmartList<TransportTaskTrack> transportTaskTrackList = getTransportTaskTrackDAO().findTransportTaskTrackByMovement(transportTask.getId(),options);
		if(transportTaskTrackList != null){
			transportTask.setTransportTaskTrackList(transportTaskTrackList);
		}
		
		return transportTask;
	
	}	
		
		
  	
 	public SmartList<TransportTask> findTransportTaskByEnd(String retailStoreId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where end = ?";
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{retailStoreId}, getTransportTaskMapper());	
 		return transportTaskList;
 	}
 	
 	public SmartList<TransportTask> findTransportTaskByEnd(String retailStoreId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where end = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{retailStoreId,start, count}, getTransportTaskMapper());
		
 		return transportTaskList;
 	}
 	
 	public int countTransportTaskByEnd(String retailStoreId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where end = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<TransportTask> findTransportTaskByDriver(String truckDriverId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where driver = ?";
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{truckDriverId}, getTransportTaskMapper());	
 		return transportTaskList;
 	}
 	
 	public SmartList<TransportTask> findTransportTaskByDriver(String truckDriverId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where driver = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{truckDriverId,start, count}, getTransportTaskMapper());
		
 		return transportTaskList;
 	}
 	
 	public int countTransportTaskByDriver(String truckDriverId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where driver = ?";
		Integer count = queryInt(SQL, new Object[]{truckDriverId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<TransportTask> findTransportTaskByTruck(String transportTruckId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where truck = ?";
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{transportTruckId}, getTransportTaskMapper());	
 		return transportTaskList;
 	}
 	
 	public SmartList<TransportTask> findTransportTaskByTruck(String transportTruckId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where truck = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{transportTruckId,start, count}, getTransportTaskMapper());
		
 		return transportTaskList;
 	}
 	
 	public int countTransportTaskByTruck(String transportTruckId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where truck = ?";
		Integer count = queryInt(SQL, new Object[]{transportTruckId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<TransportTask> findTransportTaskByBelongsTo(String transportFleetId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{transportFleetId}, getTransportTaskMapper());	
 		return transportTaskList;
 	}
 	
 	public SmartList<TransportTask> findTransportTaskByBelongsTo(String transportFleetId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TransportTask> transportTaskList = queryForList(SQL, new Object[]{transportFleetId,start, count}, getTransportTaskMapper());
		
 		return transportTaskList;
 	}
 	
 	public int countTransportTaskByBelongsTo(String transportFleetId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{transportFleetId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TransportTask saveTransportTask(TransportTask  transportTask){
	
		String SQL=this.getSaveTransportTaskSQL(transportTask);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTaskParameters(transportTask);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportTask.incVersion();
		return transportTask;
	
	}
	public SmartList<TransportTask> saveTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTaskList(transportTaskList);
		
		batchTransportTaskCreate((List<TransportTask>)lists[CREATE_LIST_INDEX]);
		
		batchTransportTaskUpdate((List<TransportTask>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportTask transportTask:transportTaskList){
			if(transportTask.isChanged()){
				transportTask.incVersion();
			}
			
		
		}
		
		
		return transportTaskList;
	}

	public SmartList<TransportTask> removeTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		
		
		super.removeList(transportTaskList, options);
		
		return transportTaskList;
		
		
	}
	
	protected List<Object[]> prepareTransportTaskBatchCreateArgs(List<TransportTask> transportTaskList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTask transportTask:transportTaskList ){
			Object [] parameters = prepareTransportTaskCreateParameters(transportTask);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportTaskBatchUpdateArgs(List<TransportTask> transportTaskList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTask transportTask:transportTaskList ){
			if(!transportTask.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTaskUpdateParameters(transportTask);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportTaskCreate(List<TransportTask> transportTaskList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTaskBatchCreateArgs(transportTaskList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportTaskUpdate(List<TransportTask> transportTaskList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTaskBatchUpdateArgs(transportTaskList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportTaskList(List<TransportTask> transportTaskList){
		
		List<TransportTask> transportTaskCreateList=new ArrayList<TransportTask>();
		List<TransportTask> transportTaskUpdateList=new ArrayList<TransportTask>();
		
		for(TransportTask transportTask: transportTaskList){
			if(isUpdateRequest(transportTask)){
				transportTaskUpdateList.add( transportTask);
				continue;
			}
			transportTaskCreateList.add(transportTask);
		}
		
		return new Object[]{transportTaskCreateList,transportTaskUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportTask transportTask){
 		return transportTask.getVersion() > 0;
 	}
 	protected String getSaveTransportTaskSQL(TransportTask transportTask){
 		if(isUpdateRequest(transportTask)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportTaskParameters(TransportTask transportTask){
 		if(isUpdateRequest(transportTask) ){
 			return prepareTransportTaskUpdateParameters(transportTask);
 		}
 		return prepareTransportTaskCreateParameters(transportTask);
 	}
 	protected Object[] prepareTransportTaskUpdateParameters(TransportTask transportTask){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = transportTask.getName();
 		parameters[1] = transportTask.getStart();
 		parameters[2] = transportTask.getBeginTime(); 	
 		if(transportTask.getEnd() != null){
 			parameters[3] = transportTask.getEnd().getId();
 		}
  	
 		if(transportTask.getDriver() != null){
 			parameters[4] = transportTask.getDriver().getId();
 		}
  	
 		if(transportTask.getTruck() != null){
 			parameters[5] = transportTask.getTruck().getId();
 		}
  	
 		if(transportTask.getBelongsTo() != null){
 			parameters[6] = transportTask.getBelongsTo().getId();
 		}
 
 		parameters[7] = transportTask.getLatitude();
 		parameters[8] = transportTask.getLongitude();		
 		parameters[9] = transportTask.getId();
 		parameters[10] = transportTask.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportTaskCreateParameters(TransportTask transportTask){
		Object[] parameters = new Object[10];
		String newTransportTaskId=getNextId();
		transportTask.setId(newTransportTaskId);
		parameters[0] =  transportTask.getId();
 
 		parameters[1] = transportTask.getName();
 		parameters[2] = transportTask.getStart();
 		parameters[3] = transportTask.getBeginTime(); 	
 		if(transportTask.getEnd() != null){
 			parameters[4] = transportTask.getEnd().getId();
 		
 		}
 		 	
 		if(transportTask.getDriver() != null){
 			parameters[5] = transportTask.getDriver().getId();
 		
 		}
 		 	
 		if(transportTask.getTruck() != null){
 			parameters[6] = transportTask.getTruck().getId();
 		
 		}
 		 	
 		if(transportTask.getBelongsTo() != null){
 			parameters[7] = transportTask.getBelongsTo().getId();
 		
 		}
 		
 		parameters[8] = transportTask.getLatitude();
 		parameters[9] = transportTask.getLongitude();		
 				
 		return parameters;
 	}
 	
	protected TransportTask saveInternalTransportTask(TransportTask transportTask, Map<String,Object> options){
		
		saveTransportTask(transportTask);
 	
 		if(isSaveEndEnabled(options)){
	 		saveEnd(transportTask, options);
 		}
  	
 		if(isSaveDriverEnabled(options)){
	 		saveDriver(transportTask, options);
 		}
  	
 		if(isSaveTruckEnabled(options)){
	 		saveTruck(transportTask, options);
 		}
  	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(transportTask, options);
 		}
 
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(transportTask, options);
	 		removeGoodsList(transportTask, options);
	 		
 		}		
		
		if(isSaveTransportTaskTrackListEnabled(options)){
	 		saveTransportTaskTrackList(transportTask, options);
	 		removeTransportTaskTrackList(transportTask, options);
	 		
 		}		
		
		return transportTask;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportTask saveEnd(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getEnd() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getRetailStoreDAO().save(transportTask.getEnd(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveDriver(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getDriver() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getTruckDriverDAO().save(transportTask.getDriver(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveTruck(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getTruck() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getTransportTruckDAO().save(transportTask.getTruck(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected TransportTask saveBelongsTo(TransportTask transportTask, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTask.getBelongsTo() == null){
 			return transportTask;//do nothing when it is null
 		}
 		
 		getTransportFleetDAO().save(transportTask.getBelongsTo(),options);
 		return transportTask;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected TransportTask saveGoodsList(TransportTask transportTask, Map<String,Object> options){
		SmartList<Goods> goodsList = transportTask.getGoodsList();
		if(goodsList == null){
			return transportTask;
		}
		if(goodsList.isEmpty()){
			return transportTask;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsDAO().saveGoodsList(goodsList,options);
		
		return transportTask;
	
	}
	
	protected TransportTask removeGoodsList(TransportTask transportTask, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = transportTask.getGoodsList();
		if(goodsList == null){
			return transportTask;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return transportTask;
		}
		if(toRemoveGoodsList.isEmpty()){
			return transportTask;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return transportTask;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected TransportTask saveTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList == null){
			return transportTask;
		}
		if(transportTaskTrackList.isEmpty()){
			return transportTask;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTransportTaskTrackDAO().saveTransportTaskTrackList(transportTaskTrackList,options);
		
		return transportTask;
	
	}
	
	protected TransportTask removeTransportTaskTrackList(TransportTask transportTask, Map<String,Object> options){
	
	
		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();
		if(transportTaskTrackList == null){
			return transportTask;
		}	
	
		SmartList<TransportTaskTrack> toRemoveTransportTaskTrackList = transportTaskTrackList.getToRemoveList();
		
		if(toRemoveTransportTaskTrackList == null){
			return transportTask;
		}
		if(toRemoveTransportTaskTrackList.isEmpty()){
			return transportTask;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskTrackDAO().removeTransportTaskTrackList(toRemoveTransportTaskTrackList,options);
		
		return transportTask;
	
	}
	
	
	
 	
 	
	
	
	
		

	public TransportTask present(TransportTask transportTask,Map<String, Object> options){
	
		presentGoodsList(transportTask,options);
		presentTransportTaskTrackList(transportTask,options);

		return transportTask;
	
	}
		
	
  	
 	protected TransportTask presentGoodsList(
			TransportTask transportTask,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = transportTask.getGoodsList();		
		if(goodsList == null){
			return transportTask;			
		}
		
		String targetObjectName = "goods";
		int goodsListSize = goodsList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return transportTask;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsListSize;
		if(goodsListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsDAO().countGoodsByTransportTask(transportTask.getId(), options);			
		}
		//transportTask.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//transportTask.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsListSize,currentPage,rowsPerPage) ;
			goodsList = goodsList.subListOf(fromIndex, toIndex);
			goodsList.setTotalCount(count);
			goodsList.setCurrentPageNumber(currentPage);			
			transportTask.setGoodsList(goodsList);
			return transportTask;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsList 
			= getGoodsDAO().findGoodsByTransportTask(transportTask.getId(),start, rowsPerPage, options );
		goodsList.setTotalCount(count);
		goodsList.setCurrentPageNumber(currentPage);
		transportTask.setGoodsList(goodsList );	

		return transportTask;
	}			
		
	
  	
 	protected TransportTask presentTransportTaskTrackList(
			TransportTask transportTask,
			Map<String, Object> options) {

		SmartList<TransportTaskTrack> transportTaskTrackList = transportTask.getTransportTaskTrackList();		
		if(transportTaskTrackList == null){
			return transportTask;			
		}
		
		String targetObjectName = "transportTaskTrack";
		int transportTaskTrackListSize = transportTaskTrackList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(transportTaskTrackListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return transportTask;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = transportTaskTrackListSize;
		if(transportTaskTrackListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTransportTaskTrackDAO().countTransportTaskTrackByMovement(transportTask.getId(), options);			
		}
		//transportTask.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//transportTask.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(transportTaskTrackListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(transportTaskTrackListSize,currentPage,rowsPerPage) ;
			transportTaskTrackList = transportTaskTrackList.subListOf(fromIndex, toIndex);
			transportTaskTrackList.setTotalCount(count);
			transportTaskTrackList.setCurrentPageNumber(currentPage);			
			transportTask.setTransportTaskTrackList(transportTaskTrackList);
			return transportTask;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		transportTaskTrackList 
			= getTransportTaskTrackDAO().findTransportTaskTrackByMovement(transportTask.getId(),start, rowsPerPage, options );
		transportTaskTrackList.setTotalCount(count);
		transportTaskTrackList.setCurrentPageNumber(currentPage);
		transportTask.setTransportTaskTrackList(transportTaskTrackList );	

		return transportTask;
	}			
		


	protected String getTableName(){
		return TransportTaskTable.TABLE_NAME;
	}
}


