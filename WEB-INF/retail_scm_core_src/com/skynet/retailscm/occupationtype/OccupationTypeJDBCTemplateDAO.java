
package com.skynet.retailscm.occupationtype;

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

public class OccupationTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OccupationTypeDAO{
 
 	
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
	protected OccupationType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOccupationType(accessKey, options);
	}
	*/
	public OccupationType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOccupationType(OccupationTypeTable.withId(id), options);
	}
	
	
	
	public OccupationType save(OccupationType occupationType,Map<String,Object> options){
		
		String methodName="save(OccupationType occupationType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(occupationType, methodName, "occupationType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOccupationType(occupationType,options);
	}
	public OccupationType clone(String occupationTypeId, Map<String,Object> options) throws Exception{
	
		return clone(OccupationTypeTable.withId(occupationTypeId),options);
	}
	
	protected OccupationType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String occupationTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OccupationType newOccupationType = loadInternalOccupationType(accessKey, options);
		newOccupationType.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newOccupationType.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalOccupationType(newOccupationType,options);
		
		return newOccupationType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String occupationTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{occupationTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OccupationTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OccupationTypeNotFoundException(
					"The " + this.getTableName() + "(" + occupationTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String occupationTypeId, int version) throws Exception{
	
		String methodName="delete(String occupationTypeId, int version)";
		assertMethodArgumentNotNull(occupationTypeId, methodName, "occupationTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{occupationTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(occupationTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","description","detail_description"};
		return OccupationTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "occupation_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OccupationTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OccupationTypeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OccupationTypeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,OccupationTypeTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, OccupationTypeTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected OccupationTypeMapper getOccupationTypeMapper(){
		return new OccupationTypeMapper();
	}
	protected OccupationType extractOccupationType(String occupationTypeId) throws Exception{
		String SQL = "select * from occupation_type_data where id = ?";	
		try{
		
			OccupationType occupationType = queryForObject(SQL, new Object[]{occupationTypeId}, getOccupationTypeMapper());
			return occupationType;
		}catch(EmptyResultDataAccessException e){
			throw new OccupationTypeNotFoundException("OccupationType("+occupationTypeId+") is not found!");
		}
		
		
	}
	protected OccupationType extractOccupationType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from occupation_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			OccupationType occupationType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getOccupationTypeMapper());
			return occupationType;
		}catch(EmptyResultDataAccessException e){
			throw new OccupationTypeNotFoundException("OccupationType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected OccupationType loadInternalOccupationType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OccupationType occupationType = extractOccupationType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(occupationType, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(occupationType, loadOptions);
 		}		
		
		return occupationType;
		
	}



	
	
	 

 	protected OccupationType extractCompany(OccupationType occupationType, Map<String,Object> options) throws Exception{

		if(occupationType.getCompany() == null){
			return occupationType;
		}
		String companyId = occupationType.getCompany().getId();
		if( companyId == null){
			return occupationType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			occupationType.setCompany(company);
		}
		
 		
 		return occupationType;
 	}
 		
 
		
	protected OccupationType extractEmployeeList(OccupationType occupationType, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByOccupation(occupationType.getId(),options);
		if(employeeList != null){
			occupationType.setEmployeeList(employeeList);
		}
		
		return occupationType;
	
	}	
		
		
  	
 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<OccupationType> occupationTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getOccupationTypeMapper());	
 		return occupationTypeList;
 	}
 	
 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<OccupationType> occupationTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getOccupationTypeMapper());
		
 		return occupationTypeList;
 	}
 	
 	public int countOccupationTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected OccupationType saveOccupationType(OccupationType  occupationType){
	
		String SQL=this.getSaveOccupationTypeSQL(occupationType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOccupationTypeParameters(occupationType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		occupationType.incVersion();
		return occupationType;
	
	}
	public SmartList<OccupationType> saveOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOccupationTypeList(occupationTypeList);
		
		batchOccupationTypeCreate((List<OccupationType>)lists[CREATE_LIST_INDEX]);
		
		batchOccupationTypeUpdate((List<OccupationType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OccupationType occupationType:occupationTypeList){
			if(occupationType.isChanged()){
				occupationType.incVersion();
			}
			
		
		}
		
		
		return occupationTypeList;
	}

	public SmartList<OccupationType> removeOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options){
		
		
		super.removeList(occupationTypeList, options);
		
		return occupationTypeList;
		
		
	}
	
	protected List<Object[]> prepareOccupationTypeBatchCreateArgs(List<OccupationType> occupationTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OccupationType occupationType:occupationTypeList ){
			Object [] parameters = prepareOccupationTypeCreateParameters(occupationType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOccupationTypeBatchUpdateArgs(List<OccupationType> occupationTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OccupationType occupationType:occupationTypeList ){
			if(!occupationType.isChanged()){
				continue;
			}
			Object [] parameters = prepareOccupationTypeUpdateParameters(occupationType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOccupationTypeCreate(List<OccupationType> occupationTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOccupationTypeBatchCreateArgs(occupationTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOccupationTypeUpdate(List<OccupationType> occupationTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOccupationTypeBatchUpdateArgs(occupationTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOccupationTypeList(List<OccupationType> occupationTypeList){
		
		List<OccupationType> occupationTypeCreateList=new ArrayList<OccupationType>();
		List<OccupationType> occupationTypeUpdateList=new ArrayList<OccupationType>();
		
		for(OccupationType occupationType: occupationTypeList){
			if(isUpdateRequest(occupationType)){
				occupationTypeUpdateList.add( occupationType);
				continue;
			}
			occupationTypeCreateList.add(occupationType);
		}
		
		return new Object[]{occupationTypeCreateList,occupationTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(OccupationType occupationType){
 		return occupationType.getVersion() > 0;
 	}
 	protected String getSaveOccupationTypeSQL(OccupationType occupationType){
 		if(isUpdateRequest(occupationType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOccupationTypeParameters(OccupationType occupationType){
 		if(isUpdateRequest(occupationType) ){
 			return prepareOccupationTypeUpdateParameters(occupationType);
 		}
 		return prepareOccupationTypeCreateParameters(occupationType);
 	}
 	protected Object[] prepareOccupationTypeUpdateParameters(OccupationType occupationType){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = occupationType.getCode(); 	
 		if(occupationType.getCompany() != null){
 			parameters[1] = occupationType.getCompany().getId();
 		}
 
 		parameters[2] = occupationType.getDescription();
 		parameters[3] = occupationType.getDetailDescription();		
 		parameters[4] = occupationType.getId();
 		parameters[5] = occupationType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOccupationTypeCreateParameters(OccupationType occupationType){
		Object[] parameters = new Object[5];
		String newOccupationTypeId=getNextId();
		occupationType.setId(newOccupationTypeId);
		parameters[0] =  occupationType.getId();
 
 		parameters[1] = occupationType.getCode(); 	
 		if(occupationType.getCompany() != null){
 			parameters[2] = occupationType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = occupationType.getDescription();
 		parameters[4] = occupationType.getDetailDescription();		
 				
 		return parameters;
 	}
 	
	protected OccupationType saveInternalOccupationType(OccupationType occupationType, Map<String,Object> options){
		
		saveOccupationType(occupationType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(occupationType, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(occupationType, options);
	 		removeEmployeeList(occupationType, options);
	 		
 		}		
		
		return occupationType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected OccupationType saveCompany(OccupationType occupationType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(occupationType.getCompany() == null){
 			return occupationType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(occupationType.getCompany(),options);
 		return occupationType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected OccupationType saveEmployeeList(OccupationType occupationType, Map<String,Object> options){
		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		if(employeeList == null){
			return occupationType;
		}
		if(employeeList.isEmpty()){
			return occupationType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return occupationType;
	
	}
	
	protected OccupationType removeEmployeeList(OccupationType occupationType, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = occupationType.getEmployeeList();
		if(employeeList == null){
			return occupationType;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return occupationType;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return occupationType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return occupationType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public OccupationType present(OccupationType occupationType,Map<String, Object> options){
	
		presentEmployeeList(occupationType,options);

		return occupationType;
	
	}
		
	
  	
 	protected OccupationType presentEmployeeList(
			OccupationType occupationType,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = occupationType.getEmployeeList();		
		if(employeeList == null){
			return occupationType;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return occupationType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByOccupation(occupationType.getId(), options);			
		}
		//occupationType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//occupationType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			occupationType.setEmployeeList(employeeList);
			return occupationType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByOccupation(occupationType.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		occupationType.setEmployeeList(employeeList );	

		return occupationType;
	}			
		


	protected String getTableName(){
		return OccupationTypeTable.TABLE_NAME;
	}
}


