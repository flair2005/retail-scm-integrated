
package com.skynet.retailscm.retailstorecityservicecenter;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;


public class RetailStoreCityServiceCenterSerializer extends BaseJsonSerializer<RetailStoreCityServiceCenter>{

	

	@Override
	public void serialize(RetailStoreCityServiceCenter retailStoreCityServiceCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreCityServiceCenter,jgen,provider);
		
		jgen.writeStringField(RetailStoreCityServiceCenter.ID_PROPERTY,retailStoreCityServiceCenter.getId());
		jgen.writeStringField(RetailStoreCityServiceCenter.NAME_PROPERTY,retailStoreCityServiceCenter.getName());
		jgen.writeObjectField(RetailStoreCityServiceCenter.FOUNDED_PROPERTY,retailStoreCityServiceCenter.getFounded());
		writeBelongsTo(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY,retailStoreCityServiceCenter,jgen,provider);
		jgen.writeNumberField(RetailStoreCityServiceCenter.VERSION_PROPERTY,retailStoreCityServiceCenter.getVersion());
		writeCityPartnerList(RetailStoreCityServiceCenter.CITY_PARTNER_LIST,retailStoreCityServiceCenter,jgen,provider);
		writePotentialCustomerList(RetailStoreCityServiceCenter.POTENTIAL_CUSTOMER_LIST,retailStoreCityServiceCenter,jgen,provider);
		writeCityEventList(RetailStoreCityServiceCenter.CITY_EVENT_LIST,retailStoreCityServiceCenter,jgen,provider);
		writeRetailStoreList(RetailStoreCityServiceCenter.RETAIL_STORE_LIST,retailStoreCityServiceCenter,jgen,provider);
		
		writeEndObject(retailStoreCityServiceCenter,jgen,provider);
	}
	
	protected void writeBelongsTo(String fieldName, RetailStoreCityServiceCenter retailStoreCityServiceCenter, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreProvinceCenter belongsTo = retailStoreCityServiceCenter.getBelongsTo();
		
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreProvinceCenter.ID_PROPERTY,belongsTo.getId()); 
		jgen.writeStringField(RetailStoreProvinceCenter.NAME_PROPERTY,belongsTo.getName()); 
		jgen.writeObjectField(RetailStoreProvinceCenter.FOUNDED_PROPERTY,belongsTo.getFounded()); 
		jgen.writeNumberField(RetailStoreProvinceCenter.VERSION_PROPERTY,belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCityPartnerList(String fieldName, RetailStoreCityServiceCenter retailStoreCityServiceCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();
		
		if(cityPartnerList == null){
			return;//do nothing when null found for this field.
		}
		if(cityPartnerList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(CityPartner cityPartner: cityPartnerList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(CityPartner.ID_PROPERTY,cityPartner.getId());
			jgen.writeStringField(CityPartner.NAME_PROPERTY,cityPartner.getName());
			jgen.writeStringField(CityPartner.MOBILE_PROPERTY,cityPartner.getMobile());
			jgen.writeStringField(CityPartner.DESCRIPTION_PROPERTY,cityPartner.getDescription());
			jgen.writeNumberField(CityPartner.VERSION_PROPERTY,cityPartner.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writePotentialCustomerList(String fieldName, RetailStoreCityServiceCenter retailStoreCityServiceCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();
		
		if(potentialCustomerList == null){
			return;//do nothing when null found for this field.
		}
		if(potentialCustomerList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(PotentialCustomer potentialCustomer: potentialCustomerList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(PotentialCustomer.ID_PROPERTY,potentialCustomer.getId());
			jgen.writeStringField(PotentialCustomer.NAME_PROPERTY,potentialCustomer.getName());
			jgen.writeStringField(PotentialCustomer.MOBILE_PROPERTY,potentialCustomer.getMobile());
			jgen.writeStringField(PotentialCustomer.DESCRIPTION_PROPERTY,potentialCustomer.getDescription());
			jgen.writeNumberField(PotentialCustomer.VERSION_PROPERTY,potentialCustomer.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeCityEventList(String fieldName, RetailStoreCityServiceCenter retailStoreCityServiceCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();
		
		if(cityEventList == null){
			return;//do nothing when null found for this field.
		}
		if(cityEventList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(CityEvent cityEvent: cityEventList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(CityEvent.ID_PROPERTY,cityEvent.getId());
			jgen.writeStringField(CityEvent.NAME_PROPERTY,cityEvent.getName());
			jgen.writeStringField(CityEvent.MOBILE_PROPERTY,cityEvent.getMobile());
			jgen.writeStringField(CityEvent.DESCRIPTION_PROPERTY,cityEvent.getDescription());
			jgen.writeNumberField(CityEvent.VERSION_PROPERTY,cityEvent.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreList(String fieldName, RetailStoreCityServiceCenter retailStoreCityServiceCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();
		
		if(retailStoreList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStore retailStore: retailStoreList){
				
			jgen.writeStartObject();// {
		
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

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


