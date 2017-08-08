
package com.skynet.retailscm.originalvoucher;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.skynet.retailscm.accountingdocument.AccountingDocument;

import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditingDAO;
import com.skynet.retailscm.accountingdocument.AccountingDocumentDAO;
import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmationDAO;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreationDAO;

import com.skynet.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmationTable;
import com.skynet.retailscm.accountingdocument.AccountingDocumentTable;
import com.skynet.retailscm.originalvouchercreation.OriginalVoucherCreationTable;
import com.skynet.retailscm.originalvoucherauditing.OriginalVoucherAuditingTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class OriginalVoucherJDBCTemplateDAO extends CommonJDBCTemplateDAO implements OriginalVoucherDAO{
 
 	
 	private  OriginalVoucherCreationDAO  originalVoucherCreationDAO;
 	public void setOriginalVoucherCreationDAO(OriginalVoucherCreationDAO originalVoucherCreationDAO){
	 	this.originalVoucherCreationDAO = originalVoucherCreationDAO;
 	}
 	public OriginalVoucherCreationDAO getOriginalVoucherCreationDAO(){
	 	return this.originalVoucherCreationDAO;
 	}
 
 	
 	private  AccountingDocumentDAO  accountingDocumentDAO;
 	public void setAccountingDocumentDAO(AccountingDocumentDAO accountingDocumentDAO){
	 	this.accountingDocumentDAO = accountingDocumentDAO;
 	}
 	public AccountingDocumentDAO getAccountingDocumentDAO(){
	 	return this.accountingDocumentDAO;
 	}
 
 	
 	private  OriginalVoucherConfirmationDAO  originalVoucherConfirmationDAO;
 	public void setOriginalVoucherConfirmationDAO(OriginalVoucherConfirmationDAO originalVoucherConfirmationDAO){
	 	this.originalVoucherConfirmationDAO = originalVoucherConfirmationDAO;
 	}
 	public OriginalVoucherConfirmationDAO getOriginalVoucherConfirmationDAO(){
	 	return this.originalVoucherConfirmationDAO;
 	}
 
 	
 	private  OriginalVoucherAuditingDAO  originalVoucherAuditingDAO;
 	public void setOriginalVoucherAuditingDAO(OriginalVoucherAuditingDAO originalVoucherAuditingDAO){
	 	this.originalVoucherAuditingDAO = originalVoucherAuditingDAO;
 	}
 	public OriginalVoucherAuditingDAO getOriginalVoucherAuditingDAO(){
	 	return this.originalVoucherAuditingDAO;
 	}

		

	
	/*
	protected OriginalVoucher load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucher(accessKey, options);
	}
	*/
	public OriginalVoucher load(String id,Map<String,Object> options) throws Exception{
		return loadInternalOriginalVoucher(OriginalVoucherTable.withId(id), options);
	}
	
	
	
	public OriginalVoucher save(OriginalVoucher originalVoucher,Map<String,Object> options){
		
		String methodName="save(OriginalVoucher originalVoucher,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(originalVoucher, methodName, "originalVoucher");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalOriginalVoucher(originalVoucher,options);
	}
	public OriginalVoucher clone(String originalVoucherId, Map<String,Object> options) throws Exception{
	
		return clone(OriginalVoucherTable.withId(originalVoucherId),options);
	}
	
	protected OriginalVoucher clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String originalVoucherId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		OriginalVoucher newOriginalVoucher = loadInternalOriginalVoucher(accessKey, options);
		newOriginalVoucher.setVersion(0);
		
		

		
		saveInternalOriginalVoucher(newOriginalVoucher,options);
		
		return newOriginalVoucher;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String originalVoucherId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{originalVoucherId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new OriginalVoucherVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new OriginalVoucherNotFoundException(
					"The " + this.getTableName() + "(" + originalVoucherId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String originalVoucherId, int version) throws Exception{
	
		String methodName="delete(String originalVoucherId, int version)";
		assertMethodArgumentNotNull(originalVoucherId, methodName, "originalVoucherId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{originalVoucherId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(originalVoucherId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"title","made_by","received_by","voucher_type","voucher_image","belongs_to","creation","confirmation","auditing","current_status"};
		return OriginalVoucherTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "original_voucher";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return OriginalVoucherTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractBelongsToEnabled = true;
 	//private static final String BELONGSTO = "belongsTo";
 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.BELONGSTO);
 	}
 	
 	
 	//private boolean saveBelongsToEnabled = true;
 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.BELONGSTO);
 	}
 	

 	
  
 	//private boolean extractCreationEnabled = true;
 	//private static final String CREATION = "creation";
 	protected boolean isExtractCreationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.CREATION);
 	}
 	
 	
 	//private boolean saveCreationEnabled = true;
 	protected boolean isSaveCreationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.CREATION);
 	}
 	

 	
  
 	//private boolean extractConfirmationEnabled = true;
 	//private static final String CONFIRMATION = "confirmation";
 	protected boolean isExtractConfirmationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.CONFIRMATION);
 	}
 	
 	
 	//private boolean saveConfirmationEnabled = true;
 	protected boolean isSaveConfirmationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.CONFIRMATION);
 	}
 	

 	
  
 	//private boolean extractAuditingEnabled = true;
 	//private static final String AUDITING = "auditing";
 	protected boolean isExtractAuditingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, OriginalVoucherTokens.AUDITING);
 	}
 	
 	
 	//private boolean saveAuditingEnabled = true;
 	protected boolean isSaveAuditingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, OriginalVoucherTokens.AUDITING);
 	}
 	

 	
 
		

	

	protected OriginalVoucherMapper getOriginalVoucherMapper(){
		return new OriginalVoucherMapper();
	}
	protected OriginalVoucher extractOriginalVoucher(String originalVoucherId) throws Exception{
		String SQL = "select * from original_voucher_data where id = ?";	
		try{
		
			OriginalVoucher originalVoucher = queryForObject(SQL, new Object[]{originalVoucherId}, getOriginalVoucherMapper());
			return originalVoucher;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherNotFoundException("OriginalVoucher("+originalVoucherId+") is not found!");
		}
		
		
	}
	protected OriginalVoucher extractOriginalVoucher(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from original_voucher_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			OriginalVoucher originalVoucher = queryForObject(SQL, new Object[]{accessKey.getValue()}, getOriginalVoucherMapper());
			return originalVoucher;
		}catch(EmptyResultDataAccessException e){
			throw new OriginalVoucherNotFoundException("OriginalVoucher("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected OriginalVoucher loadInternalOriginalVoucher(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		OriginalVoucher originalVoucher = extractOriginalVoucher(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(originalVoucher, loadOptions);
 		}
  	
 		if(isExtractCreationEnabled(loadOptions)){
	 		extractCreation(originalVoucher, loadOptions);
 		}
  	
 		if(isExtractConfirmationEnabled(loadOptions)){
	 		extractConfirmation(originalVoucher, loadOptions);
 		}
  	
 		if(isExtractAuditingEnabled(loadOptions)){
	 		extractAuditing(originalVoucher, loadOptions);
 		}
 
		
		return originalVoucher;
		
	}



	
	
	 

 	protected OriginalVoucher extractBelongsTo(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getBelongsTo() == null){
			return originalVoucher;
		}
		String belongsToId = originalVoucher.getBelongsTo().getId();
		if( belongsToId == null){
			return originalVoucher;
		}
		AccountingDocument belongsTo = getAccountingDocumentDAO().load(belongsToId,options);
		if(belongsTo != null){
			originalVoucher.setBelongsTo(belongsTo);
		}
		
 		
 		return originalVoucher;
 	}
 		
  

 	protected OriginalVoucher extractCreation(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getCreation() == null){
			return originalVoucher;
		}
		String creationId = originalVoucher.getCreation().getId();
		if( creationId == null){
			return originalVoucher;
		}
		OriginalVoucherCreation creation = getOriginalVoucherCreationDAO().load(creationId,options);
		if(creation != null){
			originalVoucher.setCreation(creation);
		}
		
 		
 		return originalVoucher;
 	}
 		
  

 	protected OriginalVoucher extractConfirmation(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getConfirmation() == null){
			return originalVoucher;
		}
		String confirmationId = originalVoucher.getConfirmation().getId();
		if( confirmationId == null){
			return originalVoucher;
		}
		OriginalVoucherConfirmation confirmation = getOriginalVoucherConfirmationDAO().load(confirmationId,options);
		if(confirmation != null){
			originalVoucher.setConfirmation(confirmation);
		}
		
 		
 		return originalVoucher;
 	}
 		
  

 	protected OriginalVoucher extractAuditing(OriginalVoucher originalVoucher, Map<String,Object> options) throws Exception{

		if(originalVoucher.getAuditing() == null){
			return originalVoucher;
		}
		String auditingId = originalVoucher.getAuditing().getId();
		if( auditingId == null){
			return originalVoucher;
		}
		OriginalVoucherAuditing auditing = getOriginalVoucherAuditingDAO().load(auditingId,options);
		if(auditing != null){
			originalVoucher.setAuditing(auditing);
		}
		
 		
 		return originalVoucher;
 	}
 		
 
		
		
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ?";
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{accountingDocumentId}, getOriginalVoucherMapper());	
 		return originalVoucherList;
 	}
 	
 	public SmartList<OriginalVoucher> findOriginalVoucherByBelongsTo(String accountingDocumentId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where belongs_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{accountingDocumentId,start, count}, getOriginalVoucherMapper());
		
 		return originalVoucherList;
 	}
 	
 	public int countOriginalVoucherByBelongsTo(String accountingDocumentId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where belongs_to = ?";
		Integer count = queryInt(SQL, new Object[]{accountingDocumentId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where creation = ?";
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{originalVoucherCreationId}, getOriginalVoucherMapper());	
 		return originalVoucherList;
 	}
 	
 	public SmartList<OriginalVoucher> findOriginalVoucherByCreation(String originalVoucherCreationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where creation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{originalVoucherCreationId,start, count}, getOriginalVoucherMapper());
		
 		return originalVoucherList;
 	}
 	
 	public int countOriginalVoucherByCreation(String originalVoucherCreationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where creation = ?";
		Integer count = queryInt(SQL, new Object[]{originalVoucherCreationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ?";
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{originalVoucherConfirmationId}, getOriginalVoucherMapper());	
 		return originalVoucherList;
 	}
 	
 	public SmartList<OriginalVoucher> findOriginalVoucherByConfirmation(String originalVoucherConfirmationId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where confirmation = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{originalVoucherConfirmationId,start, count}, getOriginalVoucherMapper());
		
 		return originalVoucherList;
 	}
 	
 	public int countOriginalVoucherByConfirmation(String originalVoucherConfirmationId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where confirmation = ?";
		Integer count = queryInt(SQL, new Object[]{originalVoucherConfirmationId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where auditing = ?";
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{originalVoucherAuditingId}, getOriginalVoucherMapper());	
 		return originalVoucherList;
 	}
 	
 	public SmartList<OriginalVoucher> findOriginalVoucherByAuditing(String originalVoucherAuditingId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where auditing = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<OriginalVoucher> originalVoucherList = queryForList(SQL, new Object[]{originalVoucherAuditingId,start, count}, getOriginalVoucherMapper());
		
 		return originalVoucherList;
 	}
 	
 	public int countOriginalVoucherByAuditing(String originalVoucherAuditingId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where auditing = ?";
		Integer count = queryInt(SQL, new Object[]{originalVoucherAuditingId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected OriginalVoucher saveOriginalVoucher(OriginalVoucher  originalVoucher){
	
		String SQL=this.getSaveOriginalVoucherSQL(originalVoucher);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveOriginalVoucherParameters(originalVoucher);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		originalVoucher.incVersion();
		return originalVoucher;
	
	}
	public SmartList<OriginalVoucher> saveOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitOriginalVoucherList(originalVoucherList);
		
		batchOriginalVoucherCreate((List<OriginalVoucher>)lists[CREATE_LIST_INDEX]);
		
		batchOriginalVoucherUpdate((List<OriginalVoucher>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(OriginalVoucher originalVoucher:originalVoucherList){
			if(originalVoucher.isChanged()){
				originalVoucher.incVersion();
			}
			
		
		}
		
		
		return originalVoucherList;
	}

	public SmartList<OriginalVoucher> removeOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList,Map<String,Object> options){
		
		
		super.removeList(originalVoucherList, options);
		
		return originalVoucherList;
		
		
	}
	
	protected List<Object[]> prepareOriginalVoucherBatchCreateArgs(List<OriginalVoucher> originalVoucherList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucher originalVoucher:originalVoucherList ){
			Object [] parameters = prepareOriginalVoucherCreateParameters(originalVoucher);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareOriginalVoucherBatchUpdateArgs(List<OriginalVoucher> originalVoucherList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(OriginalVoucher originalVoucher:originalVoucherList ){
			if(!originalVoucher.isChanged()){
				continue;
			}
			Object [] parameters = prepareOriginalVoucherUpdateParameters(originalVoucher);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchOriginalVoucherCreate(List<OriginalVoucher> originalVoucherList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareOriginalVoucherBatchCreateArgs(originalVoucherList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchOriginalVoucherUpdate(List<OriginalVoucher> originalVoucherList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareOriginalVoucherBatchUpdateArgs(originalVoucherList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitOriginalVoucherList(List<OriginalVoucher> originalVoucherList){
		
		List<OriginalVoucher> originalVoucherCreateList=new ArrayList<OriginalVoucher>();
		List<OriginalVoucher> originalVoucherUpdateList=new ArrayList<OriginalVoucher>();
		
		for(OriginalVoucher originalVoucher: originalVoucherList){
			if(isUpdateRequest(originalVoucher)){
				originalVoucherUpdateList.add( originalVoucher);
				continue;
			}
			originalVoucherCreateList.add(originalVoucher);
		}
		
		return new Object[]{originalVoucherCreateList,originalVoucherUpdateList};
	}
	
	protected boolean isUpdateRequest(OriginalVoucher originalVoucher){
 		return originalVoucher.getVersion() > 0;
 	}
 	protected String getSaveOriginalVoucherSQL(OriginalVoucher originalVoucher){
 		if(isUpdateRequest(originalVoucher)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveOriginalVoucherParameters(OriginalVoucher originalVoucher){
 		if(isUpdateRequest(originalVoucher) ){
 			return prepareOriginalVoucherUpdateParameters(originalVoucher);
 		}
 		return prepareOriginalVoucherCreateParameters(originalVoucher);
 	}
 	protected Object[] prepareOriginalVoucherUpdateParameters(OriginalVoucher originalVoucher){
 		Object[] parameters = new Object[12];
 
 		parameters[0] = originalVoucher.getTitle();
 		parameters[1] = originalVoucher.getMadeBy();
 		parameters[2] = originalVoucher.getReceivedBy();
 		parameters[3] = originalVoucher.getVoucherType();
 		parameters[4] = originalVoucher.getVoucherImage(); 	
 		if(originalVoucher.getBelongsTo() != null){
 			parameters[5] = originalVoucher.getBelongsTo().getId();
 		}
  	
 		if(originalVoucher.getCreation() != null){
 			parameters[6] = originalVoucher.getCreation().getId();
 		}
  	
 		if(originalVoucher.getConfirmation() != null){
 			parameters[7] = originalVoucher.getConfirmation().getId();
 		}
  	
 		if(originalVoucher.getAuditing() != null){
 			parameters[8] = originalVoucher.getAuditing().getId();
 		}
 
 		parameters[9] = originalVoucher.getCurrentStatus();		
 		parameters[10] = originalVoucher.getId();
 		parameters[11] = originalVoucher.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareOriginalVoucherCreateParameters(OriginalVoucher originalVoucher){
		Object[] parameters = new Object[11];
		String newOriginalVoucherId=getNextId();
		originalVoucher.setId(newOriginalVoucherId);
		parameters[0] =  originalVoucher.getId();
 
 		parameters[1] = originalVoucher.getTitle();
 		parameters[2] = originalVoucher.getMadeBy();
 		parameters[3] = originalVoucher.getReceivedBy();
 		parameters[4] = originalVoucher.getVoucherType();
 		parameters[5] = originalVoucher.getVoucherImage(); 	
 		if(originalVoucher.getBelongsTo() != null){
 			parameters[6] = originalVoucher.getBelongsTo().getId();
 		
 		}
 		 	
 		if(originalVoucher.getCreation() != null){
 			parameters[7] = originalVoucher.getCreation().getId();
 		
 		}
 		 	
 		if(originalVoucher.getConfirmation() != null){
 			parameters[8] = originalVoucher.getConfirmation().getId();
 		
 		}
 		 	
 		if(originalVoucher.getAuditing() != null){
 			parameters[9] = originalVoucher.getAuditing().getId();
 		
 		}
 		
 		parameters[10] = originalVoucher.getCurrentStatus();		
 				
 		return parameters;
 	}
 	
	protected OriginalVoucher saveInternalOriginalVoucher(OriginalVoucher originalVoucher, Map<String,Object> options){
		
		saveOriginalVoucher(originalVoucher);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(originalVoucher, options);
 		}
  	
 		if(isSaveCreationEnabled(options)){
	 		saveCreation(originalVoucher, options);
 		}
  	
 		if(isSaveConfirmationEnabled(options)){
	 		saveConfirmation(originalVoucher, options);
 		}
  	
 		if(isSaveAuditingEnabled(options)){
	 		saveAuditing(originalVoucher, options);
 		}
 
		
		return originalVoucher;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected OriginalVoucher saveBelongsTo(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getBelongsTo() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getAccountingDocumentDAO().save(originalVoucher.getBelongsTo(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected OriginalVoucher saveCreation(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getCreation() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getOriginalVoucherCreationDAO().save(originalVoucher.getCreation(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected OriginalVoucher saveConfirmation(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getConfirmation() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getOriginalVoucherConfirmationDAO().save(originalVoucher.getConfirmation(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected OriginalVoucher saveAuditing(OriginalVoucher originalVoucher, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(originalVoucher.getAuditing() == null){
 			return originalVoucher;//do nothing when it is null
 		}
 		
 		getOriginalVoucherAuditingDAO().save(originalVoucher.getAuditing(),options);
 		return originalVoucher;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public OriginalVoucher present(OriginalVoucher originalVoucher,Map<String, Object> options){
	

		return originalVoucher;
	
	}
		


	protected String getTableName(){
		return OriginalVoucherTable.TABLE_NAME;
	}
}


