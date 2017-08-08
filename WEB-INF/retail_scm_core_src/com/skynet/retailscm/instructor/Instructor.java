
package com.skynet.retailscm.instructor;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.companytraining.CompanyTraining;

@JsonSerialize(using = InstructorSerializer.class)
public class Instructor extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String FAMILY_NAME_PROPERTY           = "familyName"        ;
	public static final String GIVEN_NAME_PROPERTY            = "givenName"         ;
	public static final String CELL_PHONE_PROPERTY            = "cellPhone"         ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String INTRODUCTION_PROPERTY          = "introduction"      ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String COMPANY_TRAINING_LIST                    = "companyTrainingList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		String              	mFamilyName         ;
	protected		String              	mGivenName          ;
	protected		String              	mCellPhone          ;
	protected		String              	mEmail              ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mIntroduction       ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CompanyTraining>	mCompanyTrainingList;
	
		
	public 	Instructor(){
		//lazy load for all the properties
	}
	
	public 	Instructor(String title, String familyName, String givenName, String cellPhone, String email, RetailStoreCountryCenter company, String introduction
)
	{
		setTitle(title);
		setFamilyName(familyName);
		setGivenName(givenName);
		setCellPhone(cellPhone);
		setEmail(email);
		setCompany(company);
		setIntroduction(introduction);

		this.mCompanyTrainingList = new SmartList<CompanyTraining>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(FAMILY_NAME_PROPERTY.equals(property)){
			changeFamilyNameProperty(newValueExpr);
		}
		if(GIVEN_NAME_PROPERTY.equals(property)){
			changeGivenNameProperty(newValueExpr);
		}
		if(CELL_PHONE_PROPERTY.equals(property)){
			changeCellPhoneProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			changeIntroductionProperty(newValueExpr);
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
			
			
			
	protected void changeFamilyNameProperty(String newValueExpr){
		String oldValue = getFamilyName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFamilyName(newValue);
		//they are surely different each other
		this.onChangeProperty(FAMILY_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeGivenNameProperty(String newValueExpr){
		String oldValue = getGivenName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setGivenName(newValue);
		//they are surely different each other
		this.onChangeProperty(GIVEN_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCellPhoneProperty(String newValueExpr){
		String oldValue = getCellPhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCellPhone(newValue);
		//they are surely different each other
		this.onChangeProperty(CELL_PHONE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setEmail(newValue);
		//they are surely different each other
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeIntroductionProperty(String newValueExpr){
		String oldValue = getIntroduction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setIntroduction(newValue);
		//they are surely different each other
		this.onChangeProperty(INTRODUCTION_PROPERTY, oldValue, newValue);
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
	
	
	public void setFamilyName(String familyName){
		this.mFamilyName = trimString(familyName);;
	}
	public String getFamilyName(){
		return this.mFamilyName;
	}
	
	
	public void setGivenName(String givenName){
		this.mGivenName = trimString(givenName);;
	}
	public String getGivenName(){
		return this.mGivenName;
	}
	
	
	public void setCellPhone(String cellPhone){
		this.mCellPhone = trimString(cellPhone);;
	}
	public String getCellPhone(){
		return this.mCellPhone;
	}
	
	
	
	public String getMaskedCellPhone(){
		String mobilePhoneNumber = getCellPhone();
		if(mobilePhoneNumber == null){
			return null;
		}
		if(mobilePhoneNumber.length()!=11){
			return mobilePhoneNumber;//残缺的手机号，无需屏蔽
		}
		return mobilePhoneNumber.substring(0,3)
			+"****"
			+mobilePhoneNumber.substring(7);
	}
	
		
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	
	
	public void setIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
	}
	public String getIntroduction(){
		return this.mIntroduction;
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
			companyTraining.setInstructor(this);
		}
		
		this.mCompanyTrainingList = companyTrainingList;
		
	}
	
	public  void addCompanyTraining(CompanyTraining companyTraining){
		companyTraining.setInstructor(this);
		getCompanyTrainingList().add(companyTraining);
	}
	public  void addCompanyTrainings(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setInstructor(this);
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
	
	
	
	
 	
	
	public Instructor copyTo(Instructor dest){

		dest.setId(getId());
		dest.setTitle(getTitle());
		dest.setFamilyName(getFamilyName());
		dest.setGivenName(getGivenName());
		dest.setCellPhone(getCellPhone());
		dest.setEmail(getEmail());
		dest.setCompany(getCompany());
		dest.setIntroduction(getIntroduction());
		dest.setVersion(getVersion());
		dest.setCompanyTrainingList(getCompanyTrainingList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("instructor{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tfamily_name='"+getFamilyName()+"';");
		stringBuilder.append("\tgiven_name='"+getGivenName()+"';");
		stringBuilder.append("\tcell_phone='"+getCellPhone()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tintroduction='"+getIntroduction()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

