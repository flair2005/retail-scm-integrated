
package com.skynet.retailscm.originalvoucher;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.accountingdocument.AccountingDocument;


public class OriginalVoucherSerializer extends BaseJsonSerializer<OriginalVoucher>{

	

	@Override
	public void serialize(OriginalVoucher originalVoucher, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(originalVoucher,jgen,provider);
		
		jgen.writeStringField(OriginalVoucher.ID_PROPERTY,originalVoucher.getId());
		jgen.writeStringField(OriginalVoucher.TITLE_PROPERTY,originalVoucher.getTitle());
		jgen.writeStringField(OriginalVoucher.MADE_BY_PROPERTY,originalVoucher.getMadeBy());
		jgen.writeStringField(OriginalVoucher.RECEIVED_BY_PROPERTY,originalVoucher.getReceivedBy());
		jgen.writeStringField(OriginalVoucher.VOUCHER_TYPE_PROPERTY,originalVoucher.getVoucherType());
		jgen.writeStringField(OriginalVoucher.VOUCHER_IMAGE_PROPERTY,originalVoucher.getVoucherImage());
		writeBelongsTo(OriginalVoucher.BELONGS_TO_PROPERTY,originalVoucher,jgen,provider);
		writeCreation(OriginalVoucher.CREATION_PROPERTY,originalVoucher,jgen,provider);
		writeConfirmation(OriginalVoucher.CONFIRMATION_PROPERTY,originalVoucher,jgen,provider);
		writeAuditing(OriginalVoucher.AUDITING_PROPERTY,originalVoucher,jgen,provider);
		jgen.writeStringField(OriginalVoucher.CURRENT_STATUS_PROPERTY,originalVoucher.getCurrentStatus());
		jgen.writeNumberField(OriginalVoucher.VERSION_PROPERTY,originalVoucher.getVersion());
		
		writeEndObject(originalVoucher,jgen,provider);
	}
	
	protected void writeBelongsTo(String fieldName, OriginalVoucher originalVoucher, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		AccountingDocument belongsTo = originalVoucher.getBelongsTo();
		
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
	
	protected void writeCreation(String fieldName, OriginalVoucher originalVoucher, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		OriginalVoucherCreation creation = originalVoucher.getCreation();
		
		if(creation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(OriginalVoucherCreation.ID_PROPERTY,creation.getId()); 
		jgen.writeStringField(OriginalVoucherCreation.WHO_PROPERTY,creation.getWho()); 
		jgen.writeStringField(OriginalVoucherCreation.COMMENTS_PROPERTY,creation.getComments()); 
		jgen.writeObjectField(OriginalVoucherCreation.MAKE_DATE_PROPERTY,creation.getMakeDate()); 
		jgen.writeNumberField(OriginalVoucherCreation.VERSION_PROPERTY,creation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeConfirmation(String fieldName, OriginalVoucher originalVoucher, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		OriginalVoucherConfirmation confirmation = originalVoucher.getConfirmation();
		
		if(confirmation == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(OriginalVoucherConfirmation.ID_PROPERTY,confirmation.getId()); 
		jgen.writeStringField(OriginalVoucherConfirmation.WHO_PROPERTY,confirmation.getWho()); 
		jgen.writeStringField(OriginalVoucherConfirmation.COMMENTS_PROPERTY,confirmation.getComments()); 
		jgen.writeObjectField(OriginalVoucherConfirmation.MAKE_DATE_PROPERTY,confirmation.getMakeDate()); 
		jgen.writeNumberField(OriginalVoucherConfirmation.VERSION_PROPERTY,confirmation.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeAuditing(String fieldName, OriginalVoucher originalVoucher, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		OriginalVoucherAuditing auditing = originalVoucher.getAuditing();
		
		if(auditing == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(OriginalVoucherAuditing.ID_PROPERTY,auditing.getId()); 
		jgen.writeStringField(OriginalVoucherAuditing.WHO_PROPERTY,auditing.getWho()); 
		jgen.writeStringField(OriginalVoucherAuditing.COMMENTS_PROPERTY,auditing.getComments()); 
		jgen.writeObjectField(OriginalVoucherAuditing.MAKE_DATE_PROPERTY,auditing.getMakeDate()); 
		jgen.writeNumberField(OriginalVoucherAuditing.VERSION_PROPERTY,auditing.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


