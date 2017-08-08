
package com.skynet.retailscm.accountingdocumentauditing;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingdocument.AccountingDocument;


public class AccountingDocumentAuditingSerializer extends BaseJsonSerializer<AccountingDocumentAuditing>{

	

	@Override
	public void serialize(AccountingDocumentAuditing accountingDocumentAuditing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingDocumentAuditing,jgen,provider);
		
		jgen.writeStringField(AccountingDocumentAuditing.ID_PROPERTY,accountingDocumentAuditing.getId());
		jgen.writeStringField(AccountingDocumentAuditing.WHO_PROPERTY,accountingDocumentAuditing.getWho());
		jgen.writeStringField(AccountingDocumentAuditing.COMMENTS_PROPERTY,accountingDocumentAuditing.getComments());
		jgen.writeObjectField(AccountingDocumentAuditing.MAKE_DATE_PROPERTY,accountingDocumentAuditing.getMakeDate());
		jgen.writeNumberField(AccountingDocumentAuditing.VERSION_PROPERTY,accountingDocumentAuditing.getVersion());
		writeAccountingDocumentList(AccountingDocumentAuditing.ACCOUNTING_DOCUMENT_LIST,accountingDocumentAuditing,jgen,provider);
		
		writeEndObject(accountingDocumentAuditing,jgen,provider);
	}
	
	protected void writeAccountingDocumentList(String fieldName, AccountingDocumentAuditing accountingDocumentAuditing, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocument> accountingDocumentList = accountingDocumentAuditing.getAccountingDocumentList();
		
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


