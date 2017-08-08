
package com.skynet.retailscm.companytraining;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;

import com.skynet.retailscm.instructor.InstructorDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseTypeDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.instructor.InstructorTable;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTrainingTable;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseTypeTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class CompanyTrainingJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CompanyTrainingDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}
 
 	
 	private  InstructorDAO  instructorDAO;
 	public void setInstructorDAO(InstructorDAO instructorDAO){
	 	this.instructorDAO = instructorDAO;
 	}
 	public InstructorDAO getInstructorDAO(){
	 	return this.instructorDAO;
 	}
 
 	
 	private  TrainingCourseTypeDAO  trainingCourseTypeDAO;
 	public void setTrainingCourseTypeDAO(TrainingCourseTypeDAO trainingCourseTypeDAO){
	 	this.trainingCourseTypeDAO = trainingCourseTypeDAO;
 	}
 	public TrainingCourseTypeDAO getTrainingCourseTypeDAO(){
	 	return this.trainingCourseTypeDAO;
 	}

		
	
  	private  EmployeeCompanyTrainingDAO  employeeCompanyTrainingDAO;
 	public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO pEmployeeCompanyTrainingDAO){
 	
 		if(pEmployeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set employeeCompanyTrainingDAO to null.");
 		}
	 	this.employeeCompanyTrainingDAO = pEmployeeCompanyTrainingDAO;
 	}
 	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO(){
 		if(this.employeeCompanyTrainingDAO == null){
 			throw new IllegalStateException("The employeeCompanyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeCompanyTrainingDAO;
 	}	
 	
			
		

	
	/*
	protected CompanyTraining load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCompanyTraining(accessKey, options);
	}
	*/
	public CompanyTraining load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCompanyTraining(CompanyTrainingTable.withId(id), options);
	}
	
	
	
	public CompanyTraining save(CompanyTraining companyTraining,Map<String,Object> options){
		
		String methodName="save(CompanyTraining companyTraining,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(companyTraining, methodName, "companyTraining");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCompanyTraining(companyTraining,options);
	}
	public CompanyTraining clone(String companyTrainingId, Map<String,Object> options) throws Exception{
	
		return clone(CompanyTrainingTable.withId(companyTrainingId),options);
	}
	
	protected CompanyTraining clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String companyTrainingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CompanyTraining newCompanyTraining = loadInternalCompanyTraining(accessKey, options);
		newCompanyTraining.setVersion(0);
		
		
 		
 		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
 			for(EmployeeCompanyTraining item: newCompanyTraining.getEmployeeCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalCompanyTraining(newCompanyTraining,options);
		
		return newCompanyTraining;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String companyTrainingId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{companyTrainingId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new CompanyTrainingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CompanyTrainingNotFoundException(
					"The " + this.getTableName() + "(" + companyTrainingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String companyTrainingId, int version) throws Exception{
	
		String methodName="delete(String companyTrainingId, int version)";
		assertMethodArgumentNotNull(companyTrainingId, methodName, "companyTrainingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{companyTrainingId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(companyTrainingId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"title","company","instructor","training_course_type","time_start","duration_hours"};
		return CompanyTrainingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "company_training";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CompanyTrainingTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CompanyTrainingTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CompanyTrainingTokens.COMPANY);
 	}
 	

 	
  
 	//private boolean extractInstructorEnabled = true;
 	//private static final String INSTRUCTOR = "instructor";
 	protected boolean isExtractInstructorEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CompanyTrainingTokens.INSTRUCTOR);
 	}
 	
 	
 	//private boolean saveInstructorEnabled = true;
 	protected boolean isSaveInstructorEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CompanyTrainingTokens.INSTRUCTOR);
 	}
 	

 	
  
 	//private boolean extractTrainingCourseTypeEnabled = true;
 	//private static final String TRAININGCOURSETYPE = "trainingCourseType";
 	protected boolean isExtractTrainingCourseTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CompanyTrainingTokens.TRAININGCOURSETYPE);
 	}
 	
 	
 	//private boolean saveTrainingCourseTypeEnabled = true;
 	protected boolean isSaveTrainingCourseTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CompanyTrainingTokens.TRAININGCOURSETYPE);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";
	
	protected boolean isExtractEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,CompanyTrainingTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}

	protected boolean isSaveEmployeeCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, CompanyTrainingTokens.EMPLOYEE_COMPANY_TRAINING_LIST);
		
 	}
 	
 	
			
		

	

	protected CompanyTrainingMapper getCompanyTrainingMapper(){
		return new CompanyTrainingMapper();
	}
	protected CompanyTraining extractCompanyTraining(String companyTrainingId) throws Exception{
		String SQL = "select * from company_training_data where id = ?";	
		try{
		
			CompanyTraining companyTraining = queryForObject(SQL, new Object[]{companyTrainingId}, getCompanyTrainingMapper());
			return companyTraining;
		}catch(EmptyResultDataAccessException e){
			throw new CompanyTrainingNotFoundException("CompanyTraining("+companyTrainingId+") is not found!");
		}
		
		
	}
	protected CompanyTraining extractCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from company_training_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			CompanyTraining companyTraining = queryForObject(SQL, new Object[]{accessKey.getValue()}, getCompanyTrainingMapper());
			return companyTraining;
		}catch(EmptyResultDataAccessException e){
			throw new CompanyTrainingNotFoundException("CompanyTraining("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected CompanyTraining loadInternalCompanyTraining(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CompanyTraining companyTraining = extractCompanyTraining(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(companyTraining, loadOptions);
 		}
  	
 		if(isExtractInstructorEnabled(loadOptions)){
	 		extractInstructor(companyTraining, loadOptions);
 		}
  	
 		if(isExtractTrainingCourseTypeEnabled(loadOptions)){
	 		extractTrainingCourseType(companyTraining, loadOptions);
 		}
 
		
		if(isExtractEmployeeCompanyTrainingListEnabled(loadOptions)){
	 		extractEmployeeCompanyTrainingList(companyTraining, loadOptions);
 		}		
		
		return companyTraining;
		
	}



	
	
	 

 	protected CompanyTraining extractCompany(CompanyTraining companyTraining, Map<String,Object> options) throws Exception{

		if(companyTraining.getCompany() == null){
			return companyTraining;
		}
		String companyId = companyTraining.getCompany().getId();
		if( companyId == null){
			return companyTraining;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			companyTraining.setCompany(company);
		}
		
 		
 		return companyTraining;
 	}
 		
  

 	protected CompanyTraining extractInstructor(CompanyTraining companyTraining, Map<String,Object> options) throws Exception{

		if(companyTraining.getInstructor() == null){
			return companyTraining;
		}
		String instructorId = companyTraining.getInstructor().getId();
		if( instructorId == null){
			return companyTraining;
		}
		Instructor instructor = getInstructorDAO().load(instructorId,options);
		if(instructor != null){
			companyTraining.setInstructor(instructor);
		}
		
 		
 		return companyTraining;
 	}
 		
  

 	protected CompanyTraining extractTrainingCourseType(CompanyTraining companyTraining, Map<String,Object> options) throws Exception{

		if(companyTraining.getTrainingCourseType() == null){
			return companyTraining;
		}
		String trainingCourseTypeId = companyTraining.getTrainingCourseType().getId();
		if( trainingCourseTypeId == null){
			return companyTraining;
		}
		TrainingCourseType trainingCourseType = getTrainingCourseTypeDAO().load(trainingCourseTypeId,options);
		if(trainingCourseType != null){
			companyTraining.setTrainingCourseType(trainingCourseType);
		}
		
 		
 		return companyTraining;
 	}
 		
 
		
	protected CompanyTraining extractEmployeeCompanyTrainingList(CompanyTraining companyTraining, Map<String,Object> options){
		
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByTraining(companyTraining.getId(),options);
		if(employeeCompanyTrainingList != null){
			companyTraining.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
		}
		
		return companyTraining;
	
	}	
		
		
  	
 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<CompanyTraining> companyTrainingList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getCompanyTrainingMapper());	
 		return companyTrainingList;
 	}
 	
 	public SmartList<CompanyTraining> findCompanyTrainingByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<CompanyTraining> companyTrainingList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getCompanyTrainingMapper());
		
 		return companyTrainingList;
 	}
 	
 	public int countCompanyTrainingByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where instructor = ?";
		SmartList<CompanyTraining> companyTrainingList = queryForList(SQL, new Object[]{instructorId}, getCompanyTrainingMapper());	
 		return companyTrainingList;
 	}
 	
 	public SmartList<CompanyTraining> findCompanyTrainingByInstructor(String instructorId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where instructor = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<CompanyTraining> companyTrainingList = queryForList(SQL, new Object[]{instructorId,start, count}, getCompanyTrainingMapper());
		
 		return companyTrainingList;
 	}
 	
 	public int countCompanyTrainingByInstructor(String instructorId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where instructor = ?";
		Integer count = queryInt(SQL, new Object[]{instructorId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where training_course_type = ?";
		SmartList<CompanyTraining> companyTrainingList = queryForList(SQL, new Object[]{trainingCourseTypeId}, getCompanyTrainingMapper());	
 		return companyTrainingList;
 	}
 	
 	public SmartList<CompanyTraining> findCompanyTrainingByTrainingCourseType(String trainingCourseTypeId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where training_course_type = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<CompanyTraining> companyTrainingList = queryForList(SQL, new Object[]{trainingCourseTypeId,start, count}, getCompanyTrainingMapper());
		
 		return companyTrainingList;
 	}
 	
 	public int countCompanyTrainingByTrainingCourseType(String trainingCourseTypeId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where training_course_type = ?";
		Integer count = queryInt(SQL, new Object[]{trainingCourseTypeId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected CompanyTraining saveCompanyTraining(CompanyTraining  companyTraining){
	
		String SQL=this.getSaveCompanyTrainingSQL(companyTraining);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCompanyTrainingParameters(companyTraining);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		companyTraining.incVersion();
		return companyTraining;
	
	}
	public SmartList<CompanyTraining> saveCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCompanyTrainingList(companyTrainingList);
		
		batchCompanyTrainingCreate((List<CompanyTraining>)lists[CREATE_LIST_INDEX]);
		
		batchCompanyTrainingUpdate((List<CompanyTraining>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(CompanyTraining companyTraining:companyTrainingList){
			if(companyTraining.isChanged()){
				companyTraining.incVersion();
			}
			
		
		}
		
		
		return companyTrainingList;
	}

	public SmartList<CompanyTraining> removeCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options){
		
		
		super.removeList(companyTrainingList, options);
		
		return companyTrainingList;
		
		
	}
	
	protected List<Object[]> prepareCompanyTrainingBatchCreateArgs(List<CompanyTraining> companyTrainingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CompanyTraining companyTraining:companyTrainingList ){
			Object [] parameters = prepareCompanyTrainingCreateParameters(companyTraining);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareCompanyTrainingBatchUpdateArgs(List<CompanyTraining> companyTrainingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CompanyTraining companyTraining:companyTrainingList ){
			if(!companyTraining.isChanged()){
				continue;
			}
			Object [] parameters = prepareCompanyTrainingUpdateParameters(companyTraining);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCompanyTrainingCreate(List<CompanyTraining> companyTrainingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCompanyTrainingBatchCreateArgs(companyTrainingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchCompanyTrainingUpdate(List<CompanyTraining> companyTrainingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCompanyTrainingBatchUpdateArgs(companyTrainingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCompanyTrainingList(List<CompanyTraining> companyTrainingList){
		
		List<CompanyTraining> companyTrainingCreateList=new ArrayList<CompanyTraining>();
		List<CompanyTraining> companyTrainingUpdateList=new ArrayList<CompanyTraining>();
		
		for(CompanyTraining companyTraining: companyTrainingList){
			if(isUpdateRequest(companyTraining)){
				companyTrainingUpdateList.add( companyTraining);
				continue;
			}
			companyTrainingCreateList.add(companyTraining);
		}
		
		return new Object[]{companyTrainingCreateList,companyTrainingUpdateList};
	}
	
	protected boolean isUpdateRequest(CompanyTraining companyTraining){
 		return companyTraining.getVersion() > 0;
 	}
 	protected String getSaveCompanyTrainingSQL(CompanyTraining companyTraining){
 		if(isUpdateRequest(companyTraining)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCompanyTrainingParameters(CompanyTraining companyTraining){
 		if(isUpdateRequest(companyTraining) ){
 			return prepareCompanyTrainingUpdateParameters(companyTraining);
 		}
 		return prepareCompanyTrainingCreateParameters(companyTraining);
 	}
 	protected Object[] prepareCompanyTrainingUpdateParameters(CompanyTraining companyTraining){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = companyTraining.getTitle(); 	
 		if(companyTraining.getCompany() != null){
 			parameters[1] = companyTraining.getCompany().getId();
 		}
  	
 		if(companyTraining.getInstructor() != null){
 			parameters[2] = companyTraining.getInstructor().getId();
 		}
  	
 		if(companyTraining.getTrainingCourseType() != null){
 			parameters[3] = companyTraining.getTrainingCourseType().getId();
 		}
 
 		parameters[4] = companyTraining.getTimeStart();
 		parameters[5] = companyTraining.getDurationHours();		
 		parameters[6] = companyTraining.getId();
 		parameters[7] = companyTraining.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCompanyTrainingCreateParameters(CompanyTraining companyTraining){
		Object[] parameters = new Object[7];
		String newCompanyTrainingId=getNextId();
		companyTraining.setId(newCompanyTrainingId);
		parameters[0] =  companyTraining.getId();
 
 		parameters[1] = companyTraining.getTitle(); 	
 		if(companyTraining.getCompany() != null){
 			parameters[2] = companyTraining.getCompany().getId();
 		
 		}
 		 	
 		if(companyTraining.getInstructor() != null){
 			parameters[3] = companyTraining.getInstructor().getId();
 		
 		}
 		 	
 		if(companyTraining.getTrainingCourseType() != null){
 			parameters[4] = companyTraining.getTrainingCourseType().getId();
 		
 		}
 		
 		parameters[5] = companyTraining.getTimeStart();
 		parameters[6] = companyTraining.getDurationHours();		
 				
 		return parameters;
 	}
 	
	protected CompanyTraining saveInternalCompanyTraining(CompanyTraining companyTraining, Map<String,Object> options){
		
		saveCompanyTraining(companyTraining);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(companyTraining, options);
 		}
  	
 		if(isSaveInstructorEnabled(options)){
	 		saveInstructor(companyTraining, options);
 		}
  	
 		if(isSaveTrainingCourseTypeEnabled(options)){
	 		saveTrainingCourseType(companyTraining, options);
 		}
 
		
		if(isSaveEmployeeCompanyTrainingListEnabled(options)){
	 		saveEmployeeCompanyTrainingList(companyTraining, options);
	 		removeEmployeeCompanyTrainingList(companyTraining, options);
	 		
 		}		
		
		return companyTraining;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CompanyTraining saveCompany(CompanyTraining companyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(companyTraining.getCompany() == null){
 			return companyTraining;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(companyTraining.getCompany(),options);
 		return companyTraining;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected CompanyTraining saveInstructor(CompanyTraining companyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(companyTraining.getInstructor() == null){
 			return companyTraining;//do nothing when it is null
 		}
 		
 		getInstructorDAO().save(companyTraining.getInstructor(),options);
 		return companyTraining;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected CompanyTraining saveTrainingCourseType(CompanyTraining companyTraining, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(companyTraining.getTrainingCourseType() == null){
 			return companyTraining;//do nothing when it is null
 		}
 		
 		getTrainingCourseTypeDAO().save(companyTraining.getTrainingCourseType(),options);
 		return companyTraining;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected CompanyTraining saveEmployeeCompanyTrainingList(CompanyTraining companyTraining, Map<String,Object> options){
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return companyTraining;
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return companyTraining;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeCompanyTrainingDAO().saveEmployeeCompanyTrainingList(employeeCompanyTrainingList,options);
		
		return companyTraining;
	
	}
	
	protected CompanyTraining removeEmployeeCompanyTrainingList(CompanyTraining companyTraining, Map<String,Object> options){
	
	
		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();
		if(employeeCompanyTrainingList == null){
			return companyTraining;
		}	
	
		SmartList<EmployeeCompanyTraining> toRemoveEmployeeCompanyTrainingList = employeeCompanyTrainingList.getToRemoveList();
		
		if(toRemoveEmployeeCompanyTrainingList == null){
			return companyTraining;
		}
		if(toRemoveEmployeeCompanyTrainingList.isEmpty()){
			return companyTraining;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeCompanyTrainingDAO().removeEmployeeCompanyTrainingList(toRemoveEmployeeCompanyTrainingList,options);
		
		return companyTraining;
	
	}
	
	
	
 	
 	
	
	
	
		

	public CompanyTraining present(CompanyTraining companyTraining,Map<String, Object> options){
	
		presentEmployeeCompanyTrainingList(companyTraining,options);

		return companyTraining;
	
	}
		
	
  	
 	protected CompanyTraining presentEmployeeCompanyTrainingList(
			CompanyTraining companyTraining,
			Map<String, Object> options) {

		SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList = companyTraining.getEmployeeCompanyTrainingList();		
		if(employeeCompanyTrainingList == null){
			return companyTraining;			
		}
		
		String targetObjectName = "employeeCompanyTraining";
		int employeeCompanyTrainingListSize = employeeCompanyTrainingList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeCompanyTrainingListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return companyTraining;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeCompanyTrainingListSize;
		if(employeeCompanyTrainingListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeCompanyTrainingDAO().countEmployeeCompanyTrainingByTraining(companyTraining.getId(), options);			
		}
		//companyTraining.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//companyTraining.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeCompanyTrainingListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeCompanyTrainingListSize,currentPage,rowsPerPage) ;
			employeeCompanyTrainingList = employeeCompanyTrainingList.subListOf(fromIndex, toIndex);
			employeeCompanyTrainingList.setTotalCount(count);
			employeeCompanyTrainingList.setCurrentPageNumber(currentPage);			
			companyTraining.setEmployeeCompanyTrainingList(employeeCompanyTrainingList);
			return companyTraining;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeCompanyTrainingList 
			= getEmployeeCompanyTrainingDAO().findEmployeeCompanyTrainingByTraining(companyTraining.getId(),start, rowsPerPage, options );
		employeeCompanyTrainingList.setTotalCount(count);
		employeeCompanyTrainingList.setCurrentPageNumber(currentPage);
		companyTraining.setEmployeeCompanyTrainingList(employeeCompanyTrainingList );	

		return companyTraining;
	}			
		


	protected String getTableName(){
		return CompanyTrainingTable.TABLE_NAME;
	}
}


