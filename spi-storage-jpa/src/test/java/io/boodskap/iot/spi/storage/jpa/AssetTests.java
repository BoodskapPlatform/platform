package io.boodskap.iot.spi.storage.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.boodskap.iot.dao.AssetDAO;
import io.boodskap.iot.model.IAsset;

public class AssetTests extends BaseTest {

	@Test
	@Order(1)
	void populateAssets() {
		
		{
			IAsset a = IAsset.create(DOMAIN_KEY, "Test Asset");
			a.setDescription("JUnit test asset1");
			a.setName("Test Asset Name1");
			a.save();
		}
		
		{
			IAsset a = IAsset.create(DOMAIN_KEY, "Test Asset2");
			a.setDescription("JUnit test asset2");
			a.setName("Test Asset Name2");
			a.save();
		}
		
		{
			IAsset a = IAsset.create(DOMAIN_KEY, "Test Asset3");
			a.setDescription("JUnit test asset3");
			a.setName("Test Asset Name3");
			a.save();
		}
		
		{
			IAsset a = IAsset.create(DOMAIN_KEY+"@", "Test Asset");
			a.setDescription("JUnit test asset @1");
			a.setName("Test Asset Name @1");
			a.save();
		}
	}
	
	@Test
	@Order(2)
	void countAll() {
		assertEquals(4, AssetDAO.get().count());
	}
	@Test
	@Order(3)
	void count() {
		assertEquals(3, AssetDAO.get().count(DOMAIN_KEY));
	}
	@Test
	@Order(4)
	void get() {
		assertNotNull(AssetDAO.get().get(DOMAIN_KEY, "Test Asset"));
	}
	@Test
	@Order(5)
	void list() {
		assertEquals(2, AssetDAO.get().list(DOMAIN_KEY, 0, 2).size());
		assertEquals(1, AssetDAO.get().list(DOMAIN_KEY, 1, 2).size());
		assertEquals(0, AssetDAO.get().list(DOMAIN_KEY, 2, 2).size());
	}
	@Test
	@Order(6)
	void loadAll() {
		assertTrue(AssetDAO.get().load().hasNext());
	}
	
	@Test
	@Order(7)
	void load() {
		assertTrue(AssetDAO.get().load(DOMAIN_KEY).hasNext());
	}
	
	@Test
	@Order(8)
	void search() {
		
		Collection<IAsset> list = AssetDAO.get().search(DOMAIN_KEY, "lower(v.name) like 'test%'", 10);
		assertEquals(3, list.size());
		
		list = AssetDAO.get().search(DOMAIN_KEY, "lower(v.name) like '%2'", 10);
		assertEquals(1, list.size());
		
		list = AssetDAO.get().search(DOMAIN_KEY, "lower(v.name) like '%asse%'", 10);
		assertEquals(3, list.size());
	}
	
	@Test
	@Order(9)
	void deleteAsset() {
		AssetDAO.get().delete(DOMAIN_KEY, "Test Asset");
	}
	
	@Test
	@Order(10)
	void delete() {
		AssetDAO.get().delete(DOMAIN_KEY);
	}
	
	@Test
	@Order(11)
	void deleteAll() {
		AssetDAO.get().delete();
	}
}
