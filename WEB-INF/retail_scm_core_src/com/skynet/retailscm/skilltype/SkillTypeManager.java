
package com.skynet.retailscm.skilltype;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface SkillTypeManager{

	public SkillType createSkillType(RetailScmUserContext userContext, String code, String companyId, String description
) throws Exception;	
	public SkillType updateSkillType(RetailScmUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public SkillType transferToAnotherCompany(RetailScmUserContext userContext, String skillTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String skillTypeId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  SkillType addEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String employeeId, String description ,String [] tokensExpr)  throws Exception;
	public  SkillType removeEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion,String [] tokensExpr)  throws Exception;
	public  SkillType updateEmployeeSkill(RetailScmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


