
package com.skynet.retailscm.productsupplyduration;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.productsupplyduration.ProductSupplyDuration;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.supplierproduct.SupplierProduct;


public class ProductSupplyDurationSerializer extends BaseJsonSerializer<ProductSupplyDuration>{

	

	@Override
	public void serialize(ProductSupplyDuration productSupplyDuration, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(productSupplyDuration,jgen,provider);
		
		jgen.writeStringField(ProductSupplyDuration.ID_PROPERTY,productSupplyDuration.getId());
		jgen.writeNumberField(ProductSupplyDuration.QUANTITY_PROPERTY,productSupplyDuration.getQuantity());
		jgen.writeStringField(ProductSupplyDuration.DURATION_PROPERTY,productSupplyDuration.getDuration());
		jgen.writeNumberField(ProductSupplyDuration.PRICE_PROPERTY,productSupplyDuration.getPrice());
		writeProduct(ProductSupplyDuration.PRODUCT_PROPERTY,productSupplyDuration,jgen,provider);
		jgen.writeNumberField(ProductSupplyDuration.VERSION_PROPERTY,productSupplyDuration.getVersion());
		
		writeEndObject(productSupplyDuration,jgen,provider);
	}
	
	protected void writeProduct(String fieldName, ProductSupplyDuration productSupplyDuration, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplierProduct product = productSupplyDuration.getProduct();
		
		if(product == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplierProduct.ID_PROPERTY,product.getId()); 
		jgen.writeStringField(SupplierProduct.PRODUCT_NAME_PROPERTY,product.getProductName()); 
		jgen.writeStringField(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY,product.getProductDescription()); 
		jgen.writeStringField(SupplierProduct.PRODUCT_UNIT_PROPERTY,product.getProductUnit()); 
		jgen.writeNumberField(SupplierProduct.VERSION_PROPERTY,product.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


