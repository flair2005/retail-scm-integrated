
package com.skynet.retailscm.employeeworkexperience;

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

public class EmployeeWorkExperienceJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeWorkExperienceDAO{
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeWorkExperience load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeWorkExperience(accessKey, options);
	}
	*/
	public EmployeeWorkExperience load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeWorkExperience(EmployeeWorkExperienceTable.withId(id), options);
	}
	
	
	
	public EmployeeWorkExperience save(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options){
		
		String methodName="save(EmployeeWorkExperience employeeWorkExperience,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeWorkExperience, methodName, "employeeWorkExperience");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeWorkExperience(employeeWorkExperience,options);
	}
	public EmployeeWorkExperience clone(String employeeWorkExperienceId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeWorkExperienceTable.withId(employeeWorkExperienceId),options);
	}
	
	protected EmployeeWorkExperience clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeWorkExperienceId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeWorkExperience newEmployeeWorkExperience = loadInternalEmployeeWorkExperience(accessKey, options);
		newEmployeeWorkExperience.setVersion(0);
		
		

		
		saveInternalEmployeeWorkExperience(newEmployeeWorkExperience,options);
		
		return newEmployeeWorkExperience;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeWorkExperienceId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeWorkExperienceId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeWorkExperienceVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeWorkExperienceNotFoundException(
					"The " + this.getTableName() + "(" + employeeWorkExperienceId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeWorkExperienceId, int version) throws Exception{
	
		String methodName="delete(String employeeWorkExperienceId, int version)";
		assertMethodArgumentNotNull(employeeWorkExperienceId, methodName, "employeeWorkExperienceId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeWorkExperienceId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeWorkExperienceId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","start","end","company","description"};
		return EmployeeWorkExperienceTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_work_experience";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeWorkExperienceTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeWorkExperienceTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeWorkExperienceTokens.EMPLOYEE);
 	}
 	

 	
 
		

	

	protected EmployeeWorkExperienceMapper getEmployeeWorkExperienceMapper(){
		return new EmployeeWorkExperienceMapper();
	}
	protected EmployeeWorkExperience extractEmployeeWorkExperience(String employeeWorkExperienceId) throws Exception{
		String SQL = "select * from employee_work_experience_data where id = ?";	
		try{
		
			EmployeeWorkExperience employeeWorkExperience = queryForObject(SQL, new Object[]{employeeWorkExperienceId}, getEmployeeWorkExperienceMapper());
			return employeeWorkExperience;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeWorkExperienceNotFoundException("EmployeeWorkExperience("+employeeWorkExperienceId+") is not found!");
		}
		
		
	}
	protected EmployeeWorkExperience extractEmployeeWorkExperience(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_work_experience_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeWorkExperience employeeWorkExperience = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeWorkExperienceMapper());
			return employeeWorkExperience;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeWorkExperienceNotFoundException("EmployeeWorkExperience("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeWorkExperience loadInternalEmployeeWorkExperience(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeWorkExperience employeeWorkExperience = extractEmployeeWorkExperience(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeWorkExperience, loadOptions);
 		}
 
		
		return employeeWorkExperience;
		
	}



	
	
	 

 	protected EmployeeWorkExperience extractEmployee(EmployeeWorkExperience employeeWorkExperience, Map<String,Object> options) throws Exception{

		if(employeeWorkExperience.getEmployee() == null){
			return employeeWorkExperience;
		}
		String employeeId = employeeWorkExperience.getEmployee().getId();
		if( employeeId == null){
			return employeeWorkExperience;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeWorkExperience.setEmployee(employee);
		}
		
 		
 		return employeeWorkExperience;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeWorkExperience> employeeWorkExperienceList = queryForList(SQL, new Object[]{employeeId}, getEmployeeWorkExperienceMapper());	
 		return employeeWorkExperienceList;
 	}
 	
 	public SmartList<EmployeeWorkExperience> findEmployeeWorkExperienceByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeWorkExperience> employeeWorkExperienceList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeWorkExperienceMapper());
		
 		return employeeWorkExperienceList;
 	}
 	
 	public int countEmployeeWorkExperienceByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeWorkExperience saveEmployeeWorkExperience(EmployeeWorkExperience  employeeWorkExperience){
	
		String SQL=this.getSaveEmployeeWorkExperienceSQL(employeeWorkExperience);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeWorkExperienceParameters(employeeWorkExperience);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeWorkExperience.incVersion();
		return employeeWorkExperience;
	
	}
	public SmartList<EmployeeWorkExperience> saveEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeWorkExperienceList(employeeWorkExperienceList);
		
		batchEmployeeWorkExperienceCreate((List<EmployeeWorkExperience>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeWorkExperienceUpdate((List<EmployeeWorkExperience>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			if(employeeWorkExperience.isChanged()){
				employeeWorkExperience.incVersion();
			}
			
		
		}
		
		
		return employeeWorkExperienceList;
	}

	public SmartList<EmployeeWorkExperience> removeEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList,Map<String,Object> options){
		
		
		super.removeList(employeeWorkExperienceList, options);
		
		return employeeWorkExperienceList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeWorkExperienceBatchCreateArgs(List<EmployeeWorkExperience> employeeWorkExperienceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList ){
			Object [] parameters = prepareEmployeeWorkExperienceCreateParameters(employeeWorkExperience);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeWorkExperienceBatchUpdateArgs(List<EmployeeWorkExperience> employeeWorkExperienceList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList ){
			if(!employeeWorkExperience.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeWorkExperienceUpdateParameters(employeeWorkExperience);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeWorkExperienceCreate(List<EmployeeWorkExperience> employeeWorkExperienceList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeWorkExperienceBatchCreateArgs(employeeWorkExperienceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeWorkExperienceUpdate(List<EmployeeWorkExperience> employeeWorkExperienceList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeWorkExperienceBatchUpdateArgs(employeeWorkExperienceList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeWorkExperienceList(List<EmployeeWorkExperience> employeeWorkExperienceList){
		
		List<EmployeeWorkExperience> employeeWorkExperienceCreateList=new ArrayList<EmployeeWorkExperience>();
		List<EmployeeWorkExperience> employeeWorkExperienceUpdateList=new ArrayList<EmployeeWorkExperience>();
		
		for(EmployeeWorkExperience employeeWorkExperience: employeeWorkExperienceList){
			if(isUpdateRequest(employeeWorkExperience)){
				employeeWorkExperienceUpdateList.add( employeeWorkExperience);
				continue;
			}
			employeeWorkExperienceCreateList.add(employeeWorkExperience);
		}
		
		return new Object[]{employeeWorkExperienceCreateList,employeeWorkExperienceUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeWorkExperience employeeWorkExperience){
 		return employeeWorkExperience.getVersion() > 0;
 	}
 	protected String getSaveEmployeeWorkExperienceSQL(EmployeeWorkExperience employeeWorkExperience){
 		if(isUpdateRequest(employeeWorkExperience)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeWorkExperienceParameters(EmployeeWorkExperience employeeWorkExperience){
 		if(isUpdateRequest(employeeWorkExperience) ){
 			return prepareEmployeeWorkExperienceUpdateParameters(employeeWorkExperience);
 		}
 		return prepareEmployeeWorkExperienceCreateParameters(employeeWorkExperience);
 	}
 	protected Object[] prepareEmployeeWorkExperienceUpdateParameters(EmployeeWorkExperience employeeWorkExperience){
 		Object[] parameters = new Object[7];
  	
 		if(employeeWorkExperience.getEmployee() != null){
 			parameters[0] = employeeWorkExperience.getEmployee().getId();
 		}
 
 		parameters[1] = employeeWorkExperience.getStart();
 		parameters[2] = employeeWorkExperience.getEnd();
 		parameters[3] = employeeWorkExperience.getCompany();
 		parameters[4] = employeeWorkExperience.getDescription();		
 		parameters[5] = employeeWorkExperience.getId();
 		parameters[6] = employeeWorkExperience.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeWorkExperienceCreateParameters(EmployeeWorkExperience employeeWorkExperience){
		Object[] parameters = new Object[6];
		String newEmployeeWorkExperienceId=getNextId();
		employeeWorkExperience.setId(newEmployeeWorkExperienceId);
		parameters[0] =  employeeWorkExperience.getId();
  	
 		if(employeeWorkExperience.getEmployee() != null){
 			parameters[1] = employeeWorkExperience.getEmployee().getId();
 		
 		}
 		
 		parameters[2] = employeeWorkExperience.getStart();
 		parameters[3] = employeeWorkExperience.getEnd();
 		parameters[4] = employeeWorkExperience.getCompany();
 		parameters[5] = employeeWorkExperience.getDescription();		
 				
 		return parameters;
 	}
 	
	protected EmployeeWorkExperience saveInternalEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience, Map<String,Object> options){
		
		saveEmployeeWorkExperience(employeeWorkExperience);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeWorkExperience, options);
 		}
 
		
		return employeeWorkExperience;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeWorkExperience saveEmployee(EmployeeWorkExperience employeeWorkExperience, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeWorkExperience.getEmployee() == null){
 			return employeeWorkExperience;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeWorkExperience.getEmployee(),options);
 		return employeeWorkExperience;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeWorkExperience present(EmployeeWorkExperience employeeWorkExperience,Map<String, Object> options){
	

		return employeeWorkExperience;
	
	}
		


	protected String getTableName(){
		return EmployeeWorkExperienceTable.TABLE_NAME;
	}
}


