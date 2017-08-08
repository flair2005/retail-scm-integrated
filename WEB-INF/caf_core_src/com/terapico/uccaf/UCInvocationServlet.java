package com.terapico.uccaf;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.terapico.caf.InternalBeanFactory;
import com.terapico.caf.InvocationContext;
import com.terapico.caf.InvocationException;
import com.terapico.caf.InvocationResult;
import com.terapico.caf.InvocationTool;
import com.terapico.caf.SimpleInvocationResult;
import com.terapico.caf.SimpleInvocationServlet;

public class UCInvocationServlet extends SimpleInvocationServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
		super.init();
		replaceBeans();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		replaceBeans();
	}
	
	protected boolean isAccessControledService(InvocationContext context){
		if(!(context instanceof UCInvocationContext)){
			return false;
		}
		Object targetObject = context.getTargetObject();
		if(!(targetObject instanceof AccessControledService)){
			return false;
		}
		//UCInvocationContext uInvocationContext = (UCInvocationContext)context;
		
		
		return true;
		
	}
	
	protected InvocationResult invoke(InvocationContext context) throws ServletException
	{
		
		//check the user context before invoke
		//before any call, check the URL
		
		Object targetObject = context.getTargetObject();
		Object []parameters = context.getParameters();
		if(isAccessControledService(context)){
			AccessControledService targetService = (AccessControledService)targetObject;
			UCInvocationContext ucInvocationContext = (UCInvocationContext)context;
			
			try {
				String methodName = ucInvocationContext.getMethodToCall().getName();
				BaseUserContext baseUserContext = ucInvocationContext.getUserContext();
				targetService.checkAccess(baseUserContext,methodName ,parameters);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				InvocationResult result=new SimpleInvocationResult();
				result.setActualResult(e);			
				//InvocationResult result = super.invoke(context);
				return result;
			}
		}
		
		
		return super.invoke(context);
		
	}
	
	
	public void replaceBeans()
	{
		InternalBeanFactory.replaceFormBuilder(new UCFormBuilder());
		InternalBeanFactory.replaceServletInvocationContextFactory(new UCInvocationContextFactory());
		
	}
	
	
	

}
