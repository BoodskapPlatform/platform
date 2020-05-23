package io.boodskap.iot.spi.grid.local;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.spi.grid.IGrid;

@TestMethodOrder(OrderAnnotation.class)
public class AllGridTests {
	
	private static final Logger LOG = LoggerFactory.getLogger(AllGridTests.class);

	private static LocalGridFactory factory;
	private static IGrid grid;

	@BeforeAll
	public static void setup() {
		
		factory = new LocalGridFactory();
		factory.init(new LocalGridConfig());
		grid = factory.getGrid();

	}
	
	@Test
	@Order(1)
	void runTest() {
		
		grid.run(new Runnable() {			
			@Override
			public void run() {
				LOG.info("I ran successfully.");
			}
		});
		
	}
	
	@Test
	@Order(2)
	void callTest() {
		
		Integer result = grid.call(new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				LOG.info("I am returning 101");
				return 101;
			}
		});
		
		assertEquals(101, result);
	}
	
	@Test
	@Order(3)
	void broadcastRunnableTest() {
		
		List<Future<?>> futures = grid.broadcast(new Runnable() {
			@Override
			public void run() {
				LOG.info("I got broadcasted successfully.");
			}
		});
		
		assertEquals(1, futures.size());
		
		futures.forEach(f-> {
			try {
				f.get();
			}catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		});
	}
	
	@Test
	@Order(4)
	void broadcastRunnableExcludeTest() {
		
		List<Future<?>> futures = grid.broadcast(new Runnable() {
			@Override
			public void run() {
				LOG.error("You should not see this!!!");
			}
		}, false);
		
		assertEquals(0, futures.size());
		
	}
	
	@Test
	@Order(5)
	void broadcastCallableTest() {
		
		final long RESULT = System.currentTimeMillis();
		
		List<Future<Long>> result = grid.broadcast(new Callable<Long>() {

			@Override
			public Long call() throws Exception {
				LOG.info(String.format("I am returining %d", RESULT));
				return RESULT;
			}
			
		});
	
		assertEquals(1, result.size());
		
		result.forEach(f-> {
			try {
				assertEquals(RESULT, f.get());
			}catch(Exception ex) {
				throw new RuntimeException(ex);
			}
		});
	}
	
	@Test
	@Order(6)
	void broadcastCallableExcludeTest() {
		
		List<Future<Long>> result = grid.broadcast(new Callable<Long>() {

			@Override
			public Long call() throws Exception {
				LOG.error("You should not see this!!!");
				return -1L;
			}
			
		}, false);
	
		assertEquals(0, result.size());
		
		
	}
	
	@Test
	@Order(7)
	void listTest() {
		
		assertEquals(1, grid.listNodes().size());
	}
	
	@AfterAll
	public static void close() {
		
		factory.dispose();
	}
}
