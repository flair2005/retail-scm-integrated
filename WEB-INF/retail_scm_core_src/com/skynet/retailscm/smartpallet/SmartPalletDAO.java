
package com.skynet.retailscm.smartpallet;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SmartPalletDAO{

	
	public SmartPallet load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SmartPallet present(SmartPallet smartPallet,Map<String,Object> options) throws Exception;
	public SmartPallet clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SmartPallet save(SmartPallet smartPallet,Map<String,Object> options);
	public SmartList<SmartPallet> saveSmartPalletList(SmartList<SmartPallet> smartPalletList,Map<String,Object> options);
	public SmartList<SmartPallet> removeSmartPalletList(SmartList<SmartPallet> smartPalletList,Map<String,Object> options);
	
	public void delete(String smartPalletId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SmartPallet> findSmartPalletByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countSmartPalletByWarehouse(String warehouseId, Map<String,Object> options);
 	public SmartList<SmartPallet> findSmartPalletByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 
 }


