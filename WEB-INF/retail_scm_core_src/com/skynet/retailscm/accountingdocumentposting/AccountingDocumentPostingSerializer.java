
package com.skynet.retailscm.accountingdocumentposting;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingdocument.AccountingDocument;


public class AccountingDocumentPostingSerializer extends BaseJsonSerializer<AccountingDocumentPosting>{

	

	@Override
	public void serialize(AccountingDocumentPosting accountingDocumentPosting, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingDocumentPosting,jgen,provider);
		
		jgen.writeStringField(AccountingDocumentPosting.ID_PROPERTY,accountingDocumentPosting.getId());
		jgen.writeStringField(AccountingDocumentPosting.WHO_PROPERTY,accountingDocumentPosting.getWho());
		jgen.writeStringField(AccountingDocumentPosting.COMMENTS_PROPERTY,accountingDocumentPosting.getComments());
		jgen.writeObjectField(AccountingDocumentPosting.MAKE_DATE_PROPERTY,accountingDocumentPosting.getMakeDate());
		jgen.writeNumberField(AccountingDocumentPosting.VERSION_PROPERTY,accountingDocumentPosting.getVersion());
		writeAccountingDocumentList(AccountingDocumentPosting.ACCOUNTING_DOCUMENT_LIST,accountingDocumentPosting,jgen,provider);
		
		writeEndObject(accountingDocumentPosting,jgen,provider);
	}
	
	protected void writeAccountingDocumentList(String fieldName, AccountingDocumentPosting accountingDocumentPosting, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocument> accountingDocumentList = accountingDocumentPosting.getAccountingDocumentList();
		
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


