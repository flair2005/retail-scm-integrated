
package com.skynet.retailscm.sku;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.goods.Goods;


public class SkuSerializer extends BaseJsonSerializer<Sku>{

	

	@Override
	public void serialize(Sku sku, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(sku,jgen,provider);
		
		jgen.writeStringField(Sku.ID_PROPERTY,sku.getId());
		jgen.writeStringField(Sku.DISPLAY_NAME_PROPERTY,sku.getDisplayName());
		jgen.writeStringField(Sku.SIZE_PROPERTY,sku.getSize());
		writeProduct(Sku.PRODUCT_PROPERTY,sku,jgen,provider);
		jgen.writeStringField(Sku.BARCODE_PROPERTY,sku.getBarcode());
		jgen.writeStringField(Sku.PACKAGE_TYPE_PROPERTY,sku.getPackageType());
		jgen.writeStringField(Sku.NET_CONTENT_PROPERTY,sku.getNetContent());
		jgen.writeNumberField(Sku.PRICE_PROPERTY,sku.getPrice());
		jgen.writeStringField(Sku.PICTURE_PROPERTY,sku.getPicture());
		jgen.writeNumberField(Sku.VERSION_PROPERTY,sku.getVersion());
		writeGoodsList(Sku.GOODS_LIST,sku,jgen,provider);
		
		writeEndObject(sku,jgen,provider);
	}
	
	protected void writeProduct(String fieldName, Sku sku, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Product product = sku.getProduct();
		
		if(product == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Product.ID_PROPERTY,product.getId()); 
		jgen.writeStringField(Product.DISPLAY_NAME_PROPERTY,product.getDisplayName()); 
		jgen.writeStringField(Product.ORIGIN_PROPERTY,product.getOrigin()); 
		jgen.writeStringField(Product.REMARK_PROPERTY,product.getRemark()); 
		jgen.writeStringField(Product.BRAND_PROPERTY,product.getBrand()); 
		jgen.writeStringField(Product.PICTURE_PROPERTY,product.getPicture()); 
		jgen.writeNumberField(Product.VERSION_PROPERTY,product.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeGoodsList(String fieldName, Sku sku, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = sku.getGoodsList();
		
		if(goodsList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Goods goods: goodsList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Goods.ID_PROPERTY,goods.getId());
			jgen.writeStringField(Goods.NAME_PROPERTY,goods.getName());
			jgen.writeStringField(Goods.RFID_PROPERTY,goods.getRfid());
			jgen.writeStringField(Goods.UOM_PROPERTY,goods.getUom());
			jgen.writeNumberField(Goods.MAX_PACKAGE_PROPERTY,goods.getMaxPackage());
			jgen.writeObjectField(Goods.EXPIRE_TIME_PROPERTY,goods.getExpireTime());
			jgen.writeStringField(Goods.CURRENT_STATUS_PROPERTY,goods.getCurrentStatus());
			jgen.writeNumberField(Goods.VERSION_PROPERTY,goods.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


