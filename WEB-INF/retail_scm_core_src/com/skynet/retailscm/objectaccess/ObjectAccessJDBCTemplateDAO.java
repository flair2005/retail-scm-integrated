
package com.skynet.retailscm.objectaccess;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.userapp.UserApp;

import com.skynet.retailscm.userapp.UserAppDAO;

import com.skynet.retailscm.userapp.UserAppTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ObjectAccessJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ObjectAccessDAO{
 
 	
 	private  UserAppDAO  userAppDAO;
 	public void setUserAppDAO(UserAppDAO userAppDAO){
	 	this.userAppDAO = userAppDAO;
 	}
 	public UserAppDAO getUserAppDAO(){
	 	return this.userAppDAO;
 	}

		

	
	/*
	protected ObjectAccess load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalObjectAccess(accessKey, options);
	}
	*/
	public ObjectAccess load(String id,Map<String,Object> options) throws Exception{
		return loadInternalObjectAccess(ObjectAccessTable.withId(id), options);
	}
	
	
	
	public ObjectAccess save(ObjectAccess objectAccess,Map<String,Object> options){
		
		String methodName="save(ObjectAccess objectAccess,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(objectAccess, methodName, "objectAccess");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalObjectAccess(objectAccess,options);
	}
	public ObjectAccess clone(String objectAccessId, Map<String,Object> options) throws Exception{
	
		return clone(ObjectAccessTable.withId(objectAccessId),options);
	}
	
	protected ObjectAccess clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String objectAccessId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ObjectAccess newObjectAccess = loadInternalObjectAccess(accessKey, options);
		newObjectAccess.setVersion(0);
		
		

		
		saveInternalObjectAccess(newObjectAccess,options);
		
		return newObjectAccess;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String objectAccessId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{objectAccessId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ObjectAccessVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ObjectAccessNotFoundException(
					"The " + this.getTableName() + "(" + objectAccessId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String objectAccessId, int version) throws Exception{
	
		String methodName="delete(String objectAccessId, int version)";
		assertMethodArgumentNotNull(objectAccessId, methodName, "objectAccessId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{objectAccessId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(objectAccessId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"display_name","object_type","list1","list2","list3","list4","list5","list6","list7","list8","list9","app"};
		return ObjectAccessTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "object_access";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ObjectAccessTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractAppEnabled = true;
 	//private static final String APP = "app";
 	protected boolean isExtractAppEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ObjectAccessTokens.APP);
 	}
 	
 	
 	//private boolean saveAppEnabled = true;
 	protected boolean isSaveAppEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ObjectAccessTokens.APP);
 	}
 	

 	
 
		

	

	protected ObjectAccessMapper getObjectAccessMapper(){
		return new ObjectAccessMapper();
	}
	protected ObjectAccess extractObjectAccess(String objectAccessId) throws Exception{
		String SQL = "select * from object_access_data where id = ?";	
		try{
		
			ObjectAccess objectAccess = queryForObject(SQL, new Object[]{objectAccessId}, getObjectAccessMapper());
			return objectAccess;
		}catch(EmptyResultDataAccessException e){
			throw new ObjectAccessNotFoundException("ObjectAccess("+objectAccessId+") is not found!");
		}
		
		
	}
	protected ObjectAccess extractObjectAccess(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from object_access_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ObjectAccess objectAccess = queryForObject(SQL, new Object[]{accessKey.getValue()}, getObjectAccessMapper());
			return objectAccess;
		}catch(EmptyResultDataAccessException e){
			throw new ObjectAccessNotFoundException("ObjectAccess("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ObjectAccess loadInternalObjectAccess(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ObjectAccess objectAccess = extractObjectAccess(accessKey, loadOptions);
 	
 		if(isExtractAppEnabled(loadOptions)){
	 		extractApp(objectAccess, loadOptions);
 		}
 
		
		return objectAccess;
		
	}



	
	
	 

 	protected ObjectAccess extractApp(ObjectAccess objectAccess, Map<String,Object> options) throws Exception{

		if(objectAccess.getApp() == null){
			return objectAccess;
		}
		String appId = objectAccess.getApp().getId();
		if( appId == null){
			return objectAccess;
		}
		UserApp app = getUserAppDAO().load(appId,options);
		if(app != null){
			objectAccess.setApp(app);
		}
		
 		
 		return objectAccess;
 	}
 		
 
		
		
  	
 	public SmartList<ObjectAccess> findObjectAccessByApp(String userAppId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where app = ?";
		SmartList<ObjectAccess> objectAccessList = queryForList(SQL, new Object[]{userAppId}, getObjectAccessMapper());	
 		return objectAccessList;
 	}
 	
 	public SmartList<ObjectAccess> findObjectAccessByApp(String userAppId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where app = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ObjectAccess> objectAccessList = queryForList(SQL, new Object[]{userAppId,start, count}, getObjectAccessMapper());
		
 		return objectAccessList;
 	}
 	
 	public int countObjectAccessByApp(String userAppId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where app = ?";
		Integer count = queryInt(SQL, new Object[]{userAppId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ObjectAccess saveObjectAccess(ObjectAccess  objectAccess){
	
		String SQL=this.getSaveObjectAccessSQL(objectAccess);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveObjectAccessParameters(objectAccess);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		objectAccess.incVersion();
		return objectAccess;
	
	}
	public SmartList<ObjectAccess> saveObjectAccessList(SmartList<ObjectAccess> objectAccessList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitObjectAccessList(objectAccessList);
		
		batchObjectAccessCreate((List<ObjectAccess>)lists[CREATE_LIST_INDEX]);
		
		batchObjectAccessUpdate((List<ObjectAccess>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ObjectAccess objectAccess:objectAccessList){
			if(objectAccess.isChanged()){
				objectAccess.incVersion();
			}
			
		
		}
		
		
		return objectAccessList;
	}

	public SmartList<ObjectAccess> removeObjectAccessList(SmartList<ObjectAccess> objectAccessList,Map<String,Object> options){
		
		
		super.removeList(objectAccessList, options);
		
		return objectAccessList;
		
		
	}
	
	protected List<Object[]> prepareObjectAccessBatchCreateArgs(List<ObjectAccess> objectAccessList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ObjectAccess objectAccess:objectAccessList ){
			Object [] parameters = prepareObjectAccessCreateParameters(objectAccess);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareObjectAccessBatchUpdateArgs(List<ObjectAccess> objectAccessList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ObjectAccess objectAccess:objectAccessList ){
			if(!objectAccess.isChanged()){
				continue;
			}
			Object [] parameters = prepareObjectAccessUpdateParameters(objectAccess);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchObjectAccessCreate(List<ObjectAccess> objectAccessList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareObjectAccessBatchCreateArgs(objectAccessList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchObjectAccessUpdate(List<ObjectAccess> objectAccessList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareObjectAccessBatchUpdateArgs(objectAccessList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitObjectAccessList(List<ObjectAccess> objectAccessList){
		
		List<ObjectAccess> objectAccessCreateList=new ArrayList<ObjectAccess>();
		List<ObjectAccess> objectAccessUpdateList=new ArrayList<ObjectAccess>();
		
		for(ObjectAccess objectAccess: objectAccessList){
			if(isUpdateRequest(objectAccess)){
				objectAccessUpdateList.add( objectAccess);
				continue;
			}
			objectAccessCreateList.add(objectAccess);
		}
		
		return new Object[]{objectAccessCreateList,objectAccessUpdateList};
	}
	
	protected boolean isUpdateRequest(ObjectAccess objectAccess){
 		return objectAccess.getVersion() > 0;
 	}
 	protected String getSaveObjectAccessSQL(ObjectAccess objectAccess){
 		if(isUpdateRequest(objectAccess)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveObjectAccessParameters(ObjectAccess objectAccess){
 		if(isUpdateRequest(objectAccess) ){
 			return prepareObjectAccessUpdateParameters(objectAccess);
 		}
 		return prepareObjectAccessCreateParameters(objectAccess);
 	}
 	protected Object[] prepareObjectAccessUpdateParameters(ObjectAccess objectAccess){
 		Object[] parameters = new Object[14];
 
 		parameters[0] = objectAccess.getDisplayName();
 		parameters[1] = objectAccess.getObjectType();
 		parameters[2] = objectAccess.getList1();
 		parameters[3] = objectAccess.getList2();
 		parameters[4] = objectAccess.getList3();
 		parameters[5] = objectAccess.getList4();
 		parameters[6] = objectAccess.getList5();
 		parameters[7] = objectAccess.getList6();
 		parameters[8] = objectAccess.getList7();
 		parameters[9] = objectAccess.getList8();
 		parameters[10] = objectAccess.getList9(); 	
 		if(objectAccess.getApp() != null){
 			parameters[11] = objectAccess.getApp().getId();
 		}
 		
 		parameters[12] = objectAccess.getId();
 		parameters[13] = objectAccess.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareObjectAccessCreateParameters(ObjectAccess objectAccess){
		Object[] parameters = new Object[13];
		String newObjectAccessId=getNextId();
		objectAccess.setId(newObjectAccessId);
		parameters[0] =  objectAccess.getId();
 
 		parameters[1] = objectAccess.getDisplayName();
 		parameters[2] = objectAccess.getObjectType();
 		parameters[3] = objectAccess.getList1();
 		parameters[4] = objectAccess.getList2();
 		parameters[5] = objectAccess.getList3();
 		parameters[6] = objectAccess.getList4();
 		parameters[7] = objectAccess.getList5();
 		parameters[8] = objectAccess.getList6();
 		parameters[9] = objectAccess.getList7();
 		parameters[10] = objectAccess.getList8();
 		parameters[11] = objectAccess.getList9(); 	
 		if(objectAccess.getApp() != null){
 			parameters[12] = objectAccess.getApp().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ObjectAccess saveInternalObjectAccess(ObjectAccess objectAccess, Map<String,Object> options){
		
		saveObjectAccess(objectAccess);
 	
 		if(isSaveAppEnabled(options)){
	 		saveApp(objectAccess, options);
 		}
 
		
		return objectAccess;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ObjectAccess saveApp(ObjectAccess objectAccess, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(objectAccess.getApp() == null){
 			return objectAccess;//do nothing when it is null
 		}
 		
 		getUserAppDAO().save(objectAccess.getApp(),options);
 		return objectAccess;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public ObjectAccess present(ObjectAccess objectAccess,Map<String, Object> options){
	

		return objectAccess;
	
	}
		


	protected String getTableName(){
		return ObjectAccessTable.TABLE_NAME;
	}
}

