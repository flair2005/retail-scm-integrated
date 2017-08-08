
package com.skynet.retailscm.smartpallet;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.warehouse.Warehouse;


public class SmartPalletSerializer extends BaseJsonSerializer<SmartPallet>{

	

	@Override
	public void serialize(SmartPallet smartPallet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(smartPallet,jgen,provider);
		
		jgen.writeStringField(SmartPallet.ID_PROPERTY,smartPallet.getId());
		jgen.writeStringField(SmartPallet.LOCATION_PROPERTY,smartPallet.getLocation());
		jgen.writeStringField(SmartPallet.CONTACT_NUMBER_PROPERTY,smartPallet.getContactNumber());
		jgen.writeStringField(SmartPallet.TOTAL_AREA_PROPERTY,smartPallet.getTotalArea());
		jgen.writeNumberField(SmartPallet.LATITUDE_PROPERTY,smartPallet.getLatitude());
		jgen.writeNumberField(SmartPallet.LONGITUDE_PROPERTY,smartPallet.getLongitude());
		writeWarehouse(SmartPallet.WAREHOUSE_PROPERTY,smartPallet,jgen,provider);
		jgen.writeNumberField(SmartPallet.VERSION_PROPERTY,smartPallet.getVersion());
		writeGoodsList(SmartPallet.GOODS_LIST,smartPallet,jgen,provider);
		
		writeEndObject(smartPallet,jgen,provider);
	}
	
	protected void writeWarehouse(String fieldName, SmartPallet smartPallet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Warehouse warehouse = smartPallet.getWarehouse();
		
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
	
	protected void writeGoodsList(String fieldName, SmartPallet smartPallet, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = smartPallet.getGoodsList();
		
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


