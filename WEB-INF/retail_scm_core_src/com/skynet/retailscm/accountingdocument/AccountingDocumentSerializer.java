
package com.skynet.retailscm.accountingdocument;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;


public class AccountingDocumentSerializer extends BaseJsonSerializer<AccountingDocument>{

	

	@Override
	public void serialize(AccountingDocument accountingDocument, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(accountingDocument,jgen,provider);
		
		jgen.writeStringField(AccountingDocument.ID_PROPERTY,accountingDocument.getId());
		jgen.writeStringField(AccountingDocument.NAME_PROPERTY,accountingDocument.getName());
		jgen.writeObjectField(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY,accountingDocument.getAccountingDocumentDate());
		writeAccountingPeriod(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY,accountingDocument,jgen,provider);
		writeDocumentType(AccountingDocument.DOCUMENT_TYPE_PROPERTY,accountingDocument,jgen,provider);
		writeCreation(AccountingDocument.CREATION_PROPERTY,accountingDocument,jgen,provider);
		writeConfirmation(AccountingDocument.CONFIRMATION_PROPERTY,accountingDocument,jgen,provider);
		writeAuditing(AccountingDocument.AUDITING_PROPERTY,accountingDocument,jgen,provider);
		writePosting(AccountingDocument.POSTING_PROPERTY,accountingDocument,jgen,provider);
		jgen.writeStringField(AccountingDocument.CURRENT_STATUS_PROPERTY,accountingDocument.getCurrentStatus());
		jgen.writeNumberField(AccountingDocument.VERSION_PROPERTY,accountingDocument.getVersion());
		writeOriginalVoucherList(AccountingDocument.ORIGINAL_VOUCHER_LIST,accountingDocument,jgen,provider);
		writeAccountingDocumentLineList(AccountingDocument.ACCOUNTING_DOCUMENT_LINE_LIST,accountingDocument,jgen,provider);
		
		writeEndObject(accountingDocument,jgen,provider);
	}
	
	protected void writeAccountingPeriod(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingPeriod accountingPeriod = accountingDocument.getAccountingPeriod();
		
		if(accountingPeriod == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingPeriod.ID_PROPERTY,accountingPeriod.getId()); 
		jgen.writeStringField(AccountingPeriod.NAME_PROPERTY,accountingPeriod.getName()); 
		jgen.writeObjectField(AccountingPeriod.START_DATE_PROPERTY,accountingPeriod.getStartDate()); 
		jgen.writeObjectField(AccountingPeriod.END_DATE_PROPERTY,accountingPeriod.getEndDate()); 
		jgen.writeNumberField(AccountingPeriod.VERSION_PROPERTY,accountingPeriod.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeDocumentType(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingDocumentType documentType = accountingDocument.getDocumentType();
		
		if(documentType == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingDocumentType.ID_PROPERTY,documentType.getId()); 
		jgen.writeStringField(AccountingDocumentType.NAME_PROPERTY,documentType.getName()); 
		jgen.writeStringField(AccountingDocumentType.DESCRIPTION_PROPERTY,documentType.getDescription()); 
		jgen.writeNumberField(AccountingDocumentType.VERSION_PROPERTY,documentType.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCreation(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingDocumentCreation creation = accountingDocument.getCreation();
		
		if(creation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingDocumentCreation.ID_PROPERTY,creation.getId()); 
		jgen.writeStringField(AccountingDocumentCreation.WHO_PROPERTY,creation.getWho()); 
		jgen.writeStringField(AccountingDocumentCreation.COMMENTS_PROPERTY,creation.getComments()); 
		jgen.writeObjectField(AccountingDocumentCreation.MAKE_DATE_PROPERTY,creation.getMakeDate()); 
		jgen.writeNumberField(AccountingDocumentCreation.VERSION_PROPERTY,creation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConfirmation(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingDocumentConfirmation confirmation = accountingDocument.getConfirmation();
		
		if(confirmation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingDocumentConfirmation.ID_PROPERTY,confirmation.getId()); 
		jgen.writeStringField(AccountingDocumentConfirmation.WHO_PROPERTY,confirmation.getWho()); 
		jgen.writeStringField(AccountingDocumentConfirmation.COMMENTS_PROPERTY,confirmation.getComments()); 
		jgen.writeObjectField(AccountingDocumentConfirmation.MAKE_DATE_PROPERTY,confirmation.getMakeDate()); 
		jgen.writeNumberField(AccountingDocumentConfirmation.VERSION_PROPERTY,confirmation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAuditing(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingDocumentAuditing auditing = accountingDocument.getAuditing();
		
		if(auditing == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingDocumentAuditing.ID_PROPERTY,auditing.getId()); 
		jgen.writeStringField(AccountingDocumentAuditing.WHO_PROPERTY,auditing.getWho()); 
		jgen.writeStringField(AccountingDocumentAuditing.COMMENTS_PROPERTY,auditing.getComments()); 
		jgen.writeObjectField(AccountingDocumentAuditing.MAKE_DATE_PROPERTY,auditing.getMakeDate()); 
		jgen.writeNumberField(AccountingDocumentAuditing.VERSION_PROPERTY,auditing.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writePosting(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingDocumentPosting posting = accountingDocument.getPosting();
		
		if(posting == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(AccountingDocumentPosting.ID_PROPERTY,posting.getId()); 
		jgen.writeStringField(AccountingDocumentPosting.WHO_PROPERTY,posting.getWho()); 
		jgen.writeStringField(AccountingDocumentPosting.COMMENTS_PROPERTY,posting.getComments()); 
		jgen.writeObjectField(AccountingDocumentPosting.MAKE_DATE_PROPERTY,posting.getMakeDate()); 
		jgen.writeNumberField(AccountingDocumentPosting.VERSION_PROPERTY,posting.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeOriginalVoucherList(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<OriginalVoucher> originalVoucherList = accountingDocument.getOriginalVoucherList();
		
		if(originalVoucherList == null){
			return;//do nothing when null found for this field.
		}
		if(originalVoucherList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(OriginalVoucher originalVoucher: originalVoucherList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(OriginalVoucher.ID_PROPERTY,originalVoucher.getId());
			jgen.writeStringField(OriginalVoucher.TITLE_PROPERTY,originalVoucher.getTitle());
			jgen.writeStringField(OriginalVoucher.MADE_BY_PROPERTY,originalVoucher.getMadeBy());
			jgen.writeStringField(OriginalVoucher.RECEIVED_BY_PROPERTY,originalVoucher.getReceivedBy());
			jgen.writeStringField(OriginalVoucher.VOUCHER_TYPE_PROPERTY,originalVoucher.getVoucherType());
			jgen.writeStringField(OriginalVoucher.VOUCHER_IMAGE_PROPERTY,originalVoucher.getVoucherImage());
			jgen.writeStringField(OriginalVoucher.CURRENT_STATUS_PROPERTY,originalVoucher.getCurrentStatus());
			jgen.writeNumberField(OriginalVoucher.VERSION_PROPERTY,originalVoucher.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeAccountingDocumentLineList(String fieldName, AccountingDocument accountingDocument, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountingDocumentLine> accountingDocumentLineList = accountingDocument.getAccountingDocumentLineList();
		
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


