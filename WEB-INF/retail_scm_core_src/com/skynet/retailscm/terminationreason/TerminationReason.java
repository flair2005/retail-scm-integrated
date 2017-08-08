
package com.skynet.retailscm.terminationreason;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.termination.Termination;

@JsonSerialize(using = TerminationReasonSerializer.class)
public class TerminationReason extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TERMINATION_LIST                         = "terminationList"   ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Termination>	mTerminationList    ;
	
		
	public 	TerminationReason(){
		//lazy load for all the properties
	}
	
	public 	TerminationReason(String code, RetailStoreCountryCenter company, String description
)
	{
		setCode(code);
		setCompany(company);
		setDescription(description);

		this.mTerminationList = new SmartList<Termination>();	
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
	
	
	public  SmartList<Termination> getTerminationList(){
		if(this.mTerminationList == null){
			this.mTerminationList = new SmartList<Termination>();
		}
		return this.mTerminationList;	
	}
	public  void setTerminationList(SmartList<Termination> terminationList){
		for( Termination termination:terminationList){
			termination.setReason(this);
		}
		
		this.mTerminationList = terminationList;
		
	}
	
	public  void addTermination(Termination termination){
		termination.setReason(this);
		getTerminationList().add(termination);
	}
	public  void addTerminations(SmartList<Termination> terminationList){
		for( Termination termination:terminationList){
			termination.setReason(this);
		}
		getTerminationList().addAll(terminationList);
	}
	
	public  void removeTermination(Termination termination){
	
		boolean result = getTerminationList().planToRemove(termination);
        if(!result){
        	String message = "Termination("+termination.getId()+") with version='"+termination.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTerminationList", termination);
		//the constant "toTermination" will be replaced after refactoried.
	
	}
	
	public void copyTerminationFrom(Termination termination) {
		// TODO Auto-generated method stub
		
        Termination terminationInList = findTheTermination(termination);
        Termination newTermination = new Termination();
        terminationInList.copyTo(newTermination);
        newTermination.setVersion(0);//will trigger copy
        getTerminationList().add(newTermination);
	}
	
	public  Termination findTheTermination(Termination termination){
		
		int index =  getTerminationList().indexOf(termination);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Termination("+termination.getId()+") with version='"+termination.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTerminationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTerminationList(){
		getTerminationList().clear();
	}
	
	
	
	
 	
	
	public TerminationReason copyTo(TerminationReason dest){

		dest.setId(getId());
		dest.setCode(getCode());
		dest.setCompany(getCompany());
		dest.setDescription(getDescription());
		dest.setVersion(getVersion());
		dest.setTerminationList(getTerminationList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("termination_reason{");
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

