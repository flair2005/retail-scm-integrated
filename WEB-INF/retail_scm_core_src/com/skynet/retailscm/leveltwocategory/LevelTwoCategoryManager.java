
package com.skynet.retailscm.leveltwocategory;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface LevelTwoCategoryManager{

	public LevelTwoCategory createLevelTwoCategory(RetailScmUserContext userContext, String parentCategoryId, String displayName
) throws Exception;	
	public LevelTwoCategory updateLevelTwoCategory(RetailScmUserContext userContext,String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public LevelTwoCategory transferToAnotherParentCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  LevelTwoCategory addLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String displayName ,String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory removeLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelTwoCategory updateLevelThreeCategory(RetailScmUserContext userContext, String levelTwoCategoryId, String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


