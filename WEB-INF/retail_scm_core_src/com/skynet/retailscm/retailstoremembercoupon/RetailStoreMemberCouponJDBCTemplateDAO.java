
package com.skynet.retailscm.retailstoremembercoupon;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreMemberCouponJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreMemberCouponDAO{
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

		

	
	/*
	protected RetailStoreMemberCoupon load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberCoupon(accessKey, options);
	}
	*/
	public RetailStoreMemberCoupon load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberCoupon(RetailStoreMemberCouponTable.withId(id), options);
	}
	
	
	
	public RetailStoreMemberCoupon save(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options){
		
		String methodName="save(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreMemberCoupon, methodName, "retailStoreMemberCoupon");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreMemberCoupon(retailStoreMemberCoupon,options);
	}
	public RetailStoreMemberCoupon clone(String retailStoreMemberCouponId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreMemberCouponTable.withId(retailStoreMemberCouponId),options);
	}
	
	protected RetailStoreMemberCoupon clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreMemberCouponId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreMemberCoupon newRetailStoreMemberCoupon = loadInternalRetailStoreMemberCoupon(accessKey, options);
		newRetailStoreMemberCoupon.setVersion(0);
		
		

		
		saveInternalRetailStoreMemberCoupon(newRetailStoreMemberCoupon,options);
		
		return newRetailStoreMemberCoupon;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreMemberCouponId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreMemberCouponId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreMemberCouponVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberCouponNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberCouponId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreMemberCouponId, int version) throws Exception{
	
		String methodName="delete(String retailStoreMemberCouponId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberCouponId, methodName, "retailStoreMemberCouponId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberCouponId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberCouponId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","owner","number"};
		return RetailStoreMemberCouponTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_member_coupon";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreMemberCouponTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberCouponTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberCouponTokens.OWNER);
 	}
 	

 	
 
		

	

	protected RetailStoreMemberCouponMapper getRetailStoreMemberCouponMapper(){
		return new RetailStoreMemberCouponMapper();
	}
	protected RetailStoreMemberCoupon extractRetailStoreMemberCoupon(String retailStoreMemberCouponId) throws Exception{
		String SQL = "select * from retail_store_member_coupon_data where id = ?";	
		try{
		
			RetailStoreMemberCoupon retailStoreMemberCoupon = queryForObject(SQL, new Object[]{retailStoreMemberCouponId}, getRetailStoreMemberCouponMapper());
			return retailStoreMemberCoupon;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberCouponNotFoundException("RetailStoreMemberCoupon("+retailStoreMemberCouponId+") is not found!");
		}
		
		
	}
	protected RetailStoreMemberCoupon extractRetailStoreMemberCoupon(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_member_coupon_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreMemberCoupon retailStoreMemberCoupon = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreMemberCouponMapper());
			return retailStoreMemberCoupon;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberCouponNotFoundException("RetailStoreMemberCoupon("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreMemberCoupon loadInternalRetailStoreMemberCoupon(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreMemberCoupon retailStoreMemberCoupon = extractRetailStoreMemberCoupon(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMemberCoupon, loadOptions);
 		}
 
		
		return retailStoreMemberCoupon;
		
	}



	
	
	 

 	protected RetailStoreMemberCoupon extractOwner(RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options) throws Exception{

		if(retailStoreMemberCoupon.getOwner() == null){
			return retailStoreMemberCoupon;
		}
		String ownerId = retailStoreMemberCoupon.getOwner().getId();
		if( ownerId == null){
			return retailStoreMemberCoupon;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMemberCoupon.setOwner(owner);
		}
		
 		
 		return retailStoreMemberCoupon;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = queryForList(SQL, new Object[]{retailStoreMemberId}, getRetailStoreMemberCouponMapper());	
 		return retailStoreMemberCouponList;
 	}
 	
 	public SmartList<RetailStoreMemberCoupon> findRetailStoreMemberCouponByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = queryForList(SQL, new Object[]{retailStoreMemberId,start, count}, getRetailStoreMemberCouponMapper());
		
 		return retailStoreMemberCouponList;
 	}
 	
 	public int countRetailStoreMemberCouponByOwner(String retailStoreMemberId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreMemberCoupon saveRetailStoreMemberCoupon(RetailStoreMemberCoupon  retailStoreMemberCoupon){
	
		String SQL=this.getSaveRetailStoreMemberCouponSQL(retailStoreMemberCoupon);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberCouponParameters(retailStoreMemberCoupon);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreMemberCoupon.incVersion();
		return retailStoreMemberCoupon;
	
	}
	public SmartList<RetailStoreMemberCoupon> saveRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberCouponList(retailStoreMemberCouponList);
		
		batchRetailStoreMemberCouponCreate((List<RetailStoreMemberCoupon>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreMemberCouponUpdate((List<RetailStoreMemberCoupon>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList){
			if(retailStoreMemberCoupon.isChanged()){
				retailStoreMemberCoupon.incVersion();
			}
			
		
		}
		
		
		return retailStoreMemberCouponList;
	}

	public SmartList<RetailStoreMemberCoupon> removeRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options){
		
		
		super.removeList(retailStoreMemberCouponList, options);
		
		return retailStoreMemberCouponList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreMemberCouponBatchCreateArgs(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList ){
			Object [] parameters = prepareRetailStoreMemberCouponCreateParameters(retailStoreMemberCoupon);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreMemberCouponBatchUpdateArgs(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList ){
			if(!retailStoreMemberCoupon.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberCouponUpdateParameters(retailStoreMemberCoupon);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreMemberCouponCreate(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberCouponBatchCreateArgs(retailStoreMemberCouponList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreMemberCouponUpdate(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberCouponBatchUpdateArgs(retailStoreMemberCouponList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreMemberCouponList(List<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		
		List<RetailStoreMemberCoupon> retailStoreMemberCouponCreateList=new ArrayList<RetailStoreMemberCoupon>();
		List<RetailStoreMemberCoupon> retailStoreMemberCouponUpdateList=new ArrayList<RetailStoreMemberCoupon>();
		
		for(RetailStoreMemberCoupon retailStoreMemberCoupon: retailStoreMemberCouponList){
			if(isUpdateRequest(retailStoreMemberCoupon)){
				retailStoreMemberCouponUpdateList.add( retailStoreMemberCoupon);
				continue;
			}
			retailStoreMemberCouponCreateList.add(retailStoreMemberCoupon);
		}
		
		return new Object[]{retailStoreMemberCouponCreateList,retailStoreMemberCouponUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		return retailStoreMemberCoupon.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberCouponSQL(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		if(isUpdateRequest(retailStoreMemberCoupon)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreMemberCouponParameters(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		if(isUpdateRequest(retailStoreMemberCoupon) ){
 			return prepareRetailStoreMemberCouponUpdateParameters(retailStoreMemberCoupon);
 		}
 		return prepareRetailStoreMemberCouponCreateParameters(retailStoreMemberCoupon);
 	}
 	protected Object[] prepareRetailStoreMemberCouponUpdateParameters(RetailStoreMemberCoupon retailStoreMemberCoupon){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = retailStoreMemberCoupon.getName(); 	
 		if(retailStoreMemberCoupon.getOwner() != null){
 			parameters[1] = retailStoreMemberCoupon.getOwner().getId();
 		}
 
 		parameters[2] = retailStoreMemberCoupon.getNumber();		
 		parameters[3] = retailStoreMemberCoupon.getId();
 		parameters[4] = retailStoreMemberCoupon.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberCouponCreateParameters(RetailStoreMemberCoupon retailStoreMemberCoupon){
		Object[] parameters = new Object[4];
		String newRetailStoreMemberCouponId=getNextId();
		retailStoreMemberCoupon.setId(newRetailStoreMemberCouponId);
		parameters[0] =  retailStoreMemberCoupon.getId();
 
 		parameters[1] = retailStoreMemberCoupon.getName(); 	
 		if(retailStoreMemberCoupon.getOwner() != null){
 			parameters[2] = retailStoreMemberCoupon.getOwner().getId();
 		
 		}
 		
 		parameters[3] = retailStoreMemberCoupon.getNumber();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreMemberCoupon saveInternalRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options){
		
		saveRetailStoreMemberCoupon(retailStoreMemberCoupon);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMemberCoupon, options);
 		}
 
		
		return retailStoreMemberCoupon;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreMemberCoupon saveOwner(RetailStoreMemberCoupon retailStoreMemberCoupon, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMemberCoupon.getOwner() == null){
 			return retailStoreMemberCoupon;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(retailStoreMemberCoupon.getOwner(),options);
 		return retailStoreMemberCoupon;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public RetailStoreMemberCoupon present(RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String, Object> options){
	

		return retailStoreMemberCoupon;
	
	}
		


	protected String getTableName(){
		return RetailStoreMemberCouponTable.TABLE_NAME;
	}
}


