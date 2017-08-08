
package com.skynet.retailscm.truckdriver;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttask.TransportTask;

import com.skynet.retailscm.transportfleet.TransportFleetDAO;
import com.skynet.retailscm.transporttask.TransportTaskDAO;

import com.skynet.retailscm.transportfleet.TransportFleetTable;
import com.skynet.retailscm.transporttask.TransportTaskTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class TruckDriverJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TruckDriverDAO{
 
 	
 	private  TransportFleetDAO  transportFleetDAO;
 	public void setTransportFleetDAO(TransportFleetDAO transportFleetDAO){
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	public TransportFleetDAO getTransportFleetDAO(){
	 	return this.transportFleetDAO;
 	}

		
	
  	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO pTransportTaskDAO){
 	
 		if(pTransportTaskDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskDAO to null.");
 		}
	 	this.transportTaskDAO = pTransportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
 		if(this.transportTaskDAO == null){
 			throw new IllegalStateException("The transportTaskDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskDAO;
 	}	
 	
			
		

	
	/*
	protected TruckDriver load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTruckDriver(accessKey, options);
	}
	*/
	public TruckDriver load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTruckDriver(TruckDriverTable.withId(id), options);
	}
	
	
	
	public TruckDriver save(TruckDriver truckDriver,Map<String,Object> options){
		
		String methodName="save(TruckDriver truckDriver,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(truckDriver, methodName, "truckDriver");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTruckDriver(truckDriver,options);
	}
	public TruckDriver clone(String truckDriverId, Map<String,Object> options) throws Exception{
	
		return clone(TruckDriverTable.withId(truckDriverId),options);
	}
	
	protected TruckDriver clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String truckDriverId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TruckDriver newTruckDriver = loadInternalTruckDriver(accessKey, options);
		newTruckDriver.setVersion(0);
		
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newTruckDriver.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTruckDriver(newTruckDriver,options);
		
		return newTruckDriver;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String truckDriverId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{truckDriverId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TruckDriverVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TruckDriverNotFoundException(
					"The " + this.getTableName() + "(" + truckDriverId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String truckDriverId, int version) throws Exception{
	
		String methodName="delete(String truckDriverId, int version)";
		assertMethodArgumentNotNull(truckDriverId, methodName, "truckDriverId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{truckDriverId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(truckDriverId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","driver_license_number","contact_number","belongs_to"};
		return TruckDriverTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "truck_driver";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TruckDriverTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TruckDriverTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TruckDriverTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TruckDriverTokens.TRANSPORT_TASK_LIST);
		
 	}

	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, TruckDriverTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
 	
			
		

	

	protected TruckDriverMapper getTruckDriverMapper(){
		return new TruckDriverMapper();
	}
	protected TruckDriver extractTruckDriver(String truckDriverId) throws Exception{
		String SQL = "select * from truck_driver_data where id = ?";	
		try{
		
			TruckDriver truckDriver = queryForObject(SQL, new Object[]{truckDriverId}, getTruckDriverMapper());
			return truckDriver;
		}catch(EmptyResultDataAccessException e){
			throw new TruckDriverNotFoundException("TruckDriver("+truckDriverId+") is not found!");
		}
		
		
	}
	protected TruckDriver extractTruckDriver(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from truck_driver_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TruckDriver truckDriver = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTruckDriverMapper());
			return truckDriver;
		}catch(EmptyResultDataAccessException e){
			throw new TruckDriverNotFoundException("TruckDriver("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TruckDriver loadInternalTruckDriver(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TruckDriver truckDriver = extractTruckDriver(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(truckDriver, loadOptions);
 		}
 
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(truckDriver, loadOptions);
 		}		
		
		return truckDriver;
		
	}



	
	
	 

 	protected TruckDriver extractBelongsTo(TruckDriver truckDriver, Map<String,Object> options) throws Exception{

		if(truckDriver.getBelongsTo() == null){
			return truckDriver;
		}
		String belongsToId = truckDriver.getBelongsTo().getId();
		if( belongsToId == null){
			return truckDriver;
		}
		TransportFleet belongsTo = getTransportFleetDAO().load(belongsToId,options);
		if(belongsTo != null){
			truckDriver.setBelongsTo(belongsTo);
		}
		
 		
 		return truckDriver;
 	}
 		
 
		
	protected TruckDriver extractTransportTaskList(TruckDriver truckDriver, Map<String,Object> options){
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByDriver(truckDriver.getId(),options);
		if(transportTaskList != null){
			truckDriver.setTransportTaskList(transportTaskList);
		}
		
		return truckDriver;
	
	}	
		
		
  	
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<TruckDriver> truckDriverList = queryForList(SQL, new Object[]{transportFleetId}, getTruckDriverMapper());	
 		return truckDriverList;
 	}
 	
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TruckDriver> truckDriverList = queryForList(SQL, new Object[]{transportFleetId,start, count}, getTruckDriverMapper());
		
 		return truckDriverList;
 	}
 	
 	public int countTruckDriverByBelongsTo(String transportFleetId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{transportFleetId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TruckDriver saveTruckDriver(TruckDriver  truckDriver){
	
		String SQL=this.getSaveTruckDriverSQL(truckDriver);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTruckDriverParameters(truckDriver);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		truckDriver.incVersion();
		return truckDriver;
	
	}
	public SmartList<TruckDriver> saveTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTruckDriverList(truckDriverList);
		
		batchTruckDriverCreate((List<TruckDriver>)lists[CREATE_LIST_INDEX]);
		
		batchTruckDriverUpdate((List<TruckDriver>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TruckDriver truckDriver:truckDriverList){
			if(truckDriver.isChanged()){
				truckDriver.incVersion();
			}
			
		
		}
		
		
		return truckDriverList;
	}

	public SmartList<TruckDriver> removeTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options){
		
		
		super.removeList(truckDriverList, options);
		
		return truckDriverList;
		
		
	}
	
	protected List<Object[]> prepareTruckDriverBatchCreateArgs(List<TruckDriver> truckDriverList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TruckDriver truckDriver:truckDriverList ){
			Object [] parameters = prepareTruckDriverCreateParameters(truckDriver);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTruckDriverBatchUpdateArgs(List<TruckDriver> truckDriverList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TruckDriver truckDriver:truckDriverList ){
			if(!truckDriver.isChanged()){
				continue;
			}
			Object [] parameters = prepareTruckDriverUpdateParameters(truckDriver);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTruckDriverCreate(List<TruckDriver> truckDriverList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTruckDriverBatchCreateArgs(truckDriverList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTruckDriverUpdate(List<TruckDriver> truckDriverList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTruckDriverBatchUpdateArgs(truckDriverList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTruckDriverList(List<TruckDriver> truckDriverList){
		
		List<TruckDriver> truckDriverCreateList=new ArrayList<TruckDriver>();
		List<TruckDriver> truckDriverUpdateList=new ArrayList<TruckDriver>();
		
		for(TruckDriver truckDriver: truckDriverList){
			if(isUpdateRequest(truckDriver)){
				truckDriverUpdateList.add( truckDriver);
				continue;
			}
			truckDriverCreateList.add(truckDriver);
		}
		
		return new Object[]{truckDriverCreateList,truckDriverUpdateList};
	}
	
	protected boolean isUpdateRequest(TruckDriver truckDriver){
 		return truckDriver.getVersion() > 0;
 	}
 	protected String getSaveTruckDriverSQL(TruckDriver truckDriver){
 		if(isUpdateRequest(truckDriver)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTruckDriverParameters(TruckDriver truckDriver){
 		if(isUpdateRequest(truckDriver) ){
 			return prepareTruckDriverUpdateParameters(truckDriver);
 		}
 		return prepareTruckDriverCreateParameters(truckDriver);
 	}
 	protected Object[] prepareTruckDriverUpdateParameters(TruckDriver truckDriver){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = truckDriver.getName();
 		parameters[1] = truckDriver.getDriverLicenseNumber();
 		parameters[2] = truckDriver.getContactNumber(); 	
 		if(truckDriver.getBelongsTo() != null){
 			parameters[3] = truckDriver.getBelongsTo().getId();
 		}
 		
 		parameters[4] = truckDriver.getId();
 		parameters[5] = truckDriver.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTruckDriverCreateParameters(TruckDriver truckDriver){
		Object[] parameters = new Object[5];
		String newTruckDriverId=getNextId();
		truckDriver.setId(newTruckDriverId);
		parameters[0] =  truckDriver.getId();
 
 		parameters[1] = truckDriver.getName();
 		parameters[2] = truckDriver.getDriverLicenseNumber();
 		parameters[3] = truckDriver.getContactNumber(); 	
 		if(truckDriver.getBelongsTo() != null){
 			parameters[4] = truckDriver.getBelongsTo().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TruckDriver saveInternalTruckDriver(TruckDriver truckDriver, Map<String,Object> options){
		
		saveTruckDriver(truckDriver);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(truckDriver, options);
 		}
 
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(truckDriver, options);
	 		removeTransportTaskList(truckDriver, options);
	 		
 		}		
		
		return truckDriver;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TruckDriver saveBelongsTo(TruckDriver truckDriver, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(truckDriver.getBelongsTo() == null){
 			return truckDriver;//do nothing when it is null
 		}
 		
 		getTransportFleetDAO().save(truckDriver.getBelongsTo(),options);
 		return truckDriver;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected TruckDriver saveTransportTaskList(TruckDriver truckDriver, Map<String,Object> options){
		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		if(transportTaskList == null){
			return truckDriver;
		}
		if(transportTaskList.isEmpty()){
			return truckDriver;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTransportTaskDAO().saveTransportTaskList(transportTaskList,options);
		
		return truckDriver;
	
	}
	
	protected TruckDriver removeTransportTaskList(TruckDriver truckDriver, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();
		if(transportTaskList == null){
			return truckDriver;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return truckDriver;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return truckDriver;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return truckDriver;
	
	}
	
	
	
 	
 	
	
	
	
		

	public TruckDriver present(TruckDriver truckDriver,Map<String, Object> options){
	
		presentTransportTaskList(truckDriver,options);

		return truckDriver;
	
	}
		
	
  	
 	protected TruckDriver presentTransportTaskList(
			TruckDriver truckDriver,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = truckDriver.getTransportTaskList();		
		if(transportTaskList == null){
			return truckDriver;			
		}
		
		String targetObjectName = "transportTask";
		int transportTaskListSize = transportTaskList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(transportTaskListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return truckDriver;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = transportTaskListSize;
		if(transportTaskListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTransportTaskDAO().countTransportTaskByDriver(truckDriver.getId(), options);			
		}
		//truckDriver.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//truckDriver.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(transportTaskListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(transportTaskListSize,currentPage,rowsPerPage) ;
			transportTaskList = transportTaskList.subListOf(fromIndex, toIndex);
			transportTaskList.setTotalCount(count);
			transportTaskList.setCurrentPageNumber(currentPage);			
			truckDriver.setTransportTaskList(transportTaskList);
			return truckDriver;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		transportTaskList 
			= getTransportTaskDAO().findTransportTaskByDriver(truckDriver.getId(),start, rowsPerPage, options );
		transportTaskList.setTotalCount(count);
		transportTaskList.setCurrentPageNumber(currentPage);
		truckDriver.setTransportTaskList(transportTaskList );	

		return truckDriver;
	}			
		


	protected String getTableName(){
		return TruckDriverTable.TABLE_NAME;
	}
}


