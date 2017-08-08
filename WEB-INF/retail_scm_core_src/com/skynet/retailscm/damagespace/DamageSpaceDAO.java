
package com.skynet.retailscm.damagespace;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface DamageSpaceDAO{

	
	public DamageSpace load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public DamageSpace present(DamageSpace damageSpace,Map<String,Object> options) throws Exception;
	public DamageSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public DamageSpace save(DamageSpace damageSpace,Map<String,Object> options);
	public SmartList<DamageSpace> saveDamageSpaceList(SmartList<DamageSpace> damageSpaceList,Map<String,Object> options);
	public SmartList<DamageSpace> removeDamageSpaceList(SmartList<DamageSpace> damageSpaceList,Map<String,Object> options);
	
	public void delete(String damageSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<DamageSpace> findDamageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countDamageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public SmartList<DamageSpace> findDamageSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 
 }


