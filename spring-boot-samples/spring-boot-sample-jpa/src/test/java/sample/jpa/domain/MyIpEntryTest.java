package sample.jpa.domain;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyIpEntryTest {


	@Test
	void test(){
		String json = "{\"ip\":\"3.89.224.204\",\"country\":\"US\",\"asn\":{\"asnum\":14618,\"org_name\":\"Amazon.com, Inc.\"},\"geo\":{\"city\":\"Ashburn\",\"region\":\"VA\",\"postal_code\":\"20149\",\"latitude\":39.0481,\"longitude\":-77.4728,\"tz\":\"America/New_York\"}}";
		MyIpEntry myIpEntry = (MyIpEntry) JSON.parseObject(json,MyIpEntry.class);
		String city = myIpEntry.getGeo().getCity();
		System.out.println(city);
	}
}