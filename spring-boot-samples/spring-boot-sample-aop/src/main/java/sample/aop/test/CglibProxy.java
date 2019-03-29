package sample.aop.test;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		Object proceed = methodInvocation.proceed();
		System.out.println("method "+methodInvocation.getMethod()+" returns "+proceed);

		return proceed;
	}
}
