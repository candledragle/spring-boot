package sample.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
* https://www.cnblogs.com/liaojie970/p/8043150.html
* */

@Component
@ConfigurationProperties(prefix = "spring.adapter.redisson")
public class TestConfigurationProperties {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
