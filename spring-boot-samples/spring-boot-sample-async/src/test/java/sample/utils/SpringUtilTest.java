package sample.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sample.bean.TestBean;

@SpringBootTest
class SpringUtilTest {

	@Autowired
	TestBean testBean;

	@Test
	void getBean() {
		TestBean bean = SpringUtil.getBean(TestBean.class);
		String s = bean.sayHello();
		assert s.equals("Hello World!");
		assert testBean.hashCode() == bean.hashCode();
	}
}