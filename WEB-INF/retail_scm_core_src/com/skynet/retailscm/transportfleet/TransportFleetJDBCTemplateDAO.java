
package com.skynet.retailscm.transportfleet;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.truckdriver.TruckDriver;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.truckdriver.TruckDriverDAO;
import com.skynet.retailscm.transporttruck.TransportTruckDAO;
import com.skynet.retailscm.transporttask.TransportTaskDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.truckdriver.TruckDriverTable;
import com.skynet.retailscm.transporttruck.TransportTruckTable;
import com.skynet.retailscm.transporttask.TransportTaskTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class TransportFleetJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TransportFleetDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  TransportTruckDAO  transportTruckDAO;
 	public void setTransportTruckDAO(TransportTruckDAO pTransportTruckDAO){
 	
 		if(pTransportTruckDAO == null){
 			throw new IllegalStateException("Do not try to set transportTruckDAO to null.");
 		}
	 	this.transportTruckDAO = pTransportTruckDAO;
 	}
 	public TransportTruckDAO getTransportTruckDAO(){
 		if(this.transportTruckDAO == null){
 			throw new IllegalStateException("The transportTruckDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTruckDAO;
 	}	
 	
			
		
	
  	private  TruckDriverDAO  truckDriverDAO;
 	public void setTruckDriverDAO(TruckDriverDAO pTruckDriverDAO){
 	
 		if(pTruckDriverDAO == null){
 			throw new IllegalStateException("Do not try to set truckDriverDAO to null.");
 		}
	 	this.truckDriverDAO = pTruckDriverDAO;
 	}
 	public TruckDriverDAO getTruckDriverDAO(){
 		if(this.truckDriverDAO == null){
 			throw new IllegalStateException("The truckDriverDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.truckDriverDAO;
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
	protected TransportFleet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportFleet(accessKey, options);
	}
	*/
	public TransportFleet load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportFleet(TransportFleetTable.withId(id), options);
	}
	
	
	
	public TransportFleet save(TransportFleet transportFleet,Map<String,Object> options){
		
		String methodName="save(TransportFleet transportFleet,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportFleet, methodName, "transportFleet");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportFleet(transportFleet,options);
	}
	public TransportFleet clone(String transportFleetId, Map<String,Object> options) throws Exception{
	
		return clone(TransportFleetTable.withId(transportFleetId),options);
	}
	
	protected TransportFleet clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportFleetId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportFleet newTransportFleet = loadInternalTransportFleet(accessKey, options);
		newTransportFleet.setVersion(0);
		
		
 		
 		if(isSaveTransportTruckListEnabled(options)){
 			for(TransportTruck item: newTransportFleet.getTransportTruckList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTruckDriverListEnabled(options)){
 			for(TruckDriver item: newTransportFleet.getTruckDriverList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newTransportFleet.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTransportFleet(newTransportFleet,options);
		
		return newTransportFleet;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String transportFleetId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{transportFleetId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TransportFleetVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportFleetNotFoundException(
					"The " + this.getTableName() + "(" + transportFleetId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String transportFleetId, int version) throws Exception{
	
		String methodName="delete(String transportFleetId, int version)";
		assertMethodArgumentNotNull(transportFleetId, methodName, "transportFleetId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportFleetId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportFleetId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","contact_number","owner"};
		return TransportFleetTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_fleet";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportFleetTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportFleetTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportFleetTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String TRANSPORT_TRUCK_LIST = "transportTruckList";
	
	protected boolean isExtractTransportTruckListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TransportFleetTokens.TRANSPORT_TRUCK_LIST);
		
 	}

	protected boolean isSaveTransportTruckListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportFleetTokens.TRANSPORT_TRUCK_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TRUCK_DRIVER_LIST = "truckDriverList";
	
	protected boolean isExtractTruckDriverListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TransportFleetTokens.TRUCK_DRIVER_LIST);
		
 	}

	protected boolean isSaveTruckDriverListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportFleetTokens.TRUCK_DRIVER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TransportFleetTokens.TRANSPORT_TASK_LIST);
		
 	}

	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, TransportFleetTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
 	
			
		

	

	protected TransportFleetMapper getTransportFleetMapper(){
		return new TransportFleetMapper();
	}
	protected TransportFleet extractTransportFleet(String transportFleetId) throws Exception{
		String SQL = "select * from transport_fleet_data where id = ?";	
		try{
		
			TransportFleet transportFleet = queryForObject(SQL, new Object[]{transportFleetId}, getTransportFleetMapper());
			return transportFleet;
		}catch(EmptyResultDataAccessException e){
			throw new TransportFleetNotFoundException("TransportFleet("+transportFleetId+") is not found!");
		}
		
		
	}
	protected TransportFleet extractTransportFleet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from transport_fleet_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TransportFleet transportFleet = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTransportFleetMapper());
			return transportFleet;
		}catch(EmptyResultDataAccessException e){
			throw new TransportFleetNotFoundException("TransportFleet("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TransportFleet loadInternalTransportFleet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportFleet transportFleet = extractTransportFleet(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(transportFleet, loadOptions);
 		}
 
		
		if(isExtractTransportTruckListEnabled(loadOptions)){
	 		extractTransportTruckList(transportFleet, loadOptions);
 		}		
		
		if(isExtractTruckDriverListEnabled(loadOptions)){
	 		extractTruckDriverList(transportFleet, loadOptions);
 		}		
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(transportFleet, loadOptions);
 		}		
		
		return transportFleet;
		
	}



	
	
	 

 	protected TransportFleet extractOwner(TransportFleet transportFleet, Map<String,Object> options) throws Exception{

		if(transportFleet.getOwner() == null){
			return transportFleet;
		}
		String ownerId = transportFleet.getOwner().getId();
		if( ownerId == null){
			return transportFleet;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			transportFleet.setOwner(owner);
		}
		
 		
 		return transportFleet;
 	}
 		
 
		
	protected TransportFleet extractTransportTruckList(TransportFleet transportFleet, Map<String,Object> options){
		
		SmartList<TransportTruck> transportTruckList = getTransportTruckDAO().findTransportTruckByOwner(transportFleet.getId(),options);
		if(transportTruckList != null){
			transportFleet.setTransportTruckList(transportTruckList);
		}
		
		return transportFleet;
	
	}	
		
	protected TransportFleet extractTruckDriverList(TransportFleet transportFleet, Map<String,Object> options){
		
		SmartList<TruckDriver> truckDriverList = getTruckDriverDAO().findTruckDriverByBelongsTo(transportFleet.getId(),options);
		if(truckDriverList != null){
			transportFleet.setTruckDriverList(truckDriverList);
		}
		
		return transportFleet;
	
	}	
		
	protected TransportFleet extractTransportTaskList(TransportFleet transportFleet, Map<String,Object> options){
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByBelongsTo(transportFleet.getId(),options);
		if(transportTaskList != null){
			transportFleet.setTransportTaskList(transportTaskList);
		}
		
		return transportFleet;
	
	}	
		
		
  	
 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<TransportFleet> transportFleetList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getTransportFleetMapper());	
 		return transportFleetList;
 	}
 	
 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TransportFleet> transportFleetList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getTransportFleetMapper());
		
 		return transportFleetList;
 	}
 	
 	public int countTransportFleetByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TransportFleet saveTransportFleet(TransportFleet  transportFleet){
	
		String SQL=this.getSaveTransportFleetSQL(transportFleet);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportFleetParameters(transportFleet);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportFleet.incVersion();
		return transportFleet;
	
	}
	public SmartList<TransportFleet> saveTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportFleetList(transportFleetList);
		
		batchTransportFleetCreate((List<TransportFleet>)lists[CREATE_LIST_INDEX]);
		
		batchTransportFleetUpdate((List<TransportFleet>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportFleet transportFleet:transportFleetList){
			if(transportFleet.isChanged()){
				transportFleet.incVersion();
			}
			
		
		}
		
		
		return transportFleetList;
	}

	public SmartList<TransportFleet> removeTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options){
		
		
		super.removeList(transportFleetList, options);
		
		return transportFleetList;
		
		
	}
	
	protected List<Object[]> prepareTransportFleetBatchCreateArgs(List<TransportFleet> transportFleetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportFleet transportFleet:transportFleetList ){
			Object [] parameters = prepareTransportFleetCreateParameters(transportFleet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportFleetBatchUpdateArgs(List<TransportFleet> transportFleetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportFleet transportFleet:transportFleetList ){
			if(!transportFleet.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportFleetUpdateParameters(transportFleet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportFleetCreate(List<TransportFleet> transportFleetList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportFleetBatchCreateArgs(transportFleetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportFleetUpdate(List<TransportFleet> transportFleetList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportFleetBatchUpdateArgs(transportFleetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportFleetList(List<TransportFleet> transportFleetList){
		
		List<TransportFleet> transportFleetCreateList=new ArrayList<TransportFleet>();
		List<TransportFleet> transportFleetUpdateList=new ArrayList<TransportFleet>();
		
		for(TransportFleet transportFleet: transportFleetList){
			if(isUpdateRequest(transportFleet)){
				transportFleetUpdateList.add( transportFleet);
				continue;
			}
			transportFleetCreateList.add(transportFleet);
		}
		
		return new Object[]{transportFleetCreateList,transportFleetUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportFleet transportFleet){
 		return transportFleet.getVersion() > 0;
 	}
 	protected String getSaveTransportFleetSQL(TransportFleet transportFleet){
 		if(isUpdateRequest(transportFleet)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportFleetParameters(TransportFleet transportFleet){
 		if(isUpdateRequest(transportFleet) ){
 			return prepareTransportFleetUpdateParameters(transportFleet);
 		}
 		return prepareTransportFleetCreateParameters(transportFleet);
 	}
 	protected Object[] prepareTransportFleetUpdateParameters(TransportFleet transportFleet){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = transportFleet.getName();
 		parameters[1] = transportFleet.getContactNumber(); 	
 		if(transportFleet.getOwner() != null){
 			parameters[2] = transportFleet.getOwner().getId();
 		}
 		
 		parameters[3] = transportFleet.getId();
 		parameters[4] = transportFleet.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportFleetCreateParameters(TransportFleet transportFleet){
		Object[] parameters = new Object[4];
		String newTransportFleetId=getNextId();
		transportFleet.setId(newTransportFleetId);
		parameters[0] =  transportFleet.getId();
 
 		parameters[1] = transportFleet.getName();
 		parameters[2] = transportFleet.getContactNumber(); 	
 		if(transportFleet.getOwner() != null){
 			parameters[3] = transportFleet.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TransportFleet saveInternalTransportFleet(TransportFleet transportFleet, Map<String,Object> options){
		
		saveTransportFleet(transportFleet);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(transportFleet, options);
 		}
 
		
		if(isSaveTransportTruckListEnabled(options)){
	 		saveTransportTruckList(transportFleet, options);
	 		removeTransportTruckList(transportFleet, options);
	 		
 		}		
		
		if(isSaveTruckDriverListEnabled(options)){
	 		saveTruckDriverList(transportFleet, options);
	 		removeTruckDriverList(transportFleet, options);
	 		
 		}		
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(transportFleet, options);
	 		removeTransportTaskList(transportFleet, options);
	 		
 		}		
		
		return transportFleet;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportFleet saveOwner(TransportFleet transportFleet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportFleet.getOwner() == null){
 			return transportFleet;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(transportFleet.getOwner(),options);
 		return transportFleet;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected TransportFleet saveTransportTruckList(TransportFleet transportFleet, Map<String,Object> options){
		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
		if(transportTruckList == null){
			return transportFleet;
		}
		if(transportTruckList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTransportTruckDAO().saveTransportTruckList(transportTruckList,options);
		
		return transportFleet;
	
	}
	
	protected TransportFleet removeTransportTruckList(TransportFleet transportFleet, Map<String,Object> options){
	
	
		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();
		if(transportTruckList == null){
			return transportFleet;
		}	
	
		SmartList<TransportTruck> toRemoveTransportTruckList = transportTruckList.getToRemoveList();
		
		if(toRemoveTransportTruckList == null){
			return transportFleet;
		}
		if(toRemoveTransportTruckList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTruckDAO().removeTransportTruckList(toRemoveTransportTruckList,options);
		
		return transportFleet;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected TransportFleet saveTruckDriverList(TransportFleet transportFleet, Map<String,Object> options){
		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
		if(truckDriverList == null){
			return transportFleet;
		}
		if(truckDriverList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTruckDriverDAO().saveTruckDriverList(truckDriverList,options);
		
		return transportFleet;
	
	}
	
	protected TransportFleet removeTruckDriverList(TransportFleet transportFleet, Map<String,Object> options){
	
	
		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();
		if(truckDriverList == null){
			return transportFleet;
		}	
	
		SmartList<TruckDriver> toRemoveTruckDriverList = truckDriverList.getToRemoveList();
		
		if(toRemoveTruckDriverList == null){
			return transportFleet;
		}
		if(toRemoveTruckDriverList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTruckDriverDAO().removeTruckDriverList(toRemoveTruckDriverList,options);
		
		return transportFleet;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected TransportFleet saveTransportTaskList(TransportFleet transportFleet, Map<String,Object> options){
		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		if(transportTaskList == null){
			return transportFleet;
		}
		if(transportTaskList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTransportTaskDAO().saveTransportTaskList(transportTaskList,options);
		
		return transportFleet;
	
	}
	
	protected TransportFleet removeTransportTaskList(TransportFleet transportFleet, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();
		if(transportTaskList == null){
			return transportFleet;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return transportFleet;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return transportFleet;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return transportFleet;
	
	}
	
	
	
 	
 	
	
	
	
		

	public TransportFleet present(TransportFleet transportFleet,Map<String, Object> options){
	
		presentTransportTruckList(transportFleet,options);
		presentTruckDriverList(transportFleet,options);
		presentTransportTaskList(transportFleet,options);

		return transportFleet;
	
	}
		
	
  	
 	protected TransportFleet presentTransportTruckList(
			TransportFleet transportFleet,
			Map<String, Object> options) {

		SmartList<TransportTruck> transportTruckList = transportFleet.getTransportTruckList();		
		if(transportTruckList == null){
			return transportFleet;			
		}
		
		String targetObjectName = "transportTruck";
		int transportTruckListSize = transportTruckList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(transportTruckListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return transportFleet;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = transportTruckListSize;
		if(transportTruckListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTransportTruckDAO().countTransportTruckByOwner(transportFleet.getId(), options);			
		}
		//transportFleet.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//transportFleet.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(transportTruckListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(transportTruckListSize,currentPage,rowsPerPage) ;
			transportTruckList = transportTruckList.subListOf(fromIndex, toIndex);
			transportTruckList.setTotalCount(count);
			transportTruckList.setCurrentPageNumber(currentPage);			
			transportFleet.setTransportTruckList(transportTruckList);
			return transportFleet;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		transportTruckList 
			= getTransportTruckDAO().findTransportTruckByOwner(transportFleet.getId(),start, rowsPerPage, options );
		transportTruckList.setTotalCount(count);
		transportTruckList.setCurrentPageNumber(currentPage);
		transportFleet.setTransportTruckList(transportTruckList );	

		return transportFleet;
	}			
		
	
  	
 	protected TransportFleet presentTruckDriverList(
			TransportFleet transportFleet,
			Map<String, Object> options) {

		SmartList<TruckDriver> truckDriverList = transportFleet.getTruckDriverList();		
		if(truckDriverList == null){
			return transportFleet;			
		}
		
		String targetObjectName = "truckDriver";
		int truckDriverListSize = truckDriverList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(truckDriverListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return transportFleet;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = truckDriverListSize;
		if(truckDriverListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTruckDriverDAO().countTruckDriverByBelongsTo(transportFleet.getId(), options);			
		}
		//transportFleet.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//transportFleet.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(truckDriverListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(truckDriverListSize,currentPage,rowsPerPage) ;
			truckDriverList = truckDriverList.subListOf(fromIndex, toIndex);
			truckDriverList.setTotalCount(count);
			truckDriverList.setCurrentPageNumber(currentPage);			
			transportFleet.setTruckDriverList(truckDriverList);
			return transportFleet;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		truckDriverList 
			= getTruckDriverDAO().findTruckDriverByBelongsTo(transportFleet.getId(),start, rowsPerPage, options );
		truckDriverList.setTotalCount(count);
		truckDriverList.setCurrentPageNumber(currentPage);
		transportFleet.setTruckDriverList(truckDriverList );	

		return transportFleet;
	}			
		
	
  	
 	protected TransportFleet presentTransportTaskList(
			TransportFleet transportFleet,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = transportFleet.getTransportTaskList();		
		if(transportTaskList == null){
			return transportFleet;			
		}
		
		String targetObjectName = "transportTask";
		int transportTaskListSize = transportTaskList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(transportTaskListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return transportFleet;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = transportTaskListSize;
		if(transportTaskListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTransportTaskDAO().countTransportTaskByBelongsTo(transportFleet.getId(), options);			
		}
		//transportFleet.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//transportFleet.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(transportTaskListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(transportTaskListSize,currentPage,rowsPerPage) ;
			transportTaskList = transportTaskList.subListOf(fromIndex, toIndex);
			transportTaskList.setTotalCount(count);
			transportTaskList.setCurrentPageNumber(currentPage);			
			transportFleet.setTransportTaskList(transportTaskList);
			return transportFleet;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		transportTaskList 
			= getTransportTaskDAO().findTransportTaskByBelongsTo(transportFleet.getId(),start, rowsPerPage, options );
		transportTaskList.setTotalCount(count);
		transportTaskList.setCurrentPageNumber(currentPage);
		transportFleet.setTransportTaskList(transportTaskList );	

		return transportFleet;
	}			
		


	protected String getTableName(){
		return TransportFleetTable.TABLE_NAME;
	}
}


