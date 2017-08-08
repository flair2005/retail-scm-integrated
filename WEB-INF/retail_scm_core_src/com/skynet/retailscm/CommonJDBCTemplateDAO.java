package com.skynet.retailscm;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public abstract class CommonJDBCTemplateDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	//this can be more object, to allow more data source configured for reading
	private int maxRows = 1000;
	public int getMaxRows() {
		return maxRows;
	}

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}
	//Having following methods to allow easier logging, performance optimization
	//The data can be read from read only databases with slave-master arch
	
	protected int[] batchUpdate(String sql, List<Object[]>args)
	{
		if(args.isEmpty()){
			return new int[0];
		}
		logSQLAndParamList("batchUpdate",sql,args);
		return getJdbcTemplateObject().batchUpdate(sql, args);
	}
	protected int update(String sql)
	{
		//return getJdbcTemplateObject().batchUpdate(sql, args);
		logSQLAndParameters("update",sql,new Object[]{});
		return getJdbcTemplateObject().update(sql);
	}
	protected int update(String sql,Object [] parameters)
	{
		
		logSQLAndParameters("update",sql,parameters);
		//return getJdbcTemplateObject().batchUpdate(sql, args);
		return getJdbcTemplateObject().update(sql,parameters);
	}
	protected<T> T queryForObject(String sql,Object [] parameters,RowMapper<T> mapper)
	{
		//return getJdbcTemplateObject().batchUpdate(sql, args);
		logSQLAndParameters("queryForObject",sql,parameters);
		return getJdbcTemplateObject().queryForObject(sql,parameters,mapper);
	}
	
	protected void logSQLAndParameters(String method, String sql,Object [] parameters){
		
		System.out.println(method+" excuting: "+ sql);
		
		for(int i=0;i<parameters.length;i++){
			logDebug("\t\tp["+i+"]:\t"+parameters[i]);
		}
	}
	protected void logDebug(String message){
		System.out.println(message);
	}
	protected void logSQLAndParamList(String method, String sql,List<Object[]>args){
		System.out.println(method+"batch excuting: "+ sql);
		
		int counter = 0;
		for(Object[] parameters: args){
			logDebug("---------------------------------line: "+counter+"-------------------------------------------------");
			
			for(int i=0;i<parameters.length;i++){
				logDebug("\tline["+counter+"]\tp["+i+"]:\t"+parameters[i]);
			}
			counter++;
		}
	}
	
	protected<T> T queryForObject(String sql,Class<T> clazz, Object [] parameters)
	{
		//return getJdbcTemplateObject().batchUpdate(sql, args);
		logSQLAndParameters("queryForObject",sql,parameters);
		return getJdbcTemplateObject().queryForObject(sql,clazz,parameters);
	}
	//List<Order> orderList = getJdbcTemplateObject().query(SQL, new Object[]{confirmationId}, getMapper());
	
	protected <T  extends BaseEntity> SmartList<T> queryForList(String sql,Object [] parameters,RowMapper<T> mapper)
	{
		//return getJdbcTemplateObject().batchUpdate(sql, args);
		logSQLAndParameters("queryForList",sql,parameters);
		//return getJdbcTemplateObject().query(sql,parameters,mapper);
		List<T> originList = getJdbcTemplateObject().query(sql,parameters,mapper);
		SmartList<T> smartList = new SmartList<T>();
		smartList.addAll(originList);
		return smartList;
		
		
	}
	protected Integer queryInt(String sql,Object [] parameters)
	{
		//return getJdbcTemplateObject().batchUpdate(sql, args);
		logSQLAndParameters("queryInt",sql,parameters);
		//return getJdbcTemplateObject().query(sql,parameters,mapper);
		
		return getJdbcTemplateObject().queryForObject (sql,parameters,Integer.class);
		
	}
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);

		jdbcTemplateObject.setFetchSize(1000);
		jdbcTemplateObject.setMaxRows(getMaxRows());
		jdbcTemplateObject.setQueryTimeout(10);
	}
	static boolean inCloseCharRang(char test, char start, char end) {
		if (test < start) {
			return false;
		}
		if (test > end) {
			return false;
		}
		return true;
	}
	static Object[] parse(String maxId) {
		
		if(maxId==null){
			return new Object[]{"USER",1L};
		}
		
		Object ret[] = new Object[2];
		StringBuilder prefixBuffer = new StringBuilder();
		StringBuilder numberBuffer = new StringBuilder();

		char[] chs = maxId.toCharArray();
		for (char ch : chs) {
			
			if(inCloseCharRang(ch,'A','Z')){
				prefixBuffer.append(ch);
				continue;
			}
			if(inCloseCharRang(ch,'a','z')){
				prefixBuffer.append(ch);
				continue;
			}
			if(inCloseCharRang(ch,'0','9')){
				numberBuffer.append(ch);
				continue;
			}

		}
		ret[0] = prefixBuffer.toString();
		String numberExpr=numberBuffer.toString();
		if(numberExpr.isEmpty()){
			ret[1] = 0L;
			return ret;
		}
		
		ret[1] = Long.parseLong(numberExpr);
		return ret;

	}
	
	//static final String ID_FORMAT="USER%06d"; 
	
	//There is an issue when runing this code under cluster environment
	//Since other instance running the same code and keep conflicting each other
	//When running under a cluster environment, we need a global unique id to ensure 
	//The id will not be repeated
	
	private Long currentMax=-1L;
	protected String getNextId()
	{
		synchronized(currentMax){
			if(currentMax > 0){

				return String.format(getIdFormat(),++currentMax);
			}
			//The following logic just run when the first time loaded the id from table
			try {
				String SQL = "select max(id) from "+getName()+"_data";
				String maxId = getJdbcTemplateObject().queryForObject(SQL, String.class);
				if(maxId==null){
					return  String.format(getIdFormat(),1);
				}
				
				Object ret[]=parse(maxId);
				currentMax = (Long)ret[1]+1;
				return String.format(getIdFormat(),currentMax);
				
			} catch (EmptyResultDataAccessException e) {
				return  String.format(getIdFormat(),1);
			}
		}
		
	}
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	
	public static String getShortName(String name) {
		String ar[] = name.split("_");
		String ret = ar[0].substring(0, 1).toUpperCase();

		for (int i = 1; i < ar.length; i++) {
			ret +=ar[i].substring(0, 1).toUpperCase();
				
		}
		return ret;
	}
	protected String getIdColumnName()
	{
		return "id";
	}
	
	protected String getVersionColumnName()
	{
		return "version";
	}
	abstract protected String[] getNormalColumnNames();
	
	abstract protected String getName();
	protected String getTableName(){
		return this.getName()+"_data";
	}
	protected String getCreateSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("insert into ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append("(id,");
		stringBuilder.append(join());
		stringBuilder.append(",version)values(?,");
		stringBuilder.append(getCreateParametersPlaceHolders());
		stringBuilder.append(",1);");
		
		return stringBuilder.toString();

		
	}
	
	protected String getDeleteSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("delete from  ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append(" where id= ? and version =?;");
			
		return stringBuilder.toString();
		
	}

	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("update ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append(" set ");
		stringBuilder.append(joinUpdate());
		stringBuilder.append(",version = version+1 ");
		
		stringBuilder.append("where id=? and version=?");
		
		return stringBuilder.toString();
		
	}
	
	protected String getDeleteWithVerionSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("delete from ");
		stringBuilder.append(this.getTableName());
		
		
		stringBuilder.append(" where id=? and version=?");
		
		return stringBuilder.toString();
		
	}
	
	
	
	protected String getCreateParametersPlaceHolders() {

		StringBuilder stringBuilder=new StringBuilder();
		int length=getNormalColumnNames().length;
		for(int i=0;i<length;i++ ){//version is an constant
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return stringBuilder.toString();
	}
	
	
	
	protected String getUpdateParametersPlaceHolders() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int length=getNormalColumnNames().length;
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return null;
	}

	protected String joinUpdateParametersPlaceHolders() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int length=getNormalColumnNames().length;
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return stringBuilder.toString();
	}
	
	
	
	
	protected String joinPlaceHolders(String []parameters) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int length=parameters.length;
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return stringBuilder.toString();
	}
	
	protected String join() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		String columNames[]=getNormalColumnNames();
		int length=columNames.length;
		
		for(int i=0; i<length; i++){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append(columNames[i]);
		}
		
		return stringBuilder.toString();
	}
	protected String joinUpdate() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		String columNames[]=getNormalColumnNames();
		int length=columNames.length;
		
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append(columNames[i]+" = ? ");
		}
		
		return stringBuilder.toString();
	}
	
	protected String getDeleteAllSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("delete from  ");
		stringBuilder.append(this.getTableName());
		
			
		return stringBuilder.toString();
		
	}
	
	public<T extends BaseEntity> SmartList<T> removeList(SmartList<T> entityList, Map<String, Object> options) {
		
		//if(true) throw new IllegalStateException("removeList-----");
		//System.out.println("removeList-----");
		batchDelete(entityList);
		return entityList;
	}
	
	protected<T extends BaseEntity> void batchDelete(List<T> entityList){
		
		if(entityList.isEmpty()){
			return;
		}
		
		String SQL=getDeleteWithVerionSQL();
		List<Object[]> args=prepareBatchDeleteArgs(entityList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
				
		
	}
	
	protected<T extends BaseEntity> List<Object[]> prepareBatchDeleteArgs(List<T> entityList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(T acceleraterAccount:entityList ){
			Object [] parameters = prepareDeleteEntityParameters(acceleraterAccount);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected<T extends BaseEntity> Object[] prepareDeleteEntityParameters(T acceleraterAccount){
 		Object[] parameters = new Object[2];		
 		parameters[0] = acceleraterAccount.getId();
 		parameters[1] = acceleraterAccount.getVersion();
 				
 		return parameters;
 	}
	
	protected int calcToIndex(int totalLoadSize, int currentPage, int rowsPerPage){
		int lastIndex = currentPage*rowsPerPage;
		if( lastIndex> totalLoadSize){
			return totalLoadSize;
		}
		return lastIndex;
		
	}
		
	protected boolean isCurrentPageInLoadedList(int totalLoadSize, int currentPage, int rowsPerPage){
		
		if(currentPage*rowsPerPage <= totalLoadSize){//is this really needed????????
			return true;
		}
		
		if(totalLoadSize < this.getMaxRows()){
			//full loaded
			return true;
		}
		
		
		return false;
	}
	protected int rowsPerPageOf(String objectName,Map<String,Object> options){
		//first get the value from options
		//acceleratorAccountList
		String object =(String) options.get(objectName + "ListRowsPerPage");
		try{
			int rowsPerPage = Integer.parseInt(object);
			if(rowsPerPage > 1000) {
				return 1000;//prevent large rows
			}
			return rowsPerPage;
		}catch(Exception e){
			return 20;
		}
		
		
		
		
	}
	
	protected int currentPageNumberOf(String objectName,Map<String,Object> options) {
		//first get the value from options
		//acceleratorAccountList
		String object =(String) options.get(objectName + "ListCurrentPage");
		try{
			int rowsPerPage = Integer.parseInt(object);
			return rowsPerPage;
		}catch(Exception e){
			
			return 1;
			//throw e;
		}

		
	}
	
	protected List<BaseEntity> pagesOf(int loadedTotalSize ,int currentPage){

		List<BaseEntity> pages = new Pagination(loadedTotalSize).render(currentPage);
		return pages;

	}
	
	protected Object [] joinArrays(Object [] arr1, Object[] arr2){
 		Object [] objs = new Object[arr1.length+arr2.length];
 		int index = 0;
 		for(Object obj:arr1){
 			objs[index++] = obj;
 		}
 		for(Object obj:arr2){
 			objs[index++] = obj;
 		}
 		return objs;
 		
 	}
	
	
	
	protected void assertMethodArgumentNotNull(Object object, String method, String parameterName){
		if(object == null){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud NOT be null");
		}
	}
	protected void assertMethodIntArgumentGreaterThan(int value, int targetValue,String method, String parameterName){
		if(value <= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud greater than " + targetValue +" but it is: "+ value);
		}
	}
	protected void assertMethodIntArgumentLessThan(int value, int targetValue,String method, String parameterName){
		if(value >= targetValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud less than " + targetValue +" but it is: "+ value);
		}
	}
	
	protected void assertMethodIntArgumentInClosedRange(int value, int startValue, int endValue, String method, String parameterName){
		
		if(startValue>endValue){
			throw new IllegalArgumentException("When calling the check method, please note your parameter, endValue < startValue");
		}
	
		if(value < startValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
		if(value > endValue){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' shoud be in closed range: ["+startValue+","+endValue+"] but it is: "+value);
		}
	}
	protected void assertMethodStringArgumentLengthInClosedRange(String value, int lengthMin, int lengthMax, String method, String parameterName){
		
		if(lengthMin < 0){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin should not less than 0");
		}
		
		if(lengthMin > lengthMax){
			throw new IllegalArgumentException("The method assertMethodStringArgumentLengthInClosedRange lengMin less or equal lengthMax");
		}
		
		if(value == null){		
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is null");
		}
		if(value.length() < lengthMin){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
		if(value.length() > lengthMax){
			throw new IllegalArgumentException("Method:" + method +": parameter '"+parameterName+"' length shoud be in closed range: ["+lengthMin+","+lengthMax+"] but it is: "+value.length());
		}
	}

}






