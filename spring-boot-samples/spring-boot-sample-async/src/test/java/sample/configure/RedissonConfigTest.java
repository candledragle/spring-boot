package sample.configure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.redisson.client.codec.StringCodec;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RedissonConfigTest {

	private Log logger = LogFactory.getLog(RedissonConfigTest.class);

	@Resource
	RedissonClient redissonClient;

	@Test
	void redisson() {

		RBucket<String> key = redissonClient.getBucket("key");
		key.set("value");

		logger.info("********************");
		logger.info(key.get());
		logger.info("***************");
	}
}