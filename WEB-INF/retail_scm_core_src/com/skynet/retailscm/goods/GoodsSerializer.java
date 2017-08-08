
package com.skynet.retailscm.goods;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.goodsmovement.GoodsMovement;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;


public class GoodsSerializer extends BaseJsonSerializer<Goods>{

	

	@Override
	public void serialize(Goods goods, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(goods,jgen,provider);
		
		jgen.writeStringField(Goods.ID_PROPERTY,goods.getId());
		jgen.writeStringField(Goods.NAME_PROPERTY,goods.getName());
		jgen.writeStringField(Goods.RFID_PROPERTY,goods.getRfid());
		jgen.writeStringField(Goods.UOM_PROPERTY,goods.getUom());
		jgen.writeNumberField(Goods.MAX_PACKAGE_PROPERTY,goods.getMaxPackage());
		jgen.writeObjectField(Goods.EXPIRE_TIME_PROPERTY,goods.getExpireTime());
		writeSku(Goods.SKU_PROPERTY,goods,jgen,provider);
		writeReceivingSpace(Goods.RECEIVING_SPACE_PROPERTY,goods,jgen,provider);
		writeGoodsAllocation(Goods.GOODS_ALLOCATION_PROPERTY,goods,jgen,provider);
		writeSmartPallet(Goods.SMART_PALLET_PROPERTY,goods,jgen,provider);
		writeShippingSpace(Goods.SHIPPING_SPACE_PROPERTY,goods,jgen,provider);
		writeTransportTask(Goods.TRANSPORT_TASK_PROPERTY,goods,jgen,provider);
		writeRetailStore(Goods.RETAIL_STORE_PROPERTY,goods,jgen,provider);
		writeBizOrder(Goods.BIZ_ORDER_PROPERTY,goods,jgen,provider);
		writeRetailStoreOrder(Goods.RETAIL_STORE_ORDER_PROPERTY,goods,jgen,provider);
		writePackaging(Goods.PACKAGING_PROPERTY,goods,jgen,provider);
		jgen.writeStringField(Goods.CURRENT_STATUS_PROPERTY,goods.getCurrentStatus());
		jgen.writeNumberField(Goods.VERSION_PROPERTY,goods.getVersion());
		writeGoodsMovementList(Goods.GOODS_MOVEMENT_LIST,goods,jgen,provider);
		
		writeEndObject(goods,jgen,provider);
	}
	
