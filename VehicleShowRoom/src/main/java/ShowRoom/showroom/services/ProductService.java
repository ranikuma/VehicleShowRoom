package ShowRoom.showroom.services;

import java.util.ArrayList;
import java.util.List;

import ShowRoom.showroom.hibernate.DAO.ProductDAO;
import ShowRoom.showroom.model.Brand;
import ShowRoom.showroom.model.Product;

public class ProductService {
	ProductDAO DAO = new ProductDAO();
	public List<Product> getProductByBrand(int brandId) {
		List<Product> list = DAO.getProductByBrand(brandId);
		return list;
	}
	public List<Product> getProductByBrand(int brandId, String category) {
		// TODO Auto-generated method stub
		List<Product> list = DAO.getProductsByBrandAndCategory(brandId, category);
		return list;
	}

}
