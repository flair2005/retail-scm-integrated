
package com.skynet.retailscm.terminationreason;

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

public class TerminationReasonJDBCTemplateDAO extends CommonJDBCTemplateDAO implements TerminationReasonDAO{
 
 	
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
	protected TerminationReason load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalTerminationReason(accessKey, options);
	}
	*/
	public TerminationReason load(String id,Map<String,Object> options) throws Exception{
		return loadInternalTerminationReason(TerminationReasonTable.withId(id), options);
	}
	
	
	
	public TerminationReason save(TerminationReason terminationReason,Map<String,Object> options){
		
		String methodName="save(TerminationReason terminationReason,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(terminationReason, methodName, "terminationReason");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalTerminationReason(terminationReason,options);
	}
	public TerminationReason clone(String terminationReasonId, Map<String,Object> options) throws Exception{
	
		return clone(TerminationReasonTable.withId(terminationReasonId),options);
	}
	
	protected TerminationReason clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String terminationReasonId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		TerminationReason newTerminationReason = loadInternalTerminationReason(accessKey, options);
		newTerminationReason.setVersion(0);
		
		
 		
 		if(isSaveTerminationListEnabled(options)){
 			for(Termination item: newTerminationReason.getTerminationList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalTerminationReason(newTerminationReason,options);
		
		return newTerminationReason;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String terminationReasonId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{terminationReasonId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new TerminationReasonVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new TerminationReasonNotFoundException(
					"The " + this.getTableName() + "(" + terminationReasonId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String terminationReasonId, int version) throws Exception{
	
		String methodName="delete(String terminationReasonId, int version)";
		assertMethodArgumentNotNull(terminationReasonId, methodName, "terminationReasonId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{terminationReasonId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(terminationReasonId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","description"};
		return TerminationReasonTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "termination_reason";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return TerminationReasonTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, TerminationReasonTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, TerminationReasonTokens.COMPANY);
 	}
 	

 	
 
		
	//protected static final String TERMINATION_LIST = "terminationList";
	
	protected boolean isExtractTerminationListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,TerminationReasonTokens.TERMINATION_LIST);
		
 	}

	protected boolean isSaveTerminationListEnabled(Map<String,Object> options){
		return checkOptions(options, TerminationReasonTokens.TERMINATION_LIST);
		
 	}
 	
 	
			
		

	

	protected TerminationReasonMapper getTerminationReasonMapper(){
		return new TerminationReasonMapper();
	}
	protected TerminationReason extractTerminationReason(String terminationReasonId) throws Exception{
		String SQL = "select * from termination_reason_data where id = ?";	
		try{
		
			TerminationReason terminationReason = queryForObject(SQL, new Object[]{terminationReasonId}, getTerminationReasonMapper());
			return terminationReason;
		}catch(EmptyResultDataAccessException e){
			throw new TerminationReasonNotFoundException("TerminationReason("+terminationReasonId+") is not found!");
		}
		
		
	}
	protected TerminationReason extractTerminationReason(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from termination_reason_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			TerminationReason terminationReason = queryForObject(SQL, new Object[]{accessKey.getValue()}, getTerminationReasonMapper());
			return terminationReason;
		}catch(EmptyResultDataAccessException e){
			throw new TerminationReasonNotFoundException("TerminationReason("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected TerminationReason loadInternalTerminationReason(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		TerminationReason terminationReason = extractTerminationReason(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(terminationReason, loadOptions);
 		}
 
		
		if(isExtractTerminationListEnabled(loadOptions)){
	 		extractTerminationList(terminationReason, loadOptions);
 		}		
		
		return terminationReason;
		
	}



	
	
	 

 	protected TerminationReason extractCompany(TerminationReason terminationReason, Map<String,Object> options) throws Exception{

		if(terminationReason.getCompany() == null){
			return terminationReason;
		}
		String companyId = terminationReason.getCompany().getId();
		if( companyId == null){
			return terminationReason;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			terminationReason.setCompany(company);
		}
		
 		
 		return terminationReason;
 	}
 		
 
		
	protected TerminationReason extractTerminationList(TerminationReason terminationReason, Map<String,Object> options){
		
		SmartList<Termination> terminationList = getTerminationDAO().findTerminationByReason(terminationReason.getId(),options);
		if(terminationList != null){
			terminationReason.setTerminationList(terminationList);
		}
		
		return terminationReason;
	
	}	
		
		
  	
 	public SmartList<TerminationReason> findTerminationReasonByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<TerminationReason> terminationReasonList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getTerminationReasonMapper());	
 		return terminationReasonList;
 	}
 	
 	public SmartList<TerminationReason> findTerminationReasonByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<TerminationReason> terminationReasonList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getTerminationReasonMapper());
		
 		return terminationReasonList;
 	}
 	
 	public int countTerminationReasonByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected TerminationReason saveTerminationReason(TerminationReason  terminationReason){
	
		String SQL=this.getSaveTerminationReasonSQL(terminationReason);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveTerminationReasonParameters(terminationReason);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		terminationReason.incVersion();
		return terminationReason;
	
	}
	public SmartList<TerminationReason> saveTerminationReasonList(SmartList<TerminationReason> terminationReasonList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitTerminationReasonList(terminationReasonList);
		
		batchTerminationReasonCreate((List<TerminationReason>)lists[CREATE_LIST_INDEX]);
		
		batchTerminationReasonUpdate((List<TerminationReason>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(TerminationReason terminationReason:terminationReasonList){
			if(terminationReason.isChanged()){
				terminationReason.incVersion();
			}
			
		
		}
		
		
		return terminationReasonList;
	}

	public SmartList<TerminationReason> removeTerminationReasonList(SmartList<TerminationReason> terminationReasonList,Map<String,Object> options){
		
		
		super.removeList(terminationReasonList, options);
		
		return terminationReasonList;
		
		
	}
	
	protected List<Object[]> prepareTerminationReasonBatchCreateArgs(List<TerminationReason> terminationReasonList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TerminationReason terminationReason:terminationReasonList ){
			Object [] parameters = prepareTerminationReasonCreateParameters(terminationReason);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareTerminationReasonBatchUpdateArgs(List<TerminationReason> terminationReasonList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(TerminationReason terminationReason:terminationReasonList ){
			if(!terminationReason.isChanged()){
				continue;
			}
			Object [] parameters = prepareTerminationReasonUpdateParameters(terminationReason);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchTerminationReasonCreate(List<TerminationReason> terminationReasonList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareTerminationReasonBatchCreateArgs(terminationReasonList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchTerminationReasonUpdate(List<TerminationReason> terminationReasonList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareTerminationReasonBatchUpdateArgs(terminationReasonList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitTerminationReasonList(List<TerminationReason> terminationReasonList){
		
		List<TerminationReason> terminationReasonCreateList=new ArrayList<TerminationReason>();
		List<TerminationReason> terminationReasonUpdateList=new ArrayList<TerminationReason>();
		
		for(TerminationReason terminationReason: terminationReasonList){
			if(isUpdateRequest(terminationReason)){
				terminationReasonUpdateList.add( terminationReason);
				continue;
			}
			terminationReasonCreateList.add(terminationReason);
		}
		
		return new Object[]{terminationReasonCreateList,terminationReasonUpdateList};
	}
	
	protected boolean isUpdateRequest(TerminationReason terminationReason){
 		return terminationReason.getVersion() > 0;
 	}
 	protected String getSaveTerminationReasonSQL(TerminationReason terminationReason){
 		if(isUpdateRequest(terminationReason)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveTerminationReasonParameters(TerminationReason terminationReason){
 		if(isUpdateRequest(terminationReason) ){
 			return prepareTerminationReasonUpdateParameters(terminationReason);
 		}
 		return prepareTerminationReasonCreateParameters(terminationReason);
 	}
 	protected Object[] prepareTerminationReasonUpdateParameters(TerminationReason terminationReason){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = terminationReason.getCode(); 	
 		if(terminationReason.getCompany() != null){
 			parameters[1] = terminationReason.getCompany().getId();
 		}
 
 		parameters[2] = terminationReason.getDescription();		
 		parameters[3] = terminationReason.getId();
 		parameters[4] = terminationReason.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareTerminationReasonCreateParameters(TerminationReason terminationReason){
		Object[] parameters = new Object[4];
		String newTerminationReasonId=getNextId();
		terminationReason.setId(newTerminationReasonId);
		parameters[0] =  terminationReason.getId();
 
 		parameters[1] = terminationReason.getCode(); 	
 		if(terminationReason.getCompany() != null){
 			parameters[2] = terminationReason.getCompany().getId();
 		
 		}
 		
 		parameters[3] = terminationReason.getDescription();		
 				
 		return parameters;
 	}
 	
	protected TerminationReason saveInternalTerminationReason(TerminationReason terminationReason, Map<String,Object> options){
		
		saveTerminationReason(terminationReason);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(terminationReason, options);
 		}
 
		
		if(isSaveTerminationListEnabled(options)){
	 		saveTerminationList(terminationReason, options);
	 		removeTerminationList(terminationReason, options);
	 		
 		}		
		
		return terminationReason;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected TerminationReason saveCompany(TerminationReason terminationReason, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(terminationReason.getCompany() == null){
 			return terminationReason;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(terminationReason.getCompany(),options);
 		return terminationReason;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected TerminationReason saveTerminationList(TerminationReason terminationReason, Map<String,Object> options){
		SmartList<Termination> terminationList = terminationReason.getTerminationList();
		if(terminationList == null){
			return terminationReason;
		}
		if(terminationList.isEmpty()){
			return terminationReason;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTerminationDAO().saveTerminationList(terminationList,options);
		
		return terminationReason;
	
	}
	
	protected TerminationReason removeTerminationList(TerminationReason terminationReason, Map<String,Object> options){
	
	
		SmartList<Termination> terminationList = terminationReason.getTerminationList();
		if(terminationList == null){
			return terminationReason;
		}	
	
		SmartList<Termination> toRemoveTerminationList = terminationList.getToRemoveList();
		
		if(toRemoveTerminationList == null){
			return terminationReason;
		}
		if(toRemoveTerminationList.isEmpty()){
			return terminationReason;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTerminationDAO().removeTerminationList(toRemoveTerminationList,options);
		
		return terminationReason;
	
	}
	
	
	
 	
 	
	
	
	
		

	public TerminationReason present(TerminationReason terminationReason,Map<String, Object> options){
	
		presentTerminationList(terminationReason,options);

		return terminationReason;
	
	}
		
	
  	
 	protected TerminationReason presentTerminationList(
			TerminationReason terminationReason,
			Map<String, Object> options) {

		SmartList<Termination> terminationList = terminationReason.getTerminationList();		
		if(terminationList == null){
			return terminationReason;			
		}
		
		String targetObjectName = "termination";
		int terminationListSize = terminationList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(terminationListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return terminationReason;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = terminationListSize;
		if(terminationListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTerminationDAO().countTerminationByReason(terminationReason.getId(), options);			
		}
		//terminationReason.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//terminationReason.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(terminationListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(terminationListSize,currentPage,rowsPerPage) ;
			terminationList = terminationList.subListOf(fromIndex, toIndex);
			terminationList.setTotalCount(count);
			terminationList.setCurrentPageNumber(currentPage);			
			terminationReason.setTerminationList(terminationList);
			return terminationReason;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		terminationList 
			= getTerminationDAO().findTerminationByReason(terminationReason.getId(),start, rowsPerPage, options );
		terminationList.setTotalCount(count);
		terminationList.setCurrentPageNumber(currentPage);
		terminationReason.setTerminationList(terminationList );	

		return terminationReason;
	}			
		


	protected String getTableName(){
		return TerminationReasonTable.TABLE_NAME;
	}
}


