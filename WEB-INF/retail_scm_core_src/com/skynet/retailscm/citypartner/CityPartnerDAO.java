
package com.skynet.retailscm.citypartner;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface CityPartnerDAO{

	
	public CityPartner load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public CityPartner present(CityPartner cityPartner,Map<String,Object> options) throws Exception;
	public CityPartner clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CityPartner save(CityPartner cityPartner,Map<String,Object> options);
	public SmartList<CityPartner> saveCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options);
	public SmartList<CityPartner> removeCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options);
	
	public void delete(String cityPartnerId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 
 }


