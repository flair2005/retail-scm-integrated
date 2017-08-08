
package com.skynet.retailscm.productsupplyduration;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ProductSupplyDurationDAO{

	
	public ProductSupplyDuration load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ProductSupplyDuration present(ProductSupplyDuration productSupplyDuration,Map<String,Object> options) throws Exception;
	public ProductSupplyDuration clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ProductSupplyDuration save(ProductSupplyDuration productSupplyDuration,Map<String,Object> options);
	public SmartList<ProductSupplyDuration> saveProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList,Map<String,Object> options);
	public SmartList<ProductSupplyDuration> removeProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList,Map<String,Object> options);
	
	public void delete(String productSupplyDurationId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(String supplierProductId, Map<String,Object> options);
 	public int countProductSupplyDurationByProduct(String supplierProductId, Map<String,Object> options);
 	public SmartList<ProductSupplyDuration> findProductSupplyDurationByProduct(String supplierProductId, int start, int count, Map<String,Object> options);
 
 }


