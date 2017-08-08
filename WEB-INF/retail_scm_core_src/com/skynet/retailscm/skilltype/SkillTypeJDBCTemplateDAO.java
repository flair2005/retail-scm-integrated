
package com.skynet.retailscm.skilltype;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeskill.EmployeeSkill;

import com.skynet.retailscm.employeeskill.EmployeeSkillDAO;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.employeeskill.EmployeeSkillTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SkillTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SkillTypeDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  EmployeeSkillDAO  employeeSkillDAO;
 	public void setEmployeeSkillDAO(EmployeeSkillDAO pEmployeeSkillDAO){
 	
 		if(pEmployeeSkillDAO == null){
 			throw new IllegalStateException("Do not try to set employeeSkillDAO to null.");
 		}
	 	this.employeeSkillDAO = pEmployeeSkillDAO;
 	}
 	public EmployeeSkillDAO getEmployeeSkillDAO(){
 		if(this.employeeSkillDAO == null){
 			throw new IllegalStateException("The employeeSkillDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeSkillDAO;
 	}	
 	
			
		

	
	/*
	protected SkillType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSkillType(accessKey, options);
	}
	*/
	public SkillType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSkillType(SkillTypeTable.withId(id), options);
	}
	
	
	
	public SkillType save(SkillType skillType,Map<String,Object> options){
		
		String methodName="save(SkillType skillType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(skillType, methodName, "skillType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSkillType(skillType,options);
	}
	public SkillType clone(String skillTypeId, Map<String,Object> options) throws Exception{
	
		return clone(SkillTypeTable.withId(skillTypeId),options);
	}
	
	protected SkillType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String skillTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SkillType newSkillType = loadInternalSkillType(accessKey, options);
		newSkillType.setVersion(0);
		
		
 		
 		if(isSaveEmployeeSkillListEnabled(options)){
 			for(EmployeeSkill item: newSkillType.getEmployeeSkillList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSkillType(newSkillType,options);
		
		return newSkillType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String skillTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{skillTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SkillTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SkillTypeNotFoundException(
					"The " + this.getTableName() + "(" + skillTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String skillTypeId, int version) throws Exception{
	
		String methodName="delete(String skillTypeId, int version)";
		assertMethodArgumentNotNull(skillTypeId, methodName, "skillTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{skillTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(skillTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","description"};
		return SkillTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "skill_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SkillTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SkillTypeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SkillTypeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String EMPLOYEE_SKILL_LIST = "employeeSkillList";
	
	protected boolean isExtractEmployeeSkillListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SkillTypeTokens.EMPLOYEE_SKILL_LIST);
		
 	}

	protected boolean isSaveEmployeeSkillListEnabled(Map<String,Object> options){
		return checkOptions(options, SkillTypeTokens.EMPLOYEE_SKILL_LIST);
		
 	}
 	
 	
			
		

	

	protected SkillTypeMapper getSkillTypeMapper(){
		return new SkillTypeMapper();
	}
	protected SkillType extractSkillType(String skillTypeId) throws Exception{
		String SQL = "select * from skill_type_data where id = ?";	
		try{
		
			SkillType skillType = queryForObject(SQL, new Object[]{skillTypeId}, getSkillTypeMapper());
			return skillType;
		}catch(EmptyResultDataAccessException e){
			throw new SkillTypeNotFoundException("SkillType("+skillTypeId+") is not found!");
		}
		
		
	}
	protected SkillType extractSkillType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from skill_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SkillType skillType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSkillTypeMapper());
			return skillType;
		}catch(EmptyResultDataAccessException e){
			throw new SkillTypeNotFoundException("SkillType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SkillType loadInternalSkillType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SkillType skillType = extractSkillType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(skillType, loadOptions);
 		}
 
		
		if(isExtractEmployeeSkillListEnabled(loadOptions)){
	 		extractEmployeeSkillList(skillType, loadOptions);
 		}		
		
		return skillType;
		
	}



	
	
	 

 	protected SkillType extractCompany(SkillType skillType, Map<String,Object> options) throws Exception{

		if(skillType.getCompany() == null){
			return skillType;
		}
		String companyId = skillType.getCompany().getId();
		if( companyId == null){
			return skillType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			skillType.setCompany(company);
		}
		
 		
 		return skillType;
 	}
 		
 
		
	protected SkillType extractEmployeeSkillList(SkillType skillType, Map<String,Object> options){
		
		SmartList<EmployeeSkill> employeeSkillList = getEmployeeSkillDAO().findEmployeeSkillBySkillType(skillType.getId(),options);
		if(employeeSkillList != null){
			skillType.setEmployeeSkillList(employeeSkillList);
		}
		
		return skillType;
	
	}	
		
		
  	
 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<SkillType> skillTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getSkillTypeMapper());	
 		return skillTypeList;
 	}
 	
 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SkillType> skillTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getSkillTypeMapper());
		
 		return skillTypeList;
 	}
 	
 	public int countSkillTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SkillType saveSkillType(SkillType  skillType){
	
		String SQL=this.getSaveSkillTypeSQL(skillType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSkillTypeParameters(skillType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		skillType.incVersion();
		return skillType;
	
	}
	public SmartList<SkillType> saveSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSkillTypeList(skillTypeList);
		
		batchSkillTypeCreate((List<SkillType>)lists[CREATE_LIST_INDEX]);
		
		batchSkillTypeUpdate((List<SkillType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SkillType skillType:skillTypeList){
			if(skillType.isChanged()){
				skillType.incVersion();
			}
			
		
		}
		
		
		return skillTypeList;
	}

	public SmartList<SkillType> removeSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options){
		
		
		super.removeList(skillTypeList, options);
		
		return skillTypeList;
		
		
	}
	
	protected List<Object[]> prepareSkillTypeBatchCreateArgs(List<SkillType> skillTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SkillType skillType:skillTypeList ){
			Object [] parameters = prepareSkillTypeCreateParameters(skillType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSkillTypeBatchUpdateArgs(List<SkillType> skillTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SkillType skillType:skillTypeList ){
			if(!skillType.isChanged()){
				continue;
			}
			Object [] parameters = prepareSkillTypeUpdateParameters(skillType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSkillTypeCreate(List<SkillType> skillTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSkillTypeBatchCreateArgs(skillTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSkillTypeUpdate(List<SkillType> skillTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSkillTypeBatchUpdateArgs(skillTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSkillTypeList(List<SkillType> skillTypeList){
		
		List<SkillType> skillTypeCreateList=new ArrayList<SkillType>();
		List<SkillType> skillTypeUpdateList=new ArrayList<SkillType>();
		
		for(SkillType skillType: skillTypeList){
			if(isUpdateRequest(skillType)){
				skillTypeUpdateList.add( skillType);
				continue;
			}
			skillTypeCreateList.add(skillType);
		}
		
		return new Object[]{skillTypeCreateList,skillTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(SkillType skillType){
 		return skillType.getVersion() > 0;
 	}
 	protected String getSaveSkillTypeSQL(SkillType skillType){
 		if(isUpdateRequest(skillType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSkillTypeParameters(SkillType skillType){
 		if(isUpdateRequest(skillType) ){
 			return prepareSkillTypeUpdateParameters(skillType);
 		}
 		return prepareSkillTypeCreateParameters(skillType);
 	}
 	protected Object[] prepareSkillTypeUpdateParameters(SkillType skillType){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = skillType.getCode(); 	
 		if(skillType.getCompany() != null){
 			parameters[1] = skillType.getCompany().getId();
 		}
 
 		parameters[2] = skillType.getDescription();		
 		parameters[3] = skillType.getId();
 		parameters[4] = skillType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSkillTypeCreateParameters(SkillType skillType){
		Object[] parameters = new Object[4];
		String newSkillTypeId=getNextId();
		skillType.setId(newSkillTypeId);
		parameters[0] =  skillType.getId();
 
 		parameters[1] = skillType.getCode(); 	
 		if(skillType.getCompany() != null){
 			parameters[2] = skillType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = skillType.getDescription();		
 				
 		return parameters;
 	}
 	
	protected SkillType saveInternalSkillType(SkillType skillType, Map<String,Object> options){
		
		saveSkillType(skillType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(skillType, options);
 		}
 
		
		if(isSaveEmployeeSkillListEnabled(options)){
	 		saveEmployeeSkillList(skillType, options);
	 		removeEmployeeSkillList(skillType, options);
	 		
 		}		
		
		return skillType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SkillType saveCompany(SkillType skillType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(skillType.getCompany() == null){
 			return skillType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(skillType.getCompany(),options);
 		return skillType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected SkillType saveEmployeeSkillList(SkillType skillType, Map<String,Object> options){
		SmartList<EmployeeSkill> employeeSkillList = skillType.getEmployeeSkillList();
		if(employeeSkillList == null){
			return skillType;
		}
		if(employeeSkillList.isEmpty()){
			return skillType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeSkillDAO().saveEmployeeSkillList(employeeSkillList,options);
		
		return skillType;
	
	}
	
	protected SkillType removeEmployeeSkillList(SkillType skillType, Map<String,Object> options){
	
	
		SmartList<EmployeeSkill> employeeSkillList = skillType.getEmployeeSkillList();
		if(employeeSkillList == null){
			return skillType;
		}	
	
		SmartList<EmployeeSkill> toRemoveEmployeeSkillList = employeeSkillList.getToRemoveList();
		
		if(toRemoveEmployeeSkillList == null){
			return skillType;
		}
		if(toRemoveEmployeeSkillList.isEmpty()){
			return skillType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeSkillDAO().removeEmployeeSkillList(toRemoveEmployeeSkillList,options);
		
		return skillType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SkillType present(SkillType skillType,Map<String, Object> options){
	
		presentEmployeeSkillList(skillType,options);

		return skillType;
	
	}
		
	
  	
 	protected SkillType presentEmployeeSkillList(
			SkillType skillType,
			Map<String, Object> options) {

		SmartList<EmployeeSkill> employeeSkillList = skillType.getEmployeeSkillList();		
		if(employeeSkillList == null){
			return skillType;			
		}
		
		String targetObjectName = "employeeSkill";
		int employeeSkillListSize = employeeSkillList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeSkillListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return skillType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeSkillListSize;
		if(employeeSkillListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeSkillDAO().countEmployeeSkillBySkillType(skillType.getId(), options);			
		}
		//skillType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//skillType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeSkillListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeSkillListSize,currentPage,rowsPerPage) ;
			employeeSkillList = employeeSkillList.subListOf(fromIndex, toIndex);
			employeeSkillList.setTotalCount(count);
			employeeSkillList.setCurrentPageNumber(currentPage);			
			skillType.setEmployeeSkillList(employeeSkillList);
			return skillType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeSkillList 
			= getEmployeeSkillDAO().findEmployeeSkillBySkillType(skillType.getId(),start, rowsPerPage, options );
		employeeSkillList.setTotalCount(count);
		employeeSkillList.setCurrentPageNumber(currentPage);
		skillType.setEmployeeSkillList(employeeSkillList );	

		return skillType;
	}			
		


	protected String getTableName(){
		return SkillTypeTable.TABLE_NAME;
	}
}


