package com.suntossh.aop.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.suntossh.aop.annotation.target.ProgrammarTO;

@Aspect
public class AdminTrack {

	
	@Before("execution(void com.suntossh.aop.annotation.target.ProgrammarTO.*(..))")                      // Actual before Advise which is executed, mapping as name matched above mtd
	public void logBeforeMethod(JoinPoint joinPoint){
		System.out.println("AOP logBeforeMethod is invoked before executing "+joinPoint.getSignature()+" will execute");
	}
	
	@AfterReturning("execution(* com.suntossh.aop.annotation.target.ProgrammarTO.*(..))")                        // Actual After Advise which is executed, mapping as name matched above mtd
	public void mailAfterMethod(JoinPoint joinPoint){
		System.out.println("AOP mailAfterMethod is invoked after executing "+joinPoint.getSignature()+" has finished executing");
	}
	
	
	@Around("execution(* com.suntossh.aop.annotation.target.ProgrammarTO.refactorCodeAndTestCase(..))")
	public Object canProccedWithRefectoring(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		ProgrammarTO programmarTO = (ProgrammarTO)proceedingJoinPoint.getTarget();
		if(programmarTO.getCategories().equalsIgnoreCase("TL")){
			System.out.println("TL is welcome to modify");
			return proceedingJoinPoint.proceed();
		}else{
			System.out.println("Only TL Can modify , so backoff, pointcut will not be executed");
			return null;
		}
	}
	
	//@AfterThrowing(pointcut="", throwing="ex")
	
}
