
package com.skynet.retailscm.goodspackaging;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface GoodsPackagingDAO{

	
	public GoodsPackaging load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public GoodsPackaging present(GoodsPackaging goodsPackaging,Map<String,Object> options) throws Exception;
	public GoodsPackaging clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public GoodsPackaging save(GoodsPackaging goodsPackaging,Map<String,Object> options);
	public SmartList<GoodsPackaging> saveGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options);
	public SmartList<GoodsPackaging> removeGoodsPackagingList(SmartList<GoodsPackaging> goodsPackagingList,Map<String,Object> options);
	
	public void delete(String goodsPackagingId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


