
package com.skynet.retailscm.product;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;


public class ProductSerializer extends BaseJsonSerializer<Product>{

	

	@Override
	public void serialize(Product product, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(product,jgen,provider);
		
		jgen.writeStringField(Product.ID_PROPERTY,product.getId());
		jgen.writeStringField(Product.DISPLAY_NAME_PROPERTY,product.getDisplayName());
		writeParentCategory(Product.PARENT_CATEGORY_PROPERTY,product,jgen,provider);
		jgen.writeStringField(Product.ORIGIN_PROPERTY,product.getOrigin());
		jgen.writeStringField(Product.REMARK_PROPERTY,product.getRemark());
		jgen.writeStringField(Product.BRAND_PROPERTY,product.getBrand());
		jgen.writeStringField(Product.PICTURE_PROPERTY,product.getPicture());
		jgen.writeNumberField(Product.VERSION_PROPERTY,product.getVersion());
		writeSkuList(Product.SKU_LIST,product,jgen,provider);
		
		writeEndObject(product,jgen,provider);
	}
	
	protected void writeParentCategory(String fieldName, Product product, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		LevelThreeCategory parentCategory = product.getParentCategory();
		
		if(parentCategory == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(LevelThreeCategory.ID_PROPERTY,parentCategory.getId()); 
		jgen.writeStringField(LevelThreeCategory.DISPLAY_NAME_PROPERTY,parentCategory.getDisplayName()); 
		jgen.writeNumberField(LevelThreeCategory.VERSION_PROPERTY,parentCategory.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeSkuList(String fieldName, Product product, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Sku> skuList = product.getSkuList();
		
		if(skuList == null){
			return;//do nothing when null found for this field.
		}
		if(skuList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Sku sku: skuList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Sku.ID_PROPERTY,sku.getId());
			jgen.writeStringField(Sku.DISPLAY_NAME_PROPERTY,sku.getDisplayName());
			jgen.writeStringField(Sku.SIZE_PROPERTY,sku.getSize());
			jgen.writeStringField(Sku.BARCODE_PROPERTY,sku.getBarcode());
			jgen.writeStringField(Sku.PACKAGE_TYPE_PROPERTY,sku.getPackageType());
			jgen.writeStringField(Sku.NET_CONTENT_PROPERTY,sku.getNetContent());
			jgen.writeNumberField(Sku.PRICE_PROPERTY,sku.getPrice());
			jgen.writeStringField(Sku.PICTURE_PROPERTY,sku.getPicture());
			jgen.writeNumberField(Sku.VERSION_PROPERTY,sku.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


