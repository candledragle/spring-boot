package sample.configure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sample.bean.TestBean;

import javax.annotation.Resource;

@SpringBootTest
class TestConfigureTest {

	private Log loger = LogFactory.getLog(TestConfigureTest.class);

	@Resource
	TestBean testBean;

	@Test
	void testBean() {

		String s = testBean.sayHello();
		loger.info(s);
	}

	@Test
	void springAware(){

	}
}