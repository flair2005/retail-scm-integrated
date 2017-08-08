
package com.skynet.retailscm.goodsallocation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.goodsshelf.GoodsShelf;


public class GoodsAllocationSerializer extends BaseJsonSerializer<GoodsAllocation>{

	

	@Override
	public void serialize(GoodsAllocation goodsAllocation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(goodsAllocation,jgen,provider);
		
		jgen.writeStringField(GoodsAllocation.ID_PROPERTY,goodsAllocation.getId());
		jgen.writeStringField(GoodsAllocation.LOCATION_PROPERTY,goodsAllocation.getLocation());
		jgen.writeNumberField(GoodsAllocation.LATITUDE_PROPERTY,goodsAllocation.getLatitude());
		jgen.writeNumberField(GoodsAllocation.LONGITUDE_PROPERTY,goodsAllocation.getLongitude());
		writeGoodsShelf(GoodsAllocation.GOODS_SHELF_PROPERTY,goodsAllocation,jgen,provider);
		jgen.writeNumberField(GoodsAllocation.VERSION_PROPERTY,goodsAllocation.getVersion());
		writeGoodsList(GoodsAllocation.GOODS_LIST,goodsAllocation,jgen,provider);
		
		writeEndObject(goodsAllocation,jgen,provider);
	}
	
	protected void writeGoodsShelf(String fieldName, GoodsAllocation goodsAllocation, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsShelf goodsShelf = goodsAllocation.getGoodsShelf();
		
		if(goodsShelf == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsShelf.ID_PROPERTY,goodsShelf.getId()); 
		jgen.writeStringField(GoodsShelf.LOCATION_PROPERTY,goodsShelf.getLocation()); 
		jgen.writeNumberField(GoodsShelf.VERSION_PROPERTY,goodsShelf.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeGoodsList(String fieldName, GoodsAllocation goodsAllocation, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = goodsAllocation.getGoodsList();
		
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


