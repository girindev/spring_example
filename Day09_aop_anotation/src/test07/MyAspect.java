package test07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution (String doSomething(int))")
	public void myPoint() {};
	
	@Before("myPoint()")
	public void myBefore(JoinPoint joinPoint) {
		Object[] params = joinPoint.getArgs();
		int n = (Integer)params[0];
		System.out.println("미리 받은 숫자 : "+n);
		System.out.println("배가 고프다.");
	}
	@AfterReturning(value="myPoint()" , returning="result")
	public void afterReturning(Object result) {
		System.out.println("음식을 먹는다 냠냠");
		System.out.println("핵심사항 결과:" + result);
	}
	@AfterThrowing(value = "myPoint()", throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("핵심관심사항 도중 에러났내");
		System.out.println("");
	}
	@After("myPoint()")
	public void myAfter() {
		System.out.println("설거지 해야지");
	}
}
