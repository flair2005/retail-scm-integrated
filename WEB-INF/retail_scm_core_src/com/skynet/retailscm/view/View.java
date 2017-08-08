
package com.skynet.retailscm.view;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ViewSerializer.class)
public class View extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String ASSESSMENT_PROPERTY            = "assessment"        ;
	public static final String INTERVIEW_TIME_PROPERTY        = "interviewTime"     ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		String              	mAssessment         ;
	protected		Date                	mInterviewTime      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	View(){
		//lazy load for all the properties
	}
	
	public 	View(String who, String assessment, Date interviewTime
)
	{
		setWho(who);
		setAssessment(assessment);
		setInterviewTime(interviewTime);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(ASSESSMENT_PROPERTY.equals(property)){
			changeAssessmentProperty(newValueExpr);
		}
		if(INTERVIEW_TIME_PROPERTY.equals(property)){
			changeInterviewTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setWho(newValue);
		//they are surely different each other
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAssessmentProperty(String newValueExpr){
		String oldValue = getAssessment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAssessment(newValue);
		//they are surely different each other
		this.onChangeProperty(ASSESSMENT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeInterviewTimeProperty(String newValueExpr){
		Date oldValue = getInterviewTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setInterviewTime(newValue);
		//they are surely different each other
		this.onChangeProperty(INTERVIEW_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	
	
	public void setAssessment(String assessment){
		this.mAssessment = trimString(assessment);;
	}
	public String getAssessment(){
		return this.mAssessment;
	}
	
	
	public void setInterviewTime(Date interviewTime){
		this.mInterviewTime = interviewTime;;
	}
	public Date getInterviewTime(){
		return this.mInterviewTime;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public View copyTo(View dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setAssessment(getAssessment());
		dest.setInterviewTime(getInterviewTime());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("view{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tassessment='"+getAssessment()+"';");
		stringBuilder.append("\tinterview_time='"+getInterviewTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

