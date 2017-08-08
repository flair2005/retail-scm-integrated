
package com.skynet.retailscm.shippingspace;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ShippingSpaceDAO{

	
	public ShippingSpace load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ShippingSpace present(ShippingSpace shippingSpace,Map<String,Object> options) throws Exception;
	public ShippingSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ShippingSpace save(ShippingSpace shippingSpace,Map<String,Object> options);
	public SmartList<ShippingSpace> saveShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options);
	public SmartList<ShippingSpace> removeShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList,Map<String,Object> options);
	
	public void delete(String shippingSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countShippingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public SmartList<ShippingSpace> findShippingSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 
 }


