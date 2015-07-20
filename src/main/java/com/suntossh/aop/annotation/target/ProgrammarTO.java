package com.suntossh.aop.annotation.target;

public class ProgrammarTO {

	private String categories;

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}
	
	public void code(){
		System.out.println("Programmar has finished Coding");
	}
	
	public void compileBuildAndRunTest(){
		System.out.println("Programmar has compiled build and ran his unit test cases");
	}
	
	public void refactorCodeAndTestCase(){
		System.out.println("Programmar has refactoring his code constantly");
	}
	
}
