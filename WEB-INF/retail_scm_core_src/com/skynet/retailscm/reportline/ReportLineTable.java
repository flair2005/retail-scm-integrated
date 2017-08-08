
package com.skynet.retailscm.reportline;
import com.skynet.retailscm.AccessKey;


public class ReportLineTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="report_line_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_JANUARY = "january";
	static final String COLUMN_FEBRUARY = "february";
	static final String COLUMN_MARCH = "march";
	static final String COLUMN_APRIL = "april";
	static final String COLUMN_MAY = "may";
	static final String COLUMN_JUNE = "june";
	static final String COLUMN_JULY = "july";
	static final String COLUMN_AUGUST = "august";
	static final String COLUMN_SEPTEMBER = "september";
	static final String COLUMN_OCTOBER = "october";
	static final String COLUMN_NOVEMBER = "november";
	static final String COLUMN_DECEMBER = "december";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_OWNER, COLUMN_JANUARY, COLUMN_FEBRUARY, COLUMN_MARCH, COLUMN_APRIL, COLUMN_MAY, COLUMN_JUNE, COLUMN_JULY, COLUMN_AUGUST, COLUMN_SEPTEMBER, COLUMN_OCTOBER, COLUMN_NOVEMBER, COLUMN_DECEMBER, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_OWNER, COLUMN_JANUARY, COLUMN_FEBRUARY, COLUMN_MARCH, COLUMN_APRIL, COLUMN_MAY, COLUMN_JUNE, COLUMN_JULY, COLUMN_AUGUST, COLUMN_SEPTEMBER, COLUMN_OCTOBER, COLUMN_NOVEMBER, COLUMN_DECEMBER
		};
	
	
}


