
package com.skynet.retailscm.leavetype;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.leavetype.LeaveType;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeleave.EmployeeLeave;


public class LeaveTypeSerializer extends BaseJsonSerializer<LeaveType>{

	

	@Override
	public void serialize(LeaveType leaveType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(leaveType,jgen,provider);
		
		jgen.writeStringField(LeaveType.ID_PROPERTY,leaveType.getId());
		jgen.writeStringField(LeaveType.CODE_PROPERTY,leaveType.getCode());
		writeCompany(LeaveType.COMPANY_PROPERTY,leaveType,jgen,provider);
		jgen.writeStringField(LeaveType.DESCRIPTION_PROPERTY,leaveType.getDescription());
		jgen.writeStringField(LeaveType.DETAIL_DESCRIPTION_PROPERTY,leaveType.getDetailDescription());
		jgen.writeNumberField(LeaveType.VERSION_PROPERTY,leaveType.getVersion());
		writeEmployeeLeaveList(LeaveType.EMPLOYEE_LEAVE_LIST,leaveType,jgen,provider);
		
		writeEndObject(leaveType,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, LeaveType leaveType, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = leaveType.getCompany();
		
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
	
	protected void writeEmployeeLeaveList(String fieldName, LeaveType leaveType, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeLeave> employeeLeaveList = leaveType.getEmployeeLeaveList();
		
		if(employeeLeaveList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeLeaveList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeLeave employeeLeave: employeeLeaveList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeLeave.ID_PROPERTY,employeeLeave.getId());
			jgen.writeNumberField(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY,employeeLeave.getLeaveDurationHour());
			jgen.writeStringField(EmployeeLeave.REMARK_PROPERTY,employeeLeave.getRemark());
			jgen.writeNumberField(EmployeeLeave.VERSION_PROPERTY,employeeLeave.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


