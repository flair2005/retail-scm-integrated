
package com.skynet.retailscm.accountset;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;


public class AccountSetSerializer extends BaseJsonSerializer<AccountSet>{

	

	@Override
	public void serialize(AccountSet accountSet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountSet,jgen,provider);
		
		jgen.writeStringField(AccountSet.ID_PROPERTY,accountSet.getId());
		jgen.writeStringField(AccountSet.NAME_PROPERTY,accountSet.getName());
		jgen.writeStringField(AccountSet.YEAR_SET_PROPERTY,accountSet.getYearSet());
		jgen.writeObjectField(AccountSet.EFFECTIVE_DATE_PROPERTY,accountSet.getEffectiveDate());
		jgen.writeStringField(AccountSet.ACCOUNTING_SYSTEM_PROPERTY,accountSet.getAccountingSystem());
		jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY,accountSet.getDomesticCurrencyCode());
		jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY,accountSet.getDomesticCurrencyName());
		jgen.writeStringField(AccountSet.OPENING_BANK_PROPERTY,accountSet.getOpeningBank());
		jgen.writeStringField(AccountSet.ACCOUNT_NUMBER_PROPERTY,accountSet.getAccountNumber());
		writeCountryCenter(AccountSet.COUNTRY_CENTER_PROPERTY,accountSet,jgen,provider);
		writeRetailStore(AccountSet.RETAIL_STORE_PROPERTY,accountSet,jgen,provider);
		writeGoodsSupplier(AccountSet.GOODS_SUPPLIER_PROPERTY,accountSet,jgen,provider);
		jgen.writeNumberField(AccountSet.VERSION_PROPERTY,accountSet.getVersion());
		writeAccountingSubjectList(AccountSet.ACCOUNTING_SUBJECT_LIST,accountSet,jgen,provider);
		writeAccountingPeriodList(AccountSet.ACCOUNTING_PERIOD_LIST,accountSet,jgen,provider);
		writeAccountingDocumentTypeList(AccountSet.ACCOUNTING_DOCUMENT_TYPE_LIST,accountSet,jgen,provider);
		
		writeEndObject(accountSet,jgen,provider);
	}
	
	protected void writeCountryCenter(String fieldName, AccountSet accountSet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter countryCenter = accountSet.getCountryCenter();
		
		if(countryCenter == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,countryCenter.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,countryCenter.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,countryCenter.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,countryCenter.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,countryCenter.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,countryCenter.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,countryCenter.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,countryCenter.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,countryCenter.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,countryCenter.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeRetailStore(String fieldName, AccountSet accountSet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStore retailStore = accountSet.getRetailStore();
		
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
	
	protected void writeGoodsSupplier(String fieldName, AccountSet accountSet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsSupplier goodsSupplier = accountSet.getGoodsSupplier();
		
		if(goodsSupplier == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsSupplier.ID_PROPERTY,goodsSupplier.getId()); 
		jgen.writeStringField(GoodsSupplier.NAME_PROPERTY,goodsSupplier.getName()); 
		jgen.writeStringField(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY,goodsSupplier.getSupplyProduct()); 
		jgen.writeStringField(GoodsSupplier.CONTACT_NUMBER_PROPERTY,goodsSupplier.getContactNumber()); 
		jgen.writeStringField(GoodsSupplier.DESCRIPTION_PROPERTY,goodsSupplier.getDescription()); 
		jgen.writeNumberField(GoodsSupplier.VERSION_PROPERTY,goodsSupplier.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAccountingSubjectList(String fieldName, AccountSet accountSet, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingSubject> accountingSubjectList = accountSet.getAccountingSubjectList();
		
		if(accountingSubjectList == null){
			return;//do nothing when null found for this field.
		}
		if(accountingSubjectList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountingSubject accountingSubject: accountingSubjectList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountingSubject.ID_PROPERTY,accountingSubject.getId());
			jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY,accountingSubject.getAccountingSubjectCode());
			jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY,accountingSubject.getAccountingSubjectName());
			jgen.writeNumberField(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY,accountingSubject.getAccountingSubjectClassCode());
			jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY,accountingSubject.getAccountingSubjectClassName());
			jgen.writeNumberField(AccountingSubject.VERSION_PROPERTY,accountingSubject.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeAccountingPeriodList(String fieldName, AccountSet accountSet, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingPeriod> accountingPeriodList = accountSet.getAccountingPeriodList();
		
		if(accountingPeriodList == null){
			return;//do nothing when null found for this field.
		}
		if(accountingPeriodList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountingPeriod accountingPeriod: accountingPeriodList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountingPeriod.ID_PROPERTY,accountingPeriod.getId());
			jgen.writeStringField(AccountingPeriod.NAME_PROPERTY,accountingPeriod.getName());
			jgen.writeObjectField(AccountingPeriod.START_DATE_PROPERTY,accountingPeriod.getStartDate());
			jgen.writeObjectField(AccountingPeriod.END_DATE_PROPERTY,accountingPeriod.getEndDate());
			jgen.writeNumberField(AccountingPeriod.VERSION_PROPERTY,accountingPeriod.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeAccountingDocumentTypeList(String fieldName, AccountSet accountSet, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocumentType> accountingDocumentTypeList = accountSet.getAccountingDocumentTypeList();
		
		if(accountingDocumentTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(accountingDocumentTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountingDocumentType accountingDocumentType: accountingDocumentTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountingDocumentType.ID_PROPERTY,accountingDocumentType.getId());
			jgen.writeStringField(AccountingDocumentType.NAME_PROPERTY,accountingDocumentType.getName());
			jgen.writeStringField(AccountingDocumentType.DESCRIPTION_PROPERTY,accountingDocumentType.getDescription());
			jgen.writeNumberField(AccountingDocumentType.VERSION_PROPERTY,accountingDocumentType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


