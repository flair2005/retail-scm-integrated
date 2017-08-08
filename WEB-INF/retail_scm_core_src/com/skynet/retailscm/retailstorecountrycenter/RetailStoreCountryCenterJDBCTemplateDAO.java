
package com.skynet.retailscm.retailstorecountrycenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
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

import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;
import com.skynet.retailscm.warehouse.WarehouseDAO;
import com.skynet.retailscm.employee.EmployeeDAO;
import com.skynet.retailscm.goodssupplier.GoodsSupplierDAO;
import com.skynet.retailscm.companytraining.CompanyTrainingDAO;
import com.skynet.retailscm.catalog.CatalogDAO;
import com.skynet.retailscm.occupationtype.OccupationTypeDAO;
import com.skynet.retailscm.retailstore.RetailStoreDAO;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseTypeDAO;
import com.skynet.retailscm.report.ReportDAO;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartmentDAO;
import com.skynet.retailscm.transportfleet.TransportFleetDAO;
import com.skynet.retailscm.skilltype.SkillTypeDAO;
import com.skynet.retailscm.terminationreason.TerminationReasonDAO;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.skynet.retailscm.instructor.InstructorDAO;
import com.skynet.retailscm.terminationtype.TerminationTypeDAO;
import com.skynet.retailscm.supplyorder.SupplyOrderDAO;
import com.skynet.retailscm.salarygrade.SalaryGradeDAO;
import com.skynet.retailscm.interviewtype.InterviewTypeDAO;
import com.skynet.retailscm.leavetype.LeaveTypeDAO;
import com.skynet.retailscm.responsibilitytype.ResponsibilityTypeDAO;
import com.skynet.retailscm.accountset.AccountSetDAO;
import com.skynet.retailscm.publicholiday.PublicHolidayDAO;

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


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreCountryCenterJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreCountryCenterDAO{

		
	
  	private  ReportDAO  reportDAO;
 	public void setReportDAO(ReportDAO pReportDAO){
 	
 		if(pReportDAO == null){
 			throw new IllegalStateException("Do not try to set reportDAO to null.");
 		}
	 	this.reportDAO = pReportDAO;
 	}
 	public ReportDAO getReportDAO(){
 		if(this.reportDAO == null){
 			throw new IllegalStateException("The reportDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.reportDAO;
 	}	
 	
			
		
	
  	private  CatalogDAO  catalogDAO;
 	public void setCatalogDAO(CatalogDAO pCatalogDAO){
 	
 		if(pCatalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = pCatalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The catalogDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.catalogDAO;
 	}	
 	
			
		
	
  	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO pRetailStoreProvinceCenterDAO){
 	
 		if(pRetailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreProvinceCenterDAO to null.");
 		}
	 	this.retailStoreProvinceCenterDAO = pRetailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
 		if(this.retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreProvinceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreProvinceCenterDAO;
 	}	
 	
			
		
	
  	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO pRetailStoreDAO){
 	
 		if(pRetailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = pRetailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}	
 	
			
		
	
  	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO pRetailStoreMemberDAO){
 	
 		if(pRetailStoreMemberDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberDAO to null.");
 		}
	 	this.retailStoreMemberDAO = pRetailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
 		if(this.retailStoreMemberDAO == null){
 			throw new IllegalStateException("The retailStoreMemberDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberDAO;
 	}	
 	
			
		
	
  	private  GoodsSupplierDAO  goodsSupplierDAO;
 	public void setGoodsSupplierDAO(GoodsSupplierDAO pGoodsSupplierDAO){
 	
 		if(pGoodsSupplierDAO == null){
 			throw new IllegalStateException("Do not try to set goodsSupplierDAO to null.");
 		}
	 	this.goodsSupplierDAO = pGoodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
 		if(this.goodsSupplierDAO == null){
 			throw new IllegalStateException("The goodsSupplierDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsSupplierDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO pSupplyOrderDAO){
 	
 		if(pSupplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = pSupplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	
 	
			
		
	
  	private  RetailStoreOrderDAO  retailStoreOrderDAO;
 	public void setRetailStoreOrderDAO(RetailStoreOrderDAO pRetailStoreOrderDAO){
 	
 		if(pRetailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = pRetailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}	
 	
			
		
	
  	private  WarehouseDAO  warehouseDAO;
 	public void setWarehouseDAO(WarehouseDAO pWarehouseDAO){
 	
 		if(pWarehouseDAO == null){
 			throw new IllegalStateException("Do not try to set warehouseDAO to null.");
 		}
	 	this.warehouseDAO = pWarehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
 		if(this.warehouseDAO == null){
 			throw new IllegalStateException("The warehouseDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.warehouseDAO;
 	}	
 	
			
		
	
  	private  TransportFleetDAO  transportFleetDAO;
 	public void setTransportFleetDAO(TransportFleetDAO pTransportFleetDAO){
 	
 		if(pTransportFleetDAO == null){
 			throw new IllegalStateException("Do not try to set transportFleetDAO to null.");
 		}
	 	this.transportFleetDAO = pTransportFleetDAO;
 	}
 	public TransportFleetDAO getTransportFleetDAO(){
 		if(this.transportFleetDAO == null){
 			throw new IllegalStateException("The transportFleetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportFleetDAO;
 	}	
 	
			
		
	
  	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO pAccountSetDAO){
 	
 		if(pAccountSetDAO == null){
 			throw new IllegalStateException("Do not try to set accountSetDAO to null.");
 		}
	 	this.accountSetDAO = pAccountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
 		if(this.accountSetDAO == null){
 			throw new IllegalStateException("The accountSetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountSetDAO;
 	}	
 	
			
		
	
  	private  LevelOneDepartmentDAO  levelOneDepartmentDAO;
 	public void setLevelOneDepartmentDAO(LevelOneDepartmentDAO pLevelOneDepartmentDAO){
 	
 		if(pLevelOneDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneDepartmentDAO to null.");
 		}
	 	this.levelOneDepartmentDAO = pLevelOneDepartmentDAO;
 	}
 	public LevelOneDepartmentDAO getLevelOneDepartmentDAO(){
 		if(this.levelOneDepartmentDAO == null){
 			throw new IllegalStateException("The levelOneDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.levelOneDepartmentDAO;
 	}	
 	
			
		
	
  	private  SkillTypeDAO  skillTypeDAO;
 	public void setSkillTypeDAO(SkillTypeDAO pSkillTypeDAO){
 	
 		if(pSkillTypeDAO == null){
 			throw new IllegalStateException("Do not try to set skillTypeDAO to null.");
 		}
	 	this.skillTypeDAO = pSkillTypeDAO;
 	}
 	public SkillTypeDAO getSkillTypeDAO(){
 		if(this.skillTypeDAO == null){
 			throw new IllegalStateException("The skillTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.skillTypeDAO;
 	}	
 	
			
		
	
  	private  ResponsibilityTypeDAO  responsibilityTypeDAO;
 	public void setResponsibilityTypeDAO(ResponsibilityTypeDAO pResponsibilityTypeDAO){
 	
 		if(pResponsibilityTypeDAO == null){
 			throw new IllegalStateException("Do not try to set responsibilityTypeDAO to null.");
 		}
	 	this.responsibilityTypeDAO = pResponsibilityTypeDAO;
 	}
 	public ResponsibilityTypeDAO getResponsibilityTypeDAO(){
 		if(this.responsibilityTypeDAO == null){
 			throw new IllegalStateException("The responsibilityTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.responsibilityTypeDAO;
 	}	
 	
			
		
	
  	private  TerminationReasonDAO  terminationReasonDAO;
 	public void setTerminationReasonDAO(TerminationReasonDAO pTerminationReasonDAO){
 	
 		if(pTerminationReasonDAO == null){
 			throw new IllegalStateException("Do not try to set terminationReasonDAO to null.");
 		}
	 	this.terminationReasonDAO = pTerminationReasonDAO;
 	}
 	public TerminationReasonDAO getTerminationReasonDAO(){
 		if(this.terminationReasonDAO == null){
 			throw new IllegalStateException("The terminationReasonDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.terminationReasonDAO;
 	}	
 	
			
		
	
  	private  TerminationTypeDAO  terminationTypeDAO;
 	public void setTerminationTypeDAO(TerminationTypeDAO pTerminationTypeDAO){
 	
 		if(pTerminationTypeDAO == null){
 			throw new IllegalStateException("Do not try to set terminationTypeDAO to null.");
 		}
	 	this.terminationTypeDAO = pTerminationTypeDAO;
 	}
 	public TerminationTypeDAO getTerminationTypeDAO(){
 		if(this.terminationTypeDAO == null){
 			throw new IllegalStateException("The terminationTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.terminationTypeDAO;
 	}	
 	
			
		
	
  	private  OccupationTypeDAO  occupationTypeDAO;
 	public void setOccupationTypeDAO(OccupationTypeDAO pOccupationTypeDAO){
 	
 		if(pOccupationTypeDAO == null){
 			throw new IllegalStateException("Do not try to set occupationTypeDAO to null.");
 		}
	 	this.occupationTypeDAO = pOccupationTypeDAO;
 	}
 	public OccupationTypeDAO getOccupationTypeDAO(){
 		if(this.occupationTypeDAO == null){
 			throw new IllegalStateException("The occupationTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.occupationTypeDAO;
 	}	
 	
			
		
	
  	private  LeaveTypeDAO  leaveTypeDAO;
 	public void setLeaveTypeDAO(LeaveTypeDAO pLeaveTypeDAO){
 	
 		if(pLeaveTypeDAO == null){
 			throw new IllegalStateException("Do not try to set leaveTypeDAO to null.");
 		}
	 	this.leaveTypeDAO = pLeaveTypeDAO;
 	}
 	public LeaveTypeDAO getLeaveTypeDAO(){
 		if(this.leaveTypeDAO == null){
 			throw new IllegalStateException("The leaveTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.leaveTypeDAO;
 	}	
 	
			
		
	
  	private  SalaryGradeDAO  salaryGradeDAO;
 	public void setSalaryGradeDAO(SalaryGradeDAO pSalaryGradeDAO){
 	
 		if(pSalaryGradeDAO == null){
 			throw new IllegalStateException("Do not try to set salaryGradeDAO to null.");
 		}
	 	this.salaryGradeDAO = pSalaryGradeDAO;
 	}
 	public SalaryGradeDAO getSalaryGradeDAO(){
 		if(this.salaryGradeDAO == null){
 			throw new IllegalStateException("The salaryGradeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.salaryGradeDAO;
 	}	
 	
			
		
	
  	private  InterviewTypeDAO  interviewTypeDAO;
 	public void setInterviewTypeDAO(InterviewTypeDAO pInterviewTypeDAO){
 	
 		if(pInterviewTypeDAO == null){
 			throw new IllegalStateException("Do not try to set interviewTypeDAO to null.");
 		}
	 	this.interviewTypeDAO = pInterviewTypeDAO;
 	}
 	public InterviewTypeDAO getInterviewTypeDAO(){
 		if(this.interviewTypeDAO == null){
 			throw new IllegalStateException("The interviewTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.interviewTypeDAO;
 	}	
 	
			
		
	
  	private  TrainingCourseTypeDAO  trainingCourseTypeDAO;
 	public void setTrainingCourseTypeDAO(TrainingCourseTypeDAO pTrainingCourseTypeDAO){
 	
 		if(pTrainingCourseTypeDAO == null){
 			throw new IllegalStateException("Do not try to set trainingCourseTypeDAO to null.");
 		}
	 	this.trainingCourseTypeDAO = pTrainingCourseTypeDAO;
 	}
 	public TrainingCourseTypeDAO getTrainingCourseTypeDAO(){
 		if(this.trainingCourseTypeDAO == null){
 			throw new IllegalStateException("The trainingCourseTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.trainingCourseTypeDAO;
 	}	
 	
			
		
	
  	private  PublicHolidayDAO  publicHolidayDAO;
 	public void setPublicHolidayDAO(PublicHolidayDAO pPublicHolidayDAO){
 	
 		if(pPublicHolidayDAO == null){
 			throw new IllegalStateException("Do not try to set publicHolidayDAO to null.");
 		}
	 	this.publicHolidayDAO = pPublicHolidayDAO;
 	}
 	public PublicHolidayDAO getPublicHolidayDAO(){
 		if(this.publicHolidayDAO == null){
 			throw new IllegalStateException("The publicHolidayDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.publicHolidayDAO;
 	}	
 	
			
		
	
  	private  EmployeeDAO  employeeDAO;
 	public void setEmployeeDAO(EmployeeDAO pEmployeeDAO){
 	
 		if(pEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = pEmployeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.employeeDAO;
 	}	
 	
			
		
	
  	private  InstructorDAO  instructorDAO;
 	public void setInstructorDAO(InstructorDAO pInstructorDAO){
 	
 		if(pInstructorDAO == null){
 			throw new IllegalStateException("Do not try to set instructorDAO to null.");
 		}
	 	this.instructorDAO = pInstructorDAO;
 	}
 	public InstructorDAO getInstructorDAO(){
 		if(this.instructorDAO == null){
 			throw new IllegalStateException("The instructorDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.instructorDAO;
 	}	
 	
			
		
	
  	private  CompanyTrainingDAO  companyTrainingDAO;
 	public void setCompanyTrainingDAO(CompanyTrainingDAO pCompanyTrainingDAO){
 	
 		if(pCompanyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set companyTrainingDAO to null.");
 		}
	 	this.companyTrainingDAO = pCompanyTrainingDAO;
 	}
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
 		if(this.companyTrainingDAO == null){
 			throw new IllegalStateException("The companyTrainingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.companyTrainingDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreCountryCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCountryCenter(accessKey, options);
	}
	*/
	public RetailStoreCountryCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCountryCenter(RetailStoreCountryCenterTable.withId(id), options);
	}
	
	
	
	public RetailStoreCountryCenter save(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options){
		
		String methodName="save(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreCountryCenter, methodName, "retailStoreCountryCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreCountryCenter(retailStoreCountryCenter,options);
	}
	public RetailStoreCountryCenter clone(String retailStoreCountryCenterId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreCountryCenterTable.withId(retailStoreCountryCenterId),options);
	}
	
	protected RetailStoreCountryCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreCountryCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreCountryCenter newRetailStoreCountryCenter = loadInternalRetailStoreCountryCenter(accessKey, options);
		newRetailStoreCountryCenter.setVersion(0);
		
		
 		
 		if(isSaveReportListEnabled(options)){
 			for(Report item: newRetailStoreCountryCenter.getReportList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCatalogListEnabled(options)){
 			for(Catalog item: newRetailStoreCountryCenter.getCatalogList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreProvinceCenterListEnabled(options)){
 			for(RetailStoreProvinceCenter item: newRetailStoreCountryCenter.getRetailStoreProvinceCenterList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreCountryCenter.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreMemberListEnabled(options)){
 			for(RetailStoreMember item: newRetailStoreCountryCenter.getRetailStoreMemberList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveGoodsSupplierListEnabled(options)){
 			for(GoodsSupplier item: newRetailStoreCountryCenter.getGoodsSupplierList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newRetailStoreCountryCenter.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreCountryCenter.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveWarehouseListEnabled(options)){
 			for(Warehouse item: newRetailStoreCountryCenter.getWarehouseList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportFleetListEnabled(options)){
 			for(TransportFleet item: newRetailStoreCountryCenter.getTransportFleetList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountSetListEnabled(options)){
 			for(AccountSet item: newRetailStoreCountryCenter.getAccountSetList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveLevelOneDepartmentListEnabled(options)){
 			for(LevelOneDepartment item: newRetailStoreCountryCenter.getLevelOneDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSkillTypeListEnabled(options)){
 			for(SkillType item: newRetailStoreCountryCenter.getSkillTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveResponsibilityTypeListEnabled(options)){
 			for(ResponsibilityType item: newRetailStoreCountryCenter.getResponsibilityTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTerminationReasonListEnabled(options)){
 			for(TerminationReason item: newRetailStoreCountryCenter.getTerminationReasonList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTerminationTypeListEnabled(options)){
 			for(TerminationType item: newRetailStoreCountryCenter.getTerminationTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveOccupationTypeListEnabled(options)){
 			for(OccupationType item: newRetailStoreCountryCenter.getOccupationTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveLeaveTypeListEnabled(options)){
 			for(LeaveType item: newRetailStoreCountryCenter.getLeaveTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSalaryGradeListEnabled(options)){
 			for(SalaryGrade item: newRetailStoreCountryCenter.getSalaryGradeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveInterviewTypeListEnabled(options)){
 			for(InterviewType item: newRetailStoreCountryCenter.getInterviewTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTrainingCourseTypeListEnabled(options)){
 			for(TrainingCourseType item: newRetailStoreCountryCenter.getTrainingCourseTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePublicHolidayListEnabled(options)){
 			for(PublicHoliday item: newRetailStoreCountryCenter.getPublicHolidayList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newRetailStoreCountryCenter.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveInstructorListEnabled(options)){
 			for(Instructor item: newRetailStoreCountryCenter.getInstructorList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCompanyTrainingListEnabled(options)){
 			for(CompanyTraining item: newRetailStoreCountryCenter.getCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreCountryCenter(newRetailStoreCountryCenter,options);
		
		return newRetailStoreCountryCenter;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreCountryCenterId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreCountryCenterId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreCountryCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreCountryCenterNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreCountryCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreCountryCenterId, int version) throws Exception{
	
		String methodName="delete(String retailStoreCountryCenterId, int version)";
		assertMethodArgumentNotNull(retailStoreCountryCenterId, methodName, "retailStoreCountryCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreCountryCenterId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreCountryCenterId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","service_number","founded","web_site","address","operated_by","legal_representative","description"};
		return RetailStoreCountryCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_country_center";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreCountryCenterTokens.checkOptions(options, optionToCheck);
	
	}


		
	//protected static final String REPORT_LIST = "reportList";
	
	protected boolean isExtractReportListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.REPORT_LIST);
		
 	}

	protected boolean isSaveReportListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.REPORT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String CATALOG_LIST = "catalogList";
	
	protected boolean isExtractCatalogListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.CATALOG_LIST);
		
 	}

	protected boolean isSaveCatalogListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.CATALOG_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_PROVINCE_CENTER_LIST = "retailStoreProvinceCenterList";
	
	protected boolean isExtractRetailStoreProvinceCenterListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_PROVINCE_CENTER_LIST);
		
 	}

	protected boolean isSaveRetailStoreProvinceCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_PROVINCE_CENTER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_LIST = "retailStoreList";
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_MEMBER_LIST = "retailStoreMemberList";
	
	protected boolean isExtractRetailStoreMemberListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_MEMBER_LIST);
		
 	}

	protected boolean isSaveRetailStoreMemberListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_MEMBER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String GOODS_SUPPLIER_LIST = "goodsSupplierList";
	
	protected boolean isExtractGoodsSupplierListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.GOODS_SUPPLIER_LIST);
		
 	}

	protected boolean isSaveGoodsSupplierListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.GOODS_SUPPLIER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_ORDER_LIST);
		
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String WAREHOUSE_LIST = "warehouseList";
	
	protected boolean isExtractWarehouseListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.WAREHOUSE_LIST);
		
 	}

	protected boolean isSaveWarehouseListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.WAREHOUSE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TRANSPORT_FLEET_LIST = "transportFleetList";
	
	protected boolean isExtractTransportFleetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.TRANSPORT_FLEET_LIST);
		
 	}

	protected boolean isSaveTransportFleetListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TRANSPORT_FLEET_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ACCOUNT_SET_LIST = "accountSetList";
	
	protected boolean isExtractAccountSetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.ACCOUNT_SET_LIST);
		
 	}

	protected boolean isSaveAccountSetListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.ACCOUNT_SET_LIST);
		
 	}
 	
 	
			
		
	//protected static final String LEVEL_ONE_DEPARTMENT_LIST = "levelOneDepartmentList";
	
	protected boolean isExtractLevelOneDepartmentListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.LEVEL_ONE_DEPARTMENT_LIST);
		
 	}

	protected boolean isSaveLevelOneDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.LEVEL_ONE_DEPARTMENT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SKILL_TYPE_LIST = "skillTypeList";
	
	protected boolean isExtractSkillTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.SKILL_TYPE_LIST);
		
 	}

	protected boolean isSaveSkillTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.SKILL_TYPE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RESPONSIBILITY_TYPE_LIST = "responsibilityTypeList";
	
	protected boolean isExtractResponsibilityTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.RESPONSIBILITY_TYPE_LIST);
		
 	}

	protected boolean isSaveResponsibilityTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RESPONSIBILITY_TYPE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TERMINATION_REASON_LIST = "terminationReasonList";
	
	protected boolean isExtractTerminationReasonListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.TERMINATION_REASON_LIST);
		
 	}

	protected boolean isSaveTerminationReasonListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TERMINATION_REASON_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TERMINATION_TYPE_LIST = "terminationTypeList";
	
	protected boolean isExtractTerminationTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.TERMINATION_TYPE_LIST);
		
 	}

	protected boolean isSaveTerminationTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TERMINATION_TYPE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String OCCUPATION_TYPE_LIST = "occupationTypeList";
	
	protected boolean isExtractOccupationTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.OCCUPATION_TYPE_LIST);
		
 	}

	protected boolean isSaveOccupationTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.OCCUPATION_TYPE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String LEAVE_TYPE_LIST = "leaveTypeList";
	
	protected boolean isExtractLeaveTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.LEAVE_TYPE_LIST);
		
 	}

	protected boolean isSaveLeaveTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.LEAVE_TYPE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SALARY_GRADE_LIST = "salaryGradeList";
	
	protected boolean isExtractSalaryGradeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.SALARY_GRADE_LIST);
		
 	}

	protected boolean isSaveSalaryGradeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.SALARY_GRADE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String INTERVIEW_TYPE_LIST = "interviewTypeList";
	
	protected boolean isExtractInterviewTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.INTERVIEW_TYPE_LIST);
		
 	}

	protected boolean isSaveInterviewTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.INTERVIEW_TYPE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String TRAINING_COURSE_TYPE_LIST = "trainingCourseTypeList";
	
	protected boolean isExtractTrainingCourseTypeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.TRAINING_COURSE_TYPE_LIST);
		
 	}

	protected boolean isSaveTrainingCourseTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TRAINING_COURSE_TYPE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String PUBLIC_HOLIDAY_LIST = "publicHolidayList";
	
	protected boolean isExtractPublicHolidayListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.PUBLIC_HOLIDAY_LIST);
		
 	}

	protected boolean isSavePublicHolidayListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.PUBLIC_HOLIDAY_LIST);
		
 	}
 	
 	
			
		
	//protected static final String EMPLOYEE_LIST = "employeeList";
	
	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.EMPLOYEE_LIST);
		
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.EMPLOYEE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String INSTRUCTOR_LIST = "instructorList";
	
	protected boolean isExtractInstructorListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.INSTRUCTOR_LIST);
		
 	}

	protected boolean isSaveInstructorListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.INSTRUCTOR_LIST);
		
 	}
 	
 	
			
		
	//protected static final String COMPANY_TRAINING_LIST = "companyTrainingList";
	
	protected boolean isExtractCompanyTrainingListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCountryCenterTokens.COMPANY_TRAINING_LIST);
		
 	}

	protected boolean isSaveCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.COMPANY_TRAINING_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreCountryCenterMapper getRetailStoreCountryCenterMapper(){
		return new RetailStoreCountryCenterMapper();
	}
	protected RetailStoreCountryCenter extractRetailStoreCountryCenter(String retailStoreCountryCenterId) throws Exception{
		String SQL = "select * from retail_store_country_center_data where id = ?";	
		try{
		
			RetailStoreCountryCenter retailStoreCountryCenter = queryForObject(SQL, new Object[]{retailStoreCountryCenterId}, getRetailStoreCountryCenterMapper());
			return retailStoreCountryCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCountryCenterNotFoundException("RetailStoreCountryCenter("+retailStoreCountryCenterId+") is not found!");
		}
		
		
	}
	protected RetailStoreCountryCenter extractRetailStoreCountryCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_country_center_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreCountryCenter retailStoreCountryCenter = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreCountryCenterMapper());
			return retailStoreCountryCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCountryCenterNotFoundException("RetailStoreCountryCenter("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreCountryCenter loadInternalRetailStoreCountryCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreCountryCenter retailStoreCountryCenter = extractRetailStoreCountryCenter(accessKey, loadOptions);

		
		if(isExtractReportListEnabled(loadOptions)){
	 		extractReportList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractCatalogListEnabled(loadOptions)){
	 		extractCatalogList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractRetailStoreProvinceCenterListEnabled(loadOptions)){
	 		extractRetailStoreProvinceCenterList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractRetailStoreMemberListEnabled(loadOptions)){
	 		extractRetailStoreMemberList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractGoodsSupplierListEnabled(loadOptions)){
	 		extractGoodsSupplierList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractWarehouseListEnabled(loadOptions)){
	 		extractWarehouseList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractTransportFleetListEnabled(loadOptions)){
	 		extractTransportFleetList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractAccountSetListEnabled(loadOptions)){
	 		extractAccountSetList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractLevelOneDepartmentListEnabled(loadOptions)){
	 		extractLevelOneDepartmentList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractSkillTypeListEnabled(loadOptions)){
	 		extractSkillTypeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractResponsibilityTypeListEnabled(loadOptions)){
	 		extractResponsibilityTypeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractTerminationReasonListEnabled(loadOptions)){
	 		extractTerminationReasonList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractTerminationTypeListEnabled(loadOptions)){
	 		extractTerminationTypeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractOccupationTypeListEnabled(loadOptions)){
	 		extractOccupationTypeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractLeaveTypeListEnabled(loadOptions)){
	 		extractLeaveTypeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractSalaryGradeListEnabled(loadOptions)){
	 		extractSalaryGradeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractInterviewTypeListEnabled(loadOptions)){
	 		extractInterviewTypeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractTrainingCourseTypeListEnabled(loadOptions)){
	 		extractTrainingCourseTypeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractPublicHolidayListEnabled(loadOptions)){
	 		extractPublicHolidayList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractInstructorListEnabled(loadOptions)){
	 		extractInstructorList(retailStoreCountryCenter, loadOptions);
 		}		
		
		if(isExtractCompanyTrainingListEnabled(loadOptions)){
	 		extractCompanyTrainingList(retailStoreCountryCenter, loadOptions);
 		}		
		
		return retailStoreCountryCenter;
		
	}



	
	
	
		
	protected RetailStoreCountryCenter extractReportList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<Report> reportList = getReportDAO().findReportByOwner(retailStoreCountryCenter.getId(),options);
		if(reportList != null){
			retailStoreCountryCenter.setReportList(reportList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<Catalog> catalogList = getCatalogDAO().findCatalogByOwner(retailStoreCountryCenter.getId(),options);
		if(catalogList != null){
			retailStoreCountryCenter.setCatalogList(catalogList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = getRetailStoreProvinceCenterDAO().findRetailStoreProvinceCenterByCountry(retailStoreCountryCenter.getId(),options);
		if(retailStoreProvinceCenterList != null){
			retailStoreCountryCenter.setRetailStoreProvinceCenterList(retailStoreProvinceCenterList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByRetailStoreCountryCenter(retailStoreCountryCenter.getId(),options);
		if(retailStoreList != null){
			retailStoreCountryCenter.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<RetailStoreMember> retailStoreMemberList = getRetailStoreMemberDAO().findRetailStoreMemberByOwner(retailStoreCountryCenter.getId(),options);
		if(retailStoreMemberList != null){
			retailStoreCountryCenter.setRetailStoreMemberList(retailStoreMemberList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<GoodsSupplier> goodsSupplierList = getGoodsSupplierDAO().findGoodsSupplierByBelongTo(retailStoreCountryCenter.getId(),options);
		if(goodsSupplierList != null){
			retailStoreCountryCenter.setGoodsSupplierList(goodsSupplierList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByBuyer(retailStoreCountryCenter.getId(),options);
		if(supplyOrderList != null){
			retailStoreCountryCenter.setSupplyOrderList(supplyOrderList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderBySeller(retailStoreCountryCenter.getId(),options);
		if(retailStoreOrderList != null){
			retailStoreCountryCenter.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<Warehouse> warehouseList = getWarehouseDAO().findWarehouseByOwner(retailStoreCountryCenter.getId(),options);
		if(warehouseList != null){
			retailStoreCountryCenter.setWarehouseList(warehouseList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<TransportFleet> transportFleetList = getTransportFleetDAO().findTransportFleetByOwner(retailStoreCountryCenter.getId(),options);
		if(transportFleetList != null){
			retailStoreCountryCenter.setTransportFleetList(transportFleetList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<AccountSet> accountSetList = getAccountSetDAO().findAccountSetByCountryCenter(retailStoreCountryCenter.getId(),options);
		if(accountSetList != null){
			retailStoreCountryCenter.setAccountSetList(accountSetList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<LevelOneDepartment> levelOneDepartmentList = getLevelOneDepartmentDAO().findLevelOneDepartmentByBelongsTo(retailStoreCountryCenter.getId(),options);
		if(levelOneDepartmentList != null){
			retailStoreCountryCenter.setLevelOneDepartmentList(levelOneDepartmentList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<SkillType> skillTypeList = getSkillTypeDAO().findSkillTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(skillTypeList != null){
			retailStoreCountryCenter.setSkillTypeList(skillTypeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<ResponsibilityType> responsibilityTypeList = getResponsibilityTypeDAO().findResponsibilityTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(responsibilityTypeList != null){
			retailStoreCountryCenter.setResponsibilityTypeList(responsibilityTypeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<TerminationReason> terminationReasonList = getTerminationReasonDAO().findTerminationReasonByCompany(retailStoreCountryCenter.getId(),options);
		if(terminationReasonList != null){
			retailStoreCountryCenter.setTerminationReasonList(terminationReasonList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<TerminationType> terminationTypeList = getTerminationTypeDAO().findTerminationTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(terminationTypeList != null){
			retailStoreCountryCenter.setTerminationTypeList(terminationTypeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<OccupationType> occupationTypeList = getOccupationTypeDAO().findOccupationTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(occupationTypeList != null){
			retailStoreCountryCenter.setOccupationTypeList(occupationTypeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<LeaveType> leaveTypeList = getLeaveTypeDAO().findLeaveTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(leaveTypeList != null){
			retailStoreCountryCenter.setLeaveTypeList(leaveTypeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<SalaryGrade> salaryGradeList = getSalaryGradeDAO().findSalaryGradeByCompany(retailStoreCountryCenter.getId(),options);
		if(salaryGradeList != null){
			retailStoreCountryCenter.setSalaryGradeList(salaryGradeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<InterviewType> interviewTypeList = getInterviewTypeDAO().findInterviewTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(interviewTypeList != null){
			retailStoreCountryCenter.setInterviewTypeList(interviewTypeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<TrainingCourseType> trainingCourseTypeList = getTrainingCourseTypeDAO().findTrainingCourseTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(trainingCourseTypeList != null){
			retailStoreCountryCenter.setTrainingCourseTypeList(trainingCourseTypeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractPublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<PublicHoliday> publicHolidayList = getPublicHolidayDAO().findPublicHolidayByCompany(retailStoreCountryCenter.getId(),options);
		if(publicHolidayList != null){
			retailStoreCountryCenter.setPublicHolidayList(publicHolidayList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByCompany(retailStoreCountryCenter.getId(),options);
		if(employeeList != null){
			retailStoreCountryCenter.setEmployeeList(employeeList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<Instructor> instructorList = getInstructorDAO().findInstructorByCompany(retailStoreCountryCenter.getId(),options);
		if(instructorList != null){
			retailStoreCountryCenter.setInstructorList(instructorList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
	protected RetailStoreCountryCenter extractCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		SmartList<CompanyTraining> companyTrainingList = getCompanyTrainingDAO().findCompanyTrainingByCompany(retailStoreCountryCenter.getId(),options);
		if(companyTrainingList != null){
			retailStoreCountryCenter.setCompanyTrainingList(companyTrainingList);
		}
		
		return retailStoreCountryCenter;
	
	}	
		
		
 	
		
		
		

	

	protected RetailStoreCountryCenter saveRetailStoreCountryCenter(RetailStoreCountryCenter  retailStoreCountryCenter){
	
		String SQL=this.getSaveRetailStoreCountryCenterSQL(retailStoreCountryCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreCountryCenterParameters(retailStoreCountryCenter);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreCountryCenter.incVersion();
		return retailStoreCountryCenter;
	
	}
	public SmartList<RetailStoreCountryCenter> saveRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreCountryCenterList(retailStoreCountryCenterList);
		
		batchRetailStoreCountryCenterCreate((List<RetailStoreCountryCenter>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreCountryCenterUpdate((List<RetailStoreCountryCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreCountryCenter retailStoreCountryCenter:retailStoreCountryCenterList){
			if(retailStoreCountryCenter.isChanged()){
				retailStoreCountryCenter.incVersion();
			}
			
		
		}
		
		
		return retailStoreCountryCenterList;
	}

	public SmartList<RetailStoreCountryCenter> removeRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options){
		
		
		super.removeList(retailStoreCountryCenterList, options);
		
		return retailStoreCountryCenterList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreCountryCenterBatchCreateArgs(List<RetailStoreCountryCenter> retailStoreCountryCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCountryCenter retailStoreCountryCenter:retailStoreCountryCenterList ){
			Object [] parameters = prepareRetailStoreCountryCenterCreateParameters(retailStoreCountryCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreCountryCenterBatchUpdateArgs(List<RetailStoreCountryCenter> retailStoreCountryCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCountryCenter retailStoreCountryCenter:retailStoreCountryCenterList ){
			if(!retailStoreCountryCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreCountryCenterUpdateParameters(retailStoreCountryCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreCountryCenterCreate(List<RetailStoreCountryCenter> retailStoreCountryCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreCountryCenterBatchCreateArgs(retailStoreCountryCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreCountryCenterUpdate(List<RetailStoreCountryCenter> retailStoreCountryCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreCountryCenterBatchUpdateArgs(retailStoreCountryCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreCountryCenterList(List<RetailStoreCountryCenter> retailStoreCountryCenterList){
		
		List<RetailStoreCountryCenter> retailStoreCountryCenterCreateList=new ArrayList<RetailStoreCountryCenter>();
		List<RetailStoreCountryCenter> retailStoreCountryCenterUpdateList=new ArrayList<RetailStoreCountryCenter>();
		
		for(RetailStoreCountryCenter retailStoreCountryCenter: retailStoreCountryCenterList){
			if(isUpdateRequest(retailStoreCountryCenter)){
				retailStoreCountryCenterUpdateList.add( retailStoreCountryCenter);
				continue;
			}
			retailStoreCountryCenterCreateList.add(retailStoreCountryCenter);
		}
		
		return new Object[]{retailStoreCountryCenterCreateList,retailStoreCountryCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreCountryCenter retailStoreCountryCenter){
 		return retailStoreCountryCenter.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreCountryCenterSQL(RetailStoreCountryCenter retailStoreCountryCenter){
 		if(isUpdateRequest(retailStoreCountryCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreCountryCenterParameters(RetailStoreCountryCenter retailStoreCountryCenter){
 		if(isUpdateRequest(retailStoreCountryCenter) ){
 			return prepareRetailStoreCountryCenterUpdateParameters(retailStoreCountryCenter);
 		}
 		return prepareRetailStoreCountryCenterCreateParameters(retailStoreCountryCenter);
 	}
 	protected Object[] prepareRetailStoreCountryCenterUpdateParameters(RetailStoreCountryCenter retailStoreCountryCenter){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = retailStoreCountryCenter.getName();
 		parameters[1] = retailStoreCountryCenter.getServiceNumber();
 		parameters[2] = retailStoreCountryCenter.getFounded();
 		parameters[3] = retailStoreCountryCenter.getWebSite();
 		parameters[4] = retailStoreCountryCenter.getAddress();
 		parameters[5] = retailStoreCountryCenter.getOperatedBy();
 		parameters[6] = retailStoreCountryCenter.getLegalRepresentative();
 		parameters[7] = retailStoreCountryCenter.getDescription();		
 		parameters[8] = retailStoreCountryCenter.getId();
 		parameters[9] = retailStoreCountryCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCountryCenterCreateParameters(RetailStoreCountryCenter retailStoreCountryCenter){
		Object[] parameters = new Object[9];
		String newRetailStoreCountryCenterId=getNextId();
		retailStoreCountryCenter.setId(newRetailStoreCountryCenterId);
		parameters[0] =  retailStoreCountryCenter.getId();
 
 		parameters[1] = retailStoreCountryCenter.getName();
 		parameters[2] = retailStoreCountryCenter.getServiceNumber();
 		parameters[3] = retailStoreCountryCenter.getFounded();
 		parameters[4] = retailStoreCountryCenter.getWebSite();
 		parameters[5] = retailStoreCountryCenter.getAddress();
 		parameters[6] = retailStoreCountryCenter.getOperatedBy();
 		parameters[7] = retailStoreCountryCenter.getLegalRepresentative();
 		parameters[8] = retailStoreCountryCenter.getDescription();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreCountryCenter saveInternalRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		
		saveRetailStoreCountryCenter(retailStoreCountryCenter);

		
		if(isSaveReportListEnabled(options)){
	 		saveReportList(retailStoreCountryCenter, options);
	 		removeReportList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveCatalogListEnabled(options)){
	 		saveCatalogList(retailStoreCountryCenter, options);
	 		removeCatalogList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveRetailStoreProvinceCenterListEnabled(options)){
	 		saveRetailStoreProvinceCenterList(retailStoreCountryCenter, options);
	 		removeRetailStoreProvinceCenterList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreCountryCenter, options);
	 		removeRetailStoreList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveRetailStoreMemberListEnabled(options)){
	 		saveRetailStoreMemberList(retailStoreCountryCenter, options);
	 		removeRetailStoreMemberList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveGoodsSupplierListEnabled(options)){
	 		saveGoodsSupplierList(retailStoreCountryCenter, options);
	 		removeGoodsSupplierList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(retailStoreCountryCenter, options);
	 		removeSupplyOrderList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreCountryCenter, options);
	 		removeRetailStoreOrderList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveWarehouseListEnabled(options)){
	 		saveWarehouseList(retailStoreCountryCenter, options);
	 		removeWarehouseList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveTransportFleetListEnabled(options)){
	 		saveTransportFleetList(retailStoreCountryCenter, options);
	 		removeTransportFleetList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveAccountSetListEnabled(options)){
	 		saveAccountSetList(retailStoreCountryCenter, options);
	 		removeAccountSetList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveLevelOneDepartmentListEnabled(options)){
	 		saveLevelOneDepartmentList(retailStoreCountryCenter, options);
	 		removeLevelOneDepartmentList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveSkillTypeListEnabled(options)){
	 		saveSkillTypeList(retailStoreCountryCenter, options);
	 		removeSkillTypeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveResponsibilityTypeListEnabled(options)){
	 		saveResponsibilityTypeList(retailStoreCountryCenter, options);
	 		removeResponsibilityTypeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveTerminationReasonListEnabled(options)){
	 		saveTerminationReasonList(retailStoreCountryCenter, options);
	 		removeTerminationReasonList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveTerminationTypeListEnabled(options)){
	 		saveTerminationTypeList(retailStoreCountryCenter, options);
	 		removeTerminationTypeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveOccupationTypeListEnabled(options)){
	 		saveOccupationTypeList(retailStoreCountryCenter, options);
	 		removeOccupationTypeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveLeaveTypeListEnabled(options)){
	 		saveLeaveTypeList(retailStoreCountryCenter, options);
	 		removeLeaveTypeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveSalaryGradeListEnabled(options)){
	 		saveSalaryGradeList(retailStoreCountryCenter, options);
	 		removeSalaryGradeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveInterviewTypeListEnabled(options)){
	 		saveInterviewTypeList(retailStoreCountryCenter, options);
	 		removeInterviewTypeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveTrainingCourseTypeListEnabled(options)){
	 		saveTrainingCourseTypeList(retailStoreCountryCenter, options);
	 		removeTrainingCourseTypeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSavePublicHolidayListEnabled(options)){
	 		savePublicHolidayList(retailStoreCountryCenter, options);
	 		removePublicHolidayList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(retailStoreCountryCenter, options);
	 		removeEmployeeList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveInstructorListEnabled(options)){
	 		saveInstructorList(retailStoreCountryCenter, options);
	 		removeInstructorList(retailStoreCountryCenter, options);
	 		
 		}		
		
		if(isSaveCompanyTrainingListEnabled(options)){
	 		saveCompanyTrainingList(retailStoreCountryCenter, options);
	 		removeCompanyTrainingList(retailStoreCountryCenter, options);
	 		
 		}		
		
		return retailStoreCountryCenter;
		
	}
	
	
	
	//======================================================================================
	
		
	protected RetailStoreCountryCenter saveReportList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<Report> reportList = retailStoreCountryCenter.getReportList();
		if(reportList == null){
			return retailStoreCountryCenter;
		}
		if(reportList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getReportDAO().saveReportList(reportList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeReportList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<Report> reportList = retailStoreCountryCenter.getReportList();
		if(reportList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<Report> toRemoveReportList = reportList.getToRemoveList();
		
		if(toRemoveReportList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveReportList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getReportDAO().removeReportList(toRemoveReportList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
		if(catalogList == null){
			return retailStoreCountryCenter;
		}
		if(catalogList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCatalogDAO().saveCatalogList(catalogList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
		if(catalogList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<Catalog> toRemoveCatalogList = catalogList.getToRemoveList();
		
		if(toRemoveCatalogList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveCatalogList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCatalogDAO().removeCatalogList(toRemoveCatalogList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
		if(retailStoreProvinceCenterList == null){
			return retailStoreCountryCenter;
		}
		if(retailStoreProvinceCenterList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreProvinceCenterDAO().saveRetailStoreProvinceCenterList(retailStoreProvinceCenterList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
		if(retailStoreProvinceCenterList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<RetailStoreProvinceCenter> toRemoveRetailStoreProvinceCenterList = retailStoreProvinceCenterList.getToRemoveList();
		
		if(toRemoveRetailStoreProvinceCenterList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreProvinceCenterList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreProvinceCenterDAO().removeRetailStoreProvinceCenterList(toRemoveRetailStoreProvinceCenterList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(retailStoreList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreDAO().saveRetailStoreList(retailStoreList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
		if(retailStoreMemberList == null){
			return retailStoreCountryCenter;
		}
		if(retailStoreMemberList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreMemberDAO().saveRetailStoreMemberList(retailStoreMemberList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
		if(retailStoreMemberList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<RetailStoreMember> toRemoveRetailStoreMemberList = retailStoreMemberList.getToRemoveList();
		
		if(toRemoveRetailStoreMemberList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreMemberList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreMemberDAO().removeRetailStoreMemberList(toRemoveRetailStoreMemberList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
		if(goodsSupplierList == null){
			return retailStoreCountryCenter;
		}
		if(goodsSupplierList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getGoodsSupplierDAO().saveGoodsSupplierList(goodsSupplierList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
		if(goodsSupplierList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<GoodsSupplier> toRemoveGoodsSupplierList = goodsSupplierList.getToRemoveList();
		
		if(toRemoveGoodsSupplierList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveGoodsSupplierList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsSupplierDAO().removeGoodsSupplierList(toRemoveGoodsSupplierList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		if(supplyOrderList == null){
			return retailStoreCountryCenter;
		}
		if(supplyOrderList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		if(supplyOrderList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreCountryCenter;
		}
		if(retailStoreOrderList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreOrderDAO().saveRetailStoreOrderList(retailStoreOrderList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
		if(warehouseList == null){
			return retailStoreCountryCenter;
		}
		if(warehouseList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getWarehouseDAO().saveWarehouseList(warehouseList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
		if(warehouseList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<Warehouse> toRemoveWarehouseList = warehouseList.getToRemoveList();
		
		if(toRemoveWarehouseList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveWarehouseList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getWarehouseDAO().removeWarehouseList(toRemoveWarehouseList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
		if(transportFleetList == null){
			return retailStoreCountryCenter;
		}
		if(transportFleetList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTransportFleetDAO().saveTransportFleetList(transportFleetList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
		if(transportFleetList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<TransportFleet> toRemoveTransportFleetList = transportFleetList.getToRemoveList();
		
		if(toRemoveTransportFleetList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTransportFleetList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportFleetDAO().removeTransportFleetList(toRemoveTransportFleetList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		if(accountSetList == null){
			return retailStoreCountryCenter;
		}
		if(accountSetList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountSetDAO().saveAccountSetList(accountSetList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		if(accountSetList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<AccountSet> toRemoveAccountSetList = accountSetList.getToRemoveList();
		
		if(toRemoveAccountSetList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveAccountSetList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountSetDAO().removeAccountSetList(toRemoveAccountSetList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
		if(levelOneDepartmentList == null){
			return retailStoreCountryCenter;
		}
		if(levelOneDepartmentList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLevelOneDepartmentDAO().saveLevelOneDepartmentList(levelOneDepartmentList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
		if(levelOneDepartmentList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<LevelOneDepartment> toRemoveLevelOneDepartmentList = levelOneDepartmentList.getToRemoveList();
		
		if(toRemoveLevelOneDepartmentList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveLevelOneDepartmentList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLevelOneDepartmentDAO().removeLevelOneDepartmentList(toRemoveLevelOneDepartmentList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
		if(skillTypeList == null){
			return retailStoreCountryCenter;
		}
		if(skillTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSkillTypeDAO().saveSkillTypeList(skillTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
		if(skillTypeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<SkillType> toRemoveSkillTypeList = skillTypeList.getToRemoveList();
		
		if(toRemoveSkillTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveSkillTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSkillTypeDAO().removeSkillTypeList(toRemoveSkillTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
		if(responsibilityTypeList == null){
			return retailStoreCountryCenter;
		}
		if(responsibilityTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getResponsibilityTypeDAO().saveResponsibilityTypeList(responsibilityTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
		if(responsibilityTypeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<ResponsibilityType> toRemoveResponsibilityTypeList = responsibilityTypeList.getToRemoveList();
		
		if(toRemoveResponsibilityTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveResponsibilityTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getResponsibilityTypeDAO().removeResponsibilityTypeList(toRemoveResponsibilityTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
		if(terminationReasonList == null){
			return retailStoreCountryCenter;
		}
		if(terminationReasonList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTerminationReasonDAO().saveTerminationReasonList(terminationReasonList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
		if(terminationReasonList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<TerminationReason> toRemoveTerminationReasonList = terminationReasonList.getToRemoveList();
		
		if(toRemoveTerminationReasonList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTerminationReasonList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTerminationReasonDAO().removeTerminationReasonList(toRemoveTerminationReasonList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
		if(terminationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(terminationTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTerminationTypeDAO().saveTerminationTypeList(terminationTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
		if(terminationTypeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<TerminationType> toRemoveTerminationTypeList = terminationTypeList.getToRemoveList();
		
		if(toRemoveTerminationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTerminationTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTerminationTypeDAO().removeTerminationTypeList(toRemoveTerminationTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
		if(occupationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(occupationTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getOccupationTypeDAO().saveOccupationTypeList(occupationTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
		if(occupationTypeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<OccupationType> toRemoveOccupationTypeList = occupationTypeList.getToRemoveList();
		
		if(toRemoveOccupationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveOccupationTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getOccupationTypeDAO().removeOccupationTypeList(toRemoveOccupationTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
		if(leaveTypeList == null){
			return retailStoreCountryCenter;
		}
		if(leaveTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getLeaveTypeDAO().saveLeaveTypeList(leaveTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
		if(leaveTypeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<LeaveType> toRemoveLeaveTypeList = leaveTypeList.getToRemoveList();
		
		if(toRemoveLeaveTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveLeaveTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLeaveTypeDAO().removeLeaveTypeList(toRemoveLeaveTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
		if(salaryGradeList == null){
			return retailStoreCountryCenter;
		}
		if(salaryGradeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSalaryGradeDAO().saveSalaryGradeList(salaryGradeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
		if(salaryGradeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<SalaryGrade> toRemoveSalaryGradeList = salaryGradeList.getToRemoveList();
		
		if(toRemoveSalaryGradeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveSalaryGradeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSalaryGradeDAO().removeSalaryGradeList(toRemoveSalaryGradeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
		if(interviewTypeList == null){
			return retailStoreCountryCenter;
		}
		if(interviewTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getInterviewTypeDAO().saveInterviewTypeList(interviewTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
		if(interviewTypeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<InterviewType> toRemoveInterviewTypeList = interviewTypeList.getToRemoveList();
		
		if(toRemoveInterviewTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveInterviewTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getInterviewTypeDAO().removeInterviewTypeList(toRemoveInterviewTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
		if(trainingCourseTypeList == null){
			return retailStoreCountryCenter;
		}
		if(trainingCourseTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getTrainingCourseTypeDAO().saveTrainingCourseTypeList(trainingCourseTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
		if(trainingCourseTypeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<TrainingCourseType> toRemoveTrainingCourseTypeList = trainingCourseTypeList.getToRemoveList();
		
		if(toRemoveTrainingCourseTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTrainingCourseTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTrainingCourseTypeDAO().removeTrainingCourseTypeList(toRemoveTrainingCourseTypeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter savePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
		if(publicHolidayList == null){
			return retailStoreCountryCenter;
		}
		if(publicHolidayList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getPublicHolidayDAO().savePublicHolidayList(publicHolidayList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
		if(publicHolidayList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<PublicHoliday> toRemovePublicHolidayList = publicHolidayList.getToRemoveList();
		
		if(toRemovePublicHolidayList == null){
			return retailStoreCountryCenter;
		}
		if(toRemovePublicHolidayList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPublicHolidayDAO().removePublicHolidayList(toRemovePublicHolidayList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		if(employeeList == null){
			return retailStoreCountryCenter;
		}
		if(employeeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getEmployeeDAO().saveEmployeeList(employeeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		if(employeeList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();
		
		if(toRemoveEmployeeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
		if(instructorList == null){
			return retailStoreCountryCenter;
		}
		if(instructorList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getInstructorDAO().saveInstructorList(instructorList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
		if(instructorList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<Instructor> toRemoveInstructorList = instructorList.getToRemoveList();
		
		if(toRemoveInstructorList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveInstructorList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getInstructorDAO().removeInstructorList(toRemoveInstructorList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected RetailStoreCountryCenter saveCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		if(companyTrainingList == null){
			return retailStoreCountryCenter;
		}
		if(companyTrainingList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getCompanyTrainingDAO().saveCompanyTrainingList(companyTrainingList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	protected RetailStoreCountryCenter removeCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
	
	
		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		if(companyTrainingList == null){
			return retailStoreCountryCenter;
		}	
	
		SmartList<CompanyTraining> toRemoveCompanyTrainingList = companyTrainingList.getToRemoveList();
		
		if(toRemoveCompanyTrainingList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveCompanyTrainingList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCompanyTrainingDAO().removeCompanyTrainingList(toRemoveCompanyTrainingList,options);
		
		return retailStoreCountryCenter;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreCountryCenter present(RetailStoreCountryCenter retailStoreCountryCenter,Map<String, Object> options){
	
		presentReportList(retailStoreCountryCenter,options);
		presentCatalogList(retailStoreCountryCenter,options);
		presentRetailStoreProvinceCenterList(retailStoreCountryCenter,options);
		presentRetailStoreList(retailStoreCountryCenter,options);
		presentRetailStoreMemberList(retailStoreCountryCenter,options);
		presentGoodsSupplierList(retailStoreCountryCenter,options);
		presentSupplyOrderList(retailStoreCountryCenter,options);
		presentRetailStoreOrderList(retailStoreCountryCenter,options);
		presentWarehouseList(retailStoreCountryCenter,options);
		presentTransportFleetList(retailStoreCountryCenter,options);
		presentAccountSetList(retailStoreCountryCenter,options);
		presentLevelOneDepartmentList(retailStoreCountryCenter,options);
		presentSkillTypeList(retailStoreCountryCenter,options);
		presentResponsibilityTypeList(retailStoreCountryCenter,options);
		presentTerminationReasonList(retailStoreCountryCenter,options);
		presentTerminationTypeList(retailStoreCountryCenter,options);
		presentOccupationTypeList(retailStoreCountryCenter,options);
		presentLeaveTypeList(retailStoreCountryCenter,options);
		presentSalaryGradeList(retailStoreCountryCenter,options);
		presentInterviewTypeList(retailStoreCountryCenter,options);
		presentTrainingCourseTypeList(retailStoreCountryCenter,options);
		presentPublicHolidayList(retailStoreCountryCenter,options);
		presentEmployeeList(retailStoreCountryCenter,options);
		presentInstructorList(retailStoreCountryCenter,options);
		presentCompanyTrainingList(retailStoreCountryCenter,options);

		return retailStoreCountryCenter;
	
	}
		
	
  	
 	protected RetailStoreCountryCenter presentReportList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<Report> reportList = retailStoreCountryCenter.getReportList();		
		if(reportList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "report";
		int reportListSize = reportList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(reportListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = reportListSize;
		if(reportListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getReportDAO().countReportByOwner(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(reportListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(reportListSize,currentPage,rowsPerPage) ;
			reportList = reportList.subListOf(fromIndex, toIndex);
			reportList.setTotalCount(count);
			reportList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setReportList(reportList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		reportList 
			= getReportDAO().findReportByOwner(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		reportList.setTotalCount(count);
		reportList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setReportList(reportList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentCatalogList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();		
		if(catalogList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "catalog";
		int catalogListSize = catalogList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(catalogListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = catalogListSize;
		if(catalogListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getCatalogDAO().countCatalogByOwner(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(catalogListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(catalogListSize,currentPage,rowsPerPage) ;
			catalogList = catalogList.subListOf(fromIndex, toIndex);
			catalogList.setTotalCount(count);
			catalogList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setCatalogList(catalogList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		catalogList 
			= getCatalogDAO().findCatalogByOwner(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		catalogList.setTotalCount(count);
		catalogList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setCatalogList(catalogList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentRetailStoreProvinceCenterList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();		
		if(retailStoreProvinceCenterList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "retailStoreProvinceCenter";
		int retailStoreProvinceCenterListSize = retailStoreProvinceCenterList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreProvinceCenterListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreProvinceCenterListSize;
		if(retailStoreProvinceCenterListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreProvinceCenterDAO().countRetailStoreProvinceCenterByCountry(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreProvinceCenterListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreProvinceCenterListSize,currentPage,rowsPerPage) ;
			retailStoreProvinceCenterList = retailStoreProvinceCenterList.subListOf(fromIndex, toIndex);
			retailStoreProvinceCenterList.setTotalCount(count);
			retailStoreProvinceCenterList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setRetailStoreProvinceCenterList(retailStoreProvinceCenterList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreProvinceCenterList 
			= getRetailStoreProvinceCenterDAO().findRetailStoreProvinceCenterByCountry(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		retailStoreProvinceCenterList.setTotalCount(count);
		retailStoreProvinceCenterList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setRetailStoreProvinceCenterList(retailStoreProvinceCenterList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentRetailStoreList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();		
		if(retailStoreList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "retailStore";
		int retailStoreListSize = retailStoreList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreListSize;
		if(retailStoreListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreDAO().countRetailStoreByRetailStoreCountryCenter(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreListSize,currentPage,rowsPerPage) ;
			retailStoreList = retailStoreList.subListOf(fromIndex, toIndex);
			retailStoreList.setTotalCount(count);
			retailStoreList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setRetailStoreList(retailStoreList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreList 
			= getRetailStoreDAO().findRetailStoreByRetailStoreCountryCenter(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		retailStoreList.setTotalCount(count);
		retailStoreList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setRetailStoreList(retailStoreList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentRetailStoreMemberList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();		
		if(retailStoreMemberList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "retailStoreMember";
		int retailStoreMemberListSize = retailStoreMemberList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreMemberListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreMemberListSize;
		if(retailStoreMemberListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreMemberDAO().countRetailStoreMemberByOwner(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreMemberListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreMemberListSize,currentPage,rowsPerPage) ;
			retailStoreMemberList = retailStoreMemberList.subListOf(fromIndex, toIndex);
			retailStoreMemberList.setTotalCount(count);
			retailStoreMemberList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setRetailStoreMemberList(retailStoreMemberList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreMemberList 
			= getRetailStoreMemberDAO().findRetailStoreMemberByOwner(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		retailStoreMemberList.setTotalCount(count);
		retailStoreMemberList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setRetailStoreMemberList(retailStoreMemberList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentGoodsSupplierList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();		
		if(goodsSupplierList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "goodsSupplier";
		int goodsSupplierListSize = goodsSupplierList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(goodsSupplierListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = goodsSupplierListSize;
		if(goodsSupplierListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getGoodsSupplierDAO().countGoodsSupplierByBelongTo(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(goodsSupplierListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(goodsSupplierListSize,currentPage,rowsPerPage) ;
			goodsSupplierList = goodsSupplierList.subListOf(fromIndex, toIndex);
			goodsSupplierList.setTotalCount(count);
			goodsSupplierList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setGoodsSupplierList(goodsSupplierList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		goodsSupplierList 
			= getGoodsSupplierDAO().findGoodsSupplierByBelongTo(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		goodsSupplierList.setTotalCount(count);
		goodsSupplierList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setGoodsSupplierList(goodsSupplierList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentSupplyOrderList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();		
		if(supplyOrderList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderByBuyer(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setSupplyOrderList(supplyOrderList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderByBuyer(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setSupplyOrderList(supplyOrderList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentRetailStoreOrderList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();		
		if(retailStoreOrderList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "retailStoreOrder";
		int retailStoreOrderListSize = retailStoreOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreOrderListSize;
		if(retailStoreOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreOrderDAO().countRetailStoreOrderBySeller(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreOrderListSize,currentPage,rowsPerPage) ;
			retailStoreOrderList = retailStoreOrderList.subListOf(fromIndex, toIndex);
			retailStoreOrderList.setTotalCount(count);
			retailStoreOrderList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setRetailStoreOrderList(retailStoreOrderList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreOrderList 
			= getRetailStoreOrderDAO().findRetailStoreOrderBySeller(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		retailStoreOrderList.setTotalCount(count);
		retailStoreOrderList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setRetailStoreOrderList(retailStoreOrderList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentWarehouseList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();		
		if(warehouseList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "warehouse";
		int warehouseListSize = warehouseList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(warehouseListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = warehouseListSize;
		if(warehouseListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getWarehouseDAO().countWarehouseByOwner(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(warehouseListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(warehouseListSize,currentPage,rowsPerPage) ;
			warehouseList = warehouseList.subListOf(fromIndex, toIndex);
			warehouseList.setTotalCount(count);
			warehouseList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setWarehouseList(warehouseList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		warehouseList 
			= getWarehouseDAO().findWarehouseByOwner(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		warehouseList.setTotalCount(count);
		warehouseList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setWarehouseList(warehouseList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentTransportFleetList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();		
		if(transportFleetList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "transportFleet";
		int transportFleetListSize = transportFleetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(transportFleetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = transportFleetListSize;
		if(transportFleetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTransportFleetDAO().countTransportFleetByOwner(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(transportFleetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(transportFleetListSize,currentPage,rowsPerPage) ;
			transportFleetList = transportFleetList.subListOf(fromIndex, toIndex);
			transportFleetList.setTotalCount(count);
			transportFleetList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setTransportFleetList(transportFleetList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		transportFleetList 
			= getTransportFleetDAO().findTransportFleetByOwner(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		transportFleetList.setTotalCount(count);
		transportFleetList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setTransportFleetList(transportFleetList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentAccountSetList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();		
		if(accountSetList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "accountSet";
		int accountSetListSize = accountSetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountSetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountSetListSize;
		if(accountSetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountSetDAO().countAccountSetByCountryCenter(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountSetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountSetListSize,currentPage,rowsPerPage) ;
			accountSetList = accountSetList.subListOf(fromIndex, toIndex);
			accountSetList.setTotalCount(count);
			accountSetList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setAccountSetList(accountSetList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountSetList 
			= getAccountSetDAO().findAccountSetByCountryCenter(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		accountSetList.setTotalCount(count);
		accountSetList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setAccountSetList(accountSetList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentLevelOneDepartmentList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();		
		if(levelOneDepartmentList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "levelOneDepartment";
		int levelOneDepartmentListSize = levelOneDepartmentList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(levelOneDepartmentListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = levelOneDepartmentListSize;
		if(levelOneDepartmentListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getLevelOneDepartmentDAO().countLevelOneDepartmentByBelongsTo(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(levelOneDepartmentListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(levelOneDepartmentListSize,currentPage,rowsPerPage) ;
			levelOneDepartmentList = levelOneDepartmentList.subListOf(fromIndex, toIndex);
			levelOneDepartmentList.setTotalCount(count);
			levelOneDepartmentList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setLevelOneDepartmentList(levelOneDepartmentList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		levelOneDepartmentList 
			= getLevelOneDepartmentDAO().findLevelOneDepartmentByBelongsTo(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		levelOneDepartmentList.setTotalCount(count);
		levelOneDepartmentList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setLevelOneDepartmentList(levelOneDepartmentList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentSkillTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();		
		if(skillTypeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "skillType";
		int skillTypeListSize = skillTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(skillTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = skillTypeListSize;
		if(skillTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSkillTypeDAO().countSkillTypeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(skillTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(skillTypeListSize,currentPage,rowsPerPage) ;
			skillTypeList = skillTypeList.subListOf(fromIndex, toIndex);
			skillTypeList.setTotalCount(count);
			skillTypeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setSkillTypeList(skillTypeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		skillTypeList 
			= getSkillTypeDAO().findSkillTypeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		skillTypeList.setTotalCount(count);
		skillTypeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setSkillTypeList(skillTypeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentResponsibilityTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();		
		if(responsibilityTypeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "responsibilityType";
		int responsibilityTypeListSize = responsibilityTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(responsibilityTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = responsibilityTypeListSize;
		if(responsibilityTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getResponsibilityTypeDAO().countResponsibilityTypeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(responsibilityTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(responsibilityTypeListSize,currentPage,rowsPerPage) ;
			responsibilityTypeList = responsibilityTypeList.subListOf(fromIndex, toIndex);
			responsibilityTypeList.setTotalCount(count);
			responsibilityTypeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setResponsibilityTypeList(responsibilityTypeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		responsibilityTypeList 
			= getResponsibilityTypeDAO().findResponsibilityTypeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		responsibilityTypeList.setTotalCount(count);
		responsibilityTypeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setResponsibilityTypeList(responsibilityTypeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentTerminationReasonList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();		
		if(terminationReasonList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "terminationReason";
		int terminationReasonListSize = terminationReasonList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(terminationReasonListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = terminationReasonListSize;
		if(terminationReasonListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTerminationReasonDAO().countTerminationReasonByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(terminationReasonListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(terminationReasonListSize,currentPage,rowsPerPage) ;
			terminationReasonList = terminationReasonList.subListOf(fromIndex, toIndex);
			terminationReasonList.setTotalCount(count);
			terminationReasonList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setTerminationReasonList(terminationReasonList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		terminationReasonList 
			= getTerminationReasonDAO().findTerminationReasonByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		terminationReasonList.setTotalCount(count);
		terminationReasonList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setTerminationReasonList(terminationReasonList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentTerminationTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();		
		if(terminationTypeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "terminationType";
		int terminationTypeListSize = terminationTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(terminationTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = terminationTypeListSize;
		if(terminationTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTerminationTypeDAO().countTerminationTypeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(terminationTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(terminationTypeListSize,currentPage,rowsPerPage) ;
			terminationTypeList = terminationTypeList.subListOf(fromIndex, toIndex);
			terminationTypeList.setTotalCount(count);
			terminationTypeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setTerminationTypeList(terminationTypeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		terminationTypeList 
			= getTerminationTypeDAO().findTerminationTypeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		terminationTypeList.setTotalCount(count);
		terminationTypeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setTerminationTypeList(terminationTypeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentOccupationTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();		
		if(occupationTypeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "occupationType";
		int occupationTypeListSize = occupationTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(occupationTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = occupationTypeListSize;
		if(occupationTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getOccupationTypeDAO().countOccupationTypeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(occupationTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(occupationTypeListSize,currentPage,rowsPerPage) ;
			occupationTypeList = occupationTypeList.subListOf(fromIndex, toIndex);
			occupationTypeList.setTotalCount(count);
			occupationTypeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setOccupationTypeList(occupationTypeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		occupationTypeList 
			= getOccupationTypeDAO().findOccupationTypeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		occupationTypeList.setTotalCount(count);
		occupationTypeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setOccupationTypeList(occupationTypeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentLeaveTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();		
		if(leaveTypeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "leaveType";
		int leaveTypeListSize = leaveTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(leaveTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = leaveTypeListSize;
		if(leaveTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getLeaveTypeDAO().countLeaveTypeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(leaveTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(leaveTypeListSize,currentPage,rowsPerPage) ;
			leaveTypeList = leaveTypeList.subListOf(fromIndex, toIndex);
			leaveTypeList.setTotalCount(count);
			leaveTypeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setLeaveTypeList(leaveTypeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		leaveTypeList 
			= getLeaveTypeDAO().findLeaveTypeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		leaveTypeList.setTotalCount(count);
		leaveTypeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setLeaveTypeList(leaveTypeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentSalaryGradeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();		
		if(salaryGradeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "salaryGrade";
		int salaryGradeListSize = salaryGradeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(salaryGradeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = salaryGradeListSize;
		if(salaryGradeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSalaryGradeDAO().countSalaryGradeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(salaryGradeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(salaryGradeListSize,currentPage,rowsPerPage) ;
			salaryGradeList = salaryGradeList.subListOf(fromIndex, toIndex);
			salaryGradeList.setTotalCount(count);
			salaryGradeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setSalaryGradeList(salaryGradeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		salaryGradeList 
			= getSalaryGradeDAO().findSalaryGradeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		salaryGradeList.setTotalCount(count);
		salaryGradeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setSalaryGradeList(salaryGradeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentInterviewTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();		
		if(interviewTypeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "interviewType";
		int interviewTypeListSize = interviewTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(interviewTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = interviewTypeListSize;
		if(interviewTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getInterviewTypeDAO().countInterviewTypeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(interviewTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(interviewTypeListSize,currentPage,rowsPerPage) ;
			interviewTypeList = interviewTypeList.subListOf(fromIndex, toIndex);
			interviewTypeList.setTotalCount(count);
			interviewTypeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setInterviewTypeList(interviewTypeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		interviewTypeList 
			= getInterviewTypeDAO().findInterviewTypeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		interviewTypeList.setTotalCount(count);
		interviewTypeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setInterviewTypeList(interviewTypeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentTrainingCourseTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();		
		if(trainingCourseTypeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "trainingCourseType";
		int trainingCourseTypeListSize = trainingCourseTypeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(trainingCourseTypeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = trainingCourseTypeListSize;
		if(trainingCourseTypeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getTrainingCourseTypeDAO().countTrainingCourseTypeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(trainingCourseTypeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(trainingCourseTypeListSize,currentPage,rowsPerPage) ;
			trainingCourseTypeList = trainingCourseTypeList.subListOf(fromIndex, toIndex);
			trainingCourseTypeList.setTotalCount(count);
			trainingCourseTypeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setTrainingCourseTypeList(trainingCourseTypeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		trainingCourseTypeList 
			= getTrainingCourseTypeDAO().findTrainingCourseTypeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		trainingCourseTypeList.setTotalCount(count);
		trainingCourseTypeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setTrainingCourseTypeList(trainingCourseTypeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentPublicHolidayList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();		
		if(publicHolidayList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "publicHoliday";
		int publicHolidayListSize = publicHolidayList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(publicHolidayListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = publicHolidayListSize;
		if(publicHolidayListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getPublicHolidayDAO().countPublicHolidayByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(publicHolidayListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(publicHolidayListSize,currentPage,rowsPerPage) ;
			publicHolidayList = publicHolidayList.subListOf(fromIndex, toIndex);
			publicHolidayList.setTotalCount(count);
			publicHolidayList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setPublicHolidayList(publicHolidayList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		publicHolidayList 
			= getPublicHolidayDAO().findPublicHolidayByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		publicHolidayList.setTotalCount(count);
		publicHolidayList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setPublicHolidayList(publicHolidayList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentEmployeeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();		
		if(employeeList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "employee";
		int employeeListSize = employeeList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(employeeListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = employeeListSize;
		if(employeeListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getEmployeeDAO().countEmployeeByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(employeeListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(employeeListSize,currentPage,rowsPerPage) ;
			employeeList = employeeList.subListOf(fromIndex, toIndex);
			employeeList.setTotalCount(count);
			employeeList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setEmployeeList(employeeList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		employeeList 
			= getEmployeeDAO().findEmployeeByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		employeeList.setTotalCount(count);
		employeeList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setEmployeeList(employeeList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentInstructorList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();		
		if(instructorList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "instructor";
		int instructorListSize = instructorList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(instructorListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = instructorListSize;
		if(instructorListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getInstructorDAO().countInstructorByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(instructorListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(instructorListSize,currentPage,rowsPerPage) ;
			instructorList = instructorList.subListOf(fromIndex, toIndex);
			instructorList.setTotalCount(count);
			instructorList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setInstructorList(instructorList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		instructorList 
			= getInstructorDAO().findInstructorByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		instructorList.setTotalCount(count);
		instructorList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setInstructorList(instructorList );	

		return retailStoreCountryCenter;
	}			
		
	
  	
 	protected RetailStoreCountryCenter presentCompanyTrainingList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {

		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();		
		if(companyTrainingList == null){
			return retailStoreCountryCenter;			
		}
		
		String targetObjectName = "companyTraining";
		int companyTrainingListSize = companyTrainingList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(companyTrainingListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreCountryCenter;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = companyTrainingListSize;
		if(companyTrainingListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getCompanyTrainingDAO().countCompanyTrainingByCompany(retailStoreCountryCenter.getId(), options);			
		}
		//retailStoreCountryCenter.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreCountryCenter.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(companyTrainingListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(companyTrainingListSize,currentPage,rowsPerPage) ;
			companyTrainingList = companyTrainingList.subListOf(fromIndex, toIndex);
			companyTrainingList.setTotalCount(count);
			companyTrainingList.setCurrentPageNumber(currentPage);			
			retailStoreCountryCenter.setCompanyTrainingList(companyTrainingList);
			return retailStoreCountryCenter;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		companyTrainingList 
			= getCompanyTrainingDAO().findCompanyTrainingByCompany(retailStoreCountryCenter.getId(),start, rowsPerPage, options );
		companyTrainingList.setTotalCount(count);
		companyTrainingList.setCurrentPageNumber(currentPage);
		retailStoreCountryCenter.setCompanyTrainingList(companyTrainingList );	

		return retailStoreCountryCenter;
	}			
		


	protected String getTableName(){
		return RetailStoreCountryCenterTable.TABLE_NAME;
	}
}


