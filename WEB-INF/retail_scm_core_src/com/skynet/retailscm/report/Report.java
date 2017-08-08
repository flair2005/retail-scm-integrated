
package com.skynet.retailscm.report;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.reportline.ReportLine;

@JsonSerialize(using = ReportSerializer.class)
public class Report extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CREATED_BY_PROPERTY            = "createdBy"         ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String REPORT_LINE_LIST                         = "reportLineList"    ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mCreatedBy          ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ReportLine>	mReportLineList     ;
	
		
	public 	Report(){
		//lazy load for all the properties
	}
	
	public 	Report(String name, String createdBy, RetailStoreCountryCenter owner
)
	{
		setName(name);
		setCreatedBy(createdBy);
		setOwner(owner);

		this.mReportLineList = new SmartList<ReportLine>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CREATED_BY_PROPERTY.equals(property)){
			changeCreatedByProperty(newValueExpr);
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
			
			
			
	protected void changeCreatedByProperty(String newValueExpr){
		String oldValue = getCreatedBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCreatedBy(newValue);
		//they are surely different each other
		this.onChangeProperty(CREATED_BY_PROPERTY, oldValue, newValue);
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
	
	
	public void setCreatedBy(String createdBy){
		this.mCreatedBy = trimString(createdBy);;
	}
	public String getCreatedBy(){
		return this.mCreatedBy;
	}
	
	
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ReportLine> getReportLineList(){
		if(this.mReportLineList == null){
			this.mReportLineList = new SmartList<ReportLine>();
		}
		return this.mReportLineList;	
	}
	public  void setReportLineList(SmartList<ReportLine> reportLineList){
		for( ReportLine reportLine:reportLineList){
			reportLine.setOwner(this);
		}
		
		this.mReportLineList = reportLineList;
		
	}
	
	public  void addReportLine(ReportLine reportLine){
		reportLine.setOwner(this);
		getReportLineList().add(reportLine);
	}
	public  void addReportLines(SmartList<ReportLine> reportLineList){
		for( ReportLine reportLine:reportLineList){
			reportLine.setOwner(this);
		}
		getReportLineList().addAll(reportLineList);
	}
	
	public  void removeReportLine(ReportLine reportLine){
	
		boolean result = getReportLineList().planToRemove(reportLine);
        if(!result){
        	String message = "ReportLine("+reportLine.getId()+") with version='"+reportLine.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveReportLineList", reportLine);
		//the constant "toReportLine" will be replaced after refactoried.
	
	}
	
	public void copyReportLineFrom(ReportLine reportLine) {
		// TODO Auto-generated method stub
		
        ReportLine reportLineInList = findTheReportLine(reportLine);
        ReportLine newReportLine = new ReportLine();
        reportLineInList.copyTo(newReportLine);
        newReportLine.setVersion(0);//will trigger copy
        getReportLineList().add(newReportLine);
	}
	
	public  ReportLine findTheReportLine(ReportLine reportLine){
		
		int index =  getReportLineList().indexOf(reportLine);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ReportLine("+reportLine.getId()+") with version='"+reportLine.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getReportLineList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpReportLineList(){
		getReportLineList().clear();
	}
	
	
	
	
 	
	
	public Report copyTo(Report dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setCreatedBy(getCreatedBy());
		dest.setOwner(getOwner());
		dest.setVersion(getVersion());
		dest.setReportLineList(getReportLineList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("report{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcreated_by='"+getCreatedBy()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_country_center("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

