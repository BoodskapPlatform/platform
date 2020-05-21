package io.boodskap.iot.spi.cache.local;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.boodskap.iot.spi.cache.ICache;

@TestMethodOrder(OrderAnnotation.class)
class AllCacheTests {

	private static LocalCacheFactory factory;
	private static ICache cache;
	private static Map<String, Map<?, ?>> caches = new HashMap<>();
	
	static void createCache(Class<?> keyClass, Class<?> valueClass, String cacheName) {
		Map<?, ?> c = cache.getCache(keyClass, valueClass, cacheName);
		c.clear();
		//System.out.format("Created cache %s(%s, %s)\n", cacheName, keyClass.getSimpleName(), valueClass.getSimpleName());
		caches.put(cacheName, c);
	}
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		factory = new LocalCacheFactory();
		factory.init(new LocalCacheConfig());
		cache = factory.getCache();
		
		createCache(Byte.class, Byte.class, "bbCache");
		createCache(Short.class, Byte.class, "sbCache");
		createCache(Integer.class, Byte.class, "ibCache");
		createCache(Long.class, Byte.class, "lbCache");
		createCache(Float.class, Byte.class, "fbCache");
		createCache(Double.class, Byte.class, "dbCache");
		createCache(KeyObject.class, Byte.class, "obCache");
		
		createCache(Byte.class, Short.class, "bsCache");
		createCache(Short.class, Short.class, "ssCache");
		createCache(Integer.class, Short.class, "isCache");
		createCache(Long.class, Short.class, "lsCache");
		createCache(Float.class, Short.class, "fsCache");
		createCache(Double.class, Short.class, "dsCache");
		createCache(KeyObject.class, Short.class, "osCache");
		
		createCache(Byte.class, Integer.class, "biCache");
		createCache(Short.class, Integer.class, "siCache");
		createCache(Integer.class, Integer.class, "iiCache");
		createCache(Long.class, Integer.class, "liCache");
		createCache(Float.class, Integer.class, "fiCache");
		createCache(Double.class, Integer.class, "diCache");
		createCache(KeyObject.class, Integer.class, "oiCache");
		
		createCache(Byte.class, Long.class, "blCache");
		createCache(Short.class, Long.class, "slCache");
		createCache(Integer.class, Long.class, "ilCache");
		createCache(Long.class, Long.class, "llCache");
		createCache(Float.class, Long.class, "flCache");
		createCache(Double.class, Long.class, "dlCache");
		createCache(KeyObject.class, Long.class, "olCache");
		
		createCache(Byte.class, Float.class, "bfCache");
		createCache(Short.class, Float.class, "sfCache");
		createCache(Integer.class, Float.class, "ifCache");
		createCache(Long.class, Float.class, "lfCache");
		createCache(Float.class, Float.class, "ffCache");
		createCache(Double.class, Float.class, "dfCache");
		createCache(KeyObject.class, Float.class, "ofCache");
		
		createCache(Byte.class, Double.class, "bdCache");
		createCache(Short.class, Double.class, "sdCache");
		createCache(Integer.class, Double.class, "idCache");
		createCache(Long.class, Double.class, "ldCache");
		createCache(Float.class, Double.class, "fdCache");
		createCache(Double.class, Double.class, "ddCache");
		createCache(KeyObject.class, Double.class, "odCache");
		
