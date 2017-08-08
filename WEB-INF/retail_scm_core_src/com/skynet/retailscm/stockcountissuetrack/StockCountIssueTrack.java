
package com.skynet.retailscm.stockcountissuetrack;


import java.util.Date;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

@JsonSerialize(using = StockCountIssueTrackSerializer.class)
public class StockCountIssueTrack extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String COUNT_TIME_PROPERTY            = "countTime"         ;
	public static final String SUMMARY_PROPERTY               = "summary"           ;
	public static final String STOCK_COUNT_PROPERTY           = "stockCount"        ;
	public static final String VERSION_PROPERTY               = "version"           ;





	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		Date                	mCountTime          ;
	protected		String              	mSummary            ;
	protected		GoodsShelfStockCount	mStockCount         ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	StockCountIssueTrack(){
		//lazy load for all the properties
	}
	
	public 	StockCountIssueTrack(String title, Date countTime, String summary, GoodsShelfStockCount stockCount
)
	{
		setTitle(title);
		setCountTime(countTime);
		setSummary(summary);
		setStockCount(stockCount);
	
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
	
	
	public void setStockCount(GoodsShelfStockCount stockCount){
		this.mStockCount = stockCount;;
	}
	public GoodsShelfStockCount getStockCount(){
		return this.mStockCount;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	
	
 	
	
	public StockCountIssueTrack copyTo(StockCountIssueTrack dest){

		dest.setId(getId());
		dest.setTitle(getTitle());
		dest.setCountTime(getCountTime());
		dest.setSummary(getSummary());
		dest.setStockCount(getStockCount());
		dest.setVersion(getVersion());

		return dest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("stock_count_issue_track{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tcount_time='"+getCountTime()+"';");
		stringBuilder.append("\tsummary='"+getSummary()+"';");
		if(getStockCount() != null ){
 			stringBuilder.append("\tstock_count='goods_shelf_stock_count("+getStockCount().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	
	
	
}

