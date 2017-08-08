
package com.skynet.retailscm.goodsshelf;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.goodsshelf.GoodsShelf;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.skynet.retailscm.supplierspace.SupplierSpace;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;


public class GoodsShelfSerializer extends BaseJsonSerializer<GoodsShelf>{

	

	@Override
	public void serialize(GoodsShelf goodsShelf, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(goodsShelf,jgen,provider);
		
		jgen.writeStringField(GoodsShelf.ID_PROPERTY,goodsShelf.getId());
		jgen.writeStringField(GoodsShelf.LOCATION_PROPERTY,goodsShelf.getLocation());
		writeStorageSpace(GoodsShelf.STORAGE_SPACE_PROPERTY,goodsShelf,jgen,provider);
		writeSupplierSpace(GoodsShelf.SUPPLIER_SPACE_PROPERTY,goodsShelf,jgen,provider);
		writeDamageSpace(GoodsShelf.DAMAGE_SPACE_PROPERTY,goodsShelf,jgen,provider);
		jgen.writeNumberField(GoodsShelf.VERSION_PROPERTY,goodsShelf.getVersion());
		writeGoodsShelfStockCountList(GoodsShelf.GOODS_SHELF_STOCK_COUNT_LIST,goodsShelf,jgen,provider);
		writeGoodsAllocationList(GoodsShelf.GOODS_ALLOCATION_LIST,goodsShelf,jgen,provider);
		
		writeEndObject(goodsShelf,jgen,provider);
	}
	
	protected void writeStorageSpace(String fieldName, GoodsShelf goodsShelf, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		StorageSpace storageSpace = goodsShelf.getStorageSpace();
		
		if(storageSpace == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(StorageSpace.ID_PROPERTY,storageSpace.getId()); 
		jgen.writeStringField(StorageSpace.LOCATION_PROPERTY,storageSpace.getLocation()); 
		jgen.writeStringField(StorageSpace.CONTACT_NUMBER_PROPERTY,storageSpace.getContactNumber()); 
		jgen.writeStringField(StorageSpace.TOTAL_AREA_PROPERTY,storageSpace.getTotalArea()); 
		jgen.writeNumberField(StorageSpace.LATITUDE_PROPERTY,storageSpace.getLatitude()); 
		jgen.writeNumberField(StorageSpace.LONGITUDE_PROPERTY,storageSpace.getLongitude()); 
		jgen.writeNumberField(StorageSpace.VERSION_PROPERTY,storageSpace.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeSupplierSpace(String fieldName, GoodsShelf goodsShelf, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplierSpace supplierSpace = goodsShelf.getSupplierSpace();
		
		if(supplierSpace == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplierSpace.ID_PROPERTY,supplierSpace.getId()); 
		jgen.writeStringField(SupplierSpace.LOCATION_PROPERTY,supplierSpace.getLocation()); 
		jgen.writeStringField(SupplierSpace.CONTACT_NUMBER_PROPERTY,supplierSpace.getContactNumber()); 
		jgen.writeStringField(SupplierSpace.TOTAL_AREA_PROPERTY,supplierSpace.getTotalArea()); 
		jgen.writeNumberField(SupplierSpace.LATITUDE_PROPERTY,supplierSpace.getLatitude()); 
		jgen.writeNumberField(SupplierSpace.LONGITUDE_PROPERTY,supplierSpace.getLongitude()); 
		jgen.writeNumberField(SupplierSpace.VERSION_PROPERTY,supplierSpace.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDamageSpace(String fieldName, GoodsShelf goodsShelf, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		DamageSpace damageSpace = goodsShelf.getDamageSpace();
		
		if(damageSpace == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(DamageSpace.ID_PROPERTY,damageSpace.getId()); 
		jgen.writeStringField(DamageSpace.LOCATION_PROPERTY,damageSpace.getLocation()); 
		jgen.writeStringField(DamageSpace.CONTACT_NUMBER_PROPERTY,damageSpace.getContactNumber()); 
		jgen.writeStringField(DamageSpace.TOTAL_AREA_PROPERTY,damageSpace.getTotalArea()); 
		jgen.writeNumberField(DamageSpace.LATITUDE_PROPERTY,damageSpace.getLatitude()); 
		jgen.writeNumberField(DamageSpace.LONGITUDE_PROPERTY,damageSpace.getLongitude()); 
		jgen.writeNumberField(DamageSpace.VERSION_PROPERTY,damageSpace.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeGoodsShelfStockCountList(String fieldName, GoodsShelf goodsShelf, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<GoodsShelfStockCount> goodsShelfStockCountList = goodsShelf.getGoodsShelfStockCountList();
		
		if(goodsShelfStockCountList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsShelfStockCountList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(GoodsShelfStockCount goodsShelfStockCount: goodsShelfStockCountList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(GoodsShelfStockCount.ID_PROPERTY,goodsShelfStockCount.getId());
			jgen.writeStringField(GoodsShelfStockCount.TITLE_PROPERTY,goodsShelfStockCount.getTitle());
			jgen.writeObjectField(GoodsShelfStockCount.COUNT_TIME_PROPERTY,goodsShelfStockCount.getCountTime());
			jgen.writeStringField(GoodsShelfStockCount.SUMMARY_PROPERTY,goodsShelfStockCount.getSummary());
			jgen.writeNumberField(GoodsShelfStockCount.VERSION_PROPERTY,goodsShelfStockCount.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeGoodsAllocationList(String fieldName, GoodsShelf goodsShelf, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<GoodsAllocation> goodsAllocationList = goodsShelf.getGoodsAllocationList();
		
		if(goodsAllocationList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsAllocationList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(GoodsAllocation goodsAllocation: goodsAllocationList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(GoodsAllocation.ID_PROPERTY,goodsAllocation.getId());
			jgen.writeStringField(GoodsAllocation.LOCATION_PROPERTY,goodsAllocation.getLocation());
			jgen.writeNumberField(GoodsAllocation.LATITUDE_PROPERTY,goodsAllocation.getLatitude());
			jgen.writeNumberField(GoodsAllocation.LONGITUDE_PROPERTY,goodsAllocation.getLongitude());
			jgen.writeNumberField(GoodsAllocation.VERSION_PROPERTY,goodsAllocation.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


