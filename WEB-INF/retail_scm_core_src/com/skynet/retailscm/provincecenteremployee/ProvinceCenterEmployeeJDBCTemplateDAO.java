
package com.skynet.retailscm.provincecenteremployee;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;

import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartmentTable;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ProvinceCenterEmployeeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ProvinceCenterEmployeeDAO{
 
 	
 	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
	 	return this.retailStoreProvinceCenterDAO;
 	}
 
 	
 	private  ProvinceCenterDepartmentDAO  provinceCenterDepartmentDAO;
 	public void setProvinceCenterDepartmentDAO(ProvinceCenterDepartmentDAO provinceCenterDepartmentDAO){
	 	this.provinceCenterDepartmentDAO = provinceCenterDepartmentDAO;
 	}
 	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO(){
	 	return this.provinceCenterDepartmentDAO;
 	}

		

	
	/*
	protected ProvinceCenterEmployee load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterEmployee(accessKey, options);
	}
	*/
	public ProvinceCenterEmployee load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterEmployee(ProvinceCenterEmployeeTable.withId(id), options);
	}
	
	
	
	public ProvinceCenterEmployee save(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options){
		
		String methodName="save(ProvinceCenterEmployee provinceCenterEmployee,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(provinceCenterEmployee, methodName, "provinceCenterEmployee");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalProvinceCenterEmployee(provinceCenterEmployee,options);
	}
	public ProvinceCenterEmployee clone(String provinceCenterEmployeeId, Map<String,Object> options) throws Exception{
	
		return clone(ProvinceCenterEmployeeTable.withId(provinceCenterEmployeeId),options);
	}
	
	protected ProvinceCenterEmployee clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String provinceCenterEmployeeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ProvinceCenterEmployee newProvinceCenterEmployee = loadInternalProvinceCenterEmployee(accessKey, options);
		newProvinceCenterEmployee.setVersion(0);
		
		

		
		saveInternalProvinceCenterEmployee(newProvinceCenterEmployee,options);
		
		return newProvinceCenterEmployee;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String provinceCenterEmployeeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{provinceCenterEmployeeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ProvinceCenterEmployeeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProvinceCenterEmployeeNotFoundException(
					"The " + this.getTableName() + "(" + provinceCenterEmployeeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String provinceCenterEmployeeId, int version) throws Exception{
	
		String methodName="delete(String provinceCenterEmployeeId, int version)";
		assertMethodArgumentNotNull(provinceCenterEmployeeId, methodName, "provinceCenterEmployeeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{provinceCenterEmployeeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(provinceCenterEmployeeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","mobile","email","founded","department","province_center"};
		return ProvinceCenterEmployeeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "province_center_employee";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ProvinceCenterEmployeeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractDepartmentEnabled = true;
 	//private static final String DEPARTMENT = "department";
 	protected boolean isExtractDepartmentEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProvinceCenterEmployeeTokens.DEPARTMENT);
 	}
 	
 	
 	//private boolean saveDepartmentEnabled = true;
 	protected boolean isSaveDepartmentEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProvinceCenterEmployeeTokens.DEPARTMENT);
 	}
 	

 	
  
 	//private boolean extractProvinceCenterEnabled = true;
 	//private static final String PROVINCECENTER = "provinceCenter";
 	protected boolean isExtractProvinceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ProvinceCenterEmployeeTokens.PROVINCECENTER);
 	}
 	
 	
 	//private boolean saveProvinceCenterEnabled = true;
 	protected boolean isSaveProvinceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ProvinceCenterEmployeeTokens.PROVINCECENTER);
 	}
 	

 	
 
		

	

	protected ProvinceCenterEmployeeMapper getProvinceCenterEmployeeMapper(){
		return new ProvinceCenterEmployeeMapper();
	}
	protected ProvinceCenterEmployee extractProvinceCenterEmployee(String provinceCenterEmployeeId) throws Exception{
		String SQL = "select * from province_center_employee_data where id = ?";	
		try{
		
			ProvinceCenterEmployee provinceCenterEmployee = queryForObject(SQL, new Object[]{provinceCenterEmployeeId}, getProvinceCenterEmployeeMapper());
			return provinceCenterEmployee;
		}catch(EmptyResultDataAccessException e){
			throw new ProvinceCenterEmployeeNotFoundException("ProvinceCenterEmployee("+provinceCenterEmployeeId+") is not found!");
		}
		
		
	}
	protected ProvinceCenterEmployee extractProvinceCenterEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from province_center_employee_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ProvinceCenterEmployee provinceCenterEmployee = queryForObject(SQL, new Object[]{accessKey.getValue()}, getProvinceCenterEmployeeMapper());
			return provinceCenterEmployee;
		}catch(EmptyResultDataAccessException e){
			throw new ProvinceCenterEmployeeNotFoundException("ProvinceCenterEmployee("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ProvinceCenterEmployee loadInternalProvinceCenterEmployee(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ProvinceCenterEmployee provinceCenterEmployee = extractProvinceCenterEmployee(accessKey, loadOptions);
 	
 		if(isExtractDepartmentEnabled(loadOptions)){
	 		extractDepartment(provinceCenterEmployee, loadOptions);
 		}
  	
 		if(isExtractProvinceCenterEnabled(loadOptions)){
	 		extractProvinceCenter(provinceCenterEmployee, loadOptions);
 		}
 
		
		return provinceCenterEmployee;
		
	}



	
	
	 

 	protected ProvinceCenterEmployee extractDepartment(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options) throws Exception{

		if(provinceCenterEmployee.getDepartment() == null){
			return provinceCenterEmployee;
		}
		String departmentId = provinceCenterEmployee.getDepartment().getId();
		if( departmentId == null){
			return provinceCenterEmployee;
		}
		ProvinceCenterDepartment department = getProvinceCenterDepartmentDAO().load(departmentId,options);
		if(department != null){
			provinceCenterEmployee.setDepartment(department);
		}
		
 		
 		return provinceCenterEmployee;
 	}
 		
  

 	protected ProvinceCenterEmployee extractProvinceCenter(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options) throws Exception{

		if(provinceCenterEmployee.getProvinceCenter() == null){
			return provinceCenterEmployee;
		}
		String provinceCenterId = provinceCenterEmployee.getProvinceCenter().getId();
		if( provinceCenterId == null){
			return provinceCenterEmployee;
		}
		RetailStoreProvinceCenter provinceCenter = getRetailStoreProvinceCenterDAO().load(provinceCenterId,options);
		if(provinceCenter != null){
			provinceCenterEmployee.setProvinceCenter(provinceCenter);
		}
		
 		
 		return provinceCenterEmployee;
 	}
 		
 
		
		
  	
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where department = ?";
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = queryForList(SQL, new Object[]{provinceCenterDepartmentId}, getProvinceCenterEmployeeMapper());	
 		return provinceCenterEmployeeList;
 	}
 	
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where department = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = queryForList(SQL, new Object[]{provinceCenterDepartmentId,start, count}, getProvinceCenterEmployeeMapper());
		
 		return provinceCenterEmployeeList;
 	}
 	
 	public int countProvinceCenterEmployeeByDepartment(String provinceCenterDepartmentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where department = ?";
		Integer count = queryInt(SQL, new Object[]{provinceCenterDepartmentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where province_center = ?";
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = queryForList(SQL, new Object[]{retailStoreProvinceCenterId}, getProvinceCenterEmployeeMapper());	
 		return provinceCenterEmployeeList;
 	}
 	
 	public SmartList<ProvinceCenterEmployee> findProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where province_center = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = queryForList(SQL, new Object[]{retailStoreProvinceCenterId,start, count}, getProvinceCenterEmployeeMapper());
		
 		return provinceCenterEmployeeList;
 	}
 	
 	public int countProvinceCenterEmployeeByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where province_center = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreProvinceCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ProvinceCenterEmployee saveProvinceCenterEmployee(ProvinceCenterEmployee  provinceCenterEmployee){
	
		String SQL=this.getSaveProvinceCenterEmployeeSQL(provinceCenterEmployee);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProvinceCenterEmployeeParameters(provinceCenterEmployee);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		provinceCenterEmployee.incVersion();
		return provinceCenterEmployee;
	
	}
	public SmartList<ProvinceCenterEmployee> saveProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProvinceCenterEmployeeList(provinceCenterEmployeeList);
		
		batchProvinceCenterEmployeeCreate((List<ProvinceCenterEmployee>)lists[CREATE_LIST_INDEX]);
		
		batchProvinceCenterEmployeeUpdate((List<ProvinceCenterEmployee>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			if(provinceCenterEmployee.isChanged()){
				provinceCenterEmployee.incVersion();
			}
			
		
		}
		
		
		return provinceCenterEmployeeList;
	}

	public SmartList<ProvinceCenterEmployee> removeProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options){
		
		
		super.removeList(provinceCenterEmployeeList, options);
		
		return provinceCenterEmployeeList;
		
		
	}
	
	protected List<Object[]> prepareProvinceCenterEmployeeBatchCreateArgs(List<ProvinceCenterEmployee> provinceCenterEmployeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList ){
			Object [] parameters = prepareProvinceCenterEmployeeCreateParameters(provinceCenterEmployee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareProvinceCenterEmployeeBatchUpdateArgs(List<ProvinceCenterEmployee> provinceCenterEmployeeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList ){
			if(!provinceCenterEmployee.isChanged()){
				continue;
			}
			Object [] parameters = prepareProvinceCenterEmployeeUpdateParameters(provinceCenterEmployee);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchProvinceCenterEmployeeCreate(List<ProvinceCenterEmployee> provinceCenterEmployeeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProvinceCenterEmployeeBatchCreateArgs(provinceCenterEmployeeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchProvinceCenterEmployeeUpdate(List<ProvinceCenterEmployee> provinceCenterEmployeeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProvinceCenterEmployeeBatchUpdateArgs(provinceCenterEmployeeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitProvinceCenterEmployeeList(List<ProvinceCenterEmployee> provinceCenterEmployeeList){
		
		List<ProvinceCenterEmployee> provinceCenterEmployeeCreateList=new ArrayList<ProvinceCenterEmployee>();
		List<ProvinceCenterEmployee> provinceCenterEmployeeUpdateList=new ArrayList<ProvinceCenterEmployee>();
		
		for(ProvinceCenterEmployee provinceCenterEmployee: provinceCenterEmployeeList){
			if(isUpdateRequest(provinceCenterEmployee)){
				provinceCenterEmployeeUpdateList.add( provinceCenterEmployee);
				continue;
			}
			provinceCenterEmployeeCreateList.add(provinceCenterEmployee);
		}
		
		return new Object[]{provinceCenterEmployeeCreateList,provinceCenterEmployeeUpdateList};
	}
	
	protected boolean isUpdateRequest(ProvinceCenterEmployee provinceCenterEmployee){
 		return provinceCenterEmployee.getVersion() > 0;
 	}
 	protected String getSaveProvinceCenterEmployeeSQL(ProvinceCenterEmployee provinceCenterEmployee){
 		if(isUpdateRequest(provinceCenterEmployee)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveProvinceCenterEmployeeParameters(ProvinceCenterEmployee provinceCenterEmployee){
 		if(isUpdateRequest(provinceCenterEmployee) ){
 			return prepareProvinceCenterEmployeeUpdateParameters(provinceCenterEmployee);
 		}
 		return prepareProvinceCenterEmployeeCreateParameters(provinceCenterEmployee);
 	}
 	protected Object[] prepareProvinceCenterEmployeeUpdateParameters(ProvinceCenterEmployee provinceCenterEmployee){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = provinceCenterEmployee.getName();
 		parameters[1] = provinceCenterEmployee.getMobile();
 		parameters[2] = provinceCenterEmployee.getEmail();
 		parameters[3] = provinceCenterEmployee.getFounded(); 	
 		if(provinceCenterEmployee.getDepartment() != null){
 			parameters[4] = provinceCenterEmployee.getDepartment().getId();
 		}
  	
 		if(provinceCenterEmployee.getProvinceCenter() != null){
 			parameters[5] = provinceCenterEmployee.getProvinceCenter().getId();
 		}
 		
 		parameters[6] = provinceCenterEmployee.getId();
 		parameters[7] = provinceCenterEmployee.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareProvinceCenterEmployeeCreateParameters(ProvinceCenterEmployee provinceCenterEmployee){
		Object[] parameters = new Object[7];
		String newProvinceCenterEmployeeId=getNextId();
		provinceCenterEmployee.setId(newProvinceCenterEmployeeId);
		parameters[0] =  provinceCenterEmployee.getId();
 
 		parameters[1] = provinceCenterEmployee.getName();
 		parameters[2] = provinceCenterEmployee.getMobile();
 		parameters[3] = provinceCenterEmployee.getEmail();
 		parameters[4] = provinceCenterEmployee.getFounded(); 	
 		if(provinceCenterEmployee.getDepartment() != null){
 			parameters[5] = provinceCenterEmployee.getDepartment().getId();
 		
 		}
 		 	
 		if(provinceCenterEmployee.getProvinceCenter() != null){
 			parameters[6] = provinceCenterEmployee.getProvinceCenter().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ProvinceCenterEmployee saveInternalProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options){
		
		saveProvinceCenterEmployee(provinceCenterEmployee);
 	
 		if(isSaveDepartmentEnabled(options)){
	 		saveDepartment(provinceCenterEmployee, options);
 		}
  	
 		if(isSaveProvinceCenterEnabled(options)){
	 		saveProvinceCenter(provinceCenterEmployee, options);
 		}
 
		
		return provinceCenterEmployee;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ProvinceCenterEmployee saveDepartment(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(provinceCenterEmployee.getDepartment() == null){
 			return provinceCenterEmployee;//do nothing when it is null
 		}
 		
 		getProvinceCenterDepartmentDAO().save(provinceCenterEmployee.getDepartment(),options);
 		return provinceCenterEmployee;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ProvinceCenterEmployee saveProvinceCenter(ProvinceCenterEmployee provinceCenterEmployee, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(provinceCenterEmployee.getProvinceCenter() == null){
 			return provinceCenterEmployee;//do nothing when it is null
 		}
 		
 		getRetailStoreProvinceCenterDAO().save(provinceCenterEmployee.getProvinceCenter(),options);
 		return provinceCenterEmployee;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public ProvinceCenterEmployee present(ProvinceCenterEmployee provinceCenterEmployee,Map<String, Object> options){
	

		return provinceCenterEmployee;
	
	}
		


	protected String getTableName(){
		return ProvinceCenterEmployeeTable.TABLE_NAME;
	}
}


