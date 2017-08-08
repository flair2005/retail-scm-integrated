
package com.skynet.retailscm.userdomain;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.secuser.SecUser;

import com.skynet.retailscm.secuser.SecUserDAO;

import com.skynet.retailscm.secuser.SecUserTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class UserDomainJDBCTemplateDAO extends CommonJDBCTemplateDAO implements UserDomainDAO{

		
	
  	private  SecUserDAO  secUserDAO;
 	public void setSecUserDAO(SecUserDAO pSecUserDAO){
 	
 		if(pSecUserDAO == null){
 			throw new IllegalStateException("Do not try to set secUserDAO to null.");
 		}
	 	this.secUserDAO = pSecUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
 		if(this.secUserDAO == null){
 			throw new IllegalStateException("The secUserDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.secUserDAO;
 	}	
 	
			
		

	
	/*
	protected UserDomain load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserDomain(accessKey, options);
	}
	*/
	public UserDomain load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserDomain(UserDomainTable.withId(id), options);
	}
	
	
	
	public UserDomain save(UserDomain userDomain,Map<String,Object> options){
		
		String methodName="save(UserDomain userDomain,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userDomain, methodName, "userDomain");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserDomain(userDomain,options);
	}
	public UserDomain clone(String userDomainId, Map<String,Object> options) throws Exception{
	
		return clone(UserDomainTable.withId(userDomainId),options);
	}
	
	protected UserDomain clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userDomainId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserDomain newUserDomain = loadInternalUserDomain(accessKey, options);
		newUserDomain.setVersion(0);
		
		
 		
 		if(isSaveSecUserListEnabled(options)){
 			for(SecUser item: newUserDomain.getSecUserList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalUserDomain(newUserDomain,options);
		
		return newUserDomain;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String userDomainId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{userDomainId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new UserDomainVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserDomainNotFoundException(
					"The " + this.getTableName() + "(" + userDomainId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String userDomainId, int version) throws Exception{
	
		String methodName="delete(String userDomainId, int version)";
		assertMethodArgumentNotNull(userDomainId, methodName, "userDomainId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userDomainId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userDomainId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name"};
		return UserDomainTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_domain";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserDomainTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String SEC_USER_LIST = "secUserList";
	
	protected boolean isExtractSecUserListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,UserDomainTokens.SEC_USER_LIST);
		
 	}

	protected boolean isSaveSecUserListEnabled(Map<String,Object> options){
		return checkOptions(options, UserDomainTokens.SEC_USER_LIST);
		
 	}
 	
 	
			
		

	

	protected UserDomainMapper getUserDomainMapper(){
		return new UserDomainMapper();
	}
	protected UserDomain extractUserDomain(String userDomainId) throws Exception{
		String SQL = "select * from user_domain_data where id = ?";	
		try{
		
			UserDomain userDomain = queryForObject(SQL, new Object[]{userDomainId}, getUserDomainMapper());
			return userDomain;
		}catch(EmptyResultDataAccessException e){
			throw new UserDomainNotFoundException("UserDomain("+userDomainId+") is not found!");
		}
		
		
	}
	protected UserDomain extractUserDomain(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from user_domain_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			UserDomain userDomain = queryForObject(SQL, new Object[]{accessKey.getValue()}, getUserDomainMapper());
			return userDomain;
		}catch(EmptyResultDataAccessException e){
			throw new UserDomainNotFoundException("UserDomain("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected UserDomain loadInternalUserDomain(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserDomain userDomain = extractUserDomain(accessKey, loadOptions);

		
		if(isExtractSecUserListEnabled(loadOptions)){
	 		extractSecUserList(userDomain, loadOptions);
 		}		
		
		return userDomain;
		
	}



	
	
	
		
	protected UserDomain extractSecUserList(UserDomain userDomain, Map<String,Object> options){
		
		SmartList<SecUser> secUserList = getSecUserDAO().findSecUserByDomain(userDomain.getId(),options);
		if(secUserList != null){
			userDomain.setSecUserList(secUserList);
		}
		
		return userDomain;
	
	}	
		
		
 	
		
		
		

	

	protected UserDomain saveUserDomain(UserDomain  userDomain){
	
		String SQL=this.getSaveUserDomainSQL(userDomain);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserDomainParameters(userDomain);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userDomain.incVersion();
		return userDomain;
	
	}
	public SmartList<UserDomain> saveUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserDomainList(userDomainList);
		
		batchUserDomainCreate((List<UserDomain>)lists[CREATE_LIST_INDEX]);
		
		batchUserDomainUpdate((List<UserDomain>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserDomain userDomain:userDomainList){
			if(userDomain.isChanged()){
				userDomain.incVersion();
			}
			
		
		}
		
		
		return userDomainList;
	}

	public SmartList<UserDomain> removeUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options){
		
		
		super.removeList(userDomainList, options);
		
		return userDomainList;
		
		
	}
	
	protected List<Object[]> prepareUserDomainBatchCreateArgs(List<UserDomain> userDomainList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserDomain userDomain:userDomainList ){
			Object [] parameters = prepareUserDomainCreateParameters(userDomain);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserDomainBatchUpdateArgs(List<UserDomain> userDomainList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserDomain userDomain:userDomainList ){
			if(!userDomain.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserDomainUpdateParameters(userDomain);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserDomainCreate(List<UserDomain> userDomainList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserDomainBatchCreateArgs(userDomainList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserDomainUpdate(List<UserDomain> userDomainList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserDomainBatchUpdateArgs(userDomainList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserDomainList(List<UserDomain> userDomainList){
		
		List<UserDomain> userDomainCreateList=new ArrayList<UserDomain>();
		List<UserDomain> userDomainUpdateList=new ArrayList<UserDomain>();
		
		for(UserDomain userDomain: userDomainList){
			if(isUpdateRequest(userDomain)){
				userDomainUpdateList.add( userDomain);
				continue;
			}
			userDomainCreateList.add(userDomain);
		}
		
		return new Object[]{userDomainCreateList,userDomainUpdateList};
	}
	
	protected boolean isUpdateRequest(UserDomain userDomain){
 		return userDomain.getVersion() > 0;
 	}
 	protected String getSaveUserDomainSQL(UserDomain userDomain){
 		if(isUpdateRequest(userDomain)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserDomainParameters(UserDomain userDomain){
 		if(isUpdateRequest(userDomain) ){
 			return prepareUserDomainUpdateParameters(userDomain);
 		}
 		return prepareUserDomainCreateParameters(userDomain);
 	}
 	protected Object[] prepareUserDomainUpdateParameters(UserDomain userDomain){
 		Object[] parameters = new Object[3];
 
 		parameters[0] = userDomain.getName();		
 		parameters[1] = userDomain.getId();
 		parameters[2] = userDomain.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserDomainCreateParameters(UserDomain userDomain){
		Object[] parameters = new Object[2];
		String newUserDomainId=getNextId();
		userDomain.setId(newUserDomainId);
		parameters[0] =  userDomain.getId();
 
 		parameters[1] = userDomain.getName();		
 				
 		return parameters;
 	}
 	
	protected UserDomain saveInternalUserDomain(UserDomain userDomain, Map<String,Object> options){
		
		saveUserDomain(userDomain);

		
		if(isSaveSecUserListEnabled(options)){
	 		saveSecUserList(userDomain, options);
	 		removeSecUserList(userDomain, options);
	 		
 		}		
		
		return userDomain;
		
	}
	
	
	
	//======================================================================================
	
		
	protected UserDomain saveSecUserList(UserDomain userDomain, Map<String,Object> options){
		SmartList<SecUser> secUserList = userDomain.getSecUserList();
		if(secUserList == null){
			return userDomain;
		}
		if(secUserList.isEmpty()){
			return userDomain;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSecUserDAO().saveSecUserList(secUserList,options);
		
		return userDomain;
	
	}
	
	protected UserDomain removeSecUserList(UserDomain userDomain, Map<String,Object> options){
	
	
		SmartList<SecUser> secUserList = userDomain.getSecUserList();
		if(secUserList == null){
			return userDomain;
		}	
	
		SmartList<SecUser> toRemoveSecUserList = secUserList.getToRemoveList();
		
		if(toRemoveSecUserList == null){
			return userDomain;
		}
		if(toRemoveSecUserList.isEmpty()){
			return userDomain;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSecUserDAO().removeSecUserList(toRemoveSecUserList,options);
		
		return userDomain;
	
	}
	
	
	
 	
 	
	
	
	
		

	public UserDomain present(UserDomain userDomain,Map<String, Object> options){
	
		presentSecUserList(userDomain,options);

		return userDomain;
	
	}
		
	
  	
 	protected UserDomain presentSecUserList(
			UserDomain userDomain,
			Map<String, Object> options) {

		SmartList<SecUser> secUserList = userDomain.getSecUserList();		
		if(secUserList == null){
			return userDomain;			
		}
		
		String targetObjectName = "secUser";
		int secUserListSize = secUserList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(secUserListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return userDomain;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = secUserListSize;
		if(secUserListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSecUserDAO().countSecUserByDomain(userDomain.getId(), options);			
		}
		//userDomain.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//userDomain.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(secUserListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(secUserListSize,currentPage,rowsPerPage) ;
			secUserList = secUserList.subListOf(fromIndex, toIndex);
			secUserList.setTotalCount(count);
			secUserList.setCurrentPageNumber(currentPage);			
			userDomain.setSecUserList(secUserList);
			return userDomain;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		secUserList 
			= getSecUserDAO().findSecUserByDomain(userDomain.getId(),start, rowsPerPage, options );
		secUserList.setTotalCount(count);
		secUserList.setCurrentPageNumber(currentPage);
		userDomain.setSecUserList(secUserList );	

		return userDomain;
	}			
		


	protected String getTableName(){
		return UserDomainTable.TABLE_NAME;
	}
}


