package ShowRoom.showroom.services;

import java.util.List;

import ShowRoom.showroom.hibernate.DAO.BrandsDAO;
import ShowRoom.showroom.model.Brand;

public class BrandService {
	BrandsDAO dao = new BrandsDAO();
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub
		List<Brand> list = dao.getBrands();
		return list;
	}

	public void addBrand(Brand brand) {
		// TODO Auto-generated method stub
		dao.addBrand(brand);
		
	}

	public void updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		dao.updateBrand(brand);
		
	}

	public void deleteBrand(int brandId) {
		// TODO Auto-generated method stub
		dao.deleteBrand(brandId);
	}

	public Brand getBrand(int brandId) {
		
		return dao.getBrand(brandId);
	}
	
}
