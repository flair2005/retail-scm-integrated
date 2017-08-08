
package com.skynet.retailscm.retailstoreprovincecenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployeeTable;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartmentTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreProvinceCenterJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreProvinceCenterDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  ProvinceCenterDepartmentDAO  provinceCenterDepartmentDAO;
 	public void setProvinceCenterDepartmentDAO(ProvinceCenterDepartmentDAO pProvinceCenterDepartmentDAO){
 	
 		if(pProvinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterDepartmentDAO to null.");
 		}
	 	this.provinceCenterDepartmentDAO = pProvinceCenterDepartmentDAO;
 	}
 	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO(){
 		if(this.provinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("The provinceCenterDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterDepartmentDAO;
 	}	
 	
			
		
	
  	private  ProvinceCenterEmployeeDAO  provinceCenterEmployeeDAO;
 	public void setProvinceCenterEmployeeDAO(ProvinceCenterEmployeeDAO pProvinceCenterEmployeeDAO){
 	
 		if(pProvinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterEmployeeDAO to null.");
 		}
	 	this.provinceCenterEmployeeDAO = pProvinceCenterEmployeeDAO;
 	}
 	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO(){
 		if(this.provinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("The provinceCenterEmployeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterEmployeeDAO;
 	}	
 	
			
		
	
  	private  RetailStoreCityServiceCenterDAO  retailStoreCityServiceCenterDAO;
 	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO pRetailStoreCityServiceCenterDAO){
 	
 		if(pRetailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCityServiceCenterDAO to null.");
 		}
	 	this.retailStoreCityServiceCenterDAO = pRetailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
 		if(this.retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCityServiceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCityServiceCenterDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreProvinceCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreProvinceCenter(accessKey, options);
	}
	*/
	public RetailStoreProvinceCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreProvinceCenter(RetailStoreProvinceCenterTable.withId(id), options);
	}
	
	
	
	public RetailStoreProvinceCenter save(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options){
		
		String methodName="save(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreProvinceCenter, methodName, "retailStoreProvinceCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreProvinceCenter(retailStoreProvinceCenter,options);
	}
	public RetailStoreProvinceCenter clone(String retailStoreProvinceCenterId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreProvinceCenterTable.withId(retailStoreProvinceCenterId),options);
	}
	
	protected RetailStoreProvinceCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreProvinceCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreProvinceCenter newRetailStoreProvinceCenter = loadInternalRetailStoreProvinceCenter(accessKey, options);
		newRetailStoreProvinceCenter.setVersion(0);
		
		
 		
 		if(isSaveProvinceCenterDepartmentListEnabled(options)){
 			for(ProvinceCenterDepartment item: newRetailStoreProvinceCenter.getProvinceCenterDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProvinceCenterEmployeeListEnabled(options)){
 			for(ProvinceCenterEmployee item: newRetailStoreProvinceCenter.getProvinceCenterEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreCityServiceCenterListEnabled(options)){
 			for(RetailStoreCityServiceCenter item: newRetailStoreProvinceCenter.getRetailStoreCityServiceCenterList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreProvinceCenter(newRetailStoreProvinceCenter,options);
		
		return newRetailStoreProvinceCenter;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreProvinceCenterId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreProvinceCenterId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreProvinceCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreProvinceCenterNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreProvinceCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreProvinceCenterId, int version) throws Exception{
	
		String methodName="delete(String retailStoreProvinceCenterId, int version)";
		assertMethodArgumentNotNull(retailStoreProvinceCenterId, methodName, "retailStoreProvinceCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreProvinceCenterId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreProvinceCenterId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","founded","country"};
		return RetailStoreProvinceCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_province_center";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreProvinceCenterTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCountryEnabled = true;
 	//private static final String COUNTRY = "country";
 	protected boolean isExtractCountryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreProvinceCenterTokens.COUNTRY);
 	}
 	
 	
 	//private boolean saveCountryEnabled = true;
 	protected boolean isSaveCountryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreProvinceCenterTokens.COUNTRY);
 	}
 	

 	
 
		
	//protected static final String PROVINCE_CENTER_DEPARTMENT_LIST = "provinceCenterDepartmentList";
	
	protected boolean isExtractProvinceCenterDepartmentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreProvinceCenterTokens.PROVINCE_CENTER_DEPARTMENT_LIST);
		
 	}

	protected boolean isSaveProvinceCenterDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreProvinceCenterTokens.PROVINCE_CENTER_DEPARTMENT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String PROVINCE_CENTER_EMPLOYEE_LIST = "provinceCenterEmployeeList";
	
	protected boolean isExtractProvinceCenterEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreProvinceCenterTokens.PROVINCE_CENTER_EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveProvinceCenterEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreProvinceCenterTokens.PROVINCE_CENTER_EMPLOYEE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_CITY_SERVICE_CENTER_LIST = "retailStoreCityServiceCenterList";
	
	protected boolean isExtractRetailStoreCityServiceCenterListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreProvinceCenterTokens.RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
		
 	}

	protected boolean isSaveRetailStoreCityServiceCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreProvinceCenterTokens.RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreProvinceCenterMapper getRetailStoreProvinceCenterMapper(){
		return new RetailStoreProvinceCenterMapper();
	}
	protected RetailStoreProvinceCenter extractRetailStoreProvinceCenter(String retailStoreProvinceCenterId) throws Exception{
		String SQL = "select * from retail_store_province_center_data where id = ?";	
		try{
		
			RetailStoreProvinceCenter retailStoreProvinceCenter = queryForObject(SQL, new Object[]{retailStoreProvinceCenterId}, getRetailStoreProvinceCenterMapper());
			return retailStoreProvinceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreProvinceCenterNotFoundException("RetailStoreProvinceCenter("+retailStoreProvinceCenterId+") is not found!");
		}
		
		
	}
	protected RetailStoreProvinceCenter extractRetailStoreProvinceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_province_center_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreProvinceCenter retailStoreProvinceCenter = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreProvinceCenterMapper());
			return retailStoreProvinceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreProvinceCenterNotFoundException("RetailStoreProvinceCenter("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreProvinceCenter loadInternalRetailStoreProvinceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = extractRetailStoreProvinceCenter(accessKey, loadOptions);
 	
 		if(isExtractCountryEnabled(loadOptions)){
	 		extractCountry(retailStoreProvinceCenter, loadOptions);
 		}
 
		
		if(isExtractProvinceCenterDepartmentListEnabled(loadOptions)){
	 		extractProvinceCenterDepartmentList(retailStoreProvinceCenter, loadOptions);
 		}		
		
		if(isExtractProvinceCenterEmployeeListEnabled(loadOptions)){
	 		extractProvinceCenterEmployeeList(retailStoreProvinceCenter, loadOptions);
 		}		
		
		if(isExtractRetailStoreCityServiceCenterListEnabled(loadOptions)){
	 		extractRetailStoreCityServiceCenterList(retailStoreProvinceCenter, loadOptions);
 		}		
		
		return retailStoreProvinceCenter;
		
	}



	
	
	 

 	protected RetailStoreProvinceCenter extractCountry(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options) throws Exception{

		if(retailStoreProvinceCenter.getCountry() == null){
			return retailStoreProvinceCenter;
		}
		String countryId = retailStoreProvinceCenter.getCountry().getId();
		if( countryId == null){
			return retailStoreProvinceCenter;
		}
		RetailStoreCountryCenter country = getRetailStoreCountryCenterDAO().load(countryId,options);
		if(country != null){
			retailStoreProvinceCenter.setCountry(country);
		}
		
 		
 		return retailStoreProvinceCenter;
 	}
 		
 
		
	protected RetailStoreProvinceCenter extractProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = getProvinceCenterDepartmentDAO().findProvinceCenterDepartmentByProvinceCenter(retailStoreProvinceCenter.getId(),options);
		if(provinceCenterDepartmentList != null){
			retailStoreProvinceCenter.setProvinceCenterDepartmentList(provinceCenterDepartmentList);
		}
		
		return retailStoreProvinceCenter;
	
	}	
		
	protected RetailStoreProvinceCenter extractProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeByProvinceCenter(retailStoreProvinceCenter.getId(),options);
		if(provinceCenterEmployeeList != null){
			retailStoreProvinceCenter.setProvinceCenterEmployeeList(provinceCenterEmployeeList);
		}
		
		return retailStoreProvinceCenter;
	
	}	
		
	protected RetailStoreProvinceCenter extractRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = getRetailStoreCityServiceCenterDAO().findRetailStoreCityServiceCenterByBelongsTo(retailStoreProvinceCenter.getId(),options);
		if(retailStoreCityServiceCenterList != null){
			retailStoreProvinceCenter.setRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList);
		}
		
		return retailStoreProvinceCenter;
	
	}	
		
		
  	
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where country = ?";
		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getRetailStoreProvinceCenterMapper());	
 		return retailStoreProvinceCenterList;
 	}
 	
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where country = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getRetailStoreProvinceCenterMapper());
		
 		return retailStoreProvinceCenterList;
 	}
 	
 	public int countRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where country = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(RetailStoreProvinceCenter  retailStoreProvinceCenter){
	
		String SQL=this.getSaveRetailStoreProvinceCenterSQL(retailStoreProvinceCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreProvinceCenterParameters(retailStoreProvinceCenter);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreProvinceCenter.incVersion();
		return retailStoreProvinceCenter;
	
	}
	public SmartList<RetailStoreProvinceCenter> saveRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreProvinceCenterList(retailStoreProvinceCenterList);
		
		batchRetailStoreProvinceCenterCreate((List<RetailStoreProvinceCenter>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreProvinceCenterUpdate((List<RetailStoreProvinceCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList){
			if(retailStoreProvinceCenter.isChanged()){
				retailStoreProvinceCenter.incVersion();
			}
			
		
		}
		
		
		return retailStoreProvinceCenterList;
	}

	public SmartList<RetailStoreProvinceCenter> removeRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options){
		
		
		super.removeList(retailStoreProvinceCenterList, options);
		
		return retailStoreProvinceCenterList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreProvinceCenterBatchCreateArgs(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList ){
			Object [] parameters = prepareRetailStoreProvinceCenterCreateParameters(retailStoreProvinceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreProvinceCenterBatchUpdateArgs(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList ){
			if(!retailStoreProvinceCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreProvinceCenterUpdateParameters(retailStoreProvinceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreProvinceCenterCreate(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreProvinceCenterBatchCreateArgs(retailStoreProvinceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreProvinceCenterUpdate(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreProvinceCenterBatchUpdateArgs(retailStoreProvinceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreProvinceCenterList(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		
		List<RetailStoreProvinceCenter> retailStoreProvinceCenterCreateList=new ArrayList<RetailStoreProvinceCenter>();
		List<RetailStoreProvinceCenter> retailStoreProvinceCenterUpdateList=new ArrayList<RetailStoreProvinceCenter>();
		
		for(RetailStoreProvinceCenter retailStoreProvinceCenter: retailStoreProvinceCenterList){
			if(isUpdateRequest(retailStoreProvinceCenter)){
				retailStoreProvinceCenterUpdateList.add( retailStoreProvinceCenter);
				continue;
			}
			retailStoreProvinceCenterCreateList.add(retailStoreProvinceCenter);
		}
		
		return new Object[]{retailStoreProvinceCenterCreateList,retailStoreProvinceCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		return retailStoreProvinceCenter.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreProvinceCenterSQL(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		if(isUpdateRequest(retailStoreProvinceCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreProvinceCenterParameters(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		if(isUpdateRequest(retailStoreProvinceCenter) ){
 			return prepareRetailStoreProvinceCenterUpdateParameters(retailStoreProvinceCenter);
 		}
 		return prepareRetailStoreProvinceCenterCreateParameters(retailStoreProvinceCenter);
 	}
 	protected Object[] prepareRetailStoreProvinceCenterUpdateParameters(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreProvinceCenter.getName();
 		parameters[1] = retailStoreProvinceCenter.getFounded(); 	
 		if(retailStoreProvinceCenter.getCountry() != null){
 			parameters[2] = retailStoreProvinceCenter.getCountry().getId();
 		}
 		
 		parameters[3] = retailStoreProvinceCenter.getId();
 		parameters[4] = retailStoreProvinceCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreProvinceCenterCreateParameters(RetailStoreProvinceCenter retailStoreProvinceCenter){
		Object[] parameters = new Object[4];
		String newRetailStoreProvinceCenterId=getNextId();
		retailStoreProvinceCenter.setId(newRetailStoreProvinceCenterId);
		parameters[0] =  retailStoreProvinceCenter.getId();
 
 		parameters[1] = retailStoreProvinceCenter.getName();
 		parameters[2] = retailStoreProvinceCenter.getFounded(); 	
 		if(retailStoreProvinceCenter.getCountry() != null){
 			parameters[3] = retailStoreProvinceCenter.getCountry().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreProvinceCenter saveInternalRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		saveRetailStoreProvinceCenter(retailStoreProvinceCenter);
 	
 		if(isSaveCountryEnabled(options)){
	 		saveCountry(retailStoreProvinceCenter, options);
 		}
 
		
		if(isSaveProvinceCenterDepartmentListEnabled(options)){
	 		saveProvinceCenterDepartmentList(retailStoreProvinceCenter, options);
	 		removeProvinceCenterDepartmentList(retailStoreProvinceCenter, options);
	 		
 		}		
		
		if(isSaveProvinceCenterEmployeeListEnabled(options)){
	 		saveProvinceCenterEmployeeList(retailStoreProvinceCenter, options);
	 		removeProvinceCenterEmployeeList(retailStoreProvinceCenter, options);
	 		
 		}		
		
		if(isSaveRetailStoreCityServiceCenterListEnabled(options)){
	 		saveRetailStoreCityServiceCenterList(retailStoreProvinceCenter, options);
	 		removeRetailStoreCityServiceCenterList(retailStoreProvinceCenter, options);
	 		
 		}		
		
		return retailStoreProvinceCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreProvinceCenter saveCountry(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreProvinceCenter.getCountry() == null){
 			return retailStoreProvinceCenter;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(retailStoreProvinceCenter.getCountry(),options);
 		return retailStoreProvinceCenter;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected RetailStoreProvinceCenter saveProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();
		if(provinceCenterDepartmentList == null){
			return retailStoreProvinceCenter;
		}
		if(provinceCenterDepartmentList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getProvinceCenterDepartmentDAO().saveProvinceCenterDepartmentList(provinceCenterDepartmentList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	protected RetailStoreProvinceCenter removeProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
	
	
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();
		if(provinceCenterDepartmentList == null){
			return retailStoreProvinceCenter;
		}	
	
		SmartList<ProvinceCenterDepartment> toRemoveProvinceCenterDepartmentList = provinceCenterDepartmentList.getToRemoveList();
		
		if(toRemoveProvinceCenterDepartmentList == null){
			return retailStoreProvinceCenter;
		}
		if(toRemoveProvinceCenterDepartmentList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProvinceCenterDepartmentDAO().removeProvinceCenterDepartmentList(toRemoveProvinceCenterDepartmentList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreProvinceCenter saveProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;
		}
		if(provinceCenterEmployeeList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getProvinceCenterEmployeeDAO().saveProvinceCenterEmployeeList(provinceCenterEmployeeList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	protected RetailStoreProvinceCenter removeProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
	
	
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;
		}	
	
		SmartList<ProvinceCenterEmployee> toRemoveProvinceCenterEmployeeList = provinceCenterEmployeeList.getToRemoveList();
		
		if(toRemoveProvinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;
		}
		if(toRemoveProvinceCenterEmployeeList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProvinceCenterEmployeeDAO().removeProvinceCenterEmployeeList(toRemoveProvinceCenterEmployeeList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreProvinceCenter saveRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();
		if(retailStoreCityServiceCenterList == null){
			return retailStoreProvinceCenter;
		}
		if(retailStoreCityServiceCenterList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreCityServiceCenterDAO().saveRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	protected RetailStoreProvinceCenter removeRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
	
	
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();
		if(retailStoreCityServiceCenterList == null){
			return retailStoreProvinceCenter;
		}	
	
		SmartList<RetailStoreCityServiceCenter> toRemoveRetailStoreCityServiceCenterList = retailStoreCityServiceCenterList.getToRemoveList();
		
		if(toRemoveRetailStoreCityServiceCenterList == null){
			return retailStoreProvinceCenter;
		}
		if(toRemoveRetailStoreCityServiceCenterList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreCityServiceCenterDAO().removeRetailStoreCityServiceCenterList(toRemoveRetailStoreCityServiceCenterList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreProvinceCenter present(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String, Object> options){
	
		presentProvinceCenterDepartmentList(retailStoreProvinceCenter,options);
		presentProvinceCenterEmployeeList(retailStoreProvinceCenter,options);
		presentRetailStoreCityServiceCenterList(retailStoreProvinceCenter,options);

		return retailStoreProvinceCenter;
	
	}
		
	
  	
 	protected RetailStoreProvinceCenter presentProvinceCenterDepartmentList(
			RetailStoreProvinceCenter retailStoreProvinceCenter,
			Map<String, Object> options) {

		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();		
		if(provinceCenterDepartmentList == null){
			return retailStoreProvinceCenter;			
		}
		
		String targetObjectName = "provinceCenterDepartment";
		int provinceCenterDepartmentListSize = provinceCenterDepartmentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(provinceCenterDepartmentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreProvinceCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = provinceCenterDepartmentListSize;
		if(provinceCenterDepartmentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getProvinceCenterDepartmentDAO().countProvinceCenterDepartmentByProvinceCenter(retailStoreProvinceCenter.getId(), options);			
		}
		//retailStoreProvinceCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreProvinceCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(provinceCenterDepartmentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(provinceCenterDepartmentListSize,currentPage,rowsPerPage) ;
			provinceCenterDepartmentList = provinceCenterDepartmentList.subListOf(fromIndex, toIndex);
			provinceCenterDepartmentList.setTotalCount(count);
			provinceCenterDepartmentList.setCurrentPageNumber(currentPage);			
			retailStoreProvinceCenter.setProvinceCenterDepartmentList(provinceCenterDepartmentList);
			return retailStoreProvinceCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		provinceCenterDepartmentList 
			= getProvinceCenterDepartmentDAO().findProvinceCenterDepartmentByProvinceCenter(retailStoreProvinceCenter.getId(),start, rowsPerPage, options );
		provinceCenterDepartmentList.setTotalCount(count);
		provinceCenterDepartmentList.setCurrentPageNumber(currentPage);
		retailStoreProvinceCenter.setProvinceCenterDepartmentList(provinceCenterDepartmentList );	

		return retailStoreProvinceCenter;
	}			
		
	
  	
 	protected RetailStoreProvinceCenter presentProvinceCenterEmployeeList(
			RetailStoreProvinceCenter retailStoreProvinceCenter,
			Map<String, Object> options) {

		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();		
		if(provinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;			
		}
		
		String targetObjectName = "provinceCenterEmployee";
		int provinceCenterEmployeeListSize = provinceCenterEmployeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(provinceCenterEmployeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreProvinceCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = provinceCenterEmployeeListSize;
		if(provinceCenterEmployeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getProvinceCenterEmployeeDAO().countProvinceCenterEmployeeByProvinceCenter(retailStoreProvinceCenter.getId(), options);			
		}
		//retailStoreProvinceCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreProvinceCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(provinceCenterEmployeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(provinceCenterEmployeeListSize,currentPage,rowsPerPage) ;
			provinceCenterEmployeeList = provinceCenterEmployeeList.subListOf(fromIndex, toIndex);
			provinceCenterEmployeeList.setTotalCount(count);
			provinceCenterEmployeeList.setCurrentPageNumber(currentPage);			
			retailStoreProvinceCenter.setProvinceCenterEmployeeList(provinceCenterEmployeeList);
			return retailStoreProvinceCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		provinceCenterEmployeeList 
			= getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeByProvinceCenter(retailStoreProvinceCenter.getId(),start, rowsPerPage, options );
		provinceCenterEmployeeList.setTotalCount(count);
		provinceCenterEmployeeList.setCurrentPageNumber(currentPage);
		retailStoreProvinceCenter.setProvinceCenterEmployeeList(provinceCenterEmployeeList );	

		return retailStoreProvinceCenter;
	}			
		
	
  	
 	protected RetailStoreProvinceCenter presentRetailStoreCityServiceCenterList(
			RetailStoreProvinceCenter retailStoreProvinceCenter,
			Map<String, Object> options) {

		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();		
		if(retailStoreCityServiceCenterList == null){
			return retailStoreProvinceCenter;			
		}
		
		String targetObjectName = "retailStoreCityServiceCenter";
		int retailStoreCityServiceCenterListSize = retailStoreCityServiceCenterList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreCityServiceCenterListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreProvinceCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreCityServiceCenterListSize;
		if(retailStoreCityServiceCenterListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreCityServiceCenterDAO().countRetailStoreCityServiceCenterByBelongsTo(retailStoreProvinceCenter.getId(), options);			
		}
		//retailStoreProvinceCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreProvinceCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreCityServiceCenterListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreCityServiceCenterListSize,currentPage,rowsPerPage) ;
			retailStoreCityServiceCenterList = retailStoreCityServiceCenterList.subListOf(fromIndex, toIndex);
			retailStoreCityServiceCenterList.setTotalCount(count);
			retailStoreCityServiceCenterList.setCurrentPageNumber(currentPage);			
			retailStoreProvinceCenter.setRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList);
			return retailStoreProvinceCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreCityServiceCenterList 
			= getRetailStoreCityServiceCenterDAO().findRetailStoreCityServiceCenterByBelongsTo(retailStoreProvinceCenter.getId(),start, rowsPerPage, options );
		retailStoreCityServiceCenterList.setTotalCount(count);
		retailStoreCityServiceCenterList.setCurrentPageNumber(currentPage);
		retailStoreProvinceCenter.setRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList );	

		return retailStoreProvinceCenter;
	}			
		


	protected String getTableName(){
		return RetailStoreProvinceCenterTable.TABLE_NAME;
	}
}


