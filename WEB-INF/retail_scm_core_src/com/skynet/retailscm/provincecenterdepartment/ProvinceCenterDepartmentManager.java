
package com.skynet.retailscm.provincecenterdepartment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface ProvinceCenterDepartmentManager{

	public ProvinceCenterDepartment createProvinceCenterDepartment(RetailScmUserContext userContext, String name, Date founded, String provinceCenterId, String manager
) throws Exception;	
	public ProvinceCenterDepartment updateProvinceCenterDepartment(RetailScmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public ProvinceCenterDepartment transferToAnotherProvinceCenter(RetailScmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String provinceCenterDepartmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  ProvinceCenterDepartment addProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId ,String [] tokensExpr)  throws Exception;
	public  ProvinceCenterDepartment removeProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  ProvinceCenterDepartment updateProvinceCenterEmployee(RetailScmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


