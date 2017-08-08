
package com.skynet.retailscm.supplierproduct;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface SupplierProductDAO{

	
	public SupplierProduct load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public SupplierProduct present(SupplierProduct supplierProduct,Map<String,Object> options) throws Exception;
	public SupplierProduct clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplierProduct save(SupplierProduct supplierProduct,Map<String,Object> options);
	public SmartList<SupplierProduct> saveSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options);
	public SmartList<SupplierProduct> removeSupplierProductList(SmartList<SupplierProduct> supplierProductList,Map<String,Object> options);
	
	public void delete(String supplierProductId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId, Map<String,Object> options);
 	public int countSupplierProductBySupplier(String goodsSupplierId, Map<String,Object> options);
 	public SmartList<SupplierProduct> findSupplierProductBySupplier(String goodsSupplierId, int start, int count, Map<String,Object> options);
 
 }


