
package com.skynet.retailscm.stockcountissuetrack;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.stockcountissuetrack.StockCountIssueTrack;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goodsshelfstockcount.GoodsShelfStockCount;


public class StockCountIssueTrackSerializer extends BaseJsonSerializer<StockCountIssueTrack>{

	

	@Override
	public void serialize(StockCountIssueTrack stockCountIssueTrack, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(stockCountIssueTrack,jgen,provider);
		
		jgen.writeStringField(StockCountIssueTrack.ID_PROPERTY,stockCountIssueTrack.getId());
		jgen.writeStringField(StockCountIssueTrack.TITLE_PROPERTY,stockCountIssueTrack.getTitle());
		jgen.writeObjectField(StockCountIssueTrack.COUNT_TIME_PROPERTY,stockCountIssueTrack.getCountTime());
		jgen.writeStringField(StockCountIssueTrack.SUMMARY_PROPERTY,stockCountIssueTrack.getSummary());
		writeStockCount(StockCountIssueTrack.STOCK_COUNT_PROPERTY,stockCountIssueTrack,jgen,provider);
		jgen.writeNumberField(StockCountIssueTrack.VERSION_PROPERTY,stockCountIssueTrack.getVersion());
		
		writeEndObject(stockCountIssueTrack,jgen,provider);
	}
	
	protected void writeStockCount(String fieldName, StockCountIssueTrack stockCountIssueTrack, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		GoodsShelfStockCount stockCount = stockCountIssueTrack.getStockCount();
		
		if(stockCount == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(GoodsShelfStockCount.ID_PROPERTY,stockCount.getId()); 
		jgen.writeStringField(GoodsShelfStockCount.TITLE_PROPERTY,stockCount.getTitle()); 
		jgen.writeObjectField(GoodsShelfStockCount.COUNT_TIME_PROPERTY,stockCount.getCountTime()); 
		jgen.writeStringField(GoodsShelfStockCount.SUMMARY_PROPERTY,stockCount.getSummary()); 
		jgen.writeNumberField(GoodsShelfStockCount.VERSION_PROPERTY,stockCount.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


