
package com.skynet.retailscm.supplyordershipment;
import com.skynet.retailscm.AccessKey;


public class SupplyOrderShipmentTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	static final String TABLE_NAME="supply_order_shipment_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WHO = "who";
	static final String COLUMN_SHIP_TIME = "ship_time";
	static final String COLUMN_VERSION = "version";
 
	static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_WHO, COLUMN_SHIP_TIME, 
		COLUMN_VERSION};
	static final String []NORMAL_CLOUMNS = {
		COLUMN_WHO, COLUMN_SHIP_TIME
		};
	
	
}


