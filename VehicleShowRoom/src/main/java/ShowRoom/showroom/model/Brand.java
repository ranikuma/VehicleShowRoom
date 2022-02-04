package ShowRoom.showroom.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Entity;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@javax.persistence.Entity(name="showroom") 
@javax.persistence.Table(name="showroom")
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="brandId")
	int brandId;
	@Column(name="brandName")
	String brandName;
	
	@Transient
	private List<Link> links;
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public List<Link> getLink() {
		return links;
	}

	public void setLink(List<Link> links) {
		this.links = links;
	}

	public int getBrandId() {
		return brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "BrandEntity [brandId=" + brandId + ", brandName=" + brandName + "]";
	}
	
}
