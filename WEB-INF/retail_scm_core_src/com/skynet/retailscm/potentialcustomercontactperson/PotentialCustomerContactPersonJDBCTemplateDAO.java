
package com.skynet.retailscm.potentialcustomercontactperson;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;

import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContactTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class PotentialCustomerContactPersonJDBCTemplateDAO extends CommonJDBCTemplateDAO implements PotentialCustomerContactPersonDAO{
 
 	
 	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
	 	return this.potentialCustomerDAO;
 	}

		
	
  	private  PotentialCustomerContactDAO  potentialCustomerContactDAO;
 	public void setPotentialCustomerContactDAO(PotentialCustomerContactDAO pPotentialCustomerContactDAO){
 	
 		if(pPotentialCustomerContactDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerContactDAO to null.");
 		}
	 	this.potentialCustomerContactDAO = pPotentialCustomerContactDAO;
 	}
 	public PotentialCustomerContactDAO getPotentialCustomerContactDAO(){
 		if(this.potentialCustomerContactDAO == null){
 			throw new IllegalStateException("The potentialCustomerContactDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerContactDAO;
 	}	
 	
			
		

	
	/*
	protected PotentialCustomerContactPerson load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContactPerson(accessKey, options);
	}
	*/
	public PotentialCustomerContactPerson load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContactPerson(PotentialCustomerContactPersonTable.withId(id), options);
	}
	
	
	
	public PotentialCustomerContactPerson save(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options){
		
		String methodName="save(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(potentialCustomerContactPerson, methodName, "potentialCustomerContactPerson");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPotentialCustomerContactPerson(potentialCustomerContactPerson,options);
	}
	public PotentialCustomerContactPerson clone(String potentialCustomerContactPersonId, Map<String,Object> options) throws Exception{
	
		return clone(PotentialCustomerContactPersonTable.withId(potentialCustomerContactPersonId),options);
	}
	
	protected PotentialCustomerContactPerson clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String potentialCustomerContactPersonId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PotentialCustomerContactPerson newPotentialCustomerContactPerson = loadInternalPotentialCustomerContactPerson(accessKey, options);
		newPotentialCustomerContactPerson.setVersion(0);
		
		
 		
 		if(isSavePotentialCustomerContactListEnabled(options)){
 			for(PotentialCustomerContact item: newPotentialCustomerContactPerson.getPotentialCustomerContactList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPotentialCustomerContactPerson(newPotentialCustomerContactPerson,options);
		
		return newPotentialCustomerContactPerson;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String potentialCustomerContactPersonId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{potentialCustomerContactPersonId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new PotentialCustomerContactPersonVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PotentialCustomerContactPersonNotFoundException(
					"The " + this.getTableName() + "(" + potentialCustomerContactPersonId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String potentialCustomerContactPersonId, int version) throws Exception{
	
		String methodName="delete(String potentialCustomerContactPersonId, int version)";
		assertMethodArgumentNotNull(potentialCustomerContactPersonId, methodName, "potentialCustomerContactPersonId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{potentialCustomerContactPersonId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(potentialCustomerContactPersonId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","mobile","potential_customer","description"};
		return PotentialCustomerContactPersonTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "potential_customer_contact_person";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PotentialCustomerContactPersonTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractPotentialCustomerEnabled = true;
 	//private static final String POTENTIALCUSTOMER = "potentialCustomer";
 	protected boolean isExtractPotentialCustomerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactPersonTokens.POTENTIALCUSTOMER);
 	}
 	
 	
 	//private boolean savePotentialCustomerEnabled = true;
 	protected boolean isSavePotentialCustomerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactPersonTokens.POTENTIALCUSTOMER);
 	}
 	

 	
 
		
	//protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
	
	protected boolean isExtractPotentialCustomerContactListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,PotentialCustomerContactPersonTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}

	protected boolean isSavePotentialCustomerContactListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerContactPersonTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}
 	
 	
			
		

	

	protected PotentialCustomerContactPersonMapper getPotentialCustomerContactPersonMapper(){
		return new PotentialCustomerContactPersonMapper();
	}
	protected PotentialCustomerContactPerson extractPotentialCustomerContactPerson(String potentialCustomerContactPersonId) throws Exception{
		String SQL = "select * from potential_customer_contact_person_data where id = ?";	
		try{
		
			PotentialCustomerContactPerson potentialCustomerContactPerson = queryForObject(SQL, new Object[]{potentialCustomerContactPersonId}, getPotentialCustomerContactPersonMapper());
			return potentialCustomerContactPerson;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerContactPersonNotFoundException("PotentialCustomerContactPerson("+potentialCustomerContactPersonId+") is not found!");
		}
		
		
	}
	protected PotentialCustomerContactPerson extractPotentialCustomerContactPerson(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from potential_customer_contact_person_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			PotentialCustomerContactPerson potentialCustomerContactPerson = queryForObject(SQL, new Object[]{accessKey.getValue()}, getPotentialCustomerContactPersonMapper());
			return potentialCustomerContactPerson;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerContactPersonNotFoundException("PotentialCustomerContactPerson("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected PotentialCustomerContactPerson loadInternalPotentialCustomerContactPerson(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = extractPotentialCustomerContactPerson(accessKey, loadOptions);
 	
 		if(isExtractPotentialCustomerEnabled(loadOptions)){
	 		extractPotentialCustomer(potentialCustomerContactPerson, loadOptions);
 		}
 
		
		if(isExtractPotentialCustomerContactListEnabled(loadOptions)){
	 		extractPotentialCustomerContactList(potentialCustomerContactPerson, loadOptions);
 		}		
		
		return potentialCustomerContactPerson;
		
	}



	
	
	 

 	protected PotentialCustomerContactPerson extractPotentialCustomer(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options) throws Exception{

		if(potentialCustomerContactPerson.getPotentialCustomer() == null){
			return potentialCustomerContactPerson;
		}
		String potentialCustomerId = potentialCustomerContactPerson.getPotentialCustomer().getId();
		if( potentialCustomerId == null){
			return potentialCustomerContactPerson;
		}
		PotentialCustomer potentialCustomer = getPotentialCustomerDAO().load(potentialCustomerId,options);
		if(potentialCustomer != null){
			potentialCustomerContactPerson.setPotentialCustomer(potentialCustomer);
		}
		
 		
 		return potentialCustomerContactPerson;
 	}
 		
 
		
	protected PotentialCustomerContactPerson extractPotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = getPotentialCustomerContactDAO().findPotentialCustomerContactByContactTo(potentialCustomerContactPerson.getId(),options);
		if(potentialCustomerContactList != null){
			potentialCustomerContactPerson.setPotentialCustomerContactList(potentialCustomerContactList);
		}
		
		return potentialCustomerContactPerson;
	
	}	
		
		
  	
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where potential_customer = ?";
		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = queryForList(SQL, new Object[]{potentialCustomerId}, getPotentialCustomerContactPersonMapper());	
 		return potentialCustomerContactPersonList;
 	}
 	
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where potential_customer = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = queryForList(SQL, new Object[]{potentialCustomerId,start, count}, getPotentialCustomerContactPersonMapper());
		
 		return potentialCustomerContactPersonList;
 	}
 	
 	public int countPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where potential_customer = ?";
		Integer count = queryInt(SQL, new Object[]{potentialCustomerId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(PotentialCustomerContactPerson  potentialCustomerContactPerson){
	
		String SQL=this.getSavePotentialCustomerContactPersonSQL(potentialCustomerContactPerson);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePotentialCustomerContactPersonParameters(potentialCustomerContactPerson);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		potentialCustomerContactPerson.incVersion();
		return potentialCustomerContactPerson;
	
	}
	public SmartList<PotentialCustomerContactPerson> savePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPotentialCustomerContactPersonList(potentialCustomerContactPersonList);
		
		batchPotentialCustomerContactPersonCreate((List<PotentialCustomerContactPerson>)lists[CREATE_LIST_INDEX]);
		
		batchPotentialCustomerContactPersonUpdate((List<PotentialCustomerContactPerson>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList){
			if(potentialCustomerContactPerson.isChanged()){
				potentialCustomerContactPerson.incVersion();
			}
			
		
		}
		
		
		return potentialCustomerContactPersonList;
	}

	public SmartList<PotentialCustomerContactPerson> removePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options){
		
		
		super.removeList(potentialCustomerContactPersonList, options);
		
		return potentialCustomerContactPersonList;
		
		
	}
	
	protected List<Object[]> preparePotentialCustomerContactPersonBatchCreateArgs(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList ){
			Object [] parameters = preparePotentialCustomerContactPersonCreateParameters(potentialCustomerContactPerson);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePotentialCustomerContactPersonBatchUpdateArgs(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList ){
			if(!potentialCustomerContactPerson.isChanged()){
				continue;
			}
			Object [] parameters = preparePotentialCustomerContactPersonUpdateParameters(potentialCustomerContactPerson);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPotentialCustomerContactPersonCreate(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePotentialCustomerContactPersonBatchCreateArgs(potentialCustomerContactPersonList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPotentialCustomerContactPersonUpdate(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePotentialCustomerContactPersonBatchUpdateArgs(potentialCustomerContactPersonList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPotentialCustomerContactPersonList(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		
		List<PotentialCustomerContactPerson> potentialCustomerContactPersonCreateList=new ArrayList<PotentialCustomerContactPerson>();
		List<PotentialCustomerContactPerson> potentialCustomerContactPersonUpdateList=new ArrayList<PotentialCustomerContactPerson>();
		
		for(PotentialCustomerContactPerson potentialCustomerContactPerson: potentialCustomerContactPersonList){
			if(isUpdateRequest(potentialCustomerContactPerson)){
				potentialCustomerContactPersonUpdateList.add( potentialCustomerContactPerson);
				continue;
			}
			potentialCustomerContactPersonCreateList.add(potentialCustomerContactPerson);
		}
		
		return new Object[]{potentialCustomerContactPersonCreateList,potentialCustomerContactPersonUpdateList};
	}
	
	protected boolean isUpdateRequest(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		return potentialCustomerContactPerson.getVersion() > 0;
 	}
 	protected String getSavePotentialCustomerContactPersonSQL(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		if(isUpdateRequest(potentialCustomerContactPerson)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePotentialCustomerContactPersonParameters(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		if(isUpdateRequest(potentialCustomerContactPerson) ){
 			return preparePotentialCustomerContactPersonUpdateParameters(potentialCustomerContactPerson);
 		}
 		return preparePotentialCustomerContactPersonCreateParameters(potentialCustomerContactPerson);
 	}
 	protected Object[] preparePotentialCustomerContactPersonUpdateParameters(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = potentialCustomerContactPerson.getName();
 		parameters[1] = potentialCustomerContactPerson.getMobile(); 	
 		if(potentialCustomerContactPerson.getPotentialCustomer() != null){
 			parameters[2] = potentialCustomerContactPerson.getPotentialCustomer().getId();
 		}
 
 		parameters[3] = potentialCustomerContactPerson.getDescription();		
 		parameters[4] = potentialCustomerContactPerson.getId();
 		parameters[5] = potentialCustomerContactPerson.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePotentialCustomerContactPersonCreateParameters(PotentialCustomerContactPerson potentialCustomerContactPerson){
		Object[] parameters = new Object[5];
		String newPotentialCustomerContactPersonId=getNextId();
		potentialCustomerContactPerson.setId(newPotentialCustomerContactPersonId);
		parameters[0] =  potentialCustomerContactPerson.getId();
 
 		parameters[1] = potentialCustomerContactPerson.getName();
 		parameters[2] = potentialCustomerContactPerson.getMobile(); 	
 		if(potentialCustomerContactPerson.getPotentialCustomer() != null){
 			parameters[3] = potentialCustomerContactPerson.getPotentialCustomer().getId();
 		
 		}
 		
 		parameters[4] = potentialCustomerContactPerson.getDescription();		
 				
 		return parameters;
 	}
 	
	protected PotentialCustomerContactPerson saveInternalPotentialCustomerContactPerson(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
		
		savePotentialCustomerContactPerson(potentialCustomerContactPerson);
 	
 		if(isSavePotentialCustomerEnabled(options)){
	 		savePotentialCustomer(potentialCustomerContactPerson, options);
 		}
 
		
		if(isSavePotentialCustomerContactListEnabled(options)){
	 		savePotentialCustomerContactList(potentialCustomerContactPerson, options);
	 		removePotentialCustomerContactList(potentialCustomerContactPerson, options);
	 		
 		}		
		
		return potentialCustomerContactPerson;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PotentialCustomerContactPerson savePotentialCustomer(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContactPerson.getPotentialCustomer() == null){
 			return potentialCustomerContactPerson;//do nothing when it is null
 		}
 		
 		getPotentialCustomerDAO().save(potentialCustomerContactPerson.getPotentialCustomer(),options);
 		return potentialCustomerContactPerson;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected PotentialCustomerContactPerson savePotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}
		if(potentialCustomerContactList.isEmpty()){
			return potentialCustomerContactPerson;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPotentialCustomerContactDAO().savePotentialCustomerContactList(potentialCustomerContactList,options);
		
		return potentialCustomerContactPerson;
	
	}
	
	protected PotentialCustomerContactPerson removePotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
	
	
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}	
	
		SmartList<PotentialCustomerContact> toRemovePotentialCustomerContactList = potentialCustomerContactList.getToRemoveList();
		
		if(toRemovePotentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}
		if(toRemovePotentialCustomerContactList.isEmpty()){
			return potentialCustomerContactPerson;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerContactDAO().removePotentialCustomerContactList(toRemovePotentialCustomerContactList,options);
		
		return potentialCustomerContactPerson;
	
	}
	
	
	
 	
 	
	
	
	
		

	public PotentialCustomerContactPerson present(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String, Object> options){
	
		presentPotentialCustomerContactList(potentialCustomerContactPerson,options);

		return potentialCustomerContactPerson;
	
	}
		
	
  	
 	protected PotentialCustomerContactPerson presentPotentialCustomerContactList(
			PotentialCustomerContactPerson potentialCustomerContactPerson,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();		
		if(potentialCustomerContactList == null){
			return potentialCustomerContactPerson;			
		}
		
		String targetObjectName = "potentialCustomerContact";
		int potentialCustomerContactListSize = potentialCustomerContactList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(potentialCustomerContactListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return potentialCustomerContactPerson;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = potentialCustomerContactListSize;
		if(potentialCustomerContactListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPotentialCustomerContactDAO().countPotentialCustomerContactByContactTo(potentialCustomerContactPerson.getId(), options);			
		}
		//potentialCustomerContactPerson.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//potentialCustomerContactPerson.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(potentialCustomerContactListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(potentialCustomerContactListSize,currentPage,rowsPerPage) ;
			potentialCustomerContactList = potentialCustomerContactList.subListOf(fromIndex, toIndex);
			potentialCustomerContactList.setTotalCount(count);
			potentialCustomerContactList.setCurrentPageNumber(currentPage);			
			potentialCustomerContactPerson.setPotentialCustomerContactList(potentialCustomerContactList);
			return potentialCustomerContactPerson;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		potentialCustomerContactList 
			= getPotentialCustomerContactDAO().findPotentialCustomerContactByContactTo(potentialCustomerContactPerson.getId(),start, rowsPerPage, options );
		potentialCustomerContactList.setTotalCount(count);
		potentialCustomerContactList.setCurrentPageNumber(currentPage);
		potentialCustomerContactPerson.setPotentialCustomerContactList(potentialCustomerContactList );	

		return potentialCustomerContactPerson;
	}			
		


	protected String getTableName(){
		return PotentialCustomerContactPersonTable.TABLE_NAME;
	}
}


