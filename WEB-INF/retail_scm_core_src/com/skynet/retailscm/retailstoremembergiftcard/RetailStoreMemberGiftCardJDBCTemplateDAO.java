
package com.skynet.retailscm.retailstoremembergiftcard;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;

import com.skynet.retailscm.retailstoremember.RetailStoreMemberDAO;
import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;

import com.skynet.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTable;
import com.skynet.retailscm.retailstoremember.RetailStoreMemberTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreMemberGiftCardJDBCTemplateDAO extends CommonJDBCTemplateDAO implements RetailStoreMemberGiftCardDAO{
 
 	
 	private  RetailStoreMemberDAO  retailStoreMemberDAO;
 	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
	 	return this.retailStoreMemberDAO;
 	}

		
	
  	private  RetailStoreMemberGiftCardConsumeRecordDAO  retailStoreMemberGiftCardConsumeRecordDAO;
 	public void setRetailStoreMemberGiftCardConsumeRecordDAO(RetailStoreMemberGiftCardConsumeRecordDAO pRetailStoreMemberGiftCardConsumeRecordDAO){
 	
 		if(pRetailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardConsumeRecordDAO to null.");
 		}
	 	this.retailStoreMemberGiftCardConsumeRecordDAO = pRetailStoreMemberGiftCardConsumeRecordDAO;
 	}
 	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO(){
 		if(this.retailStoreMemberGiftCardConsumeRecordDAO == null){
 			throw new IllegalStateException("The retailStoreMemberGiftCardConsumeRecordDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreMemberGiftCardConsumeRecordDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreMemberGiftCard load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberGiftCard(accessKey, options);
	}
	*/
	public RetailStoreMemberGiftCard load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMemberGiftCard(RetailStoreMemberGiftCardTable.withId(id), options);
	}
	
	
	
	public RetailStoreMemberGiftCard save(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options){
		
		String methodName="save(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreMemberGiftCard, methodName, "retailStoreMemberGiftCard");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreMemberGiftCard(retailStoreMemberGiftCard,options);
	}
	public RetailStoreMemberGiftCard clone(String retailStoreMemberGiftCardId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreMemberGiftCardTable.withId(retailStoreMemberGiftCardId),options);
	}
	
	protected RetailStoreMemberGiftCard clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreMemberGiftCardId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreMemberGiftCard newRetailStoreMemberGiftCard = loadInternalRetailStoreMemberGiftCard(accessKey, options);
		newRetailStoreMemberGiftCard.setVersion(0);
		
		
 		
 		if(isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)){
 			for(RetailStoreMemberGiftCardConsumeRecord item: newRetailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreMemberGiftCard(newRetailStoreMemberGiftCard,options);
		
		return newRetailStoreMemberGiftCard;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String retailStoreMemberGiftCardId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{retailStoreMemberGiftCardId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new RetailStoreMemberGiftCardVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberGiftCardNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberGiftCardId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String retailStoreMemberGiftCardId, int version) throws Exception{
	
		String methodName="delete(String retailStoreMemberGiftCardId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberGiftCardId, methodName, "retailStoreMemberGiftCardId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberGiftCardId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberGiftCardId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","owner","number","remain"};
		return RetailStoreMemberGiftCardTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_member_gift_card";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreMemberGiftCardTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractOwnerEnabled = true;
 	//private static final String OWNER = "owner";
 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreMemberGiftCardTokens.OWNER);
 	}
 	
 	
 	//private boolean saveOwnerEnabled = true;
 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreMemberGiftCardTokens.OWNER);
 	}
 	

 	
 
		
	//protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";
	
	protected boolean isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreMemberGiftCardTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		
 	}

	protected boolean isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberGiftCardTokens.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreMemberGiftCardMapper getRetailStoreMemberGiftCardMapper(){
		return new RetailStoreMemberGiftCardMapper();
	}
	protected RetailStoreMemberGiftCard extractRetailStoreMemberGiftCard(String retailStoreMemberGiftCardId) throws Exception{
		String SQL = "select * from retail_store_member_gift_card_data where id = ?";	
		try{
		
			RetailStoreMemberGiftCard retailStoreMemberGiftCard = queryForObject(SQL, new Object[]{retailStoreMemberGiftCardId}, getRetailStoreMemberGiftCardMapper());
			return retailStoreMemberGiftCard;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberGiftCardNotFoundException("RetailStoreMemberGiftCard("+retailStoreMemberGiftCardId+") is not found!");
		}
		
		
	}
	protected RetailStoreMemberGiftCard extractRetailStoreMemberGiftCard(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from retail_store_member_gift_card_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			RetailStoreMemberGiftCard retailStoreMemberGiftCard = queryForObject(SQL, new Object[]{accessKey.getValue()}, getRetailStoreMemberGiftCardMapper());
			return retailStoreMemberGiftCard;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberGiftCardNotFoundException("RetailStoreMemberGiftCard("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected RetailStoreMemberGiftCard loadInternalRetailStoreMemberGiftCard(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = extractRetailStoreMemberGiftCard(accessKey, loadOptions);
 	
 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMemberGiftCard, loadOptions);
 		}
 
		
		if(isExtractRetailStoreMemberGiftCardConsumeRecordListEnabled(loadOptions)){
	 		extractRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, loadOptions);
 		}		
		
		return retailStoreMemberGiftCard;
		
	}



	
	
	 

 	protected RetailStoreMemberGiftCard extractOwner(RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object> options) throws Exception{

		if(retailStoreMemberGiftCard.getOwner() == null){
			return retailStoreMemberGiftCard;
		}
		String ownerId = retailStoreMemberGiftCard.getOwner().getId();
		if( ownerId == null){
			return retailStoreMemberGiftCard;
		}
		RetailStoreMember owner = getRetailStoreMemberDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMemberGiftCard.setOwner(owner);
		}
		
 		
 		return retailStoreMemberGiftCard;
 	}
 		
 
		
	protected RetailStoreMemberGiftCard extractRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object> options){
		
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = getRetailStoreMemberGiftCardConsumeRecordDAO().findRetailStoreMemberGiftCardConsumeRecordByOwner(retailStoreMemberGiftCard.getId(),options);
		if(retailStoreMemberGiftCardConsumeRecordList != null){
			retailStoreMemberGiftCard.setRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList);
		}
		
		return retailStoreMemberGiftCard;
	
	}	
		
		
  	
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ?";
		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = queryForList(SQL, new Object[]{retailStoreMemberId}, getRetailStoreMemberGiftCardMapper());	
 		return retailStoreMemberGiftCardList;
 	}
 	
 	public SmartList<RetailStoreMemberGiftCard> findRetailStoreMemberGiftCardByOwner(String retailStoreMemberId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where owner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = queryForList(SQL, new Object[]{retailStoreMemberId,start, count}, getRetailStoreMemberGiftCardMapper());
		
 		return retailStoreMemberGiftCardList;
 	}
 	
 	public int countRetailStoreMemberGiftCardByOwner(String retailStoreMemberId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where owner = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreMemberId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCard(RetailStoreMemberGiftCard  retailStoreMemberGiftCard){
	
		String SQL=this.getSaveRetailStoreMemberGiftCardSQL(retailStoreMemberGiftCard);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberGiftCardParameters(retailStoreMemberGiftCard);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreMemberGiftCard.incVersion();
		return retailStoreMemberGiftCard;
	
	}
	public SmartList<RetailStoreMemberGiftCard> saveRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList);
		
		batchRetailStoreMemberGiftCardCreate((List<RetailStoreMemberGiftCard>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreMemberGiftCardUpdate((List<RetailStoreMemberGiftCard>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreMemberGiftCard retailStoreMemberGiftCard:retailStoreMemberGiftCardList){
			if(retailStoreMemberGiftCard.isChanged()){
				retailStoreMemberGiftCard.incVersion();
			}
			
		
		}
		
		
		return retailStoreMemberGiftCardList;
	}

	public SmartList<RetailStoreMemberGiftCard> removeRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options){
		
		
		super.removeList(retailStoreMemberGiftCardList, options);
		
		return retailStoreMemberGiftCardList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreMemberGiftCardBatchCreateArgs(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberGiftCard retailStoreMemberGiftCard:retailStoreMemberGiftCardList ){
			Object [] parameters = prepareRetailStoreMemberGiftCardCreateParameters(retailStoreMemberGiftCard);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreMemberGiftCardBatchUpdateArgs(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMemberGiftCard retailStoreMemberGiftCard:retailStoreMemberGiftCardList ){
			if(!retailStoreMemberGiftCard.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberGiftCardUpdateParameters(retailStoreMemberGiftCard);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreMemberGiftCardCreate(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberGiftCardBatchCreateArgs(retailStoreMemberGiftCardList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreMemberGiftCardUpdate(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberGiftCardBatchUpdateArgs(retailStoreMemberGiftCardList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreMemberGiftCardList(List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		
		List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardCreateList=new ArrayList<RetailStoreMemberGiftCard>();
		List<RetailStoreMemberGiftCard> retailStoreMemberGiftCardUpdateList=new ArrayList<RetailStoreMemberGiftCard>();
		
		for(RetailStoreMemberGiftCard retailStoreMemberGiftCard: retailStoreMemberGiftCardList){
			if(isUpdateRequest(retailStoreMemberGiftCard)){
				retailStoreMemberGiftCardUpdateList.add( retailStoreMemberGiftCard);
				continue;
			}
			retailStoreMemberGiftCardCreateList.add(retailStoreMemberGiftCard);
		}
		
		return new Object[]{retailStoreMemberGiftCardCreateList,retailStoreMemberGiftCardUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
 		return retailStoreMemberGiftCard.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberGiftCardSQL(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
 		if(isUpdateRequest(retailStoreMemberGiftCard)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreMemberGiftCardParameters(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
 		if(isUpdateRequest(retailStoreMemberGiftCard) ){
 			return prepareRetailStoreMemberGiftCardUpdateParameters(retailStoreMemberGiftCard);
 		}
 		return prepareRetailStoreMemberGiftCardCreateParameters(retailStoreMemberGiftCard);
 	}
 	protected Object[] prepareRetailStoreMemberGiftCardUpdateParameters(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = retailStoreMemberGiftCard.getName(); 	
 		if(retailStoreMemberGiftCard.getOwner() != null){
 			parameters[1] = retailStoreMemberGiftCard.getOwner().getId();
 		}
 
 		parameters[2] = retailStoreMemberGiftCard.getNumber();
 		parameters[3] = retailStoreMemberGiftCard.getRemain();		
 		parameters[4] = retailStoreMemberGiftCard.getId();
 		parameters[5] = retailStoreMemberGiftCard.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberGiftCardCreateParameters(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
		Object[] parameters = new Object[5];
		String newRetailStoreMemberGiftCardId=getNextId();
		retailStoreMemberGiftCard.setId(newRetailStoreMemberGiftCardId);
		parameters[0] =  retailStoreMemberGiftCard.getId();
 
 		parameters[1] = retailStoreMemberGiftCard.getName(); 	
 		if(retailStoreMemberGiftCard.getOwner() != null){
 			parameters[2] = retailStoreMemberGiftCard.getOwner().getId();
 		
 		}
 		
 		parameters[3] = retailStoreMemberGiftCard.getNumber();
 		parameters[4] = retailStoreMemberGiftCard.getRemain();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreMemberGiftCard saveInternalRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object> options){
		
		saveRetailStoreMemberGiftCard(retailStoreMemberGiftCard);
 	
 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMemberGiftCard, options);
 		}
 
		
		if(isSaveRetailStoreMemberGiftCardConsumeRecordListEnabled(options)){
	 		saveRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, options);
	 		removeRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard, options);
	 		
 		}		
		
		return retailStoreMemberGiftCard;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreMemberGiftCard saveOwner(RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreMemberGiftCard.getOwner() == null){
 			return retailStoreMemberGiftCard;//do nothing when it is null
 		}
 		
 		getRetailStoreMemberDAO().save(retailStoreMemberGiftCard.getOwner(),options);
 		return retailStoreMemberGiftCard;
 		
 	}
 	
 	
 	
 	 
	
 
		
	protected RetailStoreMemberGiftCard saveRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object> options){
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return retailStoreMemberGiftCard;
		}
		if(retailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return retailStoreMemberGiftCard;// Does this mean delete all from the parent object?
		}
		//Call DAO to save the list
		
		getRetailStoreMemberGiftCardConsumeRecordDAO().saveRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList,options);
		
		return retailStoreMemberGiftCard;
	
	}
	
	protected RetailStoreMemberGiftCard removeRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCard retailStoreMemberGiftCard, Map<String,Object> options){
	
	
		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return retailStoreMemberGiftCard;
		}	
	
		SmartList<RetailStoreMemberGiftCardConsumeRecord> toRemoveRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList.getToRemoveList();
		
		if(toRemoveRetailStoreMemberGiftCardConsumeRecordList == null){
			return retailStoreMemberGiftCard;
		}
		if(toRemoveRetailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return retailStoreMemberGiftCard;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreMemberGiftCardConsumeRecordDAO().removeRetailStoreMemberGiftCardConsumeRecordList(toRemoveRetailStoreMemberGiftCardConsumeRecordList,options);
		
		return retailStoreMemberGiftCard;
	
	}
	
	
	
 	
 	
	
	
	
		

	public RetailStoreMemberGiftCard present(RetailStoreMemberGiftCard retailStoreMemberGiftCard,Map<String, Object> options){
	
		presentRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCard,options);

		return retailStoreMemberGiftCard;
	
	}
		
	
  	
 	protected RetailStoreMemberGiftCard presentRetailStoreMemberGiftCardConsumeRecordList(
			RetailStoreMemberGiftCard retailStoreMemberGiftCard,
			Map<String, Object> options) {

		SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCard.getRetailStoreMemberGiftCardConsumeRecordList();		
		if(retailStoreMemberGiftCardConsumeRecordList == null){
			return retailStoreMemberGiftCard;			
		}
		
		String targetObjectName = "retailStoreMemberGiftCardConsumeRecord";
		int retailStoreMemberGiftCardConsumeRecordListSize = retailStoreMemberGiftCardConsumeRecordList.size();		
		int rowsPerPage = rowsPerPageOf(targetObjectName,options);
		
		if(retailStoreMemberGiftCardConsumeRecordListSize <= rowsPerPage){
			//do not need to put a pagination object to it, it just fills out a page or less than a page			
			return retailStoreMemberGiftCard;			
		}
		int currentPage = currentPageNumberOf(targetObjectName,options);		
		//page must be calculated with this step
		int count = retailStoreMemberGiftCardConsumeRecordListSize;
		if(retailStoreMemberGiftCardConsumeRecordListSize >= this.getMaxRows()){
			//fix the count because the list is not a full list
			count = getRetailStoreMemberGiftCardConsumeRecordDAO().countRetailStoreMemberGiftCardConsumeRecordByOwner(retailStoreMemberGiftCard.getId(), options);			
		}
		//retailStoreMemberGiftCard.addListSize(targetObjectName,count);
		int maxPageNumber = count/rowsPerPage +((count%rowsPerPage==0)?0:1);
		if(currentPage > maxPageNumber){
			currentPage = maxPageNumber;
		}
		//List<BaseEntity> pages = pagesOf(count,currentPage);
		//retailStoreMemberGiftCard.addPagesToFlexibleList(targetObjectName,pages );
		
		if(isCurrentPageInLoadedList(retailStoreMemberGiftCardConsumeRecordListSize, currentPage,rowsPerPage )){
			
			//get a sub list from it
			int fromIndex = (currentPage-1)*rowsPerPage;
			int toIndex = calcToIndex(retailStoreMemberGiftCardConsumeRecordListSize,currentPage,rowsPerPage) ;
			retailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList.subListOf(fromIndex, toIndex);
			retailStoreMemberGiftCardConsumeRecordList.setTotalCount(count);
			retailStoreMemberGiftCardConsumeRecordList.setCurrentPageNumber(currentPage);			
			retailStoreMemberGiftCard.setRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList);
			return retailStoreMemberGiftCard;
		}
		
		//where to get the current page?
		//load the page data from database
		int start = (currentPage-1) * rowsPerPage ;
		
		retailStoreMemberGiftCardConsumeRecordList 
			= getRetailStoreMemberGiftCardConsumeRecordDAO().findRetailStoreMemberGiftCardConsumeRecordByOwner(retailStoreMemberGiftCard.getId(),start, rowsPerPage, options );
		retailStoreMemberGiftCardConsumeRecordList.setTotalCount(count);
		retailStoreMemberGiftCardConsumeRecordList.setCurrentPageNumber(currentPage);
		retailStoreMemberGiftCard.setRetailStoreMemberGiftCardConsumeRecordList(retailStoreMemberGiftCardConsumeRecordList );	

		return retailStoreMemberGiftCard;
	}			
		


	protected String getTableName(){
		return RetailStoreMemberGiftCardTable.TABLE_NAME;
	}
}


