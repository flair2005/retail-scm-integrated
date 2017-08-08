
package com.skynet.retailscm.reportline;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.reportline.ReportLine;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.report.Report;


public class ReportLineSerializer extends BaseJsonSerializer<ReportLine>{

	

	@Override
	public void serialize(ReportLine reportLine, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(reportLine,jgen,provider);
		
		jgen.writeStringField(ReportLine.ID_PROPERTY,reportLine.getId());
		jgen.writeStringField(ReportLine.NAME_PROPERTY,reportLine.getName());
		writeOwner(ReportLine.OWNER_PROPERTY,reportLine,jgen,provider);
		jgen.writeNumberField(ReportLine.JANUARY_PROPERTY,reportLine.getJanuary());
		jgen.writeNumberField(ReportLine.FEBRUARY_PROPERTY,reportLine.getFebruary());
		jgen.writeNumberField(ReportLine.MARCH_PROPERTY,reportLine.getMarch());
		jgen.writeNumberField(ReportLine.APRIL_PROPERTY,reportLine.getApril());
		jgen.writeNumberField(ReportLine.MAY_PROPERTY,reportLine.getMay());
		jgen.writeNumberField(ReportLine.JUNE_PROPERTY,reportLine.getJune());
		jgen.writeNumberField(ReportLine.JULY_PROPERTY,reportLine.getJuly());
		jgen.writeNumberField(ReportLine.AUGUST_PROPERTY,reportLine.getAugust());
		jgen.writeNumberField(ReportLine.SEPTEMBER_PROPERTY,reportLine.getSeptember());
		jgen.writeNumberField(ReportLine.OCTOBER_PROPERTY,reportLine.getOctober());
		jgen.writeNumberField(ReportLine.NOVEMBER_PROPERTY,reportLine.getNovember());
		jgen.writeNumberField(ReportLine.DECEMBER_PROPERTY,reportLine.getDecember());
		jgen.writeNumberField(ReportLine.VERSION_PROPERTY,reportLine.getVersion());
		
		writeEndObject(reportLine,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, ReportLine reportLine, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Report owner = reportLine.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Report.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(Report.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(Report.CREATED_BY_PROPERTY,owner.getCreatedBy()); 
		jgen.writeNumberField(Report.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


