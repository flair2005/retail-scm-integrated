
package com.skynet.retailscm.reportline;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.skynet.retailscm.BaseRowMapper;
import com.skynet.retailscm.report.Report;

public class ReportLineMapper extends BaseRowMapper<ReportLine>{
	
	protected ReportLine internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ReportLine reportLine = getReportLine();		
		 		
 		setId(reportLine, rs, rowNumber); 		
 		setName(reportLine, rs, rowNumber); 		
 		setOwner(reportLine, rs, rowNumber); 		
 		setJanuary(reportLine, rs, rowNumber); 		
 		setFebruary(reportLine, rs, rowNumber); 		
 		setMarch(reportLine, rs, rowNumber); 		
 		setApril(reportLine, rs, rowNumber); 		
 		setMay(reportLine, rs, rowNumber); 		
 		setJune(reportLine, rs, rowNumber); 		
 		setJuly(reportLine, rs, rowNumber); 		
 		setAugust(reportLine, rs, rowNumber); 		
 		setSeptember(reportLine, rs, rowNumber); 		
 		setOctober(reportLine, rs, rowNumber); 		
 		setNovember(reportLine, rs, rowNumber); 		
 		setDecember(reportLine, rs, rowNumber); 		
 		setVersion(reportLine, rs, rowNumber);

		return reportLine;
	}
	
	protected ReportLine getReportLine(){
		return new ReportLine();
	}		
		
	protected void setId(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ReportLineTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setId(id);
	}
		
	protected void setName(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ReportLineTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setName(name);
	}
		 		
 	protected void setOwner(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
 		String reportId = rs.getString(ReportLineTable.COLUMN_OWNER);
 		if( reportId == null){
 			return;
 		}
 		if( reportId.isEmpty()){
 			return;
 		}
 		Report report = reportLine.getOwner();
 		if( report != null ){
 			//if the root object 'reportLine' already have the property, just set the id for it;
 			report.setId(reportId);
 			return;
 		}
 		reportLine.setOwner(createEmptyOwner(reportId));
 	}
 	
	protected void setJanuary(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double january = rs.getDouble(ReportLineTable.COLUMN_JANUARY);
		if(january == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setJanuary(january);
	}
		
	protected void setFebruary(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double february = rs.getDouble(ReportLineTable.COLUMN_FEBRUARY);
		if(february == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setFebruary(february);
	}
		
	protected void setMarch(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double march = rs.getDouble(ReportLineTable.COLUMN_MARCH);
		if(march == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setMarch(march);
	}
		
	protected void setApril(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double april = rs.getDouble(ReportLineTable.COLUMN_APRIL);
		if(april == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setApril(april);
	}
		
	protected void setMay(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double may = rs.getDouble(ReportLineTable.COLUMN_MAY);
		if(may == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setMay(may);
	}
		
	protected void setJune(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double june = rs.getDouble(ReportLineTable.COLUMN_JUNE);
		if(june == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setJune(june);
	}
		
	protected void setJuly(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double july = rs.getDouble(ReportLineTable.COLUMN_JULY);
		if(july == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setJuly(july);
	}
		
	protected void setAugust(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double august = rs.getDouble(ReportLineTable.COLUMN_AUGUST);
		if(august == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setAugust(august);
	}
		
	protected void setSeptember(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double september = rs.getDouble(ReportLineTable.COLUMN_SEPTEMBER);
		if(september == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setSeptember(september);
	}
		
	protected void setOctober(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double october = rs.getDouble(ReportLineTable.COLUMN_OCTOBER);
		if(october == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setOctober(october);
	}
		
	protected void setNovember(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double november = rs.getDouble(ReportLineTable.COLUMN_NOVEMBER);
		if(november == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setNovember(november);
	}
		
	protected void setDecember(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double december = rs.getDouble(ReportLineTable.COLUMN_DECEMBER);
		if(december == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setDecember(december);
	}
		
	protected void setVersion(ReportLine reportLine, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ReportLineTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
	
		reportLine.setVersion(version);
	}
		
		

 	protected Report  createEmptyOwner(String reportId){
 		Report report = new Report();
 		report.setId(reportId);
 		return report;
 	}
 	
}


