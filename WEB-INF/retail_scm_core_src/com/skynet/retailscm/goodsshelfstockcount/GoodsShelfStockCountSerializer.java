
package com.skynet.retailscm.goodsshelfstockcount;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goodsshelf.GoodsShelf;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrack;


public class GoodsShelfStockCountSerializer extends BaseJsonSerializer<GoodsShelfStockCount>{

	

	@Override
	public void serialize(GoodsShelfStockCount goodsShelfStockCount, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(goodsShelfStockCount,jgen,provider);
		
		jgen.writeStringField(GoodsShelfStockCount.ID_PROPERTY,goodsShelfStockCount.getId());
		jgen.writeStringField(GoodsShelfStockCount.TITLE_PROPERTY,goodsShelfStockCount.getTitle());
		jgen.writeObjectField(GoodsShelfStockCount.COUNT_TIME_PROPERTY,goodsShelfStockCount.getCountTime());
		jgen.writeStringField(GoodsShelfStockCount.SUMMARY_PROPERTY,goodsShelfStockCount.getSummary());
		writeShelf(GoodsShelfStockCount.SHELF_PROPERTY,goodsShelfStockCount,jgen,provider);
		jgen.writeNumberField(GoodsShelfStockCount.VERSION_PROPERTY,goodsShelfStockCount.getVersion());
		writeStockCountIssueTrackList(GoodsShelfStockCount.STOCK_COUNT_ISSUE_TRACK_LIST,goodsShelfStockCount,jgen,provider);
		
		writeEndObject(goodsShelfStockCount,jgen,provider);
	}
	
	protected void writeShelf(String fieldName, GoodsShelfStockCount goodsShelfStockCount, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsShelf shelf = goodsShelfStockCount.getShelf();
		
		if(shelf == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsShelf.ID_PROPERTY,shelf.getId()); 
		jgen.writeStringField(GoodsShelf.LOCATION_PROPERTY,shelf.getLocation()); 
		jgen.writeNumberField(GoodsShelf.VERSION_PROPERTY,shelf.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeStockCountIssueTrackList(String fieldName, GoodsShelfStockCount goodsShelfStockCount, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<StockCountIssueTrack> stockCountIssueTrackList = goodsShelfStockCount.getStockCountIssueTrackList();
		
		if(stockCountIssueTrackList == null){
			return;//do nothing when null found for this field.
		}
		if(stockCountIssueTrackList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(StockCountIssueTrack stockCountIssueTrack: stockCountIssueTrackList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(StockCountIssueTrack.ID_PROPERTY,stockCountIssueTrack.getId());
			jgen.writeStringField(StockCountIssueTrack.TITLE_PROPERTY,stockCountIssueTrack.getTitle());
			jgen.writeObjectField(StockCountIssueTrack.COUNT_TIME_PROPERTY,stockCountIssueTrack.getCountTime());
			jgen.writeStringField(StockCountIssueTrack.SUMMARY_PROPERTY,stockCountIssueTrack.getSummary());
			jgen.writeNumberField(StockCountIssueTrack.VERSION_PROPERTY,stockCountIssueTrack.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


