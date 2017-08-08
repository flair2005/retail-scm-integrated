
package com.skynet.retailscm.shippingspace;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.warehouse.Warehouse;


public class ShippingSpaceSerializer extends BaseJsonSerializer<ShippingSpace>{

	

	@Override
	public void serialize(ShippingSpace shippingSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(shippingSpace,jgen,provider);
		
		jgen.writeStringField(ShippingSpace.ID_PROPERTY,shippingSpace.getId());
		jgen.writeStringField(ShippingSpace.LOCATION_PROPERTY,shippingSpace.getLocation());
		jgen.writeStringField(ShippingSpace.CONTACT_NUMBER_PROPERTY,shippingSpace.getContactNumber());
		jgen.writeStringField(ShippingSpace.TOTAL_AREA_PROPERTY,shippingSpace.getTotalArea());
		writeWarehouse(ShippingSpace.WAREHOUSE_PROPERTY,shippingSpace,jgen,provider);
		jgen.writeNumberField(ShippingSpace.LATITUDE_PROPERTY,shippingSpace.getLatitude());
		jgen.writeNumberField(ShippingSpace.LONGITUDE_PROPERTY,shippingSpace.getLongitude());
		jgen.writeStringField(ShippingSpace.DESCRIPTION_PROPERTY,shippingSpace.getDescription());
		jgen.writeNumberField(ShippingSpace.VERSION_PROPERTY,shippingSpace.getVersion());
		writeGoodsList(ShippingSpace.GOODS_LIST,shippingSpace,jgen,provider);
		
		writeEndObject(shippingSpace,jgen,provider);
	}
	
	protected void writeWarehouse(String fieldName, ShippingSpace shippingSpace, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Warehouse warehouse = shippingSpace.getWarehouse();
		
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
	
	protected void writeGoodsList(String fieldName, ShippingSpace shippingSpace, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = shippingSpace.getGoodsList();
		
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


