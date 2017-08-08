
package com.skynet.retailscm.provincecenteremployee;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ProvinceCenterEmployeeManager{

	public ProvinceCenterEmployee createProvinceCenterEmployee(RetailScmUserContext userContext, String name, String mobile, String email, Date founded, String departmentId, String provinceCenterId
) throws Exception;	
	public ProvinceCenterEmployee updateProvinceCenterEmployee(RetailScmUserContext userContext,String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ProvinceCenterEmployee transferToAnotherDepartment(RetailScmUserContext userContext, String provinceCenterEmployeeId, String anotherDepartmentId)  throws Exception;
 	public ProvinceCenterEmployee transferToAnotherProvinceCenter(RetailScmUserContext userContext, String provinceCenterEmployeeId, String anotherProvinceCenterId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String provinceCenterEmployeeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


