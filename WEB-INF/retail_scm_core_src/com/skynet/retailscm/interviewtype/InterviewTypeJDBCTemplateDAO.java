
package com.skynet.retailscm.interviewtype;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeinterview.EmployeeInterview;

import com.skynet.retailscm.employeeinterview.EmployeeInterviewDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employeeinterview.EmployeeInterviewTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class InterviewTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements InterviewTypeDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  EmployeeInterviewDAO  employeeInterviewDAO;
 	public void setEmployeeInterviewDAO(EmployeeInterviewDAO pEmployeeInterviewDAO){
 	
 		if(pEmployeeInterviewDAO == null){
 			throw new IllegalStateException("Do not try to set employeeInterviewDAO to null.");
 		}
	 	this.employeeInterviewDAO = pEmployeeInterviewDAO;
 	}
 	public EmployeeInterviewDAO getEmployeeInterviewDAO(){
 		if(this.employeeInterviewDAO == null){
 			throw new IllegalStateException("The employeeInterviewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeInterviewDAO;
 	}	
 	
			
		

	
	/*
	protected InterviewType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalInterviewType(accessKey, options);
	}
	*/
	public InterviewType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalInterviewType(InterviewTypeTable.withId(id), options);
	}
	
	
	
	public InterviewType save(InterviewType interviewType,Map<String,Object> options){
		
		String methodName="save(InterviewType interviewType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(interviewType, methodName, "interviewType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalInterviewType(interviewType,options);
	}
	public InterviewType clone(String interviewTypeId, Map<String,Object> options) throws Exception{
	
		return clone(InterviewTypeTable.withId(interviewTypeId),options);
	}
	
	protected InterviewType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String interviewTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		InterviewType newInterviewType = loadInternalInterviewType(accessKey, options);
		newInterviewType.setVersion(0);
		
		
 		
 		if(isSaveEmployeeInterviewListEnabled(options)){
 			for(EmployeeInterview item: newInterviewType.getEmployeeInterviewList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalInterviewType(newInterviewType,options);
		
		return newInterviewType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String interviewTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{interviewTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new InterviewTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new InterviewTypeNotFoundException(
					"The " + this.getTableName() + "(" + interviewTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String interviewTypeId, int version) throws Exception{
	
		String methodName="delete(String interviewTypeId, int version)";
		assertMethodArgumentNotNull(interviewTypeId, methodName, "interviewTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{interviewTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(interviewTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","description","detail_description"};
		return InterviewTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "interview_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return InterviewTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, InterviewTypeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, InterviewTypeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_INTERVIEW_LIST = "employeeInterviewList";
	
	protected boolean isExtractEmployeeInterviewListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,InterviewTypeTokens.EMPLOYEE_INTERVIEW_LIST);
		
 	}

	protected boolean isSaveEmployeeInterviewListEnabled(Map<String,Object> options){
		return checkOptions(options, InterviewTypeTokens.EMPLOYEE_INTERVIEW_LIST);
		
 	}
 	
 	
			
		

	

	protected InterviewTypeMapper getInterviewTypeMapper(){
		return new InterviewTypeMapper();
	}
	protected InterviewType extractInterviewType(String interviewTypeId) throws Exception{
		String SQL = "select * from interview_type_data where id = ?";	
		try{
		
			InterviewType interviewType = queryForObject(SQL, new Object[]{interviewTypeId}, getInterviewTypeMapper());
			return interviewType;
		}catch(EmptyResultDataAccessException e){
			throw new InterviewTypeNotFoundException("InterviewType("+interviewTypeId+") is not found!");
		}
		
		
	}
	protected InterviewType extractInterviewType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from interview_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			InterviewType interviewType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getInterviewTypeMapper());
			return interviewType;
		}catch(EmptyResultDataAccessException e){
			throw new InterviewTypeNotFoundException("InterviewType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected InterviewType loadInternalInterviewType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		InterviewType interviewType = extractInterviewType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(interviewType, loadOptions);
 		}
 
		
		if(isExtractEmployeeInterviewListEnabled(loadOptions)){
	 		extractEmployeeInterviewList(interviewType, loadOptions);
 		}		
		
		return interviewType;
		
	}



	
	
	 

 	protected InterviewType extractCompany(InterviewType interviewType, Map<String,Object> options) throws Exception{

		if(interviewType.getCompany() == null){
			return interviewType;
		}
		String companyId = interviewType.getCompany().getId();
		if( companyId == null){
			return interviewType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			interviewType.setCompany(company);
		}
		
 		
 		return interviewType;
 	}
 		
 
		
	protected InterviewType extractEmployeeInterviewList(InterviewType interviewType, Map<String,Object> options){
		
		SmartList<EmployeeInterview> employeeInterviewList = getEmployeeInterviewDAO().findEmployeeInterviewByInterviewType(interviewType.getId(),options);
		if(employeeInterviewList != null){
			interviewType.setEmployeeInterviewList(employeeInterviewList);
		}
		
		return interviewType;
	
	}	
		
		
  	
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<InterviewType> interviewTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getInterviewTypeMapper());	
 		return interviewTypeList;
 	}
 	
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<InterviewType> interviewTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getInterviewTypeMapper());
		
 		return interviewTypeList;
 	}
 	
 	public int countInterviewTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected InterviewType saveInterviewType(InterviewType  interviewType){
	
		String SQL=this.getSaveInterviewTypeSQL(interviewType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveInterviewTypeParameters(interviewType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		interviewType.incVersion();
		return interviewType;
	
	}
	public SmartList<InterviewType> saveInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitInterviewTypeList(interviewTypeList);
		
		batchInterviewTypeCreate((List<InterviewType>)lists[CREATE_LIST_INDEX]);
		
		batchInterviewTypeUpdate((List<InterviewType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(InterviewType interviewType:interviewTypeList){
			if(interviewType.isChanged()){
				interviewType.incVersion();
			}
			
		
		}
		
		
		return interviewTypeList;
	}

	public SmartList<InterviewType> removeInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options){
		
		
		super.removeList(interviewTypeList, options);
		
		return interviewTypeList;
		
		
	}
	
	protected List<Object[]> prepareInterviewTypeBatchCreateArgs(List<InterviewType> interviewTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(InterviewType interviewType:interviewTypeList ){
			Object [] parameters = prepareInterviewTypeCreateParameters(interviewType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareInterviewTypeBatchUpdateArgs(List<InterviewType> interviewTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(InterviewType interviewType:interviewTypeList ){
			if(!interviewType.isChanged()){
				continue;
			}
			Object [] parameters = prepareInterviewTypeUpdateParameters(interviewType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchInterviewTypeCreate(List<InterviewType> interviewTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareInterviewTypeBatchCreateArgs(interviewTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchInterviewTypeUpdate(List<InterviewType> interviewTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareInterviewTypeBatchUpdateArgs(interviewTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitInterviewTypeList(List<InterviewType> interviewTypeList){
		
		List<InterviewType> interviewTypeCreateList=new ArrayList<InterviewType>();
		List<InterviewType> interviewTypeUpdateList=new ArrayList<InterviewType>();
		
		for(InterviewType interviewType: interviewTypeList){
			if(isUpdateRequest(interviewType)){
				interviewTypeUpdateList.add( interviewType);
				continue;
			}
			interviewTypeCreateList.add(interviewType);
		}
		
		return new Object[]{interviewTypeCreateList,interviewTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(InterviewType interviewType){
 		return interviewType.getVersion() > 0;
 	}
 	protected String getSaveInterviewTypeSQL(InterviewType interviewType){
 		if(isUpdateRequest(interviewType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveInterviewTypeParameters(InterviewType interviewType){
 		if(isUpdateRequest(interviewType) ){
 			return prepareInterviewTypeUpdateParameters(interviewType);
 		}
 		return prepareInterviewTypeCreateParameters(interviewType);
 	}
 	protected Object[] prepareInterviewTypeUpdateParameters(InterviewType interviewType){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = interviewType.getCode(); 	
 		if(interviewType.getCompany() != null){
 			parameters[1] = interviewType.getCompany().getId();
 		}
 
 		parameters[2] = interviewType.getDescription();
 		parameters[3] = interviewType.getDetailDescription();		
 		parameters[4] = interviewType.getId();
 		parameters[5] = interviewType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareInterviewTypeCreateParameters(InterviewType interviewType){
		Object[] parameters = new Object[5];
		String newInterviewTypeId=getNextId();
		interviewType.setId(newInterviewTypeId);
		parameters[0] =  interviewType.getId();
 
 		parameters[1] = interviewType.getCode(); 	
 		if(interviewType.getCompany() != null){
 			parameters[2] = interviewType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = interviewType.getDescription();
 		parameters[4] = interviewType.getDetailDescription();		
 				
 		return parameters;
 	}
 	
	protected InterviewType saveInternalInterviewType(InterviewType interviewType, Map<String,Object> options){
		
		saveInterviewType(interviewType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(interviewType, options);
 		}
 
		
		if(isSaveEmployeeInterviewListEnabled(options)){
	 		saveEmployeeInterviewList(interviewType, options);
	 		removeEmployeeInterviewList(interviewType, options);
	 		
 		}		
		
		return interviewType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected InterviewType saveCompany(InterviewType interviewType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(interviewType.getCompany() == null){
 			return interviewType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(interviewType.getCompany(),options);
 		return interviewType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected InterviewType saveEmployeeInterviewList(InterviewType interviewType, Map<String,Object> options){
		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();
		if(employeeInterviewList == null){
			return interviewType;
		}
		if(employeeInterviewList.isEmpty()){
			return interviewType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeInterviewDAO().saveEmployeeInterviewList(employeeInterviewList,options);
		
		return interviewType;
	
	}
	
	protected InterviewType removeEmployeeInterviewList(InterviewType interviewType, Map<String,Object> options){
	
	
		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();
		if(employeeInterviewList == null){
			return interviewType;
		}	
	
		SmartList<EmployeeInterview> toRemoveEmployeeInterviewList = employeeInterviewList.getToRemoveList();
		
		if(toRemoveEmployeeInterviewList == null){
			return interviewType;
		}
		if(toRemoveEmployeeInterviewList.isEmpty()){
			return interviewType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeInterviewDAO().removeEmployeeInterviewList(toRemoveEmployeeInterviewList,options);
		
		return interviewType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public InterviewType present(InterviewType interviewType,Map<String, Object> options){
	
		presentEmployeeInterviewList(interviewType,options);

		return interviewType;
	
	}
		
	
  	
 	protected InterviewType presentEmployeeInterviewList(
			InterviewType interviewType,
			Map<String, Object> options) {

		SmartList<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();		
		if(employeeInterviewList == null){
			return interviewType;			
		}
		
		String targetObjectName = "employeeInterview";
		int employeeInterviewListSize = employeeInterviewList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeInterviewListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return interviewType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeInterviewListSize;
		if(employeeInterviewListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeInterviewDAO().countEmployeeInterviewByInterviewType(interviewType.getId(), options);			
		}
		//interviewType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//interviewType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeInterviewListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeInterviewListSize,currentPage,rowsPerPage) ;
			employeeInterviewList = employeeInterviewList.subListOf(fromIndex, toIndex);
			employeeInterviewList.setTotalCount(count);
			employeeInterviewList.setCurrentPageNumber(currentPage);			
			interviewType.setEmployeeInterviewList(employeeInterviewList);
			return interviewType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeInterviewList 
			= getEmployeeInterviewDAO().findEmployeeInterviewByInterviewType(interviewType.getId(),start, rowsPerPage, options );
		employeeInterviewList.setTotalCount(count);
		employeeInterviewList.setCurrentPageNumber(currentPage);
		interviewType.setEmployeeInterviewList(employeeInterviewList );	

		return interviewType;
	}			
		


	protected String getTableName(){
		return InterviewTypeTable.TABLE_NAME;
	}
}


