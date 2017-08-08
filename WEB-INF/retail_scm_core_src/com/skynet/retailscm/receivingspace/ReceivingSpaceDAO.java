
package com.skynet.retailscm.receivingspace;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ReceivingSpaceDAO{

	
	public ReceivingSpace load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public ReceivingSpace present(ReceivingSpace receivingSpace,Map<String,Object> options) throws Exception;
	public ReceivingSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ReceivingSpace save(ReceivingSpace receivingSpace,Map<String,Object> options);
	public SmartList<ReceivingSpace> saveReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options);
	public SmartList<ReceivingSpace> removeReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList,Map<String,Object> options);
	
	public void delete(String receivingSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countReceivingSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public SmartList<ReceivingSpace> findReceivingSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 
 }


