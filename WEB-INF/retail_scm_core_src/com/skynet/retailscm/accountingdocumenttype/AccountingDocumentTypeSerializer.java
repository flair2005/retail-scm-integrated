
package com.skynet.retailscm.accountingdocumenttype;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.accountset.AccountSet;


public class AccountingDocumentTypeSerializer extends BaseJsonSerializer<AccountingDocumentType>{

	

	@Override
	public void serialize(AccountingDocumentType accountingDocumentType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingDocumentType,jgen,provider);
		
		jgen.writeStringField(AccountingDocumentType.ID_PROPERTY,accountingDocumentType.getId());
		jgen.writeStringField(AccountingDocumentType.NAME_PROPERTY,accountingDocumentType.getName());
		jgen.writeStringField(AccountingDocumentType.DESCRIPTION_PROPERTY,accountingDocumentType.getDescription());
		writeAccountingPeriod(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY,accountingDocumentType,jgen,provider);
		jgen.writeNumberField(AccountingDocumentType.VERSION_PROPERTY,accountingDocumentType.getVersion());
		writeAccountingDocumentList(AccountingDocumentType.ACCOUNTING_DOCUMENT_LIST,accountingDocumentType,jgen,provider);
		
		writeEndObject(accountingDocumentType,jgen,provider);
	}
	
	protected void writeAccountingPeriod(String fieldName, AccountingDocumentType accountingDocumentType, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountSet accountingPeriod = accountingDocumentType.getAccountingPeriod();
		
		if(accountingPeriod == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountSet.ID_PROPERTY,accountingPeriod.getId()); 
		jgen.writeStringField(AccountSet.NAME_PROPERTY,accountingPeriod.getName()); 
		jgen.writeStringField(AccountSet.YEAR_SET_PROPERTY,accountingPeriod.getYearSet()); 
		jgen.writeObjectField(AccountSet.EFFECTIVE_DATE_PROPERTY,accountingPeriod.getEffectiveDate()); 
		jgen.writeStringField(AccountSet.ACCOUNTING_SYSTEM_PROPERTY,accountingPeriod.getAccountingSystem()); 
		jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY,accountingPeriod.getDomesticCurrencyCode()); 
		jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY,accountingPeriod.getDomesticCurrencyName()); 
		jgen.writeStringField(AccountSet.OPENING_BANK_PROPERTY,accountingPeriod.getOpeningBank()); 
		jgen.writeStringField(AccountSet.ACCOUNT_NUMBER_PROPERTY,accountingPeriod.getAccountNumber()); 
		jgen.writeNumberField(AccountSet.VERSION_PROPERTY,accountingPeriod.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAccountingDocumentList(String fieldName, AccountingDocumentType accountingDocumentType, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocument> accountingDocumentList = accountingDocumentType.getAccountingDocumentList();
		
		if(accountingDocumentList == null){
			return;//do nothing when null found for this field.
		}
		if(accountingDocumentList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountingDocument accountingDocument: accountingDocumentList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountingDocument.ID_PROPERTY,accountingDocument.getId());
			jgen.writeStringField(AccountingDocument.NAME_PROPERTY,accountingDocument.getName());
			jgen.writeObjectField(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY,accountingDocument.getAccountingDocumentDate());
			jgen.writeStringField(AccountingDocument.CURRENT_STATUS_PROPERTY,accountingDocument.getCurrentStatus());
			jgen.writeNumberField(AccountingDocument.VERSION_PROPERTY,accountingDocument.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


