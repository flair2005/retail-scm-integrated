
package com.skynet.retailscm.instructor;
import com.skynet.retailscm.AccessKey;


public class InstructorTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="instructor_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_FAMILY_NAME = "family_name";
	static final String COLUMN_GIVEN_NAME = "given_name";
	static final String COLUMN_CELL_PHONE = "cell_phone";
	static final String COLUMN_EMAIL = "email";
	static final String COLUMN_COMPANY = "company";
	static final String COLUMN_INTRODUCTION = "introduction";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_FAMILY_NAME, COLUMN_GIVEN_NAME, COLUMN_CELL_PHONE, COLUMN_EMAIL, COLUMN_COMPANY, COLUMN_INTRODUCTION, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_FAMILY_NAME, COLUMN_GIVEN_NAME, COLUMN_CELL_PHONE, COLUMN_EMAIL, COLUMN_COMPANY, COLUMN_INTRODUCTION
		};
	
	
}


