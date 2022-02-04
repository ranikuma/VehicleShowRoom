package ShowRoom.showroom.hibernate.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;

import ShowRoom.showroom.model.Brand;
import ShowRoom.showroom.model.Product;

public class ProductDAO {
	SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Product.class)
								.addAnnotatedClass(Brand.class)
								.buildSessionFactory();

	public List<Product> getProductByBrand(int brandId) {
		org.hibernate.Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Product> list;
		String hql= "from products where brandId = '"+brandId+"'";
		list = session.createQuery(hql).getResultList();
		return list;
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Product> list;
		String hql = "from products where brandId='"+brandId+"'and category='"+category+"'";
		list = session.createQuery(hql).getResultList();
		return list;
	}
	
	
}
