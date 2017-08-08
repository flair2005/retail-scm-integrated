
package com.skynet.retailscm.memberwishlist;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.memberwishlist.MemberWishlist;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstoremember.RetailStoreMember;
import com.skynet.retailscm.memberwishlistproduct.MemberWishlistProduct;


public class MemberWishlistSerializer extends BaseJsonSerializer<MemberWishlist>{

	

	@Override
	public void serialize(MemberWishlist memberWishlist, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(memberWishlist,jgen,provider);
		
		jgen.writeStringField(MemberWishlist.ID_PROPERTY,memberWishlist.getId());
		jgen.writeStringField(MemberWishlist.NAME_PROPERTY,memberWishlist.getName());
		writeOwner(MemberWishlist.OWNER_PROPERTY,memberWishlist,jgen,provider);
		jgen.writeNumberField(MemberWishlist.VERSION_PROPERTY,memberWishlist.getVersion());
		writeMemberWishlistProductList(MemberWishlist.MEMBER_WISHLIST_PRODUCT_LIST,memberWishlist,jgen,provider);
		
		writeEndObject(memberWishlist,jgen,provider);
	}
	
	protected void writeOwner(String fieldName, MemberWishlist memberWishlist, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreMember owner = memberWishlist.getOwner();
		
		if(owner == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreMember.ID_PROPERTY,owner.getId()); 
		jgen.writeStringField(RetailStoreMember.NAME_PROPERTY,owner.getName()); 
		jgen.writeStringField(RetailStoreMember.MOBILE_PHONE_PROPERTY,owner.getMobilePhone()); 
		jgen.writeNumberField(RetailStoreMember.VERSION_PROPERTY,owner.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeMemberWishlistProductList(String fieldName, MemberWishlist memberWishlist, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<MemberWishlistProduct> memberWishlistProductList = memberWishlist.getMemberWishlistProductList();
		
		if(memberWishlistProductList == null){
			return;//do nothing when null found for this field.
		}
		if(memberWishlistProductList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(MemberWishlistProduct memberWishlistProduct: memberWishlistProductList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(MemberWishlistProduct.ID_PROPERTY,memberWishlistProduct.getId());
			jgen.writeStringField(MemberWishlistProduct.NAME_PROPERTY,memberWishlistProduct.getName());
			jgen.writeNumberField(MemberWishlistProduct.VERSION_PROPERTY,memberWishlistProduct.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