	protected void writeSku(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Sku sku = goods.getSku();
		
		if(sku == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Sku.ID_PROPERTY,sku.getId()); 
		jgen.writeStringField(Sku.DISPLAY_NAME_PROPERTY,sku.getDisplayName()); 
		jgen.writeStringField(Sku.SIZE_PROPERTY,sku.getSize()); 
		jgen.writeStringField(Sku.BARCODE_PROPERTY,sku.getBarcode()); 
		jgen.writeStringField(Sku.PACKAGE_TYPE_PROPERTY,sku.getPackageType()); 
		jgen.writeStringField(Sku.NET_CONTENT_PROPERTY,sku.getNetContent()); 
		jgen.writeNumberField(Sku.PRICE_PROPERTY,sku.getPrice()); 
		jgen.writeStringField(Sku.PICTURE_PROPERTY,sku.getPicture()); 
		jgen.writeNumberField(Sku.VERSION_PROPERTY,sku.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeReceivingSpace(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ReceivingSpace receivingSpace = goods.getReceivingSpace();
		
		if(receivingSpace == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(ReceivingSpace.ID_PROPERTY,receivingSpace.getId()); 
		jgen.writeStringField(ReceivingSpace.LOCATION_PROPERTY,receivingSpace.getLocation()); 
		jgen.writeStringField(ReceivingSpace.CONTACT_NUMBER_PROPERTY,receivingSpace.getContactNumber()); 
		jgen.writeStringField(ReceivingSpace.DESCRIPTION_PROPERTY,receivingSpace.getDescription()); 
		jgen.writeStringField(ReceivingSpace.TOTAL_AREA_PROPERTY,receivingSpace.getTotalArea()); 
		jgen.writeNumberField(ReceivingSpace.LATITUDE_PROPERTY,receivingSpace.getLatitude()); 
		jgen.writeNumberField(ReceivingSpace.LONGITUDE_PROPERTY,receivingSpace.getLongitude()); 
		jgen.writeNumberField(ReceivingSpace.VERSION_PROPERTY,receivingSpace.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeGoodsAllocation(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsAllocation goodsAllocation = goods.getGoodsAllocation();
		
		if(goodsAllocation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsAllocation.ID_PROPERTY,goodsAllocation.getId()); 
		jgen.writeStringField(GoodsAllocation.LOCATION_PROPERTY,goodsAllocation.getLocation()); 
		jgen.writeNumberField(GoodsAllocation.LATITUDE_PROPERTY,goodsAllocation.getLatitude()); 
		jgen.writeNumberField(GoodsAllocation.LONGITUDE_PROPERTY,goodsAllocation.getLongitude()); 
		jgen.writeNumberField(GoodsAllocation.VERSION_PROPERTY,goodsAllocation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeSmartPallet(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SmartPallet smartPallet = goods.getSmartPallet();
		
		if(smartPallet == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SmartPallet.ID_PROPERTY,smartPallet.getId()); 
		jgen.writeStringField(SmartPallet.LOCATION_PROPERTY,smartPallet.getLocation()); 
		jgen.writeStringField(SmartPallet.CONTACT_NUMBER_PROPERTY,smartPallet.getContactNumber()); 
		jgen.writeStringField(SmartPallet.TOTAL_AREA_PROPERTY,smartPallet.getTotalArea()); 
		jgen.writeNumberField(SmartPallet.LATITUDE_PROPERTY,smartPallet.getLatitude()); 
		jgen.writeNumberField(SmartPallet.LONGITUDE_PROPERTY,smartPallet.getLongitude()); 
		jgen.writeNumberField(SmartPallet.VERSION_PROPERTY,smartPallet.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeShippingSpace(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		ShippingSpace shippingSpace = goods.getShippingSpace();
		
		if(shippingSpace == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(ShippingSpace.ID_PROPERTY,shippingSpace.getId()); 
		jgen.writeStringField(ShippingSpace.LOCATION_PROPERTY,shippingSpace.getLocation()); 
		jgen.writeStringField(ShippingSpace.CONTACT_NUMBER_PROPERTY,shippingSpace.getContactNumber()); 
		jgen.writeStringField(ShippingSpace.TOTAL_AREA_PROPERTY,shippingSpace.getTotalArea()); 
		jgen.writeNumberField(ShippingSpace.LATITUDE_PROPERTY,shippingSpace.getLatitude()); 
		jgen.writeNumberField(ShippingSpace.LONGITUDE_PROPERTY,shippingSpace.getLongitude()); 
		jgen.writeStringField(ShippingSpace.DESCRIPTION_PROPERTY,shippingSpace.getDescription()); 
		jgen.writeNumberField(ShippingSpace.VERSION_PROPERTY,shippingSpace.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeTransportTask(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		TransportTask transportTask = goods.getTransportTask();
		
		if(transportTask == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(TransportTask.ID_PROPERTY,transportTask.getId()); 
		jgen.writeStringField(TransportTask.NAME_PROPERTY,transportTask.getName()); 
		jgen.writeStringField(TransportTask.START_PROPERTY,transportTask.getStart()); 
		jgen.writeObjectField(TransportTask.BEGIN_TIME_PROPERTY,transportTask.getBeginTime()); 
		jgen.writeNumberField(TransportTask.LATITUDE_PROPERTY,transportTask.getLatitude()); 
		jgen.writeNumberField(TransportTask.LONGITUDE_PROPERTY,transportTask.getLongitude()); 
		jgen.writeNumberField(TransportTask.VERSION_PROPERTY,transportTask.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeRetailStore(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStore retailStore = goods.getRetailStore();
		
		if(retailStore == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStore.ID_PROPERTY,retailStore.getId()); 
		jgen.writeStringField(RetailStore.NAME_PROPERTY,retailStore.getName()); 
		jgen.writeStringField(RetailStore.TELEPHONE_PROPERTY,retailStore.getTelephone()); 
		jgen.writeStringField(RetailStore.OWNER_PROPERTY,retailStore.getOwner()); 
		jgen.writeObjectField(RetailStore.FOUNDED_PROPERTY,retailStore.getFounded()); 
		jgen.writeNumberField(RetailStore.LATITUDE_PROPERTY,retailStore.getLatitude()); 
		jgen.writeNumberField(RetailStore.LONGITUDE_PROPERTY,retailStore.getLongitude()); 
		jgen.writeStringField(RetailStore.DESCRIPTION_PROPERTY,retailStore.getDescription()); 
		jgen.writeStringField(RetailStore.CURRENT_STATUS_PROPERTY,retailStore.getCurrentStatus()); 
		jgen.writeNumberField(RetailStore.VERSION_PROPERTY,retailStore.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeBizOrder(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SupplyOrder bizOrder = goods.getBizOrder();
		
		if(bizOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SupplyOrder.ID_PROPERTY,bizOrder.getId()); 
		jgen.writeStringField(SupplyOrder.TITLE_PROPERTY,bizOrder.getTitle()); 
		jgen.writeNumberField(SupplyOrder.TOTAL_AMOUNT_PROPERTY,bizOrder.getTotalAmount()); 
		jgen.writeStringField(SupplyOrder.CURRENT_STATUS_PROPERTY,bizOrder.getCurrentStatus()); 
		jgen.writeNumberField(SupplyOrder.VERSION_PROPERTY,bizOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeRetailStoreOrder(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOrder retailStoreOrder = goods.getRetailStoreOrder();
		
		if(retailStoreOrder == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOrder.ID_PROPERTY,retailStoreOrder.getId()); 
		jgen.writeStringField(RetailStoreOrder.TITLE_PROPERTY,retailStoreOrder.getTitle()); 
		jgen.writeNumberField(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY,retailStoreOrder.getTotalAmount()); 
		jgen.writeStringField(RetailStoreOrder.CURRENT_STATUS_PROPERTY,retailStoreOrder.getCurrentStatus()); 
		jgen.writeNumberField(RetailStoreOrder.VERSION_PROPERTY,retailStoreOrder.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writePackaging(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsPackaging packaging = goods.getPackaging();
		
		if(packaging == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsPackaging.ID_PROPERTY,packaging.getId()); 
		jgen.writeStringField(GoodsPackaging.PACKAGE_NAME_PROPERTY,packaging.getPackageName()); 
		jgen.writeStringField(GoodsPackaging.RFID_PROPERTY,packaging.getRfid()); 
		jgen.writeObjectField(GoodsPackaging.PACKAGE_TIME_PROPERTY,packaging.getPackageTime()); 
		jgen.writeStringField(GoodsPackaging.DESCRIPTION_PROPERTY,packaging.getDescription()); 
		jgen.writeNumberField(GoodsPackaging.VERSION_PROPERTY,packaging.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeGoodsMovementList(String fieldName, Goods goods, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<GoodsMovement> goodsMovementList = goods.getGoodsMovementList();
		
		if(goodsMovementList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsMovementList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(GoodsMovement goodsMovement: goodsMovementList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(GoodsMovement.ID_PROPERTY,goodsMovement.getId());
			jgen.writeObjectField(GoodsMovement.MOVE_TIME_PROPERTY,goodsMovement.getMoveTime());
			jgen.writeStringField(GoodsMovement.FACILITY_PROPERTY,goodsMovement.getFacility());
			jgen.writeStringField(GoodsMovement.FACILITY_ID_PROPERTY,goodsMovement.getFacilityId());
			jgen.writeStringField(GoodsMovement.FROM_IP_PROPERTY,goodsMovement.getFromIp());
			jgen.writeStringField(GoodsMovement.USER_AGENT_PROPERTY,goodsMovement.getUserAgent());
			jgen.writeStringField(GoodsMovement.SESSION_ID_PROPERTY,goodsMovement.getSessionId());
			jgen.writeNumberField(GoodsMovement.LATITUDE_PROPERTY,goodsMovement.getLatitude());
			jgen.writeNumberField(GoodsMovement.LONGITUDE_PROPERTY,goodsMovement.getLongitude());
			jgen.writeNumberField(GoodsMovement.VERSION_PROPERTY,goodsMovement.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


