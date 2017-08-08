
package com.skynet.retailscm.report;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.reportline.ReportLine;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.reportline.ReportLineDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.reportline.ReportLineTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ReportJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ReportDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  ReportLineDAO  reportLineDAO;
 	public void setReportLineDAO(ReportLineDAO pReportLineDAO){
 	
 		if(pReportLineDAO == null){
 			throw new IllegalStateException("Do not try to set reportLineDAO to null.");
 		}
	 	this.reportLineDAO = pReportLineDAO;
 	}
 	public ReportLineDAO getReportLineDAO(){
 		if(this.reportLineDAO == null){
 			throw new IllegalStateException("The reportLineDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.reportLineDAO;
 	}	
 	
			
		

	
	/*
	protected Report load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalReport(accessKey, options);
	}
	*/
	public Report load(String id,Map<String,Object> options) throws Exception{
		return loadInternalReport(ReportTable.withId(id), options);
	}
	
	
	
	public Report save(Report report,Map<String,Object> options){
		
		String methodName="save(Report report,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(report, methodName, "report");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalReport(report,options);
	}
	public Report clone(String reportId, Map<String,Object> options) throws Exception{
	
		return clone(ReportTable.withId(reportId),options);
	}
	
	protected Report clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String reportId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Report newReport = loadInternalReport(accessKey, options);
		newReport.setVersion(0);
		
		
 		
 		if(isSaveReportLineListEnabled(options)){
 			for(ReportLine item: newReport.getReportLineList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalReport(newReport,options);
		
		return newReport;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String reportId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{reportId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ReportVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ReportNotFoundException(
					"The " + this.getTableName() + "(" + reportId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String reportId, int version) throws Exception{
	
		String methodName="delete(String reportId, int version)";
		assertMethodArgumentNotNull(reportId, methodName, "reportId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{reportId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(reportId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","created_by","owner"};
		return ReportTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "report";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ReportTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ReportTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ReportTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String REPORT_LINE_LIST = "reportLineList";
	
	protected boolean isExtractReportLineListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,ReportTokens.REPORT_LINE_LIST);
		
 	}

	protected boolean isSaveReportLineListEnabled(Map<String,Object> options){
		return checkOptions(options, ReportTokens.REPORT_LINE_LIST);
		
 	}
 	
 	
			
		

	

	protected ReportMapper getReportMapper(){
		return new ReportMapper();
	}
	protected Report extractReport(String reportId) throws Exception{
		String SQL = "select * from report_data where id = ?";	
		try{
		
			Report report = queryForObject(SQL, new Object[]{reportId}, getReportMapper());
			return report;
		}catch(EmptyResultDataAccessException e){
			throw new ReportNotFoundException("Report("+reportId+") is not found!");
		}
		
		
	}
	protected Report extractReport(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from report_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Report report = queryForObject(SQL, new Object[]{accessKey.getValue()}, getReportMapper());
			return report;
		}catch(EmptyResultDataAccessException e){
			throw new ReportNotFoundException("Report("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Report loadInternalReport(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Report report = extractReport(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(report, loadOptions);
 		}
 
		
		if(isExtractReportLineListEnabled(loadOptions)){
	 		extractReportLineList(report, loadOptions);
 		}		
		
		return report;
		
	}



	
	
	 

 	protected Report extractOwner(Report report, Map<String,Object> options) throws Exception{

		if(report.getOwner() == null){
			return report;
		}
		String ownerId = report.getOwner().getId();
		if( ownerId == null){
			return report;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			report.setOwner(owner);
		}
		
 		
 		return report;
 	}
 		
 
		
	protected Report extractReportLineList(Report report, Map<String,Object> options){
		
		SmartList<ReportLine> reportLineList = getReportLineDAO().findReportLineByOwner(report.getId(),options);
		if(reportLineList != null){
			report.setReportLineList(reportLineList);
		}
		
		return report;
	
	}	
		
		
  	
 	public SmartList<Report> findReportByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<Report> reportList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getReportMapper());	
 		return reportList;
 	}
 	
 	public SmartList<Report> findReportByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Report> reportList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getReportMapper());
		
 		return reportList;
 	}
 	
 	public int countReportByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Report saveReport(Report  report){
	
		String SQL=this.getSaveReportSQL(report);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveReportParameters(report);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		report.incVersion();
		return report;
	
	}
	public SmartList<Report> saveReportList(SmartList<Report> reportList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitReportList(reportList);
		
		batchReportCreate((List<Report>)lists[CREATE_LIST_INDEX]);
		
		batchReportUpdate((List<Report>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Report report:reportList){
			if(report.isChanged()){
				report.incVersion();
			}
			
		
		}
		
		
		return reportList;
	}

	public SmartList<Report> removeReportList(SmartList<Report> reportList,Map<String,Object> options){
		
		
		super.removeList(reportList, options);
		
		return reportList;
		
		
	}
	
	protected List<Object[]> prepareReportBatchCreateArgs(List<Report> reportList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Report report:reportList ){
			Object [] parameters = prepareReportCreateParameters(report);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareReportBatchUpdateArgs(List<Report> reportList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Report report:reportList ){
			if(!report.isChanged()){
				continue;
			}
			Object [] parameters = prepareReportUpdateParameters(report);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchReportCreate(List<Report> reportList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareReportBatchCreateArgs(reportList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchReportUpdate(List<Report> reportList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareReportBatchUpdateArgs(reportList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitReportList(List<Report> reportList){
		
		List<Report> reportCreateList=new ArrayList<Report>();
		List<Report> reportUpdateList=new ArrayList<Report>();
		
		for(Report report: reportList){
			if(isUpdateRequest(report)){
				reportUpdateList.add( report);
				continue;
			}
			reportCreateList.add(report);
		}
		
		return new Object[]{reportCreateList,reportUpdateList};
	}
	
	protected boolean isUpdateRequest(Report report){
 		return report.getVersion() > 0;
 	}
 	protected String getSaveReportSQL(Report report){
 		if(isUpdateRequest(report)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveReportParameters(Report report){
 		if(isUpdateRequest(report) ){
 			return prepareReportUpdateParameters(report);
 		}
 		return prepareReportCreateParameters(report);
 	}
 	protected Object[] prepareReportUpdateParameters(Report report){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = report.getName();
 		parameters[1] = report.getCreatedBy(); 	
 		if(report.getOwner() != null){
 			parameters[2] = report.getOwner().getId();
 		}
 		
 		parameters[3] = report.getId();
 		parameters[4] = report.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareReportCreateParameters(Report report){
		Object[] parameters = new Object[4];
		String newReportId=getNextId();
		report.setId(newReportId);
		parameters[0] =  report.getId();
 
 		parameters[1] = report.getName();
 		parameters[2] = report.getCreatedBy(); 	
 		if(report.getOwner() != null){
 			parameters[3] = report.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Report saveInternalReport(Report report, Map<String,Object> options){
		
		saveReport(report);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(report, options);
 		}
 
		
		if(isSaveReportLineListEnabled(options)){
	 		saveReportLineList(report, options);
	 		removeReportLineList(report, options);
	 		
 		}		
		
		return report;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Report saveOwner(Report report, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(report.getOwner() == null){
 			return report;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(report.getOwner(),options);
 		return report;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Report saveReportLineList(Report report, Map<String,Object> options){
		SmartList<ReportLine> reportLineList = report.getReportLineList();
		if(reportLineList == null){
			return report;
		}
		if(reportLineList.isEmpty()){
			return report;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getReportLineDAO().saveReportLineList(reportLineList,options);
		
		return report;
	
	}
	
	protected Report removeReportLineList(Report report, Map<String,Object> options){
	
	
		SmartList<ReportLine> reportLineList = report.getReportLineList();
		if(reportLineList == null){
			return report;
		}	
	
		SmartList<ReportLine> toRemoveReportLineList = reportLineList.getToRemoveList();
		
		if(toRemoveReportLineList == null){
			return report;
		}
		if(toRemoveReportLineList.isEmpty()){
			return report;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getReportLineDAO().removeReportLineList(toRemoveReportLineList,options);
		
		return report;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Report present(Report report,Map<String, Object> options){
	
		presentReportLineList(report,options);

		return report;
	
	}
		
	
  	
 	protected Report presentReportLineList(
			Report report,
			Map<String, Object> options) {

		SmartList<ReportLine> reportLineList = report.getReportLineList();		
		if(reportLineList == null){
			return report;			
		}
		
		String targetObjectName = "reportLine";
		int reportLineListSize = reportLineList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(reportLineListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return report;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = reportLineListSize;
		if(reportLineListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getReportLineDAO().countReportLineByOwner(report.getId(), options);			
		}
		//report.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//report.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(reportLineListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(reportLineListSize,currentPage,rowsPerPage) ;
			reportLineList = reportLineList.subListOf(fromIndex, toIndex);
			reportLineList.setTotalCount(count);
			reportLineList.setCurrentPageNumber(currentPage);			
			report.setReportLineList(reportLineList);
			return report;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		reportLineList 
			= getReportLineDAO().findReportLineByOwner(report.getId(),start, rowsPerPage, options );
		reportLineList.setTotalCount(count);
		reportLineList.setCurrentPageNumber(currentPage);
		report.setReportLineList(reportLineList );	

		return report;
	}			
		


	protected String getTableName(){
		return ReportTable.TABLE_NAME;
	}
}


