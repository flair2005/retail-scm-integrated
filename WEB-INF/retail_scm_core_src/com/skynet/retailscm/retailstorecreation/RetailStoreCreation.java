
package com.skynet.retailscm.retailstorecreation;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.retailstore.RetailStore;

@JsonSerialize(using = RetailStoreCreationSerializer.class)
public class RetailStoreCreation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_LIST                        = "retailStoreList"   ;




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mComment            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStore>	mRetailStoreList    ;
	
		
	public 	RetailStoreCreation(){
		//lazy load for all the properties
	}
	
	public 	RetailStoreCreation(String comment
)
	{
		setComment(comment);

		this.mRetailStoreList = new SmartList<RetailStore>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCommentProperty(String newValueExpr){
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setComment(newValue);
		//they are surely different each other
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<RetailStore> getRetailStoreList(){
		if(this.mRetailStoreList == null){
			this.mRetailStoreList = new SmartList<RetailStore>();
		}
		return this.mRetailStoreList;	
	}
	public  void setRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setCreation(this);
		}
		
		this.mRetailStoreList = retailStoreList;
		
	}
	
	public  void addRetailStore(RetailStore retailStore){
		retailStore.setCreation(this);
		getRetailStoreList().add(retailStore);
	}
	public  void addRetailStores(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setCreation(this);
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
	
	
	
	
 	
	
	public RetailStoreCreation copyTo(RetailStoreCreation dest){

		dest.setId(getId());
		dest.setComment(getComment());
		dest.setVersion(getVersion());
		dest.setRetailStoreList(getRetailStoreList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("retail_store_creation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcomment='"+getComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

