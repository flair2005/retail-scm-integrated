package com.skynet.retailscm;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;

public class RetailScmCheckerManager extends BaseManagerImpl {
	
	 		
	public static final String  ID_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.id";
	
	protected void checkIdOfRetailStoreCountryCenter(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreCountryCenter(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.name";
	
	protected void checkNameOfRetailStoreCountryCenter(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreCountryCenter(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 44, NAME_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.service_number";
	
	protected void checkServiceNumberOfRetailStoreCountryCenter(RetailScmUserContext userContext, String serviceNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkServiceNumberOfRetailStoreCountryCenter(userContext, serviceNumber, exception);
			return;
		}
	 	checkStringLengthRange(serviceNumber, 3, 36, SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.founded";
	
	protected void checkFoundedOfRetailStoreCountryCenter(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfRetailStoreCountryCenter(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.web_site";
	
	protected void checkWebSiteOfRetailStoreCountryCenter(RetailScmUserContext userContext, String webSite, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWebSiteOfRetailStoreCountryCenter(userContext, webSite, exception);
			return;
		}
	 	checkUrl(webSite, 11, 88, WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.address";
	
	protected void checkAddressOfRetailStoreCountryCenter(RetailScmUserContext userContext, String address, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAddressOfRetailStoreCountryCenter(userContext, address, exception);
			return;
		}
	 	checkStringLengthRange(address, 4, 52, ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.operated_by";
	
	protected void checkOperatedByOfRetailStoreCountryCenter(RetailScmUserContext userContext, String operatedBy, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkOperatedByOfRetailStoreCountryCenter(userContext, operatedBy, exception);
			return;
		}
	 	checkStringLengthRange(operatedBy, 2, 16, OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.legal_representative";
	
	protected void checkLegalRepresentativeOfRetailStoreCountryCenter(RetailScmUserContext userContext, String legalRepresentative, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLegalRepresentativeOfRetailStoreCountryCenter(userContext, legalRepresentative, exception);
			return;
		}
	 	checkStringLengthRange(legalRepresentative, 1, 12, LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.description";
	
	protected void checkDescriptionOfRetailStoreCountryCenter(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfRetailStoreCountryCenter(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 4, 52, DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.version";
	
	protected void checkVersionOfRetailStoreCountryCenter(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreCountryCenter(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_COUNTRY_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_REPORT ="report.id";
	
	protected void checkIdOfReport(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfReport(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_REPORT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_REPORT ="report.name";
	
	protected void checkNameOfReport(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfReport(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 28, NAME_OF_REPORT,exception); 		
	}
	 		
	 			 		
	public static final String  CREATED_BY_OF_REPORT ="report.created_by";
	
	protected void checkCreatedByOfReport(RetailScmUserContext userContext, String createdBy, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCreatedByOfReport(userContext, createdBy, exception);
			return;
		}
	 	checkStringLengthRange(createdBy, 5, 68, CREATED_BY_OF_REPORT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_REPORT ="report.version";
	
	protected void checkVersionOfReport(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfReport(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_REPORT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_REPORT_LINE ="report_line.id";
	
	protected void checkIdOfReportLine(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfReportLine(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_REPORT_LINE ="report_line.name";
	
	protected void checkNameOfReportLine(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfReportLine(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 20, NAME_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  JANUARY_OF_REPORT_LINE ="report_line.january";
	
	protected void checkJanuaryOfReportLine(RetailScmUserContext userContext, double january, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkJanuaryOfReportLine(userContext, january, exception);
			return;
		}
	 	checkMoneyAmount(january, 0.00, 123198823.88, JANUARY_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  FEBRUARY_OF_REPORT_LINE ="report_line.february";
	
	protected void checkFebruaryOfReportLine(RetailScmUserContext userContext, double february, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFebruaryOfReportLine(userContext, february, exception);
			return;
		}
	 	checkMoneyAmount(february, 0.00, 133198823.88, FEBRUARY_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  MARCH_OF_REPORT_LINE ="report_line.march";
	
	protected void checkMarchOfReportLine(RetailScmUserContext userContext, double march, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMarchOfReportLine(userContext, march, exception);
			return;
		}
	 	checkMoneyAmount(march, 0.00, 13198823.88, MARCH_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  APRIL_OF_REPORT_LINE ="report_line.april";
	
	protected void checkAprilOfReportLine(RetailScmUserContext userContext, double april, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAprilOfReportLine(userContext, april, exception);
			return;
		}
	 	checkMoneyAmount(april, 0.00, 13198823.88, APRIL_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  MAY_OF_REPORT_LINE ="report_line.may";
	
	protected void checkMayOfReportLine(RetailScmUserContext userContext, double may, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMayOfReportLine(userContext, may, exception);
			return;
		}
	 	checkMoneyAmount(may, 0.00, 123198823.88, MAY_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  JUNE_OF_REPORT_LINE ="report_line.june";
	
	protected void checkJuneOfReportLine(RetailScmUserContext userContext, double june, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkJuneOfReportLine(userContext, june, exception);
			return;
		}
	 	checkMoneyAmount(june, 0.00, 123198823.88, JUNE_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  JULY_OF_REPORT_LINE ="report_line.july";
	
	protected void checkJulyOfReportLine(RetailScmUserContext userContext, double july, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkJulyOfReportLine(userContext, july, exception);
			return;
		}
	 	checkMoneyAmount(july, 0.00, 123198823.88, JULY_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  AUGUST_OF_REPORT_LINE ="report_line.august";
	
	protected void checkAugustOfReportLine(RetailScmUserContext userContext, double august, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAugustOfReportLine(userContext, august, exception);
			return;
		}
	 	checkMoneyAmount(august, 0.00, 123198823.88, AUGUST_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  SEPTEMBER_OF_REPORT_LINE ="report_line.september";
	
	protected void checkSeptemberOfReportLine(RetailScmUserContext userContext, double september, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSeptemberOfReportLine(userContext, september, exception);
			return;
		}
	 	checkMoneyAmount(september, 0.00, 123198823.88, SEPTEMBER_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  OCTOBER_OF_REPORT_LINE ="report_line.october";
	
	protected void checkOctoberOfReportLine(RetailScmUserContext userContext, double october, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkOctoberOfReportLine(userContext, october, exception);
			return;
		}
	 	checkMoneyAmount(october, 0.00, 123198823.88, OCTOBER_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  NOVEMBER_OF_REPORT_LINE ="report_line.november";
	
	protected void checkNovemberOfReportLine(RetailScmUserContext userContext, double november, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNovemberOfReportLine(userContext, november, exception);
			return;
		}
	 	checkMoneyAmount(november, 0.00, 123198823.88, NOVEMBER_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  DECEMBER_OF_REPORT_LINE ="report_line.december";
	
	protected void checkDecemberOfReportLine(RetailScmUserContext userContext, double december, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDecemberOfReportLine(userContext, december, exception);
			return;
		}
	 	checkMoneyAmount(december, 0.00, 123198823.88, DECEMBER_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_REPORT_LINE ="report_line.version";
	
	protected void checkVersionOfReportLine(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfReportLine(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_REPORT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CATALOG ="catalog.id";
	
	protected void checkIdOfCatalog(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfCatalog(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CATALOG,exception); 		
	}
	 		
	 			 		
	public static final String  DISPLAY_NAME_OF_CATALOG ="catalog.display_name";
	
	protected void checkDisplayNameOfCatalog(RetailScmUserContext userContext, String displayName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDisplayNameOfCatalog(userContext, displayName, exception);
			return;
		}
	 	checkStringLengthRange(displayName, 2, 16, DISPLAY_NAME_OF_CATALOG,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CATALOG ="catalog.version";
	
	protected void checkVersionOfCatalog(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfCatalog(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CATALOG,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	
	protected void checkIdOfLevelOneCategory(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfLevelOneCategory(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_LEVEL_ONE_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  DISPLAY_NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.display_name";
	
	protected void checkDisplayNameOfLevelOneCategory(RetailScmUserContext userContext, String displayName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDisplayNameOfLevelOneCategory(userContext, displayName, exception);
			return;
		}
	 	checkStringLengthRange(displayName, 2, 16, DISPLAY_NAME_OF_LEVEL_ONE_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	
	protected void checkVersionOfLevelOneCategory(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfLevelOneCategory(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LEVEL_ONE_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	
	protected void checkIdOfLevelTwoCategory(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfLevelTwoCategory(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_LEVEL_TWO_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  DISPLAY_NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.display_name";
	
	protected void checkDisplayNameOfLevelTwoCategory(RetailScmUserContext userContext, String displayName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDisplayNameOfLevelTwoCategory(userContext, displayName, exception);
			return;
		}
	 	checkStringLengthRange(displayName, 2, 16, DISPLAY_NAME_OF_LEVEL_TWO_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	
	protected void checkVersionOfLevelTwoCategory(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfLevelTwoCategory(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LEVEL_TWO_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_LEVEL_THREE_CATEGORY ="level_three_category.id";
	
	protected void checkIdOfLevelThreeCategory(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfLevelThreeCategory(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_LEVEL_THREE_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  DISPLAY_NAME_OF_LEVEL_THREE_CATEGORY ="level_three_category.display_name";
	
	protected void checkDisplayNameOfLevelThreeCategory(RetailScmUserContext userContext, String displayName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDisplayNameOfLevelThreeCategory(userContext, displayName, exception);
			return;
		}
	 	checkStringLengthRange(displayName, 2, 16, DISPLAY_NAME_OF_LEVEL_THREE_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_LEVEL_THREE_CATEGORY ="level_three_category.version";
	
	protected void checkVersionOfLevelThreeCategory(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfLevelThreeCategory(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LEVEL_THREE_CATEGORY,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_PRODUCT ="product.id";
	
	protected void checkIdOfProduct(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfProduct(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  DISPLAY_NAME_OF_PRODUCT ="product.display_name";
	
	protected void checkDisplayNameOfProduct(RetailScmUserContext userContext, String displayName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDisplayNameOfProduct(userContext, displayName, exception);
			return;
		}
	 	checkStringLengthRange(displayName, 1, 12, DISPLAY_NAME_OF_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	
	protected void checkOriginOfProduct(RetailScmUserContext userContext, String origin, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkOriginOfProduct(userContext, origin, exception);
			return;
		}
	 	checkStringLengthRange(origin, 1, 8, ORIGIN_OF_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  REMARK_OF_PRODUCT ="product.remark";
	
	protected void checkRemarkOfProduct(RetailScmUserContext userContext, String remark, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemarkOfProduct(userContext, remark, exception);
			return;
		}
	 	checkStringLengthRange(remark, 6, 88, REMARK_OF_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  BRAND_OF_PRODUCT ="product.brand";
	
	protected void checkBrandOfProduct(RetailScmUserContext userContext, String brand, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBrandOfProduct(userContext, brand, exception);
			return;
		}
	 	checkStringLengthRange(brand, 6, 92, BRAND_OF_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  PICTURE_OF_PRODUCT ="product.picture";
	
	protected void checkPictureOfProduct(RetailScmUserContext userContext, String picture, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPictureOfProduct(userContext, picture, exception);
			return;
		}
	 	checkStringLengthRange(picture, 7, 108, PICTURE_OF_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_PRODUCT ="product.version";
	
	protected void checkVersionOfProduct(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfProduct(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SKU ="sku.id";
	
	protected void checkIdOfSku(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSku(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  DISPLAY_NAME_OF_SKU ="sku.display_name";
	
	protected void checkDisplayNameOfSku(RetailScmUserContext userContext, String displayName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDisplayNameOfSku(userContext, displayName, exception);
			return;
		}
	 	checkStringLengthRange(displayName, 2, 24, DISPLAY_NAME_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  SIZE_OF_SKU ="sku.size";
	
	protected void checkSizeOfSku(RetailScmUserContext userContext, String size, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSizeOfSku(userContext, size, exception);
			return;
		}
	 	checkStringLengthRange(size, 1, 4, SIZE_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  BARCODE_OF_SKU ="sku.barcode";
	
	protected void checkBarcodeOfSku(RetailScmUserContext userContext, String barcode, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBarcodeOfSku(userContext, barcode, exception);
			return;
		}
	 	checkStringLengthRange(barcode, 4, 52, BARCODE_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  PACKAGE_TYPE_OF_SKU ="sku.package_type";
	
	protected void checkPackageTypeOfSku(RetailScmUserContext userContext, String packageType, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPackageTypeOfSku(userContext, packageType, exception);
			return;
		}
	 	checkStringLengthRange(packageType, 2, 16, PACKAGE_TYPE_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  NET_CONTENT_OF_SKU ="sku.net_content";
	
	protected void checkNetContentOfSku(RetailScmUserContext userContext, String netContent, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNetContentOfSku(userContext, netContent, exception);
			return;
		}
	 	checkStringLengthRange(netContent, 6, 92, NET_CONTENT_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  PRICE_OF_SKU ="sku.price";
	
	protected void checkPriceOfSku(RetailScmUserContext userContext, double price, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPriceOfSku(userContext, price, exception);
			return;
		}
	 	checkMoneyAmount(price, 0.00, 1323.33, PRICE_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  PICTURE_OF_SKU ="sku.picture";
	
	protected void checkPictureOfSku(RetailScmUserContext userContext, String picture, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPictureOfSku(userContext, picture, exception);
			return;
		}
	 	checkStringLengthRange(picture, 9, 128, PICTURE_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SKU ="sku.version";
	
	protected void checkVersionOfSku(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSku(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SKU,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.id";
	
	protected void checkIdOfRetailStoreProvinceCenter(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreProvinceCenter(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_PROVINCE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.name";
	
	protected void checkNameOfRetailStoreProvinceCenter(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreProvinceCenter(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 44, NAME_OF_RETAIL_STORE_PROVINCE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.founded";
	
	protected void checkFoundedOfRetailStoreProvinceCenter(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfRetailStoreProvinceCenter(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.version";
	
	protected void checkVersionOfRetailStoreProvinceCenter(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreProvinceCenter(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_PROVINCE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.id";
	
	protected void checkIdOfProvinceCenterDepartment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfProvinceCenterDepartment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_PROVINCE_CENTER_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.name";
	
	protected void checkNameOfProvinceCenterDepartment(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfProvinceCenterDepartment(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 20, NAME_OF_PROVINCE_CENTER_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.founded";
	
	protected void checkFoundedOfProvinceCenterDepartment(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfProvinceCenterDepartment(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  MANAGER_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.manager";
	
	protected void checkManagerOfProvinceCenterDepartment(RetailScmUserContext userContext, String manager, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkManagerOfProvinceCenterDepartment(userContext, manager, exception);
			return;
		}
	 	checkStringLengthRange(manager, 1, 12, MANAGER_OF_PROVINCE_CENTER_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.version";
	
	protected void checkVersionOfProvinceCenterDepartment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfProvinceCenterDepartment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PROVINCE_CENTER_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.id";
	
	protected void checkIdOfProvinceCenterEmployee(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfProvinceCenterEmployee(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_PROVINCE_CENTER_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.name";
	
	protected void checkNameOfProvinceCenterEmployee(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfProvinceCenterEmployee(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_PROVINCE_CENTER_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.mobile";
	
	protected void checkMobileOfProvinceCenterEmployee(RetailScmUserContext userContext, String mobile, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobileOfProvinceCenterEmployee(userContext, mobile, exception);
			return;
		}
	 	checkChinaMobilePhone(mobile, 5, 44, MOBILE_OF_PROVINCE_CENTER_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  EMAIL_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.email";
	
	protected void checkEmailOfProvinceCenterEmployee(RetailScmUserContext userContext, String email, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEmailOfProvinceCenterEmployee(userContext, email, exception);
			return;
		}
	 	checkEmail(email, 19, 80, EMAIL_OF_PROVINCE_CENTER_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.founded";
	
	protected void checkFoundedOfProvinceCenterEmployee(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfProvinceCenterEmployee(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.version";
	
	protected void checkVersionOfProvinceCenterEmployee(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfProvinceCenterEmployee(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PROVINCE_CENTER_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.id";
	
	protected void checkIdOfRetailStoreCityServiceCenter(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreCityServiceCenter(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.name";
	
	protected void checkNameOfRetailStoreCityServiceCenter(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreCityServiceCenter(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 36, NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.founded";
	
	protected void checkFoundedOfRetailStoreCityServiceCenter(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfRetailStoreCityServiceCenter(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.version";
	
	protected void checkVersionOfRetailStoreCityServiceCenter(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreCityServiceCenter(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CITY_PARTNER ="city_partner.id";
	
	protected void checkIdOfCityPartner(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfCityPartner(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CITY_PARTNER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_CITY_PARTNER ="city_partner.name";
	
	protected void checkNameOfCityPartner(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfCityPartner(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_CITY_PARTNER,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_OF_CITY_PARTNER ="city_partner.mobile";
	
	protected void checkMobileOfCityPartner(RetailScmUserContext userContext, String mobile, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobileOfCityPartner(userContext, mobile, exception);
			return;
		}
	 	checkChinaMobilePhone(mobile, 5, 44, MOBILE_OF_CITY_PARTNER,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_CITY_PARTNER ="city_partner.description";
	
	protected void checkDescriptionOfCityPartner(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfCityPartner(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 5, 64, DESCRIPTION_OF_CITY_PARTNER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CITY_PARTNER ="city_partner.version";
	
	protected void checkVersionOfCityPartner(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfCityPartner(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CITY_PARTNER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_POTENTIAL_CUSTOMER ="potential_customer.id";
	
	protected void checkIdOfPotentialCustomer(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfPotentialCustomer(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_POTENTIAL_CUSTOMER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_POTENTIAL_CUSTOMER ="potential_customer.name";
	
	protected void checkNameOfPotentialCustomer(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfPotentialCustomer(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_POTENTIAL_CUSTOMER,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER ="potential_customer.mobile";
	
	protected void checkMobileOfPotentialCustomer(RetailScmUserContext userContext, String mobile, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobileOfPotentialCustomer(userContext, mobile, exception);
			return;
		}
	 	checkChinaMobilePhone(mobile, 5, 44, MOBILE_OF_POTENTIAL_CUSTOMER,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER ="potential_customer.description";
	
	protected void checkDescriptionOfPotentialCustomer(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfPotentialCustomer(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 5, 64, DESCRIPTION_OF_POTENTIAL_CUSTOMER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_POTENTIAL_CUSTOMER ="potential_customer.version";
	
	protected void checkVersionOfPotentialCustomer(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfPotentialCustomer(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_POTENTIAL_CUSTOMER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.id";
	
	protected void checkIdOfPotentialCustomerContactPerson(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfPotentialCustomerContactPerson(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.name";
	
	protected void checkNameOfPotentialCustomerContactPerson(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfPotentialCustomerContactPerson(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.mobile";
	
	protected void checkMobileOfPotentialCustomerContactPerson(RetailScmUserContext userContext, String mobile, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobileOfPotentialCustomerContactPerson(userContext, mobile, exception);
			return;
		}
	 	checkChinaMobilePhone(mobile, 5, 44, MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.description";
	
	protected void checkDescriptionOfPotentialCustomerContactPerson(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfPotentialCustomerContactPerson(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 7, 96, DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.version";
	
	protected void checkVersionOfPotentialCustomerContactPerson(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfPotentialCustomerContactPerson(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.id";
	
	protected void checkIdOfPotentialCustomerContact(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfPotentialCustomerContact(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_POTENTIAL_CUSTOMER_CONTACT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.name";
	
	protected void checkNameOfPotentialCustomerContact(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfPotentialCustomerContact(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 40, NAME_OF_POTENTIAL_CUSTOMER_CONTACT,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_date";
	
	protected void checkContactDateOfPotentialCustomerContact(RetailScmUserContext userContext, Date contactDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactDateOfPotentialCustomerContact(userContext, contactDate, exception);
			return;
		}
	 	checkDateRange(contactDate, parseDate("2000-01-01"), parseDate("2016-09-09"), CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_method";
	
	protected void checkContactMethodOfPotentialCustomerContact(RetailScmUserContext userContext, String contactMethod, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactMethodOfPotentialCustomerContact(userContext, contactMethod, exception);
			return;
		}
	 	checkStringLengthRange(contactMethod, 2, 16, CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.description";
	
	protected void checkDescriptionOfPotentialCustomerContact(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfPotentialCustomerContact(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 2, 24, DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.version";
	
	protected void checkVersionOfPotentialCustomerContact(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfPotentialCustomerContact(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_POTENTIAL_CUSTOMER_CONTACT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CITY_EVENT ="city_event.id";
	
	protected void checkIdOfCityEvent(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfCityEvent(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CITY_EVENT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_CITY_EVENT ="city_event.name";
	
	protected void checkNameOfCityEvent(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfCityEvent(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 28, NAME_OF_CITY_EVENT,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_OF_CITY_EVENT ="city_event.mobile";
	
	protected void checkMobileOfCityEvent(RetailScmUserContext userContext, String mobile, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobileOfCityEvent(userContext, mobile, exception);
			return;
		}
	 	checkChinaMobilePhone(mobile, 5, 44, MOBILE_OF_CITY_EVENT,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_CITY_EVENT ="city_event.description";
	
	protected void checkDescriptionOfCityEvent(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfCityEvent(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 4, 48, DESCRIPTION_OF_CITY_EVENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CITY_EVENT ="city_event.version";
	
	protected void checkVersionOfCityEvent(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfCityEvent(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CITY_EVENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EVENT_ATTENDANCE ="event_attendance.id";
	
	protected void checkIdOfEventAttendance(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEventAttendance(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EVENT_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_EVENT_ATTENDANCE ="event_attendance.name";
	
	protected void checkNameOfEventAttendance(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfEventAttendance(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 36, NAME_OF_EVENT_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_EVENT_ATTENDANCE ="event_attendance.description";
	
	protected void checkDescriptionOfEventAttendance(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfEventAttendance(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 3, 36, DESCRIPTION_OF_EVENT_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EVENT_ATTENDANCE ="event_attendance.version";
	
	protected void checkVersionOfEventAttendance(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEventAttendance(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EVENT_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE ="retail_store.id";
	
	protected void checkIdOfRetailStore(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStore(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE ="retail_store.name";
	
	protected void checkNameOfRetailStore(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStore(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 24, NAME_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  TELEPHONE_OF_RETAIL_STORE ="retail_store.telephone";
	
	protected void checkTelephoneOfRetailStore(RetailScmUserContext userContext, String telephone, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTelephoneOfRetailStore(userContext, telephone, exception);
			return;
		}
	 	checkStringLengthRange(telephone, 3, 44, TELEPHONE_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  OWNER_OF_RETAIL_STORE ="retail_store.owner";
	
	protected void checkOwnerOfRetailStore(RetailScmUserContext userContext, String owner, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkOwnerOfRetailStore(userContext, owner, exception);
			return;
		}
	 	checkStringLengthRange(owner, 1, 8, OWNER_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_RETAIL_STORE ="retail_store.founded";
	
	protected void checkFoundedOfRetailStore(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfRetailStore(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_RETAIL_STORE ="retail_store.latitude";
	
	protected void checkLatitudeOfRetailStore(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfRetailStore(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_RETAIL_STORE ="retail_store.longitude";
	
	protected void checkLongitudeOfRetailStore(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfRetailStore(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_RETAIL_STORE ="retail_store.description";
	
	protected void checkDescriptionOfRetailStore(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfRetailStore(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 6, 84, DESCRIPTION_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_RETAIL_STORE ="retail_store.current_status";
	
	protected void checkCurrentStatusOfRetailStore(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfRetailStore(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 5, 72, CURRENT_STATUS_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE ="retail_store.version";
	
	protected void checkVersionOfRetailStore(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStore(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_CREATION ="retail_store_creation.id";
	
	protected void checkIdOfRetailStoreCreation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreCreation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_RETAIL_STORE_CREATION ="retail_store_creation.comment";
	
	protected void checkCommentOfRetailStoreCreation(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfRetailStoreCreation(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 2, 20, COMMENT_OF_RETAIL_STORE_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_CREATION ="retail_store_creation.version";
	
	protected void checkVersionOfRetailStoreCreation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreCreation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.id";
	
	protected void checkIdOfRetailStoreInvestmentInvitation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreInvestmentInvitation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_INVESTMENT_INVITATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.comment";
	
	protected void checkCommentOfRetailStoreInvestmentInvitation(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfRetailStoreInvestmentInvitation(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 2, 24, COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.version";
	
	protected void checkVersionOfRetailStoreInvestmentInvitation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreInvestmentInvitation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.id";
	
	protected void checkIdOfRetailStoreFranchising(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreFranchising(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_FRANCHISING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.comment";
	
	protected void checkCommentOfRetailStoreFranchising(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfRetailStoreFranchising(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 2, 16, COMMENT_OF_RETAIL_STORE_FRANCHISING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.version";
	
	protected void checkVersionOfRetailStoreFranchising(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreFranchising(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_FRANCHISING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.id";
	
	protected void checkIdOfRetailStoreDecoration(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreDecoration(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_DECORATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.comment";
	
	protected void checkCommentOfRetailStoreDecoration(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfRetailStoreDecoration(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 1, 8, COMMENT_OF_RETAIL_STORE_DECORATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.version";
	
	protected void checkVersionOfRetailStoreDecoration(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreDecoration(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_DECORATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_OPENING ="retail_store_opening.id";
	
	protected void checkIdOfRetailStoreOpening(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOpening(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_OPENING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_RETAIL_STORE_OPENING ="retail_store_opening.comment";
	
	protected void checkCommentOfRetailStoreOpening(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfRetailStoreOpening(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 1, 8, COMMENT_OF_RETAIL_STORE_OPENING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_OPENING ="retail_store_opening.version";
	
	protected void checkVersionOfRetailStoreOpening(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOpening(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_OPENING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_CLOSING ="retail_store_closing.id";
	
	protected void checkIdOfRetailStoreClosing(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreClosing(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_CLOSING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_RETAIL_STORE_CLOSING ="retail_store_closing.comment";
	
	protected void checkCommentOfRetailStoreClosing(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfRetailStoreClosing(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 1, 8, COMMENT_OF_RETAIL_STORE_CLOSING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_CLOSING ="retail_store_closing.version";
	
	protected void checkVersionOfRetailStoreClosing(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreClosing(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_CLOSING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_MEMBER ="retail_store_member.id";
	
	protected void checkIdOfRetailStoreMember(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreMember(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_MEMBER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_MEMBER ="retail_store_member.name";
	
	protected void checkNameOfRetailStoreMember(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreMember(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_RETAIL_STORE_MEMBER,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER ="retail_store_member.mobile_phone";
	
	protected void checkMobilePhoneOfRetailStoreMember(RetailScmUserContext userContext, String mobilePhone, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobilePhoneOfRetailStoreMember(userContext, mobilePhone, exception);
			return;
		}
	 	checkChinaMobilePhone(mobilePhone, 5, 44, MOBILE_PHONE_OF_RETAIL_STORE_MEMBER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER ="retail_store_member.version";
	
	protected void checkVersionOfRetailStoreMember(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreMember(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_MEMBER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER ="consumer_order.id";
	
	protected void checkIdOfConsumerOrder(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrder(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_CONSUMER_ORDER ="consumer_order.title";
	
	protected void checkTitleOfConsumerOrder(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfConsumerOrder(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 2, 16, TITLE_OF_CONSUMER_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_CONSUMER_ORDER ="consumer_order.current_status";
	
	protected void checkCurrentStatusOfConsumerOrder(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfConsumerOrder(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 3, 36, CURRENT_STATUS_OF_CONSUMER_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER ="consumer_order.version";
	
	protected void checkVersionOfConsumerOrder(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrder(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.id";
	
	protected void checkIdOfConsumerOrderConfirmation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderConfirmation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.who";
	
	protected void checkWhoOfConsumerOrderConfirmation(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfConsumerOrderConfirmation(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_CONSUMER_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.confirm_time";
	
	protected void checkConfirmTimeOfConsumerOrderConfirmation(RetailScmUserContext userContext, Date confirmTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkConfirmTimeOfConsumerOrderConfirmation(userContext, confirmTime, exception);
			return;
		}
	 	checkDateRange(confirmTime, parseDate("2000-01-01"), parseDate("2018-07-09"), CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.version";
	
	protected void checkVersionOfConsumerOrderConfirmation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderConfirmation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.id";
	
	protected void checkIdOfConsumerOrderApproval(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderApproval(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.who";
	
	protected void checkWhoOfConsumerOrderApproval(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfConsumerOrderApproval(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_CONSUMER_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.approve_time";
	
	protected void checkApproveTimeOfConsumerOrderApproval(RetailScmUserContext userContext, Date approveTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkApproveTimeOfConsumerOrderApproval(userContext, approveTime, exception);
			return;
		}
	 	checkDateRange(approveTime, parseDate("2000-01-01"), parseDate("2018-07-09"), APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.version";
	
	protected void checkVersionOfConsumerOrderApproval(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderApproval(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.id";
	
	protected void checkIdOfConsumerOrderProcessing(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderProcessing(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.who";
	
	protected void checkWhoOfConsumerOrderProcessing(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfConsumerOrderProcessing(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_CONSUMER_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.process_time";
	
	protected void checkProcessTimeOfConsumerOrderProcessing(RetailScmUserContext userContext, Date processTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProcessTimeOfConsumerOrderProcessing(userContext, processTime, exception);
			return;
		}
	 	checkDateRange(processTime, parseDate("2000-01-01"), parseDate("2018-07-09"), PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.version";
	
	protected void checkVersionOfConsumerOrderProcessing(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderProcessing(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.id";
	
	protected void checkIdOfConsumerOrderShipment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderShipment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.who";
	
	protected void checkWhoOfConsumerOrderShipment(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfConsumerOrderShipment(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_CONSUMER_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.ship_time";
	
	protected void checkShipTimeOfConsumerOrderShipment(RetailScmUserContext userContext, Date shipTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkShipTimeOfConsumerOrderShipment(userContext, shipTime, exception);
			return;
		}
	 	checkDateRange(shipTime, parseDate("2000-01-01"), parseDate("2018-07-09"), SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.version";
	
	protected void checkVersionOfConsumerOrderShipment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderShipment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.id";
	
	protected void checkIdOfConsumerOrderDelivery(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderDelivery(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.who";
	
	protected void checkWhoOfConsumerOrderDelivery(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfConsumerOrderDelivery(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_CONSUMER_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.delivery_time";
	
	protected void checkDeliveryTimeOfConsumerOrderDelivery(RetailScmUserContext userContext, Date deliveryTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDeliveryTimeOfConsumerOrderDelivery(userContext, deliveryTime, exception);
			return;
		}
	 	checkDateRange(deliveryTime, parseDate("2000-01-01"), parseDate("2018-07-09"), DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.version";
	
	protected void checkVersionOfConsumerOrderDelivery(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderDelivery(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.id";
	
	protected void checkIdOfConsumerOrderLineItem(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderLineItem(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_id";
	
	protected void checkSkuIdOfConsumerOrderLineItem(RetailScmUserContext userContext, String skuId, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSkuIdOfConsumerOrderLineItem(userContext, skuId, exception);
			return;
		}
	 	checkStringLengthRange(skuId, 1, 12, SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_name";
	
	protected void checkSkuNameOfConsumerOrderLineItem(RetailScmUserContext userContext, String skuName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSkuNameOfConsumerOrderLineItem(userContext, skuName, exception);
			return;
		}
	 	checkStringLengthRange(skuName, 2, 16, SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  PRICE_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.price";
	
	protected void checkPriceOfConsumerOrderLineItem(RetailScmUserContext userContext, double price, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPriceOfConsumerOrderLineItem(userContext, price, exception);
			return;
		}
	 	checkMoneyAmount(price, 0.00, 5.97, PRICE_OF_CONSUMER_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.quantity";
	
	protected void checkQuantityOfConsumerOrderLineItem(RetailScmUserContext userContext, double quantity, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkQuantityOfConsumerOrderLineItem(userContext, quantity, exception);
			return;
		}
	 	checkDoubleRange(quantity, 0, 1000.00, QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.amount";
	
	protected void checkAmountOfConsumerOrderLineItem(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfConsumerOrderLineItem(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 9999.99, AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.version";
	
	protected void checkVersionOfConsumerOrderLineItem(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderLineItem(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.id";
	
	protected void checkIdOfConsumerOrderShippingGroup(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderShippingGroup(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.name";
	
	protected void checkNameOfConsumerOrderShippingGroup(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfConsumerOrderShippingGroup(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 24, NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.amount";
	
	protected void checkAmountOfConsumerOrderShippingGroup(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfConsumerOrderShippingGroup(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 599.99, AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.version";
	
	protected void checkVersionOfConsumerOrderShippingGroup(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderShippingGroup(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.id";
	
	protected void checkIdOfConsumerOrderPaymentGroup(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderPaymentGroup(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.name";
	
	protected void checkNameOfConsumerOrderPaymentGroup(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfConsumerOrderPaymentGroup(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.card_number";
	
	protected void checkCardNumberOfConsumerOrderPaymentGroup(RetailScmUserContext userContext, String cardNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCardNumberOfConsumerOrderPaymentGroup(userContext, cardNumber, exception);
			return;
		}
	 	checkStringLengthRange(cardNumber, 5, 68, CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.version";
	
	protected void checkVersionOfConsumerOrderPaymentGroup(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderPaymentGroup(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.id";
	
	protected void checkIdOfConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfConsumerOrderPriceAdjustment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.name";
	
	protected void checkNameOfConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfConsumerOrderPriceAdjustment(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.amount";
	
	protected void checkAmountOfConsumerOrderPriceAdjustment(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfConsumerOrderPriceAdjustment(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 599.99, AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.provider";
	
	protected void checkProviderOfConsumerOrderPriceAdjustment(RetailScmUserContext userContext, String provider, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProviderOfConsumerOrderPriceAdjustment(userContext, provider, exception);
			return;
		}
	 	checkStringLengthRange(provider, 2, 16, PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.version";
	
	protected void checkVersionOfConsumerOrderPriceAdjustment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfConsumerOrderPriceAdjustment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.id";
	
	protected void checkIdOfRetailStoreMemberCoupon(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreMemberCoupon(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_MEMBER_COUPON,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.name";
	
	protected void checkNameOfRetailStoreMemberCoupon(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreMemberCoupon(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_RETAIL_STORE_MEMBER_COUPON,exception); 		
	}
	 		
	 			 		
	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.number";
	
	protected void checkNumberOfRetailStoreMemberCoupon(RetailScmUserContext userContext, String number, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNumberOfRetailStoreMemberCoupon(userContext, number, exception);
			return;
		}
	 	checkStringLengthRange(number, 2, 28, NUMBER_OF_RETAIL_STORE_MEMBER_COUPON,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.version";
	
	protected void checkVersionOfRetailStoreMemberCoupon(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreMemberCoupon(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_MEMBER_COUPON,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_MEMBER_WISHLIST ="member_wishlist.id";
	
	protected void checkIdOfMemberWishlist(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfMemberWishlist(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_MEMBER_WISHLIST,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_MEMBER_WISHLIST ="member_wishlist.name";
	
	protected void checkNameOfMemberWishlist(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfMemberWishlist(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 24, NAME_OF_MEMBER_WISHLIST,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_MEMBER_WISHLIST ="member_wishlist.version";
	
	protected void checkVersionOfMemberWishlist(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfMemberWishlist(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_MEMBER_WISHLIST,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_MEMBER_REWARD_POINT ="member_reward_point.id";
	
	protected void checkIdOfMemberRewardPoint(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfMemberRewardPoint(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_MEMBER_REWARD_POINT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_MEMBER_REWARD_POINT ="member_reward_point.name";
	
	protected void checkNameOfMemberRewardPoint(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfMemberRewardPoint(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 24, NAME_OF_MEMBER_REWARD_POINT,exception); 		
	}
	 		
	 			 		
	public static final String  POINT_OF_MEMBER_REWARD_POINT ="member_reward_point.point";
	
	protected void checkPointOfMemberRewardPoint(RetailScmUserContext userContext, int point, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPointOfMemberRewardPoint(userContext, point, exception);
			return;
		}
	 	checkIntegerRange(point, 0, 20, POINT_OF_MEMBER_REWARD_POINT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_MEMBER_REWARD_POINT ="member_reward_point.version";
	
	protected void checkVersionOfMemberRewardPoint(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfMemberRewardPoint(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_MEMBER_REWARD_POINT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.id";
	
	protected void checkIdOfMemberRewardPointRedemption(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfMemberRewardPointRedemption(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_MEMBER_REWARD_POINT_REDEMPTION,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.name";
	
	protected void checkNameOfMemberRewardPointRedemption(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfMemberRewardPointRedemption(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_MEMBER_REWARD_POINT_REDEMPTION,exception); 		
	}
	 		
	 			 		
	public static final String  POINT_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.point";
	
	protected void checkPointOfMemberRewardPointRedemption(RetailScmUserContext userContext, int point, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPointOfMemberRewardPointRedemption(userContext, point, exception);
			return;
		}
	 	checkIntegerRange(point, 0, 20, POINT_OF_MEMBER_REWARD_POINT_REDEMPTION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.version";
	
	protected void checkVersionOfMemberRewardPointRedemption(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfMemberRewardPointRedemption(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.id";
	
	protected void checkIdOfMemberWishlistProduct(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfMemberWishlistProduct(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_MEMBER_WISHLIST_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.name";
	
	protected void checkNameOfMemberWishlistProduct(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfMemberWishlistProduct(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 20, NAME_OF_MEMBER_WISHLIST_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.version";
	
	protected void checkVersionOfMemberWishlistProduct(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfMemberWishlistProduct(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_MEMBER_WISHLIST_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.id";
	
	protected void checkIdOfRetailStoreMemberAddress(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreMemberAddress(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_MEMBER_ADDRESS,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.name";
	
	protected void checkNameOfRetailStoreMemberAddress(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreMemberAddress(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 24, NAME_OF_RETAIL_STORE_MEMBER_ADDRESS,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.mobile_phone";
	
	protected void checkMobilePhoneOfRetailStoreMemberAddress(RetailScmUserContext userContext, String mobilePhone, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobilePhoneOfRetailStoreMemberAddress(userContext, mobilePhone, exception);
			return;
		}
	 	checkChinaMobilePhone(mobilePhone, 5, 44, MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS,exception); 		
	}
	 		
	 			 		
	public static final String  ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.address";
	
	protected void checkAddressOfRetailStoreMemberAddress(RetailScmUserContext userContext, String address, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAddressOfRetailStoreMemberAddress(userContext, address, exception);
			return;
		}
	 	checkStringLengthRange(address, 4, 56, ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.version";
	
	protected void checkVersionOfRetailStoreMemberAddress(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreMemberAddress(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.id";
	
	protected void checkIdOfRetailStoreMemberGiftCard(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreMemberGiftCard(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.name";
	
	protected void checkNameOfRetailStoreMemberGiftCard(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreMemberGiftCard(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD,exception); 		
	}
	 		
	 			 		
	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.number";
	
	protected void checkNumberOfRetailStoreMemberGiftCard(RetailScmUserContext userContext, String number, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNumberOfRetailStoreMemberGiftCard(userContext, number, exception);
			return;
		}
	 	checkStringLengthRange(number, 2, 28, NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD,exception); 		
	}
	 		
	 			 		
	public static final String  REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.remain";
	
	protected void checkRemainOfRetailStoreMemberGiftCard(RetailScmUserContext userContext, double remain, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemainOfRetailStoreMemberGiftCard(userContext, remain, exception);
			return;
		}
	 	checkMoneyAmount(remain, 0.00, 213.99, REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.version";
	
	protected void checkVersionOfRetailStoreMemberGiftCard(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreMemberGiftCard(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.id";
	
	protected void checkIdOfRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD,exception); 		
	}
	 		
	 			 		
	public static final String  OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.occure_time";
	
	protected void checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, Date occureTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(userContext, occureTime, exception);
			return;
		}
	 	checkDatePast(occureTime, parseDate("1900-01-01"), new Date(), OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD,exception); 		
	}
	 		
	 			 		
	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.number";
	
	protected void checkNumberOfRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, String number, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNumberOfRetailStoreMemberGiftCardConsumeRecord(userContext, number, exception);
			return;
		}
	 	checkStringLengthRange(number, 2, 28, NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.amount";
	
	protected void checkAmountOfRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfRetailStoreMemberGiftCardConsumeRecord(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 20.99, AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.version";
	
	protected void checkVersionOfRetailStoreMemberGiftCardConsumeRecord(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreMemberGiftCardConsumeRecord(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_GOODS_SUPPLIER ="goods_supplier.id";
	
	protected void checkIdOfGoodsSupplier(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfGoodsSupplier(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_GOODS_SUPPLIER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_GOODS_SUPPLIER ="goods_supplier.name";
	
	protected void checkNameOfGoodsSupplier(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfGoodsSupplier(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 40, NAME_OF_GOODS_SUPPLIER,exception); 		
	}
	 		
	 			 		
	public static final String  SUPPLY_PRODUCT_OF_GOODS_SUPPLIER ="goods_supplier.supply_product";
	
	protected void checkSupplyProductOfGoodsSupplier(RetailScmUserContext userContext, String supplyProduct, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSupplyProductOfGoodsSupplier(userContext, supplyProduct, exception);
			return;
		}
	 	checkStringLengthRange(supplyProduct, 2, 16, SUPPLY_PRODUCT_OF_GOODS_SUPPLIER,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_GOODS_SUPPLIER ="goods_supplier.contact_number";
	
	protected void checkContactNumberOfGoodsSupplier(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfGoodsSupplier(userContext, contactNumber, exception);
			return;
		}
	 	checkChinaMobilePhone(contactNumber, 5, 44, CONTACT_NUMBER_OF_GOODS_SUPPLIER,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_GOODS_SUPPLIER ="goods_supplier.description";
	
	protected void checkDescriptionOfGoodsSupplier(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfGoodsSupplier(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 5, 72, DESCRIPTION_OF_GOODS_SUPPLIER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_GOODS_SUPPLIER ="goods_supplier.version";
	
	protected void checkVersionOfGoodsSupplier(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfGoodsSupplier(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_GOODS_SUPPLIER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLIER_PRODUCT ="supplier_product.id";
	
	protected void checkIdOfSupplierProduct(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplierProduct(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLIER_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  PRODUCT_NAME_OF_SUPPLIER_PRODUCT ="supplier_product.product_name";
	
	protected void checkProductNameOfSupplierProduct(RetailScmUserContext userContext, String productName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProductNameOfSupplierProduct(userContext, productName, exception);
			return;
		}
	 	checkStringLengthRange(productName, 2, 16, PRODUCT_NAME_OF_SUPPLIER_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT ="supplier_product.product_description";
	
	protected void checkProductDescriptionOfSupplierProduct(RetailScmUserContext userContext, String productDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProductDescriptionOfSupplierProduct(userContext, productDescription, exception);
			return;
		}
	 	checkStringLengthRange(productDescription, 4, 52, PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  PRODUCT_UNIT_OF_SUPPLIER_PRODUCT ="supplier_product.product_unit";
	
	protected void checkProductUnitOfSupplierProduct(RetailScmUserContext userContext, String productUnit, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProductUnitOfSupplierProduct(userContext, productUnit, exception);
			return;
		}
	 	checkStringLengthRange(productUnit, 1, 8, PRODUCT_UNIT_OF_SUPPLIER_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLIER_PRODUCT ="supplier_product.version";
	
	protected void checkVersionOfSupplierProduct(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplierProduct(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLIER_PRODUCT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.id";
	
	protected void checkIdOfProductSupplyDuration(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfProductSupplyDuration(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_PRODUCT_SUPPLY_DURATION,exception); 		
	}
	 		
	 			 		
	public static final String  QUANTITY_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.quantity";
	
	protected void checkQuantityOfProductSupplyDuration(RetailScmUserContext userContext, int quantity, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkQuantityOfProductSupplyDuration(userContext, quantity, exception);
			return;
		}
	 	checkIntegerRange(quantity, 0, 100|200|500, QUANTITY_OF_PRODUCT_SUPPLY_DURATION,exception); 		
	}
	 		
	 			 		
	public static final String  DURATION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.duration";
	
	protected void checkDurationOfProductSupplyDuration(RetailScmUserContext userContext, String duration, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDurationOfProductSupplyDuration(userContext, duration, exception);
			return;
		}
	 	checkStringLengthRange(duration, 1, 8, DURATION_OF_PRODUCT_SUPPLY_DURATION,exception); 		
	}
	 		
	 			 		
	public static final String  PRICE_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.price";
	
	protected void checkPriceOfProductSupplyDuration(RetailScmUserContext userContext, double price, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPriceOfProductSupplyDuration(userContext, price, exception);
			return;
		}
	 	checkMoneyAmount(price, 0.00, 9999.99, PRICE_OF_PRODUCT_SUPPLY_DURATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.version";
	
	protected void checkVersionOfProductSupplyDuration(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfProductSupplyDuration(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PRODUCT_SUPPLY_DURATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER ="supply_order.id";
	
	protected void checkIdOfSupplyOrder(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrder(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_SUPPLY_ORDER ="supply_order.title";
	
	protected void checkTitleOfSupplyOrder(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfSupplyOrder(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 3, 40, TITLE_OF_SUPPLY_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AMOUNT_OF_SUPPLY_ORDER ="supply_order.total_amount";
	
	protected void checkTotalAmountOfSupplyOrder(RetailScmUserContext userContext, double totalAmount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAmountOfSupplyOrder(userContext, totalAmount, exception);
			return;
		}
	 	checkMoneyAmount(totalAmount, 0.00, 3000000000.88, TOTAL_AMOUNT_OF_SUPPLY_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_SUPPLY_ORDER ="supply_order.current_status";
	
	protected void checkCurrentStatusOfSupplyOrder(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfSupplyOrder(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 3, 36, CURRENT_STATUS_OF_SUPPLY_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER ="supply_order.version";
	
	protected void checkVersionOfSupplyOrder(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrder(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.id";
	
	protected void checkIdOfSupplyOrderConfirmation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderConfirmation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.who";
	
	protected void checkWhoOfSupplyOrderConfirmation(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfSupplyOrderConfirmation(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_SUPPLY_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.confirm_time";
	
	protected void checkConfirmTimeOfSupplyOrderConfirmation(RetailScmUserContext userContext, Date confirmTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkConfirmTimeOfSupplyOrderConfirmation(userContext, confirmTime, exception);
			return;
		}
	 	checkDateRange(confirmTime, parseDate("2000-01-01"), parseDate("2018-07-09"), CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.version";
	
	protected void checkVersionOfSupplyOrderConfirmation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderConfirmation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.id";
	
	protected void checkIdOfSupplyOrderApproval(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderApproval(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.who";
	
	protected void checkWhoOfSupplyOrderApproval(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfSupplyOrderApproval(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_SUPPLY_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.approve_time";
	
	protected void checkApproveTimeOfSupplyOrderApproval(RetailScmUserContext userContext, Date approveTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkApproveTimeOfSupplyOrderApproval(userContext, approveTime, exception);
			return;
		}
	 	checkDateRange(approveTime, parseDate("2000-01-01"), parseDate("2018-07-09"), APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.version";
	
	protected void checkVersionOfSupplyOrderApproval(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderApproval(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.id";
	
	protected void checkIdOfSupplyOrderProcessing(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderProcessing(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.who";
	
	protected void checkWhoOfSupplyOrderProcessing(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfSupplyOrderProcessing(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_SUPPLY_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.process_time";
	
	protected void checkProcessTimeOfSupplyOrderProcessing(RetailScmUserContext userContext, Date processTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProcessTimeOfSupplyOrderProcessing(userContext, processTime, exception);
			return;
		}
	 	checkDateRange(processTime, parseDate("2000-01-01"), parseDate("2018-07-09"), PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.version";
	
	protected void checkVersionOfSupplyOrderProcessing(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderProcessing(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.id";
	
	protected void checkIdOfSupplyOrderPicking(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderPicking(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.who";
	
	protected void checkWhoOfSupplyOrderPicking(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfSupplyOrderPicking(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_SUPPLY_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.process_time";
	
	protected void checkProcessTimeOfSupplyOrderPicking(RetailScmUserContext userContext, Date processTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProcessTimeOfSupplyOrderPicking(userContext, processTime, exception);
			return;
		}
	 	checkDateRange(processTime, parseDate("2000-01-01"), parseDate("2018-07-09"), PROCESS_TIME_OF_SUPPLY_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.version";
	
	protected void checkVersionOfSupplyOrderPicking(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderPicking(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.id";
	
	protected void checkIdOfSupplyOrderShipment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderShipment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.who";
	
	protected void checkWhoOfSupplyOrderShipment(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfSupplyOrderShipment(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_SUPPLY_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.ship_time";
	
	protected void checkShipTimeOfSupplyOrderShipment(RetailScmUserContext userContext, Date shipTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkShipTimeOfSupplyOrderShipment(userContext, shipTime, exception);
			return;
		}
	 	checkDateRange(shipTime, parseDate("2000-01-01"), parseDate("2018-07-09"), SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.version";
	
	protected void checkVersionOfSupplyOrderShipment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderShipment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.id";
	
	protected void checkIdOfSupplyOrderDelivery(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderDelivery(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.who";
	
	protected void checkWhoOfSupplyOrderDelivery(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfSupplyOrderDelivery(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_SUPPLY_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.delivery_time";
	
	protected void checkDeliveryTimeOfSupplyOrderDelivery(RetailScmUserContext userContext, Date deliveryTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDeliveryTimeOfSupplyOrderDelivery(userContext, deliveryTime, exception);
			return;
		}
	 	checkDateRange(deliveryTime, parseDate("2000-01-01"), parseDate("2018-07-09"), DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.version";
	
	protected void checkVersionOfSupplyOrderDelivery(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderDelivery(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.id";
	
	protected void checkIdOfSupplyOrderLineItem(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderLineItem(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_id";
	
	protected void checkSkuIdOfSupplyOrderLineItem(RetailScmUserContext userContext, String skuId, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSkuIdOfSupplyOrderLineItem(userContext, skuId, exception);
			return;
		}
	 	checkStringLengthRange(skuId, 1, 12, SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_name";
	
	protected void checkSkuNameOfSupplyOrderLineItem(RetailScmUserContext userContext, String skuName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSkuNameOfSupplyOrderLineItem(userContext, skuName, exception);
			return;
		}
	 	checkStringLengthRange(skuName, 2, 16, SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.amount";
	
	protected void checkAmountOfSupplyOrderLineItem(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfSupplyOrderLineItem(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 5.97, AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.quantity";
	
	protected void checkQuantityOfSupplyOrderLineItem(RetailScmUserContext userContext, int quantity, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkQuantityOfSupplyOrderLineItem(userContext, quantity, exception);
			return;
		}
	 	checkIntegerRange(quantity, 0, 10000, QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.unit_of_measurement";
	
	protected void checkUnitOfMeasurementOfSupplyOrderLineItem(RetailScmUserContext userContext, String unitOfMeasurement, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkUnitOfMeasurementOfSupplyOrderLineItem(userContext, unitOfMeasurement, exception);
			return;
		}
	 	checkStringLengthRange(unitOfMeasurement, 1, 8, UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.version";
	
	protected void checkVersionOfSupplyOrderLineItem(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderLineItem(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.id";
	
	protected void checkIdOfSupplyOrderShippingGroup(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderShippingGroup(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.name";
	
	protected void checkNameOfSupplyOrderShippingGroup(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfSupplyOrderShippingGroup(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 40, NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.amount";
	
	protected void checkAmountOfSupplyOrderShippingGroup(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfSupplyOrderShippingGroup(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 5.99, AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.version";
	
	protected void checkVersionOfSupplyOrderShippingGroup(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderShippingGroup(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.id";
	
	protected void checkIdOfSupplyOrderPaymentGroup(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplyOrderPaymentGroup(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLY_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.name";
	
	protected void checkNameOfSupplyOrderPaymentGroup(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfSupplyOrderPaymentGroup(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.card_number";
	
	protected void checkCardNumberOfSupplyOrderPaymentGroup(RetailScmUserContext userContext, String cardNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCardNumberOfSupplyOrderPaymentGroup(userContext, cardNumber, exception);
			return;
		}
	 	checkStringLengthRange(cardNumber, 5, 68, CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.version";
	
	protected void checkVersionOfSupplyOrderPaymentGroup(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplyOrderPaymentGroup(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER ="retail_store_order.id";
	
	protected void checkIdOfRetailStoreOrder(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrder(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_RETAIL_STORE_ORDER ="retail_store_order.title";
	
	protected void checkTitleOfRetailStoreOrder(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfRetailStoreOrder(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 4, 56, TITLE_OF_RETAIL_STORE_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER ="retail_store_order.total_amount";
	
	protected void checkTotalAmountOfRetailStoreOrder(RetailScmUserContext userContext, double totalAmount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAmountOfRetailStoreOrder(userContext, totalAmount, exception);
			return;
		}
	 	checkMoneyAmount(totalAmount, 0.00, 3000000000.88, TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_RETAIL_STORE_ORDER ="retail_store_order.current_status";
	
	protected void checkCurrentStatusOfRetailStoreOrder(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfRetailStoreOrder(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 3, 36, CURRENT_STATUS_OF_RETAIL_STORE_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER ="retail_store_order.version";
	
	protected void checkVersionOfRetailStoreOrder(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrder(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.id";
	
	protected void checkIdOfRetailStoreOrderConfirmation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderConfirmation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.who";
	
	protected void checkWhoOfRetailStoreOrderConfirmation(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfRetailStoreOrderConfirmation(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.confirm_time";
	
	protected void checkConfirmTimeOfRetailStoreOrderConfirmation(RetailScmUserContext userContext, Date confirmTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkConfirmTimeOfRetailStoreOrderConfirmation(userContext, confirmTime, exception);
			return;
		}
	 	checkDateRange(confirmTime, parseDate("2000-01-01"), parseDate("2018-07-09"), CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.version";
	
	protected void checkVersionOfRetailStoreOrderConfirmation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderConfirmation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.id";
	
	protected void checkIdOfRetailStoreOrderApproval(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderApproval(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.who";
	
	protected void checkWhoOfRetailStoreOrderApproval(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfRetailStoreOrderApproval(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_RETAIL_STORE_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.approve_time";
	
	protected void checkApproveTimeOfRetailStoreOrderApproval(RetailScmUserContext userContext, Date approveTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkApproveTimeOfRetailStoreOrderApproval(userContext, approveTime, exception);
			return;
		}
	 	checkDateRange(approveTime, parseDate("2000-01-01"), parseDate("2018-07-09"), APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.version";
	
	protected void checkVersionOfRetailStoreOrderApproval(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderApproval(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.id";
	
	protected void checkIdOfRetailStoreOrderProcessing(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderProcessing(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.who";
	
	protected void checkWhoOfRetailStoreOrderProcessing(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfRetailStoreOrderProcessing(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_RETAIL_STORE_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.process_time";
	
	protected void checkProcessTimeOfRetailStoreOrderProcessing(RetailScmUserContext userContext, Date processTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProcessTimeOfRetailStoreOrderProcessing(userContext, processTime, exception);
			return;
		}
	 	checkDateRange(processTime, parseDate("2000-01-01"), parseDate("2018-07-09"), PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.version";
	
	protected void checkVersionOfRetailStoreOrderProcessing(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderProcessing(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_PROCESSING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.id";
	
	protected void checkIdOfRetailStoreOrderPicking(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderPicking(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.who";
	
	protected void checkWhoOfRetailStoreOrderPicking(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfRetailStoreOrderPicking(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_RETAIL_STORE_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.process_time";
	
	protected void checkProcessTimeOfRetailStoreOrderPicking(RetailScmUserContext userContext, Date processTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkProcessTimeOfRetailStoreOrderPicking(userContext, processTime, exception);
			return;
		}
	 	checkDateRange(processTime, parseDate("2000-01-01"), parseDate("2018-07-09"), PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.version";
	
	protected void checkVersionOfRetailStoreOrderPicking(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderPicking(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_PICKING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.id";
	
	protected void checkIdOfRetailStoreOrderShipment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderShipment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.who";
	
	protected void checkWhoOfRetailStoreOrderShipment(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfRetailStoreOrderShipment(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_RETAIL_STORE_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.ship_time";
	
	protected void checkShipTimeOfRetailStoreOrderShipment(RetailScmUserContext userContext, Date shipTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkShipTimeOfRetailStoreOrderShipment(userContext, shipTime, exception);
			return;
		}
	 	checkDateRange(shipTime, parseDate("2000-01-01"), parseDate("2018-07-09"), SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.version";
	
	protected void checkVersionOfRetailStoreOrderShipment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderShipment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.id";
	
	protected void checkIdOfRetailStoreOrderDelivery(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderDelivery(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.who";
	
	protected void checkWhoOfRetailStoreOrderDelivery(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfRetailStoreOrderDelivery(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_RETAIL_STORE_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.delivery_time";
	
	protected void checkDeliveryTimeOfRetailStoreOrderDelivery(RetailScmUserContext userContext, Date deliveryTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDeliveryTimeOfRetailStoreOrderDelivery(userContext, deliveryTime, exception);
			return;
		}
	 	checkDateRange(deliveryTime, parseDate("2000-01-01"), parseDate("2018-07-09"), DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.version";
	
	protected void checkVersionOfRetailStoreOrderDelivery(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderDelivery(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_DELIVERY,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.id";
	
	protected void checkIdOfRetailStoreOrderLineItem(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderLineItem(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_id";
	
	protected void checkSkuIdOfRetailStoreOrderLineItem(RetailScmUserContext userContext, String skuId, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSkuIdOfRetailStoreOrderLineItem(userContext, skuId, exception);
			return;
		}
	 	checkStringLengthRange(skuId, 1, 12, SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_name";
	
	protected void checkSkuNameOfRetailStoreOrderLineItem(RetailScmUserContext userContext, String skuName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSkuNameOfRetailStoreOrderLineItem(userContext, skuName, exception);
			return;
		}
	 	checkStringLengthRange(skuName, 2, 16, SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.amount";
	
	protected void checkAmountOfRetailStoreOrderLineItem(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfRetailStoreOrderLineItem(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 3.97, AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.quantity";
	
	protected void checkQuantityOfRetailStoreOrderLineItem(RetailScmUserContext userContext, int quantity, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkQuantityOfRetailStoreOrderLineItem(userContext, quantity, exception);
			return;
		}
	 	checkIntegerRange(quantity, 0, 10000, QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.unit_of_measurement";
	
	protected void checkUnitOfMeasurementOfRetailStoreOrderLineItem(RetailScmUserContext userContext, String unitOfMeasurement, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkUnitOfMeasurementOfRetailStoreOrderLineItem(userContext, unitOfMeasurement, exception);
			return;
		}
	 	checkStringLengthRange(unitOfMeasurement, 1, 8, UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.version";
	
	protected void checkVersionOfRetailStoreOrderLineItem(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderLineItem(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.id";
	
	protected void checkIdOfRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderShippingGroup(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.name";
	
	protected void checkNameOfRetailStoreOrderShippingGroup(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreOrderShippingGroup(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 40, NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.amount";
	
	protected void checkAmountOfRetailStoreOrderShippingGroup(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfRetailStoreOrderShippingGroup(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 5.99, AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.version";
	
	protected void checkVersionOfRetailStoreOrderShippingGroup(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderShippingGroup(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.id";
	
	protected void checkIdOfRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfRetailStoreOrderPaymentGroup(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.name";
	
	protected void checkNameOfRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfRetailStoreOrderPaymentGroup(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.card_number";
	
	protected void checkCardNumberOfRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, String cardNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCardNumberOfRetailStoreOrderPaymentGroup(userContext, cardNumber, exception);
			return;
		}
	 	checkStringLengthRange(cardNumber, 5, 68, CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.version";
	
	protected void checkVersionOfRetailStoreOrderPaymentGroup(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfRetailStoreOrderPaymentGroup(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_WAREHOUSE ="warehouse.id";
	
	protected void checkIdOfWarehouse(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfWarehouse(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_WAREHOUSE,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_WAREHOUSE ="warehouse.location";
	
	protected void checkLocationOfWarehouse(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfWarehouse(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 3, 44, LOCATION_OF_WAREHOUSE,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_WAREHOUSE ="warehouse.contact_number";
	
	protected void checkContactNumberOfWarehouse(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfWarehouse(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_WAREHOUSE,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AREA_OF_WAREHOUSE ="warehouse.total_area";
	
	protected void checkTotalAreaOfWarehouse(RetailScmUserContext userContext, String totalArea, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAreaOfWarehouse(userContext, totalArea, exception);
			return;
		}
	 	checkStringLengthRange(totalArea, 3, 36, TOTAL_AREA_OF_WAREHOUSE,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_WAREHOUSE ="warehouse.latitude";
	
	protected void checkLatitudeOfWarehouse(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfWarehouse(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_WAREHOUSE,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_WAREHOUSE ="warehouse.longitude";
	
	protected void checkLongitudeOfWarehouse(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfWarehouse(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_WAREHOUSE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_WAREHOUSE ="warehouse.version";
	
	protected void checkVersionOfWarehouse(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfWarehouse(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_WAREHOUSE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_STORAGE_SPACE ="storage_space.id";
	
	protected void checkIdOfStorageSpace(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfStorageSpace(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_STORAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_STORAGE_SPACE ="storage_space.location";
	
	protected void checkLocationOfStorageSpace(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfStorageSpace(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 4, 56, LOCATION_OF_STORAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_STORAGE_SPACE ="storage_space.contact_number";
	
	protected void checkContactNumberOfStorageSpace(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfStorageSpace(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_STORAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AREA_OF_STORAGE_SPACE ="storage_space.total_area";
	
	protected void checkTotalAreaOfStorageSpace(RetailScmUserContext userContext, String totalArea, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAreaOfStorageSpace(userContext, totalArea, exception);
			return;
		}
	 	checkStringLengthRange(totalArea, 2, 28, TOTAL_AREA_OF_STORAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_STORAGE_SPACE ="storage_space.latitude";
	
	protected void checkLatitudeOfStorageSpace(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfStorageSpace(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_STORAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_STORAGE_SPACE ="storage_space.longitude";
	
	protected void checkLongitudeOfStorageSpace(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfStorageSpace(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_STORAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_STORAGE_SPACE ="storage_space.version";
	
	protected void checkVersionOfStorageSpace(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfStorageSpace(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_STORAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SMART_PALLET ="smart_pallet.id";
	
	protected void checkIdOfSmartPallet(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSmartPallet(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SMART_PALLET,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_SMART_PALLET ="smart_pallet.location";
	
	protected void checkLocationOfSmartPallet(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfSmartPallet(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 7, 104, LOCATION_OF_SMART_PALLET,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_SMART_PALLET ="smart_pallet.contact_number";
	
	protected void checkContactNumberOfSmartPallet(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfSmartPallet(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_SMART_PALLET,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AREA_OF_SMART_PALLET ="smart_pallet.total_area";
	
	protected void checkTotalAreaOfSmartPallet(RetailScmUserContext userContext, String totalArea, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAreaOfSmartPallet(userContext, totalArea, exception);
			return;
		}
	 	checkStringLengthRange(totalArea, 2, 28, TOTAL_AREA_OF_SMART_PALLET,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_SMART_PALLET ="smart_pallet.latitude";
	
	protected void checkLatitudeOfSmartPallet(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfSmartPallet(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_SMART_PALLET,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_SMART_PALLET ="smart_pallet.longitude";
	
	protected void checkLongitudeOfSmartPallet(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfSmartPallet(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_SMART_PALLET,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SMART_PALLET ="smart_pallet.version";
	
	protected void checkVersionOfSmartPallet(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSmartPallet(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SMART_PALLET,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_GOODS_SHELF ="goods_shelf.id";
	
	protected void checkIdOfGoodsShelf(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfGoodsShelf(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_GOODS_SHELF,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_GOODS_SHELF ="goods_shelf.location";
	
	protected void checkLocationOfGoodsShelf(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfGoodsShelf(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 5, 64, LOCATION_OF_GOODS_SHELF,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_GOODS_SHELF ="goods_shelf.version";
	
	protected void checkVersionOfGoodsShelf(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfGoodsShelf(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_GOODS_SHELF,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.id";
	
	protected void checkIdOfGoodsShelfStockCount(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfGoodsShelfStockCount(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_GOODS_SHELF_STOCK_COUNT,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.title";
	
	protected void checkTitleOfGoodsShelfStockCount(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfGoodsShelfStockCount(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 2, 16, TITLE_OF_GOODS_SHELF_STOCK_COUNT,exception); 		
	}
	 		
	 			 		
	public static final String  COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.count_time";
	
	protected void checkCountTimeOfGoodsShelfStockCount(RetailScmUserContext userContext, Date countTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCountTimeOfGoodsShelfStockCount(userContext, countTime, exception);
			return;
		}
	 	checkDateRange(countTime, parseDate("2000-01-01"), parseDate("2017-04-01"), COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT,exception); 		
	}
	 		
	 			 		
	public static final String  SUMMARY_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.summary";
	
	protected void checkSummaryOfGoodsShelfStockCount(RetailScmUserContext userContext, String summary, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSummaryOfGoodsShelfStockCount(userContext, summary, exception);
			return;
		}
	 	checkStringLengthRange(summary, 5, 72, SUMMARY_OF_GOODS_SHELF_STOCK_COUNT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.version";
	
	protected void checkVersionOfGoodsShelfStockCount(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfGoodsShelfStockCount(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_GOODS_SHELF_STOCK_COUNT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.id";
	
	protected void checkIdOfStockCountIssueTrack(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfStockCountIssueTrack(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_STOCK_COUNT_ISSUE_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.title";
	
	protected void checkTitleOfStockCountIssueTrack(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfStockCountIssueTrack(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 2, 16, TITLE_OF_STOCK_COUNT_ISSUE_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.count_time";
	
	protected void checkCountTimeOfStockCountIssueTrack(RetailScmUserContext userContext, Date countTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCountTimeOfStockCountIssueTrack(userContext, countTime, exception);
			return;
		}
	 	checkDateRange(countTime, parseDate("2000-01-01"), parseDate("2017-04-01"), COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.summary";
	
	protected void checkSummaryOfStockCountIssueTrack(RetailScmUserContext userContext, String summary, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSummaryOfStockCountIssueTrack(userContext, summary, exception);
			return;
		}
	 	checkStringLengthRange(summary, 3, 40, SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.version";
	
	protected void checkVersionOfStockCountIssueTrack(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfStockCountIssueTrack(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_STOCK_COUNT_ISSUE_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_GOODS_ALLOCATION ="goods_allocation.id";
	
	protected void checkIdOfGoodsAllocation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfGoodsAllocation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_GOODS_ALLOCATION,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_GOODS_ALLOCATION ="goods_allocation.location";
	
	protected void checkLocationOfGoodsAllocation(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfGoodsAllocation(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 6, 84, LOCATION_OF_GOODS_ALLOCATION,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_GOODS_ALLOCATION ="goods_allocation.latitude";
	
	protected void checkLatitudeOfGoodsAllocation(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfGoodsAllocation(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_GOODS_ALLOCATION,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_GOODS_ALLOCATION ="goods_allocation.longitude";
	
	protected void checkLongitudeOfGoodsAllocation(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfGoodsAllocation(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_GOODS_ALLOCATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_GOODS_ALLOCATION ="goods_allocation.version";
	
	protected void checkVersionOfGoodsAllocation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfGoodsAllocation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_GOODS_ALLOCATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_GOODS ="goods.id";
	
	protected void checkIdOfGoods(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfGoods(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_GOODS ="goods.name";
	
	protected void checkNameOfGoods(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfGoods(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  RFID_OF_GOODS ="goods.rfid";
	
	protected void checkRfidOfGoods(RetailScmUserContext userContext, String rfid, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRfidOfGoods(userContext, rfid, exception);
			return;
		}
	 	checkStringLengthRange(rfid, 2, 28, RFID_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  UOM_OF_GOODS ="goods.uom";
	
	protected void checkUomOfGoods(RetailScmUserContext userContext, String uom, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkUomOfGoods(userContext, uom, exception);
			return;
		}
	 	checkStringLengthRange(uom, 1, 4, UOM_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  MAX_PACKAGE_OF_GOODS ="goods.max_package";
	
	protected void checkMaxPackageOfGoods(RetailScmUserContext userContext, int maxPackage, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMaxPackageOfGoods(userContext, maxPackage, exception);
			return;
		}
	 	checkIntegerRange(maxPackage, 0, 10, MAX_PACKAGE_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  EXPIRE_TIME_OF_GOODS ="goods.expire_time";
	
	protected void checkExpireTimeOfGoods(RetailScmUserContext userContext, Date expireTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkExpireTimeOfGoods(userContext, expireTime, exception);
			return;
		}
	 	checkDateRange(expireTime, parseDate("2000-01-01"), parseDate("2019-09-09"), EXPIRE_TIME_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_GOODS ="goods.current_status";
	
	protected void checkCurrentStatusOfGoods(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfGoods(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 2, 24, CURRENT_STATUS_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_GOODS ="goods.version";
	
	protected void checkVersionOfGoods(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfGoods(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_GOODS,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_GOODS_PACKAGING ="goods_packaging.id";
	
	protected void checkIdOfGoodsPackaging(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfGoodsPackaging(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_GOODS_PACKAGING,exception); 		
	}
	 		
	 			 		
	public static final String  PACKAGE_NAME_OF_GOODS_PACKAGING ="goods_packaging.package_name";
	
	protected void checkPackageNameOfGoodsPackaging(RetailScmUserContext userContext, String packageName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPackageNameOfGoodsPackaging(userContext, packageName, exception);
			return;
		}
	 	checkStringLengthRange(packageName, 1, 12, PACKAGE_NAME_OF_GOODS_PACKAGING,exception); 		
	}
	 		
	 			 		
	public static final String  RFID_OF_GOODS_PACKAGING ="goods_packaging.rfid";
	
	protected void checkRfidOfGoodsPackaging(RetailScmUserContext userContext, String rfid, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRfidOfGoodsPackaging(userContext, rfid, exception);
			return;
		}
	 	checkStringLengthRange(rfid, 2, 28, RFID_OF_GOODS_PACKAGING,exception); 		
	}
	 		
	 			 		
	public static final String  PACKAGE_TIME_OF_GOODS_PACKAGING ="goods_packaging.package_time";
	
	protected void checkPackageTimeOfGoodsPackaging(RetailScmUserContext userContext, Date packageTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPackageTimeOfGoodsPackaging(userContext, packageTime, exception);
			return;
		}
	 	checkDateRange(packageTime, parseDate("2000-01-01"), parseDate("2017-09-09"), PACKAGE_TIME_OF_GOODS_PACKAGING,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_GOODS_PACKAGING ="goods_packaging.description";
	
	protected void checkDescriptionOfGoodsPackaging(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfGoodsPackaging(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 3, 36, DESCRIPTION_OF_GOODS_PACKAGING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_GOODS_PACKAGING ="goods_packaging.version";
	
	protected void checkVersionOfGoodsPackaging(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfGoodsPackaging(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_GOODS_PACKAGING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_GOODS_MOVEMENT ="goods_movement.id";
	
	protected void checkIdOfGoodsMovement(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfGoodsMovement(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  MOVE_TIME_OF_GOODS_MOVEMENT ="goods_movement.move_time";
	
	protected void checkMoveTimeOfGoodsMovement(RetailScmUserContext userContext, Date moveTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMoveTimeOfGoodsMovement(userContext, moveTime, exception);
			return;
		}
	 	checkDateTime(moveTime, parseTimestamp("2000-01-01T00:00:00"), parseTimestamp("2017-08-09T09:09:09"), MOVE_TIME_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  FACILITY_OF_GOODS_MOVEMENT ="goods_movement.facility";
	
	protected void checkFacilityOfGoodsMovement(RetailScmUserContext userContext, String facility, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFacilityOfGoodsMovement(userContext, facility, exception);
			return;
		}
	 	checkStringLengthRange(facility, 2, 16, FACILITY_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  FACILITY_ID_OF_GOODS_MOVEMENT ="goods_movement.facility_id";
	
	protected void checkFacilityIdOfGoodsMovement(RetailScmUserContext userContext, String facilityId, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFacilityIdOfGoodsMovement(userContext, facilityId, exception);
			return;
		}
	 	checkStringLengthRange(facilityId, 2, 16, FACILITY_ID_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  FROM_IP_OF_GOODS_MOVEMENT ="goods_movement.from_ip";
	
	protected void checkFromIpOfGoodsMovement(RetailScmUserContext userContext, String fromIp, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFromIpOfGoodsMovement(userContext, fromIp, exception);
			return;
		}
	 	checkStringLengthRange(fromIp, 4, 48, FROM_IP_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  USER_AGENT_OF_GOODS_MOVEMENT ="goods_movement.user_agent";
	
	protected void checkUserAgentOfGoodsMovement(RetailScmUserContext userContext, String userAgent, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkUserAgentOfGoodsMovement(userContext, userAgent, exception);
			return;
		}
	 	checkStringLengthRange(userAgent, 28, 444, USER_AGENT_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  SESSION_ID_OF_GOODS_MOVEMENT ="goods_movement.session_id";
	
	protected void checkSessionIdOfGoodsMovement(RetailScmUserContext userContext, String sessionId, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSessionIdOfGoodsMovement(userContext, sessionId, exception);
			return;
		}
	 	checkStringLengthRange(sessionId, 6, 80, SESSION_ID_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_GOODS_MOVEMENT ="goods_movement.latitude";
	
	protected void checkLatitudeOfGoodsMovement(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfGoodsMovement(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_GOODS_MOVEMENT ="goods_movement.longitude";
	
	protected void checkLongitudeOfGoodsMovement(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfGoodsMovement(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_GOODS_MOVEMENT ="goods_movement.version";
	
	protected void checkVersionOfGoodsMovement(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfGoodsMovement(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_GOODS_MOVEMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SUPPLIER_SPACE ="supplier_space.id";
	
	protected void checkIdOfSupplierSpace(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSupplierSpace(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SUPPLIER_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_SUPPLIER_SPACE ="supplier_space.location";
	
	protected void checkLocationOfSupplierSpace(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfSupplierSpace(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 5, 76, LOCATION_OF_SUPPLIER_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_SUPPLIER_SPACE ="supplier_space.contact_number";
	
	protected void checkContactNumberOfSupplierSpace(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfSupplierSpace(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_SUPPLIER_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AREA_OF_SUPPLIER_SPACE ="supplier_space.total_area";
	
	protected void checkTotalAreaOfSupplierSpace(RetailScmUserContext userContext, String totalArea, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAreaOfSupplierSpace(userContext, totalArea, exception);
			return;
		}
	 	checkStringLengthRange(totalArea, 2, 28, TOTAL_AREA_OF_SUPPLIER_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_SUPPLIER_SPACE ="supplier_space.latitude";
	
	protected void checkLatitudeOfSupplierSpace(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfSupplierSpace(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_SUPPLIER_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_SUPPLIER_SPACE ="supplier_space.longitude";
	
	protected void checkLongitudeOfSupplierSpace(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfSupplierSpace(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_SUPPLIER_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SUPPLIER_SPACE ="supplier_space.version";
	
	protected void checkVersionOfSupplierSpace(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSupplierSpace(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SUPPLIER_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RECEIVING_SPACE ="receiving_space.id";
	
	protected void checkIdOfReceivingSpace(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfReceivingSpace(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_RECEIVING_SPACE ="receiving_space.location";
	
	protected void checkLocationOfReceivingSpace(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfReceivingSpace(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 5, 64, LOCATION_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_RECEIVING_SPACE ="receiving_space.contact_number";
	
	protected void checkContactNumberOfReceivingSpace(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfReceivingSpace(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_RECEIVING_SPACE ="receiving_space.description";
	
	protected void checkDescriptionOfReceivingSpace(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfReceivingSpace(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 4, 52, DESCRIPTION_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AREA_OF_RECEIVING_SPACE ="receiving_space.total_area";
	
	protected void checkTotalAreaOfReceivingSpace(RetailScmUserContext userContext, String totalArea, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAreaOfReceivingSpace(userContext, totalArea, exception);
			return;
		}
	 	checkStringLengthRange(totalArea, 2, 28, TOTAL_AREA_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_RECEIVING_SPACE ="receiving_space.latitude";
	
	protected void checkLatitudeOfReceivingSpace(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfReceivingSpace(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_RECEIVING_SPACE ="receiving_space.longitude";
	
	protected void checkLongitudeOfReceivingSpace(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfReceivingSpace(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RECEIVING_SPACE ="receiving_space.version";
	
	protected void checkVersionOfReceivingSpace(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfReceivingSpace(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RECEIVING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SHIPPING_SPACE ="shipping_space.id";
	
	protected void checkIdOfShippingSpace(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfShippingSpace(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_SHIPPING_SPACE ="shipping_space.location";
	
	protected void checkLocationOfShippingSpace(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfShippingSpace(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 4, 56, LOCATION_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_SHIPPING_SPACE ="shipping_space.contact_number";
	
	protected void checkContactNumberOfShippingSpace(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfShippingSpace(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AREA_OF_SHIPPING_SPACE ="shipping_space.total_area";
	
	protected void checkTotalAreaOfShippingSpace(RetailScmUserContext userContext, String totalArea, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAreaOfShippingSpace(userContext, totalArea, exception);
			return;
		}
	 	checkStringLengthRange(totalArea, 2, 28, TOTAL_AREA_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_SHIPPING_SPACE ="shipping_space.latitude";
	
	protected void checkLatitudeOfShippingSpace(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfShippingSpace(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_SHIPPING_SPACE ="shipping_space.longitude";
	
	protected void checkLongitudeOfShippingSpace(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfShippingSpace(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_SHIPPING_SPACE ="shipping_space.description";
	
	protected void checkDescriptionOfShippingSpace(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfShippingSpace(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 4, 52, DESCRIPTION_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SHIPPING_SPACE ="shipping_space.version";
	
	protected void checkVersionOfShippingSpace(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfShippingSpace(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SHIPPING_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_DAMAGE_SPACE ="damage_space.id";
	
	protected void checkIdOfDamageSpace(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfDamageSpace(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_DAMAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_DAMAGE_SPACE ="damage_space.location";
	
	protected void checkLocationOfDamageSpace(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfDamageSpace(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 6, 80, LOCATION_OF_DAMAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_DAMAGE_SPACE ="damage_space.contact_number";
	
	protected void checkContactNumberOfDamageSpace(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfDamageSpace(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_DAMAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  TOTAL_AREA_OF_DAMAGE_SPACE ="damage_space.total_area";
	
	protected void checkTotalAreaOfDamageSpace(RetailScmUserContext userContext, String totalArea, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTotalAreaOfDamageSpace(userContext, totalArea, exception);
			return;
		}
	 	checkStringLengthRange(totalArea, 2, 28, TOTAL_AREA_OF_DAMAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_DAMAGE_SPACE ="damage_space.latitude";
	
	protected void checkLatitudeOfDamageSpace(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfDamageSpace(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_DAMAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_DAMAGE_SPACE ="damage_space.longitude";
	
	protected void checkLongitudeOfDamageSpace(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfDamageSpace(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_DAMAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_DAMAGE_SPACE ="damage_space.version";
	
	protected void checkVersionOfDamageSpace(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfDamageSpace(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_DAMAGE_SPACE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_WAREHOUSE_ASSET ="warehouse_asset.id";
	
	protected void checkIdOfWarehouseAsset(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfWarehouseAsset(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_WAREHOUSE_ASSET,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_WAREHOUSE_ASSET ="warehouse_asset.name";
	
	protected void checkNameOfWarehouseAsset(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfWarehouseAsset(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 20, NAME_OF_WAREHOUSE_ASSET,exception); 		
	}
	 		
	 			 		
	public static final String  POSITION_OF_WAREHOUSE_ASSET ="warehouse_asset.position";
	
	protected void checkPositionOfWarehouseAsset(RetailScmUserContext userContext, String position, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPositionOfWarehouseAsset(userContext, position, exception);
			return;
		}
	 	checkStringLengthRange(position, 3, 40, POSITION_OF_WAREHOUSE_ASSET,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_WAREHOUSE_ASSET ="warehouse_asset.version";
	
	protected void checkVersionOfWarehouseAsset(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfWarehouseAsset(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_WAREHOUSE_ASSET,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TRANSPORT_FLEET ="transport_fleet.id";
	
	protected void checkIdOfTransportFleet(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTransportFleet(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TRANSPORT_FLEET,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_TRANSPORT_FLEET ="transport_fleet.name";
	
	protected void checkNameOfTransportFleet(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfTransportFleet(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 28, NAME_OF_TRANSPORT_FLEET,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_TRANSPORT_FLEET ="transport_fleet.contact_number";
	
	protected void checkContactNumberOfTransportFleet(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfTransportFleet(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_TRANSPORT_FLEET,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TRANSPORT_FLEET ="transport_fleet.version";
	
	protected void checkVersionOfTransportFleet(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTransportFleet(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TRANSPORT_FLEET,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TRANSPORT_TRUCK ="transport_truck.id";
	
	protected void checkIdOfTransportTruck(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTransportTruck(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_TRANSPORT_TRUCK ="transport_truck.name";
	
	protected void checkNameOfTransportTruck(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfTransportTruck(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  PLATE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.plate_number";
	
	protected void checkPlateNumberOfTransportTruck(RetailScmUserContext userContext, String plateNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPlateNumberOfTransportTruck(userContext, plateNumber, exception);
			return;
		}
	 	checkStringLengthRange(plateNumber, 2, 16, PLATE_NUMBER_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.contact_number";
	
	protected void checkContactNumberOfTransportTruck(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfTransportTruck(userContext, contactNumber, exception);
			return;
		}
	 	checkStringLengthRange(contactNumber, 3, 44, CONTACT_NUMBER_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.vehicle_license_number";
	
	protected void checkVehicleLicenseNumberOfTransportTruck(RetailScmUserContext userContext, String vehicleLicenseNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVehicleLicenseNumberOfTransportTruck(userContext, vehicleLicenseNumber, exception);
			return;
		}
	 	checkStringLengthRange(vehicleLicenseNumber, 2, 24, VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  ENGINE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.engine_number";
	
	protected void checkEngineNumberOfTransportTruck(RetailScmUserContext userContext, String engineNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEngineNumberOfTransportTruck(userContext, engineNumber, exception);
			return;
		}
	 	checkStringLengthRange(engineNumber, 2, 28, ENGINE_NUMBER_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_TRANSPORT_TRUCK ="transport_truck.make_date";
	
	protected void checkMakeDateOfTransportTruck(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfTransportTruck(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2010-09-09"), MAKE_DATE_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  MILEAGE_OF_TRANSPORT_TRUCK ="transport_truck.mileage";
	
	protected void checkMileageOfTransportTruck(RetailScmUserContext userContext, String mileage, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMileageOfTransportTruck(userContext, mileage, exception);
			return;
		}
	 	checkStringLengthRange(mileage, 2, 24, MILEAGE_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  BODY_COLOR_OF_TRANSPORT_TRUCK ="transport_truck.body_color";
	
	protected void checkBodyColorOfTransportTruck(RetailScmUserContext userContext, String bodyColor, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBodyColorOfTransportTruck(userContext, bodyColor, exception);
			return;
		}
	 	checkStringLengthRange(bodyColor, 1, 8, BODY_COLOR_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TRANSPORT_TRUCK ="transport_truck.version";
	
	protected void checkVersionOfTransportTruck(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTransportTruck(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TRANSPORT_TRUCK,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TRUCK_DRIVER ="truck_driver.id";
	
	protected void checkIdOfTruckDriver(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTruckDriver(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TRUCK_DRIVER,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_TRUCK_DRIVER ="truck_driver.name";
	
	protected void checkNameOfTruckDriver(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfTruckDriver(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 24, NAME_OF_TRUCK_DRIVER,exception); 		
	}
	 		
	 			 		
	public static final String  DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER ="truck_driver.driver_license_number";
	
	protected void checkDriverLicenseNumberOfTruckDriver(RetailScmUserContext userContext, String driverLicenseNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDriverLicenseNumberOfTruckDriver(userContext, driverLicenseNumber, exception);
			return;
		}
	 	checkStringLengthRange(driverLicenseNumber, 3, 44, DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER,exception); 		
	}
	 		
	 			 		
	public static final String  CONTACT_NUMBER_OF_TRUCK_DRIVER ="truck_driver.contact_number";
	
	protected void checkContactNumberOfTruckDriver(RetailScmUserContext userContext, String contactNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkContactNumberOfTruckDriver(userContext, contactNumber, exception);
			return;
		}
	 	checkChinaMobilePhone(contactNumber, 5, 44, CONTACT_NUMBER_OF_TRUCK_DRIVER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TRUCK_DRIVER ="truck_driver.version";
	
	protected void checkVersionOfTruckDriver(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTruckDriver(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TRUCK_DRIVER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TRANSPORT_TASK ="transport_task.id";
	
	protected void checkIdOfTransportTask(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTransportTask(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TRANSPORT_TASK,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_TRANSPORT_TASK ="transport_task.name";
	
	protected void checkNameOfTransportTask(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfTransportTask(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_TRANSPORT_TASK,exception); 		
	}
	 		
	 			 		
	public static final String  START_OF_TRANSPORT_TASK ="transport_task.start";
	
	protected void checkStartOfTransportTask(RetailScmUserContext userContext, String start, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkStartOfTransportTask(userContext, start, exception);
			return;
		}
	 	checkStringLengthRange(start, 2, 20, START_OF_TRANSPORT_TASK,exception); 		
	}
	 		
	 			 		
	public static final String  BEGIN_TIME_OF_TRANSPORT_TASK ="transport_task.begin_time";
	
	protected void checkBeginTimeOfTransportTask(RetailScmUserContext userContext, Date beginTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBeginTimeOfTransportTask(userContext, beginTime, exception);
			return;
		}
	 	checkDatePast(beginTime, parseDate("1900-01-01"), new Date(), BEGIN_TIME_OF_TRANSPORT_TASK,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_TRANSPORT_TASK ="transport_task.latitude";
	
	protected void checkLatitudeOfTransportTask(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfTransportTask(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 40.776877, LATITUDE_OF_TRANSPORT_TASK,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_TRANSPORT_TASK ="transport_task.longitude";
	
	protected void checkLongitudeOfTransportTask(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfTransportTask(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 130.273647, LONGITUDE_OF_TRANSPORT_TASK,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TRANSPORT_TASK ="transport_task.version";
	
	protected void checkVersionOfTransportTask(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTransportTask(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TRANSPORT_TASK,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TRANSPORT_TASK_TRACK ="transport_task_track.id";
	
	protected void checkIdOfTransportTaskTrack(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTransportTaskTrack(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TRANSPORT_TASK_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  TRACK_TIME_OF_TRANSPORT_TASK_TRACK ="transport_task_track.track_time";
	
	protected void checkTrackTimeOfTransportTaskTrack(RetailScmUserContext userContext, Date trackTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTrackTimeOfTransportTaskTrack(userContext, trackTime, exception);
			return;
		}
	 	checkDatePast(trackTime, parseDate("1900-01-01"), new Date(), TRACK_TIME_OF_TRANSPORT_TASK_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  LATITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.latitude";
	
	protected void checkLatitudeOfTransportTaskTrack(RetailScmUserContext userContext, double latitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLatitudeOfTransportTaskTrack(userContext, latitude, exception);
			return;
		}
	 	checkDoubleRange(latitude, 0, 30.912929, LATITUDE_OF_TRANSPORT_TASK_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  LONGITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.longitude";
	
	protected void checkLongitudeOfTransportTaskTrack(RetailScmUserContext userContext, double longitude, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLongitudeOfTransportTaskTrack(userContext, longitude, exception);
			return;
		}
	 	checkDoubleRange(longitude, 0, 104.121232, LONGITUDE_OF_TRANSPORT_TASK_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TRANSPORT_TASK_TRACK ="transport_task_track.version";
	
	protected void checkVersionOfTransportTaskTrack(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTransportTaskTrack(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TRANSPORT_TASK_TRACK,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNT_SET ="account_set.id";
	
	protected void checkIdOfAccountSet(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountSet(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_ACCOUNT_SET ="account_set.name";
	
	protected void checkNameOfAccountSet(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfAccountSet(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 24, NAME_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  YEAR_SET_OF_ACCOUNT_SET ="account_set.year_set";
	
	protected void checkYearSetOfAccountSet(RetailScmUserContext userContext, String yearSet, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkYearSetOfAccountSet(userContext, yearSet, exception);
			return;
		}
	 	checkStringLengthRange(yearSet, 2, 20, YEAR_SET_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  EFFECTIVE_DATE_OF_ACCOUNT_SET ="account_set.effective_date";
	
	protected void checkEffectiveDateOfAccountSet(RetailScmUserContext userContext, Date effectiveDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEffectiveDateOfAccountSet(userContext, effectiveDate, exception);
			return;
		}
	 	checkDateRange(effectiveDate, parseDate("2000-01-01"), parseDate("2017-05-28"), EFFECTIVE_DATE_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  ACCOUNTING_SYSTEM_OF_ACCOUNT_SET ="account_set.accounting_system";
	
	protected void checkAccountingSystemOfAccountSet(RetailScmUserContext userContext, String accountingSystem, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccountingSystemOfAccountSet(userContext, accountingSystem, exception);
			return;
		}
	 	checkStringLengthRange(accountingSystem, 2, 28, ACCOUNTING_SYSTEM_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET ="account_set.domestic_currency_code";
	
	protected void checkDomesticCurrencyCodeOfAccountSet(RetailScmUserContext userContext, String domesticCurrencyCode, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDomesticCurrencyCodeOfAccountSet(userContext, domesticCurrencyCode, exception);
			return;
		}
	 	checkStringLengthRange(domesticCurrencyCode, 1, 12, DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET ="account_set.domestic_currency_name";
	
	protected void checkDomesticCurrencyNameOfAccountSet(RetailScmUserContext userContext, String domesticCurrencyName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDomesticCurrencyNameOfAccountSet(userContext, domesticCurrencyName, exception);
			return;
		}
	 	checkStringLengthRange(domesticCurrencyName, 1, 12, DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  OPENING_BANK_OF_ACCOUNT_SET ="account_set.opening_bank";
	
	protected void checkOpeningBankOfAccountSet(RetailScmUserContext userContext, String openingBank, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkOpeningBankOfAccountSet(userContext, openingBank, exception);
			return;
		}
	 	checkStringLengthRange(openingBank, 2, 16, OPENING_BANK_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  ACCOUNT_NUMBER_OF_ACCOUNT_SET ="account_set.account_number";
	
	protected void checkAccountNumberOfAccountSet(RetailScmUserContext userContext, String accountNumber, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccountNumberOfAccountSet(userContext, accountNumber, exception);
			return;
		}
	 	checkStringLengthRange(accountNumber, 4, 56, ACCOUNT_NUMBER_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNT_SET ="account_set.version";
	
	protected void checkVersionOfAccountSet(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountSet(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNT_SET,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_SUBJECT ="accounting_subject.id";
	
	protected void checkIdOfAccountingSubject(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingSubject(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_SUBJECT,exception); 		
	}
	 		
	 			 		
	public static final String  ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_code";
	
	protected void checkAccountingSubjectCodeOfAccountingSubject(RetailScmUserContext userContext, String accountingSubjectCode, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccountingSubjectCodeOfAccountingSubject(userContext, accountingSubjectCode, exception);
			return;
		}
	 	checkStringLengthRange(accountingSubjectCode, 2, 24, ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT,exception); 		
	}
	 		
	 			 		
	public static final String  ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_name";
	
	protected void checkAccountingSubjectNameOfAccountingSubject(RetailScmUserContext userContext, String accountingSubjectName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccountingSubjectNameOfAccountingSubject(userContext, accountingSubjectName, exception);
			return;
		}
	 	checkStringLengthRange(accountingSubjectName, 2, 16, ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT,exception); 		
	}
	 		
	 			 		
	public static final String  ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_code";
	
	protected void checkAccountingSubjectClassCodeOfAccountingSubject(RetailScmUserContext userContext, int accountingSubjectClassCode, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccountingSubjectClassCodeOfAccountingSubject(userContext, accountingSubjectClassCode, exception);
			return;
		}
	 	checkIntegerRange(accountingSubjectClassCode, 0, 1|2|3|4|5|6, ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT,exception); 		
	}
	 		
	 			 		
	public static final String  ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_name";
	
	protected void checkAccountingSubjectClassNameOfAccountingSubject(RetailScmUserContext userContext, String accountingSubjectClassName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccountingSubjectClassNameOfAccountingSubject(userContext, accountingSubjectClassName, exception);
			return;
		}
	 	checkStringLengthRange(accountingSubjectClassName, 2, 24, ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_SUBJECT ="accounting_subject.version";
	
	protected void checkVersionOfAccountingSubject(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingSubject(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_SUBJECT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_PERIOD ="accounting_period.id";
	
	protected void checkIdOfAccountingPeriod(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingPeriod(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_PERIOD,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_ACCOUNTING_PERIOD ="accounting_period.name";
	
	protected void checkNameOfAccountingPeriod(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfAccountingPeriod(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 32, NAME_OF_ACCOUNTING_PERIOD,exception); 		
	}
	 		
	 			 		
	public static final String  START_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.start_date";
	
	protected void checkStartDateOfAccountingPeriod(RetailScmUserContext userContext, Date startDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkStartDateOfAccountingPeriod(userContext, startDate, exception);
			return;
		}
	 	checkDateRange(startDate, parseDate("2000-01-01"), parseDate("2017-01-09"), START_DATE_OF_ACCOUNTING_PERIOD,exception); 		
	}
	 		
	 			 		
	public static final String  END_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.end_date";
	
	protected void checkEndDateOfAccountingPeriod(RetailScmUserContext userContext, Date endDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEndDateOfAccountingPeriod(userContext, endDate, exception);
			return;
		}
	 	checkDateRange(endDate, parseDate("2000-01-01"), parseDate("2017-01-09"), END_DATE_OF_ACCOUNTING_PERIOD,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_PERIOD ="accounting_period.version";
	
	protected void checkVersionOfAccountingPeriod(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingPeriod(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_PERIOD,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.id";
	
	protected void checkIdOfAccountingDocumentType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingDocumentType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_DOCUMENT_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.name";
	
	protected void checkNameOfAccountingDocumentType(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfAccountingDocumentType(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_ACCOUNTING_DOCUMENT_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.description";
	
	protected void checkDescriptionOfAccountingDocumentType(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfAccountingDocumentType(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 18, 280, DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.version";
	
	protected void checkVersionOfAccountingDocumentType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingDocumentType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_DOCUMENT_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_DOCUMENT ="accounting_document.id";
	
	protected void checkIdOfAccountingDocument(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingDocument(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_DOCUMENT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_ACCOUNTING_DOCUMENT ="accounting_document.name";
	
	protected void checkNameOfAccountingDocument(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfAccountingDocument(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_ACCOUNTING_DOCUMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT ="accounting_document.accounting_document_date";
	
	protected void checkAccountingDocumentDateOfAccountingDocument(RetailScmUserContext userContext, Date accountingDocumentDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccountingDocumentDateOfAccountingDocument(userContext, accountingDocumentDate, exception);
			return;
		}
	 	checkDateRange(accountingDocumentDate, parseDate("2000-01-01"), parseDate("2018-09-09"), ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_ACCOUNTING_DOCUMENT ="accounting_document.current_status";
	
	protected void checkCurrentStatusOfAccountingDocument(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfAccountingDocument(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 3, 36, CURRENT_STATUS_OF_ACCOUNTING_DOCUMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT ="accounting_document.version";
	
	protected void checkVersionOfAccountingDocument(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingDocument(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_DOCUMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.id";
	
	protected void checkIdOfAccountingDocumentCreation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingDocumentCreation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_DOCUMENT_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.who";
	
	protected void checkWhoOfAccountingDocumentCreation(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfAccountingDocumentCreation(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 16, WHO_OF_ACCOUNTING_DOCUMENT_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.comments";
	
	protected void checkCommentsOfAccountingDocumentCreation(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfAccountingDocumentCreation(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 2, 16, COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.make_date";
	
	protected void checkMakeDateOfAccountingDocumentCreation(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfAccountingDocumentCreation(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2017-09-09"), MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.version";
	
	protected void checkVersionOfAccountingDocumentCreation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingDocumentCreation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_DOCUMENT_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.id";
	
	protected void checkIdOfAccountingDocumentConfirmation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingDocumentConfirmation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.who";
	
	protected void checkWhoOfAccountingDocumentConfirmation(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfAccountingDocumentConfirmation(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 16, WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.comments";
	
	protected void checkCommentsOfAccountingDocumentConfirmation(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfAccountingDocumentConfirmation(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 2, 16, COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.make_date";
	
	protected void checkMakeDateOfAccountingDocumentConfirmation(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfAccountingDocumentConfirmation(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2017-09-09"), MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.version";
	
	protected void checkVersionOfAccountingDocumentConfirmation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingDocumentConfirmation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.id";
	
	protected void checkIdOfAccountingDocumentAuditing(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingDocumentAuditing(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_DOCUMENT_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.who";
	
	protected void checkWhoOfAccountingDocumentAuditing(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfAccountingDocumentAuditing(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 16, WHO_OF_ACCOUNTING_DOCUMENT_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.comments";
	
	protected void checkCommentsOfAccountingDocumentAuditing(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfAccountingDocumentAuditing(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 4, 60, COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.make_date";
	
	protected void checkMakeDateOfAccountingDocumentAuditing(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfAccountingDocumentAuditing(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2017-09-09"), MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.version";
	
	protected void checkVersionOfAccountingDocumentAuditing(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingDocumentAuditing(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.id";
	
	protected void checkIdOfAccountingDocumentPosting(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingDocumentPosting(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_DOCUMENT_POSTING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.who";
	
	protected void checkWhoOfAccountingDocumentPosting(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfAccountingDocumentPosting(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 16, WHO_OF_ACCOUNTING_DOCUMENT_POSTING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.comments";
	
	protected void checkCommentsOfAccountingDocumentPosting(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfAccountingDocumentPosting(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 4, 60, COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.make_date";
	
	protected void checkMakeDateOfAccountingDocumentPosting(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfAccountingDocumentPosting(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2017-09-09"), MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.version";
	
	protected void checkVersionOfAccountingDocumentPosting(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingDocumentPosting(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_DOCUMENT_POSTING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ORIGINAL_VOUCHER ="original_voucher.id";
	
	protected void checkIdOfOriginalVoucher(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfOriginalVoucher(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_ORIGINAL_VOUCHER ="original_voucher.title";
	
	protected void checkTitleOfOriginalVoucher(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfOriginalVoucher(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 2, 28, TITLE_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  MADE_BY_OF_ORIGINAL_VOUCHER ="original_voucher.made_by";
	
	protected void checkMadeByOfOriginalVoucher(RetailScmUserContext userContext, String madeBy, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMadeByOfOriginalVoucher(userContext, madeBy, exception);
			return;
		}
	 	checkStringLengthRange(madeBy, 1, 12, MADE_BY_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  RECEIVED_BY_OF_ORIGINAL_VOUCHER ="original_voucher.received_by";
	
	protected void checkReceivedByOfOriginalVoucher(RetailScmUserContext userContext, String receivedBy, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkReceivedByOfOriginalVoucher(userContext, receivedBy, exception);
			return;
		}
	 	checkStringLengthRange(receivedBy, 1, 12, RECEIVED_BY_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  VOUCHER_TYPE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_type";
	
	protected void checkVoucherTypeOfOriginalVoucher(RetailScmUserContext userContext, String voucherType, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVoucherTypeOfOriginalVoucher(userContext, voucherType, exception);
			return;
		}
	 	checkStringLengthRange(voucherType, 2, 16, VOUCHER_TYPE_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_image";
	
	protected void checkVoucherImageOfOriginalVoucher(RetailScmUserContext userContext, String voucherImage, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVoucherImageOfOriginalVoucher(userContext, voucherImage, exception);
			return;
		}
	 	checkImage(voucherImage, 6, 52, VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_ORIGINAL_VOUCHER ="original_voucher.current_status";
	
	protected void checkCurrentStatusOfOriginalVoucher(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfOriginalVoucher(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 3, 36, CURRENT_STATUS_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ORIGINAL_VOUCHER ="original_voucher.version";
	
	protected void checkVersionOfOriginalVoucher(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfOriginalVoucher(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ORIGINAL_VOUCHER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.id";
	
	protected void checkIdOfOriginalVoucherCreation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfOriginalVoucherCreation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ORIGINAL_VOUCHER_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.who";
	
	protected void checkWhoOfOriginalVoucherCreation(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfOriginalVoucherCreation(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 16, WHO_OF_ORIGINAL_VOUCHER_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.comments";
	
	protected void checkCommentsOfOriginalVoucherCreation(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfOriginalVoucherCreation(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 2, 16, COMMENTS_OF_ORIGINAL_VOUCHER_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.make_date";
	
	protected void checkMakeDateOfOriginalVoucherCreation(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfOriginalVoucherCreation(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2017-09-09"), MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.version";
	
	protected void checkVersionOfOriginalVoucherCreation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfOriginalVoucherCreation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ORIGINAL_VOUCHER_CREATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.id";
	
	protected void checkIdOfOriginalVoucherConfirmation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfOriginalVoucherConfirmation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ORIGINAL_VOUCHER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.who";
	
	protected void checkWhoOfOriginalVoucherConfirmation(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfOriginalVoucherConfirmation(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 16, WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.comments";
	
	protected void checkCommentsOfOriginalVoucherConfirmation(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfOriginalVoucherConfirmation(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 2, 16, COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.make_date";
	
	protected void checkMakeDateOfOriginalVoucherConfirmation(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfOriginalVoucherConfirmation(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2017-09-09"), MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.version";
	
	protected void checkVersionOfOriginalVoucherConfirmation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfOriginalVoucherConfirmation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.id";
	
	protected void checkIdOfOriginalVoucherAuditing(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfOriginalVoucherAuditing(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ORIGINAL_VOUCHER_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.who";
	
	protected void checkWhoOfOriginalVoucherAuditing(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfOriginalVoucherAuditing(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 16, WHO_OF_ORIGINAL_VOUCHER_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.comments";
	
	protected void checkCommentsOfOriginalVoucherAuditing(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfOriginalVoucherAuditing(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 4, 60, COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.make_date";
	
	protected void checkMakeDateOfOriginalVoucherAuditing(RetailScmUserContext userContext, Date makeDate, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMakeDateOfOriginalVoucherAuditing(userContext, makeDate, exception);
			return;
		}
	 	checkDateRange(makeDate, parseDate("2000-01-01"), parseDate("2017-09-09"), MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.version";
	
	protected void checkVersionOfOriginalVoucherAuditing(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfOriginalVoucherAuditing(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ORIGINAL_VOUCHER_AUDITING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.id";
	
	protected void checkIdOfAccountingDocumentLine(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfAccountingDocumentLine(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_ACCOUNTING_DOCUMENT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.name";
	
	protected void checkNameOfAccountingDocumentLine(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfAccountingDocumentLine(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_ACCOUNTING_DOCUMENT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.code";
	
	protected void checkCodeOfAccountingDocumentLine(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfAccountingDocumentLine(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 24, CODE_OF_ACCOUNTING_DOCUMENT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  DIRECT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.direct";
	
	protected void checkDirectOfAccountingDocumentLine(RetailScmUserContext userContext, String direct, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDirectOfAccountingDocumentLine(userContext, direct, exception);
			return;
		}
	 	checkStringLengthRange(direct, 1, 4, DIRECT_OF_ACCOUNTING_DOCUMENT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.amount";
	
	protected void checkAmountOfAccountingDocumentLine(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfAccountingDocumentLine(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 989127.99, AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.version";
	
	protected void checkVersionOfAccountingDocumentLine(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfAccountingDocumentLine(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_ACCOUNTING_DOCUMENT_LINE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	
	protected void checkIdOfUserDomain(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfUserDomain(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_USER_DOMAIN,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	
	protected void checkNameOfUserDomain(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfUserDomain(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_USER_DOMAIN,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	
	protected void checkVersionOfUserDomain(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfUserDomain(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_USER_DOMAIN,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	
	protected void checkIdOfSecUser(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSecUser(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SEC_USER,exception); 		
	}
	 		
	 			 		
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	
	protected void checkLoginOfSecUser(RetailScmUserContext userContext, String login, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLoginOfSecUser(userContext, login, exception);
			return;
		}
	 	checkStringLengthRange(login, 2, 20, LOGIN_OF_SEC_USER,exception); 		
	}
	 		
	 			 		
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	
	protected void checkMobileOfSecUser(RetailScmUserContext userContext, String mobile, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkMobileOfSecUser(userContext, mobile, exception);
			return;
		}
	 	checkChinaMobilePhone(mobile, 5, 44, MOBILE_OF_SEC_USER,exception); 		
	}
	 		
	 			 		
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	
	protected void checkEmailOfSecUser(RetailScmUserContext userContext, String email, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEmailOfSecUser(userContext, email, exception);
			return;
		}
	 	checkEmail(email, 9, 76, EMAIL_OF_SEC_USER,exception); 		
	}
	 		
	 			 		
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	
	protected void checkPwdOfSecUser(RetailScmUserContext userContext, String pwd, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPwdOfSecUser(userContext, pwd, exception);
			return;
		}
	 	checkPassword(pwd, 3, 28, PWD_OF_SEC_USER,exception); 		
	}
	 		
	 			 		
	public static final String  LAST_LOGIN_OF_SEC_USER ="sec_user.last_login";
	
	protected void checkLastLoginOfSecUser(RetailScmUserContext userContext, Date lastLogin, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLastLoginOfSecUser(userContext, lastLogin, exception);
			return;
		}
	 	checkDateRange(lastLogin, parseDate("2000-01-01"), parseDate("2017-03-10"), LAST_LOGIN_OF_SEC_USER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	
	protected void checkVersionOfSecUser(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSecUser(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SEC_USER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_USER_APP ="user_app.id";
	
	protected void checkIdOfUserApp(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfUserApp(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	
	protected void checkTitleOfUserApp(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfUserApp(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 2, 24, TITLE_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	
	protected void checkAppIconOfUserApp(RetailScmUserContext userContext, String appIcon, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAppIconOfUserApp(userContext, appIcon, exception);
			return;
		}
	 	checkImage(appIcon, 11, 92, APP_ICON_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	
	protected void checkFullAccessOfUserApp(RetailScmUserContext userContext, boolean fullAccess, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFullAccessOfUserApp(userContext, fullAccess, exception);
			return;
		}
	 	checkBooleanRange(fullAccess, 0, true, FULL_ACCESS_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	
	protected void checkPermissionOfUserApp(RetailScmUserContext userContext, String permission, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPermissionOfUserApp(userContext, permission, exception);
			return;
		}
	 	checkStringLengthRange(permission, 2, 16, PERMISSION_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	
	protected void checkObjectTypeOfUserApp(RetailScmUserContext userContext, String objectType, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkObjectTypeOfUserApp(userContext, objectType, exception);
			return;
		}
	 	checkStringLengthRange(objectType, 7, 96, OBJECT_TYPE_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	
	protected void checkObjectIdOfUserApp(RetailScmUserContext userContext, String objectId, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkObjectIdOfUserApp(userContext, objectId, exception);
			return;
		}
	 	checkStringLengthRange(objectId, 3, 40, OBJECT_ID_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	
	protected void checkLocationOfUserApp(RetailScmUserContext userContext, String location, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLocationOfUserApp(userContext, location, exception);
			return;
		}
	 	checkStringLengthRange(location, 4, 48, LOCATION_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	
	protected void checkVersionOfUserApp(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfUserApp(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_USER_APP,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	
	protected void checkIdOfObjectAccess(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfObjectAccess(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  DISPLAY_NAME_OF_OBJECT_ACCESS ="object_access.display_name";
	
	protected void checkDisplayNameOfObjectAccess(RetailScmUserContext userContext, String displayName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDisplayNameOfObjectAccess(userContext, displayName, exception);
			return;
		}
	 	checkStringLengthRange(displayName, 2, 28, DISPLAY_NAME_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	
	protected void checkObjectTypeOfObjectAccess(RetailScmUserContext userContext, String objectType, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkObjectTypeOfObjectAccess(userContext, objectType, exception);
			return;
		}
	 	checkStringLengthRange(objectType, 7, 96, OBJECT_TYPE_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	
	protected void checkList1OfObjectAccess(RetailScmUserContext userContext, String list1, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList1OfObjectAccess(userContext, list1, exception);
			return;
		}
	 	checkStringLengthRange(list1, 6, 80, LIST1_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	
	protected void checkList2OfObjectAccess(RetailScmUserContext userContext, String list2, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList2OfObjectAccess(userContext, list2, exception);
			return;
		}
	 	checkStringLengthRange(list2, 6, 80, LIST2_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	
	protected void checkList3OfObjectAccess(RetailScmUserContext userContext, String list3, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList3OfObjectAccess(userContext, list3, exception);
			return;
		}
	 	checkStringLengthRange(list3, 6, 80, LIST3_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	
	protected void checkList4OfObjectAccess(RetailScmUserContext userContext, String list4, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList4OfObjectAccess(userContext, list4, exception);
			return;
		}
	 	checkStringLengthRange(list4, 6, 80, LIST4_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	
	protected void checkList5OfObjectAccess(RetailScmUserContext userContext, String list5, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList5OfObjectAccess(userContext, list5, exception);
			return;
		}
	 	checkStringLengthRange(list5, 6, 80, LIST5_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	
	protected void checkList6OfObjectAccess(RetailScmUserContext userContext, String list6, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList6OfObjectAccess(userContext, list6, exception);
			return;
		}
	 	checkStringLengthRange(list6, 6, 80, LIST6_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	
	protected void checkList7OfObjectAccess(RetailScmUserContext userContext, String list7, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList7OfObjectAccess(userContext, list7, exception);
			return;
		}
	 	checkStringLengthRange(list7, 6, 80, LIST7_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	
	protected void checkList8OfObjectAccess(RetailScmUserContext userContext, String list8, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList8OfObjectAccess(userContext, list8, exception);
			return;
		}
	 	checkStringLengthRange(list8, 6, 80, LIST8_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	
	protected void checkList9OfObjectAccess(RetailScmUserContext userContext, String list9, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkList9OfObjectAccess(userContext, list9, exception);
			return;
		}
	 	checkStringLengthRange(list9, 6, 80, LIST9_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	
	protected void checkVersionOfObjectAccess(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfObjectAccess(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_OBJECT_ACCESS,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.id";
	
	protected void checkIdOfLevelOneDepartment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfLevelOneDepartment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_LEVEL_ONE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.name";
	
	protected void checkNameOfLevelOneDepartment(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfLevelOneDepartment(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 20, NAME_OF_LEVEL_ONE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.description";
	
	protected void checkDescriptionOfLevelOneDepartment(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfLevelOneDepartment(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 5, 72, DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  MANAGER_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.manager";
	
	protected void checkManagerOfLevelOneDepartment(RetailScmUserContext userContext, String manager, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkManagerOfLevelOneDepartment(userContext, manager, exception);
			return;
		}
	 	checkStringLengthRange(manager, 1, 12, MANAGER_OF_LEVEL_ONE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.founded";
	
	protected void checkFoundedOfLevelOneDepartment(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfLevelOneDepartment(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_LEVEL_ONE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.version";
	
	protected void checkVersionOfLevelOneDepartment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfLevelOneDepartment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LEVEL_ONE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.id";
	
	protected void checkIdOfLevelTwoDepartment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfLevelTwoDepartment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_LEVEL_TWO_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.name";
	
	protected void checkNameOfLevelTwoDepartment(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfLevelTwoDepartment(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 3, 40, NAME_OF_LEVEL_TWO_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.description";
	
	protected void checkDescriptionOfLevelTwoDepartment(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfLevelTwoDepartment(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 5, 72, DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.founded";
	
	protected void checkFoundedOfLevelTwoDepartment(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfLevelTwoDepartment(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_LEVEL_TWO_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.version";
	
	protected void checkVersionOfLevelTwoDepartment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfLevelTwoDepartment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LEVEL_TWO_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.id";
	
	protected void checkIdOfLevelThreeDepartment(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfLevelThreeDepartment(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_LEVEL_THREE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.name";
	
	protected void checkNameOfLevelThreeDepartment(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfLevelThreeDepartment(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 4, 52, NAME_OF_LEVEL_THREE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.description";
	
	protected void checkDescriptionOfLevelThreeDepartment(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfLevelThreeDepartment(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 5, 72, DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  FOUNDED_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.founded";
	
	protected void checkFoundedOfLevelThreeDepartment(RetailScmUserContext userContext, Date founded, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFoundedOfLevelThreeDepartment(userContext, founded, exception);
			return;
		}
	 	checkDatePast(founded, parseDate("1900-01-01"), new Date(), FOUNDED_OF_LEVEL_THREE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.version";
	
	protected void checkVersionOfLevelThreeDepartment(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfLevelThreeDepartment(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LEVEL_THREE_DEPARTMENT,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SKILL_TYPE ="skill_type.id";
	
	protected void checkIdOfSkillType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSkillType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SKILL_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_SKILL_TYPE ="skill_type.code";
	
	protected void checkCodeOfSkillType(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfSkillType(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 20, CODE_OF_SKILL_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_SKILL_TYPE ="skill_type.description";
	
	protected void checkDescriptionOfSkillType(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfSkillType(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 2, 24, DESCRIPTION_OF_SKILL_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SKILL_TYPE ="skill_type.version";
	
	protected void checkVersionOfSkillType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSkillType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SKILL_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_RESPONSIBILITY_TYPE ="responsibility_type.id";
	
	protected void checkIdOfResponsibilityType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfResponsibilityType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_RESPONSIBILITY_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_RESPONSIBILITY_TYPE ="responsibility_type.code";
	
	protected void checkCodeOfResponsibilityType(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfResponsibilityType(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 20, CODE_OF_RESPONSIBILITY_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.base_description";
	
	protected void checkBaseDescriptionOfResponsibilityType(RetailScmUserContext userContext, String baseDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBaseDescriptionOfResponsibilityType(userContext, baseDescription, exception);
			return;
		}
	 	checkStringLengthRange(baseDescription, 2, 16, BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.detail_description";
	
	protected void checkDetailDescriptionOfResponsibilityType(RetailScmUserContext userContext, String detailDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDetailDescriptionOfResponsibilityType(userContext, detailDescription, exception);
			return;
		}
	 	checkStringLengthRange(detailDescription, 8, 116, DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_RESPONSIBILITY_TYPE ="responsibility_type.version";
	
	protected void checkVersionOfResponsibilityType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfResponsibilityType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_RESPONSIBILITY_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TERMINATION_REASON ="termination_reason.id";
	
	protected void checkIdOfTerminationReason(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTerminationReason(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TERMINATION_REASON,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_TERMINATION_REASON ="termination_reason.code";
	
	protected void checkCodeOfTerminationReason(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfTerminationReason(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 28, CODE_OF_TERMINATION_REASON,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_TERMINATION_REASON ="termination_reason.description";
	
	protected void checkDescriptionOfTerminationReason(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfTerminationReason(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 3, 36, DESCRIPTION_OF_TERMINATION_REASON,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TERMINATION_REASON ="termination_reason.version";
	
	protected void checkVersionOfTerminationReason(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTerminationReason(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TERMINATION_REASON,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TERMINATION_TYPE ="termination_type.id";
	
	protected void checkIdOfTerminationType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTerminationType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TERMINATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_TERMINATION_TYPE ="termination_type.code";
	
	protected void checkCodeOfTerminationType(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfTerminationType(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 28, CODE_OF_TERMINATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  BASE_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.base_description";
	
	protected void checkBaseDescriptionOfTerminationType(RetailScmUserContext userContext, String baseDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBaseDescriptionOfTerminationType(userContext, baseDescription, exception);
			return;
		}
	 	checkStringLengthRange(baseDescription, 2, 16, BASE_DESCRIPTION_OF_TERMINATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DETAIL_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.detail_description";
	
	protected void checkDetailDescriptionOfTerminationType(RetailScmUserContext userContext, String detailDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDetailDescriptionOfTerminationType(userContext, detailDescription, exception);
			return;
		}
	 	checkStringLengthRange(detailDescription, 16, 248, DETAIL_DESCRIPTION_OF_TERMINATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TERMINATION_TYPE ="termination_type.version";
	
	protected void checkVersionOfTerminationType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTerminationType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TERMINATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_OCCUPATION_TYPE ="occupation_type.id";
	
	protected void checkIdOfOccupationType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfOccupationType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_OCCUPATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_OCCUPATION_TYPE ="occupation_type.code";
	
	protected void checkCodeOfOccupationType(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfOccupationType(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 24, CODE_OF_OCCUPATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.description";
	
	protected void checkDescriptionOfOccupationType(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfOccupationType(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 2, 28, DESCRIPTION_OF_OCCUPATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.detail_description";
	
	protected void checkDetailDescriptionOfOccupationType(RetailScmUserContext userContext, String detailDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDetailDescriptionOfOccupationType(userContext, detailDescription, exception);
			return;
		}
	 	checkStringLengthRange(detailDescription, 16, 244, DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_OCCUPATION_TYPE ="occupation_type.version";
	
	protected void checkVersionOfOccupationType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfOccupationType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_OCCUPATION_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_LEAVE_TYPE ="leave_type.id";
	
	protected void checkIdOfLeaveType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfLeaveType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_LEAVE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_LEAVE_TYPE ="leave_type.code";
	
	protected void checkCodeOfLeaveType(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfLeaveType(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 24, CODE_OF_LEAVE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_LEAVE_TYPE ="leave_type.description";
	
	protected void checkDescriptionOfLeaveType(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfLeaveType(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 2, 16, DESCRIPTION_OF_LEAVE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DETAIL_DESCRIPTION_OF_LEAVE_TYPE ="leave_type.detail_description";
	
	protected void checkDetailDescriptionOfLeaveType(RetailScmUserContext userContext, String detailDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDetailDescriptionOfLeaveType(userContext, detailDescription, exception);
			return;
		}
	 	checkStringLengthRange(detailDescription, 16, 244, DETAIL_DESCRIPTION_OF_LEAVE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_LEAVE_TYPE ="leave_type.version";
	
	protected void checkVersionOfLeaveType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfLeaveType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_LEAVE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SALARY_GRADE ="salary_grade.id";
	
	protected void checkIdOfSalaryGrade(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfSalaryGrade(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SALARY_GRADE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_SALARY_GRADE ="salary_grade.code";
	
	protected void checkCodeOfSalaryGrade(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfSalaryGrade(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 24, CODE_OF_SALARY_GRADE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_SALARY_GRADE ="salary_grade.name";
	
	protected void checkNameOfSalaryGrade(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfSalaryGrade(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_SALARY_GRADE,exception); 		
	}
	 		
	 			 		
	public static final String  DETAIL_DESCRIPTION_OF_SALARY_GRADE ="salary_grade.detail_description";
	
	protected void checkDetailDescriptionOfSalaryGrade(RetailScmUserContext userContext, String detailDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDetailDescriptionOfSalaryGrade(userContext, detailDescription, exception);
			return;
		}
	 	checkStringLengthRange(detailDescription, 16, 244, DETAIL_DESCRIPTION_OF_SALARY_GRADE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SALARY_GRADE ="salary_grade.version";
	
	protected void checkVersionOfSalaryGrade(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfSalaryGrade(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SALARY_GRADE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_INTERVIEW_TYPE ="interview_type.id";
	
	protected void checkIdOfInterviewType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfInterviewType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_INTERVIEW_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_INTERVIEW_TYPE ="interview_type.code";
	
	protected void checkCodeOfInterviewType(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfInterviewType(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 3, 32, CODE_OF_INTERVIEW_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.description";
	
	protected void checkDescriptionOfInterviewType(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfInterviewType(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 2, 24, DESCRIPTION_OF_INTERVIEW_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.detail_description";
	
	protected void checkDetailDescriptionOfInterviewType(RetailScmUserContext userContext, String detailDescription, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDetailDescriptionOfInterviewType(userContext, detailDescription, exception);
			return;
		}
	 	checkStringLengthRange(detailDescription, 16, 244, DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_INTERVIEW_TYPE ="interview_type.version";
	
	protected void checkVersionOfInterviewType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfInterviewType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_INTERVIEW_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TRAINING_COURSE_TYPE ="training_course_type.id";
	
	protected void checkIdOfTrainingCourseType(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTrainingCourseType(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TRAINING_COURSE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_TRAINING_COURSE_TYPE ="training_course_type.code";
	
	protected void checkCodeOfTrainingCourseType(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfTrainingCourseType(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 16, CODE_OF_TRAINING_COURSE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_TRAINING_COURSE_TYPE ="training_course_type.name";
	
	protected void checkNameOfTrainingCourseType(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfTrainingCourseType(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 2, 16, NAME_OF_TRAINING_COURSE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_TRAINING_COURSE_TYPE ="training_course_type.description";
	
	protected void checkDescriptionOfTrainingCourseType(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfTrainingCourseType(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 5, 64, DESCRIPTION_OF_TRAINING_COURSE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TRAINING_COURSE_TYPE ="training_course_type.version";
	
	protected void checkVersionOfTrainingCourseType(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTrainingCourseType(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TRAINING_COURSE_TYPE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_PUBLIC_HOLIDAY ="public_holiday.id";
	
	protected void checkIdOfPublicHoliday(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfPublicHoliday(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_PUBLIC_HOLIDAY,exception); 		
	}
	 		
	 			 		
	public static final String  CODE_OF_PUBLIC_HOLIDAY ="public_holiday.code";
	
	protected void checkCodeOfPublicHoliday(RetailScmUserContext userContext, String code, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCodeOfPublicHoliday(userContext, code, exception);
			return;
		}
	 	checkStringLengthRange(code, 2, 16, CODE_OF_PUBLIC_HOLIDAY,exception); 		
	}
	 		
	 			 		
	public static final String  NAME_OF_PUBLIC_HOLIDAY ="public_holiday.name";
	
	protected void checkNameOfPublicHoliday(RetailScmUserContext userContext, String name, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkNameOfPublicHoliday(userContext, name, exception);
			return;
		}
	 	checkStringLengthRange(name, 1, 12, NAME_OF_PUBLIC_HOLIDAY,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_PUBLIC_HOLIDAY ="public_holiday.description";
	
	protected void checkDescriptionOfPublicHoliday(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfPublicHoliday(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 3, 40, DESCRIPTION_OF_PUBLIC_HOLIDAY,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_PUBLIC_HOLIDAY ="public_holiday.version";
	
	protected void checkVersionOfPublicHoliday(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfPublicHoliday(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PUBLIC_HOLIDAY,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_TERMINATION ="termination.id";
	
	protected void checkIdOfTermination(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfTermination(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_TERMINATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_TERMINATION ="termination.comment";
	
	protected void checkCommentOfTermination(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfTermination(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 2, 16, COMMENT_OF_TERMINATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_TERMINATION ="termination.version";
	
	protected void checkVersionOfTermination(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfTermination(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_TERMINATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_VIEW ="view.id";
	
	protected void checkIdOfView(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfView(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_VIEW,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_VIEW ="view.who";
	
	protected void checkWhoOfView(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfView(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_VIEW,exception); 		
	}
	 		
	 			 		
	public static final String  ASSESSMENT_OF_VIEW ="view.assessment";
	
	protected void checkAssessmentOfView(RetailScmUserContext userContext, String assessment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAssessmentOfView(userContext, assessment, exception);
			return;
		}
	 	checkStringLengthRange(assessment, 3, 40, ASSESSMENT_OF_VIEW,exception); 		
	}
	 		
	 			 		
	public static final String  INTERVIEW_TIME_OF_VIEW ="view.interview_time";
	
	protected void checkInterviewTimeOfView(RetailScmUserContext userContext, Date interviewTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkInterviewTimeOfView(userContext, interviewTime, exception);
			return;
		}
	 	checkDateRange(interviewTime, parseDate("2000-01-01"), parseDate("2017-03-03"), INTERVIEW_TIME_OF_VIEW,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_VIEW ="view.version";
	
	protected void checkVersionOfView(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfView(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_VIEW,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE ="employee.id";
	
	protected void checkIdOfEmployee(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployee(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_EMPLOYEE ="employee.title";
	
	protected void checkTitleOfEmployee(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfEmployee(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 1, 12, TITLE_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  FAMILY_NAME_OF_EMPLOYEE ="employee.family_name";
	
	protected void checkFamilyNameOfEmployee(RetailScmUserContext userContext, String familyName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFamilyNameOfEmployee(userContext, familyName, exception);
			return;
		}
	 	checkStringLengthRange(familyName, 1, 4, FAMILY_NAME_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  GIVEN_NAME_OF_EMPLOYEE ="employee.given_name";
	
	protected void checkGivenNameOfEmployee(RetailScmUserContext userContext, String givenName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkGivenNameOfEmployee(userContext, givenName, exception);
			return;
		}
	 	checkStringLengthRange(givenName, 1, 8, GIVEN_NAME_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  EMAIL_OF_EMPLOYEE ="employee.email";
	
	protected void checkEmailOfEmployee(RetailScmUserContext userContext, String email, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEmailOfEmployee(userContext, email, exception);
			return;
		}
	 	checkEmail(email, 6, 52, EMAIL_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  CITY_OF_EMPLOYEE ="employee.city";
	
	protected void checkCityOfEmployee(RetailScmUserContext userContext, String city, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCityOfEmployee(userContext, city, exception);
			return;
		}
	 	checkStringLengthRange(city, 1, 8, CITY_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  ADDRESS_OF_EMPLOYEE ="employee.address";
	
	protected void checkAddressOfEmployee(RetailScmUserContext userContext, String address, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAddressOfEmployee(userContext, address, exception);
			return;
		}
	 	checkStringLengthRange(address, 2, 28, ADDRESS_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  CELL_PHONE_OF_EMPLOYEE ="employee.cell_phone";
	
	protected void checkCellPhoneOfEmployee(RetailScmUserContext userContext, String cellPhone, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCellPhoneOfEmployee(userContext, cellPhone, exception);
			return;
		}
	 	checkChinaMobilePhone(cellPhone, 5, 44, CELL_PHONE_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  SALARY_ACCOUNT_OF_EMPLOYEE ="employee.salary_account";
	
	protected void checkSalaryAccountOfEmployee(RetailScmUserContext userContext, String salaryAccount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSalaryAccountOfEmployee(userContext, salaryAccount, exception);
			return;
		}
	 	checkStringLengthRange(salaryAccount, 4, 60, SALARY_ACCOUNT_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_EMPLOYEE ="employee.current_status";
	
	protected void checkCurrentStatusOfEmployee(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfEmployee(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 6, 88, CURRENT_STATUS_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE ="employee.version";
	
	protected void checkVersionOfEmployee(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployee(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_JOB_APPLICATION ="job_application.id";
	
	protected void checkIdOfJobApplication(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfJobApplication(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_JOB_APPLICATION,exception); 		
	}
	 		
	 			 		
	public static final String  APPLICATION_TIME_OF_JOB_APPLICATION ="job_application.application_time";
	
	protected void checkApplicationTimeOfJobApplication(RetailScmUserContext userContext, Date applicationTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkApplicationTimeOfJobApplication(userContext, applicationTime, exception);
			return;
		}
	 	checkDateRange(applicationTime, parseDate("2000-01-01"), parseDate("2018-03-04"), APPLICATION_TIME_OF_JOB_APPLICATION,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_JOB_APPLICATION ="job_application.who";
	
	protected void checkWhoOfJobApplication(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfJobApplication(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 20, WHO_OF_JOB_APPLICATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_JOB_APPLICATION ="job_application.comments";
	
	protected void checkCommentsOfJobApplication(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfJobApplication(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 8, 124, COMMENTS_OF_JOB_APPLICATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_JOB_APPLICATION ="job_application.version";
	
	protected void checkVersionOfJobApplication(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfJobApplication(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_JOB_APPLICATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_PROFESSION_INTERVIEW ="profession_interview.id";
	
	protected void checkIdOfProfessionInterview(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfProfessionInterview(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_PROFESSION_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_PROFESSION_INTERVIEW ="profession_interview.who";
	
	protected void checkWhoOfProfessionInterview(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfProfessionInterview(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_PROFESSION_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  INTERVIEW_TIME_OF_PROFESSION_INTERVIEW ="profession_interview.interview_time";
	
	protected void checkInterviewTimeOfProfessionInterview(RetailScmUserContext userContext, Date interviewTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkInterviewTimeOfProfessionInterview(userContext, interviewTime, exception);
			return;
		}
	 	checkDateRange(interviewTime, parseDate("2000-01-01"), parseDate("2018-03-04"), INTERVIEW_TIME_OF_PROFESSION_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_PROFESSION_INTERVIEW ="profession_interview.comments";
	
	protected void checkCommentsOfProfessionInterview(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfProfessionInterview(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 4, 60, COMMENTS_OF_PROFESSION_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_PROFESSION_INTERVIEW ="profession_interview.version";
	
	protected void checkVersionOfProfessionInterview(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfProfessionInterview(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PROFESSION_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_HR_INTERVIEW ="hr_interview.id";
	
	protected void checkIdOfHrInterview(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfHrInterview(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_HR_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_HR_INTERVIEW ="hr_interview.who";
	
	protected void checkWhoOfHrInterview(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfHrInterview(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 20, WHO_OF_HR_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  INTERVIEW_TIME_OF_HR_INTERVIEW ="hr_interview.interview_time";
	
	protected void checkInterviewTimeOfHrInterview(RetailScmUserContext userContext, Date interviewTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkInterviewTimeOfHrInterview(userContext, interviewTime, exception);
			return;
		}
	 	checkDateRange(interviewTime, parseDate("2000-01-01"), parseDate("2018-03-04"), INTERVIEW_TIME_OF_HR_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_HR_INTERVIEW ="hr_interview.comments";
	
	protected void checkCommentsOfHrInterview(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfHrInterview(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 4, 52, COMMENTS_OF_HR_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_HR_INTERVIEW ="hr_interview.version";
	
	protected void checkVersionOfHrInterview(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfHrInterview(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_HR_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_OFFER_APPROVAL ="offer_approval.id";
	
	protected void checkIdOfOfferApproval(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfOfferApproval(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_OFFER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_OFFER_APPROVAL ="offer_approval.who";
	
	protected void checkWhoOfOfferApproval(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfOfferApproval(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_OFFER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  APPROVE_TIME_OF_OFFER_APPROVAL ="offer_approval.approve_time";
	
	protected void checkApproveTimeOfOfferApproval(RetailScmUserContext userContext, Date approveTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkApproveTimeOfOfferApproval(userContext, approveTime, exception);
			return;
		}
	 	checkDateRange(approveTime, parseDate("2000-01-01"), parseDate("2018-03-04"), APPROVE_TIME_OF_OFFER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_OFFER_APPROVAL ="offer_approval.comments";
	
	protected void checkCommentsOfOfferApproval(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfOfferApproval(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 3, 40, COMMENTS_OF_OFFER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_OFFER_APPROVAL ="offer_approval.version";
	
	protected void checkVersionOfOfferApproval(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfOfferApproval(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_OFFER_APPROVAL,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_OFFER_ACCEPTANCE ="offer_acceptance.id";
	
	protected void checkIdOfOfferAcceptance(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfOfferAcceptance(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_OFFER_ACCEPTANCE,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_OFFER_ACCEPTANCE ="offer_acceptance.who";
	
	protected void checkWhoOfOfferAcceptance(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfOfferAcceptance(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 12, WHO_OF_OFFER_ACCEPTANCE,exception); 		
	}
	 		
	 			 		
	public static final String  ACCEPT_TIME_OF_OFFER_ACCEPTANCE ="offer_acceptance.accept_time";
	
	protected void checkAcceptTimeOfOfferAcceptance(RetailScmUserContext userContext, Date acceptTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAcceptTimeOfOfferAcceptance(userContext, acceptTime, exception);
			return;
		}
	 	checkDateRange(acceptTime, parseDate("2000-01-01"), parseDate("2018-03-04"), ACCEPT_TIME_OF_OFFER_ACCEPTANCE,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_OFFER_ACCEPTANCE ="offer_acceptance.comments";
	
	protected void checkCommentsOfOfferAcceptance(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfOfferAcceptance(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 3, 40, COMMENTS_OF_OFFER_ACCEPTANCE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_OFFER_ACCEPTANCE ="offer_acceptance.version";
	
	protected void checkVersionOfOfferAcceptance(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfOfferAcceptance(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_OFFER_ACCEPTANCE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_BOARDING ="employee_boarding.id";
	
	protected void checkIdOfEmployeeBoarding(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeBoarding(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_BOARDING,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_EMPLOYEE_BOARDING ="employee_boarding.who";
	
	protected void checkWhoOfEmployeeBoarding(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfEmployeeBoarding(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 2, 20, WHO_OF_EMPLOYEE_BOARDING,exception); 		
	}
	 		
	 			 		
	public static final String  EMPLOY_TIME_OF_EMPLOYEE_BOARDING ="employee_boarding.employ_time";
	
	protected void checkEmployTimeOfEmployeeBoarding(RetailScmUserContext userContext, Date employTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEmployTimeOfEmployeeBoarding(userContext, employTime, exception);
			return;
		}
	 	checkDateRange(employTime, parseDate("2000-01-01"), parseDate("2018-03-04"), EMPLOY_TIME_OF_EMPLOYEE_BOARDING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENTS_OF_EMPLOYEE_BOARDING ="employee_boarding.comments";
	
	protected void checkCommentsOfEmployeeBoarding(RetailScmUserContext userContext, String comments, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentsOfEmployeeBoarding(userContext, comments, exception);
			return;
		}
	 	checkStringLengthRange(comments, 3, 44, COMMENTS_OF_EMPLOYEE_BOARDING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_BOARDING ="employee_boarding.version";
	
	protected void checkVersionOfEmployeeBoarding(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeBoarding(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_BOARDING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_INSTRUCTOR ="instructor.id";
	
	protected void checkIdOfInstructor(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfInstructor(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_INSTRUCTOR ="instructor.title";
	
	protected void checkTitleOfInstructor(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfInstructor(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 2, 16, TITLE_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  FAMILY_NAME_OF_INSTRUCTOR ="instructor.family_name";
	
	protected void checkFamilyNameOfInstructor(RetailScmUserContext userContext, String familyName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkFamilyNameOfInstructor(userContext, familyName, exception);
			return;
		}
	 	checkStringLengthRange(familyName, 1, 4, FAMILY_NAME_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  GIVEN_NAME_OF_INSTRUCTOR ="instructor.given_name";
	
	protected void checkGivenNameOfInstructor(RetailScmUserContext userContext, String givenName, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkGivenNameOfInstructor(userContext, givenName, exception);
			return;
		}
	 	checkStringLengthRange(givenName, 1, 8, GIVEN_NAME_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  CELL_PHONE_OF_INSTRUCTOR ="instructor.cell_phone";
	
	protected void checkCellPhoneOfInstructor(RetailScmUserContext userContext, String cellPhone, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCellPhoneOfInstructor(userContext, cellPhone, exception);
			return;
		}
	 	checkChinaMobilePhone(cellPhone, 5, 44, CELL_PHONE_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  EMAIL_OF_INSTRUCTOR ="instructor.email";
	
	protected void checkEmailOfInstructor(RetailScmUserContext userContext, String email, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEmailOfInstructor(userContext, email, exception);
			return;
		}
	 	checkEmail(email, 10, 80, EMAIL_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  INTRODUCTION_OF_INSTRUCTOR ="instructor.introduction";
	
	protected void checkIntroductionOfInstructor(RetailScmUserContext userContext, String introduction, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIntroductionOfInstructor(userContext, introduction, exception);
			return;
		}
	 	checkStringLengthRange(introduction, 4, 60, INTRODUCTION_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_INSTRUCTOR ="instructor.version";
	
	protected void checkVersionOfInstructor(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfInstructor(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_INSTRUCTOR,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_COMPANY_TRAINING ="company_training.id";
	
	protected void checkIdOfCompanyTraining(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfCompanyTraining(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  TITLE_OF_COMPANY_TRAINING ="company_training.title";
	
	protected void checkTitleOfCompanyTraining(RetailScmUserContext userContext, String title, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTitleOfCompanyTraining(userContext, title, exception);
			return;
		}
	 	checkStringLengthRange(title, 2, 16, TITLE_OF_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  TIME_START_OF_COMPANY_TRAINING ="company_training.time_start";
	
	protected void checkTimeStartOfCompanyTraining(RetailScmUserContext userContext, Date timeStart, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTimeStartOfCompanyTraining(userContext, timeStart, exception);
			return;
		}
	 	checkDatePast(timeStart, parseDate("1900-01-01"), new Date(), TIME_START_OF_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  DURATION_HOURS_OF_COMPANY_TRAINING ="company_training.duration_hours";
	
	protected void checkDurationHoursOfCompanyTraining(RetailScmUserContext userContext, int durationHours, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDurationHoursOfCompanyTraining(userContext, durationHours, exception);
			return;
		}
	 	checkIntegerRange(durationHours, 0, 3, DURATION_HOURS_OF_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_COMPANY_TRAINING ="company_training.version";
	
	protected void checkVersionOfCompanyTraining(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfCompanyTraining(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_SCORING ="scoring.id";
	
	protected void checkIdOfScoring(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfScoring(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_SCORING,exception); 		
	}
	 		
	 			 		
	public static final String  SCORED_BY_OF_SCORING ="scoring.scored_by";
	
	protected void checkScoredByOfScoring(RetailScmUserContext userContext, String scoredBy, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkScoredByOfScoring(userContext, scoredBy, exception);
			return;
		}
	 	checkStringLengthRange(scoredBy, 1, 12, SCORED_BY_OF_SCORING,exception); 		
	}
	 		
	 			 		
	public static final String  SCORE_OF_SCORING ="scoring.score";
	
	protected void checkScoreOfScoring(RetailScmUserContext userContext, int score, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkScoreOfScoring(userContext, score, exception);
			return;
		}
	 	checkIntegerRange(score, 0, 100, SCORE_OF_SCORING,exception); 		
	}
	 		
	 			 		
	public static final String  COMMENT_OF_SCORING ="scoring.comment";
	
	protected void checkCommentOfScoring(RetailScmUserContext userContext, String comment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCommentOfScoring(userContext, comment, exception);
			return;
		}
	 	checkStringLengthRange(comment, 3, 36, COMMENT_OF_SCORING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_SCORING ="scoring.version";
	
	protected void checkVersionOfScoring(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfScoring(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_SCORING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.id";
	
	protected void checkIdOfEmployeeCompanyTraining(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeCompanyTraining(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.current_status";
	
	protected void checkCurrentStatusOfEmployeeCompanyTraining(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfEmployeeCompanyTraining(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 2, 24, CURRENT_STATUS_OF_EMPLOYEE_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.version";
	
	protected void checkVersionOfEmployeeCompanyTraining(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeCompanyTraining(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_COMPANY_TRAINING,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_SKILL ="employee_skill.id";
	
	protected void checkIdOfEmployeeSkill(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeSkill(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_SKILL,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_EMPLOYEE_SKILL ="employee_skill.description";
	
	protected void checkDescriptionOfEmployeeSkill(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfEmployeeSkill(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 2, 28, DESCRIPTION_OF_EMPLOYEE_SKILL,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_SKILL ="employee_skill.version";
	
	protected void checkVersionOfEmployeeSkill(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeSkill(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_SKILL,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_PERFORMANCE ="employee_performance.id";
	
	protected void checkIdOfEmployeePerformance(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeePerformance(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_PERFORMANCE,exception); 		
	}
	 		
	 			 		
	public static final String  PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE ="employee_performance.performance_comment";
	
	protected void checkPerformanceCommentOfEmployeePerformance(RetailScmUserContext userContext, String performanceComment, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPerformanceCommentOfEmployeePerformance(userContext, performanceComment, exception);
			return;
		}
	 	checkStringLengthRange(performanceComment, 2, 28, PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_PERFORMANCE ="employee_performance.version";
	
	protected void checkVersionOfEmployeePerformance(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeePerformance(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_PERFORMANCE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.id";
	
	protected void checkIdOfEmployeeWorkExperience(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeWorkExperience(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_WORK_EXPERIENCE,exception); 		
	}
	 		
	 			 		
	public static final String  START_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.start";
	
	protected void checkStartOfEmployeeWorkExperience(RetailScmUserContext userContext, Date start, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkStartOfEmployeeWorkExperience(userContext, start, exception);
			return;
		}
	 	checkDateRange(start, parseDate("2000-01-01"), parseDate("2008-01-10"), START_OF_EMPLOYEE_WORK_EXPERIENCE,exception); 		
	}
	 		
	 			 		
	public static final String  END_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.end";
	
	protected void checkEndOfEmployeeWorkExperience(RetailScmUserContext userContext, Date end, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEndOfEmployeeWorkExperience(userContext, end, exception);
			return;
		}
	 	checkDateRange(end, parseDate("2000-01-01"), parseDate("2018-01-10"), END_OF_EMPLOYEE_WORK_EXPERIENCE,exception); 		
	}
	 		
	 			 		
	public static final String  COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.company";
	
	protected void checkCompanyOfEmployeeWorkExperience(RetailScmUserContext userContext, String company, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCompanyOfEmployeeWorkExperience(userContext, company, exception);
			return;
		}
	 	checkStringLengthRange(company, 3, 32, COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE,exception); 		
	}
	 		
	 			 		
	public static final String  DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.description";
	
	protected void checkDescriptionOfEmployeeWorkExperience(RetailScmUserContext userContext, String description, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDescriptionOfEmployeeWorkExperience(userContext, description, exception);
			return;
		}
	 	checkStringLengthRange(description, 6, 84, DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.version";
	
	protected void checkVersionOfEmployeeWorkExperience(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeWorkExperience(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_WORK_EXPERIENCE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_LEAVE ="employee_leave.id";
	
	protected void checkIdOfEmployeeLeave(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeLeave(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_LEAVE,exception); 		
	}
	 		
	 			 		
	public static final String  LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE ="employee_leave.leave_duration_hour";
	
	protected void checkLeaveDurationHourOfEmployeeLeave(RetailScmUserContext userContext, int leaveDurationHour, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLeaveDurationHourOfEmployeeLeave(userContext, leaveDurationHour, exception);
			return;
		}
	 	checkIntegerRange(leaveDurationHour, 0, 8, LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE,exception); 		
	}
	 		
	 			 		
	public static final String  REMARK_OF_EMPLOYEE_LEAVE ="employee_leave.remark";
	
	protected void checkRemarkOfEmployeeLeave(RetailScmUserContext userContext, String remark, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemarkOfEmployeeLeave(userContext, remark, exception);
			return;
		}
	 	checkStringLengthRange(remark, 3, 44, REMARK_OF_EMPLOYEE_LEAVE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_LEAVE ="employee_leave.version";
	
	protected void checkVersionOfEmployeeLeave(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeLeave(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_LEAVE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_INTERVIEW ="employee_interview.id";
	
	protected void checkIdOfEmployeeInterview(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeInterview(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  REMARK_OF_EMPLOYEE_INTERVIEW ="employee_interview.remark";
	
	protected void checkRemarkOfEmployeeInterview(RetailScmUserContext userContext, String remark, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemarkOfEmployeeInterview(userContext, remark, exception);
			return;
		}
	 	checkStringLengthRange(remark, 3, 40, REMARK_OF_EMPLOYEE_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_INTERVIEW ="employee_interview.version";
	
	protected void checkVersionOfEmployeeInterview(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeInterview(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_INTERVIEW,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.id";
	
	protected void checkIdOfEmployeeAttendance(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeAttendance(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  ENTER_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.enter_time";
	
	protected void checkEnterTimeOfEmployeeAttendance(RetailScmUserContext userContext, Date enterTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkEnterTimeOfEmployeeAttendance(userContext, enterTime, exception);
			return;
		}
	 	checkDateRange(enterTime, parseDate("2000-01-01"), parseDate("2017-01-01"), ENTER_TIME_OF_EMPLOYEE_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.leave_time";
	
	protected void checkLeaveTimeOfEmployeeAttendance(RetailScmUserContext userContext, Date leaveTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLeaveTimeOfEmployeeAttendance(userContext, leaveTime, exception);
			return;
		}
	 	checkDateRange(leaveTime, parseDate("2000-01-01"), parseDate("2017-03-01"), LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.duration_hours";
	
	protected void checkDurationHoursOfEmployeeAttendance(RetailScmUserContext userContext, int durationHours, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkDurationHoursOfEmployeeAttendance(userContext, durationHours, exception);
			return;
		}
	 	checkIntegerRange(durationHours, 0, 8, DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  REMARK_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.remark";
	
	protected void checkRemarkOfEmployeeAttendance(RetailScmUserContext userContext, String remark, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemarkOfEmployeeAttendance(userContext, remark, exception);
			return;
		}
	 	checkStringLengthRange(remark, 2, 28, REMARK_OF_EMPLOYEE_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.version";
	
	protected void checkVersionOfEmployeeAttendance(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeAttendance(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_ATTENDANCE,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.id";
	
	protected void checkIdOfEmployeeQualifier(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeQualifier(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_QUALIFIER,exception); 		
	}
	 		
	 			 		
	public static final String  QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.qualified_time";
	
	protected void checkQualifiedTimeOfEmployeeQualifier(RetailScmUserContext userContext, Date qualifiedTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkQualifiedTimeOfEmployeeQualifier(userContext, qualifiedTime, exception);
			return;
		}
	 	checkDateRange(qualifiedTime, parseDate("2000-01-01"), parseDate("2017-01-01"), QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER,exception); 		
	}
	 		
	 			 		
	public static final String  TYPE_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.type";
	
	protected void checkTypeOfEmployeeQualifier(RetailScmUserContext userContext, String type, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTypeOfEmployeeQualifier(userContext, type, exception);
			return;
		}
	 	checkStringLengthRange(type, 2, 20, TYPE_OF_EMPLOYEE_QUALIFIER,exception); 		
	}
	 		
	 			 		
	public static final String  LEVEL_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.level";
	
	protected void checkLevelOfEmployeeQualifier(RetailScmUserContext userContext, String level, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkLevelOfEmployeeQualifier(userContext, level, exception);
			return;
		}
	 	checkStringLengthRange(level, 1, 8, LEVEL_OF_EMPLOYEE_QUALIFIER,exception); 		
	}
	 		
	 			 		
	public static final String  REMARK_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.remark";
	
	protected void checkRemarkOfEmployeeQualifier(RetailScmUserContext userContext, String remark, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemarkOfEmployeeQualifier(userContext, remark, exception);
			return;
		}
	 	checkStringLengthRange(remark, 3, 36, REMARK_OF_EMPLOYEE_QUALIFIER,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.version";
	
	protected void checkVersionOfEmployeeQualifier(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeQualifier(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_QUALIFIER,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_EDUCATION ="employee_education.id";
	
	protected void checkIdOfEmployeeEducation(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeEducation(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_EDUCATION,exception); 		
	}
	 		
	 			 		
	public static final String  COMPLETE_TIME_OF_EMPLOYEE_EDUCATION ="employee_education.complete_time";
	
	protected void checkCompleteTimeOfEmployeeEducation(RetailScmUserContext userContext, Date completeTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCompleteTimeOfEmployeeEducation(userContext, completeTime, exception);
			return;
		}
	 	checkDateRange(completeTime, parseDate("2000-01-01"), parseDate("2017-01-01"), COMPLETE_TIME_OF_EMPLOYEE_EDUCATION,exception); 		
	}
	 		
	 			 		
	public static final String  TYPE_OF_EMPLOYEE_EDUCATION ="employee_education.type";
	
	protected void checkTypeOfEmployeeEducation(RetailScmUserContext userContext, String type, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTypeOfEmployeeEducation(userContext, type, exception);
			return;
		}
	 	checkStringLengthRange(type, 2, 16, TYPE_OF_EMPLOYEE_EDUCATION,exception); 		
	}
	 		
	 			 		
	public static final String  REMARK_OF_EMPLOYEE_EDUCATION ="employee_education.remark";
	
	protected void checkRemarkOfEmployeeEducation(RetailScmUserContext userContext, String remark, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemarkOfEmployeeEducation(userContext, remark, exception);
			return;
		}
	 	checkStringLengthRange(remark, 3, 36, REMARK_OF_EMPLOYEE_EDUCATION,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_EDUCATION ="employee_education.version";
	
	protected void checkVersionOfEmployeeEducation(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeEducation(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_EDUCATION,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_AWARD ="employee_award.id";
	
	protected void checkIdOfEmployeeAward(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeAward(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_AWARD,exception); 		
	}
	 		
	 			 		
	public static final String  COMPLETE_TIME_OF_EMPLOYEE_AWARD ="employee_award.complete_time";
	
	protected void checkCompleteTimeOfEmployeeAward(RetailScmUserContext userContext, Date completeTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCompleteTimeOfEmployeeAward(userContext, completeTime, exception);
			return;
		}
	 	checkDateRange(completeTime, parseDate("2000-01-01"), parseDate("2017-01-01"), COMPLETE_TIME_OF_EMPLOYEE_AWARD,exception); 		
	}
	 		
	 			 		
	public static final String  TYPE_OF_EMPLOYEE_AWARD ="employee_award.type";
	
	protected void checkTypeOfEmployeeAward(RetailScmUserContext userContext, String type, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkTypeOfEmployeeAward(userContext, type, exception);
			return;
		}
	 	checkStringLengthRange(type, 2, 20, TYPE_OF_EMPLOYEE_AWARD,exception); 		
	}
	 		
	 			 		
	public static final String  REMARK_OF_EMPLOYEE_AWARD ="employee_award.remark";
	
	protected void checkRemarkOfEmployeeAward(RetailScmUserContext userContext, String remark, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRemarkOfEmployeeAward(userContext, remark, exception);
			return;
		}
	 	checkStringLengthRange(remark, 3, 36, REMARK_OF_EMPLOYEE_AWARD,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_AWARD ="employee_award.version";
	
	protected void checkVersionOfEmployeeAward(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeAward(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_AWARD,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.id";
	
	protected void checkIdOfEmployeeSalarySheet(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfEmployeeSalarySheet(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.base_salary";
	
	protected void checkBaseSalaryOfEmployeeSalarySheet(RetailScmUserContext userContext, double baseSalary, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBaseSalaryOfEmployeeSalarySheet(userContext, baseSalary, exception);
			return;
		}
	 	checkMoneyAmount(baseSalary, 0.00, 3000.10, BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  BONUS_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.bonus";
	
	protected void checkBonusOfEmployeeSalarySheet(RetailScmUserContext userContext, double bonus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkBonusOfEmployeeSalarySheet(userContext, bonus, exception);
			return;
		}
	 	checkMoneyAmount(bonus, 0.00, 1000.10, BONUS_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  REWARD_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.reward";
	
	protected void checkRewardOfEmployeeSalarySheet(RetailScmUserContext userContext, double reward, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkRewardOfEmployeeSalarySheet(userContext, reward, exception);
			return;
		}
	 	checkMoneyAmount(reward, 0.00, 1000.10, REWARD_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.personal_tax";
	
	protected void checkPersonalTaxOfEmployeeSalarySheet(RetailScmUserContext userContext, double personalTax, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPersonalTaxOfEmployeeSalarySheet(userContext, personalTax, exception);
			return;
		}
	 	checkMoneyAmount(personalTax, 0.00, 792.88, PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.social_security";
	
	protected void checkSocialSecurityOfEmployeeSalarySheet(RetailScmUserContext userContext, double socialSecurity, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkSocialSecurityOfEmployeeSalarySheet(userContext, socialSecurity, exception);
			return;
		}
	 	checkMoneyAmount(socialSecurity, 0.00, 1100.22, SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.housing_found";
	
	protected void checkHousingFoundOfEmployeeSalarySheet(RetailScmUserContext userContext, double housingFound, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkHousingFoundOfEmployeeSalarySheet(userContext, housingFound, exception);
			return;
		}
	 	checkMoneyAmount(housingFound, 0.00, 1222.99, HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.job_insurance";
	
	protected void checkJobInsuranceOfEmployeeSalarySheet(RetailScmUserContext userContext, double jobInsurance, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkJobInsuranceOfEmployeeSalarySheet(userContext, jobInsurance, exception);
			return;
		}
	 	checkMoneyAmount(jobInsurance, 0.00, 8.88, JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  CURRENT_STATUS_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.current_status";
	
	protected void checkCurrentStatusOfEmployeeSalarySheet(RetailScmUserContext userContext, String currentStatus, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkCurrentStatusOfEmployeeSalarySheet(userContext, currentStatus, exception);
			return;
		}
	 	checkStringLengthRange(currentStatus, 3, 32, CURRENT_STATUS_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.version";
	
	protected void checkVersionOfEmployeeSalarySheet(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfEmployeeSalarySheet(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_EMPLOYEE_SALARY_SHEET,exception); 		
	}
	 		
	 			 		
	public static final String  ID_OF_PAYING_OFF ="paying_off.id";
	
	protected void checkIdOfPayingOff(RetailScmUserContext userContext, String id, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkIdOfPayingOff(userContext, id, exception);
			return;
		}
	 	checkStringLengthRange(id, 5, 64, ID_OF_PAYING_OFF,exception); 		
	}
	 		
	 			 		
	public static final String  WHO_OF_PAYING_OFF ="paying_off.who";
	
	protected void checkWhoOfPayingOff(RetailScmUserContext userContext, String who, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkWhoOfPayingOff(userContext, who, exception);
			return;
		}
	 	checkStringLengthRange(who, 1, 8, WHO_OF_PAYING_OFF,exception); 		
	}
	 		
	 			 		
	public static final String  PAID_TIME_OF_PAYING_OFF ="paying_off.paid_time";
	
	protected void checkPaidTimeOfPayingOff(RetailScmUserContext userContext, Date paidTime, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkPaidTimeOfPayingOff(userContext, paidTime, exception);
			return;
		}
	 	checkDateRange(paidTime, parseDate("2000-01-01"), parseDate("2018-01-19"), PAID_TIME_OF_PAYING_OFF,exception); 		
	}
	 		
	 			 		
	public static final String  AMOUNT_OF_PAYING_OFF ="paying_off.amount";
	
	protected void checkAmountOfPayingOff(RetailScmUserContext userContext, double amount, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAmountOfPayingOff(userContext, amount, exception);
			return;
		}
	 	checkMoneyAmount(amount, 0.00, 5223.88, AMOUNT_OF_PAYING_OFF,exception); 		
	}
	 		
	 			 		
	public static final String  VERSION_OF_PAYING_OFF ="paying_off.version";
	
	protected void checkVersionOfPayingOff(RetailScmUserContext userContext, int version, RetailScmException exception)
	{
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkVersionOfPayingOff(userContext, version, exception);
			return;
		}
	 	checkIntegerRange(version, 0, Integer.MAX_VALUE, VERSION_OF_PAYING_OFF,exception); 		
	}
	 		
	 		
	public void checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof RetailScmUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return;
		}
		RetailScmUserContext userContext = (RetailScmUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return;
		}
		super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(RetailScmUserContext userContext, RetailScmException exception) throws Exception{
		//translate messages;
		if(!exception.hasErrors()){
			return;
		}
		
		
		for(Message message: exception.getErrorMessageList()){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			
		}
		throw exception;
	}
    
}









