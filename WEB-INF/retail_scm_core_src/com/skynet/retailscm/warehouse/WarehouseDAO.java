
package com.skynet.retailscm.warehouse;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface WarehouseDAO{

	
	public Warehouse load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Warehouse present(Warehouse warehouse,Map<String,Object> options) throws Exception;
	public Warehouse clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Warehouse save(Warehouse warehouse,Map<String,Object> options);
	public SmartList<Warehouse> saveWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options);
	public SmartList<Warehouse> removeWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options);
	
	public void delete(String warehouseId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countWarehouseByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


