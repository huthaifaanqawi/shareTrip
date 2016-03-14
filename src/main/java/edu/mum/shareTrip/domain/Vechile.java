package edu.mum.shareTrip.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
 @Entity
public class Vechile {

   @Id
	int id;
	@NotEmpty
	String vechileName;
	@NotEmpty(message="edu.mum.domain.vechile.type")
	String type;
	int seatNumber;
	double pricePerDay;
	private MultipartFile  productImage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVechileName() {
		return vechileName;
	}
	public void setVechileName(String vechileName) {
		this.vechileName = vechileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public MultipartFile getProductImage() {
		return productImage;
	}
	@XmlTransient
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
}
