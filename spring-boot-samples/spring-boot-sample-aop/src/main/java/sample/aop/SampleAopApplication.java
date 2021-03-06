/*
 * Copyright 2012-2018 the original author or authors.
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

package sample.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sample.aop.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sample.aop.service.Test;
import sample.aop.test.CglibProxy;
import sample.aop.test.SayHello;

import javax.annotation.Resource;

@SpringBootApplication
public class SampleAopApplication implements CommandLineRunner {

	// Simple example shows how an application can spy on itself with AOP

	@Autowired
	private HelloWorldService helloWorldService;

	@Resource
	Test test;

	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getHelloMessage(null));
//		test = new Test();
		test.sayHello();


	}

	public static void main(String[] args) {
		SpringApplication.run(SampleAopApplication.class, args);
	}

}
