
package com.skynet.retailscm.potentialcustomercontact;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.skynet.retailscm.CommonJDBCTemplateDAO;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.skynet.retailscm.AccessKey;
import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;
import com.skynet.retailscm.citypartner.CityPartnerDAO;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerDAO;

import com.skynet.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTable;
import com.skynet.retailscm.potentialcustomer.PotentialCustomerTable;
import com.skynet.retailscm.citypartner.CityPartnerTable;


import org.springframework.dao.EmptyResultDataAccessException;

public class PotentialCustomerContactJDBCTemplateDAO extends CommonJDBCTemplateDAO implements PotentialCustomerContactDAO{
 
 	
 	private  CityPartnerDAO  cityPartnerDAO;
 	public void setCityPartnerDAO(CityPartnerDAO cityPartnerDAO){
	 	this.cityPartnerDAO = cityPartnerDAO;
 	}
 	public CityPartnerDAO getCityPartnerDAO(){
	 	return this.cityPartnerDAO;
 	}
 
 	
 	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
	 	return this.potentialCustomerDAO;
 	}
 
 	
 	private  PotentialCustomerContactPersonDAO  potentialCustomerContactPersonDAO;
 	public void setPotentialCustomerContactPersonDAO(PotentialCustomerContactPersonDAO potentialCustomerContactPersonDAO){
	 	this.potentialCustomerContactPersonDAO = potentialCustomerContactPersonDAO;
 	}
 	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO(){
	 	return this.potentialCustomerContactPersonDAO;
 	}

		

	
	/*
	protected PotentialCustomerContact load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContact(accessKey, options);
	}
	*/
	public PotentialCustomerContact load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContact(PotentialCustomerContactTable.withId(id), options);
	}
	
	
	
	public PotentialCustomerContact save(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options){
		
		String methodName="save(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(potentialCustomerContact, methodName, "potentialCustomerContact");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPotentialCustomerContact(potentialCustomerContact,options);
	}
	public PotentialCustomerContact clone(String potentialCustomerContactId, Map<String,Object> options) throws Exception{
	
		return clone(PotentialCustomerContactTable.withId(potentialCustomerContactId),options);
	}
	
	protected PotentialCustomerContact clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String potentialCustomerContactId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PotentialCustomerContact newPotentialCustomerContact = loadInternalPotentialCustomerContact(accessKey, options);
		newPotentialCustomerContact.setVersion(0);
		
		

		
		saveInternalPotentialCustomerContact(newPotentialCustomerContact,options);
		
		return newPotentialCustomerContact;
	}
	
	
	
	
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String potentialCustomerContactId, int version) throws Exception {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{potentialCustomerContactId};
		int count = queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new PotentialCustomerContactVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PotentialCustomerContactNotFoundException(
					"The " + this.getTableName() + "(" + potentialCustomerContactId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String potentialCustomerContactId, int version) throws Exception{
	
		String methodName="delete(String potentialCustomerContactId, int version)";
		assertMethodArgumentNotNull(potentialCustomerContactId, methodName, "potentialCustomerContactId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{potentialCustomerContactId,version};
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(potentialCustomerContactId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		//return new String[]{"name","contact_date","contact_method","potential_customer","city_partner","contact_to","description"};
		return PotentialCustomerContactTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "potential_customer_contact";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PotentialCustomerContactTokens.checkOptions(options, optionToCheck);
	
	}

 
 	//private boolean extractPotentialCustomerEnabled = true;
 	//private static final String POTENTIALCUSTOMER = "potentialCustomer";
 	protected boolean isExtractPotentialCustomerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactTokens.POTENTIALCUSTOMER);
 	}
 	
 	
 	//private boolean savePotentialCustomerEnabled = true;
 	protected boolean isSavePotentialCustomerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactTokens.POTENTIALCUSTOMER);
 	}
 	

 	
  
 	//private boolean extractCityPartnerEnabled = true;
 	//private static final String CITYPARTNER = "cityPartner";
 	protected boolean isExtractCityPartnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactTokens.CITYPARTNER);
 	}
 	
 	
 	//private boolean saveCityPartnerEnabled = true;
 	protected boolean isSaveCityPartnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactTokens.CITYPARTNER);
 	}
 	

 	
  
 	//private boolean extractContactToEnabled = true;
 	//private static final String CONTACTTO = "contactTo";
 	protected boolean isExtractContactToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactTokens.CONTACTTO);
 	}
 	
 	
 	//private boolean saveContactToEnabled = true;
 	protected boolean isSaveContactToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactTokens.CONTACTTO);
 	}
 	

 	
 
		

	

	protected PotentialCustomerContactMapper getPotentialCustomerContactMapper(){
		return new PotentialCustomerContactMapper();
	}
	protected PotentialCustomerContact extractPotentialCustomerContact(String potentialCustomerContactId) throws Exception{
		String SQL = "select * from potential_customer_contact_data where id = ?";	
		try{
		
			PotentialCustomerContact potentialCustomerContact = queryForObject(SQL, new Object[]{potentialCustomerContactId}, getPotentialCustomerContactMapper());
			return potentialCustomerContact;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerContactNotFoundException("PotentialCustomerContact("+potentialCustomerContactId+") is not found!");
		}
		
		
	}
	protected PotentialCustomerContact extractPotentialCustomerContact(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		String SQL = "select * from potential_customer_contact_data where " + accessKey.getColumnName()+" = ?";	
		try{
		
			PotentialCustomerContact potentialCustomerContact = queryForObject(SQL, new Object[]{accessKey.getValue()}, getPotentialCustomerContactMapper());
			return potentialCustomerContact;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerContactNotFoundException("PotentialCustomerContact("+accessKey+") is not found!");
		}
		
		
	}

	
	

	protected PotentialCustomerContact loadInternalPotentialCustomerContact(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PotentialCustomerContact potentialCustomerContact = extractPotentialCustomerContact(accessKey, loadOptions);
 	
 		if(isExtractPotentialCustomerEnabled(loadOptions)){
	 		extractPotentialCustomer(potentialCustomerContact, loadOptions);
 		}
  	
 		if(isExtractCityPartnerEnabled(loadOptions)){
	 		extractCityPartner(potentialCustomerContact, loadOptions);
 		}
  	
 		if(isExtractContactToEnabled(loadOptions)){
	 		extractContactTo(potentialCustomerContact, loadOptions);
 		}
 
		
		return potentialCustomerContact;
		
	}



	
	
	 

 	protected PotentialCustomerContact extractPotentialCustomer(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options) throws Exception{

		if(potentialCustomerContact.getPotentialCustomer() == null){
			return potentialCustomerContact;
		}
		String potentialCustomerId = potentialCustomerContact.getPotentialCustomer().getId();
		if( potentialCustomerId == null){
			return potentialCustomerContact;
		}
		PotentialCustomer potentialCustomer = getPotentialCustomerDAO().load(potentialCustomerId,options);
		if(potentialCustomer != null){
			potentialCustomerContact.setPotentialCustomer(potentialCustomer);
		}
		
 		
 		return potentialCustomerContact;
 	}
 		
  

 	protected PotentialCustomerContact extractCityPartner(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options) throws Exception{

		if(potentialCustomerContact.getCityPartner() == null){
			return potentialCustomerContact;
		}
		String cityPartnerId = potentialCustomerContact.getCityPartner().getId();
		if( cityPartnerId == null){
			return potentialCustomerContact;
		}
		CityPartner cityPartner = getCityPartnerDAO().load(cityPartnerId,options);
		if(cityPartner != null){
			potentialCustomerContact.setCityPartner(cityPartner);
		}
		
 		
 		return potentialCustomerContact;
 	}
 		
  

 	protected PotentialCustomerContact extractContactTo(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options) throws Exception{

		if(potentialCustomerContact.getContactTo() == null){
			return potentialCustomerContact;
		}
		String contactToId = potentialCustomerContact.getContactTo().getId();
		if( contactToId == null){
			return potentialCustomerContact;
		}
		PotentialCustomerContactPerson contactTo = getPotentialCustomerContactPersonDAO().load(contactToId,options);
		if(contactTo != null){
			potentialCustomerContact.setContactTo(contactTo);
		}
		
 		
 		return potentialCustomerContact;
 	}
 		
 
		
		
  	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where potential_customer = ?";
		SmartList<PotentialCustomerContact> potentialCustomerContactList = queryForList(SQL, new Object[]{potentialCustomerId}, getPotentialCustomerContactMapper());	
 		return potentialCustomerContactList;
 	}
 	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where potential_customer = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PotentialCustomerContact> potentialCustomerContactList = queryForList(SQL, new Object[]{potentialCustomerId,start, count}, getPotentialCustomerContactMapper());
		
 		return potentialCustomerContactList;
 	}
 	
 	public int countPotentialCustomerContactByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where potential_customer = ?";
		Integer count = queryInt(SQL, new Object[]{potentialCustomerId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_partner = ?";
		SmartList<PotentialCustomerContact> potentialCustomerContactList = queryForList(SQL, new Object[]{cityPartnerId}, getPotentialCustomerContactMapper());	
 		return potentialCustomerContactList;
 	}
 	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where city_partner = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PotentialCustomerContact> potentialCustomerContactList = queryForList(SQL, new Object[]{cityPartnerId,start, count}, getPotentialCustomerContactMapper());
		
 		return potentialCustomerContactList;
 	}
 	
 	public int countPotentialCustomerContactByCityPartner(String cityPartnerId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where city_partner = ?";
		Integer count = queryInt(SQL, new Object[]{cityPartnerId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
  	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where contact_to = ?";
		SmartList<PotentialCustomerContact> potentialCustomerContactList = queryForList(SQL, new Object[]{potentialCustomerContactPersonId}, getPotentialCustomerContactMapper());	
 		return potentialCustomerContactList;
 	}
 	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, int start, int count,Map<String,Object> options){
 	
 		String SQL = "select * from "+this.getTableName()+" where contact_to = ? limit ?, ?";
 		//MySQL only, please replace it when using ORACLE DB
		SmartList<PotentialCustomerContact> potentialCustomerContactList = queryForList(SQL, new Object[]{potentialCustomerContactPersonId,start, count}, getPotentialCustomerContactMapper());
		
 		return potentialCustomerContactList;
 	}
 	
 	public int countPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId,Map<String,Object> options){
	 	
 		String SQL = "select count(*) from "+this.getTableName()+" where contact_to = ?";
		Integer count = queryInt(SQL, new Object[]{potentialCustomerContactPersonId});
		if(count ==  null ){
			//return the value anyways
			return 0;
		}
 		
 		return count;
 	}
 	
 	
 	
		
		
		

	

	protected PotentialCustomerContact savePotentialCustomerContact(PotentialCustomerContact  potentialCustomerContact){
	
		String SQL=this.getSavePotentialCustomerContactSQL(potentialCustomerContact);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePotentialCustomerContactParameters(potentialCustomerContact);
		int affectedNumber = update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		potentialCustomerContact.incVersion();
		return potentialCustomerContact;
	
	}
	public SmartList<PotentialCustomerContact> savePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPotentialCustomerContactList(potentialCustomerContactList);
		
		batchPotentialCustomerContactCreate((List<PotentialCustomerContact>)lists[CREATE_LIST_INDEX]);
		
		batchPotentialCustomerContactUpdate((List<PotentialCustomerContact>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			if(potentialCustomerContact.isChanged()){
				potentialCustomerContact.incVersion();
			}
			
		
		}
		
		
		return potentialCustomerContactList;
	}

	public SmartList<PotentialCustomerContact> removePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options){
		
		
		super.removeList(potentialCustomerContactList, options);
		
		return potentialCustomerContactList;
		
		
	}
	
	protected List<Object[]> preparePotentialCustomerContactBatchCreateArgs(List<PotentialCustomerContact> potentialCustomerContactList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList ){
			Object [] parameters = preparePotentialCustomerContactCreateParameters(potentialCustomerContact);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePotentialCustomerContactBatchUpdateArgs(List<PotentialCustomerContact> potentialCustomerContactList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList ){
			if(!potentialCustomerContact.isChanged()){
				continue;
			}
			Object [] parameters = preparePotentialCustomerContactUpdateParameters(potentialCustomerContact);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPotentialCustomerContactCreate(List<PotentialCustomerContact> potentialCustomerContactList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePotentialCustomerContactBatchCreateArgs(potentialCustomerContactList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPotentialCustomerContactUpdate(List<PotentialCustomerContact> potentialCustomerContactList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePotentialCustomerContactBatchUpdateArgs(potentialCustomerContactList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPotentialCustomerContactList(List<PotentialCustomerContact> potentialCustomerContactList){
		
		List<PotentialCustomerContact> potentialCustomerContactCreateList=new ArrayList<PotentialCustomerContact>();
		List<PotentialCustomerContact> potentialCustomerContactUpdateList=new ArrayList<PotentialCustomerContact>();
		
		for(PotentialCustomerContact potentialCustomerContact: potentialCustomerContactList){
			if(isUpdateRequest(potentialCustomerContact)){
				potentialCustomerContactUpdateList.add( potentialCustomerContact);
				continue;
			}
			potentialCustomerContactCreateList.add(potentialCustomerContact);
		}
		
		return new Object[]{potentialCustomerContactCreateList,potentialCustomerContactUpdateList};
	}
	
	protected boolean isUpdateRequest(PotentialCustomerContact potentialCustomerContact){
 		return potentialCustomerContact.getVersion() > 0;
 	}
 	protected String getSavePotentialCustomerContactSQL(PotentialCustomerContact potentialCustomerContact){
 		if(isUpdateRequest(potentialCustomerContact)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePotentialCustomerContactParameters(PotentialCustomerContact potentialCustomerContact){
 		if(isUpdateRequest(potentialCustomerContact) ){
 			return preparePotentialCustomerContactUpdateParameters(potentialCustomerContact);
 		}
 		return preparePotentialCustomerContactCreateParameters(potentialCustomerContact);
 	}
 	protected Object[] preparePotentialCustomerContactUpdateParameters(PotentialCustomerContact potentialCustomerContact){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = potentialCustomerContact.getName();
 		parameters[1] = potentialCustomerContact.getContactDate();
 		parameters[2] = potentialCustomerContact.getContactMethod(); 	
 		if(potentialCustomerContact.getPotentialCustomer() != null){
 			parameters[3] = potentialCustomerContact.getPotentialCustomer().getId();
 		}
  	
 		if(potentialCustomerContact.getCityPartner() != null){
 			parameters[4] = potentialCustomerContact.getCityPartner().getId();
 		}
  	
 		if(potentialCustomerContact.getContactTo() != null){
 			parameters[5] = potentialCustomerContact.getContactTo().getId();
 		}
 
 		parameters[6] = potentialCustomerContact.getDescription();		
 		parameters[7] = potentialCustomerContact.getId();
 		parameters[8] = potentialCustomerContact.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePotentialCustomerContactCreateParameters(PotentialCustomerContact potentialCustomerContact){
		Object[] parameters = new Object[8];
		String newPotentialCustomerContactId=getNextId();
		potentialCustomerContact.setId(newPotentialCustomerContactId);
		parameters[0] =  potentialCustomerContact.getId();
 
 		parameters[1] = potentialCustomerContact.getName();
 		parameters[2] = potentialCustomerContact.getContactDate();
 		parameters[3] = potentialCustomerContact.getContactMethod(); 	
 		if(potentialCustomerContact.getPotentialCustomer() != null){
 			parameters[4] = potentialCustomerContact.getPotentialCustomer().getId();
 		
 		}
 		 	
 		if(potentialCustomerContact.getCityPartner() != null){
 			parameters[5] = potentialCustomerContact.getCityPartner().getId();
 		
 		}
 		 	
 		if(potentialCustomerContact.getContactTo() != null){
 			parameters[6] = potentialCustomerContact.getContactTo().getId();
 		
 		}
 		
 		parameters[7] = potentialCustomerContact.getDescription();		
 				
 		return parameters;
 	}
 	
	protected PotentialCustomerContact saveInternalPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){
		
		savePotentialCustomerContact(potentialCustomerContact);
 	
 		if(isSavePotentialCustomerEnabled(options)){
	 		savePotentialCustomer(potentialCustomerContact, options);
 		}
  	
 		if(isSaveCityPartnerEnabled(options)){
	 		saveCityPartner(potentialCustomerContact, options);
 		}
  	
 		if(isSaveContactToEnabled(options)){
	 		saveContactTo(potentialCustomerContact, options);
 		}
 
		
		return potentialCustomerContact;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PotentialCustomerContact savePotentialCustomer(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContact.getPotentialCustomer() == null){
 			return potentialCustomerContact;//do nothing when it is null
 		}
 		
 		getPotentialCustomerDAO().save(potentialCustomerContact.getPotentialCustomer(),options);
 		return potentialCustomerContact;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected PotentialCustomerContact saveCityPartner(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContact.getCityPartner() == null){
 			return potentialCustomerContact;//do nothing when it is null
 		}
 		
 		getCityPartnerDAO().save(potentialCustomerContact.getCityPartner(),options);
 		return potentialCustomerContact;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected PotentialCustomerContact saveContactTo(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContact.getContactTo() == null){
 			return potentialCustomerContact;//do nothing when it is null
 		}
 		
 		getPotentialCustomerContactPersonDAO().save(potentialCustomerContact.getContactTo(),options);
 		return potentialCustomerContact;
 		
 	}
 	
 	
 	
 	 
	
 
		

	public PotentialCustomerContact present(PotentialCustomerContact potentialCustomerContact,Map<String, Object> options){
	

		return potentialCustomerContact;
	
	}
		


	protected String getTableName(){
		return PotentialCustomerContactTable.TABLE_NAME;
	}
}


