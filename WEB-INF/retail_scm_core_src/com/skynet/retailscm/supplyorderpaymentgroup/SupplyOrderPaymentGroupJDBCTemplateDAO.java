
package com.skynet.retailscm.supplyorderpaymentgroup;

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

public class SupplyOrderPaymentGroupJDBCTemplateDAO extends CommonJDBCTemplateDAO implements SupplyOrderPaymentGroupDAO{
 
 	
 	private  SupplyOrderDAO  supplyOrderDAO;
 	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
	 	return this.supplyOrderDAO;
 	}

		

	
	/*
	protected SupplyOrderPaymentGroup load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPaymentGroup(accessKey, options);
	}
	*/
	public SupplyOrderPaymentGroup load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSupplyOrderPaymentGroup(SupplyOrderPaymentGroupTable.withId(id), options);
	}
	
	
	
	public SupplyOrderPaymentGroup save(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options){
		
		String methodName="save(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(supplyOrderPaymentGroup, methodName, "supplyOrderPaymentGroup");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSupplyOrderPaymentGroup(supplyOrderPaymentGroup,options);
	}
	public SupplyOrderPaymentGroup clone(String supplyOrderPaymentGroupId, Map<String,Object> options) throws Exception{
	
		return clone(SupplyOrderPaymentGroupTable.withId(supplyOrderPaymentGroupId),options);
	}
	
	protected SupplyOrderPaymentGroup clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String supplyOrderPaymentGroupId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SupplyOrderPaymentGroup newSupplyOrderPaymentGroup = loadInternalSupplyOrderPaymentGroup(accessKey, options);
		newSupplyOrderPaymentGroup.setVersion(0);
		
		

		
		saveInternalSupplyOrderPaymentGroup(newSupplyOrderPaymentGroup,options);
		
		return newSupplyOrderPaymentGroup;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String supplyOrderPaymentGroupId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{supplyOrderPaymentGroupId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new SupplyOrderPaymentGroupVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SupplyOrderPaymentGroupNotFoundException(
					"The " + this.getTableName() + "(" + supplyOrderPaymentGroupId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String supplyOrderPaymentGroupId, int version) throws Exception{
	
		String methodName="delete(String supplyOrderPaymentGroupId, int version)";
		assertMethodArgumentNotNull(supplyOrderPaymentGroupId, methodName, "supplyOrderPaymentGroupId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{supplyOrderPaymentGroupId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(supplyOrderPaymentGroupId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","biz_order","card_number"};
		return SupplyOrderPaymentGroupTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "supply_order_payment_group";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SupplyOrderPaymentGroupTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBizOrderEnabled = true;
 	//private static final String BIZORDER = "bizOrder";
 	protected boolean isExtractBizOrderEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SupplyOrderPaymentGroupTokens.BIZORDER);
 	}
 	
 	
 	//private boolean saveBizOrderEnabled = true;
 	protected boolean isSaveBizOrderEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SupplyOrderPaymentGroupTokens.BIZORDER);
 	}
 	

 	
 
		

	

	protected SupplyOrderPaymentGroupMapper getSupplyOrderPaymentGroupMapper(){
		return new SupplyOrderPaymentGroupMapper();
	}
	protected SupplyOrderPaymentGroup extractSupplyOrderPaymentGroup(String supplyOrderPaymentGroupId) throws Exception{
		String SQL = "select * from supply_order_payment_group_data where id = ?";	
		try{
		
			SupplyOrderPaymentGroup supplyOrderPaymentGroup = queryForObject(SQL, new Object[]{supplyOrderPaymentGroupId}, getSupplyOrderPaymentGroupMapper());
			return supplyOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderPaymentGroupNotFoundException("SupplyOrderPaymentGroup("+supplyOrderPaymentGroupId+") is not found!");
		}
		
		
	}
	protected SupplyOrderPaymentGroup extractSupplyOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from supply_order_payment_group_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			SupplyOrderPaymentGroup supplyOrderPaymentGroup = queryForObject(SQL, new Object[]{accessKey.getValue()}, getSupplyOrderPaymentGroupMapper());
			return supplyOrderPaymentGroup;
		}catch(EmptyResultDataAccessException e){
			throw new SupplyOrderPaymentGroupNotFoundException("SupplyOrderPaymentGroup("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected SupplyOrderPaymentGroup loadInternalSupplyOrderPaymentGroup(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = extractSupplyOrderPaymentGroup(accessKey, loadOptions);
 	
 		if(isExtractBizOrderEnabled(loadOptions)){
	 		extractBizOrder(supplyOrderPaymentGroup, loadOptions);
 		}
 
		
		return supplyOrderPaymentGroup;
		
	}



	
	
	 

 	protected SupplyOrderPaymentGroup extractBizOrder(SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options) throws Exception{

		if(supplyOrderPaymentGroup.getBizOrder() == null){
			return supplyOrderPaymentGroup;
		}
		String bizOrderId = supplyOrderPaymentGroup.getBizOrder().getId();
		if( bizOrderId == null){
			return supplyOrderPaymentGroup;
		}
		SupplyOrder bizOrder = getSupplyOrderDAO().load(bizOrderId,options);
		if(bizOrder != null){
			supplyOrderPaymentGroup.setBizOrder(bizOrder);
		}
		
 		
 		return supplyOrderPaymentGroup;
 	}
 		
 
		
		
  	
 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ?";
		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = queryForList(SQL, new Object[]{supplyOrderId}, getSupplyOrderPaymentGroupMapper());	
 		return supplyOrderPaymentGroupList;
 	}
 	
 	public SmartList<SupplyOrderPaymentGroup> findSupplyOrderPaymentGroupByBizOrder(String supplyOrderId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where biz_order = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList = queryForList(SQL, new Object[]{supplyOrderId,start, count}, getSupplyOrderPaymentGroupMapper());
		
 		return supplyOrderPaymentGroupList;
 	}
 	
 	public int countSupplyOrderPaymentGroupByBizOrder(String supplyOrderId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where biz_order = ?";
		Integer count = queryInt(SQL, new Object[]{supplyOrderId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(SupplyOrderPaymentGroup  supplyOrderPaymentGroup){
	
		String SQL=this.getSaveSupplyOrderPaymentGroupSQL(supplyOrderPaymentGroup);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSupplyOrderPaymentGroupParameters(supplyOrderPaymentGroup);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		supplyOrderPaymentGroup.incVersion();
		return supplyOrderPaymentGroup;
	
	}
	public SmartList<SupplyOrderPaymentGroup> saveSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSupplyOrderPaymentGroupList(supplyOrderPaymentGroupList);
		
		batchSupplyOrderPaymentGroupCreate((List<SupplyOrderPaymentGroup>)lists[CREATE_LIST_INDEX]);
		
		batchSupplyOrderPaymentGroupUpdate((List<SupplyOrderPaymentGroup>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			if(supplyOrderPaymentGroup.isChanged()){
				supplyOrderPaymentGroup.incVersion();
			}
			
		
		}
		
		
		return supplyOrderPaymentGroupList;
	}

	public SmartList<SupplyOrderPaymentGroup> removeSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList,Map<String,Object> options){
		
		
		super.removeList(supplyOrderPaymentGroupList, options);
		
		return supplyOrderPaymentGroupList;
		
		
	}
	
	protected List<Object[]> prepareSupplyOrderPaymentGroupBatchCreateArgs(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList ){
			Object [] parameters = prepareSupplyOrderPaymentGroupCreateParameters(supplyOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSupplyOrderPaymentGroupBatchUpdateArgs(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList ){
			if(!supplyOrderPaymentGroup.isChanged()){
				continue;
			}
			Object [] parameters = prepareSupplyOrderPaymentGroupUpdateParameters(supplyOrderPaymentGroup);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSupplyOrderPaymentGroupCreate(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSupplyOrderPaymentGroupBatchCreateArgs(supplyOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSupplyOrderPaymentGroupUpdate(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSupplyOrderPaymentGroupBatchUpdateArgs(supplyOrderPaymentGroupList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSupplyOrderPaymentGroupList(List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		
		List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupCreateList=new ArrayList<SupplyOrderPaymentGroup>();
		List<SupplyOrderPaymentGroup> supplyOrderPaymentGroupUpdateList=new ArrayList<SupplyOrderPaymentGroup>();
		
		for(SupplyOrderPaymentGroup supplyOrderPaymentGroup: supplyOrderPaymentGroupList){
			if(isUpdateRequest(supplyOrderPaymentGroup)){
				supplyOrderPaymentGroupUpdateList.add( supplyOrderPaymentGroup);
				continue;
			}
			supplyOrderPaymentGroupCreateList.add(supplyOrderPaymentGroup);
		}
		
		return new Object[]{supplyOrderPaymentGroupCreateList,supplyOrderPaymentGroupUpdateList};
	}
	
	protected boolean isUpdateRequest(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		return supplyOrderPaymentGroup.getVersion() > 0;
 	}
 	protected String getSaveSupplyOrderPaymentGroupSQL(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		if(isUpdateRequest(supplyOrderPaymentGroup)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSupplyOrderPaymentGroupParameters(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		if(isUpdateRequest(supplyOrderPaymentGroup) ){
 			return prepareSupplyOrderPaymentGroupUpdateParameters(supplyOrderPaymentGroup);
 		}
 		return prepareSupplyOrderPaymentGroupCreateParameters(supplyOrderPaymentGroup);
 	}
 	protected Object[] prepareSupplyOrderPaymentGroupUpdateParameters(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = supplyOrderPaymentGroup.getName(); 	
 		if(supplyOrderPaymentGroup.getBizOrder() != null){
 			parameters[1] = supplyOrderPaymentGroup.getBizOrder().getId();
 		}
 
 		parameters[2] = supplyOrderPaymentGroup.getCardNumber();		
 		parameters[3] = supplyOrderPaymentGroup.getId();
 		parameters[4] = supplyOrderPaymentGroup.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSupplyOrderPaymentGroupCreateParameters(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		Object[] parameters = new Object[4];
		String newSupplyOrderPaymentGroupId=getNextId();
		supplyOrderPaymentGroup.setId(newSupplyOrderPaymentGroupId);
		parameters[0] =  supplyOrderPaymentGroup.getId();
 
 		parameters[1] = supplyOrderPaymentGroup.getName(); 	
 		if(supplyOrderPaymentGroup.getBizOrder() != null){
 			parameters[2] = supplyOrderPaymentGroup.getBizOrder().getId();
 		
 		}
 		
 		parameters[3] = supplyOrderPaymentGroup.getCardNumber();		
 				
 		return parameters;
 	}
 	
	protected SupplyOrderPaymentGroup saveInternalSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options){
		
		saveSupplyOrderPaymentGroup(supplyOrderPaymentGroup);
 	
 		if(isSaveBizOrderEnabled(options)){
	 		saveBizOrder(supplyOrderPaymentGroup, options);
 		}
 
		
		return supplyOrderPaymentGroup;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SupplyOrderPaymentGroup saveBizOrder(SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(supplyOrderPaymentGroup.getBizOrder() == null){
 			return supplyOrderPaymentGroup;//do nothing when it is null
 		}
 		
 		getSupplyOrderDAO().save(supplyOrderPaymentGroup.getBizOrder(),options);
 		return supplyOrderPaymentGroup;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public SupplyOrderPaymentGroup present(SupplyOrderPaymentGroup supplyOrderPaymentGroup,Map<String, Object> options){
	

		return supplyOrderPaymentGroup;
	
	}
		


	protected String getTableName(){
		return SupplyOrderPaymentGroupTable.TABLE_NAME;
	}
}


