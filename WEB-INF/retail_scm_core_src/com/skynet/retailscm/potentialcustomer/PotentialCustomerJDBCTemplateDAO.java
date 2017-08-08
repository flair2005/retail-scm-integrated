
package com.skynet.retailscm.potentialcustomer;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.skynet.retailscm.citypartner.CityPartnerDAO;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;
import com.skynet.retailscm.eventattendance.EventAttendanceDAO;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactTable;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTable;
import com.skynet.retailscm.eventattendance.EventAttendanceTable;
import com.skynet.retailscm.citypartner.CityPartnerTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class PotentialCustomerJDBCTemplateDAO extends CommonJDBCTemplateDAO implements PotentialCustomerDAO{
 
 	
 	private  CityPartnerDAO  cityPartnerDAO;
 	public void setCityPartnerDAO(CityPartnerDAO cityPartnerDAO){
	 	this.cityPartnerDAO = cityPartnerDAO;
 	}
 	public CityPartnerDAO getCityPartnerDAO(){
	 	return this.cityPartnerDAO;
 	}
 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}

		
	
  	private  PotentialCustomerContactPersonDAO  potentialCustomerContactPersonDAO;
 	public void setPotentialCustomerContactPersonDAO(PotentialCustomerContactPersonDAO pPotentialCustomerContactPersonDAO){
 	
 		if(pPotentialCustomerContactPersonDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerContactPersonDAO to null.");
 		}
	 	this.potentialCustomerContactPersonDAO = pPotentialCustomerContactPersonDAO;
 	}
 	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO(){
 		if(this.potentialCustomerContactPersonDAO == null){
 			throw new IllegalStateException("The potentialCustomerContactPersonDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerContactPersonDAO;
 	}	
 	
			
		
	
  	private  PotentialCustomerContactDAO  potentialCustomerContactDAO;
 	public void setPotentialCustomerContactDAO(PotentialCustomerContactDAO pPotentialCustomerContactDAO){
 	
 		if(pPotentialCustomerContactDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerContactDAO to null.");
 		}
	 	this.potentialCustomerContactDAO = pPotentialCustomerContactDAO;
 	}
 	public PotentialCustomerContactDAO getPotentialCustomerContactDAO(){
 		if(this.potentialCustomerContactDAO == null){
 			throw new IllegalStateException("The potentialCustomerContactDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerContactDAO;
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
	protected PotentialCustomer load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomer(accessKey, options);
	}
	*/
	public PotentialCustomer load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomer(PotentialCustomerTable.withId(id), options);
	}
	
	
	
	public PotentialCustomer save(PotentialCustomer potentialCustomer,Map<String,Object> options){
		
		String methodName="save(PotentialCustomer potentialCustomer,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(potentialCustomer, methodName, "potentialCustomer");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPotentialCustomer(potentialCustomer,options);
	}
	public PotentialCustomer clone(String potentialCustomerId, Map<String,Object> options) throws Exception{
	
		return clone(PotentialCustomerTable.withId(potentialCustomerId),options);
	}
	
	protected PotentialCustomer clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String potentialCustomerId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PotentialCustomer newPotentialCustomer = loadInternalPotentialCustomer(accessKey, options);
		newPotentialCustomer.setVersion(0);
		
		
 		
 		if(isSavePotentialCustomerContactPersonListEnabled(options)){
 			for(PotentialCustomerContactPerson item: newPotentialCustomer.getPotentialCustomerContactPersonList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePotentialCustomerContactListEnabled(options)){
 			for(PotentialCustomerContact item: newPotentialCustomer.getPotentialCustomerContactList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEventAttendanceListEnabled(options)){
 			for(EventAttendance item: newPotentialCustomer.getEventAttendanceList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPotentialCustomer(newPotentialCustomer,options);
		
		return newPotentialCustomer;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String potentialCustomerId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{potentialCustomerId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new PotentialCustomerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PotentialCustomerNotFoundException(
					"The " + this.getTableName() + "(" + potentialCustomerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String potentialCustomerId, int version) throws Exception{
	
		String methodName="delete(String potentialCustomerId, int version)";
		assertMethodArgumentNotNull(potentialCustomerId, methodName, "potentialCustomerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{potentialCustomerId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(potentialCustomerId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","mobile","city_service_center","city_partner","description"};
		return PotentialCustomerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "potential_customer";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PotentialCustomerTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCityServiceCenterEnabled = true;
 	//private static final String CITYSERVICECENTER = "cityServiceCenter";
 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerTokens.CITYSERVICECENTER);
 	}
 	
 	
 	//private boolean saveCityServiceCenterEnabled = true;
 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerTokens.CITYSERVICECENTER);
 	}
 	

 	
  
 	//private boolean extractCityPartnerEnabled = true;
 	//private static final String CITYPARTNER = "cityPartner";
 	protected boolean isExtractCityPartnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerTokens.CITYPARTNER);
 	}
 	
 	
 	//private boolean saveCityPartnerEnabled = true;
 	protected boolean isSaveCityPartnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerTokens.CITYPARTNER);
 	}
 	

 	
 
		
	//protected static final String POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST = "potentialCustomerContactPersonList";
	
	protected boolean isExtractPotentialCustomerContactPersonListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
		
 	}

	protected boolean isSavePotentialCustomerContactPersonListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
		
 	}
 	
 	
			
		
	//protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
	
	protected boolean isExtractPotentialCustomerContactListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}

	protected boolean isSavePotentialCustomerContactListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EVENT_ATTENDANCE_LIST = "eventAttendanceList";
	
	protected boolean isExtractEventAttendanceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,PotentialCustomerTokens.EVENT_ATTENDANCE_LIST);
		
 	}

	protected boolean isSaveEventAttendanceListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerTokens.EVENT_ATTENDANCE_LIST);
		
 	}
 	
 	
			
		

	

	protected PotentialCustomerMapper getPotentialCustomerMapper(){
		return new PotentialCustomerMapper();
	}
	protected PotentialCustomer extractPotentialCustomer(String potentialCustomerId) throws Exception{
		String SQL = "select * from potential_customer_data where id = ?";	
		try{
		
			PotentialCustomer potentialCustomer = queryForObject(SQL, new Object[]{potentialCustomerId}, getPotentialCustomerMapper());
			return potentialCustomer;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerNotFoundException("PotentialCustomer("+potentialCustomerId+") is not found!");
		}
		
		
	}
	protected PotentialCustomer extractPotentialCustomer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from potential_customer_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			PotentialCustomer potentialCustomer = queryForObject(SQL, new Object[]{accessKey.getValue()}, getPotentialCustomerMapper());
			return potentialCustomer;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerNotFoundException("PotentialCustomer("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected PotentialCustomer loadInternalPotentialCustomer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PotentialCustomer potentialCustomer = extractPotentialCustomer(accessKey, loadOptions);
 	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(potentialCustomer, loadOptions);
 		}
  	
 		if(isExtractCityPartnerEnabled(loadOptions)){
	 		extractCityPartner(potentialCustomer, loadOptions);
 		}
 
		
		if(isExtractPotentialCustomerContactPersonListEnabled(loadOptions)){
	 		extractPotentialCustomerContactPersonList(potentialCustomer, loadOptions);
 		}		
		
		if(isExtractPotentialCustomerContactListEnabled(loadOptions)){
	 		extractPotentialCustomerContactList(potentialCustomer, loadOptions);
 		}		
		
		if(isExtractEventAttendanceListEnabled(loadOptions)){
	 		extractEventAttendanceList(potentialCustomer, loadOptions);
 		}		
		
		return potentialCustomer;
		
	}



	
	
	 

 	protected PotentialCustomer extractCityServiceCenter(PotentialCustomer potentialCustomer, Map<String,Object> options) throws Exception{

		if(potentialCustomer.getCityServiceCenter() == null){
			return potentialCustomer;
		}
		String cityServiceCenterId = potentialCustomer.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return potentialCustomer;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			potentialCustomer.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return potentialCustomer;
 	}
 		
  

 	protected PotentialCustomer extractCityPartner(PotentialCustomer potentialCustomer, Map<String,Object> options) throws Exception{

		if(potentialCustomer.getCityPartner() == null){
			return potentialCustomer;
		}
		String cityPartnerId = potentialCustomer.getCityPartner().getId();
		if( cityPartnerId == null){
			return potentialCustomer;
		}
		CityPartner cityPartner = getCityPartnerDAO().load(cityPartnerId,options);
		if(cityPartner != null){
			potentialCustomer.setCityPartner(cityPartner);
		}
		
 		
 		return potentialCustomer;
 	}
 		
 
		
	protected PotentialCustomer extractPotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = getPotentialCustomerContactPersonDAO().findPotentialCustomerContactPersonByPotentialCustomer(potentialCustomer.getId(),options);
		if(potentialCustomerContactPersonList != null){
			potentialCustomer.setPotentialCustomerContactPersonList(potentialCustomerContactPersonList);
		}
		
		return potentialCustomer;
	
	}	
		
	protected PotentialCustomer extractPotentialCustomerContactList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = getPotentialCustomerContactDAO().findPotentialCustomerContactByPotentialCustomer(potentialCustomer.getId(),options);
		if(potentialCustomerContactList != null){
			potentialCustomer.setPotentialCustomerContactList(potentialCustomerContactList);
		}
		
		return potentialCustomer;
	
	}	
		
	protected PotentialCustomer extractEventAttendanceList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		SmartList<EventAttendance> eventAttendanceList = getEventAttendanceDAO().findEventAttendanceByPotentialCustomer(potentialCustomer.getId(),options);
		if(eventAttendanceList != null){
			potentialCustomer.setEventAttendanceList(eventAttendanceList);
		}
		
		return potentialCustomer;
	
	}	
		
		
  	
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ?";
		SmartList<PotentialCustomer> potentialCustomerList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId}, getPotentialCustomerMapper());	
 		return potentialCustomerList;
 	}
 	
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PotentialCustomer> potentialCustomerList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId,start, count}, getPotentialCustomerMapper());
		
 		return potentialCustomerList;
 	}
 	
 	public int countPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where city_service_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCityServiceCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_partner = ?";
		SmartList<PotentialCustomer> potentialCustomerList = queryForList(SQL, new Object[]{cityPartnerId}, getPotentialCustomerMapper());	
 		return potentialCustomerList;
 	}
 	
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_partner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PotentialCustomer> potentialCustomerList = queryForList(SQL, new Object[]{cityPartnerId,start, count}, getPotentialCustomerMapper());
		
 		return potentialCustomerList;
 	}
 	
 	public int countPotentialCustomerByCityPartner(String cityPartnerId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where city_partner = ?";
		Integer count = queryInt(SQL, new Object[]{cityPartnerId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected PotentialCustomer savePotentialCustomer(PotentialCustomer  potentialCustomer){
	
		String SQL=this.getSavePotentialCustomerSQL(potentialCustomer);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePotentialCustomerParameters(potentialCustomer);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		potentialCustomer.incVersion();
		return potentialCustomer;
	
	}
	public SmartList<PotentialCustomer> savePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPotentialCustomerList(potentialCustomerList);
		
		batchPotentialCustomerCreate((List<PotentialCustomer>)lists[CREATE_LIST_INDEX]);
		
		batchPotentialCustomerUpdate((List<PotentialCustomer>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PotentialCustomer potentialCustomer:potentialCustomerList){
			if(potentialCustomer.isChanged()){
				potentialCustomer.incVersion();
			}
			
		
		}
		
		
		return potentialCustomerList;
	}

	public SmartList<PotentialCustomer> removePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options){
		
		
		super.removeList(potentialCustomerList, options);
		
		return potentialCustomerList;
		
		
	}
	
	protected List<Object[]> preparePotentialCustomerBatchCreateArgs(List<PotentialCustomer> potentialCustomerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomer potentialCustomer:potentialCustomerList ){
			Object [] parameters = preparePotentialCustomerCreateParameters(potentialCustomer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePotentialCustomerBatchUpdateArgs(List<PotentialCustomer> potentialCustomerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomer potentialCustomer:potentialCustomerList ){
			if(!potentialCustomer.isChanged()){
				continue;
			}
			Object [] parameters = preparePotentialCustomerUpdateParameters(potentialCustomer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPotentialCustomerCreate(List<PotentialCustomer> potentialCustomerList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePotentialCustomerBatchCreateArgs(potentialCustomerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPotentialCustomerUpdate(List<PotentialCustomer> potentialCustomerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePotentialCustomerBatchUpdateArgs(potentialCustomerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPotentialCustomerList(List<PotentialCustomer> potentialCustomerList){
		
		List<PotentialCustomer> potentialCustomerCreateList=new ArrayList<PotentialCustomer>();
		List<PotentialCustomer> potentialCustomerUpdateList=new ArrayList<PotentialCustomer>();
		
		for(PotentialCustomer potentialCustomer: potentialCustomerList){
			if(isUpdateRequest(potentialCustomer)){
				potentialCustomerUpdateList.add( potentialCustomer);
				continue;
			}
			potentialCustomerCreateList.add(potentialCustomer);
		}
		
		return new Object[]{potentialCustomerCreateList,potentialCustomerUpdateList};
	}
	
	protected boolean isUpdateRequest(PotentialCustomer potentialCustomer){
 		return potentialCustomer.getVersion() > 0;
 	}
 	protected String getSavePotentialCustomerSQL(PotentialCustomer potentialCustomer){
 		if(isUpdateRequest(potentialCustomer)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePotentialCustomerParameters(PotentialCustomer potentialCustomer){
 		if(isUpdateRequest(potentialCustomer) ){
 			return preparePotentialCustomerUpdateParameters(potentialCustomer);
 		}
 		return preparePotentialCustomerCreateParameters(potentialCustomer);
 	}
 	protected Object[] preparePotentialCustomerUpdateParameters(PotentialCustomer potentialCustomer){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = potentialCustomer.getName();
 		parameters[1] = potentialCustomer.getMobile(); 	
 		if(potentialCustomer.getCityServiceCenter() != null){
 			parameters[2] = potentialCustomer.getCityServiceCenter().getId();
 		}
  	
 		if(potentialCustomer.getCityPartner() != null){
 			parameters[3] = potentialCustomer.getCityPartner().getId();
 		}
 
 		parameters[4] = potentialCustomer.getDescription();		
 		parameters[5] = potentialCustomer.getId();
 		parameters[6] = potentialCustomer.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePotentialCustomerCreateParameters(PotentialCustomer potentialCustomer){
		Object[] parameters = new Object[6];
		String newPotentialCustomerId=getNextId();
		potentialCustomer.setId(newPotentialCustomerId);
		parameters[0] =  potentialCustomer.getId();
 
 		parameters[1] = potentialCustomer.getName();
 		parameters[2] = potentialCustomer.getMobile(); 	
 		if(potentialCustomer.getCityServiceCenter() != null){
 			parameters[3] = potentialCustomer.getCityServiceCenter().getId();
 		
 		}
 		 	
 		if(potentialCustomer.getCityPartner() != null){
 			parameters[4] = potentialCustomer.getCityPartner().getId();
 		
 		}
 		
 		parameters[5] = potentialCustomer.getDescription();		
 				
 		return parameters;
 	}
 	
	protected PotentialCustomer saveInternalPotentialCustomer(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		savePotentialCustomer(potentialCustomer);
 	
 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(potentialCustomer, options);
 		}
  	
 		if(isSaveCityPartnerEnabled(options)){
	 		saveCityPartner(potentialCustomer, options);
 		}
 
		
		if(isSavePotentialCustomerContactPersonListEnabled(options)){
	 		savePotentialCustomerContactPersonList(potentialCustomer, options);
	 		removePotentialCustomerContactPersonList(potentialCustomer, options);
	 		
 		}		
		
		if(isSavePotentialCustomerContactListEnabled(options)){
	 		savePotentialCustomerContactList(potentialCustomer, options);
	 		removePotentialCustomerContactList(potentialCustomer, options);
	 		
 		}		
		
		if(isSaveEventAttendanceListEnabled(options)){
	 		saveEventAttendanceList(potentialCustomer, options);
	 		removeEventAttendanceList(potentialCustomer, options);
	 		
 		}		
		
		return potentialCustomer;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PotentialCustomer saveCityServiceCenter(PotentialCustomer potentialCustomer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomer.getCityServiceCenter() == null){
 			return potentialCustomer;//do nothing when it is null
 		}
 		
 		getRetailStoreCityServiceCenterDAO().save(potentialCustomer.getCityServiceCenter(),options);
 		return potentialCustomer;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected PotentialCustomer saveCityPartner(PotentialCustomer potentialCustomer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomer.getCityPartner() == null){
 			return potentialCustomer;//do nothing when it is null
 		}
 		
 		getCityPartnerDAO().save(potentialCustomer.getCityPartner(),options);
 		return potentialCustomer;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected PotentialCustomer savePotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();
		if(potentialCustomerContactPersonList == null){
			return potentialCustomer;
		}
		if(potentialCustomerContactPersonList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPotentialCustomerContactPersonDAO().savePotentialCustomerContactPersonList(potentialCustomerContactPersonList,options);
		
		return potentialCustomer;
	
	}
	
	protected PotentialCustomer removePotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, Map<String,Object> options){
	
	
		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();
		if(potentialCustomerContactPersonList == null){
			return potentialCustomer;
		}	
	
		SmartList<PotentialCustomerContactPerson> toRemovePotentialCustomerContactPersonList = potentialCustomerContactPersonList.getToRemoveList();
		
		if(toRemovePotentialCustomerContactPersonList == null){
			return potentialCustomer;
		}
		if(toRemovePotentialCustomerContactPersonList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerContactPersonDAO().removePotentialCustomerContactPersonList(toRemovePotentialCustomerContactPersonList,options);
		
		return potentialCustomer;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected PotentialCustomer savePotentialCustomerContactList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return potentialCustomer;
		}
		if(potentialCustomerContactList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPotentialCustomerContactDAO().savePotentialCustomerContactList(potentialCustomerContactList,options);
		
		return potentialCustomer;
	
	}
	
	protected PotentialCustomer removePotentialCustomerContactList(PotentialCustomer potentialCustomer, Map<String,Object> options){
	
	
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return potentialCustomer;
		}	
	
		SmartList<PotentialCustomerContact> toRemovePotentialCustomerContactList = potentialCustomerContactList.getToRemoveList();
		
		if(toRemovePotentialCustomerContactList == null){
			return potentialCustomer;
		}
		if(toRemovePotentialCustomerContactList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerContactDAO().removePotentialCustomerContactList(toRemovePotentialCustomerContactList,options);
		
		return potentialCustomer;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected PotentialCustomer saveEventAttendanceList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		if(eventAttendanceList == null){
			return potentialCustomer;
		}
		if(eventAttendanceList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEventAttendanceDAO().saveEventAttendanceList(eventAttendanceList,options);
		
		return potentialCustomer;
	
	}
	
	protected PotentialCustomer removeEventAttendanceList(PotentialCustomer potentialCustomer, Map<String,Object> options){
	
	
		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		if(eventAttendanceList == null){
			return potentialCustomer;
		}	
	
		SmartList<EventAttendance> toRemoveEventAttendanceList = eventAttendanceList.getToRemoveList();
		
		if(toRemoveEventAttendanceList == null){
			return potentialCustomer;
		}
		if(toRemoveEventAttendanceList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEventAttendanceDAO().removeEventAttendanceList(toRemoveEventAttendanceList,options);
		
		return potentialCustomer;
	
	}
	
	
	
 	
 	
	
	
	
		

	public PotentialCustomer present(PotentialCustomer potentialCustomer,Map<String, Object> options){
	
		presentPotentialCustomerContactPersonList(potentialCustomer,options);
		presentPotentialCustomerContactList(potentialCustomer,options);
		presentEventAttendanceList(potentialCustomer,options);

		return potentialCustomer;
	
	}
		
	
  	
 	protected PotentialCustomer presentPotentialCustomerContactPersonList(
			PotentialCustomer potentialCustomer,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();		
		if(potentialCustomerContactPersonList == null){
			return potentialCustomer;			
		}
		
		String targetObjectName = "potentialCustomerContactPerson";
		int potentialCustomerContactPersonListSize = potentialCustomerContactPersonList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(potentialCustomerContactPersonListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return potentialCustomer;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = potentialCustomerContactPersonListSize;
		if(potentialCustomerContactPersonListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPotentialCustomerContactPersonDAO().countPotentialCustomerContactPersonByPotentialCustomer(potentialCustomer.getId(), options);			
		}
		//potentialCustomer.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//potentialCustomer.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(potentialCustomerContactPersonListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(potentialCustomerContactPersonListSize,currentPage,rowsPerPage) ;
			potentialCustomerContactPersonList = potentialCustomerContactPersonList.subListOf(fromIndex, toIndex);
			potentialCustomerContactPersonList.setTotalCount(count);
			potentialCustomerContactPersonList.setCurrentPageNumber(currentPage);			
			potentialCustomer.setPotentialCustomerContactPersonList(potentialCustomerContactPersonList);
			return potentialCustomer;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		potentialCustomerContactPersonList 
			= getPotentialCustomerContactPersonDAO().findPotentialCustomerContactPersonByPotentialCustomer(potentialCustomer.getId(),start, rowsPerPage, options );
		potentialCustomerContactPersonList.setTotalCount(count);
		potentialCustomerContactPersonList.setCurrentPageNumber(currentPage);
		potentialCustomer.setPotentialCustomerContactPersonList(potentialCustomerContactPersonList );	

		return potentialCustomer;
	}			
		
	
  	
 	protected PotentialCustomer presentPotentialCustomerContactList(
			PotentialCustomer potentialCustomer,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();		
		if(potentialCustomerContactList == null){
			return potentialCustomer;			
		}
		
		String targetObjectName = "potentialCustomerContact";
		int potentialCustomerContactListSize = potentialCustomerContactList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(potentialCustomerContactListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return potentialCustomer;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = potentialCustomerContactListSize;
		if(potentialCustomerContactListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPotentialCustomerContactDAO().countPotentialCustomerContactByPotentialCustomer(potentialCustomer.getId(), options);			
		}
		//potentialCustomer.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//potentialCustomer.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(potentialCustomerContactListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(potentialCustomerContactListSize,currentPage,rowsPerPage) ;
			potentialCustomerContactList = potentialCustomerContactList.subListOf(fromIndex, toIndex);
			potentialCustomerContactList.setTotalCount(count);
			potentialCustomerContactList.setCurrentPageNumber(currentPage);			
			potentialCustomer.setPotentialCustomerContactList(potentialCustomerContactList);
			return potentialCustomer;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		potentialCustomerContactList 
			= getPotentialCustomerContactDAO().findPotentialCustomerContactByPotentialCustomer(potentialCustomer.getId(),start, rowsPerPage, options );
		potentialCustomerContactList.setTotalCount(count);
		potentialCustomerContactList.setCurrentPageNumber(currentPage);
		potentialCustomer.setPotentialCustomerContactList(potentialCustomerContactList );	

		return potentialCustomer;
	}			
		
	
  	
 	protected PotentialCustomer presentEventAttendanceList(
			PotentialCustomer potentialCustomer,
			Map<String, Object> options) {

		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();		
		if(eventAttendanceList == null){
			return potentialCustomer;			
		}
		
		String targetObjectName = "eventAttendance";
		int eventAttendanceListSize = eventAttendanceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(eventAttendanceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return potentialCustomer;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = eventAttendanceListSize;
		if(eventAttendanceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEventAttendanceDAO().countEventAttendanceByPotentialCustomer(potentialCustomer.getId(), options);			
		}
		//potentialCustomer.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//potentialCustomer.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(eventAttendanceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(eventAttendanceListSize,currentPage,rowsPerPage) ;
			eventAttendanceList = eventAttendanceList.subListOf(fromIndex, toIndex);
			eventAttendanceList.setTotalCount(count);
			eventAttendanceList.setCurrentPageNumber(currentPage);			
			potentialCustomer.setEventAttendanceList(eventAttendanceList);
			return potentialCustomer;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		eventAttendanceList 
			= getEventAttendanceDAO().findEventAttendanceByPotentialCustomer(potentialCustomer.getId(),start, rowsPerPage, options );
		eventAttendanceList.setTotalCount(count);
		eventAttendanceList.setCurrentPageNumber(currentPage);
		potentialCustomer.setEventAttendanceList(eventAttendanceList );	

		return potentialCustomer;
	}			
		


	protected String getTableName(){
		return PotentialCustomerTable.TABLE_NAME;
	}
}


