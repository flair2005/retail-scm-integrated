
package com.skynet.retailscm.levelthreedepartment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface LevelThreeDepartmentManager{

	public LevelThreeDepartment createLevelThreeDepartment(RetailScmUserContext userContext, String belongsToId, String name, String description, Date founded
) throws Exception;	
	public LevelThreeDepartment updateLevelThreeDepartment(RetailScmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public LevelThreeDepartment transferToAnotherBelongsTo(RetailScmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String levelThreeDepartmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  LevelThreeDepartment addEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment removeEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  LevelThreeDepartment updateEmployee(RetailScmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


