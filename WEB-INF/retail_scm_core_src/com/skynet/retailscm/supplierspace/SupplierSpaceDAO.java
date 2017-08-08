
package com.skynet.retailscm.supplierspace;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplierSpaceDAO{

	
	public SupplierSpace load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplierSpace present(SupplierSpace supplierSpace,Map<String,Object> options) throws Exception;
	public SupplierSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplierSpace save(SupplierSpace supplierSpace,Map<String,Object> options);
	public SmartList<SupplierSpace> saveSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options);
	public SmartList<SupplierSpace> removeSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options);
	
	public void delete(String supplierSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countSupplierSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 
 }


