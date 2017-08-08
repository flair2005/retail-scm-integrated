
package com.skynet.retailscm.reportline;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.report.Report;

import com.skynet.retailscm.report.ReportDAO;



import com.skynet.retailscm.report.ReportTable;




public class ReportLineManagerImpl extends RetailScmCheckerManager implements ReportLineManager {
	
	private static final String SERVICE_TYPE = "ReportLine";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ReportLineDAO  reportLineDAO;
 	public void setReportLineDAO(ReportLineDAO  reportLineDAO){
 	
 		if(reportLineDAO == null){
 			throw new IllegalStateException("Do not try to set reportLineDAO to null.");
 		}
	 	this.reportLineDAO = reportLineDAO;
 	}
 	public ReportLineDAO getReportLineDAO(){
 		if(this.reportLineDAO == null){
 			throw new IllegalStateException("The ReportLineDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.reportLineDAO;
 	}
 	
 	protected ReportLine saveReportLine(RetailScmUserContext userContext, ReportLine reportLine, String [] tokensExpr) throws Exception{	
 		//return getReportLineDAO().save(reportLine, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveReportLine(userContext, reportLine, tokens);
 	}
 	
 	protected ReportLine saveReportLineDetail(RetailScmUserContext userContext, ReportLine reportLine) throws Exception{	

 		
 		return saveReportLine(userContext, reportLine, allTokens());
 	}
 	
 	public ReportLine loadReportLine(RetailScmUserContext userContext, String reportLineId, String [] tokensExpr) throws Exception{				
 
 		ReportLineManagerException exception = new ReportLineManagerException("Error Occured");
		
		checkIdOfReportLine(userContext, reportLineId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ReportLine reportLine = loadReportLine( userContext, reportLineId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,reportLine, tokens);
 	}
 	
 	protected ReportLine present(RetailScmUserContext userContext, ReportLine reportLine, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,reportLine,tokens);
		
		
		return this.getReportLineDAO().present(reportLine, tokens);
	}
 
 	
 	
 	public ReportLine loadReportLineDetail(RetailScmUserContext userContext, String reportLineId) throws Exception{	
 		ReportLineManagerException exception = new ReportLineManagerException("Error Occured");
		
		checkIdOfReportLine(userContext, reportLineId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ReportLine reportLine = loadReportLine( userContext, reportLineId, allTokens());

 		return present(userContext,reportLine, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String reportLineId) throws Exception{	
 		ReportLineManagerException exception = new ReportLineManagerException("Error Occured");
		
		checkIdOfReportLine(userContext, reportLineId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		ReportLine reportLine = loadReportLine( userContext, reportLineId, allTokens());

 		return present(userContext,reportLine, allTokens());
		
 	}
 	protected ReportLine saveReportLine(RetailScmUserContext userContext, ReportLine reportLine, Map<String,Object>tokens) throws Exception{	
 		return getReportLineDAO().save(reportLine, tokens);
 	}
 	protected ReportLine loadReportLine(RetailScmUserContext userContext, String reportLineId, Map<String,Object>tokens) throws Exception{	
 		return getReportLineDAO().load(reportLineId, tokens);
 	}

	



 	 
 	
 	private  ReportDAO  reportDAO;
 	public void setReportDAO(ReportDAO reportDAO){
	 	this.reportDAO = reportDAO;
 	}
 	//------------------------------------
 	public ReportDAO getReportDAO(){
	 	return this.reportDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ReportLine reportLine, Map<String, Object> tokens){
		super.addActions(userContext, reportLine, tokens);
		
		addAction(userContext, reportLine, tokens,"@create","createReportLine","createReportLine/","main","primary");
		addAction(userContext, reportLine, tokens,"@update","updateReportLine","updateReportLine/"+reportLine.getId()+"/","main","primary");
		addAction(userContext, reportLine, tokens,"@copy","cloneReportLine","cloneReportLine/"+reportLine.getId()+"/","main","primary");
		
		addAction(userContext, reportLine, tokens,"report_line.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+reportLine.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, ReportLine reportLine, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ReportLine createReportLine(RetailScmUserContext userContext,String name, String ownerId, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december
) throws Exception
	{
		
		ReportLineManagerException exception = new ReportLineManagerException("Error Occured");

		

		checkNameOfReportLine(userContext,  name, exception);
		checkJanuaryOfReportLine(userContext,  january, exception);
		checkFebruaryOfReportLine(userContext,  february, exception);
		checkMarchOfReportLine(userContext,  march, exception);
		checkAprilOfReportLine(userContext,  april, exception);
		checkMayOfReportLine(userContext,  may, exception);
		checkJuneOfReportLine(userContext,  june, exception);
		checkJulyOfReportLine(userContext,  july, exception);
		checkAugustOfReportLine(userContext,  august, exception);
		checkSeptemberOfReportLine(userContext,  september, exception);
		checkOctoberOfReportLine(userContext,  october, exception);
		checkNovemberOfReportLine(userContext,  november, exception);
		checkDecemberOfReportLine(userContext,  december, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		ReportLine reportLine=createNewReportLine();	

		reportLine.setName(name);
		Report owner = loadReport(ownerId,emptyOptions());
		reportLine.setOwner(owner);
		reportLine.setJanuary(january);
		reportLine.setFebruary(february);
		reportLine.setMarch(march);
		reportLine.setApril(april);
		reportLine.setMay(may);
		reportLine.setJune(june);
		reportLine.setJuly(july);
		reportLine.setAugust(august);
		reportLine.setSeptember(september);
		reportLine.setOctober(october);
		reportLine.setNovember(november);
		reportLine.setDecember(december);

		return saveReportLine(userContext, reportLine, emptyOptions());
		

		
	}
	protected ReportLine createNewReportLine() 
	{
		
		return new ReportLine();		
	}
	
	protected void checkParamsForUpdatingReportLine(RetailScmUserContext userContext,String reportLineId, int reportLineVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ReportLineManagerException exception = new ReportLineManagerException("Error Occured");
		
		checkIdOfReportLine(userContext, reportLineId, exception);
		checkVersionOfReportLine(userContext, reportLineVersion, exception);
		

		if(ReportLine.NAME_PROPERTY.equals(property)){
			checkNameOfReportLine(userContext, parseString(newValueExpr), exception);
		}		

		
		if(ReportLine.JANUARY_PROPERTY.equals(property)){
			checkJanuaryOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.FEBRUARY_PROPERTY.equals(property)){
			checkFebruaryOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.MARCH_PROPERTY.equals(property)){
			checkMarchOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.APRIL_PROPERTY.equals(property)){
			checkAprilOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.MAY_PROPERTY.equals(property)){
			checkMayOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.JUNE_PROPERTY.equals(property)){
			checkJuneOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.JULY_PROPERTY.equals(property)){
			checkJulyOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.AUGUST_PROPERTY.equals(property)){
			checkAugustOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.SEPTEMBER_PROPERTY.equals(property)){
			checkSeptemberOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.OCTOBER_PROPERTY.equals(property)){
			checkOctoberOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.NOVEMBER_PROPERTY.equals(property)){
			checkNovemberOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
		if(ReportLine.DECEMBER_PROPERTY.equals(property)){
			checkDecemberOfReportLine(userContext, parseDouble(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public ReportLine clone(RetailScmUserContext userContext, String fromReportLineId) throws Exception{
		
		return this.getReportLineDAO().clone(fromReportLineId, this.allTokens());
	}
	
	public ReportLine updateReportLine(RetailScmUserContext userContext,String reportLineId, int reportLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingReportLine(userContext, reportLineId, reportLineVersion, property, newValueExpr, tokensExpr);
		
		ReportLine reportLine = loadReportLine(userContext, reportLineId, allTokens());
		if(reportLine.getVersion() != reportLineVersion){
			String message = "The target version("+reportLine.getVersion()+") is not equals to version("+reportLineVersion+") provided";
			throw new ReportLineManagerException(message);
		}
		synchronized(reportLine){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ReportLine.
			
			reportLine.changePropery(property, newValueExpr);
			reportLine = saveReportLine(userContext, reportLine, tokens().done());
			return present(userContext,reportLine, mergedAllTokens(tokensExpr));
			//return saveReportLine(userContext, reportLine, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ReportLineTokens tokens(){
		return ReportLineTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ReportLineTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ReportLineTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String reportLineId, String anotherOwnerId) throws Exception
 	{
 		ReportLineManagerException exception = new ReportLineManagerException("Error Occured");
 		checkIdOfReportLine(userContext, reportLineId,exception);
 		checkIdOfReport(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public ReportLine transferToAnotherOwner(RetailScmUserContext userContext, String reportLineId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, reportLineId,anotherOwnerId);
 
		ReportLine reportLine = loadReportLine(userContext, reportLineId, allTokens());	
		synchronized(reportLine){
			//will be good when the reportLine loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Report owner = loadReport(anotherOwnerId, emptyOptions());		
			reportLine.setOwner(owner);		
			reportLine = saveReportLine(userContext, reportLine, emptyOptions());
			
			return present(userContext,reportLine, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected Report loadReport(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getReportDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String reportLineId, int reportLineVersion) throws Exception {
		
		deleteInternal(userContext, reportLineId, reportLineVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String reportLineId, int reportLineVersion) throws Exception{
		getReportLineDAO().delete(reportLineId, reportLineVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ReportLineManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getReportLineDAO().deleteAll();
	}


}


