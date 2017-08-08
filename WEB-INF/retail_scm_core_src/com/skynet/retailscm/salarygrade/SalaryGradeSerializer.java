
package com.skynet.retailscm.salarygrade;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;


public class SalaryGradeSerializer extends BaseJsonSerializer<SalaryGrade>{

	

	@Override
	public void serialize(SalaryGrade salaryGrade, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(salaryGrade,jgen,provider);
		
		jgen.writeStringField(SalaryGrade.ID_PROPERTY,salaryGrade.getId());
		jgen.writeStringField(SalaryGrade.CODE_PROPERTY,salaryGrade.getCode());
		writeCompany(SalaryGrade.COMPANY_PROPERTY,salaryGrade,jgen,provider);
		jgen.writeStringField(SalaryGrade.NAME_PROPERTY,salaryGrade.getName());
		jgen.writeStringField(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY,salaryGrade.getDetailDescription());
		jgen.writeNumberField(SalaryGrade.VERSION_PROPERTY,salaryGrade.getVersion());
		writeEmployeeList(SalaryGrade.EMPLOYEE_LIST,salaryGrade,jgen,provider);
		writeEmployeeSalarySheetList(SalaryGrade.EMPLOYEE_SALARY_SHEET_LIST,salaryGrade,jgen,provider);
		
		writeEndObject(salaryGrade,jgen,provider);
	}
	
	protected void writeCompany(String fieldName, SalaryGrade salaryGrade, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter company = salaryGrade.getCompany();
		
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
	
	protected void writeEmployeeList(String fieldName, SalaryGrade salaryGrade, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = salaryGrade.getEmployeeList();
		
		if(employeeList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Employee employee: employeeList){
				
			jgen.writeStartObject();// {
		
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

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeSalarySheetList(String fieldName, SalaryGrade salaryGrade, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeSalarySheet> employeeSalarySheetList = salaryGrade.getEmployeeSalarySheetList();
		
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


