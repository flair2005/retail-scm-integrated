
package com.skynet.retailscm.retailstorecityservicecenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.skynet.retailscm.citypartner.CityPartnerDAO;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.skynet.retailscm.cityevent.CityEventDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;

import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;
import com.skynet.retailscm.citypartner.CityPartnerTable;
import com.skynet.retailscm.cityevent.CityEventTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreCityServiceCenterJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreCityServiceCenterDAO{
 
 	
 	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
	 	return this.retailStoreProvinceCenterDAO;
 	}

		
	
  	private  CityPartnerDAO  cityPartnerDAO;
 	public void setCityPartnerDAO(CityPartnerDAO pCityPartnerDAO){
 	
 		if(pCityPartnerDAO == null){
 			throw new IllegalStateException("Do not try to set cityPartnerDAO to null.");
 		}
	 	this.cityPartnerDAO = pCityPartnerDAO;
 	}
 	public CityPartnerDAO getCityPartnerDAO(){
 		if(this.cityPartnerDAO == null){
 			throw new IllegalStateException("The cityPartnerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityPartnerDAO;
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
 	
			
		
	
  	private  CityEventDAO  cityEventDAO;
 	public void setCityEventDAO(CityEventDAO pCityEventDAO){
 	
 		if(pCityEventDAO == null){
 			throw new IllegalStateException("Do not try to set cityEventDAO to null.");
 		}
	 	this.cityEventDAO = pCityEventDAO;
 	}
 	public CityEventDAO getCityEventDAO(){
 		if(this.cityEventDAO == null){
 			throw new IllegalStateException("The cityEventDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityEventDAO;
 	}	
 	
			
		
	
  	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO pRetailStoreDAO){
 	
 		if(pRetailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = pRetailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreCityServiceCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCityServiceCenter(accessKey, options);
	}
	*/
	public RetailStoreCityServiceCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCityServiceCenter(RetailStoreCityServiceCenterTable.withId(id), options);
	}
	
	
	
	public RetailStoreCityServiceCenter save(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options){
		
		String methodName="save(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreCityServiceCenter, methodName, "retailStoreCityServiceCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreCityServiceCenter(retailStoreCityServiceCenter,options);
	}
	public RetailStoreCityServiceCenter clone(String retailStoreCityServiceCenterId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreCityServiceCenterTable.withId(retailStoreCityServiceCenterId),options);
	}
	
	protected RetailStoreCityServiceCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreCityServiceCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreCityServiceCenter newRetailStoreCityServiceCenter = loadInternalRetailStoreCityServiceCenter(accessKey, options);
		newRetailStoreCityServiceCenter.setVersion(0);
		
		
 		
 		if(isSaveCityPartnerListEnabled(options)){
 			for(CityPartner item: newRetailStoreCityServiceCenter.getCityPartnerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePotentialCustomerListEnabled(options)){
 			for(PotentialCustomer item: newRetailStoreCityServiceCenter.getPotentialCustomerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCityEventListEnabled(options)){
 			for(CityEvent item: newRetailStoreCityServiceCenter.getCityEventList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreCityServiceCenter.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreCityServiceCenter(newRetailStoreCityServiceCenter,options);
		
		return newRetailStoreCityServiceCenter;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreCityServiceCenterId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreCityServiceCenterId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreCityServiceCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreCityServiceCenterNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreCityServiceCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreCityServiceCenterId, int version) throws Exception{
	
		String methodName="delete(String retailStoreCityServiceCenterId, int version)";
		assertMethodArgumentNotNull(retailStoreCityServiceCenterId, methodName, "retailStoreCityServiceCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreCityServiceCenterId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreCityServiceCenterId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","founded","belongs_to"};
		return RetailStoreCityServiceCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_city_service_center";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreCityServiceCenterTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreCityServiceCenterTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreCityServiceCenterTokens.BELONGSTO);
 	}
 	

 	
 
		
	//protected static final String CITY_PARTNER_LIST = "cityPartnerList";
	
	protected boolean isExtractCityPartnerListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.CITY_PARTNER_LIST);
		
 	}

	protected boolean isSaveCityPartnerListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.CITY_PARTNER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
	
	protected boolean isExtractPotentialCustomerListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}

	protected boolean isSavePotentialCustomerListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CITY_EVENT_LIST = "cityEventList";
	
	protected boolean isExtractCityEventListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.CITY_EVENT_LIST);
		
 	}

	protected boolean isSaveCityEventListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.CITY_EVENT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreCityServiceCenterMapper getRetailStoreCityServiceCenterMapper(){
		return new RetailStoreCityServiceCenterMapper();
	}
	protected RetailStoreCityServiceCenter extractRetailStoreCityServiceCenter(String retailStoreCityServiceCenterId) throws Exception{
		String SQL = "select * from retail_store_city_service_center_data where id = ?";	
		try{
		
			RetailStoreCityServiceCenter retailStoreCityServiceCenter = queryForObject(SQL, new Object[]{retailStoreCityServiceCenterId}, getRetailStoreCityServiceCenterMapper());
			return retailStoreCityServiceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCityServiceCenterNotFoundException("RetailStoreCityServiceCenter("+retailStoreCityServiceCenterId+") is not found!");
		}
		
		
	}
	protected RetailStoreCityServiceCenter extractRetailStoreCityServiceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_city_service_center_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreCityServiceCenter retailStoreCityServiceCenter = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreCityServiceCenterMapper());
			return retailStoreCityServiceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCityServiceCenterNotFoundException("RetailStoreCityServiceCenter("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreCityServiceCenter loadInternalRetailStoreCityServiceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = extractRetailStoreCityServiceCenter(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(retailStoreCityServiceCenter, loadOptions);
 		}
 
		
		if(isExtractCityPartnerListEnabled(loadOptions)){
	 		extractCityPartnerList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		if(isExtractPotentialCustomerListEnabled(loadOptions)){
	 		extractPotentialCustomerList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		if(isExtractCityEventListEnabled(loadOptions)){
	 		extractCityEventList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		return retailStoreCityServiceCenter;
		
	}



	
	
	 

 	protected RetailStoreCityServiceCenter extractBelongsTo(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options) throws Exception{

		if(retailStoreCityServiceCenter.getBelongsTo() == null){
			return retailStoreCityServiceCenter;
		}
		String belongsToId = retailStoreCityServiceCenter.getBelongsTo().getId();
		if( belongsToId == null){
			return retailStoreCityServiceCenter;
		}
		RetailStoreProvinceCenter belongsTo = getRetailStoreProvinceCenterDAO().load(belongsToId,options);
		if(belongsTo != null){
			retailStoreCityServiceCenter.setBelongsTo(belongsTo);
		}
		
 		
 		return retailStoreCityServiceCenter;
 	}
 		
 
		
	protected RetailStoreCityServiceCenter extractCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		SmartList<CityPartner> cityPartnerList = getCityPartnerDAO().findCityPartnerByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(cityPartnerList != null){
			retailStoreCityServiceCenter.setCityPartnerList(cityPartnerList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
	protected RetailStoreCityServiceCenter extractPotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		SmartList<PotentialCustomer> potentialCustomerList = getPotentialCustomerDAO().findPotentialCustomerByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(potentialCustomerList != null){
			retailStoreCityServiceCenter.setPotentialCustomerList(potentialCustomerList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
	protected RetailStoreCityServiceCenter extractCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		SmartList<CityEvent> cityEventList = getCityEventDAO().findCityEventByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(cityEventList != null){
			retailStoreCityServiceCenter.setCityEventList(cityEventList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
	protected RetailStoreCityServiceCenter extractRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(retailStoreList != null){
			retailStoreCityServiceCenter.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
		
  	
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = queryForList(SQL, new Object[]{retailStoreProvinceCenterId}, getRetailStoreCityServiceCenterMapper());	
 		return retailStoreCityServiceCenterList;
 	}
 	
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = queryForList(SQL, new Object[]{retailStoreProvinceCenterId,start, count}, getRetailStoreCityServiceCenterMapper());
		
 		return retailStoreCityServiceCenterList;
 	}
 	
 	public int countRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreProvinceCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenter(RetailStoreCityServiceCenter  retailStoreCityServiceCenter){
	
		String SQL=this.getSaveRetailStoreCityServiceCenterSQL(retailStoreCityServiceCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreCityServiceCenterParameters(retailStoreCityServiceCenter);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreCityServiceCenter.incVersion();
		return retailStoreCityServiceCenter;
	
	}
	public SmartList<RetailStoreCityServiceCenter> saveRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList);
		
		batchRetailStoreCityServiceCenterCreate((List<RetailStoreCityServiceCenter>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreCityServiceCenterUpdate((List<RetailStoreCityServiceCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList){
			if(retailStoreCityServiceCenter.isChanged()){
				retailStoreCityServiceCenter.incVersion();
			}
			
		
		}
		
		
		return retailStoreCityServiceCenterList;
	}

	public SmartList<RetailStoreCityServiceCenter> removeRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options){
		
		
		super.removeList(retailStoreCityServiceCenterList, options);
		
		return retailStoreCityServiceCenterList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreCityServiceCenterBatchCreateArgs(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList ){
			Object [] parameters = prepareRetailStoreCityServiceCenterCreateParameters(retailStoreCityServiceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreCityServiceCenterBatchUpdateArgs(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList ){
			if(!retailStoreCityServiceCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreCityServiceCenterUpdateParameters(retailStoreCityServiceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreCityServiceCenterCreate(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreCityServiceCenterBatchCreateArgs(retailStoreCityServiceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreCityServiceCenterUpdate(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreCityServiceCenterBatchUpdateArgs(retailStoreCityServiceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreCityServiceCenterList(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		
		List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterCreateList=new ArrayList<RetailStoreCityServiceCenter>();
		List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterUpdateList=new ArrayList<RetailStoreCityServiceCenter>();
		
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter: retailStoreCityServiceCenterList){
			if(isUpdateRequest(retailStoreCityServiceCenter)){
				retailStoreCityServiceCenterUpdateList.add( retailStoreCityServiceCenter);
				continue;
			}
			retailStoreCityServiceCenterCreateList.add(retailStoreCityServiceCenter);
		}
		
		return new Object[]{retailStoreCityServiceCenterCreateList,retailStoreCityServiceCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		return retailStoreCityServiceCenter.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreCityServiceCenterSQL(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		if(isUpdateRequest(retailStoreCityServiceCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreCityServiceCenterParameters(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		if(isUpdateRequest(retailStoreCityServiceCenter) ){
 			return prepareRetailStoreCityServiceCenterUpdateParameters(retailStoreCityServiceCenter);
 		}
 		return prepareRetailStoreCityServiceCenterCreateParameters(retailStoreCityServiceCenter);
 	}
 	protected Object[] prepareRetailStoreCityServiceCenterUpdateParameters(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreCityServiceCenter.getName();
 		parameters[1] = retailStoreCityServiceCenter.getFounded(); 	
 		if(retailStoreCityServiceCenter.getBelongsTo() != null){
 			parameters[2] = retailStoreCityServiceCenter.getBelongsTo().getId();
 		}
 		
 		parameters[3] = retailStoreCityServiceCenter.getId();
 		parameters[4] = retailStoreCityServiceCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCityServiceCenterCreateParameters(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
		Object[] parameters = new Object[4];
		String newRetailStoreCityServiceCenterId=getNextId();
		retailStoreCityServiceCenter.setId(newRetailStoreCityServiceCenterId);
		parameters[0] =  retailStoreCityServiceCenter.getId();
 
 		parameters[1] = retailStoreCityServiceCenter.getName();
 		parameters[2] = retailStoreCityServiceCenter.getFounded(); 	
 		if(retailStoreCityServiceCenter.getBelongsTo() != null){
 			parameters[3] = retailStoreCityServiceCenter.getBelongsTo().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreCityServiceCenter saveInternalRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		saveRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(retailStoreCityServiceCenter, options);
 		}
 
		
		if(isSaveCityPartnerListEnabled(options)){
	 		saveCityPartnerList(retailStoreCityServiceCenter, options);
	 		removeCityPartnerList(retailStoreCityServiceCenter, options);
	 		
 		}		
		
		if(isSavePotentialCustomerListEnabled(options)){
	 		savePotentialCustomerList(retailStoreCityServiceCenter, options);
	 		removePotentialCustomerList(retailStoreCityServiceCenter, options);
	 		
 		}		
		
		if(isSaveCityEventListEnabled(options)){
	 		saveCityEventList(retailStoreCityServiceCenter, options);
	 		removeCityEventList(retailStoreCityServiceCenter, options);
	 		
 		}		
		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreCityServiceCenter, options);
	 		removeRetailStoreList(retailStoreCityServiceCenter, options);
	 		
 		}		
		
		return retailStoreCityServiceCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreCityServiceCenter saveBelongsTo(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreCityServiceCenter.getBelongsTo() == null){
 			return retailStoreCityServiceCenter;//do nothing when it is null
 		}
 		
 		getRetailStoreProvinceCenterDAO().save(retailStoreCityServiceCenter.getBelongsTo(),options);
 		return retailStoreCityServiceCenter;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected RetailStoreCityServiceCenter saveCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		SmartList<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();
		if(cityPartnerList == null){
			return retailStoreCityServiceCenter;
		}
		if(cityPartnerList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCityPartnerDAO().saveCityPartnerList(cityPartnerList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removeCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();
		if(cityPartnerList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<CityPartner> toRemoveCityPartnerList = cityPartnerList.getToRemoveList();
		
		if(toRemoveCityPartnerList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemoveCityPartnerList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityPartnerDAO().removeCityPartnerList(toRemoveCityPartnerList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCityServiceCenter savePotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();
		if(potentialCustomerList == null){
			return retailStoreCityServiceCenter;
		}
		if(potentialCustomerList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPotentialCustomerDAO().savePotentialCustomerList(potentialCustomerList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removePotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();
		if(potentialCustomerList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<PotentialCustomer> toRemovePotentialCustomerList = potentialCustomerList.getToRemoveList();
		
		if(toRemovePotentialCustomerList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemovePotentialCustomerList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerDAO().removePotentialCustomerList(toRemovePotentialCustomerList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCityServiceCenter saveCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		SmartList<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();
		if(cityEventList == null){
			return retailStoreCityServiceCenter;
		}
		if(cityEventList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCityEventDAO().saveCityEventList(cityEventList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removeCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();
		if(cityEventList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<CityEvent> toRemoveCityEventList = cityEventList.getToRemoveList();
		
		if(toRemoveCityEventList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemoveCityEventList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityEventDAO().removeCityEventList(toRemoveCityEventList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCityServiceCenter saveRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCityServiceCenter;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removeRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreCityServiceCenter present(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String, Object> options){
	
		presentCityPartnerList(retailStoreCityServiceCenter,options);
		presentPotentialCustomerList(retailStoreCityServiceCenter,options);
		presentCityEventList(retailStoreCityServiceCenter,options);
		presentRetailStoreList(retailStoreCityServiceCenter,options);

		return retailStoreCityServiceCenter;
	
	}
		
	
  	
 	protected RetailStoreCityServiceCenter presentCityPartnerList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();		
		if(cityPartnerList == null){
			return retailStoreCityServiceCenter;			
		}
		
		String targetObjectName = "cityPartner";
		int cityPartnerListSize = cityPartnerList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(cityPartnerListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCityServiceCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = cityPartnerListSize;
		if(cityPartnerListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getCityPartnerDAO().countCityPartnerByCityServiceCenter(retailStoreCityServiceCenter.getId(), options);			
		}
		//retailStoreCityServiceCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCityServiceCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(cityPartnerListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(cityPartnerListSize,currentPage,rowsPerPage) ;
			cityPartnerList = cityPartnerList.subListOf(fromIndex, toIndex);
			cityPartnerList.setTotalCount(count);
			cityPartnerList.setCurrentPageNumber(currentPage);			
			retailStoreCityServiceCenter.setCityPartnerList(cityPartnerList);
			return retailStoreCityServiceCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		cityPartnerList 
			= getCityPartnerDAO().findCityPartnerByCityServiceCenter(retailStoreCityServiceCenter.getId(),start, rowsPerPage, options );
		cityPartnerList.setTotalCount(count);
		cityPartnerList.setCurrentPageNumber(currentPage);
		retailStoreCityServiceCenter.setCityPartnerList(cityPartnerList );	

		return retailStoreCityServiceCenter;
	}			
		
	
  	
 	protected RetailStoreCityServiceCenter presentPotentialCustomerList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();		
		if(potentialCustomerList == null){
			return retailStoreCityServiceCenter;			
		}
		
		String targetObjectName = "potentialCustomer";
		int potentialCustomerListSize = potentialCustomerList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(potentialCustomerListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCityServiceCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = potentialCustomerListSize;
		if(potentialCustomerListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPotentialCustomerDAO().countPotentialCustomerByCityServiceCenter(retailStoreCityServiceCenter.getId(), options);			
		}
		//retailStoreCityServiceCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCityServiceCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(potentialCustomerListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(potentialCustomerListSize,currentPage,rowsPerPage) ;
			potentialCustomerList = potentialCustomerList.subListOf(fromIndex, toIndex);
			potentialCustomerList.setTotalCount(count);
			potentialCustomerList.setCurrentPageNumber(currentPage);			
			retailStoreCityServiceCenter.setPotentialCustomerList(potentialCustomerList);
			return retailStoreCityServiceCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		potentialCustomerList 
			= getPotentialCustomerDAO().findPotentialCustomerByCityServiceCenter(retailStoreCityServiceCenter.getId(),start, rowsPerPage, options );
		potentialCustomerList.setTotalCount(count);
		potentialCustomerList.setCurrentPageNumber(currentPage);
		retailStoreCityServiceCenter.setPotentialCustomerList(potentialCustomerList );	

		return retailStoreCityServiceCenter;
	}			
		
	
  	
 	protected RetailStoreCityServiceCenter presentCityEventList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();		
		if(cityEventList == null){
			return retailStoreCityServiceCenter;			
		}
		
		String targetObjectName = "cityEvent";
		int cityEventListSize = cityEventList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(cityEventListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCityServiceCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = cityEventListSize;
		if(cityEventListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getCityEventDAO().countCityEventByCityServiceCenter(retailStoreCityServiceCenter.getId(), options);			
		}
		//retailStoreCityServiceCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCityServiceCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(cityEventListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(cityEventListSize,currentPage,rowsPerPage) ;
			cityEventList = cityEventList.subListOf(fromIndex, toIndex);
			cityEventList.setTotalCount(count);
			cityEventList.setCurrentPageNumber(currentPage);			
			retailStoreCityServiceCenter.setCityEventList(cityEventList);
			return retailStoreCityServiceCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		cityEventList 
			= getCityEventDAO().findCityEventByCityServiceCenter(retailStoreCityServiceCenter.getId(),start, rowsPerPage, options );
		cityEventList.setTotalCount(count);
		cityEventList.setCurrentPageNumber(currentPage);
		retailStoreCityServiceCenter.setCityEventList(cityEventList );	

		return retailStoreCityServiceCenter;
	}			
		
	
  	
 	protected RetailStoreCityServiceCenter presentRetailStoreList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreCityServiceCenter;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCityServiceCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByCityServiceCenter(retailStoreCityServiceCenter.getId(), options);			
		}
		//retailStoreCityServiceCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCityServiceCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreCityServiceCenter.setRetailStoreList(retailStoreList);
			return retailStoreCityServiceCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByCityServiceCenter(retailStoreCityServiceCenter.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreCityServiceCenter.setRetailStoreList(retailStoreList );	

		return retailStoreCityServiceCenter;
	}			
		


	protected String getTableName(){
		return RetailStoreCityServiceCenterTable.TABLE_NAME;
	}
}


