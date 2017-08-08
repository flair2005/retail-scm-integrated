
package com.skynet.retailscm.retailstorecityservicecenter;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.cityevent.CityEvent;
import com.skynet.retailscm.retailstore.RetailStore;
import com.skynet.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.skynet.retailscm.potentialcustomer.PotentialCustomer;
import com.skynet.retailscm.citypartner.CityPartner;

@JsonSerialize(using = RetailStoreCityServiceCenterSerializer.class)
public class RetailStoreCityServiceCenter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CITY_PARTNER_LIST                        = "cityPartnerList"   ;
	public static final String POTENTIAL_CUSTOMER_LIST                  = "potentialCustomerList";
	public static final String CITY_EVENT_LIST                          = "cityEventList"     ;
	public static final String RETAIL_STORE_LIST                        = "retailStoreList"   ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		Date                	mFounded            ;
	protected		RetailStoreProvinceCenter	mBelongsTo          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CityPartner>	mCityPartnerList    ;
	protected		SmartList<PotentialCustomer>	mPotentialCustomerList;
	protected		SmartList<CityEvent>	mCityEventList      ;
	protected		SmartList<RetailStore>	mRetailStoreList    ;
	
		
	public 	RetailStoreCityServiceCenter(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreCityServiceCenter(String name, Date founded, RetailStoreProvinceCenter belongsTo
)
	{
		setName(name);
		setFounded(founded);
		setBelongsTo(belongsTo);

		this.mCityPartnerList = new SmartList<CityPartner>();
		this.mPotentialCustomerList = new SmartList<PotentialCustomer>();
		this.mCityEventList = new SmartList<CityEvent>();
		this.mRetailStoreList = new SmartList<RetailStore>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	
	
	public void setBelongsTo(RetailStoreProvinceCenter belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public RetailStoreProvinceCenter getBelongsTo(){
		return this.mBelongsTo;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<CityPartner> getCityPartnerList(){
		if(this.mCityPartnerList == null){
			this.mCityPartnerList = new SmartList<CityPartner>();
		}
		return this.mCityPartnerList;	
	}
	public  void setCityPartnerList(SmartList<CityPartner> cityPartnerList){
		for( CityPartner cityPartner:cityPartnerList){
			cityPartner.setCityServiceCenter(this);
		}
		
		this.mCityPartnerList = cityPartnerList;
		
	}
	
	public  void addCityPartner(CityPartner cityPartner){
		cityPartner.setCityServiceCenter(this);
		getCityPartnerList().add(cityPartner);
	}
	public  void addCityPartners(SmartList<CityPartner> cityPartnerList){
		for( CityPartner cityPartner:cityPartnerList){
			cityPartner.setCityServiceCenter(this);
		}
		getCityPartnerList().addAll(cityPartnerList);
	}
	
	public  void removeCityPartner(CityPartner cityPartner){
	
		boolean result = getCityPartnerList().planToRemove(cityPartner);
        if(!result){
        	String message = "CityPartner("+cityPartner.getId()+") with version='"+cityPartner.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveCityPartnerList", cityPartner);
		//the constant "toCityPartner" will be replaced after refactoried.
	
	}
	
	public void copyCityPartnerFrom(CityPartner cityPartner) {
		// TODO Auto-generated method stub
		
        CityPartner cityPartnerInList = findTheCityPartner(cityPartner);
        CityPartner newCityPartner = new CityPartner();
        cityPartnerInList.copyTo(newCityPartner);
        newCityPartner.setVersion(0);//will trigger copy
        getCityPartnerList().add(newCityPartner);
	}
	
	public  CityPartner findTheCityPartner(CityPartner cityPartner){
		
		int index =  getCityPartnerList().indexOf(cityPartner);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "CityPartner("+cityPartner.getId()+") with version='"+cityPartner.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getCityPartnerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCityPartnerList(){
		getCityPartnerList().clear();
	}
	
	
	
	
	public  SmartList<PotentialCustomer> getPotentialCustomerList(){
		if(this.mPotentialCustomerList == null){
			this.mPotentialCustomerList = new SmartList<PotentialCustomer>();
		}
		return this.mPotentialCustomerList;	
	}
	public  void setPotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList){
		for( PotentialCustomer potentialCustomer:potentialCustomerList){
			potentialCustomer.setCityServiceCenter(this);
		}
		
		this.mPotentialCustomerList = potentialCustomerList;
		
	}
	
	public  void addPotentialCustomer(PotentialCustomer potentialCustomer){
		potentialCustomer.setCityServiceCenter(this);
		getPotentialCustomerList().add(potentialCustomer);
	}
	public  void addPotentialCustomers(SmartList<PotentialCustomer> potentialCustomerList){
		for( PotentialCustomer potentialCustomer:potentialCustomerList){
			potentialCustomer.setCityServiceCenter(this);
		}
		getPotentialCustomerList().addAll(potentialCustomerList);
	}
	
	public  void removePotentialCustomer(PotentialCustomer potentialCustomer){
	
		boolean result = getPotentialCustomerList().planToRemove(potentialCustomer);
        if(!result){
        	String message = "PotentialCustomer("+potentialCustomer.getId()+") with version='"+potentialCustomer.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemovePotentialCustomerList", potentialCustomer);
		//the constant "toPotentialCustomer" will be replaced after refactoried.
	
	}
	
	public void copyPotentialCustomerFrom(PotentialCustomer potentialCustomer) {
		// TODO Auto-generated method stub
		
        PotentialCustomer potentialCustomerInList = findThePotentialCustomer(potentialCustomer);
        PotentialCustomer newPotentialCustomer = new PotentialCustomer();
        potentialCustomerInList.copyTo(newPotentialCustomer);
        newPotentialCustomer.setVersion(0);//will trigger copy
        getPotentialCustomerList().add(newPotentialCustomer);
	}
	
	public  PotentialCustomer findThePotentialCustomer(PotentialCustomer potentialCustomer){
		
		int index =  getPotentialCustomerList().indexOf(potentialCustomer);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "PotentialCustomer("+potentialCustomer.getId()+") with version='"+potentialCustomer.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getPotentialCustomerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPotentialCustomerList(){
		getPotentialCustomerList().clear();
	}
	
	
	
	
	public  SmartList<CityEvent> getCityEventList(){
		if(this.mCityEventList == null){
			this.mCityEventList = new SmartList<CityEvent>();
		}
		return this.mCityEventList;	
	}
	public  void setCityEventList(SmartList<CityEvent> cityEventList){
		for( CityEvent cityEvent:cityEventList){
			cityEvent.setCityServiceCenter(this);
		}
		
		this.mCityEventList = cityEventList;
		
	}
	
	public  void addCityEvent(CityEvent cityEvent){
		cityEvent.setCityServiceCenter(this);
		getCityEventList().add(cityEvent);
	}
	public  void addCityEvents(SmartList<CityEvent> cityEventList){
		for( CityEvent cityEvent:cityEventList){
			cityEvent.setCityServiceCenter(this);
		}
		getCityEventList().addAll(cityEventList);
	}
	
	public  void removeCityEvent(CityEvent cityEvent){
	
		boolean result = getCityEventList().planToRemove(cityEvent);
        if(!result){
        	String message = "CityEvent("+cityEvent.getId()+") with version='"+cityEvent.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveCityEventList", cityEvent);
		//the constant "toCityEvent" will be replaced after refactoried.
	
	}
	
	public void copyCityEventFrom(CityEvent cityEvent) {
		// TODO Auto-generated method stub
		
        CityEvent cityEventInList = findTheCityEvent(cityEvent);
        CityEvent newCityEvent = new CityEvent();
        cityEventInList.copyTo(newCityEvent);
        newCityEvent.setVersion(0);//will trigger copy
        getCityEventList().add(newCityEvent);
	}
	
	public  CityEvent findTheCityEvent(CityEvent cityEvent){
		
		int index =  getCityEventList().indexOf(cityEvent);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "CityEvent("+cityEvent.getId()+") with version='"+cityEvent.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getCityEventList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCityEventList(){
		getCityEventList().clear();
	}
	
	
	
	
	public  SmartList<RetailStore> getRetailStoreList(){
		if(this.mRetailStoreList == null){
			this.mRetailStoreList = new SmartList<RetailStore>();
		}
		return this.mRetailStoreList;	
	}
	public  void setRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setCityServiceCenter(this);
		}
		
		this.mRetailStoreList = retailStoreList;
		
	}
	
	public  void addRetailStore(RetailStore retailStore){
		retailStore.setCityServiceCenter(this);
		getRetailStoreList().add(retailStore);
	}
	public  void addRetailStores(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setCityServiceCenter(this);
		}
		getRetailStoreList().addAll(retailStoreList);
	}
	
	public  void removeRetailStore(RetailStore retailStore){
	
		boolean result = getRetailStoreList().planToRemove(retailStore);
        if(!result){
        	String message = "RetailStore("+retailStore.getId()+") with version='"+retailStore.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveRetailStoreList", retailStore);
		//the constant "toRetailStore" will be replaced after refactoried.
	
	}
	
	public void copyRetailStoreFrom(RetailStore retailStore) {
		// TODO Auto-generated method stub
		
        RetailStore retailStoreInList = findTheRetailStore(retailStore);
        RetailStore newRetailStore = new RetailStore();
        retailStoreInList.copyTo(newRetailStore);
        newRetailStore.setVersion(0);//will trigger copy
        getRetailStoreList().add(newRetailStore);
	}
	
	public  RetailStore findTheRetailStore(RetailStore retailStore){
		
		int index =  getRetailStoreList().indexOf(retailStore);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "RetailStore("+retailStore.getId()+") with version='"+retailStore.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getRetailStoreList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreList(){
		getRetailStoreList().clear();
	}
	
	
	
	
 	
	
	public RetailStoreCityServiceCenter copyTo(RetailStoreCityServiceCenter dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setFounded(getFounded());
		dest.setBelongsTo(getBelongsTo());
		dest.setVersion(getVersion());
		dest.setCityPartnerList(getCityPartnerList());
		dest.setPotentialCustomerList(getPotentialCustomerList());
		dest.setCityEventList(getCityEventList());
		dest.setRetailStoreList(getRetailStoreList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_city_service_center{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongs_to='retail_store_province_center("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

