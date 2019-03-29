/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

	/*@AfterReturning("execution(* sample..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}*/

	/*@Pointcut("execution(public void sample.aop.service.Test.sayHello())")
	public void logServiceAccess() {
		System.out.println("Pointcut: " );
	}

	@Before("logServiceAccess()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println(" I,m from TestAop doBefore *******************************");
	}

	@AfterReturning(returning = "ret", pointcut = "logServiceAccess()")
	public void doAfterReturning(Object ret) {
		System.out.println(" I,m from TestAop doAfterReturning *******************************");
	}*/

	@Around("@annotation(sample.aop.annotation.RequestMonitor)")
	public Object monitor(ProceedingJoinPoint joinPoint) {

		try {
			System.out.println("************ before **************");
			Object result = joinPoint.proceed();
			System.out.println("************ after ***************");
			return result;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return null;
	}



}
