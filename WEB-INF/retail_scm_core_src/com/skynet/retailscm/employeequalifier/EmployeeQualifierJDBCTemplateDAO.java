
package com.skynet.retailscm.employeequalifier;

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

public class EmployeeQualifierJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeQualifierDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeQualifier load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeQualifier(accessKey, options);
	}
	*/
	public EmployeeQualifier load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeQualifier(EmployeeQualifierTable.withId(id), options);
	}
	
	
	
	public EmployeeQualifier save(EmployeeQualifier employeeQualifier,Map<String,Object> options){
		
		String methodName="save(EmployeeQualifier employeeQualifier,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeQualifier, methodName, "employeeQualifier");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeQualifier(employeeQualifier,options);
	}
	public EmployeeQualifier clone(String employeeQualifierId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeQualifierTable.withId(employeeQualifierId),options);
	}
	
	protected EmployeeQualifier clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeQualifierId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeQualifier newEmployeeQualifier = loadInternalEmployeeQualifier(accessKey, options);
		newEmployeeQualifier.setVersion(0);
		
		

		
		saveInternalEmployeeQualifier(newEmployeeQualifier,options);
		
		return newEmployeeQualifier;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeQualifierId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeQualifierId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeQualifierVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeQualifierNotFoundException(
					"The " + this.getTableName() + "(" + employeeQualifierId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeQualifierId, int version) throws Exception{
	
		String methodName="delete(String employeeQualifierId, int version)";
		assertMethodArgumentNotNull(employeeQualifierId, methodName, "employeeQualifierId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeQualifierId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeQualifierId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","qualified_time","type","level","remark"};
		return EmployeeQualifierTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_qualifier";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeQualifierTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeQualifierTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeQualifierTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeQualifierMapper getEmployeeQualifierMapper(){
		return new EmployeeQualifierMapper();
	}
	protected EmployeeQualifier extractEmployeeQualifier(String employeeQualifierId) throws Exception{
		String SQL = "select * from employee_qualifier_data where id = ?";	
		try{
		
			EmployeeQualifier employeeQualifier = queryForObject(SQL, new Object[]{employeeQualifierId}, getEmployeeQualifierMapper());
			return employeeQualifier;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeQualifierNotFoundException("EmployeeQualifier("+employeeQualifierId+") is not found!");
		}
		
		
	}
	protected EmployeeQualifier extractEmployeeQualifier(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_qualifier_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeQualifier employeeQualifier = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeQualifierMapper());
			return employeeQualifier;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeQualifierNotFoundException("EmployeeQualifier("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeQualifier loadInternalEmployeeQualifier(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeQualifier employeeQualifier = extractEmployeeQualifier(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeQualifier, loadOptions);
 		}
 
		
		return employeeQualifier;
		
	}



	
	
	 

 	protected EmployeeQualifier extractEmployee(EmployeeQualifier employeeQualifier, Map<String,Object> options) throws Exception{

		if(employeeQualifier.getEmployee() == null){
			return employeeQualifier;
		}
		String employeeId = employeeQualifier.getEmployee().getId();
		if( employeeId == null){
			return employeeQualifier;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeQualifier.setEmployee(employee);
		}
		
 		
 		return employeeQualifier;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeQualifier> employeeQualifierList = queryForList(SQL, new Object[]{employeeId}, getEmployeeQualifierMapper());	
 		return employeeQualifierList;
 	}
 	
 	public SmartList<EmployeeQualifier> findEmployeeQualifierByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeQualifier> employeeQualifierList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeQualifierMapper());
		
 		return employeeQualifierList;
 	}
 	
 	public int countEmployeeQualifierByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeQualifier saveEmployeeQualifier(EmployeeQualifier  employeeQualifier){
	
		String SQL=this.getSaveEmployeeQualifierSQL(employeeQualifier);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeQualifierParameters(employeeQualifier);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeQualifier.incVersion();
		return employeeQualifier;
	
	}
	public SmartList<EmployeeQualifier> saveEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeQualifierList(employeeQualifierList);
		
		batchEmployeeQualifierCreate((List<EmployeeQualifier>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeQualifierUpdate((List<EmployeeQualifier>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeQualifier employeeQualifier:employeeQualifierList){
			if(employeeQualifier.isChanged()){
				employeeQualifier.incVersion();
			}
			
		
		}
		
		
		return employeeQualifierList;
	}

	public SmartList<EmployeeQualifier> removeEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList,Map<String,Object> options){
		
		
		super.removeList(employeeQualifierList, options);
		
		return employeeQualifierList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeQualifierBatchCreateArgs(List<EmployeeQualifier> employeeQualifierList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeQualifier employeeQualifier:employeeQualifierList ){
			Object [] parameters = prepareEmployeeQualifierCreateParameters(employeeQualifier);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeQualifierBatchUpdateArgs(List<EmployeeQualifier> employeeQualifierList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeQualifier employeeQualifier:employeeQualifierList ){
			if(!employeeQualifier.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeQualifierUpdateParameters(employeeQualifier);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeQualifierCreate(List<EmployeeQualifier> employeeQualifierList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeQualifierBatchCreateArgs(employeeQualifierList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeQualifierUpdate(List<EmployeeQualifier> employeeQualifierList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeQualifierBatchUpdateArgs(employeeQualifierList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeQualifierList(List<EmployeeQualifier> employeeQualifierList){
		
		List<EmployeeQualifier> employeeQualifierCreateList=new ArrayList<EmployeeQualifier>();
		List<EmployeeQualifier> employeeQualifierUpdateList=new ArrayList<EmployeeQualifier>();
		
		for(EmployeeQualifier employeeQualifier: employeeQualifierList){
			if(isUpdateRequest(employeeQualifier)){
				employeeQualifierUpdateList.add( employeeQualifier);
				continue;
			}
			employeeQualifierCreateList.add(employeeQualifier);
		}
		
		return new Object[]{employeeQualifierCreateList,employeeQualifierUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeQualifier employeeQualifier){
 		return employeeQualifier.getVersion() > 0;
 	}
 	protected String getSaveEmployeeQualifierSQL(EmployeeQualifier employeeQualifier){
 		if(isUpdateRequest(employeeQualifier)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeQualifierParameters(EmployeeQualifier employeeQualifier){
 		if(isUpdateRequest(employeeQualifier) ){
 			return prepareEmployeeQualifierUpdateParameters(employeeQualifier);
 		}
 		return prepareEmployeeQualifierCreateParameters(employeeQualifier);
 	}
 	protected Object[] prepareEmployeeQualifierUpdateParameters(EmployeeQualifier employeeQualifier){
 		Object[] parameters = new Object[7];
  	
 		if(employeeQualifier.getEmployee() != null){
 			parameters[0] = employeeQualifier.getEmployee().getId();
 		}
 
 		parameters[1] = employeeQualifier.getQualifiedTime();
 		parameters[2] = employeeQualifier.getType();
 		parameters[3] = employeeQualifier.getLevel();
 		parameters[4] = employeeQualifier.getRemark();		
 		parameters[5] = employeeQualifier.getId();
 		parameters[6] = employeeQualifier.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeQualifierCreateParameters(EmployeeQualifier employeeQualifier){
		Object[] parameters = new Object[6];
		String newEmployeeQualifierId=getNextId();
		employeeQualifier.setId(newEmployeeQualifierId);
		parameters[0] =  employeeQualifier.getId();
  	
 		if(employeeQualifier.getEmployee() != null){
 			parameters[1] = employeeQualifier.getEmployee().getId();
 		
 		}
 		
 		parameters[2] = employeeQualifier.getQualifiedTime();
 		parameters[3] = employeeQualifier.getType();
 		parameters[4] = employeeQualifier.getLevel();
 		parameters[5] = employeeQualifier.getRemark();		
 				
 		return parameters;
 	}
 	
	protected EmployeeQualifier saveInternalEmployeeQualifier(EmployeeQualifier employeeQualifier, Map<String,Object> options){
		
		saveEmployeeQualifier(employeeQualifier);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeQualifier, options);
 		}
 
		
		return employeeQualifier;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeQualifier saveEmployee(EmployeeQualifier employeeQualifier, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeQualifier.getEmployee() == null){
 			return employeeQualifier;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeQualifier.getEmployee(),options);
 		return employeeQualifier;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeQualifier present(EmployeeQualifier employeeQualifier,Map<String, Object> options){
	

		return employeeQualifier;
	
	}
		


	protected String getTableName(){
		return EmployeeQualifierTable.TABLE_NAME;
	}
}


