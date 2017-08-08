
package com.skynet.retailscm.employeeskill;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.skilltype.SkillTypeDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.skilltype.SkillTypeTable;
import com.skynet.retailscm.employee.EmployeeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeSkillJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeSkillDAO{
 
 	
 	private  SkillTypeDAO  skillTypeDAO;
 	public void setSkillTypeDAO(SkillTypeDAO skillTypeDAO){
	 	this.skillTypeDAO = skillTypeDAO;
 	}
 	public SkillTypeDAO getSkillTypeDAO(){
	 	return this.skillTypeDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeSkill load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSkill(accessKey, options);
	}
	*/
	public EmployeeSkill load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeSkill(EmployeeSkillTable.withId(id), options);
	}
	
	
	
	public EmployeeSkill save(EmployeeSkill employeeSkill,Map<String,Object> options){
		
		String methodName="save(EmployeeSkill employeeSkill,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeSkill, methodName, "employeeSkill");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeSkill(employeeSkill,options);
	}
	public EmployeeSkill clone(String employeeSkillId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeSkillTable.withId(employeeSkillId),options);
	}
	
	protected EmployeeSkill clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeSkillId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeSkill newEmployeeSkill = loadInternalEmployeeSkill(accessKey, options);
		newEmployeeSkill.setVersion(0);
		
		

		
		saveInternalEmployeeSkill(newEmployeeSkill,options);
		
		return newEmployeeSkill;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeSkillId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeSkillId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeSkillVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeSkillNotFoundException(
					"The " + this.getTableName() + "(" + employeeSkillId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeSkillId, int version) throws Exception{
	
		String methodName="delete(String employeeSkillId, int version)";
		assertMethodArgumentNotNull(employeeSkillId, methodName, "employeeSkillId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeSkillId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeSkillId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","skill_type","description"};
		return EmployeeSkillTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_skill";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeSkillTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSkillTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSkillTokens.EMPLOYEE);
 	}
 	

 	
  
 	//private boolean extractSkillTypeEnabled = true;
 	//private static final String SKILLTYPE = "skillType";
 	protected boolean isExtractSkillTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeSkillTokens.SKILLTYPE);
 	}
 	
 	
 	//private boolean saveSkillTypeEnabled = true;
 	protected boolean isSaveSkillTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeSkillTokens.SKILLTYPE);
 	}
 	

 	
 
		

	

	protected EmployeeSkillMapper getEmployeeSkillMapper(){
		return new EmployeeSkillMapper();
	}
	protected EmployeeSkill extractEmployeeSkill(String employeeSkillId) throws Exception{
		String SQL = "select * from employee_skill_data where id = ?";	
		try{
		
			EmployeeSkill employeeSkill = queryForObject(SQL, new Object[]{employeeSkillId}, getEmployeeSkillMapper());
			return employeeSkill;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeSkillNotFoundException("EmployeeSkill("+employeeSkillId+") is not found!");
		}
		
		
	}
	protected EmployeeSkill extractEmployeeSkill(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_skill_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeSkill employeeSkill = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeSkillMapper());
			return employeeSkill;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeSkillNotFoundException("EmployeeSkill("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeSkill loadInternalEmployeeSkill(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeSkill employeeSkill = extractEmployeeSkill(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeSkill, loadOptions);
 		}
  	
 		if(isExtractSkillTypeEnabled(loadOptions)){
	 		extractSkillType(employeeSkill, loadOptions);
 		}
 
		
		return employeeSkill;
		
	}



	
	
	 

 	protected EmployeeSkill extractEmployee(EmployeeSkill employeeSkill, Map<String,Object> options) throws Exception{

		if(employeeSkill.getEmployee() == null){
			return employeeSkill;
		}
		String employeeId = employeeSkill.getEmployee().getId();
		if( employeeId == null){
			return employeeSkill;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeSkill.setEmployee(employee);
		}
		
 		
 		return employeeSkill;
 	}
 		
  

 	protected EmployeeSkill extractSkillType(EmployeeSkill employeeSkill, Map<String,Object> options) throws Exception{

		if(employeeSkill.getSkillType() == null){
			return employeeSkill;
		}
		String skillTypeId = employeeSkill.getSkillType().getId();
		if( skillTypeId == null){
			return employeeSkill;
		}
		SkillType skillType = getSkillTypeDAO().load(skillTypeId,options);
		if(skillType != null){
			employeeSkill.setSkillType(skillType);
		}
		
 		
 		return employeeSkill;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeSkill> employeeSkillList = queryForList(SQL, new Object[]{employeeId}, getEmployeeSkillMapper());	
 		return employeeSkillList;
 	}
 	
 	public SmartList<EmployeeSkill> findEmployeeSkillByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeSkill> employeeSkillList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeSkillMapper());
		
 		return employeeSkillList;
 	}
 	
 	public int countEmployeeSkillByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where skill_type = ?";
		SmartList<EmployeeSkill> employeeSkillList = queryForList(SQL, new Object[]{skillTypeId}, getEmployeeSkillMapper());	
 		return employeeSkillList;
 	}
 	
 	public SmartList<EmployeeSkill> findEmployeeSkillBySkillType(String skillTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where skill_type = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeSkill> employeeSkillList = queryForList(SQL, new Object[]{skillTypeId,start, count}, getEmployeeSkillMapper());
		
 		return employeeSkillList;
 	}
 	
 	public int countEmployeeSkillBySkillType(String skillTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where skill_type = ?";
		Integer count = queryInt(SQL, new Object[]{skillTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeSkill saveEmployeeSkill(EmployeeSkill  employeeSkill){
	
		String SQL=this.getSaveEmployeeSkillSQL(employeeSkill);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeSkillParameters(employeeSkill);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeSkill.incVersion();
		return employeeSkill;
	
	}
	public SmartList<EmployeeSkill> saveEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeSkillList(employeeSkillList);
		
		batchEmployeeSkillCreate((List<EmployeeSkill>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeSkillUpdate((List<EmployeeSkill>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeSkill employeeSkill:employeeSkillList){
			if(employeeSkill.isChanged()){
				employeeSkill.incVersion();
			}
			
		
		}
		
		
		return employeeSkillList;
	}

	public SmartList<EmployeeSkill> removeEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList,Map<String,Object> options){
		
		
		super.removeList(employeeSkillList, options);
		
		return employeeSkillList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeSkillBatchCreateArgs(List<EmployeeSkill> employeeSkillList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSkill employeeSkill:employeeSkillList ){
			Object [] parameters = prepareEmployeeSkillCreateParameters(employeeSkill);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeSkillBatchUpdateArgs(List<EmployeeSkill> employeeSkillList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeSkill employeeSkill:employeeSkillList ){
			if(!employeeSkill.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeSkillUpdateParameters(employeeSkill);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeSkillCreate(List<EmployeeSkill> employeeSkillList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeSkillBatchCreateArgs(employeeSkillList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeSkillUpdate(List<EmployeeSkill> employeeSkillList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeSkillBatchUpdateArgs(employeeSkillList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeSkillList(List<EmployeeSkill> employeeSkillList){
		
		List<EmployeeSkill> employeeSkillCreateList=new ArrayList<EmployeeSkill>();
		List<EmployeeSkill> employeeSkillUpdateList=new ArrayList<EmployeeSkill>();
		
		for(EmployeeSkill employeeSkill: employeeSkillList){
			if(isUpdateRequest(employeeSkill)){
				employeeSkillUpdateList.add( employeeSkill);
				continue;
			}
			employeeSkillCreateList.add(employeeSkill);
		}
		
		return new Object[]{employeeSkillCreateList,employeeSkillUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeSkill employeeSkill){
 		return employeeSkill.getVersion() > 0;
 	}
 	protected String getSaveEmployeeSkillSQL(EmployeeSkill employeeSkill){
 		if(isUpdateRequest(employeeSkill)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeSkillParameters(EmployeeSkill employeeSkill){
 		if(isUpdateRequest(employeeSkill) ){
 			return prepareEmployeeSkillUpdateParameters(employeeSkill);
 		}
 		return prepareEmployeeSkillCreateParameters(employeeSkill);
 	}
 	protected Object[] prepareEmployeeSkillUpdateParameters(EmployeeSkill employeeSkill){
 		Object[] parameters = new Object[5];
  	
 		if(employeeSkill.getEmployee() != null){
 			parameters[0] = employeeSkill.getEmployee().getId();
 		}
  	
 		if(employeeSkill.getSkillType() != null){
 			parameters[1] = employeeSkill.getSkillType().getId();
 		}
 
 		parameters[2] = employeeSkill.getDescription();		
 		parameters[3] = employeeSkill.getId();
 		parameters[4] = employeeSkill.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeSkillCreateParameters(EmployeeSkill employeeSkill){
		Object[] parameters = new Object[4];
		String newEmployeeSkillId=getNextId();
		employeeSkill.setId(newEmployeeSkillId);
		parameters[0] =  employeeSkill.getId();
  	
 		if(employeeSkill.getEmployee() != null){
 			parameters[1] = employeeSkill.getEmployee().getId();
 		
 		}
 		 	
 		if(employeeSkill.getSkillType() != null){
 			parameters[2] = employeeSkill.getSkillType().getId();
 		
 		}
 		
 		parameters[3] = employeeSkill.getDescription();		
 				
 		return parameters;
 	}
 	
	protected EmployeeSkill saveInternalEmployeeSkill(EmployeeSkill employeeSkill, Map<String,Object> options){
		
		saveEmployeeSkill(employeeSkill);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeSkill, options);
 		}
  	
 		if(isSaveSkillTypeEnabled(options)){
	 		saveSkillType(employeeSkill, options);
 		}
 
		
		return employeeSkill;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeSkill saveEmployee(EmployeeSkill employeeSkill, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSkill.getEmployee() == null){
 			return employeeSkill;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeSkill.getEmployee(),options);
 		return employeeSkill;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeSkill saveSkillType(EmployeeSkill employeeSkill, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeSkill.getSkillType() == null){
 			return employeeSkill;//do nothing when it is null
 		}
 		
 		getSkillTypeDAO().save(employeeSkill.getSkillType(),options);
 		return employeeSkill;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeSkill present(EmployeeSkill employeeSkill,Map<String, Object> options){
	

		return employeeSkill;
	
	}
		


	protected String getTableName(){
		return EmployeeSkillTable.TABLE_NAME;
	}
}


