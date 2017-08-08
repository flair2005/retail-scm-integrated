
package com.skynet.retailscm.scoring;

import java.util.List;
import java.util.Map;
import com.skynet.retailscm.BaseEntity;
import com.skynet.retailscm.SmartList;

public interface ScoringDAO{

	
	public Scoring load(String id, Map<String,Object> options) throws Exception;
	
	
	
	
	
	public Scoring present(Scoring scoring,Map<String,Object> options) throws Exception;
	public Scoring clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Scoring save(Scoring scoring,Map<String,Object> options);
	public SmartList<Scoring> saveScoringList(SmartList<Scoring> scoringList,Map<String,Object> options);
	public SmartList<Scoring> removeScoringList(SmartList<Scoring> scoringList,Map<String,Object> options);
	
	public void delete(String scoringId, int version) throws Exception;
	public int deleteAll() throws Exception;
}


