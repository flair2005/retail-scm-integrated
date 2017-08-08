
package com.skynet.retailscm.warehouse;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.warehouseasset.WarehouseAsset;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.supplierspace.SupplierSpace;


public class WarehouseSerializer extends BaseJsonSerializer<Warehouse>{

	

	@Override
	public void serialize(Warehouse warehouse, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(warehouse,jgen,provider);
		
		jgen.writeStringField(Warehouse.ID_PROPERTY,warehouse.getId());
		jgen.writeStringField(Warehouse.LOCATION_PROPERTY,warehouse.getLocation());
		jgen.writeStringField(Warehouse.CONTACT_NUMBER_PROPERTY,warehouse.getContactNumber());
		jgen.writeStringField(Warehouse.TOTAL_AREA_PROPERTY,warehouse.getTotalArea());
		writeOwner(Warehouse.OWNER_PROPERTY,warehouse,jgen,provider);
		jgen.writeNumberField(Warehouse.LATITUDE_PROPERTY,warehouse.getLatitude());
		jgen.writeNumberField(Warehouse.LONGITUDE_PROPERTY,warehouse.getLongitude());
		jgen.writeNumberField(Warehouse.VERSION_PROPERTY,warehouse.getVersion());
		writeStorageSpaceList(Warehouse.STORAGE_SPACE_LIST,warehouse,jgen,provider);
		writeSmartPalletList(Warehouse.SMART_PALLET_LIST,warehouse,jgen,provider);
		writeSupplierSpaceList(Warehouse.SUPPLIER_SPACE_LIST,warehouse,jgen,provider);
		writeReceivingSpaceList(Warehouse.RECEIVING_SPACE_LIST,warehouse,jgen,provider);
		writeShippingSpaceList(Warehouse.SHIPPING_SPACE_LIST,warehouse,jgen,provider);
		writeDamageSpaceList(Warehouse.DAMAGE_SPACE_LIST,warehouse,jgen,provider);
		writeWarehouseAssetList(Warehouse.WAREHOUSE_ASSET_LIST,warehouse,jgen,provider);
		
		writeEndObject(warehouse,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter owner = warehouse.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,owner.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,owner.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,owner.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,owner.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,owner.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,owner.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,owner.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeStorageSpaceList(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();
		
		if(storageSpaceList == null){
			return;//do nothing when null found for this field.
		}
		if(storageSpaceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(StorageSpace storageSpace: storageSpaceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(StorageSpace.ID_PROPERTY,storageSpace.getId());
			jgen.writeStringField(StorageSpace.LOCATION_PROPERTY,storageSpace.getLocation());
			jgen.writeStringField(StorageSpace.CONTACT_NUMBER_PROPERTY,storageSpace.getContactNumber());
			jgen.writeStringField(StorageSpace.TOTAL_AREA_PROPERTY,storageSpace.getTotalArea());
			jgen.writeNumberField(StorageSpace.LATITUDE_PROPERTY,storageSpace.getLatitude());
			jgen.writeNumberField(StorageSpace.LONGITUDE_PROPERTY,storageSpace.getLongitude());
			jgen.writeNumberField(StorageSpace.VERSION_PROPERTY,storageSpace.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSmartPalletList(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SmartPallet> smartPalletList = warehouse.getSmartPalletList();
		
		if(smartPalletList == null){
			return;//do nothing when null found for this field.
		}
		if(smartPalletList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SmartPallet smartPallet: smartPalletList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SmartPallet.ID_PROPERTY,smartPallet.getId());
			jgen.writeStringField(SmartPallet.LOCATION_PROPERTY,smartPallet.getLocation());
			jgen.writeStringField(SmartPallet.CONTACT_NUMBER_PROPERTY,smartPallet.getContactNumber());
			jgen.writeStringField(SmartPallet.TOTAL_AREA_PROPERTY,smartPallet.getTotalArea());
			jgen.writeNumberField(SmartPallet.LATITUDE_PROPERTY,smartPallet.getLatitude());
			jgen.writeNumberField(SmartPallet.LONGITUDE_PROPERTY,smartPallet.getLongitude());
			jgen.writeNumberField(SmartPallet.VERSION_PROPERTY,smartPallet.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSupplierSpaceList(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();
		
		if(supplierSpaceList == null){
			return;//do nothing when null found for this field.
		}
		if(supplierSpaceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplierSpace supplierSpace: supplierSpaceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplierSpace.ID_PROPERTY,supplierSpace.getId());
			jgen.writeStringField(SupplierSpace.LOCATION_PROPERTY,supplierSpace.getLocation());
			jgen.writeStringField(SupplierSpace.CONTACT_NUMBER_PROPERTY,supplierSpace.getContactNumber());
			jgen.writeStringField(SupplierSpace.TOTAL_AREA_PROPERTY,supplierSpace.getTotalArea());
			jgen.writeNumberField(SupplierSpace.LATITUDE_PROPERTY,supplierSpace.getLatitude());
			jgen.writeNumberField(SupplierSpace.LONGITUDE_PROPERTY,supplierSpace.getLongitude());
			jgen.writeNumberField(SupplierSpace.VERSION_PROPERTY,supplierSpace.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeReceivingSpaceList(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();
		
		if(receivingSpaceList == null){
			return;//do nothing when null found for this field.
		}
		if(receivingSpaceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ReceivingSpace receivingSpace: receivingSpaceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ReceivingSpace.ID_PROPERTY,receivingSpace.getId());
			jgen.writeStringField(ReceivingSpace.LOCATION_PROPERTY,receivingSpace.getLocation());
			jgen.writeStringField(ReceivingSpace.CONTACT_NUMBER_PROPERTY,receivingSpace.getContactNumber());
			jgen.writeStringField(ReceivingSpace.DESCRIPTION_PROPERTY,receivingSpace.getDescription());
			jgen.writeStringField(ReceivingSpace.TOTAL_AREA_PROPERTY,receivingSpace.getTotalArea());
			jgen.writeNumberField(ReceivingSpace.LATITUDE_PROPERTY,receivingSpace.getLatitude());
			jgen.writeNumberField(ReceivingSpace.LONGITUDE_PROPERTY,receivingSpace.getLongitude());
			jgen.writeNumberField(ReceivingSpace.VERSION_PROPERTY,receivingSpace.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeShippingSpaceList(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();
		
		if(shippingSpaceList == null){
			return;//do nothing when null found for this field.
		}
		if(shippingSpaceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ShippingSpace shippingSpace: shippingSpaceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ShippingSpace.ID_PROPERTY,shippingSpace.getId());
			jgen.writeStringField(ShippingSpace.LOCATION_PROPERTY,shippingSpace.getLocation());
			jgen.writeStringField(ShippingSpace.CONTACT_NUMBER_PROPERTY,shippingSpace.getContactNumber());
			jgen.writeStringField(ShippingSpace.TOTAL_AREA_PROPERTY,shippingSpace.getTotalArea());
			jgen.writeNumberField(ShippingSpace.LATITUDE_PROPERTY,shippingSpace.getLatitude());
			jgen.writeNumberField(ShippingSpace.LONGITUDE_PROPERTY,shippingSpace.getLongitude());
			jgen.writeStringField(ShippingSpace.DESCRIPTION_PROPERTY,shippingSpace.getDescription());
			jgen.writeNumberField(ShippingSpace.VERSION_PROPERTY,shippingSpace.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeDamageSpaceList(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();
		
		if(damageSpaceList == null){
			return;//do nothing when null found for this field.
		}
		if(damageSpaceList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(DamageSpace damageSpace: damageSpaceList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(DamageSpace.ID_PROPERTY,damageSpace.getId());
			jgen.writeStringField(DamageSpace.LOCATION_PROPERTY,damageSpace.getLocation());
			jgen.writeStringField(DamageSpace.CONTACT_NUMBER_PROPERTY,damageSpace.getContactNumber());
			jgen.writeStringField(DamageSpace.TOTAL_AREA_PROPERTY,damageSpace.getTotalArea());
			jgen.writeNumberField(DamageSpace.LATITUDE_PROPERTY,damageSpace.getLatitude());
			jgen.writeNumberField(DamageSpace.LONGITUDE_PROPERTY,damageSpace.getLongitude());
			jgen.writeNumberField(DamageSpace.VERSION_PROPERTY,damageSpace.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeWarehouseAssetList(String fieldName, Warehouse warehouse, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();
		
		if(warehouseAssetList == null){
			return;//do nothing when null found for this field.
		}
		if(warehouseAssetList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(WarehouseAsset warehouseAsset: warehouseAssetList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(WarehouseAsset.ID_PROPERTY,warehouseAsset.getId());
			jgen.writeStringField(WarehouseAsset.NAME_PROPERTY,warehouseAsset.getName());
			jgen.writeStringField(WarehouseAsset.POSITION_PROPERTY,warehouseAsset.getPosition());
			jgen.writeNumberField(WarehouseAsset.VERSION_PROPERTY,warehouseAsset.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


