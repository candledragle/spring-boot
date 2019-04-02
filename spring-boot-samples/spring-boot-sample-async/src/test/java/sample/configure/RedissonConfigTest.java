package sample.configure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.redisson.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/*
* https://github.com/redisson/redisson/wiki/2.-Configuration#21-programmatically-configuration
* */

@SpringBootTest
class RedissonConfigTest {

	private Log logger = LogFactory.getLog(RedissonConfigTest.class);

	@Resource
	RedissonClient redisson;

	@Test
	void redisson() {

		RBucket<String> key = redisson.getBucket("key");
		key.set("value");

		logger.info("********************");
		logger.info(key.get());
		logger.info("***************");

		//config
		try {
			String json = redisson.getConfig().toJSON();
			logger.warn(json);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//map
		RMap<Object, Object> anyMap = redisson.getMap("anyMap");
		anyMap.put("key", "value");
		anyMap = redisson.getMap("anyMap");
		Object key1 = anyMap.get("key");
		logger.warn("key1 : " + key1);

		//Map 分布式集合
		RMap<String,String> map = redisson.getMap("anyMap");
		map.put("123","123");
		map.putIfAbsent("123","123");

		//set example
		RSet<String> set = redisson.getSet("myset");
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("5");

		/*boolean b = set.contains("1");
		if(b){
			logger.warn("set contain 1");
		}

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()){
			String  next = iterator.next();
			logger.warn("Rset : "+next);
		}

		boolean remove = set.remove("1");
		logger.warn("****************** remove **************");
		for (String str :
				set) {
			logger.warn(str);
		}
		logger.warn("****************** remove **************");

		set.removeAll(Arrays.asList("1","2","3"));

		logger.warn("****************** remove all **************");
		for (String str :
				set) {
			logger.warn(str);
		}
		logger.warn("****************** remove all **************");

		boolean b1 = set.containsAll(Arrays.asList("4", "1", "0"));*/

        String random = set.removeRandom();
        logger.warn("随机：    "+random);
        random = set.random();
        logger.warn("随机：    "+random);

        RSet<String> secondSet = redisson.getSet("mySecondSet");
        secondSet.add("4");
        secondSet.add("5");

        set.union(secondSet.getName());

        //list
        RList<String> list = redisson.getList("myList");
        list.add("1");
        list.add("2");
        list.add("3");

        list.contains("1");

        String valueAtIndex = list.get(3);
        for (String str :
                list) {
            logger.warn(str);
        }

        list.remove("1");
        list.removeAll(Arrays.asList("1","2","3"));
        list.containsAll(Arrays.asList("4","1","0"));

        ArrayList<String> secondList = new ArrayList<>();
        secondList.add("4");
        secondList.add("5");
        list.addAll(secondList);

        list.addAfter("5","6");
        list.addBefore("4","-3");

        list.fastSet(1,"6");
        list.fastRemove(1);

        List<String> allValues = list.readAll();
        for (String s:
             allValues) {
            logger.warn(s);
        }

        //setCache

        RSetCache<String> setCache = redisson.getSetCache("mySet");
        setCache.add("1",20, TimeUnit.SECONDS);

        //bucket
        RBucket<String> bucket = redisson.getBucket("test");
        bucket.set("123");

        bucket = redisson.getBucket("test");
        logger.warn(bucket.get());

        anyMap = redisson.getMap("anyMap");
        anyMap.put("test","123");
        logger.warn(anyMap.get("test"));

    }

	@Test
	void testRedis() {

		Jedis jedis = new Jedis("localhost");
		jedis.flushAll();
		jedis.set("foo", "bar");
		String foo = jedis.get("foo");
		logger.info(foo);

		//hash
		jedis.hset("myhash", "hash_key1", "hash_value1");
		jedis.hset("myhash", "hash_key2", "hash_value2");

		String hash_key1 = jedis.hget("myhash", "hash_key1");
		logger.info("hash_key1 : " + hash_key1);
		String hash_key2 = jedis.hget("myhash", "hash_key2");
		logger.info("hash_key2 : " + hash_key2);

		//list
		jedis.lpush("runoob", "redis");
		jedis.lpush("runoob", "mongodb");
		jedis.lpush("runoob", "rabitmap");

		Long runoob_length = jedis.llen("runoob");

		logger.warn(" the length of runoob is " + runoob_length);

		List<String> runoob_list = jedis.lrange("runoob", 0, runoob_length);
		logger.warn(" the element of runoob is " + runoob_list);

		//set Redis的Set是string类型的无序集合
		jedis.sadd("runoob1", "redis");
		jedis.sadd("runoob1", "mongodb");
		jedis.sadd("runoob1", "rabitmq");
		jedis.sadd("runoob1", "java");
		jedis.sadd("runoob1", "c++");

		runoob_length = jedis.scard("runoob1");
		logger.warn("the length of runoob is " + runoob_length);

		Set<String> smembers = jedis.smembers("runoob1");
		Iterator<String> iterator = smembers.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			logger.warn("set : " + next);
		}

		//zset 有序集合　zadd key score member 　
		/*
		* Redis zset 和 set 一样也是string类型元素的集合,且不允许重复的成员。
		*不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
		*zset的成员是唯一的,但分数(score)却可以重复。
		* */

		jedis.zadd("runobb",0,"java");
		jedis.zadd("runobb",1,"c++");
		jedis.zadd("runobb",0,"c");
		jedis.zadd("runobb",2,"python");

		Set<String> runobb_zset = jedis.zrangeByScore("runobb", 0, 100);
		Iterator<String> iterator_zset = runobb_zset.iterator();
		while (iterator_zset.hasNext()){
			String next = iterator_zset.next();
			logger.warn("zset : "+next);
		}

		//hash 删除
		jedis.hdel("myhash","hash_key1");
		//hash 判断是否存在
		jedis.hexists("myhash","hash_key1");

	}
}