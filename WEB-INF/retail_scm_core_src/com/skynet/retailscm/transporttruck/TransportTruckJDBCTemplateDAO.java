
package com.skynet.retailscm.transporttruck;

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

public class TransportTruckJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TransportTruckDAO{
 
 	
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
	protected TransportTruck load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTruck(accessKey, options);
	}
	*/
	public TransportTruck load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTruck(TransportTruckTable.withId(id), options);
	}
	
	
	
	public TransportTruck save(TransportTruck transportTruck,Map<String,Object> options){
		
		String methodName="save(TransportTruck transportTruck,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportTruck, methodName, "transportTruck");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportTruck(transportTruck,options);
	}
	public TransportTruck clone(String transportTruckId, Map<String,Object> options) throws Exception{
	
		return clone(TransportTruckTable.withId(transportTruckId),options);
	}
	
	protected TransportTruck clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportTruckId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportTruck newTransportTruck = loadInternalTransportTruck(accessKey, options);
		newTransportTruck.setVersion(0);
		
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newTransportTruck.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransportTruck(newTransportTruck,options);
		
		return newTransportTruck;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String transportTruckId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{transportTruckId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TransportTruckVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTruckNotFoundException(
					"The " + this.getTableName() + "(" + transportTruckId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String transportTruckId, int version) throws Exception{
	
		String methodName="delete(String transportTruckId, int version)";
		assertMethodArgumentNotNull(transportTruckId, methodName, "transportTruckId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTruckId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTruckId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","plate_number","contact_number","vehicle_license_number","engine_number","make_date","mileage","body_color","owner"};
		return TransportTruckTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_truck";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTruckTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTruckTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTruckTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TransportTruckTokens.TRANSPORT_TASK_LIST);
		
 	}

	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportTruckTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
 	
			
		

	

	protected TransportTruckMapper getTransportTruckMapper(){
		return new TransportTruckMapper();
	}
	protected TransportTruck extractTransportTruck(String transportTruckId) throws Exception{
		String SQL = "select * from transport_truck_data where id = ?";	
		try{
		
			TransportTruck transportTruck = queryForObject(SQL, new Object[]{transportTruckId}, getTransportTruckMapper());
			return transportTruck;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTruckNotFoundException("TransportTruck("+transportTruckId+") is not found!");
		}
		
		
	}
	protected TransportTruck extractTransportTruck(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from transport_truck_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TransportTruck transportTruck = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTransportTruckMapper());
			return transportTruck;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTruckNotFoundException("TransportTruck("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TransportTruck loadInternalTransportTruck(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTruck transportTruck = extractTransportTruck(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(transportTruck, loadOptions);
 		}
 
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(transportTruck, loadOptions);
 		}		
		
		return transportTruck;
		
	}



	
	
	 

 	protected TransportTruck extractOwner(TransportTruck transportTruck, Map<String,Object> options) throws Exception{

		if(transportTruck.getOwner() == null){
			return transportTruck;
		}
		String ownerId = transportTruck.getOwner().getId();
		if( ownerId == null){
			return transportTruck;
		}
		TransportFleet owner = getTransportFleetDAO().load(ownerId,options);
		if(owner != null){
			transportTruck.setOwner(owner);
		}
		
 		
 		return transportTruck;
 	}
 		
 
		
	protected TransportTruck extractTransportTaskList(TransportTruck transportTruck, Map<String,Object> options){
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByTruck(transportTruck.getId(),options);
		if(transportTaskList != null){
			transportTruck.setTransportTaskList(transportTaskList);
		}
		
		return transportTruck;
	
	}	
		
		
  	
 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<TransportTruck> transportTruckList = queryForList(SQL, new Object[]{transportFleetId}, getTransportTruckMapper());	
 		return transportTruckList;
 	}
 	
 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TransportTruck> transportTruckList = queryForList(SQL, new Object[]{transportFleetId,start, count}, getTransportTruckMapper());
		
 		return transportTruckList;
 	}
 	
 	public int countTransportTruckByOwner(String transportFleetId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{transportFleetId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TransportTruck saveTransportTruck(TransportTruck  transportTruck){
	
		String SQL=this.getSaveTransportTruckSQL(transportTruck);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTruckParameters(transportTruck);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportTruck.incVersion();
		return transportTruck;
	
	}
	public SmartList<TransportTruck> saveTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTruckList(transportTruckList);
		
		batchTransportTruckCreate((List<TransportTruck>)lists[CREATE_LIST_INDEX]);
		
		batchTransportTruckUpdate((List<TransportTruck>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportTruck transportTruck:transportTruckList){
			if(transportTruck.isChanged()){
				transportTruck.incVersion();
			}
			
		
		}
		
		
		return transportTruckList;
	}

	public SmartList<TransportTruck> removeTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options){
		
		
		super.removeList(transportTruckList, options);
		
		return transportTruckList;
		
		
	}
	
	protected List<Object[]> prepareTransportTruckBatchCreateArgs(List<TransportTruck> transportTruckList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTruck transportTruck:transportTruckList ){
			Object [] parameters = prepareTransportTruckCreateParameters(transportTruck);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportTruckBatchUpdateArgs(List<TransportTruck> transportTruckList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTruck transportTruck:transportTruckList ){
			if(!transportTruck.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTruckUpdateParameters(transportTruck);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportTruckCreate(List<TransportTruck> transportTruckList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTruckBatchCreateArgs(transportTruckList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportTruckUpdate(List<TransportTruck> transportTruckList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTruckBatchUpdateArgs(transportTruckList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportTruckList(List<TransportTruck> transportTruckList){
		
		List<TransportTruck> transportTruckCreateList=new ArrayList<TransportTruck>();
		List<TransportTruck> transportTruckUpdateList=new ArrayList<TransportTruck>();
		
		for(TransportTruck transportTruck: transportTruckList){
			if(isUpdateRequest(transportTruck)){
				transportTruckUpdateList.add( transportTruck);
				continue;
			}
			transportTruckCreateList.add(transportTruck);
		}
		
		return new Object[]{transportTruckCreateList,transportTruckUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportTruck transportTruck){
 		return transportTruck.getVersion() > 0;
 	}
 	protected String getSaveTransportTruckSQL(TransportTruck transportTruck){
 		if(isUpdateRequest(transportTruck)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportTruckParameters(TransportTruck transportTruck){
 		if(isUpdateRequest(transportTruck) ){
 			return prepareTransportTruckUpdateParameters(transportTruck);
 		}
 		return prepareTransportTruckCreateParameters(transportTruck);
 	}
 	protected Object[] prepareTransportTruckUpdateParameters(TransportTruck transportTruck){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = transportTruck.getName();
 		parameters[1] = transportTruck.getPlateNumber();
 		parameters[2] = transportTruck.getContactNumber();
 		parameters[3] = transportTruck.getVehicleLicenseNumber();
 		parameters[4] = transportTruck.getEngineNumber();
 		parameters[5] = transportTruck.getMakeDate();
 		parameters[6] = transportTruck.getMileage();
 		parameters[7] = transportTruck.getBodyColor(); 	
 		if(transportTruck.getOwner() != null){
 			parameters[8] = transportTruck.getOwner().getId();
 		}
 		
 		parameters[9] = transportTruck.getId();
 		parameters[10] = transportTruck.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportTruckCreateParameters(TransportTruck transportTruck){
		Object[] parameters = new Object[10];
		String newTransportTruckId=getNextId();
		transportTruck.setId(newTransportTruckId);
		parameters[0] =  transportTruck.getId();
 
 		parameters[1] = transportTruck.getName();
 		parameters[2] = transportTruck.getPlateNumber();
 		parameters[3] = transportTruck.getContactNumber();
 		parameters[4] = transportTruck.getVehicleLicenseNumber();
 		parameters[5] = transportTruck.getEngineNumber();
 		parameters[6] = transportTruck.getMakeDate();
 		parameters[7] = transportTruck.getMileage();
 		parameters[8] = transportTruck.getBodyColor(); 	
 		if(transportTruck.getOwner() != null){
 			parameters[9] = transportTruck.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TransportTruck saveInternalTransportTruck(TransportTruck transportTruck, Map<String,Object> options){
		
		saveTransportTruck(transportTruck);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(transportTruck, options);
 		}
 
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(transportTruck, options);
	 		removeTransportTaskList(transportTruck, options);
	 		
 		}		
		
		return transportTruck;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportTruck saveOwner(TransportTruck transportTruck, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTruck.getOwner() == null){
 			return transportTruck;//do nothing when it is null
 		}
 		
 		getTransportFleetDAO().save(transportTruck.getOwner(),options);
 		return transportTruck;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected TransportTruck saveTransportTaskList(TransportTruck transportTruck, Map<String,Object> options){
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();
		if(transportTaskList == null){
			return transportTruck;
		}
		if(transportTaskList.isEmpty()){
			return transportTruck;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTransportTaskDAO().saveTransportTaskList(transportTaskList,options);
		
		return transportTruck;
	
	}
	
	protected TransportTruck removeTransportTaskList(TransportTruck transportTruck, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();
		if(transportTaskList == null){
			return transportTruck;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return transportTruck;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return transportTruck;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return transportTruck;
	
	}
	
	
	
 	
 	
	
	
	
		

	public TransportTruck present(TransportTruck transportTruck,Map<String, Object> options){
	
		presentTransportTaskList(transportTruck,options);

		return transportTruck;
	
	}
		
	
  	
 	protected TransportTruck presentTransportTaskList(
			TransportTruck transportTruck,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = transportTruck.getTransportTaskList();		
		if(transportTaskList == null){
			return transportTruck;			
		}
		
		String targetObjectName = "transportTask";
		int transportTaskListSize = transportTaskList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(transportTaskListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return transportTruck;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = transportTaskListSize;
		if(transportTaskListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTransportTaskDAO().countTransportTaskByTruck(transportTruck.getId(), options);			
		}
		//transportTruck.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//transportTruck.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(transportTaskListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(transportTaskListSize,currentPage,rowsPerPage) ;
			transportTaskList = transportTaskList.subListOf(fromIndex, toIndex);
			transportTaskList.setTotalCount(count);
			transportTaskList.setCurrentPageNumber(currentPage);			
			transportTruck.setTransportTaskList(transportTaskList);
			return transportTruck;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		transportTaskList 
			= getTransportTaskDAO().findTransportTaskByTruck(transportTruck.getId(),start, rowsPerPage, options );
		transportTaskList.setTotalCount(count);
		transportTaskList.setCurrentPageNumber(currentPage);
		transportTruck.setTransportTaskList(transportTaskList );	

		return transportTruck;
	}			
		


	protected String getTableName(){
		return TransportTruckTable.TABLE_NAME;
	}
}


