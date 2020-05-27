package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingTemplateDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingTemplate;
import io.boodskap.iot.model.jpa.BillingTemplate;
import io.boodskap.iot.model.jpa.BillingTemplateId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class BillingTemplateDAOImpl implements BillingTemplateDAO<BillingTemplate> {

	private static final BillingTemplateDAO<BillingTemplate> instance = new BillingTemplateDAOImpl();

	protected BillingTemplateDAOImpl() {
	}
	
	public static final BillingTemplateDAO<BillingTemplate> get() {
		return instance;
	}

	@Override
	public Class<? extends BillingTemplate> clazz() {
		return BillingTemplate.class;
	}

	@Override
	public IBillingTemplate create(String templatename, String itemname) {
		return new BillingTemplate(new BillingTemplateId(templatename, itemname));
	}

	@Override
	public void createOrUpdate(BillingTemplate e) throws StorageException {
		
		try {
			
			final IBillingTemplate oe = get(e.getTemplatename(), e.getItemname());
			IBillingTemplate ne;
			
			if(null == oe) {
				ne = new BillingTemplate(new BillingTemplateId(e.getTemplatename(), e.getItemname()));
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setDescription(e.getDescription());
			ne.setTax(e.getTax());
			ne.setTemplatecode(e.getTemplatecode());
			ne.setUnitprice(e.getUnitprice());
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
		
	}

	@Override
	public EntityIterator<BillingTemplate> load() throws StorageException {
		try {
			return new EntityIteratorImpl<>(BillingTemplate.class, "id.templatename");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<BillingTemplate> load(String templatename) throws StorageException {
		try {
			return new EntityIteratorImpl<>(BillingTemplate.class, "templatename", templatename, "id.itemname");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(BillingTemplate.class).count();
	}

	@Override
	public long count(String templatename) throws StorageException {
		return new CommonDAO<>(BillingTemplate.class).count("id.templatename", templatename);
	}

	@Override
	public BillingTemplate get(String templatename, String itemname) throws StorageException {
		return new CommonDAO<>(BillingTemplate.class).find(new BillingTemplateId(templatename, itemname));
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(BillingTemplate.class).delete();
	}

	@Override
	public void delete(String templatename) throws StorageException {
		new CommonDAO<>(BillingTemplate.class).delete("id.templatename", templatename);
	}

	@Override
	public void delete(String templatename, String itemname) throws StorageException {
		new CommonDAO<>(BillingTemplate.class).delete("id.templatename", templatename, "id.itemname", itemname);
	}

	@Override
	public Collection<BillingTemplate> list(int page, int pageSize) throws StorageException {
		return new CommonDAO<>(BillingTemplate.class).list(page, pageSize, "id.templatename");
	}

	@Override
	public Collection<BillingTemplate> listNext(String templatename, String itemname, int page, int pageSize) throws StorageException {
		return list(page, pageSize);
	}

	@Override
	public Collection<BillingTemplate> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(BillingTemplate.class).search(query, pageSize);
	}

}
