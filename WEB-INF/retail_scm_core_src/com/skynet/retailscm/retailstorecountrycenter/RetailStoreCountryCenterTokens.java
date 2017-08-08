
package com.skynet.retailscm.retailstorecountrycenter;
import com.skynet.retailscm.CommonTokens;
import java.util.Map;
public class RetailStoreCountryCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreCountryCenter";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected RetailStoreCountryCenterTokens(){
		//ensure not initialized outside the class
	}
	
	public RetailStoreCountryCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RetailStoreCountryCenterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RetailStoreCountryCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RetailStoreCountryCenterTokens start(){
		return new RetailStoreCountryCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RetailStoreCountryCenterTokens allTokens(){
		
		return start()
			.withReportList()
			.withCatalogList()
			.withRetailStoreProvinceCenterList()
			.withRetailStoreList()
			.withRetailStoreMemberList()
			.withGoodsSupplierList()
			.withSupplyOrderList()
			.withRetailStoreOrderList()
			.withWarehouseList()
			.withTransportFleetList()
			.withAccountSetList()
			.withLevelOneDepartmentList()
			.withSkillTypeList()
			.withResponsibilityTypeList()
			.withTerminationReasonList()
			.withTerminationTypeList()
			.withOccupationTypeList()
			.withLeaveTypeList()
			.withSalaryGradeList()
			.withInterviewTypeList()
			.withTrainingCourseTypeList()
			.withPublicHolidayList()
			.withEmployeeList()
			.withInstructorList()
			.withCompanyTrainingList();
	
	}
	protected static RetailStoreCountryCenterTokens withoutListsTokens(){
		
		return start();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String REPORT_LIST = "reportList";
	public String getReportList(){
		return REPORT_LIST;
	}
	public RetailStoreCountryCenterTokens withReportList(){		
		addSimpleOptions(REPORT_LIST);
		return this;
	}	
		
	protected static final String CATALOG_LIST = "catalogList";
	public String getCatalogList(){
		return CATALOG_LIST;
	}
	public RetailStoreCountryCenterTokens withCatalogList(){		
		addSimpleOptions(CATALOG_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_PROVINCE_CENTER_LIST = "retailStoreProvinceCenterList";
	public String getRetailStoreProvinceCenterList(){
		return RETAIL_STORE_PROVINCE_CENTER_LIST;
	}
	public RetailStoreCountryCenterTokens withRetailStoreProvinceCenterList(){		
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_LIST = "retailStoreList";
	public String getRetailStoreList(){
		return RETAIL_STORE_LIST;
	}
	public RetailStoreCountryCenterTokens withRetailStoreList(){		
		addSimpleOptions(RETAIL_STORE_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_MEMBER_LIST = "retailStoreMemberList";
	public String getRetailStoreMemberList(){
		return RETAIL_STORE_MEMBER_LIST;
	}
	public RetailStoreCountryCenterTokens withRetailStoreMemberList(){		
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST);
		return this;
	}	
		
	protected static final String GOODS_SUPPLIER_LIST = "goodsSupplierList";
	public String getGoodsSupplierList(){
		return GOODS_SUPPLIER_LIST;
	}
	public RetailStoreCountryCenterTokens withGoodsSupplierList(){		
		addSimpleOptions(GOODS_SUPPLIER_LIST);
		return this;
	}	
		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}
	public RetailStoreCountryCenterTokens withSupplyOrderList(){		
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}	
		
	protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	public String getRetailStoreOrderList(){
		return RETAIL_STORE_ORDER_LIST;
	}
	public RetailStoreCountryCenterTokens withRetailStoreOrderList(){		
		addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return this;
	}	
		
	protected static final String WAREHOUSE_LIST = "warehouseList";
	public String getWarehouseList(){
		return WAREHOUSE_LIST;
	}
	public RetailStoreCountryCenterTokens withWarehouseList(){		
		addSimpleOptions(WAREHOUSE_LIST);
		return this;
	}	
		
	protected static final String TRANSPORT_FLEET_LIST = "transportFleetList";
	public String getTransportFleetList(){
		return TRANSPORT_FLEET_LIST;
	}
	public RetailStoreCountryCenterTokens withTransportFleetList(){		
		addSimpleOptions(TRANSPORT_FLEET_LIST);
		return this;
	}	
		
	protected static final String ACCOUNT_SET_LIST = "accountSetList";
	public String getAccountSetList(){
		return ACCOUNT_SET_LIST;
	}
	public RetailStoreCountryCenterTokens withAccountSetList(){		
		addSimpleOptions(ACCOUNT_SET_LIST);
		return this;
	}	
		
	protected static final String LEVEL_ONE_DEPARTMENT_LIST = "levelOneDepartmentList";
	public String getLevelOneDepartmentList(){
		return LEVEL_ONE_DEPARTMENT_LIST;
	}
	public RetailStoreCountryCenterTokens withLevelOneDepartmentList(){		
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST);
		return this;
	}	
		
	protected static final String SKILL_TYPE_LIST = "skillTypeList";
	public String getSkillTypeList(){
		return SKILL_TYPE_LIST;
	}
	public RetailStoreCountryCenterTokens withSkillTypeList(){		
		addSimpleOptions(SKILL_TYPE_LIST);
		return this;
	}	
		
	protected static final String RESPONSIBILITY_TYPE_LIST = "responsibilityTypeList";
	public String getResponsibilityTypeList(){
		return RESPONSIBILITY_TYPE_LIST;
	}
	public RetailStoreCountryCenterTokens withResponsibilityTypeList(){		
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST);
		return this;
	}	
		
	protected static final String TERMINATION_REASON_LIST = "terminationReasonList";
	public String getTerminationReasonList(){
		return TERMINATION_REASON_LIST;
	}
	public RetailStoreCountryCenterTokens withTerminationReasonList(){		
		addSimpleOptions(TERMINATION_REASON_LIST);
		return this;
	}	
		
	protected static final String TERMINATION_TYPE_LIST = "terminationTypeList";
	public String getTerminationTypeList(){
		return TERMINATION_TYPE_LIST;
	}
	public RetailStoreCountryCenterTokens withTerminationTypeList(){		
		addSimpleOptions(TERMINATION_TYPE_LIST);
		return this;
	}	
		
	protected static final String OCCUPATION_TYPE_LIST = "occupationTypeList";
	public String getOccupationTypeList(){
		return OCCUPATION_TYPE_LIST;
	}
	public RetailStoreCountryCenterTokens withOccupationTypeList(){		
		addSimpleOptions(OCCUPATION_TYPE_LIST);
		return this;
	}	
		
	protected static final String LEAVE_TYPE_LIST = "leaveTypeList";
	public String getLeaveTypeList(){
		return LEAVE_TYPE_LIST;
	}
	public RetailStoreCountryCenterTokens withLeaveTypeList(){		
		addSimpleOptions(LEAVE_TYPE_LIST);
		return this;
	}	
		
	protected static final String SALARY_GRADE_LIST = "salaryGradeList";
	public String getSalaryGradeList(){
		return SALARY_GRADE_LIST;
	}
	public RetailStoreCountryCenterTokens withSalaryGradeList(){		
		addSimpleOptions(SALARY_GRADE_LIST);
		return this;
	}	
		
	protected static final String INTERVIEW_TYPE_LIST = "interviewTypeList";
	public String getInterviewTypeList(){
		return INTERVIEW_TYPE_LIST;
	}
	public RetailStoreCountryCenterTokens withInterviewTypeList(){		
		addSimpleOptions(INTERVIEW_TYPE_LIST);
		return this;
	}	
		
	protected static final String TRAINING_COURSE_TYPE_LIST = "trainingCourseTypeList";
	public String getTrainingCourseTypeList(){
		return TRAINING_COURSE_TYPE_LIST;
	}
	public RetailStoreCountryCenterTokens withTrainingCourseTypeList(){		
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST);
		return this;
	}	
		
	protected static final String PUBLIC_HOLIDAY_LIST = "publicHolidayList";
	public String getPublicHolidayList(){
		return PUBLIC_HOLIDAY_LIST;
	}
	public RetailStoreCountryCenterTokens withPublicHolidayList(){		
		addSimpleOptions(PUBLIC_HOLIDAY_LIST);
		return this;
	}	
		
	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}
	public RetailStoreCountryCenterTokens withEmployeeList(){		
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}	
		
	protected static final String INSTRUCTOR_LIST = "instructorList";
	public String getInstructorList(){
		return INSTRUCTOR_LIST;
	}
	public RetailStoreCountryCenterTokens withInstructorList(){		
		addSimpleOptions(INSTRUCTOR_LIST);
		return this;
	}	
		
	protected static final String COMPANY_TRAINING_LIST = "companyTrainingList";
	public String getCompanyTrainingList(){
		return COMPANY_TRAINING_LIST;
	}
	public RetailStoreCountryCenterTokens withCompanyTrainingList(){		
		addSimpleOptions(COMPANY_TRAINING_LIST);
		return this;
	}	
		
}

