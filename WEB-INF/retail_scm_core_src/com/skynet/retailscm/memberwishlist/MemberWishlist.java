
package com.skynet.retailscm.memberwishlist;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProduct;

@JsonSerialize(using = MemberWishlistSerializer.class)
public class MemberWishlist extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String MEMBER_WISHLIST_PRODUCT_LIST             = "memberWishlistProductList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		RetailStoreMember   	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<MemberWishlistProduct>	mMemberWishlistProductList;
	
		
	public 	MemberWishlist(){
		//lazy load for all the properties
	}
	
	public 	MemberWishlist(String name, RetailStoreMember owner
)
	{
		setName(name);
		setOwner(owner);

		this.mMemberWishlistProductList = new SmartList<MemberWishlistProduct>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
	
	
	public void setOwner(RetailStoreMember owner){
		this.mOwner = owner;;
	}
	public RetailStoreMember getOwner(){
		return this.mOwner;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<MemberWishlistProduct> getMemberWishlistProductList(){
		if(this.mMemberWishlistProductList == null){
			this.mMemberWishlistProductList = new SmartList<MemberWishlistProduct>();
		}
		return this.mMemberWishlistProductList;	
	}
	public  void setMemberWishlistProductList(SmartList<MemberWishlistProduct> memberWishlistProductList){
		for( MemberWishlistProduct memberWishlistProduct:memberWishlistProductList){
			memberWishlistProduct.setOwner(this);
		}
		
		this.mMemberWishlistProductList = memberWishlistProductList;
		
	}
	
	public  void addMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
		memberWishlistProduct.setOwner(this);
		getMemberWishlistProductList().add(memberWishlistProduct);
	}
	public  void addMemberWishlistProducts(SmartList<MemberWishlistProduct> memberWishlistProductList){
		for( MemberWishlistProduct memberWishlistProduct:memberWishlistProductList){
			memberWishlistProduct.setOwner(this);
		}
		getMemberWishlistProductList().addAll(memberWishlistProductList);
	}
	
	public  void removeMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
	
		boolean result = getMemberWishlistProductList().planToRemove(memberWishlistProduct);
        if(!result){
        	String message = "MemberWishlistProduct("+memberWishlistProduct.getId()+") with version='"+memberWishlistProduct.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveMemberWishlistProductList", memberWishlistProduct);
		//the constant "toMemberWishlistProduct" will be replaced after refactoried.
	
	}
	
	public void copyMemberWishlistProductFrom(MemberWishlistProduct memberWishlistProduct) {
		// TODO Auto-generated method stub
		
        MemberWishlistProduct memberWishlistProductInList = findTheMemberWishlistProduct(memberWishlistProduct);
        MemberWishlistProduct newMemberWishlistProduct = new MemberWishlistProduct();
        memberWishlistProductInList.copyTo(newMemberWishlistProduct);
        newMemberWishlistProduct.setVersion(0);//will trigger copy
        getMemberWishlistProductList().add(newMemberWishlistProduct);
	}
	
	public  MemberWishlistProduct findTheMemberWishlistProduct(MemberWishlistProduct memberWishlistProduct){
		
		int index =  getMemberWishlistProductList().indexOf(memberWishlistProduct);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "MemberWishlistProduct("+memberWishlistProduct.getId()+") with version='"+memberWishlistProduct.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getMemberWishlistProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberWishlistProductList(){
		getMemberWishlistProductList().clear();
	}
	
	
	
	
 	
	
	public MemberWishlist copyTo(MemberWishlist dest){

		dest.setId(getId());
		dest.setName(getName());
		dest.setOwner(getOwner());
		dest.setVersion(getVersion());
		dest.setMemberWishlistProductList(getMemberWishlistProductList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("member_wishlist{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='retail_store_member("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

