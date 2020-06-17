package io.boodskap.iot.spi.storage.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.boodskap.iot.model.IUser;

public class UserTests extends BaseTest {

	@Test
	@Order(1)
	void populate() {
	
		{
			IUser e = IUser.create(DOMAIN_KEY, "admin");
			e.setAdmin();
			e.setPassword("admin");
			e.setFirstName("Domain");
			e.setLastName("Administrator");
			e.save();
		}
	}

	@Test
	@Order(2)
	void countAll() {
		assertEquals(1, IUser.count());
	}
	
	@Test
	@Order(3)
	void count() {
		assertEquals(1, IUser.count(DOMAIN_KEY));
	}
	
	@Test
	@Order(4)
	void get() {
		assertNotNull(IUser.get("admin"));
	}
	
	@Test
	@Order(5)
	void list() {
		assertEquals(1, IUser.list(DOMAIN_KEY, 0, 2).size());
	}
	
	@Test
	@Order(6)
	void loadAll() {
		assertTrue(IUser.load().hasNext());
	}
	
	@Test
	@Order(7)
	void load() {
		assertTrue(IUser.load(DOMAIN_KEY).hasNext());
	}
	
	@Test
	@Order(8)
	void search() {
		
		Collection<IUser> list = IUser.search(DOMAIN_KEY, "lower(v.firstName) like 'dom%'", 10);
		assertEquals(1, list.size());
		
	}
	
	@Test
	@Order(9)
	void deleteOne() {
		IUser.delete(DOMAIN_KEY, "admin");
	}
	
	@Test
	@Order(10)
	void deleteDomains() {
		IUser.delete(DOMAIN_KEY);
	}
	
	@Test
	@Order(11)
	void deleteAll() {
		IUser.delete();
	}
}
