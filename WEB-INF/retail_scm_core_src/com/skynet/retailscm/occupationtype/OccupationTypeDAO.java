
package com.skynet.retailscm.occupationtype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface OccupationTypeDAO{

	
	public OccupationType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public OccupationType present(OccupationType occupationType,Map<String,Object> options) throws Exception;
	public OccupationType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public OccupationType save(OccupationType occupationType,Map<String,Object> options);
	public SmartList<OccupationType> saveOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options);
	public SmartList<OccupationType> removeOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options);
	
	public void delete(String occupationTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countOccupationTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<OccupationType> findOccupationTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


