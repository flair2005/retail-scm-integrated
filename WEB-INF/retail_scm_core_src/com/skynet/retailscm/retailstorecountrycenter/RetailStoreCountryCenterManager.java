
package com.skynet.retailscm.retailstorecountrycenter;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreCountryCenterManager{

	public RetailStoreCountryCenter createRetailStoreCountryCenter(RetailScmUserContext userContext, String name, String serviceNumber, Date founded, String webSite, String address, String operatedBy, String legalRepresentative, String description
) throws Exception;	
	public RetailStoreCountryCenter updateRetailStoreCountryCenter(RetailScmUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	


	public void delete(RetailScmUserContext userContext, String retailStoreCountryCenterId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreCountryCenter addReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String createdBy ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, String reportId, int reportVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, String reportId, int reportVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, String displayName ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, Date founded, double latitude, double longitude, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addPublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removePublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updatePublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreCountryCenter addCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


