
package com.skynet.retailscm.product;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ProductDAO{

	
	public Product load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Product present(Product product,Map<String,Object> options) throws Exception;
	public Product clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Product save(Product product,Map<String,Object> options);
	public SmartList<Product> saveProductList(SmartList<Product> productList,Map<String,Object> options);
	public SmartList<Product> removeProductList(SmartList<Product> productList,Map<String,Object> options);
	
	public void delete(String productId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId, Map<String,Object> options);
 	public int countProductByParentCategory(String levelThreeCategoryId, Map<String,Object> options);
 	public SmartList<Product> findProductByParentCategory(String levelThreeCategoryId, int start, int count, Map<String,Object> options);
 
 }


