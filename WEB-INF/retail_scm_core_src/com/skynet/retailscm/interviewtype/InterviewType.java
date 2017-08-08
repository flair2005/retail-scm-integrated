
package com.skynet.retailscm.interviewtype;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeinterview.EmployeeInterview;

@JsonSerialize(using = InterviewTypeSerializer.class)
public class InterviewType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_INTERVIEW_LIST                  = "employeeInterviewList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mDescription        ;
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeInterview>	mEmployeeInterviewList;
	
		
	public 	InterviewType(){
		//lazy load for all the properties
	}
	
	public 	InterviewType(String code, RetailStoreCountryCenter company, String description, String detailDescription
)
	{
		setCode(code);
		setCompany(company);
		setDescription(description);
		setDetailDescription(detailDescription);

		this.mEmployeeInterviewList = new SmartList<EmployeeInterview>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			changeDetailDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCodeProperty(String newValueExpr){
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCode(newValue);
		//they are surely different each other
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeDetailDescriptionProperty(String newValueExpr){
		String oldValue = getDetailDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDetailDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
	}
	public String getDetailDescription(){
		return this.mDetailDescription;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<EmployeeInterview> getEmployeeInterviewList(){
		if(this.mEmployeeInterviewList == null){
			this.mEmployeeInterviewList = new SmartList<EmployeeInterview>();
		}
		return this.mEmployeeInterviewList;	
	}
	public  void setEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setInterviewType(this);
		}
		
		this.mEmployeeInterviewList = employeeInterviewList;
		
	}
	
	public  void addEmployeeInterview(EmployeeInterview employeeInterview){
		employeeInterview.setInterviewType(this);
		getEmployeeInterviewList().add(employeeInterview);
	}
	public  void addEmployeeInterviews(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setInterviewType(this);
		}
		getEmployeeInterviewList().addAll(employeeInterviewList);
	}
	
	public  void removeEmployeeInterview(EmployeeInterview employeeInterview){
	
		boolean result = getEmployeeInterviewList().planToRemove(employeeInterview);
        if(!result){
        	String message = "EmployeeInterview("+employeeInterview.getId()+") with version='"+employeeInterview.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeInterviewList", employeeInterview);
		//the constant "toEmployeeInterview" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeInterviewFrom(EmployeeInterview employeeInterview) {
		// TODO Auto-generated method stub
		
        EmployeeInterview employeeInterviewInList = findTheEmployeeInterview(employeeInterview);
        EmployeeInterview newEmployeeInterview = new EmployeeInterview();
        employeeInterviewInList.copyTo(newEmployeeInterview);
        newEmployeeInterview.setVersion(0);//will trigger copy
        getEmployeeInterviewList().add(newEmployeeInterview);
	}
	
	public  EmployeeInterview findTheEmployeeInterview(EmployeeInterview employeeInterview){
		
		int index =  getEmployeeInterviewList().indexOf(employeeInterview);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeInterview("+employeeInterview.getId()+") with version='"+employeeInterview.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeInterviewList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeInterviewList(){
		getEmployeeInterviewList().clear();
	}
	
	
	
	
 	
	
	public InterviewType copyTo(InterviewType dest){

		dest.setId(getId());
		dest.setCode(getCode());
		dest.setCompany(getCompany());
		dest.setDescription(getDescription());
		dest.setDetailDescription(getDetailDescription());
		dest.setVersion(getVersion());
		dest.setEmployeeInterviewList(getEmployeeInterviewList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("interview_type{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tdetail_description='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

