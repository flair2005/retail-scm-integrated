
package com.skynet.retailscm.payingoff;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheetTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class PayingOffJDBCTemplateDAO extends CommonJDBCTemplateDAO implements PayingOffDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
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
	protected PayingOff load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPayingOff(accessKey, options);
	}
	*/
	public PayingOff load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPayingOff(PayingOffTable.withId(id), options);
	}
	
	
	
	public PayingOff save(PayingOff payingOff,Map<String,Object> options){
		
		String methodName="save(PayingOff payingOff,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(payingOff, methodName, "payingOff");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPayingOff(payingOff,options);
	}
	public PayingOff clone(String payingOffId, Map<String,Object> options) throws Exception{
	
		return clone(PayingOffTable.withId(payingOffId),options);
	}
	
	protected PayingOff clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String payingOffId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PayingOff newPayingOff = loadInternalPayingOff(accessKey, options);
		newPayingOff.setVersion(0);
		
		
 		
 		if(isSaveEmployeeSalarySheetListEnabled(options)){
 			for(EmployeeSalarySheet item: newPayingOff.getEmployeeSalarySheetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPayingOff(newPayingOff,options);
		
		return newPayingOff;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String payingOffId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{payingOffId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new PayingOffVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PayingOffNotFoundException(
					"The " + this.getTableName() + "(" + payingOffId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String payingOffId, int version) throws Exception{
	
		String methodName="delete(String payingOffId, int version)";
		assertMethodArgumentNotNull(payingOffId, methodName, "payingOffId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{payingOffId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(payingOffId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","paid_for","paid_time","amount"};
		return PayingOffTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "paying_off";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PayingOffTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractPaidForEnabled = true;
 	//private static final String PAIDFOR = "paidFor";
 	protected boolean isExtractPaidForEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PayingOffTokens.PAIDFOR);
 	}
 	
 	
 	//private boolean savePaidForEnabled = true;
 	protected boolean isSavePaidForEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PayingOffTokens.PAIDFOR);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_SALARY_SHEET_LIST = "employeeSalarySheetList";
	
	protected boolean isExtractEmployeeSalarySheetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,PayingOffTokens.EMPLOYEE_SALARY_SHEET_LIST);
		
 	}

	protected boolean isSaveEmployeeSalarySheetListEnabled(Map<String,Object> options){
		return checkOptions(options, PayingOffTokens.EMPLOYEE_SALARY_SHEET_LIST);
		
 	}
 	
 	
			
		

	

	protected PayingOffMapper getPayingOffMapper(){
		return new PayingOffMapper();
	}
	protected PayingOff extractPayingOff(String payingOffId) throws Exception{
		String SQL = "select * from paying_off_data where id = ?";	
		try{
		
			PayingOff payingOff = queryForObject(SQL, new Object[]{payingOffId}, getPayingOffMapper());
			return payingOff;
		}catch(EmptyResultDataAccessException e){
			throw new PayingOffNotFoundException("PayingOff("+payingOffId+") is not found!");
		}
		
		
	}
	protected PayingOff extractPayingOff(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from paying_off_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			PayingOff payingOff = queryForObject(SQL, new Object[]{accessKey.getValue()}, getPayingOffMapper());
			return payingOff;
		}catch(EmptyResultDataAccessException e){
			throw new PayingOffNotFoundException("PayingOff("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected PayingOff loadInternalPayingOff(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PayingOff payingOff = extractPayingOff(accessKey, loadOptions);
 	
 		if(isExtractPaidForEnabled(loadOptions)){
	 		extractPaidFor(payingOff, loadOptions);
 		}
 
		
		if(isExtractEmployeeSalarySheetListEnabled(loadOptions)){
	 		extractEmployeeSalarySheetList(payingOff, loadOptions);
 		}		
		
		return payingOff;
		
	}



	
	
	 

 	protected PayingOff extractPaidFor(PayingOff payingOff, Map<String,Object> options) throws Exception{

		if(payingOff.getPaidFor() == null){
			return payingOff;
		}
		String paidForId = payingOff.getPaidFor().getId();
		if( paidForId == null){
			return payingOff;
		}
		Employee paidFor = getEmployeeDAO().load(paidForId,options);
		if(paidFor != null){
			payingOff.setPaidFor(paidFor);
		}
		
 		
 		return payingOff;
 	}
 		
 
		
	protected PayingOff extractEmployeeSalarySheetList(PayingOff payingOff, Map<String,Object> options){
		
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = getEmployeeSalarySheetDAO().findEmployeeSalarySheetByPayingOff(payingOff.getId(),options);
		if(employeeSalarySheetList != null){
			payingOff.setEmployeeSalarySheetList(employeeSalarySheetList);
		}
		
		return payingOff;
	
	}	
		
		
  	
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where paid_for = ?";
		SmartList<PayingOff> payingOffList = queryForList(SQL, new Object[]{employeeId}, getPayingOffMapper());	
 		return payingOffList;
 	}
 	
 	public SmartList<PayingOff> findPayingOffByPaidFor(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where paid_for = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PayingOff> payingOffList = queryForList(SQL, new Object[]{employeeId,start, count}, getPayingOffMapper());
		
 		return payingOffList;
 	}
 	
 	public int countPayingOffByPaidFor(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where paid_for = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected PayingOff savePayingOff(PayingOff  payingOff){
	
		String SQL=this.getSavePayingOffSQL(payingOff);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePayingOffParameters(payingOff);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		payingOff.incVersion();
		return payingOff;
	
	}
	public SmartList<PayingOff> savePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPayingOffList(payingOffList);
		
		batchPayingOffCreate((List<PayingOff>)lists[CREATE_LIST_INDEX]);
		
		batchPayingOffUpdate((List<PayingOff>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PayingOff payingOff:payingOffList){
			if(payingOff.isChanged()){
				payingOff.incVersion();
			}
			
		
		}
		
		
		return payingOffList;
	}

	public SmartList<PayingOff> removePayingOffList(SmartList<PayingOff> payingOffList,Map<String,Object> options){
		
		
		super.removeList(payingOffList, options);
		
		return payingOffList;
		
		
	}
	
	protected List<Object[]> preparePayingOffBatchCreateArgs(List<PayingOff> payingOffList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PayingOff payingOff:payingOffList ){
			Object [] parameters = preparePayingOffCreateParameters(payingOff);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePayingOffBatchUpdateArgs(List<PayingOff> payingOffList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PayingOff payingOff:payingOffList ){
			if(!payingOff.isChanged()){
				continue;
			}
			Object [] parameters = preparePayingOffUpdateParameters(payingOff);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPayingOffCreate(List<PayingOff> payingOffList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePayingOffBatchCreateArgs(payingOffList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPayingOffUpdate(List<PayingOff> payingOffList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePayingOffBatchUpdateArgs(payingOffList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPayingOffList(List<PayingOff> payingOffList){
		
		List<PayingOff> payingOffCreateList=new ArrayList<PayingOff>();
		List<PayingOff> payingOffUpdateList=new ArrayList<PayingOff>();
		
		for(PayingOff payingOff: payingOffList){
			if(isUpdateRequest(payingOff)){
				payingOffUpdateList.add( payingOff);
				continue;
			}
			payingOffCreateList.add(payingOff);
		}
		
		return new Object[]{payingOffCreateList,payingOffUpdateList};
	}
	
	protected boolean isUpdateRequest(PayingOff payingOff){
 		return payingOff.getVersion() > 0;
 	}
 	protected String getSavePayingOffSQL(PayingOff payingOff){
 		if(isUpdateRequest(payingOff)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePayingOffParameters(PayingOff payingOff){
 		if(isUpdateRequest(payingOff) ){
 			return preparePayingOffUpdateParameters(payingOff);
 		}
 		return preparePayingOffCreateParameters(payingOff);
 	}
 	protected Object[] preparePayingOffUpdateParameters(PayingOff payingOff){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = payingOff.getWho(); 	
 		if(payingOff.getPaidFor() != null){
 			parameters[1] = payingOff.getPaidFor().getId();
 		}
 
 		parameters[2] = payingOff.getPaidTime();
 		parameters[3] = payingOff.getAmount();		
 		parameters[4] = payingOff.getId();
 		parameters[5] = payingOff.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePayingOffCreateParameters(PayingOff payingOff){
		Object[] parameters = new Object[5];
		String newPayingOffId=getNextId();
		payingOff.setId(newPayingOffId);
		parameters[0] =  payingOff.getId();
 
 		parameters[1] = payingOff.getWho(); 	
 		if(payingOff.getPaidFor() != null){
 			parameters[2] = payingOff.getPaidFor().getId();
 		
 		}
 		
 		parameters[3] = payingOff.getPaidTime();
 		parameters[4] = payingOff.getAmount();		
 				
 		return parameters;
 	}
 	
	protected PayingOff saveInternalPayingOff(PayingOff payingOff, Map<String,Object> options){
		
		savePayingOff(payingOff);
 	
 		if(isSavePaidForEnabled(options)){
	 		savePaidFor(payingOff, options);
 		}
 
		
		if(isSaveEmployeeSalarySheetListEnabled(options)){
	 		saveEmployeeSalarySheetList(payingOff, options);
	 		removeEmployeeSalarySheetList(payingOff, options);
	 		
 		}		
		
		return payingOff;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PayingOff savePaidFor(PayingOff payingOff, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(payingOff.getPaidFor() == null){
 			return payingOff;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(payingOff.getPaidFor(),options);
 		return payingOff;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected PayingOff saveEmployeeSalarySheetList(PayingOff payingOff, Map<String,Object> options){
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			return payingOff;
		}
		if(employeeSalarySheetList.isEmpty()){
			return payingOff;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeSalarySheetDAO().saveEmployeeSalarySheetList(employeeSalarySheetList,options);
		
		return payingOff;
	
	}
	
	protected PayingOff removeEmployeeSalarySheetList(PayingOff payingOff, Map<String,Object> options){
	
	
		SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
		if(employeeSalarySheetList == null){
			return payingOff;
		}	
	
		SmartList<EmployeeSalarySheet> toRemoveEmployeeSalarySheetList = employeeSalarySheetList.getToRemoveList();
		
		if(toRemoveEmployeeSalarySheetList == null){
			return payingOff;
		}
		if(toRemoveEmployeeSalarySheetList.isEmpty()){
			return payingOff;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeSalarySheetDAO().removeEmployeeSalarySheetList(toRemoveEmployeeSalarySheetList,options);
		
		return payingOff;
	
	}
	
	
	
 	
 	
	
	
	
		

	public PayingOff present(PayingOff payingOff,Map<String, Object> options){
	
		presentEmployeeSalarySheetList(payingOff,options);

		return payingOff;
	
	}
		
	
  	
 	protected PayingOff presentEmployeeSalarySheetList(
			PayingOff payingOff,
			Map<String, Object> options) {

		SmartList<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();		
		if(employeeSalarySheetList == null){
			return payingOff;			
		}
		
		String targetObjectName = "employeeSalarySheet";
		int employeeSalarySheetListSize = employeeSalarySheetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeSalarySheetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return payingOff;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeSalarySheetListSize;
		if(employeeSalarySheetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeSalarySheetDAO().countEmployeeSalarySheetByPayingOff(payingOff.getId(), options);			
		}
		//payingOff.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//payingOff.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeSalarySheetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeSalarySheetListSize,currentPage,rowsPerPage) ;
			employeeSalarySheetList = employeeSalarySheetList.subListOf(fromIndex, toIndex);
			employeeSalarySheetList.setTotalCount(count);
			employeeSalarySheetList.setCurrentPageNumber(currentPage);			
			payingOff.setEmployeeSalarySheetList(employeeSalarySheetList);
			return payingOff;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeSalarySheetList 
			= getEmployeeSalarySheetDAO().findEmployeeSalarySheetByPayingOff(payingOff.getId(),start, rowsPerPage, options );
		employeeSalarySheetList.setTotalCount(count);
		employeeSalarySheetList.setCurrentPageNumber(currentPage);
		payingOff.setEmployeeSalarySheetList(employeeSalarySheetList );	

		return payingOff;
	}			
		


	protected String getTableName(){
		return PayingOffTable.TABLE_NAME;
	}
}












