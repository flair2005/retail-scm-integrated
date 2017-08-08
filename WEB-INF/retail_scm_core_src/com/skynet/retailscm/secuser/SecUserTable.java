
package com.skynet.retailscm.secuser;
import com.skynet.retailscm.AccessKey;


public class SecUserTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="sec_user_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_LOGIN = "login";
	static final String COLUMN_MOBILE = "mobile";
	static final String COLUMN_EMAIL = "email";
	static final String COLUMN_PWD = "pwd";
	static final String COLUMN_LAST_LOGIN = "last_login";
	static final String COLUMN_DOMAIN = "domain";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_LOGIN, COLUMN_MOBILE, COLUMN_EMAIL, COLUMN_PWD, COLUMN_LAST_LOGIN, COLUMN_DOMAIN, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_LOGIN, COLUMN_MOBILE, COLUMN_EMAIL, COLUMN_PWD, COLUMN_LAST_LOGIN, COLUMN_DOMAIN
		};
	
	
}


