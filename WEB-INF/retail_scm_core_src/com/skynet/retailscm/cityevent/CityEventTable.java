
package com.skynet.retailscm.cityevent;
import com.skynet.retailscm.AccessKey;


public class CityEventTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="city_event_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_MOBILE = "mobile";
	static final String COLUMN_CITY_SERVICE_CENTER = "city_service_center";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_MOBILE, COLUMN_CITY_SERVICE_CENTER, COLUMN_DESCRIPTION, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_MOBILE, COLUMN_CITY_SERVICE_CENTER, COLUMN_DESCRIPTION
		};
	
	
}


