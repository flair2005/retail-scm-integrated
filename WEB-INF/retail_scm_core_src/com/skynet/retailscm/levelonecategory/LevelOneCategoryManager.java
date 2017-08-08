
package com.skynet.retailscm.levelonecategory;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface LevelOneCategoryManager{

	public LevelOneCategory createLevelOneCategory(RetailScmUserContext userContext, String catalogId, String displayName
) throws Exception;	
	public LevelOneCategory updateLevelOneCategory(RetailScmUserContext userContext,String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public LevelOneCategory transferToAnotherCatalog(RetailScmUserContext userContext, String levelOneCategoryId, String anotherCatalogId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String levelOneCategoryId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  LevelOneCategory addLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, String displayName ,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory removeLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion,String [] tokensExpr)  throws Exception;
	public  LevelOneCategory updateLevelTwoCategory(RetailScmUserContext userContext, String levelOneCategoryId, String levelTwoCategoryId, int levelTwoCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


