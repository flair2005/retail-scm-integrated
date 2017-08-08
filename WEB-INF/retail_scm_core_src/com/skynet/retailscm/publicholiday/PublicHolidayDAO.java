
package com.skynet.retailscm.publicholiday;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface PublicHolidayDAO{

	
	public PublicHoliday load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public PublicHoliday present(PublicHoliday publicHoliday,Map<String,Object> options) throws Exception;
	public PublicHoliday clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PublicHoliday save(PublicHoliday publicHoliday,Map<String,Object> options);
	public SmartList<PublicHoliday> savePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options);
	public SmartList<PublicHoliday> removePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options);
	
	public void delete(String publicHolidayId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countPublicHolidayByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


