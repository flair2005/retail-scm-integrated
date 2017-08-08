
package com.skynet.retailscm;
import java.util.Map;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.report.Report;
import com.skynet.retailscm.reportline.ReportLine;
import com.skynet.retailscm.catalog.Catalog;
import com.skynet.retailscm.levelonecategory.LevelOneCategory;
import com.skynet.retailscm.leveltwocategory.LevelTwoCategory;
import com.skynet.retailscm.levelthreecategory.LevelThreeCategory;
import com.skynet.retailscm.product.Product;
import com.skynet.retailscm.sku.Sku;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.skynet.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.citypartner.CityPartner;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.eventattendance.EventAttendance;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreation;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosing;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.consumerorderconfirmation.ConsumerOrderConfirmation;
import com.skynet.retailscm.consumerorderapproval.ConsumerOrderApproval;
import com.skynet.retailscm.consumerorderprocessing.ConsumerOrderProcessing;
import com.skynet.retailscm.consumerordershipment.ConsumerOrderShipment;
import com.skynet.retailscm.consumerorderdelivery.ConsumerOrderDelivery;
import com.skynet.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.skynet.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.skynet.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.skynet.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.skynet.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.skynet.retailscm.memberwishlist.MemberWishlist;
import com.skynet.retailscm.memberrewardpoint.MemberRewardPoint;
import com.skynet.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.skynet.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.skynet.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.supplierproduct.SupplierProduct;
import com.skynet.retailscm.productsupplyduration.ProductSupplyDuration;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.skynet.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.skynet.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.skynet.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.skynet.retailscm.supplyordershipment.SupplyOrderShipment;
import com.skynet.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.skynet.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.skynet.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.skynet.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.skynet.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.skynet.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.skynet.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.skynet.retailscm.retailstoreordershipment.RetailStoreOrderShipment;
import com.skynet.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.skynet.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.skynet.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.skynet.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.skynet.retailscm.warehouse.Warehouse;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.goodsshelf.GoodsShelf;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrack;
import com.skynet.retailscm.goodsallocation.GoodsAllocation;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.goodspackaging.GoodsPackaging;
import com.skynet.retailscm.goodsmovement.GoodsMovement;
import com.skynet.retailscm.supplierspace.SupplierSpace;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.warehouseasset.WarehouseAsset;
import com.skynet.retailscm.transportfleet.TransportFleet;
import com.skynet.retailscm.transporttruck.TransportTruck;
import com.skynet.retailscm.truckdriver.TruckDriver;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.transporttasktrack.TransportTaskTrack;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.accountingsubject.AccountingSubject;
import com.skynet.retailscm.accountingperiod.AccountingPeriod;
import com.skynet.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.skynet.retailscm.accountingdocument.AccountingDocument;
import com.skynet.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.skynet.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.skynet.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.skynet.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.skynet.retailscm.originalvoucher.OriginalVoucher;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.skynet.retailscm.userdomain.UserDomain;
import com.skynet.retailscm.secuser.SecUser;
import com.skynet.retailscm.userapp.UserApp;
import com.skynet.retailscm.objectaccess.ObjectAccess;
import com.skynet.retailscm.levelonedepartment.LevelOneDepartment;
import com.skynet.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.skynet.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.skynet.retailscm.skilltype.SkillType;
import com.skynet.retailscm.responsibilitytype.ResponsibilityType;
import com.skynet.retailscm.terminationreason.TerminationReason;
import com.skynet.retailscm.terminationtype.TerminationType;
import com.skynet.retailscm.occupationtype.OccupationType;
import com.skynet.retailscm.leavetype.LeaveType;
import com.skynet.retailscm.salarygrade.SalaryGrade;
import com.skynet.retailscm.interviewtype.InterviewType;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;
import com.skynet.retailscm.publicholiday.PublicHoliday;
import com.skynet.retailscm.termination.Termination;
import com.skynet.retailscm.view.View;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.jobapplication.JobApplication;
import com.skynet.retailscm.professioninterview.ProfessionInterview;
import com.skynet.retailscm.hrinterview.HrInterview;
import com.skynet.retailscm.offerapproval.OfferApproval;
import com.skynet.retailscm.offeracceptance.OfferAcceptance;
import com.skynet.retailscm.employeeboarding.EmployeeBoarding;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.companytraining.CompanyTraining;
import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.skynet.retailscm.employeeskill.EmployeeSkill;
import com.skynet.retailscm.employeeperformance.EmployeePerformance;
import com.skynet.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.skynet.retailscm.employeeleave.EmployeeLeave;
import com.skynet.retailscm.employeeinterview.EmployeeInterview;
import com.skynet.retailscm.employeeattendance.EmployeeAttendance;
import com.skynet.retailscm.employeequalifier.EmployeeQualifier;
import com.skynet.retailscm.employeeeducation.EmployeeEducation;
import com.skynet.retailscm.employeeaward.EmployeeAward;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.payingoff.PayingOff;

