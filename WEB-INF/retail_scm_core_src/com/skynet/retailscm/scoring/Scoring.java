
package com.skynet.retailscm.scoring;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;

@JsonSerialize(using = ScoringSerializer.class)
public class Scoring extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String SCORED_BY_PROPERTY             = "scoredBy"          ;
	public static final String SCORE_PROPERTY                 = "score"             ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_COMPANY_TRAINING_LIST           = "employeeCompanyTrainingList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mScoredBy           ;
	protected		int                 	mScore              ;
	protected		String              	mComment            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeCompanyTraining>	mEmployeeCompanyTrainingList;
	
		
	public 	Scoring(){
		//lazy load for all the properties
	}
	
	public 	Scoring(String scoredBy, int score, String comment
)
	{
		setScoredBy(scoredBy);
		setScore(score);
		setComment(comment);

		this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(SCORED_BY_PROPERTY.equals(property)){
			changeScoredByProperty(newValueExpr);
		}
		if(SCORE_PROPERTY.equals(property)){
			changeScoreProperty(newValueExpr);
		}
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeScoredByProperty(String newValueExpr){
		String oldValue = getScoredBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setScoredBy(newValue);
		//they are surely different each other
		this.onChangeProperty(SCORED_BY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeScoreProperty(String newValueExpr){
		int oldValue = getScore();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setScore(newValue);
		//they are surely different each other
		this.onChangeProperty(SCORE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCommentProperty(String newValueExpr){
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setComment(newValue);
		//they are surely different each other
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setScoredBy(String scoredBy){
		this.mScoredBy = trimString(scoredBy);;
	}
	public String getScoredBy(){
		return this.mScoredBy;
	}
	
	
	public void setScore(int score){
		this.mScore = score;;
	}
	public int getScore(){
		return this.mScore;
	}
	
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
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
			employeeCompanyTraining.setScoring(this);
		}
		
		this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
		
	}
	
	public  void addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		employeeCompanyTraining.setScoring(this);
		getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
	}
	public  void addEmployeeCompanyTrainings(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setScoring(this);
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
	
	
	
	
 	
	
	public Scoring copyTo(Scoring dest){

		dest.setId(getId());
		dest.setScoredBy(getScoredBy());
		dest.setScore(getScore());
		dest.setComment(getComment());
		dest.setVersion(getVersion());
		dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("scoring{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tscored_by='"+getScoredBy()+"';");
		stringBuilder.append("\tscore='"+getScore()+"';");
		stringBuilder.append("\tcomment='"+getComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

