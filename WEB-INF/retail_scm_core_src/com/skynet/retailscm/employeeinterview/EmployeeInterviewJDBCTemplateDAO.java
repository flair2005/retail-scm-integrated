
package com.skynet.retailscm.employeeinterview;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.interviewtype.InterviewTypeDAO;
import com.skynet.retailscm.employee.EmployeeDAO;

import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.interviewtype.InterviewTypeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeInterviewJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeInterviewDAO{
 
 	
 	private  InterviewTypeDAO  interviewTypeDAO;
 	public void setInterviewTypeDAO(InterviewTypeDAO interviewTypeDAO){
	 	this.interviewTypeDAO = interviewTypeDAO;
 	}
 	public InterviewTypeDAO getInterviewTypeDAO(){
	 	return this.interviewTypeDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeInterview load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeInterview(accessKey, options);
	}
	*/
	public EmployeeInterview load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeInterview(EmployeeInterviewTable.withId(id), options);
	}
	
	
	
	public EmployeeInterview save(EmployeeInterview employeeInterview,Map<String,Object> options){
		
		String methodName="save(EmployeeInterview employeeInterview,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeInterview, methodName, "employeeInterview");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeInterview(employeeInterview,options);
	}
	public EmployeeInterview clone(String employeeInterviewId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeInterviewTable.withId(employeeInterviewId),options);
	}
	
	protected EmployeeInterview clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeInterviewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeInterview newEmployeeInterview = loadInternalEmployeeInterview(accessKey, options);
		newEmployeeInterview.setVersion(0);
		
		

		
		saveInternalEmployeeInterview(newEmployeeInterview,options);
		
		return newEmployeeInterview;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeInterviewId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeInterviewId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeInterviewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeInterviewNotFoundException(
					"The " + this.getTableName() + "(" + employeeInterviewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeInterviewId, int version) throws Exception{
	
		String methodName="delete(String employeeInterviewId, int version)";
		assertMethodArgumentNotNull(employeeInterviewId, methodName, "employeeInterviewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeInterviewId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeInterviewId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","interview_type","remark"};
		return EmployeeInterviewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_interview";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeInterviewTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeInterviewTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeInterviewTokens.EMPLOYEE);
 	}
 	

 	
  
 	//private boolean extractInterviewTypeEnabled = true;
 	//private static final String INTERVIEWTYPE = "interviewType";
 	protected boolean isExtractInterviewTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeInterviewTokens.INTERVIEWTYPE);
 	}
 	
 	
 	//private boolean saveInterviewTypeEnabled = true;
 	protected boolean isSaveInterviewTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeInterviewTokens.INTERVIEWTYPE);
 	}
 	

 	
 
		

	

	protected EmployeeInterviewMapper getEmployeeInterviewMapper(){
		return new EmployeeInterviewMapper();
	}
	protected EmployeeInterview extractEmployeeInterview(String employeeInterviewId) throws Exception{
		String SQL = "select * from employee_interview_data where id = ?";	
		try{
		
			EmployeeInterview employeeInterview = queryForObject(SQL, new Object[]{employeeInterviewId}, getEmployeeInterviewMapper());
			return employeeInterview;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeInterviewNotFoundException("EmployeeInterview("+employeeInterviewId+") is not found!");
		}
		
		
	}
	protected EmployeeInterview extractEmployeeInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_interview_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeInterview employeeInterview = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeInterviewMapper());
			return employeeInterview;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeInterviewNotFoundException("EmployeeInterview("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeInterview loadInternalEmployeeInterview(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeInterview employeeInterview = extractEmployeeInterview(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeInterview, loadOptions);
 		}
  	
 		if(isExtractInterviewTypeEnabled(loadOptions)){
	 		extractInterviewType(employeeInterview, loadOptions);
 		}
 
		
		return employeeInterview;
		
	}



	
	
	 

 	protected EmployeeInterview extractEmployee(EmployeeInterview employeeInterview, Map<String,Object> options) throws Exception{

		if(employeeInterview.getEmployee() == null){
			return employeeInterview;
		}
		String employeeId = employeeInterview.getEmployee().getId();
		if( employeeId == null){
			return employeeInterview;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeInterview.setEmployee(employee);
		}
		
 		
 		return employeeInterview;
 	}
 		
  

 	protected EmployeeInterview extractInterviewType(EmployeeInterview employeeInterview, Map<String,Object> options) throws Exception{

		if(employeeInterview.getInterviewType() == null){
			return employeeInterview;
		}
		String interviewTypeId = employeeInterview.getInterviewType().getId();
		if( interviewTypeId == null){
			return employeeInterview;
		}
		InterviewType interviewType = getInterviewTypeDAO().load(interviewTypeId,options);
		if(interviewType != null){
			employeeInterview.setInterviewType(interviewType);
		}
		
 		
 		return employeeInterview;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeInterview> employeeInterviewList = queryForList(SQL, new Object[]{employeeId}, getEmployeeInterviewMapper());	
 		return employeeInterviewList;
 	}
 	
 	public SmartList<EmployeeInterview> findEmployeeInterviewByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeInterview> employeeInterviewList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeInterviewMapper());
		
 		return employeeInterviewList;
 	}
 	
 	public int countEmployeeInterviewByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where interview_type = ?";
		SmartList<EmployeeInterview> employeeInterviewList = queryForList(SQL, new Object[]{interviewTypeId}, getEmployeeInterviewMapper());	
 		return employeeInterviewList;
 	}
 	
 	public SmartList<EmployeeInterview> findEmployeeInterviewByInterviewType(String interviewTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where interview_type = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeInterview> employeeInterviewList = queryForList(SQL, new Object[]{interviewTypeId,start, count}, getEmployeeInterviewMapper());
		
 		return employeeInterviewList;
 	}
 	
 	public int countEmployeeInterviewByInterviewType(String interviewTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where interview_type = ?";
		Integer count = queryInt(SQL, new Object[]{interviewTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeInterview saveEmployeeInterview(EmployeeInterview  employeeInterview){
	
		String SQL=this.getSaveEmployeeInterviewSQL(employeeInterview);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeInterviewParameters(employeeInterview);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeInterview.incVersion();
		return employeeInterview;
	
	}
	public SmartList<EmployeeInterview> saveEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeInterviewList(employeeInterviewList);
		
		batchEmployeeInterviewCreate((List<EmployeeInterview>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeInterviewUpdate((List<EmployeeInterview>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeInterview employeeInterview:employeeInterviewList){
			if(employeeInterview.isChanged()){
				employeeInterview.incVersion();
			}
			
		
		}
		
		
		return employeeInterviewList;
	}

	public SmartList<EmployeeInterview> removeEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList,Map<String,Object> options){
		
		
		super.removeList(employeeInterviewList, options);
		
		return employeeInterviewList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeInterviewBatchCreateArgs(List<EmployeeInterview> employeeInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeInterview employeeInterview:employeeInterviewList ){
			Object [] parameters = prepareEmployeeInterviewCreateParameters(employeeInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeInterviewBatchUpdateArgs(List<EmployeeInterview> employeeInterviewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeInterview employeeInterview:employeeInterviewList ){
			if(!employeeInterview.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeInterviewUpdateParameters(employeeInterview);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeInterviewCreate(List<EmployeeInterview> employeeInterviewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeInterviewBatchCreateArgs(employeeInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeInterviewUpdate(List<EmployeeInterview> employeeInterviewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeInterviewBatchUpdateArgs(employeeInterviewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeInterviewList(List<EmployeeInterview> employeeInterviewList){
		
		List<EmployeeInterview> employeeInterviewCreateList=new ArrayList<EmployeeInterview>();
		List<EmployeeInterview> employeeInterviewUpdateList=new ArrayList<EmployeeInterview>();
		
		for(EmployeeInterview employeeInterview: employeeInterviewList){
			if(isUpdateRequest(employeeInterview)){
				employeeInterviewUpdateList.add( employeeInterview);
				continue;
			}
			employeeInterviewCreateList.add(employeeInterview);
		}
		
		return new Object[]{employeeInterviewCreateList,employeeInterviewUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeInterview employeeInterview){
 		return employeeInterview.getVersion() > 0;
 	}
 	protected String getSaveEmployeeInterviewSQL(EmployeeInterview employeeInterview){
 		if(isUpdateRequest(employeeInterview)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeInterviewParameters(EmployeeInterview employeeInterview){
 		if(isUpdateRequest(employeeInterview) ){
 			return prepareEmployeeInterviewUpdateParameters(employeeInterview);
 		}
 		return prepareEmployeeInterviewCreateParameters(employeeInterview);
 	}
 	protected Object[] prepareEmployeeInterviewUpdateParameters(EmployeeInterview employeeInterview){
 		Object[] parameters = new Object[5];
  	
 		if(employeeInterview.getEmployee() != null){
 			parameters[0] = employeeInterview.getEmployee().getId();
 		}
  	
 		if(employeeInterview.getInterviewType() != null){
 			parameters[1] = employeeInterview.getInterviewType().getId();
 		}
 
 		parameters[2] = employeeInterview.getRemark();		
 		parameters[3] = employeeInterview.getId();
 		parameters[4] = employeeInterview.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeInterviewCreateParameters(EmployeeInterview employeeInterview){
		Object[] parameters = new Object[4];
		String newEmployeeInterviewId=getNextId();
		employeeInterview.setId(newEmployeeInterviewId);
		parameters[0] =  employeeInterview.getId();
  	
 		if(employeeInterview.getEmployee() != null){
 			parameters[1] = employeeInterview.getEmployee().getId();
 		
 		}
 		 	
 		if(employeeInterview.getInterviewType() != null){
 			parameters[2] = employeeInterview.getInterviewType().getId();
 		
 		}
 		
 		parameters[3] = employeeInterview.getRemark();		
 				
 		return parameters;
 	}
 	
	protected EmployeeInterview saveInternalEmployeeInterview(EmployeeInterview employeeInterview, Map<String,Object> options){
		
		saveEmployeeInterview(employeeInterview);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeInterview, options);
 		}
  	
 		if(isSaveInterviewTypeEnabled(options)){
	 		saveInterviewType(employeeInterview, options);
 		}
 
		
		return employeeInterview;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeInterview saveEmployee(EmployeeInterview employeeInterview, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeInterview.getEmployee() == null){
 			return employeeInterview;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeInterview.getEmployee(),options);
 		return employeeInterview;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeInterview saveInterviewType(EmployeeInterview employeeInterview, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeInterview.getInterviewType() == null){
 			return employeeInterview;//do nothing when it is null
 		}
 		
 		getInterviewTypeDAO().save(employeeInterview.getInterviewType(),options);
 		return employeeInterview;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeInterview present(EmployeeInterview employeeInterview,Map<String, Object> options){
	

		return employeeInterview;
	
	}
		


	protected String getTableName(){
		return EmployeeInterviewTable.TABLE_NAME;
	}
}


