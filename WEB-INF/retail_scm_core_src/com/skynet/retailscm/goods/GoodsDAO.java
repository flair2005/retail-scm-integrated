
package com.skynet.retailscm.goods;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface GoodsDAO{

	
	public Goods load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Goods present(Goods goods,Map<String,Object> options) throws Exception;
	public Goods clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Goods save(Goods goods,Map<String,Object> options);
	public SmartList<Goods> saveGoodsList(SmartList<Goods> goodsList,Map<String,Object> options);
	public SmartList<Goods> removeGoodsList(SmartList<Goods> goodsList,Map<String,Object> options);
	
	public void delete(String goodsId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Goods> findGoodsBySku(String skuId, Map<String,Object> options);
 	public int countGoodsBySku(String skuId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsBySku(String skuId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId, Map<String,Object> options);
 	public int countGoodsByReceivingSpace(String receivingSpaceId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByReceivingSpace(String receivingSpaceId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId, Map<String,Object> options);
 	public int countGoodsByGoodsAllocation(String goodsAllocationId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByGoodsAllocation(String goodsAllocationId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId, Map<String,Object> options);
 	public int countGoodsBySmartPallet(String smartPalletId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsBySmartPallet(String smartPalletId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId, Map<String,Object> options);
 	public int countGoodsByShippingSpace(String shippingSpaceId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByShippingSpace(String shippingSpaceId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId, Map<String,Object> options);
 	public int countGoodsByTransportTask(String transportTaskId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByTransportTask(String transportTaskId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId, Map<String,Object> options);
 	public int countGoodsByRetailStore(String retailStoreId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByRetailStore(String retailStoreId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public int countGoodsByBizOrder(String supplyOrderId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByBizOrder(String supplyOrderId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId, Map<String,Object> options);
 	public int countGoodsByRetailStoreOrder(String retailStoreOrderId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByRetailStoreOrder(String retailStoreOrderId, int start, int count, Map<String,Object> options);
 
  
 	public SmartList<Goods> findGoodsByPackaging(String goodsPackagingId, Map<String,Object> options);
 	public int countGoodsByPackaging(String goodsPackagingId, Map<String,Object> options);
 	public SmartList<Goods> findGoodsByPackaging(String goodsPackagingId, int start, int count, Map<String,Object> options);
 
 }


