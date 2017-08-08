
package com.skynet.retailscm.leveltwodepartment;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface LevelTwoDepartmentManager{

	public LevelTwoDepartment createLevelTwoDepartment(RetailScmUserContext userContext, String belongsToId, String name, String description, Date founded
) throws Exception;	
	public LevelTwoDepartment updateLevelTwoDepartment(RetailScmUserContext userContext,String levelTwoDepartmentId, int levelTwoDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public LevelTwoDepartment transferToAnotherBelongsTo(RetailScmUserContext userContext, String levelTwoDepartmentId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String levelTwoDepartmentId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  LevelTwoDepartment addLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String name, String description, Date founded ,String [] tokensExpr)  throws Exception;
	public  LevelTwoDepartment removeLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoDepartment updateLevelThreeDepartment(RetailScmUserContext userContext, String levelTwoDepartmentId, String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


