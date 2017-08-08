
package com.skynet.retailscm.retailstore;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreation;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosing;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.accountset.AccountSet;


public class RetailStoreSerializer extends BaseJsonSerializer<RetailStore>{

	

	@Override
	public void serialize(RetailStore retailStore, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStore,jgen,provider);
		
		jgen.writeStringField(RetailStore.ID_PROPERTY,retailStore.getId());
		jgen.writeStringField(RetailStore.NAME_PROPERTY,retailStore.getName());
		jgen.writeStringField(RetailStore.TELEPHONE_PROPERTY,retailStore.getTelephone());
		jgen.writeStringField(RetailStore.OWNER_PROPERTY,retailStore.getOwner());
		writeRetailStoreCountryCenter(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY,retailStore,jgen,provider);
		writeCityServiceCenter(RetailStore.CITY_SERVICE_CENTER_PROPERTY,retailStore,jgen,provider);
		writeCreation(RetailStore.CREATION_PROPERTY,retailStore,jgen,provider);
		writeInvestmentInvitation(RetailStore.INVESTMENT_INVITATION_PROPERTY,retailStore,jgen,provider);
		writeFranchising(RetailStore.FRANCHISING_PROPERTY,retailStore,jgen,provider);
		writeDecoration(RetailStore.DECORATION_PROPERTY,retailStore,jgen,provider);
		writeOpening(RetailStore.OPENING_PROPERTY,retailStore,jgen,provider);
		writeClosing(RetailStore.CLOSING_PROPERTY,retailStore,jgen,provider);
		jgen.writeObjectField(RetailStore.FOUNDED_PROPERTY,retailStore.getFounded());
		jgen.writeNumberField(RetailStore.LATITUDE_PROPERTY,retailStore.getLatitude());
		jgen.writeNumberField(RetailStore.LONGITUDE_PROPERTY,retailStore.getLongitude());
		jgen.writeStringField(RetailStore.DESCRIPTION_PROPERTY,retailStore.getDescription());
		jgen.writeStringField(RetailStore.CURRENT_STATUS_PROPERTY,retailStore.getCurrentStatus());
		jgen.writeNumberField(RetailStore.VERSION_PROPERTY,retailStore.getVersion());
		writeConsumerOrderList(RetailStore.CONSUMER_ORDER_LIST,retailStore,jgen,provider);
		writeRetailStoreOrderList(RetailStore.RETAIL_STORE_ORDER_LIST,retailStore,jgen,provider);
		writeGoodsList(RetailStore.GOODS_LIST,retailStore,jgen,provider);
		writeTransportTaskList(RetailStore.TRANSPORT_TASK_LIST,retailStore,jgen,provider);
		writeAccountSetList(RetailStore.ACCOUNT_SET_LIST,retailStore,jgen,provider);
		
