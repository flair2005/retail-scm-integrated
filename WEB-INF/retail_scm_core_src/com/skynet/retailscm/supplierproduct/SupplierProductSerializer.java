
package com.skynet.retailscm.supplierproduct;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplierproduct.SupplierProduct;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.productsupplyduration.ProductSupplyDuration;


public class SupplierProductSerializer extends BaseJsonSerializer<SupplierProduct>{

	

	@Override
	public void serialize(SupplierProduct supplierProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplierProduct,jgen,provider);
		
		jgen.writeStringField(SupplierProduct.ID_PROPERTY,supplierProduct.getId());
		jgen.writeStringField(SupplierProduct.PRODUCT_NAME_PROPERTY,supplierProduct.getProductName());
		jgen.writeStringField(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY,supplierProduct.getProductDescription());
		jgen.writeStringField(SupplierProduct.PRODUCT_UNIT_PROPERTY,supplierProduct.getProductUnit());
		writeSupplier(SupplierProduct.SUPPLIER_PROPERTY,supplierProduct,jgen,provider);
		jgen.writeNumberField(SupplierProduct.VERSION_PROPERTY,supplierProduct.getVersion());
		writeProductSupplyDurationList(SupplierProduct.PRODUCT_SUPPLY_DURATION_LIST,supplierProduct,jgen,provider);
		
		writeEndObject(supplierProduct,jgen,provider);
	}
	
	protected void writeSupplier(String fieldName, SupplierProduct supplierProduct, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsSupplier supplier = supplierProduct.getSupplier();
		
		if(supplier == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsSupplier.ID_PROPERTY,supplier.getId()); 
		jgen.writeStringField(GoodsSupplier.NAME_PROPERTY,supplier.getName()); 
		jgen.writeStringField(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY,supplier.getSupplyProduct()); 
		jgen.writeStringField(GoodsSupplier.CONTACT_NUMBER_PROPERTY,supplier.getContactNumber()); 
		jgen.writeStringField(GoodsSupplier.DESCRIPTION_PROPERTY,supplier.getDescription()); 
		jgen.writeNumberField(GoodsSupplier.VERSION_PROPERTY,supplier.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProductSupplyDurationList(String fieldName, SupplierProduct supplierProduct, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ProductSupplyDuration> productSupplyDurationList = supplierProduct.getProductSupplyDurationList();
		
		if(productSupplyDurationList == null){
			return;//do nothing when null found for this field.
		}
		if(productSupplyDurationList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ProductSupplyDuration productSupplyDuration: productSupplyDurationList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ProductSupplyDuration.ID_PROPERTY,productSupplyDuration.getId());
			jgen.writeNumberField(ProductSupplyDuration.QUANTITY_PROPERTY,productSupplyDuration.getQuantity());
			jgen.writeStringField(ProductSupplyDuration.DURATION_PROPERTY,productSupplyDuration.getDuration());
			jgen.writeNumberField(ProductSupplyDuration.PRICE_PROPERTY,productSupplyDuration.getPrice());
			jgen.writeNumberField(ProductSupplyDuration.VERSION_PROPERTY,productSupplyDuration.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


