
package com.skynet.retailscm.goodsmovement;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.goodsmovement.GoodsMovement;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.goods.Goods;


public class GoodsMovementSerializer extends BaseJsonSerializer<GoodsMovement>{

	

	@Override
	public void serialize(GoodsMovement goodsMovement, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(goodsMovement,jgen,provider);
		
		jgen.writeStringField(GoodsMovement.ID_PROPERTY,goodsMovement.getId());
		jgen.writeObjectField(GoodsMovement.MOVE_TIME_PROPERTY,goodsMovement.getMoveTime());
		jgen.writeStringField(GoodsMovement.FACILITY_PROPERTY,goodsMovement.getFacility());
		jgen.writeStringField(GoodsMovement.FACILITY_ID_PROPERTY,goodsMovement.getFacilityId());
		jgen.writeStringField(GoodsMovement.FROM_IP_PROPERTY,goodsMovement.getFromIp());
		jgen.writeStringField(GoodsMovement.USER_AGENT_PROPERTY,goodsMovement.getUserAgent());
		jgen.writeStringField(GoodsMovement.SESSION_ID_PROPERTY,goodsMovement.getSessionId());
		jgen.writeNumberField(GoodsMovement.LATITUDE_PROPERTY,goodsMovement.getLatitude());
		jgen.writeNumberField(GoodsMovement.LONGITUDE_PROPERTY,goodsMovement.getLongitude());
		writeGoods(GoodsMovement.GOODS_PROPERTY,goodsMovement,jgen,provider);
		jgen.writeNumberField(GoodsMovement.VERSION_PROPERTY,goodsMovement.getVersion());
		
		writeEndObject(goodsMovement,jgen,provider);
	}
	
	protected void writeGoods(String fieldName, GoodsMovement goodsMovement, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		Goods goods = goodsMovement.getGoods();
		
		if(goods == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(Goods.ID_PROPERTY,goods.getId()); 
		jgen.writeStringField(Goods.NAME_PROPERTY,goods.getName()); 
		jgen.writeStringField(Goods.RFID_PROPERTY,goods.getRfid()); 
		jgen.writeStringField(Goods.UOM_PROPERTY,goods.getUom()); 
		jgen.writeNumberField(Goods.MAX_PACKAGE_PROPERTY,goods.getMaxPackage()); 
		jgen.writeObjectField(Goods.EXPIRE_TIME_PROPERTY,goods.getExpireTime()); 
		jgen.writeStringField(Goods.CURRENT_STATUS_PROPERTY,goods.getCurrentStatus()); 
		jgen.writeNumberField(Goods.VERSION_PROPERTY,goods.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


