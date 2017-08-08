
package com.skynet.retailscm.goodspackaging;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;


public class GoodsPackagingSerializer extends BaseJsonSerializer<GoodsPackaging>{

	

	@Override
	public void serialize(GoodsPackaging goodsPackaging, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(goodsPackaging,jgen,provider);
		
		jgen.writeStringField(GoodsPackaging.ID_PROPERTY,goodsPackaging.getId());
		jgen.writeStringField(GoodsPackaging.PACKAGE_NAME_PROPERTY,goodsPackaging.getPackageName());
		jgen.writeStringField(GoodsPackaging.RFID_PROPERTY,goodsPackaging.getRfid());
		jgen.writeObjectField(GoodsPackaging.PACKAGE_TIME_PROPERTY,goodsPackaging.getPackageTime());
		jgen.writeStringField(GoodsPackaging.DESCRIPTION_PROPERTY,goodsPackaging.getDescription());
		jgen.writeNumberField(GoodsPackaging.VERSION_PROPERTY,goodsPackaging.getVersion());
		writeGoodsList(GoodsPackaging.GOODS_LIST,goodsPackaging,jgen,provider);
		
		writeEndObject(goodsPackaging,jgen,provider);
	}
	
	protected void writeGoodsList(String fieldName, GoodsPackaging goodsPackaging, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = goodsPackaging.getGoodsList();
		
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


