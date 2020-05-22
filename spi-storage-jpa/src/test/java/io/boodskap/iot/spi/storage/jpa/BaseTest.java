package io.boodskap.iot.spi.storage.jpa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.IConfig;
import io.boodskap.iot.spi.storage.IDynamicStorageFactory;
import io.boodskap.iot.spi.storage.IRawStorageFactory;
import io.boodskap.iot.spi.storage.IStorageFactory;
import io.boodskap.iot.spi.storage.jpa.config.HSQLDBConfig;
import io.boodskap.iot.spi.storage.policy.PolicyManager;

@TestMethodOrder(OrderAnnotation.class)
public abstract class BaseTest {
	
	protected static final String DOMAIN_KEY = "JUNITDOMKEY";
	protected static final String API_KEY = "JUNITAPIKEY";
	
	protected static IStorageFactory sf;
	protected static IDynamicStorageFactory dsf;
	protected static IRawStorageFactory rsf;
	
	protected BaseTest() {
	}

	@BeforeAll
	public static void openStorage() {
		
		try {
			
			PolicyManager.setEnabled(false);
			
			IConfig cfg = new HSQLDBConfig();
			
			sf = new JPAStorageFactory();
			sf.init(cfg);
			
			dsf = new JPADynamicStorageFactory();
			dsf.init(cfg);
			
			rsf = new JPARawStorageFactory();
			rsf.init(cfg);
			
			BoodskapSystem.get().setStorageManager(sf);
			BoodskapSystem.get().setDynamicStorageManager(dsf);
			BoodskapSystem.get().setRawStorageManager(rsf);
			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
	
	@AfterAll
	public static void closeStorage() {
		
		try {
			
			if(null != sf) sf.dispose();
			if(null != dsf) dsf.dispose();
			if(null != rsf) rsf.dispose();
			
		}catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		
	}
}
