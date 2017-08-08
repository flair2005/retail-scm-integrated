
package com.skynet.retailscm.salarygrade;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SalaryGradeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SalaryGradeDAO{
 
 	
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
 	
			
		
	
  	private  EmployeeSalarySheetDAO  employeeSalarySheetDAO;
 	public void setEmployeeSalarySheetDAO(EmployeeSalarySheetDAO pEmployeeSalarySheetDAO){
 	
 		if(pEmployeeSalarySheetDAO == null){
 			throw new IllegalStateException("Do not try to set employeeSalarySheetDAO to null.");
 		}
	 	this.employeeSalarySheetDAO = pEmployeeSalarySheetDAO;
 	}
 	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO(){
 		if(this.employeeSalarySheetDAO == null){
 			throw new IllegalStateException("The employeeSalarySheetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeSalarySheetDAO;
 	}	
 	
			
		

	
	/*
	protected SalaryGrade load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSalaryGrade(accessKey, options);
	}
	*/
	public SalaryGrade load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSalaryGrade(SalaryGradeTable.withId(id), options);
	}
	
	
	
	public SalaryGrade save(SalaryGrade salaryGrade,Map<String,Object> options){
		
		String methodName="save(SalaryGrade salaryGrade,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(salaryGrade, methodName, "salaryGrade");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSalaryGrade(salaryGrade,options);
	}
	public SalaryGrade clone(String salaryGradeId, Map<String,Object> options) throws Exception{
	
		return clone(SalaryGradeTable.withId(salaryGradeId),options);
	}
	
	protected SalaryGrade clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String salaryGradeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SalaryGrade newSalaryGrade = loadInternalSalaryGrade(accessKey, options);
		newSalaryGrade.setVersion(0);
		
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newSalaryGrade.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeSalarySheetListEnabled(options)){
 			for(EmployeeSalarySheet item: newSalaryGrade.getEmployeeSalarySheetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSalaryGrade(newSalaryGrade,options);
		
		return newSalaryGrade;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String salaryGradeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{salaryGradeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SalaryGradeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SalaryGradeNotFoundException(
					"The " + this.getTableName() + "(" + salaryGradeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String salaryGradeId, int version) throws Exception{
	
		String methodName="delete(String salaryGradeId, int version)";
		assertMethodArgumentNotNull(salaryGradeId, methodName, "salaryGradeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{salaryGradeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(salaryGradeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","name","detail_description"};
		return SalaryGradeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "salary_grade";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SalaryGradeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SalaryGradeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SalaryGradeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SalaryGradeTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, SalaryGradeTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";
	
	protected boolean isExtractEmployeeSalarySheetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SalaryGradeTokens.EMPLOYEE_SALARY_SHEET_LIST);
		
 	}

	protected boolean isSaveEmployeeSalarySheetListEnabled(Map<String,Object> options){
		return checkOptions(options, SalaryGradeTokens.EMPLOYEE_SALARY_SHEET_LIST);
		
 	}
 	
 	
			
		

	

	protected SalaryGradeMapper getSalaryGradeMapper(){
		return new SalaryGradeMapper();
	}
	protected SalaryGrade extractSalaryGrade(String salaryGradeId) throws Exception{
		String SQL = "select * from salary_grade_data where id = ?";	
		try{
		
			SalaryGrade salaryGrade = queryForObject(SQL, new Object[]{salaryGradeId}, getSalaryGradeMapper());
			return salaryGrade;
		}catch(EmptyResultDataAccessException e){
			throw new SalaryGradeNotFoundException("SalaryGrade("+salaryGradeId+") is not found!");
		}
		
		
	}
	protected SalaryGrade extractSalaryGrade(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from salary_grade_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SalaryGrade salaryGrade = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSalaryGradeMapper());
			return salaryGrade;
		}catch(EmptyResultDataAccessException e){
			throw new SalaryGradeNotFoundException("SalaryGrade("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SalaryGrade loadInternalSalaryGrade(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SalaryGrade salaryGrade = extractSalaryGrade(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(salaryGrade, loadOptions);
 		}
 
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(salaryGrade, loadOptions);
 		}		
		
		if(isExtractEmployeeSalarySheetListEnabled(loadOptions)){
	 		extractEmployeeSalarySheetList(salaryGrade, loadOptions);
 		}		
		
		return salaryGrade;
		
	}



	
	
	 

 	protected SalaryGrade extractCompany(SalaryGrade salaryGrade, Map<String,Object> options) throws Exception{

		if(salaryGrade.getCompany() == null){
			return salaryGrade;
		}
		String companyId = salaryGrade.getCompany().getId();
		if( companyId == null){
			return salaryGrade;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			salaryGrade.setCompany(company);
		}
		
 		
 		return salaryGrade;
 	}
 		
 
		
	protected SalaryGrade extractEmployeeList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByCurrentSalaryGrade(salaryGrade.getId(),options);
		if(employeeList != null){
			salaryGrade.setEmployeeList(employeeList);
		}
		
		return salaryGrade;
	
	}	
		
	protected SalaryGrade extractEmployeeSalarySheetList(SalaryGrade salaryGrade, Map<String,Object> options){
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = getEmployeeSalarySheetDAO().findEmployeeSalarySheetByCurrentSalaryGrade(salaryGrade.getId(),options);
		if(employeeSalarySheetList != null){
			salaryGrade.setEmployeeSalarySheetList(employeeSalarySheetList);
		}
		
		return salaryGrade;
	
	}	
		
		
  	
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<SalaryGrade> salaryGradeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getSalaryGradeMapper());	
 		return salaryGradeList;
 	}
 	
 	public SmartList<SalaryGrade> findSalaryGradeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SalaryGrade> salaryGradeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getSalaryGradeMapper());
		
 		return salaryGradeList;
 	}
 	
 	public int countSalaryGradeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SalaryGrade saveSalaryGrade(SalaryGrade  salaryGrade){
	
		String SQL=this.getSaveSalaryGradeSQL(salaryGrade);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSalaryGradeParameters(salaryGrade);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		salaryGrade.incVersion();
		return salaryGrade;
	
	}
	public SmartList<SalaryGrade> saveSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSalaryGradeList(salaryGradeList);
		
		batchSalaryGradeCreate((List<SalaryGrade>)lists[CREATE_LIST_INDEX]);
		
		batchSalaryGradeUpdate((List<SalaryGrade>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SalaryGrade salaryGrade:salaryGradeList){
			if(salaryGrade.isChanged()){
				salaryGrade.incVersion();
			}
			
		
		}
		
		
		return salaryGradeList;
	}

	public SmartList<SalaryGrade> removeSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options){
		
		
		super.removeList(salaryGradeList, options);
		
		return salaryGradeList;
		
		
	}
	
	protected List<Object[]> prepareSalaryGradeBatchCreateArgs(List<SalaryGrade> salaryGradeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SalaryGrade salaryGrade:salaryGradeList ){
			Object [] parameters = prepareSalaryGradeCreateParameters(salaryGrade);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSalaryGradeBatchUpdateArgs(List<SalaryGrade> salaryGradeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SalaryGrade salaryGrade:salaryGradeList ){
			if(!salaryGrade.isChanged()){
				continue;
			}
			Object [] parameters = prepareSalaryGradeUpdateParameters(salaryGrade);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSalaryGradeCreate(List<SalaryGrade> salaryGradeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSalaryGradeBatchCreateArgs(salaryGradeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSalaryGradeUpdate(List<SalaryGrade> salaryGradeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSalaryGradeBatchUpdateArgs(salaryGradeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSalaryGradeList(List<SalaryGrade> salaryGradeList){
		
		List<SalaryGrade> salaryGradeCreateList=new ArrayList<SalaryGrade>();
		List<SalaryGrade> salaryGradeUpdateList=new ArrayList<SalaryGrade>();
		
		for(SalaryGrade salaryGrade: salaryGradeList){
			if(isUpdateRequest(salaryGrade)){
				salaryGradeUpdateList.add( salaryGrade);
				continue;
			}
			salaryGradeCreateList.add(salaryGrade);
		}
		
		return new Object[]{salaryGradeCreateList,salaryGradeUpdateList};
	}
	
	protected boolean isUpdateRequest(SalaryGrade salaryGrade){
 		return salaryGrade.getVersion() > 0;
 	}
 	protected String getSaveSalaryGradeSQL(SalaryGrade salaryGrade){
 		if(isUpdateRequest(salaryGrade)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSalaryGradeParameters(SalaryGrade salaryGrade){
 		if(isUpdateRequest(salaryGrade) ){
 			return prepareSalaryGradeUpdateParameters(salaryGrade);
 		}
 		return prepareSalaryGradeCreateParameters(salaryGrade);
 	}
 	protected Object[] prepareSalaryGradeUpdateParameters(SalaryGrade salaryGrade){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = salaryGrade.getCode(); 	
 		if(salaryGrade.getCompany() != null){
 			parameters[1] = salaryGrade.getCompany().getId();
 		}
 
 		parameters[2] = salaryGrade.getName();
 		parameters[3] = salaryGrade.getDetailDescription();		
 		parameters[4] = salaryGrade.getId();
 		parameters[5] = salaryGrade.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSalaryGradeCreateParameters(SalaryGrade salaryGrade){
		Object[] parameters = new Object[5];
		String newSalaryGradeId=getNextId();
		salaryGrade.setId(newSalaryGradeId);
		parameters[0] =  salaryGrade.getId();
 
 		parameters[1] = salaryGrade.getCode(); 	
 		if(salaryGrade.getCompany() != null){
 			parameters[2] = salaryGrade.getCompany().getId();
 		
 		}
 		
 		parameters[3] = salaryGrade.getName();
 		parameters[4] = salaryGrade.getDetailDescription();		
 				
 		return parameters;
 	}
 	
	protected SalaryGrade saveInternalSalaryGrade(SalaryGrade salaryGrade, Map<String,Object> options){
		
		saveSalaryGrade(salaryGrade);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(salaryGrade, options);
 		}
 
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(salaryGrade, options);
	 		removeEmployeeList(salaryGrade, options);
	 		
 		}		
		
		if(isSaveEmployeeSalarySheetListEnabled(options)){
	 		saveEmployeeSalarySheetList(salaryGrade, options);
	 		removeEmployeeSalarySheetList(salaryGrade, options);
	 		
 		}		
		
		return salaryGrade;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SalaryGrade saveCompany(SalaryGrade salaryGrade, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(salaryGrade.getCompany() == null){
 			return salaryGrade;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(salaryGrade.getCompany(),options);
 		return salaryGrade;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected SalaryGrade saveEmployeeList(SalaryGrade salaryGrade, Map<String,Object> options){
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();
		if(employeeList == null){
			return salaryGrade;
		}
		if(employeeList.isEmpty()){
			return salaryGrade;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return salaryGrade;
	
	}
	
	protected SalaryGrade removeEmployeeList(SalaryGrade salaryGrade, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();
		if(employeeList == null){
			return salaryGrade;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return salaryGrade;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return salaryGrade;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return salaryGrade;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected SalaryGrade saveEmployeeSalarySheetList(SalaryGrade salaryGrade, Map<String,Object> options){
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			return salaryGrade;
		}
		if(employeeSalarySheetList.isEmpty()){
			return salaryGrade;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeSalarySheetDAO().saveEmployeeSalarySheetList(employeeSalarySheetList,options);
		
		return salaryGrade;
	
	}
	
	protected SalaryGrade removeEmployeeSalarySheetList(SalaryGrade salaryGrade, Map<String,Object> options){
	
	
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			return salaryGrade;
		}	
	
		SmartList<EmployeeSalarySheet> toRemoveEmployeeSalarySheetList = employeeSalarySheetList.getToRemoveList();
		
		if(toRemoveEmployeeSalarySheetList == null){
			return salaryGrade;
		}
		if(toRemoveEmployeeSalarySheetList.isEmpty()){
			return salaryGrade;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeSalarySheetDAO().removeEmployeeSalarySheetList(toRemoveEmployeeSalarySheetList,options);
		
		return salaryGrade;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SalaryGrade present(SalaryGrade salaryGrade,Map<String, Object> options){
	
		presentEmployeeList(salaryGrade,options);
		presentEmployeeSalarySheetList(salaryGrade,options);

		return salaryGrade;
	
	}
		
	
  	
 	protected SalaryGrade presentEmployeeList(
			SalaryGrade salaryGrade,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = salaryGrade.getEmployeeList();		
		if(employeeList == null){
			return salaryGrade;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return salaryGrade;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByCurrentSalaryGrade(salaryGrade.getId(), options);			
		}
		//salaryGrade.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//salaryGrade.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			salaryGrade.setEmployeeList(employeeList);
			return salaryGrade;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByCurrentSalaryGrade(salaryGrade.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		salaryGrade.setEmployeeList(employeeList );	

		return salaryGrade;
	}			
		
	
  	
 	protected SalaryGrade presentEmployeeSalarySheetList(
			SalaryGrade salaryGrade,
			Map<String, Object> options) {

		SmartList<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();		
		if(employeeSalarySheetList == null){
			return salaryGrade;			
		}
		
		String targetObjectName = "employeeSalarySheet";
		int employeeSalarySheetListSize = employeeSalarySheetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeSalarySheetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return salaryGrade;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeSalarySheetListSize;
		if(employeeSalarySheetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetByCurrentSalaryGrade(salaryGrade.getId(), options);			
		}
		//salaryGrade.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//salaryGrade.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeSalarySheetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeSalarySheetListSize,currentPage,rowsPerPage) ;
			employeeSalarySheetList = employeeSalarySheetList.subListOf(fromIndex, toIndex);
			employeeSalarySheetList.setTotalCount(count);
			employeeSalarySheetList.setCurrentPageNumber(currentPage);			
			salaryGrade.setEmployeeSalarySheetList(employeeSalarySheetList);
			return salaryGrade;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeSalarySheetList 
			= getEmployeeSalarySheetDAO().findEmployeeSalarySheetByCurrentSalaryGrade(salaryGrade.getId(),start, rowsPerPage, options );
		employeeSalarySheetList.setTotalCount(count);
		employeeSalarySheetList.setCurrentPageNumber(currentPage);
		salaryGrade.setEmployeeSalarySheetList(employeeSalarySheetList );	

		return salaryGrade;
	}			
		


	protected String getTableName(){
		return SalaryGradeTable.TABLE_NAME;
	}
}


