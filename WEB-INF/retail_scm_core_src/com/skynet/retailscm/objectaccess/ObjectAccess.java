
package com.skynet.retailscm.objectaccess;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.userapp.UserApp;

@JsonSerialize(using = ObjectAccessSerializer.class)
public class ObjectAccess extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String DISPLAY_NAME_PROPERTY          = "displayName"       ;
	public static final String OBJECT_TYPE_PROPERTY           = "objectType"        ;
	public static final String LIST1_PROPERTY                 = "list1"             ;
	public static final String LIST2_PROPERTY                 = "list2"             ;
	public static final String LIST3_PROPERTY                 = "list3"             ;
	public static final String LIST4_PROPERTY                 = "list4"             ;
	public static final String LIST5_PROPERTY                 = "list5"             ;
	public static final String LIST6_PROPERTY                 = "list6"             ;
	public static final String LIST7_PROPERTY                 = "list7"             ;
	public static final String LIST8_PROPERTY                 = "list8"             ;
	public static final String LIST9_PROPERTY                 = "list9"             ;
	public static final String APP_PROPERTY                   = "app"               ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mDisplayName        ;
	protected		String              	mObjectType         ;
	protected		String              	mList1              ;
	protected		String              	mList2              ;
	protected		String              	mList3              ;
	protected		String              	mList4              ;
	protected		String              	mList5              ;
	protected		String              	mList6              ;
	protected		String              	mList7              ;
	protected		String              	mList8              ;
	protected		String              	mList9              ;
	protected		UserApp             	mApp                ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ObjectAccess(){
		//lazy load for all the properties
	}
	
	public 	ObjectAccess(String displayName, String objectType, String list1, String list2, String list3, String list4, String list5, String list6, String list7, String list8, String list9, UserApp app
)
	{
		setDisplayName(displayName);
		setObjectType(objectType);
		setList1(list1);
		setList2(list2);
		setList3(list3);
		setList4(list4);
		setList5(list5);
		setList6(list6);
		setList7(list7);
		setList8(list8);
		setList9(list9);
		setApp(app);
	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(DISPLAY_NAME_PROPERTY.equals(property)){
			changeDisplayNameProperty(newValueExpr);
		}
		if(OBJECT_TYPE_PROPERTY.equals(property)){
			changeObjectTypeProperty(newValueExpr);
		}
		if(LIST1_PROPERTY.equals(property)){
			changeList1Property(newValueExpr);
		}
		if(LIST2_PROPERTY.equals(property)){
			changeList2Property(newValueExpr);
		}
		if(LIST3_PROPERTY.equals(property)){
			changeList3Property(newValueExpr);
		}
		if(LIST4_PROPERTY.equals(property)){
			changeList4Property(newValueExpr);
		}
		if(LIST5_PROPERTY.equals(property)){
			changeList5Property(newValueExpr);
		}
		if(LIST6_PROPERTY.equals(property)){
			changeList6Property(newValueExpr);
		}
		if(LIST7_PROPERTY.equals(property)){
			changeList7Property(newValueExpr);
		}
		if(LIST8_PROPERTY.equals(property)){
			changeList8Property(newValueExpr);
		}
		if(LIST9_PROPERTY.equals(property)){
			changeList9Property(newValueExpr);
		}

      
	}
    
    
	protected void changeDisplayNameProperty(String newValueExpr){
		String oldValue = getDisplayName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setDisplayName(newValue);
		//they are surely different each other
		this.onChangeProperty(DISPLAY_NAME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeObjectTypeProperty(String newValueExpr){
		String oldValue = getObjectType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setObjectType(newValue);
		//they are surely different each other
		this.onChangeProperty(OBJECT_TYPE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList1Property(String newValueExpr){
		String oldValue = getList1();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList1(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST1_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList2Property(String newValueExpr){
		String oldValue = getList2();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList2(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST2_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList3Property(String newValueExpr){
		String oldValue = getList3();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList3(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST3_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList4Property(String newValueExpr){
		String oldValue = getList4();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList4(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST4_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList5Property(String newValueExpr){
		String oldValue = getList5();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList5(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST5_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList6Property(String newValueExpr){
		String oldValue = getList6();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList6(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST6_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList7Property(String newValueExpr){
		String oldValue = getList7();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList7(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST7_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList8Property(String newValueExpr){
		String oldValue = getList8();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList8(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST8_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeList9Property(String newValueExpr){
		String oldValue = getList9();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setList9(newValue);
		//they are surely different each other
		this.onChangeProperty(LIST9_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setDisplayName(String displayName){
		this.mDisplayName = trimString(displayName);;
	}
	public String getDisplayName(){
		return this.mDisplayName;
	}
	
	
	public void setObjectType(String objectType){
		this.mObjectType = trimString(objectType);;
	}
	public String getObjectType(){
		return this.mObjectType;
	}
	
	
	public void setList1(String list1){
		this.mList1 = trimString(list1);;
	}
	public String getList1(){
		return this.mList1;
	}
	
	
	public void setList2(String list2){
		this.mList2 = trimString(list2);;
	}
	public String getList2(){
		return this.mList2;
	}
	
	
	public void setList3(String list3){
		this.mList3 = trimString(list3);;
	}
	public String getList3(){
		return this.mList3;
	}
	
	
	public void setList4(String list4){
		this.mList4 = trimString(list4);;
	}
	public String getList4(){
		return this.mList4;
	}
	
	
	public void setList5(String list5){
		this.mList5 = trimString(list5);;
	}
	public String getList5(){
		return this.mList5;
	}
	
	
	public void setList6(String list6){
		this.mList6 = trimString(list6);;
	}
	public String getList6(){
		return this.mList6;
	}
	
	
	public void setList7(String list7){
		this.mList7 = trimString(list7);;
	}
	public String getList7(){
		return this.mList7;
	}
	
	
	public void setList8(String list8){
		this.mList8 = trimString(list8);;
	}
	public String getList8(){
		return this.mList8;
	}
	
	
	public void setList9(String list9){
		this.mList9 = trimString(list9);;
	}
	public String getList9(){
		return this.mList9;
	}
	
	
	public void setApp(UserApp app){
		this.mApp = app;;
	}
	public UserApp getApp(){
		return this.mApp;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public ObjectAccess copyTo(ObjectAccess dest){

		dest.setId(getId());
		dest.setDisplayName(getDisplayName());
		dest.setObjectType(getObjectType());
		dest.setList1(getList1());
		dest.setList2(getList2());
		dest.setList3(getList3());
		dest.setList4(getList4());
		dest.setList5(getList5());
		dest.setList6(getList6());
		dest.setList7(getList7());
		dest.setList8(getList8());
		dest.setList9(getList9());
		dest.setApp(getApp());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("object_access{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tdisplay_name='"+getDisplayName()+"';");
		stringBuilder.append("\tobject_type='"+getObjectType()+"';");
		stringBuilder.append("\tlist1='"+getList1()+"';");
		stringBuilder.append("\tlist2='"+getList2()+"';");
		stringBuilder.append("\tlist3='"+getList3()+"';");
		stringBuilder.append("\tlist4='"+getList4()+"';");
		stringBuilder.append("\tlist5='"+getList5()+"';");
		stringBuilder.append("\tlist6='"+getList6()+"';");
		stringBuilder.append("\tlist7='"+getList7()+"';");
		stringBuilder.append("\tlist8='"+getList8()+"';");
		stringBuilder.append("\tlist9='"+getList9()+"';");
		if(getApp() != null ){
 			stringBuilder.append("\tapp='user_app("+getApp().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

