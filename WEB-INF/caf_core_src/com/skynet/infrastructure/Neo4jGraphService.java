package com.skynet.infrastructure;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Relationship;

public class Neo4jGraphService extends InfraBaseService implements GraphService{
	Driver driver ;
	public Neo4jGraphService() {
		driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic("neo4j", "neo4j?") );
		
	}
	
	public List<String[]> relationsOf(String fromLabel, String fromId,
			String toLable, String toId) {
		final String realtionVar = "relation";
		
		StatementResult result = runCheckQuery(fromLabel,fromId,toLable,toId,realtionVar);
		
		//ticker.tick("query");
		
		List<String[]> relationList = new ArrayList<String[]>();
		
		while ( result.hasNext() )
		{
		    Record record = result.next();
		    
		    Value value = record.get( realtionVar);
		    
		    List<Object> relations = value.asList();
		    if(relations.size()<=0){
		    	continue;
		    }
		    String [] relationArray = new String[relations.size()];
		    int index = 0;
		    for(Object object: relations){
		    	
		    	if(object instanceof Relationship){
		    		Relationship relationShip =  (Relationship) object;
		    		relationArray[index] =relationShip.type();
		    		index++;
		    	}

		    }
		    relationList.add(relationArray);
		   
		    //some thing like ["R", "R", "R", "R", "R", "R"]
		}
		
		//System.out.println();
		
		
		return relationList;
	}
	
	protected void checkType(String type)
	{
		

		//the first char must be alphabets
		String trimedType = type.trim();
		if(trimedType.isEmpty()){
			throw new IllegalArgumentException("protected void checkType(String type): type is not allowed to be empty after trimed");
		}
		char firstChar = trimedType.charAt(0);//safe here, empty is checked;
		if(!Character.isLetter(firstChar)){
			throw new IllegalArgumentException("protected void checkType(String type): first char '"+firstChar+"' must be alphabets");
		}
		
		for(char ch: type.toCharArray()){
			if(Character.isDigit(ch)){
				continue;
			}
			if(Character.isLetter(ch)){
				continue;
			}
			throw new IllegalArgumentException("Character '"+ch+"' in " + type + " is not allowed to be other character except letter and digit");
			
		}
	}
	protected StatementResult runCheckQuery(String startType, String startId, String endType, String endId, String relationVar)
	{
		
		checkType(startType);
		checkType(endType);
		
		final String query = "MATCH (:"+startType+" {id:{startId}})-["+relationVar+"*..10]->(:"+endType+" {id:{endId}}) "
				+"return "+relationVar+"";
		
		System.out.println(query);
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("startId", startId);
		parameters.put("endId", endId);
		Session session = driver.session();
		return session.run( query,parameters);
	}
	
	public  static void main(String []args) throws ClassNotFoundException, SQLException{
		
		Neo4jGraphService service = new Neo4jGraphService();
		
		List<String[]> relationList = service.relationsOf("TaskViolation","TV000001","DecorationCountryCenter","DCC000002");
		
		for(String [] strArray: relationList){
			for(String ele: strArray){
				System.out.print(ele+", ");
			}
			System.out.println();
		}
		
	}
}
