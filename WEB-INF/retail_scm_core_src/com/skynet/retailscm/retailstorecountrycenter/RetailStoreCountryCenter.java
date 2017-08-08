
package com.skynet.retailscm.retailstorecountrycenter;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

@JsonSerialize(using = RetailStoreCountryCenterSerializer.class)
public class RetailStoreCountryCenter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SERVICE_NUMBER_PROPERTY        = "serviceNumber"     ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String WEB_SITE_PROPERTY              = "webSite"           ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String OPERATED_BY_PROPERTY           = "operatedBy"        ;
	public static final String LEGAL_REPRESENTATIVE_PROPERTY  = "legalRepresentative";
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String REPORT_LIST                              = "reportList"        ;
	public static final String CATALOG_LIST                             = "catalogList"       ;
	public static final String RETAIL_STORE_PROVINCE_CENTER_LIST        = "retailStoreProvinceCenterList";
	public static final String RETAIL_STORE_LIST                        = "retailStoreList"   ;
	public static final String RETAIL_STORE_MEMBER_LIST                 = "retailStoreMemberList";
	public static final String GOODS_SUPPLIER_LIST                      = "goodsSupplierList" ;
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;
	public static final String RETAIL_STORE_ORDER_LIST                  = "retailStoreOrderList";
	public static final String WAREHOUSE_LIST                           = "warehouseList"     ;
	public static final String TRANSPORT_FLEET_LIST                     = "transportFleetList";
	public static final String ACCOUNT_SET_LIST                         = "accountSetList"    ;
	public static final String LEVEL_ONE_DEPARTMENT_LIST                = "levelOneDepartmentList";
	public static final String SKILL_TYPE_LIST                          = "skillTypeList"     ;
	public static final String RESPONSIBILITY_TYPE_LIST                 = "responsibilityTypeList";
	public static final String TERMINATION_REASON_LIST                  = "terminationReasonList";
	public static final String TERMINATION_TYPE_LIST                    = "terminationTypeList";
	public static final String OCCUPATION_TYPE_LIST                     = "occupationTypeList";
	public static final String LEAVE_TYPE_LIST                          = "leaveTypeList"     ;
	public static final String SALARY_GRADE_LIST                        = "salaryGradeList"   ;
	public static final String INTERVIEW_TYPE_LIST                      = "interviewTypeList" ;
	public static final String TRAINING_COURSE_TYPE_LIST                = "trainingCourseTypeList";
	public static final String PUBLIC_HOLIDAY_LIST                      = "publicHolidayList" ;
	public static final String EMPLOYEE_LIST                            = "employeeList"      ;
	public static final String INSTRUCTOR_LIST                          = "instructorList"    ;
	public static final String COMPANY_TRAINING_LIST                    = "companyTrainingList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mServiceNumber      ;
	protected		Date                	mFounded            ;
	protected		String              	mWebSite            ;
	protected		String              	mAddress            ;
	protected		String              	mOperatedBy         ;
	protected		String              	mLegalRepresentative;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Report>   	mReportList         ;
	protected		SmartList<Catalog>  	mCatalogList        ;
	protected		SmartList<RetailStoreProvinceCenter>	mRetailStoreProvinceCenterList;
	protected		SmartList<RetailStore>	mRetailStoreList    ;
	protected		SmartList<RetailStoreMember>	mRetailStoreMemberList;
	protected		SmartList<GoodsSupplier>	mGoodsSupplierList  ;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	protected		SmartList<RetailStoreOrder>	mRetailStoreOrderList;
	protected		SmartList<Warehouse>	mWarehouseList      ;
	protected		SmartList<TransportFleet>	mTransportFleetList ;
	protected		SmartList<AccountSet>	mAccountSetList     ;
	protected		SmartList<LevelOneDepartment>	mLevelOneDepartmentList;
	protected		SmartList<SkillType>	mSkillTypeList      ;
	protected		SmartList<ResponsibilityType>	mResponsibilityTypeList;
	protected		SmartList<TerminationReason>	mTerminationReasonList;
	protected		SmartList<TerminationType>	mTerminationTypeList;
	protected		SmartList<OccupationType>	mOccupationTypeList ;
	protected		SmartList<LeaveType>	mLeaveTypeList      ;
	protected		SmartList<SalaryGrade>	mSalaryGradeList    ;
	protected		SmartList<InterviewType>	mInterviewTypeList  ;
	protected		SmartList<TrainingCourseType>	mTrainingCourseTypeList;
	protected		SmartList<PublicHoliday>	mPublicHolidayList  ;
	protected		SmartList<Employee> 	mEmployeeList       ;
	protected		SmartList<Instructor>	mInstructorList     ;
	protected		SmartList<CompanyTraining>	mCompanyTrainingList;
	
		
	public 	RetailStoreCountryCenter(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreCountryCenter(String name, String serviceNumber, Date founded, String webSite, String address, String operatedBy, String legalRepresentative, String description
)
	{
		setName(name);
		setServiceNumber(serviceNumber);
		setFounded(founded);
		setWebSite(webSite);
		setAddress(address);
		setOperatedBy(operatedBy);
		setLegalRepresentative(legalRepresentative);
		setDescription(description);

		this.mReportList = new SmartList<Report>();
		this.mCatalogList = new SmartList<Catalog>();
		this.mRetailStoreProvinceCenterList = new SmartList<RetailStoreProvinceCenter>();
		this.mRetailStoreList = new SmartList<RetailStore>();
		this.mRetailStoreMemberList = new SmartList<RetailStoreMember>();
		this.mGoodsSupplierList = new SmartList<GoodsSupplier>();
		this.mSupplyOrderList = new SmartList<SupplyOrder>();
		this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
		this.mWarehouseList = new SmartList<Warehouse>();
		this.mTransportFleetList = new SmartList<TransportFleet>();
		this.mAccountSetList = new SmartList<AccountSet>();
		this.mLevelOneDepartmentList = new SmartList<LevelOneDepartment>();
		this.mSkillTypeList = new SmartList<SkillType>();
		this.mResponsibilityTypeList = new SmartList<ResponsibilityType>();
		this.mTerminationReasonList = new SmartList<TerminationReason>();
		this.mTerminationTypeList = new SmartList<TerminationType>();
		this.mOccupationTypeList = new SmartList<OccupationType>();
		this.mLeaveTypeList = new SmartList<LeaveType>();
		this.mSalaryGradeList = new SmartList<SalaryGrade>();
		this.mInterviewTypeList = new SmartList<InterviewType>();
		this.mTrainingCourseTypeList = new SmartList<TrainingCourseType>();
		this.mPublicHolidayList = new SmartList<PublicHoliday>();
		this.mEmployeeList = new SmartList<Employee>();
		this.mInstructorList = new SmartList<Instructor>();
		this.mCompanyTrainingList = new SmartList<CompanyTraining>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SERVICE_NUMBER_PROPERTY.equals(property)){
			changeServiceNumberProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(WEB_SITE_PROPERTY.equals(property)){
			changeWebSiteProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
		}
		if(OPERATED_BY_PROPERTY.equals(property)){
			changeOperatedByProperty(newValueExpr);
		}
		if(LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
			changeLegalRepresentativeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setName(newValue);
		//they are surely different each other
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeServiceNumberProperty(String newValueExpr){
		String oldValue = getServiceNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setServiceNumber(newValue);
		//they are surely different each other
		this.onChangeProperty(SERVICE_NUMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFounded(newValue);
		//they are surely different each other
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeWebSiteProperty(String newValueExpr){
		String oldValue = getWebSite();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setWebSite(newValue);
		//they are surely different each other
		this.onChangeProperty(WEB_SITE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAddress(newValue);
		//they are surely different each other
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeOperatedByProperty(String newValueExpr){
		String oldValue = getOperatedBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setOperatedBy(newValue);
		//they are surely different each other
		this.onChangeProperty(OPERATED_BY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLegalRepresentativeProperty(String newValueExpr){
		String oldValue = getLegalRepresentative();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLegalRepresentative(newValue);
		//they are surely different each other
		this.onChangeProperty(LEGAL_REPRESENTATIVE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setServiceNumber(String serviceNumber){
		this.mServiceNumber = trimString(serviceNumber);;
	}
	public String getServiceNumber(){
		return this.mServiceNumber;
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	
	
	public void setWebSite(String webSite){
		this.mWebSite = trimString(webSite);;
	}
	public String getWebSite(){
		return this.mWebSite;
	}
	
	
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	
	
	public void setOperatedBy(String operatedBy){
		this.mOperatedBy = trimString(operatedBy);;
	}
	public String getOperatedBy(){
		return this.mOperatedBy;
	}
	
	
	public void setLegalRepresentative(String legalRepresentative){
		this.mLegalRepresentative = trimString(legalRepresentative);;
	}
	public String getLegalRepresentative(){
		return this.mLegalRepresentative;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<Report> getReportList(){
		if(this.mReportList == null){
			this.mReportList = new SmartList<Report>();
		}
		return this.mReportList;	
	}
	public  void setReportList(SmartList<Report> reportList){
		for( Report report:reportList){
			report.setOwner(this);
		}
		
		this.mReportList = reportList;
		
	}
	
	public  void addReport(Report report){
		report.setOwner(this);
		getReportList().add(report);
	}
	public  void addReports(SmartList<Report> reportList){
		for( Report report:reportList){
			report.setOwner(this);
		}
		getReportList().addAll(reportList);
	}
	
	public  void removeReport(Report report){
	
		boolean result = getReportList().planToRemove(report);
        if(!result){
        	String message = "Report("+report.getId()+") with version='"+report.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveReportList", report);
		//the constant "toReport" will be replaced after refactoried.
	
	}
	
	public void copyReportFrom(Report report) {
		// TODO Auto-generated method stub
		
        Report reportInList = findTheReport(report);
        Report newReport = new Report();
        reportInList.copyTo(newReport);
        newReport.setVersion(0);//will trigger copy
        getReportList().add(newReport);
	}
	
	public  Report findTheReport(Report report){
		
		int index =  getReportList().indexOf(report);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Report("+report.getId()+") with version='"+report.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getReportList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpReportList(){
		getReportList().clear();
	}
	
	
	
	
	public  SmartList<Catalog> getCatalogList(){
		if(this.mCatalogList == null){
			this.mCatalogList = new SmartList<Catalog>();
		}
		return this.mCatalogList;	
	}
	public  void setCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setOwner(this);
		}
		
		this.mCatalogList = catalogList;
		
	}
	
	public  void addCatalog(Catalog catalog){
		catalog.setOwner(this);
		getCatalogList().add(catalog);
	}
	public  void addCatalogs(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setOwner(this);
		}
		getCatalogList().addAll(catalogList);
	}
	
	public  void removeCatalog(Catalog catalog){
	
		boolean result = getCatalogList().planToRemove(catalog);
        if(!result){
        	String message = "Catalog("+catalog.getId()+") with version='"+catalog.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveCatalogList", catalog);
		//the constant "toCatalog" will be replaced after refactoried.
	
	}
	
	public void copyCatalogFrom(Catalog catalog) {
		// TODO Auto-generated method stub
		
        Catalog catalogInList = findTheCatalog(catalog);
        Catalog newCatalog = new Catalog();
        catalogInList.copyTo(newCatalog);
        newCatalog.setVersion(0);//will trigger copy
        getCatalogList().add(newCatalog);
	}
	
	public  Catalog findTheCatalog(Catalog catalog){
		
		int index =  getCatalogList().indexOf(catalog);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Catalog("+catalog.getId()+") with version='"+catalog.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getCatalogList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCatalogList(){
		getCatalogList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreProvinceCenter> getRetailStoreProvinceCenterList(){
		if(this.mRetailStoreProvinceCenterList == null){
			this.mRetailStoreProvinceCenterList = new SmartList<RetailStoreProvinceCenter>();
		}
		return this.mRetailStoreProvinceCenterList;	
	}
	public  void setRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		for( RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList){
			retailStoreProvinceCenter.setCountry(this);
		}
		
		this.mRetailStoreProvinceCenterList = retailStoreProvinceCenterList;
		
	}
	
	public  void addRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter){
		retailStoreProvinceCenter.setCountry(this);
		getRetailStoreProvinceCenterList().add(retailStoreProvinceCenter);
	}
	public  void addRetailStoreProvinceCenters(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		for( RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList){
			retailStoreProvinceCenter.setCountry(this);
		}
		getRetailStoreProvinceCenterList().addAll(retailStoreProvinceCenterList);
	}
	
	public  void removeRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter){
	
		boolean result = getRetailStoreProvinceCenterList().planToRemove(retailStoreProvinceCenter);
        if(!result){
        	String message = "RetailStoreProvinceCenter("+retailStoreProvinceCenter.getId()+") with version='"+retailStoreProvinceCenter.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreProvinceCenterList", retailStoreProvinceCenter);
		//the constant "toRetailStoreProvinceCenter" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreProvinceCenterFrom(RetailStoreProvinceCenter retailStoreProvinceCenter) {
		// TODO Auto-generated method stub
		
        RetailStoreProvinceCenter retailStoreProvinceCenterInList = findTheRetailStoreProvinceCenter(retailStoreProvinceCenter);
        RetailStoreProvinceCenter newRetailStoreProvinceCenter = new RetailStoreProvinceCenter();
        retailStoreProvinceCenterInList.copyTo(newRetailStoreProvinceCenter);
        newRetailStoreProvinceCenter.setVersion(0);//will trigger copy
        getRetailStoreProvinceCenterList().add(newRetailStoreProvinceCenter);
	}
	
	public  RetailStoreProvinceCenter findTheRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter){
		
		int index =  getRetailStoreProvinceCenterList().indexOf(retailStoreProvinceCenter);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreProvinceCenter("+retailStoreProvinceCenter.getId()+") with version='"+retailStoreProvinceCenter.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreProvinceCenterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreProvinceCenterList(){
		getRetailStoreProvinceCenterList().clear();
	}
	
	
	
	
	public  SmartList<RetailStore> getRetailStoreList(){
		if(this.mRetailStoreList == null){
			this.mRetailStoreList = new SmartList<RetailStore>();
		}
		return this.mRetailStoreList;	
	}
	public  void setRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setRetailStoreCountryCenter(this);
		}
		
		this.mRetailStoreList = retailStoreList;
		
	}
	
	public  void addRetailStore(RetailStore retailStore){
		retailStore.setRetailStoreCountryCenter(this);
		getRetailStoreList().add(retailStore);
	}
	public  void addRetailStores(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setRetailStoreCountryCenter(this);
		}
		getRetailStoreList().addAll(retailStoreList);
	}
	
	public  void removeRetailStore(RetailStore retailStore){
	
		boolean result = getRetailStoreList().planToRemove(retailStore);
        if(!result){
        	String message = "RetailStore("+retailStore.getId()+") with version='"+retailStore.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreList", retailStore);
		//the constant "toRetailStore" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreFrom(RetailStore retailStore) {
		// TODO Auto-generated method stub
		
        RetailStore retailStoreInList = findTheRetailStore(retailStore);
        RetailStore newRetailStore = new RetailStore();
        retailStoreInList.copyTo(newRetailStore);
        newRetailStore.setVersion(0);//will trigger copy
        getRetailStoreList().add(newRetailStore);
	}
	
	public  RetailStore findTheRetailStore(RetailStore retailStore){
		
		int index =  getRetailStoreList().indexOf(retailStore);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStore("+retailStore.getId()+") with version='"+retailStore.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreList(){
		getRetailStoreList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreMember> getRetailStoreMemberList(){
		if(this.mRetailStoreMemberList == null){
			this.mRetailStoreMemberList = new SmartList<RetailStoreMember>();
		}
		return this.mRetailStoreMemberList;	
	}
	public  void setRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList){
		for( RetailStoreMember retailStoreMember:retailStoreMemberList){
			retailStoreMember.setOwner(this);
		}
		
		this.mRetailStoreMemberList = retailStoreMemberList;
		
	}
	
	public  void addRetailStoreMember(RetailStoreMember retailStoreMember){
		retailStoreMember.setOwner(this);
		getRetailStoreMemberList().add(retailStoreMember);
	}
	public  void addRetailStoreMembers(SmartList<RetailStoreMember> retailStoreMemberList){
		for( RetailStoreMember retailStoreMember:retailStoreMemberList){
			retailStoreMember.setOwner(this);
		}
		getRetailStoreMemberList().addAll(retailStoreMemberList);
	}
	
	public  void removeRetailStoreMember(RetailStoreMember retailStoreMember){
	
		boolean result = getRetailStoreMemberList().planToRemove(retailStoreMember);
        if(!result){
        	String message = "RetailStoreMember("+retailStoreMember.getId()+") with version='"+retailStoreMember.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreMemberList", retailStoreMember);
		//the constant "toRetailStoreMember" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreMemberFrom(RetailStoreMember retailStoreMember) {
		// TODO Auto-generated method stub
		
        RetailStoreMember retailStoreMemberInList = findTheRetailStoreMember(retailStoreMember);
        RetailStoreMember newRetailStoreMember = new RetailStoreMember();
        retailStoreMemberInList.copyTo(newRetailStoreMember);
        newRetailStoreMember.setVersion(0);//will trigger copy
        getRetailStoreMemberList().add(newRetailStoreMember);
	}
	
	public  RetailStoreMember findTheRetailStoreMember(RetailStoreMember retailStoreMember){
		
		int index =  getRetailStoreMemberList().indexOf(retailStoreMember);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreMember("+retailStoreMember.getId()+") with version='"+retailStoreMember.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreMemberList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberList(){
		getRetailStoreMemberList().clear();
	}
	
	
	
	
	public  SmartList<GoodsSupplier> getGoodsSupplierList(){
		if(this.mGoodsSupplierList == null){
			this.mGoodsSupplierList = new SmartList<GoodsSupplier>();
		}
		return this.mGoodsSupplierList;	
	}
	public  void setGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList){
		for( GoodsSupplier goodsSupplier:goodsSupplierList){
			goodsSupplier.setBelongTo(this);
		}
		
		this.mGoodsSupplierList = goodsSupplierList;
		
	}
	
	public  void addGoodsSupplier(GoodsSupplier goodsSupplier){
		goodsSupplier.setBelongTo(this);
		getGoodsSupplierList().add(goodsSupplier);
	}
	public  void addGoodsSuppliers(SmartList<GoodsSupplier> goodsSupplierList){
		for( GoodsSupplier goodsSupplier:goodsSupplierList){
			goodsSupplier.setBelongTo(this);
		}
		getGoodsSupplierList().addAll(goodsSupplierList);
	}
	
	public  void removeGoodsSupplier(GoodsSupplier goodsSupplier){
	
		boolean result = getGoodsSupplierList().planToRemove(goodsSupplier);
        if(!result){
        	String message = "GoodsSupplier("+goodsSupplier.getId()+") with version='"+goodsSupplier.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsSupplierList", goodsSupplier);
		//the constant "toGoodsSupplier" will be replaced after refactoried.
	
	}
	
	public void copyGoodsSupplierFrom(GoodsSupplier goodsSupplier) {
		// TODO Auto-generated method stub
		
        GoodsSupplier goodsSupplierInList = findTheGoodsSupplier(goodsSupplier);
        GoodsSupplier newGoodsSupplier = new GoodsSupplier();
        goodsSupplierInList.copyTo(newGoodsSupplier);
        newGoodsSupplier.setVersion(0);//will trigger copy
        getGoodsSupplierList().add(newGoodsSupplier);
	}
	
	public  GoodsSupplier findTheGoodsSupplier(GoodsSupplier goodsSupplier){
		
		int index =  getGoodsSupplierList().indexOf(goodsSupplier);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "GoodsSupplier("+goodsSupplier.getId()+") with version='"+goodsSupplier.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsSupplierList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsSupplierList(){
		getGoodsSupplierList().clear();
	}
	
	
	
	
	public  SmartList<SupplyOrder> getSupplyOrderList(){
		if(this.mSupplyOrderList == null){
			this.mSupplyOrderList = new SmartList<SupplyOrder>();
		}
		return this.mSupplyOrderList;	
	}
	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setBuyer(this);
		}
		
		this.mSupplyOrderList = supplyOrderList;
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setBuyer(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrders(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setBuyer(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
	}
	
	public  void removeSupplyOrder(SupplyOrder supplyOrder){
	
		boolean result = getSupplyOrderList().planToRemove(supplyOrder);
        if(!result){
        	String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSupplyOrderList", supplyOrder);
		//the constant "toSupplyOrder" will be replaced after refactoried.
	
	}
	
	public void copySupplyOrderFrom(SupplyOrder supplyOrder) {
		// TODO Auto-generated method stub
		
        SupplyOrder supplyOrderInList = findTheSupplyOrder(supplyOrder);
        SupplyOrder newSupplyOrder = new SupplyOrder();
        supplyOrderInList.copyTo(newSupplyOrder);
        newSupplyOrder.setVersion(0);//will trigger copy
        getSupplyOrderList().add(newSupplyOrder);
	}
	
	public  SupplyOrder findTheSupplyOrder(SupplyOrder supplyOrder){
		
		int index =  getSupplyOrderList().indexOf(supplyOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSupplyOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderList(){
		getSupplyOrderList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreOrder> getRetailStoreOrderList(){
		if(this.mRetailStoreOrderList == null){
			this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
		}
		return this.mRetailStoreOrderList;	
	}
	public  void setRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setSeller(this);
		}
		
		this.mRetailStoreOrderList = retailStoreOrderList;
		
	}
	
	public  void addRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		retailStoreOrder.setSeller(this);
		getRetailStoreOrderList().add(retailStoreOrder);
	}
	public  void addRetailStoreOrders(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setSeller(this);
		}
		getRetailStoreOrderList().addAll(retailStoreOrderList);
	}
	
	public  void removeRetailStoreOrder(RetailStoreOrder retailStoreOrder){
	
		boolean result = getRetailStoreOrderList().planToRemove(retailStoreOrder);
        if(!result){
        	String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreOrderList", retailStoreOrder);
		//the constant "toRetailStoreOrder" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreOrderFrom(RetailStoreOrder retailStoreOrder) {
		// TODO Auto-generated method stub
		
        RetailStoreOrder retailStoreOrderInList = findTheRetailStoreOrder(retailStoreOrder);
        RetailStoreOrder newRetailStoreOrder = new RetailStoreOrder();
        retailStoreOrderInList.copyTo(newRetailStoreOrder);
        newRetailStoreOrder.setVersion(0);//will trigger copy
        getRetailStoreOrderList().add(newRetailStoreOrder);
	}
	
	public  RetailStoreOrder findTheRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		
		int index =  getRetailStoreOrderList().indexOf(retailStoreOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderList(){
		getRetailStoreOrderList().clear();
	}
	
	
	
	
	public  SmartList<Warehouse> getWarehouseList(){
		if(this.mWarehouseList == null){
			this.mWarehouseList = new SmartList<Warehouse>();
		}
		return this.mWarehouseList;	
	}
	public  void setWarehouseList(SmartList<Warehouse> warehouseList){
		for( Warehouse warehouse:warehouseList){
			warehouse.setOwner(this);
		}
		
		this.mWarehouseList = warehouseList;
		
	}
	
	public  void addWarehouse(Warehouse warehouse){
		warehouse.setOwner(this);
		getWarehouseList().add(warehouse);
	}
	public  void addWarehouses(SmartList<Warehouse> warehouseList){
		for( Warehouse warehouse:warehouseList){
			warehouse.setOwner(this);
		}
		getWarehouseList().addAll(warehouseList);
	}
	
	public  void removeWarehouse(Warehouse warehouse){
	
		boolean result = getWarehouseList().planToRemove(warehouse);
        if(!result){
        	String message = "Warehouse("+warehouse.getId()+") with version='"+warehouse.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveWarehouseList", warehouse);
		//the constant "toWarehouse" will be replaced after refactoried.
	
	}
	
	public void copyWarehouseFrom(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
        Warehouse warehouseInList = findTheWarehouse(warehouse);
        Warehouse newWarehouse = new Warehouse();
        warehouseInList.copyTo(newWarehouse);
        newWarehouse.setVersion(0);//will trigger copy
        getWarehouseList().add(newWarehouse);
	}
	
	public  Warehouse findTheWarehouse(Warehouse warehouse){
		
		int index =  getWarehouseList().indexOf(warehouse);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Warehouse("+warehouse.getId()+") with version='"+warehouse.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getWarehouseList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpWarehouseList(){
		getWarehouseList().clear();
	}
	
	
	
	
	public  SmartList<TransportFleet> getTransportFleetList(){
		if(this.mTransportFleetList == null){
			this.mTransportFleetList = new SmartList<TransportFleet>();
		}
		return this.mTransportFleetList;	
	}
	public  void setTransportFleetList(SmartList<TransportFleet> transportFleetList){
		for( TransportFleet transportFleet:transportFleetList){
			transportFleet.setOwner(this);
		}
		
		this.mTransportFleetList = transportFleetList;
		
	}
	
	public  void addTransportFleet(TransportFleet transportFleet){
		transportFleet.setOwner(this);
		getTransportFleetList().add(transportFleet);
	}
	public  void addTransportFleets(SmartList<TransportFleet> transportFleetList){
		for( TransportFleet transportFleet:transportFleetList){
			transportFleet.setOwner(this);
		}
		getTransportFleetList().addAll(transportFleetList);
	}
	
	public  void removeTransportFleet(TransportFleet transportFleet){
	
		boolean result = getTransportFleetList().planToRemove(transportFleet);
        if(!result){
        	String message = "TransportFleet("+transportFleet.getId()+") with version='"+transportFleet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTransportFleetList", transportFleet);
		//the constant "toTransportFleet" will be replaced after refactoried.
	
	}
	
	public void copyTransportFleetFrom(TransportFleet transportFleet) {
		// TODO Auto-generated method stub
		
        TransportFleet transportFleetInList = findTheTransportFleet(transportFleet);
        TransportFleet newTransportFleet = new TransportFleet();
        transportFleetInList.copyTo(newTransportFleet);
        newTransportFleet.setVersion(0);//will trigger copy
        getTransportFleetList().add(newTransportFleet);
	}
	
	public  TransportFleet findTheTransportFleet(TransportFleet transportFleet){
		
		int index =  getTransportFleetList().indexOf(transportFleet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TransportFleet("+transportFleet.getId()+") with version='"+transportFleet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTransportFleetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportFleetList(){
		getTransportFleetList().clear();
	}
	
	
	
	
	public  SmartList<AccountSet> getAccountSetList(){
		if(this.mAccountSetList == null){
			this.mAccountSetList = new SmartList<AccountSet>();
		}
		return this.mAccountSetList;	
	}
	public  void setAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setCountryCenter(this);
		}
		
		this.mAccountSetList = accountSetList;
		
	}
	
	public  void addAccountSet(AccountSet accountSet){
		accountSet.setCountryCenter(this);
		getAccountSetList().add(accountSet);
	}
	public  void addAccountSets(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setCountryCenter(this);
		}
		getAccountSetList().addAll(accountSetList);
	}
	
	public  void removeAccountSet(AccountSet accountSet){
	
		boolean result = getAccountSetList().planToRemove(accountSet);
        if(!result){
        	String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountSetList", accountSet);
		//the constant "toAccountSet" will be replaced after refactoried.
	
	}
	
	public void copyAccountSetFrom(AccountSet accountSet) {
		// TODO Auto-generated method stub
		
        AccountSet accountSetInList = findTheAccountSet(accountSet);
        AccountSet newAccountSet = new AccountSet();
        accountSetInList.copyTo(newAccountSet);
        newAccountSet.setVersion(0);//will trigger copy
        getAccountSetList().add(newAccountSet);
	}
	
	public  AccountSet findTheAccountSet(AccountSet accountSet){
		
		int index =  getAccountSetList().indexOf(accountSet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountSetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountSetList(){
		getAccountSetList().clear();
	}
	
	
	
	
	public  SmartList<LevelOneDepartment> getLevelOneDepartmentList(){
		if(this.mLevelOneDepartmentList == null){
			this.mLevelOneDepartmentList = new SmartList<LevelOneDepartment>();
		}
		return this.mLevelOneDepartmentList;	
	}
	public  void setLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList){
		for( LevelOneDepartment levelOneDepartment:levelOneDepartmentList){
			levelOneDepartment.setBelongsTo(this);
		}
		
		this.mLevelOneDepartmentList = levelOneDepartmentList;
		
	}
	
	public  void addLevelOneDepartment(LevelOneDepartment levelOneDepartment){
		levelOneDepartment.setBelongsTo(this);
		getLevelOneDepartmentList().add(levelOneDepartment);
	}
	public  void addLevelOneDepartments(SmartList<LevelOneDepartment> levelOneDepartmentList){
		for( LevelOneDepartment levelOneDepartment:levelOneDepartmentList){
			levelOneDepartment.setBelongsTo(this);
		}
		getLevelOneDepartmentList().addAll(levelOneDepartmentList);
	}
	
	public  void removeLevelOneDepartment(LevelOneDepartment levelOneDepartment){
	
		boolean result = getLevelOneDepartmentList().planToRemove(levelOneDepartment);
        if(!result){
        	String message = "LevelOneDepartment("+levelOneDepartment.getId()+") with version='"+levelOneDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveLevelOneDepartmentList", levelOneDepartment);
		//the constant "toLevelOneDepartment" will be replaced after refactoried.
	
	}
	
	public void copyLevelOneDepartmentFrom(LevelOneDepartment levelOneDepartment) {
		// TODO Auto-generated method stub
		
        LevelOneDepartment levelOneDepartmentInList = findTheLevelOneDepartment(levelOneDepartment);
        LevelOneDepartment newLevelOneDepartment = new LevelOneDepartment();
        levelOneDepartmentInList.copyTo(newLevelOneDepartment);
        newLevelOneDepartment.setVersion(0);//will trigger copy
        getLevelOneDepartmentList().add(newLevelOneDepartment);
	}
	
	public  LevelOneDepartment findTheLevelOneDepartment(LevelOneDepartment levelOneDepartment){
		
		int index =  getLevelOneDepartmentList().indexOf(levelOneDepartment);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "LevelOneDepartment("+levelOneDepartment.getId()+") with version='"+levelOneDepartment.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getLevelOneDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelOneDepartmentList(){
		getLevelOneDepartmentList().clear();
	}
	
	
	
	
	public  SmartList<SkillType> getSkillTypeList(){
		if(this.mSkillTypeList == null){
			this.mSkillTypeList = new SmartList<SkillType>();
		}
		return this.mSkillTypeList;	
	}
	public  void setSkillTypeList(SmartList<SkillType> skillTypeList){
		for( SkillType skillType:skillTypeList){
			skillType.setCompany(this);
		}
		
		this.mSkillTypeList = skillTypeList;
		
	}
	
	public  void addSkillType(SkillType skillType){
		skillType.setCompany(this);
		getSkillTypeList().add(skillType);
	}
	public  void addSkillTypes(SmartList<SkillType> skillTypeList){
		for( SkillType skillType:skillTypeList){
			skillType.setCompany(this);
		}
		getSkillTypeList().addAll(skillTypeList);
	}
	
	public  void removeSkillType(SkillType skillType){
	
		boolean result = getSkillTypeList().planToRemove(skillType);
        if(!result){
        	String message = "SkillType("+skillType.getId()+") with version='"+skillType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSkillTypeList", skillType);
		//the constant "toSkillType" will be replaced after refactoried.
	
	}
	
	public void copySkillTypeFrom(SkillType skillType) {
		// TODO Auto-generated method stub
		
        SkillType skillTypeInList = findTheSkillType(skillType);
        SkillType newSkillType = new SkillType();
        skillTypeInList.copyTo(newSkillType);
        newSkillType.setVersion(0);//will trigger copy
        getSkillTypeList().add(newSkillType);
	}
	
	public  SkillType findTheSkillType(SkillType skillType){
		
		int index =  getSkillTypeList().indexOf(skillType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SkillType("+skillType.getId()+") with version='"+skillType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSkillTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSkillTypeList(){
		getSkillTypeList().clear();
	}
	
	
	
	
	public  SmartList<ResponsibilityType> getResponsibilityTypeList(){
		if(this.mResponsibilityTypeList == null){
			this.mResponsibilityTypeList = new SmartList<ResponsibilityType>();
		}
		return this.mResponsibilityTypeList;	
	}
	public  void setResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList){
		for( ResponsibilityType responsibilityType:responsibilityTypeList){
			responsibilityType.setCompany(this);
		}
		
		this.mResponsibilityTypeList = responsibilityTypeList;
		
	}
	
	public  void addResponsibilityType(ResponsibilityType responsibilityType){
		responsibilityType.setCompany(this);
		getResponsibilityTypeList().add(responsibilityType);
	}
	public  void addResponsibilityTypes(SmartList<ResponsibilityType> responsibilityTypeList){
		for( ResponsibilityType responsibilityType:responsibilityTypeList){
			responsibilityType.setCompany(this);
		}
		getResponsibilityTypeList().addAll(responsibilityTypeList);
	}
	
	public  void removeResponsibilityType(ResponsibilityType responsibilityType){
	
		boolean result = getResponsibilityTypeList().planToRemove(responsibilityType);
        if(!result){
        	String message = "ResponsibilityType("+responsibilityType.getId()+") with version='"+responsibilityType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveResponsibilityTypeList", responsibilityType);
		//the constant "toResponsibilityType" will be replaced after refactoried.
	
	}
	
	public void copyResponsibilityTypeFrom(ResponsibilityType responsibilityType) {
		// TODO Auto-generated method stub
		
        ResponsibilityType responsibilityTypeInList = findTheResponsibilityType(responsibilityType);
        ResponsibilityType newResponsibilityType = new ResponsibilityType();
        responsibilityTypeInList.copyTo(newResponsibilityType);
        newResponsibilityType.setVersion(0);//will trigger copy
        getResponsibilityTypeList().add(newResponsibilityType);
	}
	
	public  ResponsibilityType findTheResponsibilityType(ResponsibilityType responsibilityType){
		
		int index =  getResponsibilityTypeList().indexOf(responsibilityType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ResponsibilityType("+responsibilityType.getId()+") with version='"+responsibilityType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getResponsibilityTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpResponsibilityTypeList(){
		getResponsibilityTypeList().clear();
	}
	
	
	
	
	public  SmartList<TerminationReason> getTerminationReasonList(){
		if(this.mTerminationReasonList == null){
			this.mTerminationReasonList = new SmartList<TerminationReason>();
		}
		return this.mTerminationReasonList;	
	}
	public  void setTerminationReasonList(SmartList<TerminationReason> terminationReasonList){
		for( TerminationReason terminationReason:terminationReasonList){
			terminationReason.setCompany(this);
		}
		
		this.mTerminationReasonList = terminationReasonList;
		
	}
	
	public  void addTerminationReason(TerminationReason terminationReason){
		terminationReason.setCompany(this);
		getTerminationReasonList().add(terminationReason);
	}
	public  void addTerminationReasons(SmartList<TerminationReason> terminationReasonList){
		for( TerminationReason terminationReason:terminationReasonList){
			terminationReason.setCompany(this);
		}
		getTerminationReasonList().addAll(terminationReasonList);
	}
	
	public  void removeTerminationReason(TerminationReason terminationReason){
	
		boolean result = getTerminationReasonList().planToRemove(terminationReason);
        if(!result){
        	String message = "TerminationReason("+terminationReason.getId()+") with version='"+terminationReason.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTerminationReasonList", terminationReason);
		//the constant "toTerminationReason" will be replaced after refactoried.
	
	}
	
	public void copyTerminationReasonFrom(TerminationReason terminationReason) {
		// TODO Auto-generated method stub
		
        TerminationReason terminationReasonInList = findTheTerminationReason(terminationReason);
        TerminationReason newTerminationReason = new TerminationReason();
        terminationReasonInList.copyTo(newTerminationReason);
        newTerminationReason.setVersion(0);//will trigger copy
        getTerminationReasonList().add(newTerminationReason);
	}
	
	public  TerminationReason findTheTerminationReason(TerminationReason terminationReason){
		
		int index =  getTerminationReasonList().indexOf(terminationReason);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TerminationReason("+terminationReason.getId()+") with version='"+terminationReason.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTerminationReasonList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTerminationReasonList(){
		getTerminationReasonList().clear();
	}
	
	
	
	
	public  SmartList<TerminationType> getTerminationTypeList(){
		if(this.mTerminationTypeList == null){
			this.mTerminationTypeList = new SmartList<TerminationType>();
		}
		return this.mTerminationTypeList;	
	}
	public  void setTerminationTypeList(SmartList<TerminationType> terminationTypeList){
		for( TerminationType terminationType:terminationTypeList){
			terminationType.setCompany(this);
		}
		
		this.mTerminationTypeList = terminationTypeList;
		
	}
	
	public  void addTerminationType(TerminationType terminationType){
		terminationType.setCompany(this);
		getTerminationTypeList().add(terminationType);
	}
	public  void addTerminationTypes(SmartList<TerminationType> terminationTypeList){
		for( TerminationType terminationType:terminationTypeList){
			terminationType.setCompany(this);
		}
		getTerminationTypeList().addAll(terminationTypeList);
	}
	
	public  void removeTerminationType(TerminationType terminationType){
	
		boolean result = getTerminationTypeList().planToRemove(terminationType);
        if(!result){
        	String message = "TerminationType("+terminationType.getId()+") with version='"+terminationType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTerminationTypeList", terminationType);
		//the constant "toTerminationType" will be replaced after refactoried.
	
	}
	
	public void copyTerminationTypeFrom(TerminationType terminationType) {
		// TODO Auto-generated method stub
		
        TerminationType terminationTypeInList = findTheTerminationType(terminationType);
        TerminationType newTerminationType = new TerminationType();
        terminationTypeInList.copyTo(newTerminationType);
        newTerminationType.setVersion(0);//will trigger copy
        getTerminationTypeList().add(newTerminationType);
	}
	
	public  TerminationType findTheTerminationType(TerminationType terminationType){
		
		int index =  getTerminationTypeList().indexOf(terminationType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TerminationType("+terminationType.getId()+") with version='"+terminationType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTerminationTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTerminationTypeList(){
		getTerminationTypeList().clear();
	}
	
	
	
	
	public  SmartList<OccupationType> getOccupationTypeList(){
		if(this.mOccupationTypeList == null){
			this.mOccupationTypeList = new SmartList<OccupationType>();
		}
		return this.mOccupationTypeList;	
	}
	public  void setOccupationTypeList(SmartList<OccupationType> occupationTypeList){
		for( OccupationType occupationType:occupationTypeList){
			occupationType.setCompany(this);
		}
		
		this.mOccupationTypeList = occupationTypeList;
		
	}
	
	public  void addOccupationType(OccupationType occupationType){
		occupationType.setCompany(this);
		getOccupationTypeList().add(occupationType);
	}
	public  void addOccupationTypes(SmartList<OccupationType> occupationTypeList){
		for( OccupationType occupationType:occupationTypeList){
			occupationType.setCompany(this);
		}
		getOccupationTypeList().addAll(occupationTypeList);
	}
	
	public  void removeOccupationType(OccupationType occupationType){
	
		boolean result = getOccupationTypeList().planToRemove(occupationType);
        if(!result){
        	String message = "OccupationType("+occupationType.getId()+") with version='"+occupationType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveOccupationTypeList", occupationType);
		//the constant "toOccupationType" will be replaced after refactoried.
	
	}
	
	public void copyOccupationTypeFrom(OccupationType occupationType) {
		// TODO Auto-generated method stub
		
        OccupationType occupationTypeInList = findTheOccupationType(occupationType);
        OccupationType newOccupationType = new OccupationType();
        occupationTypeInList.copyTo(newOccupationType);
        newOccupationType.setVersion(0);//will trigger copy
        getOccupationTypeList().add(newOccupationType);
	}
	
	public  OccupationType findTheOccupationType(OccupationType occupationType){
		
		int index =  getOccupationTypeList().indexOf(occupationType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "OccupationType("+occupationType.getId()+") with version='"+occupationType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getOccupationTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOccupationTypeList(){
		getOccupationTypeList().clear();
	}
	
	
	
	
	public  SmartList<LeaveType> getLeaveTypeList(){
		if(this.mLeaveTypeList == null){
			this.mLeaveTypeList = new SmartList<LeaveType>();
		}
		return this.mLeaveTypeList;	
	}
	public  void setLeaveTypeList(SmartList<LeaveType> leaveTypeList){
		for( LeaveType leaveType:leaveTypeList){
			leaveType.setCompany(this);
		}
		
		this.mLeaveTypeList = leaveTypeList;
		
	}
	
	public  void addLeaveType(LeaveType leaveType){
		leaveType.setCompany(this);
		getLeaveTypeList().add(leaveType);
	}
	public  void addLeaveTypes(SmartList<LeaveType> leaveTypeList){
		for( LeaveType leaveType:leaveTypeList){
			leaveType.setCompany(this);
		}
		getLeaveTypeList().addAll(leaveTypeList);
	}
	
	public  void removeLeaveType(LeaveType leaveType){
	
		boolean result = getLeaveTypeList().planToRemove(leaveType);
        if(!result){
        	String message = "LeaveType("+leaveType.getId()+") with version='"+leaveType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveLeaveTypeList", leaveType);
		//the constant "toLeaveType" will be replaced after refactoried.
	
	}
	
	public void copyLeaveTypeFrom(LeaveType leaveType) {
		// TODO Auto-generated method stub
		
        LeaveType leaveTypeInList = findTheLeaveType(leaveType);
        LeaveType newLeaveType = new LeaveType();
        leaveTypeInList.copyTo(newLeaveType);
        newLeaveType.setVersion(0);//will trigger copy
        getLeaveTypeList().add(newLeaveType);
	}
	
	public  LeaveType findTheLeaveType(LeaveType leaveType){
		
		int index =  getLeaveTypeList().indexOf(leaveType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "LeaveType("+leaveType.getId()+") with version='"+leaveType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getLeaveTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLeaveTypeList(){
		getLeaveTypeList().clear();
	}
	
	
	
	
	public  SmartList<SalaryGrade> getSalaryGradeList(){
		if(this.mSalaryGradeList == null){
			this.mSalaryGradeList = new SmartList<SalaryGrade>();
		}
		return this.mSalaryGradeList;	
	}
	public  void setSalaryGradeList(SmartList<SalaryGrade> salaryGradeList){
		for( SalaryGrade salaryGrade:salaryGradeList){
			salaryGrade.setCompany(this);
		}
		
		this.mSalaryGradeList = salaryGradeList;
		
	}
	
	public  void addSalaryGrade(SalaryGrade salaryGrade){
		salaryGrade.setCompany(this);
		getSalaryGradeList().add(salaryGrade);
	}
	public  void addSalaryGrades(SmartList<SalaryGrade> salaryGradeList){
		for( SalaryGrade salaryGrade:salaryGradeList){
			salaryGrade.setCompany(this);
		}
		getSalaryGradeList().addAll(salaryGradeList);
	}
	
	public  void removeSalaryGrade(SalaryGrade salaryGrade){
	
		boolean result = getSalaryGradeList().planToRemove(salaryGrade);
        if(!result){
        	String message = "SalaryGrade("+salaryGrade.getId()+") with version='"+salaryGrade.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveSalaryGradeList", salaryGrade);
		//the constant "toSalaryGrade" will be replaced after refactoried.
	
	}
	
	public void copySalaryGradeFrom(SalaryGrade salaryGrade) {
		// TODO Auto-generated method stub
		
        SalaryGrade salaryGradeInList = findTheSalaryGrade(salaryGrade);
        SalaryGrade newSalaryGrade = new SalaryGrade();
        salaryGradeInList.copyTo(newSalaryGrade);
        newSalaryGrade.setVersion(0);//will trigger copy
        getSalaryGradeList().add(newSalaryGrade);
	}
	
	public  SalaryGrade findTheSalaryGrade(SalaryGrade salaryGrade){
		
		int index =  getSalaryGradeList().indexOf(salaryGrade);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "SalaryGrade("+salaryGrade.getId()+") with version='"+salaryGrade.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getSalaryGradeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSalaryGradeList(){
		getSalaryGradeList().clear();
	}
	
	
	
	
	public  SmartList<InterviewType> getInterviewTypeList(){
		if(this.mInterviewTypeList == null){
			this.mInterviewTypeList = new SmartList<InterviewType>();
		}
		return this.mInterviewTypeList;	
	}
	public  void setInterviewTypeList(SmartList<InterviewType> interviewTypeList){
		for( InterviewType interviewType:interviewTypeList){
			interviewType.setCompany(this);
		}
		
		this.mInterviewTypeList = interviewTypeList;
		
	}
	
	public  void addInterviewType(InterviewType interviewType){
		interviewType.setCompany(this);
		getInterviewTypeList().add(interviewType);
	}
	public  void addInterviewTypes(SmartList<InterviewType> interviewTypeList){
		for( InterviewType interviewType:interviewTypeList){
			interviewType.setCompany(this);
		}
		getInterviewTypeList().addAll(interviewTypeList);
	}
	
	public  void removeInterviewType(InterviewType interviewType){
	
		boolean result = getInterviewTypeList().planToRemove(interviewType);
        if(!result){
        	String message = "InterviewType("+interviewType.getId()+") with version='"+interviewType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveInterviewTypeList", interviewType);
		//the constant "toInterviewType" will be replaced after refactoried.
	
	}
	
	public void copyInterviewTypeFrom(InterviewType interviewType) {
		// TODO Auto-generated method stub
		
        InterviewType interviewTypeInList = findTheInterviewType(interviewType);
        InterviewType newInterviewType = new InterviewType();
        interviewTypeInList.copyTo(newInterviewType);
        newInterviewType.setVersion(0);//will trigger copy
        getInterviewTypeList().add(newInterviewType);
	}
	
	public  InterviewType findTheInterviewType(InterviewType interviewType){
		
		int index =  getInterviewTypeList().indexOf(interviewType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "InterviewType("+interviewType.getId()+") with version='"+interviewType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getInterviewTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpInterviewTypeList(){
		getInterviewTypeList().clear();
	}
	
	
	
	
	public  SmartList<TrainingCourseType> getTrainingCourseTypeList(){
		if(this.mTrainingCourseTypeList == null){
			this.mTrainingCourseTypeList = new SmartList<TrainingCourseType>();
		}
		return this.mTrainingCourseTypeList;	
	}
	public  void setTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList){
		for( TrainingCourseType trainingCourseType:trainingCourseTypeList){
			trainingCourseType.setCompany(this);
		}
		
		this.mTrainingCourseTypeList = trainingCourseTypeList;
		
	}
	
	public  void addTrainingCourseType(TrainingCourseType trainingCourseType){
		trainingCourseType.setCompany(this);
		getTrainingCourseTypeList().add(trainingCourseType);
	}
	public  void addTrainingCourseTypes(SmartList<TrainingCourseType> trainingCourseTypeList){
		for( TrainingCourseType trainingCourseType:trainingCourseTypeList){
			trainingCourseType.setCompany(this);
		}
		getTrainingCourseTypeList().addAll(trainingCourseTypeList);
	}
	
	public  void removeTrainingCourseType(TrainingCourseType trainingCourseType){
	
		boolean result = getTrainingCourseTypeList().planToRemove(trainingCourseType);
        if(!result){
        	String message = "TrainingCourseType("+trainingCourseType.getId()+") with version='"+trainingCourseType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTrainingCourseTypeList", trainingCourseType);
		//the constant "toTrainingCourseType" will be replaced after refactoried.
	
	}
	
	public void copyTrainingCourseTypeFrom(TrainingCourseType trainingCourseType) {
		// TODO Auto-generated method stub
		
        TrainingCourseType trainingCourseTypeInList = findTheTrainingCourseType(trainingCourseType);
        TrainingCourseType newTrainingCourseType = new TrainingCourseType();
        trainingCourseTypeInList.copyTo(newTrainingCourseType);
        newTrainingCourseType.setVersion(0);//will trigger copy
        getTrainingCourseTypeList().add(newTrainingCourseType);
	}
	
	public  TrainingCourseType findTheTrainingCourseType(TrainingCourseType trainingCourseType){
		
		int index =  getTrainingCourseTypeList().indexOf(trainingCourseType);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TrainingCourseType("+trainingCourseType.getId()+") with version='"+trainingCourseType.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTrainingCourseTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTrainingCourseTypeList(){
		getTrainingCourseTypeList().clear();
	}
	
	
	
	
	public  SmartList<PublicHoliday> getPublicHolidayList(){
		if(this.mPublicHolidayList == null){
			this.mPublicHolidayList = new SmartList<PublicHoliday>();
		}
		return this.mPublicHolidayList;	
	}
	public  void setPublicHolidayList(SmartList<PublicHoliday> publicHolidayList){
		for( PublicHoliday publicHoliday:publicHolidayList){
			publicHoliday.setCompany(this);
		}
		
		this.mPublicHolidayList = publicHolidayList;
		
	}
	
	public  void addPublicHoliday(PublicHoliday publicHoliday){
		publicHoliday.setCompany(this);
		getPublicHolidayList().add(publicHoliday);
	}
	public  void addPublicHolidays(SmartList<PublicHoliday> publicHolidayList){
		for( PublicHoliday publicHoliday:publicHolidayList){
			publicHoliday.setCompany(this);
		}
		getPublicHolidayList().addAll(publicHolidayList);
	}
	
	public  void removePublicHoliday(PublicHoliday publicHoliday){
	
		boolean result = getPublicHolidayList().planToRemove(publicHoliday);
        if(!result){
        	String message = "PublicHoliday("+publicHoliday.getId()+") with version='"+publicHoliday.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemovePublicHolidayList", publicHoliday);
		//the constant "toPublicHoliday" will be replaced after refactoried.
	
	}
	
	public void copyPublicHolidayFrom(PublicHoliday publicHoliday) {
		// TODO Auto-generated method stub
		
        PublicHoliday publicHolidayInList = findThePublicHoliday(publicHoliday);
        PublicHoliday newPublicHoliday = new PublicHoliday();
        publicHolidayInList.copyTo(newPublicHoliday);
        newPublicHoliday.setVersion(0);//will trigger copy
        getPublicHolidayList().add(newPublicHoliday);
	}
	
	public  PublicHoliday findThePublicHoliday(PublicHoliday publicHoliday){
		
		int index =  getPublicHolidayList().indexOf(publicHoliday);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "PublicHoliday("+publicHoliday.getId()+") with version='"+publicHoliday.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getPublicHolidayList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPublicHolidayList(){
		getPublicHolidayList().clear();
	}
	
	
	
	
	public  SmartList<Employee> getEmployeeList(){
		if(this.mEmployeeList == null){
			this.mEmployeeList = new SmartList<Employee>();
		}
		return this.mEmployeeList;	
	}
	public  void setEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCompany(this);
		}
		
		this.mEmployeeList = employeeList;
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setCompany(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployees(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCompany(this);
		}
		getEmployeeList().addAll(employeeList);
	}
	
	public  void removeEmployee(Employee employee){
	
		boolean result = getEmployeeList().planToRemove(employee);
        if(!result){
        	String message = "Employee("+employee.getId()+") with version='"+employee.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeList", employee);
		//the constant "toEmployee" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeFrom(Employee employee) {
		// TODO Auto-generated method stub
		
        Employee employeeInList = findTheEmployee(employee);
        Employee newEmployee = new Employee();
        employeeInList.copyTo(newEmployee);
        newEmployee.setVersion(0);//will trigger copy
        getEmployeeList().add(newEmployee);
	}
	
	public  Employee findTheEmployee(Employee employee){
		
		int index =  getEmployeeList().indexOf(employee);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Employee("+employee.getId()+") with version='"+employee.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeList(){
		getEmployeeList().clear();
	}
	
	
	
	
	public  SmartList<Instructor> getInstructorList(){
		if(this.mInstructorList == null){
			this.mInstructorList = new SmartList<Instructor>();
		}
		return this.mInstructorList;	
	}
	public  void setInstructorList(SmartList<Instructor> instructorList){
		for( Instructor instructor:instructorList){
			instructor.setCompany(this);
		}
		
		this.mInstructorList = instructorList;
		
	}
	
	public  void addInstructor(Instructor instructor){
		instructor.setCompany(this);
		getInstructorList().add(instructor);
	}
	public  void addInstructors(SmartList<Instructor> instructorList){
		for( Instructor instructor:instructorList){
			instructor.setCompany(this);
		}
		getInstructorList().addAll(instructorList);
	}
	
	public  void removeInstructor(Instructor instructor){
	
		boolean result = getInstructorList().planToRemove(instructor);
        if(!result){
        	String message = "Instructor("+instructor.getId()+") with version='"+instructor.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveInstructorList", instructor);
		//the constant "toInstructor" will be replaced after refactoried.
	
	}
	
	public void copyInstructorFrom(Instructor instructor) {
		// TODO Auto-generated method stub
		
        Instructor instructorInList = findTheInstructor(instructor);
        Instructor newInstructor = new Instructor();
        instructorInList.copyTo(newInstructor);
        newInstructor.setVersion(0);//will trigger copy
        getInstructorList().add(newInstructor);
	}
	
	public  Instructor findTheInstructor(Instructor instructor){
		
		int index =  getInstructorList().indexOf(instructor);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Instructor("+instructor.getId()+") with version='"+instructor.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getInstructorList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpInstructorList(){
		getInstructorList().clear();
	}
	
	
	
	
	public  SmartList<CompanyTraining> getCompanyTrainingList(){
		if(this.mCompanyTrainingList == null){
			this.mCompanyTrainingList = new SmartList<CompanyTraining>();
		}
		return this.mCompanyTrainingList;	
	}
	public  void setCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setCompany(this);
		}
		
		this.mCompanyTrainingList = companyTrainingList;
		
	}
	
	public  void addCompanyTraining(CompanyTraining companyTraining){
		companyTraining.setCompany(this);
		getCompanyTrainingList().add(companyTraining);
	}
	public  void addCompanyTrainings(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setCompany(this);
		}
		getCompanyTrainingList().addAll(companyTrainingList);
	}
	
	public  void removeCompanyTraining(CompanyTraining companyTraining){
	
		boolean result = getCompanyTrainingList().planToRemove(companyTraining);
        if(!result){
        	String message = "CompanyTraining("+companyTraining.getId()+") with version='"+companyTraining.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveCompanyTrainingList", companyTraining);
		//the constant "toCompanyTraining" will be replaced after refactoried.
	
	}
	
	public void copyCompanyTrainingFrom(CompanyTraining companyTraining) {
		// TODO Auto-generated method stub
		
        CompanyTraining companyTrainingInList = findTheCompanyTraining(companyTraining);
        CompanyTraining newCompanyTraining = new CompanyTraining();
        companyTrainingInList.copyTo(newCompanyTraining);
        newCompanyTraining.setVersion(0);//will trigger copy
        getCompanyTrainingList().add(newCompanyTraining);
	}
	
	public  CompanyTraining findTheCompanyTraining(CompanyTraining companyTraining){
		
		int index =  getCompanyTrainingList().indexOf(companyTraining);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "CompanyTraining("+companyTraining.getId()+") with version='"+companyTraining.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getCompanyTrainingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCompanyTrainingList(){
		getCompanyTrainingList().clear();
	}
	
	
	
	
 	
	
	public RetailStoreCountryCenter copyTo(RetailStoreCountryCenter dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setServiceNumber(getServiceNumber());
		dest.setFounded(getFounded());
		dest.setWebSite(getWebSite());
		dest.setAddress(getAddress());
		dest.setOperatedBy(getOperatedBy());
		dest.setLegalRepresentative(getLegalRepresentative());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setReportList(getReportList());
		dest.setCatalogList(getCatalogList());
		dest.setRetailStoreProvinceCenterList(getRetailStoreProvinceCenterList());
		dest.setRetailStoreList(getRetailStoreList());
		dest.setRetailStoreMemberList(getRetailStoreMemberList());
		dest.setGoodsSupplierList(getGoodsSupplierList());
		dest.setSupplyOrderList(getSupplyOrderList());
		dest.setRetailStoreOrderList(getRetailStoreOrderList());
		dest.setWarehouseList(getWarehouseList());
		dest.setTransportFleetList(getTransportFleetList());
		dest.setAccountSetList(getAccountSetList());
		dest.setLevelOneDepartmentList(getLevelOneDepartmentList());
		dest.setSkillTypeList(getSkillTypeList());
		dest.setResponsibilityTypeList(getResponsibilityTypeList());
		dest.setTerminationReasonList(getTerminationReasonList());
		dest.setTerminationTypeList(getTerminationTypeList());
		dest.setOccupationTypeList(getOccupationTypeList());
		dest.setLeaveTypeList(getLeaveTypeList());
		dest.setSalaryGradeList(getSalaryGradeList());
		dest.setInterviewTypeList(getInterviewTypeList());
		dest.setTrainingCourseTypeList(getTrainingCourseTypeList());
		dest.setPublicHolidayList(getPublicHolidayList());
		dest.setEmployeeList(getEmployeeList());
		dest.setInstructorList(getInstructorList());
		dest.setCompanyTrainingList(getCompanyTrainingList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_country_center{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tservice_number='"+getServiceNumber()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tweb_site='"+getWebSite()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\toperated_by='"+getOperatedBy()+"';");
		stringBuilder.append("\tlegal_representative='"+getLegalRepresentative()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

