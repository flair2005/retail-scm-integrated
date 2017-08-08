
package com.skynet.retailscm.accountingperiod;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.accountset.AccountSet;


public class AccountingPeriodSerializer extends BaseJsonSerializer<AccountingPeriod>{

	

	@Override
	public void serialize(AccountingPeriod accountingPeriod, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingPeriod,jgen,provider);
		
		jgen.writeStringField(AccountingPeriod.ID_PROPERTY,accountingPeriod.getId());
		jgen.writeStringField(AccountingPeriod.NAME_PROPERTY,accountingPeriod.getName());
		jgen.writeObjectField(AccountingPeriod.START_DATE_PROPERTY,accountingPeriod.getStartDate());
		jgen.writeObjectField(AccountingPeriod.END_DATE_PROPERTY,accountingPeriod.getEndDate());
		writeAccountSet(AccountingPeriod.ACCOUNT_SET_PROPERTY,accountingPeriod,jgen,provider);
		jgen.writeNumberField(AccountingPeriod.VERSION_PROPERTY,accountingPeriod.getVersion());
		writeAccountingDocumentList(AccountingPeriod.ACCOUNTING_DOCUMENT_LIST,accountingPeriod,jgen,provider);
		
		writeEndObject(accountingPeriod,jgen,provider);
	}
	
	protected void writeAccountSet(String fieldName, AccountingPeriod accountingPeriod, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountSet accountSet = accountingPeriod.getAccountSet();
		
		if(accountSet == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
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
		jgen.writeEndObject();
		
	}
	
	protected void writeAccountingDocumentList(String fieldName, AccountingPeriod accountingPeriod, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocument> accountingDocumentList = accountingPeriod.getAccountingDocumentList();
		
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


