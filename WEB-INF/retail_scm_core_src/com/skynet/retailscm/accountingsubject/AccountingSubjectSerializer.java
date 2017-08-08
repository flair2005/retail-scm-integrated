
package com.skynet.retailscm.accountingsubject;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;


public class AccountingSubjectSerializer extends BaseJsonSerializer<AccountingSubject>{

	

	@Override
	public void serialize(AccountingSubject accountingSubject, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingSubject,jgen,provider);
		
		jgen.writeStringField(AccountingSubject.ID_PROPERTY,accountingSubject.getId());
		jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY,accountingSubject.getAccountingSubjectCode());
		jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY,accountingSubject.getAccountingSubjectName());
		jgen.writeNumberField(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY,accountingSubject.getAccountingSubjectClassCode());
		jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY,accountingSubject.getAccountingSubjectClassName());
		writeAccountSet(AccountingSubject.ACCOUNT_SET_PROPERTY,accountingSubject,jgen,provider);
		jgen.writeNumberField(AccountingSubject.VERSION_PROPERTY,accountingSubject.getVersion());
		writeAccountingDocumentLineList(AccountingSubject.ACCOUNTING_DOCUMENT_LINE_LIST,accountingSubject,jgen,provider);
		
		writeEndObject(accountingSubject,jgen,provider);
	}
	
	protected void writeAccountSet(String fieldName, AccountingSubject accountingSubject, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountSet accountSet = accountingSubject.getAccountSet();
		
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
	
	protected void writeAccountingDocumentLineList(String fieldName, AccountingSubject accountingSubject, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocumentLine> accountingDocumentLineList = accountingSubject.getAccountingDocumentLineList();
		
		if(accountingDocumentLineList == null){
			return;//do nothing when null found for this field.
		}
		if(accountingDocumentLineList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountingDocumentLine accountingDocumentLine: accountingDocumentLineList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountingDocumentLine.ID_PROPERTY,accountingDocumentLine.getId());
			jgen.writeStringField(AccountingDocumentLine.NAME_PROPERTY,accountingDocumentLine.getName());
			jgen.writeStringField(AccountingDocumentLine.CODE_PROPERTY,accountingDocumentLine.getCode());
			jgen.writeStringField(AccountingDocumentLine.DIRECT_PROPERTY,accountingDocumentLine.getDirect());
			jgen.writeNumberField(AccountingDocumentLine.AMOUNT_PROPERTY,accountingDocumentLine.getAmount());
			jgen.writeNumberField(AccountingDocumentLine.VERSION_PROPERTY,accountingDocumentLine.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


