
package com.skynet.retailscm.goodsmovement;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goods.Goods;

@JsonSerialize(using = GoodsMovementSerializer.class)
public class GoodsMovement extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String MOVE_TIME_PROPERTY             = "moveTime"          ;
	public static final String FACILITY_PROPERTY              = "facility"          ;
	public static final String FACILITY_ID_PROPERTY           = "facilityId"        ;
	public static final String FROM_IP_PROPERTY               = "fromIp"            ;
	public static final String USER_AGENT_PROPERTY            = "userAgent"         ;
	public static final String SESSION_ID_PROPERTY            = "sessionId"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String GOODS_PROPERTY                 = "goods"             ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Date                	mMoveTime           ;
	protected		String              	mFacility           ;
	protected		String              	mFacilityId         ;
	protected		String              	mFromIp             ;
	protected		String              	mUserAgent          ;
	protected		String              	mSessionId          ;
	protected		double              	mLatitude           ;
	protected		double              	mLongitude          ;
	protected		Goods               	mGoods              ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	GoodsMovement(){
		//lazy load for all the properties
	}
	
	public 	GoodsMovement(Date moveTime, String facility, String facilityId, String fromIp, String userAgent, String sessionId, double latitude, double longitude, Goods goods
)
	{
		setMoveTime(moveTime);
		setFacility(facility);
		setFacilityId(facilityId);
		setFromIp(fromIp);
		setUserAgent(userAgent);
		setSessionId(sessionId);
		setLatitude(latitude);
		setLongitude(longitude);
		setGoods(goods);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(MOVE_TIME_PROPERTY.equals(property)){
			changeMoveTimeProperty(newValueExpr);
		}
		if(FACILITY_PROPERTY.equals(property)){
			changeFacilityProperty(newValueExpr);
		}
		if(FACILITY_ID_PROPERTY.equals(property)){
			changeFacilityIdProperty(newValueExpr);
		}
		if(FROM_IP_PROPERTY.equals(property)){
			changeFromIpProperty(newValueExpr);
		}
		if(USER_AGENT_PROPERTY.equals(property)){
			changeUserAgentProperty(newValueExpr);
		}
		if(SESSION_ID_PROPERTY.equals(property)){
			changeSessionIdProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeMoveTimeProperty(String newValueExpr){
		Date oldValue = getMoveTime();
		Date newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setMoveTime(newValue);
		//they are surely different each other
		this.onChangeProperty(MOVE_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFacilityProperty(String newValueExpr){
		String oldValue = getFacility();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFacility(newValue);
		//they are surely different each other
		this.onChangeProperty(FACILITY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFacilityIdProperty(String newValueExpr){
		String oldValue = getFacilityId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFacilityId(newValue);
		//they are surely different each other
		this.onChangeProperty(FACILITY_ID_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeFromIpProperty(String newValueExpr){
		String oldValue = getFromIp();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setFromIp(newValue);
		//they are surely different each other
		this.onChangeProperty(FROM_IP_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeUserAgentProperty(String newValueExpr){
		String oldValue = getUserAgent();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setUserAgent(newValue);
		//they are surely different each other
		this.onChangeProperty(USER_AGENT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeSessionIdProperty(String newValueExpr){
		String oldValue = getSessionId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSessionId(newValue);
		//they are surely different each other
		this.onChangeProperty(SESSION_ID_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setMoveTime(Date moveTime){
		this.mMoveTime = moveTime;;
	}
	public Date getMoveTime(){
		return this.mMoveTime;
	}
	
	
	public void setFacility(String facility){
		this.mFacility = trimString(facility);;
	}
	public String getFacility(){
		return this.mFacility;
	}
	
	
	public void setFacilityId(String facilityId){
		this.mFacilityId = trimString(facilityId);;
	}
	public String getFacilityId(){
		return this.mFacilityId;
	}
	
	
	public void setFromIp(String fromIp){
		this.mFromIp = trimString(fromIp);;
	}
	public String getFromIp(){
		return this.mFromIp;
	}
	
	
	public void setUserAgent(String userAgent){
		this.mUserAgent = trimString(userAgent);;
	}
	public String getUserAgent(){
		return this.mUserAgent;
	}
	
	
	public void setSessionId(String sessionId){
		this.mSessionId = trimString(sessionId);;
	}
	public String getSessionId(){
		return this.mSessionId;
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
	
	
	public void setGoods(Goods goods){
		this.mGoods = goods;;
	}
	public Goods getGoods(){
		return this.mGoods;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public GoodsMovement copyTo(GoodsMovement dest){

		dest.setId(getId());
		dest.setMoveTime(getMoveTime());
		dest.setFacility(getFacility());
		dest.setFacilityId(getFacilityId());
		dest.setFromIp(getFromIp());
		dest.setUserAgent(getUserAgent());
		dest.setSessionId(getSessionId());
		dest.setLatitude(getLatitude());
		dest.setLongitude(getLongitude());
		dest.setGoods(getGoods());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("goods_movement{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tmove_time='"+getMoveTime()+"';");
		stringBuilder.append("\tfacility='"+getFacility()+"';");
		stringBuilder.append("\tfacility_id='"+getFacilityId()+"';");
		stringBuilder.append("\tfrom_ip='"+getFromIp()+"';");
		stringBuilder.append("\tuser_agent='"+getUserAgent()+"';");
		stringBuilder.append("\tsession_id='"+getSessionId()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		if(getGoods() != null ){
 			stringBuilder.append("\tgoods='goods("+getGoods().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

