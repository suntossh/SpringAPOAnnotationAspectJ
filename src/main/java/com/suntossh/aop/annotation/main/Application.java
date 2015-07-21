package com.suntossh.aop.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suntossh.aop.annotation.target.ProgrammarTO;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		ProgrammarTO programmarTOObject = context.getBean("ProgrammarTOBean", ProgrammarTO.class);
		
		programmarTOObject.code();
		
		programmarTOObject.compileBuildAndRunTest();
		
		
		programmarTOObject.refactorCodeAndTestCase();
		
		context.close();
	}
}
