
package com.skynet.retailscm.companytraining;
import com.skynet.retailscm.AccessKey;


public class CompanyTrainingTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="company_training_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_COMPANY = "company";
	static final String COLUMN_INSTRUCTOR = "instructor";
	static final String COLUMN_TRAINING_COURSE_TYPE = "training_course_type";
	static final String COLUMN_TIME_START = "time_start";
	static final String COLUMN_DURATION_HOURS = "duration_hours";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_COMPANY, COLUMN_INSTRUCTOR, COLUMN_TRAINING_COURSE_TYPE, COLUMN_TIME_START, COLUMN_DURATION_HOURS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_COMPANY, COLUMN_INSTRUCTOR, COLUMN_TRAINING_COURSE_TYPE, COLUMN_TIME_START, COLUMN_DURATION_HOURS
		};
	
	
}


