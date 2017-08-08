package com.skynet.retailscm;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class BaseEntity implements Serializable{
	

	private static final long serialVersionUID = 1L;
	protected		int                 	mVersion            ;
	protected		boolean					changed = false      ;
	protected		String 					id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void incVersion(){
		int version = getVersion();
		setVersion(version+1);
		
		
		
		
	}
	public List<Message> getErrorMessageList() {
		
		if(errorMessageList ==  null){
			return new ArrayList<Message>();
		}
		
		return errorMessageList;
	}
	public void setErrorMessageList(List<Message> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	@Override
	public boolean equals(Object object){
		if(object == null){
			return false;
		}
		
		if(!(object instanceof BaseEntity)){
			return false;
		}
		BaseEntity targetObject = (BaseEntity)object;
		String targetId = targetObject.getId();
		if(targetId == null){
			return false;
		}
		
		if(!(targetId.equals(this.getId()))){
			return false;
		}
		
		int targetVersion = targetObject.getVersion();
		
		if(targetVersion != this.getVersion()){
			return false;
		}
		
		//is exactly the same class?
		if(object.getClass() == this.getClass()){
			return true;
		}
		//If the class is not exactly the same, but they may initiated from different class loader
		
		
		String targetClassName = object.getClass().getCanonicalName();
		String thisClassName = this.getClass().getCanonicalName();
		
		if(targetClassName.equals(thisClassName)){
			return true;
		}		
		
		return false;
		
	}
	protected  Map<String,List<BaseEntity>> flexibleLists;
	protected<T> void ensureFlexibleLists(){
		if(flexibleLists ==  null){
			flexibleLists = new HashMap<String,List<BaseEntity>>();
		}
	}
	protected List<BaseEntity> ensureFlexibleList(String key){
		
		List<BaseEntity> list = (List<BaseEntity>) flexibleLists.get(key);
		if(list ==  null){
			list = new ArrayList<BaseEntity>();
			flexibleLists.put(key,list);
		}
		return list;
		
	}
	public void  addItemToFlexibleList(String key, BaseEntity item){
		ensureFlexibleLists();
		List<BaseEntity> list = ensureFlexibleList(key);
		list.add(item);
		
		
	}
	
	protected Map<String,Object> valueMap;
	protected<T> void ensureValueMap(){
		if(valueMap ==  null){
			valueMap = new HashMap<String,Object>();
		}
	}
	
	public <T> void  addItemToValueMap(String key, T item){
		ensureValueMap();
		valueMap.put(key, item);
	}
	
	protected Object  valueByKey(String key){
		if(valueMap == null){
			return null;
		}
		
		return valueMap.get(key);
	}
	protected String getListSizeKey(String targetName){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(targetName);
		stringBuilder.append("ListSize");
		return stringBuilder.toString();
	}
	public Integer  listSizeOf(String targetName){

		return (Integer)valueMap.get(getListSizeKey(targetName));
	}
	public void addListSize(String targetName, int value){
	
		addItemToValueMap(getListSizeKey(targetName), value);
		
	}
	
	public void  addItemToFlexibleList(String key, List<BaseEntity> entityList){
		ensureFlexibleLists();
		List<BaseEntity> list = ensureFlexibleList(key);
		list.addAll(entityList);
		
		
	}
	
	public void  addPagesToFlexibleList(String object, List<BaseEntity> entityList){
		ensureFlexibleLists();
		List<BaseEntity> list = ensureFlexibleList(object+"ListPagination");
		list.addAll(entityList);
		
		
	}
	
	public List<BaseEntity>   flexibleListOf(String key){
		
		if(flexibleLists == null){
			return null;
		}

		List<BaseEntity> list = (List<BaseEntity>) flexibleLists.get(key);
		return list;
		
		
	}
	
	protected  Map<String,BaseEntity> flexibleObjects;
	protected void ensureFlexibleObjects(){
		if(flexibleObjects ==  null){
			flexibleObjects = new HashMap<String,BaseEntity>();
		}
	}
	public void addItemToFlexiableObject(String key, BaseEntity item){
		ensureFlexibleObjects();		
		flexibleObjects.put(key, item);
		
	}
	/*
	 * Functional for this list:
	 * 
	 * Removed items Once an item marked as delete, then the item will move to this list before delete
	 * 
	 * there may be more items types need to remove
	 * 
	 * 
	 * */
	protected List<Message> errorMessageList;
	protected void ensureErrorMessageList(){
		if(errorMessageList ==  null){
			errorMessageList = new ArrayList<Message>();
		}
	}
	public void addErrorMessage(Message message){
		ensureErrorMessageList();
		errorMessageList.add(message);
		
	}
	
	protected List<Action> actionList;
	
	protected void ensureActionList(){
		if(actionList ==  null){
			actionList = new ArrayList<Action>();
		}
	}
	public void addAction(Action action){
		ensureActionList();
		actionList.add(action);
		
	}
	
	public List<Action> getActionList() {
		return actionList;
	}
	
	protected void onChangeProperty(String property, Object oldValue, Object newValue){
		changed = true;
		return;
	}
	public boolean isChanged(){
		if(this.getVersion()==0){
			return true;
		}
		return changed;
	}
	public void setVersion(int version){
		this.mVersion = version;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	protected Double parseDouble(String doubleExpr) {
		//support for money types
		char firstChar = doubleExpr.charAt(0);
		
		if(Character.isDigit(firstChar)){

			return Double.parseDouble(doubleExpr);
		}
		
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.SIMPLIFIED_CHINESE);
		try {
			return format.parse(doubleExpr).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new NumberFormatException("The value: "+ doubleExpr +" is not for a number");
		}
		
		
		//return Double.parseDouble(doubleExpr.substring(1));
		
		
	}
	protected Double parseDouble(String doubleExpr, int precision){		
		return Double.parseDouble(doubleExpr);
	}
	
	protected Float parseFloat(String floatExpr){		
		return Float.parseFloat(floatExpr);
	}
	protected Integer parseInt(String intExpr){		
		return Integer.parseInt(intExpr);
	}
	protected Boolean parseBoolean(String booleanExpr){		
		return Boolean.parseBoolean(booleanExpr);
	}
	protected Double parseTime(String timeExpr){		
		return Double.parseDouble(timeExpr);
	}
	protected Date parseDate(String dateExpr){
		String defaultFormat = "yyyy-MM-dd";
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		try {
			return formatter.parse(dateExpr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("The value '"+dateExpr+"' could not be parsed to a Date.");
		}
	}

	protected String parseString(String stringExpr){		
		return stringExpr;
	}
	
	
	protected boolean equalsInt(int a, int b){
		return a==b;
	}
	protected boolean equalsLong(long a, long b){
		return a==b;
	}
	protected boolean equalsDouble(double a, double b){
		return Math.abs(a-b)<0.00001;
	}
	protected boolean equalsFloat(float a, float b){
		return Math.abs(a-b)<0.00001;
	}
	
	private boolean equalsObject(Object a, Object b){
		if(a==b){
			return true;//they can be both null, or exact the same object, this is much faster than equals function
		}
		if(a==null){
			return false;//a is null, b must not be null
		}
		if(b==null){
			return false;//b is null, b must not be null
		}
		if(a.equals(b)){
			return true;//both of them are not null, then safely compare the value
		}
		return false;
		
	}
	protected boolean equalsString(String a, String b){
		return equalsObject(a,b);
	}
	protected boolean equalsDate(Date a, Date b){
		return equalsObject(a,b);
	}
	protected boolean equalsBoolean(boolean a, boolean b){
		return a==b;
	}
	protected void addErrorMessageInternal(String messageKey, Object prameters[]){
		ensureErrorMessageList();
		Message erroMessage = createErrorMessage(messageKey, prameters);
		errorMessageList.add(erroMessage);
	}
	//This method will be called from external classes.
	public void addErrorMessage(String messageKey, Object prarameters[]){
		if(messageKey == null){	
			//this must a code issue
			throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): key is null, this is not epected");
		}
		if(prarameters == null){
			//this must a code issue
			addErrorMessageInternal(messageKey,prarameters);
			return;
			//throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): parameters is null, this is not epected");			
		}
		addErrorMessageInternal(messageKey,prarameters);
		
	}
	protected Message createErrorMessage(String key, Object[] parameters){
		Message message = new Message();
		message.setSourcePostion(key);
		message.setParameters(parameters);
		
		return message;
	}
	protected boolean wrapErrorMessage(String key){
		return  wrapErrorMessage( key, null);
	}
	protected boolean wrapErrorMessage(String key,Object[] parameters){
		if(key == null){	
			//this must a code issue
			throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): key is null, this is not epected");
		}
		if(parameters == null){
			//this must a code issue
			addErrorMessageInternal(key,parameters);
			//throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): parameters is null, this is not epected");
			return false;
		}
		int index = 0;
		for(Object object: parameters){
			//this must a code issue
			if(object == null){
				throw new IllegalArgumentException("wrapErrorMessage(String key,Object[] parameters): parameters["+index+"] is null, this is not epected");
			}
			index++;
		}
		addErrorMessageInternal(key,parameters);
		return false;

	}
	private static final String ID_NOT_ALLOWED_TO_BE_NULL_WHEN_VERSION_GREAT_THAN_ZERO = "ID_NOT_ALLOWED_TO_BE_NULL_WHEN_VERSION_GREAT_THAN_ZERO";
	private static final String ID_NOT_ALLOWED_TO_BE_EMPTY_WHEN_VERSION_GREAT_THAN_ZERO = "ID_NOT_ALLOWED_TO_BE_EMPTY_WHEN_VERSION_GREAT_THAN_ZERO";
	private static final String VERSION_NOT_ALLOWED_TO_BE_LESS_THAN_ZERO_ANY_TIME = "VERSION_NOT_ALLOWED_TO_LESS_THAN_ZERO_ANY_TIME";
	
	public boolean validate(){
		if(getVersion()>0){
			//when the version great than 0, it means an existing object.
			if(null == getId()){				
				return wrapErrorMessage(ID_NOT_ALLOWED_TO_BE_NULL_WHEN_VERSION_GREAT_THAN_ZERO);
			}
			String trimedId = getId().trim();
			if(trimedId.isEmpty()){
				return wrapErrorMessage(ID_NOT_ALLOWED_TO_BE_EMPTY_WHEN_VERSION_GREAT_THAN_ZERO);
			}
		}
		if(getVersion()<0){
			
			return wrapErrorMessage(VERSION_NOT_ALLOWED_TO_BE_LESS_THAN_ZERO_ANY_TIME, new Object[]{ getVersion()});
		}
		return true;
	}
	protected String trimString(String string){
		if(string == null){
			return null;
		}
		return string.trim();
		
	}
	//使用SALT的目的是为了防止在数据库泄露的情况下，黑客对其进行碰撞攻击，黑客的碰撞攻击
	//就是通过密码词典，进行hash，然后查看库中是否有匹配的字串，发现有，则密码攻破
	//弱的密码就无法逃脱
	//加入SALT之后，可以大大增加hash攻击的难度，因为增加了一个维度。
	protected String hashStringWithSHA256(String valueToHash) {
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String textToHash = new StringBuilder(valueToHash).append(":").append(getSalt()).toString();
			byte[] hash = digest.digest(textToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder stringBuilder = new StringBuilder();
		    for (byte b : hash) {
		        stringBuilder.append(String.format("%02X", b));
		    }
		    return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
		
	}
	protected String getSalt(){
		return this.getId();
	}
	protected boolean equalsTimestamp(Date oldValue, Date newValue) {
		// TODO Auto-generated method stub
		return equalsDate(oldValue,newValue);
	}

	protected Date parseTimestamp(String timestampExpr) {
		String defaultFormat = "yyyy-MM-dd'T'HH:mm:ss";
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		try {
			return formatter.parse(timestampExpr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("The value '"+timestampExpr+"' could not be parsed to a Date.");
		}
		
	}
	
	
}//END class base Entity












