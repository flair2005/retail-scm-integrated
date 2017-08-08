
package com.skynet.retailscm.memberwishlistproduct;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.memberwishlist.MemberWishlist;

import com.skynet.retailscm.memberwishlist.MemberWishlistDAO;

import com.skynet.retailscm.memberwishlist.MemberWishlistTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class MemberWishlistProductJDBCTemplateDAO extends CommonJDBCTemplateDAO implements MemberWishlistProductDAO{
 
 	
 	private  MemberWishlistDAO  memberWishlistDAO;
 	public void setMemberWishlistDAO(MemberWishlistDAO memberWishlistDAO){
	 	this.memberWishlistDAO = memberWishlistDAO;
 	}
 	public MemberWishlistDAO getMemberWishlistDAO(){
	 	return this.memberWishlistDAO;
 	}

		

	
	/*
	protected MemberWishlistProduct load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMemberWishlistProduct(accessKey, options);
	}
	*/
	public MemberWishlistProduct load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMemberWishlistProduct(MemberWishlistProductTable.withId(id), options);
	}
	
	
	
	public MemberWishlistProduct save(MemberWishlistProduct memberWishlistProduct,Map<String,Object> options){
		
		String methodName="save(MemberWishlistProduct memberWishlistProduct,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(memberWishlistProduct, methodName, "memberWishlistProduct");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalMemberWishlistProduct(memberWishlistProduct,options);
	}
	public MemberWishlistProduct clone(String memberWishlistProductId, Map<String,Object> options) throws Exception{
	
		return clone(MemberWishlistProductTable.withId(memberWishlistProductId),options);
	}
	
	protected MemberWishlistProduct clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String memberWishlistProductId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		MemberWishlistProduct newMemberWishlistProduct = loadInternalMemberWishlistProduct(accessKey, options);
		newMemberWishlistProduct.setVersion(0);
		
		

		
		saveInternalMemberWishlistProduct(newMemberWishlistProduct,options);
		
		return newMemberWishlistProduct;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String memberWishlistProductId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{memberWishlistProductId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new MemberWishlistProductVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MemberWishlistProductNotFoundException(
					"The " + this.getTableName() + "(" + memberWishlistProductId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String memberWishlistProductId, int version) throws Exception{
	
		String methodName="delete(String memberWishlistProductId, int version)";
		assertMethodArgumentNotNull(memberWishlistProductId, methodName, "memberWishlistProductId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{memberWishlistProductId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(memberWishlistProductId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","owner"};
		return MemberWishlistProductTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "member_wishlist_product";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return MemberWishlistProductTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, MemberWishlistProductTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, MemberWishlistProductTokens.OWNER);
 	}
 	

 	
 
		

	

	protected MemberWishlistProductMapper getMemberWishlistProductMapper(){
		return new MemberWishlistProductMapper();
	}
	protected MemberWishlistProduct extractMemberWishlistProduct(String memberWishlistProductId) throws Exception{
		String SQL = "select * from member_wishlist_product_data where id = ?";	
		try{
		
			MemberWishlistProduct memberWishlistProduct = queryForObject(SQL, new Object[]{memberWishlistProductId}, getMemberWishlistProductMapper());
			return memberWishlistProduct;
		}catch(EmptyResultDataAccessException e){
			throw new MemberWishlistProductNotFoundException("MemberWishlistProduct("+memberWishlistProductId+") is not found!");
		}
		
		
	}
	protected MemberWishlistProduct extractMemberWishlistProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from member_wishlist_product_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			MemberWishlistProduct memberWishlistProduct = queryForObject(SQL, new Object[]{accessKey.getValue()}, getMemberWishlistProductMapper());
			return memberWishlistProduct;
		}catch(EmptyResultDataAccessException e){
			throw new MemberWishlistProductNotFoundException("MemberWishlistProduct("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected MemberWishlistProduct loadInternalMemberWishlistProduct(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		MemberWishlistProduct memberWishlistProduct = extractMemberWishlistProduct(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(memberWishlistProduct, loadOptions);
 		}
 
		
		return memberWishlistProduct;
		
	}



	
	
	 

 	protected MemberWishlistProduct extractOwner(MemberWishlistProduct memberWishlistProduct, Map<String,Object> options) throws Exception{

		if(memberWishlistProduct.getOwner() == null){
			return memberWishlistProduct;
		}
		String ownerId = memberWishlistProduct.getOwner().getId();
		if( ownerId == null){
			return memberWishlistProduct;
		}
		MemberWishlist owner = getMemberWishlistDAO().load(ownerId,options);
		if(owner != null){
			memberWishlistProduct.setOwner(owner);
		}
		
 		
 		return memberWishlistProduct;
 	}
 		
 
		
		
  	
 	public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(String memberWishlistId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<MemberWishlistProduct> memberWishlistProductList = queryForList(SQL, new Object[]{memberWishlistId}, getMemberWishlistProductMapper());	
 		return memberWishlistProductList;
 	}
 	
 	public SmartList<MemberWishlistProduct> findMemberWishlistProductByOwner(String memberWishlistId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<MemberWishlistProduct> memberWishlistProductList = queryForList(SQL, new Object[]{memberWishlistId,start, count}, getMemberWishlistProductMapper());
		
 		return memberWishlistProductList;
 	}
 	
 	public int countMemberWishlistProductByOwner(String memberWishlistId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{memberWishlistId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected MemberWishlistProduct saveMemberWishlistProduct(MemberWishlistProduct  memberWishlistProduct){
	
		String SQL=this.getSaveMemberWishlistProductSQL(memberWishlistProduct);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMemberWishlistProductParameters(memberWishlistProduct);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		memberWishlistProduct.incVersion();
		return memberWishlistProduct;
	
	}
	public SmartList<MemberWishlistProduct> saveMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMemberWishlistProductList(memberWishlistProductList);
		
		batchMemberWishlistProductCreate((List<MemberWishlistProduct>)lists[CREATE_LIST_INDEX]);
		
		batchMemberWishlistProductUpdate((List<MemberWishlistProduct>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(MemberWishlistProduct memberWishlistProduct:memberWishlistProductList){
			if(memberWishlistProduct.isChanged()){
				memberWishlistProduct.incVersion();
			}
			
		
		}
		
		
		return memberWishlistProductList;
	}

	public SmartList<MemberWishlistProduct> removeMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList,Map<String,Object> options){
		
		
		super.removeList(memberWishlistProductList, options);
		
		return memberWishlistProductList;
		
		
	}
	
	protected List<Object[]> prepareMemberWishlistProductBatchCreateArgs(List<MemberWishlistProduct> memberWishlistProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberWishlistProduct memberWishlistProduct:memberWishlistProductList ){
			Object [] parameters = prepareMemberWishlistProductCreateParameters(memberWishlistProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareMemberWishlistProductBatchUpdateArgs(List<MemberWishlistProduct> memberWishlistProductList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MemberWishlistProduct memberWishlistProduct:memberWishlistProductList ){
			if(!memberWishlistProduct.isChanged()){
				continue;
			}
			Object [] parameters = prepareMemberWishlistProductUpdateParameters(memberWishlistProduct);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchMemberWishlistProductCreate(List<MemberWishlistProduct> memberWishlistProductList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMemberWishlistProductBatchCreateArgs(memberWishlistProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchMemberWishlistProductUpdate(List<MemberWishlistProduct> memberWishlistProductList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMemberWishlistProductBatchUpdateArgs(memberWishlistProductList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitMemberWishlistProductList(List<MemberWishlistProduct> memberWishlistProductList){
		
		List<MemberWishlistProduct> memberWishlistProductCreateList=new ArrayList<MemberWishlistProduct>();
		List<MemberWishlistProduct> memberWishlistProductUpdateList=new ArrayList<MemberWishlistProduct>();
		
		for(MemberWishlistProduct memberWishlistProduct: memberWishlistProductList){
			if(isUpdateRequest(memberWishlistProduct)){
				memberWishlistProductUpdateList.add( memberWishlistProduct);
				continue;
			}
			memberWishlistProductCreateList.add(memberWishlistProduct);
		}
		
		return new Object[]{memberWishlistProductCreateList,memberWishlistProductUpdateList};
	}
	
	protected boolean isUpdateRequest(MemberWishlistProduct memberWishlistProduct){
 		return memberWishlistProduct.getVersion() > 0;
 	}
 	protected String getSaveMemberWishlistProductSQL(MemberWishlistProduct memberWishlistProduct){
 		if(isUpdateRequest(memberWishlistProduct)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveMemberWishlistProductParameters(MemberWishlistProduct memberWishlistProduct){
 		if(isUpdateRequest(memberWishlistProduct) ){
 			return prepareMemberWishlistProductUpdateParameters(memberWishlistProduct);
 		}
 		return prepareMemberWishlistProductCreateParameters(memberWishlistProduct);
 	}
 	protected Object[] prepareMemberWishlistProductUpdateParameters(MemberWishlistProduct memberWishlistProduct){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = memberWishlistProduct.getName(); 	
 		if(memberWishlistProduct.getOwner() != null){
 			parameters[1] = memberWishlistProduct.getOwner().getId();
 		}
 		
 		parameters[2] = memberWishlistProduct.getId();
 		parameters[3] = memberWishlistProduct.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareMemberWishlistProductCreateParameters(MemberWishlistProduct memberWishlistProduct){
		Object[] parameters = new Object[3];
		String newMemberWishlistProductId=getNextId();
		memberWishlistProduct.setId(newMemberWishlistProductId);
		parameters[0] =  memberWishlistProduct.getId();
 
 		parameters[1] = memberWishlistProduct.getName(); 	
 		if(memberWishlistProduct.getOwner() != null){
 			parameters[2] = memberWishlistProduct.getOwner().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected MemberWishlistProduct saveInternalMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct, Map<String,Object> options){
		
		saveMemberWishlistProduct(memberWishlistProduct);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(memberWishlistProduct, options);
 		}
 
		
		return memberWishlistProduct;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected MemberWishlistProduct saveOwner(MemberWishlistProduct memberWishlistProduct, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(memberWishlistProduct.getOwner() == null){
 			return memberWishlistProduct;//do nothing when it is null
 		}
 		
 		getMemberWishlistDAO().save(memberWishlistProduct.getOwner(),options);
 		return memberWishlistProduct;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public MemberWishlistProduct present(MemberWishlistProduct memberWishlistProduct,Map<String, Object> options){
	

		return memberWishlistProduct;
	
	}
		


	protected String getTableName(){
		return MemberWishlistProductTable.TABLE_NAME;
	}
}


