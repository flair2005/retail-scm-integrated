package com.skynet.retailscm;

public interface RetailScmUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
}

