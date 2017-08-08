
package com.skynet.retailscm.interviewtype;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeinterview.EmployeeInterview;


public class InterviewTypeSerializer extends BaseJsonSerializer<InterviewType>{

	

	@Override
	public void serialize(InterviewType interviewType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(interviewType,jgen,provider);
		
		jgen.writeStringField(InterviewType.ID_PROPERTY,interviewType.getId());
		jgen.writeStringField(InterviewType.CODE_PROPERTY,interviewType.getCode());
		writeCompany(InterviewType.COMPANY_PROPERTY,interviewType,jgen,provider);
		jgen.writeStringField(InterviewType.DESCRIPTION_PROPERTY,interviewType.getDescription());
		jgen.writeStringField(InterviewType.DETAIL_DESCRIPTION_PROPERTY,interviewType.getDetailDescription());
		jgen.writeNumberField(InterviewType.VERSION_PROPERTY,interviewType.getVersion());
		writeEmployeeInterviewList(InterviewType.EMPLOYEE_INTERVIEW_LIST,interviewType,jgen,provider);
		
		writeEndObject(interviewType,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, InterviewType interviewType, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = interviewType.getCompany();
		
		if(company == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,company.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,company.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,company.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,company.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,company.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,company.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,company.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,company.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,company.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,company.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeInterviewList(String fieldName, InterviewType interviewType, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeInterview> employeeInterviewList = interviewType.getEmployeeInterviewList();
		
		if(employeeInterviewList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeInterviewList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeInterview employeeInterview: employeeInterviewList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeInterview.ID_PROPERTY,employeeInterview.getId());
			jgen.writeStringField(EmployeeInterview.REMARK_PROPERTY,employeeInterview.getRemark());
			jgen.writeNumberField(EmployeeInterview.VERSION_PROPERTY,employeeInterview.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


