
package com.skynet.retailscm.cityevent;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.skynet.retailscm.eventattendance.EventAttendanceDAO;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.eventattendance.EventAttendanceTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class CityEventJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CityEventDAO{
 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}

		
	
  	private  EventAttendanceDAO  eventAttendanceDAO;
 	public void setEventAttendanceDAO(EventAttendanceDAO pEventAttendanceDAO){
 	
 		if(pEventAttendanceDAO == null){
 			throw new IllegalStateException("Do not try to set eventAttendanceDAO to null.");
 		}
	 	this.eventAttendanceDAO = pEventAttendanceDAO;
 	}
 	public EventAttendanceDAO getEventAttendanceDAO(){
 		if(this.eventAttendanceDAO == null){
 			throw new IllegalStateException("The eventAttendanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.eventAttendanceDAO;
 	}	
 	
			
		

	
	/*
	protected CityEvent load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCityEvent(accessKey, options);
	}
	*/
	public CityEvent load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCityEvent(CityEventTable.withId(id), options);
	}
	
	
	
	public CityEvent save(CityEvent cityEvent,Map<String,Object> options){
		
		String methodName="save(CityEvent cityEvent,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(cityEvent, methodName, "cityEvent");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCityEvent(cityEvent,options);
	}
	public CityEvent clone(String cityEventId, Map<String,Object> options) throws Exception{
	
		return clone(CityEventTable.withId(cityEventId),options);
	}
	
	protected CityEvent clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String cityEventId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CityEvent newCityEvent = loadInternalCityEvent(accessKey, options);
		newCityEvent.setVersion(0);
		
		
 		
 		if(isSaveEventAttendanceListEnabled(options)){
 			for(EventAttendance item: newCityEvent.getEventAttendanceList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCityEvent(newCityEvent,options);
		
		return newCityEvent;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String cityEventId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{cityEventId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new CityEventVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CityEventNotFoundException(
					"The " + this.getTableName() + "(" + cityEventId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String cityEventId, int version) throws Exception{
	
		String methodName="delete(String cityEventId, int version)";
		assertMethodArgumentNotNull(cityEventId, methodName, "cityEventId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{cityEventId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(cityEventId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","mobile","city_service_center","description"};
		return CityEventTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "city_event";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CityEventTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCityServiceCenterEnabled = true;
 	//private static final String CITYSERVICECENTER = "cityServiceCenter";
 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CityEventTokens.CITYSERVICECENTER);
 	}
 	
 	
 	//private boolean saveCityServiceCenterEnabled = true;
 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CityEventTokens.CITYSERVICECENTER);
 	}
 	

 	
 
		
	//protected static final String EVENT_ATTENDANCE_LIST = "eventAttendanceList";
	
	protected boolean isExtractEventAttendanceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,CityEventTokens.EVENT_ATTENDANCE_LIST);
		
 	}

	protected boolean isSaveEventAttendanceListEnabled(Map<String,Object> options){
		return checkOptions(options, CityEventTokens.EVENT_ATTENDANCE_LIST);
		
 	}
 	
 	
			
		

	

	protected CityEventMapper getCityEventMapper(){
		return new CityEventMapper();
	}
	protected CityEvent extractCityEvent(String cityEventId) throws Exception{
		String SQL = "select * from city_event_data where id = ?";	
		try{
		
			CityEvent cityEvent = queryForObject(SQL, new Object[]{cityEventId}, getCityEventMapper());
			return cityEvent;
		}catch(EmptyResultDataAccessException e){
			throw new CityEventNotFoundException("CityEvent("+cityEventId+") is not found!");
		}
		
		
	}
	protected CityEvent extractCityEvent(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from city_event_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			CityEvent cityEvent = queryForObject(SQL, new Object[]{accessKey.getValue()}, getCityEventMapper());
			return cityEvent;
		}catch(EmptyResultDataAccessException e){
			throw new CityEventNotFoundException("CityEvent("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected CityEvent loadInternalCityEvent(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CityEvent cityEvent = extractCityEvent(accessKey, loadOptions);
 	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(cityEvent, loadOptions);
 		}
 
		
		if(isExtractEventAttendanceListEnabled(loadOptions)){
	 		extractEventAttendanceList(cityEvent, loadOptions);
 		}		
		
		return cityEvent;
		
	}



	
	
	 

 	protected CityEvent extractCityServiceCenter(CityEvent cityEvent, Map<String,Object> options) throws Exception{

		if(cityEvent.getCityServiceCenter() == null){
			return cityEvent;
		}
		String cityServiceCenterId = cityEvent.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return cityEvent;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			cityEvent.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return cityEvent;
 	}
 		
 
		
	protected CityEvent extractEventAttendanceList(CityEvent cityEvent, Map<String,Object> options){
		
		SmartList<EventAttendance> eventAttendanceList = getEventAttendanceDAO().findEventAttendanceByCityEvent(cityEvent.getId(),options);
		if(eventAttendanceList != null){
			cityEvent.setEventAttendanceList(eventAttendanceList);
		}
		
		return cityEvent;
	
	}	
		
		
  	
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ?";
		SmartList<CityEvent> cityEventList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId}, getCityEventMapper());	
 		return cityEventList;
 	}
 	
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<CityEvent> cityEventList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId,start, count}, getCityEventMapper());
		
 		return cityEventList;
 	}
 	
 	public int countCityEventByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where city_service_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCityServiceCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected CityEvent saveCityEvent(CityEvent  cityEvent){
	
		String SQL=this.getSaveCityEventSQL(cityEvent);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCityEventParameters(cityEvent);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		cityEvent.incVersion();
		return cityEvent;
	
	}
	public SmartList<CityEvent> saveCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCityEventList(cityEventList);
		
		batchCityEventCreate((List<CityEvent>)lists[CREATE_LIST_INDEX]);
		
		batchCityEventUpdate((List<CityEvent>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CityEvent cityEvent:cityEventList){
			if(cityEvent.isChanged()){
				cityEvent.incVersion();
			}
			
		
		}
		
		
		return cityEventList;
	}

	public SmartList<CityEvent> removeCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options){
		
		
		super.removeList(cityEventList, options);
		
		return cityEventList;
		
		
	}
	
	protected List<Object[]> prepareCityEventBatchCreateArgs(List<CityEvent> cityEventList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityEvent cityEvent:cityEventList ){
			Object [] parameters = prepareCityEventCreateParameters(cityEvent);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCityEventBatchUpdateArgs(List<CityEvent> cityEventList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityEvent cityEvent:cityEventList ){
			if(!cityEvent.isChanged()){
				continue;
			}
			Object [] parameters = prepareCityEventUpdateParameters(cityEvent);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCityEventCreate(List<CityEvent> cityEventList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCityEventBatchCreateArgs(cityEventList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCityEventUpdate(List<CityEvent> cityEventList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCityEventBatchUpdateArgs(cityEventList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCityEventList(List<CityEvent> cityEventList){
		
		List<CityEvent> cityEventCreateList=new ArrayList<CityEvent>();
		List<CityEvent> cityEventUpdateList=new ArrayList<CityEvent>();
		
		for(CityEvent cityEvent: cityEventList){
			if(isUpdateRequest(cityEvent)){
				cityEventUpdateList.add( cityEvent);
				continue;
			}
			cityEventCreateList.add(cityEvent);
		}
		
		return new Object[]{cityEventCreateList,cityEventUpdateList};
	}
	
	protected boolean isUpdateRequest(CityEvent cityEvent){
 		return cityEvent.getVersion() > 0;
 	}
 	protected String getSaveCityEventSQL(CityEvent cityEvent){
 		if(isUpdateRequest(cityEvent)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCityEventParameters(CityEvent cityEvent){
 		if(isUpdateRequest(cityEvent) ){
 			return prepareCityEventUpdateParameters(cityEvent);
 		}
 		return prepareCityEventCreateParameters(cityEvent);
 	}
 	protected Object[] prepareCityEventUpdateParameters(CityEvent cityEvent){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = cityEvent.getName();
 		parameters[1] = cityEvent.getMobile(); 	
 		if(cityEvent.getCityServiceCenter() != null){
 			parameters[2] = cityEvent.getCityServiceCenter().getId();
 		}
 
 		parameters[3] = cityEvent.getDescription();		
 		parameters[4] = cityEvent.getId();
 		parameters[5] = cityEvent.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCityEventCreateParameters(CityEvent cityEvent){
		Object[] parameters = new Object[5];
		String newCityEventId=getNextId();
		cityEvent.setId(newCityEventId);
		parameters[0] =  cityEvent.getId();
 
 		parameters[1] = cityEvent.getName();
 		parameters[2] = cityEvent.getMobile(); 	
 		if(cityEvent.getCityServiceCenter() != null){
 			parameters[3] = cityEvent.getCityServiceCenter().getId();
 		
 		}
 		
 		parameters[4] = cityEvent.getDescription();		
 				
 		return parameters;
 	}
 	
	protected CityEvent saveInternalCityEvent(CityEvent cityEvent, Map<String,Object> options){
		
		saveCityEvent(cityEvent);
 	
 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(cityEvent, options);
 		}
 
		
		if(isSaveEventAttendanceListEnabled(options)){
	 		saveEventAttendanceList(cityEvent, options);
	 		removeEventAttendanceList(cityEvent, options);
	 		
 		}		
		
		return cityEvent;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CityEvent saveCityServiceCenter(CityEvent cityEvent, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(cityEvent.getCityServiceCenter() == null){
 			return cityEvent;//do nothing when it is null
 		}
 		
 		getRetailStoreCityServiceCenterDAO().save(cityEvent.getCityServiceCenter(),options);
 		return cityEvent;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected CityEvent saveEventAttendanceList(CityEvent cityEvent, Map<String,Object> options){
		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();
		if(eventAttendanceList == null){
			return cityEvent;
		}
		if(eventAttendanceList.isEmpty()){
			return cityEvent;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEventAttendanceDAO().saveEventAttendanceList(eventAttendanceList,options);
		
		return cityEvent;
	
	}
	
	protected CityEvent removeEventAttendanceList(CityEvent cityEvent, Map<String,Object> options){
	
	
		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();
		if(eventAttendanceList == null){
			return cityEvent;
		}	
	
		SmartList<EventAttendance> toRemoveEventAttendanceList = eventAttendanceList.getToRemoveList();
		
		if(toRemoveEventAttendanceList == null){
			return cityEvent;
		}
		if(toRemoveEventAttendanceList.isEmpty()){
			return cityEvent;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEventAttendanceDAO().removeEventAttendanceList(toRemoveEventAttendanceList,options);
		
		return cityEvent;
	
	}
	
	
	
 	
 	
	
	
	
		

	public CityEvent present(CityEvent cityEvent,Map<String, Object> options){
	
		presentEventAttendanceList(cityEvent,options);

		return cityEvent;
	
	}
		
	
  	
 	protected CityEvent presentEventAttendanceList(
			CityEvent cityEvent,
			Map<String, Object> options) {

		SmartList<EventAttendance> eventAttendanceList = cityEvent.getEventAttendanceList();		
		if(eventAttendanceList == null){
			return cityEvent;			
		}
		
		String targetObjectName = "eventAttendance";
		int eventAttendanceListSize = eventAttendanceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(eventAttendanceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return cityEvent;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = eventAttendanceListSize;
		if(eventAttendanceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEventAttendanceDAO().countEventAttendanceByCityEvent(cityEvent.getId(), options);			
		}
		//cityEvent.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//cityEvent.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(eventAttendanceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(eventAttendanceListSize,currentPage,rowsPerPage) ;
			eventAttendanceList = eventAttendanceList.subListOf(fromIndex, toIndex);
			eventAttendanceList.setTotalCount(count);
			eventAttendanceList.setCurrentPageNumber(currentPage);			
			cityEvent.setEventAttendanceList(eventAttendanceList);
			return cityEvent;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		eventAttendanceList 
			= getEventAttendanceDAO().findEventAttendanceByCityEvent(cityEvent.getId(),start, rowsPerPage, options );
		eventAttendanceList.setTotalCount(count);
		eventAttendanceList.setCurrentPageNumber(currentPage);
		cityEvent.setEventAttendanceList(eventAttendanceList );	

		return cityEvent;
	}			
		


	protected String getTableName(){
		return CityEventTable.TABLE_NAME;
	}
}


