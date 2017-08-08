
package com.skynet.retailscm.instructor;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.companytraining.CompanyTraining;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.companytraining.CompanyTrainingDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.companytraining.CompanyTrainingTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class InstructorJDBCTemplateDAO extends CommonJDBCTemplateDAO implements InstructorDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  CompanyTrainingDAO  companyTrainingDAO;
 	public void setCompanyTrainingDAO(CompanyTrainingDAO pCompanyTrainingDAO){
 	
 		if(pCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set companyTrainingDAO to null.");
 		}
	 	this.companyTrainingDAO = pCompanyTrainingDAO;
 	}
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
 		if(this.companyTrainingDAO == null){
 			throw new IllegalStateException("The companyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.companyTrainingDAO;
 	}	
 	
			
		

	
	/*
	protected Instructor load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalInstructor(accessKey, options);
	}
	*/
	public Instructor load(String id,Map<String,Object> options) throws Exception{
		return loadInternalInstructor(InstructorTable.withId(id), options);
	}
	
	
	
	public Instructor save(Instructor instructor,Map<String,Object> options){
		
		String methodName="save(Instructor instructor,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(instructor, methodName, "instructor");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalInstructor(instructor,options);
	}
	public Instructor clone(String instructorId, Map<String,Object> options) throws Exception{
	
		return clone(InstructorTable.withId(instructorId),options);
	}
	
	protected Instructor clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String instructorId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Instructor newInstructor = loadInternalInstructor(accessKey, options);
		newInstructor.setVersion(0);
		
		
 		
 		if(isSaveCompanyTrainingListEnabled(options)){
 			for(CompanyTraining item: newInstructor.getCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalInstructor(newInstructor,options);
		
		return newInstructor;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String instructorId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{instructorId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new InstructorVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new InstructorNotFoundException(
					"The " + this.getTableName() + "(" + instructorId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String instructorId, int version) throws Exception{
	
		String methodName="delete(String instructorId, int version)";
		assertMethodArgumentNotNull(instructorId, methodName, "instructorId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{instructorId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(instructorId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"title","family_name","given_name","cell_phone","email","company","introduction"};
		return InstructorTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "instructor";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return InstructorTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, InstructorTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, InstructorTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String COMPANY_TRAINING_LIST = "companyTrainingList";
	
	protected boolean isExtractCompanyTrainingListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,InstructorTokens.COMPANY_TRAINING_LIST);
		
 	}

	protected boolean isSaveCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, InstructorTokens.COMPANY_TRAINING_LIST);
		
 	}
 	
 	
			
		

	

	protected InstructorMapper getInstructorMapper(){
		return new InstructorMapper();
	}
	protected Instructor extractInstructor(String instructorId) throws Exception{
		String SQL = "select * from instructor_data where id = ?";	
		try{
		
			Instructor instructor = queryForObject(SQL, new Object[]{instructorId}, getInstructorMapper());
			return instructor;
		}catch(EmptyResultDataAccessException e){
			throw new InstructorNotFoundException("Instructor("+instructorId+") is not found!");
		}
		
		
	}
	protected Instructor extractInstructor(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from instructor_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Instructor instructor = queryForObject(SQL, new Object[]{accessKey.getValue()}, getInstructorMapper());
			return instructor;
		}catch(EmptyResultDataAccessException e){
			throw new InstructorNotFoundException("Instructor("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Instructor loadInternalInstructor(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Instructor instructor = extractInstructor(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(instructor, loadOptions);
 		}
 
		
		if(isExtractCompanyTrainingListEnabled(loadOptions)){
	 		extractCompanyTrainingList(instructor, loadOptions);
 		}		
		
		return instructor;
		
	}



	
	
	 

 	protected Instructor extractCompany(Instructor instructor, Map<String,Object> options) throws Exception{

		if(instructor.getCompany() == null){
			return instructor;
		}
		String companyId = instructor.getCompany().getId();
		if( companyId == null){
			return instructor;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			instructor.setCompany(company);
		}
		
 		
 		return instructor;
 	}
 		
 
		
	protected Instructor extractCompanyTrainingList(Instructor instructor, Map<String,Object> options){
		
		SmartList<CompanyTraining> companyTrainingList = getCompanyTrainingDAO().findCompanyTrainingByInstructor(instructor.getId(),options);
		if(companyTrainingList != null){
			instructor.setCompanyTrainingList(companyTrainingList);
		}
		
		return instructor;
	
	}	
		
		
  	
 	public SmartList<Instructor> findInstructorByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<Instructor> instructorList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getInstructorMapper());	
 		return instructorList;
 	}
 	
 	public SmartList<Instructor> findInstructorByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Instructor> instructorList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getInstructorMapper());
		
 		return instructorList;
 	}
 	
 	public int countInstructorByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Instructor saveInstructor(Instructor  instructor){
	
		String SQL=this.getSaveInstructorSQL(instructor);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveInstructorParameters(instructor);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		instructor.incVersion();
		return instructor;
	
	}
	public SmartList<Instructor> saveInstructorList(SmartList<Instructor> instructorList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitInstructorList(instructorList);
		
		batchInstructorCreate((List<Instructor>)lists[CREATE_LIST_INDEX]);
		
		batchInstructorUpdate((List<Instructor>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Instructor instructor:instructorList){
			if(instructor.isChanged()){
				instructor.incVersion();
			}
			
		
		}
		
		
		return instructorList;
	}

	public SmartList<Instructor> removeInstructorList(SmartList<Instructor> instructorList,Map<String,Object> options){
		
		
		super.removeList(instructorList, options);
		
		return instructorList;
		
		
	}
	
	protected List<Object[]> prepareInstructorBatchCreateArgs(List<Instructor> instructorList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Instructor instructor:instructorList ){
			Object [] parameters = prepareInstructorCreateParameters(instructor);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareInstructorBatchUpdateArgs(List<Instructor> instructorList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Instructor instructor:instructorList ){
			if(!instructor.isChanged()){
				continue;
			}
			Object [] parameters = prepareInstructorUpdateParameters(instructor);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchInstructorCreate(List<Instructor> instructorList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareInstructorBatchCreateArgs(instructorList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchInstructorUpdate(List<Instructor> instructorList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareInstructorBatchUpdateArgs(instructorList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitInstructorList(List<Instructor> instructorList){
		
		List<Instructor> instructorCreateList=new ArrayList<Instructor>();
		List<Instructor> instructorUpdateList=new ArrayList<Instructor>();
		
		for(Instructor instructor: instructorList){
			if(isUpdateRequest(instructor)){
				instructorUpdateList.add( instructor);
				continue;
			}
			instructorCreateList.add(instructor);
		}
		
		return new Object[]{instructorCreateList,instructorUpdateList};
	}
	
	protected boolean isUpdateRequest(Instructor instructor){
 		return instructor.getVersion() > 0;
 	}
 	protected String getSaveInstructorSQL(Instructor instructor){
 		if(isUpdateRequest(instructor)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveInstructorParameters(Instructor instructor){
 		if(isUpdateRequest(instructor) ){
 			return prepareInstructorUpdateParameters(instructor);
 		}
 		return prepareInstructorCreateParameters(instructor);
 	}
 	protected Object[] prepareInstructorUpdateParameters(Instructor instructor){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = instructor.getTitle();
 		parameters[1] = instructor.getFamilyName();
 		parameters[2] = instructor.getGivenName();
 		parameters[3] = instructor.getCellPhone();
 		parameters[4] = instructor.getEmail(); 	
 		if(instructor.getCompany() != null){
 			parameters[5] = instructor.getCompany().getId();
 		}
 
 		parameters[6] = instructor.getIntroduction();		
 		parameters[7] = instructor.getId();
 		parameters[8] = instructor.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareInstructorCreateParameters(Instructor instructor){
		Object[] parameters = new Object[8];
		String newInstructorId=getNextId();
		instructor.setId(newInstructorId);
		parameters[0] =  instructor.getId();
 
 		parameters[1] = instructor.getTitle();
 		parameters[2] = instructor.getFamilyName();
 		parameters[3] = instructor.getGivenName();
 		parameters[4] = instructor.getCellPhone();
 		parameters[5] = instructor.getEmail(); 	
 		if(instructor.getCompany() != null){
 			parameters[6] = instructor.getCompany().getId();
 		
 		}
 		
 		parameters[7] = instructor.getIntroduction();		
 				
 		return parameters;
 	}
 	
	protected Instructor saveInternalInstructor(Instructor instructor, Map<String,Object> options){
		
		saveInstructor(instructor);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(instructor, options);
 		}
 
		
		if(isSaveCompanyTrainingListEnabled(options)){
	 		saveCompanyTrainingList(instructor, options);
	 		removeCompanyTrainingList(instructor, options);
	 		
 		}		
		
		return instructor;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Instructor saveCompany(Instructor instructor, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(instructor.getCompany() == null){
 			return instructor;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(instructor.getCompany(),options);
 		return instructor;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Instructor saveCompanyTrainingList(Instructor instructor, Map<String,Object> options){
		SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
		if(companyTrainingList == null){
			return instructor;
		}
		if(companyTrainingList.isEmpty()){
			return instructor;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCompanyTrainingDAO().saveCompanyTrainingList(companyTrainingList,options);
		
		return instructor;
	
	}
	
	protected Instructor removeCompanyTrainingList(Instructor instructor, Map<String,Object> options){
	
	
		SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();
		if(companyTrainingList == null){
			return instructor;
		}	
	
		SmartList<CompanyTraining> toRemoveCompanyTrainingList = companyTrainingList.getToRemoveList();
		
		if(toRemoveCompanyTrainingList == null){
			return instructor;
		}
		if(toRemoveCompanyTrainingList.isEmpty()){
			return instructor;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCompanyTrainingDAO().removeCompanyTrainingList(toRemoveCompanyTrainingList,options);
		
		return instructor;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Instructor present(Instructor instructor,Map<String, Object> options){
	
		presentCompanyTrainingList(instructor,options);

		return instructor;
	
	}
		
	
  	
 	protected Instructor presentCompanyTrainingList(
			Instructor instructor,
			Map<String, Object> options) {

		SmartList<CompanyTraining> companyTrainingList = instructor.getCompanyTrainingList();		
		if(companyTrainingList == null){
			return instructor;			
		}
		
		String targetObjectName = "companyTraining";
		int companyTrainingListSize = companyTrainingList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(companyTrainingListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return instructor;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = companyTrainingListSize;
		if(companyTrainingListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getCompanyTrainingDAO().countCompanyTrainingByInstructor(instructor.getId(), options);			
		}
		//instructor.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//instructor.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(companyTrainingListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(companyTrainingListSize,currentPage,rowsPerPage) ;
			companyTrainingList = companyTrainingList.subListOf(fromIndex, toIndex);
			companyTrainingList.setTotalCount(count);
			companyTrainingList.setCurrentPageNumber(currentPage);			
			instructor.setCompanyTrainingList(companyTrainingList);
			return instructor;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		companyTrainingList 
			= getCompanyTrainingDAO().findCompanyTrainingByInstructor(instructor.getId(),start, rowsPerPage, options );
		companyTrainingList.setTotalCount(count);
		companyTrainingList.setCurrentPageNumber(currentPage);
		instructor.setCompanyTrainingList(companyTrainingList );	

		return instructor;
	}			
		


	protected String getTableName(){
		return InstructorTable.TABLE_NAME;
	}
}


