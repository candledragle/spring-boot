package sample.aop.service;


import org.springframework.stereotype.Component;
import sample.aop.annotation.RequestMonitor;

@Component
public class Test {

	@RequestMonitor
	public void sayHello(){
		System.out.println("hello world!");
	}
}