public class BeanFactoryImpl{


	public RetailStoreCountryCenter createRetailStoreCountryCenter(Map<String,Object> options){
		return new RetailStoreCountryCenter();
	}


	public Report createReport(Map<String,Object> options){
		return new Report();
	}


	public ReportLine createReportLine(Map<String,Object> options){
		return new ReportLine();
	}


	public Catalog createCatalog(Map<String,Object> options){
		return new Catalog();
	}


	public LevelOneCategory createLevelOneCategory(Map<String,Object> options){
		return new LevelOneCategory();
	}


	public LevelTwoCategory createLevelTwoCategory(Map<String,Object> options){
		return new LevelTwoCategory();
	}


	public LevelThreeCategory createLevelThreeCategory(Map<String,Object> options){
		return new LevelThreeCategory();
	}


	public Product createProduct(Map<String,Object> options){
		return new Product();
	}


	public Sku createSku(Map<String,Object> options){
		return new Sku();
	}


	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(Map<String,Object> options){
		return new RetailStoreProvinceCenter();
	}


	public ProvinceCenterDepartment createProvinceCenterDepartment(Map<String,Object> options){
		return new ProvinceCenterDepartment();
	}


	public ProvinceCenterEmployee createProvinceCenterEmployee(Map<String,Object> options){
		return new ProvinceCenterEmployee();
	}


	public RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(Map<String,Object> options){
		return new RetailStoreCityServiceCenter();
	}


	public CityPartner createCityPartner(Map<String,Object> options){
		return new CityPartner();
	}


	public PotentialCustomer createPotentialCustomer(Map<String,Object> options){
		return new PotentialCustomer();
	}


	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(Map<String,Object> options){
		return new PotentialCustomerContactPerson();
	}


	public PotentialCustomerContact createPotentialCustomerContact(Map<String,Object> options){
		return new PotentialCustomerContact();
	}


	public CityEvent createCityEvent(Map<String,Object> options){
		return new CityEvent();
	}


	public EventAttendance createEventAttendance(Map<String,Object> options){
		return new EventAttendance();
	}


	public RetailStore createRetailStore(Map<String,Object> options){
		return new RetailStore();
	}


	public RetailStoreCreation createRetailStoreCreation(Map<String,Object> options){
		return new RetailStoreCreation();
	}


	public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(Map<String,Object> options){
		return new RetailStoreInvestmentInvitation();
	}


	public RetailStoreFranchising createRetailStoreFranchising(Map<String,Object> options){
		return new RetailStoreFranchising();
	}


	public RetailStoreDecoration createRetailStoreDecoration(Map<String,Object> options){
		return new RetailStoreDecoration();
	}


	public RetailStoreOpening createRetailStoreOpening(Map<String,Object> options){
		return new RetailStoreOpening();
	}


	public RetailStoreClosing createRetailStoreClosing(Map<String,Object> options){
		return new RetailStoreClosing();
	}


	public RetailStoreMember createRetailStoreMember(Map<String,Object> options){
		return new RetailStoreMember();
	}


	public ConsumerOrder createConsumerOrder(Map<String,Object> options){
		return new ConsumerOrder();
	}


	public ConsumerOrderConfirmation createConsumerOrderConfirmation(Map<String,Object> options){
		return new ConsumerOrderConfirmation();
	}


	public ConsumerOrderApproval createConsumerOrderApproval(Map<String,Object> options){
		return new ConsumerOrderApproval();
	}


	public ConsumerOrderProcessing createConsumerOrderProcessing(Map<String,Object> options){
		return new ConsumerOrderProcessing();
	}


