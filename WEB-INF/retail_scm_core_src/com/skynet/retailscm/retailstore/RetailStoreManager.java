
package com.skynet.retailscm.retailstore;

import java.util.Date;
import com.skynet.retailscm.RetailScmUserContext;
public interface RetailStoreManager{

	public RetailStore createRetailStore(RetailScmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, Date founded, double latitude, double longitude, String description
) throws Exception;	
	public RetailStore updateRetailStore(RetailScmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	
	public RetailStore transferToAnotherRetailStoreCountryCenter(RetailScmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId)  throws Exception;
 	public RetailStore transferToAnotherCityServiceCenter(RetailScmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId)  throws Exception;
 	public RetailStore create(RetailScmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore inviteInvestment(RetailScmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore franchise(RetailScmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore decorate(RetailScmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore open(RetailScmUserContext userContext, String retailStoreId, String comment
)  throws Exception;
	public RetailStore close(RetailScmUserContext userContext, String retailStoreId, String comment
)  throws Exception;


	public void delete(RetailScmUserContext userContext, String retailStoreId, int version) throws Exception;
	public int deleteAll(RetailScmUserContext userContext, String secureCode ) throws Exception;
	
	/*======================================================DATA MAINTENANCE===========================================================*/
	
	public  RetailStore addConsumerOrder(RetailScmUserContext userContext, String retailStoreId, String title, String consumerId ,String [] tokensExpr)  throws Exception;
	public  RetailStore removeConsumerOrder(RetailScmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateConsumerOrder(RetailScmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStore addRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, String sellerId, String title, double totalAmount ,String [] tokensExpr)  throws Exception;
	public  RetailStore removeRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateRetailStoreOrder(RetailScmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStore addGoods(RetailScmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId ,String [] tokensExpr)  throws Exception;
	public  RetailStore removeGoods(RetailScmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateGoods(RetailScmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStore addTransportTask(RetailScmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, double latitude, double longitude ,String [] tokensExpr)  throws Exception;
	public  RetailStore removeTransportTask(RetailScmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateTransportTask(RetailScmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	public  RetailStore addAccountSet(RetailScmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId ,String [] tokensExpr)  throws Exception;
	public  RetailStore removeAccountSet(RetailScmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStore updateAccountSet(RetailScmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;




}


