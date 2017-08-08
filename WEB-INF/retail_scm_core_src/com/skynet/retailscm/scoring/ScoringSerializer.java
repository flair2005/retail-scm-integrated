
package com.skynet.retailscm.scoring;

import java.util.List;
//import java.util.Date; This is optional import for some classes
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.skynet.retailscm.scoring.Scoring;
import com.skynet.retailscm.BaseJsonSerializer;

import com.skynet.retailscm.employeecompanytraining.EmployeeCompanyTraining;


public class ScoringSerializer extends BaseJsonSerializer<Scoring>{

	

	@Override
	public void serialize(Scoring scoring, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		writeStartObject(scoring,jgen,provider);
		
		jgen.writeStringField(Scoring.ID_PROPERTY,scoring.getId());
		jgen.writeStringField(Scoring.SCORED_BY_PROPERTY,scoring.getScoredBy());
		jgen.writeNumberField(Scoring.SCORE_PROPERTY,scoring.getScore());
		jgen.writeStringField(Scoring.COMMENT_PROPERTY,scoring.getComment());
		jgen.writeNumberField(Scoring.VERSION_PROPERTY,scoring.getVersion());
		writeEmployeeCompanyTrainingList(Scoring.EMPLOYEE_COMPANY_TRAINING_LIST,scoring,jgen,provider);
		
		writeEndObject(scoring,jgen,provider);
	}
	
	protected void writeEmployeeCompanyTrainingList(String fieldName, Scoring scoring, JsonGenerator jgen,SerializerProvider provider)throws IOException,
			JsonProcessingException{
		
		List<EmployeeCompanyTraining> employeeCompanyTrainingList = scoring.getEmployeeCompanyTrainingList();
		
		if(employeeCompanyTrainingList == null){
			return;//do nothing when null found for this field.
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return;//do nothing when no elements found for this field.
		}
		jgen.writeFieldName(fieldName);
		jgen.writeStartArray();
		//start an array [
		for(EmployeeCompanyTraining employeeCompanyTraining: employeeCompanyTrainingList){
				
			jgen.writeStartObject();// {
		
			jgen.writeStringField(EmployeeCompanyTraining.ID_PROPERTY,employeeCompanyTraining.getId());
			jgen.writeStringField(EmployeeCompanyTraining.CURRENT_STATUS_PROPERTY,employeeCompanyTraining.getCurrentStatus());
			jgen.writeNumberField(EmployeeCompanyTraining.VERSION_PROPERTY,employeeCompanyTraining.getVersion());	

			jgen.writeEndObject();//}
			
		}
		jgen.writeEndArray();
		//end the array ]
	}
	
}


