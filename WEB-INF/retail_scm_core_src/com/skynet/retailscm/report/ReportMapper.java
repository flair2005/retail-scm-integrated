
package com.skynet.retailscm.report;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.skynet.retailscm.BaseRowMapper;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class ReportMapper extends BaseRowMapper<Report>{
	
	protected Report internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Report report = getReport();		
		 		
 		setId(report, rs, rowNumber); 		
 		setName(report, rs, rowNumber); 		
 		setCreatedBy(report, rs, rowNumber); 		
 		setOwner(report, rs, rowNumber); 		
 		setVersion(report, rs, rowNumber);

		return report;
	}
	
	protected Report getReport(){
		return new Report();
	}		
		
	protected void setId(Report report, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ReportTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
	
		report.setId(id);
	}
		
	protected void setName(Report report, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ReportTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
	
		report.setName(name);
	}
		
	protected void setCreatedBy(Report report, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String createdBy = rs.getString(ReportTable.COLUMN_CREATED_BY);
		if(createdBy == null){
			//do nothing when nothing found in database
			return;
		}
	
		report.setCreatedBy(createdBy);
	}
		 		
 	protected void setOwner(Report report, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(ReportTable.COLUMN_OWNER);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = report.getOwner();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'report' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			return;
 		}
 		report.setOwner(createEmptyOwner(retailStoreCountryCenterId));
 	}
 	
	protected void setVersion(Report report, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ReportTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
	
		report.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyOwner(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		return retailStoreCountryCenter;
 	}
 	
}


