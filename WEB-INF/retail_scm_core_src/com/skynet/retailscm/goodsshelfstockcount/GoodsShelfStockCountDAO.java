
package com.skynet.retailscm.goodsshelfstockcount;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface GoodsShelfStockCountDAO{

	
	public GoodsShelfStockCount load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public GoodsShelfStockCount present(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options) throws Exception;
	public GoodsShelfStockCount clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsShelfStockCount save(GoodsShelfStockCount goodsShelfStockCount,Map<String,Object> options);
	public SmartList<GoodsShelfStockCount> saveGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options);
	public SmartList<GoodsShelfStockCount> removeGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList,Map<String,Object> options);
	
	public void delete(String goodsShelfStockCountId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId, Map<String,Object> options);
 	public int countGoodsShelfStockCountByShelf(String goodsShelfId, Map<String,Object> options);
 	public SmartList<GoodsShelfStockCount> findGoodsShelfStockCountByShelf(String goodsShelfId, int start, int count, Map<String,Object> options);
 
 }


