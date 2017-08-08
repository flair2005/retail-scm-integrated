
package com.skynet.retailscm.retailstorecountrycenter;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.RetailScmUserContext;
//import com.skynet.retailscm.BaseManagerImpl;
import com.skynet.retailscm.RetailScmCheckerManager;

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


import com.skynet.retailscm.termination.Termination;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.offeracceptance.OfferAcceptance;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.employeeboarding.EmployeeBoarding;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.occupationtype.OccupationType;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosing;
import com.skynet.retailscm.responsibilitytype.ResponsibilityType;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.professioninterview.ProfessionInterview;
import com.skynet.retailscm.offerapproval.OfferApproval;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreation;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.hrinterview.HrInterview;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.jobapplication.JobApplication;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;


import com.skynet.retailscm.retailstore.RetailStoreTable;
import com.skynet.retailscm.skilltype.SkillTypeTable;
import com.skynet.retailscm.terminationtype.TerminationTypeTable;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;
import com.skynet.retailscm.warehouse.WarehouseTable;
import com.skynet.retailscm.terminationreason.TerminationReasonTable;
import com.skynet.retailscm.leavetype.LeaveTypeTable;
import com.skynet.retailscm.transportfleet.TransportFleetTable;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderTable;
import com.skynet.retailscm.supplyorder.SupplyOrderTable;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartmentTable;
import com.skynet.retailscm.report.ReportTable;
import com.skynet.retailscm.instructor.InstructorTable;
import com.skynet.retailscm.catalog.CatalogTable;
import com.skynet.retailscm.salarygrade.SalaryGradeTable;
import com.skynet.retailscm.companytraining.CompanyTrainingTable;
import com.skynet.retailscm.goodssupplier.GoodsSupplierTable;
import com.skynet.retailscm.publicholiday.PublicHolidayTable;
import com.skynet.retailscm.occupationtype.OccupationTypeTable;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;
import com.skynet.retailscm.responsibilitytype.ResponsibilityTypeTable;
import com.skynet.retailscm.employee.EmployeeTable;
import com.skynet.retailscm.interviewtype.InterviewTypeTable;
import com.skynet.retailscm.accountset.AccountSetTable;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseTypeTable;




public class RetailStoreCountryCenterManagerImpl extends RetailScmCheckerManager implements RetailStoreCountryCenterManager {
	
