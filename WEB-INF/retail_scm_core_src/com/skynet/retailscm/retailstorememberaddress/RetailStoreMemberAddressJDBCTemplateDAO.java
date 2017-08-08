
package com.skynet.retailscm.retailstorememberaddress;

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

public class RetailStoreMemberAddressJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreMemberAddressDAO{
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

		

	
	/*
	protected RetailStoreMemberAddress load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberAddress(accessKey, options);
	}
	*/
	public RetailStoreMemberAddress load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberAddress(RetailStoreMemberAddressTable.withId(id), options);
	}
	
	
	
	public RetailStoreMemberAddress save(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options){
		
		String methodName="save(RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreMemberAddress, methodName, "retailStoreMemberAddress");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreMemberAddress(retailStoreMemberAddress,options);
	}
	public RetailStoreMemberAddress clone(String retailStoreMemberAddressId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreMemberAddressTable.withId(retailStoreMemberAddressId),options);
	}
	
	protected RetailStoreMemberAddress clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreMemberAddressId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreMemberAddress newRetailStoreMemberAddress = loadInternalRetailStoreMemberAddress(accessKey, options);
		newRetailStoreMemberAddress.setVersion(0);
		
		

		
		saveInternalRetailStoreMemberAddress(newRetailStoreMemberAddress,options);
		
		return newRetailStoreMemberAddress;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreMemberAddressId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreMemberAddressId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreMemberAddressVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberAddressNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberAddressId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreMemberAddressId, int version) throws Exception{
	
		String methodName="delete(String retailStoreMemberAddressId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberAddressId, methodName, "retailStoreMemberAddressId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberAddressId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberAddressId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","owner","mobile_phone","address"};
		return RetailStoreMemberAddressTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_member_address";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreMemberAddressTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberAddressTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberAddressTokens.OWNER);
 	}
 	

 	
 
		

	

	protected RetailStoreMemberAddressMapper getRetailStoreMemberAddressMapper(){
		return new RetailStoreMemberAddressMapper();
	}
	protected RetailStoreMemberAddress extractRetailStoreMemberAddress(String retailStoreMemberAddressId) throws Exception{
		String SQL = "select * from retail_store_member_address_data where id = ?";	
		try{
		
			RetailStoreMemberAddress retailStoreMemberAddress = queryForObject(SQL, new Object[]{retailStoreMemberAddressId}, getRetailStoreMemberAddressMapper());
			return retailStoreMemberAddress;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberAddressNotFoundException("RetailStoreMemberAddress("+retailStoreMemberAddressId+") is not found!");
		}
		
		
	}
	protected RetailStoreMemberAddress extractRetailStoreMemberAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_member_address_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreMemberAddress retailStoreMemberAddress = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreMemberAddressMapper());
			return retailStoreMemberAddress;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberAddressNotFoundException("RetailStoreMemberAddress("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreMemberAddress loadInternalRetailStoreMemberAddress(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreMemberAddress retailStoreMemberAddress = extractRetailStoreMemberAddress(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMemberAddress, loadOptions);
 		}
 
		
		return retailStoreMemberAddress;
		
	}



	
	
	 

 	protected RetailStoreMemberAddress extractOwner(RetailStoreMemberAddress retailStoreMemberAddress, Map<String,Object> options) throws Exception{

		if(retailStoreMemberAddress.getOwner() == null){
			return retailStoreMemberAddress;
		}
		String ownerId = retailStoreMemberAddress.getOwner().getId();
		if( ownerId == null){
			return retailStoreMemberAddress;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMemberAddress.setOwner(owner);
		}
		
 		
 		return retailStoreMemberAddress;
 	}
 		
 
		
		
  	
 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = queryForList(SQL, new Object[]{retailStoreMemberId}, getRetailStoreMemberAddressMapper());	
 		return retailStoreMemberAddressList;
 	}
 	
 	public SmartList<RetailStoreMemberAddress> findRetailStoreMemberAddressByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = queryForList(SQL, new Object[]{retailStoreMemberId,start, count}, getRetailStoreMemberAddressMapper());
		
 		return retailStoreMemberAddressList;
 	}
 	
 	public int countRetailStoreMemberAddressByOwner(String retailStoreMemberId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreMemberAddress saveRetailStoreMemberAddress(RetailStoreMemberAddress  retailStoreMemberAddress){
	
		String SQL=this.getSaveRetailStoreMemberAddressSQL(retailStoreMemberAddress);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberAddressParameters(retailStoreMemberAddress);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreMemberAddress.incVersion();
		return retailStoreMemberAddress;
	
	}
	public SmartList<RetailStoreMemberAddress> saveRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberAddressList(retailStoreMemberAddressList);
		
		batchRetailStoreMemberAddressCreate((List<RetailStoreMemberAddress>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreMemberAddressUpdate((List<RetailStoreMemberAddress>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList){
			if(retailStoreMemberAddress.isChanged()){
				retailStoreMemberAddress.incVersion();
			}
			
		
		}
		
		
		return retailStoreMemberAddressList;
	}

	public SmartList<RetailStoreMemberAddress> removeRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options){
		
		
		super.removeList(retailStoreMemberAddressList, options);
		
		return retailStoreMemberAddressList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreMemberAddressBatchCreateArgs(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList ){
			Object [] parameters = prepareRetailStoreMemberAddressCreateParameters(retailStoreMemberAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreMemberAddressBatchUpdateArgs(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList ){
			if(!retailStoreMemberAddress.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberAddressUpdateParameters(retailStoreMemberAddress);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreMemberAddressCreate(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberAddressBatchCreateArgs(retailStoreMemberAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreMemberAddressUpdate(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberAddressBatchUpdateArgs(retailStoreMemberAddressList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreMemberAddressList(List<RetailStoreMemberAddress> retailStoreMemberAddressList){
		
		List<RetailStoreMemberAddress> retailStoreMemberAddressCreateList=new ArrayList<RetailStoreMemberAddress>();
		List<RetailStoreMemberAddress> retailStoreMemberAddressUpdateList=new ArrayList<RetailStoreMemberAddress>();
		
		for(RetailStoreMemberAddress retailStoreMemberAddress: retailStoreMemberAddressList){
			if(isUpdateRequest(retailStoreMemberAddress)){
				retailStoreMemberAddressUpdateList.add( retailStoreMemberAddress);
				continue;
			}
			retailStoreMemberAddressCreateList.add(retailStoreMemberAddress);
		}
		
		return new Object[]{retailStoreMemberAddressCreateList,retailStoreMemberAddressUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreMemberAddress retailStoreMemberAddress){
 		return retailStoreMemberAddress.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberAddressSQL(RetailStoreMemberAddress retailStoreMemberAddress){
 		if(isUpdateRequest(retailStoreMemberAddress)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreMemberAddressParameters(RetailStoreMemberAddress retailStoreMemberAddress){
 		if(isUpdateRequest(retailStoreMemberAddress) ){
 			return prepareRetailStoreMemberAddressUpdateParameters(retailStoreMemberAddress);
 		}
 		return prepareRetailStoreMemberAddressCreateParameters(retailStoreMemberAddress);
 	}
 	protected Object[] prepareRetailStoreMemberAddressUpdateParameters(RetailStoreMemberAddress retailStoreMemberAddress){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = retailStoreMemberAddress.getName(); 	
 		if(retailStoreMemberAddress.getOwner() != null){
 			parameters[1] = retailStoreMemberAddress.getOwner().getId();
 		}
 
 		parameters[2] = retailStoreMemberAddress.getMobilePhone();
 		parameters[3] = retailStoreMemberAddress.getAddress();		
 		parameters[4] = retailStoreMemberAddress.getId();
 		parameters[5] = retailStoreMemberAddress.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberAddressCreateParameters(RetailStoreMemberAddress retailStoreMemberAddress){
		Object[] parameters = new Object[5];
		String newRetailStoreMemberAddressId=getNextId();
		retailStoreMemberAddress.setId(newRetailStoreMemberAddressId);
		parameters[0] =  retailStoreMemberAddress.getId();
 
 		parameters[1] = retailStoreMemberAddress.getName(); 	
 		if(retailStoreMemberAddress.getOwner() != null){
 			parameters[2] = retailStoreMemberAddress.getOwner().getId();
 		
 		}
 		
 		parameters[3] = retailStoreMemberAddress.getMobilePhone();
 		parameters[4] = retailStoreMemberAddress.getAddress();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreMemberAddress saveInternalRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress, Map<String,Object> options){
		
		saveRetailStoreMemberAddress(retailStoreMemberAddress);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMemberAddress, options);
 		}
 
		
		return retailStoreMemberAddress;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreMemberAddress saveOwner(RetailStoreMemberAddress retailStoreMemberAddress, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMemberAddress.getOwner() == null){
 			return retailStoreMemberAddress;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(retailStoreMemberAddress.getOwner(),options);
 		return retailStoreMemberAddress;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public RetailStoreMemberAddress present(RetailStoreMemberAddress retailStoreMemberAddress,Map<String, Object> options){
	

		return retailStoreMemberAddress;
	
	}
		


	protected String getTableName(){
		return RetailStoreMemberAddressTable.TABLE_NAME;
	}
}


