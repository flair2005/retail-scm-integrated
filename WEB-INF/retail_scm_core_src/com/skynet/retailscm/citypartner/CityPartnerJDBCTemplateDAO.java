
package com.skynet.retailscm.citypartner;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactTable;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class CityPartnerJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CityPartnerDAO{
 
 	
 	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
	 	return this.retailStoreCityServiceCenterDAO;
 	}

		
	
  	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO pPotentialCustomerDAO){
 	
 		if(pPotentialCustomerDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerDAO to null.");
 		}
	 	this.potentialCustomerDAO = pPotentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
 		if(this.potentialCustomerDAO == null){
 			throw new IllegalStateException("The potentialCustomerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerDAO;
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
 	
			
		

	
	/*
	protected CityPartner load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCityPartner(accessKey, options);
	}
	*/
	public CityPartner load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCityPartner(CityPartnerTable.withId(id), options);
	}
	
	
	
	public CityPartner save(CityPartner cityPartner,Map<String,Object> options){
		
		String methodName="save(CityPartner cityPartner,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(cityPartner, methodName, "cityPartner");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCityPartner(cityPartner,options);
	}
	public CityPartner clone(String cityPartnerId, Map<String,Object> options) throws Exception{
	
		return clone(CityPartnerTable.withId(cityPartnerId),options);
	}
	
	protected CityPartner clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String cityPartnerId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CityPartner newCityPartner = loadInternalCityPartner(accessKey, options);
		newCityPartner.setVersion(0);
		
		
 		
 		if(isSavePotentialCustomerListEnabled(options)){
 			for(PotentialCustomer item: newCityPartner.getPotentialCustomerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePotentialCustomerContactListEnabled(options)){
 			for(PotentialCustomerContact item: newCityPartner.getPotentialCustomerContactList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCityPartner(newCityPartner,options);
		
		return newCityPartner;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String cityPartnerId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{cityPartnerId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new CityPartnerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CityPartnerNotFoundException(
					"The " + this.getTableName() + "(" + cityPartnerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String cityPartnerId, int version) throws Exception{
	
		String methodName="delete(String cityPartnerId, int version)";
		assertMethodArgumentNotNull(cityPartnerId, methodName, "cityPartnerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{cityPartnerId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(cityPartnerId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","mobile","city_service_center","description"};
		return CityPartnerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "city_partner";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CityPartnerTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCityServiceCenterEnabled = true;
 	//private static final String CITYSERVICECENTER = "cityServiceCenter";
 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CityPartnerTokens.CITYSERVICECENTER);
 	}
 	
 	
 	//private boolean saveCityServiceCenterEnabled = true;
 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CityPartnerTokens.CITYSERVICECENTER);
 	}
 	

 	
 
		
	//protected static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
	
	protected boolean isExtractPotentialCustomerListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,CityPartnerTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}

	protected boolean isSavePotentialCustomerListEnabled(Map<String,Object> options){
		return checkOptions(options, CityPartnerTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
	
	protected boolean isExtractPotentialCustomerContactListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,CityPartnerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}

	protected boolean isSavePotentialCustomerContactListEnabled(Map<String,Object> options){
		return checkOptions(options, CityPartnerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}
 	
 	
			
		

	

	protected CityPartnerMapper getCityPartnerMapper(){
		return new CityPartnerMapper();
	}
	protected CityPartner extractCityPartner(String cityPartnerId) throws Exception{
		String SQL = "select * from city_partner_data where id = ?";	
		try{
		
			CityPartner cityPartner = queryForObject(SQL, new Object[]{cityPartnerId}, getCityPartnerMapper());
			return cityPartner;
		}catch(EmptyResultDataAccessException e){
			throw new CityPartnerNotFoundException("CityPartner("+cityPartnerId+") is not found!");
		}
		
		
	}
	protected CityPartner extractCityPartner(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from city_partner_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			CityPartner cityPartner = queryForObject(SQL, new Object[]{accessKey.getValue()}, getCityPartnerMapper());
			return cityPartner;
		}catch(EmptyResultDataAccessException e){
			throw new CityPartnerNotFoundException("CityPartner("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected CityPartner loadInternalCityPartner(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CityPartner cityPartner = extractCityPartner(accessKey, loadOptions);
 	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(cityPartner, loadOptions);
 		}
 
		
		if(isExtractPotentialCustomerListEnabled(loadOptions)){
	 		extractPotentialCustomerList(cityPartner, loadOptions);
 		}		
		
		if(isExtractPotentialCustomerContactListEnabled(loadOptions)){
	 		extractPotentialCustomerContactList(cityPartner, loadOptions);
 		}		
		
		return cityPartner;
		
	}



	
	
	 

 	protected CityPartner extractCityServiceCenter(CityPartner cityPartner, Map<String,Object> options) throws Exception{

		if(cityPartner.getCityServiceCenter() == null){
			return cityPartner;
		}
		String cityServiceCenterId = cityPartner.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return cityPartner;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			cityPartner.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return cityPartner;
 	}
 		
 
		
	protected CityPartner extractPotentialCustomerList(CityPartner cityPartner, Map<String,Object> options){
		
		SmartList<PotentialCustomer> potentialCustomerList = getPotentialCustomerDAO().findPotentialCustomerByCityPartner(cityPartner.getId(),options);
		if(potentialCustomerList != null){
			cityPartner.setPotentialCustomerList(potentialCustomerList);
		}
		
		return cityPartner;
	
	}	
		
	protected CityPartner extractPotentialCustomerContactList(CityPartner cityPartner, Map<String,Object> options){
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = getPotentialCustomerContactDAO().findPotentialCustomerContactByCityPartner(cityPartner.getId(),options);
		if(potentialCustomerContactList != null){
			cityPartner.setPotentialCustomerContactList(potentialCustomerContactList);
		}
		
		return cityPartner;
	
	}	
		
		
  	
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ?";
		SmartList<CityPartner> cityPartnerList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId}, getCityPartnerMapper());	
 		return cityPartnerList;
 	}
 	
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_service_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<CityPartner> cityPartnerList = queryForList(SQL, new Object[]{retailStoreCityServiceCenterId,start, count}, getCityPartnerMapper());
		
 		return cityPartnerList;
 	}
 	
 	public int countCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where city_service_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCityServiceCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected CityPartner saveCityPartner(CityPartner  cityPartner){
	
		String SQL=this.getSaveCityPartnerSQL(cityPartner);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCityPartnerParameters(cityPartner);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		cityPartner.incVersion();
		return cityPartner;
	
	}
	public SmartList<CityPartner> saveCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCityPartnerList(cityPartnerList);
		
		batchCityPartnerCreate((List<CityPartner>)lists[CREATE_LIST_INDEX]);
		
		batchCityPartnerUpdate((List<CityPartner>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CityPartner cityPartner:cityPartnerList){
			if(cityPartner.isChanged()){
				cityPartner.incVersion();
			}
			
		
		}
		
		
		return cityPartnerList;
	}

	public SmartList<CityPartner> removeCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options){
		
		
		super.removeList(cityPartnerList, options);
		
		return cityPartnerList;
		
		
	}
	
	protected List<Object[]> prepareCityPartnerBatchCreateArgs(List<CityPartner> cityPartnerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityPartner cityPartner:cityPartnerList ){
			Object [] parameters = prepareCityPartnerCreateParameters(cityPartner);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCityPartnerBatchUpdateArgs(List<CityPartner> cityPartnerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityPartner cityPartner:cityPartnerList ){
			if(!cityPartner.isChanged()){
				continue;
			}
			Object [] parameters = prepareCityPartnerUpdateParameters(cityPartner);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCityPartnerCreate(List<CityPartner> cityPartnerList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCityPartnerBatchCreateArgs(cityPartnerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCityPartnerUpdate(List<CityPartner> cityPartnerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCityPartnerBatchUpdateArgs(cityPartnerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCityPartnerList(List<CityPartner> cityPartnerList){
		
		List<CityPartner> cityPartnerCreateList=new ArrayList<CityPartner>();
		List<CityPartner> cityPartnerUpdateList=new ArrayList<CityPartner>();
		
		for(CityPartner cityPartner: cityPartnerList){
			if(isUpdateRequest(cityPartner)){
				cityPartnerUpdateList.add( cityPartner);
				continue;
			}
			cityPartnerCreateList.add(cityPartner);
		}
		
		return new Object[]{cityPartnerCreateList,cityPartnerUpdateList};
	}
	
	protected boolean isUpdateRequest(CityPartner cityPartner){
 		return cityPartner.getVersion() > 0;
 	}
 	protected String getSaveCityPartnerSQL(CityPartner cityPartner){
 		if(isUpdateRequest(cityPartner)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCityPartnerParameters(CityPartner cityPartner){
 		if(isUpdateRequest(cityPartner) ){
 			return prepareCityPartnerUpdateParameters(cityPartner);
 		}
 		return prepareCityPartnerCreateParameters(cityPartner);
 	}
 	protected Object[] prepareCityPartnerUpdateParameters(CityPartner cityPartner){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = cityPartner.getName();
 		parameters[1] = cityPartner.getMobile(); 	
 		if(cityPartner.getCityServiceCenter() != null){
 			parameters[2] = cityPartner.getCityServiceCenter().getId();
 		}
 
 		parameters[3] = cityPartner.getDescription();		
 		parameters[4] = cityPartner.getId();
 		parameters[5] = cityPartner.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCityPartnerCreateParameters(CityPartner cityPartner){
		Object[] parameters = new Object[5];
		String newCityPartnerId=getNextId();
		cityPartner.setId(newCityPartnerId);
		parameters[0] =  cityPartner.getId();
 
 		parameters[1] = cityPartner.getName();
 		parameters[2] = cityPartner.getMobile(); 	
 		if(cityPartner.getCityServiceCenter() != null){
 			parameters[3] = cityPartner.getCityServiceCenter().getId();
 		
 		}
 		
 		parameters[4] = cityPartner.getDescription();		
 				
 		return parameters;
 	}
 	
	protected CityPartner saveInternalCityPartner(CityPartner cityPartner, Map<String,Object> options){
		
		saveCityPartner(cityPartner);
 	
 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(cityPartner, options);
 		}
 
		
		if(isSavePotentialCustomerListEnabled(options)){
	 		savePotentialCustomerList(cityPartner, options);
	 		removePotentialCustomerList(cityPartner, options);
	 		
 		}		
		
		if(isSavePotentialCustomerContactListEnabled(options)){
	 		savePotentialCustomerContactList(cityPartner, options);
	 		removePotentialCustomerContactList(cityPartner, options);
	 		
 		}		
		
		return cityPartner;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CityPartner saveCityServiceCenter(CityPartner cityPartner, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(cityPartner.getCityServiceCenter() == null){
 			return cityPartner;//do nothing when it is null
 		}
 		
 		getRetailStoreCityServiceCenterDAO().save(cityPartner.getCityServiceCenter(),options);
 		return cityPartner;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected CityPartner savePotentialCustomerList(CityPartner cityPartner, Map<String,Object> options){
		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		if(potentialCustomerList == null){
			return cityPartner;
		}
		if(potentialCustomerList.isEmpty()){
			return cityPartner;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPotentialCustomerDAO().savePotentialCustomerList(potentialCustomerList,options);
		
		return cityPartner;
	
	}
	
	protected CityPartner removePotentialCustomerList(CityPartner cityPartner, Map<String,Object> options){
	
	
		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		if(potentialCustomerList == null){
			return cityPartner;
		}	
	
		SmartList<PotentialCustomer> toRemovePotentialCustomerList = potentialCustomerList.getToRemoveList();
		
		if(toRemovePotentialCustomerList == null){
			return cityPartner;
		}
		if(toRemovePotentialCustomerList.isEmpty()){
			return cityPartner;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerDAO().removePotentialCustomerList(toRemovePotentialCustomerList,options);
		
		return cityPartner;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected CityPartner savePotentialCustomerContactList(CityPartner cityPartner, Map<String,Object> options){
		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return cityPartner;
		}
		if(potentialCustomerContactList.isEmpty()){
			return cityPartner;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPotentialCustomerContactDAO().savePotentialCustomerContactList(potentialCustomerContactList,options);
		
		return cityPartner;
	
	}
	
	protected CityPartner removePotentialCustomerContactList(CityPartner cityPartner, Map<String,Object> options){
	
	
		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return cityPartner;
		}	
	
		SmartList<PotentialCustomerContact> toRemovePotentialCustomerContactList = potentialCustomerContactList.getToRemoveList();
		
		if(toRemovePotentialCustomerContactList == null){
			return cityPartner;
		}
		if(toRemovePotentialCustomerContactList.isEmpty()){
			return cityPartner;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerContactDAO().removePotentialCustomerContactList(toRemovePotentialCustomerContactList,options);
		
		return cityPartner;
	
	}
	
	
	
 	
 	
	
	
	
		

	public CityPartner present(CityPartner cityPartner,Map<String, Object> options){
	
		presentPotentialCustomerList(cityPartner,options);
		presentPotentialCustomerContactList(cityPartner,options);

		return cityPartner;
	
	}
		
	
  	
 	protected CityPartner presentPotentialCustomerList(
			CityPartner cityPartner,
			Map<String, Object> options) {

		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();		
		if(potentialCustomerList == null){
			return cityPartner;			
		}
		
		String targetObjectName = "potentialCustomer";
		int potentialCustomerListSize = potentialCustomerList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(potentialCustomerListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return cityPartner;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = potentialCustomerListSize;
		if(potentialCustomerListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPotentialCustomerDAO().countPotentialCustomerByCityPartner(cityPartner.getId(), options);			
		}
		//cityPartner.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//cityPartner.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(potentialCustomerListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(potentialCustomerListSize,currentPage,rowsPerPage) ;
			potentialCustomerList = potentialCustomerList.subListOf(fromIndex, toIndex);
			potentialCustomerList.setTotalCount(count);
			potentialCustomerList.setCurrentPageNumber(currentPage);			
			cityPartner.setPotentialCustomerList(potentialCustomerList);
			return cityPartner;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		potentialCustomerList 
			= getPotentialCustomerDAO().findPotentialCustomerByCityPartner(cityPartner.getId(),start, rowsPerPage, options );
		potentialCustomerList.setTotalCount(count);
		potentialCustomerList.setCurrentPageNumber(currentPage);
		cityPartner.setPotentialCustomerList(potentialCustomerList );	

		return cityPartner;
	}			
		
	
  	
 	protected CityPartner presentPotentialCustomerContactList(
			CityPartner cityPartner,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();		
		if(potentialCustomerContactList == null){
			return cityPartner;			
		}
		
		String targetObjectName = "potentialCustomerContact";
		int potentialCustomerContactListSize = potentialCustomerContactList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(potentialCustomerContactListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return cityPartner;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = potentialCustomerContactListSize;
		if(potentialCustomerContactListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPotentialCustomerContactDAO().countPotentialCustomerContactByCityPartner(cityPartner.getId(), options);			
		}
		//cityPartner.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//cityPartner.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(potentialCustomerContactListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(potentialCustomerContactListSize,currentPage,rowsPerPage) ;
			potentialCustomerContactList = potentialCustomerContactList.subListOf(fromIndex, toIndex);
			potentialCustomerContactList.setTotalCount(count);
			potentialCustomerContactList.setCurrentPageNumber(currentPage);			
			cityPartner.setPotentialCustomerContactList(potentialCustomerContactList);
			return cityPartner;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		potentialCustomerContactList 
			= getPotentialCustomerContactDAO().findPotentialCustomerContactByCityPartner(cityPartner.getId(),start, rowsPerPage, options );
		potentialCustomerContactList.setTotalCount(count);
		potentialCustomerContactList.setCurrentPageNumber(currentPage);
		cityPartner.setPotentialCustomerContactList(potentialCustomerContactList );	

		return cityPartner;
	}			
		


	protected String getTableName(){
		return CityPartnerTable.TABLE_NAME;
	}
}


