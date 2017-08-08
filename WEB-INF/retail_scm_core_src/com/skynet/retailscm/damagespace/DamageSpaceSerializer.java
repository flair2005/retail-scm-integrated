
package com.skynet.retailscm.damagespace;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.goodsshelf.GoodsShelf;


public class DamageSpaceSerializer extends BaseJsonSerializer<DamageSpace>{

	

	@Override
	public void serialize(DamageSpace damageSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(damageSpace,jgen,provider);
		
		jgen.writeStringField(DamageSpace.ID_PROPERTY,damageSpace.getId());
		jgen.writeStringField(DamageSpace.LOCATION_PROPERTY,damageSpace.getLocation());
		jgen.writeStringField(DamageSpace.CONTACT_NUMBER_PROPERTY,damageSpace.getContactNumber());
		jgen.writeStringField(DamageSpace.TOTAL_AREA_PROPERTY,damageSpace.getTotalArea());
		jgen.writeNumberField(DamageSpace.LATITUDE_PROPERTY,damageSpace.getLatitude());
		jgen.writeNumberField(DamageSpace.LONGITUDE_PROPERTY,damageSpace.getLongitude());
		writeWarehouse(DamageSpace.WAREHOUSE_PROPERTY,damageSpace,jgen,provider);
		jgen.writeNumberField(DamageSpace.VERSION_PROPERTY,damageSpace.getVersion());
		writeGoodsShelfList(DamageSpace.GOODS_SHELF_LIST,damageSpace,jgen,provider);
		
		writeEndObject(damageSpace,jgen,provider);
	}
	
	protected void writeWarehouse(String fieldName, DamageSpace damageSpace, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Warehouse warehouse = damageSpace.getWarehouse();
		
		if(warehouse == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Warehouse.ID_PROPERTY,warehouse.getId()); 
		jgen.writeStringField(Warehouse.LOCATION_PROPERTY,warehouse.getLocation()); 
		jgen.writeStringField(Warehouse.CONTACT_NUMBER_PROPERTY,warehouse.getContactNumber()); 
		jgen.writeStringField(Warehouse.TOTAL_AREA_PROPERTY,warehouse.getTotalArea()); 
		jgen.writeNumberField(Warehouse.LATITUDE_PROPERTY,warehouse.getLatitude()); 
		jgen.writeNumberField(Warehouse.LONGITUDE_PROPERTY,warehouse.getLongitude()); 
		jgen.writeNumberField(Warehouse.VERSION_PROPERTY,warehouse.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeGoodsShelfList(String fieldName, DamageSpace damageSpace, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<GoodsShelf> goodsShelfList = damageSpace.getGoodsShelfList();
		
		if(goodsShelfList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsShelfList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(GoodsShelf goodsShelf: goodsShelfList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(GoodsShelf.ID_PROPERTY,goodsShelf.getId());
			jgen.writeStringField(GoodsShelf.LOCATION_PROPERTY,goodsShelf.getLocation());
			jgen.writeNumberField(GoodsShelf.VERSION_PROPERTY,goodsShelf.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


