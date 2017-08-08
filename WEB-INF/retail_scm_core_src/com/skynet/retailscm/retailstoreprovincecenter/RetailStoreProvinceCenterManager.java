
package com.skynet.retailscm.retailstoreprovincecenter;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreProvinceCenterManager{

	public RetailStoreProvinceCenter createRetailStoreProvinceCenter(RetailScmUserContext userContext, String name, Date founded, String countryId
) throws Exception;	
	public RetailStoreProvinceCenter updateRetailStoreProvinceCenter(RetailScmUserContext userContext,String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStoreProvinceCenter transferToAnotherCountry(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String anotherCountryId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String retailStoreProvinceCenterId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStoreProvinceCenter addProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded, String manager ,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateProvinceCenterDepartment(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreProvinceCenter addProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, String mobile, String email, Date founded, String departmentId ,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateProvinceCenterEmployee(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter removeRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreProvinceCenter updateRetailStoreCityServiceCenter(RetailScmUserContext userContext, String retailStoreProvinceCenterId, String retailStoreCityServiceCenterId, int retailStoreCityServiceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


