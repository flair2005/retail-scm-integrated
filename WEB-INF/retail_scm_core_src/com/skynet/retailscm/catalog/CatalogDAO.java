
package com.skynet.retailscm.catalog;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface CatalogDAO{

	
	public Catalog load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Catalog present(Catalog catalog,Map<String,Object> options) throws Exception;
	public Catalog clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Catalog save(Catalog catalog,Map<String,Object> options);
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	
	public void delete(String catalogId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countCatalogByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


