package merchant_product_dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import merchant_product_dto.Merchant;
import merchant_product_dto.Product;

public class ProductDao {
	EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();

	public Product saveProduct(Product p, int merchant_id) {
		Merchant m = manager.find(Merchant.class, merchant_id);
		if (m != null) {
			m.getProducts().add(p);
			p.setMerchant(m);
			EntityTransaction transaction = manager.getTransaction();
			manager.persist(p);
			transaction.begin();
			transaction.commit();
			return p;
		}
		return null;
	}

	public Product updateProduct(Product p, int merchant_id) {
		Merchant m = manager.find(Merchant.class, merchant_id);
		if (m != null) {
			p.setMerchant(m);
			EntityTransaction transaction = manager.getTransaction();
			manager.merge(p);
			transaction.begin();
			transaction.commit();
			return p;
		}
		return null;
	}

	public List<Product> findProductsByMerchantId(int merchant_id) {
		Query q = manager.createQuery("select p from Product p where p.merchant.id=?1");
		q.setParameter(1, merchant_id);
		return q.getResultList();
	}

	public  List<Product> findProductsByBrand(String brand) {
		Query q = manager.createQuery("select p from Product p where p.brand=?1");
		q.setParameter(1, brand);
		return q.getResultList();
	}

	public  List<Product> findProductsByCategory(String category) {
		Query q = manager.createQuery("select p from Product p where p.category=?1");
		q.setParameter(1, category);
		return q.getResultList();
	}

}
