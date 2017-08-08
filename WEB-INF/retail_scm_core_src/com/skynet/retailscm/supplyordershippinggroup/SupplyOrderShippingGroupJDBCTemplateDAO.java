
package com.skynet.retailscm.supplyordershippinggroup;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.supplyorder.SupplyOrder;

import com.skynet.retailscm.supplyorder.SupplyOrderDAO;

import com.skynet.retailscm.supplyorder.SupplyOrderTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class SupplyOrderShippingGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderShippingGroupDAO{
 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}

		

	
	/*
	protected SupplyOrderShippingGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShippingGroup(accessKey, options);
	}
	*/
	public SupplyOrderShippingGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderShippingGroup(SupplyOrderShippingGroupTable.withId(id), options);
	}
	
	
	
	public SupplyOrderShippingGroup save(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options){
		
		String methodName="save(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderShippingGroup, methodName, "supplyOrderShippingGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderShippingGroup(supplyOrderShippingGroup,options);
	}
	public SupplyOrderShippingGroup clone(String supplyOrderShippingGroupId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderShippingGroupTable.withId(supplyOrderShippingGroupId),options);
	}
	
	protected SupplyOrderShippingGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderShippingGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderShippingGroup newSupplyOrderShippingGroup = loadInternalSupplyOrderShippingGroup(accessKey, options);
		newSupplyOrderShippingGroup.setVersion(0);
		
		

		
		saveInternalSupplyOrderShippingGroup(newSupplyOrderShippingGroup,options);
		
		return newSupplyOrderShippingGroup;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderShippingGroupId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderShippingGroupId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderShippingGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderShippingGroupNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderShippingGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderShippingGroupId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderShippingGroupId, int version)";
		assertMethodArgumentNotNull(supplyOrderShippingGroupId, methodName, "supplyOrderShippingGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderShippingGroupId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderShippingGroupId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","biz_order","amount"};
		return SupplyOrderShippingGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_shipping_group";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderShippingGroupTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderShippingGroupTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderShippingGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected SupplyOrderShippingGroupMapper getSupplyOrderShippingGroupMapper(){
		return new SupplyOrderShippingGroupMapper();
	}
	protected SupplyOrderShippingGroup extractSupplyOrderShippingGroup(String supplyOrderShippingGroupId) throws Exception{
		String SQL = "select * from supply_order_shipping_group_data where id = ?";	
		try{
		
			SupplyOrderShippingGroup supplyOrderShippingGroup = queryForObject(SQL, new Object[]{supplyOrderShippingGroupId}, getSupplyOrderShippingGroupMapper());
			return supplyOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderShippingGroupNotFoundException("SupplyOrderShippingGroup("+supplyOrderShippingGroupId+") is not found!");
		}
		
		
	}
	protected SupplyOrderShippingGroup extractSupplyOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_shipping_group_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderShippingGroup supplyOrderShippingGroup = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderShippingGroupMapper());
			return supplyOrderShippingGroup;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderShippingGroupNotFoundException("SupplyOrderShippingGroup("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderShippingGroup loadInternalSupplyOrderShippingGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = extractSupplyOrderShippingGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(supplyOrderShippingGroup, loadOptions);
 		}
 
		
		return supplyOrderShippingGroup;
		
	}



	
	
	 

 	protected SupplyOrderShippingGroup extractBizOrder(SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object> options) throws Exception{

		if(supplyOrderShippingGroup.getBizOrder() == null){
			return supplyOrderShippingGroup;
		}
		String bizOrderId = supplyOrderShippingGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return supplyOrderShippingGroup;
		}
		SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			supplyOrderShippingGroup.setBizOrder(bizOrder);
		}
		
 		
 		return supplyOrderShippingGroup;
 	}
 		
 
		
		
  	
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = queryForList(SQL, new Object[]{supplyOrderId}, getSupplyOrderShippingGroupMapper());	
 		return supplyOrderShippingGroupList;
 	}
 	
 	public SmartList<SupplyOrderShippingGroup> findSupplyOrderShippingGroupByBizOrder(String supplyOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList = queryForList(SQL, new Object[]{supplyOrderId,start, count}, getSupplyOrderShippingGroupMapper());
		
 		return supplyOrderShippingGroupList;
 	}
 	
 	public int countSupplyOrderShippingGroupByBizOrder(String supplyOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroup(SupplyOrderShippingGroup  supplyOrderShippingGroup){
	
		String SQL=this.getSaveSupplyOrderShippingGroupSQL(supplyOrderShippingGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderShippingGroupParameters(supplyOrderShippingGroup);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderShippingGroup.incVersion();
		return supplyOrderShippingGroup;
	
	}
	public SmartList<SupplyOrderShippingGroup> saveSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderShippingGroupList(supplyOrderShippingGroupList);
		
		batchSupplyOrderShippingGroupCreate((List<SupplyOrderShippingGroup>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderShippingGroupUpdate((List<SupplyOrderShippingGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			if(supplyOrderShippingGroup.isChanged()){
				supplyOrderShippingGroup.incVersion();
			}
			
		
		}
		
		
		return supplyOrderShippingGroupList;
	}

	public SmartList<SupplyOrderShippingGroup> removeSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderShippingGroupList, options);
		
		return supplyOrderShippingGroupList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderShippingGroupBatchCreateArgs(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList ){
			Object [] parameters = prepareSupplyOrderShippingGroupCreateParameters(supplyOrderShippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderShippingGroupBatchUpdateArgs(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList ){
			if(!supplyOrderShippingGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderShippingGroupUpdateParameters(supplyOrderShippingGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderShippingGroupCreate(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderShippingGroupBatchCreateArgs(supplyOrderShippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderShippingGroupUpdate(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderShippingGroupBatchUpdateArgs(supplyOrderShippingGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderShippingGroupList(List<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		
		List<SupplyOrderShippingGroup> supplyOrderShippingGroupCreateList=new ArrayList<SupplyOrderShippingGroup>();
		List<SupplyOrderShippingGroup> supplyOrderShippingGroupUpdateList=new ArrayList<SupplyOrderShippingGroup>();
		
		for(SupplyOrderShippingGroup supplyOrderShippingGroup: supplyOrderShippingGroupList){
			if(isUpdateRequest(supplyOrderShippingGroup)){
				supplyOrderShippingGroupUpdateList.add( supplyOrderShippingGroup);
				continue;
			}
			supplyOrderShippingGroupCreateList.add(supplyOrderShippingGroup);
		}
		
		return new Object[]{supplyOrderShippingGroupCreateList,supplyOrderShippingGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		return supplyOrderShippingGroup.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderShippingGroupSQL(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		if(isUpdateRequest(supplyOrderShippingGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderShippingGroupParameters(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		if(isUpdateRequest(supplyOrderShippingGroup) ){
 			return prepareSupplyOrderShippingGroupUpdateParameters(supplyOrderShippingGroup);
 		}
 		return prepareSupplyOrderShippingGroupCreateParameters(supplyOrderShippingGroup);
 	}
 	protected Object[] prepareSupplyOrderShippingGroupUpdateParameters(SupplyOrderShippingGroup supplyOrderShippingGroup){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderShippingGroup.getName(); 	
 		if(supplyOrderShippingGroup.getBizOrder() != null){
 			parameters[1] = supplyOrderShippingGroup.getBizOrder().getId();
 		}
 
 		parameters[2] = supplyOrderShippingGroup.getAmount();		
 		parameters[3] = supplyOrderShippingGroup.getId();
 		parameters[4] = supplyOrderShippingGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderShippingGroupCreateParameters(SupplyOrderShippingGroup supplyOrderShippingGroup){
		Object[] parameters = new Object[4];
		String newSupplyOrderShippingGroupId=getNextId();
		supplyOrderShippingGroup.setId(newSupplyOrderShippingGroupId);
		parameters[0] =  supplyOrderShippingGroup.getId();
 
 		parameters[1] = supplyOrderShippingGroup.getName(); 	
 		if(supplyOrderShippingGroup.getBizOrder() != null){
 			parameters[2] = supplyOrderShippingGroup.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = supplyOrderShippingGroup.getAmount();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderShippingGroup saveInternalSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object> options){
		
		saveSupplyOrderShippingGroup(supplyOrderShippingGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(supplyOrderShippingGroup, options);
 		}
 
		
		return supplyOrderShippingGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplyOrderShippingGroup saveBizOrder(SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrderShippingGroup.getBizOrder() == null){
 			return supplyOrderShippingGroup;//do nothing when it is null
 		}
 		
 		getSupplyOrderDAO().save(supplyOrderShippingGroup.getBizOrder(),options);
 		return supplyOrderShippingGroup;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public SupplyOrderShippingGroup present(SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String, Object> options){
	

		return supplyOrderShippingGroup;
	
	}
		


	protected String getTableName(){
		return SupplyOrderShippingGroupTable.TABLE_NAME;
	}
}


