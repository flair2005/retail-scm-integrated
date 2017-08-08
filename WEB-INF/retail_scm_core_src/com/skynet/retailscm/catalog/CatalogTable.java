
package com.skynet.retailscm.catalog;
import com.skynet.retailscm.AccessKey;


public class CatalogTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="catalog_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_DISPLAY_NAME = "display_name";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_DISPLAY_NAME, COLUMN_OWNER, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_DISPLAY_NAME, COLUMN_OWNER
		};
	
	
}


