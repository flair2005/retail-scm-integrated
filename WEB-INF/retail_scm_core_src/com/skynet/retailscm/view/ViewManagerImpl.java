
package com.skynet.retailscm.view;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;









public class ViewManagerImpl extends RetailScmCheckerManager implements ViewManager {
	
	private static final String SERVICE_TYPE = "View";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ViewDAO  viewDAO;
 	public void setViewDAO(ViewDAO  viewDAO){
 	
 		if(viewDAO == null){
 			throw new IllegalStateException("Do not try to set viewDAO to null.");
 		}
	 	this.viewDAO = viewDAO;
 	}
 	public ViewDAO getViewDAO(){
 		if(this.viewDAO == null){
 			throw new IllegalStateException("The ViewDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.viewDAO;
 	}
 	
 	protected View saveView(RetailScmUserContext userContext, View view, String [] tokensExpr) throws Exception{	
 		//return getViewDAO().save(view, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveView(userContext, view, tokens);
 	}
 	
 	protected View saveViewDetail(RetailScmUserContext userContext, View view) throws Exception{	

 		
 		return saveView(userContext, view, allTokens());
 	}
 	
 	public View loadView(RetailScmUserContext userContext, String viewId, String [] tokensExpr) throws Exception{				
 
 		ViewManagerException exception = new ViewManagerException("Error Occured");
		
		checkIdOfView(userContext, viewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		View view = loadView( userContext, viewId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,view, tokens);
 	}
 	
 	protected View present(RetailScmUserContext userContext, View view, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,view,tokens);
		
		
		return this.getViewDAO().present(view, tokens);
	}
 
 	
 	
 	public View loadViewDetail(RetailScmUserContext userContext, String viewId) throws Exception{	
 		ViewManagerException exception = new ViewManagerException("Error Occured");
		
		checkIdOfView(userContext, viewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		View view = loadView( userContext, viewId, allTokens());

 		return present(userContext,view, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String viewId) throws Exception{	
 		ViewManagerException exception = new ViewManagerException("Error Occured");
		
		checkIdOfView(userContext, viewId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		View view = loadView( userContext, viewId, allTokens());

 		return present(userContext,view, allTokens());
		
 	}
 	protected View saveView(RetailScmUserContext userContext, View view, Map<String,Object>tokens) throws Exception{	
 		return getViewDAO().save(view, tokens);
 	}
 	protected View loadView(RetailScmUserContext userContext, String viewId, Map<String,Object>tokens) throws Exception{	
 		return getViewDAO().load(viewId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, View view, Map<String, Object> tokens){
		super.addActions(userContext, view, tokens);
		
		addAction(userContext, view, tokens,"@create","createView","createView/","main","primary");
		addAction(userContext, view, tokens,"@update","updateView","updateView/"+view.getId()+"/","main","primary");
		addAction(userContext, view, tokens,"@copy","cloneView","cloneView/"+view.getId()+"/","main","primary");
		
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, View view, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public View createView(RetailScmUserContext userContext,String who, String assessment, Date interviewTime
) throws Exception
	{
		
		ViewManagerException exception = new ViewManagerException("Error Occured");

		

		checkWhoOfView(userContext,  who, exception);
		checkAssessmentOfView(userContext,  assessment, exception);
		checkInterviewTimeOfView(userContext,  interviewTime, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		View view=createNewView();	

		view.setWho(who);
		view.setAssessment(assessment);
		view.setInterviewTime(interviewTime);

		return saveView(userContext, view, emptyOptions());
		

		
	}
	protected View createNewView() 
	{
		
		return new View();		
	}
	
	protected void checkParamsForUpdatingView(RetailScmUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ViewManagerException exception = new ViewManagerException("Error Occured");
		
		checkIdOfView(userContext, viewId, exception);
		checkVersionOfView(userContext, viewVersion, exception);
		

		if(View.WHO_PROPERTY.equals(property)){
			checkWhoOfView(userContext, parseString(newValueExpr), exception);
		}
		if(View.ASSESSMENT_PROPERTY.equals(property)){
			checkAssessmentOfView(userContext, parseString(newValueExpr), exception);
		}
		if(View.INTERVIEW_TIME_PROPERTY.equals(property)){
			checkInterviewTimeOfView(userContext, parseDate(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public View clone(RetailScmUserContext userContext, String fromViewId) throws Exception{
		
		return this.getViewDAO().clone(fromViewId, this.allTokens());
	}
	
	public View updateView(RetailScmUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingView(userContext, viewId, viewVersion, property, newValueExpr, tokensExpr);
		
		View view = loadView(userContext, viewId, allTokens());
		if(view.getVersion() != viewVersion){
			String message = "The target version("+view.getVersion()+") is not equals to version("+viewVersion+") provided";
			throw new ViewManagerException(message);
		}
		synchronized(view){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to View.
			
			view.changePropery(property, newValueExpr);
			view = saveView(userContext, view, tokens().done());
			return present(userContext,view, mergedAllTokens(tokensExpr));
			//return saveView(userContext, view, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ViewTokens tokens(){
		return ViewTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ViewTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ViewTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String viewId, int viewVersion) throws Exception {
		
		deleteInternal(userContext, viewId, viewVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String viewId, int viewVersion) throws Exception{
		getViewDAO().delete(viewId, viewVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ViewManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getViewDAO().deleteAll();
	}


}


