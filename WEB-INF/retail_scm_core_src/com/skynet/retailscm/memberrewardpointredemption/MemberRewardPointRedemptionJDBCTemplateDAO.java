
package com.skynet.retailscm.memberrewardpointredemption;

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

public class MemberRewardPointRedemptionJDBCTemplateDAO extends CommonJDBCTemplateDAO implements MemberRewardPointRedemptionDAO{
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

		

	
	/*
	protected MemberRewardPointRedemption load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMemberRewardPointRedemption(accessKey, options);
	}
	*/
	public MemberRewardPointRedemption load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMemberRewardPointRedemption(MemberRewardPointRedemptionTable.withId(id), options);
	}
	
	
	
	public MemberRewardPointRedemption save(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options){
		
		String methodName="save(MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(memberRewardPointRedemption, methodName, "memberRewardPointRedemption");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMemberRewardPointRedemption(memberRewardPointRedemption,options);
	}
	public MemberRewardPointRedemption clone(String memberRewardPointRedemptionId, Map<String,Object> options) throws Exception{
	
		return clone(MemberRewardPointRedemptionTable.withId(memberRewardPointRedemptionId),options);
	}
	
	protected MemberRewardPointRedemption clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String memberRewardPointRedemptionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		MemberRewardPointRedemption newMemberRewardPointRedemption = loadInternalMemberRewardPointRedemption(accessKey, options);
		newMemberRewardPointRedemption.setVersion(0);
		
		

		
		saveInternalMemberRewardPointRedemption(newMemberRewardPointRedemption,options);
		
		return newMemberRewardPointRedemption;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String memberRewardPointRedemptionId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{memberRewardPointRedemptionId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new MemberRewardPointRedemptionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MemberRewardPointRedemptionNotFoundException(
					"The " + this.getTableName() + "(" + memberRewardPointRedemptionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String memberRewardPointRedemptionId, int version) throws Exception{
	
		String methodName="delete(String memberRewardPointRedemptionId, int version)";
		assertMethodArgumentNotNull(memberRewardPointRedemptionId, methodName, "memberRewardPointRedemptionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{memberRewardPointRedemptionId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(memberRewardPointRedemptionId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","point","owner"};
		return MemberRewardPointRedemptionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "member_reward_point_redemption";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MemberRewardPointRedemptionTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MemberRewardPointRedemptionTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MemberRewardPointRedemptionTokens.OWNER);
 	}
 	

 	
 
		

	

	protected MemberRewardPointRedemptionMapper getMemberRewardPointRedemptionMapper(){
		return new MemberRewardPointRedemptionMapper();
	}
	protected MemberRewardPointRedemption extractMemberRewardPointRedemption(String memberRewardPointRedemptionId) throws Exception{
		String SQL = "select * from member_reward_point_redemption_data where id = ?";	
		try{
		
			MemberRewardPointRedemption memberRewardPointRedemption = queryForObject(SQL, new Object[]{memberRewardPointRedemptionId}, getMemberRewardPointRedemptionMapper());
			return memberRewardPointRedemption;
		}catch(EmptyResultDataAccessException e){
			throw new MemberRewardPointRedemptionNotFoundException("MemberRewardPointRedemption("+memberRewardPointRedemptionId+") is not found!");
		}
		
		
	}
	protected MemberRewardPointRedemption extractMemberRewardPointRedemption(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from member_reward_point_redemption_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			MemberRewardPointRedemption memberRewardPointRedemption = queryForObject(SQL, new Object[]{accessKey.getValue()}, getMemberRewardPointRedemptionMapper());
			return memberRewardPointRedemption;
		}catch(EmptyResultDataAccessException e){
			throw new MemberRewardPointRedemptionNotFoundException("MemberRewardPointRedemption("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected MemberRewardPointRedemption loadInternalMemberRewardPointRedemption(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		MemberRewardPointRedemption memberRewardPointRedemption = extractMemberRewardPointRedemption(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(memberRewardPointRedemption, loadOptions);
 		}
 
		
		return memberRewardPointRedemption;
		
	}



	
	
	 

 	protected MemberRewardPointRedemption extractOwner(MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options) throws Exception{

		if(memberRewardPointRedemption.getOwner() == null){
			return memberRewardPointRedemption;
		}
		String ownerId = memberRewardPointRedemption.getOwner().getId();
		if( ownerId == null){
			return memberRewardPointRedemption;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			memberRewardPointRedemption.setOwner(owner);
		}
		
 		
 		return memberRewardPointRedemption;
 	}
 		
 
		
		
  	
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = queryForList(SQL, new Object[]{retailStoreMemberId}, getMemberRewardPointRedemptionMapper());	
 		return memberRewardPointRedemptionList;
 	}
 	
 	public SmartList<MemberRewardPointRedemption> findMemberRewardPointRedemptionByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = queryForList(SQL, new Object[]{retailStoreMemberId,start, count}, getMemberRewardPointRedemptionMapper());
		
 		return memberRewardPointRedemptionList;
 	}
 	
 	public int countMemberRewardPointRedemptionByOwner(String retailStoreMemberId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(MemberRewardPointRedemption  memberRewardPointRedemption){
	
		String SQL=this.getSaveMemberRewardPointRedemptionSQL(memberRewardPointRedemption);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMemberRewardPointRedemptionParameters(memberRewardPointRedemption);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		memberRewardPointRedemption.incVersion();
		return memberRewardPointRedemption;
	
	}
	public SmartList<MemberRewardPointRedemption> saveMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMemberRewardPointRedemptionList(memberRewardPointRedemptionList);
		
		batchMemberRewardPointRedemptionCreate((List<MemberRewardPointRedemption>)lists[CREATE_LIST_INDEX]);
		
		batchMemberRewardPointRedemptionUpdate((List<MemberRewardPointRedemption>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList){
			if(memberRewardPointRedemption.isChanged()){
				memberRewardPointRedemption.incVersion();
			}
			
		
		}
		
		
		return memberRewardPointRedemptionList;
	}

	public SmartList<MemberRewardPointRedemption> removeMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options){
		
		
		super.removeList(memberRewardPointRedemptionList, options);
		
		return memberRewardPointRedemptionList;
		
		
	}
	
	protected List<Object[]> prepareMemberRewardPointRedemptionBatchCreateArgs(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList ){
			Object [] parameters = prepareMemberRewardPointRedemptionCreateParameters(memberRewardPointRedemption);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMemberRewardPointRedemptionBatchUpdateArgs(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList ){
			if(!memberRewardPointRedemption.isChanged()){
				continue;
			}
			Object [] parameters = prepareMemberRewardPointRedemptionUpdateParameters(memberRewardPointRedemption);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMemberRewardPointRedemptionCreate(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMemberRewardPointRedemptionBatchCreateArgs(memberRewardPointRedemptionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMemberRewardPointRedemptionUpdate(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMemberRewardPointRedemptionBatchUpdateArgs(memberRewardPointRedemptionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMemberRewardPointRedemptionList(List<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		
		List<MemberRewardPointRedemption> memberRewardPointRedemptionCreateList=new ArrayList<MemberRewardPointRedemption>();
		List<MemberRewardPointRedemption> memberRewardPointRedemptionUpdateList=new ArrayList<MemberRewardPointRedemption>();
		
		for(MemberRewardPointRedemption memberRewardPointRedemption: memberRewardPointRedemptionList){
			if(isUpdateRequest(memberRewardPointRedemption)){
				memberRewardPointRedemptionUpdateList.add( memberRewardPointRedemption);
				continue;
			}
			memberRewardPointRedemptionCreateList.add(memberRewardPointRedemption);
		}
		
		return new Object[]{memberRewardPointRedemptionCreateList,memberRewardPointRedemptionUpdateList};
	}
	
	protected boolean isUpdateRequest(MemberRewardPointRedemption memberRewardPointRedemption){
 		return memberRewardPointRedemption.getVersion() > 0;
 	}
 	protected String getSaveMemberRewardPointRedemptionSQL(MemberRewardPointRedemption memberRewardPointRedemption){
 		if(isUpdateRequest(memberRewardPointRedemption)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMemberRewardPointRedemptionParameters(MemberRewardPointRedemption memberRewardPointRedemption){
 		if(isUpdateRequest(memberRewardPointRedemption) ){
 			return prepareMemberRewardPointRedemptionUpdateParameters(memberRewardPointRedemption);
 		}
 		return prepareMemberRewardPointRedemptionCreateParameters(memberRewardPointRedemption);
 	}
 	protected Object[] prepareMemberRewardPointRedemptionUpdateParameters(MemberRewardPointRedemption memberRewardPointRedemption){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = memberRewardPointRedemption.getName();
 		parameters[1] = memberRewardPointRedemption.getPoint(); 	
 		if(memberRewardPointRedemption.getOwner() != null){
 			parameters[2] = memberRewardPointRedemption.getOwner().getId();
 		}
 		
 		parameters[3] = memberRewardPointRedemption.getId();
 		parameters[4] = memberRewardPointRedemption.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMemberRewardPointRedemptionCreateParameters(MemberRewardPointRedemption memberRewardPointRedemption){
		Object[] parameters = new Object[4];
		String newMemberRewardPointRedemptionId=getNextId();
		memberRewardPointRedemption.setId(newMemberRewardPointRedemptionId);
		parameters[0] =  memberRewardPointRedemption.getId();
 
 		parameters[1] = memberRewardPointRedemption.getName();
 		parameters[2] = memberRewardPointRedemption.getPoint(); 	
 		if(memberRewardPointRedemption.getOwner() != null){
 			parameters[3] = memberRewardPointRedemption.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected MemberRewardPointRedemption saveInternalMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options){
		
		saveMemberRewardPointRedemption(memberRewardPointRedemption);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(memberRewardPointRedemption, options);
 		}
 
		
		return memberRewardPointRedemption;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected MemberRewardPointRedemption saveOwner(MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(memberRewardPointRedemption.getOwner() == null){
 			return memberRewardPointRedemption;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(memberRewardPointRedemption.getOwner(),options);
 		return memberRewardPointRedemption;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public MemberRewardPointRedemption present(MemberRewardPointRedemption memberRewardPointRedemption,Map<String, Object> options){
	

		return memberRewardPointRedemption;
	
	}
		


	protected String getTableName(){
		return MemberRewardPointRedemptionTable.TABLE_NAME;
	}
}


