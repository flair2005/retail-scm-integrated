
package com.skynet.retailscm.accountingdocumentconfirmation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingdocument.AccountingDocument;


public class AccountingDocumentConfirmationSerializer extends BaseJsonSerializer<AccountingDocumentConfirmation>{

	

	@Override
	public void serialize(AccountingDocumentConfirmation accountingDocumentConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingDocumentConfirmation,jgen,provider);
		
		jgen.writeStringField(AccountingDocumentConfirmation.ID_PROPERTY,accountingDocumentConfirmation.getId());
		jgen.writeStringField(AccountingDocumentConfirmation.WHO_PROPERTY,accountingDocumentConfirmation.getWho());
		jgen.writeStringField(AccountingDocumentConfirmation.COMMENTS_PROPERTY,accountingDocumentConfirmation.getComments());
		jgen.writeObjectField(AccountingDocumentConfirmation.MAKE_DATE_PROPERTY,accountingDocumentConfirmation.getMakeDate());
		jgen.writeNumberField(AccountingDocumentConfirmation.VERSION_PROPERTY,accountingDocumentConfirmation.getVersion());
		writeAccountingDocumentList(AccountingDocumentConfirmation.ACCOUNTING_DOCUMENT_LIST,accountingDocumentConfirmation,jgen,provider);
		
		writeEndObject(accountingDocumentConfirmation,jgen,provider);
	}
	
	protected void writeAccountingDocumentList(String fieldName, AccountingDocumentConfirmation accountingDocumentConfirmation, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocument> accountingDocumentList = accountingDocumentConfirmation.getAccountingDocumentList();
		
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