	private static final String SERVICE_TYPE = "RetailStoreCountryCenter";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO){
 	
 		if(retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
 		}
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
 		if(this.retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("The RetailStoreCountryCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCountryCenterDAO;
 	}
 	
 	protected RetailStoreCountryCenter saveRetailStoreCountryCenter(RetailScmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreCountryCenterDAO().save(retailStoreCountryCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens);
 	}
 	
 	protected RetailStoreCountryCenter saveRetailStoreCountryCenterDetail(RetailScmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter) throws Exception{	

 		
 		return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, allTokens());
 	}
 	
 	public RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String [] tokensExpr) throws Exception{				
 
 		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter( userContext, retailStoreCountryCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCountryCenter, tokens);
 	}
 	
 	protected RetailStoreCountryCenter present(RetailScmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreCountryCenter,tokens);
		
		
		return this.getRetailStoreCountryCenterDAO().present(retailStoreCountryCenter, tokens);
	}
 
 	
 	
 	public RetailStoreCountryCenter loadRetailStoreCountryCenterDetail(RetailScmUserContext userContext, String retailStoreCountryCenterId) throws Exception{	
 		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter( userContext, retailStoreCountryCenterId, allTokens());

 		return present(userContext,retailStoreCountryCenter, allTokens());
		
 	}
 	
 	public Object view(RetailScmUserContext userContext, String retailStoreCountryCenterId) throws Exception{	
 		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		
		throwExceptionIfHasErrors(userContext, exception);

 		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter( userContext, retailStoreCountryCenterId, allTokens());

 		return present(userContext,retailStoreCountryCenter, allTokens());
		
 	}
 	protected RetailStoreCountryCenter saveRetailStoreCountryCenter(RetailScmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreCountryCenterDAO().save(retailStoreCountryCenter, tokens);
 	}
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, Map<String,Object>tokens) throws Exception{	
 		return getRetailStoreCountryCenterDAO().load(retailStoreCountryCenterId, tokens);
 	}

	



 	
 	
 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreCountryCenter, tokens);
		
		addAction(userContext, retailStoreCountryCenter, tokens,"@create","createRetailStoreCountryCenter","createRetailStoreCountryCenter/","main","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"@update","updateRetailStoreCountryCenter","updateRetailStoreCountryCenter/"+retailStoreCountryCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"@copy","cloneRetailStoreCountryCenter","cloneRetailStoreCountryCenter/"+retailStoreCountryCenter.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addReport","addReport","addReport/"+retailStoreCountryCenter.getId()+"/","reportList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeReport","removeReport","removeReport/"+retailStoreCountryCenter.getId()+"/","reportList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateReport","updateReport","updateReport/"+retailStoreCountryCenter.getId()+"/","reportList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyReportFrom","copyReportFrom","copyReportFrom/"+retailStoreCountryCenter.getId()+"/","reportList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addCatalog","addCatalog","addCatalog/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeCatalog","removeCatalog","removeCatalog/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateCatalog","updateCatalog","updateCatalog/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyCatalogFrom","copyCatalogFrom","copyCatalogFrom/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStoreProvinceCenter","addRetailStoreProvinceCenter","addRetailStoreProvinceCenter/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStoreProvinceCenter","removeRetailStoreProvinceCenter","removeRetailStoreProvinceCenter/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStoreProvinceCenter","updateRetailStoreProvinceCenter","updateRetailStoreProvinceCenter/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreProvinceCenterFrom","copyRetailStoreProvinceCenterFrom","copyRetailStoreProvinceCenterFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStore","addRetailStore","addRetailStore/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStoreMember","addRetailStoreMember","addRetailStoreMember/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStoreMember","removeRetailStoreMember","removeRetailStoreMember/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStoreMember","updateRetailStoreMember","updateRetailStoreMember/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreMemberFrom","copyRetailStoreMemberFrom","copyRetailStoreMemberFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addGoodsSupplier","addGoodsSupplier","addGoodsSupplier/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeGoodsSupplier","removeGoodsSupplier","removeGoodsSupplier/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateGoodsSupplier","updateGoodsSupplier","updateGoodsSupplier/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyGoodsSupplierFrom","copyGoodsSupplierFrom","copyGoodsSupplierFrom/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addWarehouse","addWarehouse","addWarehouse/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeWarehouse","removeWarehouse","removeWarehouse/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateWarehouse","updateWarehouse","updateWarehouse/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyWarehouseFrom","copyWarehouseFrom","copyWarehouseFrom/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTransportFleet","addTransportFleet","addTransportFleet/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTransportFleet","removeTransportFleet","removeTransportFleet/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTransportFleet","updateTransportFleet","updateTransportFleet/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTransportFleetFrom","copyTransportFleetFrom","copyTransportFleetFrom/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addAccountSet","addAccountSet","addAccountSet/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeAccountSet","removeAccountSet","removeAccountSet/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateAccountSet","updateAccountSet","updateAccountSet/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addLevelOneDepartment","addLevelOneDepartment","addLevelOneDepartment/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeLevelOneDepartment","removeLevelOneDepartment","removeLevelOneDepartment/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateLevelOneDepartment","updateLevelOneDepartment","updateLevelOneDepartment/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyLevelOneDepartmentFrom","copyLevelOneDepartmentFrom","copyLevelOneDepartmentFrom/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addSkillType","addSkillType","addSkillType/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeSkillType","removeSkillType","removeSkillType/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateSkillType","updateSkillType","updateSkillType/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copySkillTypeFrom","copySkillTypeFrom","copySkillTypeFrom/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addResponsibilityType","addResponsibilityType","addResponsibilityType/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeResponsibilityType","removeResponsibilityType","removeResponsibilityType/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateResponsibilityType","updateResponsibilityType","updateResponsibilityType/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyResponsibilityTypeFrom","copyResponsibilityTypeFrom","copyResponsibilityTypeFrom/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTerminationReason","addTerminationReason","addTerminationReason/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTerminationReason","removeTerminationReason","removeTerminationReason/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTerminationReason","updateTerminationReason","updateTerminationReason/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTerminationReasonFrom","copyTerminationReasonFrom","copyTerminationReasonFrom/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTerminationType","addTerminationType","addTerminationType/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTerminationType","removeTerminationType","removeTerminationType/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTerminationType","updateTerminationType","updateTerminationType/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTerminationTypeFrom","copyTerminationTypeFrom","copyTerminationTypeFrom/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addOccupationType","addOccupationType","addOccupationType/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeOccupationType","removeOccupationType","removeOccupationType/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateOccupationType","updateOccupationType","updateOccupationType/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyOccupationTypeFrom","copyOccupationTypeFrom","copyOccupationTypeFrom/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addLeaveType","addLeaveType","addLeaveType/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeLeaveType","removeLeaveType","removeLeaveType/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateLeaveType","updateLeaveType","updateLeaveType/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyLeaveTypeFrom","copyLeaveTypeFrom","copyLeaveTypeFrom/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addSalaryGrade","addSalaryGrade","addSalaryGrade/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeSalaryGrade","removeSalaryGrade","removeSalaryGrade/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateSalaryGrade","updateSalaryGrade","updateSalaryGrade/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copySalaryGradeFrom","copySalaryGradeFrom","copySalaryGradeFrom/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addInterviewType","addInterviewType","addInterviewType/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeInterviewType","removeInterviewType","removeInterviewType/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateInterviewType","updateInterviewType","updateInterviewType/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyInterviewTypeFrom","copyInterviewTypeFrom","copyInterviewTypeFrom/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTrainingCourseType","addTrainingCourseType","addTrainingCourseType/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTrainingCourseType","removeTrainingCourseType","removeTrainingCourseType/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTrainingCourseType","updateTrainingCourseType","updateTrainingCourseType/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTrainingCourseTypeFrom","copyTrainingCourseTypeFrom","copyTrainingCourseTypeFrom/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addPublicHoliday","addPublicHoliday","addPublicHoliday/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removePublicHoliday","removePublicHoliday","removePublicHoliday/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updatePublicHoliday","updatePublicHoliday","updatePublicHoliday/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyPublicHolidayFrom","copyPublicHolidayFrom","copyPublicHolidayFrom/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addEmployee","addEmployee","addEmployee/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeEmployee","removeEmployee","removeEmployee/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateEmployee","updateEmployee","updateEmployee/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addInstructor","addInstructor","addInstructor/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeInstructor","removeInstructor","removeInstructor/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateInstructor","updateInstructor","updateInstructor/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyInstructorFrom","copyInstructorFrom","copyInstructorFrom/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addCompanyTraining","addCompanyTraining","addCompanyTraining/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeCompanyTraining","removeCompanyTraining","removeCompanyTraining/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateCompanyTraining","updateCompanyTraining","updateCompanyTraining/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyCompanyTrainingFrom","copyCompanyTrainingFrom","copyCompanyTrainingFrom/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailScmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public RetailStoreCountryCenter createRetailStoreCountryCenter(RetailScmUserContext userContext,String name, String serviceNumber, Date founded, String webSite, String address, String operatedBy, String legalRepresentative, String description
) throws Exception
	{
		
		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");

		

		checkNameOfRetailStoreCountryCenter(userContext,  name, exception);
		checkServiceNumberOfRetailStoreCountryCenter(userContext,  serviceNumber, exception);
		checkFoundedOfRetailStoreCountryCenter(userContext,  founded, exception);
		checkWebSiteOfRetailStoreCountryCenter(userContext,  webSite, exception);
		checkAddressOfRetailStoreCountryCenter(userContext,  address, exception);
		checkOperatedByOfRetailStoreCountryCenter(userContext,  operatedBy, exception);
		checkLegalRepresentativeOfRetailStoreCountryCenter(userContext,  legalRepresentative, exception);
		checkDescriptionOfRetailStoreCountryCenter(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);


		RetailStoreCountryCenter retailStoreCountryCenter=createNewRetailStoreCountryCenter();	

		retailStoreCountryCenter.setName(name);
		retailStoreCountryCenter.setServiceNumber(serviceNumber);
		retailStoreCountryCenter.setFounded(founded);
		retailStoreCountryCenter.setWebSite(webSite);
		retailStoreCountryCenter.setAddress(address);
		retailStoreCountryCenter.setOperatedBy(operatedBy);
		retailStoreCountryCenter.setLegalRepresentative(legalRepresentative);
		retailStoreCountryCenter.setDescription(description);

		return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, emptyOptions());
		

		
	}
	protected RetailStoreCountryCenter createNewRetailStoreCountryCenter() 
	{
		
		return new RetailStoreCountryCenter();		
	}
	
	protected void checkParamsForUpdatingRetailStoreCountryCenter(RetailScmUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkVersionOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterVersion, exception);
		

		if(RetailStoreCountryCenter.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreCountryCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY.equals(property)){
			checkServiceNumberOfRetailStoreCountryCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreCountryCenter.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStoreCountryCenter(userContext, parseDate(newValueExpr), exception);
		}
		if(RetailStoreCountryCenter.WEB_SITE_PROPERTY.equals(property)){
			checkWebSiteOfRetailStoreCountryCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreCountryCenter.ADDRESS_PROPERTY.equals(property)){
			checkAddressOfRetailStoreCountryCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreCountryCenter.OPERATED_BY_PROPERTY.equals(property)){
			checkOperatedByOfRetailStoreCountryCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
			checkLegalRepresentativeOfRetailStoreCountryCenter(userContext, parseString(newValueExpr), exception);
		}
		if(RetailStoreCountryCenter.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfRetailStoreCountryCenter(userContext, parseString(newValueExpr), exception);
		}
	
		throwExceptionIfHasErrors(userContext, exception);
	
		
	}
	
	
	
	public RetailStoreCountryCenter clone(RetailScmUserContext userContext, String fromRetailStoreCountryCenterId) throws Exception{
		
		return this.getRetailStoreCountryCenterDAO().clone(fromRetailStoreCountryCenterId, this.allTokens());
	}
	
	public RetailStoreCountryCenter updateRetailStoreCountryCenter(RetailScmUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, retailStoreCountryCenterVersion, property, newValueExpr, tokensExpr);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		if(retailStoreCountryCenter.getVersion() != retailStoreCountryCenterVersion){
			String message = "The target version("+retailStoreCountryCenter.getVersion()+") is not equals to version("+retailStoreCountryCenterVersion+") provided";
			throw new RetailStoreCountryCenterManagerException(message);
		}
		synchronized(retailStoreCountryCenter){ 
			//will be good when the decorationAccelerater loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCountryCenter.
			
			retailStoreCountryCenter.changePropery(property, newValueExpr);
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RetailStoreCountryCenterTokens tokens(){
		return RetailStoreCountryCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreCountryCenterTokens.all();
	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreCountryCenterTokens.mergeAll(tokens).done();
	}
	private static final String [] STATUS_SEQUENCE={};
 	protected String getNextStatus(RetailScmUserContext userContext, String currentStatus){
 	
 		if(currentStatus == null){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE[0];
 		}
 	
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throw new IllegalArgumentException("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		//this is not the last one, just return it.
 		
 		return STATUS_SEQUENCE[index+1];
 	
 	}/**/
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailScmUserContext userContext, String retailStoreCountryCenterId, int retailStoreCountryCenterVersion) throws Exception {
		
		deleteInternal(userContext, retailStoreCountryCenterId, retailStoreCountryCenterVersion);		
		
	}
	
	protected void deleteInternal(RetailScmUserContext userContext,
			String retailStoreCountryCenterId, int retailStoreCountryCenterVersion) throws Exception{
		getRetailStoreCountryCenterDAO().delete(retailStoreCountryCenterId, retailStoreCountryCenterVersion);
	}
	
	public int deleteAll(RetailScmUserContext userContext, String secureCode) throws Exception
	{
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreCountryCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
	}
	
	
	protected int deleteAllInternal(RetailScmUserContext userContext) throws Exception{
		return getRetailStoreCountryCenterDAO().deleteAll();
	}

	protected void checkParamsForAddingReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String createdBy,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfReport(userContext,  name, exception);
		checkCreatedByOfReport(userContext,  createdBy, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String createdBy, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingReport(userContext,retailStoreCountryCenterId,name, createdBy,tokensExpr);
		
		Report report = createReport(userContext,name, createdBy);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addReport( report );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withReportList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected Report createReport(RetailScmUserContext userContext, String name, String createdBy) throws Exception{

		Report report = new Report();
		
		
		report.setName(name);		
		report.setCreatedBy(createdBy);
	
		
		return report;
	
		
	}
	
	protected Report createIndexedReport(String id, int version){

		Report report = new Report();
		report.setId(id);
		report.setVersion(version);
		return report;			
		
	}
	protected void checkParamsForRemovingReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String reportId, int reportVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfReport(userContext, reportId, exception);
		checkVersionOfReport(userContext, reportVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String reportId, int reportVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingReport(userContext,retailStoreCountryCenterId, reportId, reportVersion,tokensExpr);
		
		Report report = createIndexedReport(reportId, reportVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeReport( report );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withReportList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String reportId, int reportVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfReport(userContext, reportId, exception);
		checkVersionOfReport(userContext, reportVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyReportFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String reportId, int reportVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingReport(userContext,retailStoreCountryCenterId, reportId, reportVersion,tokensExpr);
		
		Report report = createIndexedReport(reportId, reportVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyReportFrom( report );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withReportList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, String reportId, int reportVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfReport(userContext, reportId, exception);
		checkVersionOfReport(userContext, reportVersion, exception);
		

		if(Report.NAME_PROPERTY.equals(property)){
			checkNameOfReport(userContext, parseString(newValueExpr), exception);
		}
		
		if(Report.CREATED_BY_PROPERTY.equals(property)){
			checkCreatedByOfReport(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateReport(RetailScmUserContext userContext, String retailStoreCountryCenterId, String reportId, int reportVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingReport(userContext, retailStoreCountryCenterId, reportId, reportVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeReport( report );	
			//make changes to AcceleraterAccount.
			Report reportIndex = createIndexedReport(reportId, reportVersion);
		
			Report report = retailStoreCountryCenter.findTheReport(reportIndex);
			if(report == null){
				throw new RetailStoreCountryCenterManagerException(report+"Not found" );
			}
			
			report.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withReportList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, String displayName,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkDisplayNameOfCatalog(userContext,  displayName, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, String displayName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCatalog(userContext,retailStoreCountryCenterId,displayName,tokensExpr);
		
		Catalog catalog = createCatalog(userContext,displayName);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addCatalog( catalog );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected Catalog createCatalog(RetailScmUserContext userContext, String displayName) throws Exception{

		Catalog catalog = new Catalog();
		
		
		catalog.setDisplayName(displayName);
	
		
		return catalog;
	
		
	}
	
	protected Catalog createIndexedCatalog(String id, int version){

		Catalog catalog = new Catalog();
		catalog.setId(id);
		catalog.setVersion(version);
		return catalog;			
		
	}
	protected void checkParamsForRemovingCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfCatalog(userContext, catalogId, exception);
		checkVersionOfCatalog(userContext, catalogVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCatalog(userContext,retailStoreCountryCenterId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeCatalog( catalog );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfCatalog(userContext, catalogId, exception);
		checkVersionOfCatalog(userContext, catalogVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyCatalogFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCatalog(userContext,retailStoreCountryCenterId, catalogId, catalogVersion,tokensExpr);
		
		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyCatalogFrom( catalog );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfCatalog(userContext, catalogId, exception);
		checkVersionOfCatalog(userContext, catalogVersion, exception);
		

		if(Catalog.DISPLAY_NAME_PROPERTY.equals(property)){
			checkDisplayNameOfCatalog(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateCatalog(RetailScmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCatalog(userContext, retailStoreCountryCenterId, catalogId, catalogVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeCatalog( catalog );	
			//make changes to AcceleraterAccount.
			Catalog catalogIndex = createIndexedCatalog(catalogId, catalogVersion);
		
			Catalog catalog = retailStoreCountryCenter.findTheCatalog(catalogIndex);
			if(catalog == null){
				throw new RetailStoreCountryCenterManagerException(catalog+"Not found" );
			}
			
			catalog.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, Date founded,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfRetailStoreProvinceCenter(userContext,  name, exception);
		checkFoundedOfRetailStoreProvinceCenter(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreProvinceCenter(userContext,retailStoreCountryCenterId,name, founded,tokensExpr);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = createRetailStoreProvinceCenter(userContext,name, founded);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStoreProvinceCenter( retailStoreProvinceCenter );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreProvinceCenter createRetailStoreProvinceCenter(RetailScmUserContext userContext, String name, Date founded) throws Exception{

		RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
		
		
		retailStoreProvinceCenter.setName(name);		
		retailStoreProvinceCenter.setFounded(founded);
	
		
		return retailStoreProvinceCenter;
	
		
	}
	
	protected RetailStoreProvinceCenter createIndexedRetailStoreProvinceCenter(String id, int version){

		RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
		retailStoreProvinceCenter.setId(id);
		retailStoreProvinceCenter.setVersion(version);
		return retailStoreProvinceCenter;			
		
	}
	protected void checkParamsForRemovingRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkVersionOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreProvinceCenter(userContext,retailStoreCountryCenterId, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion,tokensExpr);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = createIndexedRetailStoreProvinceCenter(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStoreProvinceCenter( retailStoreProvinceCenter );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkVersionOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyRetailStoreProvinceCenterFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreProvinceCenter(userContext,retailStoreCountryCenterId, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion,tokensExpr);
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = createIndexedRetailStoreProvinceCenter(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyRetailStoreProvinceCenterFrom( retailStoreProvinceCenter );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterId, exception);
		checkVersionOfRetailStoreProvinceCenter(userContext, retailStoreProvinceCenterVersion, exception);
		

		if(RetailStoreProvinceCenter.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreProvinceCenter(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreProvinceCenter.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStoreProvinceCenter(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateRetailStoreProvinceCenter(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreCountryCenterId, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStoreProvinceCenter( retailStoreProvinceCenter );	
			//make changes to AcceleraterAccount.
			RetailStoreProvinceCenter retailStoreProvinceCenterIndex = createIndexedRetailStoreProvinceCenter(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
		
			RetailStoreProvinceCenter retailStoreProvinceCenter = retailStoreCountryCenter.findTheRetailStoreProvinceCenter(retailStoreProvinceCenterIndex);
			if(retailStoreProvinceCenter == null){
				throw new RetailStoreCountryCenterManagerException(retailStoreProvinceCenter+"Not found" );
			}
			
			retailStoreProvinceCenter.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, Date founded, double latitude, double longitude, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfRetailStore(userContext,  name, exception);
		checkTelephoneOfRetailStore(userContext,  telephone, exception);
		checkOwnerOfRetailStore(userContext,  owner, exception);		
		
		checkIdOfRetailStoreCityServiceCenter(userContext,  cityServiceCenterId, exception);
		checkFoundedOfRetailStore(userContext,  founded, exception);
		checkLatitudeOfRetailStore(userContext,  latitude, exception);
		checkLongitudeOfRetailStore(userContext,  longitude, exception);
		checkDescriptionOfRetailStore(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, Date founded, double latitude, double longitude, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStore(userContext,retailStoreCountryCenterId,name, telephone, owner, cityServiceCenterId, founded, latitude, longitude, description,tokensExpr);
		
		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, cityServiceCenterId, founded, latitude, longitude, description);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStore( retailStore );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStore createRetailStore(RetailScmUserContext userContext, String name, String telephone, String owner, String cityServiceCenterId, Date founded, double latitude, double longitude, String description) throws Exception{

		RetailStore retailStore = new RetailStore();
		
		
		retailStore.setName(name);		
		retailStore.setTelephone(telephone);		
		retailStore.setOwner(owner);		
		RetailStoreCityServiceCenter  cityServiceCenter = new RetailStoreCityServiceCenter();
		cityServiceCenter.setId(cityServiceCenterId);		
		retailStore.setCityServiceCenter(cityServiceCenter);		
		retailStore.setFounded(founded);		
		retailStore.setLatitude(latitude);		
		retailStore.setLongitude(longitude);		
		retailStore.setDescription(description);
	
		
		return retailStore;
	
		
	}
	
	protected RetailStore createIndexedRetailStore(String id, int version){

		RetailStore retailStore = new RetailStore();
		retailStore.setId(id);
		retailStore.setVersion(version);
		return retailStore;			
		
	}
	protected void checkParamsForRemovingRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStore(userContext,retailStoreCountryCenterId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStore( retailStore );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyRetailStoreFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStore(userContext,retailStoreCountryCenterId, retailStoreId, retailStoreVersion,tokensExpr);
		
		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyRetailStoreFrom( retailStore );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStore(userContext, retailStoreId, exception);
		checkVersionOfRetailStore(userContext, retailStoreVersion, exception);
		

		if(RetailStore.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
			checkTelephoneOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.OWNER_PROPERTY.equals(property)){
			checkOwnerOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfRetailStore(userContext, parseDate(newValueExpr), exception);
		}
		
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfRetailStore(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfRetailStore(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateRetailStore(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStore(userContext, retailStoreCountryCenterId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStore( retailStore );	
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		
			RetailStore retailStore = retailStoreCountryCenter.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreCountryCenterManagerException(retailStore+"Not found" );
			}
			
			retailStore.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfRetailStoreMember(userContext,  name, exception);
		checkMobilePhoneOfRetailStoreMember(userContext,  mobilePhone, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreMember(userContext,retailStoreCountryCenterId,name, mobilePhone,tokensExpr);
		
		RetailStoreMember retailStoreMember = createRetailStoreMember(userContext,name, mobilePhone);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStoreMember( retailStoreMember );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreMember createRetailStoreMember(RetailScmUserContext userContext, String name, String mobilePhone) throws Exception{

		RetailStoreMember retailStoreMember = new RetailStoreMember();
		
		
		retailStoreMember.setName(name);		
		retailStoreMember.setMobilePhone(mobilePhone);
	
		
		return retailStoreMember;
	
		
	}
	
	protected RetailStoreMember createIndexedRetailStoreMember(String id, int version){

		RetailStoreMember retailStoreMember = new RetailStoreMember();
		retailStoreMember.setId(id);
		retailStoreMember.setVersion(version);
		return retailStoreMember;			
		
	}
	protected void checkParamsForRemovingRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkVersionOfRetailStoreMember(userContext, retailStoreMemberVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreMember(userContext,retailStoreCountryCenterId, retailStoreMemberId, retailStoreMemberVersion,tokensExpr);
		
		RetailStoreMember retailStoreMember = createIndexedRetailStoreMember(retailStoreMemberId, retailStoreMemberVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStoreMember( retailStoreMember );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkVersionOfRetailStoreMember(userContext, retailStoreMemberVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyRetailStoreMemberFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreMember(userContext,retailStoreCountryCenterId, retailStoreMemberId, retailStoreMemberVersion,tokensExpr);
		
		RetailStoreMember retailStoreMember = createIndexedRetailStoreMember(retailStoreMemberId, retailStoreMemberVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyRetailStoreMemberFrom( retailStoreMember );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreMember(userContext, retailStoreMemberId, exception);
		checkVersionOfRetailStoreMember(userContext, retailStoreMemberVersion, exception);
		

		if(RetailStoreMember.NAME_PROPERTY.equals(property)){
			checkNameOfRetailStoreMember(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreMember.MOBILE_PHONE_PROPERTY.equals(property)){
			checkMobilePhoneOfRetailStoreMember(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateRetailStoreMember(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreCountryCenterId, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStoreMember( retailStoreMember );	
			//make changes to AcceleraterAccount.
			RetailStoreMember retailStoreMemberIndex = createIndexedRetailStoreMember(retailStoreMemberId, retailStoreMemberVersion);
		
			RetailStoreMember retailStoreMember = retailStoreCountryCenter.findTheRetailStoreMember(retailStoreMemberIndex);
			if(retailStoreMember == null){
				throw new RetailStoreCountryCenterManagerException(retailStoreMember+"Not found" );
			}
			
			retailStoreMember.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfGoodsSupplier(userContext,  name, exception);
		checkSupplyProductOfGoodsSupplier(userContext,  supplyProduct, exception);
		checkContactNumberOfGoodsSupplier(userContext,  contactNumber, exception);
		checkDescriptionOfGoodsSupplier(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingGoodsSupplier(userContext,retailStoreCountryCenterId,name, supplyProduct, contactNumber, description,tokensExpr);
		
		GoodsSupplier goodsSupplier = createGoodsSupplier(userContext,name, supplyProduct, contactNumber, description);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addGoodsSupplier( goodsSupplier );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected GoodsSupplier createGoodsSupplier(RetailScmUserContext userContext, String name, String supplyProduct, String contactNumber, String description) throws Exception{

		GoodsSupplier goodsSupplier = new GoodsSupplier();
		
		
		goodsSupplier.setName(name);		
		goodsSupplier.setSupplyProduct(supplyProduct);		
		goodsSupplier.setContactNumber(contactNumber);		
		goodsSupplier.setDescription(description);
	
		
		return goodsSupplier;
	
		
	}
	
	protected GoodsSupplier createIndexedGoodsSupplier(String id, int version){

		GoodsSupplier goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(id);
		goodsSupplier.setVersion(version);
		return goodsSupplier;			
		
	}
	protected void checkParamsForRemovingGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkVersionOfGoodsSupplier(userContext, goodsSupplierVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingGoodsSupplier(userContext,retailStoreCountryCenterId, goodsSupplierId, goodsSupplierVersion,tokensExpr);
		
		GoodsSupplier goodsSupplier = createIndexedGoodsSupplier(goodsSupplierId, goodsSupplierVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeGoodsSupplier( goodsSupplier );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkVersionOfGoodsSupplier(userContext, goodsSupplierVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyGoodsSupplierFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingGoodsSupplier(userContext,retailStoreCountryCenterId, goodsSupplierId, goodsSupplierVersion,tokensExpr);
		
		GoodsSupplier goodsSupplier = createIndexedGoodsSupplier(goodsSupplierId, goodsSupplierVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyGoodsSupplierFrom( goodsSupplier );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfGoodsSupplier(userContext, goodsSupplierId, exception);
		checkVersionOfGoodsSupplier(userContext, goodsSupplierVersion, exception);
		

		if(GoodsSupplier.NAME_PROPERTY.equals(property)){
			checkNameOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY.equals(property)){
			checkSupplyProductOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsSupplier.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}
		
		if(GoodsSupplier.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfGoodsSupplier(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateGoodsSupplier(RetailScmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingGoodsSupplier(userContext, retailStoreCountryCenterId, goodsSupplierId, goodsSupplierVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeGoodsSupplier( goodsSupplier );	
			//make changes to AcceleraterAccount.
			GoodsSupplier goodsSupplierIndex = createIndexedGoodsSupplier(goodsSupplierId, goodsSupplierVersion);
		
			GoodsSupplier goodsSupplier = retailStoreCountryCenter.findTheGoodsSupplier(goodsSupplierIndex);
			if(goodsSupplier == null){
				throw new RetailStoreCountryCenterManagerException(goodsSupplier+"Not found" );
			}
			
			goodsSupplier.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		
		
		checkIdOfGoodsSupplier(userContext,  sellerId, exception);
		checkTitleOfSupplyOrder(userContext,  title, exception);
		checkTotalAmountOfSupplyOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSupplyOrder(userContext,retailStoreCountryCenterId,sellerId, title, totalAmount,tokensExpr);
		
		SupplyOrder supplyOrder = createSupplyOrder(userContext,sellerId, title, totalAmount);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addSupplyOrder( supplyOrder );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected SupplyOrder createSupplyOrder(RetailScmUserContext userContext, String sellerId, String title, double totalAmount) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);
	
		
		return supplyOrder;
	
		
	}
	
	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;			
		
	}
	protected void checkParamsForRemovingSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSupplyOrder(userContext,retailStoreCountryCenterId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeSupplyOrder( supplyOrder );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copySupplyOrderFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSupplyOrder(userContext,retailStoreCountryCenterId, supplyOrderId, supplyOrderVersion,tokensExpr);
		
		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copySupplyOrderFrom( supplyOrder );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSupplyOrder(userContext, supplyOrderId, exception);
		checkVersionOfSupplyOrder(userContext, supplyOrderVersion, exception);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfSupplyOrder(userContext, parseString(newValueExpr), exception);
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkTotalAmountOfSupplyOrder(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateSupplyOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSupplyOrder(userContext, retailStoreCountryCenterId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeSupplyOrder( supplyOrder );	
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		
			SupplyOrder supplyOrder = retailStoreCountryCenter.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new RetailStoreCountryCenterManagerException(supplyOrder+"Not found" );
			}
			
			supplyOrder.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, double totalAmount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		
		
		checkIdOfRetailStore(userContext,  buyerId, exception);
		checkTitleOfRetailStoreOrder(userContext,  title, exception);
		checkTotalAmountOfRetailStoreOrder(userContext,  totalAmount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, double totalAmount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreCountryCenterId,buyerId, title, totalAmount,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, title, totalAmount);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStoreOrder( retailStoreOrder );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected RetailStoreOrder createRetailStoreOrder(RetailScmUserContext userContext, String buyerId, String title, double totalAmount) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
		RetailStore  buyer = new RetailStore();
		buyer.setId(buyerId);		
		retailStoreOrder.setBuyer(buyer);		
		retailStoreOrder.setTitle(title);		
		retailStoreOrder.setTotalAmount(totalAmount);
	
		
		return retailStoreOrder;
	
		
	}
	
	protected RetailStoreOrder createIndexedRetailStoreOrder(String id, int version){

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(version);
		return retailStoreOrder;			
		
	}
	protected void checkParamsForRemovingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreCountryCenterId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStoreOrder( retailStoreOrder );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyRetailStoreOrderFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreCountryCenterId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);
		
		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyRetailStoreOrderFrom( retailStoreOrder );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfRetailStoreOrder(userContext, retailStoreOrderId, exception);
		checkVersionOfRetailStoreOrder(userContext, retailStoreOrderVersion, exception);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			checkTitleOfRetailStoreOrder(userContext, parseString(newValueExpr), exception);
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkTotalAmountOfRetailStoreOrder(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreCountryCenterId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStoreOrder( retailStoreOrder );	
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		
			RetailStoreOrder retailStoreOrder = retailStoreCountryCenter.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreCountryCenterManagerException(retailStoreOrder+"Not found" );
			}
			
			retailStoreOrder.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, double latitude, double longitude,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkLocationOfWarehouse(userContext,  location, exception);
		checkContactNumberOfWarehouse(userContext,  contactNumber, exception);
		checkTotalAreaOfWarehouse(userContext,  totalArea, exception);
		checkLatitudeOfWarehouse(userContext,  latitude, exception);
		checkLongitudeOfWarehouse(userContext,  longitude, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, double latitude, double longitude, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingWarehouse(userContext,retailStoreCountryCenterId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);
		
		Warehouse warehouse = createWarehouse(userContext,location, contactNumber, totalArea, latitude, longitude);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addWarehouse( warehouse );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected Warehouse createWarehouse(RetailScmUserContext userContext, String location, String contactNumber, String totalArea, double latitude, double longitude) throws Exception{

		Warehouse warehouse = new Warehouse();
		
		
		warehouse.setLocation(location);		
		warehouse.setContactNumber(contactNumber);		
		warehouse.setTotalArea(totalArea);		
		warehouse.setLatitude(latitude);		
		warehouse.setLongitude(longitude);
	
		
		return warehouse;
	
		
	}
	
	protected Warehouse createIndexedWarehouse(String id, int version){

		Warehouse warehouse = new Warehouse();
		warehouse.setId(id);
		warehouse.setVersion(version);
		return warehouse;			
		
	}
	protected void checkParamsForRemovingWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkVersionOfWarehouse(userContext, warehouseVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingWarehouse(userContext,retailStoreCountryCenterId, warehouseId, warehouseVersion,tokensExpr);
		
		Warehouse warehouse = createIndexedWarehouse(warehouseId, warehouseVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeWarehouse( warehouse );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkVersionOfWarehouse(userContext, warehouseVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyWarehouseFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingWarehouse(userContext,retailStoreCountryCenterId, warehouseId, warehouseVersion,tokensExpr);
		
		Warehouse warehouse = createIndexedWarehouse(warehouseId, warehouseVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyWarehouseFrom( warehouse );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfWarehouse(userContext, warehouseId, exception);
		checkVersionOfWarehouse(userContext, warehouseVersion, exception);
		

		if(Warehouse.LOCATION_PROPERTY.equals(property)){
			checkLocationOfWarehouse(userContext, parseString(newValueExpr), exception);
		}
		
		if(Warehouse.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfWarehouse(userContext, parseString(newValueExpr), exception);
		}
		
		if(Warehouse.TOTAL_AREA_PROPERTY.equals(property)){
			checkTotalAreaOfWarehouse(userContext, parseString(newValueExpr), exception);
		}
		
		if(Warehouse.LATITUDE_PROPERTY.equals(property)){
			checkLatitudeOfWarehouse(userContext, parseDouble(newValueExpr), exception);
		}
		
		if(Warehouse.LONGITUDE_PROPERTY.equals(property)){
			checkLongitudeOfWarehouse(userContext, parseDouble(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateWarehouse(RetailScmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingWarehouse(userContext, retailStoreCountryCenterId, warehouseId, warehouseVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeWarehouse( warehouse );	
			//make changes to AcceleraterAccount.
			Warehouse warehouseIndex = createIndexedWarehouse(warehouseId, warehouseVersion);
		
			Warehouse warehouse = retailStoreCountryCenter.findTheWarehouse(warehouseIndex);
			if(warehouse == null){
				throw new RetailStoreCountryCenterManagerException(warehouse+"Not found" );
			}
			
			warehouse.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfTransportFleet(userContext,  name, exception);
		checkContactNumberOfTransportFleet(userContext,  contactNumber, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTransportFleet(userContext,retailStoreCountryCenterId,name, contactNumber,tokensExpr);
		
		TransportFleet transportFleet = createTransportFleet(userContext,name, contactNumber);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTransportFleet( transportFleet );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected TransportFleet createTransportFleet(RetailScmUserContext userContext, String name, String contactNumber) throws Exception{

		TransportFleet transportFleet = new TransportFleet();
		
		
		transportFleet.setName(name);		
		transportFleet.setContactNumber(contactNumber);
	
		
		return transportFleet;
	
		
	}
	
	protected TransportFleet createIndexedTransportFleet(String id, int version){

		TransportFleet transportFleet = new TransportFleet();
		transportFleet.setId(id);
		transportFleet.setVersion(version);
		return transportFleet;			
		
	}
	protected void checkParamsForRemovingTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkVersionOfTransportFleet(userContext, transportFleetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTransportFleet(userContext,retailStoreCountryCenterId, transportFleetId, transportFleetVersion,tokensExpr);
		
		TransportFleet transportFleet = createIndexedTransportFleet(transportFleetId, transportFleetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTransportFleet( transportFleet );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkVersionOfTransportFleet(userContext, transportFleetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyTransportFleetFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTransportFleet(userContext,retailStoreCountryCenterId, transportFleetId, transportFleetVersion,tokensExpr);
		
		TransportFleet transportFleet = createIndexedTransportFleet(transportFleetId, transportFleetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyTransportFleetFrom( transportFleet );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTransportFleet(userContext, transportFleetId, exception);
		checkVersionOfTransportFleet(userContext, transportFleetVersion, exception);
		

		if(TransportFleet.NAME_PROPERTY.equals(property)){
			checkNameOfTransportFleet(userContext, parseString(newValueExpr), exception);
		}
		
		if(TransportFleet.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkContactNumberOfTransportFleet(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateTransportFleet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTransportFleet(userContext, retailStoreCountryCenterId, transportFleetId, transportFleetVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTransportFleet( transportFleet );	
			//make changes to AcceleraterAccount.
			TransportFleet transportFleetIndex = createIndexedTransportFleet(transportFleetId, transportFleetVersion);
		
			TransportFleet transportFleet = retailStoreCountryCenter.findTheTransportFleet(transportFleetIndex);
			if(transportFleet == null){
				throw new RetailStoreCountryCenterManagerException(transportFleet+"Not found" );
			}
			
			transportFleet.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfAccountSet(userContext,  name, exception);
		checkYearSetOfAccountSet(userContext,  yearSet, exception);
		checkEffectiveDateOfAccountSet(userContext,  effectiveDate, exception);
		checkAccountingSystemOfAccountSet(userContext,  accountingSystem, exception);
		checkDomesticCurrencyCodeOfAccountSet(userContext,  domesticCurrencyCode, exception);
		checkDomesticCurrencyNameOfAccountSet(userContext,  domesticCurrencyName, exception);
		checkOpeningBankOfAccountSet(userContext,  openingBank, exception);
		checkAccountNumberOfAccountSet(userContext,  accountNumber, exception);		
		
		checkIdOfRetailStore(userContext,  retailStoreId, exception);		
		
		checkIdOfGoodsSupplier(userContext,  goodsSupplierId, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAccountSet(userContext,retailStoreCountryCenterId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, retailStoreId, goodsSupplierId,tokensExpr);
		
		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, retailStoreId, goodsSupplierId);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addAccountSet( accountSet );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected AccountSet createAccountSet(RetailScmUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId) throws Exception{

		AccountSet accountSet = new AccountSet();
		
		
		accountSet.setName(name);		
		accountSet.setYearSet(yearSet);		
		accountSet.setEffectiveDate(effectiveDate);		
		accountSet.setAccountingSystem(accountingSystem);		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);		
		accountSet.setOpeningBank(openingBank);		
		accountSet.setAccountNumber(accountNumber);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		accountSet.setRetailStore(retailStore);		
		GoodsSupplier  goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(goodsSupplierId);		
		accountSet.setGoodsSupplier(goodsSupplier);
	
		
		return accountSet;
	
		
	}
	
	protected AccountSet createIndexedAccountSet(String id, int version){

		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(version);
		return accountSet;			
		
	}
	protected void checkParamsForRemovingAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAccountSet(userContext,retailStoreCountryCenterId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeAccountSet( accountSet );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyAccountSetFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAccountSet(userContext,retailStoreCountryCenterId, accountSetId, accountSetVersion,tokensExpr);
		
		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyAccountSetFrom( accountSet );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfAccountSet(userContext, accountSetId, exception);
		checkVersionOfAccountSet(userContext, accountSetVersion, exception);
		

		if(AccountSet.NAME_PROPERTY.equals(property)){
			checkNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
			checkYearSetOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
			checkEffectiveDateOfAccountSet(userContext, parseDate(newValueExpr), exception);
		}
		
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			checkAccountingSystemOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			checkDomesticCurrencyCodeOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			checkDomesticCurrencyNameOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
			checkOpeningBankOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
			checkAccountNumberOfAccountSet(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateAccountSet(RetailScmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAccountSet(userContext, retailStoreCountryCenterId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeAccountSet( accountSet );	
			//make changes to AcceleraterAccount.
			AccountSet accountSetIndex = createIndexedAccountSet(accountSetId, accountSetVersion);
		
			AccountSet accountSet = retailStoreCountryCenter.findTheAccountSet(accountSetIndex);
			if(accountSet == null){
				throw new RetailStoreCountryCenterManagerException(accountSet+"Not found" );
			}
			
			accountSet.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkNameOfLevelOneDepartment(userContext,  name, exception);
		checkDescriptionOfLevelOneDepartment(userContext,  description, exception);
		checkManagerOfLevelOneDepartment(userContext,  manager, exception);
		checkFoundedOfLevelOneDepartment(userContext,  founded, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLevelOneDepartment(userContext,retailStoreCountryCenterId,name, description, manager, founded,tokensExpr);
		
		LevelOneDepartment levelOneDepartment = createLevelOneDepartment(userContext,name, description, manager, founded);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addLevelOneDepartment( levelOneDepartment );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected LevelOneDepartment createLevelOneDepartment(RetailScmUserContext userContext, String name, String description, String manager, Date founded) throws Exception{

		LevelOneDepartment levelOneDepartment = new LevelOneDepartment();
		
		
		levelOneDepartment.setName(name);		
		levelOneDepartment.setDescription(description);		
		levelOneDepartment.setManager(manager);		
		levelOneDepartment.setFounded(founded);
	
		
		return levelOneDepartment;
	
		
	}
	
	protected LevelOneDepartment createIndexedLevelOneDepartment(String id, int version){

		LevelOneDepartment levelOneDepartment = new LevelOneDepartment();
		levelOneDepartment.setId(id);
		levelOneDepartment.setVersion(version);
		return levelOneDepartment;			
		
	}
	protected void checkParamsForRemovingLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		checkVersionOfLevelOneDepartment(userContext, levelOneDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLevelOneDepartment(userContext,retailStoreCountryCenterId, levelOneDepartmentId, levelOneDepartmentVersion,tokensExpr);
		
		LevelOneDepartment levelOneDepartment = createIndexedLevelOneDepartment(levelOneDepartmentId, levelOneDepartmentVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeLevelOneDepartment( levelOneDepartment );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		checkVersionOfLevelOneDepartment(userContext, levelOneDepartmentVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyLevelOneDepartmentFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLevelOneDepartment(userContext,retailStoreCountryCenterId, levelOneDepartmentId, levelOneDepartmentVersion,tokensExpr);
		
		LevelOneDepartment levelOneDepartment = createIndexedLevelOneDepartment(levelOneDepartmentId, levelOneDepartmentVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyLevelOneDepartmentFrom( levelOneDepartment );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfLevelOneDepartment(userContext, levelOneDepartmentId, exception);
		checkVersionOfLevelOneDepartment(userContext, levelOneDepartmentVersion, exception);
		

		if(LevelOneDepartment.NAME_PROPERTY.equals(property)){
			checkNameOfLevelOneDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(LevelOneDepartment.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfLevelOneDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(LevelOneDepartment.MANAGER_PROPERTY.equals(property)){
			checkManagerOfLevelOneDepartment(userContext, parseString(newValueExpr), exception);
		}
		
		if(LevelOneDepartment.FOUNDED_PROPERTY.equals(property)){
			checkFoundedOfLevelOneDepartment(userContext, parseDate(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateLevelOneDepartment(RetailScmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLevelOneDepartment(userContext, retailStoreCountryCenterId, levelOneDepartmentId, levelOneDepartmentVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeLevelOneDepartment( levelOneDepartment );	
			//make changes to AcceleraterAccount.
			LevelOneDepartment levelOneDepartmentIndex = createIndexedLevelOneDepartment(levelOneDepartmentId, levelOneDepartmentVersion);
		
			LevelOneDepartment levelOneDepartment = retailStoreCountryCenter.findTheLevelOneDepartment(levelOneDepartmentIndex);
			if(levelOneDepartment == null){
				throw new RetailStoreCountryCenterManagerException(levelOneDepartment+"Not found" );
			}
			
			levelOneDepartment.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfSkillType(userContext,  code, exception);
		checkDescriptionOfSkillType(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSkillType(userContext,retailStoreCountryCenterId,code, description,tokensExpr);
		
		SkillType skillType = createSkillType(userContext,code, description);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addSkillType( skillType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected SkillType createSkillType(RetailScmUserContext userContext, String code, String description) throws Exception{

		SkillType skillType = new SkillType();
		
		
		skillType.setCode(code);		
		skillType.setDescription(description);
	
		
		return skillType;
	
		
	}
	
	protected SkillType createIndexedSkillType(String id, int version){

		SkillType skillType = new SkillType();
		skillType.setId(id);
		skillType.setVersion(version);
		return skillType;			
		
	}
	protected void checkParamsForRemovingSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSkillType(userContext, skillTypeId, exception);
		checkVersionOfSkillType(userContext, skillTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSkillType(userContext,retailStoreCountryCenterId, skillTypeId, skillTypeVersion,tokensExpr);
		
		SkillType skillType = createIndexedSkillType(skillTypeId, skillTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeSkillType( skillType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSkillType(userContext, skillTypeId, exception);
		checkVersionOfSkillType(userContext, skillTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copySkillTypeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSkillType(userContext,retailStoreCountryCenterId, skillTypeId, skillTypeVersion,tokensExpr);
		
		SkillType skillType = createIndexedSkillType(skillTypeId, skillTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copySkillTypeFrom( skillType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSkillType(userContext, skillTypeId, exception);
		checkVersionOfSkillType(userContext, skillTypeVersion, exception);
		

		if(SkillType.CODE_PROPERTY.equals(property)){
			checkCodeOfSkillType(userContext, parseString(newValueExpr), exception);
		}
		
		if(SkillType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfSkillType(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateSkillType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSkillType(userContext, retailStoreCountryCenterId, skillTypeId, skillTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeSkillType( skillType );	
			//make changes to AcceleraterAccount.
			SkillType skillTypeIndex = createIndexedSkillType(skillTypeId, skillTypeVersion);
		
			SkillType skillType = retailStoreCountryCenter.findTheSkillType(skillTypeIndex);
			if(skillType == null){
				throw new RetailStoreCountryCenterManagerException(skillType+"Not found" );
			}
			
			skillType.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfResponsibilityType(userContext,  code, exception);
		checkBaseDescriptionOfResponsibilityType(userContext,  baseDescription, exception);
		checkDetailDescriptionOfResponsibilityType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingResponsibilityType(userContext,retailStoreCountryCenterId,code, baseDescription, detailDescription,tokensExpr);
		
		ResponsibilityType responsibilityType = createResponsibilityType(userContext,code, baseDescription, detailDescription);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addResponsibilityType( responsibilityType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected ResponsibilityType createResponsibilityType(RetailScmUserContext userContext, String code, String baseDescription, String detailDescription) throws Exception{

		ResponsibilityType responsibilityType = new ResponsibilityType();
		
		
		responsibilityType.setCode(code);		
		responsibilityType.setBaseDescription(baseDescription);		
		responsibilityType.setDetailDescription(detailDescription);
	
		
		return responsibilityType;
	
		
	}
	
	protected ResponsibilityType createIndexedResponsibilityType(String id, int version){

		ResponsibilityType responsibilityType = new ResponsibilityType();
		responsibilityType.setId(id);
		responsibilityType.setVersion(version);
		return responsibilityType;			
		
	}
	protected void checkParamsForRemovingResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		checkVersionOfResponsibilityType(userContext, responsibilityTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingResponsibilityType(userContext,retailStoreCountryCenterId, responsibilityTypeId, responsibilityTypeVersion,tokensExpr);
		
		ResponsibilityType responsibilityType = createIndexedResponsibilityType(responsibilityTypeId, responsibilityTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeResponsibilityType( responsibilityType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		checkVersionOfResponsibilityType(userContext, responsibilityTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyResponsibilityTypeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingResponsibilityType(userContext,retailStoreCountryCenterId, responsibilityTypeId, responsibilityTypeVersion,tokensExpr);
		
		ResponsibilityType responsibilityType = createIndexedResponsibilityType(responsibilityTypeId, responsibilityTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyResponsibilityTypeFrom( responsibilityType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfResponsibilityType(userContext, responsibilityTypeId, exception);
		checkVersionOfResponsibilityType(userContext, responsibilityTypeVersion, exception);
		

		if(ResponsibilityType.CODE_PROPERTY.equals(property)){
			checkCodeOfResponsibilityType(userContext, parseString(newValueExpr), exception);
		}
		
		if(ResponsibilityType.BASE_DESCRIPTION_PROPERTY.equals(property)){
			checkBaseDescriptionOfResponsibilityType(userContext, parseString(newValueExpr), exception);
		}
		
		if(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfResponsibilityType(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateResponsibilityType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingResponsibilityType(userContext, retailStoreCountryCenterId, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeResponsibilityType( responsibilityType );	
			//make changes to AcceleraterAccount.
			ResponsibilityType responsibilityTypeIndex = createIndexedResponsibilityType(responsibilityTypeId, responsibilityTypeVersion);
		
			ResponsibilityType responsibilityType = retailStoreCountryCenter.findTheResponsibilityType(responsibilityTypeIndex);
			if(responsibilityType == null){
				throw new RetailStoreCountryCenterManagerException(responsibilityType+"Not found" );
			}
			
			responsibilityType.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfTerminationReason(userContext,  code, exception);
		checkDescriptionOfTerminationReason(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTerminationReason(userContext,retailStoreCountryCenterId,code, description,tokensExpr);
		
		TerminationReason terminationReason = createTerminationReason(userContext,code, description);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTerminationReason( terminationReason );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected TerminationReason createTerminationReason(RetailScmUserContext userContext, String code, String description) throws Exception{

		TerminationReason terminationReason = new TerminationReason();
		
		
		terminationReason.setCode(code);		
		terminationReason.setDescription(description);
	
		
		return terminationReason;
	
		
	}
	
	protected TerminationReason createIndexedTerminationReason(String id, int version){

		TerminationReason terminationReason = new TerminationReason();
		terminationReason.setId(id);
		terminationReason.setVersion(version);
		return terminationReason;			
		
	}
	protected void checkParamsForRemovingTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		checkVersionOfTerminationReason(userContext, terminationReasonVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTerminationReason(userContext,retailStoreCountryCenterId, terminationReasonId, terminationReasonVersion,tokensExpr);
		
		TerminationReason terminationReason = createIndexedTerminationReason(terminationReasonId, terminationReasonVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTerminationReason( terminationReason );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		checkVersionOfTerminationReason(userContext, terminationReasonVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyTerminationReasonFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTerminationReason(userContext,retailStoreCountryCenterId, terminationReasonId, terminationReasonVersion,tokensExpr);
		
		TerminationReason terminationReason = createIndexedTerminationReason(terminationReasonId, terminationReasonVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyTerminationReasonFrom( terminationReason );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTerminationReason(userContext, terminationReasonId, exception);
		checkVersionOfTerminationReason(userContext, terminationReasonVersion, exception);
		

		if(TerminationReason.CODE_PROPERTY.equals(property)){
			checkCodeOfTerminationReason(userContext, parseString(newValueExpr), exception);
		}
		
		if(TerminationReason.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfTerminationReason(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateTerminationReason(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTerminationReason(userContext, retailStoreCountryCenterId, terminationReasonId, terminationReasonVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTerminationReason( terminationReason );	
			//make changes to AcceleraterAccount.
			TerminationReason terminationReasonIndex = createIndexedTerminationReason(terminationReasonId, terminationReasonVersion);
		
			TerminationReason terminationReason = retailStoreCountryCenter.findTheTerminationReason(terminationReasonIndex);
			if(terminationReason == null){
				throw new RetailStoreCountryCenterManagerException(terminationReason+"Not found" );
			}
			
			terminationReason.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfTerminationType(userContext,  code, exception);
		checkBaseDescriptionOfTerminationType(userContext,  baseDescription, exception);
		checkDetailDescriptionOfTerminationType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTerminationType(userContext,retailStoreCountryCenterId,code, baseDescription, detailDescription,tokensExpr);
		
		TerminationType terminationType = createTerminationType(userContext,code, baseDescription, detailDescription);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTerminationType( terminationType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected TerminationType createTerminationType(RetailScmUserContext userContext, String code, String baseDescription, String detailDescription) throws Exception{

		TerminationType terminationType = new TerminationType();
		
		
		terminationType.setCode(code);		
		terminationType.setBaseDescription(baseDescription);		
		terminationType.setDetailDescription(detailDescription);
	
		
		return terminationType;
	
		
	}
	
	protected TerminationType createIndexedTerminationType(String id, int version){

		TerminationType terminationType = new TerminationType();
		terminationType.setId(id);
		terminationType.setVersion(version);
		return terminationType;			
		
	}
	protected void checkParamsForRemovingTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		checkVersionOfTerminationType(userContext, terminationTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTerminationType(userContext,retailStoreCountryCenterId, terminationTypeId, terminationTypeVersion,tokensExpr);
		
		TerminationType terminationType = createIndexedTerminationType(terminationTypeId, terminationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTerminationType( terminationType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		checkVersionOfTerminationType(userContext, terminationTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyTerminationTypeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTerminationType(userContext,retailStoreCountryCenterId, terminationTypeId, terminationTypeVersion,tokensExpr);
		
		TerminationType terminationType = createIndexedTerminationType(terminationTypeId, terminationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyTerminationTypeFrom( terminationType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTerminationType(userContext, terminationTypeId, exception);
		checkVersionOfTerminationType(userContext, terminationTypeVersion, exception);
		

		if(TerminationType.CODE_PROPERTY.equals(property)){
			checkCodeOfTerminationType(userContext, parseString(newValueExpr), exception);
		}
		
		if(TerminationType.BASE_DESCRIPTION_PROPERTY.equals(property)){
			checkBaseDescriptionOfTerminationType(userContext, parseString(newValueExpr), exception);
		}
		
		if(TerminationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfTerminationType(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateTerminationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTerminationType(userContext, retailStoreCountryCenterId, terminationTypeId, terminationTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTerminationType( terminationType );	
			//make changes to AcceleraterAccount.
			TerminationType terminationTypeIndex = createIndexedTerminationType(terminationTypeId, terminationTypeVersion);
		
			TerminationType terminationType = retailStoreCountryCenter.findTheTerminationType(terminationTypeIndex);
			if(terminationType == null){
				throw new RetailStoreCountryCenterManagerException(terminationType+"Not found" );
			}
			
			terminationType.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfOccupationType(userContext,  code, exception);
		checkDescriptionOfOccupationType(userContext,  description, exception);
		checkDetailDescriptionOfOccupationType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingOccupationType(userContext,retailStoreCountryCenterId,code, description, detailDescription,tokensExpr);
		
		OccupationType occupationType = createOccupationType(userContext,code, description, detailDescription);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addOccupationType( occupationType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected OccupationType createOccupationType(RetailScmUserContext userContext, String code, String description, String detailDescription) throws Exception{

		OccupationType occupationType = new OccupationType();
		
		
		occupationType.setCode(code);		
		occupationType.setDescription(description);		
		occupationType.setDetailDescription(detailDescription);
	
		
		return occupationType;
	
		
	}
	
	protected OccupationType createIndexedOccupationType(String id, int version){

		OccupationType occupationType = new OccupationType();
		occupationType.setId(id);
		occupationType.setVersion(version);
		return occupationType;			
		
	}
	protected void checkParamsForRemovingOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		checkVersionOfOccupationType(userContext, occupationTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingOccupationType(userContext,retailStoreCountryCenterId, occupationTypeId, occupationTypeVersion,tokensExpr);
		
		OccupationType occupationType = createIndexedOccupationType(occupationTypeId, occupationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeOccupationType( occupationType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		checkVersionOfOccupationType(userContext, occupationTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyOccupationTypeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingOccupationType(userContext,retailStoreCountryCenterId, occupationTypeId, occupationTypeVersion,tokensExpr);
		
		OccupationType occupationType = createIndexedOccupationType(occupationTypeId, occupationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyOccupationTypeFrom( occupationType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfOccupationType(userContext, occupationTypeId, exception);
		checkVersionOfOccupationType(userContext, occupationTypeVersion, exception);
		

		if(OccupationType.CODE_PROPERTY.equals(property)){
			checkCodeOfOccupationType(userContext, parseString(newValueExpr), exception);
		}
		
		if(OccupationType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfOccupationType(userContext, parseString(newValueExpr), exception);
		}
		
		if(OccupationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfOccupationType(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateOccupationType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingOccupationType(userContext, retailStoreCountryCenterId, occupationTypeId, occupationTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeOccupationType( occupationType );	
			//make changes to AcceleraterAccount.
			OccupationType occupationTypeIndex = createIndexedOccupationType(occupationTypeId, occupationTypeVersion);
		
			OccupationType occupationType = retailStoreCountryCenter.findTheOccupationType(occupationTypeIndex);
			if(occupationType == null){
				throw new RetailStoreCountryCenterManagerException(occupationType+"Not found" );
			}
			
			occupationType.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfLeaveType(userContext,  code, exception);
		checkDescriptionOfLeaveType(userContext,  description, exception);
		checkDetailDescriptionOfLeaveType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLeaveType(userContext,retailStoreCountryCenterId,code, description, detailDescription,tokensExpr);
		
		LeaveType leaveType = createLeaveType(userContext,code, description, detailDescription);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addLeaveType( leaveType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected LeaveType createLeaveType(RetailScmUserContext userContext, String code, String description, String detailDescription) throws Exception{

		LeaveType leaveType = new LeaveType();
		
		
		leaveType.setCode(code);		
		leaveType.setDescription(description);		
		leaveType.setDetailDescription(detailDescription);
	
		
		return leaveType;
	
		
	}
	
	protected LeaveType createIndexedLeaveType(String id, int version){

		LeaveType leaveType = new LeaveType();
		leaveType.setId(id);
		leaveType.setVersion(version);
		return leaveType;			
		
	}
	protected void checkParamsForRemovingLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		checkVersionOfLeaveType(userContext, leaveTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLeaveType(userContext,retailStoreCountryCenterId, leaveTypeId, leaveTypeVersion,tokensExpr);
		
		LeaveType leaveType = createIndexedLeaveType(leaveTypeId, leaveTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeLeaveType( leaveType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		checkVersionOfLeaveType(userContext, leaveTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyLeaveTypeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLeaveType(userContext,retailStoreCountryCenterId, leaveTypeId, leaveTypeVersion,tokensExpr);
		
		LeaveType leaveType = createIndexedLeaveType(leaveTypeId, leaveTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyLeaveTypeFrom( leaveType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfLeaveType(userContext, leaveTypeId, exception);
		checkVersionOfLeaveType(userContext, leaveTypeVersion, exception);
		

		if(LeaveType.CODE_PROPERTY.equals(property)){
			checkCodeOfLeaveType(userContext, parseString(newValueExpr), exception);
		}
		
		if(LeaveType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfLeaveType(userContext, parseString(newValueExpr), exception);
		}
		
		if(LeaveType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfLeaveType(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateLeaveType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLeaveType(userContext, retailStoreCountryCenterId, leaveTypeId, leaveTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeLeaveType( leaveType );	
			//make changes to AcceleraterAccount.
			LeaveType leaveTypeIndex = createIndexedLeaveType(leaveTypeId, leaveTypeVersion);
		
			LeaveType leaveType = retailStoreCountryCenter.findTheLeaveType(leaveTypeIndex);
			if(leaveType == null){
				throw new RetailStoreCountryCenterManagerException(leaveType+"Not found" );
			}
			
			leaveType.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfSalaryGrade(userContext,  code, exception);
		checkNameOfSalaryGrade(userContext,  name, exception);
		checkDetailDescriptionOfSalaryGrade(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingSalaryGrade(userContext,retailStoreCountryCenterId,code, name, detailDescription,tokensExpr);
		
		SalaryGrade salaryGrade = createSalaryGrade(userContext,code, name, detailDescription);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addSalaryGrade( salaryGrade );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected SalaryGrade createSalaryGrade(RetailScmUserContext userContext, String code, String name, String detailDescription) throws Exception{

		SalaryGrade salaryGrade = new SalaryGrade();
		
		
		salaryGrade.setCode(code);		
		salaryGrade.setName(name);		
		salaryGrade.setDetailDescription(detailDescription);
	
		
		return salaryGrade;
	
		
	}
	
	protected SalaryGrade createIndexedSalaryGrade(String id, int version){

		SalaryGrade salaryGrade = new SalaryGrade();
		salaryGrade.setId(id);
		salaryGrade.setVersion(version);
		return salaryGrade;			
		
	}
	protected void checkParamsForRemovingSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkVersionOfSalaryGrade(userContext, salaryGradeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingSalaryGrade(userContext,retailStoreCountryCenterId, salaryGradeId, salaryGradeVersion,tokensExpr);
		
		SalaryGrade salaryGrade = createIndexedSalaryGrade(salaryGradeId, salaryGradeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeSalaryGrade( salaryGrade );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkVersionOfSalaryGrade(userContext, salaryGradeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copySalaryGradeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingSalaryGrade(userContext,retailStoreCountryCenterId, salaryGradeId, salaryGradeVersion,tokensExpr);
		
		SalaryGrade salaryGrade = createIndexedSalaryGrade(salaryGradeId, salaryGradeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copySalaryGradeFrom( salaryGrade );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfSalaryGrade(userContext, salaryGradeId, exception);
		checkVersionOfSalaryGrade(userContext, salaryGradeVersion, exception);
		

		if(SalaryGrade.CODE_PROPERTY.equals(property)){
			checkCodeOfSalaryGrade(userContext, parseString(newValueExpr), exception);
		}
		
		if(SalaryGrade.NAME_PROPERTY.equals(property)){
			checkNameOfSalaryGrade(userContext, parseString(newValueExpr), exception);
		}
		
		if(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfSalaryGrade(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateSalaryGrade(RetailScmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingSalaryGrade(userContext, retailStoreCountryCenterId, salaryGradeId, salaryGradeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeSalaryGrade( salaryGrade );	
			//make changes to AcceleraterAccount.
			SalaryGrade salaryGradeIndex = createIndexedSalaryGrade(salaryGradeId, salaryGradeVersion);
		
			SalaryGrade salaryGrade = retailStoreCountryCenter.findTheSalaryGrade(salaryGradeIndex);
			if(salaryGrade == null){
				throw new RetailStoreCountryCenterManagerException(salaryGrade+"Not found" );
			}
			
			salaryGrade.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfInterviewType(userContext,  code, exception);
		checkDescriptionOfInterviewType(userContext,  description, exception);
		checkDetailDescriptionOfInterviewType(userContext,  detailDescription, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingInterviewType(userContext,retailStoreCountryCenterId,code, description, detailDescription,tokensExpr);
		
		InterviewType interviewType = createInterviewType(userContext,code, description, detailDescription);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addInterviewType( interviewType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected InterviewType createInterviewType(RetailScmUserContext userContext, String code, String description, String detailDescription) throws Exception{

		InterviewType interviewType = new InterviewType();
		
		
		interviewType.setCode(code);		
		interviewType.setDescription(description);		
		interviewType.setDetailDescription(detailDescription);
	
		
		return interviewType;
	
		
	}
	
	protected InterviewType createIndexedInterviewType(String id, int version){

		InterviewType interviewType = new InterviewType();
		interviewType.setId(id);
		interviewType.setVersion(version);
		return interviewType;			
		
	}
	protected void checkParamsForRemovingInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		checkVersionOfInterviewType(userContext, interviewTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingInterviewType(userContext,retailStoreCountryCenterId, interviewTypeId, interviewTypeVersion,tokensExpr);
		
		InterviewType interviewType = createIndexedInterviewType(interviewTypeId, interviewTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeInterviewType( interviewType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		checkVersionOfInterviewType(userContext, interviewTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyInterviewTypeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingInterviewType(userContext,retailStoreCountryCenterId, interviewTypeId, interviewTypeVersion,tokensExpr);
		
		InterviewType interviewType = createIndexedInterviewType(interviewTypeId, interviewTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyInterviewTypeFrom( interviewType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfInterviewType(userContext, interviewTypeId, exception);
		checkVersionOfInterviewType(userContext, interviewTypeVersion, exception);
		

		if(InterviewType.CODE_PROPERTY.equals(property)){
			checkCodeOfInterviewType(userContext, parseString(newValueExpr), exception);
		}
		
		if(InterviewType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfInterviewType(userContext, parseString(newValueExpr), exception);
		}
		
		if(InterviewType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			checkDetailDescriptionOfInterviewType(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateInterviewType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingInterviewType(userContext, retailStoreCountryCenterId, interviewTypeId, interviewTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeInterviewType( interviewType );	
			//make changes to AcceleraterAccount.
			InterviewType interviewTypeIndex = createIndexedInterviewType(interviewTypeId, interviewTypeVersion);
		
			InterviewType interviewType = retailStoreCountryCenter.findTheInterviewType(interviewTypeIndex);
			if(interviewType == null){
				throw new RetailStoreCountryCenterManagerException(interviewType+"Not found" );
			}
			
			interviewType.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfTrainingCourseType(userContext,  code, exception);
		checkNameOfTrainingCourseType(userContext,  name, exception);
		checkDescriptionOfTrainingCourseType(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingTrainingCourseType(userContext,retailStoreCountryCenterId,code, name, description,tokensExpr);
		
		TrainingCourseType trainingCourseType = createTrainingCourseType(userContext,code, name, description);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTrainingCourseType( trainingCourseType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected TrainingCourseType createTrainingCourseType(RetailScmUserContext userContext, String code, String name, String description) throws Exception{

		TrainingCourseType trainingCourseType = new TrainingCourseType();
		
		
		trainingCourseType.setCode(code);		
		trainingCourseType.setName(name);		
		trainingCourseType.setDescription(description);
	
		
		return trainingCourseType;
	
		
	}
	
	protected TrainingCourseType createIndexedTrainingCourseType(String id, int version){

		TrainingCourseType trainingCourseType = new TrainingCourseType();
		trainingCourseType.setId(id);
		trainingCourseType.setVersion(version);
		return trainingCourseType;			
		
	}
	protected void checkParamsForRemovingTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		checkVersionOfTrainingCourseType(userContext, trainingCourseTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingTrainingCourseType(userContext,retailStoreCountryCenterId, trainingCourseTypeId, trainingCourseTypeVersion,tokensExpr);
		
		TrainingCourseType trainingCourseType = createIndexedTrainingCourseType(trainingCourseTypeId, trainingCourseTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTrainingCourseType( trainingCourseType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		checkVersionOfTrainingCourseType(userContext, trainingCourseTypeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyTrainingCourseTypeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingTrainingCourseType(userContext,retailStoreCountryCenterId, trainingCourseTypeId, trainingCourseTypeVersion,tokensExpr);
		
		TrainingCourseType trainingCourseType = createIndexedTrainingCourseType(trainingCourseTypeId, trainingCourseTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyTrainingCourseTypeFrom( trainingCourseType );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfTrainingCourseType(userContext, trainingCourseTypeId, exception);
		checkVersionOfTrainingCourseType(userContext, trainingCourseTypeVersion, exception);
		

		if(TrainingCourseType.CODE_PROPERTY.equals(property)){
			checkCodeOfTrainingCourseType(userContext, parseString(newValueExpr), exception);
		}
		
		if(TrainingCourseType.NAME_PROPERTY.equals(property)){
			checkNameOfTrainingCourseType(userContext, parseString(newValueExpr), exception);
		}
		
		if(TrainingCourseType.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfTrainingCourseType(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateTrainingCourseType(RetailScmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingTrainingCourseType(userContext, retailStoreCountryCenterId, trainingCourseTypeId, trainingCourseTypeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTrainingCourseType( trainingCourseType );	
			//make changes to AcceleraterAccount.
			TrainingCourseType trainingCourseTypeIndex = createIndexedTrainingCourseType(trainingCourseTypeId, trainingCourseTypeVersion);
		
			TrainingCourseType trainingCourseType = retailStoreCountryCenter.findTheTrainingCourseType(trainingCourseTypeIndex);
			if(trainingCourseType == null){
				throw new RetailStoreCountryCenterManagerException(trainingCourseType+"Not found" );
			}
			
			trainingCourseType.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingPublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkCodeOfPublicHoliday(userContext,  code, exception);
		checkNameOfPublicHoliday(userContext,  name, exception);
		checkDescriptionOfPublicHoliday(userContext,  description, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addPublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingPublicHoliday(userContext,retailStoreCountryCenterId,code, name, description,tokensExpr);
		
		PublicHoliday publicHoliday = createPublicHoliday(userContext,code, name, description);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addPublicHoliday( publicHoliday );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected PublicHoliday createPublicHoliday(RetailScmUserContext userContext, String code, String name, String description) throws Exception{

		PublicHoliday publicHoliday = new PublicHoliday();
		
		
		publicHoliday.setCode(code);		
		publicHoliday.setName(name);		
		publicHoliday.setDescription(description);
	
		
		return publicHoliday;
	
		
	}
	
	protected PublicHoliday createIndexedPublicHoliday(String id, int version){

		PublicHoliday publicHoliday = new PublicHoliday();
		publicHoliday.setId(id);
		publicHoliday.setVersion(version);
		return publicHoliday;			
		
	}
	protected void checkParamsForRemovingPublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfPublicHoliday(userContext, publicHolidayId, exception);
		checkVersionOfPublicHoliday(userContext, publicHolidayVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removePublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingPublicHoliday(userContext,retailStoreCountryCenterId, publicHolidayId, publicHolidayVersion,tokensExpr);
		
		PublicHoliday publicHoliday = createIndexedPublicHoliday(publicHolidayId, publicHolidayVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removePublicHoliday( publicHoliday );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingPublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfPublicHoliday(userContext, publicHolidayId, exception);
		checkVersionOfPublicHoliday(userContext, publicHolidayVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyPublicHolidayFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingPublicHoliday(userContext,retailStoreCountryCenterId, publicHolidayId, publicHolidayVersion,tokensExpr);
		
		PublicHoliday publicHoliday = createIndexedPublicHoliday(publicHolidayId, publicHolidayVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyPublicHolidayFrom( publicHoliday );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingPublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfPublicHoliday(userContext, publicHolidayId, exception);
		checkVersionOfPublicHoliday(userContext, publicHolidayVersion, exception);
		

		if(PublicHoliday.CODE_PROPERTY.equals(property)){
			checkCodeOfPublicHoliday(userContext, parseString(newValueExpr), exception);
		}
		
		if(PublicHoliday.NAME_PROPERTY.equals(property)){
			checkNameOfPublicHoliday(userContext, parseString(newValueExpr), exception);
		}
		
		if(PublicHoliday.DESCRIPTION_PROPERTY.equals(property)){
			checkDescriptionOfPublicHoliday(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updatePublicHoliday(RetailScmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingPublicHoliday(userContext, retailStoreCountryCenterId, publicHolidayId, publicHolidayVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removePublicHoliday( publicHoliday );	
			//make changes to AcceleraterAccount.
			PublicHoliday publicHolidayIndex = createIndexedPublicHoliday(publicHolidayId, publicHolidayVersion);
		
			PublicHoliday publicHoliday = retailStoreCountryCenter.findThePublicHoliday(publicHolidayIndex);
			if(publicHoliday == null){
				throw new RetailStoreCountryCenterManagerException(publicHoliday+"Not found" );
			}
			
			publicHoliday.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkTitleOfEmployee(userContext,  title, exception);		
		
		checkIdOfLevelThreeDepartment(userContext,  departmentId, exception);
		checkFamilyNameOfEmployee(userContext,  familyName, exception);
		checkGivenNameOfEmployee(userContext,  givenName, exception);
		checkEmailOfEmployee(userContext,  email, exception);
		checkCityOfEmployee(userContext,  city, exception);
		checkAddressOfEmployee(userContext,  address, exception);
		checkCellPhoneOfEmployee(userContext,  cellPhone, exception);		
		
		checkIdOfOccupationType(userContext,  occupationId, exception);		
		
		checkIdOfResponsibilityType(userContext,  responsibleForId, exception);		
		
		checkIdOfSalaryGrade(userContext,  currentSalaryGradeId, exception);
		checkSalaryAccountOfEmployee(userContext,  salaryAccount, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployee(userContext,retailStoreCountryCenterId,title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);
		
		Employee employee = createEmployee(userContext,title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addEmployee( employee );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected Employee createEmployee(RetailScmUserContext userContext, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		employee.setTitle(title);		
		LevelThreeDepartment  department = new LevelThreeDepartment();
		department.setId(departmentId);		
		employee.setDepartment(department);		
		employee.setFamilyName(familyName);		
		employee.setGivenName(givenName);		
		employee.setEmail(email);		
		employee.setCity(city);		
		employee.setAddress(address);		
		employee.setCellPhone(cellPhone);		
		OccupationType  occupation = new OccupationType();
		occupation.setId(occupationId);		
		employee.setOccupation(occupation);		
		ResponsibilityType  responsibleFor = new ResponsibilityType();
		responsibleFor.setId(responsibleForId);		
		employee.setResponsibleFor(responsibleFor);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employee.setCurrentSalaryGrade(currentSalaryGrade);		
		employee.setSalaryAccount(salaryAccount);
	
		
		return employee;
	
		
	}
	
	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;			
		
	}
	protected void checkParamsForRemovingEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployee(userContext,retailStoreCountryCenterId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeEmployee( employee );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyEmployeeFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployee(userContext,retailStoreCountryCenterId, employeeId, employeeVersion,tokensExpr);
		
		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyEmployeeFrom( employee );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfEmployee(userContext, employeeId, exception);
		checkVersionOfEmployee(userContext, employeeVersion, exception);
		

		if(Employee.TITLE_PROPERTY.equals(property)){
			checkTitleOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
			checkFamilyNameOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
			checkGivenNameOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
			checkEmailOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
			checkCityOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
			checkAddressOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
			checkCellPhoneOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
			checkSalaryAccountOfEmployee(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateEmployee(RetailScmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployee(userContext, retailStoreCountryCenterId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeEmployee( employee );	
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);
		
			Employee employee = retailStoreCountryCenter.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new RetailStoreCountryCenterManagerException(employee+"Not found" );
			}
			
			employee.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkTitleOfInstructor(userContext,  title, exception);
		checkFamilyNameOfInstructor(userContext,  familyName, exception);
		checkGivenNameOfInstructor(userContext,  givenName, exception);
		checkCellPhoneOfInstructor(userContext,  cellPhone, exception);
		checkEmailOfInstructor(userContext,  email, exception);
		checkIntroductionOfInstructor(userContext,  introduction, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingInstructor(userContext,retailStoreCountryCenterId,title, familyName, givenName, cellPhone, email, introduction,tokensExpr);
		
		Instructor instructor = createInstructor(userContext,title, familyName, givenName, cellPhone, email, introduction);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addInstructor( instructor );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected Instructor createInstructor(RetailScmUserContext userContext, String title, String familyName, String givenName, String cellPhone, String email, String introduction) throws Exception{

		Instructor instructor = new Instructor();
		
		
		instructor.setTitle(title);		
		instructor.setFamilyName(familyName);		
		instructor.setGivenName(givenName);		
		instructor.setCellPhone(cellPhone);		
		instructor.setEmail(email);		
		instructor.setIntroduction(introduction);
	
		
		return instructor;
	
		
	}
	
	protected Instructor createIndexedInstructor(String id, int version){

		Instructor instructor = new Instructor();
		instructor.setId(id);
		instructor.setVersion(version);
		return instructor;			
		
	}
	protected void checkParamsForRemovingInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfInstructor(userContext, instructorId, exception);
		checkVersionOfInstructor(userContext, instructorVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingInstructor(userContext,retailStoreCountryCenterId, instructorId, instructorVersion,tokensExpr);
		
		Instructor instructor = createIndexedInstructor(instructorId, instructorVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeInstructor( instructor );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfInstructor(userContext, instructorId, exception);
		checkVersionOfInstructor(userContext, instructorVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyInstructorFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingInstructor(userContext,retailStoreCountryCenterId, instructorId, instructorVersion,tokensExpr);
		
		Instructor instructor = createIndexedInstructor(instructorId, instructorVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyInstructorFrom( instructor );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfInstructor(userContext, instructorId, exception);
		checkVersionOfInstructor(userContext, instructorVersion, exception);
		

		if(Instructor.TITLE_PROPERTY.equals(property)){
			checkTitleOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		
		if(Instructor.FAMILY_NAME_PROPERTY.equals(property)){
			checkFamilyNameOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		
		if(Instructor.GIVEN_NAME_PROPERTY.equals(property)){
			checkGivenNameOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		
		if(Instructor.CELL_PHONE_PROPERTY.equals(property)){
			checkCellPhoneOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		
		if(Instructor.EMAIL_PROPERTY.equals(property)){
			checkEmailOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		
		if(Instructor.INTRODUCTION_PROPERTY.equals(property)){
			checkIntroductionOfInstructor(userContext, parseString(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateInstructor(RetailScmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingInstructor(userContext, retailStoreCountryCenterId, instructorId, instructorVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeInstructor( instructor );	
			//make changes to AcceleraterAccount.
			Instructor instructorIndex = createIndexedInstructor(instructorId, instructorVersion);
		
			Instructor instructor = retailStoreCountryCenter.findTheInstructor(instructorIndex);
			if(instructor == null){
				throw new RetailStoreCountryCenterManagerException(instructor+"Not found" );
			}
			
			instructor.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	


	protected void checkParamsForAddingCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{
		
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);

		checkTitleOfCompanyTraining(userContext,  title, exception);		
		
		checkIdOfInstructor(userContext,  instructorId, exception);		
		
		checkIdOfTrainingCourseType(userContext,  trainingCourseTypeId, exception);
		checkTimeStartOfCompanyTraining(userContext,  timeStart, exception);
		checkDurationHoursOfCompanyTraining(userContext,  durationHours, exception);
	
		throwExceptionIfHasErrors(userContext, exception);

	
	}
	public  RetailStoreCountryCenter addCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCompanyTraining(userContext,retailStoreCountryCenterId,title, instructorId, trainingCourseTypeId, timeStart, durationHours,tokensExpr);
		
		CompanyTraining companyTraining = createCompanyTraining(userContext,title, instructorId, trainingCourseTypeId, timeStart, durationHours);
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addCompanyTraining( companyTraining );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected CompanyTraining createCompanyTraining(RetailScmUserContext userContext, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours) throws Exception{

		CompanyTraining companyTraining = new CompanyTraining();
		
		
		companyTraining.setTitle(title);		
		Instructor  instructor = new Instructor();
		instructor.setId(instructorId);		
		companyTraining.setInstructor(instructor);		
		TrainingCourseType  trainingCourseType = new TrainingCourseType();
		trainingCourseType.setId(trainingCourseTypeId);		
		companyTraining.setTrainingCourseType(trainingCourseType);		
		companyTraining.setTimeStart(timeStart);		
		companyTraining.setDurationHours(durationHours);
	
		
		return companyTraining;
	
		
	}
	
	protected CompanyTraining createIndexedCompanyTraining(String id, int version){

		CompanyTraining companyTraining = new CompanyTraining();
		companyTraining.setId(id);
		companyTraining.setVersion(version);
		return companyTraining;			
		
	}
	protected void checkParamsForRemovingCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter removeCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCompanyTraining(userContext,retailStoreCountryCenterId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeCompanyTraining( companyTraining );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
		
	}
	protected void checkParamsForCopyingCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);

		throwExceptionIfHasErrors(userContext, exception);
	
	}
	public  RetailStoreCountryCenter copyCompanyTrainingFrom(RetailScmUserContext userContext, String retailStoreCountryCenterId, 
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCompanyTraining(userContext,retailStoreCountryCenterId, companyTrainingId, companyTrainingVersion,tokensExpr);
		
		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.copyCompanyTrainingFrom( companyTraining );		
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}	
		
	}
	
	protected void checkParamsForUpdatingCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		RetailStoreCountryCenterManagerException exception = new RetailStoreCountryCenterManagerException("Error Occured");
		
		checkIdOfRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, exception);
		checkIdOfCompanyTraining(userContext, companyTrainingId, exception);
		checkVersionOfCompanyTraining(userContext, companyTrainingVersion, exception);
		

		if(CompanyTraining.TITLE_PROPERTY.equals(property)){
			checkTitleOfCompanyTraining(userContext, parseString(newValueExpr), exception);
		}
		
		if(CompanyTraining.TIME_START_PROPERTY.equals(property)){
			checkTimeStartOfCompanyTraining(userContext, parseDate(newValueExpr), exception);
		}
		
		if(CompanyTraining.DURATION_HOURS_PROPERTY.equals(property)){
			checkDurationHoursOfCompanyTraining(userContext, parseInt(newValueExpr), exception);
		}
		
	
		throwExceptionIfHasErrors(userContext, exception);
	
	}
	
	public  RetailStoreCountryCenter updateCompanyTraining(RetailScmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCompanyTraining(userContext, retailStoreCountryCenterId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);
		
		
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		
		synchronized(retailStoreCountryCenter){ 
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeCompanyTraining( companyTraining );	
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIndex = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		
			CompanyTraining companyTraining = retailStoreCountryCenter.findTheCompanyTraining(companyTrainingIndex);
			if(companyTraining == null){
				throw new RetailStoreCountryCenterManagerException(companyTraining+"Not found" );
			}
			
			companyTraining.changePropery(property, newValueExpr);

			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	
	
	



}


