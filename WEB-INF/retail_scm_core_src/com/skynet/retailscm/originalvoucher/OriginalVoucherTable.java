
package com.skynet.retailscm.originalvoucher;
import com.skynet.retailscm.AccessKey;


public class OriginalVoucherTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="original_voucher_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_MADE_BY = "made_by";
	static final String COLUMN_RECEIVED_BY = "received_by";
	static final String COLUMN_VOUCHER_TYPE = "voucher_type";
	static final String COLUMN_VOUCHER_IMAGE = "voucher_image";
	static final String COLUMN_BELONGS_TO = "belongs_to";
	static final String COLUMN_CREATION = "creation";
	static final String COLUMN_CONFIRMATION = "confirmation";
	static final String COLUMN_AUDITING = "auditing";
	static final String COLUMN_CURRENT_STATUS = "current_status";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_MADE_BY, COLUMN_RECEIVED_BY, COLUMN_VOUCHER_TYPE, COLUMN_VOUCHER_IMAGE, COLUMN_BELONGS_TO, COLUMN_CREATION, COLUMN_CONFIRMATION, COLUMN_AUDITING, COLUMN_CURRENT_STATUS, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_MADE_BY, COLUMN_RECEIVED_BY, COLUMN_VOUCHER_TYPE, COLUMN_VOUCHER_IMAGE, COLUMN_BELONGS_TO, COLUMN_CREATION, COLUMN_CONFIRMATION, COLUMN_AUDITING, COLUMN_CURRENT_STATUS
		};
	
	
}


