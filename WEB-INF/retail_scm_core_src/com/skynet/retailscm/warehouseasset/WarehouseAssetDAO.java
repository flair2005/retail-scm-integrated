
package com.skynet.retailscm.warehouseasset;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface WarehouseAssetDAO{

	
	public WarehouseAsset load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public WarehouseAsset present(WarehouseAsset warehouseAsset,Map<String,Object> options) throws Exception;
	public WarehouseAsset clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public WarehouseAsset save(WarehouseAsset warehouseAsset,Map<String,Object> options);
	public SmartList<WarehouseAsset> saveWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList,Map<String,Object> options);
	public SmartList<WarehouseAsset> removeWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList,Map<String,Object> options);
	
	public void delete(String warehouseAssetId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<WarehouseAsset> findWarehouseAssetByOwner(String warehouseId, Map<String,Object> options);
 	public int countWarehouseAssetByOwner(String warehouseId, Map<String,Object> options);
 	public SmartList<WarehouseAsset> findWarehouseAssetByOwner(String warehouseId, int start, int count, Map<String,Object> options);
 
 }


