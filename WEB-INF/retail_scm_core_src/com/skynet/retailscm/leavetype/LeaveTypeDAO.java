
package com.skynet.retailscm.leavetype;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface LeaveTypeDAO{

	
	public LeaveType load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public LeaveType present(LeaveType leaveType,Map<String,Object> options) throws Exception;
	public LeaveType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LeaveType save(LeaveType leaveType,Map<String,Object> options);
	public SmartList<LeaveType> saveLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options);
	public SmartList<LeaveType> removeLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options);
	
	public void delete(String leaveTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
 
 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countLeaveTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public SmartList<LeaveType> findLeaveTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 
 }


