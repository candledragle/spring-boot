package sample.bean;

import org.springframework.stereotype.Component;

@Component(value = "testBean1")
public class TestBean1 {

	public String sayHello(){
		return "TestBean1 Hello World!";
	}
}
