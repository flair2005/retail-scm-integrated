
package com.skynet.retailscm.levelthreecategory;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface LevelThreeCategoryManager{

	public LevelThreeCategory createLevelThreeCategory(RetailScmUserContext userContext, String parentCategoryId, String displayName
) throws Exception;	
	public LevelThreeCategory updateLevelThreeCategory(RetailScmUserContext userContext,String levelThreeCategoryId, int levelThreeCategoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public LevelThreeCategory transferToAnotherParentCategory(RetailScmUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String levelThreeCategoryId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  LevelThreeCategory addProduct(RetailScmUserContext userContext, String levelThreeCategoryId, String displayName, String origin, String remark, String brand, String picture ,String [] tokensExpr)  throws Exception;
	public  LevelThreeCategory removeProduct(RetailScmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion,String [] tokensExpr)  throws Exception;
	public  LevelThreeCategory updateProduct(RetailScmUserContext userContext, String levelThreeCategoryId, String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


