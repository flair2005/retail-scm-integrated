
package com.skynet.retailscm.stockcountissuetrack;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface StockCountIssueTrackDAO{

	
	public StockCountIssueTrack load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public StockCountIssueTrack present(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options) throws Exception;
	public StockCountIssueTrack clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public StockCountIssueTrack save(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> saveStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> removeStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options);
	
	public void delete(String stockCountIssueTrackId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, Map<String,Object> options);
 	public int countStockCountIssueTrackByStockCount(String goodsShelfStockCountId, Map<String,Object> options);
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, int start, int count, Map<String,Object> options);
 
 }


