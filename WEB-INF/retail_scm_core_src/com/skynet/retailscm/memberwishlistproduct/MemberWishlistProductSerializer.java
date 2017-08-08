
package com.skynet.retailscm.memberwishlistproduct;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.memberwishlist.MemberWishlist;


public class MemberWishlistProductSerializer extends BaseJsonSerializer<MemberWishlistProduct>{

	

	@Override
	public void serialize(MemberWishlistProduct memberWishlistProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(memberWishlistProduct,jgen,provider);
		
		jgen.writeStringField(MemberWishlistProduct.ID_PROPERTY,memberWishlistProduct.getId());
		jgen.writeStringField(MemberWishlistProduct.NAME_PROPERTY,memberWishlistProduct.getName());
		writeOwner(MemberWishlistProduct.OWNER_PROPERTY,memberWishlistProduct,jgen,provider);
		jgen.writeNumberField(MemberWishlistProduct.VERSION_PROPERTY,memberWishlistProduct.getVersion());
		
		writeEndObject(memberWishlistProduct,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, MemberWishlistProduct memberWishlistProduct, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		MemberWishlist owner = memberWishlistProduct.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(MemberWishlist.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(MemberWishlist.NAME_PROPERTY,owner.getName()); 
		jgen.writeNumberField(MemberWishlist.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	
}


