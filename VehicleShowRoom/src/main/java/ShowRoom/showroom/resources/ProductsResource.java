package ShowRoom.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ShowRoom.showroom.model.Product;
import ShowRoom.showroom.services.ProductService;

@Path("/showroom/Brands")
public class ProductsResource {
	ProductService productService = new ProductService();
	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductByBrand(@javax.ws.rs.PathParam("brandId") int brandId
											, @QueryParam("category") String category, @QueryParam("start") int start
											, @QueryParam("size") int size) {
		List<Product> list;
		if(category != null) {
			list = productService.getProductByBrand(brandId, category);
		}else {
			list = productService.getProductByBrand(brandId);
		}
		if(size > 0) {
			list = list.subList(start, size);
		}
		return list;
	}
	
}
