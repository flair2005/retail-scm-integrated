
package com.skynet.retailscm.reportline;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.report.Report;

@JsonSerialize(using = ReportLineSerializer.class)
public class ReportLine extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String JANUARY_PROPERTY               = "january"           ;
	public static final String FEBRUARY_PROPERTY              = "february"          ;
	public static final String MARCH_PROPERTY                 = "march"             ;
	public static final String APRIL_PROPERTY                 = "april"             ;
	public static final String MAY_PROPERTY                   = "may"               ;
	public static final String JUNE_PROPERTY                  = "june"              ;
	public static final String JULY_PROPERTY                  = "july"              ;
	public static final String AUGUST_PROPERTY                = "august"            ;
	public static final String SEPTEMBER_PROPERTY             = "september"         ;
	public static final String OCTOBER_PROPERTY               = "october"           ;
	public static final String NOVEMBER_PROPERTY              = "november"          ;
	public static final String DECEMBER_PROPERTY              = "december"          ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Report              	mOwner              ;
	protected		double              	mJanuary            ;
	protected		double              	mFebruary           ;
	protected		double              	mMarch              ;
	protected		double              	mApril              ;
	protected		double              	mMay                ;
	protected		double              	mJune               ;
	protected		double              	mJuly               ;
	protected		double              	mAugust             ;
	protected		double              	mSeptember          ;
	protected		double              	mOctober            ;
	protected		double              	mNovember           ;
	protected		double              	mDecember           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ReportLine(){
		//lazy load for all the properties
	}
	
	public 	ReportLine(String name, Report owner, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december
)
	{
		setName(name);
		setOwner(owner);
		setJanuary(january);
		setFebruary(february);
		setMarch(march);
		setApril(april);
		setMay(may);
		setJune(june);
		setJuly(july);
		setAugust(august);
		setSeptember(september);
		setOctober(october);
		setNovember(november);
		setDecember(december);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(JANUARY_PROPERTY.equals(property)){
			changeJanuaryProperty(newValueExpr);
		}
		if(FEBRUARY_PROPERTY.equals(property)){
			changeFebruaryProperty(newValueExpr);
		}
		if(MARCH_PROPERTY.equals(property)){
			changeMarchProperty(newValueExpr);
		}
		if(APRIL_PROPERTY.equals(property)){
			changeAprilProperty(newValueExpr);
		}
		if(MAY_PROPERTY.equals(property)){
			changeMayProperty(newValueExpr);
		}
		if(JUNE_PROPERTY.equals(property)){
			changeJuneProperty(newValueExpr);
		}
		if(JULY_PROPERTY.equals(property)){
			changeJulyProperty(newValueExpr);
		}
		if(AUGUST_PROPERTY.equals(property)){
			changeAugustProperty(newValueExpr);
		}
		if(SEPTEMBER_PROPERTY.equals(property)){
			changeSeptemberProperty(newValueExpr);
		}
		if(OCTOBER_PROPERTY.equals(property)){
			changeOctoberProperty(newValueExpr);
		}
		if(NOVEMBER_PROPERTY.equals(property)){
			changeNovemberProperty(newValueExpr);
		}
		if(DECEMBER_PROPERTY.equals(property)){
			changeDecemberProperty(newValueExpr);
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
			
			
			
	protected void changeJanuaryProperty(String newValueExpr){
		double oldValue = getJanuary();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setJanuary(newValue);
		//they are surely different each other
		this.onChangeProperty(JANUARY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFebruaryProperty(String newValueExpr){
		double oldValue = getFebruary();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFebruary(newValue);
		//they are surely different each other
		this.onChangeProperty(FEBRUARY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMarchProperty(String newValueExpr){
		double oldValue = getMarch();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMarch(newValue);
		//they are surely different each other
		this.onChangeProperty(MARCH_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAprilProperty(String newValueExpr){
		double oldValue = getApril();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setApril(newValue);
		//they are surely different each other
		this.onChangeProperty(APRIL_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeMayProperty(String newValueExpr){
		double oldValue = getMay();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMay(newValue);
		//they are surely different each other
		this.onChangeProperty(MAY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeJuneProperty(String newValueExpr){
		double oldValue = getJune();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setJune(newValue);
		//they are surely different each other
		this.onChangeProperty(JUNE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeJulyProperty(String newValueExpr){
		double oldValue = getJuly();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setJuly(newValue);
		//they are surely different each other
		this.onChangeProperty(JULY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAugustProperty(String newValueExpr){
		double oldValue = getAugust();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAugust(newValue);
		//they are surely different each other
		this.onChangeProperty(AUGUST_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeSeptemberProperty(String newValueExpr){
		double oldValue = getSeptember();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSeptember(newValue);
		//they are surely different each other
		this.onChangeProperty(SEPTEMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeOctoberProperty(String newValueExpr){
		double oldValue = getOctober();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setOctober(newValue);
		//they are surely different each other
		this.onChangeProperty(OCTOBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeNovemberProperty(String newValueExpr){
		double oldValue = getNovember();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setNovember(newValue);
		//they are surely different each other
		this.onChangeProperty(NOVEMBER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDecemberProperty(String newValueExpr){
		double oldValue = getDecember();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDecember(newValue);
		//they are surely different each other
		this.onChangeProperty(DECEMBER_PROPERTY, oldValue, newValue);
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
	
	
	public void setOwner(Report owner){
		this.mOwner = owner;;
	}
	public Report getOwner(){
		return this.mOwner;
	}
	
	
	public void setJanuary(double january){
		this.mJanuary = january;;
	}
	public double getJanuary(){
		return this.mJanuary;
	}
	
	
	public void setFebruary(double february){
		this.mFebruary = february;;
	}
	public double getFebruary(){
		return this.mFebruary;
	}
	
	
	public void setMarch(double march){
		this.mMarch = march;;
	}
	public double getMarch(){
		return this.mMarch;
	}
	
	
	public void setApril(double april){
		this.mApril = april;;
	}
	public double getApril(){
		return this.mApril;
	}
	
	
	public void setMay(double may){
		this.mMay = may;;
	}
	public double getMay(){
		return this.mMay;
	}
	
	
	public void setJune(double june){
		this.mJune = june;;
	}
	public double getJune(){
		return this.mJune;
	}
	
	
	public void setJuly(double july){
		this.mJuly = july;;
	}
	public double getJuly(){
		return this.mJuly;
	}
	
	
	public void setAugust(double august){
		this.mAugust = august;;
	}
	public double getAugust(){
		return this.mAugust;
	}
	
	
	public void setSeptember(double september){
		this.mSeptember = september;;
	}
	public double getSeptember(){
		return this.mSeptember;
	}
	
	
	public void setOctober(double october){
		this.mOctober = october;;
	}
	public double getOctober(){
		return this.mOctober;
	}
	
	
	public void setNovember(double november){
		this.mNovember = november;;
	}
	public double getNovember(){
		return this.mNovember;
	}
	
	
	public void setDecember(double december){
		this.mDecember = december;;
	}
	public double getDecember(){
		return this.mDecember;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ReportLine copyTo(ReportLine dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setOwner(getOwner());
		dest.setJanuary(getJanuary());
		dest.setFebruary(getFebruary());
		dest.setMarch(getMarch());
		dest.setApril(getApril());
		dest.setMay(getMay());
		dest.setJune(getJune());
		dest.setJuly(getJuly());
		dest.setAugust(getAugust());
		dest.setSeptember(getSeptember());
		dest.setOctober(getOctober());
		dest.setNovember(getNovember());
		dest.setDecember(getDecember());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("report_line{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='report("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tjanuary='"+getJanuary()+"';");
		stringBuilder.append("\tfebruary='"+getFebruary()+"';");
		stringBuilder.append("\tmarch='"+getMarch()+"';");
		stringBuilder.append("\tapril='"+getApril()+"';");
		stringBuilder.append("\tmay='"+getMay()+"';");
		stringBuilder.append("\tjune='"+getJune()+"';");
		stringBuilder.append("\tjuly='"+getJuly()+"';");
		stringBuilder.append("\taugust='"+getAugust()+"';");
		stringBuilder.append("\tseptember='"+getSeptember()+"';");
		stringBuilder.append("\toctober='"+getOctober()+"';");
		stringBuilder.append("\tnovember='"+getNovember()+"';");
		stringBuilder.append("\tdecember='"+getDecember()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

