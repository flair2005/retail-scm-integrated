
package com.skynet.retailscm.employeecompanytraining;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.employee.Employee;

import com.skynet.retailscm.employee.EmployeeDAO;
import com.skynet.retailscm.companytraining.CompanyTrainingDAO;
import com.skynet.retailscm.scoring.ScoringDAO;

import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.companytraining.CompanyTrainingTable;
import com.skynet.retailscm.scoring.ScoringTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeCompanyTrainingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements EmployeeCompanyTrainingDAO{
 
 	
 	private  CompanyTrainingDAO  companyTrainingDAO;
 	public void setCompanyTrainingDAO(CompanyTrainingDAO companyTrainingDAO){
	 	this.companyTrainingDAO = companyTrainingDAO;
 	}
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
	 	return this.companyTrainingDAO;
 	}
 
 	
 	private  ScoringDAO  scoringDAO;
 	public void setScoringDAO(ScoringDAO scoringDAO){
	 	this.scoringDAO = scoringDAO;
 	}
 	public ScoringDAO getScoringDAO(){
	 	return this.scoringDAO;
 	}
 
 	
 	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO employeeDAO){
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
	 	return this.employeeDAO;
 	}

		

	
	/*
	protected EmployeeCompanyTraining load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeCompanyTraining(accessKey, options);
	}
	*/
	public EmployeeCompanyTraining load(String id,Map<String,Object> options) throws Exception{
		return loadInternalEmployeeCompanyTraining(EmployeeCompanyTrainingTable.withId(id), options);
	}
	
	
	
	public EmployeeCompanyTraining save(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options){
		
		String methodName="save(EmployeeCompanyTraining employeeCompanyTraining,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(employeeCompanyTraining, methodName, "employeeCompanyTraining");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalEmployeeCompanyTraining(employeeCompanyTraining,options);
	}
	public EmployeeCompanyTraining clone(String employeeCompanyTrainingId, Map<String,Object> options) throws Exception{
	
		return clone(EmployeeCompanyTrainingTable.withId(employeeCompanyTrainingId),options);
	}
	
	protected EmployeeCompanyTraining clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String employeeCompanyTrainingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		EmployeeCompanyTraining newEmployeeCompanyTraining = loadInternalEmployeeCompanyTraining(accessKey, options);
		newEmployeeCompanyTraining.setVersion(0);
		
		

		
		saveInternalEmployeeCompanyTraining(newEmployeeCompanyTraining,options);
		
		return newEmployeeCompanyTraining;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String employeeCompanyTrainingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{employeeCompanyTrainingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new EmployeeCompanyTrainingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new EmployeeCompanyTrainingNotFoundException(
					"The " + this.getTableName() + "(" + employeeCompanyTrainingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String employeeCompanyTrainingId, int version) throws Exception{
	
		String methodName="delete(String employeeCompanyTrainingId, int version)";
		assertMethodArgumentNotNull(employeeCompanyTrainingId, methodName, "employeeCompanyTrainingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{employeeCompanyTrainingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(employeeCompanyTrainingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"employee","training","scoring","current_status"};
		return EmployeeCompanyTrainingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "employee_company_training";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return EmployeeCompanyTrainingTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractEmployeeEnabled = true;
 	//private static final String EMPLOYEE = "employee";
 	protected boolean isExtractEmployeeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeCompanyTrainingTokens.EMPLOYEE);
 	}
 	
 	
 	//private boolean saveEmployeeEnabled = true;
 	protected boolean isSaveEmployeeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeCompanyTrainingTokens.EMPLOYEE);
 	}
 	

 	
  
 	//private boolean extractTrainingEnabled = true;
 	//private static final String TRAINING = "training";
 	protected boolean isExtractTrainingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeCompanyTrainingTokens.TRAINING);
 	}
 	
 	
 	//private boolean saveTrainingEnabled = true;
 	protected boolean isSaveTrainingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeCompanyTrainingTokens.TRAINING);
 	}
 	

 	
  
 	//private boolean extractScoringEnabled = true;
 	//private static final String SCORING = "scoring";
 	protected boolean isExtractScoringEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, EmployeeCompanyTrainingTokens.SCORING);
 	}
 	
 	
 	//private boolean saveScoringEnabled = true;
 	protected boolean isSaveScoringEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, EmployeeCompanyTrainingTokens.SCORING);
 	}
 	

 	
 
		

	

	protected EmployeeCompanyTrainingMapper getEmployeeCompanyTrainingMapper(){
		return new EmployeeCompanyTrainingMapper();
	}
	protected EmployeeCompanyTraining extractEmployeeCompanyTraining(String employeeCompanyTrainingId) throws Exception{
		String SQL = "select * from employee_company_training_data where id = ?";	
		try{
		
			EmployeeCompanyTraining employeeCompanyTraining = queryForObject(SQL, new Object[]{employeeCompanyTrainingId}, getEmployeeCompanyTrainingMapper());
			return employeeCompanyTraining;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeCompanyTrainingNotFoundException("EmployeeCompanyTraining("+employeeCompanyTrainingId+") is not found!");
		}
		
		
	}
	protected EmployeeCompanyTraining extractEmployeeCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from employee_company_training_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			EmployeeCompanyTraining employeeCompanyTraining = queryForObject(SQL, new Object[]{accessKey.getValue()}, getEmployeeCompanyTrainingMapper());
			return employeeCompanyTraining;
		}catch(EmptyResultDataAccessException e){
			throw new EmployeeCompanyTrainingNotFoundException("EmployeeCompanyTraining("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected EmployeeCompanyTraining loadInternalEmployeeCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		EmployeeCompanyTraining employeeCompanyTraining = extractEmployeeCompanyTraining(accessKey, loadOptions);
 	
 		if(isExtractEmployeeEnabled(loadOptions)){
	 		extractEmployee(employeeCompanyTraining, loadOptions);
 		}
  	
 		if(isExtractTrainingEnabled(loadOptions)){
	 		extractTraining(employeeCompanyTraining, loadOptions);
 		}
  	
 		if(isExtractScoringEnabled(loadOptions)){
	 		extractScoring(employeeCompanyTraining, loadOptions);
 		}
 
		
		return employeeCompanyTraining;
		
	}



	
	
	 

 	protected EmployeeCompanyTraining extractEmployee(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception{

		if(employeeCompanyTraining.getEmployee() == null){
			return employeeCompanyTraining;
		}
		String employeeId = employeeCompanyTraining.getEmployee().getId();
		if( employeeId == null){
			return employeeCompanyTraining;
		}
		Employee employee = getEmployeeDAO().load(employeeId,options);
		if(employee != null){
			employeeCompanyTraining.setEmployee(employee);
		}
		
 		
 		return employeeCompanyTraining;
 	}
 		
  

 	protected EmployeeCompanyTraining extractTraining(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception{

		if(employeeCompanyTraining.getTraining() == null){
			return employeeCompanyTraining;
		}
		String trainingId = employeeCompanyTraining.getTraining().getId();
		if( trainingId == null){
			return employeeCompanyTraining;
		}
		CompanyTraining training = getCompanyTrainingDAO().load(trainingId,options);
		if(training != null){
			employeeCompanyTraining.setTraining(training);
		}
		
 		
 		return employeeCompanyTraining;
 	}
 		
  

 	protected EmployeeCompanyTraining extractScoring(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options) throws Exception{

		if(employeeCompanyTraining.getScoring() == null){
			return employeeCompanyTraining;
		}
		String scoringId = employeeCompanyTraining.getScoring().getId();
		if( scoringId == null){
			return employeeCompanyTraining;
		}
		Scoring scoring = getScoringDAO().load(scoringId,options);
		if(scoring != null){
			employeeCompanyTraining.setScoring(scoring);
		}
		
 		
 		return employeeCompanyTraining;
 	}
 		
 
		
		
  	
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ?";
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = queryForList(SQL, new Object[]{employeeId}, getEmployeeCompanyTrainingMapper());	
 		return employeeCompanyTrainingList;
 	}
 	
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByEmployee(String employeeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where employee = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = queryForList(SQL, new Object[]{employeeId,start, count}, getEmployeeCompanyTrainingMapper());
		
 		return employeeCompanyTrainingList;
 	}
 	
 	public int countEmployeeCompanyTrainingByEmployee(String employeeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where employee = ?";
		Integer count = queryInt(SQL, new Object[]{employeeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where training = ?";
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = queryForList(SQL, new Object[]{companyTrainingId}, getEmployeeCompanyTrainingMapper());	
 		return employeeCompanyTrainingList;
 	}
 	
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByTraining(String companyTrainingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where training = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = queryForList(SQL, new Object[]{companyTrainingId,start, count}, getEmployeeCompanyTrainingMapper());
		
 		return employeeCompanyTrainingList;
 	}
 	
 	public int countEmployeeCompanyTrainingByTraining(String companyTrainingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where training = ?";
		Integer count = queryInt(SQL, new Object[]{companyTrainingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where scoring = ?";
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = queryForList(SQL, new Object[]{scoringId}, getEmployeeCompanyTrainingMapper());	
 		return employeeCompanyTrainingList;
 	}
 	
 	public SmartList<EmployeeCompanyTraining> findEmployeeCompanyTrainingByScoring(String scoringId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where scoring = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = queryForList(SQL, new Object[]{scoringId,start, count}, getEmployeeCompanyTrainingMapper());
		
 		return employeeCompanyTrainingList;
 	}
 	
 	public int countEmployeeCompanyTrainingByScoring(String scoringId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where scoring = ?";
		Integer count = queryInt(SQL, new Object[]{scoringId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected EmployeeCompanyTraining saveEmployeeCompanyTraining(EmployeeCompanyTraining  employeeCompanyTraining){
	
		String SQL=this.getSaveEmployeeCompanyTrainingSQL(employeeCompanyTraining);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveEmployeeCompanyTrainingParameters(employeeCompanyTraining);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		employeeCompanyTraining.incVersion();
		return employeeCompanyTraining;
	
	}
	public SmartList<EmployeeCompanyTraining> saveEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitEmployeeCompanyTrainingList(employeeCompanyTrainingList);
		
		batchEmployeeCompanyTrainingCreate((List<EmployeeCompanyTraining>)lists[CREATE_LIST_INDEX]);
		
		batchEmployeeCompanyTrainingUpdate((List<EmployeeCompanyTraining>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			if(employeeCompanyTraining.isChanged()){
				employeeCompanyTraining.incVersion();
			}
			
		
		}
		
		
		return employeeCompanyTrainingList;
	}

	public SmartList<EmployeeCompanyTraining> removeEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList,Map<String,Object> options){
		
		
		super.removeList(employeeCompanyTrainingList, options);
		
		return employeeCompanyTrainingList;
		
		
	}
	
	protected List<Object[]> prepareEmployeeCompanyTrainingBatchCreateArgs(List<EmployeeCompanyTraining> employeeCompanyTrainingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList ){
			Object [] parameters = prepareEmployeeCompanyTrainingCreateParameters(employeeCompanyTraining);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareEmployeeCompanyTrainingBatchUpdateArgs(List<EmployeeCompanyTraining> employeeCompanyTrainingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList ){
			if(!employeeCompanyTraining.isChanged()){
				continue;
			}
			Object [] parameters = prepareEmployeeCompanyTrainingUpdateParameters(employeeCompanyTraining);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchEmployeeCompanyTrainingCreate(List<EmployeeCompanyTraining> employeeCompanyTrainingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareEmployeeCompanyTrainingBatchCreateArgs(employeeCompanyTrainingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchEmployeeCompanyTrainingUpdate(List<EmployeeCompanyTraining> employeeCompanyTrainingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareEmployeeCompanyTrainingBatchUpdateArgs(employeeCompanyTrainingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitEmployeeCompanyTrainingList(List<EmployeeCompanyTraining> employeeCompanyTrainingList){
		
		List<EmployeeCompanyTraining> employeeCompanyTrainingCreateList=new ArrayList<EmployeeCompanyTraining>();
		List<EmployeeCompanyTraining> employeeCompanyTrainingUpdateList=new ArrayList<EmployeeCompanyTraining>();
		
		for(EmployeeCompanyTraining employeeCompanyTraining: employeeCompanyTrainingList){
			if(isUpdateRequest(employeeCompanyTraining)){
				employeeCompanyTrainingUpdateList.add( employeeCompanyTraining);
				continue;
			}
			employeeCompanyTrainingCreateList.add(employeeCompanyTraining);
		}
		
		return new Object[]{employeeCompanyTrainingCreateList,employeeCompanyTrainingUpdateList};
	}
	
	protected boolean isUpdateRequest(EmployeeCompanyTraining employeeCompanyTraining){
 		return employeeCompanyTraining.getVersion() > 0;
 	}
 	protected String getSaveEmployeeCompanyTrainingSQL(EmployeeCompanyTraining employeeCompanyTraining){
 		if(isUpdateRequest(employeeCompanyTraining)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveEmployeeCompanyTrainingParameters(EmployeeCompanyTraining employeeCompanyTraining){
 		if(isUpdateRequest(employeeCompanyTraining) ){
 			return prepareEmployeeCompanyTrainingUpdateParameters(employeeCompanyTraining);
 		}
 		return prepareEmployeeCompanyTrainingCreateParameters(employeeCompanyTraining);
 	}
 	protected Object[] prepareEmployeeCompanyTrainingUpdateParameters(EmployeeCompanyTraining employeeCompanyTraining){
 		Object[] parameters = new Object[6];
  	
 		if(employeeCompanyTraining.getEmployee() != null){
 			parameters[0] = employeeCompanyTraining.getEmployee().getId();
 		}
  	
 		if(employeeCompanyTraining.getTraining() != null){
 			parameters[1] = employeeCompanyTraining.getTraining().getId();
 		}
  	
 		if(employeeCompanyTraining.getScoring() != null){
 			parameters[2] = employeeCompanyTraining.getScoring().getId();
 		}
 
 		parameters[3] = employeeCompanyTraining.getCurrentStatus();		
 		parameters[4] = employeeCompanyTraining.getId();
 		parameters[5] = employeeCompanyTraining.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareEmployeeCompanyTrainingCreateParameters(EmployeeCompanyTraining employeeCompanyTraining){
		Object[] parameters = new Object[5];
		String newEmployeeCompanyTrainingId=getNextId();
		employeeCompanyTraining.setId(newEmployeeCompanyTrainingId);
		parameters[0] =  employeeCompanyTraining.getId();
  	
 		if(employeeCompanyTraining.getEmployee() != null){
 			parameters[1] = employeeCompanyTraining.getEmployee().getId();
 		
 		}
 		 	
 		if(employeeCompanyTraining.getTraining() != null){
 			parameters[2] = employeeCompanyTraining.getTraining().getId();
 		
 		}
 		 	
 		if(employeeCompanyTraining.getScoring() != null){
 			parameters[3] = employeeCompanyTraining.getScoring().getId();
 		
 		}
 		
 		parameters[4] = employeeCompanyTraining.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected EmployeeCompanyTraining saveInternalEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){
		
		saveEmployeeCompanyTraining(employeeCompanyTraining);
 	
 		if(isSaveEmployeeEnabled(options)){
	 		saveEmployee(employeeCompanyTraining, options);
 		}
  	
 		if(isSaveTrainingEnabled(options)){
	 		saveTraining(employeeCompanyTraining, options);
 		}
  	
 		if(isSaveScoringEnabled(options)){
	 		saveScoring(employeeCompanyTraining, options);
 		}
 
		
		return employeeCompanyTraining;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected EmployeeCompanyTraining saveEmployee(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeCompanyTraining.getEmployee() == null){
 			return employeeCompanyTraining;//do nothing when it is null
 		}
 		
 		getEmployeeDAO().save(employeeCompanyTraining.getEmployee(),options);
 		return employeeCompanyTraining;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeCompanyTraining saveTraining(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeCompanyTraining.getTraining() == null){
 			return employeeCompanyTraining;//do nothing when it is null
 		}
 		
 		getCompanyTrainingDAO().save(employeeCompanyTraining.getTraining(),options);
 		return employeeCompanyTraining;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected EmployeeCompanyTraining saveScoring(EmployeeCompanyTraining employeeCompanyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(employeeCompanyTraining.getScoring() == null){
 			return employeeCompanyTraining;//do nothing when it is null
 		}
 		
 		getScoringDAO().save(employeeCompanyTraining.getScoring(),options);
 		return employeeCompanyTraining;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public EmployeeCompanyTraining present(EmployeeCompanyTraining employeeCompanyTraining,Map<String, Object> options){
	

		return employeeCompanyTraining;
	
	}
		


	protected String getTableName(){
		return EmployeeCompanyTrainingTable.TABLE_NAME;
	}
}


