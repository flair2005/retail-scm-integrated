
package com.skynet.retailscm.employeesalarysheet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.skynet.retailscm.BaseRowMapper;
import com.skynet.retailscm.employee.Employee;
import com.skynet.retailscm.payingoff.PayingOff;
import com.skynet.retailscm.salarygrade.SalaryGrade;

public class EmployeeSalarySheetMapper extends BaseRowMapper<EmployeeSalarySheet>{
	
	protected EmployeeSalarySheet internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		EmployeeSalarySheet employeeSalarySheet = getEmployeeSalarySheet();		
		 		
 		setId(employeeSalarySheet, rs, rowNumber); 		
 		setEmployee(employeeSalarySheet, rs, rowNumber); 		
 		setCurrentSalaryGrade(employeeSalarySheet, rs, rowNumber); 		
 		setBaseSalary(employeeSalarySheet, rs, rowNumber); 		
 		setBonus(employeeSalarySheet, rs, rowNumber); 		
 		setReward(employeeSalarySheet, rs, rowNumber); 		
 		setPersonalTax(employeeSalarySheet, rs, rowNumber); 		
 		setSocialSecurity(employeeSalarySheet, rs, rowNumber); 		
 		setHousingFound(employeeSalarySheet, rs, rowNumber); 		
 		setJobInsurance(employeeSalarySheet, rs, rowNumber); 		
 		setPayingOff(employeeSalarySheet, rs, rowNumber); 		
 		setCurrentStatus(employeeSalarySheet, rs, rowNumber); 		
 		setVersion(employeeSalarySheet, rs, rowNumber);

		return employeeSalarySheet;
	}
	
	protected EmployeeSalarySheet getEmployeeSalarySheet(){
		return new EmployeeSalarySheet();
	}		
		
	protected void setId(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(EmployeeSalarySheetTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setId(id);
	}
		 		
 	protected void setEmployee(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeId = rs.getString(EmployeeSalarySheetTable.COLUMN_EMPLOYEE);
 		if( employeeId == null){
 			return;
 		}
 		if( employeeId.isEmpty()){
 			return;
 		}
 		Employee employee = employeeSalarySheet.getEmployee();
 		if( employee != null ){
 			//if the root object 'employeeSalarySheet' already have the property, just set the id for it;
 			employee.setId(employeeId);
 			return;
 		}
 		employeeSalarySheet.setEmployee(createEmptyEmployee(employeeId));
 	}
 	 		
 	protected void setCurrentSalaryGrade(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
 		String salaryGradeId = rs.getString(EmployeeSalarySheetTable.COLUMN_CURRENT_SALARY_GRADE);
 		if( salaryGradeId == null){
 			return;
 		}
 		if( salaryGradeId.isEmpty()){
 			return;
 		}
 		SalaryGrade salaryGrade = employeeSalarySheet.getCurrentSalaryGrade();
 		if( salaryGrade != null ){
 			//if the root object 'employeeSalarySheet' already have the property, just set the id for it;
 			salaryGrade.setId(salaryGradeId);
 			return;
 		}
 		employeeSalarySheet.setCurrentSalaryGrade(createEmptyCurrentSalaryGrade(salaryGradeId));
 	}
 	
	protected void setBaseSalary(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double baseSalary = rs.getDouble(EmployeeSalarySheetTable.COLUMN_BASE_SALARY);
		if(baseSalary == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setBaseSalary(baseSalary);
	}
		
	protected void setBonus(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double bonus = rs.getDouble(EmployeeSalarySheetTable.COLUMN_BONUS);
		if(bonus == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setBonus(bonus);
	}
		
	protected void setReward(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double reward = rs.getDouble(EmployeeSalarySheetTable.COLUMN_REWARD);
		if(reward == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setReward(reward);
	}
		
	protected void setPersonalTax(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double personalTax = rs.getDouble(EmployeeSalarySheetTable.COLUMN_PERSONAL_TAX);
		if(personalTax == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setPersonalTax(personalTax);
	}
		
	protected void setSocialSecurity(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double socialSecurity = rs.getDouble(EmployeeSalarySheetTable.COLUMN_SOCIAL_SECURITY);
		if(socialSecurity == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setSocialSecurity(socialSecurity);
	}
		
	protected void setHousingFound(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double housingFound = rs.getDouble(EmployeeSalarySheetTable.COLUMN_HOUSING_FOUND);
		if(housingFound == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setHousingFound(housingFound);
	}
		
	protected void setJobInsurance(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Double jobInsurance = rs.getDouble(EmployeeSalarySheetTable.COLUMN_JOB_INSURANCE);
		if(jobInsurance == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setJobInsurance(jobInsurance);
	}
		 		
 	protected void setPayingOff(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
 		String payingOffId = rs.getString(EmployeeSalarySheetTable.COLUMN_PAYING_OFF);
 		if( payingOffId == null){
 			return;
 		}
 		if( payingOffId.isEmpty()){
 			return;
 		}
 		PayingOff payingOff = employeeSalarySheet.getPayingOff();
 		if( payingOff != null ){
 			//if the root object 'employeeSalarySheet' already have the property, just set the id for it;
 			payingOff.setId(payingOffId);
 			return;
 		}
 		employeeSalarySheet.setPayingOff(createEmptyPayingOff(payingOffId));
 	}
 	
	protected void setCurrentStatus(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(EmployeeSalarySheetTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(EmployeeSalarySheetTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
	
		employeeSalarySheet.setVersion(version);
	}
		
		

 	protected Employee  createEmptyEmployee(String employeeId){
 		Employee employee = new Employee();
 		employee.setId(employeeId);
 		return employee;
 	}
 	
 	protected SalaryGrade  createEmptyCurrentSalaryGrade(String salaryGradeId){
 		SalaryGrade salaryGrade = new SalaryGrade();
 		salaryGrade.setId(salaryGradeId);
 		return salaryGrade;
 	}
 	
 	protected PayingOff  createEmptyPayingOff(String payingOffId){
 		PayingOff payingOff = new PayingOff();
 		payingOff.setId(payingOffId);
 		return payingOff;
 	}
 	
}


