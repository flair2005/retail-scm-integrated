package com.terapico.uccaf;

import java.lang.reflect.Type;

import com.terapico.caf.FormBuilder;

public class UCFormBuilder extends FormBuilder {
	/*
	 * 
	 * 当第一参数是BaseUserType的时候，自动忽略该参数
	 * */
	@Override
	protected boolean isToAddToFormField(int index, Type type, String name) {
		if(true){
			//throw new IllegalStateException("called to here!");
		}
		if(index > 0){
			return super.isToAddToFormField(index, type, name);
		}
		if(UCTypeTool.isBaseUCType(type)){
			return false;
		}
		return true;
		
	}
	
}
