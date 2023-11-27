package merchant_product_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import merchant_product_dto.Merchant;

public class MerchantDao {
	EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();

	public Merchant saveMerchant(Merchant m) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(m);
		transaction.begin();
		transaction.commit();
		return m;
	}

	public Merchant updateMerchant(Merchant m) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(m);
		transaction.begin();
		transaction.commit();
		return m;
	}

	public Merchant verifyMerchant(long phone, String password) {
		Query q = manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant verifyMerchant(String email, String password) {
		Query q = manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (Merchant) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean deleteMerchant(int id) {
		Merchant m = manager.find(Merchant.class, id);
		if (m != null) {
			manager.remove(m);
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
