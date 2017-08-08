
package com.skynet.retailscm.sku;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SkuDAO{

	
	public Sku load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Sku present(Sku sku,Map<String,Object> options) throws Exception;
	public Sku clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Sku save(Sku sku,Map<String,Object> options);
	public SmartList<Sku> saveSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	public SmartList<Sku> removeSkuList(SmartList<Sku> skuList,Map<String,Object> options);
	
	public void delete(String skuId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Sku> findSkuByProduct(String productId, Map<String,Object> options);
 	public int countSkuByProduct(String productId, Map<String,Object> options);
 	public SmartList<Sku> findSkuByProduct(String productId, int start, int count, Map<String,Object> options);
 
 }


