package io.boodskap.iot.spi.cache.local;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.boodskap.iot.spi.cache.ICache;

@TestMethodOrder(OrderAnnotation.class)
class AllQueueTests {

	private static LocalCacheFactory factory;
	private static ICache cache;
	private static Map<String, BlockingQueue<?>> queues = new HashMap<>();
	
	static void createQueue(Class<?> valueClass, String queueName) {
		BlockingQueue<?> q = cache.createOrGetQueue(valueClass, queueName);
		q.clear();
		queues.put(queueName, q);
	}
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		factory = new LocalCacheFactory();
		factory.init(new LocalCacheConfig());
		cache = factory.getCache();
		
		createQueue(Byte.class, "bQ");
		createQueue(Short.class, "sQ");
		createQueue(Integer.class, "iQ");
		createQueue(Long.class, "lQ");
		createQueue(Float.class, "fQ");
		createQueue(Double.class, "dQ");
		createQueue(Double[].class, "daQ");
		createQueue(String.class, "stQ");
		createQueue(Date.class, "dtQ");
		createQueue(byte[].class, "baQ");
		createQueue(ValueObject.class, "oQ");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		factory.dispose();
	}

	@SuppressWarnings("unchecked")
	@Test
	@Order(1)
	void produceValues() {
		
		for(int i=0;i<Byte.MAX_VALUE;i++) {
			((BlockingQueue<Byte>)queues.get("bQ")).offer((byte)i);
			((BlockingQueue<Short>)queues.get("sQ")).offer((short)i);
			((BlockingQueue<Integer>)queues.get("iQ")).offer(i);
			((BlockingQueue<Long>)queues.get("lQ")).offer((long)i);
			((BlockingQueue<Float>)queues.get("fQ")).offer((float)i);
			((BlockingQueue<Double>)queues.get("dQ")).offer((double)i);
			((BlockingQueue<Double[]>)queues.get("daQ")).offer(new Double[] {Double.MIN_VALUE, Double.MAX_VALUE});
			((BlockingQueue<String>)queues.get("stQ")).offer(UUID.randomUUID().toString());
			((BlockingQueue<Date>)queues.get("dtQ")).offer(new Date());
			((BlockingQueue<byte[]>)queues.get("baQ")).offer(UUID.randomUUID().toString().getBytes());
			((BlockingQueue<ValueObject>)queues.get("oQ")).offer(new ValueObject(UUID.randomUUID().toString()));
		}
	}
	
	@Test
	@Order(2)
	void consumeValues() {
		drain(queues.get("bQ"));
		drain(queues.get("sQ"));
		drain(queues.get("iQ"));
		drain(queues.get("lQ"));
		drain(queues.get("fQ"));
		drain(queues.get("dQ"));
		drain(queues.get("daQ"));
		drain(queues.get("oQ"));
		drain(queues.get("stQ"));
		drain(queues.get("dtQ"));
		drain(queues.get("baQ"));
	}

	@Test
	@Order(3)
	void checkEmpty() {
		assertEquals(0, queues.get("bQ").size());
		assertEquals(0, queues.get("sQ").size());
		assertEquals(0, queues.get("iQ").size());
		assertEquals(0, queues.get("lQ").size());
		assertEquals(0, queues.get("fQ").size());
		assertEquals(0, queues.get("dQ").size());
		assertEquals(0, queues.get("daQ").size());
		assertEquals(0, queues.get("oQ").size());
		assertEquals(0, queues.get("stQ").size());
		assertEquals(0, queues.get("dtQ").size());
		assertEquals(0, queues.get("baQ").size());
	}

	void drain(BlockingQueue<?> q) {
		
		try {
			
			while(true) {
				
				Object val = q.poll(100, TimeUnit.MILLISECONDS);
				
				if(null == val) {
					break;
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
