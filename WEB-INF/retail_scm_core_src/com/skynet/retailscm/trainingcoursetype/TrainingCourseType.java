
package com.skynet.retailscm.trainingcoursetype;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.companytraining.CompanyTraining;

@JsonSerialize(using = TrainingCourseTypeSerializer.class)
public class TrainingCourseType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String COMPANY_TRAINING_LIST                    = "companyTrainingList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CompanyTraining>	mCompanyTrainingList;
	
		
	public 	TrainingCourseType(){
		//lazy load for all the properties
	}
	
	public 	TrainingCourseType(String code, RetailStoreCountryCenter company, String name, String description
)
	{
		setCode(code);
		setCompany(company);
		setName(name);
		setDescription(description);

		this.mCompanyTrainingList = new SmartList<CompanyTraining>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
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
	
	
	public  SmartList<CompanyTraining> getCompanyTrainingList(){
		if(this.mCompanyTrainingList == null){
			this.mCompanyTrainingList = new SmartList<CompanyTraining>();
		}
		return this.mCompanyTrainingList;	
	}
	public  void setCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setTrainingCourseType(this);
		}
		
		this.mCompanyTrainingList = companyTrainingList;
		
	}
	
	public  void addCompanyTraining(CompanyTraining companyTraining){
		companyTraining.setTrainingCourseType(this);
		getCompanyTrainingList().add(companyTraining);
	}
	public  void addCompanyTrainings(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setTrainingCourseType(this);
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
	
	
	
	
 	
	
	public TrainingCourseType copyTo(TrainingCourseType dest){

		dest.setId(getId());
		dest.setCode(getCode());
		dest.setCompany(getCompany());
		dest.setName(getName());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setCompanyTrainingList(getCompanyTrainingList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("training_course_type{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

