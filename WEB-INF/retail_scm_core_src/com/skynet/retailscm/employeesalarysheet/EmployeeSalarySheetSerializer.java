
package com.skynet.retailscm.employeesalarysheet;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.salarygrade.SalaryGrade;


public class EmployeeSalarySheetSerializer extends BaseJsonSerializer<EmployeeSalarySheet>{

	

	@Override
	public void serialize(EmployeeSalarySheet employeeSalarySheet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(employeeSalarySheet,jgen,provider);
		
		jgen.writeStringField(EmployeeSalarySheet.ID_PROPERTY,employeeSalarySheet.getId());
		writeEmployee(EmployeeSalarySheet.EMPLOYEE_PROPERTY,employeeSalarySheet,jgen,provider);
		writeCurrentSalaryGrade(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY,employeeSalarySheet,jgen,provider);
		jgen.writeNumberField(EmployeeSalarySheet.BASE_SALARY_PROPERTY,employeeSalarySheet.getBaseSalary());
		jgen.writeNumberField(EmployeeSalarySheet.BONUS_PROPERTY,employeeSalarySheet.getBonus());
		jgen.writeNumberField(EmployeeSalarySheet.REWARD_PROPERTY,employeeSalarySheet.getReward());
		jgen.writeNumberField(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY,employeeSalarySheet.getPersonalTax());
		jgen.writeNumberField(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY,employeeSalarySheet.getSocialSecurity());
		jgen.writeNumberField(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY,employeeSalarySheet.getHousingFound());
		jgen.writeNumberField(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY,employeeSalarySheet.getJobInsurance());
		writePayingOff(EmployeeSalarySheet.PAYING_OFF_PROPERTY,employeeSalarySheet,jgen,provider);
		jgen.writeStringField(EmployeeSalarySheet.CURRENT_STATUS_PROPERTY,employeeSalarySheet.getCurrentStatus());
		jgen.writeNumberField(EmployeeSalarySheet.VERSION_PROPERTY,employeeSalarySheet.getVersion());
		
		writeEndObject(employeeSalarySheet,jgen,provider);
	}
	
	protected void writeEmployee(String fieldName, EmployeeSalarySheet employeeSalarySheet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Employee employee = employeeSalarySheet.getEmployee();
		
		if(employee == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Employee.ID_PROPERTY,employee.getId()); 
		jgen.writeStringField(Employee.TITLE_PROPERTY,employee.getTitle()); 
		jgen.writeStringField(Employee.FAMILY_NAME_PROPERTY,employee.getFamilyName()); 
		jgen.writeStringField(Employee.GIVEN_NAME_PROPERTY,employee.getGivenName()); 
		jgen.writeStringField(Employee.EMAIL_PROPERTY,employee.getEmail()); 
		jgen.writeStringField(Employee.CITY_PROPERTY,employee.getCity()); 
		jgen.writeStringField(Employee.ADDRESS_PROPERTY,employee.getAddress()); 
		jgen.writeStringField(Employee.CELL_PHONE_PROPERTY,employee.getCellPhone()); 
		jgen.writeStringField(Employee.SALARY_ACCOUNT_PROPERTY,employee.getSalaryAccount()); 
		jgen.writeStringField(Employee.CURRENT_STATUS_PROPERTY,employee.getCurrentStatus()); 
		jgen.writeNumberField(Employee.VERSION_PROPERTY,employee.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeCurrentSalaryGrade(String fieldName, EmployeeSalarySheet employeeSalarySheet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		SalaryGrade currentSalaryGrade = employeeSalarySheet.getCurrentSalaryGrade();
		
		if(currentSalaryGrade == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(SalaryGrade.ID_PROPERTY,currentSalaryGrade.getId()); 
		jgen.writeStringField(SalaryGrade.CODE_PROPERTY,currentSalaryGrade.getCode()); 
		jgen.writeStringField(SalaryGrade.NAME_PROPERTY,currentSalaryGrade.getName()); 
		jgen.writeStringField(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY,currentSalaryGrade.getDetailDescription()); 
		jgen.writeNumberField(SalaryGrade.VERSION_PROPERTY,currentSalaryGrade.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writePayingOff(String fieldName, EmployeeSalarySheet employeeSalarySheet, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		PayingOff payingOff = employeeSalarySheet.getPayingOff();
		
		if(payingOff == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(PayingOff.ID_PROPERTY,payingOff.getId()); 
		jgen.writeStringField(PayingOff.WHO_PROPERTY,payingOff.getWho()); 
		jgen.writeObjectField(PayingOff.PAID_TIME_PROPERTY,payingOff.getPaidTime()); 
		jgen.writeNumberField(PayingOff.AMOUNT_PROPERTY,payingOff.getAmount()); 
		jgen.writeNumberField(PayingOff.VERSION_PROPERTY,payingOff.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


