
package com.skynet.retailscm.employeesalarysheet;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.salarygrade.SalaryGrade;

import com.skynet.retailscm.employee.EmployeeDAO;
import com.skynet.retailscm.salarygrade.SalaryGradeDAO;
import com.skynet.retailscm.payingoff.PayingOffDAO;

import com.skynet.retailscm.salarygrade.SalaryGradeTable;
import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.payingoff.PayingOffTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeSalarySheetJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeSalarySheetDAO{
 
 	
 	private  SalaryGradeDAO  salaryGradeDAO;
 	public void setSalaryGradeDAO(SalaryGradeDAO salaryGradeDAO){
	 	this.salaryGradeDAO = salaryGradeDAO;
 	}
 	public SalaryGradeDAO getSalaryGradeDAO(){
	 	return this.salaryGradeDAO;
 	}
 
 	
 	private  PayingOffDAO  payingOffDAO;
 	public void setPayingOffDAO(PayingOffDAO payingOffDAO){
	 	this.payingOffDAO = payingOffDAO;
 	}
 	public PayingOffDAO getPayingOffDAO(){
	 	return this.payingOffDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeSalarySheet load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSalarySheet(accessKey, options);
	}
	*/
	public EmployeeSalarySheet load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSalarySheet(EmployeeSalarySheetTable.withId(id), options);
	}
	
	
	
	public EmployeeSalarySheet save(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options){
		
		String methodName="save(EmployeeSalarySheet employeeSalarySheet,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeSalarySheet, methodName, "employeeSalarySheet");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeSalarySheet(employeeSalarySheet,options);
	}
	public EmployeeSalarySheet clone(String employeeSalarySheetId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeSalarySheetTable.withId(employeeSalarySheetId),options);
	}
	
	protected EmployeeSalarySheet clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeSalarySheetId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeSalarySheet newEmployeeSalarySheet = loadInternalEmployeeSalarySheet(accessKey, options);
		newEmployeeSalarySheet.setVersion(0);
		
		

		
		saveInternalEmployeeSalarySheet(newEmployeeSalarySheet,options);
		
		return newEmployeeSalarySheet;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeSalarySheetId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeSalarySheetId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeSalarySheetVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeSalarySheetNotFoundException(
					"The " + this.getTableName() + "(" + employeeSalarySheetId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeSalarySheetId, int version) throws Exception{
	
		String methodName="delete(String employeeSalarySheetId, int version)";
		assertMethodArgumentNotNull(employeeSalarySheetId, methodName, "employeeSalarySheetId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeSalarySheetId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeSalarySheetId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","current_salary_grade","base_salary","bonus","reward","personal_tax","social_security","housing_found","job_insurance","paying_off","current_status"};
		return EmployeeSalarySheetTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_salary_sheet";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeSalarySheetTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSalarySheetTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSalarySheetTokens.EMPLOYEE);
 	}
 	

 	
  
 	//private boolean extractCurrentSalaryGradeEnabled = true;
 	//private static final String CURRENTSALARYGRADE = "currentSalaryGrade";
 	protected boolean isExtractCurrentSalaryGradeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSalarySheetTokens.CURRENTSALARYGRADE);
 	}
 	
 	
 	//private boolean saveCurrentSalaryGradeEnabled = true;
 	protected boolean isSaveCurrentSalaryGradeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSalarySheetTokens.CURRENTSALARYGRADE);
 	}
 	

 	
  
 	//private boolean extractPayingOffEnabled = true;
 	//private static final String PAYINGOFF = "payingOff";
 	protected boolean isExtractPayingOffEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSalarySheetTokens.PAYINGOFF);
 	}
 	
 	
 	//private boolean savePayingOffEnabled = true;
 	protected boolean isSavePayingOffEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSalarySheetTokens.PAYINGOFF);
 	}
 	

 	
 
		

	

	protected EmployeeSalarySheetMapper getEmployeeSalarySheetMapper(){
		return new EmployeeSalarySheetMapper();
	}
	protected EmployeeSalarySheet extractEmployeeSalarySheet(String employeeSalarySheetId) throws Exception{
		String SQL = "select * from employee_salary_sheet_data where id = ?";	
		try{
		
			EmployeeSalarySheet employeeSalarySheet = queryForObject(SQL, new Object[]{employeeSalarySheetId}, getEmployeeSalarySheetMapper());
			return employeeSalarySheet;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeSalarySheetNotFoundException("EmployeeSalarySheet("+employeeSalarySheetId+") is not found!");
		}
		
		
	}
	protected EmployeeSalarySheet extractEmployeeSalarySheet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_salary_sheet_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeSalarySheet employeeSalarySheet = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeSalarySheetMapper());
			return employeeSalarySheet;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeSalarySheetNotFoundException("EmployeeSalarySheet("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeSalarySheet loadInternalEmployeeSalarySheet(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeSalarySheet employeeSalarySheet = extractEmployeeSalarySheet(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeSalarySheet, loadOptions);
 		}
  	
 		if(isExtractCurrentSalaryGradeEnabled(loadOptions)){
	 		extractCurrentSalaryGrade(employeeSalarySheet, loadOptions);
 		}
  	
 		if(isExtractPayingOffEnabled(loadOptions)){
	 		extractPayingOff(employeeSalarySheet, loadOptions);
 		}
 
		
		return employeeSalarySheet;
		
	}



	
	
	 

 	protected EmployeeSalarySheet extractEmployee(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options) throws Exception{

		if(employeeSalarySheet.getEmployee() == null){
			return employeeSalarySheet;
		}
		String employeeId = employeeSalarySheet.getEmployee().getId();
		if( employeeId == null){
			return employeeSalarySheet;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeSalarySheet.setEmployee(employee);
		}
		
 		
 		return employeeSalarySheet;
 	}
 		
  

 	protected EmployeeSalarySheet extractCurrentSalaryGrade(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options) throws Exception{

		if(employeeSalarySheet.getCurrentSalaryGrade() == null){
			return employeeSalarySheet;
		}
		String currentSalaryGradeId = employeeSalarySheet.getCurrentSalaryGrade().getId();
		if( currentSalaryGradeId == null){
			return employeeSalarySheet;
		}
		SalaryGrade currentSalaryGrade = getSalaryGradeDAO().load(currentSalaryGradeId,options);
		if(currentSalaryGrade != null){
			employeeSalarySheet.setCurrentSalaryGrade(currentSalaryGrade);
		}
		
 		
 		return employeeSalarySheet;
 	}
 		
  

 	protected EmployeeSalarySheet extractPayingOff(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options) throws Exception{

		if(employeeSalarySheet.getPayingOff() == null){
			return employeeSalarySheet;
		}
		String payingOffId = employeeSalarySheet.getPayingOff().getId();
		if( payingOffId == null){
			return employeeSalarySheet;
		}
		PayingOff payingOff = getPayingOffDAO().load(payingOffId,options);
		if(payingOff != null){
			employeeSalarySheet.setPayingOff(payingOff);
		}
		
 		
 		return employeeSalarySheet;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = queryForList(SQL, new Object[]{employeeId}, getEmployeeSalarySheetMapper());	
 		return employeeSalarySheetList;
 	}
 	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeSalarySheetMapper());
		
 		return employeeSalarySheetList;
 	}
 	
 	public int countEmployeeSalarySheetByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where current_salary_grade = ?";
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = queryForList(SQL, new Object[]{salaryGradeId}, getEmployeeSalarySheetMapper());	
 		return employeeSalarySheetList;
 	}
 	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where current_salary_grade = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = queryForList(SQL, new Object[]{salaryGradeId,start, count}, getEmployeeSalarySheetMapper());
		
 		return employeeSalarySheetList;
 	}
 	
 	public int countEmployeeSalarySheetByCurrentSalaryGrade(String salaryGradeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where current_salary_grade = ?";
		Integer count = queryInt(SQL, new Object[]{salaryGradeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where paying_off = ?";
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = queryForList(SQL, new Object[]{payingOffId}, getEmployeeSalarySheetMapper());	
 		return employeeSalarySheetList;
 	}
 	
 	public SmartList<EmployeeSalarySheet> findEmployeeSalarySheetByPayingOff(String payingOffId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where paying_off = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = queryForList(SQL, new Object[]{payingOffId,start, count}, getEmployeeSalarySheetMapper());
		
 		return employeeSalarySheetList;
 	}
 	
 	public int countEmployeeSalarySheetByPayingOff(String payingOffId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where paying_off = ?";
		Integer count = queryInt(SQL, new Object[]{payingOffId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeSalarySheet saveEmployeeSalarySheet(EmployeeSalarySheet  employeeSalarySheet){
	
		String SQL=this.getSaveEmployeeSalarySheetSQL(employeeSalarySheet);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeSalarySheetParameters(employeeSalarySheet);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeSalarySheet.incVersion();
		return employeeSalarySheet;
	
	}
	public SmartList<EmployeeSalarySheet> saveEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeSalarySheetList(employeeSalarySheetList);
		
		batchEmployeeSalarySheetCreate((List<EmployeeSalarySheet>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeSalarySheetUpdate((List<EmployeeSalarySheet>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			if(employeeSalarySheet.isChanged()){
				employeeSalarySheet.incVersion();
			}
			
		
		}
		
		
		return employeeSalarySheetList;
	}

	public SmartList<EmployeeSalarySheet> removeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList,Map<String,Object> options){
		
		
		super.removeList(employeeSalarySheetList, options);
		
		return employeeSalarySheetList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeSalarySheetBatchCreateArgs(List<EmployeeSalarySheet> employeeSalarySheetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList ){
			Object [] parameters = prepareEmployeeSalarySheetCreateParameters(employeeSalarySheet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeSalarySheetBatchUpdateArgs(List<EmployeeSalarySheet> employeeSalarySheetList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList ){
			if(!employeeSalarySheet.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeSalarySheetUpdateParameters(employeeSalarySheet);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeSalarySheetCreate(List<EmployeeSalarySheet> employeeSalarySheetList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeSalarySheetBatchCreateArgs(employeeSalarySheetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeSalarySheetUpdate(List<EmployeeSalarySheet> employeeSalarySheetList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeSalarySheetBatchUpdateArgs(employeeSalarySheetList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeSalarySheetList(List<EmployeeSalarySheet> employeeSalarySheetList){
		
		List<EmployeeSalarySheet> employeeSalarySheetCreateList=new ArrayList<EmployeeSalarySheet>();
		List<EmployeeSalarySheet> employeeSalarySheetUpdateList=new ArrayList<EmployeeSalarySheet>();
		
		for(EmployeeSalarySheet employeeSalarySheet: employeeSalarySheetList){
			if(isUpdateRequest(employeeSalarySheet)){
				employeeSalarySheetUpdateList.add( employeeSalarySheet);
				continue;
			}
			employeeSalarySheetCreateList.add(employeeSalarySheet);
		}
		
		return new Object[]{employeeSalarySheetCreateList,employeeSalarySheetUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeSalarySheet employeeSalarySheet){
 		return employeeSalarySheet.getVersion() > 0;
 	}
 	protected String getSaveEmployeeSalarySheetSQL(EmployeeSalarySheet employeeSalarySheet){
 		if(isUpdateRequest(employeeSalarySheet)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeSalarySheetParameters(EmployeeSalarySheet employeeSalarySheet){
 		if(isUpdateRequest(employeeSalarySheet) ){
 			return prepareEmployeeSalarySheetUpdateParameters(employeeSalarySheet);
 		}
 		return prepareEmployeeSalarySheetCreateParameters(employeeSalarySheet);
 	}
 	protected Object[] prepareEmployeeSalarySheetUpdateParameters(EmployeeSalarySheet employeeSalarySheet){
 		Object[] parameters = new Object[13];
  	
 		if(employeeSalarySheet.getEmployee() != null){
 			parameters[0] = employeeSalarySheet.getEmployee().getId();
 		}
  	
 		if(employeeSalarySheet.getCurrentSalaryGrade() != null){
 			parameters[1] = employeeSalarySheet.getCurrentSalaryGrade().getId();
 		}
 
 		parameters[2] = employeeSalarySheet.getBaseSalary();
 		parameters[3] = employeeSalarySheet.getBonus();
 		parameters[4] = employeeSalarySheet.getReward();
 		parameters[5] = employeeSalarySheet.getPersonalTax();
 		parameters[6] = employeeSalarySheet.getSocialSecurity();
 		parameters[7] = employeeSalarySheet.getHousingFound();
 		parameters[8] = employeeSalarySheet.getJobInsurance(); 	
 		if(employeeSalarySheet.getPayingOff() != null){
 			parameters[9] = employeeSalarySheet.getPayingOff().getId();
 		}
 
 		parameters[10] = employeeSalarySheet.getCurrentStatus();		
 		parameters[11] = employeeSalarySheet.getId();
 		parameters[12] = employeeSalarySheet.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeSalarySheetCreateParameters(EmployeeSalarySheet employeeSalarySheet){
		Object[] parameters = new Object[12];
		String newEmployeeSalarySheetId=getNextId();
		employeeSalarySheet.setId(newEmployeeSalarySheetId);
		parameters[0] =  employeeSalarySheet.getId();
  	
 		if(employeeSalarySheet.getEmployee() != null){
 			parameters[1] = employeeSalarySheet.getEmployee().getId();
 		
 		}
 		 	
 		if(employeeSalarySheet.getCurrentSalaryGrade() != null){
 			parameters[2] = employeeSalarySheet.getCurrentSalaryGrade().getId();
 		
 		}
 		
 		parameters[3] = employeeSalarySheet.getBaseSalary();
 		parameters[4] = employeeSalarySheet.getBonus();
 		parameters[5] = employeeSalarySheet.getReward();
 		parameters[6] = employeeSalarySheet.getPersonalTax();
 		parameters[7] = employeeSalarySheet.getSocialSecurity();
 		parameters[8] = employeeSalarySheet.getHousingFound();
 		parameters[9] = employeeSalarySheet.getJobInsurance(); 	
 		if(employeeSalarySheet.getPayingOff() != null){
 			parameters[10] = employeeSalarySheet.getPayingOff().getId();
 		
 		}
 		
 		parameters[11] = employeeSalarySheet.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected EmployeeSalarySheet saveInternalEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
		
		saveEmployeeSalarySheet(employeeSalarySheet);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeSalarySheet, options);
 		}
  	
 		if(isSaveCurrentSalaryGradeEnabled(options)){
	 		saveCurrentSalaryGrade(employeeSalarySheet, options);
 		}
  	
 		if(isSavePayingOffEnabled(options)){
	 		savePayingOff(employeeSalarySheet, options);
 		}
 
		
		return employeeSalarySheet;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeSalarySheet saveEmployee(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSalarySheet.getEmployee() == null){
 			return employeeSalarySheet;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeSalarySheet.getEmployee(),options);
 		return employeeSalarySheet;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeSalarySheet saveCurrentSalaryGrade(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSalarySheet.getCurrentSalaryGrade() == null){
 			return employeeSalarySheet;//do nothing when it is null
 		}
 		
 		getSalaryGradeDAO().save(employeeSalarySheet.getCurrentSalaryGrade(),options);
 		return employeeSalarySheet;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeSalarySheet savePayingOff(EmployeeSalarySheet employeeSalarySheet, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSalarySheet.getPayingOff() == null){
 			return employeeSalarySheet;//do nothing when it is null
 		}
 		
 		getPayingOffDAO().save(employeeSalarySheet.getPayingOff(),options);
 		return employeeSalarySheet;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeSalarySheet present(EmployeeSalarySheet employeeSalarySheet,Map<String, Object> options){
	

		return employeeSalarySheet;
	
	}
		


	protected String getTableName(){
		return EmployeeSalarySheetTable.TABLE_NAME;
	}
}


