
package com.skynet.retailscm.provincecenterdepartment;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO;

import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployeeTable;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ProvinceCenterDepartmentJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ProvinceCenterDepartmentDAO{
 
 	
 	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
	 	return this.retailStoreProvinceCenterDAO;
 	}

		
	
  	private  ProvinceCenterEmployeeDAO  provinceCenterEmployeeDAO;
 	public void setProvinceCenterEmployeeDAO(ProvinceCenterEmployeeDAO pProvinceCenterEmployeeDAO){
 	
 		if(pProvinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterEmployeeDAO to null.");
 		}
	 	this.provinceCenterEmployeeDAO = pProvinceCenterEmployeeDAO;
 	}
 	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO(){
 		if(this.provinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("The provinceCenterEmployeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterEmployeeDAO;
 	}	
 	
			
		

	
	/*
	protected ProvinceCenterDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterDepartment(accessKey, options);
	}
	*/
	public ProvinceCenterDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterDepartment(ProvinceCenterDepartmentTable.withId(id), options);
	}
	
	
	
	public ProvinceCenterDepartment save(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options){
		
		String methodName="save(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(provinceCenterDepartment, methodName, "provinceCenterDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProvinceCenterDepartment(provinceCenterDepartment,options);
	}
	public ProvinceCenterDepartment clone(String provinceCenterDepartmentId, Map<String,Object> options) throws Exception{
	
		return clone(ProvinceCenterDepartmentTable.withId(provinceCenterDepartmentId),options);
	}
	
	protected ProvinceCenterDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String provinceCenterDepartmentId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ProvinceCenterDepartment newProvinceCenterDepartment = loadInternalProvinceCenterDepartment(accessKey, options);
		newProvinceCenterDepartment.setVersion(0);
		
		
 		
 		if(isSaveProvinceCenterEmployeeListEnabled(options)){
 			for(ProvinceCenterEmployee item: newProvinceCenterDepartment.getProvinceCenterEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalProvinceCenterDepartment(newProvinceCenterDepartment,options);
		
		return newProvinceCenterDepartment;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String provinceCenterDepartmentId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{provinceCenterDepartmentId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ProvinceCenterDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProvinceCenterDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + provinceCenterDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String provinceCenterDepartmentId, int version) throws Exception{
	
		String methodName="delete(String provinceCenterDepartmentId, int version)";
		assertMethodArgumentNotNull(provinceCenterDepartmentId, methodName, "provinceCenterDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{provinceCenterDepartmentId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(provinceCenterDepartmentId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","founded","province_center","manager"};
		return ProvinceCenterDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "province_center_department";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProvinceCenterDepartmentTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractProvinceCenterEnabled = true;
 	//private static final String PROVINCECENTER = "provinceCenter";
 	protected boolean isExtractProvinceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProvinceCenterDepartmentTokens.PROVINCECENTER);
 	}
 	
 	
 	//private boolean saveProvinceCenterEnabled = true;
 	protected boolean isSaveProvinceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProvinceCenterDepartmentTokens.PROVINCECENTER);
 	}
 	

 	
 
		
	//protected static final String PROVINCE_CENTER_EMPLOYEE_LIST = "provinceCenterEmployeeList";
	
	protected boolean isExtractProvinceCenterEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ProvinceCenterDepartmentTokens.PROVINCE_CENTER_EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveProvinceCenterEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, ProvinceCenterDepartmentTokens.PROVINCE_CENTER_EMPLOYEE_LIST);
		
 	}
 	
 	
			
		

	

	protected ProvinceCenterDepartmentMapper getProvinceCenterDepartmentMapper(){
		return new ProvinceCenterDepartmentMapper();
	}
	protected ProvinceCenterDepartment extractProvinceCenterDepartment(String provinceCenterDepartmentId) throws Exception{
		String SQL = "select * from province_center_department_data where id = ?";	
		try{
		
			ProvinceCenterDepartment provinceCenterDepartment = queryForObject(SQL, new Object[]{provinceCenterDepartmentId}, getProvinceCenterDepartmentMapper());
			return provinceCenterDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new ProvinceCenterDepartmentNotFoundException("ProvinceCenterDepartment("+provinceCenterDepartmentId+") is not found!");
		}
		
		
	}
	protected ProvinceCenterDepartment extractProvinceCenterDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from province_center_department_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ProvinceCenterDepartment provinceCenterDepartment = queryForObject(SQL, new Object[]{accessKey.getValue()}, getProvinceCenterDepartmentMapper());
			return provinceCenterDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new ProvinceCenterDepartmentNotFoundException("ProvinceCenterDepartment("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ProvinceCenterDepartment loadInternalProvinceCenterDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ProvinceCenterDepartment provinceCenterDepartment = extractProvinceCenterDepartment(accessKey, loadOptions);
 	
 		if(isExtractProvinceCenterEnabled(loadOptions)){
	 		extractProvinceCenter(provinceCenterDepartment, loadOptions);
 		}
 
		
		if(isExtractProvinceCenterEmployeeListEnabled(loadOptions)){
	 		extractProvinceCenterEmployeeList(provinceCenterDepartment, loadOptions);
 		}		
		
		return provinceCenterDepartment;
		
	}



	
	
	 

 	protected ProvinceCenterDepartment extractProvinceCenter(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options) throws Exception{

		if(provinceCenterDepartment.getProvinceCenter() == null){
			return provinceCenterDepartment;
		}
		String provinceCenterId = provinceCenterDepartment.getProvinceCenter().getId();
		if( provinceCenterId == null){
			return provinceCenterDepartment;
		}
		RetailStoreProvinceCenter provinceCenter = getRetailStoreProvinceCenterDAO().load(provinceCenterId,options);
		if(provinceCenter != null){
			provinceCenterDepartment.setProvinceCenter(provinceCenter);
		}
		
 		
 		return provinceCenterDepartment;
 	}
 		
 
		
	protected ProvinceCenterDepartment extractProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
		
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeByDepartment(provinceCenterDepartment.getId(),options);
		if(provinceCenterEmployeeList != null){
			provinceCenterDepartment.setProvinceCenterEmployeeList(provinceCenterEmployeeList);
		}
		
		return provinceCenterDepartment;
	
	}	
		
		
  	
 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where province_center = ?";
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = queryForList(SQL, new Object[]{retailStoreProvinceCenterId}, getProvinceCenterDepartmentMapper());	
 		return provinceCenterDepartmentList;
 	}
 	
 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where province_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = queryForList(SQL, new Object[]{retailStoreProvinceCenterId,start, count}, getProvinceCenterDepartmentMapper());
		
 		return provinceCenterDepartmentList;
 	}
 	
 	public int countProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where province_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreProvinceCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ProvinceCenterDepartment saveProvinceCenterDepartment(ProvinceCenterDepartment  provinceCenterDepartment){
	
		String SQL=this.getSaveProvinceCenterDepartmentSQL(provinceCenterDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProvinceCenterDepartmentParameters(provinceCenterDepartment);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		provinceCenterDepartment.incVersion();
		return provinceCenterDepartment;
	
	}
	public SmartList<ProvinceCenterDepartment> saveProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProvinceCenterDepartmentList(provinceCenterDepartmentList);
		
		batchProvinceCenterDepartmentCreate((List<ProvinceCenterDepartment>)lists[CREATE_LIST_INDEX]);
		
		batchProvinceCenterDepartmentUpdate((List<ProvinceCenterDepartment>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList){
			if(provinceCenterDepartment.isChanged()){
				provinceCenterDepartment.incVersion();
			}
			
		
		}
		
		
		return provinceCenterDepartmentList;
	}

	public SmartList<ProvinceCenterDepartment> removeProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options){
		
		
		super.removeList(provinceCenterDepartmentList, options);
		
		return provinceCenterDepartmentList;
		
		
	}
	
	protected List<Object[]> prepareProvinceCenterDepartmentBatchCreateArgs(List<ProvinceCenterDepartment> provinceCenterDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList ){
			Object [] parameters = prepareProvinceCenterDepartmentCreateParameters(provinceCenterDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProvinceCenterDepartmentBatchUpdateArgs(List<ProvinceCenterDepartment> provinceCenterDepartmentList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList ){
			if(!provinceCenterDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareProvinceCenterDepartmentUpdateParameters(provinceCenterDepartment);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProvinceCenterDepartmentCreate(List<ProvinceCenterDepartment> provinceCenterDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProvinceCenterDepartmentBatchCreateArgs(provinceCenterDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProvinceCenterDepartmentUpdate(List<ProvinceCenterDepartment> provinceCenterDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProvinceCenterDepartmentBatchUpdateArgs(provinceCenterDepartmentList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProvinceCenterDepartmentList(List<ProvinceCenterDepartment> provinceCenterDepartmentList){
		
		List<ProvinceCenterDepartment> provinceCenterDepartmentCreateList=new ArrayList<ProvinceCenterDepartment>();
		List<ProvinceCenterDepartment> provinceCenterDepartmentUpdateList=new ArrayList<ProvinceCenterDepartment>();
		
		for(ProvinceCenterDepartment provinceCenterDepartment: provinceCenterDepartmentList){
			if(isUpdateRequest(provinceCenterDepartment)){
				provinceCenterDepartmentUpdateList.add( provinceCenterDepartment);
				continue;
			}
			provinceCenterDepartmentCreateList.add(provinceCenterDepartment);
		}
		
		return new Object[]{provinceCenterDepartmentCreateList,provinceCenterDepartmentUpdateList};
	}
	
	protected boolean isUpdateRequest(ProvinceCenterDepartment provinceCenterDepartment){
 		return provinceCenterDepartment.getVersion() > 0;
 	}
 	protected String getSaveProvinceCenterDepartmentSQL(ProvinceCenterDepartment provinceCenterDepartment){
 		if(isUpdateRequest(provinceCenterDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProvinceCenterDepartmentParameters(ProvinceCenterDepartment provinceCenterDepartment){
 		if(isUpdateRequest(provinceCenterDepartment) ){
 			return prepareProvinceCenterDepartmentUpdateParameters(provinceCenterDepartment);
 		}
 		return prepareProvinceCenterDepartmentCreateParameters(provinceCenterDepartment);
 	}
 	protected Object[] prepareProvinceCenterDepartmentUpdateParameters(ProvinceCenterDepartment provinceCenterDepartment){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = provinceCenterDepartment.getName();
 		parameters[1] = provinceCenterDepartment.getFounded(); 	
 		if(provinceCenterDepartment.getProvinceCenter() != null){
 			parameters[2] = provinceCenterDepartment.getProvinceCenter().getId();
 		}
 
 		parameters[3] = provinceCenterDepartment.getManager();		
 		parameters[4] = provinceCenterDepartment.getId();
 		parameters[5] = provinceCenterDepartment.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProvinceCenterDepartmentCreateParameters(ProvinceCenterDepartment provinceCenterDepartment){
		Object[] parameters = new Object[5];
		String newProvinceCenterDepartmentId=getNextId();
		provinceCenterDepartment.setId(newProvinceCenterDepartmentId);
		parameters[0] =  provinceCenterDepartment.getId();
 
 		parameters[1] = provinceCenterDepartment.getName();
 		parameters[2] = provinceCenterDepartment.getFounded(); 	
 		if(provinceCenterDepartment.getProvinceCenter() != null){
 			parameters[3] = provinceCenterDepartment.getProvinceCenter().getId();
 		
 		}
 		
 		parameters[4] = provinceCenterDepartment.getManager();		
 				
 		return parameters;
 	}
 	
	protected ProvinceCenterDepartment saveInternalProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
		
		saveProvinceCenterDepartment(provinceCenterDepartment);
 	
 		if(isSaveProvinceCenterEnabled(options)){
	 		saveProvinceCenter(provinceCenterDepartment, options);
 		}
 
		
		if(isSaveProvinceCenterEmployeeListEnabled(options)){
	 		saveProvinceCenterEmployeeList(provinceCenterDepartment, options);
	 		removeProvinceCenterEmployeeList(provinceCenterDepartment, options);
	 		
 		}		
		
		return provinceCenterDepartment;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ProvinceCenterDepartment saveProvinceCenter(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(provinceCenterDepartment.getProvinceCenter() == null){
 			return provinceCenterDepartment;//do nothing when it is null
 		}
 		
 		getRetailStoreProvinceCenterDAO().save(provinceCenterDepartment.getProvinceCenter(),options);
 		return provinceCenterDepartment;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected ProvinceCenterDepartment saveProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			return provinceCenterDepartment;
		}
		if(provinceCenterEmployeeList.isEmpty()){
			return provinceCenterDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getProvinceCenterEmployeeDAO().saveProvinceCenterEmployeeList(provinceCenterEmployeeList,options);
		
		return provinceCenterDepartment;
	
	}
	
	protected ProvinceCenterDepartment removeProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
	
	
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			return provinceCenterDepartment;
		}	
	
		SmartList<ProvinceCenterEmployee> toRemoveProvinceCenterEmployeeList = provinceCenterEmployeeList.getToRemoveList();
		
		if(toRemoveProvinceCenterEmployeeList == null){
			return provinceCenterDepartment;
		}
		if(toRemoveProvinceCenterEmployeeList.isEmpty()){
			return provinceCenterDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProvinceCenterEmployeeDAO().removeProvinceCenterEmployeeList(toRemoveProvinceCenterEmployeeList,options);
		
		return provinceCenterDepartment;
	
	}
	
	
	
 	
 	
	
	
	
		

	public ProvinceCenterDepartment present(ProvinceCenterDepartment provinceCenterDepartment,Map<String, Object> options){
	
		presentProvinceCenterEmployeeList(provinceCenterDepartment,options);

		return provinceCenterDepartment;
	
	}
		
	
  	
 	protected ProvinceCenterDepartment presentProvinceCenterEmployeeList(
			ProvinceCenterDepartment provinceCenterDepartment,
			Map<String, Object> options) {

		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();		
		if(provinceCenterEmployeeList == null){
			return provinceCenterDepartment;			
		}
		
		String targetObjectName = "provinceCenterEmployee";
		int provinceCenterEmployeeListSize = provinceCenterEmployeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(provinceCenterEmployeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return provinceCenterDepartment;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = provinceCenterEmployeeListSize;
		if(provinceCenterEmployeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getProvinceCenterEmployeeDAO().countProvinceCenterEmployeeByDepartment(provinceCenterDepartment.getId(), options);			
		}
		//provinceCenterDepartment.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//provinceCenterDepartment.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(provinceCenterEmployeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(provinceCenterEmployeeListSize,currentPage,rowsPerPage) ;
			provinceCenterEmployeeList = provinceCenterEmployeeList.subListOf(fromIndex, toIndex);
			provinceCenterEmployeeList.setTotalCount(count);
			provinceCenterEmployeeList.setCurrentPageNumber(currentPage);			
			provinceCenterDepartment.setProvinceCenterEmployeeList(provinceCenterEmployeeList);
			return provinceCenterDepartment;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		provinceCenterEmployeeList 
			= getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeByDepartment(provinceCenterDepartment.getId(),start, rowsPerPage, options );
		provinceCenterEmployeeList.setTotalCount(count);
		provinceCenterEmployeeList.setCurrentPageNumber(currentPage);
		provinceCenterDepartment.setProvinceCenterEmployeeList(provinceCenterEmployeeList );	

		return provinceCenterDepartment;
	}			
		


	protected String getTableName(){
		return ProvinceCenterDepartmentTable.TABLE_NAME;
	}
}


