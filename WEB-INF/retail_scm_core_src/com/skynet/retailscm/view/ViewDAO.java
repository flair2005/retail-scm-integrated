
package com.skynet.retailscm.view;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ViewDAO{

	
	public View load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public View present(View view,Map<String,Object> options) throws Exception;
	public View clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public View save(View view,Map<String,Object> options);
	public SmartList<View> saveViewList(SmartList<View> viewList,Map<String,Object> options);
	public SmartList<View> removeViewList(SmartList<View> viewList,Map<String,Object> options);
	
	public void delete(String viewId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


