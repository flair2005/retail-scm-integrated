
package com.skynet.retailscm.warehouseasset;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.warehouseasset.WarehouseAsset;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.warehouse.Warehouse;


public class WarehouseAssetSerializer extends BaseJsonSerializer<WarehouseAsset>{

	

	@Override
	public void serialize(WarehouseAsset warehouseAsset, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(warehouseAsset,jgen,provider);
		
		jgen.writeStringField(WarehouseAsset.ID_PROPERTY,warehouseAsset.getId());
		jgen.writeStringField(WarehouseAsset.NAME_PROPERTY,warehouseAsset.getName());
		jgen.writeStringField(WarehouseAsset.POSITION_PROPERTY,warehouseAsset.getPosition());
		writeOwner(WarehouseAsset.OWNER_PROPERTY,warehouseAsset,jgen,provider);
		jgen.writeNumberField(WarehouseAsset.VERSION_PROPERTY,warehouseAsset.getVersion());
		
		writeEndObject(warehouseAsset,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, WarehouseAsset warehouseAsset, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Warehouse owner = warehouseAsset.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Warehouse.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(Warehouse.LOCATION_PROPERTY,owner.getLocation()); 
		jgen.writeStringField(Warehouse.CONTACT_NUMBER_PROPERTY,owner.getContactNumber()); 
		jgen.writeStringField(Warehouse.TOTAL_AREA_PROPERTY,owner.getTotalArea()); 
		jgen.writeNumberField(Warehouse.LATITUDE_PROPERTY,owner.getLatitude()); 
		jgen.writeNumberField(Warehouse.LONGITUDE_PROPERTY,owner.getLongitude()); 
		jgen.writeNumberField(Warehouse.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


