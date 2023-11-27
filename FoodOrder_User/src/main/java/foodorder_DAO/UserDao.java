package foodorder_DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import foodorder_DTO.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();

	public User saveUser(User u) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(u);
		transaction.begin();
		transaction.commit();
		return u;
	}

	public User UpdateUser(User u) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(u);
		transaction.begin();
		transaction.commit();
		return u;

	}

	public User findUser(int id) {

		return manager.find(User.class, id);

	}

	public User verifyUser(long phone, String psswd) {
		Query q = manager.createQuery("select u from User u where u.phone=?1 and u.password=?2 ");
		q.setParameter(1, phone);
		q.setParameter(2, psswd);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(String email, String psswd) {
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2 ");
		q.setParameter(1, email);
		q.setParameter(2, psswd);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean deleteUser(int id) {

		User m = manager.find(User.class, id);
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
