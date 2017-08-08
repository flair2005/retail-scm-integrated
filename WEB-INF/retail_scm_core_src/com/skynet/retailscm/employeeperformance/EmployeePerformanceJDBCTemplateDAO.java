
package com.skynet.retailscm.employeeperformance;

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

public class EmployeePerformanceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeePerformanceDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeePerformance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeePerformance(accessKey, options);
	}
	*/
	public EmployeePerformance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeePerformance(EmployeePerformanceTable.withId(id), options);
	}
	
	
	
	public EmployeePerformance save(EmployeePerformance employeePerformance,Map<String,Object> options){
		
		String methodName="save(EmployeePerformance employeePerformance,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeePerformance, methodName, "employeePerformance");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeePerformance(employeePerformance,options);
	}
	public EmployeePerformance clone(String employeePerformanceId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeePerformanceTable.withId(employeePerformanceId),options);
	}
	
	protected EmployeePerformance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeePerformanceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeePerformance newEmployeePerformance = loadInternalEmployeePerformance(accessKey, options);
		newEmployeePerformance.setVersion(0);
		
		

		
		saveInternalEmployeePerformance(newEmployeePerformance,options);
		
		return newEmployeePerformance;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeePerformanceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeePerformanceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeePerformanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeePerformanceNotFoundException(
					"The " + this.getTableName() + "(" + employeePerformanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeePerformanceId, int version) throws Exception{
	
		String methodName="delete(String employeePerformanceId, int version)";
		assertMethodArgumentNotNull(employeePerformanceId, methodName, "employeePerformanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeePerformanceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeePerformanceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","performance_comment"};
		return EmployeePerformanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_performance";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeePerformanceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeePerformanceTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeePerformanceTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeePerformanceMapper getEmployeePerformanceMapper(){
		return new EmployeePerformanceMapper();
	}
	protected EmployeePerformance extractEmployeePerformance(String employeePerformanceId) throws Exception{
		String SQL = "select * from employee_performance_data where id = ?";	
		try{
		
			EmployeePerformance employeePerformance = queryForObject(SQL, new Object[]{employeePerformanceId}, getEmployeePerformanceMapper());
			return employeePerformance;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeePerformanceNotFoundException("EmployeePerformance("+employeePerformanceId+") is not found!");
		}
		
		
	}
	protected EmployeePerformance extractEmployeePerformance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_performance_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeePerformance employeePerformance = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeePerformanceMapper());
			return employeePerformance;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeePerformanceNotFoundException("EmployeePerformance("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeePerformance loadInternalEmployeePerformance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeePerformance employeePerformance = extractEmployeePerformance(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeePerformance, loadOptions);
 		}
 
		
		return employeePerformance;
		
	}



	
	
	 

 	protected EmployeePerformance extractEmployee(EmployeePerformance employeePerformance, Map<String,Object> options) throws Exception{

		if(employeePerformance.getEmployee() == null){
			return employeePerformance;
		}
		String employeeId = employeePerformance.getEmployee().getId();
		if( employeeId == null){
			return employeePerformance;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeePerformance.setEmployee(employee);
		}
		
 		
 		return employeePerformance;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeePerformance> employeePerformanceList = queryForList(SQL, new Object[]{employeeId}, getEmployeePerformanceMapper());	
 		return employeePerformanceList;
 	}
 	
 	public SmartList<EmployeePerformance> findEmployeePerformanceByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeePerformance> employeePerformanceList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeePerformanceMapper());
		
 		return employeePerformanceList;
 	}
 	
 	public int countEmployeePerformanceByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeePerformance saveEmployeePerformance(EmployeePerformance  employeePerformance){
	
		String SQL=this.getSaveEmployeePerformanceSQL(employeePerformance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeePerformanceParameters(employeePerformance);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeePerformance.incVersion();
		return employeePerformance;
	
	}
	public SmartList<EmployeePerformance> saveEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeePerformanceList(employeePerformanceList);
		
		batchEmployeePerformanceCreate((List<EmployeePerformance>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeePerformanceUpdate((List<EmployeePerformance>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeePerformance employeePerformance:employeePerformanceList){
			if(employeePerformance.isChanged()){
				employeePerformance.incVersion();
			}
			
		
		}
		
		
		return employeePerformanceList;
	}

	public SmartList<EmployeePerformance> removeEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList,Map<String,Object> options){
		
		
		super.removeList(employeePerformanceList, options);
		
		return employeePerformanceList;
		
		
	}
	
	protected List<Object[]> prepareEmployeePerformanceBatchCreateArgs(List<EmployeePerformance> employeePerformanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeePerformance employeePerformance:employeePerformanceList ){
			Object [] parameters = prepareEmployeePerformanceCreateParameters(employeePerformance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeePerformanceBatchUpdateArgs(List<EmployeePerformance> employeePerformanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeePerformance employeePerformance:employeePerformanceList ){
			if(!employeePerformance.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeePerformanceUpdateParameters(employeePerformance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeePerformanceCreate(List<EmployeePerformance> employeePerformanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeePerformanceBatchCreateArgs(employeePerformanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeePerformanceUpdate(List<EmployeePerformance> employeePerformanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeePerformanceBatchUpdateArgs(employeePerformanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeePerformanceList(List<EmployeePerformance> employeePerformanceList){
		
		List<EmployeePerformance> employeePerformanceCreateList=new ArrayList<EmployeePerformance>();
		List<EmployeePerformance> employeePerformanceUpdateList=new ArrayList<EmployeePerformance>();
		
		for(EmployeePerformance employeePerformance: employeePerformanceList){
			if(isUpdateRequest(employeePerformance)){
				employeePerformanceUpdateList.add( employeePerformance);
				continue;
			}
			employeePerformanceCreateList.add(employeePerformance);
		}
		
		return new Object[]{employeePerformanceCreateList,employeePerformanceUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeePerformance employeePerformance){
 		return employeePerformance.getVersion() > 0;
 	}
 	protected String getSaveEmployeePerformanceSQL(EmployeePerformance employeePerformance){
 		if(isUpdateRequest(employeePerformance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeePerformanceParameters(EmployeePerformance employeePerformance){
 		if(isUpdateRequest(employeePerformance) ){
 			return prepareEmployeePerformanceUpdateParameters(employeePerformance);
 		}
 		return prepareEmployeePerformanceCreateParameters(employeePerformance);
 	}
 	protected Object[] prepareEmployeePerformanceUpdateParameters(EmployeePerformance employeePerformance){
 		Object[] parameters = new Object[4];
  	
 		if(employeePerformance.getEmployee() != null){
 			parameters[0] = employeePerformance.getEmployee().getId();
 		}
 
 		parameters[1] = employeePerformance.getPerformanceComment();		
 		parameters[2] = employeePerformance.getId();
 		parameters[3] = employeePerformance.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeePerformanceCreateParameters(EmployeePerformance employeePerformance){
		Object[] parameters = new Object[3];
		String newEmployeePerformanceId=getNextId();
		employeePerformance.setId(newEmployeePerformanceId);
		parameters[0] =  employeePerformance.getId();
  	
 		if(employeePerformance.getEmployee() != null){
 			parameters[1] = employeePerformance.getEmployee().getId();
 		
 		}
 		
 		parameters[2] = employeePerformance.getPerformanceComment();		
 				
 		return parameters;
 	}
 	
	protected EmployeePerformance saveInternalEmployeePerformance(EmployeePerformance employeePerformance, Map<String,Object> options){
		
		saveEmployeePerformance(employeePerformance);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeePerformance, options);
 		}
 
		
		return employeePerformance;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeePerformance saveEmployee(EmployeePerformance employeePerformance, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeePerformance.getEmployee() == null){
 			return employeePerformance;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeePerformance.getEmployee(),options);
 		return employeePerformance;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeePerformance present(EmployeePerformance employeePerformance,Map<String, Object> options){
	

		return employeePerformance;
	
	}
		


	protected String getTableName(){
		return EmployeePerformanceTable.TABLE_NAME;
	}
}


