package foodorder_DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import foodorder_DTO.FoodOrder;
import foodorder_DTO.User;

public class FoodOrderDao {

	EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
	EntityTransaction t = manager.getTransaction();

	public FoodOrder savefoodorder(FoodOrder fo, int user_id) {
		User u = manager.find(User.class, user_id);
		if (u != null) {
			fo.setUsers(u);
			manager.persist(fo);
			t.begin();
			t.commit();
			return fo;
		}
		return null;
	}

	public FoodOrder updateFoodOrder(FoodOrder fo, int user_id) {
		User u = manager.find(User.class, user_id);
		if (u != null) {
			FoodOrder temporder = manager.find(FoodOrder.class, fo.getId());
			
			manager.merge(fo);
			t.begin();
			t.commit();
			return fo;
		}
		return null;
	}

	public List<FoodOrder> FindfoodorderbyuserID(int user_id) {
		Query q = manager.createQuery("select f from FoodOrder f where f.users.id=?1");
		q.setParameter(1, user_id);
		return q.getResultList();
	}

	public boolean deletefoodorder(FoodOrder fo,int user_id) {
		User f = manager.find(User.class, user_id);
		if (f != null) {
			FoodOrder foo=manager.find(FoodOrder.class, user_id);
			manager.remove(fo);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}
}
