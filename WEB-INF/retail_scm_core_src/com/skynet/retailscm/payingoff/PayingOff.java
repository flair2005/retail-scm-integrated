
package com.skynet.retailscm.payingoff;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.skynet.retailscm.employee.Employee;

@JsonSerialize(using = PayingOffSerializer.class)
public class PayingOff extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String PAID_FOR_PROPERTY              = "paidFor"           ;
	public static final String PAID_TIME_PROPERTY             = "paidTime"          ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_SALARY_SHEET_LIST               = "employeeSalarySheetList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Employee            	mPaidFor            ;
	protected		Date                	mPaidTime           ;
	protected		double              	mAmount             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeSalarySheet>	mEmployeeSalarySheetList;
	
		
	public 	PayingOff(){
		//lazy load for all the properties
	}
	
	public 	PayingOff(String who, Employee paidFor, Date paidTime, double amount
)
	{
		setWho(who);
		setPaidFor(paidFor);
		setPaidTime(paidTime);
		setAmount(amount);

		this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(PAID_TIME_PROPERTY.equals(property)){
			changePaidTimeProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
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
			
			
			
	protected void changePaidTimeProperty(String newValueExpr){
		Date oldValue = getPaidTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setPaidTime(newValue);
		//they are surely different each other
		this.onChangeProperty(PAID_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeAmountProperty(String newValueExpr){
		double oldValue = getAmount();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setAmount(newValue);
		//they are surely different each other
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
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
	
	
	public void setPaidFor(Employee paidFor){
		this.mPaidFor = paidFor;;
	}
	public Employee getPaidFor(){
		return this.mPaidFor;
	}
	
	
	public void setPaidTime(Date paidTime){
		this.mPaidTime = paidTime;;
	}
	public Date getPaidTime(){
		return this.mPaidTime;
	}
	
	
	public void setAmount(double amount){
		this.mAmount = amount;;
	}
	public double getAmount(){
		return this.mAmount;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<EmployeeSalarySheet> getEmployeeSalarySheetList(){
		if(this.mEmployeeSalarySheetList == null){
			this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
		}
		return this.mEmployeeSalarySheetList;	
	}
	public  void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setPayingOff(this);
		}
		
		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		
	}
	
	public  void addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setPayingOff(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
	}
	public  void addEmployeeSalarySheets(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setPayingOff(this);
		}
		getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
	}
	
	public  void removeEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
	
		boolean result = getEmployeeSalarySheetList().planToRemove(employeeSalarySheet);
        if(!result){
        	String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveEmployeeSalarySheetList", employeeSalarySheet);
		//the constant "toEmployeeSalarySheet" will be replaced after refactoried.
	
	}
	
	public void copyEmployeeSalarySheetFrom(EmployeeSalarySheet employeeSalarySheet) {
		// TODO Auto-generated method stub
		
        EmployeeSalarySheet employeeSalarySheetInList = findTheEmployeeSalarySheet(employeeSalarySheet);
        EmployeeSalarySheet newEmployeeSalarySheet = new EmployeeSalarySheet();
        employeeSalarySheetInList.copyTo(newEmployeeSalarySheet);
        newEmployeeSalarySheet.setVersion(0);//will trigger copy
        getEmployeeSalarySheetList().add(newEmployeeSalarySheet);
	}
	
	public  EmployeeSalarySheet findTheEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		
		int index =  getEmployeeSalarySheetList().indexOf(employeeSalarySheet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getEmployeeSalarySheetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeSalarySheetList(){
		getEmployeeSalarySheetList().clear();
	}
	
	
	
	
 	
	
	public PayingOff copyTo(PayingOff dest){

		dest.setId(getId());
		dest.setWho(getWho());
		dest.setPaidFor(getPaidFor());
		dest.setPaidTime(getPaidTime());
		dest.setAmount(getAmount());
		dest.setVersion(getVersion());
		dest.setEmployeeSalarySheetList(getEmployeeSalarySheetList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("paying_off{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		if(getPaidFor() != null ){
 			stringBuilder.append("\tpaid_for='employee("+getPaidFor().getId()+")';");
 		}
		stringBuilder.append("\tpaid_time='"+getPaidTime()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}






