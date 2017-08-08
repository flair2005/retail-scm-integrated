
package com.skynet.retailscm.goodsallocation;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface GoodsAllocationDAO{

	
	public GoodsAllocation load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public GoodsAllocation present(GoodsAllocation goodsAllocation,Map<String,Object> options) throws Exception;
	public GoodsAllocation clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsAllocation save(GoodsAllocation goodsAllocation,Map<String,Object> options);
	public SmartList<GoodsAllocation> saveGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options);
	public SmartList<GoodsAllocation> removeGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList,Map<String,Object> options);
	
	public void delete(String goodsAllocationId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId, Map<String,Object> options);
 	public int countGoodsAllocationByGoodsShelf(String goodsShelfId, Map<String,Object> options);
 	public SmartList<GoodsAllocation> findGoodsAllocationByGoodsShelf(String goodsShelfId, int start, int count, Map<String,Object> options);
 
 }