		createCache(Byte.class, ValueObject.class, "bvCache");
		createCache(Short.class, ValueObject.class, "svCache");
		createCache(Integer.class, ValueObject.class, "ivCache");
		createCache(Long.class, ValueObject.class, "lvCache");
		createCache(Float.class, ValueObject.class, "fvCache");
		createCache(Double.class, ValueObject.class, "dvCache");
		createCache(KeyObject.class, ValueObject.class, "ovCache");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		factory.dispose();
	}

	@SuppressWarnings("unchecked")
	@Test
	@Order(1)
	void populateCache() {
		
		final Byte bVal = Byte.valueOf((byte)127);
		final Short sVal = Short.valueOf((short)456);
		final Integer iVal = Integer.valueOf(78334);
		final Long lVal = System.currentTimeMillis();
		final Float fVal = 23434.56F;
		final Double dVal = 313333333.098D;
		final KeyObject oVal = new KeyObject(UUID.randomUUID().toString());
		
		((Map<Byte,Byte>)caches.get("bbCache")).put(bVal, Byte.valueOf((byte)12));
		((Map<Byte,Short>)caches.get("bsCache")).put(bVal, Short.valueOf((short)256));
		((Map<Byte,Integer>)caches.get("biCache")).put(bVal, Integer.valueOf(3233));
		((Map<Byte,Long>)caches.get("blCache")).put(bVal, System.nanoTime());
		((Map<Byte,Float>)caches.get("bfCache")).put(bVal, 1004.56F);
		((Map<Byte,Double>)caches.get("bdCache")).put(bVal, 6971201.678D);
		((Map<Byte,ValueObject>)caches.get("bvCache")).put(bVal, new ValueObject(UUID.randomUUID().toString()));
		
		((Map<Short,Byte>)caches.get("sbCache")).put(sVal, Byte.valueOf((byte)12));
		((Map<Short,Short>)caches.get("ssCache")).put(sVal, Short.valueOf((short)256));
		((Map<Short,Integer>)caches.get("siCache")).put(sVal, Integer.valueOf(3233));
		((Map<Short,Long>)caches.get("slCache")).put(sVal, System.nanoTime());
		((Map<Short,Float>)caches.get("sfCache")).put(sVal, 1004.56F);
		((Map<Short,Double>)caches.get("sdCache")).put(sVal, 6971201.678D);
		((Map<Short,ValueObject>)caches.get("svCache")).put(sVal, new ValueObject(UUID.randomUUID().toString()));
		
		((Map<Integer,Byte>)caches.get("ibCache")).put(iVal, Byte.valueOf((byte)12));
		((Map<Integer,Short>)caches.get("isCache")).put(iVal, Short.valueOf((short)256));
		((Map<Integer,Integer>)caches.get("iiCache")).put(iVal, Integer.valueOf(3233));
		((Map<Integer,Long>)caches.get("ilCache")).put(iVal, System.nanoTime());
		((Map<Integer,Float>)caches.get("ifCache")).put(iVal, 1004.56F);
		((Map<Integer,Double>)caches.get("idCache")).put(iVal, 6971201.678D);
		((Map<Integer,ValueObject>)caches.get("ivCache")).put(iVal, new ValueObject(UUID.randomUUID().toString()));
		
		((Map<Long,Byte>)caches.get("lbCache")).put(lVal, Byte.valueOf((byte)12));
		((Map<Long,Short>)caches.get("lsCache")).put(lVal, Short.valueOf((short)256));
		((Map<Long,Integer>)caches.get("liCache")).put(lVal, Integer.valueOf(3233));
		((Map<Long,Long>)caches.get("llCache")).put(lVal, System.nanoTime());
		((Map<Long,Float>)caches.get("lfCache")).put(lVal, 1004.56F);
		((Map<Long,Double>)caches.get("ldCache")).put(lVal, 6971201.678D);
		((Map<Long,ValueObject>)caches.get("lvCache")).put(lVal, new ValueObject(UUID.randomUUID().toString()));
		
		((Map<Float,Byte>)caches.get("fbCache")).put(fVal, Byte.valueOf((byte)12));
		((Map<Float,Short>)caches.get("fsCache")).put(fVal, Short.valueOf((short)256));
		((Map<Float,Integer>)caches.get("fiCache")).put(fVal, Integer.valueOf(3233));
		((Map<Float,Long>)caches.get("flCache")).put(fVal, System.nanoTime());
		((Map<Float,Float>)caches.get("ffCache")).put(fVal, 1004.56F);
		((Map<Float,Double>)caches.get("fdCache")).put(fVal, 6971201.678D);
		((Map<Float,ValueObject>)caches.get("fvCache")).put(fVal, new ValueObject(UUID.randomUUID().toString()));
		
		((Map<Double,Byte>)caches.get("dbCache")).put(dVal, Byte.valueOf((byte)12));
		((Map<Double,Short>)caches.get("dsCache")).put(dVal, Short.valueOf((short)256));
		((Map<Double,Integer>)caches.get("diCache")).put(dVal, Integer.valueOf(3233));
		((Map<Double,Long>)caches.get("dlCache")).put(dVal, System.nanoTime());
		((Map<Double,Float>)caches.get("dfCache")).put(dVal, 1004.56F);
		((Map<Double,Double>)caches.get("ddCache")).put(dVal, 6971201.678D);
		((Map<Double,ValueObject>)caches.get("dvCache")).put(dVal, new ValueObject(UUID.randomUUID().toString()));
		
		((Map<KeyObject,Byte>)caches.get("obCache")).put(oVal, Byte.valueOf((byte)12));
		((Map<KeyObject,Short>)caches.get("osCache")).put(oVal, Short.valueOf((short)256));
		((Map<KeyObject,Integer>)caches.get("oiCache")).put(oVal, Integer.valueOf(3233));
		((Map<KeyObject,Long>)caches.get("olCache")).put(oVal, System.nanoTime());
		((Map<KeyObject,Float>)caches.get("ofCache")).put(oVal, 1004.56F);
		((Map<KeyObject,Double>)caches.get("odCache")).put(oVal, 6971201.678D);
		((Map<KeyObject,ValueObject>)caches.get("ovCache")).put(oVal, new ValueObject(UUID.randomUUID().toString()));
		
	}

	@Test
	@Order(2)
	void sizeCache() {
		caches.forEach((c,m) -> {
			assertEquals(1, m.size());
		});
	}

	@Test
	@Order(3)
	void clearCache() {
		caches.forEach((c,m) -> {
			m.clear();
		});
	}

	@Test
	@Order(4)
	void checkCache() {
		caches.forEach((c,m) -> {
			assertEquals(0, m.size());
		});
	}

}
