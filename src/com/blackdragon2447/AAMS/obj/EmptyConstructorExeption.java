package com.blackdragon2447.AAMS.obj;

public class EmptyConstructorExeption extends Exception{

	private static final long serialVersionUID = 967838652164620067L;

	public EmptyConstructorExeption(){}
	
	public EmptyConstructorExeption(String str){
		super(str);
	}
}
