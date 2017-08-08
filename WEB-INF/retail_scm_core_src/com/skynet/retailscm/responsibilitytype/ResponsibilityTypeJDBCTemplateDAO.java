
package com.skynet.retailscm.responsibilitytype;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employee.EmployeeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ResponsibilityTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ResponsibilityTypeDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO pEmployeeDAO){
 	
 		if(pEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = pEmployeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}	
 	
			
		

	
	/*
	protected ResponsibilityType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalResponsibilityType(accessKey, options);
	}
	*/
	public ResponsibilityType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalResponsibilityType(ResponsibilityTypeTable.withId(id), options);
	}
	
	
	
	public ResponsibilityType save(ResponsibilityType responsibilityType,Map<String,Object> options){
		
		String methodName="save(ResponsibilityType responsibilityType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(responsibilityType, methodName, "responsibilityType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalResponsibilityType(responsibilityType,options);
	}
	public ResponsibilityType clone(String responsibilityTypeId, Map<String,Object> options) throws Exception{
	
		return clone(ResponsibilityTypeTable.withId(responsibilityTypeId),options);
	}
	
	protected ResponsibilityType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String responsibilityTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ResponsibilityType newResponsibilityType = loadInternalResponsibilityType(accessKey, options);
		newResponsibilityType.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newResponsibilityType.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalResponsibilityType(newResponsibilityType,options);
		
		return newResponsibilityType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String responsibilityTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{responsibilityTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ResponsibilityTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ResponsibilityTypeNotFoundException(
					"The " + this.getTableName() + "(" + responsibilityTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String responsibilityTypeId, int version) throws Exception{
	
		String methodName="delete(String responsibilityTypeId, int version)";
		assertMethodArgumentNotNull(responsibilityTypeId, methodName, "responsibilityTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{responsibilityTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(responsibilityTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","base_description","detail_description"};
		return ResponsibilityTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "responsibility_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ResponsibilityTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ResponsibilityTypeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ResponsibilityTypeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ResponsibilityTypeTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, ResponsibilityTypeTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected ResponsibilityTypeMapper getResponsibilityTypeMapper(){
		return new ResponsibilityTypeMapper();
	}
	protected ResponsibilityType extractResponsibilityType(String responsibilityTypeId) throws Exception{
		String SQL = "select * from responsibility_type_data where id = ?";	
		try{
		
			ResponsibilityType responsibilityType = queryForObject(SQL, new Object[]{responsibilityTypeId}, getResponsibilityTypeMapper());
			return responsibilityType;
		}catch(EmptyResultDataAccessException e){
			throw new ResponsibilityTypeNotFoundException("ResponsibilityType("+responsibilityTypeId+") is not found!");
		}
		
		
	}
	protected ResponsibilityType extractResponsibilityType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from responsibility_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ResponsibilityType responsibilityType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getResponsibilityTypeMapper());
			return responsibilityType;
		}catch(EmptyResultDataAccessException e){
			throw new ResponsibilityTypeNotFoundException("ResponsibilityType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ResponsibilityType loadInternalResponsibilityType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ResponsibilityType responsibilityType = extractResponsibilityType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(responsibilityType, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(responsibilityType, loadOptions);
 		}		
		
		return responsibilityType;
		
	}



	
	
	 

 	protected ResponsibilityType extractCompany(ResponsibilityType responsibilityType, Map<String,Object> options) throws Exception{

		if(responsibilityType.getCompany() == null){
			return responsibilityType;
		}
		String companyId = responsibilityType.getCompany().getId();
		if( companyId == null){
			return responsibilityType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			responsibilityType.setCompany(company);
		}
		
 		
 		return responsibilityType;
 	}
 		
 
		
	protected ResponsibilityType extractEmployeeList(ResponsibilityType responsibilityType, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByResponsibleFor(responsibilityType.getId(),options);
		if(employeeList != null){
			responsibilityType.setEmployeeList(employeeList);
		}
		
		return responsibilityType;
	
	}	
		
		
  	
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<ResponsibilityType> responsibilityTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getResponsibilityTypeMapper());	
 		return responsibilityTypeList;
 	}
 	
 	public SmartList<ResponsibilityType> findResponsibilityTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ResponsibilityType> responsibilityTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getResponsibilityTypeMapper());
		
 		return responsibilityTypeList;
 	}
 	
 	public int countResponsibilityTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ResponsibilityType saveResponsibilityType(ResponsibilityType  responsibilityType){
	
		String SQL=this.getSaveResponsibilityTypeSQL(responsibilityType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveResponsibilityTypeParameters(responsibilityType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		responsibilityType.incVersion();
		return responsibilityType;
	
	}
	public SmartList<ResponsibilityType> saveResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitResponsibilityTypeList(responsibilityTypeList);
		
		batchResponsibilityTypeCreate((List<ResponsibilityType>)lists[CREATE_LIST_INDEX]);
		
		batchResponsibilityTypeUpdate((List<ResponsibilityType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ResponsibilityType responsibilityType:responsibilityTypeList){
			if(responsibilityType.isChanged()){
				responsibilityType.incVersion();
			}
			
		
		}
		
		
		return responsibilityTypeList;
	}

	public SmartList<ResponsibilityType> removeResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options){
		
		
		super.removeList(responsibilityTypeList, options);
		
		return responsibilityTypeList;
		
		
	}
	
	protected List<Object[]> prepareResponsibilityTypeBatchCreateArgs(List<ResponsibilityType> responsibilityTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ResponsibilityType responsibilityType:responsibilityTypeList ){
			Object [] parameters = prepareResponsibilityTypeCreateParameters(responsibilityType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareResponsibilityTypeBatchUpdateArgs(List<ResponsibilityType> responsibilityTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ResponsibilityType responsibilityType:responsibilityTypeList ){
			if(!responsibilityType.isChanged()){
				continue;
			}
			Object [] parameters = prepareResponsibilityTypeUpdateParameters(responsibilityType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchResponsibilityTypeCreate(List<ResponsibilityType> responsibilityTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareResponsibilityTypeBatchCreateArgs(responsibilityTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchResponsibilityTypeUpdate(List<ResponsibilityType> responsibilityTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareResponsibilityTypeBatchUpdateArgs(responsibilityTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitResponsibilityTypeList(List<ResponsibilityType> responsibilityTypeList){
		
		List<ResponsibilityType> responsibilityTypeCreateList=new ArrayList<ResponsibilityType>();
		List<ResponsibilityType> responsibilityTypeUpdateList=new ArrayList<ResponsibilityType>();
		
		for(ResponsibilityType responsibilityType: responsibilityTypeList){
			if(isUpdateRequest(responsibilityType)){
				responsibilityTypeUpdateList.add( responsibilityType);
				continue;
			}
			responsibilityTypeCreateList.add(responsibilityType);
		}
		
		return new Object[]{responsibilityTypeCreateList,responsibilityTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(ResponsibilityType responsibilityType){
 		return responsibilityType.getVersion() > 0;
 	}
 	protected String getSaveResponsibilityTypeSQL(ResponsibilityType responsibilityType){
 		if(isUpdateRequest(responsibilityType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveResponsibilityTypeParameters(ResponsibilityType responsibilityType){
 		if(isUpdateRequest(responsibilityType) ){
 			return prepareResponsibilityTypeUpdateParameters(responsibilityType);
 		}
 		return prepareResponsibilityTypeCreateParameters(responsibilityType);
 	}
 	protected Object[] prepareResponsibilityTypeUpdateParameters(ResponsibilityType responsibilityType){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = responsibilityType.getCode(); 	
 		if(responsibilityType.getCompany() != null){
 			parameters[1] = responsibilityType.getCompany().getId();
 		}
 
 		parameters[2] = responsibilityType.getBaseDescription();
 		parameters[3] = responsibilityType.getDetailDescription();		
 		parameters[4] = responsibilityType.getId();
 		parameters[5] = responsibilityType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareResponsibilityTypeCreateParameters(ResponsibilityType responsibilityType){
		Object[] parameters = new Object[5];
		String newResponsibilityTypeId=getNextId();
		responsibilityType.setId(newResponsibilityTypeId);
		parameters[0] =  responsibilityType.getId();
 
 		parameters[1] = responsibilityType.getCode(); 	
 		if(responsibilityType.getCompany() != null){
 			parameters[2] = responsibilityType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = responsibilityType.getBaseDescription();
 		parameters[4] = responsibilityType.getDetailDescription();		
 				
 		return parameters;
 	}
 	
	protected ResponsibilityType saveInternalResponsibilityType(ResponsibilityType responsibilityType, Map<String,Object> options){
		
		saveResponsibilityType(responsibilityType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(responsibilityType, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(responsibilityType, options);
	 		removeEmployeeList(responsibilityType, options);
	 		
 		}		
		
		return responsibilityType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ResponsibilityType saveCompany(ResponsibilityType responsibilityType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(responsibilityType.getCompany() == null){
 			return responsibilityType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(responsibilityType.getCompany(),options);
 		return responsibilityType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected ResponsibilityType saveEmployeeList(ResponsibilityType responsibilityType, Map<String,Object> options){
		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		if(employeeList == null){
			return responsibilityType;
		}
		if(employeeList.isEmpty()){
			return responsibilityType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return responsibilityType;
	
	}
	
	protected ResponsibilityType removeEmployeeList(ResponsibilityType responsibilityType, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();
		if(employeeList == null){
			return responsibilityType;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return responsibilityType;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return responsibilityType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return responsibilityType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public ResponsibilityType present(ResponsibilityType responsibilityType,Map<String, Object> options){
	
		presentEmployeeList(responsibilityType,options);

		return responsibilityType;
	
	}
		
	
  	
 	protected ResponsibilityType presentEmployeeList(
			ResponsibilityType responsibilityType,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = responsibilityType.getEmployeeList();		
		if(employeeList == null){
			return responsibilityType;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return responsibilityType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByResponsibleFor(responsibilityType.getId(), options);			
		}
		//responsibilityType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//responsibilityType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			responsibilityType.setEmployeeList(employeeList);
			return responsibilityType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByResponsibleFor(responsibilityType.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		responsibilityType.setEmployeeList(employeeList );	

		return responsibilityType;
	}			
		


	protected String getTableName(){
		return ResponsibilityTypeTable.TABLE_NAME;
	}
}


