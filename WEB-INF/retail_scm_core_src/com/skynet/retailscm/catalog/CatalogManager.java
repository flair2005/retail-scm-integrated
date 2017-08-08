
package com.skynet.retailscm.catalog;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface CatalogManager{

	public Catalog createCatalog(RetailScmUserContext userContext, String displayName, String ownerId
) throws Exception;	
	public Catalog updateCatalog(RetailScmUserContext userContext,String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public Catalog transferToAnotherOwner(RetailScmUserContext userContext, String catalogId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailScmUserContext userContext, String catalogId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  Catalog addLevelOneCategory(RetailScmUserContext userContext, String catalogId, String displayName ,String [] tokensExpr)  throws Exception;
	public  Catalog removeLevelOneCategory(RetailScmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion,String [] tokensExpr)  throws Exception;
	public  Catalog updateLevelOneCategory(RetailScmUserContext userContext, String catalogId, String levelOneCategoryId, int levelOneCategoryVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


