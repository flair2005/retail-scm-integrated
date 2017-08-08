
package com.skynet.retailscm.userapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.secuser.SecUser;
import com.skynet.retailscm.objectaccess.ObjectAccess;

import com.skynet.retailscm.secuser.SecUserDAO;
import com.skynet.retailscm.objectaccess.ObjectAccessDAO;

import com.skynet.retailscm.objectaccess.ObjectAccessTable;
import com.skynet.retailscm.secuser.SecUserTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class UserAppJDBCTemplateDAO extends CommonJDBCTemplateDAO implements UserAppDAO{
 
 	
 	private  SecUserDAO  secUserDAO;
 	public void setSecUserDAO(SecUserDAO secUserDAO){
	 	this.secUserDAO = secUserDAO;
 	}
 	public SecUserDAO getSecUserDAO(){
	 	return this.secUserDAO;
 	}

		
	
  	private  ObjectAccessDAO  objectAccessDAO;
 	public void setObjectAccessDAO(ObjectAccessDAO pObjectAccessDAO){
 	
 		if(pObjectAccessDAO == null){
 			throw new IllegalStateException("Do not try to set objectAccessDAO to null.");
 		}
	 	this.objectAccessDAO = pObjectAccessDAO;
 	}
 	public ObjectAccessDAO getObjectAccessDAO(){
 		if(this.objectAccessDAO == null){
 			throw new IllegalStateException("The objectAccessDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.objectAccessDAO;
 	}	
 	
			
		

	
	/*
	protected UserApp load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserApp(accessKey, options);
	}
	*/
	public UserApp load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserApp(UserAppTable.withId(id), options);
	}
	
	
	
	public UserApp save(UserApp userApp,Map<String,Object> options){
		
		String methodName="save(UserApp userApp,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userApp, methodName, "userApp");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserApp(userApp,options);
	}
	public UserApp clone(String userAppId, Map<String,Object> options) throws Exception{
	
		return clone(UserAppTable.withId(userAppId),options);
	}
	
	protected UserApp clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userAppId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserApp newUserApp = loadInternalUserApp(accessKey, options);
		newUserApp.setVersion(0);
		
		
 		
 		if(isSaveObjectAccessListEnabled(options)){
 			for(ObjectAccess item: newUserApp.getObjectAccessList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalUserApp(newUserApp,options);
		
		return newUserApp;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String userAppId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{userAppId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new UserAppVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserAppNotFoundException(
					"The " + this.getTableName() + "(" + userAppId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String userAppId, int version) throws Exception{
	
		String methodName="delete(String userAppId, int version)";
		assertMethodArgumentNotNull(userAppId, methodName, "userAppId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userAppId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userAppId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"title","sec_user","app_icon","full_access","permission","object_type","object_id","location"};
		return UserAppTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_app";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserAppTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractSecUserEnabled = true;
 	//private static final String SECUSER = "secUser";
 	protected boolean isExtractSecUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserAppTokens.SECUSER);
 	}
 	
 	
 	//private boolean saveSecUserEnabled = true;
 	protected boolean isSaveSecUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserAppTokens.SECUSER);
 	}
 	

 	
 
		
	//protected static final String OBJECT_ACCESS_LIST = "objectAccessList";
	
	protected boolean isExtractObjectAccessListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,UserAppTokens.OBJECT_ACCESS_LIST);
		
 	}

	protected boolean isSaveObjectAccessListEnabled(Map<String,Object> options){
		return checkOptions(options, UserAppTokens.OBJECT_ACCESS_LIST);
		
 	}
 	
 	
			
		

	

	protected UserAppMapper getUserAppMapper(){
		return new UserAppMapper();
	}
	protected UserApp extractUserApp(String userAppId) throws Exception{
		String SQL = "select * from user_app_data where id = ?";	
		try{
		
			UserApp userApp = queryForObject(SQL, new Object[]{userAppId}, getUserAppMapper());
			return userApp;
		}catch(EmptyResultDataAccessException e){
			throw new UserAppNotFoundException("UserApp("+userAppId+") is not found!");
		}
		
		
	}
	protected UserApp extractUserApp(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from user_app_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			UserApp userApp = queryForObject(SQL, new Object[]{accessKey.getValue()}, getUserAppMapper());
			return userApp;
		}catch(EmptyResultDataAccessException e){
			throw new UserAppNotFoundException("UserApp("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected UserApp loadInternalUserApp(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserApp userApp = extractUserApp(accessKey, loadOptions);
 	
 		if(isExtractSecUserEnabled(loadOptions)){
	 		extractSecUser(userApp, loadOptions);
 		}
 
		
		if(isExtractObjectAccessListEnabled(loadOptions)){
	 		extractObjectAccessList(userApp, loadOptions);
 		}		
		
		return userApp;
		
	}



	
	
	 

 	protected UserApp extractSecUser(UserApp userApp, Map<String,Object> options) throws Exception{

		if(userApp.getSecUser() == null){
			return userApp;
		}
		String secUserId = userApp.getSecUser().getId();
		if( secUserId == null){
			return userApp;
		}
		SecUser secUser = getSecUserDAO().load(secUserId,options);
		if(secUser != null){
			userApp.setSecUser(secUser);
		}
		
 		
 		return userApp;
 	}
 		
 
		
	protected UserApp extractObjectAccessList(UserApp userApp, Map<String,Object> options){
		
		SmartList<ObjectAccess> objectAccessList = getObjectAccessDAO().findObjectAccessByApp(userApp.getId(),options);
		if(objectAccessList != null){
			userApp.setObjectAccessList(objectAccessList);
		}
		
		return userApp;
	
	}	
		
		
  	
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where sec_user = ?";
		SmartList<UserApp> userAppList = queryForList(SQL, new Object[]{secUserId}, getUserAppMapper());	
 		return userAppList;
 	}
 	
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where sec_user = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<UserApp> userAppList = queryForList(SQL, new Object[]{secUserId,start, count}, getUserAppMapper());
		
 		return userAppList;
 	}
 	
 	public int countUserAppBySecUser(String secUserId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where sec_user = ?";
		Integer count = queryInt(SQL, new Object[]{secUserId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected UserApp saveUserApp(UserApp  userApp){
	
		String SQL=this.getSaveUserAppSQL(userApp);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserAppParameters(userApp);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userApp.incVersion();
		return userApp;
	
	}
	public SmartList<UserApp> saveUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserAppList(userAppList);
		
		batchUserAppCreate((List<UserApp>)lists[CREATE_LIST_INDEX]);
		
		batchUserAppUpdate((List<UserApp>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserApp userApp:userAppList){
			if(userApp.isChanged()){
				userApp.incVersion();
			}
			
		
		}
		
		
		return userAppList;
	}

	public SmartList<UserApp> removeUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options){
		
		
		super.removeList(userAppList, options);
		
		return userAppList;
		
		
	}
	
	protected List<Object[]> prepareUserAppBatchCreateArgs(List<UserApp> userAppList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserApp userApp:userAppList ){
			Object [] parameters = prepareUserAppCreateParameters(userApp);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserAppBatchUpdateArgs(List<UserApp> userAppList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserApp userApp:userAppList ){
			if(!userApp.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserAppUpdateParameters(userApp);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserAppCreate(List<UserApp> userAppList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserAppBatchCreateArgs(userAppList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserAppUpdate(List<UserApp> userAppList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserAppBatchUpdateArgs(userAppList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserAppList(List<UserApp> userAppList){
		
		List<UserApp> userAppCreateList=new ArrayList<UserApp>();
		List<UserApp> userAppUpdateList=new ArrayList<UserApp>();
		
		for(UserApp userApp: userAppList){
			if(isUpdateRequest(userApp)){
				userAppUpdateList.add( userApp);
				continue;
			}
			userAppCreateList.add(userApp);
		}
		
		return new Object[]{userAppCreateList,userAppUpdateList};
	}
	
	protected boolean isUpdateRequest(UserApp userApp){
 		return userApp.getVersion() > 0;
 	}
 	protected String getSaveUserAppSQL(UserApp userApp){
 		if(isUpdateRequest(userApp)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserAppParameters(UserApp userApp){
 		if(isUpdateRequest(userApp) ){
 			return prepareUserAppUpdateParameters(userApp);
 		}
 		return prepareUserAppCreateParameters(userApp);
 	}
 	protected Object[] prepareUserAppUpdateParameters(UserApp userApp){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = userApp.getTitle(); 	
 		if(userApp.getSecUser() != null){
 			parameters[1] = userApp.getSecUser().getId();
 		}
 
 		parameters[2] = userApp.getAppIcon();
 		parameters[3] = userApp.getFullAccess();
 		parameters[4] = userApp.getPermission();
 		parameters[5] = userApp.getObjectType();
 		parameters[6] = userApp.getObjectId();
 		parameters[7] = userApp.getLocation();		
 		parameters[8] = userApp.getId();
 		parameters[9] = userApp.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserAppCreateParameters(UserApp userApp){
		Object[] parameters = new Object[9];
		String newUserAppId=getNextId();
		userApp.setId(newUserAppId);
		parameters[0] =  userApp.getId();
 
 		parameters[1] = userApp.getTitle(); 	
 		if(userApp.getSecUser() != null){
 			parameters[2] = userApp.getSecUser().getId();
 		
 		}
 		
 		parameters[3] = userApp.getAppIcon();
 		parameters[4] = userApp.getFullAccess();
 		parameters[5] = userApp.getPermission();
 		parameters[6] = userApp.getObjectType();
 		parameters[7] = userApp.getObjectId();
 		parameters[8] = userApp.getLocation();		
 				
 		return parameters;
 	}
 	
	protected UserApp saveInternalUserApp(UserApp userApp, Map<String,Object> options){
		
		saveUserApp(userApp);
 	
 		if(isSaveSecUserEnabled(options)){
	 		saveSecUser(userApp, options);
 		}
 
		
		if(isSaveObjectAccessListEnabled(options)){
	 		saveObjectAccessList(userApp, options);
	 		removeObjectAccessList(userApp, options);
	 		
 		}		
		
		return userApp;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected UserApp saveSecUser(UserApp userApp, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userApp.getSecUser() == null){
 			return userApp;//do nothing when it is null
 		}
 		
 		getSecUserDAO().save(userApp.getSecUser(),options);
 		return userApp;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected UserApp saveObjectAccessList(UserApp userApp, Map<String,Object> options){
		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();
		if(objectAccessList == null){
			return userApp;
		}
		if(objectAccessList.isEmpty()){
			return userApp;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getObjectAccessDAO().saveObjectAccessList(objectAccessList,options);
		
		return userApp;
	
	}
	
	protected UserApp removeObjectAccessList(UserApp userApp, Map<String,Object> options){
	
	
		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();
		if(objectAccessList == null){
			return userApp;
		}	
	
		SmartList<ObjectAccess> toRemoveObjectAccessList = objectAccessList.getToRemoveList();
		
		if(toRemoveObjectAccessList == null){
			return userApp;
		}
		if(toRemoveObjectAccessList.isEmpty()){
			return userApp;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getObjectAccessDAO().removeObjectAccessList(toRemoveObjectAccessList,options);
		
		return userApp;
	
	}
	
	
	
 	
 	
	
	
	
		

	public UserApp present(UserApp userApp,Map<String, Object> options){
	
		presentObjectAccessList(userApp,options);

		return userApp;
	
	}
		
	
  	
 	protected UserApp presentObjectAccessList(
			UserApp userApp,
			Map<String, Object> options) {

		SmartList<ObjectAccess> objectAccessList = userApp.getObjectAccessList();		
		if(objectAccessList == null){
			return userApp;			
		}
		
		String targetObjectName = "objectAccess";
		int objectAccessListSize = objectAccessList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(objectAccessListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return userApp;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = objectAccessListSize;
		if(objectAccessListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getObjectAccessDAO().countObjectAccessByApp(userApp.getId(), options);			
		}
		//userApp.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//userApp.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(objectAccessListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(objectAccessListSize,currentPage,rowsPerPage) ;
			objectAccessList = objectAccessList.subListOf(fromIndex, toIndex);
			objectAccessList.setTotalCount(count);
			objectAccessList.setCurrentPageNumber(currentPage);			
			userApp.setObjectAccessList(objectAccessList);
			return userApp;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		objectAccessList 
			= getObjectAccessDAO().findObjectAccessByApp(userApp.getId(),start, rowsPerPage, options );
		objectAccessList.setTotalCount(count);
		objectAccessList.setCurrentPageNumber(currentPage);
		userApp.setObjectAccessList(objectAccessList );	

		return userApp;
	}			
		


	protected String getTableName(){
		return UserAppTable.TABLE_NAME;
	}
}