	public ConsumerOrderShipment createConsumerOrderShipment(Map<String,Object> options){
		return new ConsumerOrderShipment();
	}


	public ConsumerOrderDelivery createConsumerOrderDelivery(Map<String,Object> options){
		return new ConsumerOrderDelivery();
	}


	public ConsumerOrderLineItem createConsumerOrderLineItem(Map<String,Object> options){
		return new ConsumerOrderLineItem();
	}


	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(Map<String,Object> options){
		return new ConsumerOrderShippingGroup();
	}


	public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(Map<String,Object> options){
		return new ConsumerOrderPaymentGroup();
	}


	public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(Map<String,Object> options){
		return new ConsumerOrderPriceAdjustment();
	}


	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(Map<String,Object> options){
		return new RetailStoreMemberCoupon();
	}


	public MemberWishlist createMemberWishlist(Map<String,Object> options){
		return new MemberWishlist();
	}


	public MemberRewardPoint createMemberRewardPoint(Map<String,Object> options){
		return new MemberRewardPoint();
	}


	public MemberRewardPointRedemption createMemberRewardPointRedemption(Map<String,Object> options){
		return new MemberRewardPointRedemption();
	}


	public MemberWishlistProduct createMemberWishlistProduct(Map<String,Object> options){
		return new MemberWishlistProduct();
	}


	public RetailStoreMemberAddress createRetailStoreMemberAddress(Map<String,Object> options){
		return new RetailStoreMemberAddress();
	}


	public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(Map<String,Object> options){
		return new RetailStoreMemberGiftCard();
	}


	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(Map<String,Object> options){
		return new RetailStoreMemberGiftCardConsumeRecord();
	}


	public GoodsSupplier createGoodsSupplier(Map<String,Object> options){
		return new GoodsSupplier();
	}


	public SupplierProduct createSupplierProduct(Map<String,Object> options){
		return new SupplierProduct();
	}


	public ProductSupplyDuration createProductSupplyDuration(Map<String,Object> options){
		return new ProductSupplyDuration();
	}


	public SupplyOrder createSupplyOrder(Map<String,Object> options){
		return new SupplyOrder();
	}


	public SupplyOrderConfirmation createSupplyOrderConfirmation(Map<String,Object> options){
		return new SupplyOrderConfirmation();
	}


	public SupplyOrderApproval createSupplyOrderApproval(Map<String,Object> options){
		return new SupplyOrderApproval();
	}


	public SupplyOrderProcessing createSupplyOrderProcessing(Map<String,Object> options){
		return new SupplyOrderProcessing();
	}


	public SupplyOrderPicking createSupplyOrderPicking(Map<String,Object> options){
		return new SupplyOrderPicking();
	}


	public SupplyOrderShipment createSupplyOrderShipment(Map<String,Object> options){
		return new SupplyOrderShipment();
	}


	public SupplyOrderDelivery createSupplyOrderDelivery(Map<String,Object> options){
		return new SupplyOrderDelivery();
	}


	public SupplyOrderLineItem createSupplyOrderLineItem(Map<String,Object> options){
		return new SupplyOrderLineItem();
	}


	public SupplyOrderShippingGroup createSupplyOrderShippingGroup(Map<String,Object> options){
		return new SupplyOrderShippingGroup();
	}


	public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(Map<String,Object> options){
		return new SupplyOrderPaymentGroup();
	}


	public RetailStoreOrder createRetailStoreOrder(Map<String,Object> options){
		return new RetailStoreOrder();
	}


	public RetailStoreOrderConfirmation createRetailStoreOrderConfirmation(Map<String,Object> options){
		return new RetailStoreOrderConfirmation();
	}


	public RetailStoreOrderApproval createRetailStoreOrderApproval(Map<String,Object> options){
		return new RetailStoreOrderApproval();
	}


	public RetailStoreOrderProcessing createRetailStoreOrderProcessing(Map<String,Object> options){
		return new RetailStoreOrderProcessing();
	}


	public RetailStoreOrderPicking createRetailStoreOrderPicking(Map<String,Object> options){
		return new RetailStoreOrderPicking();
	}


	public RetailStoreOrderShipment createRetailStoreOrderShipment(Map<String,Object> options){
		return new RetailStoreOrderShipment();
	}


