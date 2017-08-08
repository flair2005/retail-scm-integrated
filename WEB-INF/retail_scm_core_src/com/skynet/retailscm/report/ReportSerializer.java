
package com.skynet.retailscm.report;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.report.Report;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.reportline.ReportLine;


public class ReportSerializer extends BaseJsonSerializer<Report>{

	

	@Override
	public void serialize(Report report, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(report,jgen,provider);
		
		jgen.writeStringField(Report.ID_PROPERTY,report.getId());
		jgen.writeStringField(Report.NAME_PROPERTY,report.getName());
		jgen.writeStringField(Report.CREATED_BY_PROPERTY,report.getCreatedBy());
		writeOwner(Report.OWNER_PROPERTY,report,jgen,provider);
		jgen.writeNumberField(Report.VERSION_PROPERTY,report.getVersion());
		writeReportLineList(Report.REPORT_LINE_LIST,report,jgen,provider);
		
		writeEndObject(report,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, Report report, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter owner = report.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,owner.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,owner.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,owner.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,owner.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,owner.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,owner.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,owner.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeReportLineList(String fieldName, Report report, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ReportLine> reportLineList = report.getReportLineList();
		
		if(reportLineList == null){
			return;//do nothing when null found for this field.
		}
		if(reportLineList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ReportLine reportLine: reportLineList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ReportLine.ID_PROPERTY,reportLine.getId());
			jgen.writeStringField(ReportLine.NAME_PROPERTY,reportLine.getName());
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

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


