
package com.skynet.retailscm.accountingdocumentcreation;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingdocument.AccountingDocument;


public class AccountingDocumentCreationSerializer extends BaseJsonSerializer<AccountingDocumentCreation>{

	

	@Override
	public void serialize(AccountingDocumentCreation accountingDocumentCreation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingDocumentCreation,jgen,provider);
		
		jgen.writeStringField(AccountingDocumentCreation.ID_PROPERTY,accountingDocumentCreation.getId());
		jgen.writeStringField(AccountingDocumentCreation.WHO_PROPERTY,accountingDocumentCreation.getWho());
		jgen.writeStringField(AccountingDocumentCreation.COMMENTS_PROPERTY,accountingDocumentCreation.getComments());
		jgen.writeObjectField(AccountingDocumentCreation.MAKE_DATE_PROPERTY,accountingDocumentCreation.getMakeDate());
		jgen.writeNumberField(AccountingDocumentCreation.VERSION_PROPERTY,accountingDocumentCreation.getVersion());
		writeAccountingDocumentList(AccountingDocumentCreation.ACCOUNTING_DOCUMENT_LIST,accountingDocumentCreation,jgen,provider);
		
		writeEndObject(accountingDocumentCreation,jgen,provider);
	}
	
	protected void writeAccountingDocumentList(String fieldName, AccountingDocumentCreation accountingDocumentCreation, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocument> accountingDocumentList = accountingDocumentCreation.getAccountingDocumentList();
		
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


