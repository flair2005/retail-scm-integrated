
package com.skynet.retailscm.goodsshelfstockcount;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goodsshelf.GoodsShelf;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrack;

@JsonSerialize(using = GoodsShelfStockCountSerializer.class)
public class GoodsShelfStockCount extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String COUNT_TIME_PROPERTY            = "countTime"         ;
	public static final String SUMMARY_PROPERTY               = "summary"           ;
	public static final String SHELF_PROPERTY                 = "shelf"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String STOCK_COUNT_ISSUE_TRACK_LIST             = "stockCountIssueTrackList";




	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		Date                	mCountTime          ;
	protected		String              	mSummary            ;
	protected		GoodsShelf          	mShelf              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<StockCountIssueTrack>	mStockCountIssueTrackList;
	
		
	public 	GoodsShelfStockCount(){
		//lazy load for all the properties
	}
	
	public 	GoodsShelfStockCount(String title, Date countTime, String summary, GoodsShelf shelf
)
	{
		setTitle(title);
		setCountTime(countTime);
		setSummary(summary);
		setShelf(shelf);

		this.mStockCountIssueTrackList = new SmartList<StockCountIssueTrack>();	
	}
	
	//Support for changing the property
	
	public void changePropery(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(COUNT_TIME_PROPERTY.equals(property)){
			changeCountTimeProperty(newValueExpr);
		}
		if(SUMMARY_PROPERTY.equals(property)){
			changeSummaryProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setTitle(newValue);
		//they are surely different each other
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeCountTimeProperty(String newValueExpr){
		Date oldValue = getCountTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setCountTime(newValue);
		//they are surely different each other
		this.onChangeProperty(COUNT_TIME_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			
	protected void changeSummaryProperty(String newValueExpr){
		String oldValue = getSummary();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
        
 		setSummary(newValue);
		//they are surely different each other
		this.onChangeProperty(SUMMARY_PROPERTY, oldValue, newValue);
		return;
             
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	
	
	public void setCountTime(Date countTime){
		this.mCountTime = countTime;;
	}
	public Date getCountTime(){
		return this.mCountTime;
	}
	
	
	public void setSummary(String summary){
		this.mSummary = trimString(summary);;
	}
	public String getSummary(){
		return this.mSummary;
	}
	
	
	public void setShelf(GoodsShelf shelf){
		this.mShelf = shelf;;
	}
	public GoodsShelf getShelf(){
		return this.mShelf;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
	public  SmartList<StockCountIssueTrack> getStockCountIssueTrackList(){
		if(this.mStockCountIssueTrackList == null){
			this.mStockCountIssueTrackList = new SmartList<StockCountIssueTrack>();
		}
		return this.mStockCountIssueTrackList;	
	}
	public  void setStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList){
		for( StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			stockCountIssueTrack.setStockCount(this);
		}
		
		this.mStockCountIssueTrackList = stockCountIssueTrackList;
		
	}
	
	public  void addStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){
		stockCountIssueTrack.setStockCount(this);
		getStockCountIssueTrackList().add(stockCountIssueTrack);
	}
	public  void addStockCountIssueTracks(SmartList<StockCountIssueTrack> stockCountIssueTrackList){
		for( StockCountIssueTrack stockCountIssueTrack:stockCountIssueTrackList){
			stockCountIssueTrack.setStockCount(this);
		}
		getStockCountIssueTrackList().addAll(stockCountIssueTrackList);
	}
	
	public  void removeStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){
	
		boolean result = getStockCountIssueTrackList().planToRemove(stockCountIssueTrack);
        if(!result){
        	String message = "StockCountIssueTrack("+stockCountIssueTrack.getId()+") with version='"+stockCountIssueTrack.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	//this.addItemToFlexibleList("toRemoveStockCountIssueTrackList", stockCountIssueTrack);
		//the constant "toStockCountIssueTrack" will be replaced after refactoried.
	
	}
	
	public void copyStockCountIssueTrackFrom(StockCountIssueTrack stockCountIssueTrack) {
		// TODO Auto-generated method stub
		
        StockCountIssueTrack stockCountIssueTrackInList = findTheStockCountIssueTrack(stockCountIssueTrack);
        StockCountIssueTrack newStockCountIssueTrack = new StockCountIssueTrack();
        stockCountIssueTrackInList.copyTo(newStockCountIssueTrack);
        newStockCountIssueTrack.setVersion(0);//will trigger copy
        getStockCountIssueTrackList().add(newStockCountIssueTrack);
	}
	
	public  StockCountIssueTrack findTheStockCountIssueTrack(StockCountIssueTrack stockCountIssueTrack){
		
		int index =  getStockCountIssueTrackList().indexOf(stockCountIssueTrack);
		//The input parameter must have the same id and version number.
        if(index < 0){
        	String message = "StockCountIssueTrack("+stockCountIssueTrack.getId()+") with version='"+stockCountIssueTrack.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
	
       	return  getStockCountIssueTrackList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpStockCountIssueTrackList(){
		getStockCountIssueTrackList().clear();
	}
	
	
	
	
 	
	
	public GoodsShelfStockCount copyTo(GoodsShelfStockCount dest){

		dest.setId(getId());
		dest.setTitle(getTitle());
		dest.setCountTime(getCountTime());
		dest.setSummary(getSummary());
		dest.setShelf(getShelf());
		dest.setVersion(getVersion());
		dest.setStockCountIssueTrackList(getStockCountIssueTrackList());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("goods_shelf_stock_count{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tcount_time='"+getCountTime()+"';");
		stringBuilder.append("\tsummary='"+getSummary()+"';");
		if(getShelf() != null ){
 			stringBuilder.append("\tshelf='goods_shelf("+getShelf().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

