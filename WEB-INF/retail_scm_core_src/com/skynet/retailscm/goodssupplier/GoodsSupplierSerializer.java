
package com.skynet.retailscm.goodssupplier;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.goodssupplier.GoodsSupplier;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.skynet.retailscm.supplyorder.SupplyOrder;
import com.skynet.retailscm.accountset.AccountSet;
import com.skynet.retailscm.supplierproduct.SupplierProduct;


public class GoodsSupplierSerializer extends BaseJsonSerializer<GoodsSupplier>{

	

	@Override
	public void serialize(GoodsSupplier goodsSupplier, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(goodsSupplier,jgen,provider);
		
		jgen.writeStringField(GoodsSupplier.ID_PROPERTY,goodsSupplier.getId());
		jgen.writeStringField(GoodsSupplier.NAME_PROPERTY,goodsSupplier.getName());
		jgen.writeStringField(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY,goodsSupplier.getSupplyProduct());
		writeBelongTo(GoodsSupplier.BELONG_TO_PROPERTY,goodsSupplier,jgen,provider);
		jgen.writeStringField(GoodsSupplier.CONTACT_NUMBER_PROPERTY,goodsSupplier.getContactNumber());
		jgen.writeStringField(GoodsSupplier.DESCRIPTION_PROPERTY,goodsSupplier.getDescription());
		jgen.writeNumberField(GoodsSupplier.VERSION_PROPERTY,goodsSupplier.getVersion());
		writeSupplierProductList(GoodsSupplier.SUPPLIER_PRODUCT_LIST,goodsSupplier,jgen,provider);
		writeSupplyOrderList(GoodsSupplier.SUPPLY_ORDER_LIST,goodsSupplier,jgen,provider);
		writeAccountSetList(GoodsSupplier.ACCOUNT_SET_LIST,goodsSupplier,jgen,provider);
		
		writeEndObject(goodsSupplier,jgen,provider);
	}
	
	protected void writeBelongTo(String fieldName, GoodsSupplier goodsSupplier, JsonGenerator jgen,SerializerProvider provider) throws IOException,
			JsonProcessingException{
		RetailStoreCountryCenter belongTo = goodsSupplier.getBelongTo();
		
		if(belongTo == null){
			return;
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartObject(); 
		jgen.writeStringField(RetailStoreCountryCenter.ID_PROPERTY,belongTo.getId()); 
		jgen.writeStringField(RetailStoreCountryCenter.NAME_PROPERTY,belongTo.getName()); 
		jgen.writeStringField(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY,belongTo.getServiceNumber()); 
		jgen.writeObjectField(RetailStoreCountryCenter.FOUNDED_PROPERTY,belongTo.getFounded()); 
		jgen.writeStringField(RetailStoreCountryCenter.WEB_SITE_PROPERTY,belongTo.getWebSite()); 
		jgen.writeStringField(RetailStoreCountryCenter.ADDRESS_PROPERTY,belongTo.getAddress()); 
		jgen.writeStringField(RetailStoreCountryCenter.OPERATED_BY_PROPERTY,belongTo.getOperatedBy()); 
		jgen.writeStringField(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY,belongTo.getLegalRepresentative()); 
		jgen.writeStringField(RetailStoreCountryCenter.DESCRIPTION_PROPERTY,belongTo.getDescription()); 
		jgen.writeNumberField(RetailStoreCountryCenter.VERSION_PROPERTY,belongTo.getVersion());
		jgen.writeEndObject();
		
	}
	
	protected void writeSupplierProductList(String fieldName, GoodsSupplier goodsSupplier, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplierProduct> supplierProductList = goodsSupplier.getSupplierProductList();
		
		if(supplierProductList == null){
			return;//do nothing when null found for this field.
		}
		if(supplierProductList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplierProduct supplierProduct: supplierProductList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplierProduct.ID_PROPERTY,supplierProduct.getId());
			jgen.writeStringField(SupplierProduct.PRODUCT_NAME_PROPERTY,supplierProduct.getProductName());
			jgen.writeStringField(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY,supplierProduct.getProductDescription());
			jgen.writeStringField(SupplierProduct.PRODUCT_UNIT_PROPERTY,supplierProduct.getProductUnit());
			jgen.writeNumberField(SupplierProduct.VERSION_PROPERTY,supplierProduct.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeSupplyOrderList(String fieldName, GoodsSupplier goodsSupplier, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<SupplyOrder> supplyOrderList = goodsSupplier.getSupplyOrderList();
		
		if(supplyOrderList == null){
			return;//do nothing when null found for this field.
		}
		if(supplyOrderList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(SupplyOrder supplyOrder: supplyOrderList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(SupplyOrder.ID_PROPERTY,supplyOrder.getId());
			jgen.writeStringField(SupplyOrder.TITLE_PROPERTY,supplyOrder.getTitle());
			jgen.writeNumberField(SupplyOrder.TOTAL_AMOUNT_PROPERTY,supplyOrder.getTotalAmount());
			jgen.writeStringField(SupplyOrder.CURRENT_STATUS_PROPERTY,supplyOrder.getCurrentStatus());
			jgen.writeNumberField(SupplyOrder.VERSION_PROPERTY,supplyOrder.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	protected void writeAccountSetList(String fieldName, GoodsSupplier goodsSupplier, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<AccountSet> accountSetList = goodsSupplier.getAccountSetList();
		
		if(accountSetList == null){
			return;//do nothing when null found for this field.
		}
		if(accountSetList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(AccountSet accountSet: accountSetList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(AccountSet.ID_PROPERTY,accountSet.getId());
			jgen.writeStringField(AccountSet.NAME_PROPERTY,accountSet.getName());
			jgen.writeStringField(AccountSet.YEAR_SET_PROPERTY,accountSet.getYearSet());
			jgen.writeObjectField(AccountSet.EFFECTIVE_DATE_PROPERTY,accountSet.getEffectiveDate());
			jgen.writeStringField(AccountSet.ACCOUNTING_SYSTEM_PROPERTY,accountSet.getAccountingSystem());
			jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY,accountSet.getDomesticCurrencyCode());
			jgen.writeStringField(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY,accountSet.getDomesticCurrencyName());
			jgen.writeStringField(AccountSet.OPENING_BANK_PROPERTY,accountSet.getOpeningBank());
			jgen.writeStringField(AccountSet.ACCOUNT_NUMBER_PROPERTY,accountSet.getAccountNumber());
			jgen.writeNumberField(AccountSet.VERSION_PROPERTY,accountSet.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


