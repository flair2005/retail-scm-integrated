
package com.skynet.retailscm.leavetype;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeleave.EmployeeLeave;

import com.skynet.retailscm.employeeleave.EmployeeLeaveDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employeeleave.EmployeeLeaveTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class LeaveTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements LeaveTypeDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  EmployeeLeaveDAO  employeeLeaveDAO;
 	public void setEmployeeLeaveDAO(EmployeeLeaveDAO pEmployeeLeaveDAO){
 	
 		if(pEmployeeLeaveDAO == null){
 			throw new IllegalStateException("Do not try to set employeeLeaveDAO to null.");
 		}
	 	this.employeeLeaveDAO = pEmployeeLeaveDAO;
 	}
 	public EmployeeLeaveDAO getEmployeeLeaveDAO(){
 		if(this.employeeLeaveDAO == null){
 			throw new IllegalStateException("The employeeLeaveDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeLeaveDAO;
 	}	
 	
			
		

	
	/*
	protected LeaveType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalLeaveType(accessKey, options);
	}
	*/
	public LeaveType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalLeaveType(LeaveTypeTable.withId(id), options);
	}
	
	
	
	public LeaveType save(LeaveType leaveType,Map<String,Object> options){
		
		String methodName="save(LeaveType leaveType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(leaveType, methodName, "leaveType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalLeaveType(leaveType,options);
	}
	public LeaveType clone(String leaveTypeId, Map<String,Object> options) throws Exception{
	
		return clone(LeaveTypeTable.withId(leaveTypeId),options);
	}
	
	protected LeaveType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String leaveTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		LeaveType newLeaveType = loadInternalLeaveType(accessKey, options);
		newLeaveType.setVersion(0);
		
		
 		
 		if(isSaveEmployeeLeaveListEnabled(options)){
 			for(EmployeeLeave item: newLeaveType.getEmployeeLeaveList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalLeaveType(newLeaveType,options);
		
		return newLeaveType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String leaveTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{leaveTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new LeaveTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new LeaveTypeNotFoundException(
					"The " + this.getTableName() + "(" + leaveTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String leaveTypeId, int version) throws Exception{
	
		String methodName="delete(String leaveTypeId, int version)";
		assertMethodArgumentNotNull(leaveTypeId, methodName, "leaveTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{leaveTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(leaveTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","description","detail_description"};
		return LeaveTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "leave_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return LeaveTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, LeaveTypeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, LeaveTypeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_LEAVE_LIST = "employeeLeaveList";
	
	protected boolean isExtractEmployeeLeaveListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,LeaveTypeTokens.EMPLOYEE_LEAVE_LIST);
		
 	}

	protected boolean isSaveEmployeeLeaveListEnabled(Map<String,Object> options){
		return checkOptions(options, LeaveTypeTokens.EMPLOYEE_LEAVE_LIST);
		
 	}
 	
 	
			
		

	

	protected LeaveTypeMapper getLeaveTypeMapper(){
		return new LeaveTypeMapper();
	}
	protected LeaveType extractLeaveType(String leaveTypeId) throws Exception{
		String SQL = "select * from leave_type_data where id = ?";	
		try{
		
			LeaveType leaveType = queryForObject(SQL, new Object[]{leaveTypeId}, getLeaveTypeMapper());
			return leaveType;
		}catch(EmptyResultDataAccessException e){
			throw new LeaveTypeNotFoundException("LeaveType("+leaveTypeId+") is not found!");
		}
		
		
	}
	protected LeaveType extractLeaveType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from leave_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			LeaveType leaveType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getLeaveTypeMapper());
			return leaveType;
		}catch(EmptyResultDataAccessException e){
			throw new LeaveTypeNotFoundException("LeaveType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected LeaveType loadInternalLeaveType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		LeaveType leaveType = extractLeaveType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(leaveType, loadOptions);
 		}
 
		
		if(isExtractEmployeeLeaveListEnabled(loadOptions)){
	 		extractEmployeeLeaveList(leaveType, loadOptions);
 		}		
		
		return leaveType;
		
	}



	
	
	 

 	protected LeaveType extractCompany(LeaveType leaveType, Map<String,Object> options) throws Exception{

		if(leaveType.getCompany() == null){
			return leaveType;
		}
		String companyId = leaveType.getCompany().getId();
		if( companyId == null){
			return leaveType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			leaveType.setCompany(company);
		}
		
 		
 		return leaveType;
 	}
 		
 
		
	protected LeaveType extractEmployeeLeaveList(LeaveType leaveType, Map<String,Object> options){
		
		SmartList<EmployeeLeave> employeeLeaveList = getEmployeeLeaveDAO().findEmployeeLeaveByType(leaveType.getId(),options);
		if(employeeLeaveList != null){
			leaveType.setEmployeeLeaveList(employeeLeaveList);
		}
		
		return leaveType;
	
	}	
		
		
  	
 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<LeaveType> leaveTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getLeaveTypeMapper());	
 		return leaveTypeList;
 	}
 	
 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<LeaveType> leaveTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getLeaveTypeMapper());
		
 		return leaveTypeList;
 	}
 	
 	public int countLeaveTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected LeaveType saveLeaveType(LeaveType  leaveType){
	
		String SQL=this.getSaveLeaveTypeSQL(leaveType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveLeaveTypeParameters(leaveType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		leaveType.incVersion();
		return leaveType;
	
	}
	public SmartList<LeaveType> saveLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitLeaveTypeList(leaveTypeList);
		
		batchLeaveTypeCreate((List<LeaveType>)lists[CREATE_LIST_INDEX]);
		
		batchLeaveTypeUpdate((List<LeaveType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(LeaveType leaveType:leaveTypeList){
			if(leaveType.isChanged()){
				leaveType.incVersion();
			}
			
		
		}
		
		
		return leaveTypeList;
	}

	public SmartList<LeaveType> removeLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options){
		
		
		super.removeList(leaveTypeList, options);
		
		return leaveTypeList;
		
		
	}
	
	protected List<Object[]> prepareLeaveTypeBatchCreateArgs(List<LeaveType> leaveTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveType leaveType:leaveTypeList ){
			Object [] parameters = prepareLeaveTypeCreateParameters(leaveType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareLeaveTypeBatchUpdateArgs(List<LeaveType> leaveTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(LeaveType leaveType:leaveTypeList ){
			if(!leaveType.isChanged()){
				continue;
			}
			Object [] parameters = prepareLeaveTypeUpdateParameters(leaveType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchLeaveTypeCreate(List<LeaveType> leaveTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareLeaveTypeBatchCreateArgs(leaveTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchLeaveTypeUpdate(List<LeaveType> leaveTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareLeaveTypeBatchUpdateArgs(leaveTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitLeaveTypeList(List<LeaveType> leaveTypeList){
		
		List<LeaveType> leaveTypeCreateList=new ArrayList<LeaveType>();
		List<LeaveType> leaveTypeUpdateList=new ArrayList<LeaveType>();
		
		for(LeaveType leaveType: leaveTypeList){
			if(isUpdateRequest(leaveType)){
				leaveTypeUpdateList.add( leaveType);
				continue;
			}
			leaveTypeCreateList.add(leaveType);
		}
		
		return new Object[]{leaveTypeCreateList,leaveTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(LeaveType leaveType){
 		return leaveType.getVersion() > 0;
 	}
 	protected String getSaveLeaveTypeSQL(LeaveType leaveType){
 		if(isUpdateRequest(leaveType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveLeaveTypeParameters(LeaveType leaveType){
 		if(isUpdateRequest(leaveType) ){
 			return prepareLeaveTypeUpdateParameters(leaveType);
 		}
 		return prepareLeaveTypeCreateParameters(leaveType);
 	}
 	protected Object[] prepareLeaveTypeUpdateParameters(LeaveType leaveType){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = leaveType.getCode(); 	
 		if(leaveType.getCompany() != null){
 			parameters[1] = leaveType.getCompany().getId();
 		}
 
 		parameters[2] = leaveType.getDescription();
 		parameters[3] = leaveType.getDetailDescription();		
 		parameters[4] = leaveType.getId();
 		parameters[5] = leaveType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareLeaveTypeCreateParameters(LeaveType leaveType){
		Object[] parameters = new Object[5];
		String newLeaveTypeId=getNextId();
		leaveType.setId(newLeaveTypeId);
		parameters[0] =  leaveType.getId();
 
 		parameters[1] = leaveType.getCode(); 	
 		if(leaveType.getCompany() != null){
 			parameters[2] = leaveType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = leaveType.getDescription();
 		parameters[4] = leaveType.getDetailDescription();		
 				
 		return parameters;
 	}
 	
	protected LeaveType saveInternalLeaveType(LeaveType leaveType, Map<String,Object> options){
		
		saveLeaveType(leaveType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(leaveType, options);
 		}
 
		
		if(isSaveEmployeeLeaveListEnabled(options)){
	 		saveEmployeeLeaveList(leaveType, options);
	 		removeEmployeeLeaveList(leaveType, options);
	 		
 		}		
		
		return leaveType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected LeaveType saveCompany(LeaveType leaveType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(leaveType.getCompany() == null){
 			return leaveType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(leaveType.getCompany(),options);
 		return leaveType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected LeaveType saveEmployeeLeaveList(LeaveType leaveType, Map<String,Object> options){
		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		if(employeeLeaveList == null){
			return leaveType;
		}
		if(employeeLeaveList.isEmpty()){
			return leaveType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeLeaveDAO().saveEmployeeLeaveList(employeeLeaveList,options);
		
		return leaveType;
	
	}
	
	protected LeaveType removeEmployeeLeaveList(LeaveType leaveType, Map<String,Object> options){
	
	
		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		if(employeeLeaveList == null){
			return leaveType;
		}	
	
		SmartList<EmployeeLeave> toRemoveEmployeeLeaveList = employeeLeaveList.getToRemoveList();
		
		if(toRemoveEmployeeLeaveList == null){
			return leaveType;
		}
		if(toRemoveEmployeeLeaveList.isEmpty()){
			return leaveType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeLeaveDAO().removeEmployeeLeaveList(toRemoveEmployeeLeaveList,options);
		
		return leaveType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public LeaveType present(LeaveType leaveType,Map<String, Object> options){
	
		presentEmployeeLeaveList(leaveType,options);

		return leaveType;
	
	}
		
	
  	
 	protected LeaveType presentEmployeeLeaveList(
			LeaveType leaveType,
			Map<String, Object> options) {

		SmartList<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();		
		if(employeeLeaveList == null){
			return leaveType;			
		}
		
		String targetObjectName = "employeeLeave";
		int employeeLeaveListSize = employeeLeaveList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeLeaveListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return leaveType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeLeaveListSize;
		if(employeeLeaveListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeLeaveDAO().countEmployeeLeaveByType(leaveType.getId(), options);			
		}
		//leaveType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//leaveType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeLeaveListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeLeaveListSize,currentPage,rowsPerPage) ;
			employeeLeaveList = employeeLeaveList.subListOf(fromIndex, toIndex);
			employeeLeaveList.setTotalCount(count);
			employeeLeaveList.setCurrentPageNumber(currentPage);			
			leaveType.setEmployeeLeaveList(employeeLeaveList);
			return leaveType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeLeaveList 
			= getEmployeeLeaveDAO().findEmployeeLeaveByType(leaveType.getId(),start, rowsPerPage, options );
		employeeLeaveList.setTotalCount(count);
		employeeLeaveList.setCurrentPageNumber(currentPage);
		leaveType.setEmployeeLeaveList(employeeLeaveList );	

		return leaveType;
	}			
		


	protected String getTableName(){
		return LeaveTypeTable.TABLE_NAME;
	}
}


