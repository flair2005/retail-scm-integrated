
package com.skynet.retailscm.secuser;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.userdomain.UserDomain;
import com.skynet.retailscm.userapp.UserApp;

import com.skynet.retailscm.userapp.UserAppDAO;
import com.skynet.retailscm.userdomain.UserDomainDAO;

import com.skynet.retailscm.userapp.UserAppTable;
import com.skynet.retailscm.userdomain.UserDomainTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SecUserJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SecUserDAO{
 
 	
 	private  UserDomainDAO  userDomainDAO;
 	public void setUserDomainDAO(UserDomainDAO userDomainDAO){
	 	this.userDomainDAO = userDomainDAO;
 	}
 	public UserDomainDAO getUserDomainDAO(){
	 	return this.userDomainDAO;
 	}

		
	
  	private  UserAppDAO  userAppDAO;
 	public void setUserAppDAO(UserAppDAO pUserAppDAO){
 	
 		if(pUserAppDAO == null){
 			throw new IllegalStateException("Do not try to set userAppDAO to null.");
 		}
	 	this.userAppDAO = pUserAppDAO;
 	}
 	public UserAppDAO getUserAppDAO(){
 		if(this.userAppDAO == null){
 			throw new IllegalStateException("The userAppDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAppDAO;
 	}	
 	
			
		

	
	/*
	protected SecUser load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(accessKey, options);
	}
	*/
	public SecUser load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withId(id), options);
	}
	
	
	
	public SecUser save(SecUser secUser,Map<String,Object> options){
		
		String methodName="save(SecUser secUser,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(secUser, methodName, "secUser");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSecUser(secUser,options);
	}
	public SecUser clone(String secUserId, Map<String,Object> options) throws Exception{
	
		return clone(SecUserTable.withId(secUserId),options);
	}
	
	protected SecUser clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String secUserId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SecUser newSecUser = loadInternalSecUser(accessKey, options);
		newSecUser.setVersion(0);
		
		
 		
 		if(isSaveUserAppListEnabled(options)){
 			for(UserApp item: newSecUser.getUserAppList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSecUser(newSecUser,options);
		
		return newSecUser;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String secUserId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{secUserId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SecUserVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SecUserNotFoundException(
					"The " + this.getTableName() + "(" + secUserId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String secUserId, int version) throws Exception{
	
		String methodName="delete(String secUserId, int version)";
		assertMethodArgumentNotNull(secUserId, methodName, "secUserId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{secUserId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(secUserId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"login","mobile","email","pwd","last_login","domain"};
		return SecUserTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "sec_user";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SecUserTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractDomainEnabled = true;
 	//private static final String DOMAIN = "domain";
 	protected boolean isExtractDomainEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SecUserTokens.DOMAIN);
 	}
 	
 	
 	//private boolean saveDomainEnabled = true;
 	protected boolean isSaveDomainEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SecUserTokens.DOMAIN);
 	}
 	

 	
 
		
	//protected static final String USER_APP_LIST = "userAppList";
	
	protected boolean isExtractUserAppListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,SecUserTokens.USER_APP_LIST);
		
 	}

	protected boolean isSaveUserAppListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.USER_APP_LIST);
		
 	}
 	
 	
			
		

	

	protected SecUserMapper getSecUserMapper(){
		return new SecUserMapper();
	}
	protected SecUser extractSecUser(String secUserId) throws Exception{
		String SQL = "select * from sec_user_data where id = ?";	
		try{
		
			SecUser secUser = queryForObject(SQL, new Object[]{secUserId}, getSecUserMapper());
			return secUser;
		}catch(EmptyResultDataAccessException e){
			throw new SecUserNotFoundException("SecUser("+secUserId+") is not found!");
		}
		
		
	}
	protected SecUser extractSecUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from sec_user_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SecUser secUser = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSecUserMapper());
			return secUser;
		}catch(EmptyResultDataAccessException e){
			throw new SecUserNotFoundException("SecUser("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SecUser loadInternalSecUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SecUser secUser = extractSecUser(accessKey, loadOptions);
 	
 		if(isExtractDomainEnabled(loadOptions)){
	 		extractDomain(secUser, loadOptions);
 		}
 
		
		if(isExtractUserAppListEnabled(loadOptions)){
	 		extractUserAppList(secUser, loadOptions);
 		}		
		
		return secUser;
		
	}



	
	
	 

 	protected SecUser extractDomain(SecUser secUser, Map<String,Object> options) throws Exception{

		if(secUser.getDomain() == null){
			return secUser;
		}
		String domainId = secUser.getDomain().getId();
		if( domainId == null){
			return secUser;
		}
		UserDomain domain = getUserDomainDAO().load(domainId,options);
		if(domain != null){
			secUser.setDomain(domain);
		}
		
 		
 		return secUser;
 	}
 		
 
		
	protected SecUser extractUserAppList(SecUser secUser, Map<String,Object> options){
		
		SmartList<UserApp> userAppList = getUserAppDAO().findUserAppBySecUser(secUser.getId(),options);
		if(userAppList != null){
			secUser.setUserAppList(userAppList);
		}
		
		return secUser;
	
	}	
		
		
  	
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where domain = ?";
		SmartList<SecUser> secUserList = queryForList(SQL, new Object[]{userDomainId}, getSecUserMapper());	
 		return secUserList;
 	}
 	
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where domain = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SecUser> secUserList = queryForList(SQL, new Object[]{userDomainId,start, count}, getSecUserMapper());
		
 		return secUserList;
 	}
 	
 	public int countSecUserByDomain(String userDomainId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where domain = ?";
		Integer count = queryInt(SQL, new Object[]{userDomainId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SecUser saveSecUser(SecUser  secUser){
	
		String SQL=this.getSaveSecUserSQL(secUser);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSecUserParameters(secUser);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		secUser.incVersion();
		return secUser;
	
	}
	public SmartList<SecUser> saveSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSecUserList(secUserList);
		
		batchSecUserCreate((List<SecUser>)lists[CREATE_LIST_INDEX]);
		
		batchSecUserUpdate((List<SecUser>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SecUser secUser:secUserList){
			if(secUser.isChanged()){
				secUser.incVersion();
			}
			
		
		}
		
		
		return secUserList;
	}

	public SmartList<SecUser> removeSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		
		
		super.removeList(secUserList, options);
		
		return secUserList;
		
		
	}
	
	protected List<Object[]> prepareSecUserBatchCreateArgs(List<SecUser> secUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUser secUser:secUserList ){
			Object [] parameters = prepareSecUserCreateParameters(secUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSecUserBatchUpdateArgs(List<SecUser> secUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUser secUser:secUserList ){
			if(!secUser.isChanged()){
				continue;
			}
			Object [] parameters = prepareSecUserUpdateParameters(secUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSecUserCreate(List<SecUser> secUserList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSecUserBatchCreateArgs(secUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSecUserUpdate(List<SecUser> secUserList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSecUserBatchUpdateArgs(secUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSecUserList(List<SecUser> secUserList){
		
		List<SecUser> secUserCreateList=new ArrayList<SecUser>();
		List<SecUser> secUserUpdateList=new ArrayList<SecUser>();
		
		for(SecUser secUser: secUserList){
			if(isUpdateRequest(secUser)){
				secUserUpdateList.add( secUser);
				continue;
			}
			secUserCreateList.add(secUser);
		}
		
		return new Object[]{secUserCreateList,secUserUpdateList};
	}
	
	protected boolean isUpdateRequest(SecUser secUser){
 		return secUser.getVersion() > 0;
 	}
 	protected String getSaveSecUserSQL(SecUser secUser){
 		if(isUpdateRequest(secUser)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSecUserParameters(SecUser secUser){
 		if(isUpdateRequest(secUser) ){
 			return prepareSecUserUpdateParameters(secUser);
 		}
 		return prepareSecUserCreateParameters(secUser);
 	}
 	protected Object[] prepareSecUserUpdateParameters(SecUser secUser){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = secUser.getLogin();
 		parameters[1] = secUser.getMobile();
 		parameters[2] = secUser.getEmail();
 		parameters[3] = secUser.getPwd();
 		parameters[4] = secUser.getLastLogin(); 	
 		if(secUser.getDomain() != null){
 			parameters[5] = secUser.getDomain().getId();
 		}
 		
 		parameters[6] = secUser.getId();
 		parameters[7] = secUser.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSecUserCreateParameters(SecUser secUser){
		Object[] parameters = new Object[7];
		String newSecUserId=getNextId();
		secUser.setId(newSecUserId);
		parameters[0] =  secUser.getId();
 
 		parameters[1] = secUser.getLogin();
 		parameters[2] = secUser.getMobile();
 		parameters[3] = secUser.getEmail();
 		parameters[4] = secUser.getPwd();
 		parameters[5] = secUser.getLastLogin(); 	
 		if(secUser.getDomain() != null){
 			parameters[6] = secUser.getDomain().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected SecUser saveInternalSecUser(SecUser secUser, Map<String,Object> options){
		
		saveSecUser(secUser);
 	
 		if(isSaveDomainEnabled(options)){
	 		saveDomain(secUser, options);
 		}
 
		
		if(isSaveUserAppListEnabled(options)){
	 		saveUserAppList(secUser, options);
	 		removeUserAppList(secUser, options);
	 		
 		}		
		
		return secUser;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SecUser saveDomain(SecUser secUser, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(secUser.getDomain() == null){
 			return secUser;//do nothing when it is null
 		}
 		
 		getUserDomainDAO().save(secUser.getDomain(),options);
 		return secUser;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected SecUser saveUserAppList(SecUser secUser, Map<String,Object> options){
		SmartList<UserApp> userAppList = secUser.getUserAppList();
		if(userAppList == null){
			return secUser;
		}
		if(userAppList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getUserAppDAO().saveUserAppList(userAppList,options);
		
		return secUser;
	
	}
	
	protected SecUser removeUserAppList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<UserApp> userAppList = secUser.getUserAppList();
		if(userAppList == null){
			return secUser;
		}	
	
		SmartList<UserApp> toRemoveUserAppList = userAppList.getToRemoveList();
		
		if(toRemoveUserAppList == null){
			return secUser;
		}
		if(toRemoveUserAppList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAppDAO().removeUserAppList(toRemoveUserAppList,options);
		
		return secUser;
	
	}
	
	
	
 	
 	
	
	
	
		

	public SecUser present(SecUser secUser,Map<String, Object> options){
	
		presentUserAppList(secUser,options);

		return secUser;
	
	}
		
	
  	
 	protected SecUser presentUserAppList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<UserApp> userAppList = secUser.getUserAppList();		
		if(userAppList == null){
			return secUser;			
		}
		
		String targetObjectName = "userApp";
		int userAppListSize = userAppList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(userAppListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return secUser;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = userAppListSize;
		if(userAppListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getUserAppDAO().countUserAppBySecUser(secUser.getId(), options);			
		}
		//secUser.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//secUser.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(userAppListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(userAppListSize,currentPage,rowsPerPage) ;
			userAppList = userAppList.subListOf(fromIndex, toIndex);
			userAppList.setTotalCount(count);
			userAppList.setCurrentPageNumber(currentPage);			
			secUser.setUserAppList(userAppList);
			return secUser;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		userAppList 
			= getUserAppDAO().findUserAppBySecUser(secUser.getId(),start, rowsPerPage, options );
		userAppList.setTotalCount(count);
		userAppList.setCurrentPageNumber(currentPage);
		secUser.setUserAppList(userAppList );	

		return secUser;
	}			
		


	protected String getTableName(){
		return SecUserTable.TABLE_NAME;
	}
}