		writeEndObject(retailStore,jgen,provider);
	}
	
	protected void writeRetailStoreCountryCenter(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter retailStoreCountryCenter = retailStore.getRetailStoreCountryCenter();
		
		if(retailStoreCountryCenter == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,retailStoreCountryCenter.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,retailStoreCountryCenter.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,retailStoreCountryCenter.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,retailStoreCountryCenter.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,retailStoreCountryCenter.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,retailStoreCountryCenter.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,retailStoreCountryCenter.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,retailStoreCountryCenter.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,retailStoreCountryCenter.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,retailStoreCountryCenter.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCityServiceCenter(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCityServiceCenter cityServiceCenter = retailStore.getCityServiceCenter();
		
		if(cityServiceCenter == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCityServiceCenter.ID_PROPERTY,cityServiceCenter.getId()); 
		jgen.writeStringField(RetailStoreCityServiceCenter.NAME_PROPERTY,cityServiceCenter.getName()); 
		jgen.writeObjectField(RetailStoreCityServiceCenter.FOUNDED_PROPERTY,cityServiceCenter.getFounded()); 
		jgen.writeNumberField(RetailStoreCityServiceCenter.VERSION_PROPERTY,cityServiceCenter.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCreation(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCreation creation = retailStore.getCreation();
		
		if(creation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCreation.ID_PROPERTY,creation.getId()); 
		jgen.writeStringField(RetailStoreCreation.COMMENT_PROPERTY,creation.getComment()); 
		jgen.writeNumberField(RetailStoreCreation.VERSION_PROPERTY,creation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeInvestmentInvitation(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreInvestmentInvitation investmentInvitation = retailStore.getInvestmentInvitation();
		
		if(investmentInvitation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreInvestmentInvitation.ID_PROPERTY,investmentInvitation.getId()); 
		jgen.writeStringField(RetailStoreInvestmentInvitation.COMMENT_PROPERTY,investmentInvitation.getComment()); 
		jgen.writeNumberField(RetailStoreInvestmentInvitation.VERSION_PROPERTY,investmentInvitation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeFranchising(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreFranchising franchising = retailStore.getFranchising();
		
		if(franchising == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreFranchising.ID_PROPERTY,franchising.getId()); 
		jgen.writeStringField(RetailStoreFranchising.COMMENT_PROPERTY,franchising.getComment()); 
		jgen.writeNumberField(RetailStoreFranchising.VERSION_PROPERTY,franchising.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDecoration(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreDecoration decoration = retailStore.getDecoration();
		
		if(decoration == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreDecoration.ID_PROPERTY,decoration.getId()); 
		jgen.writeStringField(RetailStoreDecoration.COMMENT_PROPERTY,decoration.getComment()); 
		jgen.writeNumberField(RetailStoreDecoration.VERSION_PROPERTY,decoration.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeOpening(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreOpening opening = retailStore.getOpening();
		
		if(opening == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreOpening.ID_PROPERTY,opening.getId()); 
		jgen.writeStringField(RetailStoreOpening.COMMENT_PROPERTY,opening.getComment()); 
		jgen.writeNumberField(RetailStoreOpening.VERSION_PROPERTY,opening.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeClosing(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreClosing closing = retailStore.getClosing();
		
		if(closing == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreClosing.ID_PROPERTY,closing.getId()); 
		jgen.writeStringField(RetailStoreClosing.COMMENT_PROPERTY,closing.getComment()); 
		jgen.writeNumberField(RetailStoreClosing.VERSION_PROPERTY,closing.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConsumerOrderList(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();
		
		if(consumerOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(consumerOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ConsumerOrder consumerOrder: consumerOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ConsumerOrder.ID_PROPERTY,consumerOrder.getId());
			jgen.writeStringField(ConsumerOrder.TITLE_PROPERTY,consumerOrder.getTitle());
			jgen.writeStringField(ConsumerOrder.CURRENT_STATUS_PROPERTY,consumerOrder.getCurrentStatus());
			jgen.writeNumberField(ConsumerOrder.VERSION_PROPERTY,consumerOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreOrderList(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();
		
		if(retailStoreOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreOrder.ID_PROPERTY,retailStoreOrder.getId());
			jgen.writeStringField(RetailStoreOrder.TITLE_PROPERTY,retailStoreOrder.getTitle());
			jgen.writeNumberField(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY,retailStoreOrder.getTotalAmount());
			jgen.writeStringField(RetailStoreOrder.CURRENT_STATUS_PROPERTY,retailStoreOrder.getCurrentStatus());
			jgen.writeNumberField(RetailStoreOrder.VERSION_PROPERTY,retailStoreOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeGoodsList(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Goods> goodsList = retailStore.getGoodsList();
		
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
	protected void writeTransportTaskList(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TransportTask> transportTaskList = retailStore.getTransportTaskList();
		
		if(transportTaskList == null){
			return;//do nothing when null found for this field.
		}
		if(transportTaskList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TransportTask transportTask: transportTaskList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TransportTask.ID_PROPERTY,transportTask.getId());
			jgen.writeStringField(TransportTask.NAME_PROPERTY,transportTask.getName());
			jgen.writeStringField(TransportTask.START_PROPERTY,transportTask.getStart());
			jgen.writeObjectField(TransportTask.BEGIN_TIME_PROPERTY,transportTask.getBeginTime());
			jgen.writeNumberField(TransportTask.LATITUDE_PROPERTY,transportTask.getLatitude());
			jgen.writeNumberField(TransportTask.LONGITUDE_PROPERTY,transportTask.getLongitude());
			jgen.writeNumberField(TransportTask.VERSION_PROPERTY,transportTask.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeAccountSetList(String fieldName, RetailStore retailStore, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountSet> accountSetList = retailStore.getAccountSetList();
		
		if(accountSetList == null){
			return;//do nothing when null found for this field.
		}
		if(accountSetList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountSet accountSet: accountSetList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountSet.ID_PROPERTY,accountSet.getId());
			jgen.writeStringField(AccountSet.NAME_PROPERTY,accountSet.getName());
			jgen.writeStringField(AccountSet.YEAR_SET_PROPERTY,accountSet.getYearSet());
			jgen.writeObjectField(AccountSet.EFFECTIVE_DATE_PROPERTY,accountSet.getEffectiveDate());
			jgen.writeStringField(AccountSet.ACCOUNTING_SYSTEM_PROPERTY,accountSet.getAccountingSystem());
			jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY,accountSet.getDomesticCurrencyCode());
			jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY,accountSet.getDomesticCurrencyName());
			jgen.writeStringField(AccountSet.OPENING_BANK_PROPERTY,accountSet.getOpeningBank());
			jgen.writeStringField(AccountSet.ACCOUNT_NUMBER_PROPERTY,accountSet.getAccountNumber());
			jgen.writeNumberField(AccountSet.VERSION_PROPERTY,accountSet.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


