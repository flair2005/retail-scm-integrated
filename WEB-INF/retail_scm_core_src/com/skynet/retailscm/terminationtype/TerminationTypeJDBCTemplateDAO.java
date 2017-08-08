
package com.skynet.retailscm.terminationtype;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.termination.Termination;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.termination.TerminationDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.termination.TerminationTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class TerminationTypeJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TerminationTypeDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  TerminationDAO  terminationDAO;
 	public void setTerminationDAO(TerminationDAO pTerminationDAO){
 	
 		if(pTerminationDAO == null){
 			throw new IllegalStateException("Do not try to set terminationDAO to null.");
 		}
	 	this.terminationDAO = pTerminationDAO;
 	}
 	public TerminationDAO getTerminationDAO(){
 		if(this.terminationDAO == null){
 			throw new IllegalStateException("The terminationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.terminationDAO;
 	}	
 	
			
		

	
	/*
	protected TerminationType load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTerminationType(accessKey, options);
	}
	*/
	public TerminationType load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTerminationType(TerminationTypeTable.withId(id), options);
	}
	
	
	
	public TerminationType save(TerminationType terminationType,Map<String,Object> options){
		
		String methodName="save(TerminationType terminationType,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(terminationType, methodName, "terminationType");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTerminationType(terminationType,options);
	}
	public TerminationType clone(String terminationTypeId, Map<String,Object> options) throws Exception{
	
		return clone(TerminationTypeTable.withId(terminationTypeId),options);
	}
	
	protected TerminationType clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String terminationTypeId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TerminationType newTerminationType = loadInternalTerminationType(accessKey, options);
		newTerminationType.setVersion(0);
		
		
 		
 		if(isSaveTerminationListEnabled(options)){
 			for(Termination item: newTerminationType.getTerminationList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTerminationType(newTerminationType,options);
		
		return newTerminationType;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String terminationTypeId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{terminationTypeId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TerminationTypeVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TerminationTypeNotFoundException(
					"The " + this.getTableName() + "(" + terminationTypeId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String terminationTypeId, int version) throws Exception{
	
		String methodName="delete(String terminationTypeId, int version)";
		assertMethodArgumentNotNull(terminationTypeId, methodName, "terminationTypeId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{terminationTypeId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(terminationTypeId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","base_description","detail_description"};
		return TerminationTypeTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "termination_type";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TerminationTypeTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TerminationTypeTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TerminationTypeTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String TERMINATION_LIST = "terminationList";
	
	protected boolean isExtractTerminationListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TerminationTypeTokens.TERMINATION_LIST);
		
 	}

	protected boolean isSaveTerminationListEnabled(Map<String,Object> options){
		return checkOptions(options, TerminationTypeTokens.TERMINATION_LIST);
		
 	}
 	
 	
			
		

	

	protected TerminationTypeMapper getTerminationTypeMapper(){
		return new TerminationTypeMapper();
	}
	protected TerminationType extractTerminationType(String terminationTypeId) throws Exception{
		String SQL = "select * from termination_type_data where id = ?";	
		try{
		
			TerminationType terminationType = queryForObject(SQL, new Object[]{terminationTypeId}, getTerminationTypeMapper());
			return terminationType;
		}catch(EmptyResultDataAccessException e){
			throw new TerminationTypeNotFoundException("TerminationType("+terminationTypeId+") is not found!");
		}
		
		
	}
	protected TerminationType extractTerminationType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from termination_type_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TerminationType terminationType = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTerminationTypeMapper());
			return terminationType;
		}catch(EmptyResultDataAccessException e){
			throw new TerminationTypeNotFoundException("TerminationType("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TerminationType loadInternalTerminationType(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TerminationType terminationType = extractTerminationType(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(terminationType, loadOptions);
 		}
 
		
		if(isExtractTerminationListEnabled(loadOptions)){
	 		extractTerminationList(terminationType, loadOptions);
 		}		
		
		return terminationType;
		
	}



	
	
	 

 	protected TerminationType extractCompany(TerminationType terminationType, Map<String,Object> options) throws Exception{

		if(terminationType.getCompany() == null){
			return terminationType;
		}
		String companyId = terminationType.getCompany().getId();
		if( companyId == null){
			return terminationType;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			terminationType.setCompany(company);
		}
		
 		
 		return terminationType;
 	}
 		
 
		
	protected TerminationType extractTerminationList(TerminationType terminationType, Map<String,Object> options){
		
		SmartList<Termination> terminationList = getTerminationDAO().findTerminationByType(terminationType.getId(),options);
		if(terminationList != null){
			terminationType.setTerminationList(terminationList);
		}
		
		return terminationType;
	
	}	
		
		
  	
 	public SmartList<TerminationType> findTerminationTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<TerminationType> terminationTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getTerminationTypeMapper());	
 		return terminationTypeList;
 	}
 	
 	public SmartList<TerminationType> findTerminationTypeByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TerminationType> terminationTypeList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getTerminationTypeMapper());
		
 		return terminationTypeList;
 	}
 	
 	public int countTerminationTypeByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TerminationType saveTerminationType(TerminationType  terminationType){
	
		String SQL=this.getSaveTerminationTypeSQL(terminationType);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTerminationTypeParameters(terminationType);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		terminationType.incVersion();
		return terminationType;
	
	}
	public SmartList<TerminationType> saveTerminationTypeList(SmartList<TerminationType> terminationTypeList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTerminationTypeList(terminationTypeList);
		
		batchTerminationTypeCreate((List<TerminationType>)lists[CREATE_LIST_INDEX]);
		
		batchTerminationTypeUpdate((List<TerminationType>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TerminationType terminationType:terminationTypeList){
			if(terminationType.isChanged()){
				terminationType.incVersion();
			}
			
		
		}
		
		
		return terminationTypeList;
	}

	public SmartList<TerminationType> removeTerminationTypeList(SmartList<TerminationType> terminationTypeList,Map<String,Object> options){
		
		
		super.removeList(terminationTypeList, options);
		
		return terminationTypeList;
		
		
	}
	
	protected List<Object[]> prepareTerminationTypeBatchCreateArgs(List<TerminationType> terminationTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TerminationType terminationType:terminationTypeList ){
			Object [] parameters = prepareTerminationTypeCreateParameters(terminationType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTerminationTypeBatchUpdateArgs(List<TerminationType> terminationTypeList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TerminationType terminationType:terminationTypeList ){
			if(!terminationType.isChanged()){
				continue;
			}
			Object [] parameters = prepareTerminationTypeUpdateParameters(terminationType);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTerminationTypeCreate(List<TerminationType> terminationTypeList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTerminationTypeBatchCreateArgs(terminationTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTerminationTypeUpdate(List<TerminationType> terminationTypeList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTerminationTypeBatchUpdateArgs(terminationTypeList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTerminationTypeList(List<TerminationType> terminationTypeList){
		
		List<TerminationType> terminationTypeCreateList=new ArrayList<TerminationType>();
		List<TerminationType> terminationTypeUpdateList=new ArrayList<TerminationType>();
		
		for(TerminationType terminationType: terminationTypeList){
			if(isUpdateRequest(terminationType)){
				terminationTypeUpdateList.add( terminationType);
				continue;
			}
			terminationTypeCreateList.add(terminationType);
		}
		
		return new Object[]{terminationTypeCreateList,terminationTypeUpdateList};
	}
	
	protected boolean isUpdateRequest(TerminationType terminationType){
 		return terminationType.getVersion() > 0;
 	}
 	protected String getSaveTerminationTypeSQL(TerminationType terminationType){
 		if(isUpdateRequest(terminationType)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTerminationTypeParameters(TerminationType terminationType){
 		if(isUpdateRequest(terminationType) ){
 			return prepareTerminationTypeUpdateParameters(terminationType);
 		}
 		return prepareTerminationTypeCreateParameters(terminationType);
 	}
 	protected Object[] prepareTerminationTypeUpdateParameters(TerminationType terminationType){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = terminationType.getCode(); 	
 		if(terminationType.getCompany() != null){
 			parameters[1] = terminationType.getCompany().getId();
 		}
 
 		parameters[2] = terminationType.getBaseDescription();
 		parameters[3] = terminationType.getDetailDescription();		
 		parameters[4] = terminationType.getId();
 		parameters[5] = terminationType.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTerminationTypeCreateParameters(TerminationType terminationType){
		Object[] parameters = new Object[5];
		String newTerminationTypeId=getNextId();
		terminationType.setId(newTerminationTypeId);
		parameters[0] =  terminationType.getId();
 
 		parameters[1] = terminationType.getCode(); 	
 		if(terminationType.getCompany() != null){
 			parameters[2] = terminationType.getCompany().getId();
 		
 		}
 		
 		parameters[3] = terminationType.getBaseDescription();
 		parameters[4] = terminationType.getDetailDescription();		
 				
 		return parameters;
 	}
 	
	protected TerminationType saveInternalTerminationType(TerminationType terminationType, Map<String,Object> options){
		
		saveTerminationType(terminationType);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(terminationType, options);
 		}
 
		
		if(isSaveTerminationListEnabled(options)){
	 		saveTerminationList(terminationType, options);
	 		removeTerminationList(terminationType, options);
	 		
 		}		
		
		return terminationType;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TerminationType saveCompany(TerminationType terminationType, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(terminationType.getCompany() == null){
 			return terminationType;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(terminationType.getCompany(),options);
 		return terminationType;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected TerminationType saveTerminationList(TerminationType terminationType, Map<String,Object> options){
		SmartList<Termination> terminationList = terminationType.getTerminationList();
		if(terminationList == null){
			return terminationType;
		}
		if(terminationList.isEmpty()){
			return terminationType;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTerminationDAO().saveTerminationList(terminationList,options);
		
		return terminationType;
	
	}
	
	protected TerminationType removeTerminationList(TerminationType terminationType, Map<String,Object> options){
	
	
		SmartList<Termination> terminationList = terminationType.getTerminationList();
		if(terminationList == null){
			return terminationType;
		}	
	
		SmartList<Termination> toRemoveTerminationList = terminationList.getToRemoveList();
		
		if(toRemoveTerminationList == null){
			return terminationType;
		}
		if(toRemoveTerminationList.isEmpty()){
			return terminationType;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTerminationDAO().removeTerminationList(toRemoveTerminationList,options);
		
		return terminationType;
	
	}
	
	
	
 	
 	
	
	
	
		

	public TerminationType present(TerminationType terminationType,Map<String, Object> options){
	
		presentTerminationList(terminationType,options);

		return terminationType;
	
	}
		
	
  	
 	protected TerminationType presentTerminationList(
			TerminationType terminationType,
			Map<String, Object> options) {

		SmartList<Termination> terminationList = terminationType.getTerminationList();		
		if(terminationList == null){
			return terminationType;			
		}
		
		String targetObjectName = "termination";
		int terminationListSize = terminationList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(terminationListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return terminationType;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = terminationListSize;
		if(terminationListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTerminationDAO().countTerminationByType(terminationType.getId(), options);			
		}
		//terminationType.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//terminationType.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(terminationListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(terminationListSize,currentPage,rowsPerPage) ;
			terminationList = terminationList.subListOf(fromIndex, toIndex);
			terminationList.setTotalCount(count);
			terminationList.setCurrentPageNumber(currentPage);			
			terminationType.setTerminationList(terminationList);
			return terminationType;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		terminationList 
			= getTerminationDAO().findTerminationByType(terminationType.getId(),start, rowsPerPage, options );
		terminationList.setTotalCount(count);
		terminationList.setCurrentPageNumber(currentPage);
		terminationType.setTerminationList(terminationList );	

		return terminationType;
	}			
		


	protected String getTableName(){
		return TerminationTypeTable.TABLE_NAME;
	}
}


