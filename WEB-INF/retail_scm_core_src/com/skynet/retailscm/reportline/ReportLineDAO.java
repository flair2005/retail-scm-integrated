
package com.skynet.retailscm.reportline;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ReportLineDAO{

	
	public ReportLine load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ReportLine present(ReportLine reportLine,Map<String,Object> options) throws Exception;
	public ReportLine clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ReportLine save(ReportLine reportLine,Map<String,Object> options);
	public SmartList<ReportLine> saveReportLineList(SmartList<ReportLine> reportLineList,Map<String,Object> options);
	public SmartList<ReportLine> removeReportLineList(SmartList<ReportLine> reportLineList,Map<String,Object> options);
	
	public void delete(String reportLineId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ReportLine> findReportLineByOwner(String reportId, Map<String,Object> options);
 	public int countReportLineByOwner(String reportId, Map<String,Object> options);
 	public SmartList<ReportLine> findReportLineByOwner(String reportId, int start, int count, Map<String,Object> options);
 
 }


