
package com.skynet.retailscm.report;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.reportline.ReportLine;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.report.Report;


import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.reportline.ReportLineTable;




public class ReportManagerImpl extends RetailScmCheckerManager implements ReportManager {
	
	private static final String SERVICE_TYPE = "Report";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  ReportDAO  reportDAO;
 	public void setReportDAO(ReportDAO  reportDAO){
 	
 		if(reportDAO == null){
 			throw new IllegalStateException("Do not try to set reportDAO to null.");
 		}
	 	this.reportDAO = reportDAO;
 	}
 	public ReportDAO getReportDAO(){
 		if(this.reportDAO == null){
 			throw new IllegalStateException("The ReportDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.reportDAO;
 	}
 	
 	protected Report saveReport(RetailScmUserContext userContext, Report report, String [] tokensExpr) throws Exception{	
 		//return getReportDAO().save(report, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveReport(userContext, report, tokens);
 	}
 	
 	protected Report saveReportDetail(RetailScmUserContext userContext, Report report) throws Exception{	

 		
 		return saveReport(userContext, report, allTokens());
 	}
 	
 	public Report loadReport(RetailScmUserContext userContext, String reportId, String [] tokensExpr) throws Exception{				
 
 		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Report report = loadReport( userContext, reportId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,report, tokens);
 	}
 	
 	protected Report present(RetailScmUserContext userContext, Report report, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,report,tokens);
		
		
		return this.getReportDAO().present(report, tokens);
	}
 
 	
 	
 	public Report loadReportDetail(RetailScmUserContext userContext, String reportId) throws Exception{	
 		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Report report = loadReport( userContext, reportId, allTokens());

 		return present(userContext,report, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String reportId) throws Exception{	
 		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		Report report = loadReport( userContext, reportId, allTokens());

 		return present(userContext,report, allTokens());
		
 	}
 	protected Report saveReport(RetailScmUserContext userContext, Report report, Map<String,Object>tokens) throws Exception{	
 		return getReportDAO().save(report, tokens);
 	}
 	protected Report loadReport(RetailScmUserContext userContext, String reportId, Map<String,Object>tokens) throws Exception{	
 		return getReportDAO().load(reportId, tokens);
 	}

	



 	 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	//------------------------------------
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Report report, Map<String, Object> tokens){
		super.addActions(userContext, report, tokens);
		
		addAction(userContext, report, tokens,"@create","createReport","createReport/","main","primary");
		addAction(userContext, report, tokens,"@update","updateReport","updateReport/"+report.getId()+"/","main","primary");
		addAction(userContext, report, tokens,"@copy","cloneReport","cloneReport/"+report.getId()+"/","main","primary");
		
		addAction(userContext, report, tokens,"report.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+report.getId()+"/","main","primary");
		addAction(userContext, report, tokens,"report.addReportLine","addReportLine","addReportLine/"+report.getId()+"/","reportLineList","primary");
		addAction(userContext, report, tokens,"report.removeReportLine","removeReportLine","removeReportLine/"+report.getId()+"/","reportLineList","primary");
		addAction(userContext, report, tokens,"report.updateReportLine","updateReportLine","updateReportLine/"+report.getId()+"/","reportLineList","primary");
		addAction(userContext, report, tokens,"report.copyReportLineFrom","copyReportLineFrom","copyReportLineFrom/"+report.getId()+"/","reportLineList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, Report report, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Report createReport(RetailScmUserContext userContext,String name, String createdBy, String ownerId
) throws Exception
	{
		
		ReportManagerException exception = new ReportManagerException("Error Occured");

		

		checkNameOfReport(userContext,  name, exception);
		checkCreatedByOfReport(userContext,  createdBy, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		Report report=createNewReport();	

		report.setName(name);
		report.setCreatedBy(createdBy);
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(ownerId,emptyOptions());
		report.setOwner(owner);

		return saveReport(userContext, report, emptyOptions());
		

		
	}
	protected Report createNewReport() 
	{
		
		return new Report();		
	}
	
	protected void checkParamsForUpdatingReport(RetailScmUserContext userContext,String reportId, int reportVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);
		checkVersionOfReport(userContext, reportVersion, exception);
		

		if(Report.NAME_PROPERTY.equals(property)){
			checkNameOfReport(userContext, parseString(newValueExpr), exception);
		}
		if(Report.CREATED_BY_PROPERTY.equals(property)){
			checkCreatedByOfReport(userContext, parseString(newValueExpr), exception);
		}		

		
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public Report clone(RetailScmUserContext userContext, String fromReportId) throws Exception{
		
		return this.getReportDAO().clone(fromReportId, this.allTokens());
	}
	
	public Report updateReport(RetailScmUserContext userContext,String reportId, int reportVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingReport(userContext, reportId, reportVersion, property, newValueExpr, tokensExpr);
		
		Report report = loadReport(userContext, reportId, allTokens());
		if(report.getVersion() != reportVersion){
			String message = "The target version("+report.getVersion()+") is not equals to version("+reportVersion+") provided";
			throw new ReportManagerException(message);
		}
		synchronized(report){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Report.
			
			report.changePropery(property, newValueExpr);
			report = saveReport(userContext, report, tokens().done());
			return present(userContext,report, mergedAllTokens(tokensExpr));
			//return saveReport(userContext, report, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ReportTokens tokens(){
		return ReportTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ReportTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ReportTokens.mergeAll(tokens).done();
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
	
	protected void checkParamsForTransferingAnotherOwner(RetailScmUserContext userContext, String reportId, String anotherOwnerId) throws Exception
 	{
 		ReportManagerException exception = new ReportManagerException("Error Occured");
 		checkIdOfReport(userContext, reportId,exception);
 		checkIdOfRetailStoreCountryCenter(userContext, anotherOwnerId,exception);
 		throwExceptionIfHasErrors(userContext, exception);
 		
 	}
 	public Report transferToAnotherOwner(RetailScmUserContext userContext, String reportId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, reportId,anotherOwnerId);
 
		Report report = loadReport(userContext, reportId, allTokens());	
		synchronized(report){
			//will be good when the report loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(anotherOwnerId, emptyOptions());		
			report.setOwner(owner);		
			report = saveReport(userContext, report, emptyOptions());
			
			return present(userContext,report, allTokens());
			
		}

 	}

 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return getRetailStoreCountryCenterDAO().load(newOwnerId, options);
 	}
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String reportId, int reportVersion) throws Exception {
		
		deleteInternal(userContext, reportId, reportVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String reportId, int reportVersion) throws Exception{
		getReportDAO().delete(reportId, reportVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ReportManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getReportDAO().deleteAll();
	}

	protected void checkParamsForAddingReportLine(RetailScmUserContext userContext, String reportId, String name, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december,String [] tokensExpr) throws Exception{
		
		

		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);

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

	
	}
	public  Report addReportLine(RetailScmUserContext userContext, String reportId, String name, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingReportLine(userContext,reportId,name, january, february, march, april, may, june, july, august, september, october, november, december,tokensExpr);
		
		ReportLine reportLine = createReportLine(userContext,name, january, february, march, april, may, june, july, august, september, october, november, december);
		
		Report report = loadReport(userContext, reportId, allTokens());
		synchronized(report){ 
			//Will be good when the report loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			report.addReportLine( reportLine );		
			report = saveReport(userContext, report, tokens().withReportLineList().done());
			return present(userContext,report, mergedAllTokens(tokensExpr));
		}
	}
	protected ReportLine createReportLine(RetailScmUserContext userContext, String name, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december) throws Exception{

		ReportLine reportLine = new ReportLine();
		
		
		reportLine.setName(name);		
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
	
		
		return reportLine;
	
		
	}
	
	protected ReportLine createIndexedReportLine(String id, int version){

		ReportLine reportLine = new ReportLine();
		reportLine.setId(id);
		reportLine.setVersion(version);
		return reportLine;			
		
	}
	protected void checkParamsForRemovingReportLine(RetailScmUserContext userContext, String reportId, 
		String reportLineId, int reportLineVersion,String [] tokensExpr) throws Exception{
		

		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);
		checkIdOfReportLine(userContext, reportLineId, exception);
		checkVersionOfReportLine(userContext, reportLineVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Report removeReportLine(RetailScmUserContext userContext, String reportId, 
		String reportLineId, int reportLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingReportLine(userContext,reportId, reportLineId, reportLineVersion,tokensExpr);
		
		ReportLine reportLine = createIndexedReportLine(reportLineId, reportLineVersion);
		Report report = loadReport(userContext, reportId, allTokens());
		synchronized(report){ 
			//Will be good when the report loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			report.removeReportLine( reportLine );		
			report = saveReport(userContext, report, tokens().withReportLineList().done());
			return present(userContext,report, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingReportLine(RetailScmUserContext userContext, String reportId, 
		String reportLineId, int reportLineVersion,String [] tokensExpr) throws Exception{
		

		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);
		checkIdOfReportLine(userContext, reportLineId, exception);
		checkVersionOfReportLine(userContext, reportLineVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  Report copyReportLineFrom(RetailScmUserContext userContext, String reportId, 
		String reportLineId, int reportLineVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingReportLine(userContext,reportId, reportLineId, reportLineVersion,tokensExpr);
		
		ReportLine reportLine = createIndexedReportLine(reportLineId, reportLineVersion);
		Report report = loadReport(userContext, reportId, allTokens());
		synchronized(report){ 
			//Will be good when the report loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			report.copyReportLineFrom( reportLine );		
			report = saveReport(userContext, report, tokens().withReportLineList().done());
			return present(userContext,report, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingReportLine(RetailScmUserContext userContext, String reportId, String reportLineId, int reportLineVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		ReportManagerException exception = new ReportManagerException("Error Occured");
		
		checkIdOfReport(userContext, reportId, exception);
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
	
	public  Report updateReportLine(RetailScmUserContext userContext, String reportId, String reportLineId, int reportLineVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingReportLine(userContext, reportId, reportLineId, reportLineVersion, property, newValueExpr,  tokensExpr);
		
		
		Report report = loadReport(userContext, reportId, allTokens());
		
		synchronized(report){ 
			//Will be good when the report loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//report.removeReportLine( reportLine );	
			//make changes to AcceleraterAccount.
			ReportLine reportLineIndex = createIndexedReportLine(reportLineId, reportLineVersion);
		
			ReportLine reportLine = report.findTheReportLine(reportLineIndex);
			if(reportLine == null){
				throw new ReportManagerException(reportLine+"Not found" );
			}
			
			reportLine.changePropery(property, newValueExpr);

			report = saveReport(userContext, report, tokens().withReportLineList().done());
			return present(userContext,report, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


