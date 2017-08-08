
package com.skynet.retailscm.receivingspace;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.warehouse.Warehouse;


public class ReceivingSpaceSerializer extends BaseJsonSerializer<ReceivingSpace>{

	

	@Override
	public void serialize(ReceivingSpace receivingSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(receivingSpace,jgen,provider);
		
		jgen.writeStringField(ReceivingSpace.ID_PROPERTY,receivingSpace.getId());
		jgen.writeStringField(ReceivingSpace.LOCATION_PROPERTY,receivingSpace.getLocation());
		jgen.writeStringField(ReceivingSpace.CONTACT_NUMBER_PROPERTY,receivingSpace.getContactNumber());
		jgen.writeStringField(ReceivingSpace.DESCRIPTION_PROPERTY,receivingSpace.getDescription());
		jgen.writeStringField(ReceivingSpace.TOTAL_AREA_PROPERTY,receivingSpace.getTotalArea());
		writeWarehouse(ReceivingSpace.WAREHOUSE_PROPERTY,receivingSpace,jgen,provider);
		jgen.writeNumberField(ReceivingSpace.LATITUDE_PROPERTY,receivingSpace.getLatitude());
		jgen.writeNumberField(ReceivingSpace.LONGITUDE_PROPERTY,receivingSpace.getLongitude());
		jgen.writeNumberField(ReceivingSpace.VERSION_PROPERTY,receivingSpace.getVersion());
		writeGoodsList(ReceivingSpace.GOODS_LIST,receivingSpace,jgen,provider);
		
		writeEndObject(receivingSpace,jgen,provider);
	}
	
	protected void writeWarehouse(String fieldName, ReceivingSpace receivingSpace, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Warehouse warehouse = receivingSpace.getWarehouse();
		
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
	
	protected void writeGoodsList(String fieldName, ReceivingSpace receivingSpace, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = receivingSpace.getGoodsList();
		
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


