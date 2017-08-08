
package com.skynet.retailscm.report;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ReportDAO{

	
	public Report load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Report present(Report report,Map<String,Object> options) throws Exception;
	public Report clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Report save(Report report,Map<String,Object> options);
	public SmartList<Report> saveReportList(SmartList<Report> reportList,Map<String,Object> options);
	public SmartList<Report> removeReportList(SmartList<Report> reportList,Map<String,Object> options);
	
	public void delete(String reportId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Report> findReportByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countReportByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<Report> findReportByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


