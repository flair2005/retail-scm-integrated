
package com.skynet.retailscm.transporttasktrack;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.transporttask.TransportTask;

import com.skynet.retailscm.transporttask.TransportTaskDAO;

import com.skynet.retailscm.transporttask.TransportTaskTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class TransportTaskTrackJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TransportTaskTrackDAO{
 
 	
 	private  TransportTaskDAO  transportTaskDAO;
 	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
	 	return this.transportTaskDAO;
 	}

		

	
	/*
	protected TransportTaskTrack load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskTrack(accessKey, options);
	}
	*/
	public TransportTaskTrack load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTransportTaskTrack(TransportTaskTrackTable.withId(id), options);
	}
	
	
	
	public TransportTaskTrack save(TransportTaskTrack transportTaskTrack,Map<String,Object> options){
		
		String methodName="save(TransportTaskTrack transportTaskTrack,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(transportTaskTrack, methodName, "transportTaskTrack");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTransportTaskTrack(transportTaskTrack,options);
	}
	public TransportTaskTrack clone(String transportTaskTrackId, Map<String,Object> options) throws Exception{
	
		return clone(TransportTaskTrackTable.withId(transportTaskTrackId),options);
	}
	
	protected TransportTaskTrack clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String transportTaskTrackId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TransportTaskTrack newTransportTaskTrack = loadInternalTransportTaskTrack(accessKey, options);
		newTransportTaskTrack.setVersion(0);
		
		

		
		saveInternalTransportTaskTrack(newTransportTaskTrack,options);
		
		return newTransportTaskTrack;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String transportTaskTrackId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{transportTaskTrackId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TransportTaskTrackVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TransportTaskTrackNotFoundException(
					"The " + this.getTableName() + "(" + transportTaskTrackId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String transportTaskTrackId, int version) throws Exception{
	
		String methodName="delete(String transportTaskTrackId, int version)";
		assertMethodArgumentNotNull(transportTaskTrackId, methodName, "transportTaskTrackId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{transportTaskTrackId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(transportTaskTrackId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"track_time","latitude","longitude","movement"};
		return TransportTaskTrackTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "transport_task_track";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TransportTaskTrackTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractMovementEnabled = true;
 	//private static final String MOVEMENT = "movement";
 	protected boolean isExtractMovementEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TransportTaskTrackTokens.MOVEMENT);
 	}
 	
 	
 	//private boolean saveMovementEnabled = true;
 	protected boolean isSaveMovementEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TransportTaskTrackTokens.MOVEMENT);
 	}
 	

 	
 
		

	

	protected TransportTaskTrackMapper getTransportTaskTrackMapper(){
		return new TransportTaskTrackMapper();
	}
	protected TransportTaskTrack extractTransportTaskTrack(String transportTaskTrackId) throws Exception{
		String SQL = "select * from transport_task_track_data where id = ?";	
		try{
		
			TransportTaskTrack transportTaskTrack = queryForObject(SQL, new Object[]{transportTaskTrackId}, getTransportTaskTrackMapper());
			return transportTaskTrack;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskTrackNotFoundException("TransportTaskTrack("+transportTaskTrackId+") is not found!");
		}
		
		
	}
	protected TransportTaskTrack extractTransportTaskTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from transport_task_track_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TransportTaskTrack transportTaskTrack = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTransportTaskTrackMapper());
			return transportTaskTrack;
		}catch(EmptyResultDataAccessException e){
			throw new TransportTaskTrackNotFoundException("TransportTaskTrack("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TransportTaskTrack loadInternalTransportTaskTrack(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TransportTaskTrack transportTaskTrack = extractTransportTaskTrack(accessKey, loadOptions);
 	
 		if(isExtractMovementEnabled(loadOptions)){
	 		extractMovement(transportTaskTrack, loadOptions);
 		}
 
		
		return transportTaskTrack;
		
	}



	
	
	 

 	protected TransportTaskTrack extractMovement(TransportTaskTrack transportTaskTrack, Map<String,Object> options) throws Exception{

		if(transportTaskTrack.getMovement() == null){
			return transportTaskTrack;
		}
		String movementId = transportTaskTrack.getMovement().getId();
		if( movementId == null){
			return transportTaskTrack;
		}
		TransportTask movement = getTransportTaskDAO().load(movementId,options);
		if(movement != null){
			transportTaskTrack.setMovement(movement);
		}
		
 		
 		return transportTaskTrack;
 	}
 		
 
		
		
  	
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where movement = ?";
		SmartList<TransportTaskTrack> transportTaskTrackList = queryForList(SQL, new Object[]{transportTaskId}, getTransportTaskTrackMapper());	
 		return transportTaskTrackList;
 	}
 	
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where movement = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TransportTaskTrack> transportTaskTrackList = queryForList(SQL, new Object[]{transportTaskId,start, count}, getTransportTaskTrackMapper());
		
 		return transportTaskTrackList;
 	}
 	
 	public int countTransportTaskTrackByMovement(String transportTaskId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where movement = ?";
		Integer count = queryInt(SQL, new Object[]{transportTaskId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TransportTaskTrack saveTransportTaskTrack(TransportTaskTrack  transportTaskTrack){
	
		String SQL=this.getSaveTransportTaskTrackSQL(transportTaskTrack);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTransportTaskTrackParameters(transportTaskTrack);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		transportTaskTrack.incVersion();
		return transportTaskTrack;
	
	}
	public SmartList<TransportTaskTrack> saveTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTransportTaskTrackList(transportTaskTrackList);
		
		batchTransportTaskTrackCreate((List<TransportTaskTrack>)lists[CREATE_LIST_INDEX]);
		
		batchTransportTaskTrackUpdate((List<TransportTaskTrack>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			if(transportTaskTrack.isChanged()){
				transportTaskTrack.incVersion();
			}
			
		
		}
		
		
		return transportTaskTrackList;
	}

	public SmartList<TransportTaskTrack> removeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options){
		
		
		super.removeList(transportTaskTrackList, options);
		
		return transportTaskTrackList;
		
		
	}
	
	protected List<Object[]> prepareTransportTaskTrackBatchCreateArgs(List<TransportTaskTrack> transportTaskTrackList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList ){
			Object [] parameters = prepareTransportTaskTrackCreateParameters(transportTaskTrack);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTransportTaskTrackBatchUpdateArgs(List<TransportTaskTrack> transportTaskTrackList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TransportTaskTrack transportTaskTrack:transportTaskTrackList ){
			if(!transportTaskTrack.isChanged()){
				continue;
			}
			Object [] parameters = prepareTransportTaskTrackUpdateParameters(transportTaskTrack);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTransportTaskTrackCreate(List<TransportTaskTrack> transportTaskTrackList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTransportTaskTrackBatchCreateArgs(transportTaskTrackList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTransportTaskTrackUpdate(List<TransportTaskTrack> transportTaskTrackList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTransportTaskTrackBatchUpdateArgs(transportTaskTrackList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTransportTaskTrackList(List<TransportTaskTrack> transportTaskTrackList){
		
		List<TransportTaskTrack> transportTaskTrackCreateList=new ArrayList<TransportTaskTrack>();
		List<TransportTaskTrack> transportTaskTrackUpdateList=new ArrayList<TransportTaskTrack>();
		
		for(TransportTaskTrack transportTaskTrack: transportTaskTrackList){
			if(isUpdateRequest(transportTaskTrack)){
				transportTaskTrackUpdateList.add( transportTaskTrack);
				continue;
			}
			transportTaskTrackCreateList.add(transportTaskTrack);
		}
		
		return new Object[]{transportTaskTrackCreateList,transportTaskTrackUpdateList};
	}
	
	protected boolean isUpdateRequest(TransportTaskTrack transportTaskTrack){
 		return transportTaskTrack.getVersion() > 0;
 	}
 	protected String getSaveTransportTaskTrackSQL(TransportTaskTrack transportTaskTrack){
 		if(isUpdateRequest(transportTaskTrack)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTransportTaskTrackParameters(TransportTaskTrack transportTaskTrack){
 		if(isUpdateRequest(transportTaskTrack) ){
 			return prepareTransportTaskTrackUpdateParameters(transportTaskTrack);
 		}
 		return prepareTransportTaskTrackCreateParameters(transportTaskTrack);
 	}
 	protected Object[] prepareTransportTaskTrackUpdateParameters(TransportTaskTrack transportTaskTrack){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = transportTaskTrack.getTrackTime();
 		parameters[1] = transportTaskTrack.getLatitude();
 		parameters[2] = transportTaskTrack.getLongitude(); 	
 		if(transportTaskTrack.getMovement() != null){
 			parameters[3] = transportTaskTrack.getMovement().getId();
 		}
 		
 		parameters[4] = transportTaskTrack.getId();
 		parameters[5] = transportTaskTrack.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTransportTaskTrackCreateParameters(TransportTaskTrack transportTaskTrack){
		Object[] parameters = new Object[5];
		String newTransportTaskTrackId=getNextId();
		transportTaskTrack.setId(newTransportTaskTrackId);
		parameters[0] =  transportTaskTrack.getId();
 
 		parameters[1] = transportTaskTrack.getTrackTime();
 		parameters[2] = transportTaskTrack.getLatitude();
 		parameters[3] = transportTaskTrack.getLongitude(); 	
 		if(transportTaskTrack.getMovement() != null){
 			parameters[4] = transportTaskTrack.getMovement().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected TransportTaskTrack saveInternalTransportTaskTrack(TransportTaskTrack transportTaskTrack, Map<String,Object> options){
		
		saveTransportTaskTrack(transportTaskTrack);
 	
 		if(isSaveMovementEnabled(options)){
	 		saveMovement(transportTaskTrack, options);
 		}
 
		
		return transportTaskTrack;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TransportTaskTrack saveMovement(TransportTaskTrack transportTaskTrack, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(transportTaskTrack.getMovement() == null){
 			return transportTaskTrack;//do nothing when it is null
 		}
 		
 		getTransportTaskDAO().save(transportTaskTrack.getMovement(),options);
 		return transportTaskTrack;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public TransportTaskTrack present(TransportTaskTrack transportTaskTrack,Map<String, Object> options){
	

		return transportTaskTrack;
	
	}
		


	protected String getTableName(){
		return TransportTaskTrackTable.TABLE_NAME;
	}
}

