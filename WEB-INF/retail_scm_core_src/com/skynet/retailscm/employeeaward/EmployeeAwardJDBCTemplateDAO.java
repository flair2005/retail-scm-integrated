
package com.skynet.retailscm.employeeaward;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.employee.EmployeeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeAwardJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeAwardDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeAward load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAward(accessKey, options);
	}
	*/
	public EmployeeAward load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAward(EmployeeAwardTable.withId(id), options);
	}
	
	
	
	public EmployeeAward save(EmployeeAward employeeAward,Map<String,Object> options){
		
		String methodName="save(EmployeeAward employeeAward,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeAward, methodName, "employeeAward");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeAward(employeeAward,options);
	}
	public EmployeeAward clone(String employeeAwardId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeAwardTable.withId(employeeAwardId),options);
	}
	
	protected EmployeeAward clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeAwardId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeAward newEmployeeAward = loadInternalEmployeeAward(accessKey, options);
		newEmployeeAward.setVersion(0);
		
		

		
		saveInternalEmployeeAward(newEmployeeAward,options);
		
		return newEmployeeAward;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeAwardId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeAwardId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeAwardVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeAwardNotFoundException(
					"The " + this.getTableName() + "(" + employeeAwardId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeAwardId, int version) throws Exception{
	
		String methodName="delete(String employeeAwardId, int version)";
		assertMethodArgumentNotNull(employeeAwardId, methodName, "employeeAwardId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeAwardId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeAwardId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","complete_time","type","remark"};
		return EmployeeAwardTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_award";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeAwardTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeAwardTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeAwardTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeAwardMapper getEmployeeAwardMapper(){
		return new EmployeeAwardMapper();
	}
	protected EmployeeAward extractEmployeeAward(String employeeAwardId) throws Exception{
		String SQL = "select * from employee_award_data where id = ?";	
		try{
		
			EmployeeAward employeeAward = queryForObject(SQL, new Object[]{employeeAwardId}, getEmployeeAwardMapper());
			return employeeAward;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeAwardNotFoundException("EmployeeAward("+employeeAwardId+") is not found!");
		}
		
		
	}
	protected EmployeeAward extractEmployeeAward(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_award_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeAward employeeAward = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeAwardMapper());
			return employeeAward;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeAwardNotFoundException("EmployeeAward("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeAward loadInternalEmployeeAward(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeAward employeeAward = extractEmployeeAward(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeAward, loadOptions);
 		}
 
		
		return employeeAward;
		
	}



	
	
	 

 	protected EmployeeAward extractEmployee(EmployeeAward employeeAward, Map<String,Object> options) throws Exception{

		if(employeeAward.getEmployee() == null){
			return employeeAward;
		}
		String employeeId = employeeAward.getEmployee().getId();
		if( employeeId == null){
			return employeeAward;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeAward.setEmployee(employee);
		}
		
 		
 		return employeeAward;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeAward> employeeAwardList = queryForList(SQL, new Object[]{employeeId}, getEmployeeAwardMapper());	
 		return employeeAwardList;
 	}
 	
 	public SmartList<EmployeeAward> findEmployeeAwardByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeAward> employeeAwardList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeAwardMapper());
		
 		return employeeAwardList;
 	}
 	
 	public int countEmployeeAwardByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeAward saveEmployeeAward(EmployeeAward  employeeAward){
	
		String SQL=this.getSaveEmployeeAwardSQL(employeeAward);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeAwardParameters(employeeAward);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeAward.incVersion();
		return employeeAward;
	
	}
	public SmartList<EmployeeAward> saveEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeAwardList(employeeAwardList);
		
		batchEmployeeAwardCreate((List<EmployeeAward>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeAwardUpdate((List<EmployeeAward>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeAward employeeAward:employeeAwardList){
			if(employeeAward.isChanged()){
				employeeAward.incVersion();
			}
			
		
		}
		
		
		return employeeAwardList;
	}

	public SmartList<EmployeeAward> removeEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList,Map<String,Object> options){
		
		
		super.removeList(employeeAwardList, options);
		
		return employeeAwardList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeAwardBatchCreateArgs(List<EmployeeAward> employeeAwardList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAward employeeAward:employeeAwardList ){
			Object [] parameters = prepareEmployeeAwardCreateParameters(employeeAward);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeAwardBatchUpdateArgs(List<EmployeeAward> employeeAwardList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAward employeeAward:employeeAwardList ){
			if(!employeeAward.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeAwardUpdateParameters(employeeAward);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeAwardCreate(List<EmployeeAward> employeeAwardList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeAwardBatchCreateArgs(employeeAwardList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeAwardUpdate(List<EmployeeAward> employeeAwardList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeAwardBatchUpdateArgs(employeeAwardList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeAwardList(List<EmployeeAward> employeeAwardList){
		
		List<EmployeeAward> employeeAwardCreateList=new ArrayList<EmployeeAward>();
		List<EmployeeAward> employeeAwardUpdateList=new ArrayList<EmployeeAward>();
		
		for(EmployeeAward employeeAward: employeeAwardList){
			if(isUpdateRequest(employeeAward)){
				employeeAwardUpdateList.add( employeeAward);
				continue;
			}
			employeeAwardCreateList.add(employeeAward);
		}
		
		return new Object[]{employeeAwardCreateList,employeeAwardUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeAward employeeAward){
 		return employeeAward.getVersion() > 0;
 	}
 	protected String getSaveEmployeeAwardSQL(EmployeeAward employeeAward){
 		if(isUpdateRequest(employeeAward)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeAwardParameters(EmployeeAward employeeAward){
 		if(isUpdateRequest(employeeAward) ){
 			return prepareEmployeeAwardUpdateParameters(employeeAward);
 		}
 		return prepareEmployeeAwardCreateParameters(employeeAward);
 	}
 	protected Object[] prepareEmployeeAwardUpdateParameters(EmployeeAward employeeAward){
 		Object[] parameters = new Object[6];
  	
 		if(employeeAward.getEmployee() != null){
 			parameters[0] = employeeAward.getEmployee().getId();
 		}
 
 		parameters[1] = employeeAward.getCompleteTime();
 		parameters[2] = employeeAward.getType();
 		parameters[3] = employeeAward.getRemark();		
 		parameters[4] = employeeAward.getId();
 		parameters[5] = employeeAward.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeAwardCreateParameters(EmployeeAward employeeAward){
		Object[] parameters = new Object[5];
		String newEmployeeAwardId=getNextId();
		employeeAward.setId(newEmployeeAwardId);
		parameters[0] =  employeeAward.getId();
  	
 		if(employeeAward.getEmployee() != null){
 			parameters[1] = employeeAward.getEmployee().getId();
 		
 		}
 		
 		parameters[2] = employeeAward.getCompleteTime();
 		parameters[3] = employeeAward.getType();
 		parameters[4] = employeeAward.getRemark();		
 				
 		return parameters;
 	}
 	
	protected EmployeeAward saveInternalEmployeeAward(EmployeeAward employeeAward, Map<String,Object> options){
		
		saveEmployeeAward(employeeAward);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeAward, options);
 		}
 
		
		return employeeAward;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeAward saveEmployee(EmployeeAward employeeAward, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeAward.getEmployee() == null){
 			return employeeAward;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeAward.getEmployee(),options);
 		return employeeAward;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeAward present(EmployeeAward employeeAward,Map<String, Object> options){
	

		return employeeAward;
	
	}
		


	protected String getTableName(){
		return EmployeeAwardTable.TABLE_NAME;
	}
}


