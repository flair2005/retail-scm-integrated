
package com.skynet.retailscm.memberwishlist;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProduct;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProductDAO;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProductTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class MemberWishlistJDBCTemplateDAO extends CommonJDBCTemplateDAO implements MemberWishlistDAO{
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

		
	
  	private  MemberWishlistProductDAO  memberWishlistProductDAO;
 	public void setMemberWishlistProductDAO(MemberWishlistProductDAO pMemberWishlistProductDAO){
 	
 		if(pMemberWishlistProductDAO == null){
 			throw new IllegalStateException("Do not try to set memberWishlistProductDAO to null.");
 		}
	 	this.memberWishlistProductDAO = pMemberWishlistProductDAO;
 	}
 	public MemberWishlistProductDAO getMemberWishlistProductDAO(){
 		if(this.memberWishlistProductDAO == null){
 			throw new IllegalStateException("The memberWishlistProductDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.memberWishlistProductDAO;
 	}	
 	
			
		

	
	/*
	protected MemberWishlist load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMemberWishlist(accessKey, options);
	}
	*/
	public MemberWishlist load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMemberWishlist(MemberWishlistTable.withId(id), options);
	}
	
	
	
	public MemberWishlist save(MemberWishlist memberWishlist,Map<String,Object> options){
		
		String methodName="save(MemberWishlist memberWishlist,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(memberWishlist, methodName, "memberWishlist");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMemberWishlist(memberWishlist,options);
	}
	public MemberWishlist clone(String memberWishlistId, Map<String,Object> options) throws Exception{
	
		return clone(MemberWishlistTable.withId(memberWishlistId),options);
	}
	
	protected MemberWishlist clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String memberWishlistId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		MemberWishlist newMemberWishlist = loadInternalMemberWishlist(accessKey, options);
		newMemberWishlist.setVersion(0);
		
		
 		
 		if(isSaveMemberWishlistProductListEnabled(options)){
 			for(MemberWishlistProduct item: newMemberWishlist.getMemberWishlistProductList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalMemberWishlist(newMemberWishlist,options);
		
		return newMemberWishlist;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String memberWishlistId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{memberWishlistId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new MemberWishlistVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MemberWishlistNotFoundException(
					"The " + this.getTableName() + "(" + memberWishlistId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String memberWishlistId, int version) throws Exception{
	
		String methodName="delete(String memberWishlistId, int version)";
		assertMethodArgumentNotNull(memberWishlistId, methodName, "memberWishlistId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{memberWishlistId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(memberWishlistId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","owner"};
		return MemberWishlistTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "member_wishlist";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MemberWishlistTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MemberWishlistTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MemberWishlistTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String MEMBER_WISHLIST_PRODUCT_LIST = "memberWishlistProductList";
	
	protected boolean isExtractMemberWishlistProductListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,MemberWishlistTokens.MEMBER_WISHLIST_PRODUCT_LIST);
		
 	}

	protected boolean isSaveMemberWishlistProductListEnabled(Map<String,Object> options){
		return checkOptions(options, MemberWishlistTokens.MEMBER_WISHLIST_PRODUCT_LIST);
		
 	}
 	
 	
			
		

	

	protected MemberWishlistMapper getMemberWishlistMapper(){
		return new MemberWishlistMapper();
	}
	protected MemberWishlist extractMemberWishlist(String memberWishlistId) throws Exception{
		String SQL = "select * from member_wishlist_data where id = ?";	
		try{
		
			MemberWishlist memberWishlist = queryForObject(SQL, new Object[]{memberWishlistId}, getMemberWishlistMapper());
			return memberWishlist;
		}catch(EmptyResultDataAccessException e){
			throw new MemberWishlistNotFoundException("MemberWishlist("+memberWishlistId+") is not found!");
		}
		
		
	}
	protected MemberWishlist extractMemberWishlist(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from member_wishlist_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			MemberWishlist memberWishlist = queryForObject(SQL, new Object[]{accessKey.getValue()}, getMemberWishlistMapper());
			return memberWishlist;
		}catch(EmptyResultDataAccessException e){
			throw new MemberWishlistNotFoundException("MemberWishlist("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected MemberWishlist loadInternalMemberWishlist(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		MemberWishlist memberWishlist = extractMemberWishlist(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(memberWishlist, loadOptions);
 		}
 
		
		if(isExtractMemberWishlistProductListEnabled(loadOptions)){
	 		extractMemberWishlistProductList(memberWishlist, loadOptions);
 		}		
		
		return memberWishlist;
		
	}



	
	
	 

 	protected MemberWishlist extractOwner(MemberWishlist memberWishlist, Map<String,Object> options) throws Exception{

		if(memberWishlist.getOwner() == null){
			return memberWishlist;
		}
		String ownerId = memberWishlist.getOwner().getId();
		if( ownerId == null){
			return memberWishlist;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			memberWishlist.setOwner(owner);
		}
		
 		
 		return memberWishlist;
 	}
 		
 
		
	protected MemberWishlist extractMemberWishlistProductList(MemberWishlist memberWishlist, Map<String,Object> options){
		
		SmartList<MemberWishlistProduct> memberWishlistProductList = getMemberWishlistProductDAO().findMemberWishlistProductByOwner(memberWishlist.getId(),options);
		if(memberWishlistProductList != null){
			memberWishlist.setMemberWishlistProductList(memberWishlistProductList);
		}
		
		return memberWishlist;
	
	}	
		
		
  	
 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<MemberWishlist> memberWishlistList = queryForList(SQL, new Object[]{retailStoreMemberId}, getMemberWishlistMapper());	
 		return memberWishlistList;
 	}
 	
 	public SmartList<MemberWishlist> findMemberWishlistByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<MemberWishlist> memberWishlistList = queryForList(SQL, new Object[]{retailStoreMemberId,start, count}, getMemberWishlistMapper());
		
 		return memberWishlistList;
 	}
 	
 	public int countMemberWishlistByOwner(String retailStoreMemberId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected MemberWishlist saveMemberWishlist(MemberWishlist  memberWishlist){
	
		String SQL=this.getSaveMemberWishlistSQL(memberWishlist);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMemberWishlistParameters(memberWishlist);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		memberWishlist.incVersion();
		return memberWishlist;
	
	}
	public SmartList<MemberWishlist> saveMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMemberWishlistList(memberWishlistList);
		
		batchMemberWishlistCreate((List<MemberWishlist>)lists[CREATE_LIST_INDEX]);
		
		batchMemberWishlistUpdate((List<MemberWishlist>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(MemberWishlist memberWishlist:memberWishlistList){
			if(memberWishlist.isChanged()){
				memberWishlist.incVersion();
			}
			
		
		}
		
		
		return memberWishlistList;
	}

	public SmartList<MemberWishlist> removeMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options){
		
		
		super.removeList(memberWishlistList, options);
		
		return memberWishlistList;
		
		
	}
	
	protected List<Object[]> prepareMemberWishlistBatchCreateArgs(List<MemberWishlist> memberWishlistList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberWishlist memberWishlist:memberWishlistList ){
			Object [] parameters = prepareMemberWishlistCreateParameters(memberWishlist);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMemberWishlistBatchUpdateArgs(List<MemberWishlist> memberWishlistList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberWishlist memberWishlist:memberWishlistList ){
			if(!memberWishlist.isChanged()){
				continue;
			}
			Object [] parameters = prepareMemberWishlistUpdateParameters(memberWishlist);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMemberWishlistCreate(List<MemberWishlist> memberWishlistList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMemberWishlistBatchCreateArgs(memberWishlistList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMemberWishlistUpdate(List<MemberWishlist> memberWishlistList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMemberWishlistBatchUpdateArgs(memberWishlistList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMemberWishlistList(List<MemberWishlist> memberWishlistList){
		
		List<MemberWishlist> memberWishlistCreateList=new ArrayList<MemberWishlist>();
		List<MemberWishlist> memberWishlistUpdateList=new ArrayList<MemberWishlist>();
		
		for(MemberWishlist memberWishlist: memberWishlistList){
			if(isUpdateRequest(memberWishlist)){
				memberWishlistUpdateList.add( memberWishlist);
				continue;
			}
			memberWishlistCreateList.add(memberWishlist);
		}
		
		return new Object[]{memberWishlistCreateList,memberWishlistUpdateList};
	}
	
	protected boolean isUpdateRequest(MemberWishlist memberWishlist){
 		return memberWishlist.getVersion() > 0;
 	}
 	protected String getSaveMemberWishlistSQL(MemberWishlist memberWishlist){
 		if(isUpdateRequest(memberWishlist)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMemberWishlistParameters(MemberWishlist memberWishlist){
 		if(isUpdateRequest(memberWishlist) ){
 			return prepareMemberWishlistUpdateParameters(memberWishlist);
 		}
 		return prepareMemberWishlistCreateParameters(memberWishlist);
 	}
 	protected Object[] prepareMemberWishlistUpdateParameters(MemberWishlist memberWishlist){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = memberWishlist.getName(); 	
 		if(memberWishlist.getOwner() != null){
 			parameters[1] = memberWishlist.getOwner().getId();
 		}
 		
 		parameters[2] = memberWishlist.getId();
 		parameters[3] = memberWishlist.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMemberWishlistCreateParameters(MemberWishlist memberWishlist){
		Object[] parameters = new Object[3];
		String newMemberWishlistId=getNextId();
		memberWishlist.setId(newMemberWishlistId);
		parameters[0] =  memberWishlist.getId();
 
 		parameters[1] = memberWishlist.getName(); 	
 		if(memberWishlist.getOwner() != null){
 			parameters[2] = memberWishlist.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected MemberWishlist saveInternalMemberWishlist(MemberWishlist memberWishlist, Map<String,Object> options){
		
		saveMemberWishlist(memberWishlist);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(memberWishlist, options);
 		}
 
		
		if(isSaveMemberWishlistProductListEnabled(options)){
	 		saveMemberWishlistProductList(memberWishlist, options);
	 		removeMemberWishlistProductList(memberWishlist, options);
	 		
 		}		
		
		return memberWishlist;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected MemberWishlist saveOwner(MemberWishlist memberWishlist, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(memberWishlist.getOwner() == null){
 			return memberWishlist;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(memberWishlist.getOwner(),options);
 		return memberWishlist;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected MemberWishlist saveMemberWishlistProductList(MemberWishlist memberWishlist, Map<String,Object> options){
		SmartList<MemberWishlistProduct> memberWishlistProductList = memberWishlist.getMemberWishlistProductList();
		if(memberWishlistProductList == null){
			return memberWishlist;
		}
		if(memberWishlistProductList.isEmpty()){
			return memberWishlist;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getMemberWishlistProductDAO().saveMemberWishlistProductList(memberWishlistProductList,options);
		
		return memberWishlist;
	
	}
	
	protected MemberWishlist removeMemberWishlistProductList(MemberWishlist memberWishlist, Map<String,Object> options){
	
	
		SmartList<MemberWishlistProduct> memberWishlistProductList = memberWishlist.getMemberWishlistProductList();
		if(memberWishlistProductList == null){
			return memberWishlist;
		}	
	
		SmartList<MemberWishlistProduct> toRemoveMemberWishlistProductList = memberWishlistProductList.getToRemoveList();
		
		if(toRemoveMemberWishlistProductList == null){
			return memberWishlist;
		}
		if(toRemoveMemberWishlistProductList.isEmpty()){
			return memberWishlist;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getMemberWishlistProductDAO().removeMemberWishlistProductList(toRemoveMemberWishlistProductList,options);
		
		return memberWishlist;
	
	}
	
	
	
 	
 	
	
	
	
		

	public MemberWishlist present(MemberWishlist memberWishlist,Map<String, Object> options){
	
		presentMemberWishlistProductList(memberWishlist,options);

		return memberWishlist;
	
	}
		
	
  	
 	protected MemberWishlist presentMemberWishlistProductList(
			MemberWishlist memberWishlist,
			Map<String, Object> options) {

		SmartList<MemberWishlistProduct> memberWishlistProductList = memberWishlist.getMemberWishlistProductList();		
		if(memberWishlistProductList == null){
			return memberWishlist;			
		}
		
		String targetObjectName = "memberWishlistProduct";
		int memberWishlistProductListSize = memberWishlistProductList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(memberWishlistProductListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return memberWishlist;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = memberWishlistProductListSize;
		if(memberWishlistProductListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getMemberWishlistProductDAO().countMemberWishlistProductByOwner(memberWishlist.getId(), options);			
		}
		//memberWishlist.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//memberWishlist.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(memberWishlistProductListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(memberWishlistProductListSize,currentPage,rowsPerPage) ;
			memberWishlistProductList = memberWishlistProductList.subListOf(fromIndex, toIndex);
			memberWishlistProductList.setTotalCount(count);
			memberWishlistProductList.setCurrentPageNumber(currentPage);			
			memberWishlist.setMemberWishlistProductList(memberWishlistProductList);
			return memberWishlist;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		memberWishlistProductList 
			= getMemberWishlistProductDAO().findMemberWishlistProductByOwner(memberWishlist.getId(),start, rowsPerPage, options );
		memberWishlistProductList.setTotalCount(count);
		memberWishlistProductList.setCurrentPageNumber(currentPage);
		memberWishlist.setMemberWishlistProductList(memberWishlistProductList );	

		return memberWishlist;
	}			
		


	protected String getTableName(){
		return MemberWishlistTable.TABLE_NAME;
	}
}


