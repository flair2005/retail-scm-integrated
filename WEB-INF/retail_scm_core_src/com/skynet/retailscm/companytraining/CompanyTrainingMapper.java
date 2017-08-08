
package com.skynet.retailscm.companytraining;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.skynet.retailscm.BaseRowMapper;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;

public class CompanyTrainingMapper extends BaseRowMapper<CompanyTraining>{
	
	protected CompanyTraining internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CompanyTraining companyTraining = getCompanyTraining();		
		 		
 		setId(companyTraining, rs, rowNumber); 		
 		setTitle(companyTraining, rs, rowNumber); 		
 		setCompany(companyTraining, rs, rowNumber); 		
 		setInstructor(companyTraining, rs, rowNumber); 		
 		setTrainingCourseType(companyTraining, rs, rowNumber); 		
 		setTimeStart(companyTraining, rs, rowNumber); 		
 		setDurationHours(companyTraining, rs, rowNumber); 		
 		setVersion(companyTraining, rs, rowNumber);

		return companyTraining;
	}
	
	protected CompanyTraining getCompanyTraining(){
		return new CompanyTraining();
	}		
		
	protected void setId(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(CompanyTrainingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
	
		companyTraining.setId(id);
	}
		
	protected void setTitle(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(CompanyTrainingTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
	
		companyTraining.setTitle(title);
	}
		 		
 	protected void setCompany(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(CompanyTrainingTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = companyTraining.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'companyTraining' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			return;
 		}
 		companyTraining.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	 		
 	protected void setInstructor(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
 		String instructorId = rs.getString(CompanyTrainingTable.COLUMN_INSTRUCTOR);
 		if( instructorId == null){
 			return;
 		}
 		if( instructorId.isEmpty()){
 			return;
 		}
 		Instructor instructor = companyTraining.getInstructor();
 		if( instructor != null ){
 			//if the root object 'companyTraining' already have the property, just set the id for it;
 			instructor.setId(instructorId);
 			return;
 		}
 		companyTraining.setInstructor(createEmptyInstructor(instructorId));
 	}
 	 		
 	protected void setTrainingCourseType(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
 		String trainingCourseTypeId = rs.getString(CompanyTrainingTable.COLUMN_TRAINING_COURSE_TYPE);
 		if( trainingCourseTypeId == null){
 			return;
 		}
 		if( trainingCourseTypeId.isEmpty()){
 			return;
 		}
 		TrainingCourseType trainingCourseType = companyTraining.getTrainingCourseType();
 		if( trainingCourseType != null ){
 			//if the root object 'companyTraining' already have the property, just set the id for it;
 			trainingCourseType.setId(trainingCourseTypeId);
 			return;
 		}
 		companyTraining.setTrainingCourseType(createEmptyTrainingCourseType(trainingCourseTypeId));
 	}
 	
	protected void setTimeStart(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date timeStart = rs.getDate(CompanyTrainingTable.COLUMN_TIME_START);
		if(timeStart == null){
			//do nothing when nothing found in database
			return;
		}
	
		companyTraining.setTimeStart(timeStart);
	}
		
	protected void setDurationHours(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer durationHours = rs.getInt(CompanyTrainingTable.COLUMN_DURATION_HOURS);
		if(durationHours == null){
			//do nothing when nothing found in database
			return;
		}
	
		companyTraining.setDurationHours(durationHours);
	}
		
	protected void setVersion(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(CompanyTrainingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
	
		companyTraining.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		return retailStoreCountryCenter;
 	}
 	
 	protected Instructor  createEmptyInstructor(String instructorId){
 		Instructor instructor = new Instructor();
 		instructor.setId(instructorId);
 		return instructor;
 	}
 	
 	protected TrainingCourseType  createEmptyTrainingCourseType(String trainingCourseTypeId){
 		TrainingCourseType trainingCourseType = new TrainingCourseType();
 		trainingCourseType.setId(trainingCourseTypeId);
 		return trainingCourseType;
 	}
 	
}


