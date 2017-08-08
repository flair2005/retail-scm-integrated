
package com.skynet.retailscm.payingoff;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;


public class PayingOffSerializer extends BaseJsonSerializer<PayingOff>{

	

	@Override
	public void serialize(PayingOff payingOff, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(payingOff,jgen,provider);
		
		jgen.writeStringField(PayingOff.ID_PROPERTY,payingOff.getId());
		jgen.writeStringField(PayingOff.WHO_PROPERTY,payingOff.getWho());
		writePaidFor(PayingOff.PAID_FOR_PROPERTY,payingOff,jgen,provider);
		jgen.writeObjectField(PayingOff.PAID_TIME_PROPERTY,payingOff.getPaidTime());
		jgen.writeNumberField(PayingOff.AMOUNT_PROPERTY,payingOff.getAmount());
		jgen.writeNumberField(PayingOff.VERSION_PROPERTY,payingOff.getVersion());
		writeEmployeeSalarySheetList(PayingOff.EMPLOYEE_SALARY_SHEET_LIST,payingOff,jgen,provider);
		
		writeEndObject(payingOff,jgen,provider);
	}
	
	protected void writePaidFor(String fieldName, PayingOff payingOff, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee paidFor = payingOff.getPaidFor();
		
		if(paidFor == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Employee.ID_PROPERTY,paidFor.getId()); 
		jgen.writeStringField(Employee.TITLE_PROPERTY,paidFor.getTitle()); 
		jgen.writeStringField(Employee.FAMILY_NAME_PROPERTY,paidFor.getFamilyName()); 
		jgen.writeStringField(Employee.GIVEN_NAME_PROPERTY,paidFor.getGivenName()); 
		jgen.writeStringField(Employee.EMAIL_PROPERTY,paidFor.getEmail()); 
		jgen.writeStringField(Employee.CITY_PROPERTY,paidFor.getCity()); 
		jgen.writeStringField(Employee.ADDRESS_PROPERTY,paidFor.getAddress()); 
		jgen.writeStringField(Employee.CELL_PHONE_PROPERTY,paidFor.getCellPhone()); 
		jgen.writeStringField(Employee.SALARY_ACCOUNT_PROPERTY,paidFor.getSalaryAccount()); 
		jgen.writeStringField(Employee.CURRENT_STATUS_PROPERTY,paidFor.getCurrentStatus()); 
		jgen.writeNumberField(Employee.VERSION_PROPERTY,paidFor.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeEmployeeSalarySheetList(String fieldName, PayingOff payingOff, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeSalarySheet> employeeSalarySheetList = payingOff.getEmployeeSalarySheetList();
		
		if(employeeSalarySheetList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeSalarySheetList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeSalarySheet employeeSalarySheet: employeeSalarySheetList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeSalarySheet.ID_PROPERTY,employeeSalarySheet.getId());
			jgen.writeNumberField(EmployeeSalarySheet.BASE_SALARY_PROPERTY,employeeSalarySheet.getBaseSalary());
			jgen.writeNumberField(EmployeeSalarySheet.BONUS_PROPERTY,employeeSalarySheet.getBonus());
			jgen.writeNumberField(EmployeeSalarySheet.REWARD_PROPERTY,employeeSalarySheet.getReward());
			jgen.writeNumberField(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY,employeeSalarySheet.getPersonalTax());
			jgen.writeNumberField(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY,employeeSalarySheet.getSocialSecurity());
			jgen.writeNumberField(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY,employeeSalarySheet.getHousingFound());
			jgen.writeNumberField(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY,employeeSalarySheet.getJobInsurance());
			jgen.writeStringField(EmployeeSalarySheet.CURRENT_STATUS_PROPERTY,employeeSalarySheet.getCurrentStatus());
			jgen.writeNumberField(EmployeeSalarySheet.VERSION_PROPERTY,employeeSalarySheet.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}








