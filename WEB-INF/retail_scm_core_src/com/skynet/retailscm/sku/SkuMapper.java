
package com.skynet.retailscm.sku;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.skynet.retailscm.BaseRowMapper;
import com.skynet.retailscm.product.Product;

public class SkuMapper extends BaseRowMapper<Sku>{
	
	protected Sku internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Sku sku = getSku();		
		 		
 		setId(sku, rs, rowNumber); 		
 		setDisplayName(sku, rs, rowNumber); 		
 		setSize(sku, rs, rowNumber); 		
 		setProduct(sku, rs, rowNumber); 		
 		setBarcode(sku, rs, rowNumber); 		
 		setPackageType(sku, rs, rowNumber); 		
 		setNetContent(sku, rs, rowNumber); 		
 		setPrice(sku, rs, rowNumber); 		
 		setPicture(sku, rs, rowNumber); 		
 		setVersion(sku, rs, rowNumber);

		return sku;
	}
	
	protected Sku getSku(){
		return new Sku();
	}		
		
	protected void setId(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SkuTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setId(id);
	}
		
	protected void setDisplayName(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String displayName = rs.getString(SkuTable.COLUMN_DISPLAY_NAME);
		if(displayName == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setDisplayName(displayName);
	}
		
	protected void setSize(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String size = rs.getString(SkuTable.COLUMN_SIZE);
		if(size == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setSize(size);
	}
		 		
 	protected void setProduct(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
 		String productId = rs.getString(SkuTable.COLUMN_PRODUCT);
 		if( productId == null){
 			return;
 		}
 		if( productId.isEmpty()){
 			return;
 		}
 		Product product = sku.getProduct();
 		if( product != null ){
 			//if the root object 'sku' already have the property, just set the id for it;
 			product.setId(productId);
 			return;
 		}
 		sku.setProduct(createEmptyProduct(productId));
 	}
 	
	protected void setBarcode(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String barcode = rs.getString(SkuTable.COLUMN_BARCODE);
		if(barcode == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setBarcode(barcode);
	}
		
	protected void setPackageType(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String packageType = rs.getString(SkuTable.COLUMN_PACKAGE_TYPE);
		if(packageType == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setPackageType(packageType);
	}
		
	protected void setNetContent(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String netContent = rs.getString(SkuTable.COLUMN_NET_CONTENT);
		if(netContent == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setNetContent(netContent);
	}
		
	protected void setPrice(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double price = rs.getDouble(SkuTable.COLUMN_PRICE);
		if(price == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setPrice(price);
	}
		
	protected void setPicture(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String picture = rs.getString(SkuTable.COLUMN_PICTURE);
		if(picture == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setPicture(picture);
	}
		
	protected void setVersion(Sku sku, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SkuTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
	
		sku.setVersion(version);
	}
		
		

 	protected Product  createEmptyProduct(String productId){
 		Product product = new Product();
 		product.setId(productId);
 		return product;
 	}
 	
}


