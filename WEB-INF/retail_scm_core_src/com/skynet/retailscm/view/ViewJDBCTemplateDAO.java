
package com.skynet.retailscm.view;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;




import org.springframework.dao.EmptyResultDataAccessException;

public class ViewJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ViewDAO{

		

	
	/*
	protected View load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalView(accessKey, options);
	}
	*/
	public View load(String id,Map<String,Object> options) throws Exception{
		return loadInternalView(ViewTable.withId(id), options);
	}
	
	
	
	public View save(View view,Map<String,Object> options){
		
		String methodName="save(View view,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(view, methodName, "view");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalView(view,options);
	}
	public View clone(String viewId, Map<String,Object> options) throws Exception{
	
		return clone(ViewTable.withId(viewId),options);
	}
	
	protected View clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String viewId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		View newView = loadInternalView(accessKey, options);
		newView.setVersion(0);
		
		

		
		saveInternalView(newView,options);
		
		return newView;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String viewId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{viewId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ViewVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ViewNotFoundException(
					"The " + this.getTableName() + "(" + viewId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String viewId, int version) throws Exception{
	
		String methodName="delete(String viewId, int version)";
		assertMethodArgumentNotNull(viewId, methodName, "viewId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{viewId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(viewId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"who","assessment","interview_time"};
		return ViewTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "view";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ViewTokens.checkOptions(options, optionToCheck);
	
	}


		

	

	protected ViewMapper getViewMapper(){
		return new ViewMapper();
	}
	protected View extractView(String viewId) throws Exception{
		String SQL = "select * from view_data where id = ?";	
		try{
		
			View view = queryForObject(SQL, new Object[]{viewId}, getViewMapper());
			return view;
		}catch(EmptyResultDataAccessException e){
			throw new ViewNotFoundException("View("+viewId+") is not found!");
		}
		
		
	}
	protected View extractView(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from view_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			View view = queryForObject(SQL, new Object[]{accessKey.getValue()}, getViewMapper());
			return view;
		}catch(EmptyResultDataAccessException e){
			throw new ViewNotFoundException("View("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected View loadInternalView(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		View view = extractView(accessKey, loadOptions);

		
		return view;
		
	}



	
	
	
		
		
 	
		
		
		

	

	protected View saveView(View  view){
	
		String SQL=this.getSaveViewSQL(view);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveViewParameters(view);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		view.incVersion();
		return view;
	
	}
	public SmartList<View> saveViewList(SmartList<View> viewList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitViewList(viewList);
		
		batchViewCreate((List<View>)lists[CREATE_LIST_INDEX]);
		
		batchViewUpdate((List<View>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(View view:viewList){
			if(view.isChanged()){
				view.incVersion();
			}
			
		
		}
		
		
		return viewList;
	}

	public SmartList<View> removeViewList(SmartList<View> viewList,Map<String,Object> options){
		
		
		super.removeList(viewList, options);
		
		return viewList;
		
		
	}
	
	protected List<Object[]> prepareViewBatchCreateArgs(List<View> viewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(View view:viewList ){
			Object [] parameters = prepareViewCreateParameters(view);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareViewBatchUpdateArgs(List<View> viewList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(View view:viewList ){
			if(!view.isChanged()){
				continue;
			}
			Object [] parameters = prepareViewUpdateParameters(view);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchViewCreate(List<View> viewList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareViewBatchCreateArgs(viewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchViewUpdate(List<View> viewList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareViewBatchUpdateArgs(viewList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitViewList(List<View> viewList){
		
		List<View> viewCreateList=new ArrayList<View>();
		List<View> viewUpdateList=new ArrayList<View>();
		
		for(View view: viewList){
			if(isUpdateRequest(view)){
				viewUpdateList.add( view);
				continue;
			}
			viewCreateList.add(view);
		}
		
		return new Object[]{viewCreateList,viewUpdateList};
	}
	
	protected boolean isUpdateRequest(View view){
 		return view.getVersion() > 0;
 	}
 	protected String getSaveViewSQL(View view){
 		if(isUpdateRequest(view)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveViewParameters(View view){
 		if(isUpdateRequest(view) ){
 			return prepareViewUpdateParameters(view);
 		}
 		return prepareViewCreateParameters(view);
 	}
 	protected Object[] prepareViewUpdateParameters(View view){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = view.getWho();
 		parameters[1] = view.getAssessment();
 		parameters[2] = view.getInterviewTime();		
 		parameters[3] = view.getId();
 		parameters[4] = view.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareViewCreateParameters(View view){
		Object[] parameters = new Object[4];
		String newViewId=getNextId();
		view.setId(newViewId);
		parameters[0] =  view.getId();
 
 		parameters[1] = view.getWho();
 		parameters[2] = view.getAssessment();
 		parameters[3] = view.getInterviewTime();		
 				
 		return parameters;
 	}
 	
	protected View saveInternalView(View view, Map<String,Object> options){
		
		saveView(view);

		
		return view;
		
	}
	
	
	
	//======================================================================================
	
		

	public View present(View view,Map<String, Object> options){
	

		return view;
	
	}
		


	protected String getTableName(){
		return ViewTable.TABLE_NAME;
	}
}


