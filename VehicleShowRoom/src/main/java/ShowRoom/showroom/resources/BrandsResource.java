package ShowRoom.showroom.resources;

import java.io.ObjectInputFilter.Status;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.LineBorder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ShowRoom.showroom.model.Brand;
import ShowRoom.showroom.model.Link;
import ShowRoom.showroom.model.Product;
import ShowRoom.showroom.services.BrandService;

@Path("/showroom/Brands")
public class BrandsResource {
	BrandService brandService = new BrandService();
  	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands() {
		List<Brand> list = brandService.getBrands();
		return list;
	}
	
  	@GET
  	@Produces(MediaType.APPLICATION_JSON)
  	@Path("{brandId}")
  	public Brand getBrand(@PathParam("brandId") int brandId, @Context UriInfo uri) {
  		Link self = new Link(uri.getAbsolutePath().toString(), "self");
 // 		Link products = new Link(uri.getAbsolutePathBuilder().path("products").build().toString(), "products");
  		String productsUri = uri.getBaseUriBuilder()
  								.path(ProductsResource.class)
  								.path(ProductsResource.class, "getProductByBrand")
  								.resolveTemplate("brandId", brandId).toString();
  		Link products = new Link(productsUri, "products");
  		Brand brand = brandService.getBrand(brandId);
  		List<Link> links = new ArrayList<Link>();
  		links.add(self);
  		links.add(products);
  		brand.setLink(links);
//  		brand.setLink(link);
  		return brand;
  	}
	
	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBrands(Brand brand, @Context UriInfo uri) {
		System.out.println(brand);
		brandService.addBrand(brand);
/*		String URL = uri.getAbsolutePath().toString()+brand.getBrandId();
		URI location = URI.create(URL);*/
		URI location = uri.getAbsolutePathBuilder().path(Integer.toString(brand.getBrandId())).build();
		return Response.created(location).entity(brand).build();
						//status(javax.ws.rs.core.Response.Status.CREATED).entity(brand).build();
	}
	
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void putBrands(@javax.ws.rs.PathParam("brandId") int brandId, Brand updatedBrand) {
		updatedBrand.setBrandId(brandId);
		brandService.updateBrand(updatedBrand);
	}
	
	
	@DELETE
	@Path("/{brandId}")
	public void deleteBrands(@javax.ws.rs.PathParam("brandId") int brandId) {
		brandService.deleteBrand(brandId);
	}
	
/*	@Path("/{brandId}/products")
	public ProductsResource productDelegation() {
		return new ProductsResource();
	}*/

}