	public RetailStoreOrderDelivery createRetailStoreOrderDelivery(Map<String,Object> options){
		return new RetailStoreOrderDelivery();
	}


	public RetailStoreOrderLineItem createRetailStoreOrderLineItem(Map<String,Object> options){
		return new RetailStoreOrderLineItem();
	}


	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(Map<String,Object> options){
		return new RetailStoreOrderShippingGroup();
	}


	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(Map<String,Object> options){
		return new RetailStoreOrderPaymentGroup();
	}


	public Warehouse createWarehouse(Map<String,Object> options){
		return new Warehouse();
	}


	public StorageSpace createStorageSpace(Map<String,Object> options){
		return new StorageSpace();
	}


	public SmartPallet createSmartPallet(Map<String,Object> options){
		return new SmartPallet();
	}


	public GoodsShelf createGoodsShelf(Map<String,Object> options){
		return new GoodsShelf();
	}


	public GoodsShelfStockCount createGoodsShelfStockCount(Map<String,Object> options){
		return new GoodsShelfStockCount();
	}


	public StockCountIssueTrack createStockCountIssueTrack(Map<String,Object> options){
		return new StockCountIssueTrack();
	}


	public GoodsAllocation createGoodsAllocation(Map<String,Object> options){
		return new GoodsAllocation();
	}


	public Goods createGoods(Map<String,Object> options){
		return new Goods();
	}


	public GoodsPackaging createGoodsPackaging(Map<String,Object> options){
		return new GoodsPackaging();
	}


	public GoodsMovement createGoodsMovement(Map<String,Object> options){
		return new GoodsMovement();
	}


	public SupplierSpace createSupplierSpace(Map<String,Object> options){
		return new SupplierSpace();
	}


	public ReceivingSpace createReceivingSpace(Map<String,Object> options){
		return new ReceivingSpace();
	}


	public ShippingSpace createShippingSpace(Map<String,Object> options){
		return new ShippingSpace();
	}


	public DamageSpace createDamageSpace(Map<String,Object> options){
		return new DamageSpace();
	}


	public WarehouseAsset createWarehouseAsset(Map<String,Object> options){
		return new WarehouseAsset();
	}


	public TransportFleet createTransportFleet(Map<String,Object> options){
		return new TransportFleet();
	}


	public TransportTruck createTransportTruck(Map<String,Object> options){
		return new TransportTruck();
	}


	public TruckDriver createTruckDriver(Map<String,Object> options){
		return new TruckDriver();
	}


	public TransportTask createTransportTask(Map<String,Object> options){
		return new TransportTask();
	}


	public TransportTaskTrack createTransportTaskTrack(Map<String,Object> options){
		return new TransportTaskTrack();
	}


	public AccountSet createAccountSet(Map<String,Object> options){
		return new AccountSet();
	}


	public AccountingSubject createAccountingSubject(Map<String,Object> options){
		return new AccountingSubject();
	}


	public AccountingPeriod createAccountingPeriod(Map<String,Object> options){
		return new AccountingPeriod();
	}


	public AccountingDocumentType createAccountingDocumentType(Map<String,Object> options){
		return new AccountingDocumentType();
	}


	public AccountingDocument createAccountingDocument(Map<String,Object> options){
		return new AccountingDocument();
	}


	public AccountingDocumentCreation createAccountingDocumentCreation(Map<String,Object> options){
		return new AccountingDocumentCreation();
	}


	public AccountingDocumentConfirmation createAccountingDocumentConfirmation(Map<String,Object> options){
		return new AccountingDocumentConfirmation();
	}


	public AccountingDocumentAuditing createAccountingDocumentAuditing(Map<String,Object> options){
		return new AccountingDocumentAuditing();
	}


	public AccountingDocumentPosting createAccountingDocumentPosting(Map<String,Object> options){
		return new AccountingDocumentPosting();
	}


	public OriginalVoucher createOriginalVoucher(Map<String,Object> options){
		return new OriginalVoucher();
	}


	public OriginalVoucherCreation createOriginalVoucherCreation(Map<String,Object> options){
		return new OriginalVoucherCreation();
	}


	public OriginalVoucherConfirmation createOriginalVoucherConfirmation(Map<String,Object> options){
		return new OriginalVoucherConfirmation();
	}


