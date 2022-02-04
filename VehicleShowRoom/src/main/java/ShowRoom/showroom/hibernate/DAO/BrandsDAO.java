package ShowRoom.showroom.hibernate.DAO;

import java.util.List;

import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import ShowRoom.showroom.model.Brand;

public class BrandsDAO {
	org.hibernate.SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Brand.class)
							.buildSessionFactory();	
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub
		org.hibernate.Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Brand> list = session.createQuery("from showroom").getResultList();
		return list;
	}

	public void addBrand(Brand brand) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		//Every time we modify the table in database we need to commit
		session.getTransaction().commit();
		
	}

	public void updateBrand(Brand updatedBrand) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = factory.getCurrentSession();
		session.beginTransaction();
		int id = updatedBrand.getBrandId();
		Brand brand = session.get(Brand.class, id);
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) {
		// TODO Auto-generated method stub
		org.hibernate.Session session = factory.getCurrentSession();
		session.beginTransaction();
		Brand brand = session.get(Brand.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();		
	}

	public Brand getBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Brand brand = session.get(Brand.class, brandId);
		return brand;
		
	}

}
