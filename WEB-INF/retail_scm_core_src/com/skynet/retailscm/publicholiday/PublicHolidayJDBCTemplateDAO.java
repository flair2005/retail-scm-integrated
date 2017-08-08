
package com.skynet.retailscm.publicholiday;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class PublicHolidayJDBCTemplateDAO extends CommonJDBCTemplateDAO implements PublicHolidayDAO{
 
 	
 	private  RetailStoreCountryCenterDAO  retailStoreCountryCenterDAO;
 	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
	 	return this.retailStoreCountryCenterDAO;
 	}

		

	
	/*
	protected PublicHoliday load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPublicHoliday(accessKey, options);
	}
	*/
	public PublicHoliday load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPublicHoliday(PublicHolidayTable.withId(id), options);
	}
	
	
	
	public PublicHoliday save(PublicHoliday publicHoliday,Map<String,Object> options){
		
		String methodName="save(PublicHoliday publicHoliday,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(publicHoliday, methodName, "publicHoliday");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPublicHoliday(publicHoliday,options);
	}
	public PublicHoliday clone(String publicHolidayId, Map<String,Object> options) throws Exception{
	
		return clone(PublicHolidayTable.withId(publicHolidayId),options);
	}
	
	protected PublicHoliday clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String publicHolidayId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PublicHoliday newPublicHoliday = loadInternalPublicHoliday(accessKey, options);
		newPublicHoliday.setVersion(0);
		
		

		
		saveInternalPublicHoliday(newPublicHoliday,options);
		
		return newPublicHoliday;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String publicHolidayId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{publicHolidayId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new PublicHolidayVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PublicHolidayNotFoundException(
					"The " + this.getTableName() + "(" + publicHolidayId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String publicHolidayId, int version) throws Exception{
	
		String methodName="delete(String publicHolidayId, int version)";
		assertMethodArgumentNotNull(publicHolidayId, methodName, "publicHolidayId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{publicHolidayId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(publicHolidayId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"code","company","name","description"};
		return PublicHolidayTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "public_holiday";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PublicHolidayTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractCompanyEnabled = true;
 	//private static final String COMPANY = "company";
 	protected boolean isExtractCompanyEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PublicHolidayTokens.COMPANY);
 	}
 	
 	
 	//private boolean saveCompanyEnabled = true;
 	protected boolean isSaveCompanyEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PublicHolidayTokens.COMPANY);
 	}
 	

 	
 
		

	

	protected PublicHolidayMapper getPublicHolidayMapper(){
		return new PublicHolidayMapper();
	}
	protected PublicHoliday extractPublicHoliday(String publicHolidayId) throws Exception{
		String SQL = "select * from public_holiday_data where id = ?";	
		try{
		
			PublicHoliday publicHoliday = queryForObject(SQL, new Object[]{publicHolidayId}, getPublicHolidayMapper());
			return publicHoliday;
		}catch(EmptyResultDataAccessException e){
			throw new PublicHolidayNotFoundException("PublicHoliday("+publicHolidayId+") is not found!");
		}
		
		
	}
	protected PublicHoliday extractPublicHoliday(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from public_holiday_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			PublicHoliday publicHoliday = queryForObject(SQL, new Object[]{accessKey.getValue()}, getPublicHolidayMapper());
			return publicHoliday;
		}catch(EmptyResultDataAccessException e){
			throw new PublicHolidayNotFoundException("PublicHoliday("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected PublicHoliday loadInternalPublicHoliday(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PublicHoliday publicHoliday = extractPublicHoliday(accessKey, loadOptions);
 	
 		if(isExtractCompanyEnabled(loadOptions)){
	 		extractCompany(publicHoliday, loadOptions);
 		}
 
		
		return publicHoliday;
		
	}



	
	
	 

 	protected PublicHoliday extractCompany(PublicHoliday publicHoliday, Map<String,Object> options) throws Exception{

		if(publicHoliday.getCompany() == null){
			return publicHoliday;
		}
		String companyId = publicHoliday.getCompany().getId();
		if( companyId == null){
			return publicHoliday;
		}
		RetailStoreCountryCenter company = getRetailStoreCountryCenterDAO().load(companyId,options);
		if(company != null){
			publicHoliday.setCompany(company);
		}
		
 		
 		return publicHoliday;
 	}
 		
 
		
		
  	
 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ?";
		SmartList<PublicHoliday> publicHolidayList = queryForList(SQL, new Object[]{retailStoreCountryCenterId}, getPublicHolidayMapper());	
 		return publicHolidayList;
 	}
 	
 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where company = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PublicHoliday> publicHolidayList = queryForList(SQL, new Object[]{retailStoreCountryCenterId,start, count}, getPublicHolidayMapper());
		
 		return publicHolidayList;
 	}
 	
 	public int countPublicHolidayByCompany(String retailStoreCountryCenterId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where company = ?";
		Integer count = queryInt(SQL, new Object[]{retailStoreCountryCenterId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected PublicHoliday savePublicHoliday(PublicHoliday  publicHoliday){
	
		String SQL=this.getSavePublicHolidaySQL(publicHoliday);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePublicHolidayParameters(publicHoliday);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		publicHoliday.incVersion();
		return publicHoliday;
	
	}
	public SmartList<PublicHoliday> savePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPublicHolidayList(publicHolidayList);
		
		batchPublicHolidayCreate((List<PublicHoliday>)lists[CREATE_LIST_INDEX]);
		
		batchPublicHolidayUpdate((List<PublicHoliday>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PublicHoliday publicHoliday:publicHolidayList){
			if(publicHoliday.isChanged()){
				publicHoliday.incVersion();
			}
			
		
		}
		
		
		return publicHolidayList;
	}

	public SmartList<PublicHoliday> removePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options){
		
		
		super.removeList(publicHolidayList, options);
		
		return publicHolidayList;
		
		
	}
	
	protected List<Object[]> preparePublicHolidayBatchCreateArgs(List<PublicHoliday> publicHolidayList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PublicHoliday publicHoliday:publicHolidayList ){
			Object [] parameters = preparePublicHolidayCreateParameters(publicHoliday);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePublicHolidayBatchUpdateArgs(List<PublicHoliday> publicHolidayList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PublicHoliday publicHoliday:publicHolidayList ){
			if(!publicHoliday.isChanged()){
				continue;
			}
			Object [] parameters = preparePublicHolidayUpdateParameters(publicHoliday);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPublicHolidayCreate(List<PublicHoliday> publicHolidayList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePublicHolidayBatchCreateArgs(publicHolidayList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPublicHolidayUpdate(List<PublicHoliday> publicHolidayList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePublicHolidayBatchUpdateArgs(publicHolidayList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPublicHolidayList(List<PublicHoliday> publicHolidayList){
		
		List<PublicHoliday> publicHolidayCreateList=new ArrayList<PublicHoliday>();
		List<PublicHoliday> publicHolidayUpdateList=new ArrayList<PublicHoliday>();
		
		for(PublicHoliday publicHoliday: publicHolidayList){
			if(isUpdateRequest(publicHoliday)){
				publicHolidayUpdateList.add( publicHoliday);
				continue;
			}
			publicHolidayCreateList.add(publicHoliday);
		}
		
		return new Object[]{publicHolidayCreateList,publicHolidayUpdateList};
	}
	
	protected boolean isUpdateRequest(PublicHoliday publicHoliday){
 		return publicHoliday.getVersion() > 0;
 	}
 	protected String getSavePublicHolidaySQL(PublicHoliday publicHoliday){
 		if(isUpdateRequest(publicHoliday)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePublicHolidayParameters(PublicHoliday publicHoliday){
 		if(isUpdateRequest(publicHoliday) ){
 			return preparePublicHolidayUpdateParameters(publicHoliday);
 		}
 		return preparePublicHolidayCreateParameters(publicHoliday);
 	}
 	protected Object[] preparePublicHolidayUpdateParameters(PublicHoliday publicHoliday){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = publicHoliday.getCode(); 	
 		if(publicHoliday.getCompany() != null){
 			parameters[1] = publicHoliday.getCompany().getId();
 		}
 
 		parameters[2] = publicHoliday.getName();
 		parameters[3] = publicHoliday.getDescription();		
 		parameters[4] = publicHoliday.getId();
 		parameters[5] = publicHoliday.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePublicHolidayCreateParameters(PublicHoliday publicHoliday){
		Object[] parameters = new Object[5];
		String newPublicHolidayId=getNextId();
		publicHoliday.setId(newPublicHolidayId);
		parameters[0] =  publicHoliday.getId();
 
 		parameters[1] = publicHoliday.getCode(); 	
 		if(publicHoliday.getCompany() != null){
 			parameters[2] = publicHoliday.getCompany().getId();
 		
 		}
 		
 		parameters[3] = publicHoliday.getName();
 		parameters[4] = publicHoliday.getDescription();		
 				
 		return parameters;
 	}
 	
	protected PublicHoliday saveInternalPublicHoliday(PublicHoliday publicHoliday, Map<String,Object> options){
		
		savePublicHoliday(publicHoliday);
 	
 		if(isSaveCompanyEnabled(options)){
	 		saveCompany(publicHoliday, options);
 		}
 
		
		return publicHoliday;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PublicHoliday saveCompany(PublicHoliday publicHoliday, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(publicHoliday.getCompany() == null){
 			return publicHoliday;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(publicHoliday.getCompany(),options);
 		return publicHoliday;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public PublicHoliday present(PublicHoliday publicHoliday,Map<String, Object> options){
	

		return publicHoliday;
	
	}
		


	protected String getTableName(){
		return PublicHolidayTable.TABLE_NAME;
	}
}


