
package com.skynet.retailscm.memberrewardpoint;

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

public class MemberRewardPointJDBCTemplateDAO extends CommonJDBCTemplateDAO implements MemberRewardPointDAO{
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

		

	
	/*
	protected MemberRewardPoint load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMemberRewardPoint(accessKey, options);
	}
	*/
	public MemberRewardPoint load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMemberRewardPoint(MemberRewardPointTable.withId(id), options);
	}
	
	
	
	public MemberRewardPoint save(MemberRewardPoint memberRewardPoint,Map<String,Object> options){
		
		String methodName="save(MemberRewardPoint memberRewardPoint,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(memberRewardPoint, methodName, "memberRewardPoint");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMemberRewardPoint(memberRewardPoint,options);
	}
	public MemberRewardPoint clone(String memberRewardPointId, Map<String,Object> options) throws Exception{
	
		return clone(MemberRewardPointTable.withId(memberRewardPointId),options);
	}
	
	protected MemberRewardPoint clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String memberRewardPointId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		MemberRewardPoint newMemberRewardPoint = loadInternalMemberRewardPoint(accessKey, options);
		newMemberRewardPoint.setVersion(0);
		
		

		
		saveInternalMemberRewardPoint(newMemberRewardPoint,options);
		
		return newMemberRewardPoint;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String memberRewardPointId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{memberRewardPointId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new MemberRewardPointVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MemberRewardPointNotFoundException(
					"The " + this.getTableName() + "(" + memberRewardPointId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String memberRewardPointId, int version) throws Exception{
	
		String methodName="delete(String memberRewardPointId, int version)";
		assertMethodArgumentNotNull(memberRewardPointId, methodName, "memberRewardPointId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{memberRewardPointId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(memberRewardPointId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","point","owner"};
		return MemberRewardPointTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "member_reward_point";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MemberRewardPointTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MemberRewardPointTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MemberRewardPointTokens.OWNER);
 	}
 	

 	
 
		

	

	protected MemberRewardPointMapper getMemberRewardPointMapper(){
		return new MemberRewardPointMapper();
	}
	protected MemberRewardPoint extractMemberRewardPoint(String memberRewardPointId) throws Exception{
		String SQL = "select * from member_reward_point_data where id = ?";	
		try{
		
			MemberRewardPoint memberRewardPoint = queryForObject(SQL, new Object[]{memberRewardPointId}, getMemberRewardPointMapper());
			return memberRewardPoint;
		}catch(EmptyResultDataAccessException e){
			throw new MemberRewardPointNotFoundException("MemberRewardPoint("+memberRewardPointId+") is not found!");
		}
		
		
	}
	protected MemberRewardPoint extractMemberRewardPoint(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from member_reward_point_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			MemberRewardPoint memberRewardPoint = queryForObject(SQL, new Object[]{accessKey.getValue()}, getMemberRewardPointMapper());
			return memberRewardPoint;
		}catch(EmptyResultDataAccessException e){
			throw new MemberRewardPointNotFoundException("MemberRewardPoint("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected MemberRewardPoint loadInternalMemberRewardPoint(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		MemberRewardPoint memberRewardPoint = extractMemberRewardPoint(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(memberRewardPoint, loadOptions);
 		}
 
		
		return memberRewardPoint;
		
	}



	
	
	 

 	protected MemberRewardPoint extractOwner(MemberRewardPoint memberRewardPoint, Map<String,Object> options) throws Exception{

		if(memberRewardPoint.getOwner() == null){
			return memberRewardPoint;
		}
		String ownerId = memberRewardPoint.getOwner().getId();
		if( ownerId == null){
			return memberRewardPoint;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			memberRewardPoint.setOwner(owner);
		}
		
 		
 		return memberRewardPoint;
 	}
 		
 
		
		
  	
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<MemberRewardPoint> memberRewardPointList = queryForList(SQL, new Object[]{retailStoreMemberId}, getMemberRewardPointMapper());	
 		return memberRewardPointList;
 	}
 	
 	public SmartList<MemberRewardPoint> findMemberRewardPointByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<MemberRewardPoint> memberRewardPointList = queryForList(SQL, new Object[]{retailStoreMemberId,start, count}, getMemberRewardPointMapper());
		
 		return memberRewardPointList;
 	}
 	
 	public int countMemberRewardPointByOwner(String retailStoreMemberId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected MemberRewardPoint saveMemberRewardPoint(MemberRewardPoint  memberRewardPoint){
	
		String SQL=this.getSaveMemberRewardPointSQL(memberRewardPoint);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMemberRewardPointParameters(memberRewardPoint);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		memberRewardPoint.incVersion();
		return memberRewardPoint;
	
	}
	public SmartList<MemberRewardPoint> saveMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMemberRewardPointList(memberRewardPointList);
		
		batchMemberRewardPointCreate((List<MemberRewardPoint>)lists[CREATE_LIST_INDEX]);
		
		batchMemberRewardPointUpdate((List<MemberRewardPoint>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(MemberRewardPoint memberRewardPoint:memberRewardPointList){
			if(memberRewardPoint.isChanged()){
				memberRewardPoint.incVersion();
			}
			
		
		}
		
		
		return memberRewardPointList;
	}

	public SmartList<MemberRewardPoint> removeMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options){
		
		
		super.removeList(memberRewardPointList, options);
		
		return memberRewardPointList;
		
		
	}
	
	protected List<Object[]> prepareMemberRewardPointBatchCreateArgs(List<MemberRewardPoint> memberRewardPointList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberRewardPoint memberRewardPoint:memberRewardPointList ){
			Object [] parameters = prepareMemberRewardPointCreateParameters(memberRewardPoint);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMemberRewardPointBatchUpdateArgs(List<MemberRewardPoint> memberRewardPointList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberRewardPoint memberRewardPoint:memberRewardPointList ){
			if(!memberRewardPoint.isChanged()){
				continue;
			}
			Object [] parameters = prepareMemberRewardPointUpdateParameters(memberRewardPoint);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMemberRewardPointCreate(List<MemberRewardPoint> memberRewardPointList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMemberRewardPointBatchCreateArgs(memberRewardPointList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMemberRewardPointUpdate(List<MemberRewardPoint> memberRewardPointList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMemberRewardPointBatchUpdateArgs(memberRewardPointList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMemberRewardPointList(List<MemberRewardPoint> memberRewardPointList){
		
		List<MemberRewardPoint> memberRewardPointCreateList=new ArrayList<MemberRewardPoint>();
		List<MemberRewardPoint> memberRewardPointUpdateList=new ArrayList<MemberRewardPoint>();
		
		for(MemberRewardPoint memberRewardPoint: memberRewardPointList){
			if(isUpdateRequest(memberRewardPoint)){
				memberRewardPointUpdateList.add( memberRewardPoint);
				continue;
			}
			memberRewardPointCreateList.add(memberRewardPoint);
		}
		
		return new Object[]{memberRewardPointCreateList,memberRewardPointUpdateList};
	}
	
	protected boolean isUpdateRequest(MemberRewardPoint memberRewardPoint){
 		return memberRewardPoint.getVersion() > 0;
 	}
 	protected String getSaveMemberRewardPointSQL(MemberRewardPoint memberRewardPoint){
 		if(isUpdateRequest(memberRewardPoint)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMemberRewardPointParameters(MemberRewardPoint memberRewardPoint){
 		if(isUpdateRequest(memberRewardPoint) ){
 			return prepareMemberRewardPointUpdateParameters(memberRewardPoint);
 		}
 		return prepareMemberRewardPointCreateParameters(memberRewardPoint);
 	}
 	protected Object[] prepareMemberRewardPointUpdateParameters(MemberRewardPoint memberRewardPoint){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = memberRewardPoint.getName();
 		parameters[1] = memberRewardPoint.getPoint(); 	
 		if(memberRewardPoint.getOwner() != null){
 			parameters[2] = memberRewardPoint.getOwner().getId();
 		}
 		
 		parameters[3] = memberRewardPoint.getId();
 		parameters[4] = memberRewardPoint.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMemberRewardPointCreateParameters(MemberRewardPoint memberRewardPoint){
		Object[] parameters = new Object[4];
		String newMemberRewardPointId=getNextId();
		memberRewardPoint.setId(newMemberRewardPointId);
		parameters[0] =  memberRewardPoint.getId();
 
 		parameters[1] = memberRewardPoint.getName();
 		parameters[2] = memberRewardPoint.getPoint(); 	
 		if(memberRewardPoint.getOwner() != null){
 			parameters[3] = memberRewardPoint.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected MemberRewardPoint saveInternalMemberRewardPoint(MemberRewardPoint memberRewardPoint, Map<String,Object> options){
		
		saveMemberRewardPoint(memberRewardPoint);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(memberRewardPoint, options);
 		}
 
		
		return memberRewardPoint;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected MemberRewardPoint saveOwner(MemberRewardPoint memberRewardPoint, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(memberRewardPoint.getOwner() == null){
 			return memberRewardPoint;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(memberRewardPoint.getOwner(),options);
 		return memberRewardPoint;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public MemberRewardPoint present(MemberRewardPoint memberRewardPoint,Map<String, Object> options){
	

		return memberRewardPoint;
	
	}
		


	protected String getTableName(){
		return MemberRewardPointTable.TABLE_NAME;
	}
}


