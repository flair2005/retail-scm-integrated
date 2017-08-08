
package com.skynet.retailscm.employeeleave;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.leavetype.LeaveType;

import com.skynet.retailscm.leavetype.LeaveTypeDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.leavetype.LeaveTypeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeLeaveJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeLeaveDAO{
 
 	
 	private  LeaveTypeDAO  leaveTypeDAO;
 	public void setLeaveTypeDAO(LeaveTypeDAO leaveTypeDAO){
	 	this.leaveTypeDAO = leaveTypeDAO;
 	}
 	public LeaveTypeDAO getLeaveTypeDAO(){
	 	return this.leaveTypeDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeLeave load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeLeave(accessKey, options);
	}
	*/
	public EmployeeLeave load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeLeave(EmployeeLeaveTable.withId(id), options);
	}
	
	
	
	public EmployeeLeave save(EmployeeLeave employeeLeave,Map<String,Object> options){
		
		String methodName="save(EmployeeLeave employeeLeave,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeLeave, methodName, "employeeLeave");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeLeave(employeeLeave,options);
	}
	public EmployeeLeave clone(String employeeLeaveId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeLeaveTable.withId(employeeLeaveId),options);
	}
	
	protected EmployeeLeave clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeLeaveId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeLeave newEmployeeLeave = loadInternalEmployeeLeave(accessKey, options);
		newEmployeeLeave.setVersion(0);
		
		

		
		saveInternalEmployeeLeave(newEmployeeLeave,options);
		
		return newEmployeeLeave;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeLeaveId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeLeaveId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeLeaveVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeLeaveNotFoundException(
					"The " + this.getTableName() + "(" + employeeLeaveId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeLeaveId, int version) throws Exception{
	
		String methodName="delete(String employeeLeaveId, int version)";
		assertMethodArgumentNotNull(employeeLeaveId, methodName, "employeeLeaveId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeLeaveId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeLeaveId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","type","leave_duration_hour","remark"};
		return EmployeeLeaveTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_leave";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeLeaveTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractWhoEnabled = true;
 	//private static final String WHO = "who";
 	protected boolean isExtractWhoEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeLeaveTokens.WHO);
 	}
 	
 	
 	//private boolean saveWhoEnabled = true;
 	protected boolean isSaveWhoEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeLeaveTokens.WHO);
 	}
 	

 	
  
 	//private boolean extractTypeEnabled = true;
 	//private static final String TYPE = "type";
 	protected boolean isExtractTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeLeaveTokens.TYPE);
 	}
 	
 	
 	//private boolean saveTypeEnabled = true;
 	protected boolean isSaveTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeLeaveTokens.TYPE);
 	}
 	

 	
 
		

	

	protected EmployeeLeaveMapper getEmployeeLeaveMapper(){
		return new EmployeeLeaveMapper();
	}
	protected EmployeeLeave extractEmployeeLeave(String employeeLeaveId) throws Exception{
		String SQL = "select * from employee_leave_data where id = ?";	
		try{
		
			EmployeeLeave employeeLeave = queryForObject(SQL, new Object[]{employeeLeaveId}, getEmployeeLeaveMapper());
			return employeeLeave;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeLeaveNotFoundException("EmployeeLeave("+employeeLeaveId+") is not found!");
		}
		
		
	}
	protected EmployeeLeave extractEmployeeLeave(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_leave_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeLeave employeeLeave = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeLeaveMapper());
			return employeeLeave;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeLeaveNotFoundException("EmployeeLeave("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeLeave loadInternalEmployeeLeave(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeLeave employeeLeave = extractEmployeeLeave(accessKey, loadOptions);
 	
 		if(isExtractWhoEnabled(loadOptions)){
	 		extractWho(employeeLeave, loadOptions);
 		}
  	
 		if(isExtractTypeEnabled(loadOptions)){
	 		extractType(employeeLeave, loadOptions);
 		}
 
		
		return employeeLeave;
		
	}



	
	
	 

 	protected EmployeeLeave extractWho(EmployeeLeave employeeLeave, Map<String,Object> options) throws Exception{

		if(employeeLeave.getWho() == null){
			return employeeLeave;
		}
		String whoId = employeeLeave.getWho().getId();
		if( whoId == null){
			return employeeLeave;
		}
		Employee who = getEmployeeDAO().load(whoId,options);
		if(who != null){
			employeeLeave.setWho(who);
		}
		
 		
 		return employeeLeave;
 	}
 		
  

 	protected EmployeeLeave extractType(EmployeeLeave employeeLeave, Map<String,Object> options) throws Exception{

		if(employeeLeave.getType() == null){
			return employeeLeave;
		}
		String typeId = employeeLeave.getType().getId();
		if( typeId == null){
			return employeeLeave;
		}
		LeaveType type = getLeaveTypeDAO().load(typeId,options);
		if(type != null){
			employeeLeave.setType(type);
		}
		
 		
 		return employeeLeave;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where who = ?";
		SmartList<EmployeeLeave> employeeLeaveList = queryForList(SQL, new Object[]{employeeId}, getEmployeeLeaveMapper());	
 		return employeeLeaveList;
 	}
 	
 	public SmartList<EmployeeLeave> findEmployeeLeaveByWho(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where who = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeLeave> employeeLeaveList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeLeaveMapper());
		
 		return employeeLeaveList;
 	}
 	
 	public int countEmployeeLeaveByWho(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where who = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where type = ?";
		SmartList<EmployeeLeave> employeeLeaveList = queryForList(SQL, new Object[]{leaveTypeId}, getEmployeeLeaveMapper());	
 		return employeeLeaveList;
 	}
 	
 	public SmartList<EmployeeLeave> findEmployeeLeaveByType(String leaveTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where type = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeLeave> employeeLeaveList = queryForList(SQL, new Object[]{leaveTypeId,start, count}, getEmployeeLeaveMapper());
		
 		return employeeLeaveList;
 	}
 	
 	public int countEmployeeLeaveByType(String leaveTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where type = ?";
		Integer count = queryInt(SQL, new Object[]{leaveTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeLeave saveEmployeeLeave(EmployeeLeave  employeeLeave){
	
		String SQL=this.getSaveEmployeeLeaveSQL(employeeLeave);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeLeaveParameters(employeeLeave);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeLeave.incVersion();
		return employeeLeave;
	
	}
	public SmartList<EmployeeLeave> saveEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeLeaveList(employeeLeaveList);
		
		batchEmployeeLeaveCreate((List<EmployeeLeave>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeLeaveUpdate((List<EmployeeLeave>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeLeave employeeLeave:employeeLeaveList){
			if(employeeLeave.isChanged()){
				employeeLeave.incVersion();
			}
			
		
		}
		
		
		return employeeLeaveList;
	}

	public SmartList<EmployeeLeave> removeEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList,Map<String,Object> options){
		
		
		super.removeList(employeeLeaveList, options);
		
		return employeeLeaveList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeLeaveBatchCreateArgs(List<EmployeeLeave> employeeLeaveList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeLeave employeeLeave:employeeLeaveList ){
			Object [] parameters = prepareEmployeeLeaveCreateParameters(employeeLeave);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeLeaveBatchUpdateArgs(List<EmployeeLeave> employeeLeaveList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeLeave employeeLeave:employeeLeaveList ){
			if(!employeeLeave.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeLeaveUpdateParameters(employeeLeave);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeLeaveCreate(List<EmployeeLeave> employeeLeaveList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeLeaveBatchCreateArgs(employeeLeaveList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeLeaveUpdate(List<EmployeeLeave> employeeLeaveList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeLeaveBatchUpdateArgs(employeeLeaveList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeLeaveList(List<EmployeeLeave> employeeLeaveList){
		
		List<EmployeeLeave> employeeLeaveCreateList=new ArrayList<EmployeeLeave>();
		List<EmployeeLeave> employeeLeaveUpdateList=new ArrayList<EmployeeLeave>();
		
		for(EmployeeLeave employeeLeave: employeeLeaveList){
			if(isUpdateRequest(employeeLeave)){
				employeeLeaveUpdateList.add( employeeLeave);
				continue;
			}
			employeeLeaveCreateList.add(employeeLeave);
		}
		
		return new Object[]{employeeLeaveCreateList,employeeLeaveUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeLeave employeeLeave){
 		return employeeLeave.getVersion() > 0;
 	}
 	protected String getSaveEmployeeLeaveSQL(EmployeeLeave employeeLeave){
 		if(isUpdateRequest(employeeLeave)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeLeaveParameters(EmployeeLeave employeeLeave){
 		if(isUpdateRequest(employeeLeave) ){
 			return prepareEmployeeLeaveUpdateParameters(employeeLeave);
 		}
 		return prepareEmployeeLeaveCreateParameters(employeeLeave);
 	}
 	protected Object[] prepareEmployeeLeaveUpdateParameters(EmployeeLeave employeeLeave){
 		Object[] parameters = new Object[6];
  	
 		if(employeeLeave.getWho() != null){
 			parameters[0] = employeeLeave.getWho().getId();
 		}
  	
 		if(employeeLeave.getType() != null){
 			parameters[1] = employeeLeave.getType().getId();
 		}
 
 		parameters[2] = employeeLeave.getLeaveDurationHour();
 		parameters[3] = employeeLeave.getRemark();		
 		parameters[4] = employeeLeave.getId();
 		parameters[5] = employeeLeave.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeLeaveCreateParameters(EmployeeLeave employeeLeave){
		Object[] parameters = new Object[5];
		String newEmployeeLeaveId=getNextId();
		employeeLeave.setId(newEmployeeLeaveId);
		parameters[0] =  employeeLeave.getId();
  	
 		if(employeeLeave.getWho() != null){
 			parameters[1] = employeeLeave.getWho().getId();
 		
 		}
 		 	
 		if(employeeLeave.getType() != null){
 			parameters[2] = employeeLeave.getType().getId();
 		
 		}
 		
 		parameters[3] = employeeLeave.getLeaveDurationHour();
 		parameters[4] = employeeLeave.getRemark();		
 				
 		return parameters;
 	}
 	
	protected EmployeeLeave saveInternalEmployeeLeave(EmployeeLeave employeeLeave, Map<String,Object> options){
		
		saveEmployeeLeave(employeeLeave);
 	
 		if(isSaveWhoEnabled(options)){
	 		saveWho(employeeLeave, options);
 		}
  	
 		if(isSaveTypeEnabled(options)){
	 		saveType(employeeLeave, options);
 		}
 
		
		return employeeLeave;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeLeave saveWho(EmployeeLeave employeeLeave, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeLeave.getWho() == null){
 			return employeeLeave;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeLeave.getWho(),options);
 		return employeeLeave;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeLeave saveType(EmployeeLeave employeeLeave, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeLeave.getType() == null){
 			return employeeLeave;//do nothing when it is null
 		}
 		
 		getLeaveTypeDAO().save(employeeLeave.getType(),options);
 		return employeeLeave;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeLeave present(EmployeeLeave employeeLeave,Map<String, Object> options){
	

		return employeeLeave;
	
	}
		


	protected String getTableName(){
		return EmployeeLeaveTable.TABLE_NAME;
	}
}


