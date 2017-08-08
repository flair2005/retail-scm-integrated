
package com.skynet.retailscm.retailstorecountrycenter;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.publicholiday.PublicHoliday;
import com.skynet.retailscm.occupationtype.OccupationType;
import com.skynet.retailscm.catalog.Catalog;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;
import com.skynet.retailscm.responsibilitytype.ResponsibilityType;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.report.Report;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;
import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.leavetype.LeaveType;


public class RetailStoreCountryCenterSerializer extends BaseJsonSerializer<RetailStoreCountryCenter>{

	

	@Override
	public void serialize(RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(retailStoreCountryCenter,jgen,provider);
		
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,retailStoreCountryCenter.getId());
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,retailStoreCountryCenter.getName());
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,retailStoreCountryCenter.getServiceNumber());
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,retailStoreCountryCenter.getFounded());
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,retailStoreCountryCenter.getWebSite());
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,retailStoreCountryCenter.getAddress());
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,retailStoreCountryCenter.getOperatedBy());
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,retailStoreCountryCenter.getLegalRepresentative());
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,retailStoreCountryCenter.getDescription());
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,retailStoreCountryCenter.getVersion());
		writeReportList(RetailStoreCountryCenter.REPORT_LIST,retailStoreCountryCenter,jgen,provider);
		writeCatalogList(RetailStoreCountryCenter.CATALOG_LIST,retailStoreCountryCenter,jgen,provider);
		writeRetailStoreProvinceCenterList(RetailStoreCountryCenter.RETAIL_STORE_PROVINCE_CENTER_LIST,retailStoreCountryCenter,jgen,provider);
		writeRetailStoreList(RetailStoreCountryCenter.RETAIL_STORE_LIST,retailStoreCountryCenter,jgen,provider);
		writeRetailStoreMemberList(RetailStoreCountryCenter.RETAIL_STORE_MEMBER_LIST,retailStoreCountryCenter,jgen,provider);
		writeGoodsSupplierList(RetailStoreCountryCenter.GOODS_SUPPLIER_LIST,retailStoreCountryCenter,jgen,provider);
		writeSupplyOrderList(RetailStoreCountryCenter.SUPPLY_ORDER_LIST,retailStoreCountryCenter,jgen,provider);
		writeRetailStoreOrderList(RetailStoreCountryCenter.RETAIL_STORE_ORDER_LIST,retailStoreCountryCenter,jgen,provider);
		writeWarehouseList(RetailStoreCountryCenter.WAREHOUSE_LIST,retailStoreCountryCenter,jgen,provider);
		writeTransportFleetList(RetailStoreCountryCenter.TRANSPORT_FLEET_LIST,retailStoreCountryCenter,jgen,provider);
		writeAccountSetList(RetailStoreCountryCenter.ACCOUNT_SET_LIST,retailStoreCountryCenter,jgen,provider);
		writeLevelOneDepartmentList(RetailStoreCountryCenter.LEVEL_ONE_DEPARTMENT_LIST,retailStoreCountryCenter,jgen,provider);
		writeSkillTypeList(RetailStoreCountryCenter.SKILL_TYPE_LIST,retailStoreCountryCenter,jgen,provider);
		writeResponsibilityTypeList(RetailStoreCountryCenter.RESPONSIBILITY_TYPE_LIST,retailStoreCountryCenter,jgen,provider);
		writeTerminationReasonList(RetailStoreCountryCenter.TERMINATION_REASON_LIST,retailStoreCountryCenter,jgen,provider);
		writeTerminationTypeList(RetailStoreCountryCenter.TERMINATION_TYPE_LIST,retailStoreCountryCenter,jgen,provider);
		writeOccupationTypeList(RetailStoreCountryCenter.OCCUPATION_TYPE_LIST,retailStoreCountryCenter,jgen,provider);
		writeLeaveTypeList(RetailStoreCountryCenter.LEAVE_TYPE_LIST,retailStoreCountryCenter,jgen,provider);
		writeSalaryGradeList(RetailStoreCountryCenter.SALARY_GRADE_LIST,retailStoreCountryCenter,jgen,provider);
		writeInterviewTypeList(RetailStoreCountryCenter.INTERVIEW_TYPE_LIST,retailStoreCountryCenter,jgen,provider);
		writeTrainingCourseTypeList(RetailStoreCountryCenter.TRAINING_COURSE_TYPE_LIST,retailStoreCountryCenter,jgen,provider);
		writePublicHolidayList(RetailStoreCountryCenter.PUBLIC_HOLIDAY_LIST,retailStoreCountryCenter,jgen,provider);
		writeEmployeeList(RetailStoreCountryCenter.EMPLOYEE_LIST,retailStoreCountryCenter,jgen,provider);
		writeInstructorList(RetailStoreCountryCenter.INSTRUCTOR_LIST,retailStoreCountryCenter,jgen,provider);
		writeCompanyTrainingList(RetailStoreCountryCenter.COMPANY_TRAINING_LIST,retailStoreCountryCenter,jgen,provider);
		
		writeEndObject(retailStoreCountryCenter,jgen,provider);
	}
	
	protected void writeReportList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Report> reportList = retailStoreCountryCenter.getReportList();
		
		if(reportList == null){
			return;//do nothing when null found for this field.
		}
		if(reportList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Report report: reportList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Report.ID_PROPERTY,report.getId());
			jgen.writeStringField(Report.NAME_PROPERTY,report.getName());
			jgen.writeStringField(Report.CREATED_BY_PROPERTY,report.getCreatedBy());
			jgen.writeNumberField(Report.VERSION_PROPERTY,report.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeCatalogList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
		
		if(catalogList == null){
			return;//do nothing when null found for this field.
		}
		if(catalogList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Catalog catalog: catalogList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Catalog.ID_PROPERTY,catalog.getId());
			jgen.writeStringField(Catalog.DISPLAY_NAME_PROPERTY,catalog.getDisplayName());
			jgen.writeNumberField(Catalog.VERSION_PROPERTY,catalog.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreProvinceCenterList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
		
		if(retailStoreProvinceCenterList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreProvinceCenterList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreProvinceCenter retailStoreProvinceCenter: retailStoreProvinceCenterList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreProvinceCenter.ID_PROPERTY,retailStoreProvinceCenter.getId());
			jgen.writeStringField(RetailStoreProvinceCenter.NAME_PROPERTY,retailStoreProvinceCenter.getName());
			jgen.writeObjectField(RetailStoreProvinceCenter.FOUNDED_PROPERTY,retailStoreProvinceCenter.getFounded());
			jgen.writeNumberField(RetailStoreProvinceCenter.VERSION_PROPERTY,retailStoreProvinceCenter.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		
		if(retailStoreList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStore retailStore: retailStoreList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStore.ID_PROPERTY,retailStore.getId());
			jgen.writeStringField(RetailStore.NAME_PROPERTY,retailStore.getName());
			jgen.writeStringField(RetailStore.TELEPHONE_PROPERTY,retailStore.getTelephone());
			jgen.writeStringField(RetailStore.OWNER_PROPERTY,retailStore.getOwner());
			jgen.writeObjectField(RetailStore.FOUNDED_PROPERTY,retailStore.getFounded());
			jgen.writeNumberField(RetailStore.LATITUDE_PROPERTY,retailStore.getLatitude());
			jgen.writeNumberField(RetailStore.LONGITUDE_PROPERTY,retailStore.getLongitude());
			jgen.writeStringField(RetailStore.DESCRIPTION_PROPERTY,retailStore.getDescription());
			jgen.writeStringField(RetailStore.CURRENT_STATUS_PROPERTY,retailStore.getCurrentStatus());
			jgen.writeNumberField(RetailStore.VERSION_PROPERTY,retailStore.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreMemberList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
		
		if(retailStoreMemberList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreMemberList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreMember retailStoreMember: retailStoreMemberList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreMember.ID_PROPERTY,retailStoreMember.getId());
			jgen.writeStringField(RetailStoreMember.NAME_PROPERTY,retailStoreMember.getName());
			jgen.writeStringField(RetailStoreMember.MOBILE_PHONE_PROPERTY,retailStoreMember.getMobilePhone());
			jgen.writeNumberField(RetailStoreMember.VERSION_PROPERTY,retailStoreMember.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeGoodsSupplierList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
		
		if(goodsSupplierList == null){
			return;//do nothing when null found for this field.
		}
		if(goodsSupplierList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(GoodsSupplier goodsSupplier: goodsSupplierList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(GoodsSupplier.ID_PROPERTY,goodsSupplier.getId());
			jgen.writeStringField(GoodsSupplier.NAME_PROPERTY,goodsSupplier.getName());
			jgen.writeStringField(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY,goodsSupplier.getSupplyProduct());
			jgen.writeStringField(GoodsSupplier.CONTACT_NUMBER_PROPERTY,goodsSupplier.getContactNumber());
			jgen.writeStringField(GoodsSupplier.DESCRIPTION_PROPERTY,goodsSupplier.getDescription());
			jgen.writeNumberField(GoodsSupplier.VERSION_PROPERTY,goodsSupplier.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSupplyOrderList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		
		if(supplyOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(supplyOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplyOrder supplyOrder: supplyOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplyOrder.ID_PROPERTY,supplyOrder.getId());
			jgen.writeStringField(SupplyOrder.TITLE_PROPERTY,supplyOrder.getTitle());
			jgen.writeNumberField(SupplyOrder.TOTAL_AMOUNT_PROPERTY,supplyOrder.getTotalAmount());
			jgen.writeStringField(SupplyOrder.CURRENT_STATUS_PROPERTY,supplyOrder.getCurrentStatus());
			jgen.writeNumberField(SupplyOrder.VERSION_PROPERTY,supplyOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeRetailStoreOrderList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		
		if(retailStoreOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(retailStoreOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(RetailStoreOrder retailStoreOrder: retailStoreOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(RetailStoreOrder.ID_PROPERTY,retailStoreOrder.getId());
			jgen.writeStringField(RetailStoreOrder.TITLE_PROPERTY,retailStoreOrder.getTitle());
			jgen.writeNumberField(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY,retailStoreOrder.getTotalAmount());
			jgen.writeStringField(RetailStoreOrder.CURRENT_STATUS_PROPERTY,retailStoreOrder.getCurrentStatus());
			jgen.writeNumberField(RetailStoreOrder.VERSION_PROPERTY,retailStoreOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeWarehouseList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
		
		if(warehouseList == null){
			return;//do nothing when null found for this field.
		}
		if(warehouseList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Warehouse warehouse: warehouseList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Warehouse.ID_PROPERTY,warehouse.getId());
			jgen.writeStringField(Warehouse.LOCATION_PROPERTY,warehouse.getLocation());
			jgen.writeStringField(Warehouse.CONTACT_NUMBER_PROPERTY,warehouse.getContactNumber());
			jgen.writeStringField(Warehouse.TOTAL_AREA_PROPERTY,warehouse.getTotalArea());
			jgen.writeNumberField(Warehouse.LATITUDE_PROPERTY,warehouse.getLatitude());
			jgen.writeNumberField(Warehouse.LONGITUDE_PROPERTY,warehouse.getLongitude());
			jgen.writeNumberField(Warehouse.VERSION_PROPERTY,warehouse.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeTransportFleetList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
		
		if(transportFleetList == null){
			return;//do nothing when null found for this field.
		}
		if(transportFleetList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TransportFleet transportFleet: transportFleetList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TransportFleet.ID_PROPERTY,transportFleet.getId());
			jgen.writeStringField(TransportFleet.NAME_PROPERTY,transportFleet.getName());
			jgen.writeStringField(TransportFleet.CONTACT_NUMBER_PROPERTY,transportFleet.getContactNumber());
			jgen.writeNumberField(TransportFleet.VERSION_PROPERTY,transportFleet.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeAccountSetList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		
		if(accountSetList == null){
			return;//do nothing when null found for this field.
		}
		if(accountSetList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountSet accountSet: accountSetList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountSet.ID_PROPERTY,accountSet.getId());
			jgen.writeStringField(AccountSet.NAME_PROPERTY,accountSet.getName());
			jgen.writeStringField(AccountSet.YEAR_SET_PROPERTY,accountSet.getYearSet());
			jgen.writeObjectField(AccountSet.EFFECTIVE_DATE_PROPERTY,accountSet.getEffectiveDate());
			jgen.writeStringField(AccountSet.ACCOUNTING_SYSTEM_PROPERTY,accountSet.getAccountingSystem());
			jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY,accountSet.getDomesticCurrencyCode());
			jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY,accountSet.getDomesticCurrencyName());
			jgen.writeStringField(AccountSet.OPENING_BANK_PROPERTY,accountSet.getOpeningBank());
			jgen.writeStringField(AccountSet.ACCOUNT_NUMBER_PROPERTY,accountSet.getAccountNumber());
			jgen.writeNumberField(AccountSet.VERSION_PROPERTY,accountSet.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeLevelOneDepartmentList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
		
		if(levelOneDepartmentList == null){
			return;//do nothing when null found for this field.
		}
		if(levelOneDepartmentList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LevelOneDepartment levelOneDepartment: levelOneDepartmentList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(LevelOneDepartment.ID_PROPERTY,levelOneDepartment.getId());
			jgen.writeStringField(LevelOneDepartment.NAME_PROPERTY,levelOneDepartment.getName());
			jgen.writeStringField(LevelOneDepartment.DESCRIPTION_PROPERTY,levelOneDepartment.getDescription());
			jgen.writeStringField(LevelOneDepartment.MANAGER_PROPERTY,levelOneDepartment.getManager());
			jgen.writeObjectField(LevelOneDepartment.FOUNDED_PROPERTY,levelOneDepartment.getFounded());
			jgen.writeNumberField(LevelOneDepartment.VERSION_PROPERTY,levelOneDepartment.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSkillTypeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
		
		if(skillTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(skillTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SkillType skillType: skillTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SkillType.ID_PROPERTY,skillType.getId());
			jgen.writeStringField(SkillType.CODE_PROPERTY,skillType.getCode());
			jgen.writeStringField(SkillType.DESCRIPTION_PROPERTY,skillType.getDescription());
			jgen.writeNumberField(SkillType.VERSION_PROPERTY,skillType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeResponsibilityTypeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
		
		if(responsibilityTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(responsibilityTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(ResponsibilityType responsibilityType: responsibilityTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(ResponsibilityType.ID_PROPERTY,responsibilityType.getId());
			jgen.writeStringField(ResponsibilityType.CODE_PROPERTY,responsibilityType.getCode());
			jgen.writeStringField(ResponsibilityType.BASE_DESCRIPTION_PROPERTY,responsibilityType.getBaseDescription());
			jgen.writeStringField(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY,responsibilityType.getDetailDescription());
			jgen.writeNumberField(ResponsibilityType.VERSION_PROPERTY,responsibilityType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeTerminationReasonList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
		
		if(terminationReasonList == null){
			return;//do nothing when null found for this field.
		}
		if(terminationReasonList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TerminationReason terminationReason: terminationReasonList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TerminationReason.ID_PROPERTY,terminationReason.getId());
			jgen.writeStringField(TerminationReason.CODE_PROPERTY,terminationReason.getCode());
			jgen.writeStringField(TerminationReason.DESCRIPTION_PROPERTY,terminationReason.getDescription());
			jgen.writeNumberField(TerminationReason.VERSION_PROPERTY,terminationReason.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeTerminationTypeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
		
		if(terminationTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(terminationTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TerminationType terminationType: terminationTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TerminationType.ID_PROPERTY,terminationType.getId());
			jgen.writeStringField(TerminationType.CODE_PROPERTY,terminationType.getCode());
			jgen.writeStringField(TerminationType.BASE_DESCRIPTION_PROPERTY,terminationType.getBaseDescription());
			jgen.writeStringField(TerminationType.DETAIL_DESCRIPTION_PROPERTY,terminationType.getDetailDescription());
			jgen.writeNumberField(TerminationType.VERSION_PROPERTY,terminationType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeOccupationTypeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
		
		if(occupationTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(occupationTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(OccupationType occupationType: occupationTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(OccupationType.ID_PROPERTY,occupationType.getId());
			jgen.writeStringField(OccupationType.CODE_PROPERTY,occupationType.getCode());
			jgen.writeStringField(OccupationType.DESCRIPTION_PROPERTY,occupationType.getDescription());
			jgen.writeStringField(OccupationType.DETAIL_DESCRIPTION_PROPERTY,occupationType.getDetailDescription());
			jgen.writeNumberField(OccupationType.VERSION_PROPERTY,occupationType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeLeaveTypeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
		
		if(leaveTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(leaveTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(LeaveType leaveType: leaveTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(LeaveType.ID_PROPERTY,leaveType.getId());
			jgen.writeStringField(LeaveType.CODE_PROPERTY,leaveType.getCode());
			jgen.writeStringField(LeaveType.DESCRIPTION_PROPERTY,leaveType.getDescription());
			jgen.writeStringField(LeaveType.DETAIL_DESCRIPTION_PROPERTY,leaveType.getDetailDescription());
			jgen.writeNumberField(LeaveType.VERSION_PROPERTY,leaveType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSalaryGradeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
		
		if(salaryGradeList == null){
			return;//do nothing when null found for this field.
		}
		if(salaryGradeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SalaryGrade salaryGrade: salaryGradeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SalaryGrade.ID_PROPERTY,salaryGrade.getId());
			jgen.writeStringField(SalaryGrade.CODE_PROPERTY,salaryGrade.getCode());
			jgen.writeStringField(SalaryGrade.NAME_PROPERTY,salaryGrade.getName());
			jgen.writeStringField(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY,salaryGrade.getDetailDescription());
			jgen.writeNumberField(SalaryGrade.VERSION_PROPERTY,salaryGrade.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeInterviewTypeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
		
		if(interviewTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(interviewTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(InterviewType interviewType: interviewTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(InterviewType.ID_PROPERTY,interviewType.getId());
			jgen.writeStringField(InterviewType.CODE_PROPERTY,interviewType.getCode());
			jgen.writeStringField(InterviewType.DESCRIPTION_PROPERTY,interviewType.getDescription());
			jgen.writeStringField(InterviewType.DETAIL_DESCRIPTION_PROPERTY,interviewType.getDetailDescription());
			jgen.writeNumberField(InterviewType.VERSION_PROPERTY,interviewType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeTrainingCourseTypeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
		
		if(trainingCourseTypeList == null){
			return;//do nothing when null found for this field.
		}
		if(trainingCourseTypeList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(TrainingCourseType trainingCourseType: trainingCourseTypeList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(TrainingCourseType.ID_PROPERTY,trainingCourseType.getId());
			jgen.writeStringField(TrainingCourseType.CODE_PROPERTY,trainingCourseType.getCode());
			jgen.writeStringField(TrainingCourseType.NAME_PROPERTY,trainingCourseType.getName());
			jgen.writeStringField(TrainingCourseType.DESCRIPTION_PROPERTY,trainingCourseType.getDescription());
			jgen.writeNumberField(TrainingCourseType.VERSION_PROPERTY,trainingCourseType.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writePublicHolidayList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
		
		if(publicHolidayList == null){
			return;//do nothing when null found for this field.
		}
		if(publicHolidayList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(PublicHoliday publicHoliday: publicHolidayList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(PublicHoliday.ID_PROPERTY,publicHoliday.getId());
			jgen.writeStringField(PublicHoliday.CODE_PROPERTY,publicHoliday.getCode());
			jgen.writeStringField(PublicHoliday.NAME_PROPERTY,publicHoliday.getName());
			jgen.writeStringField(PublicHoliday.DESCRIPTION_PROPERTY,publicHoliday.getDescription());
			jgen.writeNumberField(PublicHoliday.VERSION_PROPERTY,publicHoliday.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeEmployeeList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		
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
	protected void writeInstructorList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
		
		if(instructorList == null){
			return;//do nothing when null found for this field.
		}
		if(instructorList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(Instructor instructor: instructorList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(Instructor.ID_PROPERTY,instructor.getId());
			jgen.writeStringField(Instructor.TITLE_PROPERTY,instructor.getTitle());
			jgen.writeStringField(Instructor.FAMILY_NAME_PROPERTY,instructor.getFamilyName());
			jgen.writeStringField(Instructor.GIVEN_NAME_PROPERTY,instructor.getGivenName());
			jgen.writeStringField(Instructor.CELL_PHONE_PROPERTY,instructor.getCellPhone());
			jgen.writeStringField(Instructor.EMAIL_PROPERTY,instructor.getEmail());
			jgen.writeStringField(Instructor.INTRODUCTION_PROPERTY,instructor.getIntroduction());
			jgen.writeNumberField(Instructor.VERSION_PROPERTY,instructor.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeCompanyTrainingList(String fieldName, RetailStoreCountryCenter retailStoreCountryCenter, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		
		if(companyTrainingList == null){
			return;//do nothing when null found for this field.
		}
		if(companyTrainingList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(CompanyTraining companyTraining: companyTrainingList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(CompanyTraining.ID_PROPERTY,companyTraining.getId());
			jgen.writeStringField(CompanyTraining.TITLE_PROPERTY,companyTraining.getTitle());
			jgen.writeObjectField(CompanyTraining.TIME_START_PROPERTY,companyTraining.getTimeStart());
			jgen.writeNumberField(CompanyTraining.DURATION_HOURS_PROPERTY,companyTraining.getDurationHours());
			jgen.writeNumberField(CompanyTraining.VERSION_PROPERTY,companyTraining.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