	public OriginalVoucherAuditing createOriginalVoucherAuditing(Map<String,Object> options){
		return new OriginalVoucherAuditing();
	}


	public AccountingDocumentLine createAccountingDocumentLine(Map<String,Object> options){
		return new AccountingDocumentLine();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LevelOneDepartment createLevelOneDepartment(Map<String,Object> options){
		return new LevelOneDepartment();
	}


	public LevelTwoDepartment createLevelTwoDepartment(Map<String,Object> options){
		return new LevelTwoDepartment();
	}


	public LevelThreeDepartment createLevelThreeDepartment(Map<String,Object> options){
		return new LevelThreeDepartment();
	}


	public SkillType createSkillType(Map<String,Object> options){
		return new SkillType();
	}


	public ResponsibilityType createResponsibilityType(Map<String,Object> options){
		return new ResponsibilityType();
	}


	public TerminationReason createTerminationReason(Map<String,Object> options){
		return new TerminationReason();
	}


	public TerminationType createTerminationType(Map<String,Object> options){
		return new TerminationType();
	}


	public OccupationType createOccupationType(Map<String,Object> options){
		return new OccupationType();
	}


	public LeaveType createLeaveType(Map<String,Object> options){
		return new LeaveType();
	}


	public SalaryGrade createSalaryGrade(Map<String,Object> options){
		return new SalaryGrade();
	}


	public InterviewType createInterviewType(Map<String,Object> options){
		return new InterviewType();
	}


	public TrainingCourseType createTrainingCourseType(Map<String,Object> options){
		return new TrainingCourseType();
	}


	public PublicHoliday createPublicHoliday(Map<String,Object> options){
		return new PublicHoliday();
	}


	public Termination createTermination(Map<String,Object> options){
		return new Termination();
	}


	public View createView(Map<String,Object> options){
		return new View();
	}


	public Employee createEmployee(Map<String,Object> options){
		return new Employee();
	}


	public JobApplication createJobApplication(Map<String,Object> options){
		return new JobApplication();
	}


	public ProfessionInterview createProfessionInterview(Map<String,Object> options){
		return new ProfessionInterview();
	}


	public HrInterview createHrInterview(Map<String,Object> options){
		return new HrInterview();
	}


	public OfferApproval createOfferApproval(Map<String,Object> options){
		return new OfferApproval();
	}


	public OfferAcceptance createOfferAcceptance(Map<String,Object> options){
		return new OfferAcceptance();
	}


	public EmployeeBoarding createEmployeeBoarding(Map<String,Object> options){
		return new EmployeeBoarding();
	}


	public Instructor createInstructor(Map<String,Object> options){
		return new Instructor();
	}


	public CompanyTraining createCompanyTraining(Map<String,Object> options){
		return new CompanyTraining();
	}


	public Scoring createScoring(Map<String,Object> options){
		return new Scoring();
	}


	public EmployeeCompanyTraining createEmployeeCompanyTraining(Map<String,Object> options){
		return new EmployeeCompanyTraining();
	}


	public EmployeeSkill createEmployeeSkill(Map<String,Object> options){
		return new EmployeeSkill();
	}


	public EmployeePerformance createEmployeePerformance(Map<String,Object> options){
		return new EmployeePerformance();
	}


	public EmployeeWorkExperience createEmployeeWorkExperience(Map<String,Object> options){
		return new EmployeeWorkExperience();
	}


	public EmployeeLeave createEmployeeLeave(Map<String,Object> options){
		return new EmployeeLeave();
	}


	public EmployeeInterview createEmployeeInterview(Map<String,Object> options){
		return new EmployeeInterview();
	}


	public EmployeeAttendance createEmployeeAttendance(Map<String,Object> options){
		return new EmployeeAttendance();
	}


	public EmployeeQualifier createEmployeeQualifier(Map<String,Object> options){
		return new EmployeeQualifier();
	}


	public EmployeeEducation createEmployeeEducation(Map<String,Object> options){
		return new EmployeeEducation();
	}


	public EmployeeAward createEmployeeAward(Map<String,Object> options){
		return new EmployeeAward();
	}


	public EmployeeSalarySheet createEmployeeSalarySheet(Map<String,Object> options){
		return new EmployeeSalarySheet();
	}


	public PayingOff createPayingOff(Map<String,Object> options){
		return new PayingOff();
	}





}








