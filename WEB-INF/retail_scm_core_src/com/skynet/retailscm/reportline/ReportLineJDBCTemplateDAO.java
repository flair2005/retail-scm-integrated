
package com.skynet.retailscm.reportline;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.report.Report;

import com.skynet.retailscm.report.ReportDAO;

import com.skynet.retailscm.report.ReportTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class ReportLineJDBCTemplateDAO extends CommonJDBCTemplateDAO implements ReportLineDAO{
 
 	
 	private  ReportDAO  reportDAO;
 	public void setReportDAO(ReportDAO reportDAO){
	 	this.reportDAO = reportDAO;
 	}
 	public ReportDAO getReportDAO(){
	 	return this.reportDAO;
 	}

		

	
	/*
	protected ReportLine load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalReportLine(accessKey, options);
	}
	*/
	public ReportLine load(String id,Map<String,Object> options) throws Exception{
		return loadInternalReportLine(ReportLineTable.withId(id), options);
	}
	
	
	
	public ReportLine save(ReportLine reportLine,Map<String,Object> options){
		
		String methodName="save(ReportLine reportLine,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(reportLine, methodName, "reportLine");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalReportLine(reportLine,options);
	}
	public ReportLine clone(String reportLineId, Map<String,Object> options) throws Exception{
	
		return clone(ReportLineTable.withId(reportLineId),options);
	}
	
	protected ReportLine clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String reportLineId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ReportLine newReportLine = loadInternalReportLine(accessKey, options);
		newReportLine.setVersion(0);
		
		

		
		saveInternalReportLine(newReportLine,options);
		
		return newReportLine;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String reportLineId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{reportLineId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new ReportLineVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ReportLineNotFoundException(
					"The " + this.getTableName() + "(" + reportLineId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String reportLineId, int version) throws Exception{
	
		String methodName="delete(String reportLineId, int version)";
		assertMethodArgumentNotNull(reportLineId, methodName, "reportLineId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{reportLineId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(reportLineId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","owner","january","february","march","april","may","june","july","august","september","october","november","december"};
		return ReportLineTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "report_line";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ReportLineTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ReportLineTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ReportLineTokens.OWNER);
 	}
 	

 	
 
		

	

	protected ReportLineMapper getReportLineMapper(){
		return new ReportLineMapper();
	}
	protected ReportLine extractReportLine(String reportLineId) throws Exception{
		String SQL = "select * from report_line_data where id = ?";	
		try{
		
			ReportLine reportLine = queryForObject(SQL, new Object[]{reportLineId}, getReportLineMapper());
			return reportLine;
		}catch(EmptyResultDataAccessException e){
			throw new ReportLineNotFoundException("ReportLine("+reportLineId+") is not found!");
		}
		
		
	}
	protected ReportLine extractReportLine(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from report_line_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			ReportLine reportLine = queryForObject(SQL, new Object[]{accessKey.getValue()}, getReportLineMapper());
			return reportLine;
		}catch(EmptyResultDataAccessException e){
			throw new ReportLineNotFoundException("ReportLine("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected ReportLine loadInternalReportLine(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ReportLine reportLine = extractReportLine(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(reportLine, loadOptions);
 		}
 
		
		return reportLine;
		
	}



	
	
	 

 	protected ReportLine extractOwner(ReportLine reportLine, Map<String,Object> options) throws Exception{

		if(reportLine.getOwner() == null){
			return reportLine;
		}
		String ownerId = reportLine.getOwner().getId();
		if( ownerId == null){
			return reportLine;
		}
		Report owner = getReportDAO().load(ownerId,options);
		if(owner != null){
			reportLine.setOwner(owner);
		}
		
 		
 		return reportLine;
 	}
 		
 
		
		
  	
 	public SmartList<ReportLine> findReportLineByOwner(String reportId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<ReportLine> reportLineList = queryForList(SQL, new Object[]{reportId}, getReportLineMapper());	
 		return reportLineList;
 	}
 	
 	public SmartList<ReportLine> findReportLineByOwner(String reportId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<ReportLine> reportLineList = queryForList(SQL, new Object[]{reportId,start, count}, getReportLineMapper());
		
 		return reportLineList;
 	}
 	
 	public int countReportLineByOwner(String reportId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{reportId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected ReportLine saveReportLine(ReportLine  reportLine){
	
		String SQL=this.getSaveReportLineSQL(reportLine);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveReportLineParameters(reportLine);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		reportLine.incVersion();
		return reportLine;
	
	}
	public SmartList<ReportLine> saveReportLineList(SmartList<ReportLine> reportLineList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitReportLineList(reportLineList);
		
		batchReportLineCreate((List<ReportLine>)lists[CREATE_LIST_INDEX]);
		
		batchReportLineUpdate((List<ReportLine>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ReportLine reportLine:reportLineList){
			if(reportLine.isChanged()){
				reportLine.incVersion();
			}
			
		
		}
		
		
		return reportLineList;
	}

	public SmartList<ReportLine> removeReportLineList(SmartList<ReportLine> reportLineList,Map<String,Object> options){
		
		
		super.removeList(reportLineList, options);
		
		return reportLineList;
		
		
	}
	
	protected List<Object[]> prepareReportLineBatchCreateArgs(List<ReportLine> reportLineList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ReportLine reportLine:reportLineList ){
			Object [] parameters = prepareReportLineCreateParameters(reportLine);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareReportLineBatchUpdateArgs(List<ReportLine> reportLineList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ReportLine reportLine:reportLineList ){
			if(!reportLine.isChanged()){
				continue;
			}
			Object [] parameters = prepareReportLineUpdateParameters(reportLine);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchReportLineCreate(List<ReportLine> reportLineList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareReportLineBatchCreateArgs(reportLineList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchReportLineUpdate(List<ReportLine> reportLineList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareReportLineBatchUpdateArgs(reportLineList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitReportLineList(List<ReportLine> reportLineList){
		
		List<ReportLine> reportLineCreateList=new ArrayList<ReportLine>();
		List<ReportLine> reportLineUpdateList=new ArrayList<ReportLine>();
		
		for(ReportLine reportLine: reportLineList){
			if(isUpdateRequest(reportLine)){
				reportLineUpdateList.add( reportLine);
				continue;
			}
			reportLineCreateList.add(reportLine);
		}
		
		return new Object[]{reportLineCreateList,reportLineUpdateList};
	}
	
	protected boolean isUpdateRequest(ReportLine reportLine){
 		return reportLine.getVersion() > 0;
 	}
 	protected String getSaveReportLineSQL(ReportLine reportLine){
 		if(isUpdateRequest(reportLine)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveReportLineParameters(ReportLine reportLine){
 		if(isUpdateRequest(reportLine) ){
 			return prepareReportLineUpdateParameters(reportLine);
 		}
 		return prepareReportLineCreateParameters(reportLine);
 	}
 	protected Object[] prepareReportLineUpdateParameters(ReportLine reportLine){
 		Object[] parameters = new Object[16];
 
 		parameters[0] = reportLine.getName(); 	
 		if(reportLine.getOwner() != null){
 			parameters[1] = reportLine.getOwner().getId();
 		}
 
 		parameters[2] = reportLine.getJanuary();
 		parameters[3] = reportLine.getFebruary();
 		parameters[4] = reportLine.getMarch();
 		parameters[5] = reportLine.getApril();
 		parameters[6] = reportLine.getMay();
 		parameters[7] = reportLine.getJune();
 		parameters[8] = reportLine.getJuly();
 		parameters[9] = reportLine.getAugust();
 		parameters[10] = reportLine.getSeptember();
 		parameters[11] = reportLine.getOctober();
 		parameters[12] = reportLine.getNovember();
 		parameters[13] = reportLine.getDecember();		
 		parameters[14] = reportLine.getId();
 		parameters[15] = reportLine.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareReportLineCreateParameters(ReportLine reportLine){
		Object[] parameters = new Object[15];
		String newReportLineId=getNextId();
		reportLine.setId(newReportLineId);
		parameters[0] =  reportLine.getId();
 
 		parameters[1] = reportLine.getName(); 	
 		if(reportLine.getOwner() != null){
 			parameters[2] = reportLine.getOwner().getId();
 		
 		}
 		
 		parameters[3] = reportLine.getJanuary();
 		parameters[4] = reportLine.getFebruary();
 		parameters[5] = reportLine.getMarch();
 		parameters[6] = reportLine.getApril();
 		parameters[7] = reportLine.getMay();
 		parameters[8] = reportLine.getJune();
 		parameters[9] = reportLine.getJuly();
 		parameters[10] = reportLine.getAugust();
 		parameters[11] = reportLine.getSeptember();
 		parameters[12] = reportLine.getOctober();
 		parameters[13] = reportLine.getNovember();
 		parameters[14] = reportLine.getDecember();		
 				
 		return parameters;
 	}
 	
	protected ReportLine saveInternalReportLine(ReportLine reportLine, Map<String,Object> options){
		
		saveReportLine(reportLine);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(reportLine, options);
 		}
 
		
		return reportLine;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ReportLine saveOwner(ReportLine reportLine, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(reportLine.getOwner() == null){
 			return reportLine;//do nothing when it is null
 		}
 		
 		getReportDAO().save(reportLine.getOwner(),options);
 		return reportLine;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public ReportLine present(ReportLine reportLine,Map<String, Object> options){
	

		return reportLine;
	
	}
		


	protected String getTableName(){
		return ReportLineTable.TABLE_NAME;
	}
}


