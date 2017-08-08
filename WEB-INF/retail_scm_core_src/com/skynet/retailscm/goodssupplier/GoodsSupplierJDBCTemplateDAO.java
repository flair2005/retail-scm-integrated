
package com.skynet.retailscm.goodssupplier;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.supplierproduct.SupplierProduct;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.skynet.retailscm.accountset.AccountSetDAO;
import com.skynet.retailscm.supplierproduct.SupplierProductDAO;
import com.skynet.retailscm.supplyorder.SupplyOrderDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.skynet.retailscm.supplierproduct.SupplierProductTable;
import com.skynet.retailscm.supplyorder.SupplyOrderTable;
import com.skynet.retailscm.accountset.AccountSetTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class GoodsSupplierJDBCTemplateDAO extends CommonJDBCTemplateDAO implements GoodsSupplierDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		
	
  	private  SupplierProductDAO  supplierProductDAO;
 	public void setSupplierProductDAO(SupplierProductDAO pSupplierProductDAO){
 	
 		if(pSupplierProductDAO == null){
 			throw new IllegalStateException("Do not try to set supplierProductDAO to null.");
 		}
	 	this.supplierProductDAO = pSupplierProductDAO;
 	}
 	public SupplierProductDAO getSupplierProductDAO(){
 		if(this.supplierProductDAO == null){
 			throw new IllegalStateException("The supplierProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplierProductDAO;
 	}	
 	
			
		
	
  	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO pSupplyOrderDAO){
 	
 		if(pSupplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = pSupplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.supplyOrderDAO;
 	}	
 	
			
		
	
  	private  AccountSetDAO  accountSetDAO;
 	public void setAccountSetDAO(AccountSetDAO pAccountSetDAO){
 	
 		if(pAccountSetDAO == null){
 			throw new IllegalStateException("Do not try to set accountSetDAO to null.");
 		}
	 	this.accountSetDAO = pAccountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
 		if(this.accountSetDAO == null){
 			throw new IllegalStateException("The accountSetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountSetDAO;
 	}	
 	
			
		

	
	/*
	protected GoodsSupplier load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGoodsSupplier(accessKey, options);
	}
	*/
	public GoodsSupplier load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGoodsSupplier(GoodsSupplierTable.withId(id), options);
	}
	
	
	
	public GoodsSupplier save(GoodsSupplier goodsSupplier,Map<String,Object> options){
		
		String methodName="save(GoodsSupplier goodsSupplier,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(goodsSupplier, methodName, "goodsSupplier");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGoodsSupplier(goodsSupplier,options);
	}
	public GoodsSupplier clone(String goodsSupplierId, Map<String,Object> options) throws Exception{
	
		return clone(GoodsSupplierTable.withId(goodsSupplierId),options);
	}
	
	protected GoodsSupplier clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String goodsSupplierId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GoodsSupplier newGoodsSupplier = loadInternalGoodsSupplier(accessKey, options);
		newGoodsSupplier.setVersion(0);
		
		
 		
 		if(isSaveSupplierProductListEnabled(options)){
 			for(SupplierProduct item: newGoodsSupplier.getSupplierProductList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newGoodsSupplier.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountSetListEnabled(options)){
 			for(AccountSet item: newGoodsSupplier.getAccountSetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGoodsSupplier(newGoodsSupplier,options);
		
		return newGoodsSupplier;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String goodsSupplierId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{goodsSupplierId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new GoodsSupplierVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GoodsSupplierNotFoundException(
					"The " + this.getTableName() + "(" + goodsSupplierId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String goodsSupplierId, int version) throws Exception{
	
		String methodName="delete(String goodsSupplierId, int version)";
		assertMethodArgumentNotNull(goodsSupplierId, methodName, "goodsSupplierId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{goodsSupplierId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(goodsSupplierId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","supply_product","belong_to","contact_number","description"};
		return GoodsSupplierTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "goods_supplier";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GoodsSupplierTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongToEnabled = true;
 	//private static final String BELONGTO = "belongTo";
 	protected boolean isExtractBelongToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, GoodsSupplierTokens.BELONGTO);
 	}
 	
 	
 	//private boolean saveBelongToEnabled = true;
 	protected boolean isSaveBelongToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, GoodsSupplierTokens.BELONGTO);
 	}
 	

 	
 
		
	//protected static final String SUPPLIER_PRODUCT_LIST = "supplierProductList";
	
	protected boolean isExtractSupplierProductListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsSupplierTokens.SUPPLIER_PRODUCT_LIST);
		
 	}

	protected boolean isSaveSupplierProductListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsSupplierTokens.SUPPLIER_PRODUCT_LIST);
		
 	}
 	
 	
			
		
	//protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	
	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsSupplierTokens.SUPPLY_ORDER_LIST);
		
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsSupplierTokens.SUPPLY_ORDER_LIST);
		
 	}
 	
 	
			
		
	//protected static final String ACCOUNT_SET_LIST = "accountSetList";
	
	protected boolean isExtractAccountSetListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,GoodsSupplierTokens.ACCOUNT_SET_LIST);
		
 	}

	protected boolean isSaveAccountSetListEnabled(Map<String,Object> options){
		return checkOptions(options, GoodsSupplierTokens.ACCOUNT_SET_LIST);
		
 	}
 	
 	
			
		

	

	protected GoodsSupplierMapper getGoodsSupplierMapper(){
		return new GoodsSupplierMapper();
	}
	protected GoodsSupplier extractGoodsSupplier(String goodsSupplierId) throws Exception{
		String SQL = "select * from goods_supplier_data where id = ?";	
		try{
		
			GoodsSupplier goodsSupplier = queryForObject(SQL, new Object[]{goodsSupplierId}, getGoodsSupplierMapper());
			return goodsSupplier;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsSupplierNotFoundException("GoodsSupplier("+goodsSupplierId+") is not found!");
		}
		
		
	}
	protected GoodsSupplier extractGoodsSupplier(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from goods_supplier_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			GoodsSupplier goodsSupplier = queryForObject(SQL, new Object[]{accessKey.getValue()}, getGoodsSupplierMapper());
			return goodsSupplier;
		}catch(EmptyResultDataAccessException e){
			throw new GoodsSupplierNotFoundException("GoodsSupplier("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected GoodsSupplier loadInternalGoodsSupplier(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GoodsSupplier goodsSupplier = extractGoodsSupplier(accessKey, loadOptions);
 	
 		if(isExtractBelongToEnabled(loadOptions)){
	 		extractBelongTo(goodsSupplier, loadOptions);
 		}
 
		
		if(isExtractSupplierProductListEnabled(loadOptions)){
	 		extractSupplierProductList(goodsSupplier, loadOptions);
 		}		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(goodsSupplier, loadOptions);
 		}		
		
		if(isExtractAccountSetListEnabled(loadOptions)){
	 		extractAccountSetList(goodsSupplier, loadOptions);
 		}		
		
		return goodsSupplier;
		
	}



	
	
	 

 	protected GoodsSupplier extractBelongTo(GoodsSupplier goodsSupplier, Map<String,Object> options) throws Exception{

		if(goodsSupplier.getBelongTo() == null){
			return goodsSupplier;
		}
		String belongToId = goodsSupplier.getBelongTo().getId();
		if( belongToId == null){
			return goodsSupplier;
		}
		RetailStoreCountryCenter belongTo = getRetailStoreCountryCenterDAO().load(belongToId,options);
		if(belongTo != null){
			goodsSupplier.setBelongTo(belongTo);
		}
		
 		
 		return goodsSupplier;
 	}
 		
 
		
	protected GoodsSupplier extractSupplierProductList(GoodsSupplier goodsSupplier, Map<String,Object> options){
		
		SmartList<SupplierProduct> supplierProductList = getSupplierProductDAO().findSupplierProductBySupplier(goodsSupplier.getId(),options);
		if(supplierProductList != null){
			goodsSupplier.setSupplierProductList(supplierProductList);
		}
		
		return goodsSupplier;
	
	}	
		
	protected GoodsSupplier extractSupplyOrderList(GoodsSupplier goodsSupplier, Map<String,Object> options){
		
		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderBySeller(goodsSupplier.getId(),options);
		if(supplyOrderList != null){
			goodsSupplier.setSupplyOrderList(supplyOrderList);
		}
		
		return goodsSupplier;
	
	}	
		
	protected GoodsSupplier extractAccountSetList(GoodsSupplier goodsSupplier, Map<String,Object> options){
		
		SmartList<AccountSet> accountSetList = getAccountSetDAO().findAccountSetByGoodsSupplier(goodsSupplier.getId(),options);
		if(accountSetList != null){
			goodsSupplier.setAccountSetList(accountSetList);
		}
		
		return goodsSupplier;
	
	}	
		
		
  	
 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belong_to = ?";
		SmartList<GoodsSupplier> goodsSupplierList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getGoodsSupplierMapper());	
 		return goodsSupplierList;
 	}
 	
 	public SmartList<GoodsSupplier> findGoodsSupplierByBelongTo(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belong_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<GoodsSupplier> goodsSupplierList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getGoodsSupplierMapper());
		
 		return goodsSupplierList;
 	}
 	
 	public int countGoodsSupplierByBelongTo(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belong_to = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected GoodsSupplier saveGoodsSupplier(GoodsSupplier  goodsSupplier){
	
		String SQL=this.getSaveGoodsSupplierSQL(goodsSupplier);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGoodsSupplierParameters(goodsSupplier);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		goodsSupplier.incVersion();
		return goodsSupplier;
	
	}
	public SmartList<GoodsSupplier> saveGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGoodsSupplierList(goodsSupplierList);
		
		batchGoodsSupplierCreate((List<GoodsSupplier>)lists[CREATE_LIST_INDEX]);
		
		batchGoodsSupplierUpdate((List<GoodsSupplier>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GoodsSupplier goodsSupplier:goodsSupplierList){
			if(goodsSupplier.isChanged()){
				goodsSupplier.incVersion();
			}
			
		
		}
		
		
		return goodsSupplierList;
	}

	public SmartList<GoodsSupplier> removeGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options){
		
		
		super.removeList(goodsSupplierList, options);
		
		return goodsSupplierList;
		
		
	}
	
	protected List<Object[]> prepareGoodsSupplierBatchCreateArgs(List<GoodsSupplier> goodsSupplierList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsSupplier goodsSupplier:goodsSupplierList ){
			Object [] parameters = prepareGoodsSupplierCreateParameters(goodsSupplier);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGoodsSupplierBatchUpdateArgs(List<GoodsSupplier> goodsSupplierList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GoodsSupplier goodsSupplier:goodsSupplierList ){
			if(!goodsSupplier.isChanged()){
				continue;
			}
			Object [] parameters = prepareGoodsSupplierUpdateParameters(goodsSupplier);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGoodsSupplierCreate(List<GoodsSupplier> goodsSupplierList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGoodsSupplierBatchCreateArgs(goodsSupplierList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGoodsSupplierUpdate(List<GoodsSupplier> goodsSupplierList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGoodsSupplierBatchUpdateArgs(goodsSupplierList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGoodsSupplierList(List<GoodsSupplier> goodsSupplierList){
		
		List<GoodsSupplier> goodsSupplierCreateList=new ArrayList<GoodsSupplier>();
		List<GoodsSupplier> goodsSupplierUpdateList=new ArrayList<GoodsSupplier>();
		
		for(GoodsSupplier goodsSupplier: goodsSupplierList){
			if(isUpdateRequest(goodsSupplier)){
				goodsSupplierUpdateList.add( goodsSupplier);
				continue;
			}
			goodsSupplierCreateList.add(goodsSupplier);
		}
		
		return new Object[]{goodsSupplierCreateList,goodsSupplierUpdateList};
	}
	
	protected boolean isUpdateRequest(GoodsSupplier goodsSupplier){
 		return goodsSupplier.getVersion() > 0;
 	}
 	protected String getSaveGoodsSupplierSQL(GoodsSupplier goodsSupplier){
 		if(isUpdateRequest(goodsSupplier)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGoodsSupplierParameters(GoodsSupplier goodsSupplier){
 		if(isUpdateRequest(goodsSupplier) ){
 			return prepareGoodsSupplierUpdateParameters(goodsSupplier);
 		}
 		return prepareGoodsSupplierCreateParameters(goodsSupplier);
 	}
 	protected Object[] prepareGoodsSupplierUpdateParameters(GoodsSupplier goodsSupplier){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = goodsSupplier.getName();
 		parameters[1] = goodsSupplier.getSupplyProduct(); 	
 		if(goodsSupplier.getBelongTo() != null){
 			parameters[2] = goodsSupplier.getBelongTo().getId();
 		}
 
 		parameters[3] = goodsSupplier.getContactNumber();
 		parameters[4] = goodsSupplier.getDescription();		
 		parameters[5] = goodsSupplier.getId();
 		parameters[6] = goodsSupplier.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGoodsSupplierCreateParameters(GoodsSupplier goodsSupplier){
		Object[] parameters = new Object[6];
		String newGoodsSupplierId=getNextId();
		goodsSupplier.setId(newGoodsSupplierId);
		parameters[0] =  goodsSupplier.getId();
 
 		parameters[1] = goodsSupplier.getName();
 		parameters[2] = goodsSupplier.getSupplyProduct(); 	
 		if(goodsSupplier.getBelongTo() != null){
 			parameters[3] = goodsSupplier.getBelongTo().getId();
 		
 		}
 		
 		parameters[4] = goodsSupplier.getContactNumber();
 		parameters[5] = goodsSupplier.getDescription();		
 				
 		return parameters;
 	}
 	
	protected GoodsSupplier saveInternalGoodsSupplier(GoodsSupplier goodsSupplier, Map<String,Object> options){
		
		saveGoodsSupplier(goodsSupplier);
 	
 		if(isSaveBelongToEnabled(options)){
	 		saveBelongTo(goodsSupplier, options);
 		}
 
		
		if(isSaveSupplierProductListEnabled(options)){
	 		saveSupplierProductList(goodsSupplier, options);
	 		removeSupplierProductList(goodsSupplier, options);
	 		
 		}		
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(goodsSupplier, options);
	 		removeSupplyOrderList(goodsSupplier, options);
	 		
 		}		
		
		if(isSaveAccountSetListEnabled(options)){
	 		saveAccountSetList(goodsSupplier, options);
	 		removeAccountSetList(goodsSupplier, options);
	 		
 		}		
		
		return goodsSupplier;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected GoodsSupplier saveBelongTo(GoodsSupplier goodsSupplier, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(goodsSupplier.getBelongTo() == null){
 			return goodsSupplier;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(goodsSupplier.getBelongTo(),options);
 		return goodsSupplier;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected GoodsSupplier saveSupplierProductList(GoodsSupplier goodsSupplier, Map<String,Object> options){
		SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
		if(supplierProductList == null){
			return goodsSupplier;
		}
		if(supplierProductList.isEmpty()){
			return goodsSupplier;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplierProductDAO().saveSupplierProductList(supplierProductList,options);
		
		return goodsSupplier;
	
	}
	
	protected GoodsSupplier removeSupplierProductList(GoodsSupplier goodsSupplier, Map<String,Object> options){
	
	
		SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
		if(supplierProductList == null){
			return goodsSupplier;
		}	
	
		SmartList<SupplierProduct> toRemoveSupplierProductList = supplierProductList.getToRemoveList();
		
		if(toRemoveSupplierProductList == null){
			return goodsSupplier;
		}
		if(toRemoveSupplierProductList.isEmpty()){
			return goodsSupplier;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplierProductDAO().removeSupplierProductList(toRemoveSupplierProductList,options);
		
		return goodsSupplier;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected GoodsSupplier saveSupplyOrderList(GoodsSupplier goodsSupplier, Map<String,Object> options){
		SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
		if(supplyOrderList == null){
			return goodsSupplier;
		}
		if(supplyOrderList.isEmpty()){
			return goodsSupplier;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getSupplyOrderDAO().saveSupplyOrderList(supplyOrderList,options);
		
		return goodsSupplier;
	
	}
	
	protected GoodsSupplier removeSupplyOrderList(GoodsSupplier goodsSupplier, Map<String,Object> options){
	
	
		SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
		if(supplyOrderList == null){
			return goodsSupplier;
		}	
	
		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();
		
		if(toRemoveSupplyOrderList == null){
			return goodsSupplier;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return goodsSupplier;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);
		
		return goodsSupplier;
	
	}
	
	
	
 	
 	
	
	
	
		
	protected GoodsSupplier saveAccountSetList(GoodsSupplier goodsSupplier, Map<String,Object> options){
		SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
		if(accountSetList == null){
			return goodsSupplier;
		}
		if(accountSetList.isEmpty()){
			return goodsSupplier;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getAccountSetDAO().saveAccountSetList(accountSetList,options);
		
		return goodsSupplier;
	
	}
	
	protected GoodsSupplier removeAccountSetList(GoodsSupplier goodsSupplier, Map<String,Object> options){
	
	
		SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
		if(accountSetList == null){
			return goodsSupplier;
		}	
	
		SmartList<AccountSet> toRemoveAccountSetList = accountSetList.getToRemoveList();
		
		if(toRemoveAccountSetList == null){
			return goodsSupplier;
		}
		if(toRemoveAccountSetList.isEmpty()){
			return goodsSupplier;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountSetDAO().removeAccountSetList(toRemoveAccountSetList,options);
		
		return goodsSupplier;
	
	}
	
	
	
 	
 	
	
	
	
		

	public GoodsSupplier present(GoodsSupplier goodsSupplier,Map<String, Object> options){
	
		presentSupplierProductList(goodsSupplier,options);
		presentSupplyOrderList(goodsSupplier,options);
		presentAccountSetList(goodsSupplier,options);

		return goodsSupplier;
	
	}
		
	
  	
 	protected GoodsSupplier presentSupplierProductList(
			GoodsSupplier goodsSupplier,
			Map<String, Object> options) {

		SmartList<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();		
		if(supplierProductList == null){
			return goodsSupplier;			
		}
		
		String targetObjectName = "supplierProduct";
		int supplierProductListSize = supplierProductList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplierProductListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsSupplier;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplierProductListSize;
		if(supplierProductListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplierProductDAO().countSupplierProductBySupplier(goodsSupplier.getId(), options);			
		}
		//goodsSupplier.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsSupplier.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplierProductListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplierProductListSize,currentPage,rowsPerPage) ;
			supplierProductList = supplierProductList.subListOf(fromIndex, toIndex);
			supplierProductList.setTotalCount(count);
			supplierProductList.setCurrentPageNumber(currentPage);			
			goodsSupplier.setSupplierProductList(supplierProductList);
			return goodsSupplier;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplierProductList 
			= getSupplierProductDAO().findSupplierProductBySupplier(goodsSupplier.getId(),start, rowsPerPage, options );
		supplierProductList.setTotalCount(count);
		supplierProductList.setCurrentPageNumber(currentPage);
		goodsSupplier.setSupplierProductList(supplierProductList );	

		return goodsSupplier;
	}			
		
	
  	
 	protected GoodsSupplier presentSupplyOrderList(
			GoodsSupplier goodsSupplier,
			Map<String, Object> options) {

		SmartList<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();		
		if(supplyOrderList == null){
			return goodsSupplier;			
		}
		
		String targetObjectName = "supplyOrder";
		int supplyOrderListSize = supplyOrderList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(supplyOrderListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsSupplier;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = supplyOrderListSize;
		if(supplyOrderListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getSupplyOrderDAO().countSupplyOrderBySeller(goodsSupplier.getId(), options);			
		}
		//goodsSupplier.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsSupplier.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(supplyOrderListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(supplyOrderListSize,currentPage,rowsPerPage) ;
			supplyOrderList = supplyOrderList.subListOf(fromIndex, toIndex);
			supplyOrderList.setTotalCount(count);
			supplyOrderList.setCurrentPageNumber(currentPage);			
			goodsSupplier.setSupplyOrderList(supplyOrderList);
			return goodsSupplier;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		supplyOrderList 
			= getSupplyOrderDAO().findSupplyOrderBySeller(goodsSupplier.getId(),start, rowsPerPage, options );
		supplyOrderList.setTotalCount(count);
		supplyOrderList.setCurrentPageNumber(currentPage);
		goodsSupplier.setSupplyOrderList(supplyOrderList );	

		return goodsSupplier;
	}			
		
	
  	
 	protected GoodsSupplier presentAccountSetList(
			GoodsSupplier goodsSupplier,
			Map<String, Object> options) {

		SmartList<AccountSet> accountSetList = goodsSupplier.getAccountSetList();		
		if(accountSetList == null){
			return goodsSupplier;			
		}
		
		String targetObjectName = "accountSet";
		int accountSetListSize = accountSetList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(accountSetListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return goodsSupplier;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = accountSetListSize;
		if(accountSetListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getAccountSetDAO().countAccountSetByGoodsSupplier(goodsSupplier.getId(), options);			
		}
		//goodsSupplier.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//goodsSupplier.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(accountSetListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(accountSetListSize,currentPage,rowsPerPage) ;
			accountSetList = accountSetList.subListOf(fromIndex, toIndex);
			accountSetList.setTotalCount(count);
			accountSetList.setCurrentPageNumber(currentPage);			
			goodsSupplier.setAccountSetList(accountSetList);
			return goodsSupplier;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		accountSetList 
			= getAccountSetDAO().findAccountSetByGoodsSupplier(goodsSupplier.getId(),start, rowsPerPage, options );
		accountSetList.setTotalCount(count);
		accountSetList.setCurrentPageNumber(currentPage);
		goodsSupplier.setAccountSetList(accountSetList );	

		return goodsSupplier;
	}			
		


	protected String getTableName(){
		return GoodsSupplierTable.TABLE_NAME;
	}
}


