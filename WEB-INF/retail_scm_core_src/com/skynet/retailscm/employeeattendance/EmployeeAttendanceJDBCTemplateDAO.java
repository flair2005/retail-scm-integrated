
package com.skynet.retailscm.employeeattendance;

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

public class EmployeeAttendanceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeAttendanceDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeAttendance load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAttendance(accessKey, options);
	}
	*/
	public EmployeeAttendance load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeAttendance(EmployeeAttendanceTable.withId(id), options);
	}
	
	
	
	public EmployeeAttendance save(EmployeeAttendance employeeAttendance,Map<String,Object> options){
		
		String methodName="save(EmployeeAttendance employeeAttendance,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeAttendance, methodName, "employeeAttendance");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeAttendance(employeeAttendance,options);
	}
	public EmployeeAttendance clone(String employeeAttendanceId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeAttendanceTable.withId(employeeAttendanceId),options);
	}
	
	protected EmployeeAttendance clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeAttendanceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeAttendance newEmployeeAttendance = loadInternalEmployeeAttendance(accessKey, options);
		newEmployeeAttendance.setVersion(0);
		
		

		
		saveInternalEmployeeAttendance(newEmployeeAttendance,options);
		
		return newEmployeeAttendance;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeAttendanceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeAttendanceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeAttendanceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeAttendanceNotFoundException(
					"The " + this.getTableName() + "(" + employeeAttendanceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeAttendanceId, int version) throws Exception{
	
		String methodName="delete(String employeeAttendanceId, int version)";
		assertMethodArgumentNotNull(employeeAttendanceId, methodName, "employeeAttendanceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeAttendanceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeAttendanceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","enter_time","leave_time","duration_hours","remark"};
		return EmployeeAttendanceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_attendance";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeAttendanceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeAttendanceTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeAttendanceTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeAttendanceMapper getEmployeeAttendanceMapper(){
		return new EmployeeAttendanceMapper();
	}
	protected EmployeeAttendance extractEmployeeAttendance(String employeeAttendanceId) throws Exception{
		String SQL = "select * from employee_attendance_data where id = ?";	
		try{
		
			EmployeeAttendance employeeAttendance = queryForObject(SQL, new Object[]{employeeAttendanceId}, getEmployeeAttendanceMapper());
			return employeeAttendance;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeAttendanceNotFoundException("EmployeeAttendance("+employeeAttendanceId+") is not found!");
		}
		
		
	}
	protected EmployeeAttendance extractEmployeeAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_attendance_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeAttendance employeeAttendance = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeAttendanceMapper());
			return employeeAttendance;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeAttendanceNotFoundException("EmployeeAttendance("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeAttendance loadInternalEmployeeAttendance(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeAttendance employeeAttendance = extractEmployeeAttendance(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeAttendance, loadOptions);
 		}
 
		
		return employeeAttendance;
		
	}



	
	
	 

 	protected EmployeeAttendance extractEmployee(EmployeeAttendance employeeAttendance, Map<String,Object> options) throws Exception{

		if(employeeAttendance.getEmployee() == null){
			return employeeAttendance;
		}
		String employeeId = employeeAttendance.getEmployee().getId();
		if( employeeId == null){
			return employeeAttendance;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeAttendance.setEmployee(employee);
		}
		
 		
 		return employeeAttendance;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeAttendance> employeeAttendanceList = queryForList(SQL, new Object[]{employeeId}, getEmployeeAttendanceMapper());	
 		return employeeAttendanceList;
 	}
 	
 	public SmartList<EmployeeAttendance> findEmployeeAttendanceByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeAttendance> employeeAttendanceList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeAttendanceMapper());
		
 		return employeeAttendanceList;
 	}
 	
 	public int countEmployeeAttendanceByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeAttendance saveEmployeeAttendance(EmployeeAttendance  employeeAttendance){
	
		String SQL=this.getSaveEmployeeAttendanceSQL(employeeAttendance);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeAttendanceParameters(employeeAttendance);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeAttendance.incVersion();
		return employeeAttendance;
	
	}
	public SmartList<EmployeeAttendance> saveEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeAttendanceList(employeeAttendanceList);
		
		batchEmployeeAttendanceCreate((List<EmployeeAttendance>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeAttendanceUpdate((List<EmployeeAttendance>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeAttendance employeeAttendance:employeeAttendanceList){
			if(employeeAttendance.isChanged()){
				employeeAttendance.incVersion();
			}
			
		
		}
		
		
		return employeeAttendanceList;
	}

	public SmartList<EmployeeAttendance> removeEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList,Map<String,Object> options){
		
		
		super.removeList(employeeAttendanceList, options);
		
		return employeeAttendanceList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeAttendanceBatchCreateArgs(List<EmployeeAttendance> employeeAttendanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAttendance employeeAttendance:employeeAttendanceList ){
			Object [] parameters = prepareEmployeeAttendanceCreateParameters(employeeAttendance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeAttendanceBatchUpdateArgs(List<EmployeeAttendance> employeeAttendanceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeAttendance employeeAttendance:employeeAttendanceList ){
			if(!employeeAttendance.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeAttendanceUpdateParameters(employeeAttendance);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeAttendanceCreate(List<EmployeeAttendance> employeeAttendanceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeAttendanceBatchCreateArgs(employeeAttendanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeAttendanceUpdate(List<EmployeeAttendance> employeeAttendanceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeAttendanceBatchUpdateArgs(employeeAttendanceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeAttendanceList(List<EmployeeAttendance> employeeAttendanceList){
		
		List<EmployeeAttendance> employeeAttendanceCreateList=new ArrayList<EmployeeAttendance>();
		List<EmployeeAttendance> employeeAttendanceUpdateList=new ArrayList<EmployeeAttendance>();
		
		for(EmployeeAttendance employeeAttendance: employeeAttendanceList){
			if(isUpdateRequest(employeeAttendance)){
				employeeAttendanceUpdateList.add( employeeAttendance);
				continue;
			}
			employeeAttendanceCreateList.add(employeeAttendance);
		}
		
		return new Object[]{employeeAttendanceCreateList,employeeAttendanceUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeAttendance employeeAttendance){
 		return employeeAttendance.getVersion() > 0;
 	}
 	protected String getSaveEmployeeAttendanceSQL(EmployeeAttendance employeeAttendance){
 		if(isUpdateRequest(employeeAttendance)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeAttendanceParameters(EmployeeAttendance employeeAttendance){
 		if(isUpdateRequest(employeeAttendance) ){
 			return prepareEmployeeAttendanceUpdateParameters(employeeAttendance);
 		}
 		return prepareEmployeeAttendanceCreateParameters(employeeAttendance);
 	}
 	protected Object[] prepareEmployeeAttendanceUpdateParameters(EmployeeAttendance employeeAttendance){
 		Object[] parameters = new Object[7];
  	
 		if(employeeAttendance.getEmployee() != null){
 			parameters[0] = employeeAttendance.getEmployee().getId();
 		}
 
 		parameters[1] = employeeAttendance.getEnterTime();
 		parameters[2] = employeeAttendance.getLeaveTime();
 		parameters[3] = employeeAttendance.getDurationHours();
 		parameters[4] = employeeAttendance.getRemark();		
 		parameters[5] = employeeAttendance.getId();
 		parameters[6] = employeeAttendance.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeAttendanceCreateParameters(EmployeeAttendance employeeAttendance){
		Object[] parameters = new Object[6];
		String newEmployeeAttendanceId=getNextId();
		employeeAttendance.setId(newEmployeeAttendanceId);
		parameters[0] =  employeeAttendance.getId();
  	
 		if(employeeAttendance.getEmployee() != null){
 			parameters[1] = employeeAttendance.getEmployee().getId();
 		
 		}
 		
 		parameters[2] = employeeAttendance.getEnterTime();
 		parameters[3] = employeeAttendance.getLeaveTime();
 		parameters[4] = employeeAttendance.getDurationHours();
 		parameters[5] = employeeAttendance.getRemark();		
 				
 		return parameters;
 	}
 	
	protected EmployeeAttendance saveInternalEmployeeAttendance(EmployeeAttendance employeeAttendance, Map<String,Object> options){
		
		saveEmployeeAttendance(employeeAttendance);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeAttendance, options);
 		}
 
		
		return employeeAttendance;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeAttendance saveEmployee(EmployeeAttendance employeeAttendance, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeAttendance.getEmployee() == null){
 			return employeeAttendance;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeAttendance.getEmployee(),options);
 		return employeeAttendance;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeAttendance present(EmployeeAttendance employeeAttendance,Map<String, Object> options){
	

		return employeeAttendance;
	
	}
		


	protected String getTableName(){
		return EmployeeAttendanceTable.TABLE_NAME;
	}
}


