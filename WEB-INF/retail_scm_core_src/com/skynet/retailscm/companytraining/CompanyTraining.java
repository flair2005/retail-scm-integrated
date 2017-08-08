
package com.skynet.retailscm.companytraining;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.instructor.Instructor;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.skynet.retailscm.trainingcoursetype.TrainingCourseType;

@JsonSerialize(using = CompanyTrainingSerializer.class)
public class CompanyTraining extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String INSTRUCTOR_PROPERTY            = "instructor"        ;
	public static final String TRAINING_COURSE_TYPE_PROPERTY  = "trainingCourseType";
	public static final String TIME_START_PROPERTY            = "timeStart"         ;
	public static final String DURATION_HOURS_PROPERTY        = "durationHours"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_COMPANY_TRAINING_LIST           = "employeeCompanyTrainingList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		Instructor          	mInstructor         ;
	protected		TrainingCourseType  	mTrainingCourseType ;
	protected		Date                	mTimeStart          ;
	protected		int                 	mDurationHours      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeCompanyTraining>	mEmployeeCompanyTrainingList;
	
		
	public 	CompanyTraining(){
		//lazy load for all the properties
	}
	
	public 	CompanyTraining(String title, RetailStoreCountryCenter company, Instructor instructor, TrainingCourseType trainingCourseType, Date timeStart, int durationHours
)
	{
		setTitle(title);
		setCompany(company);
		setInstructor(instructor);
		setTrainingCourseType(trainingCourseType);
		setTimeStart(timeStart);
		setDurationHours(durationHours);

		this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(TIME_START_PROPERTY.equals(property)){
			changeTimeStartProperty(newValueExpr);
		}
		if(DURATION_HOURS_PROPERTY.equals(property)){
			changeDurationHoursProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTitle(newValue);
		//they are surely different each other
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeTimeStartProperty(String newValueExpr){
		Date oldValue = getTimeStart();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTimeStart(newValue);
		//they are surely different each other
		this.onChangeProperty(TIME_START_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDurationHoursProperty(String newValueExpr){
		int oldValue = getDurationHours();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDurationHours(newValue);
		//they are surely different each other
		this.onChangeProperty(DURATION_HOURS_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	
	
	public void setInstructor(Instructor instructor){
		this.mInstructor = instructor;;
	}
	public Instructor getInstructor(){
		return this.mInstructor;
	}
	
	
	public void setTrainingCourseType(TrainingCourseType trainingCourseType){
		this.mTrainingCourseType = trainingCourseType;;
	}
	public TrainingCourseType getTrainingCourseType(){
		return this.mTrainingCourseType;
	}
	
	
	public void setTimeStart(Date timeStart){
		this.mTimeStart = timeStart;;
	}
	public Date getTimeStart(){
		return this.mTimeStart;
	}
	
	
	public void setDurationHours(int durationHours){
		this.mDurationHours = durationHours;;
	}
	public int getDurationHours(){
		return this.mDurationHours;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<EmployeeCompanyTraining> getEmployeeCompanyTrainingList(){
		if(this.mEmployeeCompanyTrainingList == null){
			this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
		}
		return this.mEmployeeCompanyTrainingList;	
	}
	public  void setEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setTraining(this);
		}
		
		this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
		
	}
	
	public  void addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		employeeCompanyTraining.setTraining(this);
		getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
	}
	public  void addEmployeeCompanyTrainings(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setTraining(this);
		}
		getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
	}
	
	public  void removeEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
	
		boolean result = getEmployeeCompanyTrainingList().planToRemove(employeeCompanyTraining);
        if(!result){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") with version='"+employeeCompanyTraining.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeCompanyTrainingList", employeeCompanyTraining);
		//the constant "toEmployeeCompanyTraining" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeCompanyTrainingFrom(EmployeeCompanyTraining employeeCompanyTraining) {
		// TODO Auto-generated method stub
		
        EmployeeCompanyTraining employeeCompanyTrainingInList = findTheEmployeeCompanyTraining(employeeCompanyTraining);
        EmployeeCompanyTraining newEmployeeCompanyTraining = new EmployeeCompanyTraining();
        employeeCompanyTrainingInList.copyTo(newEmployeeCompanyTraining);
        newEmployeeCompanyTraining.setVersion(0);//will trigger copy
        getEmployeeCompanyTrainingList().add(newEmployeeCompanyTraining);
	}
	
	public  EmployeeCompanyTraining findTheEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		
		int index =  getEmployeeCompanyTrainingList().indexOf(employeeCompanyTraining);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") with version='"+employeeCompanyTraining.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeCompanyTrainingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeCompanyTrainingList(){
		getEmployeeCompanyTrainingList().clear();
	}
	
	
	
	
 	
	
	public CompanyTraining copyTo(CompanyTraining dest){

		dest.setId(getId());
		dest.setTitle(getTitle());
		dest.setCompany(getCompany());
		dest.setInstructor(getInstructor());
		dest.setTrainingCourseType(getTrainingCourseType());
		dest.setTimeStart(getTimeStart());
		dest.setDurationHours(getDurationHours());
		dest.setVersion(getVersion());
		dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("company_training{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		if(getInstructor() != null ){
 			stringBuilder.append("\tinstructor='instructor("+getInstructor().getId()+")';");
 		}
		if(getTrainingCourseType() != null ){
 			stringBuilder.append("\ttraining_course_type='training_course_type("+getTrainingCourseType().getId()+")';");
 		}
		stringBuilder.append("\ttime_start='"+getTimeStart()+"';");
		stringBuilder.append("\tduration_hours='"+getDurationHours()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

