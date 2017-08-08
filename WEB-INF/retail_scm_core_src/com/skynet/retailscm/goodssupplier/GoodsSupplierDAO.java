
package com.skynet.retailscm.goodssupplier;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface GoodsSupplierDAO{

	
	public GoodsSupplier load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public GoodsSupplier present(GoodsSupplier goodsSupplier,Map<String,Object> options) throws Exception;
	public GoodsSupplier clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsSupplier save(GoodsSupplier goodsSupplier,Map<String,Object> options);
	public SmartList<GoodsSupplier> saveGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options);
	public SmartList<GoodsSupplier> removeGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options);
	
	public void delete(String goodsSupplierId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countGoodsSupplierByBelongTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


