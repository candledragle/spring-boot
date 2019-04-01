package sample.configure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestConfigurationPropertiesTest {

	private Log logger = LogFactory.getLog(TestConfigurationPropertiesTest.class);

	@Resource
	TestConfigurationProperties testConfigurationProperties;

	@Test
	void getAddress() {

		String address = testConfigurationProperties.getAddress();
		logger.info(address);
	}
}