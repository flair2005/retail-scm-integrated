
package com.skynet.retailscm.levelthreecategory;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;


public class LevelThreeCategorySerializer extends BaseJsonSerializer<LevelThreeCategory>{

	

	@Override
	public void serialize(LevelThreeCategory levelThreeCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(levelThreeCategory,jgen,provider);
		
		jgen.writeStringField(LevelThreeCategory.ID_PROPERTY,levelThreeCategory.getId());
		writeParentCategory(LevelThreeCategory.PARENT_CATEGORY_PROPERTY,levelThreeCategory,jgen,provider);
		jgen.writeStringField(LevelThreeCategory.DISPLAY_NAME_PROPERTY,levelThreeCategory.getDisplayName());
		jgen.writeNumberField(LevelThreeCategory.VERSION_PROPERTY,levelThreeCategory.getVersion());
		writeProductList(LevelThreeCategory.PRODUCT_LIST,levelThreeCategory,jgen,provider);
		
		writeEndObject(levelThreeCategory,jgen,provider);
	}
	
	protected void writeParentCategory(String fieldName, LevelThreeCategory levelThreeCategory, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		LevelTwoCategory parentCategory = levelThreeCategory.getParentCategory();
		
		if(parentCategory == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(LevelTwoCategory.ID_PROPERTY,parentCategory.getId()); 
		jgen.writeStringField(LevelTwoCategory.DISPLAY_NAME_PROPERTY,parentCategory.getDisplayName()); 
		jgen.writeNumberField(LevelTwoCategory.VERSION_PROPERTY,parentCategory.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeProductList(String fieldName, LevelThreeCategory levelThreeCategory, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Product> productList = levelThreeCategory.getProductList();
		
		if(productList == null){
			return;//do nothing when null found for this field.
		}
		if(productList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Product product: productList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Product.ID_PROPERTY,product.getId());
			jgen.writeStringField(Product.DISPLAY_NAME_PROPERTY,product.getDisplayName());
			jgen.writeStringField(Product.ORIGIN_PROPERTY,product.getOrigin());
			jgen.writeStringField(Product.REMARK_PROPERTY,product.getRemark());
			jgen.writeStringField(Product.BRAND_PROPERTY,product.getBrand());
			jgen.writeStringField(Product.PICTURE_PROPERTY,product.getPicture());
			jgen.writeNumberField(Product.VERSION_PROPERTY,product.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


