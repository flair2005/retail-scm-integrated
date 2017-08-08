
package com.skynet.retailscm.catalog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.skynet.retailscm.BaseRowMapper;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class CatalogMapper extends BaseRowMapper<Catalog>{
	
	protected Catalog internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Catalog catalog = getCatalog();		
		 		
 		setId(catalog, rs, rowNumber); 		
 		setDisplayName(catalog, rs, rowNumber); 		
 		setOwner(catalog, rs, rowNumber); 		
 		setVersion(catalog, rs, rowNumber);

		return catalog;
	}
	
	protected Catalog getCatalog(){
		return new Catalog();
	}		
		
	protected void setId(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(CatalogTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
	
		catalog.setId(id);
	}
		
	protected void setDisplayName(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String displayName = rs.getString(CatalogTable.COLUMN_DISPLAY_NAME);
		if(displayName == null){
			//do nothing when nothing found in database
			return;
		}
	
		catalog.setDisplayName(displayName);
	}
		 		
 	protected void setOwner(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(CatalogTable.COLUMN_OWNER);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = catalog.getOwner();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'catalog' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			return;
 		}
 		catalog.setOwner(createEmptyOwner(retailStoreCountryCenterId));
 	}
 	
	protected void setVersion(Catalog catalog, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(CatalogTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
	
		catalog.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyOwner(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		return retailStoreCountryCenter;
 	}
 	
}


