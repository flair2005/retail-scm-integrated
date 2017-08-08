
package com.skynet.retailscm.trainingcoursetype;

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

public class TrainingCourseTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TrainingCourseTypeDAO{
 
 	
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
	protected TrainingCourseType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTrainingCourseType(accessKey, options);
	}
	*/
	public TrainingCourseType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTrainingCourseType(TrainingCourseTypeTable.withId(id), options);
	}
	
	
	
	public TrainingCourseType save(TrainingCourseType trainingCourseType,Map<String,Object> options){
		
		String methodName="save(TrainingCourseType trainingCourseType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(trainingCourseType, methodName, "trainingCourseType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTrainingCourseType(trainingCourseType,options);
	}
	public TrainingCourseType clone(String trainingCourseTypeId, Map<String,Object> options) throws Exception{
	
		return clone(TrainingCourseTypeTable.withId(trainingCourseTypeId),options);
	}
	
	protected TrainingCourseType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String trainingCourseTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TrainingCourseType newTrainingCourseType = loadInternalTrainingCourseType(accessKey, options);
		newTrainingCourseType.setVersion(0);
		
		
 		
 		if(isSaveCompanyTrainingListEnabled(options)){
 			for(CompanyTraining item: newTrainingCourseType.getCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTrainingCourseType(newTrainingCourseType,options);
		
		return newTrainingCourseType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String trainingCourseTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{trainingCourseTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TrainingCourseTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TrainingCourseTypeNotFoundException(
					"The " + this.getTableName() + "(" + trainingCourseTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String trainingCourseTypeId, int version) throws Exception{
	
		String methodName="delete(String trainingCourseTypeId, int version)";
		assertMethodArgumentNotNull(trainingCourseTypeId, methodName, "trainingCourseTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{trainingCourseTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(trainingCourseTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","name","description"};
		return TrainingCourseTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "training_course_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TrainingCourseTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TrainingCourseTypeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TrainingCourseTypeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String COMPANY_TRAINING_LIST = "companyTrainingList";
	
	protected boolean isExtractCompanyTrainingListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TrainingCourseTypeTokens.COMPANY_TRAINING_LIST);
		
 	}

	protected boolean isSaveCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, TrainingCourseTypeTokens.COMPANY_TRAINING_LIST);
		
 	}
 	
 	
			
		

	

	protected TrainingCourseTypeMapper getTrainingCourseTypeMapper(){
		return new TrainingCourseTypeMapper();
	}
	protected TrainingCourseType extractTrainingCourseType(String trainingCourseTypeId) throws Exception{
		String SQL = "select * from training_course_type_data where id = ?";	
		try{
		
			TrainingCourseType trainingCourseType = queryForObject(SQL, new Object[]{trainingCourseTypeId}, getTrainingCourseTypeMapper());
			return trainingCourseType;
		}catch(EmptyResultDataAccessException e){
			throw new TrainingCourseTypeNotFoundException("TrainingCourseType("+trainingCourseTypeId+") is not found!");
		}
		
		
	}
	protected TrainingCourseType extractTrainingCourseType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from training_course_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TrainingCourseType trainingCourseType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTrainingCourseTypeMapper());
			return trainingCourseType;
		}catch(EmptyResultDataAccessException e){
			throw new TrainingCourseTypeNotFoundException("TrainingCourseType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TrainingCourseType loadInternalTrainingCourseType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TrainingCourseType trainingCourseType = extractTrainingCourseType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(trainingCourseType, loadOptions);
 		}
 
		
		if(isExtractCompanyTrainingListEnabled(loadOptions)){
	 		extractCompanyTrainingList(trainingCourseType, loadOptions);
 		}		
		
		return trainingCourseType;
		
	}



	
	
	 

 	protected TrainingCourseType extractCompany(TrainingCourseType trainingCourseType, Map<String,Object> options) throws Exception{

		if(trainingCourseType.getCompany() == null){
			return trainingCourseType;
		}
		String companyId = trainingCourseType.getCompany().getId();
		if( companyId == null){
			return trainingCourseType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			trainingCourseType.setCompany(company);
		}
		
 		
 		return trainingCourseType;
 	}
 		
 
		
	protected TrainingCourseType extractCompanyTrainingList(TrainingCourseType trainingCourseType, Map<String,Object> options){
		
		SmartList<CompanyTraining> companyTrainingList = getCompanyTrainingDAO().findCompanyTrainingByTrainingCourseType(trainingCourseType.getId(),options);
		if(companyTrainingList != null){
			trainingCourseType.setCompanyTrainingList(companyTrainingList);
		}
		
		return trainingCourseType;
	
	}	
		
		
  	
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<TrainingCourseType> trainingCourseTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getTrainingCourseTypeMapper());	
 		return trainingCourseTypeList;
 	}
 	
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TrainingCourseType> trainingCourseTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getTrainingCourseTypeMapper());
		
 		return trainingCourseTypeList;
 	}
 	
 	public int countTrainingCourseTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TrainingCourseType saveTrainingCourseType(TrainingCourseType  trainingCourseType){
	
		String SQL=this.getSaveTrainingCourseTypeSQL(trainingCourseType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTrainingCourseTypeParameters(trainingCourseType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		trainingCourseType.incVersion();
		return trainingCourseType;
	
	}
	public SmartList<TrainingCourseType> saveTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTrainingCourseTypeList(trainingCourseTypeList);
		
		batchTrainingCourseTypeCreate((List<TrainingCourseType>)lists[CREATE_LIST_INDEX]);
		
		batchTrainingCourseTypeUpdate((List<TrainingCourseType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TrainingCourseType trainingCourseType:trainingCourseTypeList){
			if(trainingCourseType.isChanged()){
				trainingCourseType.incVersion();
			}
			
		
		}
		
		
		return trainingCourseTypeList;
	}

	public SmartList<TrainingCourseType> removeTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options){
		
		
		super.removeList(trainingCourseTypeList, options);
		
		return trainingCourseTypeList;
		
		
	}
	
	protected List<Object[]> prepareTrainingCourseTypeBatchCreateArgs(List<TrainingCourseType> trainingCourseTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TrainingCourseType trainingCourseType:trainingCourseTypeList ){
			Object [] parameters = prepareTrainingCourseTypeCreateParameters(trainingCourseType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTrainingCourseTypeBatchUpdateArgs(List<TrainingCourseType> trainingCourseTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TrainingCourseType trainingCourseType:trainingCourseTypeList ){
			if(!trainingCourseType.isChanged()){
				continue;
			}
			Object [] parameters = prepareTrainingCourseTypeUpdateParameters(trainingCourseType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTrainingCourseTypeCreate(List<TrainingCourseType> trainingCourseTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTrainingCourseTypeBatchCreateArgs(trainingCourseTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTrainingCourseTypeUpdate(List<TrainingCourseType> trainingCourseTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTrainingCourseTypeBatchUpdateArgs(trainingCourseTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTrainingCourseTypeList(List<TrainingCourseType> trainingCourseTypeList){
		
		List<TrainingCourseType> trainingCourseTypeCreateList=new ArrayList<TrainingCourseType>();
		List<TrainingCourseType> trainingCourseTypeUpdateList=new ArrayList<TrainingCourseType>();
		
		for(TrainingCourseType trainingCourseType: trainingCourseTypeList){
			if(isUpdateRequest(trainingCourseType)){
				trainingCourseTypeUpdateList.add( trainingCourseType);
				continue;
			}
			trainingCourseTypeCreateList.add(trainingCourseType);
		}
		
		return new Object[]{trainingCourseTypeCreateList,trainingCourseTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(TrainingCourseType trainingCourseType){
 		return trainingCourseType.getVersion() > 0;
 	}
 	protected String getSaveTrainingCourseTypeSQL(TrainingCourseType trainingCourseType){
 		if(isUpdateRequest(trainingCourseType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTrainingCourseTypeParameters(TrainingCourseType trainingCourseType){
 		if(isUpdateRequest(trainingCourseType) ){
 			return prepareTrainingCourseTypeUpdateParameters(trainingCourseType);
 		}
 		return prepareTrainingCourseTypeCreateParameters(trainingCourseType);
 	}
 	protected Object[] prepareTrainingCourseTypeUpdateParameters(TrainingCourseType trainingCourseType){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = trainingCourseType.getCode(); 	
 		if(trainingCourseType.getCompany() != null){
 			parameters[1] = trainingCourseType.getCompany().getId();
 		}
 
 		parameters[2] = trainingCourseType.getName();
 		parameters[3] = trainingCourseType.getDescription();		
 		parameters[4] = trainingCourseType.getId();
 		parameters[5] = trainingCourseType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTrainingCourseTypeCreateParameters(TrainingCourseType trainingCourseType){
		Object[] parameters = new Object[5];
		String newTrainingCourseTypeId=getNextId();
		trainingCourseType.setId(newTrainingCourseTypeId);
		parameters[0] =  trainingCourseType.getId();
 
 		parameters[1] = trainingCourseType.getCode(); 	
 		if(trainingCourseType.getCompany() != null){
 			parameters[2] = trainingCourseType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = trainingCourseType.getName();
 		parameters[4] = trainingCourseType.getDescription();		
 				
 		return parameters;
 	}
 	
	protected TrainingCourseType saveInternalTrainingCourseType(TrainingCourseType trainingCourseType, Map<String,Object> options){
		
		saveTrainingCourseType(trainingCourseType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(trainingCourseType, options);
 		}
 
		
		if(isSaveCompanyTrainingListEnabled(options)){
	 		saveCompanyTrainingList(trainingCourseType, options);
	 		removeCompanyTrainingList(trainingCourseType, options);
	 		
 		}		
		
		return trainingCourseType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TrainingCourseType saveCompany(TrainingCourseType trainingCourseType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(trainingCourseType.getCompany() == null){
 			return trainingCourseType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(trainingCourseType.getCompany(),options);
 		return trainingCourseType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected TrainingCourseType saveCompanyTrainingList(TrainingCourseType trainingCourseType, Map<String,Object> options){
		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		if(companyTrainingList == null){
			return trainingCourseType;
		}
		if(companyTrainingList.isEmpty()){
			return trainingCourseType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCompanyTrainingDAO().saveCompanyTrainingList(companyTrainingList,options);
		
		return trainingCourseType;
	
	}
	
	protected TrainingCourseType removeCompanyTrainingList(TrainingCourseType trainingCourseType, Map<String,Object> options){
	
	
		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();
		if(companyTrainingList == null){
			return trainingCourseType;
		}	
	
		SmartList<CompanyTraining> toRemoveCompanyTrainingList = companyTrainingList.getToRemoveList();
		
		if(toRemoveCompanyTrainingList == null){
			return trainingCourseType;
		}
		if(toRemoveCompanyTrainingList.isEmpty()){
			return trainingCourseType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCompanyTrainingDAO().removeCompanyTrainingList(toRemoveCompanyTrainingList,options);
		
		return trainingCourseType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public TrainingCourseType present(TrainingCourseType trainingCourseType,Map<String, Object> options){
	
		presentCompanyTrainingList(trainingCourseType,options);

		return trainingCourseType;
	
	}
		
	
  	
 	protected TrainingCourseType presentCompanyTrainingList(
			TrainingCourseType trainingCourseType,
			Map<String, Object> options) {

		SmartList<CompanyTraining> companyTrainingList = trainingCourseType.getCompanyTrainingList();		
		if(companyTrainingList == null){
			return trainingCourseType;			
		}
		
		String targetObjectName = "companyTraining";
		int companyTrainingListSize = companyTrainingList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(companyTrainingListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return trainingCourseType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = companyTrainingListSize;
		if(companyTrainingListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getCompanyTrainingDAO().countCompanyTrainingByTrainingCourseType(trainingCourseType.getId(), options);			
		}
		//trainingCourseType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//trainingCourseType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(companyTrainingListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(companyTrainingListSize,currentPage,rowsPerPage) ;
			companyTrainingList = companyTrainingList.subListOf(fromIndex, toIndex);
			companyTrainingList.setTotalCount(count);
			companyTrainingList.setCurrentPageNumber(currentPage);			
			trainingCourseType.setCompanyTrainingList(companyTrainingList);
			return trainingCourseType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		companyTrainingList 
			= getCompanyTrainingDAO().findCompanyTrainingByTrainingCourseType(trainingCourseType.getId(),start, rowsPerPage, options );
		companyTrainingList.setTotalCount(count);
		companyTrainingList.setCurrentPageNumber(currentPage);
		trainingCourseType.setCompanyTrainingList(companyTrainingList );	

		return trainingCourseType;
	}			
		


	protected String getTableName(){
		return TrainingCourseTypeTable.TABLE_NAME;
	}
}


