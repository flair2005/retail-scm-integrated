
package com.skynet.retailscm.supplierspace;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.supplierspace.SupplierSpace;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.goodsshelf.GoodsShelf;


public class SupplierSpaceSerializer extends BaseJsonSerializer<SupplierSpace>{

	

	@Override
	public void serialize(SupplierSpace supplierSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(supplierSpace,jgen,provider);
		
		jgen.writeStringField(SupplierSpace.ID_PROPERTY,supplierSpace.getId());
		jgen.writeStringField(SupplierSpace.LOCATION_PROPERTY,supplierSpace.getLocation());
		jgen.writeStringField(SupplierSpace.CONTACT_NUMBER_PROPERTY,supplierSpace.getContactNumber());
		jgen.writeStringField(SupplierSpace.TOTAL_AREA_PROPERTY,supplierSpace.getTotalArea());
		writeWarehouse(SupplierSpace.WAREHOUSE_PROPERTY,supplierSpace,jgen,provider);
		jgen.writeNumberField(SupplierSpace.LATITUDE_PROPERTY,supplierSpace.getLatitude());
		jgen.writeNumberField(SupplierSpace.LONGITUDE_PROPERTY,supplierSpace.getLongitude());
		jgen.writeNumberField(SupplierSpace.VERSION_PROPERTY,supplierSpace.getVersion());
		writeGoodsShelfList(SupplierSpace.GOODS_SHELF_LIST,supplierSpace,jgen,provider);
		
		writeEndObject(supplierSpace,jgen,provider);
	}
	
	protected void writeWarehouse(String fieldName, SupplierSpace supplierSpace, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Warehouse warehouse = supplierSpace.getWarehouse();
		
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
	
	protected void writeGoodsShelfList(String fieldName, SupplierSpace supplierSpace, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<GoodsShelf> goodsShelfList = supplierSpace.getGoodsShelfList();
		
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


