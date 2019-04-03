package sample.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sample.bean.TestBean;

@Configuration
public class TestConfigure {


	@Bean
	@Scope("singleton")
	public TestBean testBean(){
		return new TestBean();
	}
}
