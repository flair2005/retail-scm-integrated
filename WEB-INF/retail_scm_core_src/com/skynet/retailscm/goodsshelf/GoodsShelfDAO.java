
package com.skynet.retailscm.goodsshelf;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface GoodsShelfDAO{

	
	public GoodsShelf load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public GoodsShelf present(GoodsShelf goodsShelf,Map<String,Object> options) throws Exception;
	public GoodsShelf clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsShelf save(GoodsShelf goodsShelf,Map<String,Object> options);
	public SmartList<GoodsShelf> saveGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options);
	public SmartList<GoodsShelf> removeGoodsShelfList(SmartList<GoodsShelf> goodsShelfList,Map<String,Object> options);
	
	public void delete(String goodsShelfId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(String storageSpaceId, Map<String,Object> options);
 	public int countGoodsShelfByStorageSpace(String storageSpaceId, Map<String,Object> options);
 	public SmartList<GoodsShelf> findGoodsShelfByStorageSpace(String storageSpaceId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(String supplierSpaceId, Map<String,Object> options);
 	public int countGoodsShelfBySupplierSpace(String supplierSpaceId, Map<String,Object> options);
 	public SmartList<GoodsShelf> findGoodsShelfBySupplierSpace(String supplierSpaceId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(String damageSpaceId, Map<String,Object> options);
 	public int countGoodsShelfByDamageSpace(String damageSpaceId, Map<String,Object> options);
 	public SmartList<GoodsShelf> findGoodsShelfByDamageSpace(String damageSpaceId, int start, int count, Map<String,Object> options);
 
 }


