package sample.bean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sample.utils.SpringUtil;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestBean1Test {

	@Test
	void sayHello() {

		TestBean1 testBean1 = (TestBean1) SpringUtil.getBean("testBean1");
		String s = testBean1.sayHello();
		assertEquals(s,"TestBean1 Hello World!");

	}
}