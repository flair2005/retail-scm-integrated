
package com.skynet.retailscm.levelonedepartment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface LevelOneDepartmentManager{

	public LevelOneDepartment createLevelOneDepartment(RetailScmUserContext userContext, String belongsToId, String name, String description, String manager, Date founded
) throws Exception;	
	public LevelOneDepartment updateLevelOneDepartment(RetailScmUserContext userContext,String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public LevelOneDepartment transferToAnotherBelongsTo(RetailScmUserContext userContext, String levelOneDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String levelOneDepartmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  LevelOneDepartment addLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String name, String description, Date founded ,String [] tokensExpr)  throws Exception;
	public  LevelOneDepartment removeLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneDepartment updateLevelTwoDepartment(RetailScmUserContext userContext, String levelOneDepartmentId, String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


