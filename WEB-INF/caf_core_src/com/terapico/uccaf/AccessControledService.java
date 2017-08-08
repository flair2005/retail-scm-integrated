package com.terapico.uccaf;

public interface AccessControledService {
	public void checkAccess(BaseUserContext userContext,String methodName, Object[] parameters) throws Exception;
}
