
package com.skynet.retailscm.goodsmovement;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface GoodsMovementDAO{

	
	public GoodsMovement load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public GoodsMovement present(GoodsMovement goodsMovement,Map<String,Object> options) throws Exception;
	public GoodsMovement clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsMovement save(GoodsMovement goodsMovement,Map<String,Object> options);
	public SmartList<GoodsMovement> saveGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options);
	public SmartList<GoodsMovement> removeGoodsMovementList(SmartList<GoodsMovement> goodsMovementList,Map<String,Object> options);
	
	public void delete(String goodsMovementId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId, Map<String,Object> options);
 	public int countGoodsMovementByGoods(String goodsId, Map<String,Object> options);
 	public SmartList<GoodsMovement> findGoodsMovementByGoods(String goodsId, int start, int count, Map<String,Object> options);
 
 }


