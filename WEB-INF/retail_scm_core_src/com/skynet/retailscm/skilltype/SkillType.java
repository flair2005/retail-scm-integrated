
package com.skynet.retailscm.skilltype;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.employeeskill.EmployeeSkill;

@JsonSerialize(using = SkillTypeSerializer.class)
public class SkillType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_SKILL_LIST                      = "employeeSkillList" ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeSkill>	mEmployeeSkillList  ;
	
		
	public 	SkillType(){
		//lazy load for all the properties
	}
	
	public 	SkillType(String code, RetailStoreCountryCenter company, String description
)
	{
		setCode(code);
		setCompany(company);
		setDescription(description);

		this.mEmployeeSkillList = new SmartList<EmployeeSkill>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
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
	
	
	public  SmartList<EmployeeSkill> getEmployeeSkillList(){
		if(this.mEmployeeSkillList == null){
			this.mEmployeeSkillList = new SmartList<EmployeeSkill>();
		}
		return this.mEmployeeSkillList;	
	}
	public  void setEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setSkillType(this);
		}
		
		this.mEmployeeSkillList = employeeSkillList;
		
	}
	
	public  void addEmployeeSkill(EmployeeSkill employeeSkill){
		employeeSkill.setSkillType(this);
		getEmployeeSkillList().add(employeeSkill);
	}
	public  void addEmployeeSkills(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setSkillType(this);
		}
		getEmployeeSkillList().addAll(employeeSkillList);
	}
	
	public  void removeEmployeeSkill(EmployeeSkill employeeSkill){
	
		boolean result = getEmployeeSkillList().planToRemove(employeeSkill);
        if(!result){
        	String message = "EmployeeSkill("+employeeSkill.getId()+") with version='"+employeeSkill.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeSkillList", employeeSkill);
		//the constant "toEmployeeSkill" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeSkillFrom(EmployeeSkill employeeSkill) {
		// TODO Auto-generated method stub
		
        EmployeeSkill employeeSkillInList = findTheEmployeeSkill(employeeSkill);
        EmployeeSkill newEmployeeSkill = new EmployeeSkill();
        employeeSkillInList.copyTo(newEmployeeSkill);
        newEmployeeSkill.setVersion(0);//will trigger copy
        getEmployeeSkillList().add(newEmployeeSkill);
	}
	
	public  EmployeeSkill findTheEmployeeSkill(EmployeeSkill employeeSkill){
		
		int index =  getEmployeeSkillList().indexOf(employeeSkill);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeSkill("+employeeSkill.getId()+") with version='"+employeeSkill.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeSkillList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeSkillList(){
		getEmployeeSkillList().clear();
	}
	
	
	
	
 	
	
	public SkillType copyTo(SkillType dest){

		dest.setId(getId());
		dest.setCode(getCode());
		dest.setCompany(getCompany());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setEmployeeSkillList(getEmployeeSkillList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("skill_type{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='retail_store_country_center("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

