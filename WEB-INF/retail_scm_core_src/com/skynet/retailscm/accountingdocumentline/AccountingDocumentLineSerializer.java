
package com.skynet.retailscm.accountingdocumentline;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingdocument.AccountingDocument;


public class AccountingDocumentLineSerializer extends BaseJsonSerializer<AccountingDocumentLine>{

	

	@Override
	public void serialize(AccountingDocumentLine accountingDocumentLine, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingDocumentLine,jgen,provider);
		
		jgen.writeStringField(AccountingDocumentLine.ID_PROPERTY,accountingDocumentLine.getId());
		jgen.writeStringField(AccountingDocumentLine.NAME_PROPERTY,accountingDocumentLine.getName());
		jgen.writeStringField(AccountingDocumentLine.CODE_PROPERTY,accountingDocumentLine.getCode());
		jgen.writeStringField(AccountingDocumentLine.DIRECT_PROPERTY,accountingDocumentLine.getDirect());
		jgen.writeNumberField(AccountingDocumentLine.AMOUNT_PROPERTY,accountingDocumentLine.getAmount());
		writeBelongsTo(AccountingDocumentLine.BELONGS_TO_PROPERTY,accountingDocumentLine,jgen,provider);
		writeAccountingSubject(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY,accountingDocumentLine,jgen,provider);
		jgen.writeNumberField(AccountingDocumentLine.VERSION_PROPERTY,accountingDocumentLine.getVersion());
		
		writeEndObject(accountingDocumentLine,jgen,provider);
	}
	
	protected void writeBelongsTo(String fieldName, AccountingDocumentLine accountingDocumentLine, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingDocument belongsTo = accountingDocumentLine.getBelongsTo();
		
		if(belongsTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingDocument.ID_PROPERTY,belongsTo.getId()); 
		jgen.writeStringField(AccountingDocument.NAME_PROPERTY,belongsTo.getName()); 
		jgen.writeObjectField(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY,belongsTo.getAccountingDocumentDate()); 
		jgen.writeStringField(AccountingDocument.CURRENT_STATUS_PROPERTY,belongsTo.getCurrentStatus()); 
		jgen.writeNumberField(AccountingDocument.VERSION_PROPERTY,belongsTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAccountingSubject(String fieldName, AccountingDocumentLine accountingDocumentLine, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingSubject accountingSubject = accountingDocumentLine.getAccountingSubject();
		
		if(accountingSubject == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingSubject.ID_PROPERTY,accountingSubject.getId()); 
		jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY,accountingSubject.getAccountingSubjectCode()); 
		jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY,accountingSubject.getAccountingSubjectName()); 
		jgen.writeNumberField(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY,accountingSubject.getAccountingSubjectClassCode()); 
		jgen.writeStringField(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY,accountingSubject.getAccountingSubjectClassName()); 
		jgen.writeNumberField(AccountingSubject.VERSION_PROPERTY,accountingSubject.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


