package com.terapico.caf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
@SuppressWarnings("rawtypes")
public class ServletResultRenderer {

	public void render(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response,
			InvocationResult result) throws ServletException, IOException {
		
		
		if(this.isRequestForHTML(request)){
			renderHTMLPage(servlet, result, request, response);
			return;
		}
		//Otherwise use JSON as the default return format
		renderJson(result, request, response);
		return;
	
	}
	protected String calcBaseURL(HttpServletRequest request){
		
		

		if(!isBehideProxy(request)){
			String url = request.getRequestURL().toString();
			String uri = request.getRequestURI();
			return url.substring(0, url.length()-uri.length())+request.getContextPath();
		}
		String host = request.getHeader("X-Forwarded-Host");//include hostname and port
		
		return "//"+host+request.getContextPath();
		/*
		 * 	<c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
 
		 * 
		 * */
		
	}
	private boolean isBehideProxy(HttpServletRequest request) {
		
		if(request.getHeader("X-Forwarded-For")!=null){
			return true;
		}
		if(request.getHeader("X-Forwarded-Host")!=null){
			return true;
		}
		if(request.getHeader("X-Forwarded-Server")!=null){
			return true;
		}
		
		return false;
	}
	protected boolean isRequestForJson(HttpServletRequest request) {
		
		return hasHeaderWithValue(request,"Accept","application/json");

	}
	protected boolean isRequestForHTML(HttpServletRequest request) {
		
		return hasHeaderWithValue(request,"Accept","text/html");

	}
	
	protected void assertNotEmptyStringArgument(String methodName, String parameterName, String paramterValue){
		if(paramterValue ==  null){
			throw new IllegalArgumentException("Method '"+methodName+"': parameter: '"+parameterName+"' should not be null.");
		}
		if(paramterValue.isEmpty()){
			throw new IllegalArgumentException("Method '"+methodName+"': parameter: '"+parameterName+"' should not be emptry string.");
		}
	}
	protected boolean hasHeaderWithValue(HttpServletRequest request, String header, String value) {
		final String methodName = "hasHeaderWithValue(HttpServletRequest request, String header, String value)";
		
		
		assertNotEmptyStringArgument(methodName,"header", header);
		assertNotEmptyStringArgument(methodName,"value", value);

		
		String accept = request.getHeader(header);
		if (accept == null) {
			return false;
		}
		if (accept.isEmpty()) {
			return false;
		}
		if (accept.contains(value)) {
			return true;
		}
		return false;

	}
	private ObjectMapper objectMapper = null;
	protected ObjectMapper getObjectMapper(){
		if(objectMapper == null){
			objectMapper = new ObjectMapper();
		}
		return objectMapper;
		
	}
	
