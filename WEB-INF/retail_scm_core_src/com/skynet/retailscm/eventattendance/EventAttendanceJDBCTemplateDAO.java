
package com.skynet.retailscm.eventattendance;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;

import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.skynet.retailscm.cityevent.CityEventDAO;

import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;
import com.skynet.retailscm.cityevent.CityEventTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class EventAttendanceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EventAttendanceDAO{
 
 	
 	private  CityEventDAO  cityEventDAO;
 	public void setCityEventDAO(CityEventDAO cityEventDAO){
	 	this.cityEventDAO = cityEventDAO;
 	}
 	public CityEventDAO getCityEventDAO(){
	 	return this.cityEventDAO;
 	}
 
 	
 	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
	 	return this.potentialCustomerDAO;
 	}

		

	
	/*
	protected EventAttendance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEventAttendance(accessKey, options);
	}
	*/
	public EventAttendance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEventAttendance(EventAttendanceTable.withId(id), options);
	}
	
	
	
	public EventAttendance save(EventAttendance eventAttendance,Map<String,Object> options){
		
		String methodName="save(EventAttendance eventAttendance,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(eventAttendance, methodName, "eventAttendance");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEventAttendance(eventAttendance,options);
	}
	public EventAttendance clone(String eventAttendanceId, Map<String,Object> options) throws Exception{
	
		return clone(EventAttendanceTable.withId(eventAttendanceId),options);
	}
	
	protected EventAttendance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String eventAttendanceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EventAttendance newEventAttendance = loadInternalEventAttendance(accessKey, options);
		newEventAttendance.setVersion(0);
		
		

		
		saveInternalEventAttendance(newEventAttendance,options);
		
		return newEventAttendance;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String eventAttendanceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{eventAttendanceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EventAttendanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EventAttendanceNotFoundException(
					"The " + this.getTableName() + "(" + eventAttendanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String eventAttendanceId, int version) throws Exception{
	
		String methodName="delete(String eventAttendanceId, int version)";
		assertMethodArgumentNotNull(eventAttendanceId, methodName, "eventAttendanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{eventAttendanceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(eventAttendanceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","potential_customer","city_event","description"};
		return EventAttendanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "event_attendance";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EventAttendanceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractPotentialCustomerEnabled = true;
 	//private static final String POTENTIALCUSTOMER = "potentialCustomer";
 	protected boolean isExtractPotentialCustomerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EventAttendanceTokens.POTENTIALCUSTOMER);
 	}
 	
 	
 	//private boolean savePotentialCustomerEnabled = true;
 	protected boolean isSavePotentialCustomerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EventAttendanceTokens.POTENTIALCUSTOMER);
 	}
 	

 	
  
 	//private boolean extractCityEventEnabled = true;
 	//private static final String CITYEVENT = "cityEvent";
 	protected boolean isExtractCityEventEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EventAttendanceTokens.CITYEVENT);
 	}
 	
 	
 	//private boolean saveCityEventEnabled = true;
 	protected boolean isSaveCityEventEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EventAttendanceTokens.CITYEVENT);
 	}
 	

 	
 
		

	

	protected EventAttendanceMapper getEventAttendanceMapper(){
		return new EventAttendanceMapper();
	}
	protected EventAttendance extractEventAttendance(String eventAttendanceId) throws Exception{
		String SQL = "select * from event_attendance_data where id = ?";	
		try{
		
			EventAttendance eventAttendance = queryForObject(SQL, new Object[]{eventAttendanceId}, getEventAttendanceMapper());
			return eventAttendance;
		}catch(EmptyResultDataAccessException e){
			throw new EventAttendanceNotFoundException("EventAttendance("+eventAttendanceId+") is not found!");
		}
		
		
	}
	protected EventAttendance extractEventAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from event_attendance_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EventAttendance eventAttendance = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEventAttendanceMapper());
			return eventAttendance;
		}catch(EmptyResultDataAccessException e){
			throw new EventAttendanceNotFoundException("EventAttendance("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EventAttendance loadInternalEventAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EventAttendance eventAttendance = extractEventAttendance(accessKey, loadOptions);
 	
 		if(isExtractPotentialCustomerEnabled(loadOptions)){
	 		extractPotentialCustomer(eventAttendance, loadOptions);
 		}
  	
 		if(isExtractCityEventEnabled(loadOptions)){
	 		extractCityEvent(eventAttendance, loadOptions);
 		}
 
		
		return eventAttendance;
		
	}



	
	
	 

 	protected EventAttendance extractPotentialCustomer(EventAttendance eventAttendance, Map<String,Object> options) throws Exception{

		if(eventAttendance.getPotentialCustomer() == null){
			return eventAttendance;
		}
		String potentialCustomerId = eventAttendance.getPotentialCustomer().getId();
		if( potentialCustomerId == null){
			return eventAttendance;
		}
		PotentialCustomer potentialCustomer = getPotentialCustomerDAO().load(potentialCustomerId,options);
		if(potentialCustomer != null){
			eventAttendance.setPotentialCustomer(potentialCustomer);
		}
		
 		
 		return eventAttendance;
 	}
 		
  

 	protected EventAttendance extractCityEvent(EventAttendance eventAttendance, Map<String,Object> options) throws Exception{

		if(eventAttendance.getCityEvent() == null){
			return eventAttendance;
		}
		String cityEventId = eventAttendance.getCityEvent().getId();
		if( cityEventId == null){
			return eventAttendance;
		}
		CityEvent cityEvent = getCityEventDAO().load(cityEventId,options);
		if(cityEvent != null){
			eventAttendance.setCityEvent(cityEvent);
		}
		
 		
 		return eventAttendance;
 	}
 		
 
		
		
  	
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where potential_customer = ?";
		SmartList<EventAttendance> eventAttendanceList = queryForList(SQL, new Object[]{potentialCustomerId}, getEventAttendanceMapper());	
 		return eventAttendanceList;
 	}
 	
 	public SmartList<EventAttendance> findEventAttendanceByPotentialCustomer(String potentialCustomerId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where potential_customer = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EventAttendance> eventAttendanceList = queryForList(SQL, new Object[]{potentialCustomerId,start, count}, getEventAttendanceMapper());
		
 		return eventAttendanceList;
 	}
 	
 	public int countEventAttendanceByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where potential_customer = ?";
		Integer count = queryInt(SQL, new Object[]{potentialCustomerId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_event = ?";
		SmartList<EventAttendance> eventAttendanceList = queryForList(SQL, new Object[]{cityEventId}, getEventAttendanceMapper());	
 		return eventAttendanceList;
 	}
 	
 	public SmartList<EventAttendance> findEventAttendanceByCityEvent(String cityEventId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_event = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EventAttendance> eventAttendanceList = queryForList(SQL, new Object[]{cityEventId,start, count}, getEventAttendanceMapper());
		
 		return eventAttendanceList;
 	}
 	
 	public int countEventAttendanceByCityEvent(String cityEventId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where city_event = ?";
		Integer count = queryInt(SQL, new Object[]{cityEventId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EventAttendance saveEventAttendance(EventAttendance  eventAttendance){
	
		String SQL=this.getSaveEventAttendanceSQL(eventAttendance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEventAttendanceParameters(eventAttendance);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		eventAttendance.incVersion();
		return eventAttendance;
	
	}
	public SmartList<EventAttendance> saveEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEventAttendanceList(eventAttendanceList);
		
		batchEventAttendanceCreate((List<EventAttendance>)lists[CREATE_LIST_INDEX]);
		
		batchEventAttendanceUpdate((List<EventAttendance>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EventAttendance eventAttendance:eventAttendanceList){
			if(eventAttendance.isChanged()){
				eventAttendance.incVersion();
			}
			
		
		}
		
		
		return eventAttendanceList;
	}

	public SmartList<EventAttendance> removeEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options){
		
		
		super.removeList(eventAttendanceList, options);
		
		return eventAttendanceList;
		
		
	}
	
	protected List<Object[]> prepareEventAttendanceBatchCreateArgs(List<EventAttendance> eventAttendanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EventAttendance eventAttendance:eventAttendanceList ){
			Object [] parameters = prepareEventAttendanceCreateParameters(eventAttendance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEventAttendanceBatchUpdateArgs(List<EventAttendance> eventAttendanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EventAttendance eventAttendance:eventAttendanceList ){
			if(!eventAttendance.isChanged()){
				continue;
			}
			Object [] parameters = prepareEventAttendanceUpdateParameters(eventAttendance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEventAttendanceCreate(List<EventAttendance> eventAttendanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEventAttendanceBatchCreateArgs(eventAttendanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEventAttendanceUpdate(List<EventAttendance> eventAttendanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEventAttendanceBatchUpdateArgs(eventAttendanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEventAttendanceList(List<EventAttendance> eventAttendanceList){
		
		List<EventAttendance> eventAttendanceCreateList=new ArrayList<EventAttendance>();
		List<EventAttendance> eventAttendanceUpdateList=new ArrayList<EventAttendance>();
		
		for(EventAttendance eventAttendance: eventAttendanceList){
			if(isUpdateRequest(eventAttendance)){
				eventAttendanceUpdateList.add( eventAttendance);
				continue;
			}
			eventAttendanceCreateList.add(eventAttendance);
		}
		
		return new Object[]{eventAttendanceCreateList,eventAttendanceUpdateList};
	}
	
	protected boolean isUpdateRequest(EventAttendance eventAttendance){
 		return eventAttendance.getVersion() > 0;
 	}
 	protected String getSaveEventAttendanceSQL(EventAttendance eventAttendance){
 		if(isUpdateRequest(eventAttendance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEventAttendanceParameters(EventAttendance eventAttendance){
 		if(isUpdateRequest(eventAttendance) ){
 			return prepareEventAttendanceUpdateParameters(eventAttendance);
 		}
 		return prepareEventAttendanceCreateParameters(eventAttendance);
 	}
 	protected Object[] prepareEventAttendanceUpdateParameters(EventAttendance eventAttendance){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = eventAttendance.getName(); 	
 		if(eventAttendance.getPotentialCustomer() != null){
 			parameters[1] = eventAttendance.getPotentialCustomer().getId();
 		}
  	
 		if(eventAttendance.getCityEvent() != null){
 			parameters[2] = eventAttendance.getCityEvent().getId();
 		}
 
 		parameters[3] = eventAttendance.getDescription();		
 		parameters[4] = eventAttendance.getId();
 		parameters[5] = eventAttendance.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEventAttendanceCreateParameters(EventAttendance eventAttendance){
		Object[] parameters = new Object[5];
		String newEventAttendanceId=getNextId();
		eventAttendance.setId(newEventAttendanceId);
		parameters[0] =  eventAttendance.getId();
 
 		parameters[1] = eventAttendance.getName(); 	
 		if(eventAttendance.getPotentialCustomer() != null){
 			parameters[2] = eventAttendance.getPotentialCustomer().getId();
 		
 		}
 		 	
 		if(eventAttendance.getCityEvent() != null){
 			parameters[3] = eventAttendance.getCityEvent().getId();
 		
 		}
 		
 		parameters[4] = eventAttendance.getDescription();		
 				
 		return parameters;
 	}
 	
	protected EventAttendance saveInternalEventAttendance(EventAttendance eventAttendance, Map<String,Object> options){
		
		saveEventAttendance(eventAttendance);
 	
 		if(isSavePotentialCustomerEnabled(options)){
	 		savePotentialCustomer(eventAttendance, options);
 		}
  	
 		if(isSaveCityEventEnabled(options)){
	 		saveCityEvent(eventAttendance, options);
 		}
 
		
		return eventAttendance;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EventAttendance savePotentialCustomer(EventAttendance eventAttendance, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(eventAttendance.getPotentialCustomer() == null){
 			return eventAttendance;//do nothing when it is null
 		}
 		
 		getPotentialCustomerDAO().save(eventAttendance.getPotentialCustomer(),options);
 		return eventAttendance;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EventAttendance saveCityEvent(EventAttendance eventAttendance, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(eventAttendance.getCityEvent() == null){
 			return eventAttendance;//do nothing when it is null
 		}
 		
 		getCityEventDAO().save(eventAttendance.getCityEvent(),options);
 		return eventAttendance;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EventAttendance present(EventAttendance eventAttendance,Map<String, Object> options){
	

		return eventAttendance;
	
	}
		


	protected String getTableName(){
		return EventAttendanceTable.TABLE_NAME;
	}
}


