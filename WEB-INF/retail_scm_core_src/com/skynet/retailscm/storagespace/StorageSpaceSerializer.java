
package com.skynet.retailscm.storagespace;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.goodsshelf.GoodsShelf;


public class StorageSpaceSerializer extends BaseJsonSerializer<StorageSpace>{

	

	@Override
	public void serialize(StorageSpace storageSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(storageSpace,jgen,provider);
		
		jgen.writeStringField(StorageSpace.ID_PROPERTY,storageSpace.getId());
		jgen.writeStringField(StorageSpace.LOCATION_PROPERTY,storageSpace.getLocation());
		jgen.writeStringField(StorageSpace.CONTACT_NUMBER_PROPERTY,storageSpace.getContactNumber());
		jgen.writeStringField(StorageSpace.TOTAL_AREA_PROPERTY,storageSpace.getTotalArea());
		writeWarehouse(StorageSpace.WAREHOUSE_PROPERTY,storageSpace,jgen,provider);
		jgen.writeNumberField(StorageSpace.LATITUDE_PROPERTY,storageSpace.getLatitude());
		jgen.writeNumberField(StorageSpace.LONGITUDE_PROPERTY,storageSpace.getLongitude());
		jgen.writeNumberField(StorageSpace.VERSION_PROPERTY,storageSpace.getVersion());
		writeGoodsShelfList(StorageSpace.GOODS_SHELF_LIST,storageSpace,jgen,provider);
		
		writeEndObject(storageSpace,jgen,provider);
	}
	
	protected void writeWarehouse(String fieldName, StorageSpace storageSpace, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Warehouse warehouse = storageSpace.getWarehouse();
		
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
	
	protected void writeGoodsShelfList(String fieldName, StorageSpace storageSpace, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<GoodsShelf> goodsShelfList = storageSpace.getGoodsShelfList();
		
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


