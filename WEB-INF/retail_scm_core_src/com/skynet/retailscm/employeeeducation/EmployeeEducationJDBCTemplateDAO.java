
package com.skynet.retailscm.employeeeducation;

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

public class EmployeeEducationJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeEducationDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeEducation load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeEducation(accessKey, options);
	}
	*/
	public EmployeeEducation load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeEducation(EmployeeEducationTable.withId(id), options);
	}
	
	
	
	public EmployeeEducation save(EmployeeEducation employeeEducation,Map<String,Object> options){
		
		String methodName="save(EmployeeEducation employeeEducation,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeEducation, methodName, "employeeEducation");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeEducation(employeeEducation,options);
	}
	public EmployeeEducation clone(String employeeEducationId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeEducationTable.withId(employeeEducationId),options);
	}
	
	protected EmployeeEducation clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeEducationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeEducation newEmployeeEducation = loadInternalEmployeeEducation(accessKey, options);
		newEmployeeEducation.setVersion(0);
		
		

		
		saveInternalEmployeeEducation(newEmployeeEducation,options);
		
		return newEmployeeEducation;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeEducationId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeEducationId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeEducationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeEducationNotFoundException(
					"The " + this.getTableName() + "(" + employeeEducationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeEducationId, int version) throws Exception{
	
		String methodName="delete(String employeeEducationId, int version)";
		assertMethodArgumentNotNull(employeeEducationId, methodName, "employeeEducationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeEducationId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeEducationId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","complete_time","type","remark"};
		return EmployeeEducationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_education";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeEducationTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeEducationTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeEducationTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeEducationMapper getEmployeeEducationMapper(){
		return new EmployeeEducationMapper();
	}
	protected EmployeeEducation extractEmployeeEducation(String employeeEducationId) throws Exception{
		String SQL = "select * from employee_education_data where id = ?";	
		try{
		
			EmployeeEducation employeeEducation = queryForObject(SQL, new Object[]{employeeEducationId}, getEmployeeEducationMapper());
			return employeeEducation;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeEducationNotFoundException("EmployeeEducation("+employeeEducationId+") is not found!");
		}
		
		
	}
	protected EmployeeEducation extractEmployeeEducation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_education_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeEducation employeeEducation = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeEducationMapper());
			return employeeEducation;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeEducationNotFoundException("EmployeeEducation("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeEducation loadInternalEmployeeEducation(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeEducation employeeEducation = extractEmployeeEducation(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeEducation, loadOptions);
 		}
 
		
		return employeeEducation;
		
	}



	
	
	 

 	protected EmployeeEducation extractEmployee(EmployeeEducation employeeEducation, Map<String,Object> options) throws Exception{

		if(employeeEducation.getEmployee() == null){
			return employeeEducation;
		}
		String employeeId = employeeEducation.getEmployee().getId();
		if( employeeId == null){
			return employeeEducation;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeEducation.setEmployee(employee);
		}
		
 		
 		return employeeEducation;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeEducation> employeeEducationList = queryForList(SQL, new Object[]{employeeId}, getEmployeeEducationMapper());	
 		return employeeEducationList;
 	}
 	
 	public SmartList<EmployeeEducation> findEmployeeEducationByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeEducation> employeeEducationList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeEducationMapper());
		
 		return employeeEducationList;
 	}
 	
 	public int countEmployeeEducationByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeEducation saveEmployeeEducation(EmployeeEducation  employeeEducation){
	
		String SQL=this.getSaveEmployeeEducationSQL(employeeEducation);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeEducationParameters(employeeEducation);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeEducation.incVersion();
		return employeeEducation;
	
	}
	public SmartList<EmployeeEducation> saveEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeEducationList(employeeEducationList);
		
		batchEmployeeEducationCreate((List<EmployeeEducation>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeEducationUpdate((List<EmployeeEducation>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeEducation employeeEducation:employeeEducationList){
			if(employeeEducation.isChanged()){
				employeeEducation.incVersion();
			}
			
		
		}
		
		
		return employeeEducationList;
	}

	public SmartList<EmployeeEducation> removeEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList,Map<String,Object> options){
		
		
		super.removeList(employeeEducationList, options);
		
		return employeeEducationList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeEducationBatchCreateArgs(List<EmployeeEducation> employeeEducationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeEducation employeeEducation:employeeEducationList ){
			Object [] parameters = prepareEmployeeEducationCreateParameters(employeeEducation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeEducationBatchUpdateArgs(List<EmployeeEducation> employeeEducationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeEducation employeeEducation:employeeEducationList ){
			if(!employeeEducation.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeEducationUpdateParameters(employeeEducation);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeEducationCreate(List<EmployeeEducation> employeeEducationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeEducationBatchCreateArgs(employeeEducationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeEducationUpdate(List<EmployeeEducation> employeeEducationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeEducationBatchUpdateArgs(employeeEducationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeEducationList(List<EmployeeEducation> employeeEducationList){
		
		List<EmployeeEducation> employeeEducationCreateList=new ArrayList<EmployeeEducation>();
		List<EmployeeEducation> employeeEducationUpdateList=new ArrayList<EmployeeEducation>();
		
		for(EmployeeEducation employeeEducation: employeeEducationList){
			if(isUpdateRequest(employeeEducation)){
				employeeEducationUpdateList.add( employeeEducation);
				continue;
			}
			employeeEducationCreateList.add(employeeEducation);
		}
		
		return new Object[]{employeeEducationCreateList,employeeEducationUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeEducation employeeEducation){
 		return employeeEducation.getVersion() > 0;
 	}
 	protected String getSaveEmployeeEducationSQL(EmployeeEducation employeeEducation){
 		if(isUpdateRequest(employeeEducation)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeEducationParameters(EmployeeEducation employeeEducation){
 		if(isUpdateRequest(employeeEducation) ){
 			return prepareEmployeeEducationUpdateParameters(employeeEducation);
 		}
 		return prepareEmployeeEducationCreateParameters(employeeEducation);
 	}
 	protected Object[] prepareEmployeeEducationUpdateParameters(EmployeeEducation employeeEducation){
 		Object[] parameters = new Object[6];
  	
 		if(employeeEducation.getEmployee() != null){
 			parameters[0] = employeeEducation.getEmployee().getId();
 		}
 
 		parameters[1] = employeeEducation.getCompleteTime();
 		parameters[2] = employeeEducation.getType();
 		parameters[3] = employeeEducation.getRemark();		
 		parameters[4] = employeeEducation.getId();
 		parameters[5] = employeeEducation.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeEducationCreateParameters(EmployeeEducation employeeEducation){
		Object[] parameters = new Object[5];
		String newEmployeeEducationId=getNextId();
		employeeEducation.setId(newEmployeeEducationId);
		parameters[0] =  employeeEducation.getId();
  	
 		if(employeeEducation.getEmployee() != null){
 			parameters[1] = employeeEducation.getEmployee().getId();
 		
 		}
 		
 		parameters[2] = employeeEducation.getCompleteTime();
 		parameters[3] = employeeEducation.getType();
 		parameters[4] = employeeEducation.getRemark();		
 				
 		return parameters;
 	}
 	
	protected EmployeeEducation saveInternalEmployeeEducation(EmployeeEducation employeeEducation, Map<String,Object> options){
		
		saveEmployeeEducation(employeeEducation);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeEducation, options);
 		}
 
		
		return employeeEducation;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeEducation saveEmployee(EmployeeEducation employeeEducation, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeEducation.getEmployee() == null){
 			return employeeEducation;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeEducation.getEmployee(),options);
 		return employeeEducation;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeEducation present(EmployeeEducation employeeEducation,Map<String, Object> options){
	

		return employeeEducation;
	
	}
		


	protected String getTableName(){
		return EmployeeEducationTable.TABLE_NAME;
	}
}


