
package com.skynet.retailscm.retailstore;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goods.Goods;
import com.skynet.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.skynet.retailscm.transporttask.TransportTask;
import com.skynet.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.skynet.retailscm.retailstorecreation.RetailStoreCreation;
import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.retailstoreopening.RetailStoreOpening;
import com.skynet.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.skynet.retailscm.retailstoreorder.RetailStoreOrder;
import com.skynet.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.skynet.retailscm.retailstoreclosing.RetailStoreClosing;
import com.skynet.retailscm.consumerorder.ConsumerOrder;
import com.skynet.retailscm.accountset.AccountSet;

@JsonSerialize(using = RetailStoreSerializer.class)
public class RetailStore extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String TELEPHONE_PROPERTY             = "telephone"         ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String RETAIL_STORE_COUNTRY_CENTER_PROPERTY = "retailStoreCountryCenter";
	public static final String CITY_SERVICE_CENTER_PROPERTY   = "cityServiceCenter" ;
	public static final String CREATION_PROPERTY              = "creation"          ;
	public static final String INVESTMENT_INVITATION_PROPERTY = "investmentInvitation";
	public static final String FRANCHISING_PROPERTY           = "franchising"       ;
	public static final String DECORATION_PROPERTY            = "decoration"        ;
	public static final String OPENING_PROPERTY               = "opening"           ;
	public static final String CLOSING_PROPERTY               = "closing"           ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String RETAIL_STORE_ORDER_LIST                  = "retailStoreOrderList";
	public static final String GOODS_LIST                               = "goodsList"         ;
	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;
	public static final String ACCOUNT_SET_LIST                         = "accountSetList"    ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mTelephone          ;
	protected		String              	mOwner              ;
	protected		RetailStoreCountryCenter	mRetailStoreCountryCenter;
	protected		RetailStoreCityServiceCenter	mCityServiceCenter  ;
	protected		RetailStoreCreation 	mCreation           ;
	protected		RetailStoreInvestmentInvitation	mInvestmentInvitation;
	protected		RetailStoreFranchising	mFranchising        ;
	protected		RetailStoreDecoration	mDecoration         ;
	protected		RetailStoreOpening  	mOpening            ;
	protected		RetailStoreClosing  	mClosing            ;
	protected		Date                	mFounded            ;
	protected		double              	mLatitude           ;
	protected		double              	mLongitude          ;
	protected		String              	mDescription        ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<RetailStoreOrder>	mRetailStoreOrderList;
	protected		SmartList<Goods>    	mGoodsList          ;
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	protected		SmartList<AccountSet>	mAccountSetList     ;
	
		
	public 	RetailStore(){
		//lazy load for all the properties
	}
	
	public 	RetailStore(String name, String telephone, String owner, RetailStoreCountryCenter retailStoreCountryCenter, RetailStoreCityServiceCenter cityServiceCenter, Date founded, double latitude, double longitude, String description, String currentStatus
)
	{
		setName(name);
		setTelephone(telephone);
		setOwner(owner);
		setRetailStoreCountryCenter(retailStoreCountryCenter);
		setCityServiceCenter(cityServiceCenter);
		setFounded(founded);
		setLatitude(latitude);
		setLongitude(longitude);
		setDescription(description);
		setCurrentStatus(currentStatus);

		this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
		this.mGoodsList = new SmartList<Goods>();
		this.mTransportTaskList = new SmartList<TransportTask>();
		this.mAccountSetList = new SmartList<AccountSet>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(TELEPHONE_PROPERTY.equals(property)){
			changeTelephoneProperty(newValueExpr);
		}
		if(OWNER_PROPERTY.equals(property)){
			changeOwnerProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setName(newValue);
		//they are surely different each other
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeTelephoneProperty(String newValueExpr){
		String oldValue = getTelephone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTelephone(newValue);
		//they are surely different each other
		this.onChangeProperty(TELEPHONE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeOwnerProperty(String newValueExpr){
		String oldValue = getOwner();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setOwner(newValue);
		//they are surely different each other
		this.onChangeProperty(OWNER_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFounded(newValue);
		//they are surely different each other
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLatitudeProperty(String newValueExpr){
		double oldValue = getLatitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLatitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeLongitudeProperty(String newValueExpr){
		double oldValue = getLongitude();
		double newValue = parseDouble(newValueExpr);
		if(equalsDouble(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setLongitude(newValue);
		//they are surely different each other
		this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDescription(newValue);
		//they are surely different each other
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	public void setTelephone(String telephone){
		this.mTelephone = trimString(telephone);;
	}
	public String getTelephone(){
		return this.mTelephone;
	}
	
	
	public void setOwner(String owner){
		this.mOwner = trimString(owner);;
	}
	public String getOwner(){
		return this.mOwner;
	}
	
	
	public void setRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter){
		this.mRetailStoreCountryCenter = retailStoreCountryCenter;;
	}
	public RetailStoreCountryCenter getRetailStoreCountryCenter(){
		return this.mRetailStoreCountryCenter;
	}
	
	
	public void setCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		this.mCityServiceCenter = cityServiceCenter;;
	}
	public RetailStoreCityServiceCenter getCityServiceCenter(){
		return this.mCityServiceCenter;
	}
	
	
	public void setCreation(RetailStoreCreation creation){
		this.mCreation = creation;;
	}
	public RetailStoreCreation getCreation(){
		return this.mCreation;
	}
	
	
	public void setInvestmentInvitation(RetailStoreInvestmentInvitation investmentInvitation){
		this.mInvestmentInvitation = investmentInvitation;;
	}
	public RetailStoreInvestmentInvitation getInvestmentInvitation(){
		return this.mInvestmentInvitation;
	}
	
	
	public void setFranchising(RetailStoreFranchising franchising){
		this.mFranchising = franchising;;
	}
	public RetailStoreFranchising getFranchising(){
		return this.mFranchising;
	}
	
	
	public void setDecoration(RetailStoreDecoration decoration){
		this.mDecoration = decoration;;
	}
	public RetailStoreDecoration getDecoration(){
		return this.mDecoration;
	}
	
	
	public void setOpening(RetailStoreOpening opening){
		this.mOpening = opening;;
	}
	public RetailStoreOpening getOpening(){
		return this.mOpening;
	}
	
	
	public void setClosing(RetailStoreClosing closing){
		this.mClosing = closing;;
	}
	public RetailStoreClosing getClosing(){
		return this.mClosing;
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	
	
	public void setLatitude(double latitude){
		this.mLatitude = latitude;;
	}
	public double getLatitude(){
		return this.mLatitude;
	}
	
	
	public void setLongitude(double longitude){
		this.mLongitude = longitude;;
	}
	public double getLongitude(){
		return this.mLongitude;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<ConsumerOrder> getConsumerOrderList(){
		if(this.mConsumerOrderList == null){
			this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		}
		return this.mConsumerOrderList;	
	}
	public  void setConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setStore(this);
		}
		
		this.mConsumerOrderList = consumerOrderList;
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setStore(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrders(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setStore(this);
		}
		getConsumerOrderList().addAll(consumerOrderList);
	}
	
	public  void removeConsumerOrder(ConsumerOrder consumerOrder){
	
		boolean result = getConsumerOrderList().planToRemove(consumerOrder);
        if(!result){
        	String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveConsumerOrderList", consumerOrder);
		//the constant "toConsumerOrder" will be replaced after refactoried.
	
	}
	
	public void copyConsumerOrderFrom(ConsumerOrder consumerOrder) {
		// TODO Auto-generated method stub
		
        ConsumerOrder consumerOrderInList = findTheConsumerOrder(consumerOrder);
        ConsumerOrder newConsumerOrder = new ConsumerOrder();
        consumerOrderInList.copyTo(newConsumerOrder);
        newConsumerOrder.setVersion(0);//will trigger copy
        getConsumerOrderList().add(newConsumerOrder);
	}
	
	public  ConsumerOrder findTheConsumerOrder(ConsumerOrder consumerOrder){
		
		int index =  getConsumerOrderList().indexOf(consumerOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getConsumerOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderList(){
		getConsumerOrderList().clear();
	}
	
	
	
	
	public  SmartList<RetailStoreOrder> getRetailStoreOrderList(){
		if(this.mRetailStoreOrderList == null){
			this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
		}
		return this.mRetailStoreOrderList;	
	}
	public  void setRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setBuyer(this);
		}
		
		this.mRetailStoreOrderList = retailStoreOrderList;
		
	}
	
	public  void addRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		retailStoreOrder.setBuyer(this);
		getRetailStoreOrderList().add(retailStoreOrder);
	}
	public  void addRetailStoreOrders(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setBuyer(this);
		}
		getRetailStoreOrderList().addAll(retailStoreOrderList);
	}
	
	public  void removeRetailStoreOrder(RetailStoreOrder retailStoreOrder){
	
		boolean result = getRetailStoreOrderList().planToRemove(retailStoreOrder);
        if(!result){
        	String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreOrderList", retailStoreOrder);
		//the constant "toRetailStoreOrder" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreOrderFrom(RetailStoreOrder retailStoreOrder) {
		// TODO Auto-generated method stub
		
        RetailStoreOrder retailStoreOrderInList = findTheRetailStoreOrder(retailStoreOrder);
        RetailStoreOrder newRetailStoreOrder = new RetailStoreOrder();
        retailStoreOrderInList.copyTo(newRetailStoreOrder);
        newRetailStoreOrder.setVersion(0);//will trigger copy
        getRetailStoreOrderList().add(newRetailStoreOrder);
	}
	
	public  RetailStoreOrder findTheRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		
		int index =  getRetailStoreOrderList().indexOf(retailStoreOrder);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderList(){
		getRetailStoreOrderList().clear();
	}
	
	
	
	
	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
		}
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStore(this);
		}
		
		this.mGoodsList = goodsList;
		
	}
	
	public  void addGoods(Goods goods){
		goods.setRetailStore(this);
		getGoodsList().add(goods);
	}
	public  void addGoodses(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStore(this);
		}
		getGoodsList().addAll(goodsList);
	}
	
	public  void removeGoods(Goods goods){
	
		boolean result = getGoodsList().planToRemove(goods);
        if(!result){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveGoodsList", goods);
		//the constant "toGoods" will be replaced after refactoried.
	
	}
	
	public void copyGoodsFrom(Goods goods) {
		// TODO Auto-generated method stub
		
        Goods goodsInList = findTheGoods(goods);
        Goods newGoods = new Goods();
        goodsInList.copyTo(newGoods);
        newGoods.setVersion(0);//will trigger copy
        getGoodsList().add(newGoods);
	}
	
	public  Goods findTheGoods(Goods goods){
		
		int index =  getGoodsList().indexOf(goods);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getGoodsList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsList(){
		getGoodsList().clear();
	}
	
	
	
	
	public  SmartList<TransportTask> getTransportTaskList(){
		if(this.mTransportTaskList == null){
			this.mTransportTaskList = new SmartList<TransportTask>();
		}
		return this.mTransportTaskList;	
	}
	public  void setTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setEnd(this);
		}
		
		this.mTransportTaskList = transportTaskList;
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setEnd(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTasks(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setEnd(this);
		}
		getTransportTaskList().addAll(transportTaskList);
	}
	
	public  void removeTransportTask(TransportTask transportTask){
	
		boolean result = getTransportTaskList().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveTransportTaskList", transportTask);
		//the constant "toTransportTask" will be replaced after refactoried.
	
	}
	
	public void copyTransportTaskFrom(TransportTask transportTask) {
		// TODO Auto-generated method stub
		
        TransportTask transportTaskInList = findTheTransportTask(transportTask);
        TransportTask newTransportTask = new TransportTask();
        transportTaskInList.copyTo(newTransportTask);
        newTransportTask.setVersion(0);//will trigger copy
        getTransportTaskList().add(newTransportTask);
	}
	
	public  TransportTask findTheTransportTask(TransportTask transportTask){
		
		int index =  getTransportTaskList().indexOf(transportTask);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getTransportTaskList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskList(){
		getTransportTaskList().clear();
	}
	
	
	
	
	public  SmartList<AccountSet> getAccountSetList(){
		if(this.mAccountSetList == null){
			this.mAccountSetList = new SmartList<AccountSet>();
		}
		return this.mAccountSetList;	
	}
	public  void setAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setRetailStore(this);
		}
		
		this.mAccountSetList = accountSetList;
		
	}
	
	public  void addAccountSet(AccountSet accountSet){
		accountSet.setRetailStore(this);
		getAccountSetList().add(accountSet);
	}
	public  void addAccountSets(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setRetailStore(this);
		}
		getAccountSetList().addAll(accountSetList);
	}
	
	public  void removeAccountSet(AccountSet accountSet){
	
		boolean result = getAccountSetList().planToRemove(accountSet);
        if(!result){
        	String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveAccountSetList", accountSet);
		//the constant "toAccountSet" will be replaced after refactoried.
	
	}
	
	public void copyAccountSetFrom(AccountSet accountSet) {
		// TODO Auto-generated method stub
		
        AccountSet accountSetInList = findTheAccountSet(accountSet);
        AccountSet newAccountSet = new AccountSet();
        accountSetInList.copyTo(newAccountSet);
        newAccountSet.setVersion(0);//will trigger copy
        getAccountSetList().add(newAccountSet);
	}
	
	public  AccountSet findTheAccountSet(AccountSet accountSet){
		
		int index =  getAccountSetList().indexOf(accountSet);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getAccountSetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountSetList(){
		getAccountSetList().clear();
	}
	
	
	
	
 	
	
	public RetailStore copyTo(RetailStore dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setTelephone(getTelephone());
		dest.setOwner(getOwner());
		dest.setRetailStoreCountryCenter(getRetailStoreCountryCenter());
		dest.setCityServiceCenter(getCityServiceCenter());
		dest.setCreation(getCreation());
		dest.setInvestmentInvitation(getInvestmentInvitation());
		dest.setFranchising(getFranchising());
		dest.setDecoration(getDecoration());
		dest.setOpening(getOpening());
		dest.setClosing(getClosing());
		dest.setFounded(getFounded());
		dest.setLatitude(getLatitude());
		dest.setLongitude(getLongitude());
		dest.setDescription(getDescription());
		dest.setCurrentStatus(getCurrentStatus());
		dest.setVersion(getVersion());
		dest.setConsumerOrderList(getConsumerOrderList());
		dest.setRetailStoreOrderList(getRetailStoreOrderList());
		dest.setGoodsList(getGoodsList());
		dest.setTransportTaskList(getTransportTaskList());
		dest.setAccountSetList(getAccountSetList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\ttelephone='"+getTelephone()+"';");
		stringBuilder.append("\towner='"+getOwner()+"';");
		if(getRetailStoreCountryCenter() != null ){
 			stringBuilder.append("\tretail_store_country_center='retail_store_country_center("+getRetailStoreCountryCenter().getId()+")';");
 		}
		if(getCityServiceCenter() != null ){
 			stringBuilder.append("\tcity_service_center='retail_store_city_service_center("+getCityServiceCenter().getId()+")';");
 		}
		if(getCreation() != null ){
 			stringBuilder.append("\tcreation='retail_store_creation("+getCreation().getId()+")';");
 		}
		if(getInvestmentInvitation() != null ){
 			stringBuilder.append("\tinvestment_invitation='retail_store_investment_invitation("+getInvestmentInvitation().getId()+")';");
 		}
		if(getFranchising() != null ){
 			stringBuilder.append("\tfranchising='retail_store_franchising("+getFranchising().getId()+")';");
 		}
		if(getDecoration() != null ){
 			stringBuilder.append("\tdecoration='retail_store_decoration("+getDecoration().getId()+")';");
 		}
		if(getOpening() != null ){
 			stringBuilder.append("\topening='retail_store_opening("+getOpening().getId()+")';");
 		}
		if(getClosing() != null ){
 			stringBuilder.append("\tclosing='retail_store_closing("+getClosing().getId()+")';");
 		}
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tcurrent_status='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

