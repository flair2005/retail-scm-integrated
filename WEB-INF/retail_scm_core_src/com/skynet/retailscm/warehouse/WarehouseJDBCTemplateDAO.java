
package com.skynet.retailscm.warehouse;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.shippingspace.ShippingSpace;
import com.skynet.retailscm.storagespace.StorageSpace;
import com.skynet.retailscm.receivingspace.ReceivingSpace;
import com.skynet.retailscm.damagespace.DamageSpace;
import com.skynet.retailscm.warehouseasset.WarehouseAsset;
import com.skynet.retailscm.smartpallet.SmartPallet;
import com.skynet.retailscm.supplierspace.SupplierSpace;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.warehouseasset.WarehouseAssetDAO;
import com.skynet.retailscm.supplierspace.SupplierSpaceDAO;
import com.skynet.retailscm.receivingspace.ReceivingSpaceDAO;
import com.skynet.retailscm.smartpallet.SmartPalletDAO;
import com.skynet.retailscm.shippingspace.ShippingSpaceDAO;
import com.skynet.retailscm.storagespace.StorageSpaceDAO;
import com.skynet.retailscm.damagespace.DamageSpaceDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.damagespace.DamageSpaceTable;
import com.skynet.retailscm.storagespace.StorageSpaceTable;
import com.skynet.retailscm.shippingspace.ShippingSpaceTable;
import com.skynet.retailscm.smartpallet.SmartPalletTable;
import com.skynet.retailscm.warehouseasset.WarehouseAssetTable;
import com.skynet.retailscm.supplierspace.SupplierSpaceTable;
import com.skynet.retailscm.receivingspace.ReceivingSpaceTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class WarehouseJDBCTemplateDAO extends CommonJDBCTemplateDAO implements WarehouseDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  StorageSpaceDAO  storageSpaceDAO;
 	public void setStorageSpaceDAO(StorageSpaceDAO pStorageSpaceDAO){
 	
 		if(pStorageSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set storageSpaceDAO to null.");
 		}
	 	this.storageSpaceDAO = pStorageSpaceDAO;
 	}
 	public StorageSpaceDAO getStorageSpaceDAO(){
 		if(this.storageSpaceDAO == null){
 			throw new IllegalStateException("The storageSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.storageSpaceDAO;
 	}	
 	
			
		
	
  	private  SmartPalletDAO  smartPalletDAO;
 	public void setSmartPalletDAO(SmartPalletDAO pSmartPalletDAO){
 	
 		if(pSmartPalletDAO == null){
 			throw new IllegalStateException("Do not try to set smartPalletDAO to null.");
 		}
	 	this.smartPalletDAO = pSmartPalletDAO;
 	}
 	public SmartPalletDAO getSmartPalletDAO(){
 		if(this.smartPalletDAO == null){
 			throw new IllegalStateException("The smartPalletDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.smartPalletDAO;
 	}	
 	
			
		
	
  	private  SupplierSpaceDAO  supplierSpaceDAO;
 	public void setSupplierSpaceDAO(SupplierSpaceDAO pSupplierSpaceDAO){
 	
 		if(pSupplierSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set supplierSpaceDAO to null.");
 		}
	 	this.supplierSpaceDAO = pSupplierSpaceDAO;
 	}
 	public SupplierSpaceDAO getSupplierSpaceDAO(){
 		if(this.supplierSpaceDAO == null){
 			throw new IllegalStateException("The supplierSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplierSpaceDAO;
 	}	
 	
			
		
	
  	private  ReceivingSpaceDAO  receivingSpaceDAO;
 	public void setReceivingSpaceDAO(ReceivingSpaceDAO pReceivingSpaceDAO){
 	
 		if(pReceivingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set receivingSpaceDAO to null.");
 		}
	 	this.receivingSpaceDAO = pReceivingSpaceDAO;
 	}
 	public ReceivingSpaceDAO getReceivingSpaceDAO(){
 		if(this.receivingSpaceDAO == null){
 			throw new IllegalStateException("The receivingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.receivingSpaceDAO;
 	}	
 	
			
		
	
  	private  ShippingSpaceDAO  shippingSpaceDAO;
 	public void setShippingSpaceDAO(ShippingSpaceDAO pShippingSpaceDAO){
 	
 		if(pShippingSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set shippingSpaceDAO to null.");
 		}
	 	this.shippingSpaceDAO = pShippingSpaceDAO;
 	}
 	public ShippingSpaceDAO getShippingSpaceDAO(){
 		if(this.shippingSpaceDAO == null){
 			throw new IllegalStateException("The shippingSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.shippingSpaceDAO;
 	}	
 	
			
		
	
  	private  DamageSpaceDAO  damageSpaceDAO;
 	public void setDamageSpaceDAO(DamageSpaceDAO pDamageSpaceDAO){
 	
 		if(pDamageSpaceDAO == null){
 			throw new IllegalStateException("Do not try to set damageSpaceDAO to null.");
 		}
	 	this.damageSpaceDAO = pDamageSpaceDAO;
 	}
 	public DamageSpaceDAO getDamageSpaceDAO(){
 		if(this.damageSpaceDAO == null){
 			throw new IllegalStateException("The damageSpaceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.damageSpaceDAO;
 	}	
 	
			
		
	
  	private  WarehouseAssetDAO  warehouseAssetDAO;
 	public void setWarehouseAssetDAO(WarehouseAssetDAO pWarehouseAssetDAO){
 	
 		if(pWarehouseAssetDAO == null){
 			throw new IllegalStateException("Do not try to set warehouseAssetDAO to null.");
 		}
	 	this.warehouseAssetDAO = pWarehouseAssetDAO;
 	}
 	public WarehouseAssetDAO getWarehouseAssetDAO(){
 		if(this.warehouseAssetDAO == null){
 			throw new IllegalStateException("The warehouseAssetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.warehouseAssetDAO;
 	}	
 	
			
		

	
	/*
	protected Warehouse load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWarehouse(accessKey, options);
	}
	*/
	public Warehouse load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWarehouse(WarehouseTable.withId(id), options);
	}
	
	
	
	public Warehouse save(Warehouse warehouse,Map<String,Object> options){
		
		String methodName="save(Warehouse warehouse,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(warehouse, methodName, "warehouse");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalWarehouse(warehouse,options);
	}
	public Warehouse clone(String warehouseId, Map<String,Object> options) throws Exception{
	
		return clone(WarehouseTable.withId(warehouseId),options);
	}
	
	protected Warehouse clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String warehouseId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Warehouse newWarehouse = loadInternalWarehouse(accessKey, options);
		newWarehouse.setVersion(0);
		
		
 		
 		if(isSaveStorageSpaceListEnabled(options)){
 			for(StorageSpace item: newWarehouse.getStorageSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSmartPalletListEnabled(options)){
 			for(SmartPallet item: newWarehouse.getSmartPalletList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplierSpaceListEnabled(options)){
 			for(SupplierSpace item: newWarehouse.getSupplierSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveReceivingSpaceListEnabled(options)){
 			for(ReceivingSpace item: newWarehouse.getReceivingSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveShippingSpaceListEnabled(options)){
 			for(ShippingSpace item: newWarehouse.getShippingSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveDamageSpaceListEnabled(options)){
 			for(DamageSpace item: newWarehouse.getDamageSpaceList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveWarehouseAssetListEnabled(options)){
 			for(WarehouseAsset item: newWarehouse.getWarehouseAssetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalWarehouse(newWarehouse,options);
		
		return newWarehouse;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String warehouseId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{warehouseId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new WarehouseVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WarehouseNotFoundException(
					"The " + this.getTableName() + "(" + warehouseId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String warehouseId, int version) throws Exception{
	
		String methodName="delete(String warehouseId, int version)";
		assertMethodArgumentNotNull(warehouseId, methodName, "warehouseId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{warehouseId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(warehouseId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"location","contact_number","total_area","owner","latitude","longitude"};
		return WarehouseTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "warehouse";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WarehouseTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WarehouseTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WarehouseTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String STORAGE_SPACE_LIST = "storageSpaceList";
	
	protected boolean isExtractStorageSpaceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,WarehouseTokens.STORAGE_SPACE_LIST);
		
 	}

	protected boolean isSaveStorageSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.STORAGE_SPACE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SMART_PALLET_LIST = "smartPalletList";
	
	protected boolean isExtractSmartPalletListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,WarehouseTokens.SMART_PALLET_LIST);
		
 	}

	protected boolean isSaveSmartPalletListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.SMART_PALLET_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLIER_SPACE_LIST = "supplierSpaceList";
	
	protected boolean isExtractSupplierSpaceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,WarehouseTokens.SUPPLIER_SPACE_LIST);
		
 	}

	protected boolean isSaveSupplierSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.SUPPLIER_SPACE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String RECEIVING_SPACE_LIST = "receivingSpaceList";
	
	protected boolean isExtractReceivingSpaceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,WarehouseTokens.RECEIVING_SPACE_LIST);
		
 	}

	protected boolean isSaveReceivingSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.RECEIVING_SPACE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SHIPPING_SPACE_LIST = "shippingSpaceList";
	
	protected boolean isExtractShippingSpaceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,WarehouseTokens.SHIPPING_SPACE_LIST);
		
 	}

	protected boolean isSaveShippingSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.SHIPPING_SPACE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String DAMAGE_SPACE_LIST = "damageSpaceList";
	
	protected boolean isExtractDamageSpaceListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,WarehouseTokens.DAMAGE_SPACE_LIST);
		
 	}

	protected boolean isSaveDamageSpaceListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.DAMAGE_SPACE_LIST);
		
 	}
 	
 	
			
		
	//protected static final String WAREHOUSE_ASSET_LIST = "warehouseAssetList";
	
	protected boolean isExtractWarehouseAssetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,WarehouseTokens.WAREHOUSE_ASSET_LIST);
		
 	}

	protected boolean isSaveWarehouseAssetListEnabled(Map<String,Object> options){
		return checkOptions(options, WarehouseTokens.WAREHOUSE_ASSET_LIST);
		
 	}
 	
 	
			
		

	

	protected WarehouseMapper getWarehouseMapper(){
		return new WarehouseMapper();
	}
	protected Warehouse extractWarehouse(String warehouseId) throws Exception{
		String SQL = "select * from warehouse_data where id = ?";	
		try{
		
			Warehouse warehouse = queryForObject(SQL, new Object[]{warehouseId}, getWarehouseMapper());
			return warehouse;
		}catch(EmptyResultDataAccessException e){
			throw new WarehouseNotFoundException("Warehouse("+warehouseId+") is not found!");
		}
		
		
	}
	protected Warehouse extractWarehouse(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from warehouse_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			Warehouse warehouse = queryForObject(SQL, new Object[]{accessKey.getValue()}, getWarehouseMapper());
			return warehouse;
		}catch(EmptyResultDataAccessException e){
			throw new WarehouseNotFoundException("Warehouse("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected Warehouse loadInternalWarehouse(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Warehouse warehouse = extractWarehouse(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(warehouse, loadOptions);
 		}
 
		
		if(isExtractStorageSpaceListEnabled(loadOptions)){
	 		extractStorageSpaceList(warehouse, loadOptions);
 		}		
		
		if(isExtractSmartPalletListEnabled(loadOptions)){
	 		extractSmartPalletList(warehouse, loadOptions);
 		}		
		
		if(isExtractSupplierSpaceListEnabled(loadOptions)){
	 		extractSupplierSpaceList(warehouse, loadOptions);
 		}		
		
		if(isExtractReceivingSpaceListEnabled(loadOptions)){
	 		extractReceivingSpaceList(warehouse, loadOptions);
 		}		
		
		if(isExtractShippingSpaceListEnabled(loadOptions)){
	 		extractShippingSpaceList(warehouse, loadOptions);
 		}		
		
		if(isExtractDamageSpaceListEnabled(loadOptions)){
	 		extractDamageSpaceList(warehouse, loadOptions);
 		}		
		
		if(isExtractWarehouseAssetListEnabled(loadOptions)){
	 		extractWarehouseAssetList(warehouse, loadOptions);
 		}		
		
		return warehouse;
		
	}



	
	
	 

 	protected Warehouse extractOwner(Warehouse warehouse, Map<String,Object> options) throws Exception{

		if(warehouse.getOwner() == null){
			return warehouse;
		}
		String ownerId = warehouse.getOwner().getId();
		if( ownerId == null){
			return warehouse;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			warehouse.setOwner(owner);
		}
		
 		
 		return warehouse;
 	}
 		
 
		
	protected Warehouse extractStorageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		SmartList<StorageSpace> storageSpaceList = getStorageSpaceDAO().findStorageSpaceByWarehouse(warehouse.getId(),options);
		if(storageSpaceList != null){
			warehouse.setStorageSpaceList(storageSpaceList);
		}
		
		return warehouse;
	
	}	
		
	protected Warehouse extractSmartPalletList(Warehouse warehouse, Map<String,Object> options){
		
		SmartList<SmartPallet> smartPalletList = getSmartPalletDAO().findSmartPalletByWarehouse(warehouse.getId(),options);
		if(smartPalletList != null){
			warehouse.setSmartPalletList(smartPalletList);
		}
		
		return warehouse;
	
	}	
		
	protected Warehouse extractSupplierSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		SmartList<SupplierSpace> supplierSpaceList = getSupplierSpaceDAO().findSupplierSpaceByWarehouse(warehouse.getId(),options);
		if(supplierSpaceList != null){
			warehouse.setSupplierSpaceList(supplierSpaceList);
		}
		
		return warehouse;
	
	}	
		
	protected Warehouse extractReceivingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		SmartList<ReceivingSpace> receivingSpaceList = getReceivingSpaceDAO().findReceivingSpaceByWarehouse(warehouse.getId(),options);
		if(receivingSpaceList != null){
			warehouse.setReceivingSpaceList(receivingSpaceList);
		}
		
		return warehouse;
	
	}	
		
	protected Warehouse extractShippingSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		SmartList<ShippingSpace> shippingSpaceList = getShippingSpaceDAO().findShippingSpaceByWarehouse(warehouse.getId(),options);
		if(shippingSpaceList != null){
			warehouse.setShippingSpaceList(shippingSpaceList);
		}
		
		return warehouse;
	
	}	
		
	protected Warehouse extractDamageSpaceList(Warehouse warehouse, Map<String,Object> options){
		
		SmartList<DamageSpace> damageSpaceList = getDamageSpaceDAO().findDamageSpaceByWarehouse(warehouse.getId(),options);
		if(damageSpaceList != null){
			warehouse.setDamageSpaceList(damageSpaceList);
		}
		
		return warehouse;
	
	}	
		
	protected Warehouse extractWarehouseAssetList(Warehouse warehouse, Map<String,Object> options){
		
		SmartList<WarehouseAsset> warehouseAssetList = getWarehouseAssetDAO().findWarehouseAssetByOwner(warehouse.getId(),options);
		if(warehouseAssetList != null){
			warehouse.setWarehouseAssetList(warehouseAssetList);
		}
		
		return warehouse;
	
	}	
		
		
  	
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<Warehouse> warehouseList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getWarehouseMapper());	
 		return warehouseList;
 	}
 	
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<Warehouse> warehouseList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getWarehouseMapper());
		
 		return warehouseList;
 	}
 	
 	public int countWarehouseByOwner(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected Warehouse saveWarehouse(Warehouse  warehouse){
	
		String SQL=this.getSaveWarehouseSQL(warehouse);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWarehouseParameters(warehouse);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		warehouse.incVersion();
		return warehouse;
	
	}
	public SmartList<Warehouse> saveWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWarehouseList(warehouseList);
		
		batchWarehouseCreate((List<Warehouse>)lists[CREATE_LIST_INDEX]);
		
		batchWarehouseUpdate((List<Warehouse>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Warehouse warehouse:warehouseList){
			if(warehouse.isChanged()){
				warehouse.incVersion();
			}
			
		
		}
		
		
		return warehouseList;
	}

	public SmartList<Warehouse> removeWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options){
		
		
		super.removeList(warehouseList, options);
		
		return warehouseList;
		
		
	}
	
	protected List<Object[]> prepareWarehouseBatchCreateArgs(List<Warehouse> warehouseList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Warehouse warehouse:warehouseList ){
			Object [] parameters = prepareWarehouseCreateParameters(warehouse);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareWarehouseBatchUpdateArgs(List<Warehouse> warehouseList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Warehouse warehouse:warehouseList ){
			if(!warehouse.isChanged()){
				continue;
			}
			Object [] parameters = prepareWarehouseUpdateParameters(warehouse);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchWarehouseCreate(List<Warehouse> warehouseList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWarehouseBatchCreateArgs(warehouseList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchWarehouseUpdate(List<Warehouse> warehouseList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWarehouseBatchUpdateArgs(warehouseList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitWarehouseList(List<Warehouse> warehouseList){
		
		List<Warehouse> warehouseCreateList=new ArrayList<Warehouse>();
		List<Warehouse> warehouseUpdateList=new ArrayList<Warehouse>();
		
		for(Warehouse warehouse: warehouseList){
			if(isUpdateRequest(warehouse)){
				warehouseUpdateList.add( warehouse);
				continue;
			}
			warehouseCreateList.add(warehouse);
		}
		
		return new Object[]{warehouseCreateList,warehouseUpdateList};
	}
	
	protected boolean isUpdateRequest(Warehouse warehouse){
 		return warehouse.getVersion() > 0;
 	}
 	protected String getSaveWarehouseSQL(Warehouse warehouse){
 		if(isUpdateRequest(warehouse)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveWarehouseParameters(Warehouse warehouse){
 		if(isUpdateRequest(warehouse) ){
 			return prepareWarehouseUpdateParameters(warehouse);
 		}
 		return prepareWarehouseCreateParameters(warehouse);
 	}
 	protected Object[] prepareWarehouseUpdateParameters(Warehouse warehouse){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = warehouse.getLocation();
 		parameters[1] = warehouse.getContactNumber();
 		parameters[2] = warehouse.getTotalArea(); 	
 		if(warehouse.getOwner() != null){
 			parameters[3] = warehouse.getOwner().getId();
 		}
 
 		parameters[4] = warehouse.getLatitude();
 		parameters[5] = warehouse.getLongitude();		
 		parameters[6] = warehouse.getId();
 		parameters[7] = warehouse.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareWarehouseCreateParameters(Warehouse warehouse){
		Object[] parameters = new Object[7];
		String newWarehouseId=getNextId();
		warehouse.setId(newWarehouseId);
		parameters[0] =  warehouse.getId();
 
 		parameters[1] = warehouse.getLocation();
 		parameters[2] = warehouse.getContactNumber();
 		parameters[3] = warehouse.getTotalArea(); 	
 		if(warehouse.getOwner() != null){
 			parameters[4] = warehouse.getOwner().getId();
 		
 		}
 		
 		parameters[5] = warehouse.getLatitude();
 		parameters[6] = warehouse.getLongitude();		
 				
 		return parameters;
 	}
 	
	protected Warehouse saveInternalWarehouse(Warehouse warehouse, Map<String,Object> options){
		
		saveWarehouse(warehouse);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(warehouse, options);
 		}
 
		
		if(isSaveStorageSpaceListEnabled(options)){
	 		saveStorageSpaceList(warehouse, options);
	 		removeStorageSpaceList(warehouse, options);
	 		
 		}		
		
		if(isSaveSmartPalletListEnabled(options)){
	 		saveSmartPalletList(warehouse, options);
	 		removeSmartPalletList(warehouse, options);
	 		
 		}		
		
		if(isSaveSupplierSpaceListEnabled(options)){
	 		saveSupplierSpaceList(warehouse, options);
	 		removeSupplierSpaceList(warehouse, options);
	 		
 		}		
		
		if(isSaveReceivingSpaceListEnabled(options)){
	 		saveReceivingSpaceList(warehouse, options);
	 		removeReceivingSpaceList(warehouse, options);
	 		
 		}		
		
		if(isSaveShippingSpaceListEnabled(options)){
	 		saveShippingSpaceList(warehouse, options);
	 		removeShippingSpaceList(warehouse, options);
	 		
 		}		
		
		if(isSaveDamageSpaceListEnabled(options)){
	 		saveDamageSpaceList(warehouse, options);
	 		removeDamageSpaceList(warehouse, options);
	 		
 		}		
		
		if(isSaveWarehouseAssetListEnabled(options)){
	 		saveWarehouseAssetList(warehouse, options);
	 		removeWarehouseAssetList(warehouse, options);
	 		
 		}		
		
		return warehouse;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Warehouse saveOwner(Warehouse warehouse, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(warehouse.getOwner() == null){
 			return warehouse;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(warehouse.getOwner(),options);
 		return warehouse;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected Warehouse saveStorageSpaceList(Warehouse warehouse, Map<String,Object> options){
		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();
		if(storageSpaceList == null){
			return warehouse;
		}
		if(storageSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getStorageSpaceDAO().saveStorageSpaceList(storageSpaceList,options);
		
		return warehouse;
	
	}
	
	protected Warehouse removeStorageSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();
		if(storageSpaceList == null){
			return warehouse;
		}	
	
		SmartList<StorageSpace> toRemoveStorageSpaceList = storageSpaceList.getToRemoveList();
		
		if(toRemoveStorageSpaceList == null){
			return warehouse;
		}
		if(toRemoveStorageSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getStorageSpaceDAO().removeStorageSpaceList(toRemoveStorageSpaceList,options);
		
		return warehouse;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Warehouse saveSmartPalletList(Warehouse warehouse, Map<String,Object> options){
		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();
		if(smartPalletList == null){
			return warehouse;
		}
		if(smartPalletList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSmartPalletDAO().saveSmartPalletList(smartPalletList,options);
		
		return warehouse;
	
	}
	
	protected Warehouse removeSmartPalletList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();
		if(smartPalletList == null){
			return warehouse;
		}	
	
		SmartList<SmartPallet> toRemoveSmartPalletList = smartPalletList.getToRemoveList();
		
		if(toRemoveSmartPalletList == null){
			return warehouse;
		}
		if(toRemoveSmartPalletList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSmartPalletDAO().removeSmartPalletList(toRemoveSmartPalletList,options);
		
		return warehouse;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Warehouse saveSupplierSpaceList(Warehouse warehouse, Map<String,Object> options){
		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();
		if(supplierSpaceList == null){
			return warehouse;
		}
		if(supplierSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplierSpaceDAO().saveSupplierSpaceList(supplierSpaceList,options);
		
		return warehouse;
	
	}
	
	protected Warehouse removeSupplierSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();
		if(supplierSpaceList == null){
			return warehouse;
		}	
	
		SmartList<SupplierSpace> toRemoveSupplierSpaceList = supplierSpaceList.getToRemoveList();
		
		if(toRemoveSupplierSpaceList == null){
			return warehouse;
		}
		if(toRemoveSupplierSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplierSpaceDAO().removeSupplierSpaceList(toRemoveSupplierSpaceList,options);
		
		return warehouse;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Warehouse saveReceivingSpaceList(Warehouse warehouse, Map<String,Object> options){
		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();
		if(receivingSpaceList == null){
			return warehouse;
		}
		if(receivingSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getReceivingSpaceDAO().saveReceivingSpaceList(receivingSpaceList,options);
		
		return warehouse;
	
	}
	
	protected Warehouse removeReceivingSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();
		if(receivingSpaceList == null){
			return warehouse;
		}	
	
		SmartList<ReceivingSpace> toRemoveReceivingSpaceList = receivingSpaceList.getToRemoveList();
		
		if(toRemoveReceivingSpaceList == null){
			return warehouse;
		}
		if(toRemoveReceivingSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getReceivingSpaceDAO().removeReceivingSpaceList(toRemoveReceivingSpaceList,options);
		
		return warehouse;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Warehouse saveShippingSpaceList(Warehouse warehouse, Map<String,Object> options){
		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();
		if(shippingSpaceList == null){
			return warehouse;
		}
		if(shippingSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getShippingSpaceDAO().saveShippingSpaceList(shippingSpaceList,options);
		
		return warehouse;
	
	}
	
	protected Warehouse removeShippingSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();
		if(shippingSpaceList == null){
			return warehouse;
		}	
	
		SmartList<ShippingSpace> toRemoveShippingSpaceList = shippingSpaceList.getToRemoveList();
		
		if(toRemoveShippingSpaceList == null){
			return warehouse;
		}
		if(toRemoveShippingSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getShippingSpaceDAO().removeShippingSpaceList(toRemoveShippingSpaceList,options);
		
		return warehouse;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Warehouse saveDamageSpaceList(Warehouse warehouse, Map<String,Object> options){
		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();
		if(damageSpaceList == null){
			return warehouse;
		}
		if(damageSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getDamageSpaceDAO().saveDamageSpaceList(damageSpaceList,options);
		
		return warehouse;
	
	}
	
	protected Warehouse removeDamageSpaceList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();
		if(damageSpaceList == null){
			return warehouse;
		}	
	
		SmartList<DamageSpace> toRemoveDamageSpaceList = damageSpaceList.getToRemoveList();
		
		if(toRemoveDamageSpaceList == null){
			return warehouse;
		}
		if(toRemoveDamageSpaceList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getDamageSpaceDAO().removeDamageSpaceList(toRemoveDamageSpaceList,options);
		
		return warehouse;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected Warehouse saveWarehouseAssetList(Warehouse warehouse, Map<String,Object> options){
		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();
		if(warehouseAssetList == null){
			return warehouse;
		}
		if(warehouseAssetList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getWarehouseAssetDAO().saveWarehouseAssetList(warehouseAssetList,options);
		
		return warehouse;
	
	}
	
	protected Warehouse removeWarehouseAssetList(Warehouse warehouse, Map<String,Object> options){
	
	
		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();
		if(warehouseAssetList == null){
			return warehouse;
		}	
	
		SmartList<WarehouseAsset> toRemoveWarehouseAssetList = warehouseAssetList.getToRemoveList();
		
		if(toRemoveWarehouseAssetList == null){
			return warehouse;
		}
		if(toRemoveWarehouseAssetList.isEmpty()){
			return warehouse;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getWarehouseAssetDAO().removeWarehouseAssetList(toRemoveWarehouseAssetList,options);
		
		return warehouse;
	
	}
	
	
	
 	
 	
	
	
	
		

	public Warehouse present(Warehouse warehouse,Map<String, Object> options){
	
		presentStorageSpaceList(warehouse,options);
		presentSmartPalletList(warehouse,options);
		presentSupplierSpaceList(warehouse,options);
		presentReceivingSpaceList(warehouse,options);
		presentShippingSpaceList(warehouse,options);
		presentDamageSpaceList(warehouse,options);
		presentWarehouseAssetList(warehouse,options);

		return warehouse;
	
	}
		
	
  	
 	protected Warehouse presentStorageSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<StorageSpace> storageSpaceList = warehouse.getStorageSpaceList();		
		if(storageSpaceList == null){
			return warehouse;			
		}
		
		String targetObjectName = "storageSpace";
		int storageSpaceListSize = storageSpaceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(storageSpaceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return warehouse;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = storageSpaceListSize;
		if(storageSpaceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getStorageSpaceDAO().countStorageSpaceByWarehouse(warehouse.getId(), options);			
		}
		//warehouse.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//warehouse.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(storageSpaceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(storageSpaceListSize,currentPage,rowsPerPage) ;
			storageSpaceList = storageSpaceList.subListOf(fromIndex, toIndex);
			storageSpaceList.setTotalCount(count);
			storageSpaceList.setCurrentPageNumber(currentPage);			
			warehouse.setStorageSpaceList(storageSpaceList);
			return warehouse;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		storageSpaceList 
			= getStorageSpaceDAO().findStorageSpaceByWarehouse(warehouse.getId(),start, rowsPerPage, options );
		storageSpaceList.setTotalCount(count);
		storageSpaceList.setCurrentPageNumber(currentPage);
		warehouse.setStorageSpaceList(storageSpaceList );	

		return warehouse;
	}			
		
	
  	
 	protected Warehouse presentSmartPalletList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<SmartPallet> smartPalletList = warehouse.getSmartPalletList();		
		if(smartPalletList == null){
			return warehouse;			
		}
		
		String targetObjectName = "smartPallet";
		int smartPalletListSize = smartPalletList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(smartPalletListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return warehouse;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = smartPalletListSize;
		if(smartPalletListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSmartPalletDAO().countSmartPalletByWarehouse(warehouse.getId(), options);			
		}
		//warehouse.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//warehouse.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(smartPalletListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(smartPalletListSize,currentPage,rowsPerPage) ;
			smartPalletList = smartPalletList.subListOf(fromIndex, toIndex);
			smartPalletList.setTotalCount(count);
			smartPalletList.setCurrentPageNumber(currentPage);			
			warehouse.setSmartPalletList(smartPalletList);
			return warehouse;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		smartPalletList 
			= getSmartPalletDAO().findSmartPalletByWarehouse(warehouse.getId(),start, rowsPerPage, options );
		smartPalletList.setTotalCount(count);
		smartPalletList.setCurrentPageNumber(currentPage);
		warehouse.setSmartPalletList(smartPalletList );	

		return warehouse;
	}			
		
	
  	
 	protected Warehouse presentSupplierSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<SupplierSpace> supplierSpaceList = warehouse.getSupplierSpaceList();		
		if(supplierSpaceList == null){
			return warehouse;			
		}
		
		String targetObjectName = "supplierSpace";
		int supplierSpaceListSize = supplierSpaceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplierSpaceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return warehouse;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplierSpaceListSize;
		if(supplierSpaceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplierSpaceDAO().countSupplierSpaceByWarehouse(warehouse.getId(), options);			
		}
		//warehouse.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//warehouse.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplierSpaceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplierSpaceListSize,currentPage,rowsPerPage) ;
			supplierSpaceList = supplierSpaceList.subListOf(fromIndex, toIndex);
			supplierSpaceList.setTotalCount(count);
			supplierSpaceList.setCurrentPageNumber(currentPage);			
			warehouse.setSupplierSpaceList(supplierSpaceList);
			return warehouse;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplierSpaceList 
			= getSupplierSpaceDAO().findSupplierSpaceByWarehouse(warehouse.getId(),start, rowsPerPage, options );
		supplierSpaceList.setTotalCount(count);
		supplierSpaceList.setCurrentPageNumber(currentPage);
		warehouse.setSupplierSpaceList(supplierSpaceList );	

		return warehouse;
	}			
		
	
  	
 	protected Warehouse presentReceivingSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<ReceivingSpace> receivingSpaceList = warehouse.getReceivingSpaceList();		
		if(receivingSpaceList == null){
			return warehouse;			
		}
		
		String targetObjectName = "receivingSpace";
		int receivingSpaceListSize = receivingSpaceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(receivingSpaceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return warehouse;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = receivingSpaceListSize;
		if(receivingSpaceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getReceivingSpaceDAO().countReceivingSpaceByWarehouse(warehouse.getId(), options);			
		}
		//warehouse.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//warehouse.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(receivingSpaceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(receivingSpaceListSize,currentPage,rowsPerPage) ;
			receivingSpaceList = receivingSpaceList.subListOf(fromIndex, toIndex);
			receivingSpaceList.setTotalCount(count);
			receivingSpaceList.setCurrentPageNumber(currentPage);			
			warehouse.setReceivingSpaceList(receivingSpaceList);
			return warehouse;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		receivingSpaceList 
			= getReceivingSpaceDAO().findReceivingSpaceByWarehouse(warehouse.getId(),start, rowsPerPage, options );
		receivingSpaceList.setTotalCount(count);
		receivingSpaceList.setCurrentPageNumber(currentPage);
		warehouse.setReceivingSpaceList(receivingSpaceList );	

		return warehouse;
	}			
		
	
  	
 	protected Warehouse presentShippingSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<ShippingSpace> shippingSpaceList = warehouse.getShippingSpaceList();		
		if(shippingSpaceList == null){
			return warehouse;			
		}
		
		String targetObjectName = "shippingSpace";
		int shippingSpaceListSize = shippingSpaceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(shippingSpaceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return warehouse;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = shippingSpaceListSize;
		if(shippingSpaceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getShippingSpaceDAO().countShippingSpaceByWarehouse(warehouse.getId(), options);			
		}
		//warehouse.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//warehouse.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(shippingSpaceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(shippingSpaceListSize,currentPage,rowsPerPage) ;
			shippingSpaceList = shippingSpaceList.subListOf(fromIndex, toIndex);
			shippingSpaceList.setTotalCount(count);
			shippingSpaceList.setCurrentPageNumber(currentPage);			
			warehouse.setShippingSpaceList(shippingSpaceList);
			return warehouse;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		shippingSpaceList 
			= getShippingSpaceDAO().findShippingSpaceByWarehouse(warehouse.getId(),start, rowsPerPage, options );
		shippingSpaceList.setTotalCount(count);
		shippingSpaceList.setCurrentPageNumber(currentPage);
		warehouse.setShippingSpaceList(shippingSpaceList );	

		return warehouse;
	}			
		
	
  	
 	protected Warehouse presentDamageSpaceList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<DamageSpace> damageSpaceList = warehouse.getDamageSpaceList();		
		if(damageSpaceList == null){
			return warehouse;			
		}
		
		String targetObjectName = "damageSpace";
		int damageSpaceListSize = damageSpaceList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(damageSpaceListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return warehouse;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = damageSpaceListSize;
		if(damageSpaceListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getDamageSpaceDAO().countDamageSpaceByWarehouse(warehouse.getId(), options);			
		}
		//warehouse.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//warehouse.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(damageSpaceListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(damageSpaceListSize,currentPage,rowsPerPage) ;
			damageSpaceList = damageSpaceList.subListOf(fromIndex, toIndex);
			damageSpaceList.setTotalCount(count);
			damageSpaceList.setCurrentPageNumber(currentPage);			
			warehouse.setDamageSpaceList(damageSpaceList);
			return warehouse;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		damageSpaceList 
			= getDamageSpaceDAO().findDamageSpaceByWarehouse(warehouse.getId(),start, rowsPerPage, options );
		damageSpaceList.setTotalCount(count);
		damageSpaceList.setCurrentPageNumber(currentPage);
		warehouse.setDamageSpaceList(damageSpaceList );	

		return warehouse;
	}			
		
	
  	
 	protected Warehouse presentWarehouseAssetList(
			Warehouse warehouse,
			Map<String, Object> options) {

		SmartList<WarehouseAsset> warehouseAssetList = warehouse.getWarehouseAssetList();		
		if(warehouseAssetList == null){
			return warehouse;			
		}
		
		String targetObjectName = "warehouseAsset";
		int warehouseAssetListSize = warehouseAssetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(warehouseAssetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return warehouse;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = warehouseAssetListSize;
		if(warehouseAssetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getWarehouseAssetDAO().countWarehouseAssetByOwner(warehouse.getId(), options);			
		}
		//warehouse.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//warehouse.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(warehouseAssetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(warehouseAssetListSize,currentPage,rowsPerPage) ;
			warehouseAssetList = warehouseAssetList.subListOf(fromIndex, toIndex);
			warehouseAssetList.setTotalCount(count);
			warehouseAssetList.setCurrentPageNumber(currentPage);			
			warehouse.setWarehouseAssetList(warehouseAssetList);
			return warehouse;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		warehouseAssetList 
			= getWarehouseAssetDAO().findWarehouseAssetByOwner(warehouse.getId(),start, rowsPerPage, options );
		warehouseAssetList.setTotalCount(count);
		warehouseAssetList.setCurrentPageNumber(currentPage);
		warehouse.setWarehouseAssetList(warehouseAssetList );	

		return warehouse;
	}			
		


	protected String getTableName(){
		return WarehouseTable.TABLE_NAME;
	}
}