	protected void renderJson(InvocationResult result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((result.getActualResult() instanceof Exception)) {
			return;
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.addHeader("X-Class", result.getActualResult().getClass().getName());
		//Gson gson = new Gson();
		ObjectMapper mapper = getObjectMapper();
		// Type t=new TypeToken<weather.WeatherResponse>().getType();
		//response.getWriter().println(gson.toJson(result.getActualResult()));
		//mapper
		/*
		Order order=(Order)OrdreJsonTool.prepareForJson((Order)result.getActualResult());
		
		*/
		
		String json = mapper.writeValueAsString(result.getActualResult());
		response.setContentLength(json.getBytes().length);
		response.getWriter().print(json);
		
		return;

	}

	protected void renderHTMLPage(HttpServlet servlet, InvocationResult result, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.addHeader("Cache-Control", "no-cache, must-revalidate");
		request.setAttribute("result", result.getActualResult());
		request.setAttribute("rootResult", result);
		request.setAttribute("baseURL", this.calcBaseURL(request));
		
		this.dispatchView(servlet, request, response, result);

	}

	protected String joinParametersTypes(Type[] types, char connectChar) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			if (i > 0) {
				stringBuilder.append(connectChar);
			}

			Class clazz = (Class) types[i];
			stringBuilder.append(clazz.getSimpleName());
		}
		return stringBuilder.toString();
	}
	protected void handleArgumentExcepttion(String message)
	{
		throw new IllegalArgumentException(message);
	}
	protected String getGenericResultRenderKey(InvocationResult result) {

		if(result==null){
			handleArgumentExcepttion("getRenderKey(InvocationResult result)： result should not be null.");
		}
		final InvocationContext context=result.getInvocationContext();
		if(context==null){
			handleArgumentExcepttion("getRenderKey(InvocationResult result)： result.getInvocationContext() should not be null.");			
		}
		Method method = context.getMethodToCall();
		
		if(method==null){
			handleArgumentExcepttion("getRenderKey(InvocationResult result)： result.getInvocationContext().getMethodToCall() should not be null.");			
		}
		
		if (!isGenericReturnType(method)) {
			handleArgumentExcepttion("Should not call  getRenderKey() when return type is not a parameterized type.");
		}

		Type type = method.getGenericReturnType();
		
		ParameterizedType parameterReutrnType = (ParameterizedType) type;
		Type[] types = parameterReutrnType.getActualTypeArguments();
		String parameterTypeExpr = joinParametersTypes(types, '_');
		String returnTypeExpr = method.getReturnType().getSimpleName();
		return parameterTypeExpr + "$" + returnTypeExpr;

		// System.out.println(method.getReturnType());

	}

	protected boolean isGenericResult(InvocationResult result) {
		if(result==null){
			return false;
		}
		if(result.getInvocationContext()==null){
			return false;
		}
		if(result.getActualResult()==null){
			return false;
		}
		if(result.getActualResult() instanceof Throwable){
			return false;
		}
		
		
		Method method = result.getInvocationContext().getMethodToCall();
		return isGenericReturnType(method);
	}
	protected boolean isArrayResult(InvocationResult result) {
		if(result==null){
			return false;
		}
		if(result.getInvocationContext()==null){
			return false;
		}
		if(result.getActualResult()==null){
			return false;
		}
		Type type=result.getActualResult().getClass();
		return isArrayType(type);
	}
	protected boolean isArrayType(Type type) {
		
		
		Class typeClazz = (Class) type;
		if (typeClazz.isArray()) {
			return true;
		}
		return false;
	}
	protected boolean isGenericReturnType(Method method) {

		Type type = method.getGenericReturnType();
		if (type instanceof ParameterizedType) {
			return true;
		}

		return false;
	}
	

	protected void dispatchView(HttpServlet servlet, HttpServletRequest request, HttpServletResponse response,
			InvocationResult result) throws ServletException, IOException {
		RequestDispatcher view = getRenderView(servlet, request, result);
		view.include(request, response);

	}

	protected void logInfo(String message) {
		// log.log(Level.INFO, message);
		System.out.println("Render:" + message);
	}

	protected RequestDispatcher getRenderView(HttpServlet servlet, HttpServletRequest request, InvocationResult result)
			throws MalformedURLException {
		if(isGenericResult(result)){
			return request.getRequestDispatcher("/" + getGenericResultRenderKey(result) + ".jsp");
		}
		if(isArrayResult(result)){
			return request.getRequestDispatcher("/" + getArrayResultRenderKey(result) + ".jsp");
		}
		return getSimpleRenderView(servlet, request, result.getActualResult());


	}

	protected String getArrayResultRenderKey(InvocationResult result) {
		if(!isArrayResult(result)){
			throw new IllegalArgumentException("The result should be an array to be processed");
		}
		//The method isArrayResult will check the result, result.getActualResult()
		Class componentType = result.getActualResult().getClass().getComponentType();
		
		
		
		return componentType.getName()+"$Array";
	}

	private Map<Class, String> viewCache = new ConcurrentHashMap<Class, String>();
	
	protected boolean isProduction()
	{
		return "PRODUDCTION".equals(System.getenv("DEPLOYMOD"));
		//return true;
	}
	//Referer:http://localhost:8080/naf/navi/index/decorationCountryCenterManager/
	protected String [] getViewLayers(HttpServletRequest request){
		
		if(1==1){
			return new String[]{"customview","coreview","cafview"};
		}
		if(1==1){
			return new String[]{"coreview","cafview"};
		}
		
		String reqURI = request.getRequestURI();
		String referalURL = request.getHeader("Referer");
		if(reqURI.indexOf("/navi/index/") > 0){///navi/index/
			if(referalURL == null){
				return new String[]{"coreview","cafview"};
			}
			if(referalURL.indexOf("/navi/index/")>0){
				return new String[]{"coreview","cafview"};
			}
			
		}

		
		//
		String ajax = request.getHeader("X-Requested-With");
		
		if(referalURL == null){
			//no refer, it means it is the start page
			return new String[]{"customview","coreview","cafview"};
		}
		if(referalURL.indexOf("/navi/index/")>0&&ajax != null){///navi/index/
			//this is an AJAX load from management console
			return new String[]{"coreview","cafview"};
		}
		return new String[]{"customview","coreview","cafview"};
		
		
	}
	
	protected RequestDispatcher getSimpleRenderView(HttpServlet servlet, HttpServletRequest request, Object object)
			throws MalformedURLException {

		Class temp = object.getClass();
		
		if(isProduction()){
			//如果是生产环境，就使用缓存， 方便调试的时候随时修改视图
			String cachedPage = viewCache.get(temp);
			if (cachedPage != null) {
				logInfo("found cache for " + cachedPage);
				return request.getRequestDispatcher(cachedPage);
			}
		}
		

		//这个代码是根据类信息找到一个合适的渲染视图，如果找不到相应的视图，
		//就从尝试从父类中找到一个视图
		//通过一个循环实现了递归调用，节约了栈空间, 为什么节约了栈空间呢，因为一个多一次层次的调用就会多一次栈分配过程
		ServletContext context = servlet.getServletContext();
		String folderList[] = getViewLayers(request);
		temp = object.getClass();
		while (temp != null) {
			for (String folderName : folderList) {

				String jsp = "/" + folderName + "/" +getFileNameFromClass( temp) + ".jsp";
				// logInfo("trying to find: " + jsp);
				URL url = context.getResource(jsp);
				if (url != null) {
					viewCache.put(temp, jsp);
					logInfo("\tluck to find: " + jsp);
					return request.getRequestDispatcher(jsp);
				}
				logInfo("\ttried to find: " + jsp + ", will try next....");
				
			}
			temp = temp.getSuperclass();
		}
		final String defaultView = "/coreview/java/lang/Object.jsp";
		logInfo("using default view: "+defaultView);
		return request.getRequestDispatcher(defaultView);// should
																		// not
																		// go
																		// here

	}
	protected  String getFileNameFromClass(Class<?> clazz){
		String name = clazz.getName();
		String segs[]=name.split("\\.");
		return join(segs,segs.length,"/");
		
	}
		
	protected  String join(String []array,int end, String joinStr){
		if(end > array.length){
			throw new IllegalArgumentException("end is bigger than length");
			
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i< end; i++){
			if(i>0){
				stringBuilder.append(joinStr);
			}
			stringBuilder.append(array[i]);
		}
		return stringBuilder.toString();
	}

}
