
package com.skynet.retailscm.storagespace;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface StorageSpaceDAO{

	
	public StorageSpace load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public StorageSpace present(StorageSpace storageSpace,Map<String,Object> options) throws Exception;
	public StorageSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public StorageSpace save(StorageSpace storageSpace,Map<String,Object> options);
	public SmartList<StorageSpace> saveStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options);
	public SmartList<StorageSpace> removeStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options);
	
	public void delete(String storageSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countStorageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 
 }


